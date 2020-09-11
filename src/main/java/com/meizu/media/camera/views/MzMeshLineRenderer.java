package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.views.h */
public class MzMeshLineRenderer extends OverlayRenderer {

    /* renamed from: a */
    public static ChangeQuickRedirect f15350a;

    /* renamed from: b */
    private int f15351b;

    /* renamed from: c */
    private int f15352c;

    /* renamed from: d */
    private int f15353d;

    /* renamed from: e */
    private Paint f15354e = new Paint();

    /* renamed from: f */
    private Point[] f15355f;

    /* renamed from: g */
    private int f15356g;

    /* renamed from: h */
    private boolean f15357h;

    /* renamed from: i */
    private boolean f15358i;

    public MzMeshLineRenderer(Context context) {
        this.f15354e.setColor(1090519039);
        this.f15354e.setStrokeWidth(2.0f);
        this.f15354e.setStyle(Paint.Style.STROKE);
        this.f15356g = context.getResources().getDimensionPixelOffset(R.dimen.mz_filter_height);
    }

    /* renamed from: a */
    public void mo23346a(RectF rectF, Boolean bool, boolean z) {
        if (!PatchProxy.proxy(new Object[]{rectF, bool, new Byte(z ? (byte) 1 : 0)}, this, f15350a, false, 8624, new Class[]{RectF.class, Boolean.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (((float) this.f15351b) != rectF.width() || ((float) this.f15352c) != rectF.height() || ((float) this.f15353d) != rectF.top || this.f15357h != z || this.f15358i != bool.booleanValue()) {
                this.f15351b = (int) rectF.width();
                this.f15352c = (int) rectF.height();
                this.f15353d = (int) rectF.top;
                this.f15357h = z;
                this.f15358i = bool.booleanValue();
                if (this.f15355f == null) {
                    this.f15355f = new Point[8];
                    for (int i = 0; i < 8; i++) {
                        this.f15355f[i] = new Point();
                    }
                }
                this.f15355f[0].x = (this.f15351b / 3) - 1;
                this.f15355f[0].y = (int) rectF.top;
                this.f15355f[1].x = this.f15355f[0].x;
                this.f15355f[1].y = this.f15352c + ((int) rectF.top);
                this.f15355f[2].x = (this.f15351b / 3) * 2;
                this.f15355f[2].y = this.f15355f[0].y;
                this.f15355f[3].x = this.f15355f[2].x;
                this.f15355f[3].y = this.f15355f[1].y;
                this.f15355f[4].x = 0;
                this.f15355f[4].y = ((this.f15352c / 3) - 1) + ((int) rectF.top);
                this.f15355f[5].x = this.f15351b;
                this.f15355f[5].y = this.f15355f[4].y;
                this.f15355f[6].x = 0;
                this.f15355f[6].y = ((this.f15352c / 3) * 2) + ((int) rectF.top);
                this.f15355f[7].x = this.f15351b;
                this.f15355f[7].y = this.f15355f[6].y;
                mo23407o();
            }
        }
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15350a, false, 8625, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f15355f != null && this.f15355f.length > 0) {
            for (int i = 0; i < 4; i++) {
                int i2 = i * 2;
                int i3 = i2 + 1;
                canvas.drawLine((float) this.f15355f[i2].x, (float) this.f15355f[i2].y, (float) this.f15355f[i3].x, (float) this.f15355f[i3].y, this.f15354e);
            }
        }
    }
}
