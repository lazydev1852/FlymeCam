package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import java.io.File;

/* renamed from: com.android.volley.toolbox.p */
public class Volley {
    /* renamed from: a */
    public static RequestQueue m725a(Context context, BaseHttpStack bVar) {
        BasicNetwork cVar;
        if (bVar != null) {
            cVar = new BasicNetwork(bVar);
        } else if (Build.VERSION.SDK_INT >= 9) {
            cVar = new BasicNetwork((BaseHttpStack) new HurlStack());
        } else {
            String str = "volley/0";
            try {
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                str = packageName + "/" + packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            cVar = new BasicNetwork((HttpStack) new HttpClientStack(AndroidHttpClient.newInstance(str)));
        }
        return m724a(context, (Network) cVar);
    }

    /* renamed from: a */
    private static RequestQueue m724a(Context context, Network hVar) {
        RequestQueue nVar = new RequestQueue(new DiskBasedCache(new File(context.getCacheDir(), "volley")), hVar);
        nVar.mo8704a();
        return nVar;
    }

    /* renamed from: a */
    public static RequestQueue m723a(Context context) {
        return m725a(context, (BaseHttpStack) null);
    }
}
