package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.view.View;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ui.m */
public class MzFaceBeautyUI extends NullFaceBeautyUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13280a;

    /* renamed from: d */
    private static final LogUtil.C2630a f13281d = new LogUtil.C2630a("FaceBeautyUI");

    /* renamed from: b */
    private View f13282b;

    /* renamed from: c */
    private Context f13283c;

    /* renamed from: a */
    public void mo22298a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13280a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7160, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f13282b.setBackground(this.f13283c.getResources().getDrawable(R.drawable.mz_rect_fullscreen_black));
            } else {
                this.f13282b.setBackground(this.f13283c.getResources().getDrawable(R.drawable.mz_rect_black));
            }
        }
    }
}
