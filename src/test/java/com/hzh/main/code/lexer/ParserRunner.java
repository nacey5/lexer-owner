package com.hzh.main.code.lexer;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.lexer.Lexer;
import com.hzh.lexer.core.parse.BasicParser;
import com.hzh.lexer.core.token.Token;
import com.hzh.lexer.excpetion.ParseException;
import com.hzh.main.code.CodeDialog;

/**
 * @ClassName ParserRunner
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 14:51
 * @Version 0.0.1
 **/
public class ParserRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        BasicParser bp = new BasicParser();
        while (l.peek(0) != Token.EOF) {
            ASTree ast = bp.parse(l);
            System.out.println("=>" + ast.toString());
        }
    }
}
