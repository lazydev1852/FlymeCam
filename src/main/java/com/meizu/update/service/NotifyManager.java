package com.meizu.update.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import com.meizu.p055b.ReflectHelper;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.R;
import com.meizu.update.p090d.AppRestartManager;
import com.meizu.update.usage.UpdateUsageCollector;
import com.meizu.update.util.MinSdkChecker;
import com.meizu.update.util.Utility;

/* renamed from: com.meizu.update.service.a */
public class NotifyManager {

    /* renamed from: a */
    private Service f16335a;

    /* renamed from: b */
    private UpdateInfo f16336b;

    /* renamed from: c */
    private NotificationManager f16337c = ((NotificationManager) this.f16335a.getSystemService("notification"));

    /* renamed from: d */
    private Notification.Builder f16338d;

    public NotifyManager(Service service, UpdateInfo updateInfo) {
        this.f16335a = service;
        this.f16336b = updateInfo;
        mo24853n();
    }

    /* renamed from: a */
    public void mo24835a() {
        String a = m17880a(this.f16336b, (Context) this.f16335a);
        String format = String.format(this.f16335a.getString(R.string.mzuc_notification_message_s), new Object[]{this.f16336b.mVersionDesc});
        Notification.Builder builder = new Notification.Builder(this.f16335a);
        builder.setTicker(a);
        builder.setContentTitle(a);
        builder.setContentText(format);
        builder.setContentIntent(mo24847h());
        builder.setAutoCancel(true);
        m17890d(builder);
        m17882a(builder, mo24846g());
        m17881a(builder);
        if (MinSdkChecker.m17949b()) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.bigText(format);
            bigTextStyle.setBigContentTitle(a);
            builder.setStyle(bigTextStyle);
            builder.setContentInfo((CharSequence) null);
            builder.addAction(0, this.f16335a.getString(R.string.mzuc_update_later), mo24834a(false));
            builder.addAction(0, this.f16335a.getString(R.string.mzuc_update_immediately), mo24848i());
        }
        this.f16337c.notify(100, mo24838b(builder));
        UpdateUsageCollector.m17913a(this.f16335a).mo24856a(UpdateUsageCollector.UpdateAction.UpdateDisplay_Notification, this.f16336b.mVersionName, Utility.m17970b((Context) this.f16335a, this.f16335a.getPackageName()));
    }

    /* renamed from: b */
    public void mo24840b() {
        String b = m17888b(this.f16336b, this.f16335a);
        String string = this.f16335a.getString(R.string.mzuc_installing);
        Notification.Builder builder = new Notification.Builder(this.f16335a);
        builder.setTicker(b);
        builder.setContentTitle(b);
        builder.setContentText(string);
        builder.setOngoing(true);
        builder.setWhen(0);
        m17890d(builder);
        m17882a(builder, mo24846g());
        m17881a(builder);
        m17884a((Context) this.f16335a, builder);
        builder.setProgress(100, 0, true);
        this.f16337c.notify(100, mo24838b(builder));
    }

    /* renamed from: c */
    public void mo24841c() {
        m17891p();
        m17885a(this.f16335a.getString(R.string.mzuc_download_fail), mo24849j());
    }

    /* renamed from: d */
    public void mo24843d() {
        m17885a(this.f16335a.getString(R.string.mzuc_install_fail), mo24850k());
    }

    /* renamed from: e */
    public void mo24844e() {
        this.f16337c.cancel(100);
        Intent a = AppRestartManager.m17698a(this.f16335a);
        if (a == null) {
            a = new Intent();
        }
        PendingIntent activity = PendingIntent.getActivity(this.f16335a, 0, a, 134217728);
        String h = Utility.m17989h(this.f16335a);
        String format = String.format(this.f16335a.getString(R.string.mzuc_update_finish_format), new Object[]{this.f16336b.mVersionName});
        Notification.Builder builder = new Notification.Builder(this.f16335a);
        builder.setTicker(h);
        builder.setContentTitle(h);
        builder.setContentText(format);
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        m17890d(builder);
        m17882a(builder, mo24846g());
        m17881a(builder);
        if (activity != null) {
            builder.setContentIntent(activity);
        }
        this.f16337c.notify(101, mo24838b(builder));
    }

    /* renamed from: a */
    public void mo24837a(String str) {
        m17885a(this.f16335a.getString(R.string.mzuc_download_finish_install), mo24839b(str));
    }

    /* renamed from: a */
    public void mo24836a(int i, long j) {
        String b = m17888b(this.f16336b, this.f16335a);
        String format = String.format(this.f16335a.getString(R.string.mzuc_download_progress_desc_s), new Object[]{Utility.m17959a((double) j) + "/s", this.f16336b.mSize});
        if (this.f16338d == null) {
            m17887a(b, format, i);
            this.f16335a.startForeground(100, mo24838b(this.f16338d));
            return;
        }
        this.f16338d.setContentText(format);
        this.f16338d.setProgress(100, i, false);
        this.f16337c.notify(100, mo24838b(this.f16338d));
    }

    /* renamed from: a */
    private void m17887a(String str, String str2, int i) {
        Notification.Builder builder = new Notification.Builder(this.f16335a);
        builder.setTicker(str);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setContentIntent(mo24851l());
        builder.setOngoing(true);
        builder.setWhen(0);
        m17890d(builder);
        builder.setProgress(100, i, false);
        m17882a(builder, mo24846g());
        m17881a(builder);
        m17884a((Context) this.f16335a, builder);
        this.f16338d = builder;
    }

    /* renamed from: f */
    public void mo24845f() {
        m17891p();
        this.f16337c.cancel(100);
    }

    /* renamed from: a */
    public static void m17883a(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(101);
    }

    /* renamed from: a */
    private void m17885a(String str, PendingIntent pendingIntent) {
        m17886a(str, pendingIntent, 100);
    }

    /* renamed from: a */
    private void m17886a(String str, PendingIntent pendingIntent, int i) {
        String b = m17888b(this.f16336b, this.f16335a);
        Notification.Builder builder = new Notification.Builder(this.f16335a);
        builder.setTicker(b);
        builder.setContentTitle(b);
        builder.setContentText(str);
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        m17890d(builder);
        m17882a(builder, mo24846g());
        m17881a(builder);
        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }
        this.f16337c.notify(i, mo24838b(builder));
    }

    /* renamed from: a */
    public static String m17880a(UpdateInfo updateInfo, Context context) {
        String h = Utility.m17989h(context);
        return String.format(context.getString(R.string.mzuc_update_title_s), new Object[]{h, updateInfo.mVersionName});
    }

    /* renamed from: b */
    public static String m17888b(UpdateInfo updateInfo, Context context) {
        String h = Utility.m17989h(context);
        return String.format(context.getString(R.string.mzuc_update_msg_title_s), new Object[]{h, updateInfo.mVersionName});
    }

    /* renamed from: g */
    public Bitmap mo24846g() {
        return Utility.m17957a(this.f16335a.getPackageName(), (Context) this.f16335a);
    }

    /* renamed from: p */
    private void m17891p() {
        this.f16335a.stopForeground(true);
        this.f16337c.cancel(100);
        this.f16338d = null;
    }

    /* renamed from: h */
    public PendingIntent mo24847h() {
        return MzUpdateComponentService.m17861c(this.f16335a, this.f16336b);
    }

    /* renamed from: a */
    public PendingIntent mo24834a(boolean z) {
        return MzUpdateComponentService.m17829a((Context) this.f16335a, this.f16336b, z);
    }

    /* renamed from: i */
    public PendingIntent mo24848i() {
        return MzUpdateComponentService.m17827a((Context) this.f16335a, this.f16336b);
    }

    /* renamed from: j */
    public PendingIntent mo24849j() {
        return MzUpdateComponentService.m17866d(this.f16335a, this.f16336b);
    }

    /* renamed from: k */
    public PendingIntent mo24850k() {
        return MzUpdateComponentService.m17870e(this.f16335a, this.f16336b);
    }

    /* renamed from: l */
    public PendingIntent mo24851l() {
        return MzUpdateComponentService.m17854b(this.f16335a, this.f16336b);
    }

    /* renamed from: b */
    public PendingIntent mo24839b(String str) {
        return MzUpdateComponentService.m17828a((Context) this.f16335a, this.f16336b, str);
    }

    /* renamed from: a */
    public static final void m17882a(Notification.Builder builder, Bitmap bitmap) {
        builder.setSmallIcon(R.drawable.mzuc_stat_sys_update);
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
    }

    /* renamed from: a */
    public static final void m17884a(Context context, Notification.Builder builder) {
        try {
            ReflectHelper.m4009a(m17889c(builder), "setCircleProgressBar", (Class<?>[]) new Class[]{Boolean.TYPE}, new Object[]{true});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static final void m17881a(Notification.Builder builder) {
        try {
            ReflectHelper.m4009a(m17889c(builder), "setInternalApp", (Class<?>[]) new Class[]{Integer.TYPE}, new Object[]{1});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private static final Object m17889c(Notification.Builder builder) throws Exception {
        return ReflectHelper.m4008a((Object) builder, builder.getClass(), "mFlymeNotificationBuilder");
    }

    /* renamed from: b */
    public Notification mo24838b(Notification.Builder builder) {
        return MinSdkChecker.m17948a() ? builder.build() : builder.getNotification();
    }

    /* renamed from: c */
    public void mo24842c(String str) {
        String a = m17880a(this.f16336b, (Context) this.f16335a);
        String format = String.format(this.f16335a.getString(R.string.mzuc_notification_message_s), new Object[]{this.f16336b.mVersionDesc});
        Notification.Builder builder = new Notification.Builder(this.f16335a);
        builder.setTicker(a);
        builder.setContentTitle(a);
        builder.setContentText(format);
        builder.setContentIntent(mo24852m());
        builder.setAutoCancel(true);
        m17890d(builder);
        m17882a(builder, mo24846g());
        m17881a(builder);
        if (MinSdkChecker.m17949b()) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.bigText(format);
            bigTextStyle.setBigContentTitle(a);
            builder.setStyle(bigTextStyle);
            builder.setContentInfo((CharSequence) null);
            if (!this.f16336b.mNeedUpdate) {
                builder.addAction(0, this.f16335a.getString(R.string.mzuc_install_later), mo24834a(true));
            }
            builder.addAction(0, this.f16335a.getString(R.string.mzuc_install_immediately), mo24839b(str));
        }
        this.f16337c.notify(100, mo24838b(builder));
        UpdateUsageCollector.m17913a(this.f16335a).mo24856a(UpdateUsageCollector.UpdateAction.UpdateDisplay_Notification_Silent, this.f16336b.mVersionName, Utility.m17970b((Context) this.f16335a, this.f16335a.getPackageName()));
    }

    /* renamed from: m */
    public PendingIntent mo24852m() {
        return MzUpdateComponentService.m17876h(this.f16335a, this.f16336b);
    }

    /* renamed from: n */
    public void mo24853n() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f16337c.createNotificationChannel(new NotificationChannel("10050", "UpdateChannel", 2));
        }
    }

    /* renamed from: d */
    private void m17890d(Notification.Builder builder) {
        if (builder != null && Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("10050");
        }
    }

    /* renamed from: o */
    public Notification mo24854o() {
        Notification.Builder builder = new Notification.Builder(this.f16335a);
        m17890d(builder);
        return mo24838b(builder);
    }
}
