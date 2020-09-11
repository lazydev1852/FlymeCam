package com.meizu.media.camera.stereobokeh;

import android.util.Log;
import com.meizu.media.camera.portrait.BokehFace;
import com.meizu.media.camera.portrait.CameraImageParam;
import com.meizu.media.camera.portrait.FocusPoint;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH J\t\u0010\u000e\u001a\u00020\u000fH JQ\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH J\u0019\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H JA\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\rH J\u0011\u0010%\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u000fH ¨\u0006'"}, mo27294d2 = {"Lcom/meizu/media/camera/stereobokeh/TofBokehUtil;", "", "()V", "doRegistration", "", "tofdata", "", "calidata", "", "max_dep", "", "size", "dump", "", "initPreview", "", "previewProcess", "hEngine", "previewData", "previewData2", "width", "height", "rowstrite", "tofwidth", "tofheight", "tofrowstrite", "setCaliData", "setMetaData", "imageParams", "Lcom/meizu/media/camera/portrait/CameraImageParam;", "face", "Lcom/meizu/media/camera/portrait/BokehFace;", "point", "Lcom/meizu/media/camera/portrait/FocusPoint;", "blurIntensity", "i32DeviceRoll", "bRefocusOn", "uninitPreview", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: TofBokehUtil.kt */
public final class TofBokehUtil {

    /* renamed from: a */
    public static final TofBokehUtil f12194a = new TofBokehUtil();

    @NotNull
    public final native synchronized short[] doRegistration(@NotNull byte[] bArr, @NotNull int[] iArr, int i, int i2, boolean z);

    public final native long initPreview();

    public final native synchronized int previewProcess(long j, @NotNull byte[] bArr, @NotNull byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6);

    public final native synchronized int setCaliData(long j, @NotNull byte[] bArr);

    public final native synchronized int setMetaData(long j, @NotNull CameraImageParam cameraImageParam, @NotNull BokehFace bokehFace, @NotNull FocusPoint focusPoint, int i, int i2, boolean z);

    public final native void uninitPreview(long j);

    static {
        try {
            Log.i("TofBokehUtil", "loadLibrary totbokehsdk");
            System.loadLibrary("totbokehsdk");
        } catch (UnsatisfiedLinkError e) {
            Log.e("TofBokehUtil", "loadLibrary totbokehsdk error");
            e.printStackTrace();
        }
    }

    private TofBokehUtil() {
    }
}
