package com.meizu.common.renderer.effect;

/* renamed from: com.meizu.common.renderer.effect.j */
public class SynchronizedIntArray {

    /* renamed from: a */
    private int[] f4477a = new int[8];

    /* renamed from: b */
    private int f4478b = 0;

    /* renamed from: a */
    public synchronized void mo15971a(int i) {
        if (this.f4477a.length == this.f4478b) {
            int[] iArr = new int[(this.f4478b + this.f4478b)];
            System.arraycopy(this.f4477a, 0, iArr, 0, this.f4478b);
            this.f4477a = iArr;
        }
        int[] iArr2 = this.f4477a;
        int i2 = this.f4478b;
        this.f4478b = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: a */
    public synchronized int mo15970a() {
        return this.f4478b;
    }

    /* renamed from: b */
    public synchronized int[] mo15972b() {
        return this.f4477a;
    }

    /* renamed from: c */
    public synchronized void mo15973c() {
        this.f4478b = 0;
        if (this.f4477a.length != 8) {
            this.f4477a = new int[8];
        }
    }
}
