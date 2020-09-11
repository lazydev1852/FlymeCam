package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.TypeReference;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.URIParsedResult;
import com.google.zxing.common.BitMatrix;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.entity.PkgEntity;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.C2644av;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.safe.engine.url.IMyUrlCheckService;
import com.meizu.safe.engine.url.MzUrlCheckResult;
import com.meizu.safe.engine.url.MzUrlChkResultForShow;
import com.meizu.safe.engine.url.OnCheckUrlListener;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.C3393i;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.text.C3467f;
import kotlinx.coroutines.C3512ay;
import kotlinx.coroutines.C3535d;
import kotlinx.coroutines.C3568z;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0003DEFB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J2\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010!2\b\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\bJ\b\u0010)\u001a\u00020#H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u0017J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0016J\u0014\u00100\u001a\u0004\u0018\u00010\u00172\b\u00101\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010.H\u0016J\u0012\u00106\u001a\u0004\u0018\u00010\u00172\u0006\u0010,\u001a\u000207H\u0002J\u0018\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u0017H\u0016J \u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u0017H\u0002J\u0006\u0010@\u001a\u00020#J\u0010\u0010A\u001a\u00020#2\b\u0010?\u001a\u0004\u0018\u00010\u0017J\u000e\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020\bR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, mo27294d2 = {"Lcom/meizu/media/camera/barcode/result/URIResultHandler;", "Lcom/meizu/media/camera/barcode/result/ResultHandler;", "activity", "Landroid/app/Activity;", "result", "Lcom/google/zxing/client/result/ParsedResult;", "(Landroid/app/Activity;Lcom/google/zxing/client/result/ParsedResult;)V", "isUriResultSave", "", "()Z", "mAppPkgInfo", "Lcom/meizu/media/camera/barcode/result/UrlAppPkgInfo;", "mBarcodeInAutoMode", "mCloseCheckResultMsg", "", "mHandler", "Landroid/os/Handler;", "mIsMeizuLink", "mIsUriOpened", "mOpenUriRunnable", "Ljava/lang/Runnable;", "mOtherAppNames", "", "", "[Ljava/lang/String;", "mResultForShow", "Lcom/meizu/safe/engine/url/MzUrlChkResultForShow;", "mSearchURLResult", "Lcom/meizu/media/camera/barcode/result/URIResultHandler$SEARCH_URL_RESULT;", "mSearchUriTask", "Lcom/meizu/media/camera/barcode/result/URIResultHandler$SearchUriTask;", "mUriCheckOverMsg", "mUrlCheckService", "Lcom/meizu/safe/engine/url/IMyUrlCheckService;", "checkUri", "", "myUrlCheckService", "handler", "uriCheckOverMsg", "closeCheckResultMsg", "barcodeInAutoMode", "closeCheckResult", "encodeAsBitmap", "Landroid/graphics/Bitmap;", "contents", "getActionBarItems", "Ljava/util/ArrayList;", "Lcom/meizu/media/camera/barcode/result/ResultActionBarItem;", "getAppName", "packageName", "getHeader", "Lcom/meizu/media/camera/barcode/result/ResultInfoHeader;", "getItems", "Lcom/meizu/media/camera/barcode/result/ResultInfoItem;", "guessAppropriateEncoding", "", "handleClick", "action", "extraInfo", "onUriCheckResult", "rst", "Lcom/meizu/safe/engine/url/MzUrlCheckResult;", "pid", "url", "openUri", "saveScanImage", "searchUri", "needOpenUri", "Companion", "SEARCH_URL_RESULT", "SearchUriTask", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: URIResultHandler.kt */
public final class URIResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8047a;

    /* renamed from: f */
    public static final C1846a f8048f = new C1846a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final LogUtil.C2630a f8049t = new LogUtil.C2630a("URIResultHandler");

    /* renamed from: g */
    private boolean f8050g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f8051h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MzUrlChkResultForShow f8052i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f8053j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f8054k;

    /* renamed from: l */
    private int f8055l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public IMyUrlCheckService f8056m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public UrlAppPkgInfo f8057n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1847b f8058o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public SEARCH_URL_RESULT f8059p = SEARCH_URL_RESULT.OTHER_URL;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f8060q;

    /* renamed from: r */
    private final String[] f8061r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Runnable f8062s = new C1851e(this);

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo27294d2 = {"Lcom/meizu/media/camera/barcode/result/URIResultHandler$SEARCH_URL_RESULT;", "", "(Ljava/lang/String;I)V", "ALIPAY", "WECHAT", "OTHER_APP", "OTHER_URL", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* compiled from: URIResultHandler.kt */
    private enum SEARCH_URL_RESULT {
        ALIPAY,
        WECHAT,
        OTHER_APP,
        OTHER_URL;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    @Nullable
    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public URIResultHandler(@NotNull Activity activity, @Nullable ParsedResult parsedResult) {
        super(activity, parsedResult);
        C3443i.m21155b(activity, PushConstants.INTENT_ACTIVITY_NAME);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_url_result_hint);
        String[] stringArray = activity.getResources().getStringArray(R.array.mz_barcode_auto_other_app_name);
        C3443i.m21152a((Object) stringArray, "activity.resources.getSt…code_auto_other_app_name)");
        this.f8061r = stringArray;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.result.URIResultHandler$e */
    /* compiled from: URIResultHandler.kt */
    static final class C1851e implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f8071a;

        /* renamed from: b */
        final /* synthetic */ URIResultHandler f8072b;

        C1851e(URIResultHandler uRIResultHandler) {
            this.f8072b = uRIResultHandler;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f8071a, false, 2710, new Class[0], Void.TYPE).isSupported) {
                this.f8072b.mo19177l();
            }
        }
    }

    /* renamed from: a */
    public void mo19171a(int i, @NotNull String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f8047a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2688, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str, "extraInfo");
            ParsedResult d = mo19232d();
            if (d != null) {
                String uri = ((URIParsedResult) d).getURI();
                if (i != 12) {
                    switch (i) {
                        case 7:
                            mo19231c(uri);
                            return;
                        case 8:
                            mo19237f(uri);
                            return;
                        case 9:
                            mo19239g(uri);
                            return;
                        default:
                            return;
                    }
                } else {
                    m8546n();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.zxing.client.result.URIParsedResult");
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8047a, false, 2689, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        if (this.f8050g || this.f8052i == null) {
            return null;
        }
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        ResultInfoItem mVar = new ResultInfoItem();
        MzUrlChkResultForShow bVar = this.f8052i;
        if (bVar == null) {
            C3443i.m21151a();
        }
        if (bVar.f15648a != 0) {
            Activity f = mo19236f();
            C3443i.m21152a((Object) f, PushConstants.INTENT_ACTIVITY_NAME);
            mVar.mo19281c(f.getResources().getString(R.string.qr_code_result_insist_access));
            Activity f2 = mo19236f();
            C3443i.m21152a((Object) f2, PushConstants.INTENT_ACTIVITY_NAME);
            mVar.mo19284d(f2.getResources().getString(R.string.qr_code_result_supporter));
            mVar.mo19275b((View.OnClickListener) new C1850d(this));
            MzUrlChkResultForShow bVar2 = this.f8052i;
            if (bVar2 == null) {
                C3443i.m21151a();
            }
            if (!bVar2.f15652e) {
                MzUrlChkResultForShow bVar3 = this.f8052i;
                if (bVar3 == null) {
                    C3443i.m21151a();
                }
                if (bVar3.f15648a == -1) {
                    Activity f3 = mo19236f();
                    C3443i.m21152a((Object) f3, PushConstants.INTENT_ACTIVITY_NAME);
                    mVar.mo19277b(f3.getResources().getString(R.string.qr_code_result_unknown_cause_net_desc));
                    arrayList.add(mVar);
                }
            }
            MzUrlChkResultForShow bVar4 = this.f8052i;
            if (bVar4 == null) {
                C3443i.m21151a();
            }
            if (bVar4.f15648a == -1) {
                Activity f4 = mo19236f();
                C3443i.m21152a((Object) f4, PushConstants.INTENT_ACTIVITY_NAME);
                mVar.mo19277b(f4.getResources().getString(R.string.qr_code_result_unknown_desc));
            } else {
                MzUrlChkResultForShow bVar5 = this.f8052i;
                if (bVar5 == null) {
                    C3443i.m21151a();
                }
                mVar.mo19277b(bVar5.f15651d);
            }
            arrayList.add(mVar);
        }
        return arrayList;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.result.URIResultHandler$d */
    /* compiled from: URIResultHandler.kt */
    static final class C1850d implements View.OnClickListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f8069a;

        /* renamed from: b */
        final /* synthetic */ URIResultHandler f8070b;

        C1850d(URIResultHandler uRIResultHandler) {
            this.f8070b = uRIResultHandler;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0061 A[SYNTHETIC, Splitter:B:17:0x0061] */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r2 = 0
                r1[r2] = r9
                com.meizu.savior.ChangeQuickRedirect r3 = f8069a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<android.view.View> r9 = android.view.View.class
                r6[r2] = r9
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 2709(0xa95, float:3.796E-42)
                r2 = r8
                com.meizu.savior.PatchProxyResult r9 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r9 = r9.isSupported
                if (r9 == 0) goto L_0x001d
                return
            L_0x001d:
                com.meizu.media.camera.barcode.result.URIResultHandler r9 = r8.f8070b
                r9.m8546n()
                com.meizu.media.camera.barcode.result.URIResultHandler r9 = r8.f8070b
                com.meizu.media.camera.barcode.result.URIResultHandler$b r9 = r9.f8058o
                if (r9 == 0) goto L_0x0054
                com.meizu.media.camera.barcode.result.URIResultHandler r9 = r8.f8070b
                com.meizu.media.camera.barcode.result.URIResultHandler$b r9 = r9.f8058o
                if (r9 != 0) goto L_0x0035
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0035:
                com.meizu.media.camera.util.AsyncTaskEx$Status r9 = r9.mo22613c()
                com.meizu.media.camera.util.AsyncTaskEx$Status r0 = com.meizu.media.camera.util.AsyncTaskEx.Status.FINISHED
                if (r9 == r0) goto L_0x0054
                com.meizu.media.camera.barcode.result.URIResultHandler r9 = r8.f8070b
                android.os.Handler r9 = r9.f8053j
                if (r9 != 0) goto L_0x0048
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0048:
                com.meizu.media.camera.barcode.result.URIResultHandler r0 = r8.f8070b
                java.lang.Runnable r0 = r0.f8062s
                r1 = 200(0xc8, double:9.9E-322)
                r9.postDelayed(r0, r1)
                goto L_0x0059
            L_0x0054:
                com.meizu.media.camera.barcode.result.URIResultHandler r9 = r8.f8070b
                r9.mo19177l()
            L_0x0059:
                com.meizu.media.camera.barcode.result.URIResultHandler r9 = r8.f8070b
                com.meizu.safe.engine.url.a r9 = r9.f8056m
                if (r9 == 0) goto L_0x0081
                com.meizu.media.camera.barcode.result.URIResultHandler r9 = r8.f8070b     // Catch:{ RemoteException -> 0x007d }
                com.meizu.safe.engine.url.a r9 = r9.f8056m     // Catch:{ RemoteException -> 0x007d }
                if (r9 != 0) goto L_0x006c
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ RemoteException -> 0x007d }
            L_0x006c:
                com.meizu.media.camera.barcode.result.URIResultHandler r0 = r8.f8070b     // Catch:{ RemoteException -> 0x007d }
                com.meizu.safe.engine.url.b r0 = r0.f8052i     // Catch:{ RemoteException -> 0x007d }
                if (r0 != 0) goto L_0x0077
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ RemoteException -> 0x007d }
            L_0x0077:
                java.lang.String r0 = r0.f15649b     // Catch:{ RemoteException -> 0x007d }
                r9.mo23857a(r0)     // Catch:{ RemoteException -> 0x007d }
                goto L_0x0081
            L_0x007d:
                r9 = move-exception
                r9.printStackTrace()
            L_0x0081:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.barcode.result.URIResultHandler.C1850d.onClick(android.view.View):void");
        }
    }

    @NotNull
    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8047a, false, 2690, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        if (this.f8050g || this.f8052i == null) {
            return lVar;
        }
        MzUrlChkResultForShow bVar = this.f8052i;
        if (bVar == null) {
            C3443i.m21151a();
        }
        if (bVar.f15648a == -1) {
            Activity f = mo19236f();
            C3443i.m21152a((Object) f, PushConstants.INTENT_ACTIVITY_NAME);
            lVar.mo19256a(f.getResources().getDrawable(R.drawable.ic_url_chk_unknown));
            Activity f2 = mo19236f();
            C3443i.m21152a((Object) f2, PushConstants.INTENT_ACTIVITY_NAME);
            lVar.mo19257a(f2.getResources().getString(R.string.qr_code_result_unknown_title));
        } else {
            MzUrlChkResultForShow bVar2 = this.f8052i;
            if (bVar2 == null) {
                C3443i.m21151a();
            }
            if (bVar2.f15648a == 0) {
                Activity f3 = mo19236f();
                C3443i.m21152a((Object) f3, PushConstants.INTENT_ACTIVITY_NAME);
                lVar.mo19256a(f3.getResources().getDrawable(R.drawable.ic_url_chk_regular));
                Activity f4 = mo19236f();
                C3443i.m21152a((Object) f4, PushConstants.INTENT_ACTIVITY_NAME);
                lVar.mo19257a(f4.getResources().getString(R.string.qr_code_result_security_title));
            } else {
                Activity f5 = mo19236f();
                C3443i.m21152a((Object) f5, PushConstants.INTENT_ACTIVITY_NAME);
                lVar.mo19256a(f5.getResources().getDrawable(R.drawable.ic_url_chk_harm));
                MzUrlChkResultForShow bVar3 = this.f8052i;
                if (bVar3 == null) {
                    C3443i.m21151a();
                }
                lVar.mo19257a(bVar3.f15650c);
            }
        }
        MzUrlChkResultForShow bVar4 = this.f8052i;
        if (bVar4 == null) {
            C3443i.m21151a();
        }
        lVar.mo19260b(bVar4.f15649b);
        return lVar;
    }

    /* renamed from: k */
    public final boolean mo19176k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8047a, false, 2691, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (DeviceUtil.m16196a() || this.f8052i == null) {
            return true;
        }
        MzUrlChkResultForShow bVar = this.f8052i;
        if (bVar == null) {
            C3443i.m21151a();
        }
        if (bVar.f15648a == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void mo19172a(@Nullable IMyUrlCheckService aVar, @Nullable Handler handler, int i, int i2, boolean z) {
        if (!PatchProxy.proxy(new Object[]{aVar, handler, new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)}, this, f8047a, false, 2692, new Class[]{IMyUrlCheckService.class, Handler.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f8051h = z;
            ParsedResult d = mo19232d();
            if (d != null) {
                URIParsedResult uRIParsedResult = (URIParsedResult) d;
                String uri = uRIParsedResult.getURI();
                this.f8050g = mo19243i(uri) || mo19244j(uri) || mo19245k(uri);
                if (!this.f8050g) {
                    this.f8053j = handler;
                    this.f8054k = i;
                    this.f8055l = i2;
                    this.f8056m = aVar;
                    this.f8057n = null;
                    this.f8059p = SEARCH_URL_RESULT.OTHER_URL;
                    this.f8060q = false;
                    this.f8052i = null;
                    mo19179q(uRIParsedResult.getURI());
                    if (DeviceUtil.m16196a() || this.f8056m == null) {
                        mo19173a(!this.f8051h);
                        if (this.f8051h) {
                            if (this.f8058o != null) {
                                C1847b bVar = this.f8058o;
                                if (bVar == null) {
                                    C3443i.m21151a();
                                }
                                if (bVar.mo22613c() != AsyncTaskEx.Status.RUNNING) {
                                    C1847b bVar2 = this.f8058o;
                                    if (bVar2 == null) {
                                        C3443i.m21151a();
                                    }
                                    if (bVar2.mo22613c() == AsyncTaskEx.Status.PENDING) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            Handler handler2 = this.f8053j;
                            if (handler2 == null) {
                                C3443i.m21151a();
                            }
                            Message obtainMessage = handler2.obtainMessage(this.f8054k);
                            obtainMessage.obj = this;
                            obtainMessage.what = this.f8054k;
                            Handler handler3 = this.f8053j;
                            if (handler3 == null) {
                                C3443i.m21151a();
                            }
                            handler3.sendMessage(obtainMessage);
                            return;
                        }
                        return;
                    }
                    try {
                        mo19173a(false);
                        if (!this.f8051h) {
                            Handler handler4 = this.f8053j;
                            if (handler4 == null) {
                                C3443i.m21151a();
                            }
                            handler4.postDelayed(this.f8062s, 2500);
                        }
                        IMyUrlCheckService aVar2 = this.f8056m;
                        if (aVar2 == null) {
                            C3443i.m21151a();
                        }
                        aVar2.mo23858a(uRIParsedResult.getURI(), new C1849c(this, uRIParsedResult));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.zxing.client.result.URIParsedResult");
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo27294d2 = {"com/meizu/media/camera/barcode/result/URIResultHandler$checkUri$1", "Lcom/meizu/safe/engine/url/OnCheckUrlListener$Stub;", "onDone", "", "rst", "Lcom/meizu/safe/engine/url/MzUrlCheckResult;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.result.URIResultHandler$c */
    /* compiled from: URIResultHandler.kt */
    public static final class C1849c extends OnCheckUrlListener.C2797a {

        /* renamed from: a */
        public static ChangeQuickRedirect f8066a;

        /* renamed from: b */
        final /* synthetic */ URIResultHandler f8067b;

        /* renamed from: c */
        final /* synthetic */ URIParsedResult f8068c;

        C1849c(URIResultHandler uRIResultHandler, URIParsedResult uRIParsedResult) {
            this.f8067b = uRIResultHandler;
            this.f8068c = uRIParsedResult;
        }

        /* renamed from: a */
        public void mo19187a(@NotNull MzUrlCheckResult mzUrlCheckResult) throws RemoteException {
            if (!PatchProxy.proxy(new Object[]{mzUrlCheckResult}, this, f8066a, false, 2708, new Class[]{MzUrlCheckResult.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(mzUrlCheckResult, "rst");
                if (!this.f8067b.f8060q) {
                    if (!this.f8067b.f8051h) {
                        Handler c = this.f8067b.f8053j;
                        if (c == null) {
                            C3443i.m21151a();
                        }
                        c.removeCallbacks(this.f8067b.f8062s);
                    }
                    URIResultHandler uRIResultHandler = this.f8067b;
                    String uri = this.f8068c.getURI();
                    C3443i.m21152a((Object) uri, "result.uri");
                    uRIResultHandler.m8535a(mzUrlCheckResult, 0, uri);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo19173a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f8047a, false, 2693, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (DeviceUtil.m16196a()) {
                this.f8059p = SEARCH_URL_RESULT.OTHER_URL;
                if (z) {
                    mo19177l();
                    return;
                }
                return;
            }
            ParsedResult d = mo19232d();
            if (d != null) {
                Uri parse = Uri.parse(((URIParsedResult) d).getURI());
                C3443i.m21152a((Object) parse, "uri");
                if (C3467f.m21229a("qr.alipay.com", parse.getAuthority(), true) && C2644av.m16104a((Context) mo19236f(), "com.eg.android.AlipayGphone")) {
                    this.f8059p = SEARCH_URL_RESULT.ALIPAY;
                    Activity activity = this.f8113c;
                    C3443i.m21152a((Object) activity, "mActivity");
                    this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_alipay_result_hint);
                    if (z) {
                        mo19177l();
                    }
                } else if (C3467f.m21229a("wxp", parse.getScheme(), true) || C3467f.m21229a("wxhb", parse.getScheme(), true)) {
                    this.f8059p = SEARCH_URL_RESULT.WECHAT;
                    Activity activity2 = this.f8113c;
                    C3443i.m21152a((Object) activity2, "mActivity");
                    this.f8114d = activity2.getResources().getString(R.string.mz_barcode_auto_wechat_result_hint);
                    if (z) {
                        mo19177l();
                    }
                } else if (!mo19241h()) {
                    this.f8059p = SEARCH_URL_RESULT.OTHER_URL;
                    if (z) {
                        mo19177l();
                    }
                } else {
                    this.f8058o = new C1847b(z);
                    C1847b bVar = this.f8058o;
                    if (bVar == null) {
                        C3443i.m21151a();
                    }
                    bVar.mo22614c((Params[]) new Uri[]{parse});
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.zxing.client.result.URIParsedResult");
            }
        }
    }

    /* renamed from: l */
    public final void mo19177l() {
        if (!PatchProxy.proxy(new Object[0], this, f8047a, false, 2694, new Class[0], Void.TYPE).isSupported && !this.f8060q) {
            this.f8060q = true;
            ParsedResult d = mo19232d();
            if (d != null) {
                Uri parse = Uri.parse(((URIParsedResult) d).getURI());
                switch (C1866q.f8167a[this.f8059p.ordinal()]) {
                    case 1:
                        mo19233d(parse.toString());
                        return;
                    case 2:
                        mo19235e(parse.toString());
                        return;
                    case 3:
                        if (this.f8057n != null) {
                            UrlAppPkgInfo rVar = this.f8057n;
                            if (rVar == null) {
                                C3443i.m21151a();
                            }
                            String a = rVar.mo19304a();
                            UrlAppPkgInfo rVar2 = this.f8057n;
                            if (rVar2 == null) {
                                C3443i.m21151a();
                            }
                            mo19222a(a, Boolean.valueOf(rVar2.mo19309b()), parse.toString());
                            return;
                        }
                        mo19231c(parse.toString());
                        return;
                    case 4:
                        mo19231c(parse.toString());
                        return;
                    default:
                        mo19231c(parse.toString());
                        return;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.zxing.client.result.URIParsedResult");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m8535a(MzUrlCheckResult mzUrlCheckResult, int i, String str) {
        Object[] objArr = {mzUrlCheckResult, new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f8047a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2695, new Class[]{MzUrlCheckResult.class, Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            this.f8052i = MzUrlChkResultForShow.m16974a(mzUrlCheckResult, i, str);
            MzUrlChkResultForShow bVar = this.f8052i;
            if (bVar == null) {
                C3443i.m21151a();
            }
            if (bVar.f15648a != 0 || this.f8051h) {
                if (this.f8051h && this.f8058o != null) {
                    C1847b bVar2 = this.f8058o;
                    if (bVar2 == null) {
                        C3443i.m21151a();
                    }
                    if (bVar2.mo22613c() != AsyncTaskEx.Status.RUNNING) {
                        C1847b bVar3 = this.f8058o;
                        if (bVar3 == null) {
                            C3443i.m21151a();
                        }
                        if (bVar3.mo22613c() == AsyncTaskEx.Status.PENDING) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                Handler handler = this.f8053j;
                if (handler == null) {
                    C3443i.m21151a();
                }
                Message obtainMessage = handler.obtainMessage(this.f8054k);
                obtainMessage.obj = this;
                obtainMessage.what = this.f8054k;
                Handler handler2 = this.f8053j;
                if (handler2 == null) {
                    C3443i.m21151a();
                }
                handler2.sendMessage(obtainMessage);
                return;
            }
            if (this.f8058o != null) {
                C1847b bVar4 = this.f8058o;
                if (bVar4 == null) {
                    C3443i.m21151a();
                }
                if (bVar4.mo22613c() != AsyncTaskEx.Status.FINISHED) {
                    C1847b bVar5 = this.f8058o;
                    if (bVar5 == null) {
                        C3443i.m21151a();
                    }
                    bVar5.mo19183a(true);
                    Handler handler3 = this.f8053j;
                    if (handler3 == null) {
                        C3443i.m21151a();
                    }
                    handler3.postDelayed(this.f8062s, 1000);
                    return;
                }
            }
            mo19177l();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public final void m8546n() {
        if (!PatchProxy.proxy(new Object[0], this, f8047a, false, 2696, new Class[0], Void.TYPE).isSupported) {
            Handler handler = this.f8053j;
            if (handler == null) {
                C3443i.m21151a();
            }
            Message obtainMessage = handler.obtainMessage(this.f8055l);
            obtainMessage.obj = this;
            obtainMessage.what = this.f8055l;
            Handler handler2 = this.f8053j;
            if (handler2 == null) {
                C3443i.m21151a();
            }
            handler2.sendMessage(obtainMessage);
        }
    }

    @Nullable
    /* renamed from: p */
    public final Bitmap mo19178p(@Nullable String str) throws WriterException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f8047a, false, 2697, new Class[]{String.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (str != null) {
            Map map = null;
            String a = m8531a((CharSequence) str);
            if (a != null) {
                map = new EnumMap(EncodeHintType.class);
                map.put(EncodeHintType.CHARACTER_SET, a);
            }
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 84, 84, map);
                C3443i.m21152a((Object) encode, "MultiFormatWriter().enco…           84, 84, hints)");
                int width = encode.getWidth();
                int height = encode.getHeight();
                int[] iArr = new int[(width * height)];
                for (int i = 0; i < height; i++) {
                    int i2 = i * width;
                    for (int i3 = 0; i3 < width; i3++) {
                        iArr[i2 + i3] = encode.get(i3, i) ? ViewCompat.MEASURED_STATE_MASK : -1;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                return createBitmap;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private final String m8531a(CharSequence charSequence) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{charSequence}, this, f8047a, false, 2698, new Class[]{CharSequence.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) > 255) {
                return "UTF-8";
            }
        }
        return null;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo27294d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    @DebugMetadata(mo27430c = "com.meizu.media.camera.barcode.result.URIResultHandler$saveScanImage$1", mo27431f = "URIResultHandler.kt", mo27432i = {}, mo27433l = {}, mo27434m = "invokeSuspend", mo27435n = {}, mo27436s = {})
    /* renamed from: com.meizu.media.camera.barcode.result.URIResultHandler$f */
    /* compiled from: URIResultHandler.kt */
    static final class C1852f extends C3393i implements C3425m<C3568z, Continuation<? super Unit>, Object> {

        /* renamed from: a */
        public static ChangeQuickRedirect f8073a;

        /* renamed from: b */
        int f8074b;

        /* renamed from: c */
        final /* synthetic */ URIResultHandler f8075c;

        /* renamed from: d */
        final /* synthetic */ String f8076d;

        /* renamed from: e */
        private C3568z f8077e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1852f(URIResultHandler uRIResultHandler, String str, Continuation dVar) {
            super(2, dVar);
            this.f8075c = uRIResultHandler;
            this.f8076d = str;
        }

        /* renamed from: a */
        public final Object mo19191a(Object obj, Object obj2) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, obj2}, this, f8073a, false, 2713, new Class[]{Object.class, Object.class}, Object.class);
            return proxy.isSupported ? proxy.result : ((C1852f) mo19192a(obj, (Continuation<?>) (Continuation) obj2)).mo19190a(Unit.f18749a);
        }

        @NotNull
        /* renamed from: a */
        public final Continuation<Unit> mo19192a(@Nullable Object obj, @NotNull Continuation<?> dVar) {
            ChangeQuickRedirect changeQuickRedirect = f8073a;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, dVar}, this, changeQuickRedirect, false, 2712, new Class[]{Object.class, Continuation.class}, Continuation.class);
            if (proxy.isSupported) {
                return (Continuation) proxy.result;
            }
            C3443i.m21155b(dVar, "completion");
            C1852f fVar = new C1852f(this.f8075c, this.f8076d, dVar);
            fVar.f8077e = (C3568z) obj;
            return fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b9, code lost:
            if (r0.isRecycled() == false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bb, code lost:
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x010f, code lost:
            if (r0.isRecycled() == false) goto L_0x00bb;
         */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x010b  */
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object mo19190a(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r2 = 0
                r1[r2] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f8073a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                r6[r2] = r0
                java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
                r4 = 0
                r5 = 2711(0xa97, float:3.799E-42)
                r2 = r9
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r0.isSupported
                if (r1 == 0) goto L_0x0021
                java.lang.Object r10 = r0.result
                java.lang.Object r10 = (java.lang.Object) r10
                return r10
            L_0x0021:
                kotlin.coroutines.intrinsics.C3382a.m21036a()
                int r0 = r9.f8074b
                if (r0 != 0) goto L_0x015e
                kotlin.C3450n.m21199a((java.lang.Object) r10)
                kotlinx.coroutines.z r10 = r9.f8077e
                com.meizu.media.camera.util.ac$a r10 = com.meizu.media.camera.barcode.result.URIResultHandler.f8049t
                java.lang.String r0 = "saveScanImage encode start"
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r0)
                r10 = 0
                r0 = r10
                android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
                com.meizu.media.camera.barcode.result.URIResultHandler r0 = r9.f8075c     // Catch:{ WriterException -> 0x013b }
                java.lang.String r1 = r9.f8076d     // Catch:{ WriterException -> 0x013b }
                android.graphics.Bitmap r0 = r0.mo19178p(r1)     // Catch:{ WriterException -> 0x013b }
                com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.barcode.result.URIResultHandler.f8049t
                java.lang.String r2 = "saveScanImage encode end"
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
                java.io.File r1 = new java.io.File
                com.meizu.media.camera.barcode.result.URIResultHandler r2 = r9.f8075c
                android.app.Activity r2 = r2.mo19236f()
                java.lang.String r3 = "activity"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
                java.io.File r2 = r2.getExternalCacheDir()
                java.lang.String r3 = "scanImage"
                r1.<init>(r2, r3)
                r2 = r10
                java.io.FileOutputStream r2 = (java.io.FileOutputStream) r2
                r3 = r10
                java.io.BufferedOutputStream r3 = (java.io.BufferedOutputStream) r3
                java.io.DataOutputStream r10 = (java.io.DataOutputStream) r10
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00d7, all -> 0x00d1 }
                r4.<init>(r1)     // Catch:{ Exception -> 0x00d7, all -> 0x00d1 }
                r4.flush()     // Catch:{ Exception -> 0x00ce, all -> 0x00cc }
                java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00ce, all -> 0x00cc }
                r2 = r4
                java.io.OutputStream r2 = (java.io.OutputStream) r2     // Catch:{ Exception -> 0x00ce, all -> 0x00cc }
                r5 = 4096000(0x3e8000, float:5.739719E-39)
                r1.<init>(r2, r5)     // Catch:{ Exception -> 0x00ce, all -> 0x00cc }
                java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00c6, all -> 0x00c0 }
                r3 = r1
                java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ Exception -> 0x00c6, all -> 0x00c0 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x00c6, all -> 0x00c0 }
                if (r0 != 0) goto L_0x0093
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ Exception -> 0x008f, all -> 0x008a }
                goto L_0x0093
            L_0x008a:
                r10 = move-exception
                r3 = r1
                r1 = r2
                goto L_0x0120
            L_0x008f:
                r10 = move-exception
                r3 = r1
                r1 = r2
                goto L_0x00ca
            L_0x0093:
                boolean r10 = r0.isRecycled()     // Catch:{ Exception -> 0x008f, all -> 0x008a }
                if (r10 != 0) goto L_0x00a3
                android.graphics.Bitmap$CompressFormat r10 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x008f, all -> 0x008a }
                r3 = 75
                r5 = r4
                java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ Exception -> 0x008f, all -> 0x008a }
                r0.compress(r10, r3, r5)     // Catch:{ Exception -> 0x008f, all -> 0x008a }
            L_0x00a3:
                r2.close()     // Catch:{ Exception -> 0x008f, all -> 0x008a }
                java.io.Closeable r4 = (java.io.Closeable) r4
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r4)
                java.io.Closeable r1 = (java.io.Closeable) r1
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r1)
                java.io.Closeable r2 = (java.io.Closeable) r2
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)
                boolean r10 = r0.isRecycled()
                if (r10 != 0) goto L_0x0112
            L_0x00bb:
                r0.recycle()
                goto L_0x0112
            L_0x00c0:
                r2 = move-exception
                r3 = r1
                r1 = r10
                r10 = r2
                goto L_0x0120
            L_0x00c6:
                r2 = move-exception
                r3 = r1
                r1 = r10
                r10 = r2
            L_0x00ca:
                r2 = r4
                goto L_0x00db
            L_0x00cc:
                r1 = move-exception
                goto L_0x00d3
            L_0x00ce:
                r1 = move-exception
                r2 = r4
                goto L_0x00d8
            L_0x00d1:
                r1 = move-exception
                r4 = r2
            L_0x00d3:
                r8 = r1
                r1 = r10
                r10 = r8
                goto L_0x0120
            L_0x00d7:
                r1 = move-exception
            L_0x00d8:
                r8 = r1
                r1 = r10
                r10 = r8
            L_0x00db:
                com.meizu.media.camera.util.ac$a r4 = com.meizu.media.camera.barcode.result.URIResultHandler.f8049t     // Catch:{ all -> 0x011e }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011e }
                r5.<init>()     // Catch:{ all -> 0x011e }
                java.lang.String r6 = "saveScanBmpInFile Exception "
                r5.append(r6)     // Catch:{ all -> 0x011e }
                java.lang.String r6 = r10.getMessage()     // Catch:{ all -> 0x011e }
                r5.append(r6)     // Catch:{ all -> 0x011e }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011e }
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r5)     // Catch:{ all -> 0x011e }
                r10.printStackTrace()     // Catch:{ all -> 0x011e }
                java.io.Closeable r2 = (java.io.Closeable) r2
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)
                java.io.Closeable r3 = (java.io.Closeable) r3
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)
                java.io.Closeable r1 = (java.io.Closeable) r1
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r1)
                if (r0 == 0) goto L_0x0112
                boolean r10 = r0.isRecycled()
                if (r10 != 0) goto L_0x0112
                goto L_0x00bb
            L_0x0112:
                com.meizu.media.camera.util.ac$a r10 = com.meizu.media.camera.barcode.result.URIResultHandler.f8049t
                java.lang.String r0 = "saveScanImage save end"
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r0)
                kotlin.t r10 = kotlin.Unit.f18749a
                return r10
            L_0x011e:
                r10 = move-exception
                r4 = r2
            L_0x0120:
                java.io.Closeable r4 = (java.io.Closeable) r4
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r4)
                java.io.Closeable r3 = (java.io.Closeable) r3
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)
                java.io.Closeable r1 = (java.io.Closeable) r1
                com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r1)
                if (r0 == 0) goto L_0x013a
                boolean r1 = r0.isRecycled()
                if (r1 != 0) goto L_0x013a
                r0.recycle()
            L_0x013a:
                throw r10
            L_0x013b:
                r10 = move-exception
                r10.printStackTrace()
                com.meizu.media.camera.util.ac$a r0 = com.meizu.media.camera.barcode.result.URIResultHandler.f8049t
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "saveScanBmpInFile Exception "
                r1.append(r2)
                java.lang.String r10 = r10.getMessage()
                r1.append(r10)
                java.lang.String r10 = r1.toString()
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r10)
                kotlin.t r10 = kotlin.Unit.f18749a
                return r10
            L_0x015e:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.barcode.result.URIResultHandler.C1852f.mo19190a(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: q */
    public final void mo19179q(@Nullable String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8047a, false, 2699, new Class[]{String.class}, Void.TYPE).isSupported) {
            C3512ay unused = C3535d.m21638a(CoroutineScope.f18871a, (CoroutineContext) null, (CoroutineStart) null, new C1852f(this, str, (Continuation) null), 3, (Object) null);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\b\u001a\u0004\u0018\u00010\u00032\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\n\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo27294d2 = {"Lcom/meizu/media/camera/barcode/result/URIResultHandler$SearchUriTask;", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Landroid/net/Uri;", "Ljava/lang/Void;", "needOpenUri", "", "(Lcom/meizu/media/camera/barcode/result/URIResultHandler;Z)V", "mNeedOpenUri", "doInBackground", "params", "", "([Landroid/net/Uri;)Ljava/lang/Void;", "onCancelled", "", "result", "onPostExecute", "onPreExecute", "setNeedOpenUri", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.result.URIResultHandler$b */
    /* compiled from: URIResultHandler.kt */
    private final class C1847b extends AsyncTaskEx<Uri, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f8063a;

        /* renamed from: c */
        private boolean f8065c;

        public C1847b(boolean z) {
            this.f8065c = z;
        }

        /* renamed from: a */
        public final void mo19183a(boolean z) {
            this.f8065c = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void mo17658a(@org.jetbrains.annotations.NotNull android.net.Uri... r18) {
            /*
                r17 = this;
                r8 = r17
                r0 = r18
                r9 = 1
                java.lang.Object[] r1 = new java.lang.Object[r9]
                r10 = 0
                r1[r10] = r0
                com.meizu.savior.ChangeQuickRedirect r3 = f8063a
                java.lang.Class[] r6 = new java.lang.Class[r9]
                java.lang.Class<android.net.Uri[]> r2 = android.net.Uri[].class
                r6[r10] = r2
                java.lang.Class<java.lang.Void> r7 = java.lang.Void.class
                r4 = 0
                r5 = 2703(0xa8f, float:3.788E-42)
                r2 = r17
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r2 = r1.isSupported
                if (r2 == 0) goto L_0x0026
                java.lang.Object r0 = r1.result
                java.lang.Void r0 = (java.lang.Void) r0
                return r0
            L_0x0026:
                java.lang.String r1 = "params"
                kotlin.jvm.p108b.C3443i.m21155b(r0, r1)
                com.meizu.media.camera.barcode.result.URIResultHandler r1 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.URIResultHandler$SEARCH_URL_RESULT r2 = com.meizu.media.camera.barcode.result.URIResultHandler.SEARCH_URL_RESULT.OTHER_URL
                r1.f8059p = r2
                com.meizu.media.camera.barcode.result.URIResultHandler r1 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                boolean r1 = r1.mo19241h()
                r2 = 0
                if (r1 == 0) goto L_0x021a
                r0 = r0[r10]
                if (r0 != 0) goto L_0x0042
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0042:
                java.lang.String r0 = r0.getAuthority()
                java.lang.String r12 = com.meizu.media.camera.barcode.entity.BarcodeRequest.m8525b(r0)
                java.lang.String r11 = "GET"
                r13 = 0
                r14 = 0
                r15 = 1000(0x3e8, float:1.401E-42)
                r16 = 1000(0x3e8, float:1.401E-42)
                java.lang.String r0 = com.meizu.media.camera.util.HttpUtils.m16280a(r11, r12, r13, r14, r15, r16)
                com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.barcode.result.URIResultHandler.f8049t
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "parse jsonStr:"
                r3.append(r4)
                r3.append(r0)
                java.lang.String r3 = r3.toString()
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r3)
                if (r0 == 0) goto L_0x021a
                java.lang.String r1 = ""
                boolean r1 = kotlin.jvm.p108b.C3443i.m21154a((java.lang.Object) r0, (java.lang.Object) r1)
                r1 = r1 ^ r9
                if (r1 == 0) goto L_0x021a
                com.meizu.media.camera.barcode.result.URIResultHandler$b$a r1 = new com.meizu.media.camera.barcode.result.URIResultHandler$b$a
                r1.<init>()
                com.alibaba.fastjson.TypeReference r1 = (com.alibaba.fastjson.TypeReference) r1
                java.lang.Object r0 = com.meizu.media.camera.util.JSONUtils.m15932a(r0, r1)
                com.meizu.media.camera.barcode.entity.PkgEntity r0 = (com.meizu.media.camera.barcode.entity.PkgEntity) r0
                if (r0 == 0) goto L_0x021a
                int r1 = r0.getCode()
                r3 = 200(0xc8, float:2.8E-43)
                if (r1 != r3) goto L_0x021a
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.List r1 = (java.util.List) r1
                r3 = r2
                org.json.JSONArray r3 = (org.json.JSONArray) r3
                org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ef }
                java.lang.String r0 = r0.getValue()     // Catch:{ JSONException -> 0x00ef }
                r3.<init>(r0)     // Catch:{ JSONException -> 0x00ef }
                r0 = 0
            L_0x00a4:
                int r4 = r3.length()     // Catch:{ JSONException -> 0x00ef }
                if (r0 >= r4) goto L_0x00f3
                java.lang.Object r4 = r3.get(r0)     // Catch:{ JSONException -> 0x00ef }
                if (r4 == 0) goto L_0x00e7
                org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ JSONException -> 0x00ef }
                com.meizu.media.camera.barcode.result.r r5 = new com.meizu.media.camera.barcode.result.r     // Catch:{ JSONException -> 0x00ef }
                r5.<init>()     // Catch:{ JSONException -> 0x00ef }
                java.lang.String r6 = "packageName"
                java.lang.String r6 = r4.getString(r6)     // Catch:{ JSONException -> 0x00ef }
                r5.mo19306a((java.lang.String) r6)     // Catch:{ JSONException -> 0x00ef }
                java.lang.String r6 = "needMimeType"
                boolean r6 = r4.getBoolean(r6)     // Catch:{ JSONException -> 0x00ef }
                r5.mo19308b(r6)     // Catch:{ JSONException -> 0x00ef }
                java.lang.String r6 = "openByInternalBrowser"
                boolean r6 = r4.getBoolean(r6)     // Catch:{ JSONException -> 0x00ef }
                r5.mo19307a((boolean) r6)     // Catch:{ JSONException -> 0x00ef }
                java.lang.String r6 = "priority"
                int r4 = r4.getInt(r6)     // Catch:{ JSONException -> 0x00ef }
                r5.mo19305a((int) r4)     // Catch:{ JSONException -> 0x00ef }
                java.lang.String r4 = r5.mo19304a()     // Catch:{ JSONException -> 0x00ef }
                if (r4 == 0) goto L_0x00e4
                r1.add(r5)     // Catch:{ JSONException -> 0x00ef }
            L_0x00e4:
                int r0 = r0 + 1
                goto L_0x00a4
            L_0x00e7:
                kotlin.q r0 = new kotlin.q     // Catch:{ JSONException -> 0x00ef }
                java.lang.String r3 = "null cannot be cast to non-null type org.json.JSONObject"
                r0.<init>(r3)     // Catch:{ JSONException -> 0x00ef }
                throw r0     // Catch:{ JSONException -> 0x00ef }
            L_0x00ef:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00f3:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.List r0 = (java.util.List) r0
                int r3 = r1.size()
                if (r3 <= 0) goto L_0x0129
                r3 = r1
                java.util.Collection r3 = (java.util.Collection) r3
                r0.addAll(r3)
                int r3 = r1.size()
                r4 = 1
            L_0x010b:
                if (r4 >= r3) goto L_0x0129
                java.lang.Object r5 = r1.get(r4)
                com.meizu.media.camera.barcode.result.r r5 = (com.meizu.media.camera.barcode.result.UrlAppPkgInfo) r5
                int r5 = r5.mo19310c()
                int r5 = r5 - r9
                java.lang.Object r6 = r1.get(r4)
                r0.add(r5, r6)
                int r5 = r1.size()
                r0.remove(r5)
                int r4 = r4 + 1
                goto L_0x010b
            L_0x0129:
                int r1 = r0.size()
                if (r1 <= 0) goto L_0x021a
                r1 = r0
                java.util.Collection r1 = (java.util.Collection) r1
                int r1 = r1.size()
            L_0x0136:
                if (r10 >= r1) goto L_0x021a
                java.lang.Object r3 = r0.get(r10)
                com.meizu.media.camera.barcode.result.r r3 = (com.meizu.media.camera.barcode.result.UrlAppPkgInfo) r3
                java.lang.String r3 = r3.mo19304a()
                if (r3 == 0) goto L_0x0216
                com.meizu.media.camera.app.b r3 = com.meizu.media.camera.app.AndroidContext.m8284a()
                android.content.Context r3 = r3.mo19002b()
                java.lang.Object r4 = r0.get(r10)
                com.meizu.media.camera.barcode.result.r r4 = (com.meizu.media.camera.barcode.result.UrlAppPkgInfo) r4
                java.lang.String r4 = r4.mo19304a()
                boolean r3 = com.meizu.media.camera.util.C2644av.m16104a((android.content.Context) r3, (java.lang.String) r4)
                if (r3 == 0) goto L_0x0216
                com.meizu.media.camera.barcode.result.URIResultHandler r3 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                java.lang.Object r4 = r0.get(r10)
                com.meizu.media.camera.barcode.result.r r4 = (com.meizu.media.camera.barcode.result.UrlAppPkgInfo) r4
                r3.f8057n = r4
                com.meizu.media.camera.util.ac$a r3 = com.meizu.media.camera.barcode.result.URIResultHandler.f8049t
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "mAppPkgInfo:"
                r4.append(r5)
                com.meizu.media.camera.barcode.result.URIResultHandler r5 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.r r5 = r5.f8057n
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)
                com.meizu.media.camera.barcode.result.URIResultHandler r3 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.r r3 = r3.f8057n
                if (r3 != 0) goto L_0x0190
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x0190:
                java.lang.String r3 = r3.mo19304a()
                java.lang.String r4 = "com.tencent.mm"
                boolean r3 = kotlin.text.C3467f.m21229a(r3, r4, r9)
                if (r3 == 0) goto L_0x01bc
                com.meizu.media.camera.barcode.result.URIResultHandler r3 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.URIResultHandler$SEARCH_URL_RESULT r4 = com.meizu.media.camera.barcode.result.URIResultHandler.SEARCH_URL_RESULT.WECHAT
                r3.f8059p = r4
                com.meizu.media.camera.barcode.result.URIResultHandler r3 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.URIResultHandler r4 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                android.app.Activity r4 = r4.f8113c
                java.lang.String r5 = "mActivity"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r4, (java.lang.String) r5)
                android.content.res.Resources r4 = r4.getResources()
                r5 = 2131755318(0x7f100136, float:1.9141512E38)
                java.lang.String r4 = r4.getString(r5)
                r3.f8114d = r4
                goto L_0x0216
            L_0x01bc:
                com.meizu.media.camera.barcode.result.URIResultHandler r3 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.URIResultHandler$SEARCH_URL_RESULT r4 = com.meizu.media.camera.barcode.result.URIResultHandler.SEARCH_URL_RESULT.OTHER_APP
                r3.f8059p = r4
                com.meizu.media.camera.barcode.result.URIResultHandler r3 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                com.meizu.media.camera.barcode.result.URIResultHandler r5 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                android.app.Activity r5 = r5.f8113c
                java.lang.String r6 = "mActivity"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r5, (java.lang.String) r6)
                android.content.res.Resources r5 = r5.getResources()
                r6 = 2131755306(0x7f10012a, float:1.9141488E38)
                java.lang.String r5 = r5.getString(r6)
                r4.append(r5)
                com.meizu.media.camera.barcode.result.URIResultHandler r5 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.URIResultHandler r6 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                com.meizu.media.camera.barcode.result.r r6 = r6.f8057n
                if (r6 != 0) goto L_0x01ee
                kotlin.jvm.p108b.C3443i.m21151a()
            L_0x01ee:
                java.lang.String r6 = r6.mo19304a()
                java.lang.String r5 = r5.m8547r(r6)
                r4.append(r5)
                com.meizu.media.camera.barcode.result.URIResultHandler r5 = com.meizu.media.camera.barcode.result.URIResultHandler.this
                android.app.Activity r5 = r5.f8113c
                java.lang.String r6 = "mActivity"
                kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r5, (java.lang.String) r6)
                android.content.res.Resources r5 = r5.getResources()
                r6 = 2131755305(0x7f100129, float:1.9141486E38)
                java.lang.String r5 = r5.getString(r6)
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                r3.f8114d = r4
            L_0x0216:
                int r10 = r10 + 1
                goto L_0x0136
            L_0x021a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.barcode.result.URIResultHandler.C1847b.mo17658a(android.net.Uri[]):java.lang.Void");
        }

        @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, mo27294d2 = {"com/meizu/media/camera/barcode/result/URIResultHandler$SearchUriTask$doInBackground$typeRef$1", "Lcom/alibaba/fastjson/TypeReference;", "Lcom/meizu/media/camera/barcode/entity/PkgEntity;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
        /* renamed from: com.meizu.media.camera.barcode.result.URIResultHandler$b$a */
        /* compiled from: URIResultHandler.kt */
        public static final class C1848a extends TypeReference<PkgEntity> {
            C1848a() {
            }
        }

        /* renamed from: a */
        public void mo19181a() {
            if (!PatchProxy.proxy(new Object[0], this, f8063a, false, 2704, new Class[0], Void.TYPE).isSupported) {
                super.mo19181a();
            }
        }

        /* renamed from: b */
        public void mo19184b() {
            if (!PatchProxy.proxy(new Object[0], this, f8063a, false, 2705, new Class[0], Void.TYPE).isSupported) {
                super.mo19184b();
            }
        }

        /* renamed from: a */
        public void mo19185b(@Nullable Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f8063a, false, 2706, new Class[]{Void.class}, Void.TYPE).isSupported) {
                super.mo19185b(voidR);
            }
        }

        /* renamed from: b */
        public void mo17660a(@Nullable Void voidR) {
            if (!PatchProxy.proxy(new Object[]{voidR}, this, f8063a, false, 2707, new Class[]{Void.class}, Void.TYPE).isSupported) {
                if (this.f8065c) {
                    if (URIResultHandler.this.f8052i != null) {
                        MzUrlChkResultForShow b = URIResultHandler.this.f8052i;
                        if (b == null) {
                            C3443i.m21151a();
                        }
                        if (b.f15648a == 0) {
                            Handler c = URIResultHandler.this.f8053j;
                            if (c == null) {
                                C3443i.m21151a();
                            }
                            c.removeCallbacks(URIResultHandler.this.f8062s);
                        }
                    }
                    URIResultHandler.this.mo19177l();
                } else if (URIResultHandler.this.f8051h) {
                    Handler c2 = URIResultHandler.this.f8053j;
                    if (c2 == null) {
                        C3443i.m21151a();
                    }
                    Message obtainMessage = c2.obtainMessage(URIResultHandler.this.f8054k);
                    obtainMessage.obj = URIResultHandler.this;
                    obtainMessage.what = URIResultHandler.this.f8054k;
                    Handler c3 = URIResultHandler.this.f8053j;
                    if (c3 == null) {
                        C3443i.m21151a();
                    }
                    c3.sendMessage(obtainMessage);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public final String m8547r(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f8047a, false, 2700, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (str == null) {
            return null;
        }
        if (C3443i.m21154a((Object) "com.tencent.mobileqq", (Object) str)) {
            return this.f8061r[0];
        }
        if (C3443i.m21154a((Object) "tv.danmaku.bili", (Object) str)) {
            return this.f8061r[1];
        }
        if (C3443i.m21154a((Object) "com.tencent.reading", (Object) str)) {
            return this.f8061r[2];
        }
        if (C3443i.m21154a((Object) "com.netease.cloudmusic", (Object) str)) {
            return this.f8061r[3];
        }
        if (C3443i.m21154a((Object) "com.zhihu.android", (Object) str)) {
            return this.f8061r[4];
        }
        if (C3443i.m21154a((Object) "com.alibaba.android.rimet", (Object) str)) {
            return this.f8061r[5];
        }
        if (C3443i.m21154a((Object) "com.ss.android.article.news", (Object) str)) {
            return this.f8061r[6];
        }
        if (C3443i.m21154a((Object) "com.ss.android.article.video", (Object) str)) {
            return this.f8061r[7];
        }
        if (C3443i.m21154a((Object) "com.taobao.taobao", (Object) str)) {
            return this.f8061r[8];
        }
        if (C3443i.m21154a((Object) "com.sina.weibo", (Object) str)) {
            return this.f8061r[9];
        }
        return C3443i.m21154a((Object) "com.sina.weibolite", (Object) str) ? this.f8061r[10] : str;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo27294d2 = {"Lcom/meizu/media/camera/barcode/result/URIResultHandler$Companion;", "", "()V", "BLACK", "", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "WHITE", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.result.URIResultHandler$a */
    /* compiled from: URIResultHandler.kt */
    public static final class C1846a {
        private C1846a() {
        }

        public /* synthetic */ C1846a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
