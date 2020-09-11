package com.baidu.p020ar.cloud;

import android.content.Context;
import com.baidu.p020ar.cloud.C0759c;
import com.baidu.p020ar.util.ARLog;

/* renamed from: com.baidu.ar.cloud.CloudRecognitionManager */
public class CloudRecognitionManager implements C0759c.C0760a {
    private C0753a mCallback;
    private C0759c mCloudSearchController;
    private Context mContext;

    /* renamed from: com.baidu.ar.cloud.CloudRecognitionManager$a */
    public interface C0753a {
        /* renamed from: a */
        void mo10090a(int i, String str, String str2, String str3);
    }

    public void initCloudRecognition(Context context, C0753a aVar) {
        this.mContext = context.getApplicationContext();
        this.mCallback = aVar;
        if (this.mCloudSearchController == null) {
            this.mCloudSearchController = new C0759c();
        }
        this.mCloudSearchController.mo10103a((C0759c.C0760a) this);
    }

    public void onResourceRequest(C0758b bVar) {
        if (this.mCallback == null) {
            return;
        }
        if (bVar == null) {
            ARLog.m2696e("cloud recognition error");
        } else if (bVar.mo10100c() != null) {
            this.mCallback.mo10090a(bVar.mo10095a(), bVar.mo10099b(), bVar.mo10100c().mo10107a(), bVar.mo10100c().mo10109b());
        } else {
            this.mCallback.mo10090a(bVar.mo10095a(), bVar.mo10099b(), "", "");
        }
    }

    public void release() {
        if (this.mCloudSearchController != null) {
            this.mCloudSearchController.mo10101a();
            this.mCloudSearchController = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setYUVFile(byte[] r11, int r12, int r13) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00b8, all -> 0x00b3 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x00b8, all -> 0x00b3 }
            int r8 = r12 / 2
            int r9 = r13 / 2
            java.lang.Object r2 = r1.get()     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            byte[] r2 = (byte[]) r2     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            r3 = r8
            r4 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            byte[] r11 = com.baidu.p020ar.util.C0919Utils.cropYuv(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            int r2 = r8 * r9
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.lang.Object r2 = r3.get()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            int[] r2 = (int[]) r2     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            com.baidu.p020ar.util.C0919Utils.decodeYUV420SP(r2, r11, r12, r13)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.Object r11 = r3.get()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            int[] r11 = (int[]) r11     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            android.graphics.Bitmap$Config r12 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r11, r8, r9, r12)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.ref.WeakReference r12 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00a3 }
            r11.<init>()     // Catch:{ Exception -> 0x00a3 }
            java.lang.Object r13 = r12.get()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            if (r13 == 0) goto L_0x0057
            java.lang.Object r13 = r12.get()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            android.graphics.Bitmap r13 = (android.graphics.Bitmap) r13     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r2 = 100
            r13.compress(r0, r2, r11)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
        L_0x0057:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r13.<init>()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            android.content.Context r0 = r10.mContext     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            com.baidu.p020ar.task.HttpTaskUtility.addBasicInfo((android.content.Context) r0, (java.util.HashMap<java.lang.String, java.lang.String>) r13)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.lang.String r0 = "cuid"
            java.lang.String r2 = com.baidu.p020ar.bean.ARConfig.getCUID()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r13.put(r0, r2)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.lang.String r0 = "app_id"
            java.lang.String r2 = com.baidu.p020ar.util.ARFileUtils.getPackageName()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r13.put(r0, r2)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.lang.String r0 = com.baidu.p020ar.util.UrlUtils.getCloudRecgUrl()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            com.baidu.ar.cloud.c r2 = r10.mCloudSearchController     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            if (r2 == 0) goto L_0x0084
            com.baidu.ar.cloud.c r2 = r10.mCloudSearchController     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            byte[] r4 = r11.toByteArray()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r2.mo10104a(r0, r13, r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
        L_0x0084:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r11)
            java.lang.Object r11 = r12.get()
            if (r11 == 0) goto L_0x0099
            java.lang.Object r11 = r12.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            r11.recycle()
            r12.clear()
        L_0x0099:
            r1.clear()
            goto L_0x00dd
        L_0x009d:
            r13 = move-exception
            r0 = r11
            goto L_0x00e2
        L_0x00a0:
            r13 = move-exception
            r0 = r11
            goto L_0x00bc
        L_0x00a3:
            r13 = move-exception
            goto L_0x00bc
        L_0x00a5:
            r13 = move-exception
            r12 = r0
            goto L_0x00e2
        L_0x00a8:
            r13 = move-exception
            r12 = r0
            goto L_0x00bc
        L_0x00ab:
            r13 = move-exception
            r12 = r0
            r3 = r12
            goto L_0x00e2
        L_0x00af:
            r13 = move-exception
            r12 = r0
            r3 = r12
            goto L_0x00bc
        L_0x00b3:
            r13 = move-exception
            r12 = r0
            r1 = r12
            r3 = r1
            goto L_0x00e2
        L_0x00b8:
            r13 = move-exception
            r12 = r0
            r1 = r12
            r3 = r1
        L_0x00bc:
            r13.printStackTrace()     // Catch:{ all -> 0x00e1 }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            if (r12 == 0) goto L_0x00d6
            java.lang.Object r11 = r12.get()
            if (r11 == 0) goto L_0x00d6
            java.lang.Object r11 = r12.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            r11.recycle()
            r12.clear()
        L_0x00d6:
            if (r1 == 0) goto L_0x00db
            r1.clear()
        L_0x00db:
            if (r3 == 0) goto L_0x00e0
        L_0x00dd:
            r3.clear()
        L_0x00e0:
            return
        L_0x00e1:
            r13 = move-exception
        L_0x00e2:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            if (r12 == 0) goto L_0x00f9
            java.lang.Object r11 = r12.get()
            if (r11 == 0) goto L_0x00f9
            java.lang.Object r11 = r12.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            r11.recycle()
            r12.clear()
        L_0x00f9:
            if (r1 == 0) goto L_0x00fe
            r1.clear()
        L_0x00fe:
            if (r3 == 0) goto L_0x0103
            r3.clear()
        L_0x0103:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.cloud.CloudRecognitionManager.setYUVFile(byte[], int, int):void");
    }
}
