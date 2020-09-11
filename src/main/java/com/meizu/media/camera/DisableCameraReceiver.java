package com.meizu.media.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.text.C3467f;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, mo27294d2 = {"Lcom/meizu/media/camera/DisableCameraReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "disableComponent", "", "context", "Landroid/content/Context;", "klass", "", "hasBackCamera", "", "hasCamera", "onReceive", "intent", "Landroid/content/Intent;", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: DisableCameraReceiver.kt */
public final class DisableCameraReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static ChangeQuickRedirect f6744a;

    /* renamed from: b */
    public static final C1630a f6745b = new C1630a((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final LogUtil.C2630a f6746c = new LogUtil.C2630a("DisableCameraReceiver");

    /* renamed from: d */
    private static final String[] f6747d = {"com.meizu.media.camera.CameraLauncher"};

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6744a, false, 986, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(context, "context");
            C3443i.m21155b(intent, "intent");
            if (C3467f.m21230a(intent.getAction(), "android.intent.action.BOOT_COMPLETED", false, 2, (Object) null) || C3467f.m21230a(intent.getAction(), "android.intent.action.LOCKED_BOOT_COMPLETED", false, 2, (Object) null)) {
                CameraUtil.m15891d(context);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/media/camera/DisableCameraReceiver$Companion;", "", "()V", "ACTIVITIES", "", "", "[Ljava/lang/String;", "CHECK_BACK_CAMERA_ONLY", "", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.DisableCameraReceiver$a */
    /* compiled from: DisableCameraReceiver.kt */
    public static final class C1630a {
        private C1630a() {
        }

        public /* synthetic */ C1630a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
