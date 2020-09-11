package flyme.support.p093v7.util;

import androidx.fragment.app.FragmentManager;
import java.lang.reflect.Field;

/* renamed from: flyme.support.v7.util.b */
/* compiled from: ReflectUtils */
public class C3149b {

    /* renamed from: a */
    public static Field f17087a;

    /* renamed from: b */
    public static Field f17088b;

    /* renamed from: a */
    public static int m18746a(Object obj) {
        Field field;
        boolean z = obj instanceof FragmentManager;
        m18748b(obj, z);
        if (z) {
            try {
                field = f17088b;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            field = f17087a;
        }
        return field.getBoolean(obj) ? 1 : 0;
    }

    /* renamed from: a */
    public static void m18747a(Object obj, boolean z) {
        Field field;
        boolean z2 = obj instanceof FragmentManager;
        m18748b(obj, z2);
        if (z2) {
            try {
                field = f17088b;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            field = f17087a;
        }
        field.setBoolean(obj, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m18748b(java.lang.Object r3, boolean r4) {
        /*
            if (r4 == 0) goto L_0x0006
            java.lang.reflect.Field r0 = f17088b
            if (r0 != 0) goto L_0x000c
        L_0x0006:
            if (r4 != 0) goto L_0x000d
            java.lang.reflect.Field r0 = f17087a
            if (r0 == 0) goto L_0x000d
        L_0x000c:
            return
        L_0x000d:
            r0 = 0
            java.lang.Class r3 = r3.getClass()     // Catch:{ Exception -> 0x0022 }
            java.lang.String r1 = "mStateSaved"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r1)     // Catch:{ Exception -> 0x0022 }
            r0 = 1
            r3.setAccessible(r0)     // Catch:{ Exception -> 0x001d }
            goto L_0x0027
        L_0x001d:
            r0 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
            goto L_0x0023
        L_0x0022:
            r3 = move-exception
        L_0x0023:
            r3.printStackTrace()
            r3 = r0
        L_0x0027:
            if (r4 == 0) goto L_0x002c
            f17088b = r3
            goto L_0x002e
        L_0x002c:
            f17087a = r3
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.util.C3149b.m18748b(java.lang.Object, boolean):void");
    }
}
