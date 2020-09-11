package com.meizu.statsapp.p081v3.lib.plugin.utils;

import com.baidu.p020ar.util.SystemInfoUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.MacAndroid7 */
public class MacAndroid7 {
    private static InetAddress getLocalInetAddress() {
        InetAddress inetAddress;
        SocketException e;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (!inetAddresses.hasMoreElements()) {
                            break;
                        }
                        InetAddress nextElement = inetAddresses.nextElement();
                        try {
                            if (!nextElement.isLoopbackAddress() && nextElement.getHostAddress().indexOf(SystemInfoUtil.COLON) == -1) {
                                inetAddress = nextElement;
                                continue;
                                break;
                            }
                            inetAddress = null;
                        } catch (SocketException e2) {
                            e = e2;
                            inetAddress = nextElement;
                            e.printStackTrace();
                            return inetAddress;
                        }
                    }
                } catch (SocketException e3) {
                    e = e3;
                    e.printStackTrace();
                    return inetAddress;
                }
            } while (inetAddress == null);
        } catch (SocketException e4) {
            inetAddress = null;
            e = e4;
            e.printStackTrace();
            return inetAddress;
        }
        return inetAddress;
    }

    private static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getMacAddress() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(getLocalInetAddress()).getHardwareAddress();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                if (hexString.length() == 1) {
                    hexString = 0 + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMachineHardwareAddress() {
        Enumeration<NetworkInterface> enumeration;
        String str = null;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
            enumeration = null;
        }
        while (enumeration.hasMoreElements()) {
            try {
                String bytesToString = bytesToString(enumeration.nextElement().getHardwareAddress());
                if (bytesToString != null) {
                    return bytesToString;
                }
                str = bytesToString;
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    private static String bytesToString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X:", new Object[]{Byte.valueOf(bArr[i])}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String getLocalMacAddressFromBusybox() {
        String callCmd = callCmd("busybox ifconfig", "HWaddr");
        if (callCmd == null) {
            return "网络异常";
        }
        return (callCmd.length() <= 0 || !callCmd.contains("HWaddr")) ? callCmd : callCmd.substring(callCmd.indexOf("HWaddr") + 6, callCmd.length() - 1);
    }

    private static String callCmd(String str, String str2) {
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.contains(str2)) {
                    return readLine;
                }
                str3 = str3 + readLine;
            }
        } catch (Exception unused) {
            return str3;
        }
    }
}
