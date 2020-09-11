package com.loc;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* renamed from: com.loc.bc */
public final class StatisticsHeaderDataStrategy extends UpdateDataStrategy {

    /* renamed from: a */
    public static int f2632a = 13;

    /* renamed from: b */
    public static int f2633b = 6;

    /* renamed from: e */
    private Context f2634e;

    public StatisticsHeaderDataStrategy(Context context, UpdateDataStrategy beVar) {
        super(beVar);
        this.f2634e = context;
    }

    /* renamed from: a */
    private static byte[] m3081a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            C1107dj.m3814a(byteArrayOutputStream, "1.2." + f2632a + "." + f2633b);
            C1107dj.m3814a(byteArrayOutputStream, "Android");
            C1107dj.m3814a(byteArrayOutputStream, DeviceInfo.m3733v(context));
            C1107dj.m3814a(byteArrayOutputStream, DeviceInfo.m3724m(context));
            C1107dj.m3814a(byteArrayOutputStream, DeviceInfo.m3719h(context));
            C1107dj.m3814a(byteArrayOutputStream, Build.MANUFACTURER);
            C1107dj.m3814a(byteArrayOutputStream, Build.MODEL);
            C1107dj.m3814a(byteArrayOutputStream, Build.DEVICE);
            C1107dj.m3814a(byteArrayOutputStream, DeviceInfo.m3735x(context));
            C1107dj.m3814a(byteArrayOutputStream, AppInfo.m3663c(context));
            C1107dj.m3814a(byteArrayOutputStream, AppInfo.m3664d(context));
            C1107dj.m3814a(byteArrayOutputStream, AppInfo.m3666f(context));
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                th.printStackTrace();
                return byteArray;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return bArr;
        throw th;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo13039a(byte[] bArr) {
        byte[] a = m3081a(this.f2634e);
        byte[] bArr2 = new byte[(a.length + bArr.length)];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(bArr, 0, bArr2, a.length, bArr.length);
        return bArr2;
    }
}
