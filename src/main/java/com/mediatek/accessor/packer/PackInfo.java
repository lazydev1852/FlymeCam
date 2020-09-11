package com.mediatek.accessor.packer;

import java.util.ArrayList;
import java.util.Map;

public class PackInfo {
    public ArrayList<byte[]> packedCustomizedBufArray;
    public ArrayList<byte[]> packedExtendedXmpBufArray;
    public byte[] packedJpgBuf;
    public byte[] packedStandardXmpBuf;
    public byte[] unpackedBlurImageBuf;
    public Map<String, byte[]> unpackedCustomizedBufMap;
    public byte[] unpackedExtendedXmpBuf;
    public byte[] unpackedJpgBuf;
    public byte[] unpackedStandardXmpBuf;
}
