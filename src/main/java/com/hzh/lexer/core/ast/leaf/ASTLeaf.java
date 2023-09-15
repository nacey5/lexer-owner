package com.hzh.lexer.core.ast;

import com.hzh.lexer.core.token.Token;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName ASTLeaf
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 16:34
 * @Version 0.0.1
 **/
public class ASTLeaf extends ASTree {

    private static ArrayList<ASTree> empty = new ArrayList<>();

    protected Token token;

    public ASTLeaf(Token token) {
        this.token = token;
    }

    @Override
    public ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public Iterator<ASTree> children() {
        return empty.iterator();
    }

    @Override
    public String location() {
        return "at line " + token.getLineNumber();
    }

    public Token token() {
        return token;
    }
}
