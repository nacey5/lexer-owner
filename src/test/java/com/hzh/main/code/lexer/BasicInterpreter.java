package com.hzh.main.code.lexer;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.env.BasicEnv;
import com.hzh.lexer.core.env.Environment;
import com.hzh.lexer.core.evaluator.BasicEvaluator;
import com.hzh.lexer.core.lexer.Lexer;
import com.hzh.lexer.core.parse.BasicParser;
import com.hzh.lexer.core.parse.stmt.NullStmnt;
import com.hzh.lexer.core.token.Token;
import com.hzh.lexer.excpetion.ParseException;
import com.hzh.main.code.CodeDialog;

/**
 * @ClassName BasicInterpreter
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 15:38
 * @Version 0.0.1
 **/
public class BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new BasicParser(), new BasicEnv());
    }
    public static void run(BasicParser bp, Environment env)
            throws ParseException
    {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTree t = bp.parse(lexer);
            if (!(t instanceof NullStmnt)) {
                Object r = ((BasicEvaluator.ASTreeEx)t).eval(env);
                System.out.println("=> " + r);
            }
        }
    }
}
