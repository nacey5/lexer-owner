package com.hzh.lexer.core.token;

/**
 * @ClassName NumToken
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 12:58
 * @Version 0.0.1
 **/
public class NumToken extends Token {
    private int value;

    public NumToken(int line, int v) {
        super(line);
        value = v;
    }

    public boolean isNumber() {
        return true;
    }

    public String getText() {
        return Integer.toString(value);
    }

    public int getNumber() {
        return value;
    }

}
