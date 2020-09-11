package com.meizu.common.util;

import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.meizu.common.util.c */
public class ListViewProxy implements InvocationHandler {

    /* renamed from: c */
    private static Method f4504c;

    /* renamed from: d */
    private static Method f4505d;

    /* renamed from: a */
    protected AbsListView f4506a;

    /* renamed from: b */
    private boolean f4507b = true;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo15992a(int i, long j) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo15993a(MenuItem menuItem) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15994a(MenuItem menuItem, int i, long j) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo15996a(int i) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo15997a(View view, int i, long j) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15998b(int i, long j) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo15999b() {
        return true;
    }

    /* renamed from: b */
    public int[] mo16000b(int i) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo16001c() {
        return true;
    }

    public ListViewProxy(AbsListView absListView) {
        this.f4506a = absListView;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object b;
        int i;
        try {
            String name = method.getName();
            if ("onActionItemDragStart".equals(name)) {
                if (objArr.length > 0) {
                    i = mo15992a(objArr[0].intValue(), objArr[1].longValue());
                } else {
                    long[] jArr = new long[2];
                    m5125a(jArr);
                    i = mo15992a((int) jArr[0], jArr[1]);
                }
                b = Integer.valueOf(i);
            } else if ("onActionItemDrop".equals(name)) {
                mo15994a(objArr[0], objArr[1].intValue(), objArr[2].longValue());
                return null;
            } else if ("onActionItemDragEnd".equals(name)) {
                if (objArr.length > 0) {
                    mo15998b(objArr[0].intValue(), objArr[1].longValue());
                    return null;
                }
                long[] jArr2 = new long[2];
                m5125a(jArr2);
                mo15998b((int) jArr2[0], jArr2[1]);
                return null;
            } else if ("getActionItemType".equals(name)) {
                b = Integer.valueOf(mo15993a(objArr[0]));
            } else if ("onDragSelection".equals(name)) {
                b = Boolean.valueOf(mo15997a(objArr[0], objArr[1].intValue(), objArr[2].longValue()));
            } else if ("topDividerEnabled".equals(name)) {
                b = Boolean.valueOf(mo15999b());
            } else if ("dividerEnabled".equals(name)) {
                b = Boolean.valueOf(mo15996a(objArr[0].intValue()));
            } else if ("bottomDeviderEnabled".equals(name)) {
                b = Boolean.valueOf(mo16001c());
            } else if (!"getDividerPadding".equals(name)) {
                return null;
            } else {
                b = mo16000b(objArr[0].intValue());
            }
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public boolean mo15995a() {
        if (!this.f4507b || !(this.f4506a instanceof ListView)) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.widget.ListView$DividerPadding");
            if (f4504c == null) {
                f4504c = ListView.class.getMethod("setDividerPadding", new Class[]{cls});
            }
            try {
                Object a = m5124a(cls);
                if (a == null) {
                    return false;
                }
                f4504c.invoke(this.f4506a, new Object[]{a});
                return true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return false;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            f4504c = null;
            return false;
        }
    }

    /* renamed from: a */
    private Object m5124a(Class<?> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
    }

    /* renamed from: a */
    private void m5125a(long[] jArr) {
        if (this.f4506a != null) {
            Object obj = null;
            try {
                if (f4505d == null) {
                    f4505d = AbsListView.class.getMethod("getDragPosition", new Class[0]);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                f4505d = null;
            }
            ListAdapter listAdapter = (ListAdapter) this.f4506a.getAdapter();
            if (f4505d != null && listAdapter != null) {
                try {
                    obj = f4505d.invoke(this.f4506a, new Object[0]);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
                if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    long itemId = ((ListAdapter) this.f4506a.getAdapter()).getItemId(intValue);
                    jArr[0] = (long) intValue;
                    jArr[1] = itemId;
                }
            }
        }
    }
}
