package com.meizu.media.camera.portrait;

import android.graphics.Point;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, mo27294d2 = {"Lcom/meizu/media/camera/portrait/DualcamMeta;", "", "()V", "af", "", "getAf", "()Z", "setAf", "(Z)V", "camParam", "Lcom/meizu/media/camera/portrait/CameraImageParam;", "getCamParam", "()Lcom/meizu/media/camera/portrait/CameraImageParam;", "setCamParam", "(Lcom/meizu/media/camera/portrait/CameraImageParam;)V", "face", "Lcom/meizu/media/camera/portrait/BokehFace;", "getFace", "()Lcom/meizu/media/camera/portrait/BokehFace;", "setFace", "(Lcom/meizu/media/camera/portrait/BokehFace;)V", "focusPoint", "Landroid/graphics/Point;", "getFocusPoint", "()Landroid/graphics/Point;", "setFocusPoint", "(Landroid/graphics/Point;)V", "i32DeviceRoll", "", "getI32DeviceRoll", "()I", "setI32DeviceRoll", "(I)V", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: DualcamMeta.kt */
public final class DualcamMeta {
    public static ChangeQuickRedirect changeQuickRedirect;

    /* renamed from: af */
    private boolean f11407af = true;
    @Nullable
    private CameraImageParam camParam;
    @Nullable
    private BokehFace face;
    @NotNull
    private Point focusPoint = new Point();
    private int i32DeviceRoll;

    @Nullable
    public final CameraImageParam getCamParam() {
        return this.camParam;
    }

    public final void setCamParam(@Nullable CameraImageParam cameraImageParam) {
        this.camParam = cameraImageParam;
    }

    @Nullable
    public final BokehFace getFace() {
        return this.face;
    }

    public final void setFace(@Nullable BokehFace bokehFace) {
        this.face = bokehFace;
    }

    @NotNull
    public final Point getFocusPoint() {
        return this.focusPoint;
    }

    public final void setFocusPoint(@NotNull Point point) {
        if (!PatchProxy.proxy(new Object[]{point}, this, changeQuickRedirect, false, 5405, new Class[]{Point.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(point, "<set-?>");
            this.focusPoint = point;
        }
    }

    public final boolean getAf() {
        return this.f11407af;
    }

    public final void setAf(boolean z) {
        this.f11407af = z;
    }

    public final int getI32DeviceRoll() {
        return this.i32DeviceRoll;
    }

    public final void setI32DeviceRoll(int i) {
        this.i32DeviceRoll = i;
    }
}
