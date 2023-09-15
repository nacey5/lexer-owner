package com.hzh.lexer.excpetion.runtime;

import com.hzh.lexer.core.ast.ASTree;

/**
 * @ClassName StoneException
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 12:57
 * @Version 0.0.1
 * 运行异常
 **/
public class StoneException extends RuntimeException {
    public StoneException(String m) {
        super(m);
    }

    public StoneException(String m, ASTree t) {
        super(m+" "+t.location());
    }

}
