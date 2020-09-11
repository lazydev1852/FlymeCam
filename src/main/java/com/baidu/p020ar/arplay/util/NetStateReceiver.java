package com.baidu.p020ar.arplay.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.p020ar.arplay.util.NetUtils;
import java.util.ArrayList;

/* renamed from: com.baidu.ar.arplay.util.NetStateReceiver */
public class NetStateReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f901a = "NetStateReceiver";

    /* renamed from: b */
    private static boolean f902b = false;

    /* renamed from: c */
    private static NetUtils.NetType f903c;

    /* renamed from: d */
    private static ArrayList<C0584a> f904d = new ArrayList<>();

    /* renamed from: e */
    private static BroadcastReceiver f905e;

    /* renamed from: a */
    public static void m1156a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.getApplicationContext().registerReceiver(m1159b(), intentFilter);
    }

    /* renamed from: a */
    public static void m1157a(C0584a aVar) {
        if (f904d == null) {
            f904d = new ArrayList<>();
        }
        f904d.add(aVar);
    }

    /* renamed from: a */
    public static boolean m1158a() {
        return f902b;
    }

    /* renamed from: b */
    private static BroadcastReceiver m1159b() {
        if (f905e == null) {
            synchronized (NetStateReceiver.class) {
                if (f905e == null) {
                    f905e = new NetStateReceiver();
                }
            }
        }
        return f905e;
    }

    /* renamed from: b */
    public static void m1160b(Context context) {
        if (f905e != null) {
            try {
                context.getApplicationContext().unregisterReceiver(f905e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m1161b(C0584a aVar) {
        if (f904d != null && f904d.contains(aVar)) {
            f904d.remove(aVar);
        }
    }

    /* renamed from: c */
    private void m1162c() {
        if (!f904d.isEmpty()) {
            int size = f904d.size();
            for (int i = 0; i < size; i++) {
                C0584a aVar = f904d.get(i);
                if (aVar != null) {
                    if (m1158a()) {
                        aVar.mo9076a(f903c);
                    } else {
                        aVar.mo9075a();
                    }
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        f905e = this;
        if (intent.getAction().equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE") || intent.getAction().equalsIgnoreCase("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE")) {
            if (!NetUtils.m1163a(context)) {
                Log.e(getClass().getName(), "<--- network disconnected --->");
                f902b = false;
            } else {
                Log.e(getClass().getName(), "<--- network connected --->");
                f902b = true;
                f903c = NetUtils.m1164b(context);
            }
            m1162c();
        }
    }
}
