package com.hzh.lexer.core.parse.stmt;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.ast.list.ASTList;

import java.util.List;

/**
 * @ClassName NegativeExpr
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 14:31
 * @Version 0.0.1
 **/
public class NegativeExpr extends ASTList {
    public NegativeExpr(List<ASTree> children) {
        super(children);
    }

    public ASTree operand() {
        return child(0);
    }

    @Override
    public String toString() {
        return "-" + operand();
    }
}
