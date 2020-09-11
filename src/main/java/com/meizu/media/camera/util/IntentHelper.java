package com.meizu.media.camera.util;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.meizu.media.camera.mode.BackTraceMode;
import com.meizu.media.camera.mode.BarCodeMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.mode.FunnySnapMode;
import com.meizu.media.camera.mode.ManualMode;
import com.meizu.media.camera.mode.PortraitMode;
import com.meizu.media.camera.mode.SuperNightMode;
import com.meizu.media.camera.mode.TofMode;
import com.meizu.media.camera.mode.VideoMode;
import com.meizu.media.camera.simplify.MzSimplifyImageCaptureHandler;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.z */
public class IntentHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f14383a;

    /* renamed from: a */
    public static CameraModeType.ModeType m16297a(Intent intent) {
        Uri data;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent}, (Object) null, f14383a, true, 8102, new Class[]{Intent.class}, CameraModeType.ModeType.class);
        if (proxy.isSupported) {
            return (CameraModeType.ModeType) proxy.result;
        }
        CameraModeType.ModeType modeType = null;
        if (!TextUtils.equals(intent.getAction(), "android.intent.action.VIEW") || (data = intent.getData()) == null || !TextUtils.equals("flyme_3dtouch", data.getScheme())) {
            return null;
        }
        if (TextUtils.equals("/video", data.getPath())) {
            modeType = CameraModeType.ModeType.VIDEO;
        }
        return TextUtils.equals("/mirror", data.getPath()) ? CameraModeType.ModeType.AUTO : modeType;
    }

    /* renamed from: b */
    public static int m16300b(Intent intent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent}, (Object) null, f14383a, true, 8103, new Class[]{Intent.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (TextUtils.equals(intent.getAction(), "android.intent.action.VIEW")) {
            return 8;
        }
        if (BarCodeMode.m11237a(intent.getAction())) {
            return 11;
        }
        if (intent.getAction().contains("shortcut")) {
            return 10;
        }
        if (!VideoMode.m12118c(intent.getAction()) || MzSimplifyImageCaptureHandler.m13135b(intent.getAction())) {
            return FunnySnapMode.m11003g(intent.getAction()) ? 2 : 2;
        }
        return 6;
    }

    /* renamed from: a */
    public static CameraModeType.ModeType m16298a(Intent intent, ContentResolver contentResolver) {
        ChangeQuickRedirect changeQuickRedirect = f14383a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent, contentResolver}, (Object) null, changeQuickRedirect, true, 8104, new Class[]{Intent.class, ContentResolver.class}, CameraModeType.ModeType.class);
        if (proxy.isSupported) {
            return (CameraModeType.ModeType) proxy.result;
        }
        if (TextUtils.equals(intent.getAction(), "android.intent.action.VIEW") || contentResolver == null) {
            return m16297a(intent);
        }
        if (BackTraceMode.m11156a(intent, contentResolver)) {
            return CameraModeType.ModeType.BACK_TRACE;
        }
        if (BarCodeMode.m11237a(intent.getAction())) {
            return CameraModeType.ModeType.BARCODE;
        }
        if (VideoMode.m12118c(intent.getAction()) && !MzSimplifyImageCaptureHandler.m13135b(intent.getAction())) {
            return CameraModeType.ModeType.VIDEO;
        }
        if (FunnySnapMode.m11003g(intent.getAction())) {
            return CameraModeType.ModeType.FUNNY_SNAP;
        }
        if (ManualMode.m11620a(intent.getAction())) {
            return CameraModeType.ModeType.MANUAL;
        }
        if (PortraitMode.m11840a(intent.getAction())) {
            return CameraModeType.ModeType.PORTRAIT;
        }
        if (TofMode.f11116b.mo20658a(intent.getAction())) {
            return CameraModeType.ModeType.TOF;
        }
        if (SuperNightMode.m11955a(intent.getAction())) {
            return CameraModeType.ModeType.SUPER_NIGHT;
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m16299a(@NonNull Intent intent, String str, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent, str, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14383a, true, 8105, new Class[]{Intent.class, String.class, Boolean.TYPE}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : intent.getBooleanExtra(str, z);
    }
}
