package com.baidu.p020ar.recg;

import com.baidu.p020ar.resloader.C0886f;

/* renamed from: com.baidu.ar.recg.a */
public class C0821a implements C0886f {
    /* renamed from: a */
    public boolean mo10342a() {
        return true;
    }

    /* renamed from: b */
    public String mo10343b() {
        return "libImgRecognition.so";
    }

    /* renamed from: c */
    public boolean mo10344c() {
        try {
            ImgRecognitionClient.init((String[]) null);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
