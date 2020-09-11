package com.meizu.statsapp.p081v3.lib.plugin.constants;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.constants.TerType */
public enum TerType {
    PHONE(1),
    FLYME_TV(2),
    PAD(3);
    
    private final int type;

    private TerType(int i) {
        this.type = i;
    }

    public int value() {
        return this.type;
    }

    public String toString() {
        return String.valueOf(this.type);
    }
}
