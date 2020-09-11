package com.mediatek.accessor.meta;

import com.baidu.p020ar.util.SystemInfoUtil;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.XMPSchemaRegistry;
import com.p006a.p007a.p010b.SerializeOptions;
import com.p006a.p007a.p011c.XMPProperty;

public class XmpMeta {
    private static final String TAG = Log.Tag(XmpMeta.class.getSimpleName());
    private XMPMeta mMeta;
    private XMPSchemaRegistry mRegister;

    public void setMeta(XMPMeta dVar) {
        this.mMeta = dVar;
    }

    public void setRegistry(XMPSchemaRegistry gVar) {
        this.mRegister = gVar;
    }

    public String getPropertyString(String str, String str2) {
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<getPropertyString> meta is null, return -1!!!");
            return "";
        }
        try {
            return this.mMeta.mo7538b(str, str2);
        } catch (XMPException e) {
            String str3 = TAG;
            Log.m3996e(str3, "<getPropertyString> " + str + ": " + str2, e);
            return "";
        } catch (NullPointerException e2) {
            Log.m3996e(TAG, "<getPropertyString> NullPointerException!!!", e2);
            return "";
        }
    }

    public void setPropertyString(String str, String str2, String str3) {
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<setPropertyString> meta is null, return!!!");
            return;
        }
        try {
            this.mMeta.mo7530a(str, str2, (Object) str3);
        } catch (XMPException e) {
            String str4 = TAG;
            Log.m3996e(str4, "<setPropertyString> " + str + ": " + str2, e);
        } catch (NullPointerException unused) {
            Log.m3995e(TAG, "<setPropertyString> NullPointerException!!!");
        }
    }

    public byte[] getPropertyBase64(String str, String str2) {
        byte[] bArr;
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<getPropertyBase64> meta is null, return -1!!!");
            return null;
        }
        TraceHelper.beginSection(">>>>XmpMeta-getPropertyBase64");
        try {
            bArr = this.mMeta.mo7536a(str, str2);
        } catch (XMPException unused) {
            Log.m3995e(TAG, "<getPropertyBase64> XMPException, " + str + ": " + str2);
            bArr = null;
            TraceHelper.endSection();
            return bArr;
        } catch (NullPointerException unused2) {
            Log.m3995e(TAG, "<getPropertyBase64> NullPointerException!!!");
            bArr = null;
            TraceHelper.endSection();
            return bArr;
        }
        TraceHelper.endSection();
        return bArr;
    }

    public void setPropertyBase64(String str, String str2, byte[] bArr) {
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<setPropertyString> meta is null, return!!!");
            return;
        }
        TraceHelper.beginSection(">>>>XmpMeta-setPropertyBase64");
        try {
            this.mMeta.mo7535a(str, str2, bArr);
        } catch (XMPException unused) {
            String str3 = TAG;
            Log.m3995e(str3, "<setPropertyBase64> XMPException, " + str + ": " + str2);
        } catch (NullPointerException unused2) {
            Log.m3995e(TAG, "<setPropertyBase64> NullPointerException!!!");
        }
        TraceHelper.endSection();
    }

    public void setStructField(String str, String str2, String str3, String str4, String str5) {
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<setStructField> meta is null, return!!!");
            return;
        }
        try {
            this.mMeta.mo7532a(str, str2, str3, str4, str5);
        } catch (XMPException e) {
            String str6 = TAG;
            Log.m3996e(str6, "<setStructField> " + str2 + ": " + str4, e);
        } catch (NullPointerException e2) {
            Log.m3996e(TAG, "<setStructField> NullPointerException!!!", e2);
        }
    }

    public int getStructField(String str, String str2, String str3, String str4) {
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<getStructFieldInt> meta is null, return -1");
            return -1;
        }
        try {
            XMPProperty a = this.mMeta.mo7524a(str, str2, str3, str4);
            if (a != null) {
                return Integer.valueOf((String) a.mo7548a()).intValue();
            }
            String str5 = TAG;
            Log.m3993d(str5, "<getStructFieldInt> " + str3 + SystemInfoUtil.COLON + str4 + ", value is null, return -1");
            return -1;
        } catch (XMPException e) {
            String str6 = TAG;
            Log.m3996e(str6, "<getStructFieldInt> " + str2 + ": " + str4, e);
            return -1;
        } catch (NullPointerException e2) {
            Log.m3996e(TAG, "<getStructFieldInt> NullPointerException!!!", e2);
            return -1;
        }
    }

    public void setArrayItem(String str, String str2, int i, String str3) {
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<setArrayItem> meta is null, return!!!");
            return;
        }
        try {
            this.mMeta.mo7528a(str, str2, i, str3);
        } catch (XMPException e) {
            String str4 = TAG;
            Log.m3996e(str4, "<setArrayItem> " + str + ": " + str2, e);
        } catch (NullPointerException e2) {
            Log.m3996e(TAG, "<setArrayItem> NullPointerException!!!", e2);
        }
    }

    public String getArrayItem(String str, String str2, int i) {
        if (this.mMeta == null) {
            Log.m3993d(TAG, "<getArrayItem> meta is null, return!!!");
            return "";
        }
        try {
            XMPProperty a = this.mMeta.mo7523a(str, str2, i);
            if (a != null) {
                return String.valueOf(a.mo7548a());
            }
            Log.m3993d(TAG, "<getStructFieldInt> property is null, return -1");
            return "";
        } catch (XMPException e) {
            String str3 = TAG;
            Log.m3996e(str3, "<getArrayItem> " + str + ": " + str2, e);
            return "";
        } catch (NullPointerException e2) {
            Log.m3996e(TAG, "<getArrayItem> NullPointerException!!!", e2);
            return "";
        }
    }

    public void registerNamespace(String str, String str2) {
        try {
            this.mRegister.mo7596a(str, str2);
        } catch (XMPException e) {
            String str3 = TAG;
            Log.m3996e(str3, "<registerNamespace> " + str + ": " + str2, e);
        }
    }

    public byte[] serialize() {
        byte[] bArr;
        TraceHelper.beginSection(">>>>XmpMeta-serialize");
        try {
            bArr = XMPMetaFactory.m369a(this.mMeta, new SerializeOptions().mo7654b(true).mo7651a(true));
        } catch (XMPException e) {
            Log.m3996e(TAG, "<serialize> XMPException", e);
            bArr = null;
        }
        TraceHelper.endSection();
        return bArr;
    }
}
