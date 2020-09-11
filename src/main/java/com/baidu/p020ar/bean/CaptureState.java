package com.baidu.p020ar.bean;

/* renamed from: com.baidu.ar.bean.CaptureState */
public enum CaptureState {
    NONE("none"),
    PICTURE("picture"),
    VIDEO_UNSTART("video_unstart"),
    VIDEO_CAPTURING("video_capturing");
    
    private final String mValue;

    private CaptureState(String str) {
        this.mValue = str;
    }

    public static CaptureState getValueOf(String str) {
        if (str == null) {
            return NONE;
        }
        for (CaptureState captureState : values()) {
            if (captureState.getValue().equalsIgnoreCase(str)) {
                return captureState;
            }
        }
        return NONE;
    }

    public String getValue() {
        return this.mValue;
    }
}
