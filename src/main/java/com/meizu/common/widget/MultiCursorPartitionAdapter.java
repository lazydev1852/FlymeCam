package com.meizu.common.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.widget.BasePartitionAdapter;

public abstract class MultiCursorPartitionAdapter extends BasePartitionAdapter {

    /* renamed from: com.meizu.common.widget.MultiCursorPartitionAdapter$a */
    public static class C1461a extends BasePartitionAdapter.C1369a {

        /* renamed from: j */
        Cursor f5705j;

        /* renamed from: k */
        int f5706k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract View mo15853a(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo15858a(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4);

    public MultiCursorPartitionAdapter(Context context) {
        super(context);
    }

    public MultiCursorPartitionAdapter(Context context, int i) {
        super(context, i);
    }

    /* renamed from: h */
    public C1461a mo16194a(int i) {
        return (C1461a) super.mo16194a(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public int mo16938i(int i, int i2) {
        return i2 - this.f4724e[i].f4733f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo16192a(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup) {
        Cursor cursor = mo16194a(i2).f5705j;
        if (cursor != null) {
            int i5 = mo16938i(i2, i3);
            if (cursor.moveToPosition(i5)) {
                if (view == null) {
                    view = mo15853a(this.f4720a, i, i2, cursor, i3, i4, viewGroup);
                }
                mo15858a(view, this.f4720a, i, i2, cursor, i3, i4);
                return view;
            }
            throw new IllegalStateException("Couldn't move cursor to position " + i5);
        }
        throw new IllegalStateException("the partition " + i2 + " cursor is null");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Object mo16212f(int i, int i2) {
        int i3;
        Cursor cursor = mo16194a(i).f5705j;
        if (cursor == null || cursor.isClosed() || (i3 = mo16938i(i, i2)) < 0 || !cursor.moveToPosition(i3)) {
            return null;
        }
        return cursor;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public long mo16214g(int i, int i2) {
        Cursor cursor;
        int i3;
        C1461a h = mo16194a(i);
        if (h.f5706k != -1 && (cursor = h.f5705j) != null && !cursor.isClosed() && (i3 = mo16938i(i, i2)) >= 0 && cursor.moveToPosition(i3)) {
            return cursor.getLong(h.f5706k);
        }
        return 0;
    }
}
