package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.ArrayList;

public class DocScannerView extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14481a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f14482b = new LogUtil.C2630a("DocScannerView");

    /* renamed from: c */
    private final int f14483c;

    /* renamed from: d */
    private final int f14484d;

    /* renamed from: e */
    private boolean f14485e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f14486f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f14487g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f14488h;

    /* renamed from: i */
    private ArrayList<C2686a> f14489i = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Point[] f14490j;

    /* renamed from: k */
    private int f14491k = 1;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f14492l = 1;

    /* renamed from: m */
    private boolean f14493m;

    /* renamed from: n */
    private int f14494n;

    /* renamed from: o */
    private int f14495o;

    /* renamed from: p */
    private int f14496p;

    /* renamed from: q */
    private Paint f14497q;

    /* renamed from: r */
    private int f14498r;

    /* renamed from: s */
    private float f14499s = 1.0f;

    /* renamed from: t */
    private Handler f14500t = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f14501a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f14501a, false, 8330, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 1:
                        boolean unused = DocScannerView.this.f14486f = false;
                        DocScannerView.this.m16390a(DocScannerView.this.f14490j);
                        int unused2 = DocScannerView.this.f14492l = 1;
                        DocScannerView.this.m16398f();
                        return;
                    case 2:
                        LogUtil.m15954d(DocScannerView.f14482b, "handleMessage MSG_HIDE_POINTS");
                        boolean unused3 = DocScannerView.this.f14488h = true;
                        boolean unused4 = DocScannerView.this.f14487g = false;
                        int unused5 = DocScannerView.this.f14492l = 1;
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public DocScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f14483c = resources.getColor(R.color.doc_scanner_view_line_color);
        this.f14484d = resources.getColor(R.color.doc_scanner_view_bg_color);
        this.f14497q = new Paint();
        this.f14497q.setAntiAlias(true);
        this.f14497q.setStyle(Paint.Style.STROKE);
        this.f14497q.setStrokeWidth(resources.getDimension(R.dimen.doc_scanner_stroke_width));
    }

    public void setPoint(Point[] pointArr) {
        if (!PatchProxy.proxy(new Object[]{pointArr}, this, f14481a, false, 8319, new Class[]{Point[].class}, Void.TYPE).isSupported && !this.f14485e) {
            if (this.f14489i != null) {
                if (this.f14489i.size() != pointArr.length) {
                    m16397e();
                }
                if ((pointArr.length > 0 && this.f14489i.size() == 0) || (pointArr.length == 0 && this.f14489i.size() > 0)) {
                    this.f14490j = pointArr;
                    if (!this.f14486f) {
                        this.f14486f = true;
                        this.f14500t.sendEmptyMessageDelayed(1, 0);
                        return;
                    }
                    return;
                }
            }
            if (this.f14486f) {
                this.f14486f = false;
                this.f14500t.removeMessages(1);
            }
            if (!this.f14493m) {
                m16390a(pointArr);
                m16398f();
            }
        }
    }

    /* renamed from: a */
    public void mo22826a() {
        if (!PatchProxy.proxy(new Object[0], this, f14481a, false, 8320, new Class[0], Void.TYPE).isSupported) {
            this.f14485e = true;
            mo22829c();
        }
    }

    /* renamed from: b */
    public void mo22828b() {
        if (!PatchProxy.proxy(new Object[0], this, f14481a, false, 8321, new Class[0], Void.TYPE).isSupported) {
            this.f14485e = false;
            m16397e();
        }
    }

    /* renamed from: e */
    private void m16397e() {
        if (!PatchProxy.proxy(new Object[0], this, f14481a, false, 8322, new Class[0], Void.TYPE).isSupported) {
            this.f14487g = false;
            this.f14488h = false;
            this.f14500t.removeMessages(1);
        }
    }

    public void setTextureTranslationY(int i) {
        this.f14496p = i;
    }

    /* renamed from: c */
    public void mo22829c() {
        if (!PatchProxy.proxy(new Object[0], this, f14481a, false, 8323, new Class[0], Void.TYPE).isSupported) {
            if (this.f14489i != null) {
                this.f14489i.clear();
            }
            m16397e();
            this.f14500t.removeMessages(1);
            this.f14486f = false;
            postInvalidate();
        }
    }

    public void setOrientation(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14481a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8324, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f14498r != i) {
            this.f14498r = i;
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16390a(Point[] pointArr) {
        int i = 0;
        if (PatchProxy.proxy(new Object[]{pointArr}, this, f14481a, false, 8325, new Class[]{Point[].class}, Void.TYPE).isSupported || this.f14489i == null) {
            return;
        }
        if (pointArr.length != this.f14489i.size()) {
            this.f14489i.clear();
            int length = pointArr.length;
            while (i < length) {
                this.f14489i.add(new C2686a((Point) null, pointArr[i]));
                i++;
            }
            return;
        }
        while (i < pointArr.length) {
            this.f14489i.get(i).f14503a = this.f14489i.get(i).f14504b;
            this.f14489i.get(i).f14504b = pointArr[i];
            i++;
        }
    }

    /* renamed from: com.meizu.media.camera.views.DocScannerView$a */
    private static class C2686a {

        /* renamed from: a */
        Point f14503a;

        /* renamed from: b */
        Point f14504b;

        C2686a(Point point, Point point2) {
            this.f14503a = point;
            this.f14504b = point2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m16398f() {
        if (!PatchProxy.proxy(new Object[0], this, f14481a, false, 8326, new Class[0], Void.TYPE).isSupported) {
            this.f14493m = true;
            this.f14491k = 1;
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r13) {
        /*
            r12 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r13
            com.meizu.savior.ChangeQuickRedirect r3 = f14481a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.graphics.Canvas> r2 = android.graphics.Canvas.class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 8327(0x2087, float:1.1669E-41)
            r2 = r12
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            boolean r1 = r12.f14488h
            r2 = 15
            if (r1 == 0) goto L_0x0027
            int r1 = r12.f14492l
            if (r1 >= r2) goto L_0x0137
        L_0x0027:
            java.util.ArrayList<com.meizu.media.camera.views.DocScannerView$a> r1 = r12.f14489i
            if (r1 == 0) goto L_0x0137
            java.util.ArrayList<com.meizu.media.camera.views.DocScannerView$a> r1 = r12.f14489i
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0137
            int r1 = r12.f14494n
            int r3 = r12.f14495o
            float r3 = (float) r3
            float r1 = (float) r1
            float r3 = r3 / r1
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r1 = com.meizu.media.camera.util.CameraUtil.m15829a((float) r3)
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r3 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_4_3
            if (r1 != r3) goto L_0x0052
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13874aa
            if (r1 != 0) goto L_0x004d
            boolean r1 = com.meizu.media.camera.util.NavigationBarUtils.m15972a()
            if (r1 == 0) goto L_0x004d
            goto L_0x005f
        L_0x004d:
            int r1 = com.meizu.media.camera.util.CameraUtil.m15901h()
            goto L_0x0060
        L_0x0052:
            boolean r3 = com.meizu.media.camera.util.DeviceHelper.f13874aa
            if (r3 == 0) goto L_0x005f
            com.meizu.media.camera.util.CameraUtil$ScreeAspectRatio r3 = com.meizu.media.camera.util.CameraUtil.ScreeAspectRatio.Ratio_16_9
            if (r3 != r1) goto L_0x005f
            int r1 = com.meizu.media.camera.util.CameraUtil.m15901h()
            goto L_0x0060
        L_0x005f:
            r1 = 0
        L_0x0060:
            int r3 = r12.f14496p
            int r1 = r1 - r3
            r13.save()
            int r3 = r12.f14491k
            r4 = 8
            if (r3 <= r4) goto L_0x006e
            r12.f14491k = r4
        L_0x006e:
            int r3 = r12.f14492l
            if (r3 <= r2) goto L_0x0074
            r12.f14492l = r2
        L_0x0074:
            java.util.ArrayList<com.meizu.media.camera.views.DocScannerView$a> r3 = r12.f14489i
            int r3 = r3.size()
            android.graphics.Point[] r3 = new android.graphics.Point[r3]
            r5 = 0
        L_0x007d:
            java.util.ArrayList<com.meizu.media.camera.views.DocScannerView$a> r6 = r12.f14489i
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x00e2
            java.util.ArrayList<com.meizu.media.camera.views.DocScannerView$a> r6 = r12.f14489i
            java.lang.Object r6 = r6.get(r5)
            com.meizu.media.camera.views.DocScannerView$a r6 = (com.meizu.media.camera.views.DocScannerView.C2686a) r6
            android.graphics.Point r7 = r6.f14503a
            if (r7 == 0) goto L_0x00c0
            android.graphics.Point r7 = r6.f14503a
            int r7 = r7.x
            float r7 = (float) r7
            android.graphics.Point r9 = r6.f14504b
            int r9 = r9.x
            android.graphics.Point r10 = r6.f14503a
            int r10 = r10.x
            int r9 = r9 - r10
            float r9 = (float) r9
            int r10 = r12.f14491k
            float r10 = (float) r10
            r11 = 1090519040(0x41000000, float:8.0)
            float r10 = r10 / r11
            float r9 = r9 * r10
            float r7 = r7 + r9
            android.graphics.Point r9 = r6.f14503a
            int r9 = r9.y
            float r9 = (float) r9
            android.graphics.Point r10 = r6.f14504b
            int r10 = r10.y
            android.graphics.Point r6 = r6.f14503a
            int r6 = r6.y
            int r10 = r10 - r6
            float r6 = (float) r10
            int r10 = r12.f14491k
            float r10 = (float) r10
            float r10 = r10 / r11
            float r6 = r6 * r10
            float r9 = r9 + r6
            goto L_0x00ca
        L_0x00c0:
            android.graphics.Point r7 = r6.f14504b
            int r7 = r7.x
            float r7 = (float) r7
            android.graphics.Point r6 = r6.f14504b
            int r6 = r6.y
            float r9 = (float) r6
        L_0x00ca:
            int r6 = r12.f14494n
            float r6 = (float) r6
            float r6 = r6 - r9
            float r9 = r12.f14499s
            float r6 = r6 / r9
            float r9 = r12.f14499s
            float r7 = r7 / r9
            float r9 = (float) r1
            float r7 = r7 + r9
            android.graphics.Point r9 = new android.graphics.Point
            int r6 = (int) r6
            int r7 = (int) r7
            r9.<init>(r6, r7)
            r3[r5] = r9
            int r5 = r5 + 1
            goto L_0x007d
        L_0x00e2:
            boolean r1 = r12.f14488h
            r5 = 1097859072(0x41700000, float:15.0)
            r6 = 1132396544(0x437f0000, float:255.0)
            r7 = 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L_0x0101
            android.graphics.Paint r1 = r12.f14497q
            int r9 = r12.f14492l
            if (r9 >= r2) goto L_0x00fc
            int r9 = r12.f14492l
            float r9 = (float) r9
            float r9 = r9 / r5
            float r9 = r9 * r6
            int r5 = (int) r9
            int r5 = 255 - r5
            goto L_0x00fd
        L_0x00fc:
            r5 = 0
        L_0x00fd:
            r1.setAlpha(r5)
            goto L_0x0111
        L_0x0101:
            android.graphics.Paint r1 = r12.f14497q
            int r9 = r12.f14492l
            if (r9 >= r2) goto L_0x010e
            int r7 = r12.f14492l
            float r7 = (float) r7
            float r7 = r7 / r5
            float r7 = r7 * r6
            int r7 = (int) r7
        L_0x010e:
            r1.setAlpha(r7)
        L_0x0111:
            r12.m16388a((android.graphics.Canvas) r13, (android.graphics.Point[]) r3)
            boolean r1 = r12.f14487g
            if (r1 != 0) goto L_0x011a
            boolean r1 = r12.f14488h
        L_0x011a:
            r13.restore()
            int r1 = r12.f14491k
            if (r1 < r4) goto L_0x0129
            int r1 = r12.f14492l
            if (r1 >= r2) goto L_0x0126
            goto L_0x0129
        L_0x0126:
            r12.f14493m = r8
            goto L_0x013b
        L_0x0129:
            int r1 = r12.f14491k
            int r1 = r1 + r0
            r12.f14491k = r1
            int r1 = r12.f14492l
            int r1 = r1 + r0
            r12.f14492l = r1
            r12.invalidate()
            goto L_0x013b
        L_0x0137:
            r12.f14492l = r2
            r12.f14493m = r8
        L_0x013b:
            super.onDraw(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.DocScannerView.onDraw(android.graphics.Canvas):void");
    }

    /* renamed from: a */
    public void mo22827a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14481a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8328, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14494n = Math.min(i, i2);
            this.f14495o = Math.max(i, i2);
            this.f14499s = ((float) this.f14494n) / ((float) CameraUtil.m15809a());
        }
    }

    /* renamed from: a */
    private void m16388a(Canvas canvas, Point[] pointArr) {
        if (!PatchProxy.proxy(new Object[]{canvas, pointArr}, this, f14481a, false, 8329, new Class[]{Canvas.class, Point[].class}, Void.TYPE).isSupported && pointArr != null && pointArr.length != 0) {
            Path path = new Path();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < pointArr.length; i3++) {
                Point point = pointArr[i3];
                if (i3 == 0) {
                    i = point.x;
                    i2 = point.y;
                    path.moveTo((float) i, (float) i2);
                } else {
                    path.lineTo((float) point.x, (float) point.y);
                }
            }
            path.lineTo((float) i, (float) i2);
            this.f14497q.setAntiAlias(true);
            this.f14497q.setStyle(Paint.Style.STROKE);
            this.f14497q.setColor(this.f14483c);
            canvas.drawPath(path, this.f14497q);
            this.f14497q.setStyle(Paint.Style.FILL);
            this.f14497q.setColor(this.f14484d);
            canvas.drawPath(path, this.f14497q);
        }
    }
}
