package com.hzh.lexer.core.env;

import java.util.HashMap;

/**
 * @ClassName BasicEnv
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/15 15:04
 * @Version 0.0.1
 **/
public class BasicEnv implements Environment {

    protected HashMap<String, Object> values;

    public BasicEnv() {
        this.values = new HashMap<>();
    }

    @Override
    public void put(String name, Object value) {
        values.put(name, value);
    }

    @Override
    public Object get(String name) {
        return values.get(name);
    }
}
