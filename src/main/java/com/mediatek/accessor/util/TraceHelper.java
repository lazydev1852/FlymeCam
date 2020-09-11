package com.mediatek.accessor.util;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TraceHelper {
    private static final String TAG = Log.Tag(TraceHelper.class.getSimpleName());
    private static boolean sHasCheck = false;
    private static boolean sSupportTrace;
    private static Method sTraceBeginMethod;
    private static Method sTraceEndMethod;
    private static long sViewTag;

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 18) {
            z = true;
        }
        sSupportTrace = z;
    }

    public static void beginSection(String str) {
        checkWhetherSupport();
        if (sTraceBeginMethod != null && sTraceEndMethod != null) {
            try {
                sTraceBeginMethod.invoke((Object) null, new Object[]{Long.valueOf(sViewTag), str});
            } catch (IllegalAccessException e) {
                Log.m3994d(TAG, "<beginSection> IllegalAccessException", e);
            } catch (InvocationTargetException e2) {
                Log.m3994d(TAG, "<beginSection> InvocationTargetException", e2);
            }
        } else if (sSupportTrace) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        checkWhetherSupport();
        if (sTraceBeginMethod != null && sTraceEndMethod != null) {
            try {
                sTraceEndMethod.invoke((Object) null, new Object[]{Long.valueOf(sViewTag)});
            } catch (IllegalAccessException e) {
                Log.m3994d(TAG, "<endSection> IllegalAccessException", e);
            } catch (InvocationTargetException e2) {
                Log.m3994d(TAG, "<endSection> InvocationTargetException", e2);
            }
        } else if (sSupportTrace) {
            Trace.endSection();
        }
    }

    private static void checkWhetherSupport() {
        if (!sHasCheck) {
            if (!sSupportTrace) {
                sHasCheck = true;
                return;
            }
            Class<Trace> cls = Trace.class;
            try {
                sTraceBeginMethod = cls.getDeclaredMethod("traceBegin", new Class[]{Long.TYPE, String.class});
                sTraceBeginMethod.setAccessible(true);
                sTraceEndMethod = Trace.class.getDeclaredMethod("traceEnd", new Class[]{Long.TYPE});
                sTraceEndMethod.setAccessible(true);
                Field declaredField = Trace.class.getDeclaredField("TRACE_TAG_VIEW");
                declaredField.setAccessible(true);
                sViewTag = declaredField.getLong((Object) null);
            } catch (NoSuchMethodException e) {
                Log.m3994d(TAG, "<checkWhetherSupport> NoSuchMethodException", e);
            } catch (NoSuchFieldException e2) {
                Log.m3994d(TAG, "<checkWhetherSupport> NoSuchFieldException", e2);
            } catch (IllegalAccessException e3) {
                Log.m3994d(TAG, "<checkWhetherSupport> IllegalAccessException", e3);
            }
            sHasCheck = true;
        }
    }
}
