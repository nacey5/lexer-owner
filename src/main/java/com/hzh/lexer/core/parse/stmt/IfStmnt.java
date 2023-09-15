package com.hzh.lexer.core.parse.stmt;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.ast.list.ASTList;

import java.util.List;

/**
 * @ClassName IfStmnt
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 14:32
 * @Version 0.0.1
 **/
public class IfStmnt extends ASTList {
    public IfStmnt(List<ASTree> children) {
        super(children);
    }

    public ASTree condition() {
        return child(0);
    }

    public ASTree thenBlock() {
        return child(1);
    }

    public ASTree elseBlock() {
        return numChildren() > 2 ? child(2) : null;
    }

    @Override
    public String toString() {
        return "(if" + condition() + " " + thenBlock() + " else" + elseBlock() + ")";
    }
}
