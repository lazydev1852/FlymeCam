package com.meizu.media.camera.mode;

import android.annotation.SuppressLint;
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
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.mediatek.media.MtkMediaStore;
import com.mediatek.util.MtkPatterns;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.bean.ARSticker;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.database.CameraContract;
import com.meizu.media.camera.mode.ARMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.p071h.StickerNetworkManager;
import com.meizu.media.camera.p077ui.MzARUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.FormatUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NetWorkUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.util.XmpUtilHelper;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.Constants;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ARMode extends CameraMode implements StickerNetworkManager.C2118b, MzARUI.C2457a, MzARUI.C2458b, MzFocusRenderer.C2745d {

    /* renamed from: a */
    public static ChangeQuickRedirect f10522a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10523b = new LogUtil.C2630a("ARMode");
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static final UriMatcher f10524s = new UriMatcher(-1);

    /* renamed from: c */
    private CameraModeListener f10525c;

    /* renamed from: d */
    private UsageStatsHelper f10526d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MzARUI f10527e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public StickerNetworkManager f10528f;

    /* renamed from: g */
    private ConnectionChangeReceiver f10529g;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C2143a f10530l = new C2143a();

    /* renamed from: m */
    private long f10531m;

    /* renamed from: n */
    private long f10532n = -1;

    /* renamed from: o */
    private ContentValues f10533o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f10534p;

    /* renamed from: q */
    private boolean f10535q = false;

    /* renamed from: r */
    private boolean f10536r = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ContentObserver f10537t = new ContentObserver(new Handler()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f10539a;

        public void onChange(boolean z, Uri uri) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0), uri};
            ChangeQuickRedirect changeQuickRedirect = f10539a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4544, new Class[]{Boolean.TYPE, Uri.class}, Void.TYPE).isSupported) {
                super.onChange(z, uri);
                LogUtil.C2630a K = ARMode.f10523b;
                LogUtil.m15942a(K, "ContentObserver onChange selfChange:" + z + " uri:" + uri);
                if (ARMode.f10524s.match(uri) == 4000 && ARMode.this.f10530l != null) {
                    ARMode.this.f10530l.removeMessages(2);
                    ARMode.this.f10530l.sendEmptyMessageDelayed(2, 10);
                }
            }
        }
    };
    @SuppressLint({"HandlerLeak"})

    /* renamed from: u */
    private AsyncQueryHandler f10538u = new AsyncQueryHandler(this.f10787i.getContentResolver()) {

        /* renamed from: a */
        public static ChangeQuickRedirect f10541a;

        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            Object[] objArr = {new Integer(i), obj, cursor};
            ChangeQuickRedirect changeQuickRedirect = f10541a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4545, new Class[]{Integer.TYPE, Object.class, Cursor.class}, Void.TYPE).isSupported) {
                super.onQueryComplete(i, obj, cursor);
                if (cursor != null) {
                    ARMode.this.m10878a(cursor);
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

    /* renamed from: E */
    public void mo20381E() {
    }

    /* renamed from: m */
    public boolean mo20410m() {
        return false;
    }

    /* renamed from: n */
    public boolean mo20411n() {
        return false;
    }

    /* renamed from: p */
    public boolean mo20413p() {
        return true;
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
        return false;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    static {
        f10524s.addURI("com.meizu.flyme.camera", "arSticker", 4000);
    }

    ARMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        this.f10528f = new StickerNetworkManager(cameraActivity);
        if (this.f10529g == null) {
            this.f10529g = new ConnectionChangeReceiver(this.f10787i.getApplicationContext(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        this.f10529g.mo20428a();
        if (this.f10527e == null) {
            this.f10527e = mo20539R().mo18267u().mo22124am();
            this.f10527e.mo21936a(uVar);
            this.f10527e.mo21937a((MzARUI.C2457a) this);
            this.f10527e.mo21938a((MzARUI.C2458b) this);
        }
        uVar.mo21589f(true);
        this.f10528f.mo20256a((StickerNetworkManager.C2117a) this.f10527e, (StickerNetworkManager.C2118b) this);
        this.f10525c = hVar;
        this.f10526d = UsageStatsHelper.m16042a(cameraActivity.getApplicationContext());
    }

    /* renamed from: a */
    public void mo20387a(MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f10522a, false, 4498, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            super.mo20387a(uVar);
        }
    }

    /* renamed from: a_ */
    public void mo20395a_() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4499, new Class[0], Void.TYPE).isSupported) {
            mo20542U().mo21506a(2560);
            mo20542U().mo21581d(4, true);
        }
    }

    /* renamed from: com.meizu.media.camera.mode.ARMode$a */
    private class C2143a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f10551a;

        private C2143a() {
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f10551a, false, 4548, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        ARMode.this.m10873M();
                        return;
                    case 2:
                        ARMode.this.mo20397b_();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: b_ */
    public void mo20397b_() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4500, new Class[0], Void.TYPE).isSupported) {
            this.f10538u.startQuery(1003, (Object) null, CameraContract.C2035a.f9491a, (String[]) null, (String) null, (String[]) null, (String) null);
        }
    }

    /* renamed from: a */
    public void mo20388a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10522a, false, 4501, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f10538u.startQuery(1004, (Object) null, CameraContract.C2035a.f9491a, (String[]) null, "sticker_id=?", new String[]{str}, (String) null);
        }
    }

    /* renamed from: c */
    public void mo20398c() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4502, new Class[0], Void.TYPE).isSupported) {
            this.f10528f.mo20272h();
        }
    }

    /* renamed from: a */
    public void mo20389a(String str, int i) {
        if (!PatchProxy.proxy(new Object[]{str, new Integer(i)}, this, f10522a, false, 4503, new Class[]{String.class, Integer.TYPE}, Void.TYPE).isSupported) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("download", Integer.valueOf(i));
            if (this.f10787i != null) {
                this.f10787i.getContentResolver().update(CameraContract.C2035a.f9491a, contentValues, "sticker_id=?", new String[]{str});
            }
        }
    }

    /* renamed from: b */
    public void mo20396b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10522a, false, 4504, new Class[]{String.class}, Void.TYPE).isSupported) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("used", 1);
            if (this.f10787i != null) {
                this.f10787i.getContentResolver().update(ContentUris.withAppendedId(CameraContract.C2035a.f9491a, Long.parseLong(str)), contentValues, (String) null, (String[]) null);
            }
        }
    }

    /* renamed from: a */
    public void mo20391a(String str, String str2, String str3, boolean z) {
        Object[] objArr = {str, str2, str3, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10522a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4505, new Class[]{String.class, String.class, String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f10528f.mo20262a(str, str2, str3, z);
        }
    }

    /* renamed from: c */
    public void mo20399c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10522a, false, 4506, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f10528f.mo20267c(str);
        }
    }

    private class ConnectionChangeReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public static ChangeQuickRedirect f10546a;

        /* renamed from: c */
        private boolean f10548c = false;

        /* renamed from: d */
        private Context f10549d;

        /* renamed from: e */
        private IntentFilter f10550e;

        public ConnectionChangeReceiver(Context context, IntentFilter intentFilter) {
            this.f10549d = context;
            this.f10550e = intentFilter;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo20428a() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0052 }
                com.meizu.savior.ChangeQuickRedirect r3 = f10546a     // Catch:{ all -> 0x0052 }
                r4 = 0
                r5 = 4550(0x11c6, float:6.376E-42)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0052 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0052 }
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0052 }
                boolean r1 = r1.isSupported     // Catch:{ all -> 0x0052 }
                if (r1 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                boolean r1 = r8.f10548c     // Catch:{ all -> 0x0052 }
                if (r1 != 0) goto L_0x0050
                android.content.Context r1 = r8.f10549d     // Catch:{ all -> 0x0052 }
                android.content.IntentFilter r2 = r8.f10550e     // Catch:{ all -> 0x0052 }
                r1.registerReceiver(r8, r2)     // Catch:{ all -> 0x0052 }
                android.content.Context r1 = r8.f10549d     // Catch:{ all -> 0x0052 }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0052 }
                android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2035a.f9491a     // Catch:{ all -> 0x0052 }
                com.meizu.media.camera.mode.ARMode r3 = com.meizu.media.camera.mode.ARMode.this     // Catch:{ all -> 0x0052 }
                android.database.ContentObserver r3 = r3.f10537t     // Catch:{ all -> 0x0052 }
                r4 = 1
                r1.registerContentObserver(r2, r4, r3)     // Catch:{ all -> 0x0052 }
                com.meizu.media.camera.mode.ARMode r1 = com.meizu.media.camera.mode.ARMode.this     // Catch:{ all -> 0x0052 }
                boolean r1 = r1.f10534p     // Catch:{ all -> 0x0052 }
                if (r1 == 0) goto L_0x004e
                android.content.Context r1 = r8.f10549d     // Catch:{ all -> 0x0052 }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0052 }
                android.net.Uri r2 = com.meizu.media.camera.database.CameraContract.C2035a.f9491a     // Catch:{ all -> 0x0052 }
                r3 = 0
                r1.notifyChange(r2, r3)     // Catch:{ all -> 0x0052 }
                com.meizu.media.camera.mode.ARMode r1 = com.meizu.media.camera.mode.ARMode.this     // Catch:{ all -> 0x0052 }
                boolean unused = r1.f10534p = r0     // Catch:{ all -> 0x0052 }
            L_0x004e:
                r8.f10548c = r4     // Catch:{ all -> 0x0052 }
            L_0x0050:
                monitor-exit(r8)
                return
            L_0x0052:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.ARMode.ConnectionChangeReceiver.mo20428a():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
            return;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo20429b() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0034 }
                com.meizu.savior.ChangeQuickRedirect r3 = f10546a     // Catch:{ all -> 0x0034 }
                r4 = 0
                r5 = 4551(0x11c7, float:6.377E-42)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0034 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0034 }
                r2 = r8
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0034 }
                boolean r1 = r1.isSupported     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                boolean r1 = r8.f10548c     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0032
                android.content.Context r1 = r8.f10549d     // Catch:{ all -> 0x0034 }
                r1.unregisterReceiver(r8)     // Catch:{ all -> 0x0034 }
                android.content.Context r1 = r8.f10549d     // Catch:{ all -> 0x0034 }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0034 }
                com.meizu.media.camera.mode.ARMode r2 = com.meizu.media.camera.mode.ARMode.this     // Catch:{ all -> 0x0034 }
                android.database.ContentObserver r2 = r2.f10537t     // Catch:{ all -> 0x0034 }
                r1.unregisterContentObserver(r2)     // Catch:{ all -> 0x0034 }
                r8.f10548c = r0     // Catch:{ all -> 0x0034 }
            L_0x0032:
                monitor-exit(r8)
                return
            L_0x0034:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.ARMode.ConnectionChangeReceiver.mo20429b():void");
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = true;
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f10546a, false, 4552, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                int a = NetWorkUtils.m15976a(context);
                if (a != 7) {
                    switch (a) {
                        case 0:
                            LogUtil.m15942a(ARMode.f10523b, "MOBILE NETWORK CONNECTED");
                            break;
                        case 1:
                            LogUtil.m15942a(ARMode.f10523b, "Wi-Fi CONNECTED");
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    LogUtil.m15942a(ARMode.f10523b, "BLUETOOTH NETWORK CONNECTED");
                }
                if (z && ARMode.this.f10530l != null) {
                    ARMode.this.f10530l.postDelayed(new Runnable() {
                        public final void run() {
                            ARMode.ConnectionChangeReceiver.this.m10941c();
                        }
                    }, 500);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m10941c() {
            if (!PatchProxy.proxy(new Object[0], this, f10546a, false, 4553, new Class[0], Void.TYPE).isSupported && ARMode.this.f10528f != null) {
                ARMode.this.f10528f.mo20272h();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10878a(final Cursor cursor) {
        if (!PatchProxy.proxy(new Object[]{cursor}, this, f10522a, false, 4507, new Class[]{Cursor.class}, Void.TYPE).isSupported) {
            new AsyncTaskEx<Cursor, Void, ArrayList<ARSticker>>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f10543a;

                /* renamed from: a */
                public ArrayList<ARSticker> mo17658a(Cursor... cursorArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cursorArr}, this, f10543a, false, 4546, new Class[]{Cursor[].class}, ArrayList.class);
                    if (proxy.isSupported) {
                        return (ArrayList) proxy.result;
                    }
                    ArrayList<ARSticker> arrayList = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        ARSticker aRSticker = new ARSticker();
                        aRSticker.mo19316a(cursor.getInt(cursor.getColumnIndex("sticker_id")));
                        byte[] blob = cursor.getBlob(cursor.getColumnIndex("icon"));
                        if (blob != null) {
                            aRSticker.mo19317a(BitmapFactory.decodeByteArray(blob, 0, blob.length));
                        }
                        aRSticker.mo19326c(cursor.getString(cursor.getColumnIndex("name")));
                        aRSticker.mo19329d(cursor.getString(cursor.getColumnIndex("url")));
                        aRSticker.mo19334f(cursor.getString(cursor.getColumnIndex(Constants.KEY_LINK)));
                        aRSticker.mo19323b(cursor.getString(cursor.getColumnIndex("link_img_url")));
                        byte[] blob2 = cursor.getBlob(cursor.getColumnIndex("link_img"));
                        if (blob2 != null) {
                            aRSticker.mo19322b(BitmapFactory.decodeByteArray(blob2, 0, blob2.length));
                        }
                        aRSticker.mo19319a(cursor.getString(cursor.getColumnIndex("icon_url")));
                        aRSticker.mo19331e(cursor.getString(cursor.getColumnIndex("md5")));
                        switch (cursor.getInt(cursor.getColumnIndex("download"))) {
                            case 1:
                                aRSticker.mo19318a(ARSticker.DownloadState.DOWNLOADING);
                                break;
                            case 2:
                                aRSticker.mo19318a(ARSticker.DownloadState.DOWNLOADED);
                                break;
                            case 3:
                                aRSticker.mo19318a(ARSticker.DownloadState.DOWNLOAD_FAILED);
                                break;
                            case 4:
                                aRSticker.mo19318a(ARSticker.DownloadState.DOWNLOADING);
                                break;
                            default:
                                aRSticker.mo19318a(ARSticker.DownloadState.NOT_DOWNLOAD);
                                break;
                        }
                        aRSticker.mo19320a(cursor.getInt(cursor.getColumnIndex("is_fake")) == 1);
                        aRSticker.mo19327c(cursor.getInt(cursor.getColumnIndex("clickable")) == 1);
                        aRSticker.mo19330d(cursor.getInt(cursor.getColumnIndex("has_music")) == 1);
                        arrayList.add(aRSticker);
                    }
                    return arrayList;
                }

                /* renamed from: a */
                public void mo17660a(ArrayList<ARSticker> arrayList) {
                    if (!PatchProxy.proxy(new Object[]{arrayList}, this, f10543a, false, 4547, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (ARMode.this.f10527e == null) {
                            return;
                        }
                        if (arrayList.size() == 1) {
                            ARMode.this.f10527e.mo21935a(arrayList.get(0));
                        } else {
                            ARMode.this.f10527e.mo21940a(arrayList);
                        }
                    }
                }
            }.mo22614c((Params[]) new Cursor[]{cursor});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m10873M() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4508, new Class[0], Void.TYPE).isSupported && this.f10527e != null && this.f10527e.mo21954j()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f10531m;
            this.f10527e.mo21949e(CameraUtil.m15833a(currentTimeMillis, false));
            this.f10530l.sendEmptyMessageDelayed(1, 1000 - (currentTimeMillis % 1000));
        }
    }

    /* renamed from: a */
    public void mo20392a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10522a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4509, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f10527e != null) {
            this.f10527e.mo21945c(z);
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10522a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4510, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            mo20395a_();
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4511, new Class[0], Void.TYPE).isSupported) {
            super.mo20402f_();
            if (this.f10527e != null) {
                this.f10527e.mo21946d();
            }
            mo20395a_();
        }
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4512, new Class[0], Void.TYPE).isSupported) {
            if (this.f10529g != null) {
                this.f10529g.mo20429b();
            }
            this.f10538u.cancelOperation(1003);
            this.f10527e.mo21952h();
            this.f10527e = null;
            if (this.f10528f != null) {
                this.f10528f.mo20266c();
                this.f10528f.mo20256a((StickerNetworkManager.C2117a) null, (StickerNetworkManager.C2118b) null);
                this.f10528f = null;
            }
            this.f10534p = false;
            if (this.f10525c.mo17914ak() != null) {
                this.f10525c.mo17914ak().mo20230j(false);
            }
            if (this.f10788j != null) {
                this.f10788j.mo21574c(16, false);
                this.f10788j.mo21574c(256, false);
                this.f10788j.mo21533a(false, false, false);
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.AR;
    }

    /* renamed from: l_ */
    public boolean mo20409l_() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10522a, false, 4513, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10527e != null) {
            return this.f10527e.mo21954j();
        }
        return false;
    }

    /* renamed from: k_ */
    public void mo20407k_() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4514, new Class[0], Void.TYPE).isSupported && this.f10527e != null && this.f10527e.mo21954j()) {
            m10874N();
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4515, new Class[0], Void.TYPE).isSupported) {
            if (this.f10527e != null) {
                this.f10527e.mo21951g();
            }
            if (this.f10529g != null) {
                this.f10529g.mo20429b();
            }
            if (this.f10528f != null) {
                this.f10528f.mo20254a();
            }
        }
    }

    /* renamed from: j_ */
    public void mo20406j_() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4516, new Class[0], Void.TYPE).isSupported) {
            if (this.f10527e != null) {
                this.f10527e.mo21950f();
            }
            if (this.f10528f != null) {
                this.f10528f.mo20264b();
            }
            if (this.f10529g != null) {
                this.f10529g.mo20428a();
            }
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4517, new Class[0], Void.TYPE).isSupported) {
            mo20539R().mo18267u().mo22131at().mo23331a((MzFocusRenderer.C2745d) this);
            mo20395a_();
        }
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10522a, false, 4518, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && CameraController.m8868g() != null && CameraController.m8868g().mo19522k() != null && this.f10527e != null) {
            this.f10527e.mo21944c();
        }
    }

    /* renamed from: o */
    public void mo20412o() {
        if (PatchProxy.proxy(new Object[0], this, f10522a, false, 4519, new Class[0], Void.TYPE).isSupported || this.f10527e == null) {
            return;
        }
        if (!this.f10527e.mo21954j() || System.currentTimeMillis() - this.f10531m < 1000) {
            m10875O();
            this.f10535q = false;
            return;
        }
        m10874N();
        this.f10536r = false;
    }

    /* renamed from: N */
    private void m10874N() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4520, new Class[0], Void.TYPE).isSupported && !this.f10535q) {
            LogUtil.m15942a(f10523b, "stopVideoRecording");
            this.f10535q = true;
            this.f10788j.mo21532a(false, false);
            if (this.f10527e.mo21954j()) {
                this.f10788j.mo21589f(false);
                this.f10788j.mo21506a(0);
            } else {
                this.f10788j.mo21589f(true);
                this.f10788j.mo21506a(2560);
            }
            this.f10530l.removeMessages(1);
            this.f10527e.mo21953i();
            this.f10525c.mo18275x(2);
        }
    }

    /* renamed from: O */
    private void m10875O() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4521, new Class[0], Void.TYPE).isSupported && !this.f10536r) {
            LogUtil.m15942a(f10523b, "startVideoRecording");
            this.f10536r = true;
            this.f10525c.mo18275x(1);
            this.f10530l.postDelayed(new Runnable() {
                public final void run() {
                    ARMode.this.m10876P();
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void m10876P() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4543, new Class[0], Void.TYPE).isSupported) {
            this.f10531m = System.currentTimeMillis();
            String a = Storage.m7750a().mo18620a((Context) this.f10787i, this.f10531m);
            String str = a + ".mp4";
            String a2 = Storage.m7750a().mo18625a(str, true);
            File file = new File(Storage.m7750a().mo18669n());
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f10527e.mo21947d(a2);
            m10873M();
            this.f10788j.mo21532a(true, false);
            this.f10788j.mo21506a(0);
            this.f10533o = new ContentValues(9);
            this.f10533o.put(PushConstants.TITLE, a);
            this.f10533o.put("_display_name", str);
            this.f10533o.put("datetaken", Long.valueOf(this.f10531m));
            this.f10533o.put("date_modified", Long.valueOf(this.f10531m / 1000));
            this.f10533o.put("mime_type", "video/mp4");
            this.f10533o.put("_data", a2);
            this.f10533o.put("resolution", this.f10527e.mo21956l() + "x" + this.f10527e.mo21957m());
            this.f10533o.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(mo20415r()));
            Location a3 = this.f10525c.mo18192dP().mo19017a(this.f10531m);
            if (a3 != null) {
                this.f10533o.put(Parameters.LATITUDE, Double.valueOf(a3.getLatitude()));
                this.f10533o.put(Parameters.LONGITUDE, Double.valueOf(a3.getLongitude()));
            }
            if (this.f10532n == -1) {
                this.f10532n = this.f10531m;
                mo20539R().mo18175d(this.f10532n);
            }
        }
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f10522a, false, 4522, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10527e != null) {
            File file = new File(Storage.m7750a().mo18669n());
            if (!file.exists()) {
                file.mkdirs();
            }
            long dJ = this.f10525c.mo18186dJ();
            String a = CameraUtil.m15831a(dJ);
            LogUtil.C2630a aVar = f10523b;
            LogUtil.m15942a(aVar, "capture: " + a);
            String a2 = Storage.m7750a().mo18625a(a, false);
            mo20539R().mo18275x(3);
            this.f10788j.mo21614m(false);
            this.f10527e.mo21939a(a2, dJ, a);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20390a(String str, long j, String str2) {
        String str3 = str;
        long j2 = j;
        String str4 = str2;
        Object[] objArr = {str3, new Long(j2), str4};
        ChangeQuickRedirect changeQuickRedirect = f10522a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4523, new Class[]{String.class, Long.TYPE, String.class}, Void.TYPE).isSupported) {
            Uri b = m10883b(str4, j2, str3);
            m10881a(str, j);
            if (this.f10787i != null) {
                this.f10787i.mo17673b(b);
                this.f10788j.mo21518a(b);
                this.f10525c.mo18122c(true);
                this.f10787i.mo17670a(str3, false);
                this.f10788j.mo21517a((Bitmap) null, (byte[]) null, str, 0, 0, false, this.f10527e.mo21956l(), this.f10527e.mo21957m(), this.f10525c.mo18200dX());
            }
        }
    }

    /* renamed from: q */
    public void mo20414q() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4524, new Class[0], Void.TYPE).isSupported) {
            m10874N();
        }
    }

    /* renamed from: b */
    private Uri m10883b(String str, long j, String str2) {
        Object[] objArr = {str, new Long(j), str2};
        ChangeQuickRedirect changeQuickRedirect = f10522a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4525, new Class[]{String.class, Long.TYPE, String.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        File file = new File(str2);
        XmpMetaData gVar = new XmpMetaData("AR", false, false, -1);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(file.lastModified());
        ContentValues contentValues = new ContentValues(10);
        contentValues.put(PushConstants.TITLE, str);
        contentValues.put("_display_name", str + ".jpg");
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(seconds));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
        contentValues.put("_data", str2);
        contentValues.put("_size", Long.valueOf(file.length()));
        Location a = this.f10525c.mo18192dP().mo19017a(j);
        if (a != null) {
            contentValues.put(Parameters.LATITUDE, Double.valueOf(a.getLatitude()));
            contentValues.put(Parameters.LONGITUDE, Double.valueOf(a.getLongitude()));
        }
        try {
            XmpUtilHelper.m16123a(str2, gVar);
            return this.f10787i.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private void m10881a(String str, long j) {
        if (!PatchProxy.proxy(new Object[]{str, new Long(j)}, this, f10522a, false, 4526, new Class[]{String.class, Long.TYPE}, Void.TYPE).isSupported) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                String format = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss", Locale.ENGLISH).format(Long.valueOf(j));
                exifInterface.setAttribute(ExifInterface.TAG_MAKE, "Meizu");
                exifInterface.setAttribute("Model", Build.MODEL);
                exifInterface.setAttribute(ExifInterface.TAG_SOFTWARE, "Meizu Camera");
                exifInterface.setAttribute(ExifInterface.TAG_DATETIME, format);
                exifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, format);
                exifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, format);
                exifInterface.setAttribute(ExifInterface.TAG_USER_COMMENT, MtkPatterns.KEY_URLDATA_END);
                Location a = this.f10525c.mo18192dP().mo19017a(j);
                if (a != null) {
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE, FormatUtil.m16269a(a.getLatitude()));
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, a.getLatitude() > 0.0d ? "N" : ExifInterface.LATITUDE_SOUTH);
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, FormatUtil.m16269a(a.getLongitude()));
                    exifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, a.getLongitude() > 0.0d ? ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST);
                }
                exifInterface.saveAttributes();
            } catch (IOException e) {
                LogUtil.C2630a aVar = f10523b;
                LogUtil.m15949b(aVar, "failed to write ar exif: " + e.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00af, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b0, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d2, code lost:
        r12 = f10523b;
        com.meizu.media.camera.util.LogUtil.m15952c(r12, "Current video URI: " + null + "bitmap: " + r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:9:0x007c] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20400d(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r12
            com.meizu.savior.ChangeQuickRedirect r3 = f10522a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4527(0x11af, float:6.344E-42)
            r2 = r11
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r11.f10531m
            long r1 = r1 - r3
            com.meizu.media.camera.util.ac$a r3 = f10523b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "onVideoSaved: "
            r4.append(r5)
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r3, r4)
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            r4 = 0
            if (r3 != 0) goto L_0x004e
            com.meizu.media.camera.ui.d r3 = r11.f10527e
            int r3 = r3.mo21956l()
            long[] r5 = new long[r8]
            android.graphics.Bitmap r3 = com.meizu.media.camera.Thumbnail.m7941a(r12, r3, r5)
            goto L_0x004f
        L_0x004e:
            r3 = r4
        L_0x004f:
            if (r3 == 0) goto L_0x00f0
            android.graphics.Bitmap r3 = com.meizu.media.camera.util.CameraUtil.m15872b((android.graphics.Bitmap) r3, (int) r8, (boolean) r8)
            android.content.ContentValues r5 = r11.f10533o
            java.lang.String r6 = "_size"
            java.io.File r7 = new java.io.File
            r7.<init>(r12)
            long r9 = r7.length()
            java.lang.Long r7 = java.lang.Long.valueOf(r9)
            r5.put(r6, r7)
            android.content.ContentValues r5 = r11.f10533o
            java.lang.String r6 = "duration"
            java.lang.Long r7 = java.lang.Long.valueOf(r1)
            r5.put(r6, r7)
            com.meizu.media.camera.CameraActivity r5 = r11.f10787i
            android.content.ContentResolver r5 = r5.getContentResolver()
            java.lang.String r6 = "content://media/external/video/media"
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x00d2, all -> 0x00b2 }
            android.content.ContentValues r7 = r11.f10533o     // Catch:{ Exception -> 0x00d2, all -> 0x00b2 }
            android.net.Uri r5 = r5.insert(r6, r7)     // Catch:{ Exception -> 0x00d2, all -> 0x00b2 }
            com.meizu.media.camera.CameraActivity r6 = r11.f10787i     // Catch:{ Exception -> 0x00d2, all -> 0x00af }
            if (r6 == 0) goto L_0x008f
            com.meizu.media.camera.CameraActivity r6 = r11.f10787i     // Catch:{ Exception -> 0x00d2, all -> 0x00af }
            r6.mo17670a((java.lang.String) r12, (boolean) r0)     // Catch:{ Exception -> 0x00d2, all -> 0x00af }
        L_0x008f:
            com.meizu.media.camera.util.ac$a r12 = f10523b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Current video URI: "
            r4.append(r6)
            r4.append(r5)
            java.lang.String r6 = "bitmap: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r12, r4)
            r4 = r5
            goto L_0x00f0
        L_0x00af:
            r12 = move-exception
            r4 = r5
            goto L_0x00b3
        L_0x00b2:
            r12 = move-exception
        L_0x00b3:
            com.meizu.media.camera.util.ac$a r0 = f10523b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Current video URI: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = "bitmap: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            throw r12
        L_0x00d2:
            com.meizu.media.camera.util.ac$a r12 = f10523b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Current video URI: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r6 = "bitmap: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r12, r5)
        L_0x00f0:
            r11.m10877a((long) r1)
            com.meizu.media.camera.CameraActivity r12 = r11.f10787i
            if (r12 == 0) goto L_0x0103
            if (r4 == 0) goto L_0x0103
            com.meizu.media.camera.CameraActivity r12 = r11.f10787i
            r12.mo17673b((android.net.Uri) r4)
            com.meizu.media.camera.u r12 = r11.f10788j
            r12.mo21518a((android.net.Uri) r4)
        L_0x0103:
            com.meizu.media.camera.u r12 = r11.f10788j
            r12.mo21567b((android.graphics.Bitmap) r3)
            r11.f10535q = r8
            r11.f10536r = r8
            com.meizu.media.camera.mode.h r12 = r11.f10525c
            boolean[] r1 = new boolean[r0]
            r1[r8] = r0
            r12.mo18122c(r1)
            com.meizu.media.camera.u r12 = r11.f10788j
            r12.mo21589f((boolean) r0)
            com.meizu.media.camera.u r12 = r11.f10788j
            r0 = 2560(0xa00, float:3.587E-42)
            r12.mo21506a((int) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.ARMode.mo20400d(java.lang.String):void");
    }

    /* renamed from: r */
    public int mo20415r() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10522a, false, 4528, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f10525c.mo18194dR();
    }

    /* renamed from: s */
    public boolean mo20416s() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10522a, false, 4529, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10787i == null || this.f10787i.mo17677n();
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10522a, false, 4530, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10527e != null) {
            if (this.f10527e.mo21959o()) {
                this.f10527e.mo21961q();
                return true;
            } else if (this.f10527e.mo21954j()) {
                mo20412o();
                return true;
            }
        }
        return false;
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: B */
    public MzFocusRenderer.C2743b mo20378B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10522a, false, 4534, new Class[0], MzFocusRenderer.C2743b.class);
        return proxy.isSupported ? (MzFocusRenderer.C2743b) proxy.result : this.f10525c.mo17914ak().mo20245x();
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4535, new Class[0], Void.TYPE).isSupported && this.f10525c.mo18267u().mo22131at() != null) {
            this.f10525c.mo18267u().mo22131at().mo23337e();
        }
    }

    /* renamed from: F */
    public void mo20382F() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4536, new Class[0], Void.TYPE).isSupported) {
            super.mo20382F();
        }
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10522a, false, 4537, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f10527e != null) {
            arrayList.add(this.f10527e.mo21948e());
        }
        return arrayList;
    }

    /* renamed from: G */
    public void mo20286G() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4538, new Class[0], Void.TYPE).isSupported) {
            new C2144b(this.f10787i, this).mo22614c((Params[]) new Void[0]);
        }
    }

    /* renamed from: com.meizu.media.camera.mode.ARMode$b */
    private static class C2144b extends AsyncTaskEx<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f10553a;

        /* renamed from: b */
        private final WeakReference<ARMode> f10554b;

        /* renamed from: c */
        private Context f10555c;

        C2144b(Context context, ARMode aRMode) {
            this.f10555c = context.getApplicationContext();
            this.f10554b = new WeakReference<>(aRMode);
        }

        /* renamed from: a */
        public Void mo17658a(Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f10553a, false, 4549, new Class[]{Void[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            ARMode aRMode = (ARMode) this.f10554b.get();
            ContentValues contentValues = new ContentValues();
            contentValues.put("notify_change", false);
            contentValues.put("download", Integer.valueOf(ARSticker.DownloadState.NOT_DOWNLOAD.ordinal()));
            int update = this.f10555c.getApplicationContext().getContentResolver().update(CameraContract.C2035a.f9491a, contentValues, "download=? OR download=?", new String[]{String.valueOf(1), String.valueOf(3)});
            if (update > 0 && aRMode != null) {
                boolean unused = aRMode.f10534p = true;
            }
            LogUtil.C2630a K = ARMode.f10523b;
            LogUtil.m15952c(K, "CleanStickerDownloadStateTask finish :" + update);
            return null;
        }
    }

    /* renamed from: H */
    public void mo20383H() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4539, new Class[0], Void.TYPE).isSupported && this.f10527e != null) {
            this.f10527e.mo21958n();
        }
    }

    /* renamed from: I */
    public void mo20384I() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4540, new Class[0], Void.TYPE).isSupported) {
            m10877a(0);
        }
    }

    /* renamed from: a */
    private void m10877a(long j) {
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f10522a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4541, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            Map<String, String> a = this.f10526d.mo22688a(new String[]{"mode", "location", "capture_type"});
            a.put("capture_time", Long.toString(this.f10525c.mo18186dJ()));
            String str = "error mode";
            if (!(this.f10525c.mo17914ak() == null || (ak = this.f10525c.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str = h.getKey();
            }
            a.put("focus_mode", str);
            if (this.f10527e != null) {
                a.put("ar_sticker_id", Integer.toString(this.f10527e.mo21955k()));
            }
            if (j != 0) {
                a.put("ar_video_duration", Long.toString(j));
            }
            this.f10526d.mo22693a("capture_info", a);
        }
    }

    /* renamed from: J */
    public void mo20385J() {
        if (!PatchProxy.proxy(new Object[0], this, f10522a, false, 4542, new Class[0], Void.TYPE).isSupported && this.f10527e != null) {
            this.f10527e.mo21960p();
        }
    }
}
