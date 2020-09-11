package com.mediatek.accessor.packer;

import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomizedDataPacker implements IPacker {
    private static final String TAG = Log.Tag(CustomizedDataPacker.class.getSimpleName());
    private PackInfo mPackInfo;

    public CustomizedDataPacker(PackInfo packInfo) throws NullPointerException {
        this.mPackInfo = packInfo;
        if (this.mPackInfo == null) {
            throw new NullPointerException("mPackInfo is null!");
        }
    }

    public void pack() {
        TraceHelper.beginSection(">>>>CustomizedDataPacker-pack");
        Log.m3993d(TAG, "<pack> begin");
        if (this.mPackInfo == null) {
            Log.m3993d(TAG, "<pack> mPackInfo is null!");
            TraceHelper.endSection();
        } else if (this.mPackInfo.unpackedCustomizedBufMap == null) {
            Log.m3993d(TAG, "<pack> unpackedCustomizedBufMap is null!");
            TraceHelper.endSection();
        } else {
            new ArrayList();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            for (Map.Entry next : this.mPackInfo.unpackedCustomizedBufMap.entrySet()) {
                byte[] bytes = ((String) next.getKey()).getBytes();
                if (bytes != null) {
                    ArrayList<byte[]> pack = pack((byte[]) next.getValue(), bytes);
                    if (!pack.isEmpty()) {
                        arrayList.addAll(pack);
                    }
                }
            }
            this.mPackInfo.packedCustomizedBufArray = arrayList;
            Log.m3993d(TAG, "<pack> end");
            TraceHelper.endSection();
        }
    }

    public void unpack() {
        TraceHelper.beginSection(">>>>CustomizedDataPacker-unpack");
        Log.m3993d(TAG, "<unpack> begin");
        if (this.mPackInfo == null) {
            Log.m3993d(TAG, "<unpack> mPackInfo is null!");
            TraceHelper.endSection();
        } else if (this.mPackInfo.packedCustomizedBufArray == null) {
            Log.m3993d(TAG, "<unpack> packedCustomizedBufArray is null!");
            TraceHelper.endSection();
        } else {
            this.mPackInfo.unpackedCustomizedBufMap = new HashMap();
            int size = this.mPackInfo.packedCustomizedBufArray.size();
            byte[] bArr = new byte[7];
            HashMap hashMap = new HashMap();
            for (int i = 0; i < size; i++) {
                byte[] bArr2 = this.mPackInfo.packedCustomizedBufArray.get(i);
                if (bArr2 != null) {
                    byte[] bArr3 = new byte[(bArr2.length - 12)];
                    System.arraycopy(bArr2, 12, bArr3, 0, bArr3.length);
                    System.arraycopy(bArr2, 4, bArr, 0, 7);
                    String str = new String(bArr);
                    if (hashMap.containsKey(str)) {
                        ((ArrayList) hashMap.get(str)).add(bArr3);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bArr3);
                        hashMap.put(str, arrayList);
                    }
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = TAG;
                Log.m3993d(str3, "<unpack> typeName " + str2);
                if (!(str2 == null || entry.getValue() == null)) {
                    this.mPackInfo.unpackedCustomizedBufMap.put(str2, joinArraryBuffer((ArrayList) entry.getValue()));
                }
            }
            Log.m3993d(TAG, "<unpack> end");
            TraceHelper.endSection();
        }
    }

    private byte[] joinArraryBuffer(ArrayList<byte[]> arrayList) {
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += arrayList.get(i2).length;
        }
        byte[] bArr = new byte[i];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            System.arraycopy(arrayList.get(i4), 0, bArr, i3, arrayList.get(i4).length);
            i3 += arrayList.get(i4).length;
        }
        return bArr;
    }

    private ArrayList<byte[]> pack(byte[] bArr, byte[] bArr2) {
        int i;
        String str = new String(bArr2);
        String str2 = TAG;
        Log.m3993d(str2, "<pack> type name is " + str);
        ArrayList<byte[]> arrayList = new ArrayList<>();
        if (bArr.length % 65446 == 0) {
            i = bArr.length / 65446;
        } else {
            i = (bArr.length / 65446) + 1;
        }
        byte[] bArr3 = new byte[7];
        byte[] bArr4 = new byte[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int length = (i2 != i + -1 || bArr.length % 65446 == 0) ? PackUtils.MAX_BYTE_PER_APP1 : (bArr.length % 65446) + 12;
            byte[] bArr5 = new byte[length];
            System.arraycopy(PackUtils.intToByteBuffer(bArr.length, 4), 0, bArr5, 0, 4);
            System.arraycopy(bArr2, 0, bArr5, 4, 7);
            System.arraycopy(PackUtils.intToByteBuffer(i2, 1), 0, bArr5, 11, 1);
            int i4 = length - 12;
            System.arraycopy(bArr, i3, bArr5, 12, i4);
            i3 += i4;
            arrayList.add(bArr5);
            i2++;
        }
        return arrayList;
    }
}
