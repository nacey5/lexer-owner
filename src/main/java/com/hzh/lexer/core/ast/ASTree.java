package com.hzh.lexer.core.ast;

import java.util.Iterator;

/**
 * @ClassName ASTree
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 14:02
 * @Version 0.0.1
 **/
public abstract class ASTree {

    public abstract ASTree child(int i);

    public abstract int numChildren();

    public abstract Iterator<ASTree> children();

    public abstract String location();

    public Iterator<ASTree> iterator() {
        return children();
    }
}
