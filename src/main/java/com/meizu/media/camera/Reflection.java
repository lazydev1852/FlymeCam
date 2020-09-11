package com.meizu.media.camera;

import android.content.Context;
import android.os.Build;
import com.baidu.p020ar.base.MsgField;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0010\"\u00020\u0007¢\u0006\u0002\u0010\u0011J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo27294d2 = {"Lcom/meizu/media/camera/Reflection;", "", "()V", "ERROR_EXEMPT_FAILED", "", "ERROR_SET_APPLICATION_FAILED", "TAG", "", "UNKNOWN", "sVmRuntime", "setHiddenApiExemptions", "Ljava/lang/reflect/Method;", "unsealed", "exempt", "", "methods", "", "([Ljava/lang/String;)Z", "method", "exemptAll", "unseal", "context", "Landroid/content/Context;", "unsealNative", "targetSdkVersion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.z */
public final class Reflection {

    /* renamed from: a */
    public static ChangeQuickRedirect f14430a = null;

    /* renamed from: b */
    public static final Reflection f14431b = new Reflection();

    /* renamed from: c */
    private static final String f14432c = f14432c;

    /* renamed from: d */
    private static Object f14433d = null;

    /* renamed from: e */
    private static Method f14434e = null;

    /* renamed from: f */
    private static final int f14435f = -9999;

    /* renamed from: g */
    private static final int f14436g = f14436g;

    /* renamed from: h */
    private static final int f14437h = f14437h;

    /* renamed from: i */
    private static final int f14438i = f14435f;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            com.meizu.media.camera.z r0 = new com.meizu.media.camera.z
            r0.<init>()
            f14431b = r0
            java.lang.String r0 = "Reflection"
            f14432c = r0
            r0 = -9999(0xffffffffffffd8f1, float:NaN)
            f14435f = r0
            r0 = -20
            f14436g = r0
            r0 = -21
            f14437h = r0
            int r0 = f14435f
            f14438i = r0
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            java.lang.String r1 = "forName"
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r5 = 0
            r3[r5] = r4     // Catch:{ Throwable -> 0x00a4 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r1 = "Class::class.java.getDec…ame\", String::class.java)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            java.lang.String r3 = "getDeclaredMethod"
            r4 = 2
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r5] = r7     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class r7 = r7.getClass()     // Catch:{ Throwable -> 0x00a4 }
            r6[r2] = r7     // Catch:{ Throwable -> 0x00a4 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r6)     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r3 = "Class::class.java.getDec…<Class<*>>()::class.java)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r6 = "dalvik.system.VMRuntime"
            r3[r5] = r6     // Catch:{ Throwable -> 0x00a4 }
            r6 = 0
            java.lang.Object r0 = r0.invoke(r6, r3)     // Catch:{ Throwable -> 0x00a4 }
            if (r0 == 0) goto L_0x009c
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r7 = "getRuntime"
            r3[r5] = r7     // Catch:{ Throwable -> 0x00a4 }
            r3[r2] = r6     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Object r3 = r1.invoke(r0, r3)     // Catch:{ Throwable -> 0x00a4 }
            if (r3 == 0) goto L_0x0094
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r7 = "setHiddenApiExemptions"
            r4[r5] = r7     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class<java.lang.String[]> r8 = java.lang.String[].class
            r7[r5] = r8     // Catch:{ Throwable -> 0x00a4 }
            r4[r2] = r7     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Object r0 = r1.invoke(r0, r4)     // Catch:{ Throwable -> 0x00a4 }
            if (r0 == 0) goto L_0x008c
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch:{ Throwable -> 0x00a4 }
            f14434e = r0     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Object r0 = r3.invoke(r6, r0)     // Catch:{ Throwable -> 0x00a4 }
            f14433d = r0     // Catch:{ Throwable -> 0x00a4 }
            goto L_0x00a4
        L_0x008c:
            kotlin.q r0 = new kotlin.q     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.reflect.Method"
            r0.<init>(r1)     // Catch:{ Throwable -> 0x00a4 }
            throw r0     // Catch:{ Throwable -> 0x00a4 }
        L_0x0094:
            kotlin.q r0 = new kotlin.q     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.reflect.Method"
            r0.<init>(r1)     // Catch:{ Throwable -> 0x00a4 }
            throw r0     // Catch:{ Throwable -> 0x00a4 }
        L_0x009c:
            kotlin.q r0 = new kotlin.q     // Catch:{ Throwable -> 0x00a4 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.Class<*>"
            r0.<init>(r1)     // Catch:{ Throwable -> 0x00a4 }
            throw r0     // Catch:{ Throwable -> 0x00a4 }
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Reflection.<clinit>():void");
    }

    private Reflection() {
    }

    /* renamed from: a */
    public final int mo22796a(@NotNull Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, this, f14430a, false, 2098, new Class[]{Context.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(context, "context");
        if (Build.VERSION.SDK_INT >= 28 && !mo22797a()) {
            return f14437h;
        }
        return 0;
    }

    /* renamed from: a */
    public final boolean mo22798a(@NotNull String... strArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f14430a, false, PushConstants.BROADCAST_MESSAGE_ARRIVE, new Class[]{String[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(strArr, "methods");
        if (f14433d == null || f14434e == null) {
            return false;
        }
        try {
            Method method = f14434e;
            if (method == null) {
                C3443i.m21151a();
            }
            method.invoke(f14433d, new Object[]{strArr});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo22797a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14430a, false, MsgField.IMSG_MODE_SHOWING, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo22798a("L");
    }
}
