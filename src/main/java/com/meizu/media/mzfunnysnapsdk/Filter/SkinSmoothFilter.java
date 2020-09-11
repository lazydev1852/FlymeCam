package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.opengl.GLES20;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class SkinSmoothFilter extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    private float aaCoef;
    private int gHaaCoef;
    private int gHiternum;
    private int gHmixCoef;
    private int gHmixSoftLightCoef;
    private int ginputHeight;
    private int ginputWidth;
    private int iternum;
    private float mixCoef;
    private float mixSoftLightCoef;

    public void onSizeChanged(int i, int i2) {
    }

    public SkinSmoothFilter(Resources resources) {
        super(resources);
        setSmoothFlag(50);
        setSoftLightFlag(50);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9126, new Class[0], Void.TYPE).isSupported) {
            if (GlobalParams.BEAUTY_QUALITY == GlobalParams.BEAUTY_QUALITY_HIGH) {
                createProgramByAssetsFile("shader/beauty/skinsmooth_vertex.glsl", "shader/beauty/skinsmooth_fragment.glsl");
            } else {
                createProgramByAssetsFile("shader/beauty/skinsmooth_vertex_lowquality.glsl", "shader/beauty/skinsmooth_fragment_lowquality.glsl");
            }
            this.gHaaCoef = GLES20.glGetUniformLocation(this.mProgram, "aaCoef");
            this.gHmixCoef = GLES20.glGetUniformLocation(this.mProgram, "mixCoef");
            this.gHmixSoftLightCoef = GLES20.glGetUniformLocation(this.mProgram, "mixSoftLightCof");
            this.gHiternum = GLES20.glGetUniformLocation(this.mProgram, "iternum");
            this.ginputHeight = GLES20.glGetUniformLocation(this.mProgram, "mInputHeight");
            this.ginputWidth = GLES20.glGetUniformLocation(this.mProgram, "mInputWidth");
        }
    }

    public void setSmoothFlag(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 9127, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            switch (i) {
                case 1:
                    m16919a(1, 0.19f, 0.54f);
                    return;
                case 2:
                    m16919a(2, 0.29f, 0.54f);
                    return;
                case 3:
                    m16919a(3, 0.17f, 0.39f);
                    return;
                case 4:
                    m16919a(3, 0.25f, 0.54f);
                    return;
                case 5:
                    m16919a(4, 0.13f, 0.54f);
                    return;
                case 6:
                    m16919a(4, 0.19f, 0.69f);
                    return;
                default:
                    m16919a(0, 0.0f, 0.0f);
                    return;
            }
        }
    }

    public void setSoftLightFlag(int i) {
        this.mixSoftLightCoef = ((float) i) / 100.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setFlag(int r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r8 = 0
            r1[r8] = r2
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Integer.TYPE
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 9128(0x23a8, float:1.2791E-41)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            super.setFlag(r10)
            float r10 = (float) r10
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r10 / r1
            r1 = 1086324736(0x40c00000, float:6.0)
            float r10 = r10 * r1
            r1 = 0
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            r3 = 2
            r4 = 1056964608(0x3f000000, float:0.5)
            r5 = 4
            r6 = 3
            if (r2 < 0) goto L_0x003d
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x003d
        L_0x003b:
            r10 = 0
            goto L_0x007e
        L_0x003d:
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r4 = 1069547520(0x3fc00000, float:1.5)
            if (r2 < 0) goto L_0x0049
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0049
            r10 = 1
            goto L_0x007e
        L_0x0049:
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r4 = 1075838976(0x40200000, float:2.5)
            if (r2 < 0) goto L_0x0055
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0055
            r10 = 2
            goto L_0x007e
        L_0x0055:
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r4 = 1080033280(0x40600000, float:3.5)
            if (r2 < 0) goto L_0x0061
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0061
            r10 = 3
            goto L_0x007e
        L_0x0061:
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r4 = 1083179008(0x40900000, float:4.5)
            if (r2 < 0) goto L_0x006d
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x006d
            r10 = 4
            goto L_0x007e
        L_0x006d:
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r4 = 1085276160(0x40b00000, float:5.5)
            if (r2 < 0) goto L_0x0079
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0079
            r10 = 5
            goto L_0x007e
        L_0x0079:
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 < 0) goto L_0x003b
            r10 = 6
        L_0x007e:
            r2 = 1044549468(0x3e428f5c, float:0.19)
            r4 = 1057635697(0x3f0a3d71, float:0.54)
            switch(r10) {
                case 0: goto L_0x00b4;
                case 1: goto L_0x00b0;
                case 2: goto L_0x00a9;
                case 3: goto L_0x009f;
                case 4: goto L_0x0099;
                case 5: goto L_0x0092;
                case 6: goto L_0x008b;
                default: goto L_0x0087;
            }
        L_0x0087:
            r9.m16919a(r8, r1, r1)
            goto L_0x00ba
        L_0x008b:
            r10 = 1060152279(0x3f30a3d7, float:0.69)
            r9.m16919a(r5, r2, r10)
            goto L_0x00ba
        L_0x0092:
            r10 = 1040522936(0x3e051eb8, float:0.13)
            r9.m16919a(r5, r10, r4)
            goto L_0x00ba
        L_0x0099:
            r10 = 1048576000(0x3e800000, float:0.25)
            r9.m16919a(r6, r10, r4)
            goto L_0x00ba
        L_0x009f:
            r10 = 1043207291(0x3e2e147b, float:0.17)
            r0 = 1053273620(0x3ec7ae14, float:0.39)
            r9.m16919a(r6, r10, r0)
            goto L_0x00ba
        L_0x00a9:
            r10 = 1049918177(0x3e947ae1, float:0.29)
            r9.m16919a(r3, r10, r4)
            goto L_0x00ba
        L_0x00b0:
            r9.m16919a(r0, r2, r4)
            goto L_0x00ba
        L_0x00b4:
            r10 = 1008981770(0x3c23d70a, float:0.01)
            r9.m16919a(r0, r10, r10)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.Filter.SkinSmoothFilter.setFlag(int):void");
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9129, new Class[0], Void.TYPE).isSupported) {
            super.draw();
        }
    }

    /* renamed from: a */
    private void m16919a(int i, float f, float f2) {
        this.iternum = i;
        this.aaCoef = f;
        this.mixCoef = f2;
    }

    public void onSetExpandData() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9130, new Class[0], Void.TYPE).isSupported) {
            super.onSetExpandData();
            GLES20.glUniform1f(this.gHaaCoef, this.aaCoef);
            GLES20.glUniform1f(this.gHmixCoef, this.mixCoef);
            GLES20.glUniform1f(this.gHmixSoftLightCoef, this.mixSoftLightCoef);
            GLES20.glUniform1i(this.gHiternum, this.iternum);
            GLES20.glUniform1f(this.ginputHeight, (float) GlobalParams.DEFAULT_HEIGHT);
            GLES20.glUniform1f(this.ginputWidth, (float) GlobalParams.DEFAULT_WIDTH);
        }
    }
}
