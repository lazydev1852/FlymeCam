package com.meizu.share.p079b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.share.b.a */
public class ChooserTargets {

    /* renamed from: a */
    private List<DisplayResolveInfo> f15732a;

    /* renamed from: b */
    private List<DisplayResolveInfo> f15733b;

    public ChooserTargets(List<DisplayResolveInfo> list, List<DisplayResolveInfo> list2) {
        this.f15732a = list;
        this.f15733b = list2;
    }

    /* renamed from: a */
    public List<DisplayResolveInfo> mo23978a() {
        return this.f15732a;
    }

    /* renamed from: b */
    public List<DisplayResolveInfo> mo23979b() {
        return this.f15733b;
    }

    /* renamed from: c */
    public List<DisplayResolveInfo> mo23980c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f15732a);
        arrayList.addAll(this.f15733b);
        return arrayList;
    }
}
