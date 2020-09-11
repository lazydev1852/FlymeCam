package com.meizu.media.camera.p077ui;

import androidx.viewpager.widget.ViewPager;
import com.meizu.media.camera.bean.StickerCategory;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ui.MzFunnySnapUI$1 */
class MzFunnySnapUI$1 implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f12617a;

    /* renamed from: b */
    final /* synthetic */ MzFunnySnapUI f12618b;

    /* renamed from: c */
    private int f12619c = 1;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    MzFunnySnapUI$1(MzFunnySnapUI pVar) {
        this.f12618b = pVar;
    }

    public void onPageSelected(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12617a, false, 7282, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (this.f12618b.f13403w.mo18781c(this.f12619c) != null) {
                this.f12618b.f13403w.mo18781c(this.f12619c).smoothScrollToPosition(0);
            }
            LogUtil.C2630a F = MzFunnySnapUI.f13325b;
            LogUtil.m15942a(F, "onPageSelected position:" + i);
            StickerCategory a = this.f12618b.f13403w.mo18776a(i);
            this.f12618b.f13336K.mo20453a(String.valueOf(a.mo19360a()));
            if (a.mo19369e().booleanValue()) {
                a.mo19362a((Boolean) false);
                this.f12618b.m15306J();
                this.f12618b.f13336K.mo20456a(String.valueOf(a.mo19360a()), false);
            }
            this.f12619c = i;
        }
    }
}
