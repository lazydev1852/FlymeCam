package com.baidu.p020ar.p021a.p022a.p023a;

/* renamed from: com.baidu.ar.a.a.a.a */
public interface C0487a {

    /* renamed from: com.baidu.ar.a.a.a.a$a */
    public static class C0488a {

        /* renamed from: a */
        public float[] f535a;

        /* renamed from: b */
        public int f536b;

        /* renamed from: c */
        public int f537c;

        /* renamed from: a */
        public void mo8924a(float[] fArr, int i, int i2) {
            this.f535a = fArr;
            this.f536b = i;
            this.f537c = i2;
        }
    }

    /* renamed from: com.baidu.ar.a.a.a.a$b */
    public interface C0489b {
        /* renamed from: a */
        void mo8925a();

        /* renamed from: a */
        void mo8926a(int i, String str);
    }

    /* renamed from: com.baidu.ar.a.a.a.a$c */
    public interface C0490c {
        /* renamed from: a */
        void mo8927a(int i, String str);

        /* renamed from: a */
        void mo8928a(C0488a aVar);
    }

    void close();

    int init(String str, String str2);

    C0488a predictForFloatMatrix(float[] fArr, int i, int i2, int i3);
}
