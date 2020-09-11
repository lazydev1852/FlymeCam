package com.mediatek.accessor.meta;

import com.mediatek.accessor.util.Log;
import java.util.HashMap;
import java.util.Map;

public class CustomizedMeta {
    private static final String TAG = Log.Tag(CustomizedMeta.class.getSimpleName());
    private Map<String, byte[]> mCustData;

    public CustomizedMeta(Map<String, byte[]> map) {
        if (map == null || map.size() == 0) {
            this.mCustData = new HashMap();
        } else {
            this.mCustData = map;
        }
    }

    public byte[] getPropertyBuffer(String str) {
        String str2 = TAG;
        Log.m3993d(str2, "<getPropertyBuffer> name " + str);
        if (this.mCustData != null) {
            return this.mCustData.get(str);
        }
        return null;
    }

    public void setPropertyBuffer(String str, byte[] bArr) {
        String str2 = TAG;
        Log.m3993d(str2, "<setPropertyBuffer> name " + str);
        if (this.mCustData != null) {
            this.mCustData.put(str, bArr);
        }
    }

    public Map<String, byte[]> serialize() {
        return this.mCustData;
    }
}
