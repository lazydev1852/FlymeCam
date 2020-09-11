package com.meizu.media.camera.crop;

import android.app.ActionBar;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public class CropActivity extends Activity {

    /* renamed from: a */
    public static ChangeQuickRedirect f9161a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LogUtil.C2630a f9162b = new LogUtil.C2630a("CropActivity");

    /* renamed from: c */
    private CropExtras f9163c = null;

    /* renamed from: d */
    private C2026b f9164d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f9165e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f9166f = 0;

    /* renamed from: g */
    private Bitmap f9167g = null;

    /* renamed from: h */
    private RectF f9168h = null;

    /* renamed from: i */
    private int f9169i = 0;

    /* renamed from: j */
    private Uri f9170j = null;

    /* renamed from: k */
    private CropView f9171k = null;

    /* renamed from: l */
    private View f9172l = null;

    /* renamed from: m */
    private boolean f9173m = false;

    public int mzNightModeUseOf() {
        return 0;
    }

    public void onCreate(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f9161a, false, 3257, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            setResult(0, new Intent());
            this.f9163c = m9657a(intent);
            if (this.f9163c != null && this.f9163c.mo19791i()) {
                getWindow().addFlags(524288);
            }
            setContentView(LayoutInflater.from(ContextBuilder.m6349a(this, true, true)).inflate(R.layout.crop_activity, (ViewGroup) null, false));
            this.f9171k = (CropView) findViewById(R.id.cropView);
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayOptions(16);
                actionBar.setCustomView(R.layout.crop_actionbar);
                actionBar.getCustomView().setOnClickListener(new View.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f9174a;

                    public void onClick(View view) {
                        if (!PatchProxy.proxy(new Object[]{view}, this, f9174a, false, 3277, new Class[]{View.class}, Void.TYPE).isSupported) {
                            CropActivity.this.mo19752a();
                        }
                    }
                });
            }
            if (intent.getData() != null) {
                this.f9170j = intent.getData();
                m9660a(this.f9170j);
                return;
            }
            m9668b();
        }
    }

    /* renamed from: a */
    private void m9663a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9161a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3258, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f9172l != null) {
            this.f9172l.setEnabled(z);
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f9161a, false, 3259, new Class[0], Void.TYPE).isSupported) {
            if (this.f9164d != null) {
                this.f9164d.cancel(false);
            }
            super.onDestroy();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!PatchProxy.proxy(new Object[]{configuration}, this, f9161a, false, 3260, new Class[]{Configuration.class}, Void.TYPE).isSupported) {
            super.onConfigurationChanged(configuration);
            this.f9171k.mo19767a();
        }
    }

    /* renamed from: b */
    private void m9668b() {
        if (!PatchProxy.proxy(new Object[0], this, f9161a, false, 3261, new Class[0], Void.TYPE).isSupported) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            startActivityForResult(Intent.createChooser(intent, getString(R.string.select_image)), 1);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Object[] objArr = {new Integer(i), new Integer(i2), intent};
        ChangeQuickRedirect changeQuickRedirect = f9161a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3262, new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, Void.TYPE).isSupported && i2 == -1 && i == 1) {
            this.f9170j = intent.getData();
            m9660a(this.f9170j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m9669c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9161a, false, 3263, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
    }

    /* renamed from: a */
    private void m9660a(Uri uri) {
        if (!PatchProxy.proxy(new Object[]{uri}, this, f9161a, false, 3264, new Class[]{Uri.class}, Void.TYPE).isSupported) {
            if (uri != null) {
                m9663a(false);
                findViewById(R.id.loading).setVisibility(0);
                this.f9164d = new C2026b();
                this.f9164d.execute(new Uri[]{uri});
                return;
            }
            m9672d();
            m9673e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9659a(Bitmap bitmap, RectF rectF, int i) {
        Object[] objArr = {bitmap, rectF, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9161a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3265, new Class[]{Bitmap.class, RectF.class, Integer.TYPE}, Void.TYPE).isSupported) {
            findViewById(R.id.loading).setVisibility(8);
            this.f9167g = bitmap;
            this.f9168h = rectF;
            this.f9169i = i;
            if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                LogUtil.m15956e(this.f9162b, "could not load image for cropping");
                m9672d();
                setResult(0, new Intent());
                m9673e();
                return;
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            this.f9171k.mo19769a(bitmap, rectF2, rectF2, i);
            if (this.f9163c != null) {
                int c = this.f9163c.mo19785c();
                int d = this.f9163c.mo19786d();
                this.f9165e = this.f9163c.mo19783a();
                this.f9166f = this.f9163c.mo19784b();
                if (this.f9165e > 0 && this.f9166f > 0) {
                    this.f9171k.mo19768a((float) this.f9165e, (float) this.f9166f);
                }
                float j = this.f9163c.mo19792j();
                float k = this.f9163c.mo19793k();
                if (j > 0.0f && k > 0.0f) {
                    this.f9171k.setWallpaperSpotlight(j, k);
                }
                if (c > 0 && d > 0) {
                    this.f9171k.mo19768a((float) c, (float) d);
                }
            }
            m9663a(true);
        }
    }

    /* renamed from: d */
    private void m9672d() {
        if (!PatchProxy.proxy(new Object[0], this, f9161a, false, 3266, new Class[0], Void.TYPE).isSupported) {
            Toast.makeText(this, getString(R.string.cannot_load_image), 0).show();
        }
    }

    /* renamed from: com.meizu.media.camera.crop.CropActivity$b */
    private class C2026b extends AsyncTask<Uri, Void, Bitmap> {

        /* renamed from: a */
        public static ChangeQuickRedirect f9191a;

        /* renamed from: b */
        int f9192b;

        /* renamed from: c */
        Context f9193c;

        /* renamed from: d */
        Rect f9194d = new Rect();

        /* renamed from: e */
        int f9195e = 0;

        public C2026b() {
            this.f9192b = CropActivity.this.m9669c();
            this.f9193c = CropActivity.this.getApplicationContext();
        }

        /* renamed from: a */
        public Bitmap doInBackground(Uri... uriArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uriArr}, this, f9191a, false, 3281, new Class[]{Uri[].class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            Uri uri = uriArr[0];
            Bitmap a = C2027g.m9756a(uri, this.f9193c, this.f9192b, this.f9194d, false);
            this.f9195e = C2027g.m9760c(this.f9193c, uri);
            return a;
        }

        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (!PatchProxy.proxy(new Object[]{bitmap}, this, f9191a, false, 3282, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                CropActivity.this.m9659a(bitmap, new RectF(this.f9194d), this.f9195e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19752a() {
        /*
            r14 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f9161a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 3267(0xcc3, float:4.578E-42)
            r2 = r14
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            boolean r1 = r14.f9173m
            if (r1 == 0) goto L_0x001b
            return
        L_0x001b:
            r1 = 1
            r14.f9173m = r1
            r14.m9663a((boolean) r0)
            android.graphics.Bitmap r1 = r14.f9167g
            r2 = 0
            if (r1 == 0) goto L_0x0053
            com.meizu.media.camera.crop.c r1 = r14.f9163c
            if (r1 == 0) goto L_0x0053
            com.meizu.media.camera.crop.c r1 = r14.f9163c
            android.net.Uri r1 = r1.mo19789g()
            if (r1 == 0) goto L_0x003c
            com.meizu.media.camera.crop.c r1 = r14.f9163c
            android.net.Uri r1 = r1.mo19789g()
            if (r1 == 0) goto L_0x003d
            r3 = 4
            goto L_0x003e
        L_0x003c:
            r1 = r2
        L_0x003d:
            r3 = 0
        L_0x003e:
            com.meizu.media.camera.crop.c r4 = r14.f9163c
            boolean r4 = r4.mo19787e()
            if (r4 == 0) goto L_0x0048
            r3 = r3 | 1
        L_0x0048:
            com.meizu.media.camera.crop.c r4 = r14.f9163c
            boolean r4 = r4.mo19788f()
            if (r4 == 0) goto L_0x0055
            r3 = r3 | 2
            goto L_0x0055
        L_0x0053:
            r1 = r2
            r3 = 0
        L_0x0055:
            if (r3 != 0) goto L_0x0061
            android.net.Uri r1 = r14.f9170j
            android.net.Uri r1 = com.meizu.media.camera.crop.SaveImage.m9768b(r14, r1)
            if (r1 == 0) goto L_0x0061
            r3 = r3 | 4
        L_0x0061:
            r8 = r1
            r5 = r3
            r1 = r5 & 7
            if (r1 == 0) goto L_0x009d
            android.graphics.Bitmap r1 = r14.f9167g
            if (r1 == 0) goto L_0x009d
            android.graphics.RectF r10 = new android.graphics.RectF
            android.graphics.Bitmap r0 = r14.f9167g
            int r0 = r0.getWidth()
            float r0 = (float) r0
            android.graphics.Bitmap r1 = r14.f9167g
            int r1 = r1.getHeight()
            float r1 = (float) r1
            r3 = 0
            r10.<init>(r3, r3, r0, r1)
            android.graphics.RectF r9 = r14.m9656a((android.graphics.RectF) r10)
            android.graphics.Bitmap r6 = r14.f9167g
            android.net.Uri r7 = r14.f9170j
            android.graphics.RectF r11 = r14.f9168h
            com.meizu.media.camera.crop.c r0 = r14.f9163c
            if (r0 != 0) goto L_0x008f
        L_0x008d:
            r12 = r2
            goto L_0x0096
        L_0x008f:
            com.meizu.media.camera.crop.c r0 = r14.f9163c
            java.lang.String r2 = r0.mo19790h()
            goto L_0x008d
        L_0x0096:
            int r13 = r14.f9169i
            r4 = r14
            r4.m9658a(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        L_0x009d:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            r14.setResult(r0, r1)
            r14.m9673e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.crop.CropActivity.mo19752a():void");
    }

    /* renamed from: a */
    private void m9658a(int i, Bitmap bitmap, Uri uri, Uri uri2, RectF rectF, RectF rectF2, RectF rectF3, String str, int i2) {
        int i3 = i;
        if (!PatchProxy.proxy(new Object[]{new Integer(i3), bitmap, uri, uri2, rectF, rectF2, rectF3, str, new Integer(i2)}, this, f9161a, false, 3268, new Class[]{Integer.TYPE, Bitmap.class, Uri.class, Uri.class, RectF.class, RectF.class, RectF.class, String.class, Integer.TYPE}, Void.TYPE).isSupported && rectF != null && rectF2 != null && bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0 && rectF.width() != 0.0f && rectF.height() != 0.0f && rectF2.width() != 0.0f && rectF2.height() != 0.0f && (i3 & 7) != 0) {
            if ((i3 & 1) != 0) {
                Toast.makeText(this, R.string.setting_wallpaper, 1).show();
            }
            findViewById(R.id.loading).setVisibility(0);
            int i4 = this.f9165e;
            int i5 = i4;
            C2025a aVar = new C2025a(uri, uri2, str, i, rectF, rectF2, rectF3, i2, i5, this.f9166f);
            aVar.execute(new Bitmap[]{bitmap});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9664a(boolean z, Intent intent) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), intent}, this, f9161a, false, 3269, new Class[]{Boolean.TYPE, Intent.class}, Void.TYPE).isSupported) {
            findViewById(R.id.loading).setVisibility(8);
            if (z) {
                setResult(-1, intent);
            } else {
                setResult(0, intent);
            }
            m9673e();
        }
    }

    /* renamed from: com.meizu.media.camera.crop.CropActivity$a */
    private class C2025a extends AsyncTask<Bitmap, Void, Boolean> {

        /* renamed from: a */
        public static ChangeQuickRedirect f9176a;

        /* renamed from: m */
        static final /* synthetic */ boolean f9177m = (!CropActivity.class.desiredAssertionStatus());

        /* renamed from: b */
        InputStream f9178b = null;

        /* renamed from: c */
        OutputStream f9179c = null;

        /* renamed from: d */
        String f9180d = null;

        /* renamed from: e */
        Uri f9181e = null;

        /* renamed from: f */
        Uri f9182f = null;

        /* renamed from: g */
        int f9183g = 0;

        /* renamed from: h */
        RectF f9184h = null;

        /* renamed from: i */
        RectF f9185i = null;

        /* renamed from: j */
        RectF f9186j = null;

        /* renamed from: k */
        Intent f9187k = null;

        /* renamed from: l */
        int f9188l = 0;

        /* renamed from: o */
        private final WallpaperManager f9190o;

        /* renamed from: a */
        private void m9675a() {
            if (!PatchProxy.proxy(new Object[0], this, f9176a, false, 3278, new Class[0], Void.TYPE).isSupported) {
                if (this.f9182f == null) {
                    LogUtil.m15956e(CropActivity.this.f9162b, "cannot read original file, no input URI given");
                    return;
                }
                C2031i.m9775a((Closeable) this.f9178b);
                try {
                    this.f9178b = CropActivity.this.getContentResolver().openInputStream(this.f9182f);
                } catch (FileNotFoundException e) {
                    LogUtil.C2630a b = CropActivity.this.f9162b;
                    LogUtil.m15955d(b, "cannot read file: " + this.f9182f.toString(), e);
                }
            }
        }

        public C2025a(Uri uri, Uri uri2, String str, int i, RectF rectF, RectF rectF2, RectF rectF3, int i2, int i3, int i4) {
            this.f9180d = str;
            this.f9179c = null;
            this.f9181e = uri2;
            this.f9182f = uri;
            this.f9183g = i;
            this.f9184h = rectF;
            this.f9185i = rectF2;
            this.f9186j = rectF3;
            this.f9190o = WallpaperManager.getInstance(CropActivity.this.getApplicationContext());
            this.f9187k = new Intent();
            this.f9188l = i2 < 0 ? -i2 : i2;
            this.f9188l %= 360;
            this.f9188l = (this.f9188l / 90) * 90;
            int unused = CropActivity.this.f9165e = i3;
            int unused2 = CropActivity.this.f9166f = i4;
            if ((i & 4) != 0) {
                if (this.f9181e == null) {
                    LogUtil.m15956e(CropActivity.this.f9162b, "cannot write file, no output URI given");
                } else {
                    try {
                        this.f9179c = CropActivity.this.getContentResolver().openOutputStream(this.f9181e);
                    } catch (FileNotFoundException e) {
                        LogUtil.m15955d(CropActivity.this.f9162b, "cannot write file: " + this.f9181e.toString(), e);
                    }
                }
            }
            if ((i & 5) != 0) {
                m9675a();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00de  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(android.graphics.Bitmap... r19) {
            /*
                r18 = this;
                r8 = r18
                r9 = 1
                java.lang.Object[] r1 = new java.lang.Object[r9]
                r10 = 0
                r1[r10] = r19
                com.meizu.savior.ChangeQuickRedirect r3 = f9176a
                java.lang.Class[] r6 = new java.lang.Class[r9]
                java.lang.Class<android.graphics.Bitmap[]> r2 = android.graphics.Bitmap[].class
                r6[r10] = r2
                java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
                r4 = 0
                r5 = 3279(0xccf, float:4.595E-42)
                r2 = r18
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r2 = r1.isSupported
                if (r2 == 0) goto L_0x0024
                java.lang.Object r0 = r1.result
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                return r0
            L_0x0024:
                r0 = r19[r10]
                android.graphics.RectF r1 = r8.f9184h
                if (r1 == 0) goto L_0x005b
                android.graphics.RectF r1 = r8.f9185i
                if (r1 == 0) goto L_0x005b
                android.graphics.RectF r1 = r8.f9186j
                if (r1 == 0) goto L_0x005b
                android.graphics.RectF r1 = r8.f9184h
                android.graphics.RectF r2 = r8.f9185i
                android.graphics.RectF r3 = r8.f9186j
                android.graphics.RectF r1 = com.meizu.media.camera.crop.CropMath.m9720a((android.graphics.RectF) r1, (android.graphics.RectF) r2, (android.graphics.RectF) r3)
                android.graphics.Matrix r2 = new android.graphics.Matrix
                r2.<init>()
                int r3 = r8.f9188l
                float r3 = (float) r3
                r2.setRotate(r3)
                r2.mapRect(r1)
                if (r1 == 0) goto L_0x005b
                android.graphics.Rect r2 = new android.graphics.Rect
                r2.<init>()
                r1.roundOut(r2)
                android.content.Intent r1 = r8.f9187k
                java.lang.String r3 = "cropped-rect"
                r1.putExtra(r3, r2)
            L_0x005b:
                int r1 = r8.f9183g
                r1 = r1 & 2
                if (r1 == 0) goto L_0x00b7
                boolean r1 = f9177m
                if (r1 != 0) goto L_0x006e
                if (r0 == 0) goto L_0x0068
                goto L_0x006e
            L_0x0068:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x006e:
                android.graphics.RectF r1 = r8.f9184h
                android.graphics.RectF r2 = r8.f9185i
                android.graphics.Bitmap r0 = com.meizu.media.camera.crop.CropActivity.m9655a((android.graphics.Bitmap) r0, (android.graphics.RectF) r1, (android.graphics.RectF) r2)
                if (r0 == 0) goto L_0x007f
                r1 = 750000(0xb71b0, float:1.050974E-39)
                android.graphics.Bitmap r0 = com.meizu.media.camera.crop.CropActivity.m9654a((android.graphics.Bitmap) r0, (int) r1)
            L_0x007f:
                if (r0 != 0) goto L_0x008e
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.String r1 = "could not downsample bitmap to return in data"
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
                r1 = 1
                goto L_0x00b8
            L_0x008e:
                int r1 = r8.f9188l
                if (r1 <= 0) goto L_0x00b0
                android.graphics.Matrix r6 = new android.graphics.Matrix
                r6.<init>()
                int r1 = r8.f9188l
                float r1 = (float) r1
                r6.setRotate(r1)
                r2 = 0
                r3 = 0
                int r4 = r0.getWidth()
                int r5 = r0.getHeight()
                r7 = 1
                r1 = r0
                android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)
                if (r1 == 0) goto L_0x00b0
                r0 = r1
            L_0x00b0:
                android.content.Intent r1 = r8.f9187k
                java.lang.String r2 = "data"
                r1.putExtra(r2, r0)
            L_0x00b7:
                r1 = 0
            L_0x00b8:
                int r0 = r8.f9183g
                r0 = r0 & 5
                if (r0 == 0) goto L_0x0317
                java.io.InputStream r0 = r8.f9178b
                if (r0 == 0) goto L_0x0317
                android.graphics.RectF r0 = r8.f9184h
                android.graphics.RectF r2 = r8.f9185i
                android.graphics.RectF r3 = r8.f9186j
                android.graphics.RectF r0 = com.meizu.media.camera.crop.CropMath.m9720a((android.graphics.RectF) r0, (android.graphics.RectF) r2, (android.graphics.RectF) r3)
                if (r0 != 0) goto L_0x00de
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.String r1 = "cannot find crop for full size image"
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
                return r0
            L_0x00de:
                android.graphics.Rect r2 = new android.graphics.Rect
                r2.<init>()
                r0.roundOut(r2)
                int r0 = r2.width()
                if (r0 <= 0) goto L_0x0307
                int r0 = r2.height()
                if (r0 > 0) goto L_0x00f4
                goto L_0x0307
            L_0x00f4:
                r3 = 0
                java.io.InputStream r0 = r8.f9178b     // Catch:{ IOException -> 0x00fc }
                android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r0, r9)     // Catch:{ IOException -> 0x00fc }
                goto L_0x011e
            L_0x00fc:
                r0 = move-exception
                com.meizu.media.camera.crop.CropActivity r4 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r4 = r4.f9162b
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "cannot open region decoder for file: "
                r5.append(r6)
                android.net.Uri r6 = r8.f9182f
                java.lang.String r6 = r6.toString()
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                com.meizu.media.camera.util.LogUtil.m15955d(r4, r5, r0)
                r0 = r3
            L_0x011e:
                if (r0 == 0) goto L_0x012f
                android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options
                r4.<init>()
                r4.inMutable = r9
                android.graphics.Bitmap r4 = r0.decodeRegion(r2, r4)
                r0.recycle()
                goto L_0x0130
            L_0x012f:
                r4 = r3
            L_0x0130:
                if (r4 != 0) goto L_0x0151
                r18.m9675a()
                java.io.InputStream r0 = r8.f9178b
                if (r0 == 0) goto L_0x013f
                java.io.InputStream r0 = r8.f9178b
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r0)
            L_0x013f:
                if (r3 == 0) goto L_0x0151
                int r0 = r2.left
                int r4 = r2.top
                int r5 = r2.width()
                int r2 = r2.height()
                android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r3, r0, r4, r5, r2)
            L_0x0151:
                if (r4 != 0) goto L_0x0178
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "cannot decode file: "
                r1.append(r2)
                android.net.Uri r2 = r8.f9182f
                java.lang.String r2 = r2.toString()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
                return r0
            L_0x0178:
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                int r0 = r0.f9165e
                if (r0 <= 0) goto L_0x01e9
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                int r0 = r0.f9166f
                if (r0 <= 0) goto L_0x01e9
                android.graphics.Matrix r0 = new android.graphics.Matrix
                r0.<init>()
                android.graphics.RectF r2 = new android.graphics.RectF
                int r3 = r4.getWidth()
                float r3 = (float) r3
                int r5 = r4.getHeight()
                float r5 = (float) r5
                r6 = 0
                r2.<init>(r6, r6, r3, r5)
                int r3 = r8.f9188l
                if (r3 <= 0) goto L_0x01aa
                int r3 = r8.f9188l
                float r3 = (float) r3
                r0.setRotate(r3)
                r0.mapRect(r2)
            L_0x01aa:
                android.graphics.RectF r3 = new android.graphics.RectF
                com.meizu.media.camera.crop.CropActivity r5 = com.meizu.media.camera.crop.CropActivity.this
                int r5 = r5.f9165e
                float r5 = (float) r5
                com.meizu.media.camera.crop.CropActivity r7 = com.meizu.media.camera.crop.CropActivity.this
                int r7 = r7.f9166f
                float r7 = (float) r7
                r3.<init>(r6, r6, r5, r7)
                android.graphics.Matrix$ScaleToFit r5 = android.graphics.Matrix.ScaleToFit.FILL
                r0.setRectToRect(r2, r3, r5)
                int r2 = r8.f9188l
                float r2 = (float) r2
                r0.preRotate(r2)
                float r2 = r3.width()
                int r2 = (int) r2
                float r3 = r3.height()
                int r3 = (int) r3
                android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
                android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r3, r5)
                if (r2 == 0) goto L_0x020e
                android.graphics.Canvas r3 = new android.graphics.Canvas
                r3.<init>(r2)
                android.graphics.Paint r5 = new android.graphics.Paint
                r5.<init>()
                r3.drawBitmap(r4, r0, r5)
                r4 = r2
                goto L_0x020e
            L_0x01e9:
                int r0 = r8.f9188l
                if (r0 <= 0) goto L_0x020e
                android.graphics.Matrix r0 = new android.graphics.Matrix
                r0.<init>()
                int r2 = r8.f9188l
                float r2 = (float) r2
                r0.setRotate(r2)
                r12 = 0
                r13 = 0
                int r14 = r4.getWidth()
                int r15 = r4.getHeight()
                r17 = 1
                r11 = r4
                r16 = r0
                android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r11, r12, r13, r14, r15, r16, r17)
                if (r0 == 0) goto L_0x020e
                r4 = r0
            L_0x020e:
                java.lang.String r0 = r8.f9180d
                java.lang.String r0 = com.meizu.media.camera.crop.CropActivity.m9667b((java.lang.String) r0)
                android.graphics.Bitmap$CompressFormat r0 = com.meizu.media.camera.crop.CropActivity.m9653a((java.lang.String) r0)
                int r2 = r8.f9183g
                r3 = 90
                r5 = 4
                if (r2 != r5) goto L_0x0258
                java.io.OutputStream r2 = r8.f9179c
                if (r2 == 0) goto L_0x0235
                java.io.OutputStream r2 = r8.f9179c
                boolean r0 = r4.compress(r0, r3, r2)
                if (r0 != 0) goto L_0x022c
                goto L_0x0235
            L_0x022c:
                android.content.Intent r0 = r8.f9187k
                android.net.Uri r2 = r8.f9181e
                r0.setData(r2)
                goto L_0x0317
            L_0x0235:
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "failed to compress bitmap to file: "
                r1.append(r2)
                android.net.Uri r2 = r8.f9181e
                java.lang.String r2 = r2.toString()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            L_0x0255:
                r1 = 1
                goto L_0x0317
            L_0x0258:
                java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
                r6 = 2048(0x800, float:2.87E-42)
                r2.<init>(r6)
                boolean r0 = r4.compress(r0, r3, r2)
                if (r0 == 0) goto L_0x02fa
                int r0 = r8.f9183g
                r0 = r0 & r5
                if (r0 == 0) goto L_0x02c3
                java.io.OutputStream r0 = r8.f9179c
                if (r0 != 0) goto L_0x0290
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "failed to compress bitmap to file: "
                r1.append(r3)
                android.net.Uri r3 = r8.f9181e
                java.lang.String r3 = r3.toString()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            L_0x028e:
                r1 = 1
                goto L_0x02c3
            L_0x0290:
                java.io.OutputStream r0 = r8.f9179c     // Catch:{ IOException -> 0x02a1 }
                byte[] r3 = r2.toByteArray()     // Catch:{ IOException -> 0x02a1 }
                r0.write(r3)     // Catch:{ IOException -> 0x02a1 }
                android.content.Intent r0 = r8.f9187k     // Catch:{ IOException -> 0x02a1 }
                android.net.Uri r3 = r8.f9181e     // Catch:{ IOException -> 0x02a1 }
                r0.setData(r3)     // Catch:{ IOException -> 0x02a1 }
                goto L_0x02c3
            L_0x02a1:
                r0 = move-exception
                com.meizu.media.camera.crop.CropActivity r1 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r1 = r1.f9162b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "failed to compress bitmap to file: "
                r3.append(r4)
                android.net.Uri r4 = r8.f9181e
                java.lang.String r4 = r4.toString()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                com.meizu.media.camera.util.LogUtil.m15955d(r1, r3, r0)
                goto L_0x028e
            L_0x02c3:
                int r0 = r8.f9183g
                r0 = r0 & r9
                if (r0 == 0) goto L_0x0317
                android.app.WallpaperManager r0 = r8.f9190o
                if (r0 == 0) goto L_0x0317
                android.app.WallpaperManager r0 = r8.f9190o
                if (r0 != 0) goto L_0x02dd
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.String r1 = "no wallpaper manager"
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
                goto L_0x0255
            L_0x02dd:
                android.app.WallpaperManager r0 = r8.f9190o     // Catch:{ IOException -> 0x02ec }
                java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x02ec }
                byte[] r2 = r2.toByteArray()     // Catch:{ IOException -> 0x02ec }
                r3.<init>(r2)     // Catch:{ IOException -> 0x02ec }
                r0.setStream(r3)     // Catch:{ IOException -> 0x02ec }
                goto L_0x0317
            L_0x02ec:
                r0 = move-exception
                com.meizu.media.camera.crop.CropActivity r1 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r1 = r1.f9162b
                java.lang.String r2 = "cannot write stream to wallpaper"
                com.meizu.media.camera.util.LogUtil.m15955d(r1, r2, r0)
                goto L_0x0255
            L_0x02fa:
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.String r1 = "cannot compress bitmap"
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
                goto L_0x0255
            L_0x0307:
                com.meizu.media.camera.crop.CropActivity r0 = com.meizu.media.camera.crop.CropActivity.this
                com.meizu.media.camera.util.ac$a r0 = r0.f9162b
                java.lang.String r1 = "crop has bad values for full size image"
                com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
                return r0
            L_0x0317:
                r0 = r1 ^ 1
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.crop.CropActivity.C2025a.doInBackground(android.graphics.Bitmap[]):java.lang.Boolean");
        }

        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            if (!PatchProxy.proxy(new Object[]{bool}, this, f9176a, false, 3280, new Class[]{Boolean.class}, Void.TYPE).isSupported) {
                C2031i.m9775a((Closeable) this.f9179c);
                C2031i.m9775a((Closeable) this.f9178b);
                CropActivity.this.m9664a(bool.booleanValue(), this.f9187k);
            }
        }
    }

    /* renamed from: e */
    private void m9673e() {
        if (!PatchProxy.proxy(new Object[0], this, f9161a, false, 3270, new Class[0], Void.TYPE).isSupported) {
            finish();
        }
    }

    /* renamed from: a */
    public static Bitmap m9655a(Bitmap bitmap, RectF rectF, RectF rectF2) {
        ChangeQuickRedirect changeQuickRedirect = f9161a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, rectF, rectF2}, (Object) null, changeQuickRedirect, true, 3271, new Class[]{Bitmap.class, RectF.class, RectF.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        RectF a = CropMath.m9720a(rectF, rectF2, new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()));
        if (a == null) {
            return null;
        }
        Rect rect = new Rect();
        a.roundOut(rect);
        return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
    }

    /* renamed from: a */
    public static Bitmap m9654a(Bitmap bitmap, int i) {
        int i2 = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Integer(i)}, (Object) null, f9161a, true, 3272, new Class[]{Bitmap.class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || i < 16) {
            throw new IllegalArgumentException("Bad argument to getDownsampledBitmap()");
        }
        for (int a = CropMath.m9719a(bitmap); a > i; a /= 4) {
            i2++;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() >> i2, bitmap.getHeight() >> i2, true);
        if (createScaledBitmap == null) {
            return null;
        }
        return CropMath.m9719a(createScaledBitmap) > i ? Bitmap.createScaledBitmap(createScaledBitmap, createScaledBitmap.getWidth() >> 1, createScaledBitmap.getHeight() >> 1, true) : createScaledBitmap;
    }

    /* renamed from: a */
    public static CropExtras m9657a(Intent intent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent}, (Object) null, f9161a, true, 3273, new Class[]{Intent.class}, CropExtras.class);
        if (proxy.isSupported) {
            return (CropExtras) proxy.result;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        return new CropExtras(extras.getInt("outputX", 0), extras.getInt("outputY", 0), extras.getBoolean("scale", true) && extras.getBoolean("scaleUpIfNeeded", false), extras.getInt("aspectX", 0), extras.getInt("aspectY", 0), extras.getBoolean("set-as-wallpaper", false), extras.getBoolean("return-data", false), (Uri) extras.getParcelable("output"), extras.getString("outputFormat"), extras.getBoolean("showWhenLocked", false), extras.getFloat("spotlightX"), extras.getFloat("spotlightY"));
    }

    /* renamed from: a */
    public static Bitmap.CompressFormat m9653a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f9161a, true, 3274, new Class[]{String.class}, Bitmap.CompressFormat.class);
        if (proxy.isSupported) {
            return (Bitmap.CompressFormat) proxy.result;
        }
        return str.equals("png") ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    /* renamed from: b */
    public static String m9667b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f9161a, true, 3275, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (str == null) {
            str = "jpg";
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.equals("png") || lowerCase.equals("gif")) ? "png" : "jpg";
    }

    /* renamed from: a */
    private RectF m9656a(RectF rectF) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{rectF}, this, f9161a, false, 3276, new Class[]{RectF.class}, RectF.class);
        if (proxy.isSupported) {
            return (RectF) proxy.result;
        }
        RectF crop = this.f9171k.getCrop();
        RectF photo = this.f9171k.getPhoto();
        if (crop != null && photo != null) {
            return CropMath.m9720a(crop, photo, rectF);
        }
        LogUtil.m15956e(this.f9162b, "could not get crop");
        return null;
    }
}
