package com.hzh.lexer.core.ast.leaf;

import com.hzh.lexer.core.token.Token;

/**
 * @ClassName NumberLiteral
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 16:42
 * @Version 0.0.1
 **/
public class NumberLiteral extends ASTLeaf {
    public NumberLiteral(Token token) {
        super(token);
    }
    public int value(){
        return token.getLineNumber();
    }
}
