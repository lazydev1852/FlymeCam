package com.mediatek.accessor.parser;

import java.util.Map;

public class SerializedInfo {
    public static final String XMP_KEY = "XMP";
    public Map<String, byte[]> customizedBufMap;
    public byte[] extendedXmpBuf;
    public byte[] standardXmpBuf;
}
