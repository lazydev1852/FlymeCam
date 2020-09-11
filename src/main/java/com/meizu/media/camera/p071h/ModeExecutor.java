package com.meizu.media.camera.p071h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.meizu.media.camera.p077ui.MzAmazingARUI;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.PreferenceUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.Constants;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.savior.utils.MD5Util;
import com.meizu.savior.utils.NetworkUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo27294d2 = {"Lcom/meizu/media/camera/net/ModeExecutor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "mRequestQueue", "Lcom/android/volley/RequestQueue;", "fetchAmazingAR", "", "processingAmazingAR", "str", "", "safeParseJson", "Lorg/json/JSONObject;", "s", "start", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.h.b */
public final class ModeExecutor {

    /* renamed from: a */
    public static ChangeQuickRedirect f10321a;

    /* renamed from: b */
    public static final C2100a f10322b = new C2100a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final LogUtil.C2630a f10323e = new LogUtil.C2630a("ModeExecutor");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f10324c;

    /* renamed from: d */
    private RequestQueue f10325d;

    public ModeExecutor(@NotNull Context context) {
        C3443i.m21155b(context, "context");
        Context applicationContext = context.getApplicationContext();
        C3443i.m21152a((Object) applicationContext, "context.applicationContext");
        this.f10324c = applicationContext;
    }

    /* renamed from: a */
    public final void mo20252a() {
        if (!PatchProxy.proxy(new Object[0], this, f10321a, false, 5341, new Class[0], Void.TYPE).isSupported && NetworkUtil.isNetworkAvailable(this.f10324c)) {
            long j = this.f10324c.getSharedPreferences(this.f10324c.getPackageName(), 0).getLong("modeUpdateDate", -1);
            LogUtil.C2630a aVar = f10323e;
            LogUtil.m15952c(aVar, "lastUpdateDate: " + j);
            if (System.currentTimeMillis() - j > 86400000) {
                if (this.f10325d == null) {
                    this.f10325d = Volley.m723a(this.f10324c);
                    RequestQueue nVar = this.f10325d;
                    if (nVar == null) {
                        C3443i.m21151a();
                    }
                    nVar.mo8704a();
                }
                m10600c();
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0014¨\u0006\u0005"}, mo27294d2 = {"com/meizu/media/camera/net/ModeExecutor$fetchAmazingAR$request$1", "Lcom/meizu/media/camera/net/Utf8StringRequest;", "getParams", "", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.h.b$b */
    /* compiled from: ModeExecutor.kt */
    public static final class C2101b extends Utf8StringRequest {

        /* renamed from: a */
        public static ChangeQuickRedirect f10326a;

        /* renamed from: b */
        final /* synthetic */ ModeExecutor f10327b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2101b(ModeExecutor bVar, int i, String str, Response.C0452b bVar2, Response.C0451a aVar) {
            super(i, str, bVar2, aVar);
            this.f10327b = bVar;
        }

        @NotNull
        public Map<String, String> getParams() throws AuthFailureError {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10326a, false, 5345, new Class[0], Map.class);
            if (proxy.isSupported) {
                return (Map) proxy.result;
            }
            HashMap hashMap = new HashMap();
            try {
                String str = this.f10327b.f10324c.getPackageManager().getPackageInfo(this.f10327b.f10324c.getPackageName(), 0).versionName;
                C3443i.m21152a((Object) str, "pkgInfo.versionName");
                hashMap.put(Constants.PARAM_APK_VERSION_NAME, str);
                String packageName = this.f10327b.f10324c.getPackageName();
                C3443i.m21152a((Object) packageName, "mContext.packageName");
                hashMap.put(Constants.PARAM_PKG_NAME, packageName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            try {
                PackageInfo packageInfo = this.f10327b.f10324c.getPackageManager().getPackageInfo(MzAmazingARUI.f12889b.mo21986a(), 0);
                String str2 = packageInfo.versionName;
                C3443i.m21152a((Object) str2, "amazingARInfo.versionName");
                hashMap.put("sv", str2);
                hashMap.put("svc", String.valueOf(packageInfo.versionCode));
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            Map<String, String> map = hashMap;
            String str3 = Build.DISPLAY;
            C3443i.m21152a((Object) str3, "Build.DISPLAY");
            map.put(Constants.PARAM_FLYME_VERSION, str3);
            String str4 = Build.MODEL;
            C3443i.m21152a((Object) str4, "Build.MODEL");
            map.put(Constants.PARAM_MODEL, str4);
            String sortAndSign = MD5Util.sortAndSign(MD5Util.getSecretKey(this.f10327b.f10324c), map);
            C3443i.m21152a((Object) sortAndSign, "MD5Util.sortAndSign(MD5U…retKey(mContext), params)");
            map.put("sign", sortAndSign);
            return map;
        }
    }

    /* renamed from: c */
    private final void m10600c() {
        if (!PatchProxy.proxy(new Object[0], this, f10321a, false, 5342, new Class[0], Void.TYPE).isSupported) {
            C2101b bVar = new C2101b(this, 1, "http://api.photos.meizu.com/ar/avatar/switch.do", new C2102c(this), C2103d.f10331b);
            bVar.setRetryPolicy(new DefaultRetryPolicy());
            RequestQueue nVar = this.f10325d;
            if (nVar == null) {
                C3443i.m21151a();
            }
            nVar.mo8703a(bVar);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "onResponse"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.h.b$c */
    /* compiled from: ModeExecutor.kt */
    static final class C2102c<T> implements Response.C0452b<String> {

        /* renamed from: a */
        public static ChangeQuickRedirect f10328a;

        /* renamed from: b */
        final /* synthetic */ ModeExecutor f10329b;

        C2102c(ModeExecutor bVar) {
            this.f10329b = bVar;
        }

        /* renamed from: a */
        public final void onResponse(String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, f10328a, false, 5346, new Class[]{String.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a b = ModeExecutor.f10323e;
                LogUtil.m15952c(b, "onResponse s:" + str);
                ModeExecutor bVar = this.f10329b;
                C3443i.m21152a((Object) str, NotifyType.SOUND);
                bVar.m10597a(str);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "volleyError", "Lcom/android/volley/VolleyError;", "kotlin.jvm.PlatformType", "onErrorResponse"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.h.b$d */
    /* compiled from: ModeExecutor.kt */
    static final class C2103d implements Response.C0451a {

        /* renamed from: a */
        public static ChangeQuickRedirect f10330a;

        /* renamed from: b */
        public static final C2103d f10331b = new C2103d();

        C2103d() {
        }

        public final void onErrorResponse(VolleyError tVar) {
            if (!PatchProxy.proxy(new Object[]{tVar}, this, f10330a, false, 5347, new Class[]{VolleyError.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a b = ModeExecutor.f10323e;
                LogUtil.m15956e(b, "onErrorResponse volleyError :" + tVar.getMessage() + ", " + tVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m10597a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10321a, false, 5343, new Class[]{String.class}, Void.TYPE).isSupported) {
            JSONObject b = m10599b(str);
            if (b == null) {
                LogUtil.m15949b(f10323e, "jsonObject is null!");
                return;
            }
            try {
                int i = b.getInt("code");
                if (i == 200) {
                    boolean z = b.getBoolean("value");
                    boolean a = C3443i.m21154a((Object) PreferenceUtil.m15983c(this.f10324c, "amazing_ar_mode_value", "0"), (Object) "1");
                    if (z != a) {
                        PreferenceUtil.m15982b(this.f10324c, "amazing_ar_mode_value", z ? "1" : "0");
                    }
                    this.f10324c.getSharedPreferences(this.f10324c.getPackageName(), 0).edit().putLong("modeUpdateDate", System.currentTimeMillis()).apply();
                    LogUtil.C2630a aVar = f10323e;
                    LogUtil.m15952c(aVar, "amazingAR value :" + z + ", enable:" + a);
                } else if (i == 19002) {
                    RequestQueue nVar = this.f10325d;
                    if (nVar == null) {
                        C3443i.m21151a();
                    }
                    nVar.mo8707b();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private final JSONObject m10599b(String str) {
        JSONObject jSONObject;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f10321a, false, 5344, new Class[]{String.class}, JSONObject.class);
        if (proxy.isSupported) {
            return (JSONObject) proxy.result;
        }
        jSONObject = null;
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            LogUtil.m15949b(f10323e, "JSON parse ERROR" + e.getMessage());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo27294d2 = {"Lcom/meizu/media/camera/net/ModeExecutor$Companion;", "", "()V", "PARAM_AMAZING_AR_VERSIONCODE", "", "PARAM_AMAZING_AR_VERSIONNAME", "PARAM_MODE_UPDATE_DATE", "QUERY_URL", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "UPDATE_INTERVAL", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.h.b$a */
    /* compiled from: ModeExecutor.kt */
    public static final class C2100a {
        private C2100a() {
        }

        public /* synthetic */ C2100a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
