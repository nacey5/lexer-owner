package com.hzh.lexer.core.ast.leaf;

import com.hzh.lexer.core.ast.leaf.ASTLeaf;
import com.hzh.lexer.core.token.Token;

/**
 * @ClassName StringLiteral
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 14:39
 * @Version 0.0.1
 **/
public class StringLiteral extends ASTLeaf {
    public StringLiteral(Token token) {
        super(token);
    }

    public String value(){
        return token.getText();
    }
}
