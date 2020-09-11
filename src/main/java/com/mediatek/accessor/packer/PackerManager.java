package com.mediatek.accessor.packer;

import com.mediatek.accessor.util.Log;

public class PackerManager {
    private static final String TAG = Log.Tag(PackerManager.class.getSimpleName());
    private IPacker mCustDataPacker;
    private IPacker mJpgPacker;
    private IPacker mXmpPacker;

    public byte[] pack(PackInfo packInfo) {
        Log.m3993d(TAG, "<pack>");
        this.mXmpPacker = new XmpPacker(packInfo);
        this.mXmpPacker.pack();
        this.mCustDataPacker = new CustomizedDataPacker(packInfo);
        this.mCustDataPacker.pack();
        this.mJpgPacker = new JpgPacker(packInfo);
        this.mJpgPacker.pack();
        return packInfo.packedJpgBuf;
    }

    public PackInfo unpack(byte[] bArr) {
        Log.m3993d(TAG, "<unpack>");
        PackInfo packInfo = new PackInfo();
        packInfo.packedJpgBuf = bArr;
        this.mJpgPacker = new JpgPacker(packInfo);
        this.mJpgPacker.unpack();
        this.mXmpPacker = new XmpPacker(packInfo);
        this.mXmpPacker.unpack();
        this.mCustDataPacker = new CustomizedDataPacker(packInfo);
        this.mCustDataPacker.unpack();
        return packInfo;
    }
}
