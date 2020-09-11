package com.meizu.perf.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.meizu.perf.sdk.IBoostAffinity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.meizu.perf.sdk.c */
public class PerfSdk {

    /* renamed from: a */
    public static boolean f15623a = false;

    /* renamed from: c */
    private static volatile HandlerThread f15624c;

    /* renamed from: d */
    private static volatile Handler f15625d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static ConcurrentHashMap<String, BoostAffinityEntry> f15626e = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static BoostAffinityEntry f15627f = new BoostAffinityEntry((String) null, 0, (int[]) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static volatile PerfSdk f15628h = null;

    /* renamed from: b */
    public ServiceConnection f15629b = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBoostAffinity unused = PerfSdk.this.f15630g = IBoostAffinity.C2783a.m16928a(iBinder);
            Log.d("PerfSdk", "Perf Sdk init Success!");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            IBoostAffinity unused = PerfSdk.this.f15630g = null;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IBoostAffinity f15630g;

    /* renamed from: a */
    public static void m16933a(final Context context) {
        if (f15628h == null) {
            f15628h = new PerfSdk();
            f15624c = new HandlerThread("MZ_PERF_SDK_THREAD") {
                public void run() {
                    Log.d("PerfSdk", "start init PerfSdk!");
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.meizu.pps", "com.meizu.perf.sdk.BoostAffinityService"));
                    PerfSdk.f15623a = context.bindService(intent, PerfSdk.f15628h.f15629b, 1);
                    super.run();
                }
            };
            f15624c.start();
            f15625d = new Handler(f15624c.getLooper()) {
                public void handleMessage(Message message) {
                    int i;
                    Message message2 = message;
                    super.handleMessage(message);
                    if (message2.what == 1) {
                        BoostAffinityEntry aVar = (BoostAffinityEntry) message2.obj;
                        if (PerfSdk.f15626e.containsKey(aVar.mo23810a())) {
                            PerfSdk.f15626e.remove(aVar.mo23810a());
                        }
                        PerfSdk.f15626e.put(aVar.mo23810a(), aVar);
                    } else {
                        String str = (String) message2.obj;
                        if (PerfSdk.f15626e.containsKey(str)) {
                            PerfSdk.f15626e.remove(str);
                        }
                        if (PerfSdk.f15626e.size() == 0) {
                            PerfSdk.f15628h.mo23823b(PerfSdk.f15627f.mo23810a(), PerfSdk.f15627f.mo23815c());
                            PerfSdk.f15627f.mo23812a((String) null);
                            PerfSdk.f15627f.mo23811a(0);
                            PerfSdk.f15627f.mo23813a((int[]) null);
                            return;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    String str2 = "";
                    Iterator it = PerfSdk.f15626e.values().iterator();
                    long j = 0;
                    while (true) {
                        i = 0;
                        if (!it.hasNext()) {
                            break;
                        }
                        BoostAffinityEntry aVar2 = (BoostAffinityEntry) it.next();
                        long b = aVar2.mo23814b();
                        long j2 = b & 255;
                        long j3 = 255 & j;
                        if (j2 > j3) {
                            j3 = j2;
                        }
                        long j4 = b & 65280;
                        long j5 = 65280 & j;
                        if (j4 <= j5) {
                            j4 = j5;
                        }
                        long j6 = j3 | j4;
                        long j7 = b & 16711680;
                        long j8 = 16711680 & j;
                        if (j7 <= j8) {
                            j7 = j8;
                        }
                        long j9 = j6 | j7;
                        long j10 = b & 4278190080L;
                        long j11 = j & 4278190080L;
                        if (j10 > j11) {
                            j11 = j10;
                        }
                        j = j11 | j9;
                        int[] c = aVar2.mo23815c();
                        if (c != null && c.length > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            int length = c.length;
                            while (i < length) {
                                arrayList2.add(Integer.valueOf(c[i]));
                                i++;
                            }
                            arrayList.removeAll(arrayList2);
                            arrayList.addAll(arrayList2);
                        }
                        str2 = str2 + aVar2.mo23810a() + "|";
                    }
                    int[] iArr = new int[arrayList.size()];
                    while (i < arrayList.size()) {
                        iArr[i] = ((Integer) arrayList.get(i)).intValue();
                        i++;
                    }
                    if (PerfSdk.f15627f.mo23814b() > 0) {
                        PerfSdk.f15628h.mo23823b(PerfSdk.f15627f.mo23810a(), PerfSdk.f15627f.mo23815c());
                    }
                    PerfSdk.f15628h.mo23822b(str2, j, iArr);
                    PerfSdk.f15627f.mo23813a(iArr);
                    PerfSdk.f15627f.mo23811a(j);
                    PerfSdk.f15627f.mo23812a(str2);
                }
            };
        }
    }

    /* renamed from: a */
    public void mo23820a(String str, long j, int[] iArr) {
        f15625d.obtainMessage(1, new BoostAffinityEntry(str, j, iArr)).sendToTarget();
    }

    /* renamed from: a */
    public void mo23821a(String str, int[] iArr) {
        f15625d.obtainMessage(0, str).sendToTarget();
    }

    /* renamed from: b */
    public void mo23822b(String str, long j, int[] iArr) {
        if (this.f15630g != null) {
            try {
                this.f15630g.mo23816a(str, j, iArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo23823b(String str, int[] iArr) {
        if (this.f15630g != null) {
            try {
                this.f15630g.mo23817a(str, iArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static PerfSdk m16934b(Context context) {
        if (f15628h != null) {
            return f15628h;
        }
        throw new NullPointerException("Please Init the perfsdk first!");
    }
}
