package com.android.p012ex.camera2.portability;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.android.ex.camera2.portability.c */
public class Size {

    /* renamed from: a */
    private final Point f284a;

    /* renamed from: a */
    public static List<Size> m563a(List<android.util.Size> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (android.util.Size cVar : list) {
            arrayList.add(new Size(cVar));
        }
        return arrayList;
    }

    public Size(android.util.Size size) {
        if (size == null) {
            this.f284a = new Point(0, 0);
        } else {
            this.f284a = new Point(size.getWidth(), size.getHeight());
        }
    }

    /* renamed from: a */
    public int mo8622a() {
        return this.f284a.x;
    }

    /* renamed from: b */
    public int mo8623b() {
        return this.f284a.y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Size) {
            return this.f284a.equals(((Size) obj).f284a);
        }
        return false;
    }

    public int hashCode() {
        return this.f284a.hashCode();
    }

    public String toString() {
        return "Size: (" + mo8622a() + " x " + mo8623b() + ")";
    }
}
