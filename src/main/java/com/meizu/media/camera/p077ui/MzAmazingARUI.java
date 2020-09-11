package com.meizu.media.camera.p077ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.DeadSystemException;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzAmazingARUI;", "", "mContext", "Landroid/content/Context;", "mActivity", "Lcom/meizu/media/camera/CameraActivity;", "(Landroid/content/Context;Lcom/meizu/media/camera/CameraActivity;)V", "checkAmazingARSdkDlStatus", "", "downloadapk", "", "gotoAmazingAR", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.e */
public final class MzAmazingARUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12888a = null;

    /* renamed from: b */
    public static final C2462a f12889b = new C2462a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e */
    public static final String f12890e = f12890e;

    /* renamed from: f */
    private static final String f12891f = f12891f;

    /* renamed from: g */
    private static final LogUtil.C2630a f12892g = new LogUtil.C2630a("AmazingUI");

    /* renamed from: c */
    private final Context f12893c;

    /* renamed from: d */
    private final CameraActivity f12894d;

    public MzAmazingARUI(@NotNull Context context, @NotNull CameraActivity cameraActivity) {
        C3443i.m21155b(context, "mContext");
        C3443i.m21155b(cameraActivity, "mActivity");
        this.f12893c = context;
        this.f12894d = cameraActivity;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzAmazingARUI$Companion;", "", "()V", "DEEPLINK", "", "PACKAGE_NAME", "getPACKAGE_NAME", "()Ljava/lang/String;", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "isApplicationAvilible", "", "context", "Landroid/content/Context;", "appPackageName", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.e$a */
    /* compiled from: MzAmazingARUI.kt */
    public static final class C2462a {

        /* renamed from: a */
        public static ChangeQuickRedirect f12895a;

        private C2462a() {
        }

        public /* synthetic */ C2462a(DefaultConstructorMarker gVar) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final String mo21986a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12895a, false, 6415, new Class[0], String.class);
            return proxy.isSupported ? (String) proxy.result : MzAmazingARUI.f12890e;
        }

        /* renamed from: a */
        public final boolean mo21987a(@NotNull Context context, @NotNull String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, this, f12895a, false, 6416, new Class[]{Context.class, String.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            C3443i.m21155b(context, "context");
            C3443i.m21155b(str, "appPackageName");
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
                    if (installedPackages != null) {
                        int size = installedPackages.size();
                        for (int i = 0; i < size; i++) {
                            if (C3443i.m21154a((Object) str, (Object) installedPackages.get(i).packageName)) {
                                return true;
                            }
                        }
                    }
                } catch (DeadSystemException e) {
                    e.printStackTrace();
                }
            } else {
                List<PackageInfo> installedPackages2 = context.getPackageManager().getInstalledPackages(0);
                if (installedPackages2 != null) {
                    int size2 = installedPackages2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (C3443i.m21154a((Object) str, (Object) installedPackages2.get(i2).packageName)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public final void mo21983a() {
        if (PatchProxy.proxy(new Object[0], this, f12888a, false, 6412, new Class[0], Void.TYPE).isSupported || this.f12894d.mo17677n()) {
            return;
        }
        if (f12889b.mo21987a(this.f12893c, f12890e)) {
            LogUtil.m15952c(f12892g, "gotoAmazingAR");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(f12891f));
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            this.f12894d.startActivity(intent);
            return;
        }
        mo21985c();
    }

    /* renamed from: b */
    public final boolean mo21984b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12888a, false, 6413, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : f12889b.mo21987a(this.f12893c, f12890e);
    }

    /* renamed from: c */
    public final void mo21985c() {
        if (!PatchProxy.proxy(new Object[0], this, f12888a, false, 6414, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12892g;
            LogUtil.m15952c(aVar, "downloadapk: " + f12890e);
            try {
                String str = f12890e;
                String encode = URLEncoder.encode(f12891f, "UTF-8");
                Intent intent = new Intent("com.meizu.flyme.appcenter.action.perform", Uri.parse("http://app.meizu.com/apps/public/detail?package_name=" + str + "&goto_search_page=" + true + "&dplink=" + encode));
                intent.setPackage("com.meizu.mstore");
                intent.putExtra("perform_internal", false);
                intent.putExtra("source_apkname", "com.meizu.media.camera");
                intent.addFlags(268435456);
                this.f12893c.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                LogUtil.m15949b(f12892g, e.getMessage());
            } catch (UnsupportedEncodingException e2) {
                LogUtil.m15949b(f12892g, e2.getMessage());
            }
        }
    }
}
