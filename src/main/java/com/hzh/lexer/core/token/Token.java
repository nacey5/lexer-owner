package com.hzh.lexer.core.token;

import com.hzh.lexer.excpetion.runtime.StoneException;

/**
 * @ClassName Token
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 12:58
 * @Version 0.0.1
 * 词法
 **/
public abstract class Token {
    public static final Token EOF = new Token(-1) {
    }; // end of file
    public static final String EOL = "\\n"; // end of line
    private int lineNumber;

    protected Token(int line) {
        lineNumber = line;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public boolean isIdentifier() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public int getNumber() {
        throw new StoneException("not number token");
    }

    public String getText() {
        return "";
    }

}
