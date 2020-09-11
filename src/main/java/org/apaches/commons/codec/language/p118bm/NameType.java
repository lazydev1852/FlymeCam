package org.apaches.commons.codec.language.p118bm;

/* renamed from: org.apaches.commons.codec.language.bm.NameType */
public enum NameType {
    ASHKENAZI("ash"),
    GENERIC("gen"),
    SEPHARDIC("sep");
    
    private final String name;

    private NameType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}