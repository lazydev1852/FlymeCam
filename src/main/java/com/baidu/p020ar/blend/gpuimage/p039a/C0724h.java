package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.ar.blend.gpuimage.a.h */
public class C0724h extends C0712g {

    /* renamed from: m */
    private static final String f1534m = "h";

    /* renamed from: a */
    protected List<C0712g> f1535a;

    /* renamed from: l */
    protected List<C0712g> f1536l;

    /* renamed from: n */
    private int f1537n;

    /* renamed from: o */
    private int[] f1538o;

    /* renamed from: p */
    private boolean f1539p;

    public C0724h() {
        this((List<C0712g>) null);
    }

    public C0724h(List<C0712g> list) {
        this.f1539p = false;
        mo10027a(list);
    }

    /* renamed from: c */
    private void m1827c(int i, int i2) {
        mo10033o();
        if (this.f1535a.size() > 1) {
            this.f1538o = new int[2];
            for (int i3 = 0; i3 < 2; i3++) {
                this.f1538o[i3] = C0749a.m1934a(3553, i, i2);
            }
        }
    }

    /* renamed from: o */
    private void mo10033o() {
        if (this.f1538o != null) {
            GLES20.glDeleteTextures(this.f1538o.length, this.f1538o, 0);
            this.f1538o = null;
        }
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        if (!this.f1539p) {
            this.f1537n = C0749a.m1942b();
        }
        for (C0712g c : this.f1535a) {
            c.mo10001c();
        }
    }

    /* renamed from: a */
    public void mo9988a(int i) {
        mo9997b(i, 0);
    }

    /* renamed from: a */
    public void mo9990a(int i, int i2) {
        if (i != this.f1492i || i2 != this.f1493j) {
            super.mo9990a(i, i2);
            int size = this.f1535a.size();
            Log.i(f1534m, String.format("There are %d filters in this filter-chain.", new Object[]{Integer.valueOf(size)}));
            for (int i3 = 0; i3 < size; i3++) {
                this.f1535a.get(i3).mo9990a(i, i2);
            }
            if (!this.f1539p) {
                m1827c(i, i2);
            }
        }
    }

    /* renamed from: a */
    public void mo10026a(C0712g gVar) {
        if (gVar != null) {
            this.f1535a.add(gVar);
            mo10031n();
        }
    }

    /* renamed from: a */
    public void mo10027a(List<C0712g> list) {
        if (this.f1535a != null) {
            this.f1535a.clear();
        } else {
            this.f1535a = new ArrayList();
        }
        if (list != null) {
            this.f1535a.addAll(list);
        }
        mo10031n();
    }

    /* renamed from: a */
    public void mo10028a(boolean z) {
        this.f1539p = z;
    }

    /* renamed from: a */
    public void mo10029a(int[] iArr, int i) {
        this.f1537n = i;
        this.f1538o = iArr;
    }

    /* renamed from: b */
    public void mo9997b(int i, int i2) {
        if (mo10009g() && this.f1535a != null && this.f1535a.size() > 0) {
            try {
                int size = this.f1535a.size();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = size - 1;
                    if (i3 < i5) {
                        C0749a.m1944b(this.f1538o[i4], 3553, this.f1537n);
                        this.f1535a.get(i3).mo9997b(i, this.f1537n);
                        i = this.f1538o[i4];
                        i4 = 1 - i4;
                        i3++;
                    } else {
                        this.f1535a.get(i5).mo9997b(i, i2);
                        return;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public void mo10007e() {
        if (!this.f1539p) {
            mo10033o();
            C0749a.m1947c(this.f1537n);
        } else {
            this.f1538o = null;
            this.f1537n = -1;
        }
        for (C0712g d : this.f1535a) {
            d.mo10005d();
        }
        super.mo10007e();
    }

    /* renamed from: m */
    public List<C0712g> mo10030m() {
        return this.f1536l;
    }

    /* renamed from: n */
    public void mo10031n() {
        if (this.f1535a != null) {
            if (this.f1536l == null) {
                this.f1536l = new ArrayList();
            } else {
                this.f1536l.clear();
            }
            for (C0712g next : this.f1535a) {
                if (next instanceof C0724h) {
                    C0724h hVar = (C0724h) next;
                    hVar.mo10031n();
                    List<C0712g> m = hVar.mo10030m();
                    if (m != null && !m.isEmpty()) {
                        this.f1536l.addAll(m);
                    }
                } else {
                    this.f1536l.add(next);
                }
            }
        }
    }
}
