package com.mediatek.accessor.data;

public class Section {
    public byte[] buffer;
    public int length;
    public int marker;
    public long offset;
    public String type = "";

    public Section(int i, long j, int i2) {
        this.marker = i;
        this.offset = j;
        this.length = i2;
    }
}
