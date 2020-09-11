package com.baidu.p020ar.rotate;

/* renamed from: com.baidu.ar.rotate.Orientation */
public enum Orientation {
    UNKNOWN(-1),
    PORTRAIT(0),
    PORTRAIT_REVERSE(180),
    LANDSCAPE(90),
    LANDSCAPE_REVERSE(-90);
    
    private int mDegree;

    private Orientation(int i) {
        this.mDegree = i;
    }

    public static Orientation valueOf(int i) {
        return i == PORTRAIT.getDegree() ? PORTRAIT : i == PORTRAIT_REVERSE.getDegree() ? PORTRAIT_REVERSE : i == LANDSCAPE.getDegree() ? LANDSCAPE : i == LANDSCAPE_REVERSE.getDegree() ? LANDSCAPE_REVERSE : UNKNOWN;
    }

    public int getDegree() {
        return this.mDegree;
    }

    public String toString() {
        return String.valueOf(this.mDegree);
    }
}
