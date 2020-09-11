package com.meizu.statsapp.p081v3;

/* renamed from: com.meizu.statsapp.v3.PkgType */
public enum PkgType {
    APP(0),
    GAME(1),
    FLYME_TV(2),
    PAD(3);
    
    private int type;

    private PkgType(int i) {
        this.type = i;
    }

    public static PkgType fromValue(int i) {
        if (i == 0) {
            return APP;
        }
        if (i == 1) {
            return GAME;
        }
        if (i == 2) {
            return FLYME_TV;
        }
        if (i == 3) {
            return PAD;
        }
        return null;
    }

    public int value() {
        return this.type;
    }
}
