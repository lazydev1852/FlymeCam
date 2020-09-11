package com.meizu.media.camera.util;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

/* renamed from: com.meizu.media.camera.util.m */
public class CustomerHttpClient {

    /* renamed from: a */
    public static ChangeQuickRedirect f14262a;

    /* renamed from: b */
    private static HttpClient f14263b;

    /* renamed from: a */
    public static synchronized HttpClient m16183a() {
        synchronized (CustomerHttpClient.class) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14262a, true, 7970, new Class[0], HttpClient.class);
            if (proxy.isSupported) {
                HttpClient httpClient = (HttpClient) proxy.result;
                return httpClient;
            }
            if (f14263b == null) {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                basicHttpParams.setIntParameter("http.conn-manager.max-total", 25);
                HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
                HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
                HttpProtocolParams.setUseExpectContinue(basicHttpParams, true);
                ConnManagerParams.setTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
                f14263b = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            }
            HttpClient httpClient2 = f14263b;
            return httpClient2;
        }
    }
}
