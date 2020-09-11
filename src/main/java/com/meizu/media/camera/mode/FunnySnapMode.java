package com.meizu.media.camera.mode;

import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.hardware.Camera;
import android.location.Location;
import android.net.Uri;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.util.MsgConstants;
import com.mediatek.media.MtkMediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.bean.Sticker;
import com.meizu.media.camera.bean.StickerCategory;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.database.CameraContract;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.p071h.StickerNetworkManager;
import com.meizu.media.camera.p077ui.MzFunnySnapUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NetWorkUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.Constants;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FunnySnapMode extends CameraMode implements StickerNetworkManager.C2118b, MzFunnySnapUI.C2562a, MzFunnySnapUI.C2563b {

    /* renamed from: a */
    public static ChangeQuickRedirect f10568a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10569b = new LogUtil.C2630a("FunnySnapMode");
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final UriMatcher f10570t = new UriMatcher(-1);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MzFunnySnapUI f10571c;

    /* renamed from: d */
    private UsageStatsHelper f10572d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f10573e = new C2158b();

    /* renamed from: f */
    private int f10574f = 1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CameraModeListener f10575g;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public StickerNetworkManager f10576l;

    /* renamed from: m */
    private ConnectionChangeReceiver f10577m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f10578n;

    /* renamed from: o */
    private ContentValues f10579o;

    /* renamed from: p */
    private long f10580p;

    /* renamed from: q */
    private long f10581q = -1;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public FileObserver f10582r = null;

    /* renamed from: s */
    private boolean f10583s = false;

    /* renamed from: u */
    private MediaSaveService.C1639d f10584u = new MediaSaveService.C1639d() {

        /* renamed from: a */
        public static ChangeQuickRedirect f10587a;

        /* renamed from: a */
        public void mo17844a(Uri uri) {
            if (!PatchProxy.proxy(new Object[]{uri}, this, f10587a, false, 4815, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(FunnySnapMode.f10569b, "onMediaSaved");
                if (FunnySnapMode.this.f10787i != null) {
                    FunnySnapMode.this.f10787i.mo17673b(uri);
                    FunnySnapMode.this.f10788j.mo21518a(uri);
                    FunnySnapMode.this.f10575g.mo18122c(true);
                }
            }
        }

        /* renamed from: a */
        public void mo17846a(String str, int i, int i2, byte[] bArr) {
            if (!PatchProxy.proxy(new Object[]{str, new Integer(i), new Integer(i2), bArr}, this, f10587a, false, 4816, new Class[]{String.class, Integer.TYPE, Integer.TYPE, byte[].class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(FunnySnapMode.f10569b, "onGetThumbnail");
            }
        }

        /* renamed from: a */
        public void mo17845a(String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, f10587a, false, 4817, new Class[]{String.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(FunnySnapMode.f10569b, "onFileSaved");
                if (FunnySnapMode.this.f10787i != null) {
                    FunnySnapMode.this.f10787i.mo17670a(str, false);
                }
                FunnySnapMode.this.f10575g.mo18122c(true);
            }
        }

        /* renamed from: a */
        public void mo17847a(List<String> list) {
            if (!PatchProxy.proxy(new Object[]{list}, this, f10587a, false, 4818, new Class[]{List.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(FunnySnapMode.f10569b, "onFilesSaved");
                if (FunnySnapMode.this.f10787i != null) {
                    FunnySnapMode.this.f10787i.mo17671a(list, false);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ContentObserver f10585v = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f10589a;

        public void onChange(boolean z, Uri uri) {
            if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), uri}, this, f10589a, false, 4819, new Class[]{Boolean.TYPE, Uri.class}, Void.TYPE).isSupported) {
                super.onChange(z, uri);
                LogUtil.C2630a N = FunnySnapMode.f10569b;
                LogUtil.m15942a(N, "ContentObserver onChange selfChange:" + z + " uri:" + uri);
                int match = FunnySnapMode.f10570t.match(uri);
                if (match == 1000) {
                    if (FunnySnapMode.this.f10573e != null) {
                        FunnySnapMode.this.f10573e.removeMessages(2);
                        FunnySnapMode.this.f10573e.sendEmptyMessageDelayed(2, 10);
                    }
                } else if (match == 2000) {
                    new AsyncTaskEx<Uri, Void, Void>() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f10591a;

                        /* renamed from: a */
                        public Void mo17658a(Uri... uriArr) {
                            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uriArr}, this, f10591a, false, 4820, new Class[]{Uri[].class}, Void.class);
                            if (proxy.isSupported) {
                                return (Void) proxy.result;
                            }
                            if (FunnySnapMode.this.f10787i == null) {
                                return null;
                            }
                            Cursor query = FunnySnapMode.this.f10787i.getContentResolver().query(uriArr[0], new String[]{"category_id"}, (String) null, (String[]) null, (String) null);
                            while (query.moveToNext()) {
                                for (String replace : query.getString(0).split("\\]\\[")) {
                                    String replace2 = replace.replace(Constants.ARRAY_TYPE, "").replace("]", "");
                                    LogUtil.m15942a(FunnySnapMode.f10569b, "category Id:" + replace2);
                                    FunnySnapMode.this.mo20453a(replace2);
                                }
                            }
                            query.close();
                            return null;
                        }
                    }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Uri[]{uri});
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: w */
    public AsyncQueryHandler f10586w = new AsyncQueryHandler(this.f10787i.getContentResolver()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f10599a;

        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            String str;
            if (!PatchProxy.proxy(new Object[]{new Integer(i), obj, cursor}, this, f10599a, false, 4824, new Class[]{Integer.TYPE, Object.class, Cursor.class}, Void.TYPE).isSupported) {
                super.onQueryComplete(i, obj, cursor);
                switch (i) {
                    case 1001:
                        try {
                            LogUtil.m15942a(FunnySnapMode.f10569b, Thread.currentThread().getName());
                            if (cursor != null) {
                                final ArrayList arrayList = new ArrayList();
                                while (cursor.moveToNext()) {
                                    StickerCategory aVar = new StickerCategory();
                                    aVar.mo19361a(cursor.getInt(cursor.getColumnIndex("category_id")));
                                    aVar.mo19363a(cursor.getString(cursor.getColumnIndex("nameCN")));
                                    aVar.mo19365b(cursor.getString(cursor.getColumnIndex("nameTW")));
                                    aVar.mo19367c(cursor.getString(cursor.getColumnIndex("nameEN")));
                                    aVar.mo19362a(Boolean.valueOf(cursor.getInt(cursor.getColumnIndex("has_update")) == 1));
                                    arrayList.add(aVar);
                                }
                                if (FunnySnapMode.this.f10573e != null) {
                                    FunnySnapMode.this.f10573e.post(new Runnable() {

                                        /* renamed from: a */
                                        public static ChangeQuickRedirect f10601a;

                                        public void run() {
                                            if (!PatchProxy.proxy(new Object[0], this, f10601a, false, 4825, new Class[0], Void.TYPE).isSupported && FunnySnapMode.this.f10571c != null) {
                                                FunnySnapMode.this.f10571c.mo22342a((ArrayList<StickerCategory>) arrayList);
                                            }
                                        }
                                    });
                                }
                            }
                            if (cursor == null) {
                                return;
                            }
                            return;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    case 1002:
                        if (cursor == null) {
                            return;
                        }
                        if (obj == null || !(obj instanceof C2159c)) {
                            LogUtil.m15949b(FunnySnapMode.f10569b, "cookie is not QueryCookie!");
                            return;
                        }
                        C2159c cVar = (C2159c) obj;
                        new ArrayList();
                        if ("download=? OR download=?".equals(cVar.f10627b)) {
                            str = "-1";
                        } else {
                            String str2 = cVar.f10628c[0];
                            str = str2.substring(str2.indexOf(Constants.ARRAY_TYPE) + 1, str2.indexOf("]"));
                        }
                        LogUtil.C2630a N = FunnySnapMode.f10569b;
                        LogUtil.m15942a(N, "count:" + cursor.getCount());
                        FunnySnapMode.this.m10993a(cursor, str);
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: D */
    public void mo20380D() {
    }

    /* renamed from: ae */
    public boolean mo20458ae() {
        return true;
    }

    /* renamed from: c_ */
    public boolean mo20464c_() {
        return true;
    }

    /* renamed from: f */
    public void mo20467f(String str) {
    }

    /* renamed from: t */
    public boolean mo20417t() {
        return false;
    }

    /* renamed from: u */
    public boolean mo20418u() {
        return false;
    }

    /* renamed from: v */
    public boolean mo20419v() {
        return true;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    static {
        f10570t.addURI("com.meizu.flyme.camera", "stickerCategory", 1000);
        f10570t.addURI("com.meizu.flyme.camera", "sticker/*", MsgField.IMSG_SAVE_PICTURE);
    }

    /* renamed from: G */
    public void mo20286G() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4772, new Class[0], Void.TYPE).isSupported) {
            new C2157a(this.f10787i, this).mo22614c((Params[]) new Void[0]);
        }
    }

    /* renamed from: com.meizu.media.camera.mode.FunnySnapMode$b */
    private class C2158b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10624a;

        private C2158b() {
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10624a, false, 4835, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        if (FunnySnapMode.this.f10571c != null) {
                            FunnySnapMode.this.f10571c.mo22337a(FunnySnapMode.this.f10575g.mo18194dR());
                            FunnySnapMode.this.mo20539R().mo18275x(3);
                            FunnySnapMode.this.f10788j.mo21614m(false);
                            return;
                        }
                        return;
                    case 2:
                        FunnySnapMode.this.mo20469r();
                        return;
                    case 3:
                        if (FunnySnapMode.this.f10571c != null) {
                            FunnySnapMode.this.f10571c.mo22363o();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public FunnySnapMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        LogUtil.m15942a(f10569b, "FunnySnapMode");
        this.f10576l = new StickerNetworkManager(cameraActivity);
        if (this.f10571c == null) {
            this.f10571c = mo20539R().mo18267u().mo22121aj();
            this.f10571c.mo22338a(uVar);
            this.f10571c.mo22339a((MzFunnySnapUI.C2562a) this);
            this.f10571c.mo22340a((MzFunnySnapUI.C2563b) this);
        }
        this.f10571c.mo22345b();
        this.f10575g = hVar;
        this.f10572d = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
        if (this.f10577m == null) {
            this.f10577m = new ConnectionChangeReceiver(this.f10787i.getApplicationContext(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        this.f10577m.mo20481a();
        new AsyncTaskEx<Void, Void, Void>() {

            /* renamed from: a */
            public static ChangeQuickRedirect f10593a;

            /* renamed from: a */
            public Void mo17658a(Void... voidArr) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10593a, false, 4821, new Class[]{Void[].class}, Void.class);
                if (proxy.isSupported) {
                    return (Void) proxy.result;
                }
                if (FunnySnapMode.this.f10571c == null) {
                    return null;
                }
                FunnySnapMode.this.f10576l.mo20257a((StickerNetworkManager.C2119c) FunnySnapMode.this.f10571c, (StickerNetworkManager.C2118b) FunnySnapMode.this);
                FunnySnapMode.this.mo20469r();
                return null;
            }
        }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        LogUtil.m15942a(f10569b, "FunnySnapMode end");
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4773, new Class[0], Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10595a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10595a, false, 4822, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    CameraController<T>.e i = CameraController.m8868g().mo19518i();
                    i.post(new Runnable() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f10597a;

                        public void run() {
                            if (!PatchProxy.proxy(new Object[0], this, f10597a, false, 4823, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19516h() == CameraController.CameraApi.API1) {
                                ((Camera) ((CameraProxyV1) CameraController.m8868g().mo19522k()).mo19730a()).setPreviewCallback((Camera.PreviewCallback) null);
                            }
                        }
                    });
                    i.mo19553a();
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
            if (this.f10571c != null) {
                this.f10571c.mo22354f();
            }
        }
    }

    /* renamed from: Z */
    public void mo20451Z() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4774, new Class[0], Void.TYPE).isSupported) {
            super.mo20451Z();
        }
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10568a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4775, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && CameraController.m8868g() != null && CameraController.m8868g().mo19522k() != null) {
            LogUtil.m15942a(f10569b, "afterCameraResume");
            if (this.f10571c != null) {
                this.f10571c.mo22346b(i);
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f10568a, false, 4776, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || this.f10571c == null) {
            return;
        }
        if (z) {
            this.f10571c.mo22343a(true);
        } else if (this.f10788j == null) {
        } else {
            if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
                m10990P();
                this.f10571c.mo22343a(false);
            }
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4777, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10569b, "preview start");
            if (this.f10571c != null) {
                this.f10571c.mo22351d();
            }
            LogUtil.m15942a(f10569b, "preview end");
            if (this.f10571c != null) {
                this.f10571c.mo22353e();
            }
            m10990P();
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4778, new Class[0], Void.TYPE).isSupported) {
            super.mo20408l();
            mo20402f_();
        }
    }

    /* renamed from: P */
    private void m10990P() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4779, new Class[0], Void.TYPE).isSupported) {
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                mo20542U().mo21592g(MzUIController.f12304z);
                mo20542U().mo21506a((int) MsgConstants.SLAM_START_FROM_LUA);
            } else {
                mo20542U().mo21592g(MzUIController.f12273A);
                mo20542U().mo21506a(MzUIController.f12287i);
            }
            mo20542U().mo21580d(2, (int) R.drawable.mz_btn_shutter_default);
            mo20542U().mo21593g(false);
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.FUNNY_SNAP;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4780, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10569b, "release start");
            if (this.f10577m != null) {
                this.f10577m.mo20482b();
            }
            this.f10586w.cancelOperation(1001);
            this.f10586w.cancelOperation(1002);
            this.f10571c.mo22356h();
            this.f10571c = null;
            mo20468q();
            if (this.f10576l != null) {
                this.f10576l.mo20266c();
                this.f10576l.mo20257a((StickerNetworkManager.C2119c) null, (StickerNetworkManager.C2118b) null);
                this.f10576l = null;
            }
            if (this.f10573e != null) {
                this.f10573e.removeCallbacksAndMessages((Object) null);
                this.f10573e = null;
            }
            this.f10578n = false;
            if (this.f10788j != null) {
                this.f10788j.mo21533a(true, false, false);
            }
            LogUtil.m15942a(f10569b, "release end");
        }
    }

    /* renamed from: k_ */
    public void mo20407k_() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4781, new Class[0], Void.TYPE).isSupported && this.f10571c != null) {
            this.f10571c.mo22375t();
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4782, new Class[0], Void.TYPE).isSupported) {
            mo20468q();
            if (this.f10571c != null) {
                if (this.f10573e != null) {
                    this.f10573e.removeMessages(3);
                }
                this.f10571c.mo22376u();
            }
            if (this.f10577m != null) {
                this.f10577m.mo20482b();
            }
            if (this.f10576l != null) {
                this.f10576l.mo20254a();
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4783, new Class[0], Void.TYPE).isSupported) {
            mo20461c();
            if (this.f10571c != null) {
                if (!this.f10571c.mo22358j()) {
                    mo20402f_();
                }
                this.f10571c.mo22374s();
            }
            if (this.f10576l != null) {
                this.f10576l.mo20264b();
            }
            if (this.f10577m != null) {
                this.f10577m.mo20481a();
            }
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4784, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10571c != null && this.f10571c.mo22372q()) {
            mo20542U().mo21581d(4, false);
        }
        return false;
    }

    /* renamed from: X */
    public void mo20449X() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4785, new Class[0], Void.TYPE).isSupported && this.f10571c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String a = Storage.m7750a().mo18620a((Context) this.f10787i, currentTimeMillis);
            String str = a + ".mp4";
            String i = Storage.m7750a().mo18660i(str);
            File file = new File(Storage.m7750a().mo18665l());
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f10571c.mo22349c(i);
            if (this.f10573e != null) {
                this.f10573e.removeMessages(3);
                this.f10573e.sendEmptyMessageDelayed(3, 10000);
            }
            this.f10579o = new ContentValues(9);
            this.f10579o.put(PushConstants.TITLE, a);
            this.f10579o.put("_display_name", str);
            this.f10579o.put("datetaken", Long.valueOf(currentTimeMillis));
            this.f10579o.put("date_modified", Long.valueOf(currentTimeMillis / 1000));
            this.f10579o.put("mime_type", "video/mp4");
            this.f10579o.put("_data", i);
            this.f10579o.put("resolution", this.f10571c.mo22332C() + "x" + this.f10571c.mo22331B());
            if ((((this.f10575g.mo18194dR() != -1 ? CameraUtil.m15882c(this.f10575g.mo18211di(), this.f10575g.mo18194dR()) : 0) / 90) & 1) == 1) {
                this.f10579o.put(MtkMediaStore.VideoColumns.ORIENTATION, 90);
            } else {
                this.f10579o.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
            }
            Location a2 = this.f10575g.mo18192dP().mo19017a(currentTimeMillis);
            if (a2 != null) {
                this.f10579o.put(Parameters.LATITUDE, Double.valueOf(a2.getLatitude()));
                this.f10579o.put(Parameters.LONGITUDE, Double.valueOf(a2.getLongitude()));
            }
            this.f10580p = SystemClock.uptimeMillis();
            if (this.f10581q == -1) {
                this.f10581q = currentTimeMillis;
                mo20539R().mo18175d(this.f10581q);
            }
        }
    }

    /* renamed from: Y */
    public void mo20450Y() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4786, new Class[0], Void.TYPE).isSupported && this.f10571c != null) {
            if (this.f10573e != null) {
                this.f10573e.removeMessages(3);
                if (SystemClock.uptimeMillis() - this.f10580p < 150) {
                    this.f10573e.sendEmptyMessageDelayed(3, 150);
                    return;
                }
            }
            this.f10571c.mo22363o();
        }
    }

    /* renamed from: c */
    public void mo20463c(boolean z) {
        this.f10583s = z;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f10568a, false, 4787, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10571c == null || !this.f10571c.mo22372q()) {
            if (this.f10573e != null) {
                if (this.f10571c == null || !this.f10583s) {
                    this.f10573e.sendEmptyMessageDelayed(1, 350);
                } else {
                    mo20542U().mo21478B(true);
                    this.f10573e.sendEmptyMessageDelayed(1, (long) DeviceHelper.f14044n);
                }
            }
            return true;
        }
        GlobalParams.BOOLEAN_WATERMARK = this.f10571c.mo22371p();
        return false;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4788, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if (this.f10575g.mo18211di() == 1) {
            return CameraController.FocusMode.FIXED;
        }
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: ab */
    public void mo20457ab() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4789, new Class[0], Void.TYPE).isSupported) {
            mo20461c();
        }
    }

    /* renamed from: I */
    public void mo20384I() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4790, new Class[0], Void.TYPE).isSupported) {
            m10992a(0);
        }
    }

    /* renamed from: a */
    private void m10992a(long j) {
        String str;
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f10568a, false, 4791, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            Map<String, String> a = this.f10572d.mo22688a(new String[]{"mode", "is_back_camera", "capture_type", "mirror", "count_down", "funny_mark", "sd_card"});
            a.put("capture_time", Long.toString(this.f10575g.mo18186dJ()));
            a.put("sticker_id", this.f10571c != null ? this.f10571c.mo22378w() : "null");
            a.put("funny_whiten_skin_level", this.f10571c != null ? Integer.toString(this.f10571c.mo22379x()) : "null");
            a.put("funny_thin_face_level", this.f10571c != null ? Integer.toString(this.f10571c.mo22380y()) : "null");
            a.put("funny_filter", this.f10571c != null ? this.f10571c.mo22334E() : "null");
            a.put("funny_hd_on", (this.f10571c == null || !this.f10571c.mo22372q()) ? "0" : "1");
            if (this.f10575g.mo18211di() == 0) {
                a.put("flash", CameraController.m8868g().mo19534q().key);
            }
            a.put("funny_video_duration", Long.toString(j));
            Point j2 = CameraController.m8868g().mo19520j();
            if (j2 == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j2.x + "x" + j2.y);
            }
            a.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f10575g.mo17914ak() == null || (ak = this.f10575g.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str2 = h.getKey();
            }
            a.put("focus_mode", str2);
            this.f10572d.mo22693a("capture_info", a);
        }
    }

    /* renamed from: c */
    public void mo20461c() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4792, new Class[0], Void.TYPE).isSupported) {
            try {
                this.f10574f = Settings.System.getInt(mo20540S().getContentResolver(), "cpu_l");
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
            LogUtil.C2630a aVar = f10569b;
            StringBuilder sb = new StringBuilder();
            sb.append("current cpu performance mode : ");
            sb.append(this.f10574f);
            sb.append(". (high - ");
            sb.append(0);
            sb.append(", low - ");
            boolean z = true;
            sb.append(1);
            sb.append(")");
            LogUtil.m15942a(aVar, sb.toString());
            if (this.f10574f != 0) {
                z = Settings.System.putInt(mo20540S().getContentResolver(), "cpu_l", 0);
            }
            LogUtil.C2630a aVar2 = f10569b;
            LogUtil.m15942a(aVar2, "Setting high performance mode(status : " + z + ")");
        }
    }

    /* renamed from: q */
    public void mo20468q() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4793, new Class[0], Void.TYPE).isSupported) {
            boolean putInt = Settings.System.putInt(mo20540S().getContentResolver(), "cpu_l", this.f10574f);
            LogUtil.C2630a aVar = f10569b;
            LogUtil.m15942a(aVar, "Setting cpu run in recorded performance mode(status : " + putInt + ")");
            LogUtil.C2630a aVar2 = f10569b;
            LogUtil.m15942a(aVar2, "current cpu performance mode : " + this.f10574f + ". (high - " + 0 + ", low - " + 1 + ")");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10993a(final Cursor cursor, final String str) {
        if (!PatchProxy.proxy(new Object[]{cursor, str}, this, f10568a, false, 4794, new Class[]{Cursor.class, String.class}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Cursor, Void, ArrayList<Sticker>>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10604a;

                /* renamed from: a */
                public ArrayList<Sticker> mo17658a(Cursor... cursorArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cursorArr}, this, f10604a, false, 4826, new Class[]{Cursor[].class}, ArrayList.class);
                    if (proxy.isSupported) {
                        return (ArrayList) proxy.result;
                    }
                    ArrayList<Sticker> arrayList = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        Sticker sticker = new Sticker();
                        sticker.mo19343a(cursor.getInt(cursor.getColumnIndex("sticker_id")));
                        byte[] blob = cursor.getBlob(cursor.getColumnIndex("icon"));
                        if (blob != null) {
                            sticker.mo19344a(BitmapFactory.decodeByteArray(blob, 0, blob.length));
                        }
                        sticker.mo19353c(cursor.getString(cursor.getColumnIndex("cp")));
                        sticker.mo19346a(cursor.getString(cursor.getColumnIndex("icon_url")));
                        sticker.mo19349b(cursor.getInt(cursor.getColumnIndex("size")));
                        sticker.mo19350b(cursor.getString(cursor.getColumnIndex("md5")));
                        sticker.mo19347a(cursor.getInt(cursor.getColumnIndex("has_music")) == 1);
                        switch (cursor.getInt(cursor.getColumnIndex("download"))) {
                            case 1:
                                sticker.mo19345a(Sticker.DownloadState.DOWNLOADING);
                                break;
                            case 2:
                                sticker.mo19345a(Sticker.DownloadState.DOWNLOADED);
                                break;
                            case 3:
                                sticker.mo19345a(Sticker.DownloadState.DOWNLOAD_FAILED);
                                break;
                            case 4:
                                sticker.mo19345a(Sticker.DownloadState.DOWNLOADING);
                                break;
                            default:
                                sticker.mo19345a(Sticker.DownloadState.NOT_DOWNLOAD);
                                break;
                        }
                        sticker.mo19351b(cursor.getInt(cursor.getColumnIndex("is_fake")) == 1);
                        arrayList.add(sticker);
                    }
                    return arrayList;
                }

                /* renamed from: a */
                public void mo17660a(ArrayList<Sticker> arrayList) {
                    if (!PatchProxy.proxy(new Object[]{arrayList}, this, f10604a, false, 4827, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (FunnySnapMode.this.f10571c != null) {
                            FunnySnapMode.this.f10571c.mo22341a(str, arrayList);
                        }
                    }
                }
            }.mo22614c((Params[]) new Cursor[]{cursor});
        }
    }

    /* renamed from: r */
    public void mo20469r() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4795, new Class[0], Void.TYPE).isSupported) {
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10608a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10608a, false, 4828, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    if (FunnySnapMode.this.f10586w == null) {
                        return null;
                    }
                    FunnySnapMode.this.f10586w.startQuery(1001, (Object) null, CameraContract.C2037c.f9493a, (String[]) null, (String) null, (String[]) null, (String) null);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: a */
    public void mo20453a(String str) {
        String[] strArr;
        String str2;
        String str3;
        if (!PatchProxy.proxy(new Object[]{str}, this, f10568a, false, 4796, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10569b;
            LogUtil.m15942a(aVar, "categoryId:" + str);
            if ("-1".equals(str)) {
                strArr = new String[]{String.valueOf(2), String.valueOf(4)};
                str3 = "download=? OR download=?";
                str2 = "download_time DESC";
            } else {
                strArr = new String[]{"%[" + str + "]%"};
                str2 = "1".equals(str) ? "hot_order ASC" : "stick_order ASC";
                str3 = "category_id LIKE ?";
            }
            String[] strArr2 = strArr;
            C2159c cVar = new C2159c();
            cVar.f10626a = null;
            cVar.f10627b = str3;
            cVar.f10628c = strArr2;
            cVar.f10629d = str2;
            this.f10586w.startQuery(1002, cVar, CameraContract.C2036b.f9492a, (String[]) null, str3, strArr2, str2);
        }
    }

    /* renamed from: com.meizu.media.camera.mode.FunnySnapMode$c */
    private class C2159c {

        /* renamed from: a */
        String[] f10626a;

        /* renamed from: b */
        String f10627b;

        /* renamed from: c */
        String[] f10628c;

        /* renamed from: d */
        String f10629d;

        private C2159c() {
        }
    }

    /* renamed from: b */
    public void mo20460b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10568a, false, 4797, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f10576l.mo20258a(str);
        }
    }

    /* renamed from: c */
    public void mo20462c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10568a, false, 4798, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f10576l.mo20265b(str);
        }
    }

    /* renamed from: a */
    public void mo20455a(String str, String str2, int i, boolean z) {
        Object[] objArr = {str, str2, new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10568a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4799, new Class[]{String.class, String.class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f10576l.mo20260a(str, str2, i, z, true);
        }
    }

    /* renamed from: d */
    public void mo20465d(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10568a, false, 4800, new Class[]{String.class}, Void.TYPE).isSupported) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("used", 1);
            if (this.f10787i != null) {
                this.f10787i.getContentResolver().update(ContentUris.withAppendedId(CameraContract.C2036b.f9492a, Long.parseLong(str)), contentValues, (String) null, (String[]) null);
            }
        }
    }

    /* renamed from: a */
    public void mo20456a(String str, boolean z) {
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f10568a, false, 4801, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("has_update", Integer.valueOf(z ? 1 : 0));
            contentValues.put("notify_change", false);
            if (this.f10787i != null) {
                this.f10787i.getContentResolver().update(CameraContract.C2037c.f9493a, contentValues, "category_id=?", new String[]{str});
            }
        }
    }

    /* renamed from: a */
    public void mo20454a(String str, int i) {
        if (!PatchProxy.proxy(new Object[]{str, new Integer(i)}, this, f10568a, false, 4802, new Class[]{String.class, Integer.TYPE}, Void.TYPE).isSupported) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("download", Integer.valueOf(i));
            if (this.f10787i != null) {
                this.f10787i.getContentResolver().update(CameraContract.C2036b.f9492a, contentValues, "sticker_id=?", new String[]{str});
            }
        }
    }

    /* renamed from: B */
    public int mo20445B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4803, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f10576l.mo20269e();
    }

    /* renamed from: K */
    public boolean mo20446K() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4804, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f10576l.mo20270f();
    }

    /* renamed from: b */
    public void mo20459b(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f10568a, false, 4805, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            long dJ = this.f10575g.mo18186dJ();
            LogUtil.C2630a aVar = f10569b;
            LogUtil.m15942a(aVar, "mListener.getOrientation():" + this.f10575g.mo18194dR());
            if (this.f10787i != null) {
                this.f10787i.mo17689p().mo17828a(bitmap, CameraUtil.m15831a(dJ), dJ, this.f10575g.mo18192dP().mo19017a(dJ), bitmap.getWidth(), bitmap.getHeight(), 0, (ExifInterface) null, this.f10584u, this.f10787i.getContentResolver(), this.f10575g.mo18211di() == 1, false, (String) null, false, CameraModeType.ModeType.FUNNY_SNAP);
                this.f10788j.mo21517a(bitmap, (byte[]) null, (String) null, 0, 0, this.f10575g.mo18211di() == 1, bitmap.getWidth(), bitmap.getHeight(), this.f10575g.mo18200dX());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20466e(java.lang.String r22) {
        /*
            r21 = this;
            r8 = r21
            r0 = r22
            r9 = 1
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r10 = 0
            r1[r10] = r0
            com.meizu.savior.ChangeQuickRedirect r3 = f10568a
            java.lang.Class[] r6 = new java.lang.Class[r9]
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r6[r10] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4806(0x12c6, float:6.735E-42)
            r2 = r21
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            long r1 = android.os.SystemClock.uptimeMillis()
            long r3 = r8.f10580p
            long r1 = r1 - r3
            com.meizu.media.camera.ui.p r3 = r8.f10571c
            android.graphics.Bitmap r3 = r3.mo22373r()
            if (r3 != 0) goto L_0x0037
            com.meizu.media.camera.ui.p r3 = r8.f10571c
            android.graphics.Bitmap r3 = r3.mo22335a((int) r10, (int) r10)
        L_0x0037:
            r12 = r3
            com.meizu.media.camera.u r11 = r8.f10788j
            r13 = 0
            r14 = 0
            r15 = 0
            int r16 = r21.mo20447L()
            com.meizu.media.camera.mode.h r3 = r8.f10575g
            int r3 = r3.mo18211di()
            if (r3 != r9) goto L_0x004c
            r17 = 1
            goto L_0x004e
        L_0x004c:
            r17 = 0
        L_0x004e:
            int r18 = r12.getWidth()
            int r19 = r12.getHeight()
            com.meizu.media.camera.mode.h r3 = r8.f10575g
            boolean r20 = r3.mo18200dX()
            r11.mo21517a(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            android.content.ContentValues r3 = r8.f10579o
            java.lang.String r4 = "_size"
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            long r5 = r5.length()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3.put(r4, r5)
            android.content.ContentValues r3 = r8.f10579o
            java.lang.String r4 = "duration"
            java.lang.Long r5 = java.lang.Long.valueOf(r1)
            r3.put(r4, r5)
            com.meizu.media.camera.CameraActivity r3 = r8.f10787i
            android.content.ContentResolver r3 = r3.getContentResolver()
            r4 = 0
            java.lang.String r5 = "content://media/external/video/media"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00d3, all -> 0x00d0 }
            android.content.ContentValues r6 = r8.f10579o     // Catch:{ Exception -> 0x00d3, all -> 0x00d0 }
            android.net.Uri r5 = r3.insert(r5, r6)     // Catch:{ Exception -> 0x00d3, all -> 0x00d0 }
            android.content.ContentValues r6 = r8.f10579o     // Catch:{ Exception -> 0x00ce }
            java.lang.String r7 = "_size"
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x00ce }
            r11.<init>(r0)     // Catch:{ Exception -> 0x00ce }
            long r11 = r11.length()     // Catch:{ Exception -> 0x00ce }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x00ce }
            r6.put(r7, r11)     // Catch:{ Exception -> 0x00ce }
            android.content.ContentValues r6 = r8.f10579o     // Catch:{ Exception -> 0x00ce }
            r3.update(r5, r6, r4, r4)     // Catch:{ Exception -> 0x00ce }
            r8.m10995a((java.lang.String) r0, (android.net.Uri) r5)     // Catch:{ Exception -> 0x00ce }
            com.meizu.media.camera.CameraActivity r3 = r8.f10787i     // Catch:{ Exception -> 0x00ce }
            if (r3 == 0) goto L_0x00b6
            com.meizu.media.camera.CameraActivity r3 = r8.f10787i     // Catch:{ Exception -> 0x00ce }
            r3.mo17670a((java.lang.String) r0, (boolean) r9)     // Catch:{ Exception -> 0x00ce }
        L_0x00b6:
            com.meizu.media.camera.util.ac$a r0 = f10569b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Current video URI: "
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)
            r4 = r5
            goto L_0x00f2
        L_0x00ce:
            r0 = move-exception
            goto L_0x00d5
        L_0x00d0:
            r0 = move-exception
            r5 = r4
            goto L_0x010e
        L_0x00d3:
            r0 = move-exception
            r5 = r4
        L_0x00d5:
            com.meizu.media.camera.util.ac$a r3 = f10569b     // Catch:{ all -> 0x010d }
            java.lang.String r6 = "failed to add video to media store"
            com.meizu.media.camera.util.LogUtil.m15950b(r3, r6, r0)     // Catch:{ all -> 0x010d }
            com.meizu.media.camera.util.ac$a r0 = f10569b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Current video URI: "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)
        L_0x00f2:
            r8.m10992a((long) r1)
            com.meizu.media.camera.CameraActivity r0 = r8.f10787i
            if (r0 == 0) goto L_0x010c
            com.meizu.media.camera.CameraActivity r0 = r8.f10787i
            r0.mo17673b((android.net.Uri) r4)
            com.meizu.media.camera.u r0 = r8.f10788j
            r0.mo21518a((android.net.Uri) r4)
            com.meizu.media.camera.mode.h r0 = r8.f10575g
            boolean[] r1 = new boolean[r9]
            r1[r10] = r9
            r0.mo18122c(r1)
        L_0x010c:
            return
        L_0x010d:
            r0 = move-exception
        L_0x010e:
            com.meizu.media.camera.util.ac$a r1 = f10569b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Current video URI: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.FunnySnapMode.mo20466e(java.lang.String):void");
    }

    /* renamed from: a */
    private void m10995a(String str, Uri uri) {
        Class[] clsArr = {String.class, Uri.class};
        if (!PatchProxy.proxy(new Object[]{str, uri}, this, f10568a, false, 4807, clsArr, Void.TYPE).isSupported) {
            if (this.f10582r != null) {
                this.f10582r.stopWatching();
                this.f10582r = null;
            }
            final String str2 = str;
            final Uri uri2 = uri;
            this.f10582r = new FileObserver(str, 8) {

                /* renamed from: a */
                public static ChangeQuickRedirect f10610a;

                public void onEvent(int i, @Nullable String str) {
                    Object[] objArr = {new Integer(i), str};
                    ChangeQuickRedirect changeQuickRedirect = f10610a;
                    if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4829, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported && i == 8) {
                        if (FunnySnapMode.this.f10582r != null) {
                            FunnySnapMode.this.f10582r.stopWatching();
                        }
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_size", Long.valueOf(new File(str2).length()));
                            if (FunnySnapMode.this.f10787i != null) {
                                FunnySnapMode.this.f10787i.getContentResolver().update(uri2, contentValues, (String) null, (String[]) null);
                                CameraUtil.m15845a(FunnySnapMode.this.f10787i.getApplicationContext(), str2);
                            }
                        } catch (Exception e) {
                            LogUtil.C2630a N = FunnySnapMode.f10569b;
                            LogUtil.m15949b(N, "funnyVideo observer err: " + e.getMessage());
                        }
                    }
                }
            };
            this.f10582r.startWatching();
        }
    }

    /* renamed from: L */
    public int mo20447L() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4808, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f10575g.mo18194dR();
    }

    /* renamed from: M */
    public boolean mo20448M() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4809, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10787i == null || this.f10787i.mo17677n();
    }

    private class ConnectionChangeReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public static ChangeQuickRedirect f10614a;

        /* renamed from: c */
        private boolean f10616c = false;

        /* renamed from: d */
        private Context f10617d;

        /* renamed from: e */
        private IntentFilter f10618e;

        public ConnectionChangeReceiver(Context context, IntentFilter intentFilter) {
            this.f10617d = context;
            this.f10618e = intentFilter;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo20481a() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x006e }
                com.meizu.savior.ChangeQuickRedirect r3 = f10614a     // Catch:{ all -> 0x006e }
                r4 = 0
                r5 = 4831(0x12df, float:6.77E-42)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x006e }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x006e }
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006e }
                boolean r1 = r1.isSupported     // Catch:{ all -> 0x006e }
                if (r1 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                boolean r1 = r8.f10616c     // Catch:{ all -> 0x006e }
                if (r1 != 0) goto L_0x006c
                android.content.Context r1 = r8.f10617d     // Catch:{ all -> 0x006e }
                android.content.IntentFilter r2 = r8.f10618e     // Catch:{ all -> 0x006e }
                r1.registerReceiver(r8, r2)     // Catch:{ all -> 0x006e }
                android.content.Context r1 = r8.f10617d     // Catch:{ all -> 0x006e }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x006e }
                android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2036b.f9492a     // Catch:{ all -> 0x006e }
                com.meizu.media.camera.mode.FunnySnapMode r3 = com.meizu.media.camera.mode.FunnySnapMode.this     // Catch:{ all -> 0x006e }
                android.database.ContentObserver r3 = r3.f10585v     // Catch:{ all -> 0x006e }
                r4 = 1
                r1.registerContentObserver(r2, r4, r3)     // Catch:{ all -> 0x006e }
                android.content.Context r1 = r8.f10617d     // Catch:{ all -> 0x006e }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x006e }
                android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2037c.f9493a     // Catch:{ all -> 0x006e }
                com.meizu.media.camera.mode.FunnySnapMode r3 = com.meizu.media.camera.mode.FunnySnapMode.this     // Catch:{ all -> 0x006e }
                android.database.ContentObserver r3 = r3.f10585v     // Catch:{ all -> 0x006e }
                r1.registerContentObserver(r2, r4, r3)     // Catch:{ all -> 0x006e }
                com.meizu.media.camera.mode.FunnySnapMode r1 = com.meizu.media.camera.mode.FunnySnapMode.this     // Catch:{ all -> 0x006e }
                boolean r1 = r1.f10578n     // Catch:{ all -> 0x006e }
                if (r1 == 0) goto L_0x006a
                android.content.Context r1 = r8.f10617d     // Catch:{ all -> 0x006e }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x006e }
                android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2036b.f9492a     // Catch:{ all -> 0x006e }
                r3 = 0
                r1.notifyChange(r2, r3)     // Catch:{ all -> 0x006e }
                android.content.Context r1 = r8.f10617d     // Catch:{ all -> 0x006e }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x006e }
                android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2037c.f9493a     // Catch:{ all -> 0x006e }
                r1.notifyChange(r2, r3)     // Catch:{ all -> 0x006e }
                com.meizu.media.camera.mode.FunnySnapMode r1 = com.meizu.media.camera.mode.FunnySnapMode.this     // Catch:{ all -> 0x006e }
                boolean unused = r1.f10578n = r0     // Catch:{ all -> 0x006e }
            L_0x006a:
                r8.f10616c = r4     // Catch:{ all -> 0x006e }
            L_0x006c:
                monitor-exit(r8)
                return
            L_0x006e:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.FunnySnapMode.ConnectionChangeReceiver.mo20481a():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
            return;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo20482b() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0034 }
                com.meizu.savior.ChangeQuickRedirect r3 = f10614a     // Catch:{ all -> 0x0034 }
                r4 = 0
                r5 = 4832(0x12e0, float:6.771E-42)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0034 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0034 }
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0034 }
                boolean r1 = r1.isSupported     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                boolean r1 = r8.f10616c     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0032
                android.content.Context r1 = r8.f10617d     // Catch:{ all -> 0x0034 }
                r1.unregisterReceiver(r8)     // Catch:{ all -> 0x0034 }
                android.content.Context r1 = r8.f10617d     // Catch:{ all -> 0x0034 }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0034 }
                com.meizu.media.camera.mode.FunnySnapMode r2 = com.meizu.media.camera.mode.FunnySnapMode.this     // Catch:{ all -> 0x0034 }
                android.database.ContentObserver r2 = r2.f10585v     // Catch:{ all -> 0x0034 }
                r1.unregisterContentObserver(r2)     // Catch:{ all -> 0x0034 }
                r8.f10616c = r0     // Catch:{ all -> 0x0034 }
            L_0x0032:
                monitor-exit(r8)
                return
            L_0x0034:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.FunnySnapMode.ConnectionChangeReceiver.mo20482b():void");
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = true;
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f10614a, false, 4833, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                int a = NetWorkUtils.m15976a(context);
                if (a != 7) {
                    switch (a) {
                        case 0:
                            LogUtil.m15942a(FunnySnapMode.f10569b, "MOBILE NETWORK CONNECTED");
                            break;
                        case 1:
                            LogUtil.m15942a(FunnySnapMode.f10569b, "Wi-Fi CONNECTED");
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    LogUtil.m15942a(FunnySnapMode.f10569b, "BLUETOOTH NETWORK CONNECTED");
                }
                if (z && FunnySnapMode.this.f10573e != null) {
                    FunnySnapMode.this.f10573e.postDelayed(new Runnable() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f10619a;

                        public void run() {
                            if (!PatchProxy.proxy(new Object[0], this, f10619a, false, 4834, new Class[0], Void.TYPE).isSupported && FunnySnapMode.this.f10576l != null) {
                                FunnySnapMode.this.f10576l.mo20268d();
                            }
                        }
                    }, 500);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20452a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f10568a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4810, new Class[]{Float.TYPE}, Void.TYPE).isSupported && this.f10571c != null) {
            this.f10571c.mo22336a(f);
        }
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4811, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f10571c != null) {
            arrayList.add(this.f10571c.mo22381z());
        }
        return arrayList;
    }

    /* renamed from: com.meizu.media.camera.mode.FunnySnapMode$a */
    private static class C2157a extends AsyncTaskEx<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f10621a;

        /* renamed from: b */
        private final WeakReference<FunnySnapMode> f10622b;

        /* renamed from: c */
        private Context f10623c;

        public C2157a(Context context, FunnySnapMode funnySnapMode) {
            this.f10623c = context.getApplicationContext();
            this.f10622b = new WeakReference<>(funnySnapMode);
        }

        /* renamed from: a */
        public Void mo17658a(Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10621a, false, 4830, new Class[]{Void[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            FunnySnapMode funnySnapMode = (FunnySnapMode) this.f10622b.get();
            ContentValues contentValues = new ContentValues();
            contentValues.put("notify_change", false);
            contentValues.put("download", Integer.valueOf(Sticker.DownloadState.NOT_DOWNLOAD.ordinal()));
            int update = this.f10623c.getApplicationContext().getContentResolver().update(CameraContract.C2036b.f9492a, contentValues, "download=? OR download=?", new String[]{String.valueOf(1), String.valueOf(3)});
            if (update > 0 && funnySnapMode != null) {
                boolean unused = funnySnapMode.f10578n = true;
            }
            LogUtil.C2630a N = FunnySnapMode.f10569b;
            LogUtil.m15952c(N, "CleanStickerDownloadStateTask finish :" + update);
            return null;
        }
    }

    /* renamed from: H */
    public void mo20383H() {
        if (!PatchProxy.proxy(new Object[0], this, f10568a, false, 4812, new Class[0], Void.TYPE).isSupported && this.f10571c != null) {
            this.f10571c.mo22330A();
        }
    }

    /* renamed from: p */
    public boolean mo20413p() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10568a, false, 4813, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10571c != null) {
            return this.f10571c.mo22333D();
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m11003g(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f10568a, true, 4814, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "meizu.intent.action.FUNNY_CAM".equals(str);
    }
}
