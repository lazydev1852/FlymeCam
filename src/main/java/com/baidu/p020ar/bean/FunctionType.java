package com.baidu.p020ar.bean;

import com.baidu.p020ar.arplay.core.ARPScriptEnvironment;

/* renamed from: com.baidu.ar.bean.FunctionType */
public enum FunctionType {
    NONE("none"),
    VIDEO("video"),
    IMU(ARPScriptEnvironment.KEY_DATA_PIP_IMU);
    
    private final String mValue;

    private FunctionType(String str) {
        this.mValue = str;
    }

    public static FunctionType getValueOf(String str) {
        if (str == null) {
            return NONE;
        }
        for (FunctionType functionType : values()) {
            if (functionType.getValue().equalsIgnoreCase(str)) {
                return functionType;
            }
        }
        return NONE;
    }

    public String getValue() {
        return this.mValue;
    }
}
