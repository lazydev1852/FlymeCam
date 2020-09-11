package com.baidu.p020ar.recorder;

/* renamed from: com.baidu.ar.recorder.b */
public class C0841b {

    /* renamed from: a */
    private int f2039a = 100;

    /* renamed from: b */
    private long f2040b = 0;

    /* renamed from: c */
    private long f2041c = 0;

    /* renamed from: d */
    private boolean f2042d = false;

    public C0841b(long j) {
        this.f2040b = j;
    }

    /* renamed from: a */
    public void mo10420a(long j) {
        this.f2041c = j;
        this.f2042d = true;
    }

    /* renamed from: a */
    public boolean mo10421a() {
        return this.f2042d;
    }

    /* renamed from: b */
    public int mo10422b(long j) {
        if (this.f2040b == 0 || this.f2041c == 0) {
            return 0;
        }
        return (int) ((((double) (j - this.f2041c)) * ((double) this.f2039a)) / ((double) this.f2040b));
    }
}
