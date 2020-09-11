package com.meizu.media.camera.barcode.wifi;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import com.google.zxing.client.result.WifiParsedResult;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* renamed from: com.meizu.media.camera.barcode.wifi.a */
public final class WifiConfigManager extends AsyncTask<WifiParsedResult, Object, Object> {

    /* renamed from: a */
    public static ChangeQuickRedirect f8180a;

    /* renamed from: b */
    private static final LogUtil.C2630a f8181b = new LogUtil.C2630a("WifiConfigManager");

    /* renamed from: c */
    private static final Pattern f8182c = Pattern.compile("[0-9A-Fa-f]+");

    /* renamed from: d */
    private final WifiManager f8183d;

    public WifiConfigManager(WifiManager wifiManager) {
        this.f8183d = wifiManager;
    }

    /* renamed from: a */
    public Object doInBackground(WifiParsedResult... wifiParsedResultArr) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{wifiParsedResultArr}, this, f8180a, false, 2722, new Class[]{WifiParsedResult[].class}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        WifiParsedResult wifiParsedResult = wifiParsedResultArr[0];
        if (!this.f8183d.isWifiEnabled()) {
            LogUtil.m15952c(f8181b, "Enabling wi-fi...");
            if (this.f8183d.setWifiEnabled(true)) {
                LogUtil.m15952c(f8181b, "Wi-fi enabled");
                while (!this.f8183d.isWifiEnabled()) {
                    if (i >= 10) {
                        LogUtil.m15952c(f8181b, "Took too long to enable wi-fi, quitting");
                        return null;
                    }
                    LogUtil.m15952c(f8181b, "Still waiting for wi-fi to enable...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException unused) {
                    }
                    i++;
                }
            } else {
                LogUtil.m15956e(f8181b, "Wi-fi could not be enabled!");
                return null;
            }
        }
        String networkEncryption = wifiParsedResult.getNetworkEncryption();
        try {
            NetworkType forIntentValue = NetworkType.forIntentValue(networkEncryption);
            LogUtil.C2630a aVar = f8181b;
            LogUtil.m15942a(aVar, "networkType:" + forIntentValue);
            if (forIntentValue == NetworkType.NO_PASSWORD) {
                m8765d(this.f8183d, wifiParsedResult);
            } else {
                String password = wifiParsedResult.getPassword();
                if (password != null && !password.isEmpty()) {
                    if (forIntentValue == NetworkType.WEP) {
                        m8763b(this.f8183d, wifiParsedResult);
                    } else if (forIntentValue == NetworkType.WPA) {
                        m8764c(this.f8183d, wifiParsedResult);
                    }
                }
            }
            return null;
        } catch (IllegalArgumentException unused2) {
            LogUtil.C2630a aVar2 = f8181b;
            LogUtil.m15956e(aVar2, "Bad network type; see NetworkType values: " + networkEncryption);
            return null;
        }
    }

    /* renamed from: a */
    private static void m8759a(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        if (!PatchProxy.proxy(new Object[]{wifiManager, wifiConfiguration}, (Object) null, f8180a, true, 2723, new Class[]{WifiManager.class, WifiConfiguration.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f8181b, "updateNetwork start connect");
            try {
                wifiManager.disconnect();
                Method declaredMethod = Class.forName("android.net.wifi.WifiManager").getDeclaredMethod("connect", new Class[]{WifiConfiguration.class, Class.forName("android.net.wifi.WifiManager$ActionListener")});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(wifiManager, new Object[]{wifiConfiguration, null});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static String m8757a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8180a, true, 2724, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (length <= 0 || str.charAt(0) == '\"' || str.charAt(length - 1) == '\"') {
            return str;
        }
        return "\"" + str + "\"";
    }

    /* renamed from: a */
    private static WifiConfiguration m8756a(WifiParsedResult wifiParsedResult) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{wifiParsedResult}, (Object) null, f8180a, true, 2725, new Class[]{WifiParsedResult.class}, WifiConfiguration.class);
        if (proxy.isSupported) {
            return (WifiConfiguration) proxy.result;
        }
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = m8758a(wifiParsedResult.getSsid(), new int[0]);
        wifiConfiguration.hiddenSSID = wifiParsedResult.isHidden();
        return wifiConfiguration;
    }

    /* renamed from: b */
    private static void m8763b(WifiManager wifiManager, WifiParsedResult wifiParsedResult) {
        if (!PatchProxy.proxy(new Object[]{wifiManager, wifiParsedResult}, (Object) null, f8180a, true, 2726, new Class[]{WifiManager.class, WifiParsedResult.class}, Void.TYPE).isSupported) {
            WifiConfiguration a = m8756a(wifiParsedResult);
            a.SSID = m8757a(a.SSID);
            a.preSharedKey = m8757a(a.preSharedKey);
            a.wepKeys[0] = m8758a(wifiParsedResult.getPassword(), 10, 26, 58);
            a.wepTxKeyIndex = 0;
            a.allowedAuthAlgorithms.set(1);
            a.allowedKeyManagement.set(0);
            a.allowedGroupCiphers.set(2);
            a.allowedGroupCiphers.set(3);
            a.allowedGroupCiphers.set(0);
            a.allowedGroupCiphers.set(1);
            m8759a(wifiManager, a);
        }
    }

    /* renamed from: c */
    private static void m8764c(WifiManager wifiManager, WifiParsedResult wifiParsedResult) {
        if (!PatchProxy.proxy(new Object[]{wifiManager, wifiParsedResult}, (Object) null, f8180a, true, 2727, new Class[]{WifiManager.class, WifiParsedResult.class}, Void.TYPE).isSupported) {
            WifiConfiguration a = m8756a(wifiParsedResult);
            a.preSharedKey = m8758a(wifiParsedResult.getPassword(), 64);
            a.SSID = m8757a(a.SSID);
            a.preSharedKey = m8757a(a.preSharedKey);
            a.allowedAuthAlgorithms.set(0);
            a.allowedProtocols.set(0);
            a.allowedProtocols.set(1);
            a.allowedKeyManagement.set(1);
            a.allowedKeyManagement.set(2);
            a.allowedPairwiseCiphers.set(1);
            a.allowedPairwiseCiphers.set(2);
            a.allowedGroupCiphers.set(2);
            a.allowedGroupCiphers.set(3);
            m8759a(wifiManager, a);
        }
    }

    /* renamed from: d */
    private static void m8765d(WifiManager wifiManager, WifiParsedResult wifiParsedResult) {
        if (!PatchProxy.proxy(new Object[]{wifiManager, wifiParsedResult}, (Object) null, f8180a, true, 2728, new Class[]{WifiManager.class, WifiParsedResult.class}, Void.TYPE).isSupported) {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = m8758a(wifiParsedResult.getSsid(), new int[0]);
            wifiConfiguration.SSID = m8757a(wifiConfiguration.SSID);
            wifiConfiguration.hiddenSSID = wifiParsedResult.isHidden();
            wifiConfiguration.allowedKeyManagement.set(0);
            m8759a(wifiManager, wifiConfiguration);
        }
    }

    /* renamed from: a */
    private static String m8758a(String str, int... iArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, iArr}, (Object) null, f8180a, true, 2729, new Class[]{String.class, int[].class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return m8761a((CharSequence) str, iArr) ? str : m8762b(str);
    }

    /* renamed from: b */
    private static String m8762b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8180a, true, 2730, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
            return str;
        }
        return '\"' + str + '\"';
    }

    /* renamed from: a */
    private static boolean m8761a(CharSequence charSequence, int... iArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{charSequence, iArr}, (Object) null, f8180a, true, 2731, new Class[]{CharSequence.class, int[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (charSequence == null || !f8182c.matcher(charSequence).matches()) {
            return false;
        }
        if (iArr.length == 0) {
            return true;
        }
        for (int i : iArr) {
            if (charSequence.length() == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m8760a(WifiManager wifiManager, WifiParsedResult wifiParsedResult) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{wifiManager, wifiParsedResult}, (Object) null, f8180a, true, 2732, new Class[]{WifiManager.class, WifiParsedResult.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null || wifiParsedResult == null) {
            return false;
        }
        String ssid = connectionInfo.getSSID();
        if (ssid.equals("\"" + wifiParsedResult.getSsid() + "\"")) {
            return true;
        }
        return false;
    }
}
