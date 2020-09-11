package com.baidu.p020ar.recorder.p044b;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import com.baidu.p020ar.recorder.filter.FilterManager;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.baidu.ar.recorder.b.e */
public class C0846e {

    /* renamed from: a */
    private static final String f2073a = "e";

    /* renamed from: b */
    private C0847f f2074b;

    /* renamed from: c */
    private ArrayList<C0844c> f2075c;

    /* renamed from: d */
    private int f2076d = 0;

    public C0846e(Context context, Surface surface, ArrayList<C0842a> arrayList) {
        if (context != null && surface != null && arrayList != null) {
            m2373a(context, surface, arrayList);
        }
    }

    /* renamed from: a */
    private void m2373a(Context context, Surface surface, ArrayList<C0842a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (this.f2075c == null) {
                this.f2075c = new ArrayList<>();
            } else {
                this.f2075c.clear();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    this.f2075c.add(new C0844c(arrayList.get(i)));
                    if (arrayList.get(i).mo10436e()) {
                        this.f2076d = i;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f2075c.size() > this.f2076d) {
                if (surface != null) {
                    this.f2074b = new C0847f(this.f2075c.get(this.f2076d).mo10447a(), surface, true);
                } else {
                    this.f2074b.mo10468a(this.f2075c.get(this.f2076d).mo10447a());
                }
            }
            Iterator<C0844c> it = this.f2075c.iterator();
            while (it.hasNext()) {
                C0844c next = it.next();
                this.f2074b.mo10526b(next.mo10447a());
                next.mo10448a(context);
            }
        }
    }

    /* renamed from: a */
    public void mo10463a() {
        if (this.f2074b != null) {
            this.f2074b.mo10467a();
            this.f2074b = null;
        }
        if (this.f2075c != null) {
            Iterator<C0844c> it = this.f2075c.iterator();
            while (it.hasNext()) {
                it.next().mo10451b();
            }
            this.f2075c.clear();
            this.f2075c = null;
        }
    }

    /* renamed from: a */
    public void mo10464a(Context context, FilterManager.FilterType filterType) {
        Iterator<C0844c> it = this.f2075c.iterator();
        while (it.hasNext()) {
            C0844c next = it.next();
            this.f2074b.mo10526b(next.mo10447a());
            next.mo10449a(context, filterType);
        }
    }

    /* renamed from: a */
    public void mo10465a(Context context, ArrayList<C0842a> arrayList) {
        Log.d(f2073a, "updateSurfaceDrawer !!!");
        this.f2074b.mo10525b();
        Iterator<C0844c> it = this.f2075c.iterator();
        while (it.hasNext()) {
            it.next().mo10451b();
        }
        this.f2075c.clear();
        m2373a(context, (Surface) null, arrayList);
    }

    /* renamed from: a */
    public void mo10466a(float[] fArr, long j) {
        String str = f2073a;
        Log.d(str, "frameAvailable timestampNanos = " + j);
        if (this.f2074b != null && this.f2075c != null && this.f2075c.size() != 0) {
            Iterator<C0844c> it = this.f2075c.iterator();
            while (it.hasNext()) {
                C0844c next = it.next();
                this.f2074b.mo10526b(next.mo10447a());
                next.mo10450a(fArr);
            }
            this.f2074b.mo10523a(j);
            this.f2074b.mo10527c();
        }
    }
}
