package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* renamed from: com.loc.br */
public final class CgiManager {

    /* renamed from: a */
    int f2722a = 0;

    /* renamed from: b */
    ArrayList<Cgi> f2723b = new ArrayList<>();

    /* renamed from: c */
    TelephonyManager f2724c = null;

    /* renamed from: d */
    long f2725d = 0;

    /* renamed from: e */
    CellLocation f2726e;

    /* renamed from: f */
    boolean f2727f = false;

    /* renamed from: g */
    PhoneStateListener f2728g = null;

    /* renamed from: h */
    String f2729h = null;

    /* renamed from: i */
    boolean f2730i = false;

    /* renamed from: j */
    StringBuilder f2731j = null;

    /* renamed from: k */
    HandlerThread f2732k = null;

    /* renamed from: l */
    private Context f2733l;

    /* renamed from: m */
    private String f2734m = null;

    /* renamed from: n */
    private ArrayList<Cgi> f2735n = new ArrayList<>();

    /* renamed from: o */
    private int f2736o = -113;

    /* renamed from: p */
    private CellAgeEstimator f2737p = null;

    /* renamed from: q */
    private Object f2738q;

    /* renamed from: r */
    private int f2739r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f2740s = 0;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f2741t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Object f2742u = new Object();

    /* renamed from: com.loc.br$a */
    /* compiled from: CgiManager */
    class C1065a extends HandlerThread {
        public C1065a(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|(6:6|(1:8)(1:11)|9|10|14|(2:16|17)(1:18))|19|20) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onLooperPrepared() {
            /*
                r6 = this;
                super.onLooperPrepared()     // Catch:{ Throwable -> 0x0049 }
                com.loc.br r0 = com.loc.CgiManager.this     // Catch:{ Throwable -> 0x0049 }
                java.lang.Object r0 = r0.f2742u     // Catch:{ Throwable -> 0x0049 }
                monitor-enter(r0)     // Catch:{ Throwable -> 0x0049 }
                com.loc.br r1 = com.loc.CgiManager.this     // Catch:{ all -> 0x0046 }
                boolean r1 = r1.f2741t     // Catch:{ all -> 0x0046 }
                if (r1 != 0) goto L_0x0044
                com.loc.br r1 = com.loc.CgiManager.this     // Catch:{ all -> 0x0046 }
                com.loc.br$1 r2 = new com.loc.br$1     // Catch:{ all -> 0x0046 }
                r2.<init>()     // Catch:{ all -> 0x0046 }
                r1.f2728g = r2     // Catch:{ all -> 0x0046 }
                java.lang.String r2 = "android.telephony.PhoneStateListener"
                r3 = 0
                int r4 = com.loc.C1079cp.m3535d()     // Catch:{ all -> 0x0046 }
                r5 = 7
                if (r4 >= r5) goto L_0x002c
                java.lang.String r4 = "LISTEN_SIGNAL_STRENGTH"
            L_0x0027:
                int r2 = com.loc.Reflect.m3417b(r2, r4)     // Catch:{ Throwable -> 0x002f }
                goto L_0x0030
            L_0x002c:
                java.lang.String r4 = "LISTEN_SIGNAL_STRENGTHS"
                goto L_0x0027
            L_0x002f:
                r2 = 0
            L_0x0030:
                r3 = 16
                if (r2 != 0) goto L_0x003c
                android.telephony.TelephonyManager r2 = r1.f2724c     // Catch:{ Throwable -> 0x0044 }
                android.telephony.PhoneStateListener r1 = r1.f2728g     // Catch:{ Throwable -> 0x0044 }
                r2.listen(r1, r3)     // Catch:{ Throwable -> 0x0044 }
                goto L_0x0044
            L_0x003c:
                android.telephony.TelephonyManager r4 = r1.f2724c     // Catch:{ Throwable -> 0x0044 }
                android.telephony.PhoneStateListener r1 = r1.f2728g     // Catch:{ Throwable -> 0x0044 }
                r2 = r2 | r3
                r4.listen(r1, r2)     // Catch:{ Throwable -> 0x0044 }
            L_0x0044:
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return
            L_0x0046:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ Throwable -> 0x0049 }
                throw r1     // Catch:{ Throwable -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.CgiManager.C1065a.onLooperPrepared():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r3.f2744a.f2724c.listen(r3.f2744a.f2728g, 0);
            r3.f2744a.f2728g = null;
            quit();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0004 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
                super.run()     // Catch:{ Throwable -> 0x0004 }
                return
            L_0x0004:
                com.loc.br r0 = com.loc.CgiManager.this     // Catch:{ Throwable -> 0x0018 }
                android.telephony.TelephonyManager r0 = r0.f2724c     // Catch:{ Throwable -> 0x0018 }
                com.loc.br r1 = com.loc.CgiManager.this     // Catch:{ Throwable -> 0x0018 }
                android.telephony.PhoneStateListener r1 = r1.f2728g     // Catch:{ Throwable -> 0x0018 }
                r2 = 0
                r0.listen(r1, r2)     // Catch:{ Throwable -> 0x0018 }
                com.loc.br r0 = com.loc.CgiManager.this     // Catch:{ Throwable -> 0x0018 }
                r1 = 0
                r0.f2728g = r1     // Catch:{ Throwable -> 0x0018 }
                r3.quit()     // Catch:{ Throwable -> 0x0018 }
            L_0x0018:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.CgiManager.C1065a.run():void");
        }
    }

    public CgiManager(Context context) {
        Context context2;
        String str;
        this.f2733l = context;
        if (this.f2724c == null) {
            this.f2724c = (TelephonyManager) C1079cp.m3501a(this.f2733l, "phone");
        }
        if (this.f2724c != null) {
            try {
                CellLocation cellLocation = this.f2724c.getCellLocation();
                Context context3 = this.f2733l;
                this.f2722a = m3148c(cellLocation);
            } catch (SecurityException e) {
                this.f2729h = e.getMessage();
            } catch (Throwable th) {
                this.f2729h = null;
                CoreUtil.m3389a(th, "CgiManager", "CgiManager");
                this.f2722a = 0;
            }
            try {
                this.f2739r = m3153r();
                switch (this.f2739r) {
                    case 1:
                        context2 = this.f2733l;
                        str = "phone_msim";
                        break;
                    case 2:
                        context2 = this.f2733l;
                        str = "phone2";
                        break;
                    default:
                        context2 = this.f2733l;
                        str = "phone2";
                        break;
                }
                this.f2738q = C1079cp.m3501a(context2, str);
            } catch (Throwable unused) {
            }
            if (this.f2732k == null) {
                this.f2732k = new C1065a("listenerPhoneStateThread");
                this.f2732k.start();
            }
        }
        this.f2737p = new CellAgeEstimator();
    }

    /* renamed from: a */
    private CellLocation m3128a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a = Reflect.m3412a(obj, str, objArr);
            CellLocation cellLocation = a != null ? (CellLocation) a : null;
            if (m3146b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0079, code lost:
        r2 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab A[RETURN] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.telephony.CellLocation m3129a(java.util.List<android.telephony.CellInfo> r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x00ac
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x00ac
        L_0x000b:
            r1 = 0
        L_0x000c:
            int r2 = r11.size()
            if (r1 >= r2) goto L_0x0079
            java.lang.Object r2 = r11.get(r1)
            android.telephony.CellInfo r2 = (android.telephony.CellInfo) r2
            if (r2 == 0) goto L_0x0076
            boolean r3 = r2.isRegistered()     // Catch:{ Throwable -> 0x0076 }
            boolean r4 = r2 instanceof android.telephony.CellInfoCdma     // Catch:{ Throwable -> 0x0076 }
            if (r4 == 0) goto L_0x0034
            android.telephony.CellInfoCdma r2 = (android.telephony.CellInfoCdma) r2     // Catch:{ Throwable -> 0x0076 }
            android.telephony.CellIdentityCdma r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0076 }
            boolean r4 = m3141a((android.telephony.CellIdentityCdma) r4)     // Catch:{ Throwable -> 0x0076 }
            if (r4 != 0) goto L_0x002f
            goto L_0x0076
        L_0x002f:
            com.loc.bq r2 = r10.m3131a((android.telephony.CellInfoCdma) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0076 }
            goto L_0x007a
        L_0x0034:
            boolean r4 = r2 instanceof android.telephony.CellInfoGsm     // Catch:{ Throwable -> 0x0076 }
            if (r4 == 0) goto L_0x004a
            android.telephony.CellInfoGsm r2 = (android.telephony.CellInfoGsm) r2     // Catch:{ Throwable -> 0x0076 }
            android.telephony.CellIdentityGsm r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0076 }
            boolean r4 = m3142a((android.telephony.CellIdentityGsm) r4)     // Catch:{ Throwable -> 0x0076 }
            if (r4 != 0) goto L_0x0045
            goto L_0x0076
        L_0x0045:
            com.loc.bq r2 = m3132a((android.telephony.CellInfoGsm) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0076 }
            goto L_0x007a
        L_0x004a:
            boolean r4 = r2 instanceof android.telephony.CellInfoWcdma     // Catch:{ Throwable -> 0x0076 }
            if (r4 == 0) goto L_0x0060
            android.telephony.CellInfoWcdma r2 = (android.telephony.CellInfoWcdma) r2     // Catch:{ Throwable -> 0x0076 }
            android.telephony.CellIdentityWcdma r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0076 }
            boolean r4 = m3144a((android.telephony.CellIdentityWcdma) r4)     // Catch:{ Throwable -> 0x0076 }
            if (r4 != 0) goto L_0x005b
            goto L_0x0076
        L_0x005b:
            com.loc.bq r2 = m3134a((android.telephony.CellInfoWcdma) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0076 }
            goto L_0x007a
        L_0x0060:
            boolean r4 = r2 instanceof android.telephony.CellInfoLte     // Catch:{ Throwable -> 0x0076 }
            if (r4 == 0) goto L_0x0079
            android.telephony.CellInfoLte r2 = (android.telephony.CellInfoLte) r2     // Catch:{ Throwable -> 0x0076 }
            android.telephony.CellIdentityLte r4 = r2.getCellIdentity()     // Catch:{ Throwable -> 0x0076 }
            boolean r4 = m3143a((android.telephony.CellIdentityLte) r4)     // Catch:{ Throwable -> 0x0076 }
            if (r4 != 0) goto L_0x0071
            goto L_0x0076
        L_0x0071:
            com.loc.bq r2 = m3133a((android.telephony.CellInfoLte) r2, (boolean) r3)     // Catch:{ Throwable -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0079:
            r2 = r0
        L_0x007a:
            if (r2 == 0) goto L_0x00a4
            int r11 = r2.f2716k     // Catch:{ Throwable -> 0x00a2 }
            r1 = 2
            if (r11 != r1) goto L_0x0095
            android.telephony.cdma.CdmaCellLocation r11 = new android.telephony.cdma.CdmaCellLocation     // Catch:{ Throwable -> 0x00a2 }
            r11.<init>()     // Catch:{ Throwable -> 0x00a2 }
            int r4 = r2.f2714i     // Catch:{ Throwable -> 0x00a8 }
            int r5 = r2.f2710e     // Catch:{ Throwable -> 0x00a8 }
            int r6 = r2.f2711f     // Catch:{ Throwable -> 0x00a8 }
            int r7 = r2.f2712g     // Catch:{ Throwable -> 0x00a8 }
            int r8 = r2.f2713h     // Catch:{ Throwable -> 0x00a8 }
            r3 = r11
            r3.setCellLocationData(r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x00a8 }
            goto L_0x00a8
        L_0x0095:
            android.telephony.gsm.GsmCellLocation r11 = new android.telephony.gsm.GsmCellLocation     // Catch:{ Throwable -> 0x00a2 }
            r11.<init>()     // Catch:{ Throwable -> 0x00a2 }
            int r1 = r2.f2708c     // Catch:{ Throwable -> 0x00a5 }
            int r2 = r2.f2709d     // Catch:{ Throwable -> 0x00a5 }
            r11.setLacAndCid(r1, r2)     // Catch:{ Throwable -> 0x00a5 }
            goto L_0x00a5
        L_0x00a2:
            r11 = r0
            goto L_0x00a8
        L_0x00a4:
            r11 = r0
        L_0x00a5:
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x00a8:
            if (r11 != 0) goto L_0x00ab
            return r0
        L_0x00ab:
            return r11
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.CgiManager.m3129a(java.util.List):android.telephony.CellLocation");
    }

    /* renamed from: a */
    private static Cgi m3130a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        Cgi bqVar = new Cgi(i, z);
        bqVar.f2706a = i2;
        bqVar.f2707b = i3;
        bqVar.f2708c = i4;
        bqVar.f2709d = i5;
        bqVar.f2715j = i6;
        return bqVar;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private Cgi m3131a(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] a = C1079cp.m3516a(this.f2724c);
        try {
            i3 = Integer.parseInt(a[0]);
            try {
                i = Integer.parseInt(a[1]);
                i2 = i3;
            } catch (Throwable unused) {
                i2 = i3;
                i = 0;
                Cgi a2 = m3130a(2, z, i2, i, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a2.f2712g = cellIdentity.getSystemId();
                a2.f2713h = cellIdentity.getNetworkId();
                a2.f2714i = cellIdentity.getBasestationId();
                a2.f2710e = cellIdentity.getLatitude();
                a2.f2711f = cellIdentity.getLongitude();
                return a2;
            }
        } catch (Throwable unused2) {
            i3 = 0;
            i2 = i3;
            i = 0;
            Cgi a22 = m3130a(2, z, i2, i, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            a22.f2712g = cellIdentity.getSystemId();
            a22.f2713h = cellIdentity.getNetworkId();
            a22.f2714i = cellIdentity.getBasestationId();
            a22.f2710e = cellIdentity.getLatitude();
            a22.f2711f = cellIdentity.getLongitude();
            return a22;
        }
        Cgi a222 = m3130a(2, z, i2, i, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        a222.f2712g = cellIdentity.getSystemId();
        a222.f2713h = cellIdentity.getNetworkId();
        a222.f2714i = cellIdentity.getBasestationId();
        a222.f2710e = cellIdentity.getLatitude();
        a222.f2711f = cellIdentity.getLongitude();
        return a222;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static Cgi m3132a(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return m3130a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static Cgi m3133a(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        Cgi a = m3130a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        a.f2720o = cellIdentity.getPci();
        return a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static Cgi m3134a(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        Cgi a = m3130a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        a.f2720o = cellIdentity.getPsc();
        return a;
    }

    /* renamed from: a */
    private static Cgi m3135a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            Cgi bqVar = new Cgi(1, false);
            bqVar.f2706a = Integer.parseInt(strArr[0]);
            bqVar.f2707b = Integer.parseInt(strArr[1]);
            bqVar.f2708c = Reflect.m3416b(neighboringCellInfo, "getLac", new Object[0]);
            bqVar.f2709d = neighboringCellInfo.getCid();
            bqVar.f2715j = C1079cp.m3499a(neighboringCellInfo.getRssi());
            return bqVar;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3137a(android.telephony.CellLocation r7, java.lang.String[] r8, boolean r9) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0098
            android.telephony.TelephonyManager r0 = r6.f2724c
            if (r0 != 0) goto L_0x0008
            goto L_0x0098
        L_0x0008:
            java.util.ArrayList<com.loc.bq> r0 = r6.f2723b
            r0.clear()
            boolean r0 = r6.m3146b((android.telephony.CellLocation) r7)
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            r0 = 1
            r6.f2722a = r0
            r1 = 0
            java.util.ArrayList<com.loc.bq> r2 = r6.f2723b
            android.telephony.gsm.GsmCellLocation r7 = (android.telephony.gsm.GsmCellLocation) r7
            com.loc.bq r3 = new com.loc.bq
            r3.<init>(r0, r0)
            r4 = 0
            r5 = r8[r4]
            int r5 = com.loc.C1079cp.m3548h((java.lang.String) r5)
            r3.f2706a = r5
            r0 = r8[r0]
            int r0 = com.loc.C1079cp.m3548h((java.lang.String) r0)
            r3.f2707b = r0
            int r0 = r7.getLac()
            r3.f2708c = r0
            int r7 = r7.getCid()
            r3.f2709d = r7
            int r7 = r6.f2736o
            r3.f2715j = r7
            r2.add(r3)
            if (r9 == 0) goto L_0x0048
            return
        L_0x0048:
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 28
            if (r7 > r9) goto L_0x005b
            android.telephony.TelephonyManager r7 = r6.f2724c
            java.lang.String r9 = "getNeighboringCellInfo"
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.Object r7 = com.loc.Reflect.m3412a((java.lang.Object) r7, (java.lang.String) r9, (java.lang.Object[]) r0)
            r1 = r7
            java.util.List r1 = (java.util.List) r1
        L_0x005b:
            if (r1 == 0) goto L_0x0098
            boolean r7 = r1.isEmpty()
            if (r7 == 0) goto L_0x0064
            goto L_0x0098
        L_0x0064:
            java.util.Iterator r7 = r1.iterator()
        L_0x0068:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0098
            java.lang.Object r9 = r7.next()
            android.telephony.NeighboringCellInfo r9 = (android.telephony.NeighboringCellInfo) r9
            if (r9 == 0) goto L_0x0068
            int r0 = r9.getLac()
            int r1 = r9.getCid()
            boolean r0 = m3140a((int) r0, (int) r1)
            if (r0 == 0) goto L_0x0068
            com.loc.bq r9 = m3135a((android.telephony.NeighboringCellInfo) r9, (java.lang.String[]) r8)
            if (r9 == 0) goto L_0x0068
            java.util.ArrayList<com.loc.bq> r0 = r6.f2723b
            boolean r0 = r0.contains(r9)
            if (r0 != 0) goto L_0x0068
            java.util.ArrayList<com.loc.bq> r0 = r6.f2723b
            r0.add(r9)
            goto L_0x0068
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.CgiManager.m3137a(android.telephony.CellLocation, java.lang.String[], boolean):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m3138a(CgiManager brVar, int i) {
        if (i == -113) {
            brVar.f2736o = -113;
            return;
        }
        brVar.f2736o = i;
        switch (brVar.f2722a) {
            case 1:
            case 2:
                if (brVar.f2723b != null && !brVar.f2723b.isEmpty()) {
                    try {
                        brVar.f2723b.get(0).f2715j = brVar.f2736o;
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: a */
    private static boolean m3139a(int i) {
        return (i == -1 || i == 0 || i > 65535) ? false : true;
    }

    /* renamed from: a */
    private static boolean m3140a(int i, int i2) {
        return (i == -1 || i == 0 || i > 65535 || i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static boolean m3141a(CellIdentityCdma cellIdentityCdma) {
        return cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static boolean m3142a(CellIdentityGsm cellIdentityGsm) {
        return cellIdentityGsm != null && m3139a(cellIdentityGsm.getLac()) && m3145b(cellIdentityGsm.getCid());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static boolean m3143a(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && m3139a(cellIdentityLte.getTac()) && m3145b(cellIdentityLte.getCi());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static boolean m3144a(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && m3139a(cellIdentityWcdma.getLac()) && m3145b(cellIdentityWcdma.getCid());
    }

    /* renamed from: b */
    private static boolean m3145b(int i) {
        return (i == -1 || i == 0 || i == 65535 || i >= 268435455) ? false : true;
    }

    /* renamed from: b */
    private boolean m3146b(CellLocation cellLocation) {
        boolean a = mo13079a(cellLocation);
        if (!a) {
            this.f2722a = 0;
        }
        return a;
    }

    /* renamed from: c */
    private int m3148c(CellLocation cellLocation) {
        if (this.f2730i || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    /* renamed from: n */
    private CellLocation m3149n() {
        if (this.f2724c != null) {
            try {
                CellLocation cellLocation = this.f2724c.getCellLocation();
                this.f2729h = null;
                if (m3146b(cellLocation)) {
                    this.f2726e = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e) {
                this.f2729h = e.getMessage();
            } catch (Throwable th) {
                this.f2729h = null;
                CoreUtil.m3389a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: o */
    private CellLocation m3150o() {
        TelephonyManager telephonyManager = this.f2724c;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation n = m3149n();
        if (m3146b(n)) {
            return n;
        }
        if (C1079cp.m3535d() >= 18) {
            try {
                cellLocation = m3129a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e) {
                this.f2729h = e.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation a = m3128a((Object) telephonyManager, "getCellLocationExt", 1);
        if (a != null) {
            return a;
        }
        CellLocation a2 = m3128a((Object) telephonyManager, "getCellLocationGemini", 1);
        if (a2 != null) {
        }
        return a2;
    }

    /* renamed from: p */
    private CellLocation m3151p() {
        Object obj = this.f2738q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> q = m3152q();
            if (q.isInstance(obj)) {
                Object cast = q.cast(obj);
                CellLocation a = m3128a((Object) cast, "getCellLocation", new Object[0]);
                if (a != null) {
                    return a;
                }
                try {
                    CellLocation a2 = m3128a((Object) cast, "getCellLocation", 1);
                    if (a2 != null) {
                        return a2;
                    }
                    try {
                        a = m3128a((Object) cast, "getCellLocationGemini", 1);
                        if (a != null) {
                            return a;
                        }
                        cellLocation = m3128a((Object) cast, "getAllCellInfo", 1);
                        if (cellLocation != null) {
                            return cellLocation;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cellLocation = a2;
                        CoreUtil.m3389a(th, "CgiManager", "getSim2Cgi");
                        return cellLocation;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cellLocation = a;
                    CoreUtil.m3389a(th, "CgiManager", "getSim2Cgi");
                    return cellLocation;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            CoreUtil.m3389a(th, "CgiManager", "getSim2Cgi");
            return cellLocation;
        }
        return cellLocation;
    }

    /* renamed from: q */
    private Class<?> m3152q() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (this.f2739r) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* renamed from: r */
    private int m3153r() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.f2739r = 1;
        } catch (Throwable unused) {
        }
        if (this.f2739r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.f2739r = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.f2739r;
    }

    /* renamed from: a */
    public final ArrayList<Cgi> mo13077a() {
        return this.f2723b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02ae, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02af, code lost:
        r9.f2729h = r10.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02b5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e1, code lost:
        if (r10 == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x016e, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        com.loc.CoreUtil.m3389a(r10, "CgiManager", "hdlCdmaLocChange");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x025f */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x025f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0263 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0283 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0287 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02ae A[ExcHandler: SecurityException (r10v1 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0089 A[EDGE_INSN: B:177:0x0089->B:40:0x0089 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13078a(boolean r10, boolean r11) {
        /*
            r9 = this;
            android.content.Context r0 = r9.f2733l     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r0 = com.loc.C1079cp.m3505a((android.content.Context) r0)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r9.f2730i = r0     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r0 = r9.f2730i     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0020
        L_0x0010:
            long r3 = com.loc.C1079cp.m3529c()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            long r5 = r9.f2725d     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r0 = 0
            long r3 = r3 - r5
            r5 = 10000(0x2710, double:4.9407E-320)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x001f
            goto L_0x000e
        L_0x001f:
            r0 = 1
        L_0x0020:
            if (r0 != 0) goto L_0x002a
            java.util.ArrayList<com.loc.bq> r0 = r9.f2723b     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r0 = r0.isEmpty()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r0 == 0) goto L_0x027f
        L_0x002a:
            boolean r0 = r9.f2730i     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r3 = 0
            if (r0 != 0) goto L_0x006b
            android.telephony.TelephonyManager r0 = r9.f2724c     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r0 == 0) goto L_0x006b
            android.telephony.CellLocation r0 = r9.m3150o()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r4 = r9.m3146b((android.telephony.CellLocation) r0)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r4 != 0) goto L_0x0041
            android.telephony.CellLocation r0 = r9.m3151p()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x0041:
            boolean r4 = r9.m3146b((android.telephony.CellLocation) r0)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r4 == 0) goto L_0x0050
            r9.f2726e = r0     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            long r4 = com.loc.C1079cp.m3529c()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r9.f2740s = r4     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            goto L_0x006b
        L_0x0050:
            long r4 = com.loc.C1079cp.m3529c()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            long r6 = r9.f2740s     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r0 = 0
            long r4 = r4 - r6
            r6 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x006b
            r9.f2726e = r3     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            java.util.ArrayList<com.loc.bq> r0 = r9.f2723b     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r0.clear()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            java.util.ArrayList<com.loc.bq> r0 = r9.f2735n     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r0.clear()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x006b:
            boolean r0 = r9.f2727f     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r0 != 0) goto L_0x0089
            android.telephony.CellLocation r0 = r9.f2726e     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r0 != 0) goto L_0x0089
            if (r11 == 0) goto L_0x0089
            r11 = 0
        L_0x0076:
            r4 = 10
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x0080:
            int r11 = r11 + r1
            android.telephony.CellLocation r0 = r9.f2726e     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r0 != 0) goto L_0x0089
            r0 = 50
            if (r11 < r0) goto L_0x0076
        L_0x0089:
            r9.f2727f = r1     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            android.telephony.CellLocation r11 = r9.f2726e     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r11 = r9.m3146b((android.telephony.CellLocation) r11)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r11 == 0) goto L_0x017c
            android.telephony.TelephonyManager r11 = r9.f2724c     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            java.lang.String[] r11 = com.loc.C1079cp.m3516a((android.telephony.TelephonyManager) r11)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            android.telephony.CellLocation r0 = r9.f2726e     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            android.content.Context r4 = r9.f2733l     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            int r0 = r9.m3148c(r0)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            switch(r0) {
                case 1: goto L_0x0177;
                case 2: goto L_0x00a6;
                default: goto L_0x00a4;
            }     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x00a4:
            goto L_0x017c
        L_0x00a6:
            android.telephony.CellLocation r0 = r9.f2726e     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r0 == 0) goto L_0x017c
            java.util.ArrayList<com.loc.bq> r4 = r9.f2723b     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r4.clear()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            int r4 = com.loc.C1079cp.m3535d()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r5 = 5
            if (r4 < r5) goto L_0x017c
            java.lang.Object r4 = r9.f2738q     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r4 == 0) goto L_0x00e5
            java.lang.Class r4 = r0.getClass()     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
            java.lang.String r5 = "mGsmCellLoc"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
            boolean r5 = r4.isAccessible()     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
            if (r5 != 0) goto L_0x00cd
            r4.setAccessible(r1)     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        L_0x00cd:
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
            android.telephony.gsm.GsmCellLocation r4 = (android.telephony.gsm.GsmCellLocation) r4     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
            if (r4 == 0) goto L_0x00e0
            boolean r5 = r9.m3146b((android.telephony.CellLocation) r4)     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
            if (r5 == 0) goto L_0x00e0
            r9.m3137a((android.telephony.CellLocation) r4, (java.lang.String[]) r11, (boolean) r10)     // Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
            r10 = 1
            goto L_0x00e1
        L_0x00e0:
            r10 = 0
        L_0x00e1:
            if (r10 == 0) goto L_0x00e5
            goto L_0x017c
        L_0x00e5:
            boolean r10 = r9.m3146b((android.telephony.CellLocation) r0)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r10 != 0) goto L_0x00ed
            goto L_0x017c
        L_0x00ed:
            r10 = 2
            r9.f2722a = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            com.loc.bq r4 = new com.loc.bq     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.<init>(r10, r1)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r10 = r11[r2]     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2706a = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r10 = r11[r1]     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2707b = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            java.lang.String r10 = "getSystemId"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = com.loc.Reflect.m3416b(r0, r10, r11)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2712g = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            java.lang.String r10 = "getNetworkId"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = com.loc.Reflect.m3416b(r0, r10, r11)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2713h = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            java.lang.String r10 = "getBaseStationId"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = com.loc.Reflect.m3416b(r0, r10, r11)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2714i = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = r9.f2736o     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2715j = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            java.lang.String r10 = "getBaseStationLatitude"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = com.loc.Reflect.m3416b(r0, r10, r11)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2710e = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            java.lang.String r10 = "getBaseStationLongitude"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = com.loc.Reflect.m3416b(r0, r10, r11)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2711f = r10     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r10 = r4.f2710e     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            int r11 = r4.f2711f     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r10 != r11) goto L_0x0146
            int r10 = r4.f2710e     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r10 <= 0) goto L_0x0146
            goto L_0x0147
        L_0x0146:
            r1 = 0
        L_0x0147:
            int r10 = r4.f2710e     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r10 < 0) goto L_0x015c
            int r10 = r4.f2711f     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r10 < 0) goto L_0x015c
            int r10 = r4.f2710e     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == r11) goto L_0x015c
            int r10 = r4.f2711f     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r10 == r11) goto L_0x015c
            if (r1 == 0) goto L_0x0160
        L_0x015c:
            r4.f2710e = r2     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r4.f2711f = r2     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        L_0x0160:
            java.util.ArrayList<com.loc.bq> r10 = r9.f2723b     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            boolean r10 = r10.contains(r4)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            if (r10 != 0) goto L_0x017c
            java.util.ArrayList<com.loc.bq> r10 = r9.f2723b     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            r10.add(r4)     // Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
            goto L_0x017c
        L_0x016e:
            r10 = move-exception
            java.lang.String r11 = "CgiManager"
            java.lang.String r0 = "hdlCdmaLocChange"
            com.loc.CoreUtil.m3389a(r10, r11, r0)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            goto L_0x017c
        L_0x0177:
            android.telephony.CellLocation r0 = r9.f2726e     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r9.m3137a((android.telephony.CellLocation) r0, (java.lang.String[]) r11, (boolean) r10)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x017c:
            int r10 = com.loc.C1079cp.m3535d()     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            r11 = 18
            if (r10 < r11) goto L_0x025f
            android.telephony.TelephonyManager r10 = r9.f2724c     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            if (r10 == 0) goto L_0x025f
            java.util.ArrayList<com.loc.bq> r10 = r9.f2735n     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            com.loc.bp r11 = r9.f2737p     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            android.telephony.TelephonyManager r0 = r9.f2724c     // Catch:{ SecurityException -> 0x0197, Throwable -> 0x025f }
            java.util.List r0 = r0.getAllCellInfo()     // Catch:{ SecurityException -> 0x0197, Throwable -> 0x025f }
            r9.f2729h = r3     // Catch:{ SecurityException -> 0x0195, Throwable -> 0x025f }
            goto L_0x019f
        L_0x0195:
            r1 = move-exception
            goto L_0x0199
        L_0x0197:
            r1 = move-exception
            r0 = r3
        L_0x0199:
            java.lang.String r1 = r1.getMessage()     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            r9.f2729h = r1     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        L_0x019f:
            if (r0 == 0) goto L_0x024e
            int r1 = r0.size()     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            if (r1 == 0) goto L_0x024e
            if (r10 == 0) goto L_0x01ac
            r10.clear()     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        L_0x01ac:
            r3 = 0
        L_0x01ad:
            if (r3 >= r1) goto L_0x024e
            java.lang.Object r4 = r0.get(r3)     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            android.telephony.CellInfo r4 = (android.telephony.CellInfo) r4     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            if (r4 == 0) goto L_0x024a
            boolean r5 = r4.isRegistered()     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            boolean r6 = r4 instanceof android.telephony.CellInfoCdma     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            r7 = 65535(0xffff, double:3.23786E-319)
            if (r6 == 0) goto L_0x01e4
            android.telephony.CellInfoCdma r4 = (android.telephony.CellInfoCdma) r4     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            android.telephony.CellIdentityCdma r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            boolean r6 = m3141a((android.telephony.CellIdentityCdma) r6)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            if (r6 != 0) goto L_0x01d0
            goto L_0x024a
        L_0x01d0:
            com.loc.bq r4 = r9.m3131a((android.telephony.CellInfoCdma) r4, (boolean) r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = r11.mo13070a((com.loc.Cgi) r4)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            r4.f2717l = r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        L_0x01e0:
            r10.add(r4)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            goto L_0x024a
        L_0x01e4:
            boolean r6 = r4 instanceof android.telephony.CellInfoGsm     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            if (r6 == 0) goto L_0x0206
            android.telephony.CellInfoGsm r4 = (android.telephony.CellInfoGsm) r4     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            android.telephony.CellIdentityGsm r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            boolean r6 = m3142a((android.telephony.CellIdentityGsm) r6)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            if (r6 != 0) goto L_0x01f5
            goto L_0x024a
        L_0x01f5:
            com.loc.bq r4 = m3132a((android.telephony.CellInfoGsm) r4, (boolean) r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = r11.mo13070a((com.loc.Cgi) r4)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            r4.f2717l = r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            goto L_0x01e0
        L_0x0206:
            boolean r6 = r4 instanceof android.telephony.CellInfoWcdma     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            if (r6 == 0) goto L_0x0228
            android.telephony.CellInfoWcdma r4 = (android.telephony.CellInfoWcdma) r4     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            android.telephony.CellIdentityWcdma r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            boolean r6 = m3144a((android.telephony.CellIdentityWcdma) r6)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            if (r6 != 0) goto L_0x0217
            goto L_0x024a
        L_0x0217:
            com.loc.bq r4 = m3134a((android.telephony.CellInfoWcdma) r4, (boolean) r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = r11.mo13070a((com.loc.Cgi) r4)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            r4.f2717l = r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            goto L_0x01e0
        L_0x0228:
            boolean r6 = r4 instanceof android.telephony.CellInfoLte     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            if (r6 == 0) goto L_0x024a
            android.telephony.CellInfoLte r4 = (android.telephony.CellInfoLte) r4     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            android.telephony.CellIdentityLte r6 = r4.getCellIdentity()     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            boolean r6 = m3143a((android.telephony.CellIdentityLte) r6)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            if (r6 != 0) goto L_0x0239
            goto L_0x024a
        L_0x0239:
            com.loc.bq r4 = m3133a((android.telephony.CellInfoLte) r4, (boolean) r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = r11.mo13070a((com.loc.Cgi) r4)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            long r5 = java.lang.Math.min(r7, r5)     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            int r5 = (int) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            short r5 = (short) r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            r4.f2717l = r5     // Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
            goto L_0x01e0
        L_0x024a:
            int r3 = r3 + 1
            goto L_0x01ad
        L_0x024e:
            if (r10 == 0) goto L_0x025f
            int r0 = r10.size()     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            if (r0 <= 0) goto L_0x025f
            int r0 = r9.f2722a     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            r0 = r0 | 4
            r9.f2722a = r0     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
            r11.mo13072a((java.util.ArrayList<? extends com.loc.Cgi>) r10)     // Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        L_0x025f:
            android.telephony.TelephonyManager r10 = r9.f2724c     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r10 == 0) goto L_0x0279
            android.telephony.TelephonyManager r10 = r9.f2724c     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            java.lang.String r10 = r10.getNetworkOperator()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r9.f2734m = r10     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            java.lang.String r10 = r9.f2734m     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r10 != 0) goto L_0x0279
            int r10 = r9.f2722a     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r10 = r10 | 8
            r9.f2722a = r10     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x0279:
            long r10 = com.loc.C1079cp.m3529c()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r9.f2725d = r10     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x027f:
            boolean r10 = r9.f2730i     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r10 == 0) goto L_0x0287
            r9.mo13087i()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            return
        L_0x0287:
            int r10 = r9.f2722a     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            r10 = r10 & 3
            switch(r10) {
                case 1: goto L_0x029a;
                case 2: goto L_0x028f;
                default: goto L_0x028e;
            }     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x028e:
            goto L_0x02a4
        L_0x028f:
            java.util.ArrayList<com.loc.bq> r10 = r9.f2723b     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r10 = r10.isEmpty()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r10 == 0) goto L_0x02a4
            r9.f2722a = r2     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            goto L_0x02a4
        L_0x029a:
            java.util.ArrayList<com.loc.bq> r10 = r9.f2723b     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            boolean r10 = r10.isEmpty()     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
            if (r10 == 0) goto L_0x02a4
            r9.f2722a = r2     // Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        L_0x02a4:
            return
        L_0x02a5:
            r10 = move-exception
            java.lang.String r11 = "CgiManager"
            java.lang.String r0 = "refresh"
            com.loc.CoreUtil.m3389a(r10, r11, r0)
            return
        L_0x02ae:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            r9.f2729h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.CgiManager.mo13078a(boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo13079a(CellLocation cellLocation) {
        String str;
        String str2;
        if (cellLocation == null) {
            return false;
        }
        Context context = this.f2733l;
        switch (m3148c(cellLocation)) {
            case 1:
                try {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return m3140a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
                } catch (Throwable th) {
                    th = th;
                    str2 = "CgiManager";
                    str = "cgiUseful Cgi.I_GSM_T";
                    break;
                }
            case 2:
                try {
                    return Reflect.m3416b(cellLocation, "getSystemId", new Object[0]) > 0 && Reflect.m3416b(cellLocation, "getNetworkId", new Object[0]) >= 0 && Reflect.m3416b(cellLocation, "getBaseStationId", new Object[0]) >= 0;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = "CgiManager";
                    str = "cgiUseful Cgi.I_CDMA_T";
                    break;
                }
            default:
                return true;
        }
        CoreUtil.m3389a(th, str2, str);
        return true;
    }

    /* renamed from: b */
    public final ArrayList<Cgi> mo13080b() {
        return this.f2735n;
    }

    /* renamed from: c */
    public final Cgi mo13081c() {
        if (this.f2730i) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f2723b;
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    /* renamed from: d */
    public final Cgi mo13082d() {
        if (this.f2730i) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f2735n;
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    /* renamed from: e */
    public final int mo13083e() {
        return this.f2722a;
    }

    /* renamed from: f */
    public final int mo13084f() {
        return this.f2722a & 3;
    }

    /* renamed from: g */
    public final TelephonyManager mo13085g() {
        return this.f2724c;
    }

    /* renamed from: h */
    public final void mo13086h() {
        this.f2737p.mo13071a();
        this.f2740s = 0;
        synchronized (this.f2742u) {
            this.f2741t = true;
        }
        if (!(this.f2724c == null || this.f2728g == null)) {
            try {
                this.f2724c.listen(this.f2728g, 0);
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "CgiManager", "destroy");
            }
        }
        this.f2728g = null;
        if (this.f2732k != null) {
            this.f2732k.quit();
            this.f2732k = null;
        }
        this.f2736o = -113;
        this.f2724c = null;
        this.f2738q = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo13087i() {
        this.f2729h = null;
        this.f2726e = null;
        this.f2722a = 0;
        this.f2723b.clear();
        this.f2735n.clear();
    }

    /* renamed from: j */
    public final String mo13088j() {
        return this.f2729h;
    }

    /* renamed from: k */
    public final String mo13089k() {
        return this.f2734m;
    }

    /* renamed from: l */
    public final String mo13090l() {
        if (this.f2730i) {
            mo13087i();
        }
        if (this.f2731j == null) {
            this.f2731j = new StringBuilder();
        } else {
            this.f2731j.delete(0, this.f2731j.length());
        }
        if ((this.f2722a & 3) == 1) {
            for (int i = 1; i < this.f2723b.size(); i++) {
                StringBuilder sb = this.f2731j;
                sb.append("#");
                sb.append(this.f2723b.get(i).f2707b);
                StringBuilder sb2 = this.f2731j;
                sb2.append("|");
                sb2.append(this.f2723b.get(i).f2708c);
                StringBuilder sb3 = this.f2731j;
                sb3.append("|");
                sb3.append(this.f2723b.get(i).f2709d);
            }
        }
        if (this.f2731j.length() > 0) {
            this.f2731j.deleteCharAt(0);
        }
        return this.f2731j.toString();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo13091m() {
        /*
            r3 = this;
            r0 = 1
            android.telephony.TelephonyManager r1 = r3.f2724c     // Catch:{ Throwable -> 0x001f }
            if (r1 == 0) goto L_0x001f
            android.telephony.TelephonyManager r1 = r3.f2724c     // Catch:{ Throwable -> 0x001f }
            java.lang.String r1 = r1.getSimOperator()     // Catch:{ Throwable -> 0x001f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x001f }
            if (r1 != 0) goto L_0x0012
            return r0
        L_0x0012:
            android.telephony.TelephonyManager r1 = r3.f2724c     // Catch:{ Throwable -> 0x001f }
            java.lang.String r1 = r1.getSimCountryIso()     // Catch:{ Throwable -> 0x001f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x001f }
            if (r1 != 0) goto L_0x001f
            return r0
        L_0x001f:
            android.content.Context r1 = r3.f2733l     // Catch:{ Throwable -> 0x0038 }
            android.net.NetworkInfo r1 = com.loc.C1079cp.m3530c((android.content.Context) r1)     // Catch:{ Throwable -> 0x0038 }
            int r1 = com.loc.C1079cp.m3500a((android.net.NetworkInfo) r1)     // Catch:{ Throwable -> 0x0038 }
            if (r1 == 0) goto L_0x0037
            r2 = 4
            if (r1 == r2) goto L_0x0037
            r2 = 2
            if (r1 == r2) goto L_0x0037
            r2 = 5
            if (r1 == r2) goto L_0x0037
            r2 = 3
            if (r1 != r2) goto L_0x0038
        L_0x0037:
            return r0
        L_0x0038:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.CgiManager.mo13091m():boolean");
    }
}
