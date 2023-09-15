package com.hzh.lexer.core.token;

/**
 * @ClassName NumToken
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 12:58
 * @Version 0.0.1
 **/
public class StrToken extends Token {
    private String literal;

    public StrToken(int line, String str) {
        super(line);
        literal = str;
    }

    public boolean isString() {
        return true;
    }

    public String getText(){
        return literal;
    }
}
