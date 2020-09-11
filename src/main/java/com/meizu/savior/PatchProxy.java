package com.meizu.savior;

import android.text.TextUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class PatchProxy {
    private static CopyOnWriteArrayList<SaviorExtension> registerExtensionList = new CopyOnWriteArrayList<>();
    private static ThreadLocal<SaviorExtension> saviorExtensionThreadLocal = new ThreadLocal<>();

    public static Object accessDispatch(Object[] objArr, Object obj, ChangeQuickRedirect changeQuickRedirect, boolean z, int i, Class[] clsArr, Class cls) {
        if (changeQuickRedirect == null) {
            SaviorExtension saviorExtension = saviorExtensionThreadLocal.get();
            saviorExtensionThreadLocal.remove();
            if (saviorExtension == null) {
                return null;
            }
            notify(saviorExtension.describeSelfFunction());
            return saviorExtension.accessDispatch(new SaviorArguments(objArr, obj, z, i, clsArr, cls));
        }
        String classMethod = getClassMethod(z, i);
        if (TextUtils.isEmpty(classMethod)) {
            return null;
        }
        notify(Constants.PATCH_EXECUTE);
        return changeQuickRedirect.accessDispatch(classMethod, getObjects(objArr, obj, z));
    }

    public static void accessDispatchVoid(Object[] objArr, Object obj, ChangeQuickRedirect changeQuickRedirect, boolean z, int i, Class[] clsArr, Class cls) {
        if (changeQuickRedirect == null) {
            SaviorExtension saviorExtension = saviorExtensionThreadLocal.get();
            saviorExtensionThreadLocal.remove();
            if (saviorExtension != null) {
                notify(saviorExtension.describeSelfFunction());
                saviorExtension.accessDispatch(new SaviorArguments(objArr, obj, z, i, clsArr, cls));
                return;
            }
            return;
        }
        notify(Constants.PATCH_EXECUTE);
        String classMethod = getClassMethod(z, i);
        if (!TextUtils.isEmpty(classMethod)) {
            changeQuickRedirect.accessDispatch(classMethod, getObjects(objArr, obj, z));
        }
    }

    private static String getClassMethod(boolean z, int i) {
        try {
            return "" + SystemInfoUtil.COLON + "" + SystemInfoUtil.COLON + z + SystemInfoUtil.COLON + i;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String[] getClassMethodName() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return new String[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName()};
    }

    private static Object[] getObjects(Object[] objArr, Object obj, boolean z) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        Object[] objArr2 = z ? new Object[length] : new Object[(length + 1)];
        int i = 0;
        while (i < length) {
            objArr2[i] = objArr[i];
            i++;
        }
        if (!z) {
            objArr2[i] = obj;
        }
        return objArr2;
    }

    public static boolean isSupport(Object[] objArr, Object obj, ChangeQuickRedirect changeQuickRedirect, boolean z, int i, Class[] clsArr, Class cls) {
        if (changeQuickRedirect == null) {
            if (registerExtensionList != null && !registerExtensionList.isEmpty()) {
                Iterator<SaviorExtension> it = registerExtensionList.iterator();
                while (it.hasNext()) {
                    SaviorExtension next = it.next();
                    if (next.isSupport(new SaviorArguments(objArr, obj, z, i, clsArr, cls))) {
                        saviorExtensionThreadLocal.set(next);
                        return true;
                    }
                }
            }
            return false;
        }
        String classMethod = getClassMethod(z, i);
        if (TextUtils.isEmpty(classMethod)) {
            return false;
        }
        Object[] objArr2 = objArr;
        Object obj2 = obj;
        boolean z2 = z;
        try {
            return changeQuickRedirect.isSupport(classMethod, getObjects(objArr, obj, z));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void notify(String str) {
        if (registerExtensionList != null) {
            Iterator<SaviorExtension> it = registerExtensionList.iterator();
            while (it.hasNext()) {
                it.next().notifyListner(str);
            }
        }
    }

    public static PatchProxyResult proxy(Object[] objArr, Object obj, ChangeQuickRedirect changeQuickRedirect, boolean z, int i, Class[] clsArr, Class cls) {
        PatchProxyResult patchProxyResult = new PatchProxyResult();
        if (isSupport(objArr, obj, changeQuickRedirect, z, i, clsArr, cls)) {
            patchProxyResult.isSupported = true;
            patchProxyResult.result = accessDispatch(objArr, obj, changeQuickRedirect, z, i, clsArr, cls);
        }
        return patchProxyResult;
    }

    public static synchronized boolean register(SaviorExtension saviorExtension) {
        boolean addIfAbsent;
        synchronized (PatchProxy.class) {
            if (registerExtensionList == null) {
                registerExtensionList = new CopyOnWriteArrayList<>();
            }
            addIfAbsent = registerExtensionList.addIfAbsent(saviorExtension);
        }
        return addIfAbsent;
    }

    public static void reset() {
        registerExtensionList = new CopyOnWriteArrayList<>();
        saviorExtensionThreadLocal = new ThreadLocal<>();
    }

    public static synchronized boolean unregister(SaviorExtension saviorExtension) {
        synchronized (PatchProxy.class) {
            if (registerExtensionList == null) {
                return false;
            }
            boolean remove = registerExtensionList.remove(saviorExtension);
            return remove;
        }
    }
}
