package com.hzh.lexer.core.parse;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.ast.leaf.Name;
import com.hzh.lexer.core.ast.leaf.NumberLiteral;
import com.hzh.lexer.core.ast.leaf.StringLiteral;
import com.hzh.lexer.core.parse.stmt.BinaryExpr;
import com.hzh.lexer.core.lexer.Lexer;
import com.hzh.lexer.core.parse.stmt.*;
import com.hzh.lexer.core.token.Token;
import com.hzh.lexer.excpetion.ParseException;

import java.util.HashSet;

import static com.hzh.lexer.core.parse.Parser.rule;

/**
 * @ClassName BasicParser
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 18:18
 * @Version 0.0.1
 **/
public class BasicParser {
    HashSet<String> reserved = new HashSet<String>();
    Parser.Operators operators = new Parser.Operators();
    Parser expr0 = rule();
    Parser primary = rule(PrimaryExpr.class)
            .or(rule().sep("(").ast(expr0).sep(")"),
                    rule().number(NumberLiteral.class),
                    rule().identifier(Name.class, reserved),
                    rule().string(StringLiteral.class));
    Parser factor = rule().or(rule(NegativeExpr.class).sep("-").ast(primary),
            primary);
    Parser expr = expr0.expression(BinaryExpr.class, factor, operators);

    Parser statement0 = rule();
    Parser block = rule(BlockStmnt.class)
            .sep("{").option(statement0)
            .repeat(rule().sep(";", Token.EOL).option(statement0))
            .sep("}");
    Parser simple = rule(PrimaryExpr.class).ast(expr);
    Parser statement = statement0.or(
            rule(IfStmnt.class).sep("if").ast(expr).ast(block)
                    .option(rule().sep("else").ast(block)),
            rule(WhileStmnt.class).sep("while").ast(expr).ast(block),
            simple);

    Parser program = rule().or(statement, rule(NullStmnt.class))
            .sep(";", Token.EOL);

    public BasicParser() {
        reserved.add(";");
        reserved.add("}");
        reserved.add(Token.EOL);

        operators.add("=", 1, Parser.Operators.RIGHT);
        operators.add("==", 2, Parser.Operators.LEFT);
        operators.add(">", 2, Parser.Operators.LEFT);
        operators.add("<", 2, Parser.Operators.LEFT);
        operators.add("+", 3, Parser.Operators.LEFT);
        operators.add("-", 3, Parser.Operators.LEFT);
        operators.add("*", 4, Parser.Operators.LEFT);
        operators.add("/", 4, Parser.Operators.LEFT);
        operators.add("%", 4, Parser.Operators.LEFT);
    }

    public ASTree parse(Lexer lexer) throws ParseException {
        return program.parse(lexer);
    }
}