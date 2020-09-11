package com.meizu.media.camera.gif;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.meizu.media.camera.gif.c */
public class GifPlayer {

    /* renamed from: a */
    public static ChangeQuickRedirect f10247a;

    /* renamed from: b */
    private static final LogUtil.C2630a f10248b = new LogUtil.C2630a("GifPlayer");
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static int f10249j = 100;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public GifDecoder f10250c = new GifDecoder();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicBoolean f10251d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2092b f10252e;

    /* renamed from: f */
    private C2094d f10253f = new C2094d();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f10254g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f10255h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f10256i;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AtomicBoolean f10257k = new AtomicBoolean(false);

    /* renamed from: com.meizu.media.camera.gif.c$b */
    /* compiled from: GifPlayer */
    public interface C2092b {
        /* renamed from: a */
        void mo20147a();

        /* renamed from: a */
        void mo20148a(long j);

        /* renamed from: a */
        void mo20149a(Bitmap bitmap);

        /* renamed from: b */
        void mo20151b();

        /* renamed from: c */
        void mo20153c();
    }

    public GifPlayer(String str, C2092b bVar) {
        this.f10252e = bVar;
        this.f10254g = str;
        this.f10257k.set(false);
        new C2093c().execute(new Object[]{str});
    }

    /* renamed from: a */
    public int mo20188a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10247a, false, 4165, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f10250c.mo20166a();
    }

    /* renamed from: a */
    public void mo20189a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10247a, false, 4166, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i < 0) {
                LogUtil.C2630a aVar = f10248b;
                LogUtil.m15949b(aVar, "play from frame : " + i);
                i = 0;
            }
            this.f10255h = i;
        }
    }

    /* renamed from: b */
    public void mo20191b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10247a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4167, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i > mo20188a() - 1) {
                LogUtil.C2630a aVar = f10248b;
                LogUtil.m15949b(aVar, "play to frame : " + i);
                i = mo20188a() - 1;
            }
            this.f10256i = i;
        }
    }

    /* renamed from: b */
    public void mo20190b() {
        if (!PatchProxy.proxy(new Object[0], this, f10247a, false, 4168, new Class[0], Void.TYPE).isSupported) {
            this.f10251d.set(true);
            this.f10253f.removeMessages(1);
            Message.obtain(this.f10253f, 1, this.f10255h, this.f10256i).sendToTarget();
        }
    }

    /* renamed from: c */
    public void mo20192c() {
        if (!PatchProxy.proxy(new Object[0], this, f10247a, false, 4169, new Class[0], Void.TYPE).isSupported) {
            this.f10253f.removeMessages(2);
            mo20193c(this.f10255h);
        }
    }

    /* renamed from: c */
    public void mo20193c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10247a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4170, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f10253f.removeMessages(3);
            Message.obtain(this.f10253f, 3, Integer.valueOf(i)).sendToTarget();
        }
    }

    /* renamed from: com.meizu.media.camera.gif.c$d */
    /* compiled from: GifPlayer */
    private final class C2094d extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10262a;

        /* renamed from: c */
        private int f10264c;

        /* renamed from: d */
        private int f10265d;

        /* renamed from: e */
        private int f10266e;

        /* renamed from: f */
        private long f10267f;

        private C2094d() {
            this.f10267f = 0;
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10262a, false, 4179, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        this.f10264c = message.arg1;
                        this.f10265d = message.arg2;
                        this.f10266e = this.f10264c;
                        this.f10267f = 0;
                        sendEmptyMessage(2);
                        return;
                    case 2:
                        if (this.f10267f == 0) {
                            this.f10267f = System.currentTimeMillis();
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.f10267f = currentTimeMillis;
                            GifPlayer.this.f10252e.mo20148a((currentTimeMillis - this.f10267f) - ((long) GifPlayer.f10249j));
                        }
                        GifPlayer.this.f10252e.mo20149a(GifPlayer.this.f10250c.mo20171b(this.f10266e));
                        if (this.f10266e < this.f10265d) {
                            sendEmptyMessageDelayed(2, (long) GifPlayer.f10249j);
                        } else {
                            GifPlayer.this.f10251d.set(false);
                            GifPlayer.this.f10252e.mo20147a();
                        }
                        this.f10266e++;
                        return;
                    case 3:
                        GifPlayer.this.f10252e.mo20149a(GifPlayer.this.f10250c.mo20171b(((Integer) message.obj).intValue()));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo20194d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10247a, false, 4171, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f10251d.get();
    }

    /* renamed from: e */
    public void mo20195e() {
        if (!PatchProxy.proxy(new Object[0], this, f10247a, false, 4172, new Class[0], Void.TYPE).isSupported) {
            new C2091a().execute(new Object[0]);
        }
    }

    /* renamed from: com.meizu.media.camera.gif.c$a */
    /* compiled from: GifPlayer */
    private class C2091a extends AsyncTask {

        /* renamed from: a */
        public static ChangeQuickRedirect f10258a;

        public C2091a() {
        }

        public Object doInBackground(Object[] objArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{objArr}, this, f10258a, false, 4174, new Class[]{Object[].class}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            if (!GifPlayer.this.f10257k.get()) {
                return null;
            }
            if (GifPlayer.this.f10255h == 0 && GifPlayer.this.f10256i == GifPlayer.this.mo20188a() - 1) {
                return null;
            }
            GifPlayer.this.f10250c.mo20170a(GifPlayer.this.f10254g, GifPlayer.this.m10489g(), GifPlayer.this.f10255h, GifPlayer.this.f10256i);
            m10500a();
            return null;
        }

        public void onPostExecute(Object obj) {
            if (!PatchProxy.proxy(new Object[]{obj}, this, f10258a, false, 4175, new Class[]{Object.class}, Void.TYPE).isSupported) {
                GifPlayer.this.f10252e.mo20151b();
            }
        }

        /* renamed from: a */
        private void m10500a() {
            if (!PatchProxy.proxy(new Object[0], this, f10258a, false, 4176, new Class[0], Void.TYPE).isSupported) {
                new File(GifPlayer.this.f10254g).delete();
                new File(GifPlayer.this.m10489g()).renameTo(new File(GifPlayer.this.f10254g));
            }
        }
    }

    /* renamed from: com.meizu.media.camera.gif.c$c */
    /* compiled from: GifPlayer */
    private class C2093c extends AsyncTask {

        /* renamed from: a */
        public static ChangeQuickRedirect f10260a;

        private C2093c() {
        }

        public Object doInBackground(Object[] objArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{objArr}, this, f10260a, false, 4177, new Class[]{Object[].class}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            GifPlayer.this.f10250c.mo20169a(objArr[0]);
            return null;
        }

        public void onPostExecute(Object obj) {
            if (!PatchProxy.proxy(new Object[]{obj}, this, f10260a, false, 4178, new Class[]{Object.class}, Void.TYPE).isSupported) {
                int unused = GifPlayer.f10249j = GifPlayer.this.f10250c.mo20167a(1);
                int unused2 = GifPlayer.this.f10256i = GifPlayer.this.mo20188a() - 1;
                GifPlayer.this.mo20193c(0);
                GifPlayer.this.f10252e.mo20153c();
                GifPlayer.this.f10257k.set(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public String m10489g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10247a, false, 4173, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return Storage.m7750a().mo18667m() + "/.temp.gif";
    }
}
