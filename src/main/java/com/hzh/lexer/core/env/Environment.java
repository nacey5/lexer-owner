package com.hzh.lexer.core.env;

/**
 * @ClassName Environment
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 15:02
 * @Version 0.0.1
 **/
public interface Environment {
    void put(String name,Object value);
    Object get(String name);
}
