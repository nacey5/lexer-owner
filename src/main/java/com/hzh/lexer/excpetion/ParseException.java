package com.hzh.lexer.excpetion;

import com.hzh.lexer.core.token.Token;

import java.io.IOException;

/**
 * @ClassName ParseException
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 12:57
 * @Version 0.0.1
 * 解析异常类
 **/
public class ParseException extends Exception {
    public ParseException(Token t) {
        this("", t);
    }

    public ParseException(String msg, Token t) {
        super("syntax error around " + location(t) + ". " + msg);
    }

    private static String location(Token t) {
        if (t == Token.EOF)
            return "the last line";
        else
            return "\"" + t.getText() + "\" at line " + t.getLineNumber();
    }

    public ParseException(IOException e) {
        super(e);
    }

    public ParseException(String msg) {
        super(msg);
    }
}
