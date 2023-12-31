package com.hzh.lexer.core.ast.leaf;

import com.hzh.lexer.core.token.Token;

/**
 * @ClassName Name
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 16:43
 * @Version 0.0.1
 **/
public class Name extends ASTLeaf {
    public Name(Token token) {
        super(token);
    }

    public String name() {
        return token.getText();
    }
}
