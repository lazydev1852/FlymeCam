package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.WifiParsedResult;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.wifi.WifiConfigManager;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.barcode.result.s */
public final class WifiResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8173a;

    /* renamed from: f */
    private static final LogUtil.C2630a f8174f = new LogUtil.C2630a("WifiResultHandler");

    /* renamed from: g */
    private Handler f8175g;

    /* renamed from: h */
    private int f8176h;

    /* renamed from: i */
    private NetworkInfo.DetailedState f8177i = NetworkInfo.DetailedState.IDLE;

    /* renamed from: j */
    private String f8178j;

    public WifiResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_wifi_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), str}, this, f8173a, false, 2715, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported && i == 10) {
            mo19247n("CONNECT");
            WifiParsedResult wifiParsedResult = (WifiParsedResult) mo19232d();
            WifiManager wifiManager = (WifiManager) mo19236f().getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                LogUtil.m15949b(f8174f, "No WifiManager available from device");
                return;
            }
            Message obtainMessage = this.f8175g.obtainMessage();
            obtainMessage.obj = this;
            obtainMessage.what = this.f8176h;
            this.f8175g.sendMessage(obtainMessage);
            new WifiConfigManager(wifiManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new WifiParsedResult[]{wifiParsedResult});
        }
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8173a, false, 2716, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        WifiParsedResult wifiParsedResult = (WifiParsedResult) mo19232d();
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        ResultInfoItem mVar = new ResultInfoItem();
        mVar.mo19272a(mo19236f().getString(R.string.mz_wifi_title) + SystemInfoUtil.COLON);
        mVar.mo19277b(wifiParsedResult.getSsid());
        arrayList.add(mVar);
        ResultInfoItem mVar2 = new ResultInfoItem();
        mVar2.mo19272a(mo19236f().getString(R.string.mz_wifi_password_pre));
        mVar2.mo19277b(wifiParsedResult.getPassword());
        arrayList.add(mVar2);
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8173a, false, 2717, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_wifi));
        lVar.mo19257a(mo19236f().getString(R.string.mz_wifi));
        lVar.mo19260b(mo19236f().getString(R.string.mz_wifi_encription) + ((WifiParsedResult) mo19232d()).getNetworkEncryption());
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8173a, false, 2718, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
        ResultActionBarItem gVar = new ResultActionBarItem();
        WifiManager wifiManager = (WifiManager) mo19236f().getApplicationContext().getSystemService("wifi");
        String str = "";
        switch (C18671.f8179a[this.f8177i.ordinal()]) {
            case 1:
            case 2:
                str = mo19236f().getResources().getString(R.string.mz_wifi_connet_fail);
                break;
            case 3:
            case 4:
                str = this.f8178j;
                break;
            case 5:
            case 6:
                str = mo19236f().getResources().getString(R.string.mz_wifi_conneting);
                break;
            case 7:
                if (wifiManager != null && WifiConfigManager.m8760a(wifiManager, (WifiParsedResult) mo19232d())) {
                    str = mo19236f().getResources().getString(R.string.mz_wifi_conneted);
                    break;
                }
            default:
                str = mo19236f().getResources().getString(R.string.mz_wifi_connet);
                break;
        }
        this.f8178j = str;
        MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), str);
        kVar.mo23384a(Typeface.create("sans-serif-medium", 0));
        kVar.mo23383a(color);
        gVar.mo19212a((Drawable) kVar);
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 10, (String) null));
        arrayList.add(gVar);
        return arrayList;
    }

    /* renamed from: com.meizu.media.camera.barcode.result.s$1 */
    /* compiled from: WifiResultHandler */
    static /* synthetic */ class C18671 {

        /* renamed from: a */
        static final /* synthetic */ int[] f8179a = new int[NetworkInfo.DetailedState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.net.NetworkInfo$DetailedState[] r0 = android.net.NetworkInfo.DetailedState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8179a = r0
                int[] r0 = f8179a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8179a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.FAILED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f8179a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.OBTAINING_IPADDR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f8179a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.SCANNING     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f8179a     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.AUTHENTICATING     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f8179a     // Catch:{ NoSuchFieldError -> 0x004b }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f8179a     // Catch:{ NoSuchFieldError -> 0x0056 }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.barcode.result.WifiResultHandler.C18671.<clinit>():void");
        }
    }

    /* renamed from: a */
    public void mo19312a(Handler handler, int i) {
        this.f8175g = handler;
        this.f8176h = i;
    }
}
