package com.baidu.aip.auth;

import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.baidu.aip.auth.a */
public class C0474a {
    /* renamed from: a */
    public static String m762a(String str, String str2) {
        try {
            URL url = new URL(str);
            byte[] a = m764a(str2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "text/html");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(ComponentMessageType.MSG_TYPE_ON_SHAKE);
            httpURLConnection.setReadTimeout(ComponentMessageType.MSG_TYPE_ON_SHAKE);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(a);
            return m763a(httpURLConnection);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AuthException(283504, AuthException.f443b);
        }
    }

    /* renamed from: a */
    public static String m763a(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = new char[512];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                stringBuffer.append(new String(cArr, 0, read));
            } else {
                bufferedReader.close();
                return stringBuffer.toString();
            }
        }
    }

    /* renamed from: a */
    public static byte[] m764a(String str) {
        byte[] bArr = new byte[0];
        return str.getBytes("UTF-8");
    }
}
