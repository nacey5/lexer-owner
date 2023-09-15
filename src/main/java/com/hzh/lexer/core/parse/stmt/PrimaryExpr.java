package com.hzh.lexer.core.parse.stmt;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.ast.list.ASTList;

import java.util.List;

/**
 * @ClassName PrimaryExpr
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 14:30
 * @Version 0.0.1
 **/
public class PrimaryExpr extends ASTList {

    public PrimaryExpr(List<ASTree> children) {
        super(children);
    }

    public static ASTree create(List<ASTree> c){
        return c.size()==1?c.get(0):new PrimaryExpr(c);
    }
}
