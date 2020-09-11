package com.android.volley;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.android.volley.k */
public class NetworkResponse {

    /* renamed from: a */
    public final int f325a;

    /* renamed from: b */
    public final byte[] f326b;

    /* renamed from: c */
    public final Map<String, String> f327c;

    /* renamed from: d */
    public final List<Header> f328d;

    /* renamed from: e */
    public final boolean f329e;

    /* renamed from: f */
    public final long f330f;

    @Deprecated
    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, m597a(map), z, j);
    }

    public NetworkResponse(int i, byte[] bArr, boolean z, long j, List<Header> list) {
        this(i, bArr, m598a(list), list, z, j);
    }

    @Deprecated
    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, bArr, map, false, 0);
    }

    private NetworkResponse(int i, byte[] bArr, Map<String, String> map, List<Header> list, boolean z, long j) {
        this.f325a = i;
        this.f326b = bArr;
        this.f327c = map;
        if (list == null) {
            this.f328d = null;
        } else {
            this.f328d = Collections.unmodifiableList(list);
        }
        this.f329e = z;
        this.f330f = j;
    }

    /* renamed from: a */
    private static Map<String, String> m598a(List<Header> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header next : list) {
            treeMap.put(next.mo8694a(), next.mo8695b());
        }
        return treeMap;
    }

    /* renamed from: a */
    private static List<Header> m597a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new Header((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }
}
