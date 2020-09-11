package com.meizu.media.camera.app;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.privacy.aidl.IPrivacyController;
import com.meizu.privacy.aidl.IPrivacyResultCallback;
import com.meizu.privacy.aidl.PrivateItem;
import com.meizu.privacy.aidl.UpdatePrivateResult;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.app.g */
public class PrivacyService {

    /* renamed from: a */
    public static ChangeQuickRedirect f7943a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f7944b = new LogUtil.C2630a("PrivacyService");

    /* renamed from: c */
    private Context f7945c;

    /* renamed from: d */
    private ContentResolver f7946d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IPrivacyController f7947e;

    /* renamed from: f */
    private ServiceConnection f7948f = new ServiceConnection() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7950a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Class[] clsArr = {ComponentName.class, IBinder.class};
            if (!PatchProxy.proxy(new Object[]{componentName, iBinder}, this, f7950a, false, 2538, clsArr, Void.TYPE).isSupported) {
                LogUtil.C2630a c = PrivacyService.f7944b;
                LogUtil.m15942a(c, "onServiceConnected name = " + componentName);
                IPrivacyController unused = PrivacyService.this.f7947e = IPrivacyController.C2790a.m16950a(iBinder);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (!PatchProxy.proxy(new Object[]{componentName}, this, f7950a, false, 2539, new Class[]{ComponentName.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a c = PrivacyService.f7944b;
                LogUtil.m15942a(c, "onServiceDisconnected name = " + componentName);
                IPrivacyController unused = PrivacyService.this.f7947e = null;
            }
        }
    };

    /* renamed from: g */
    private IPrivacyResultCallback.C2792a f7949g = new IPrivacyResultCallback.C2792a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7952a;

        /* renamed from: a */
        public void mo19029a(List<UpdatePrivateResult> list) throws RemoteException {
            if (!PatchProxy.proxy(new Object[]{list}, this, f7952a, false, 2540, new Class[]{List.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a c = PrivacyService.f7944b;
                LogUtil.m15942a(c, "onMarkPrivateComplete results = " + list);
            }
        }

        /* renamed from: b */
        public void mo19031b(List<UpdatePrivateResult> list) throws RemoteException {
            if (!PatchProxy.proxy(new Object[]{list}, this, f7952a, false, 2541, new Class[]{List.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a c = PrivacyService.f7944b;
                LogUtil.m15942a(c, "onMarkUnPrivateComplete results = " + list);
            }
        }

        /* renamed from: c */
        public void mo19032c(List<PrivateItem> list) throws RemoteException {
            if (!PatchProxy.proxy(new Object[]{list}, this, f7952a, false, 2542, new Class[]{List.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a c = PrivacyService.f7944b;
                LogUtil.m15942a(c, "onQueryPrivateComplete results = " + list);
            }
        }

        /* renamed from: a */
        public void mo19028a() throws RemoteException {
            if (!PatchProxy.proxy(new Object[0], this, f7952a, false, 2543, new Class[0], Void.TYPE).isSupported) {
                LogUtil.m15942a(PrivacyService.f7944b, "onClearPrivatesComplete");
            }
        }

        /* renamed from: b */
        public void mo19030b() throws RemoteException {
            if (!PatchProxy.proxy(new Object[0], this, f7952a, false, 2544, new Class[0], Void.TYPE).isSupported) {
                LogUtil.m15942a(PrivacyService.f7944b, "onExportPrivatesComplete ");
            }
        }
    };

    public PrivacyService(Context context) {
        this.f7945c = context;
        this.f7946d = this.f7945c.getContentResolver();
    }

    /* renamed from: a */
    public static boolean m8310a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f7943a, true, 2529, new Class[]{Context.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return Settings.Global.getInt(context.getContentResolver(), "mz_private_mode_running", 0) == 1;
    }

    /* renamed from: b */
    public static boolean m8311b(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f7943a, true, 2530, new Class[]{Context.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return Settings.Global.getInt(context.getContentResolver(), "mz_private_camera_mode", 1) == 1;
    }

    /* renamed from: a */
    public void mo19020a() {
        if (!PatchProxy.proxy(new Object[0], this, f7943a, false, 2531, new Class[0], Void.TYPE).isSupported) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.meizu.privacy", "com.meizu.privacy.PrivacyController"));
            try {
                this.f7945c.bindService(intent, this.f7948f, 1);
                LogUtil.m15956e(f7944b, "bind");
            } catch (RuntimeException unused) {
                LogUtil.m15956e(f7944b, "bind fail");
            }
        }
    }

    /* renamed from: b */
    public void mo19023b() {
        if (!PatchProxy.proxy(new Object[0], this, f7943a, false, 2532, new Class[0], Void.TYPE).isSupported) {
            try {
                this.f7945c.unbindService(this.f7948f);
                LogUtil.m15956e(f7944b, "unbind");
            } catch (RuntimeException unused) {
                LogUtil.m15956e(f7944b, "unbind fail");
            }
        }
    }

    /* renamed from: d */
    private boolean m8313d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7943a, false, 2533, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f7947e == null) {
            LogUtil.m15956e(f7944b, "MarkPrivate service not bind");
            return false;
        } else if (!m8310a(this.f7945c)) {
            LogUtil.m15956e(f7944b, "isPrivateMode false");
            return false;
        } else if (m8311b(this.f7945c)) {
            return true;
        } else {
            LogUtil.m15956e(f7944b, "isPrivateCameraEnable false");
            return false;
        }
    }

    /* renamed from: a */
    public void mo19021a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f7943a, false, 2534, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7944b;
            LogUtil.m15954d(aVar, "file " + str);
            if (m8313d()) {
                if (str == null) {
                    LogUtil.m15956e(f7944b, "file can't be null");
                    return;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    this.f7947e.mo23842a(arrayList, 2, this.f7949g);
                } catch (RemoteException unused) {
                    LogUtil.m15956e(f7944b, "markPrivatePicFile RemoteException");
                }
            }
        }
    }

    /* renamed from: a */
    public void mo19022a(List<String> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f7943a, false, 2535, new Class[]{List.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7944b;
            LogUtil.m15954d(aVar, "file " + list);
            if (m8313d()) {
                if (list == null) {
                    LogUtil.m15956e(f7944b, "files can't be null");
                    return;
                }
                try {
                    this.f7947e.mo23842a(list, 2, this.f7949g);
                } catch (RemoteException unused) {
                    LogUtil.m15956e(f7944b, "markPrivatePicFile RemoteException");
                }
            }
        }
    }

    /* renamed from: b */
    public void mo19025b(List<String> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f7943a, false, 2536, new Class[]{List.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7944b;
            LogUtil.m15954d(aVar, "file " + list);
            if (m8313d()) {
                if (list == null) {
                    LogUtil.m15956e(f7944b, "file can't be null");
                    return;
                }
                try {
                    this.f7947e.mo23842a(list, 3, this.f7949g);
                } catch (RemoteException unused) {
                    LogUtil.m15956e(f7944b, "markPrivateVideoFile RemoteException");
                }
            }
        }
    }

    /* renamed from: b */
    public void mo19024b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f7943a, false, 2537, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7944b;
            LogUtil.m15954d(aVar, "file " + str);
            if (m8313d()) {
                if (str == null) {
                    LogUtil.m15956e(f7944b, "file can't be null");
                    return;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    this.f7947e.mo23842a(arrayList, 3, this.f7949g);
                } catch (RemoteException unused) {
                    LogUtil.m15956e(f7944b, "markPrivateVideoFile RemoteException");
                }
            }
        }
    }
}
