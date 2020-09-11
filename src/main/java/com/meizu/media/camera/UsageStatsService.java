package com.meizu.media.camera;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.mediatek.camcorder.CamcorderProfileEx;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0014"}, mo27294d2 = {"Lcom/meizu/media/camera/UsageStatsService;", "Landroid/app/job/JobService;", "()V", "isScanSwitchOpened", "", "()Z", "onCreate", "", "onDestroy", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onStartJob", "params", "Landroid/app/job/JobParameters;", "onStopJob", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: UsageStatsService.kt */
public final class UsageStatsService extends JobService {

    /* renamed from: a */
    public static ChangeQuickRedirect f7402a;

    /* renamed from: b */
    public static final C1773a f7403b = new C1773a((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final LogUtil.C2630a f7404c = new LogUtil.C2630a("UsageStatsService");

    public int onStartCommand(@NotNull Intent intent, int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{intent, new Integer(i), new Integer(i2)}, this, f7402a, false, 2232, new Class[]{Intent.class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(intent, "intent");
        return 2;
    }

    /* renamed from: a */
    private final boolean m7838a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7402a, false, 2229, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13880ag) {
            return false;
        }
        Context applicationContext = getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(getPackageName() + "_preferences_camera", 0);
        Context applicationContext2 = getApplicationContext();
        C3443i.m21152a((Object) applicationContext2, "applicationContext");
        return C3443i.m21154a((Object) getApplicationContext().getString(R.string.setting_on_value), (Object) sharedPreferences.getString("mz_pref_barcode_in_auto_enable_key", applicationContext2.getResources().getString(R.string.setting_off_value)));
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, f7402a, false, 2230, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f7404c, "onCreate");
            super.onCreate();
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f7402a, false, CamcorderProfileEx.SLOW_MOTION_VGA_120FPS, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f7404c, "onDestroy");
            super.onDestroy();
        }
    }

    public boolean onStartJob(@NotNull JobParameters jobParameters) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{jobParameters}, this, f7402a, false, 2233, new Class[]{JobParameters.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(jobParameters, "params");
        UsageStatsHelper.m16042a(getApplicationContext()).mo22691a("scan_switch", "value", m7838a() ? "1" : "0");
        return false;
    }

    public boolean onStopJob(@NotNull JobParameters jobParameters) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{jobParameters}, this, f7402a, false, 2234, new Class[]{JobParameters.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(jobParameters, "params");
        LogUtil.C2630a aVar = f7404c;
        LogUtil.m15952c(aVar, "on stop job: " + jobParameters.getJobId());
        return false;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/UsageStatsService$Companion;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.UsageStatsService$a */
    /* compiled from: UsageStatsService.kt */
    public static final class C1773a {
        private C1773a() {
        }

        public /* synthetic */ C1773a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
