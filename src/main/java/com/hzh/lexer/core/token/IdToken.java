package com.hzh.lexer.core.token;

/**
 * @ClassName NumToken
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 12:58
 * @Version 0.0.1
 **/
public class IdToken extends Token {
    private String text;

    public IdToken(int line, String id) {
        super(line);
        text = id;
    }

    public boolean isIdentifier() {
        return true;
    }


    public String getText(){
        return text;
    }

}
