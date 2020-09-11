package com.meizu.common.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Observable;
import android.os.storage.StorageManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class SDCardHelper extends BroadcastReceiver {

    /* renamed from: a */
    private static SDCardHelper f4482a;

    /* renamed from: b */
    private boolean f4483b;

    /* renamed from: c */
    private final C1334b f4484c;

    /* renamed from: d */
    private List<C1333a> f4485d;

    /* renamed from: e */
    private Method f4486e;

    /* renamed from: f */
    private Method f4487f;

    /* renamed from: g */
    private Method f4488g;

    /* renamed from: h */
    private Method f4489h;

    /* renamed from: i */
    private Object[] f4490i;

    /* renamed from: com.meizu.common.util.SDCardHelper$c */
    public interface C1335c {
        /* renamed from: a */
        void mo15991a(Intent intent, boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        mo15987a(context);
        if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
            this.f4483b = true;
            mo15988a(intent, true);
        } else if ("android.intent.action.MEDIA_EJECT".equals(action)) {
            this.f4483b = false;
            mo15988a(intent, false);
        } else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
            this.f4483b = false;
            mo15988a(intent, false);
        }
    }

    /* renamed from: a */
    public void mo15988a(Intent intent, boolean z) {
        this.f4484c.mo15990a(intent, z);
    }

    /* renamed from: com.meizu.common.util.SDCardHelper$b */
    private static class C1334b extends Observable<C1335c> {
        /* renamed from: a */
        public void mo15990a(Intent intent, boolean z) {
            synchronized (this.mObservers) {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    ((C1335c) this.mObservers.get(size)).mo15991a(intent, z);
                }
            }
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    public List<C1333a> mo15987a(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        this.f4485d.clear();
        try {
            if (this.f4490i == null) {
                this.f4490i = (Object[]) storageManager.getClass().getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
            }
            if (this.f4490i != null) {
                for (Object obj : this.f4490i) {
                    C1333a aVar = new C1333a();
                    if (this.f4486e == null || this.f4487f == null || this.f4488g == null || this.f4489h == null) {
                        this.f4486e = obj.getClass().getDeclaredMethod("getDescription", new Class[]{Context.class});
                        this.f4487f = obj.getClass().getDeclaredMethod("getPath", new Class[0]);
                        this.f4488g = obj.getClass().getDeclaredMethod("isRemovable", new Class[0]);
                        this.f4489h = storageManager.getClass().getMethod("getVolumeState", new Class[]{String.class});
                    }
                    String str = (String) this.f4487f.invoke(obj, new Object[0]);
                    aVar.m5109a((String) this.f4486e.invoke(obj, new Object[]{context}));
                    aVar.m5112b(str);
                    aVar.m5114c((String) this.f4489h.invoke(storageManager, new Object[]{str}));
                    aVar.m5110a(((Boolean) this.f4488g.invoke(obj, new Object[0])).booleanValue());
                    this.f4485d.add(aVar);
                }
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return this.f4485d;
    }

    /* renamed from: com.meizu.common.util.SDCardHelper$a */
    public class C1333a {

        /* renamed from: b */
        private String f4492b;

        /* renamed from: c */
        private String f4493c;

        /* renamed from: d */
        private String f4494d;

        /* renamed from: e */
        private boolean f4495e;

        public C1333a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m5109a(String str) {
            this.f4492b = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m5112b(String str) {
            this.f4493c = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m5114c(String str) {
            this.f4494d = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m5110a(boolean z) {
            this.f4495e = z;
        }
    }
}
