package com.hzh.lexer.core.parse.stmt;

import com.hzh.lexer.core.ast.ASTree;
import com.hzh.lexer.core.ast.list.ASTList;

import java.util.List;

/**
 * @ClassName BlockStmnt
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 14:41
 * @Version 0.0.1
 **/
public class BlockStmnt extends ASTList {
    public BlockStmnt(List<ASTree> children) {
        super(children);
    }
}
