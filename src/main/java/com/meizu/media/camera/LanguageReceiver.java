package com.meizu.media.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo27294d2 = {"Lcom/meizu/media/camera/LanguageReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: LanguageReceiver.kt */
public final class LanguageReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static ChangeQuickRedirect f6777a;

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Class[] clsArr = {Context.class, Intent.class};
        if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6777a, false, 1100, clsArr, Void.TYPE).isSupported) {
            C3443i.m21155b(context, "context");
            C3443i.m21155b(intent, "intent");
            if (C3443i.m21154a((Object) intent.getAction(), (Object) "android.intent.action.LOCALE_CHANGED")) {
                CameraUtil.m15896e(context);
            }
        }
    }
}
