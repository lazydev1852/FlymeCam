package com.meizu.cloud.pushsdk.networking.ssl;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Environment;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.base.reflect.ReflectClass;
import com.meizu.cloud.pushsdk.base.reflect.ReflectResult;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLExtensionSocketFactory extends SSLSocketFactory {
    private String TAG = "TlsSessionTicket";
    private SSLSocketFactory mDelegate;

    public SSLExtensionSocketFactory(Context context) {
        SSLSessionCache sSLSessionCache;
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            try {
                sSLSessionCache = new SSLSessionCache(new File(Environment.getExternalStorageDirectory(), "sslCache"));
            } catch (IOException e) {
                DebugLogger.m4828e(this.TAG, e.getMessage());
                sSLSessionCache = new SSLSessionCache(context);
            }
            ReflectResult invoke = ReflectClass.forObject(sSLSessionCache).method("install", SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, sSLContext);
            String str = this.TAG;
            DebugLogger.m4829i(str, "install tls session cache " + invoke.f4119ok);
            this.mDelegate = sSLContext.getSocketFactory();
        } catch (Exception e2) {
            DebugLogger.m4828e(this.TAG, e2.getMessage());
            this.mDelegate = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
    }

    private Socket makeSSLSocketSessionTicketSupport(Socket socket) {
        if (socket instanceof SSLSocket) {
            ReflectResult invoke = ReflectClass.forObject(socket).method("setUseSessionTickets", Boolean.TYPE).invoke(socket, true);
            String str = this.TAG;
            DebugLogger.m4829i(str, "set ssl session ticket support " + invoke.f4119ok);
        }
        return socket;
    }

    public String[] getDefaultCipherSuites() {
        return this.mDelegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.mDelegate.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return makeSSLSocketSessionTicketSupport(this.mDelegate.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException {
        return makeSSLSocketSessionTicketSupport(this.mDelegate.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return makeSSLSocketSessionTicketSupport(this.mDelegate.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return makeSSLSocketSessionTicketSupport(this.mDelegate.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return makeSSLSocketSessionTicketSupport(this.mDelegate.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
