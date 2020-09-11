package com.alibaba.fastjson.support.spring;

public class MappingFastJsonValue {
    private String jsonpFunction;
    private Object value;

    public MappingFastJsonValue(Object obj) {
        this.value = obj;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public Object getValue() {
        return this.value;
    }

    public void setJsonpFunction(String str) {
        this.jsonpFunction = str;
    }

    public String getJsonpFunction() {
        return this.jsonpFunction;
    }
}
