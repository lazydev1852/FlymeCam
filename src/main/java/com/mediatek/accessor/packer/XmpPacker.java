package com.mediatek.accessor.packer;

import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;

public class XmpPacker implements IPacker {
    private static final String TAG = Log.Tag(XmpPacker.class.getSimpleName());
    private PackInfo mPackInfo;

    public XmpPacker(PackInfo packInfo) throws NullPointerException {
        this.mPackInfo = packInfo;
        if (this.mPackInfo == null) {
            throw new NullPointerException("mPackInfo is null!");
        }
    }

    public void pack() {
        TraceHelper.beginSection(">>>>XmpPacker-pack");
        Log.m3993d(TAG, "<pack> begin");
        if (this.mPackInfo == null) {
            Log.m3993d(TAG, "<pack> mPackInfo is null!");
            TraceHelper.endSection();
            return;
        }
        if (this.mPackInfo.unpackedStandardXmpBuf != null) {
            byte[] bArr = new byte[(this.mPackInfo.unpackedStandardXmpBuf.length + PackUtils.XMP_HEADER_START.length())];
            System.arraycopy(PackUtils.XMP_HEADER_START.getBytes(), 0, bArr, 0, PackUtils.XMP_HEADER_START.length());
            System.arraycopy(this.mPackInfo.unpackedStandardXmpBuf, 0, bArr, PackUtils.XMP_HEADER_START.length(), this.mPackInfo.unpackedStandardXmpBuf.length);
            this.mPackInfo.packedStandardXmpBuf = bArr;
        }
        if (this.mPackInfo.unpackedExtendedXmpBuf != null) {
            this.mPackInfo.packedExtendedXmpBufArray = makeExtXmpData(this.mPackInfo.unpackedExtendedXmpBuf);
        }
        Log.m3993d(TAG, "<pack> end");
        TraceHelper.endSection();
    }

    public void unpack() {
        TraceHelper.beginSection(">>>>XmpPacker-unpack");
        Log.m3993d(TAG, "<unpack> begin");
        if (this.mPackInfo == null) {
            Log.m3993d(TAG, "<unpack> mPackInfo is null!");
            TraceHelper.endSection();
            return;
        }
        if (this.mPackInfo.packedStandardXmpBuf != null) {
            byte[] bArr = new byte[(this.mPackInfo.packedStandardXmpBuf.length - PackUtils.XMP_HEADER_START.length())];
            System.arraycopy(this.mPackInfo.packedStandardXmpBuf, PackUtils.XMP_HEADER_START.length(), bArr, 0, bArr.length);
            this.mPackInfo.unpackedStandardXmpBuf = bArr;
        }
        if (this.mPackInfo.packedExtendedXmpBufArray != null) {
            ArrayList<byte[]> arrayList = this.mPackInfo.packedExtendedXmpBufArray;
            int length = PackUtils.XMP_EXT_HEADER.length() + 32 + 4 + 4 + 1;
            int size = arrayList.size();
            byte[] bArr2 = null;
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                byte[] bArr3 = arrayList.get(i2);
                if (bArr2 != null) {
                    byte[] bArr4 = new byte[i];
                    i += bArr3.length - length;
                    byte[] bArr5 = new byte[i];
                    System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
                    System.arraycopy(bArr3, length, bArr5, bArr2.length, bArr3.length - length);
                    bArr2 = bArr5;
                } else {
                    int length2 = bArr3.length - length;
                    byte[] bArr6 = new byte[length2];
                    System.arraycopy(bArr3, length, bArr6, 0, length2);
                    byte[] bArr7 = bArr6;
                    i = length2;
                    bArr2 = bArr7;
                }
            }
            this.mPackInfo.unpackedExtendedXmpBuf = bArr2;
        }
        Log.m3993d(TAG, "<unpack> end");
        TraceHelper.endSection();
    }

    private ArrayList<byte[]> makeExtXmpData(byte[] bArr) {
        int i;
        byte[] bArr2;
        int i2;
        int i3;
        Log.m3993d(TAG, "<makeExtXmpData>");
        ArrayList<byte[]> arrayList = new ArrayList<>();
        String md5 = PackUtils.getMd5(bArr);
        if (bArr.length % PackUtils.MAX_LEN_FOR_REAL_XMP_DATA_PER_APP1 == 0) {
            i = bArr.length / PackUtils.MAX_LEN_FOR_REAL_XMP_DATA_PER_APP1;
        } else {
            i = (bArr.length / PackUtils.MAX_LEN_FOR_REAL_XMP_DATA_PER_APP1) + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            byte[] xmpCommonHeader = PackUtils.getXmpCommonHeader(md5, bArr.length, i5);
            if (i5 != i - 1 || bArr.length % PackUtils.MAX_LEN_FOR_REAL_XMP_DATA_PER_APP1 == 0) {
                i2 = PackUtils.MAX_BYTE_PER_APP1;
                bArr2 = new byte[PackUtils.MAX_BYTE_PER_APP1];
                System.arraycopy(xmpCommonHeader, 0, bArr2, 0, xmpCommonHeader.length);
                System.arraycopy(bArr, i4, bArr2, xmpCommonHeader.length, PackUtils.MAX_BYTE_PER_APP1 - xmpCommonHeader.length);
                i3 = xmpCommonHeader.length;
            } else {
                i2 = (bArr.length % PackUtils.MAX_LEN_FOR_REAL_XMP_DATA_PER_APP1) + xmpCommonHeader.length;
                bArr2 = new byte[i2];
                System.arraycopy(xmpCommonHeader, 0, bArr2, 0, xmpCommonHeader.length);
                System.arraycopy(bArr, i4, bArr2, xmpCommonHeader.length, i2 - xmpCommonHeader.length);
                i3 = xmpCommonHeader.length;
            }
            i4 += i2 - i3;
            arrayList.add(i5, bArr2);
        }
        return arrayList;
    }
}
