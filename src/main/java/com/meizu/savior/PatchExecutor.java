package com.meizu.savior;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.meizu.savior.PatchManipulate;

public class PatchExecutor extends Thread {
    protected Context context;
    protected PatchManipulate patchManipulate;
    protected SaviorCallBack saviorCallBack;

    public PatchExecutor(Context context2, PatchManipulate patchManipulate2, SaviorCallBack saviorCallBack2) {
        this.context = context2.getApplicationContext();
        this.patchManipulate = patchManipulate2;
        this.saviorCallBack = saviorCallBack2;
    }

    /* access modifiers changed from: protected */
    public void applyPatch(Patch patch) {
        boolean z;
        if (patch == null) {
            Log.d("savior", "applyPatch: patch is null");
        } else if (patch.isAppliedSuccess()) {
            Log.d("savior", "p.isAppliedSuccess() skip " + patch.getLocalPath());
        } else {
            boolean z2 = false;
            try {
                z = patch(this.context, patch);
            } catch (Throwable th) {
                this.saviorCallBack.exceptionNotify(th, "class:PatchExecutor method:applyPatch line:69");
                z = false;
            }
            if (z) {
                z2 = true;
                patch.setAppliedSuccess(true);
            }
            this.saviorCallBack.onPatchApplied(z2, patch);
            Log.d("savior", "patch LocalPath:" + patch.getLocalPath() + ",apply result " + z);
        }
    }

    /* access modifiers changed from: protected */
    public void fetchPatch(PatchManipulate.PatchFetchCallback patchFetchCallback) {
        this.patchManipulate.fetchPatch(this.context, patchFetchCallback);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean patch(android.content.Context r14, com.meizu.savior.Patch r15) {
        /*
            r13 = this;
            dalvik.system.DexClassLoader r0 = new dalvik.system.DexClassLoader
            java.lang.String r1 = r15.getLocalPath()
            java.io.File r14 = r14.getFilesDir()
            java.lang.String r14 = r14.getAbsolutePath()
            java.lang.Class<com.meizu.savior.PatchExecutor> r2 = com.meizu.savior.PatchExecutor.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r3 = 0
            r0.<init>(r1, r14, r3, r2)
            java.lang.String r14 = "savior"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x004a }
            r1.<init>()     // Catch:{ Throwable -> 0x004a }
            java.lang.String r2 = "PatchInfoImpl name:"
            r1.append(r2)     // Catch:{ Throwable -> 0x004a }
            java.lang.String r2 = r15.getPatchesInfoImplClassFullName()     // Catch:{ Throwable -> 0x004a }
            r1.append(r2)     // Catch:{ Throwable -> 0x004a }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x004a }
            android.util.Log.d(r14, r1)     // Catch:{ Throwable -> 0x004a }
            java.lang.String r14 = r15.getPatchesInfoImplClassFullName()     // Catch:{ Throwable -> 0x004a }
            java.lang.Class r14 = r0.loadClass(r14)     // Catch:{ Throwable -> 0x004a }
            java.lang.Object r14 = r14.newInstance()     // Catch:{ Throwable -> 0x004a }
            com.meizu.savior.PatchesInfo r14 = (com.meizu.savior.PatchesInfo) r14     // Catch:{ Throwable -> 0x004a }
            java.lang.String r1 = "savior"
            java.lang.String r2 = "PatchInfoImpl ok"
            android.util.Log.d(r1, r2)     // Catch:{ Throwable -> 0x0048 }
            goto L_0x0070
        L_0x0048:
            r1 = move-exception
            goto L_0x004c
        L_0x004a:
            r1 = move-exception
            r14 = r3
        L_0x004c:
            com.meizu.savior.SaviorCallBack r2 = r13.saviorCallBack
            java.lang.String r4 = "class:PatchExecutor method:patch line:108"
            r2.exceptionNotify(r1, r4)
            java.lang.String r2 = "savior"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "PatchInfoImpl failed, cause of "
            r4.append(r5)
            java.lang.String r5 = r1.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r2, r4)
            r1.printStackTrace()
        L_0x0070:
            r1 = 0
            if (r14 != 0) goto L_0x009c
            com.meizu.savior.SaviorCallBack r14 = r13.saviorCallBack
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "patchesInfo is null, patch info:id = "
            r0.append(r2)
            java.lang.String r2 = r15.getName()
            r0.append(r2)
            java.lang.String r2 = ",md5 = "
            r0.append(r2)
            java.lang.String r15 = r15.getMd5()
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            java.lang.String r0 = "class:PatchExecutor method:patch line:114"
        L_0x0098:
            r14.logNotify(r15, r0)
            return r1
        L_0x009c:
            java.util.List r14 = r14.getPatchedClassesInfo()
            if (r14 == 0) goto L_0x0227
            boolean r2 = r14.isEmpty()
            if (r2 == 0) goto L_0x00aa
            goto L_0x0227
        L_0x00aa:
            java.util.Iterator r14 = r14.iterator()
        L_0x00ae:
            boolean r2 = r14.hasNext()
            r4 = 1
            if (r2 == 0) goto L_0x021f
            java.lang.Object r2 = r14.next()
            com.meizu.savior.PatchedClassInfo r2 = (com.meizu.savior.PatchedClassInfo) r2
            java.lang.String r5 = r2.patchedClassName
            java.lang.String r2 = r2.patchClassName
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x01f5
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L_0x00cd
            goto L_0x01f5
        L_0x00cd:
            java.lang.String r6 = "savior"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "current path:"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r6, r7)
            java.lang.String r6 = r5.trim()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.Class r6 = r0.loadClass(r6)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.reflect.Field[] r7 = r6.getDeclaredFields()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r8 = "savior"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01e1 }
            r9.<init>()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r10 = "oldClass :"
            r9.append(r10)     // Catch:{ Throwable -> 0x01e1 }
            r9.append(r6)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r10 = "     fields "
            r9.append(r10)     // Catch:{ Throwable -> 0x01e1 }
            int r10 = r7.length     // Catch:{ Throwable -> 0x01e1 }
            r9.append(r10)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x01e1 }
            android.util.Log.d(r8, r9)     // Catch:{ Throwable -> 0x01e1 }
            int r8 = r7.length     // Catch:{ Throwable -> 0x01e1 }
            r9 = 0
        L_0x0110:
            if (r9 >= r8) goto L_0x013e
            r10 = r7[r9]     // Catch:{ Throwable -> 0x01e1 }
            java.lang.Class r11 = r10.getType()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r11 = r11.getCanonicalName()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.Class<com.meizu.savior.ChangeQuickRedirect> r12 = com.meizu.savior.ChangeQuickRedirect.class
            java.lang.String r12 = r12.getCanonicalName()     // Catch:{ Throwable -> 0x01e1 }
            boolean r11 = android.text.TextUtils.equals(r11, r12)     // Catch:{ Throwable -> 0x01e1 }
            if (r11 == 0) goto L_0x013b
            java.lang.Class r11 = r10.getDeclaringClass()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r11 = r11.getCanonicalName()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r12 = r6.getCanonicalName()     // Catch:{ Throwable -> 0x01e1 }
            boolean r11 = android.text.TextUtils.equals(r11, r12)     // Catch:{ Throwable -> 0x01e1 }
            if (r11 == 0) goto L_0x013b
            goto L_0x013f
        L_0x013b:
            int r9 = r9 + 1
            goto L_0x0110
        L_0x013e:
            r10 = r3
        L_0x013f:
            if (r10 != 0) goto L_0x0189
            com.meizu.savior.SaviorCallBack r4 = r13.saviorCallBack     // Catch:{ Throwable -> 0x01e1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01e1 }
            r6.<init>()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r7 = "changeQuickRedirectField  is null, patch info:id = "
            r6.append(r7)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r7 = r15.getName()     // Catch:{ Throwable -> 0x01e1 }
            r6.append(r7)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r7 = ",md5 = "
            r6.append(r7)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r7 = r15.getMd5()     // Catch:{ Throwable -> 0x01e1 }
            r6.append(r7)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r7 = "class:PatchExecutor method:patch line:147"
            r4.logNotify(r6, r7)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r4 = "savior"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01e1 }
            r6.<init>()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r7 = "current path:"
            r6.append(r7)     // Catch:{ Throwable -> 0x01e1 }
            r6.append(r5)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r5 = " something wrong !! can  not find:ChangeQuickRedirect in"
            r6.append(r5)     // Catch:{ Throwable -> 0x01e1 }
            r6.append(r2)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r2 = r6.toString()     // Catch:{ Throwable -> 0x01e1 }
            android.util.Log.d(r4, r2)     // Catch:{ Throwable -> 0x01e1 }
            goto L_0x00ae
        L_0x0189:
            java.lang.String r6 = "savior"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01e1 }
            r7.<init>()     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r8 = "current path:"
            r7.append(r8)     // Catch:{ Throwable -> 0x01e1 }
            r7.append(r5)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r5 = " find:ChangeQuickRedirect "
            r7.append(r5)     // Catch:{ Throwable -> 0x01e1 }
            r7.append(r2)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r5 = r7.toString()     // Catch:{ Throwable -> 0x01e1 }
            android.util.Log.d(r6, r5)     // Catch:{ Throwable -> 0x01e1 }
            java.lang.Class r5 = r0.loadClass(r2)     // Catch:{ Throwable -> 0x01cd }
            java.lang.Object r5 = r5.newInstance()     // Catch:{ Throwable -> 0x01cd }
            r10.setAccessible(r4)     // Catch:{ Throwable -> 0x01cd }
            r10.set(r3, r5)     // Catch:{ Throwable -> 0x01cd }
            java.lang.String r4 = "savior"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01cd }
            r5.<init>()     // Catch:{ Throwable -> 0x01cd }
            java.lang.String r6 = "changeQuickRedirectField set sucess "
            r5.append(r6)     // Catch:{ Throwable -> 0x01cd }
            r5.append(r2)     // Catch:{ Throwable -> 0x01cd }
            java.lang.String r2 = r5.toString()     // Catch:{ Throwable -> 0x01cd }
            android.util.Log.d(r4, r2)     // Catch:{ Throwable -> 0x01cd }
            goto L_0x00ae
        L_0x01cd:
            r2 = move-exception
            java.lang.String r4 = "savior"
            java.lang.String r5 = "patch failed! "
            android.util.Log.e(r4, r5)     // Catch:{ Throwable -> 0x01e1 }
            r2.printStackTrace()     // Catch:{ Throwable -> 0x01e1 }
            com.meizu.savior.SaviorCallBack r4 = r13.saviorCallBack     // Catch:{ Throwable -> 0x01e1 }
            java.lang.String r5 = "class:PatchExecutor method:patch line:163"
            r4.exceptionNotify(r2, r5)     // Catch:{ Throwable -> 0x01e1 }
            goto L_0x00ae
        L_0x01e1:
            r2 = move-exception
            java.lang.String r4 = "savior"
            java.lang.String r5 = "patch failed! "
            android.util.Log.e(r4, r5)
            r2.printStackTrace()
            com.meizu.savior.SaviorCallBack r4 = r13.saviorCallBack
            java.lang.String r5 = "class:PatchExecutor method:patch line:169"
            r4.exceptionNotify(r2, r5)
            goto L_0x00ae
        L_0x01f5:
            com.meizu.savior.SaviorCallBack r2 = r13.saviorCallBack
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "patchedClasses or patchClassName is empty, patch info:id = "
            r4.append(r5)
            java.lang.String r5 = r15.getName()
            r4.append(r5)
            java.lang.String r5 = ",md5 = "
            r4.append(r5)
            java.lang.String r5 = r15.getMd5()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "class:PatchExecutor method:patch line:131"
            r2.logNotify(r4, r5)
            goto L_0x00ae
        L_0x021f:
            java.lang.String r14 = "savior"
            java.lang.String r15 = "patch finished "
            android.util.Log.d(r14, r15)
            return r4
        L_0x0227:
            com.meizu.savior.SaviorCallBack r14 = r13.saviorCallBack
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "patchedClasses is null or empty, patch info:id = "
            r0.append(r2)
            java.lang.String r2 = r15.getName()
            r0.append(r2)
            java.lang.String r2 = ",md5 = "
            r0.append(r2)
            java.lang.String r15 = r15.getMd5()
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            java.lang.String r0 = "class:PatchExecutor method:patch line:122"
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.savior.PatchExecutor.patch(android.content.Context, com.meizu.savior.Patch):boolean");
    }

    public void run() {
        try {
            fetchPatch(new PatchManipulate.PatchFetchCallback() {
                public void onPatchFetched(Patch patch) {
                    if (patch.getPatchVerCode() > 0) {
                        SharedPreferences sharedPreferences = PatchExecutor.this.context.getSharedPreferences(PatchExecutor.this.context.getPackageName(), 0);
                        try {
                            PackageInfo packageInfo = PatchExecutor.this.context.getPackageManager().getPackageInfo(PatchExecutor.this.context.getPackageName(), 0);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString("patchVersion", packageInfo.versionCode + "_" + patch.getPatchVerCode()).apply();
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    PatchExecutor.this.applyPatch(patch);
                }
            });
        } catch (Throwable th) {
            Log.e("savior", "PatchExecutor run", th);
            this.saviorCallBack.exceptionNotify(th, "class:PatchExecutor,method:run,line:36");
        }
    }
}
