package com.meizu.update.p085c.p089d;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* renamed from: com.meizu.update.c.d.b */
public class IpHelper {
    /* renamed from: a */
    public static String m17658a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m17659a(String str) {
        String str2 = null;
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName != null) {
                if (!(byName instanceof Inet4Address)) {
                    str = byName.getHostAddress();
                }
                str2 = str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2 == null ? "" : str2;
    }
}
