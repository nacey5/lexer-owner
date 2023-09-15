package com.hzh.lexer.core.ast;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ASTList
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 16:36
 * @Version 0.0.1
 **/
public class ASTList extends ASTree {
    protected List<ASTree> children;

    public ASTList(List<ASTree> children) {
        this.children = children;
    }

    @Override
    public ASTree child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public Iterator<ASTree> children() {
        return children.iterator();
    }

    @Override
    public String location() {
        for (ASTree t : children) {
            String s = t.location();
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        String sep = "";
        for (ASTree t: children) {
            builder.append(sep);
            sep = " ";
            builder.append(t.toString());
        }
        return builder.append(')').toString();
    }
}
