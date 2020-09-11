package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.Hashtable;

/* renamed from: com.loc.bv */
/* compiled from: Cache */
public final class C1066bv {

    /* renamed from: a */
    Hashtable<String, ArrayList<C1067a>> f2777a = new Hashtable<>();

    /* renamed from: b */
    boolean f2778b = true;

    /* renamed from: c */
    long f2779c = 0;

    /* renamed from: d */
    String f2780d = null;

    /* renamed from: e */
    Cgi f2781e = null;

    /* renamed from: f */
    boolean f2782f = true;

    /* renamed from: g */
    boolean f2783g = true;

    /* renamed from: h */
    String f2784h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* renamed from: i */
    private long f2785i = 0;

    /* renamed from: j */
    private boolean f2786j = false;

    /* renamed from: k */
    private String f2787k = "2.0.201501131131".replace(".", "");

    /* renamed from: l */
    private String f2788l = null;

    /* renamed from: m */
    private String f2789m = null;

    /* renamed from: n */
    private long f2790n = 0;

    /* renamed from: com.loc.bv$a */
    /* compiled from: Cache */
    static class C1067a {

        /* renamed from: a */
        private AMapLocationServer f2791a = null;

        /* renamed from: b */
        private String f2792b = null;

        protected C1067a() {
        }

        /* renamed from: a */
        public final AMapLocationServer mo13127a() {
            return this.f2791a;
        }

        /* renamed from: a */
        public final void mo13128a(AMapLocationServer aMapLocationServer) {
            this.f2791a = aMapLocationServer;
        }

        /* renamed from: a */
        public final void mo13129a(String str) {
            this.f2792b = TextUtils.isEmpty(str) ? null : str.replace("##", "#");
        }

        /* renamed from: b */
        public final String mo13130b() {
            return this.f2792b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[Catch:{ Throwable -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d A[Catch:{ Throwable -> 0x0085 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.autonavi.aps.amapapi.model.AMapLocationServer m3215a(java.lang.String r5, java.lang.StringBuilder r6) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "cgiwifi"
            boolean r1 = r5.contains(r1)     // Catch:{ Throwable -> 0x0085 }
            if (r1 == 0) goto L_0x000e
        L_0x0009:
            com.loc.bv$a r6 = r4.m3216a((java.lang.StringBuilder) r6, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0085 }
            goto L_0x0038
        L_0x000e:
            java.lang.String r1 = "wifi"
            boolean r1 = r5.contains(r1)     // Catch:{ Throwable -> 0x0085 }
            if (r1 == 0) goto L_0x0017
            goto L_0x0009
        L_0x0017:
            java.lang.String r6 = "cgi"
            boolean r6 = r5.contains(r6)     // Catch:{ Throwable -> 0x0085 }
            if (r6 == 0) goto L_0x0037
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r6 = r4.f2777a     // Catch:{ Throwable -> 0x0085 }
            boolean r6 = r6.containsKey(r5)     // Catch:{ Throwable -> 0x0085 }
            if (r6 == 0) goto L_0x0037
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r6 = r4.f2777a     // Catch:{ Throwable -> 0x0085 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Throwable -> 0x0085 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ Throwable -> 0x0085 }
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch:{ Throwable -> 0x0085 }
            com.loc.bv$a r6 = (com.loc.C1066bv.C1067a) r6     // Catch:{ Throwable -> 0x0085 }
            goto L_0x0038
        L_0x0037:
            r6 = r0
        L_0x0038:
            if (r6 == 0) goto L_0x008d
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r6.mo13127a()     // Catch:{ Throwable -> 0x0085 }
            boolean r1 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r1)     // Catch:{ Throwable -> 0x0085 }
            if (r1 == 0) goto L_0x008d
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = r6.mo13127a()     // Catch:{ Throwable -> 0x0085 }
            java.lang.String r2 = "mem"
            r1.mo8813w(r2)     // Catch:{ Throwable -> 0x0085 }
            java.lang.String r2 = r6.mo13130b()     // Catch:{ Throwable -> 0x0085 }
            r1.mo8817z(r2)     // Catch:{ Throwable -> 0x0085 }
            long r2 = r1.getTime()     // Catch:{ Throwable -> 0x0085 }
            boolean r2 = com.loc.AuthUtil.m3349b((long) r2)     // Catch:{ Throwable -> 0x0085 }
            if (r2 == 0) goto L_0x006d
            boolean r5 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r1)     // Catch:{ Throwable -> 0x0085 }
            if (r5 == 0) goto L_0x0068
            r5 = 0
            r4.f2779c = r5     // Catch:{ Throwable -> 0x0085 }
        L_0x0068:
            r5 = 4
            r1.mo8481b((int) r5)     // Catch:{ Throwable -> 0x0085 }
            return r1
        L_0x006d:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r1 = r4.f2777a     // Catch:{ Throwable -> 0x0085 }
            if (r1 == 0) goto L_0x008d
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r1 = r4.f2777a     // Catch:{ Throwable -> 0x0085 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ Throwable -> 0x0085 }
            if (r1 == 0) goto L_0x008d
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r1 = r4.f2777a     // Catch:{ Throwable -> 0x0085 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Throwable -> 0x0085 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ Throwable -> 0x0085 }
            r5.remove(r6)     // Catch:{ Throwable -> 0x0085 }
            goto L_0x008d
        L_0x0085:
            r5 = move-exception
            java.lang.String r6 = "Cache"
            java.lang.String r1 = "get1"
            com.loc.CoreUtil.m3389a(r5, r6, r1)
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.m3215a(java.lang.String, java.lang.StringBuilder):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed A[LOOP:1: B:34:0x00e7->B:36:0x00ed, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107 A[LOOP:2: B:38:0x0101->B:40:0x0107, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0177 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.loc.C1066bv.C1067a m3216a(java.lang.StringBuilder r26, java.lang.String r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r2 = r0.f2777a
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 != 0) goto L_0x0195
            boolean r2 = android.text.TextUtils.isEmpty(r26)
            if (r2 == 0) goto L_0x0015
            goto L_0x0195
        L_0x0015:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r2 = r0.f2777a
            boolean r2 = r2.containsKey(r1)
            if (r2 != 0) goto L_0x001e
            return r3
        L_0x001e:
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            java.util.Hashtable r4 = new java.util.Hashtable
            r4.<init>()
            java.util.Hashtable r5 = new java.util.Hashtable
            r5.<init>()
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r6 = r0.f2777a
            java.lang.Object r1 = r6.get(r1)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r6 = r1.size()
            r7 = 1
            int r6 = r6 - r7
        L_0x003b:
            if (r6 < 0) goto L_0x0189
            java.lang.Object r8 = r1.get(r6)
            com.loc.bv$a r8 = (com.loc.C1066bv.C1067a) r8
            java.lang.String r9 = r8.mo13130b()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0182
            java.lang.String r9 = r8.mo13130b()
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            r11 = 0
            if (r10 != 0) goto L_0x00b6
            boolean r10 = android.text.TextUtils.isEmpty(r26)
            if (r10 == 0) goto L_0x005f
            goto L_0x00b6
        L_0x005f:
            java.lang.String r10 = ",access"
            boolean r10 = r9.contains(r10)
            if (r10 == 0) goto L_0x00b6
            java.lang.String r10 = ",access"
            r12 = r26
            int r10 = r12.indexOf(r10)
            r13 = -1
            if (r10 != r13) goto L_0x0073
            goto L_0x00b8
        L_0x0073:
            java.lang.String r10 = ",access"
            java.lang.String[] r9 = r9.split(r10)
            r10 = r9[r11]
            java.lang.String r13 = "#"
            boolean r10 = r10.contains(r13)
            if (r10 == 0) goto L_0x0093
            r10 = r9[r11]
            r9 = r9[r11]
            java.lang.String r13 = "#"
            int r9 = r9.lastIndexOf(r13)
            int r9 = r9 + r7
            java.lang.String r9 = r10.substring(r9)
            goto L_0x0095
        L_0x0093:
            r9 = r9[r11]
        L_0x0095:
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L_0x009c
            goto L_0x00b8
        L_0x009c:
            java.lang.String r10 = r26.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r9)
            java.lang.String r9 = ",access"
            r13.append(r9)
            java.lang.String r9 = r13.toString()
            boolean r9 = r10.contains(r9)
            goto L_0x00b9
        L_0x00b6:
            r12 = r26
        L_0x00b8:
            r9 = 0
        L_0x00b9:
            if (r9 == 0) goto L_0x00cd
            java.lang.String r9 = r8.mo13130b()
            java.lang.String r10 = r26.toString()
            boolean r9 = com.loc.C1079cp.m3511a((java.lang.String) r9, (java.lang.String) r10)
            if (r9 == 0) goto L_0x00cb
            goto L_0x017f
        L_0x00cb:
            r9 = 1
            goto L_0x00ce
        L_0x00cd:
            r9 = 0
        L_0x00ce:
            java.lang.String r10 = r8.mo13130b()
            m3220a((java.lang.String) r10, (java.util.Hashtable<java.lang.String, java.lang.String>) r2)
            java.lang.String r10 = r26.toString()
            m3220a((java.lang.String) r10, (java.util.Hashtable<java.lang.String, java.lang.String>) r4)
            r5.clear()
            java.util.Set r10 = r2.keySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x00e7:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x00f9
            java.lang.Object r13 = r10.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = ""
            r5.put(r13, r14)
            goto L_0x00e7
        L_0x00f9:
            java.util.Set r10 = r4.keySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0101:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x0113
            java.lang.Object r13 = r10.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = ""
            r5.put(r13, r14)
            goto L_0x0101
        L_0x0113:
            java.util.Set r10 = r5.keySet()
            int r13 = r10.size()
            double[] r13 = new double[r13]
            int r14 = r10.size()
            double[] r14 = new double[r14]
            java.util.Iterator r15 = r10.iterator()
            r16 = 0
        L_0x0129:
            if (r15 == 0) goto L_0x0158
            boolean r17 = r15.hasNext()
            if (r17 == 0) goto L_0x0158
            java.lang.Object r17 = r15.next()
            r3 = r17
            java.lang.String r3 = (java.lang.String) r3
            boolean r17 = r2.containsKey(r3)
            r19 = 0
            r21 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r17 == 0) goto L_0x0146
            r23 = r21
            goto L_0x0148
        L_0x0146:
            r23 = r19
        L_0x0148:
            r13[r16] = r23
            boolean r3 = r4.containsKey(r3)
            if (r3 == 0) goto L_0x0152
            r19 = r21
        L_0x0152:
            r14[r16] = r19
            int r16 = r16 + 1
            r3 = 0
            goto L_0x0129
        L_0x0158:
            r10.clear()
            double[] r3 = m3221a((double[]) r13, (double[]) r14)
            r13 = r3[r11]
            r15 = 4605380979056443392(0x3fe99999a0000000, double:0.800000011920929)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 < 0) goto L_0x016b
            goto L_0x017f
        L_0x016b:
            r13 = r3[r7]
            r15 = 4603741668684706349(0x3fe3c6a7ef9db22d, double:0.618)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 < 0) goto L_0x0177
            goto L_0x017f
        L_0x0177:
            if (r9 == 0) goto L_0x0184
            r9 = r3[r11]
            int r3 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r3 < 0) goto L_0x0184
        L_0x017f:
            r18 = r8
            goto L_0x018b
        L_0x0182:
            r12 = r26
        L_0x0184:
            int r6 = r6 + -1
            r3 = 0
            goto L_0x003b
        L_0x0189:
            r18 = 0
        L_0x018b:
            r2.clear()
            r4.clear()
            r5.clear()
            return r18
        L_0x0195:
            r1 = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.m3216a(java.lang.StringBuilder, java.lang.String):com.loc.bv$a");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m3217a(java.lang.String r6, java.lang.StringBuilder r7, android.content.Context r8) {
        /*
            r5 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = r5.f2788l     // Catch:{  }
            if (r2 != 0) goto L_0x0019
            java.lang.String r2 = "MD5"
            java.lang.String r8 = com.loc.AppInfo.m3663c(r8)     // Catch:{  }
            java.lang.String r8 = com.loc.Encrypt.m3207a((java.lang.String) r2, (java.lang.String) r8)     // Catch:{  }
            r5.f2788l = r8     // Catch:{  }
        L_0x0019:
            java.lang.String r8 = "&"
            boolean r8 = r6.contains(r8)     // Catch:{  }
            r2 = 0
            if (r8 == 0) goto L_0x002c
            java.lang.String r8 = "&"
            int r8 = r6.indexOf(r8)     // Catch:{  }
            java.lang.String r6 = r6.substring(r2, r8)     // Catch:{  }
        L_0x002c:
            java.lang.String r8 = "#"
            int r8 = r6.lastIndexOf(r8)     // Catch:{  }
            int r8 = r8 + 1
            java.lang.String r8 = r6.substring(r8)     // Catch:{  }
            java.lang.String r3 = "cgi"
            boolean r3 = r8.equals(r3)     // Catch:{  }
            if (r3 == 0) goto L_0x0050
            java.lang.String r7 = "cgi"
            int r8 = r6.length()     // Catch:{  }
            int r8 = r8 + -12
            java.lang.String r6 = r6.substring(r2, r8)     // Catch:{  }
        L_0x004c:
            r1.put(r7, r6)     // Catch:{  }
            goto L_0x009d
        L_0x0050:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{  }
            if (r3 != 0) goto L_0x009d
            java.lang.String r3 = ",access"
            int r3 = r7.indexOf(r3)     // Catch:{  }
            r4 = -1
            if (r3 == r4) goto L_0x009d
            int r8 = r8.length()     // Catch:{  }
            int r8 = r8 + 9
            int r3 = r6.length()     // Catch:{  }
            int r3 = r3 - r8
            java.lang.String r6 = r6.substring(r2, r3)     // Catch:{  }
            java.lang.String r8 = "cgi"
            r1.put(r8, r6)     // Catch:{  }
            java.lang.String r6 = r7.toString()     // Catch:{  }
            java.lang.String r7 = ",access"
            java.lang.String[] r6 = r6.split(r7)     // Catch:{  }
            r7 = r6[r2]     // Catch:{  }
            java.lang.String r8 = "#"
            boolean r7 = r7.contains(r8)     // Catch:{  }
            if (r7 == 0) goto L_0x0098
            r7 = r6[r2]     // Catch:{  }
            r6 = r6[r2]     // Catch:{  }
            java.lang.String r8 = "#"
            int r6 = r6.lastIndexOf(r8)     // Catch:{  }
            int r6 = r6 + 1
            java.lang.String r6 = r7.substring(r6)     // Catch:{  }
            goto L_0x009a
        L_0x0098:
            r6 = r6[r2]     // Catch:{  }
        L_0x009a:
            java.lang.String r7 = "mmac"
            goto L_0x004c
        L_0x009d:
            java.lang.String r6 = r1.toString()     // Catch:{ Throwable -> 0x00b2 }
            java.lang.String r7 = "UTF-8"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Throwable -> 0x00b2 }
            java.lang.String r7 = r5.f2788l     // Catch:{ Throwable -> 0x00b2 }
            byte[] r6 = com.loc.Encrypt.m3213c(r6, r7)     // Catch:{ Throwable -> 0x00b2 }
            java.lang.String r6 = com.loc.C1102dd.m3743b((byte[]) r6)     // Catch:{  }
            return r6
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.m3217a(java.lang.String, java.lang.StringBuilder, android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb A[Catch:{ Throwable -> 0x0268, all -> 0x0266 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x028f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3218a(android.content.Context r11, java.lang.String r12) throws java.lang.Exception {
        /*
            r10 = this;
            boolean r0 = com.loc.AuthUtil.m3370o()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            if (r11 != 0) goto L_0x000a
            return
        L_0x000a:
            r0 = 0
            java.lang.String r1 = "hmdb"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.openOrCreateDatabase(r1, r2, r0)     // Catch:{ Throwable -> 0x0271, all -> 0x026d }
            java.lang.String r3 = "hist"
            boolean r3 = com.loc.C1079cp.m3506a((android.database.sqlite.SQLiteDatabase) r1, (java.lang.String) r3)     // Catch:{ Throwable -> 0x026b }
            if (r3 != 0) goto L_0x0026
            if (r1 == 0) goto L_0x0025
            boolean r11 = r1.isOpen()     // Catch:{ Throwable -> 0x026b }
            if (r11 == 0) goto L_0x0025
            r1.close()     // Catch:{ Throwable -> 0x026b }
        L_0x0025:
            return
        L_0x0026:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x026b }
            r3.<init>()     // Catch:{ Throwable -> 0x026b }
            java.lang.String r4 = "SELECT feature, nb, loc FROM "
            r3.append(r4)     // Catch:{ Throwable -> 0x026b }
            java.lang.String r4 = "hist"
            r3.append(r4)     // Catch:{ Throwable -> 0x026b }
            java.lang.String r4 = r10.f2787k     // Catch:{ Throwable -> 0x026b }
            r3.append(r4)     // Catch:{ Throwable -> 0x026b }
            long r4 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x026b }
            long r6 = com.loc.AuthUtil.m3369n()     // Catch:{ Throwable -> 0x026b }
            r8 = 0
            long r4 = r4 - r6
            java.lang.String r6 = " WHERE time > "
            r3.append(r6)     // Catch:{ Throwable -> 0x026b }
            r3.append(r4)     // Catch:{ Throwable -> 0x026b }
            if (r12 == 0) goto L_0x0067
            java.lang.String r4 = " and feature = '"
            r3.append(r4)     // Catch:{ Throwable -> 0x026b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x026b }
            r4.<init>()     // Catch:{ Throwable -> 0x026b }
            r4.append(r12)     // Catch:{ Throwable -> 0x026b }
            java.lang.String r12 = "'"
            r4.append(r12)     // Catch:{ Throwable -> 0x026b }
            java.lang.String r12 = r4.toString()     // Catch:{ Throwable -> 0x026b }
            r3.append(r12)     // Catch:{ Throwable -> 0x026b }
        L_0x0067:
            java.lang.String r12 = " ORDER BY time ASC;"
            r3.append(r12)     // Catch:{ Throwable -> 0x026b }
            java.lang.String r12 = r3.toString()     // Catch:{ Throwable -> 0x026b }
            android.database.Cursor r12 = r1.rawQuery(r12, r0)     // Catch:{ Throwable -> 0x026b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r0.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r4 = r10.f2788l     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 != 0) goto L_0x0089
            java.lang.String r4 = "MD5"
            java.lang.String r5 = com.loc.AppInfo.m3663c(r11)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r4 = com.loc.Encrypt.m3207a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r10.f2788l = r4     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        L_0x0089:
            if (r12 == 0) goto L_0x0255
            boolean r4 = r12.moveToFirst()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 == 0) goto L_0x0255
        L_0x0091:
            java.lang.String r4 = r12.getString(r2)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "{"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x00f4
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r7 = r12.getString(r2)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r4.<init>(r7)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            int r7 = r0.length()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r0.delete(r2, r7)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r7 = r12.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r7 != 0) goto L_0x00c1
            java.lang.String r6 = r12.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        L_0x00bd:
            r0.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            goto L_0x00da
        L_0x00c1:
            java.lang.String r6 = "mmac"
            boolean r6 = com.loc.C1079cp.m3512a((org.json.JSONObject) r4, (java.lang.String) r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r6 == 0) goto L_0x00da
            java.lang.String r6 = "#"
            r0.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "mmac"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r0.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = ",access"
            goto L_0x00bd
        L_0x00da:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = r12.getString(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "type"
            boolean r5 = com.loc.C1079cp.m3512a((org.json.JSONObject) r6, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r5 == 0) goto L_0x017d
            java.lang.String r5 = "type"
            java.lang.String r7 = "new"
            r6.put(r5, r7)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            goto L_0x017d
        L_0x00f4:
            java.lang.String r4 = r12.getString(r2)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            byte[] r4 = com.loc.C1102dd.m3744b((java.lang.String) r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r9 = r10.f2788l     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            byte[] r4 = com.loc.Encrypt.m3214d(r4, r9)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r9 = "UTF-8"
            r8.<init>(r4, r9)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            int r4 = r0.length()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r0.delete(r2, r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r4 = r12.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 != 0) goto L_0x0138
            java.lang.String r4 = r12.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            byte[] r4 = com.loc.C1102dd.m3744b((java.lang.String) r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = new java.lang.String     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r8 = r10.f2788l     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            byte[] r4 = com.loc.Encrypt.m3214d(r4, r8)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r8 = "UTF-8"
            r6.<init>(r4, r8)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r0.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            goto L_0x0153
        L_0x0138:
            java.lang.String r4 = "mmac"
            boolean r4 = com.loc.C1079cp.m3512a((org.json.JSONObject) r7, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 == 0) goto L_0x0153
            java.lang.String r4 = "#"
            r0.append(r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r4 = "mmac"
            java.lang.String r4 = r7.getString(r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r0.append(r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r4 = ",access"
            r0.append(r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        L_0x0153:
            java.lang.String r4 = r12.getString(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            byte[] r4 = com.loc.C1102dd.m3744b((java.lang.String) r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r8 = r10.f2788l     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            byte[] r4 = com.loc.Encrypt.m3214d(r4, r8)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r8 = "UTF-8"
            r5.<init>(r4, r8)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r4 = "type"
            boolean r4 = com.loc.C1079cp.m3512a((org.json.JSONObject) r6, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 == 0) goto L_0x017c
            java.lang.String r4 = "type"
            java.lang.String r5 = "new"
            r6.put(r4, r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        L_0x017c:
            r4 = r7
        L_0x017d:
            com.autonavi.aps.amapapi.model.AMapLocationServer r7 = new com.autonavi.aps.amapapi.model.AMapLocationServer     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = ""
            r7.<init>(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r7.mo8807b(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "mmac"
            boolean r5 = com.loc.C1079cp.m3512a((org.json.JSONObject) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r5 == 0) goto L_0x01ee
            java.lang.String r5 = "cgi"
            boolean r5 = com.loc.C1079cp.m3512a((org.json.JSONObject) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r5 == 0) goto L_0x01ee
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r5.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "cgi"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r5.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "#"
            r5.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r6.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r6.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "network#"
            r6.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = r6.toString()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "cgi"
            java.lang.String r4 = r4.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "#"
            boolean r4 = r4.contains(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 == 0) goto L_0x01e0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r4.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r4.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "cgiwifi"
            r4.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        L_0x01da:
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r5 = r4
            goto L_0x023a
        L_0x01e0:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r4.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r4.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "wifi"
            r4.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            goto L_0x01da
        L_0x01ee:
            java.lang.String r5 = "cgi"
            boolean r5 = com.loc.C1079cp.m3512a((org.json.JSONObject) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r5 == 0) goto L_0x0241
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r5.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "cgi"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r5.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "#"
            r5.append(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r6.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r6.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "network#"
            r6.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = r6.toString()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "cgi"
            java.lang.String r4 = r4.getString(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r6 = "#"
            boolean r4 = r4.contains(r6)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 == 0) goto L_0x0241
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r4.<init>()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r4.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            java.lang.String r5 = "cgi"
            r4.append(r5)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            goto L_0x01da
        L_0x023a:
            r9 = 0
            r4 = r10
            r6 = r0
            r8 = r11
            r4.mo13125a(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        L_0x0241:
            boolean r4 = r12.moveToNext()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            if (r4 != 0) goto L_0x0091
            int r11 = r0.length()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r0.delete(r2, r11)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            int r11 = r3.length()     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
            r3.delete(r2, r11)     // Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        L_0x0255:
            if (r12 == 0) goto L_0x025a
            r12.close()
        L_0x025a:
            if (r1 == 0) goto L_0x0265
            boolean r11 = r1.isOpen()
            if (r11 == 0) goto L_0x0265
            r1.close()
        L_0x0265:
            return
        L_0x0266:
            r11 = move-exception
            goto L_0x028d
        L_0x0268:
            r11 = move-exception
            r0 = r12
            goto L_0x0273
        L_0x026b:
            r11 = move-exception
            goto L_0x0273
        L_0x026d:
            r11 = move-exception
            r12 = r0
            r1 = r12
            goto L_0x028d
        L_0x0271:
            r11 = move-exception
            r1 = r0
        L_0x0273:
            java.lang.String r12 = "DB"
            java.lang.String r2 = "fetchHist p2"
            com.loc.CoreUtil.m3389a(r11, r12, r2)     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x027f
            r0.close()
        L_0x027f:
            if (r1 == 0) goto L_0x028a
            boolean r11 = r1.isOpen()
            if (r11 == 0) goto L_0x028a
            r1.close()
        L_0x028a:
            return
        L_0x028b:
            r11 = move-exception
            r12 = r0
        L_0x028d:
            if (r12 == 0) goto L_0x0292
            r12.close()
        L_0x0292:
            if (r1 == 0) goto L_0x029d
            boolean r12 = r1.isOpen()
            if (r12 == 0) goto L_0x029d
            r1.close()
        L_0x029d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.m3218a(android.content.Context, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3219a(java.lang.String r6, com.amap.api.location.AMapLocation r7, java.lang.StringBuilder r8, android.content.Context r9) throws java.lang.Exception {
        /*
            r5 = this;
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r5.f2788l
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "MD5"
            java.lang.String r1 = com.loc.AppInfo.m3663c(r9)
            java.lang.String r0 = com.loc.Encrypt.m3207a((java.lang.String) r0, (java.lang.String) r1)
            r5.f2788l = r0
        L_0x0013:
            java.lang.String r6 = r5.m3217a(r6, r8, r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 0
            java.lang.String r3 = "hmdb"
            android.database.sqlite.SQLiteDatabase r9 = r9.openOrCreateDatabase(r3, r2, r1)     // Catch:{ Throwable -> 0x00c8 }
            java.lang.String r1 = "CREATE TABLE IF NOT EXISTS hist"
            r0.append(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r1 = r5.f2787k     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r0.append(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r1 = " (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);"
            r0.append(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r1 = r0.toString()     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r9.execSQL(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            int r1 = r0.length()     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r0.delete(r2, r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r1 = "REPLACE INTO "
            r0.append(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r1 = "hist"
            r0.append(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r1 = r5.f2787k     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r0.append(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r1 = " VALUES (?, ?, ?, ?)"
            r0.append(r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r1[r2] = r6     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r6 = r8.toString()     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r8 = "UTF-8"
            byte[] r6 = r6.getBytes(r8)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r8 = r5.f2788l     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            byte[] r6 = com.loc.Encrypt.m3213c(r6, r8)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r8 = 1
            r1[r8] = r6     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r6 = 2
            java.lang.String r3 = r7.mo8539w()     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r4 = "UTF-8"
            byte[] r3 = r3.getBytes(r4)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r4 = r5.f2788l     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            byte[] r3 = com.loc.Encrypt.m3213c(r3, r4)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r1[r6] = r3     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r6 = 3
            long r3 = r7.getTime()     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.Long r7 = java.lang.Long.valueOf(r3)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r1[r6] = r7     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r6 = 1
        L_0x008c:
            int r7 = r1.length     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            int r7 = r7 - r8
            if (r6 >= r7) goto L_0x009f
            r7 = r1[r6]     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            byte[] r7 = (byte[]) r7     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            byte[] r7 = (byte[]) r7     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            java.lang.String r7 = com.loc.C1102dd.m3743b((byte[]) r7)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r1[r6] = r7     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            int r6 = r6 + 1
            goto L_0x008c
        L_0x009f:
            java.lang.String r6 = r0.toString()     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r9.execSQL(r6, r1)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            int r6 = r0.length()     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            r0.delete(r2, r6)     // Catch:{ Throwable -> 0x00c2, all -> 0x00c0 }
            int r6 = r0.length()
            r0.delete(r2, r6)
            if (r9 == 0) goto L_0x00bf
            boolean r6 = r9.isOpen()
            if (r6 == 0) goto L_0x00bf
            r9.close()
        L_0x00bf:
            return
        L_0x00c0:
            r6 = move-exception
            goto L_0x00e3
        L_0x00c2:
            r6 = move-exception
            r1 = r9
            goto L_0x00c9
        L_0x00c5:
            r6 = move-exception
            r9 = r1
            goto L_0x00e3
        L_0x00c8:
            r6 = move-exception
        L_0x00c9:
            java.lang.String r7 = "DB"
            java.lang.String r8 = "updateHist"
            com.loc.CoreUtil.m3389a(r6, r7, r8)     // Catch:{ all -> 0x00c5 }
            int r6 = r0.length()
            r0.delete(r2, r6)
            if (r1 == 0) goto L_0x00e2
            boolean r6 = r1.isOpen()
            if (r6 == 0) goto L_0x00e2
            r1.close()
        L_0x00e2:
            return
        L_0x00e3:
            int r7 = r0.length()
            r0.delete(r2, r7)
            if (r9 == 0) goto L_0x00f5
            boolean r7 = r9.isOpen()
            if (r7 == 0) goto L_0x00f5
            r9.close()
        L_0x00f5:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.m3219a(java.lang.String, com.amap.api.location.AMapLocation, java.lang.StringBuilder, android.content.Context):void");
    }

    /* renamed from: a */
    private static void m3220a(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            for (String str2 : str.split("#")) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                    hashtable.put(str2, "");
                }
            }
        }
    }

    /* renamed from: a */
    private static double[] m3221a(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr3.length; i3++) {
            d += dArr3[i3] * dArr3[i3];
            d2 += dArr2[i3] * dArr2[i3];
            d3 += dArr3[i3] * dArr2[i3];
            if (dArr2[i3] == 1.0d) {
                i2++;
                if (dArr3[i3] == 1.0d) {
                    i++;
                }
            }
        }
        dArr4[0] = d3 / (Math.sqrt(d) * Math.sqrt(d2));
        double d4 = (double) i;
        dArr4[1] = (d4 * 1.0d) / ((double) i2);
        dArr4[2] = d4;
        for (int i4 = 0; i4 < dArr4.length - 1; i4++) {
            if (dArr4[i4] > 1.0d) {
                dArr4[i4] = 1.0d;
            }
        }
        return dArr4;
    }

    /* renamed from: b */
    private boolean m3222b() {
        return this.f2785i != 0 && (this.f2777a.size() > 360 || C1079cp.m3529c() - this.f2785i > 36000000);
    }

    /* renamed from: c */
    private void m3223c() {
        this.f2785i = 0;
        if (!this.f2777a.isEmpty()) {
            this.f2777a.clear();
        }
        this.f2786j = false;
    }

    /* renamed from: a */
    public final AMapLocationServer mo13118a(Context context, String str, StringBuilder sb, boolean z) {
        if (TextUtils.isEmpty(str) || !AuthUtil.m3370o()) {
            return null;
        }
        String str2 = str + "&" + this.f2782f + "&" + this.f2783g + "&" + this.f2784h;
        if (str2.contains("gps") || !AuthUtil.m3370o() || sb == null) {
            return null;
        }
        if (m3222b()) {
            m3223c();
            return null;
        }
        if (z && !this.f2786j) {
            try {
                String a = m3217a(str2, sb, context);
                m3223c();
                m3218a(context, a);
            } catch (Throwable unused) {
            }
        }
        if (this.f2777a.isEmpty()) {
            return null;
        }
        return m3215a(str2, sb);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b9 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d1 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e3 A[ADDED_TO_REGION, Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f9 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fb A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fe A[Catch:{ Throwable -> 0x010b }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer mo13119a(com.loc.CgiManager r18, boolean r19, com.autonavi.aps.amapapi.model.AMapLocationServer r20, com.loc.WifiManagerWrapper r21, java.lang.StringBuilder r22, java.lang.String r23, android.content.Context r24) {
        /*
            r17 = this;
            r0 = r17
            r2 = r20
            r3 = r23
            boolean r4 = r0.f2778b
            if (r4 == 0) goto L_0x0013
            boolean r4 = com.loc.AuthUtil.m3370o()
            if (r4 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r4 = 1
            goto L_0x0014
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 != 0) goto L_0x0018
        L_0x0016:
            r4 = 0
            goto L_0x0026
        L_0x0018:
            if (r2 == 0) goto L_0x0025
            long r7 = r20.getTime()
            boolean r4 = com.loc.AuthUtil.m3349b((long) r7)
            if (r4 != 0) goto L_0x0025
            goto L_0x0016
        L_0x0025:
            r4 = 1
        L_0x0026:
            r7 = 0
            if (r4 != 0) goto L_0x002a
            return r7
        L_0x002a:
            com.loc.bq r4 = r18.mo13081c()     // Catch:{ Throwable -> 0x010b }
            if (r4 != 0) goto L_0x0034
            com.loc.bq r8 = r0.f2781e     // Catch:{ Throwable -> 0x010b }
            if (r8 == 0) goto L_0x0041
        L_0x0034:
            com.loc.bq r8 = r0.f2781e     // Catch:{ Throwable -> 0x010b }
            if (r8 == 0) goto L_0x0043
            com.loc.bq r8 = r0.f2781e     // Catch:{ Throwable -> 0x010b }
            boolean r4 = r8.equals(r4)     // Catch:{ Throwable -> 0x010b }
            if (r4 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r4 = 0
            goto L_0x0044
        L_0x0043:
            r4 = 1
        L_0x0044:
            if (r2 == 0) goto L_0x005e
            java.util.ArrayList r8 = r21.mo13109c()     // Catch:{ Throwable -> 0x010b }
            int r8 = r8.size()     // Catch:{ Throwable -> 0x010b }
            float r9 = r20.getAccuracy()     // Catch:{ Throwable -> 0x010b }
            r10 = 1133871104(0x43958000, float:299.0)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x005e
            r9 = 5
            if (r8 <= r9) goto L_0x005e
            r8 = 1
            goto L_0x005f
        L_0x005e:
            r8 = 0
        L_0x005f:
            r9 = 3000(0xbb8, double:1.482E-320)
            r11 = 0
            if (r2 == 0) goto L_0x00a1
            java.lang.String r13 = r0.f2780d     // Catch:{ Throwable -> 0x010b }
            if (r13 == 0) goto L_0x00a1
            if (r8 != 0) goto L_0x00a1
            if (r4 != 0) goto L_0x00a1
            java.lang.String r4 = r0.f2780d     // Catch:{ Throwable -> 0x010b }
            java.lang.String r13 = r22.toString()     // Catch:{ Throwable -> 0x010b }
            boolean r4 = com.loc.C1079cp.m3511a((java.lang.String) r4, (java.lang.String) r13)     // Catch:{ Throwable -> 0x010b }
            long r13 = r0.f2779c     // Catch:{ Throwable -> 0x010b }
            int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x008c
            long r13 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x010b }
            long r5 = r0.f2779c     // Catch:{ Throwable -> 0x010b }
            r16 = 0
            long r13 = r13 - r5
            int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r5 >= 0) goto L_0x008c
            r5 = 1
            goto L_0x008d
        L_0x008c:
            r5 = 0
        L_0x008d:
            if (r4 != 0) goto L_0x0091
            if (r5 == 0) goto L_0x00a2
        L_0x0091:
            boolean r5 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r20)     // Catch:{ Throwable -> 0x010b }
            if (r5 == 0) goto L_0x00a2
            java.lang.String r1 = "mem"
            r2.mo8813w(r1)     // Catch:{ Throwable -> 0x010b }
            r1 = 2
            r2.mo8481b((int) r1)     // Catch:{ Throwable -> 0x010b }
            return r2
        L_0x00a1:
            r4 = 0
        L_0x00a2:
            if (r4 != 0) goto L_0x00ab
            long r4 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x010b }
            r0.f2779c = r4     // Catch:{ Throwable -> 0x010b }
            goto L_0x00ad
        L_0x00ab:
            r0.f2779c = r11     // Catch:{ Throwable -> 0x010b }
        L_0x00ad:
            java.lang.String r2 = r0.f2789m     // Catch:{ Throwable -> 0x010b }
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = r0.f2789m     // Catch:{ Throwable -> 0x010b }
            boolean r2 = r3.equals(r2)     // Catch:{ Throwable -> 0x010b }
            if (r2 != 0) goto L_0x00d1
            long r4 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x010b }
            long r13 = r0.f2790n     // Catch:{ Throwable -> 0x010b }
            r2 = 0
            long r4 = r4 - r13
            int r2 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c8
            java.lang.String r2 = r0.f2789m     // Catch:{ Throwable -> 0x010b }
            goto L_0x00e1
        L_0x00c8:
            long r4 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x010b }
        L_0x00cc:
            r0.f2790n = r4     // Catch:{ Throwable -> 0x010b }
            r0.f2789m = r3     // Catch:{ Throwable -> 0x010b }
            goto L_0x00e0
        L_0x00d1:
            java.lang.String r2 = r0.f2789m     // Catch:{ Throwable -> 0x010b }
            if (r2 != 0) goto L_0x00da
            long r4 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x010b }
            goto L_0x00cc
        L_0x00da:
            long r4 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x010b }
            r0.f2790n = r4     // Catch:{ Throwable -> 0x010b }
        L_0x00e0:
            r2 = r3
        L_0x00e1:
            if (r8 != 0) goto L_0x00ef
            if (r19 != 0) goto L_0x00ef
            r3 = r22
            r4 = r24
            r5 = 0
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r0.mo13118a((android.content.Context) r4, (java.lang.String) r2, (java.lang.StringBuilder) r3, (boolean) r5)     // Catch:{ Throwable -> 0x010b }
            goto L_0x00f1
        L_0x00ef:
            r5 = 0
            r2 = r7
        L_0x00f1:
            if (r19 != 0) goto L_0x00fb
            boolean r3 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)     // Catch:{ Throwable -> 0x010b }
            if (r3 != 0) goto L_0x00fb
            r15 = 1
            goto L_0x00fc
        L_0x00fb:
            r15 = 0
        L_0x00fc:
            if (r15 != 0) goto L_0x010b
            if (r8 == 0) goto L_0x0101
            goto L_0x010b
        L_0x0101:
            if (r19 == 0) goto L_0x0104
            return r7
        L_0x0104:
            r0.f2779c = r11     // Catch:{ Throwable -> 0x010b }
            r1 = 4
            r2.mo8481b((int) r1)     // Catch:{ Throwable -> 0x010b }
            return r2
        L_0x010b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.mo13119a(com.loc.br, boolean, com.autonavi.aps.amapapi.model.AMapLocationServer, com.loc.bt, java.lang.StringBuilder, java.lang.String, android.content.Context):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: a */
    public final void mo13120a() {
        this.f2779c = 0;
        this.f2780d = null;
    }

    /* renamed from: a */
    public final void mo13121a(Context context) {
        if (!this.f2786j) {
            try {
                m3223c();
                m3218a(context, (String) null);
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "Cache", "loadDB");
            }
            this.f2786j = true;
        }
    }

    /* renamed from: a */
    public final void mo13122a(AMapLocationClientOption aMapLocationClientOption) {
        this.f2783g = aMapLocationClientOption.mo8556e();
        this.f2782f = aMapLocationClientOption.mo8566o();
        this.f2778b = aMapLocationClientOption.mo8567p();
        this.f2784h = String.valueOf(aMapLocationClientOption.mo8571t());
    }

    /* renamed from: a */
    public final void mo13123a(Cgi bqVar) {
        this.f2781e = bqVar;
    }

    /* renamed from: a */
    public final void mo13124a(String str) {
        this.f2780d = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c A[Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13125a(java.lang.String r9, java.lang.StringBuilder r10, com.autonavi.aps.amapapi.model.AMapLocationServer r11, android.content.Context r12, boolean r13) {
        /*
            r8 = this;
            boolean r0 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r11)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01a8 }
            r0.<init>()     // Catch:{ Throwable -> 0x01a8 }
            r0.append(r9)     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r9 = "&"
            r0.append(r9)     // Catch:{ Throwable -> 0x01a8 }
            boolean r9 = r11.mo8527p()     // Catch:{ Throwable -> 0x01a8 }
            r0.append(r9)     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r9 = "&"
            r0.append(r9)     // Catch:{ Throwable -> 0x01a8 }
            boolean r9 = r11.mo8801H()     // Catch:{ Throwable -> 0x01a8 }
            r0.append(r9)     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r9 = "&"
            r0.append(r9)     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r9 = r11.mo8802I()     // Catch:{ Throwable -> 0x01a8 }
            r0.append(r9)     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r9 = r0.toString()     // Catch:{ Throwable -> 0x01a8 }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x01a8 }
            r1 = 0
            if (r0 != 0) goto L_0x0055
            boolean r0 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r11)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 != 0) goto L_0x0045
            goto L_0x0055
        L_0x0045:
            java.lang.String r0 = "#"
            boolean r0 = r9.startsWith(r0)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x004e
            goto L_0x0055
        L_0x004e:
            java.lang.String r0 = "network"
            boolean r0 = r9.contains(r0)     // Catch:{ Throwable -> 0x01a8 }
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 != 0) goto L_0x0059
            return
        L_0x0059:
            java.lang.String r0 = r11.mo8797D()     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r2 = "mem"
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0066
            return
        L_0x0066:
            java.lang.String r0 = r11.mo8797D()     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r2 = "file"
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0073
            return
        L_0x0073:
            java.lang.String r0 = r11.mo8797D()     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r2 = "wifioff"
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0080
            return
        L_0x0080:
            java.lang.String r0 = "-3"
            java.lang.String r2 = r11.mo8796C()     // Catch:{ Throwable -> 0x01a8 }
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x008d
            return
        L_0x008d:
            boolean r0 = r8.m3222b()     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0096
            r8.m3223c()     // Catch:{ Throwable -> 0x01a8 }
        L_0x0096:
            org.json.JSONObject r0 = r11.mo8798E()     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r2 = "offpct"
            boolean r2 = com.loc.C1079cp.m3512a((org.json.JSONObject) r0, (java.lang.String) r2)     // Catch:{ Throwable -> 0x01a8 }
            if (r2 == 0) goto L_0x00aa
            java.lang.String r2 = "offpct"
            r0.remove(r2)     // Catch:{ Throwable -> 0x01a8 }
            r11.mo8806a((org.json.JSONObject) r0)     // Catch:{ Throwable -> 0x01a8 }
        L_0x00aa:
            java.lang.String r0 = "wifi"
            boolean r0 = r9.contains(r0)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0120
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x00b9
            return
        L_0x00b9:
            float r0 = r11.getAccuracy()     // Catch:{ Throwable -> 0x01a8 }
            r2 = 1133903872(0x43960000, float:300.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x00e5
            java.lang.String r0 = r10.toString()     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r2 = "#"
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Throwable -> 0x01a8 }
            int r2 = r0.length     // Catch:{ Throwable -> 0x01a8 }
            r3 = 0
        L_0x00cf:
            if (r1 >= r2) goto L_0x00e0
            r4 = r0[r1]     // Catch:{ Throwable -> 0x01a8 }
            java.lang.String r5 = ","
            boolean r4 = r4.contains(r5)     // Catch:{ Throwable -> 0x01a8 }
            if (r4 == 0) goto L_0x00dd
            int r3 = r3 + 1
        L_0x00dd:
            int r1 = r1 + 1
            goto L_0x00cf
        L_0x00e0:
            r0 = 8
            if (r3 < r0) goto L_0x00f0
            return
        L_0x00e5:
            float r0 = r11.getAccuracy()     // Catch:{ Throwable -> 0x01a8 }
            r1 = 1077936128(0x40400000, float:3.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00f0
            return
        L_0x00f0:
            java.lang.String r0 = "cgiwifi"
            boolean r0 = r9.contains(r0)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0141
            java.lang.String r0 = r11.mo8799F()     // Catch:{ Throwable -> 0x01a8 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 != 0) goto L_0x0141
            java.lang.String r0 = "cgiwifi"
            java.lang.String r1 = "cgi"
            java.lang.String r3 = r9.replace(r0, r1)     // Catch:{ Throwable -> 0x01a8 }
            com.autonavi.aps.amapapi.model.AMapLocationServer r5 = r11.mo8800G()     // Catch:{ Throwable -> 0x01a8 }
            boolean r0 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r5)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0141
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01a8 }
            r4.<init>()     // Catch:{ Throwable -> 0x01a8 }
            r7 = 1
            r2 = r8
            r6 = r12
            r2.mo13125a(r3, r4, r5, r6, r7)     // Catch:{ Throwable -> 0x01a8 }
            goto L_0x0141
        L_0x0120:
            java.lang.String r0 = "cgi"
            boolean r0 = r9.contains(r0)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0141
            if (r10 == 0) goto L_0x0134
            java.lang.String r0 = ","
            int r0 = r10.indexOf(r0)     // Catch:{ Throwable -> 0x01a8 }
            r1 = -1
            if (r0 == r1) goto L_0x0134
            return
        L_0x0134:
            java.lang.String r0 = "4"
            java.lang.String r1 = r11.mo8796C()     // Catch:{ Throwable -> 0x01a8 }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x0141
            return
        L_0x0141:
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r8.m3215a((java.lang.String) r9, (java.lang.StringBuilder) r10)     // Catch:{ Throwable -> 0x01a8 }
            boolean r1 = com.loc.C1079cp.m3509a((com.autonavi.aps.amapapi.model.AMapLocationServer) r0)     // Catch:{ Throwable -> 0x01a8 }
            if (r1 == 0) goto L_0x015b
            java.lang.String r0 = r0.mo8539w()     // Catch:{ Throwable -> 0x01a8 }
            r1 = 3
            java.lang.String r1 = r11.mo8494e(r1)     // Catch:{ Throwable -> 0x01a8 }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x01a8 }
            if (r0 == 0) goto L_0x015b
            return
        L_0x015b:
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x01a8 }
            r8.f2785i = r0     // Catch:{ Throwable -> 0x01a8 }
            com.loc.bv$a r0 = new com.loc.bv$a     // Catch:{ Throwable -> 0x01a8 }
            r0.<init>()     // Catch:{ Throwable -> 0x01a8 }
            r0.mo13128a((com.autonavi.aps.amapapi.model.AMapLocationServer) r11)     // Catch:{ Throwable -> 0x01a8 }
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x01a8 }
            if (r1 == 0) goto L_0x0171
            r1 = 0
            goto L_0x0175
        L_0x0171:
            java.lang.String r1 = r10.toString()     // Catch:{ Throwable -> 0x01a8 }
        L_0x0175:
            r0.mo13129a((java.lang.String) r1)     // Catch:{ Throwable -> 0x01a8 }
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r1 = r8.f2777a     // Catch:{ Throwable -> 0x01a8 }
            boolean r1 = r1.containsKey(r9)     // Catch:{ Throwable -> 0x01a8 }
            if (r1 == 0) goto L_0x018c
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r1 = r8.f2777a     // Catch:{ Throwable -> 0x01a8 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ Throwable -> 0x01a8 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Throwable -> 0x01a8 }
            r1.add(r0)     // Catch:{ Throwable -> 0x01a8 }
            goto L_0x0199
        L_0x018c:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Throwable -> 0x01a8 }
            r1.<init>()     // Catch:{ Throwable -> 0x01a8 }
            r1.add(r0)     // Catch:{ Throwable -> 0x01a8 }
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.bv$a>> r0 = r8.f2777a     // Catch:{ Throwable -> 0x01a8 }
            r0.put(r9, r1)     // Catch:{ Throwable -> 0x01a8 }
        L_0x0199:
            if (r13 == 0) goto L_0x01a7
            r8.m3219a((java.lang.String) r9, (com.amap.api.location.AMapLocation) r11, (java.lang.StringBuilder) r10, (android.content.Context) r12)     // Catch:{ Throwable -> 0x019f }
            return
        L_0x019f:
            r9 = move-exception
            java.lang.String r10 = "Cache"
            java.lang.String r11 = "add"
            com.loc.CoreUtil.m3389a(r9, r10, r11)     // Catch:{ Throwable -> 0x01a8 }
        L_0x01a7:
            return
        L_0x01a8:
            r9 = move-exception
            java.lang.String r10 = "Cache"
            java.lang.String r11 = "add"
            com.loc.CoreUtil.m3389a(r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.mo13125a(java.lang.String, java.lang.StringBuilder, com.autonavi.aps.amapapi.model.AMapLocationServer, android.content.Context, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        if (r9.isOpen() != false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c A[SYNTHETIC, Splitter:B:38:0x007c] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13126b(android.content.Context r9) {
        /*
            r8 = this;
            r8.m3223c()     // Catch:{ Throwable -> 0x0099 }
            r0 = 0
            r1 = 0
            if (r9 == 0) goto L_0x0090
            java.lang.String r2 = "hmdb"
            android.database.sqlite.SQLiteDatabase r9 = r9.openOrCreateDatabase(r2, r0, r1)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            java.lang.String r2 = "hist"
            boolean r2 = com.loc.C1079cp.m3506a((android.database.sqlite.SQLiteDatabase) r9, (java.lang.String) r2)     // Catch:{ Throwable -> 0x006c }
            if (r2 != 0) goto L_0x0022
            if (r9 == 0) goto L_0x0090
            boolean r2 = r9.isOpen()     // Catch:{ Throwable -> 0x006c }
            if (r2 == 0) goto L_0x0090
            r9.close()     // Catch:{ Throwable -> 0x006c }
            goto L_0x0090
        L_0x0022:
            java.lang.String r2 = "time<?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Throwable -> 0x006c }
            long r4 = com.loc.C1079cp.m3518b()     // Catch:{ Throwable -> 0x006c }
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            long r4 = r4 - r6
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Throwable -> 0x006c }
            r3[r0] = r4     // Catch:{ Throwable -> 0x006c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0049 }
            java.lang.String r5 = "hist"
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0049 }
            java.lang.String r5 = r8.f2787k     // Catch:{ Throwable -> 0x0049 }
            r4.append(r5)     // Catch:{ Throwable -> 0x0049 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0049 }
            r9.delete(r4, r2, r3)     // Catch:{ Throwable -> 0x0049 }
            goto L_0x0060
        L_0x0049:
            r2 = move-exception
            java.lang.String r3 = "DB"
            java.lang.String r4 = "clearHist"
            com.loc.CoreUtil.m3389a(r2, r3, r4)     // Catch:{ Throwable -> 0x006c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Throwable -> 0x006c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x006c }
            if (r3 != 0) goto L_0x0060
            java.lang.String r3 = "no such table"
            r2.contains(r3)     // Catch:{ Throwable -> 0x006c }
        L_0x0060:
            if (r9 == 0) goto L_0x0090
            boolean r2 = r9.isOpen()     // Catch:{ Throwable -> 0x0099 }
            if (r2 == 0) goto L_0x0090
        L_0x0068:
            r9.close()     // Catch:{ Throwable -> 0x0099 }
            goto L_0x0090
        L_0x006c:
            r2 = move-exception
            goto L_0x0073
        L_0x006e:
            r0 = move-exception
            r9 = r1
            goto L_0x0084
        L_0x0071:
            r2 = move-exception
            r9 = r1
        L_0x0073:
            java.lang.String r3 = "DB"
            java.lang.String r4 = "clearHist p2"
            com.loc.CoreUtil.m3389a(r2, r3, r4)     // Catch:{ all -> 0x0083 }
            if (r9 == 0) goto L_0x0090
            boolean r2 = r9.isOpen()     // Catch:{ Throwable -> 0x0099 }
            if (r2 == 0) goto L_0x0090
            goto L_0x0068
        L_0x0083:
            r0 = move-exception
        L_0x0084:
            if (r9 == 0) goto L_0x008f
            boolean r1 = r9.isOpen()     // Catch:{ Throwable -> 0x0099 }
            if (r1 == 0) goto L_0x008f
            r9.close()     // Catch:{ Throwable -> 0x0099 }
        L_0x008f:
            throw r0     // Catch:{ Throwable -> 0x0099 }
        L_0x0090:
            r8.f2786j = r0     // Catch:{ Throwable -> 0x0099 }
            r8.f2780d = r1     // Catch:{ Throwable -> 0x0099 }
            r0 = 0
            r8.f2790n = r0     // Catch:{ Throwable -> 0x0099 }
            return
        L_0x0099:
            r9 = move-exception
            java.lang.String r0 = "Cache"
            java.lang.String r1 = "destroy part"
            com.loc.CoreUtil.m3389a(r9, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C1066bv.mo13126b(android.content.Context):void");
    }
}
