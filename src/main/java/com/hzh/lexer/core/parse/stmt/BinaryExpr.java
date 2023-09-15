package com.hzh.lexer.core.parse.stmt;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.ast.leaf.ASTLeaf;
import com.hzh.lexer.core.ast.list.ASTList;

import java.util.List;

/**
 * @ClassName BinaryExpr
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 16:46
 * @Version 0.0.1
 **/
public class BinaryExpr extends ASTList {
    public BinaryExpr(List<ASTree> children) {
        super(children);
    }

    public ASTree left() {
        return child(0);
    }

    public String operator() {
        return ((ASTLeaf) child(1)).token().getText();
    }

    public ASTree right() {
        return child(2);
    }
}
