package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class MzImageView extends AppCompatImageView {

    /* renamed from: a */
    public static ChangeQuickRedirect f14845a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14846b = new LogUtil.C2630a("MzImageView");

    public MzImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MzImageView(Context context) {
        super(context);
    }

    public MzImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14845a, false, 8619, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            try {
                super.onDraw(canvas);
            } catch (Exception unused) {
                LogUtil.m15952c(f14846b, "bitmap may be recycled !!!");
            }
        }
    }
}
