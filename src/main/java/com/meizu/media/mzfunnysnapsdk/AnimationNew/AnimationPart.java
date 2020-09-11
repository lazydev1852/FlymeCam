package com.meizu.media.mzfunnysnapsdk.AnimationNew;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class AnimationPart {
    public static ChangeQuickRedirect changeQuickRedirect;
    public String align;
    public int frameCount;
    public int framePerSecond;
    public boolean globalScaleFactor;
    public int height;

    /* renamed from: id */
    public String f15596id;
    public float localScale;
    public FacePoint2D position_X;
    public FacePoint2D position_Y;
    public FacePoint2D scale_A;
    public FacePoint2D scale_B;
    public int triggerAction;
    public int triggerDelay;
    public int triggerLoop;
    public boolean triggerStop;
    public int width;
    public float zPosition;

    public String showPoint(FacePoint2D facePoint2D) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{facePoint2D}, this, changeQuickRedirect, false, 9016, new Class[]{FacePoint2D.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "x:" + facePoint2D.f15597x + ", y:" + facePoint2D.f15598y + ", index:" + facePoint2D.index;
    }
}
