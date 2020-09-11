package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

public class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    static void flush(@NonNull Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                flushNougats(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                flushMarshmallows(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                flushLollipops(resources);
            }
        }
    }

    @RequiresApi(21)
    private static void flushLollipops(@NonNull Resources resources) {
        Map map;
        if (!sDrawableCacheFieldFetched) {
            try {
                sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        if (sDrawableCacheField != null) {
            try {
                map = (Map) sDrawableCacheField.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    @androidx.annotation.RequiresApi(23)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void flushMarshmallows(@androidx.annotation.NonNull android.content.res.Resources r4) {
        /*
            boolean r0 = sDrawableCacheFieldFetched
            if (r0 != 0) goto L_0x001f
            r0 = 1
            java.lang.Class<android.content.res.Resources> r1 = android.content.res.Resources.class
            java.lang.String r2 = "mDrawableCache"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0015 }
            sDrawableCacheField = r1     // Catch:{ NoSuchFieldException -> 0x0015 }
            java.lang.reflect.Field r1 = sDrawableCacheField     // Catch:{ NoSuchFieldException -> 0x0015 }
            r1.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0015 }
            goto L_0x001d
        L_0x0015:
            r1 = move-exception
            java.lang.String r2 = "ResourcesFlusher"
            java.lang.String r3 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r2, r3, r1)
        L_0x001d:
            sDrawableCacheFieldFetched = r0
        L_0x001f:
            r0 = 0
            java.lang.reflect.Field r1 = sDrawableCacheField
            if (r1 == 0) goto L_0x0033
            java.lang.reflect.Field r1 = sDrawableCacheField     // Catch:{ IllegalAccessException -> 0x002b }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ IllegalAccessException -> 0x002b }
            goto L_0x0034
        L_0x002b:
            r4 = move-exception
            java.lang.String r1 = "ResourcesFlusher"
            java.lang.String r2 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r1, r2, r4)
        L_0x0033:
            r4 = r0
        L_0x0034:
            if (r4 != 0) goto L_0x0037
            return
        L_0x0037:
            flushThemedResourcesCache(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ResourcesFlusher.flushMarshmallows(android.content.res.Resources):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RequiresApi(24)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void flushNougats(@androidx.annotation.NonNull android.content.res.Resources r5) {
        /*
            boolean r0 = sResourcesImplFieldFetched
            r1 = 1
            if (r0 != 0) goto L_0x001f
            java.lang.Class<android.content.res.Resources> r0 = android.content.res.Resources.class
            java.lang.String r2 = "mResourcesImpl"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0015 }
            sResourcesImplField = r0     // Catch:{ NoSuchFieldException -> 0x0015 }
            java.lang.reflect.Field r0 = sResourcesImplField     // Catch:{ NoSuchFieldException -> 0x0015 }
            r0.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x0015 }
            goto L_0x001d
        L_0x0015:
            r0 = move-exception
            java.lang.String r2 = "ResourcesFlusher"
            java.lang.String r3 = "Could not retrieve Resources#mResourcesImpl field"
            android.util.Log.e(r2, r3, r0)
        L_0x001d:
            sResourcesImplFieldFetched = r1
        L_0x001f:
            java.lang.reflect.Field r0 = sResourcesImplField
            if (r0 != 0) goto L_0x0024
            return
        L_0x0024:
            r0 = 0
            java.lang.reflect.Field r2 = sResourcesImplField     // Catch:{ IllegalAccessException -> 0x002c }
            java.lang.Object r5 = r2.get(r5)     // Catch:{ IllegalAccessException -> 0x002c }
            goto L_0x0035
        L_0x002c:
            r5 = move-exception
            java.lang.String r2 = "ResourcesFlusher"
            java.lang.String r3 = "Could not retrieve value from Resources#mResourcesImpl"
            android.util.Log.e(r2, r3, r5)
            r5 = r0
        L_0x0035:
            if (r5 != 0) goto L_0x0038
            return
        L_0x0038:
            boolean r2 = sDrawableCacheFieldFetched
            if (r2 != 0) goto L_0x0058
            java.lang.Class r2 = r5.getClass()     // Catch:{ NoSuchFieldException -> 0x004e }
            java.lang.String r3 = "mDrawableCache"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x004e }
            sDrawableCacheField = r2     // Catch:{ NoSuchFieldException -> 0x004e }
            java.lang.reflect.Field r2 = sDrawableCacheField     // Catch:{ NoSuchFieldException -> 0x004e }
            r2.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x004e }
            goto L_0x0056
        L_0x004e:
            r2 = move-exception
            java.lang.String r3 = "ResourcesFlusher"
            java.lang.String r4 = "Could not retrieve ResourcesImpl#mDrawableCache field"
            android.util.Log.e(r3, r4, r2)
        L_0x0056:
            sDrawableCacheFieldFetched = r1
        L_0x0058:
            java.lang.reflect.Field r1 = sDrawableCacheField
            if (r1 == 0) goto L_0x006b
            java.lang.reflect.Field r1 = sDrawableCacheField     // Catch:{ IllegalAccessException -> 0x0063 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ IllegalAccessException -> 0x0063 }
            goto L_0x006c
        L_0x0063:
            r5 = move-exception
            java.lang.String r1 = "ResourcesFlusher"
            java.lang.String r2 = "Could not retrieve value from ResourcesImpl#mDrawableCache"
            android.util.Log.e(r1, r2, r5)
        L_0x006b:
            r5 = r0
        L_0x006c:
            if (r5 == 0) goto L_0x0071
            flushThemedResourcesCache(r5)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ResourcesFlusher.flushNougats(android.content.res.Resources):void");
    }

    @RequiresApi(16)
    private static void flushThemedResourcesCache(@NonNull Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        if (sThemedResourceCacheClazz != null) {
            if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
                try {
                    sThemedResourceCache_mUnthemedEntriesField = sThemedResourceCacheClazz.getDeclaredField("mUnthemedEntries");
                    sThemedResourceCache_mUnthemedEntriesField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
            }
            if (sThemedResourceCache_mUnthemedEntriesField != null) {
                try {
                    longSparseArray = (LongSparseArray) sThemedResourceCache_mUnthemedEntriesField.get(obj);
                } catch (IllegalAccessException e3) {
                    Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    private ResourcesFlusher() {
    }
}
