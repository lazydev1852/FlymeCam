package com.p006a.p007a.p008a.p009a;

/* renamed from: com.a.a.a.a.d */
public class XMPPathSegment {

    /* renamed from: a */
    private String f43a;

    /* renamed from: b */
    private int f44b;

    /* renamed from: c */
    private boolean f45c;

    /* renamed from: d */
    private int f46d;

    public XMPPathSegment(String str, int i) {
        this.f43a = str;
        this.f44b = i;
    }

    /* renamed from: a */
    public int mo7490a() {
        return this.f44b;
    }

    /* renamed from: a */
    public void mo7491a(int i) {
        this.f44b = i;
    }

    /* renamed from: b */
    public String mo7494b() {
        return this.f43a;
    }

    /* renamed from: a */
    public void mo7492a(String str) {
        this.f43a = str;
    }

    /* renamed from: a */
    public void mo7493a(boolean z) {
        this.f45c = z;
    }

    /* renamed from: c */
    public boolean mo7496c() {
        return this.f45c;
    }

    /* renamed from: d */
    public int mo7497d() {
        return this.f46d;
    }

    /* renamed from: b */
    public void mo7495b(int i) {
        this.f46d = i;
    }

    public String toString() {
        switch (this.f44b) {
            case 1:
            case 2:
            case 3:
            case 4:
                return this.f43a;
            case 5:
            case 6:
                return this.f43a;
            default:
                return this.f43a;
        }
    }
}
