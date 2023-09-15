package com.hzh.lexer.core.parse.stmt;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.ast.list.ASTList;

import java.util.List;

/**
 * @ClassName WhileStmnt
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 14:37
 * @Version 0.0.1
 **/
public class WhileStmnt extends ASTList {
    public WhileStmnt(List<ASTree> children) {
        super(children);
    }

    public ASTree condition() {
        return child(0);
    }

    public ASTree body() {
        return child(1);
    }

    public String toString() {
        return "(while " + condition() + " " + body() + ")";
    }
}
