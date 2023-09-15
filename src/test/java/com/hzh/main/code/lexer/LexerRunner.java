package com.hzh.main.code.lexer;

import com.hzh.lexer.core.lexer.Lexer;
import com.hzh.lexer.core.token.Token;
import com.hzh.lexer.excpetion.ParseException;
import com.hzh.main.code.CodeDialog;

/**
 * @ClassName LexerRrunner
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 14:10
 * @Version 0.0.1
 **/
public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog()) ;
        for (Token t; (t = l.read()) != Token.EOF; )
            System.out.println("=> " + t.getText());
    }
}
