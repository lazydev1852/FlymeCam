package com.meizu.media.camera.p077ui;

import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\t\u0010\u0011\u001a\u00020\u0000H\u0002R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/LensSwitchIcon;", "", "id", "", "cameraId", "hintId", "(Ljava/lang/String;IIII)V", "getCameraId", "()I", "setCameraId", "(I)V", "getHintId", "setHintId", "getId", "setId", "getLensSwitchIcon", "camId", "next", "ICON_SUPER_WIDE_ANGLE", "ICON_WIDE_ANGLE", "ICON_TELEPHOTO", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.LensSwitchIcon */
/* compiled from: LensSwitchIcon.kt */
public enum LensSwitchIcon {
    ;
    
    public static ChangeQuickRedirect changeQuickRedirect;
    private int cameraId;
    private int hintId;

    /* renamed from: id */
    private int f12305id;

    private LensSwitchIcon(int i, int i2, int i3) {
        this.f12305id = i;
        this.cameraId = i2;
        this.hintId = i3;
    }

    public final int getCameraId() {
        return this.cameraId;
    }

    public final int getHintId() {
        return this.hintId;
    }

    public final int getId() {
        return this.f12305id;
    }

    public final void setCameraId(int i) {
        this.cameraId = i;
    }

    public final void setHintId(int i) {
        this.hintId = i;
    }

    public final void setId(int i) {
        this.f12305id = i;
    }

    static {
        LensSwitchIcon[] lensSwitchIconArr = new LensSwitchIcon[3];
        LensSwitchIcon lensSwitchIcon = new LensSwitchIcon("ICON_SUPER_WIDE_ANGLE", 0, R.drawable.mz_icon_super_wide_angle, DeviceHelper.f14029du, DeviceHelper.f14030dv != -1 ? R.string.mz_hint_just_open_wideangle : R.string.mz_hint_open_wideangle);
        ICON_SUPER_WIDE_ANGLE = lensSwitchIcon;
        lensSwitchIconArr[0] = lensSwitchIcon;
        LensSwitchIcon lensSwitchIcon2 = new LensSwitchIcon("ICON_WIDE_ANGLE", 1, R.drawable.mz_icon_wide_angle, 0, DeviceHelper.f14030dv != -1 ? R.string.mz_hint_just_close_wideangle : R.string.mz_hint_close_wideangle);
        ICON_WIDE_ANGLE = lensSwitchIcon2;
        lensSwitchIconArr[1] = lensSwitchIcon2;
        LensSwitchIcon lensSwitchIcon3 = new LensSwitchIcon("ICON_TELEPHOTO", 2, R.drawable.mz_icon_telephoto, DeviceHelper.f13949bw, R.string.mz_hint_open_telephoto);
        ICON_TELEPHOTO = lensSwitchIcon3;
        lensSwitchIconArr[2] = lensSwitchIcon3;
        $VALUES = lensSwitchIconArr;
    }

    @NotNull
    public final LensSwitchIcon next() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 6256, new Class[0], LensSwitchIcon.class);
        if (proxy.isSupported) {
            return (LensSwitchIcon) proxy.result;
        }
        switch (C2427a.f12649a[ordinal()]) {
            case 1:
                return ICON_WIDE_ANGLE;
            case 2:
                if (DeviceHelper.f14027ds) {
                    return ICON_SUPER_WIDE_ANGLE;
                }
                if ((CameraModeType.m10983m(CameraModeType.ModeType.MANUAL) || (DeviceHelper.f13863aP && CameraModeType.m10983m(CameraModeType.ModeType.VIDEO))) && DeviceHelper.f14031dw) {
                    return ICON_TELEPHOTO;
                }
                return ICON_WIDE_ANGLE;
            case 3:
                if ((CameraModeType.m10983m(CameraModeType.ModeType.MANUAL) || (DeviceHelper.f13863aP && CameraModeType.m10983m(CameraModeType.ModeType.VIDEO))) && DeviceHelper.f14031dw) {
                    return ICON_TELEPHOTO;
                }
                return ICON_WIDE_ANGLE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final LensSwitchIcon getLensSwitchIcon(int i) {
        if (i == ICON_WIDE_ANGLE.cameraId) {
            return ICON_WIDE_ANGLE;
        }
        if (i == ICON_TELEPHOTO.cameraId) {
            return ICON_TELEPHOTO;
        }
        if (i == ICON_SUPER_WIDE_ANGLE.cameraId) {
            return ICON_SUPER_WIDE_ANGLE;
        }
        return ICON_WIDE_ANGLE;
    }
}
