package com.meizu.media.camera.util;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.meizu.media.camera.UsageStatsService;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo27294d2 = {"Lcom/meizu/media/camera/util/UsageStatsScheduler;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mServiceComponent", "Landroid/content/ComponentName;", "isJobPollServiceOn", "", "jobScheduler", "Landroid/app/job/JobScheduler;", "scheduleJob", "", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.util.au */
public final class UsageStatsScheduler {

    /* renamed from: a */
    public static ChangeQuickRedirect f14184a;

    /* renamed from: b */
    public static final C2643a f14185b = new C2643a((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final LogUtil.C2630a f14186e = new LogUtil.C2630a("UsageStatsScheduler");

    /* renamed from: c */
    private ComponentName f14187c;

    /* renamed from: d */
    private final Context f14188d;

    public UsageStatsScheduler(@NotNull Context context) {
        C3443i.m21155b(context, "mContext");
        this.f14188d = context;
    }

    /* renamed from: a */
    public final void mo22723a() {
        if (!PatchProxy.proxy(new Object[0], this, f14184a, false, 8250, new Class[0], Void.TYPE).isSupported) {
            JobScheduler i = AndroidServices.m8287a().mo19010i();
            C3443i.m21152a((Object) i, "jobScheduler");
            if (m16093a(i)) {
                LogUtil.m15942a(f14186e, "scheduleJob has been poll");
                return;
            }
            if (this.f14187c == null) {
                this.f14187c = new ComponentName(this.f14188d, UsageStatsService.class);
            }
            ComponentName componentName = this.f14187c;
            if (componentName == null) {
                C3443i.m21151a();
            }
            JobInfo.Builder builder = new JobInfo.Builder(10011, componentName);
            builder.setRequiredNetworkType(1);
            builder.setPeriodic(2592000000L);
            builder.setPersisted(true);
            LogUtil.m15942a(f14186e, "Scheduling job");
            i.schedule(builder.build());
        }
    }

    /* renamed from: a */
    private final boolean m16093a(JobScheduler jobScheduler) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{jobScheduler}, this, f14184a, false, 8251, new Class[]{JobScheduler.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            C3443i.m21152a((Object) next, "jobInfo");
            if (next.getId() == 10011) {
                return true;
            }
        }
        return false;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo27294d2 = {"Lcom/meizu/media/camera/util/UsageStatsScheduler$Companion;", "", "()V", "JOB_PERIODIC", "", "JOB_SCHEDULER_ID", "", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.util.au$a */
    /* compiled from: UsageStatsScheduler.kt */
    public static final class C2643a {
        private C2643a() {
        }

        public /* synthetic */ C2643a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
