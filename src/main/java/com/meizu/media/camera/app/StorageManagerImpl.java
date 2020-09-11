package com.meizu.media.camera.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Observable;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import androidx.core.p005os.EnvironmentCompat;
import com.meizu.media.camera.app.StorageProvider;
import com.meizu.media.camera.util.C2634am;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class StorageManagerImpl implements StorageProvider {

    /* renamed from: a */
    public static ChangeQuickRedirect f7901a;

    /* renamed from: b */
    private static final LogUtil.C2630a f7902b = new LogUtil.C2630a("StorageManagerImpl");

    /* renamed from: c */
    private List<StorageProvider.C1834b> f7903c = new ArrayList();

    /* renamed from: d */
    private StorageManager f7904d = AndroidServices.m8287a().mo19009h();

    /* renamed from: e */
    private StorageBroadcastReceiver f7905e;

    /* renamed from: f */
    private Context f7906f = AndroidContext.m8284a().mo19002b();

    /* renamed from: g */
    private C1827a f7907g = new C1827a();

    public StorageManagerImpl() {
        m8259f();
    }

    /* renamed from: e */
    private void m8258e() {
        if (!PatchProxy.proxy(new Object[0], this, f7901a, false, 2545, new Class[0], Void.TYPE).isSupported && this.f7905e == null) {
            this.f7905e = new StorageBroadcastReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addDataScheme("file");
            this.f7906f.registerReceiver(this.f7905e, intentFilter);
        }
    }

    /* renamed from: a */
    public void mo18991a() {
        if (!PatchProxy.proxy(new Object[0], this, f7901a, false, 2546, new Class[0], Void.TYPE).isSupported && this.f7905e != null) {
            this.f7906f.unregisterReceiver(this.f7905e);
            this.f7905e = null;
        }
    }

    /* renamed from: a */
    public void mo18992a(StorageProvider.C1833a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f7901a, false, 2547, new Class[]{StorageProvider.C1833a.class}, Void.TYPE).isSupported) {
            this.f7907g.registerObserver(aVar);
            m8258e();
        }
    }

    /* renamed from: b */
    public void mo18993b(StorageProvider.C1833a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f7901a, false, 2548, new Class[]{StorageProvider.C1833a.class}, Void.TYPE).isSupported) {
            this.f7907g.unregisterObserver(aVar);
            mo18991a();
        }
    }

    /* renamed from: a */
    public String mo18990a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7901a, false, 2550, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            return (String) C2634am.m15993a((Object) this.f7904d, "getVolumeState", (Class<?>[]) new Class[]{String.class}, new Object[]{str});
        } catch (Exception unused) {
            LogUtil.m15949b(f7902b, "getVolumeState Exception");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    /* renamed from: b */
    public boolean mo18994b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7901a, false, 2551, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        StorageProvider.C1834b c = mo18995c();
        if (c != null) {
            return c.mo19035c();
        }
        return false;
    }

    /* renamed from: c */
    public StorageProvider.C1834b mo18995c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7901a, false, 2552, new Class[0], StorageProvider.C1834b.class);
        if (proxy.isSupported) {
            return (StorageProvider.C1834b) proxy.result;
        }
        for (StorageProvider.C1834b next : this.f7903c) {
            if (next.mo19034b() && next.mo19033a().contains("storage")) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: d */
    public StorageProvider.C1834b mo18996d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7901a, false, 2553, new Class[0], StorageProvider.C1834b.class);
        if (proxy.isSupported) {
            return (StorageProvider.C1834b) proxy.result;
        }
        for (StorageProvider.C1834b next : this.f7903c) {
            if (!next.mo19034b() && next.mo19033a().contains("storage")) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m8259f() {
        if (!PatchProxy.proxy(new Object[0], this, f7901a, false, 2554, new Class[0], Void.TYPE).isSupported) {
            this.f7903c.clear();
            try {
                Object[] objArr = (Object[]) C2634am.m15994a((Object) this.f7904d, "getVolumeList", (Object[]) null);
                if (objArr != null) {
                    for (Object obj : objArr) {
                        StorageProvider.C1834b bVar = new StorageProvider.C1834b();
                        bVar.f7955b = (String) C2634am.m15994a(obj, "getPath", (Object[]) null);
                        bVar.f7957d = ((Boolean) C2634am.m15992a(obj, "mRemovable")).booleanValue();
                        bVar.f7956c = mo18990a(bVar.f7955b);
                        if (TextUtils.equals("mounted", bVar.f7956c)) {
                            this.f7903c.add(bVar);
                        }
                    }
                }
            } catch (Exception unused) {
                LogUtil.m15949b(f7902b, "parserStorageVolume Exception");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8257a(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f7901a, false, 2555, clsArr, Void.TYPE).isSupported) {
            this.f7907g.mo18998a(str, str2);
        }
    }

    /* renamed from: com.meizu.media.camera.app.StorageManagerImpl$a */
    private static class C1827a extends Observable<StorageProvider.C1833a> {

        /* renamed from: a */
        public static ChangeQuickRedirect f7910a;

        private C1827a() {
        }

        /* renamed from: a */
        public void mo18998a(String str, String str2) {
            if (!PatchProxy.proxy(new Object[]{str, str2}, this, f7910a, false, 2557, new Class[]{String.class, String.class}, Void.TYPE).isSupported) {
                synchronized (this.mObservers) {
                    for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                        ((StorageProvider.C1833a) this.mObservers.get(size)).mo17703a(str, str2);
                    }
                }
            }
        }
    }

    private static class StorageBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public static ChangeQuickRedirect f7908a;

        /* renamed from: b */
        private WeakReference<StorageManagerImpl> f7909b;

        public StorageBroadcastReceiver(StorageManagerImpl storageManagerImpl) {
            this.f7909b = new WeakReference<>(storageManagerImpl);
        }

        public void onReceive(Context context, Intent intent) {
            StorageManagerImpl storageManagerImpl;
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f7908a, false, 2556, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported && (storageManagerImpl = (StorageManagerImpl) this.f7909b.get()) != null) {
                String action = intent.getAction();
                String path = intent.getData().getPath();
                String a = storageManagerImpl.mo18990a(path);
                storageManagerImpl.m8259f();
                if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
                    storageManagerImpl.m8257a(path, a);
                } else if ("android.intent.action.MEDIA_EJECT".equals(action)) {
                    storageManagerImpl.m8257a(path, a);
                } else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
                    storageManagerImpl.m8257a(path, a);
                }
            }
        }
    }
}
