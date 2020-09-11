package com.meizu.media.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.FloatThumbnailView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.g */
public class FloatWindowManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f10101a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f10102b = new LogUtil.C2630a("FloatWindowManager");

    /* renamed from: c */
    private FloatThumbnailView f10103c;

    /* renamed from: d */
    private WindowManager.LayoutParams f10104d;

    /* renamed from: e */
    private final int f10105e = this.f10108h.getResources().getDimensionPixelSize(R.dimen.mz_watch_float_view_width);

    /* renamed from: f */
    private final int f10106f = this.f10108h.getResources().getDimensionPixelSize(R.dimen.mz_watch_float_view_height_16_9);

    /* renamed from: g */
    private final int f10107g = this.f10108h.getResources().getDimensionPixelSize(R.dimen.mz_watch_float_view_height_4_3);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Context f10108h;

    /* renamed from: i */
    private WindowManager f10109i = AndroidServices.m8287a().mo19008g();

    /* renamed from: j */
    private C2076b f10110j;

    /* renamed from: k */
    private C2075a f10111k;

    /* renamed from: com.meizu.media.camera.g$b */
    /* compiled from: FloatWindowManager */
    public interface C2076b {
        /* renamed from: a */
        void mo17800a();

        /* renamed from: b */
        void mo17801b();

        /* renamed from: c */
        void mo17802c();

        /* renamed from: d */
        void mo17803d();

        /* renamed from: e */
        void mo17804e();
    }

    public FloatWindowManager(Context context) {
        this.f10108h = ContextBuilder.m6349a(context, true, true);
    }

    /* renamed from: a */
    public void mo20104a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f10101a, false, 994, new Class[]{Context.class}, Void.TYPE).isSupported && this.f10103c == null) {
            this.f10103c = new FloatThumbnailView(ContextBuilder.m6349a(context, true, true));
            if (this.f10104d == null) {
                this.f10104d = new WindowManager.LayoutParams();
                this.f10104d.type = 2010;
                this.f10104d.format = 1;
                this.f10104d.flags = 40;
                this.f10104d.gravity = 83;
                this.f10104d.width = this.f10105e;
                this.f10104d.height = this.f10107g;
                this.f10104d.x = 0;
                this.f10104d.y = 0;
            }
            this.f10103c.setParams(this.f10104d);
            this.f10109i.addView(this.f10103c, this.f10104d);
            this.f10103c.setListener(this.f10110j);
            this.f10103c.mo22868a(this.f10104d.height);
        }
    }

    /* renamed from: a */
    public void mo20103a() {
        if (!PatchProxy.proxy(new Object[0], this, f10101a, false, 995, new Class[0], Void.TYPE).isSupported && this.f10103c != null) {
            this.f10103c.mo22867a();
        }
    }

    /* renamed from: b */
    public void mo20107b() {
        if (!PatchProxy.proxy(new Object[0], this, f10101a, false, 996, new Class[0], Void.TYPE).isSupported) {
            if (this.f10103c != null) {
                this.f10109i.removeView(this.f10103c);
            }
            this.f10103c = null;
            this.f10104d = null;
        }
    }

    /* renamed from: a */
    public void mo20105a(Uri uri, int i, int i2, boolean z) {
        if (!PatchProxy.proxy(new Object[]{uri, new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)}, this, f10101a, false, 997, new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f10103c != null) {
                ImageView imageView = (ImageView) this.f10103c.findViewById(R.id.thumbnail_image);
                RelativeLayout relativeLayout = (RelativeLayout) this.f10103c.findViewById(R.id.thumbnail_window_layout);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                imageView.setImageBitmap((Bitmap) null);
                if (i == 90 || i == 270) {
                    layoutParams.width = this.f10105e;
                    layoutParams.height = i2 == 1 ? this.f10107g : this.f10106f;
                    this.f10104d.width = layoutParams.width;
                    this.f10104d.height = layoutParams.height;
                } else {
                    layoutParams.width = i2 == 1 ? this.f10107g : this.f10106f;
                    layoutParams.height = this.f10105e;
                    this.f10104d.width = layoutParams.width;
                    this.f10104d.height = layoutParams.height;
                }
                relativeLayout.setLayoutParams(layoutParams);
                this.f10103c.setParams(this.f10104d);
                LogUtil.C2630a aVar = f10102b;
                LogUtil.m15952c(aVar, "updateImage:  " + this.f10104d.width + "x" + this.f10104d.height + ",  jpegRotation:" + i + ", ratio:" + i2 + ",  uri:" + uri + ", isPicturePostview:" + z);
                this.f10109i.updateViewLayout(this.f10103c, this.f10104d);
                if (z) {
                    this.f10111k = new C2075a(imageView, i, uri);
                    this.f10111k.mo22614c((Params[]) new Void[0]);
                    return;
                }
                if (this.f10111k != null) {
                    this.f10111k.mo22612b(true);
                }
                imageView.setImageURI(uri);
                return;
            }
            LogUtil.m15949b(f10102b, "updateImage error");
        }
    }

    /* renamed from: a */
    public void mo20106a(C2076b bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f10101a, false, 998, new Class[]{C2076b.class}, Void.TYPE).isSupported) {
            if (this.f10103c != null) {
                this.f10110j = bVar;
                this.f10103c.setListener(bVar);
                return;
            }
            this.f10110j = bVar;
        }
    }

    /* renamed from: c */
    public void mo20108c() {
        if (!PatchProxy.proxy(new Object[0], this, f10101a, false, 999, new Class[0], Void.TYPE).isSupported && this.f10103c != null) {
            this.f10103c.mo22869b();
        }
    }

    /* renamed from: d */
    public boolean mo20109d() {
        return this.f10103c != null;
    }

    /* renamed from: com.meizu.media.camera.g$a */
    /* compiled from: FloatWindowManager */
    private class C2075a extends AsyncTaskEx<Void, Void, Bitmap> {

        /* renamed from: a */
        public static ChangeQuickRedirect f10112a;

        /* renamed from: c */
        private ImageView f10114c;

        /* renamed from: d */
        private int f10115d;

        /* renamed from: e */
        private Uri f10116e;

        public C2075a(ImageView imageView, int i, Uri uri) {
            this.f10114c = imageView;
            this.f10115d = i;
            this.f10116e = uri;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A[SYNTHETIC, Splitter:B:22:0x0054] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[SYNTHETIC, Splitter:B:30:0x0063] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap mo17658a(java.lang.Void... r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r2 = 0
                r1[r2] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f10112a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<java.lang.Void[]> r10 = java.lang.Void[].class
                r6[r2] = r10
                java.lang.Class<android.graphics.Bitmap> r7 = android.graphics.Bitmap.class
                r4 = 0
                r5 = 1000(0x3e8, float:1.401E-42)
                r2 = r9
                com.meizu.savior.PatchProxyResult r10 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r0 = r10.isSupported
                if (r0 == 0) goto L_0x0021
                java.lang.Object r10 = r10.result
                android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
                return r10
            L_0x0021:
                r10 = 0
                com.meizu.media.camera.g r0 = com.meizu.media.camera.FloatWindowManager.this     // Catch:{ IOException -> 0x004d, all -> 0x004b }
                android.content.Context r0 = r0.f10108h     // Catch:{ IOException -> 0x004d, all -> 0x004b }
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ IOException -> 0x004d, all -> 0x004b }
                android.net.Uri r1 = r9.f10116e     // Catch:{ IOException -> 0x004d, all -> 0x004b }
                java.io.InputStream r0 = r0.openInputStream(r1)     // Catch:{ IOException -> 0x004d, all -> 0x004b }
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ IOException -> 0x0049 }
                int r2 = r9.f10115d     // Catch:{ IOException -> 0x0049 }
                int r2 = r2 + -90
                android.graphics.Bitmap r1 = com.meizu.media.camera.util.BitmapCreator.m16127a(r1, r2)     // Catch:{ IOException -> 0x0049 }
                if (r0 == 0) goto L_0x0048
                r0.close()     // Catch:{ IOException -> 0x0044 }
                goto L_0x0048
            L_0x0044:
                r10 = move-exception
                r10.printStackTrace()
            L_0x0048:
                return r1
            L_0x0049:
                r1 = move-exception
                goto L_0x004f
            L_0x004b:
                r0 = move-exception
                goto L_0x0061
            L_0x004d:
                r1 = move-exception
                r0 = r10
            L_0x004f:
                r1.printStackTrace()     // Catch:{ all -> 0x005d }
                if (r0 == 0) goto L_0x005c
                r0.close()     // Catch:{ IOException -> 0x0058 }
                goto L_0x005c
            L_0x0058:
                r0 = move-exception
                r0.printStackTrace()
            L_0x005c:
                return r10
            L_0x005d:
                r10 = move-exception
                r8 = r0
                r0 = r10
                r10 = r8
            L_0x0061:
                if (r10 == 0) goto L_0x006b
                r10.close()     // Catch:{ IOException -> 0x0067 }
                goto L_0x006b
            L_0x0067:
                r10 = move-exception
                r10.printStackTrace()
            L_0x006b:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.FloatWindowManager.C2075a.mo17658a(java.lang.Void[]):android.graphics.Bitmap");
        }

        /* renamed from: a */
        public void mo17660a(Bitmap bitmap) {
            if (!PatchProxy.proxy(new Object[]{bitmap}, this, f10112a, false, 1001, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a e = FloatWindowManager.f10102b;
                LogUtil.m15952c(e, "onPostExecute:" + bitmap + ", isCancelled:" + mo22615d());
                if (this.f10114c != null && bitmap != null && !mo22615d()) {
                    this.f10114c.setImageBitmap(bitmap);
                }
            }
        }
    }
}
