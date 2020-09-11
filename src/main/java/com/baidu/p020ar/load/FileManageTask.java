package com.baidu.p020ar.load;

import android.text.TextUtils;
import com.baidu.p020ar.load.util.C0789a;
import com.baidu.p020ar.load.util.ResponseUtil;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* renamed from: com.baidu.ar.load.FileManageTask */
public class FileManageTask extends ARAsyncTask<Object, Double, String> {
    public static final int STATUS_CANCEL = 3;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TIMEOUT = 2;
    private ExtraOperateListener mExtraOperateListener;
    private FileMergeStrategy mFileMergeStrategy = FileMergeStrategy.COVER;
    private boolean mIsPause = false;
    private ActionResponseListener<String> mListener;
    private String mOriginFilePath = null;
    private double mProgress = 0.0d;
    private long mProgressTime = 0;
    private String mTargetPath = null;
    private boolean mUseParallel = false;

    /* renamed from: com.baidu.ar.load.FileManageTask$ExtraOperateListener */
    public interface ExtraOperateListener {
        String excuteChangeResult(String str);
    }

    /* renamed from: com.baidu.ar.load.FileManageTask$FileMergeStrategy */
    public enum FileMergeStrategy {
        COVER,
        SKIP
    }

    public FileManageTask(String str, String str2, FileMergeStrategy fileMergeStrategy, ActionResponseListener<String> actionResponseListener, ExtraOperateListener extraOperateListener) {
        this.mOriginFilePath = str;
        this.mTargetPath = str2;
        this.mFileMergeStrategy = fileMergeStrategy;
        this.mListener = actionResponseListener;
        this.mExtraOperateListener = extraOperateListener;
    }

    private void checkPauseValid() {
        while (this.mIsPause) {
            ARLog.m2695d("mIsPause = " + this.mIsPause);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String executeExtraOperation(String str) {
        if (this.mExtraOperateListener == null) {
            return str;
        }
        String excuteChangeResult = this.mExtraOperateListener.excuteChangeResult(str);
        return !TextUtils.isEmpty(excuteChangeResult) ? excuteChangeResult : str;
    }

    private String manageFile() {
        String str;
        if (TextUtils.isEmpty(this.mOriginFilePath)) {
            str = "originFilePath is null!";
        } else if (TextUtils.isEmpty(this.mTargetPath)) {
            str = "targetPath is null!";
        } else {
            File file = new File(this.mOriginFilePath);
            if (!file.exists()) {
                str = "originFile not exist!";
            } else if (this.mOriginFilePath.length() <= 4) {
                str = "originFilePath is invalid for too short!";
            } else if (!file.isDirectory()) {
                return FileUtils.getFileExtention(this.mOriginFilePath).equals("zip") ? manageZipFile() : manageNormalFile();
            } else {
                str = "originFile should not be directory!";
            }
        }
        ARLog.m2696e(str);
        return null;
    }

    private String manageNormalFile() {
        try {
            File file = new File(this.mOriginFilePath);
            File file2 = new File(this.mTargetPath);
            if (file2.isDirectory()) {
                ARLog.m2696e("targetFile for normal should not be directory!");
                return null;
            } else if (file2.exists() && this.mFileMergeStrategy == FileMergeStrategy.SKIP) {
                return this.mTargetPath;
            } else {
                if (file.exists()) {
                    long length = file.length();
                    FileInputStream fileInputStream = new FileInputStream(this.mOriginFilePath);
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mTargetPath);
                    byte[] bArr = new byte[1024];
                    int i = 0;
                    do {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            i += read;
                            postProgress(((double) (((float) i) / ((float) length))) * 100.0d);
                            fileOutputStream.write(bArr, 0, read);
                            checkPauseValid();
                        } else {
                            fileInputStream.close();
                        }
                    } while (!isCancelled());
                    ARLog.m2695d("cancelled");
                    return null;
                }
                checkPauseValid();
                String executeExtraOperation = executeExtraOperation(this.mTargetPath);
                checkPauseValid();
                return executeExtraOperation;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ARLog.m2696e(e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:71:0x0130=Splitter:B:71:0x0130, B:77:0x0140=Splitter:B:77:0x0140} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String manageZipFile() {
        /*
            r18 = this;
            r7 = r18
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r7.mOriginFilePath
            r0.<init>(r1)
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r7.mTargetPath
            r1.<init>(r2)
            boolean r1 = r1.isFile()
            r8 = 0
            if (r1 == 0) goto L_0x001d
            java.lang.String r0 = "targetPath for unzip should be directory!"
        L_0x0019:
            com.baidu.p020ar.util.ARLog.m2696e(r0)
            return r8
        L_0x001d:
            java.lang.String r1 = r7.mOriginFilePath
            boolean r1 = com.baidu.p020ar.util.ZipUtils.isZipFile(r1)
            if (r1 != 0) goto L_0x0028
            java.lang.String r0 = "format error: not valid zip file!"
            goto L_0x0019
        L_0x0028:
            java.util.zip.ZipFile r9 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x013e, IOException -> 0x012e, all -> 0x012b }
            r9.<init>(r0)     // Catch:{ ZipException -> 0x013e, IOException -> 0x012e, all -> 0x012b }
            java.util.Enumeration r0 = r9.entries()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.util.Enumeration r1 = r9.entries()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r2 = 0
            r10 = r2
        L_0x0038:
            boolean r4 = r1.hasMoreElements()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r1.nextElement()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            long r4 = r4.getSize()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r6 = 0
            long r10 = r10 + r4
            goto L_0x0038
        L_0x004b:
            r12 = r2
        L_0x004c:
            boolean r1 = r0.hasMoreElements()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            if (r1 == 0) goto L_0x0113
            java.lang.Object r1 = r0.nextElement()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r2 = r1.getName()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = "../"
            boolean r2 = r2.contains(r3)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            if (r2 == 0) goto L_0x0065
            goto L_0x004c
        L_0x0065:
            boolean r2 = r1.isDirectory()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            if (r2 == 0) goto L_0x006c
            goto L_0x004c
        L_0x006c:
            java.io.File r14 = new java.io.File     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r2 = r7.mTargetPath     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = r1.getName()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r14.<init>(r2, r3)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.io.File r2 = r14.getParentFile()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            boolean r2 = r2.exists()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            if (r2 != 0) goto L_0x00b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r2.<init>()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = "file path = "
            r2.append(r3)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = r14.getAbsolutePath()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r2.append(r3)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = ", parent path = "
            r2.append(r3)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.io.File r3 = r14.getParentFile()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r2.append(r3)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r2 = r2.toString()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            com.baidu.p020ar.util.ARLog.m2695d(r2)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.io.File r2 = r14.getParentFile()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r2.mkdirs()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
        L_0x00b0:
            boolean r2 = r14.exists()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            if (r2 == 0) goto L_0x00bd
            com.baidu.ar.load.FileManageTask$FileMergeStrategy r2 = r7.mFileMergeStrategy     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            com.baidu.ar.load.FileManageTask$FileMergeStrategy r3 = com.baidu.p020ar.load.FileManageTask.FileMergeStrategy.SKIP     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            if (r2 != r3) goto L_0x00bd
            goto L_0x004c
        L_0x00bd:
            long r5 = r1.getSize()     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            java.io.InputStream r15 = r9.getInputStream(r1)     // Catch:{ IOException -> 0x00fd, all -> 0x00fa }
            com.baidu.ar.load.FileManageTask$1 r3 = new com.baidu.ar.load.FileManageTask$1     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            r1 = r3
            r2 = r18
            r8 = r3
            r3 = r12
            r16 = r12
            r12 = r5
            r5 = r10
            r1.<init>(r3, r5)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            com.baidu.p020ar.util.IoUtils.copyStream((java.io.InputStream) r15, (java.io.File) r14, (long) r12, (com.baidu.p020ar.util.IoUtils.ProgressListener) r8)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            r1 = 0
            long r12 = r16 + r12
            r18.checkPauseValid()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            boolean r1 = r18.isCancelled()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            if (r1 == 0) goto L_0x00ef
            java.lang.String r0 = "cancelled"
            com.baidu.p020ar.util.ARLog.m2695d(r0)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r15)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
        L_0x00ea:
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r9)
        L_0x00ed:
            r1 = 0
            return r1
        L_0x00ef:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r15)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            r8 = 0
            goto L_0x004c
        L_0x00f5:
            r0 = move-exception
            goto L_0x010f
        L_0x00f7:
            r0 = move-exception
            r8 = r15
            goto L_0x00ff
        L_0x00fa:
            r0 = move-exception
            r15 = 0
            goto L_0x010f
        L_0x00fd:
            r0 = move-exception
            r8 = 0
        L_0x00ff:
            r0.printStackTrace()     // Catch:{ all -> 0x010d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x010d }
            com.baidu.p020ar.util.ARLog.m2696e(r0)     // Catch:{ all -> 0x010d }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r8)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            goto L_0x00ea
        L_0x010d:
            r0 = move-exception
            r15 = r8
        L_0x010f:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r15)     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
            throw r0     // Catch:{ ZipException -> 0x0128, IOException -> 0x0125, all -> 0x0123 }
        L_0x0113:
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r9)
            r18.checkPauseValid()
            java.lang.String r0 = r7.mTargetPath
            java.lang.String r0 = r7.executeExtraOperation(r0)
            r18.checkPauseValid()
            return r0
        L_0x0123:
            r0 = move-exception
            goto L_0x014a
        L_0x0125:
            r0 = move-exception
            r8 = r9
            goto L_0x0130
        L_0x0128:
            r0 = move-exception
            r8 = r9
            goto L_0x0140
        L_0x012b:
            r0 = move-exception
            r9 = 0
            goto L_0x014a
        L_0x012e:
            r0 = move-exception
            r8 = 0
        L_0x0130:
            r0.printStackTrace()     // Catch:{ all -> 0x0148 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0148 }
        L_0x0137:
            com.baidu.p020ar.util.ARLog.m2696e(r0)     // Catch:{ all -> 0x0148 }
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r8)
            goto L_0x00ed
        L_0x013e:
            r0 = move-exception
            r8 = 0
        L_0x0140:
            r0.printStackTrace()     // Catch:{ all -> 0x0148 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0148 }
            goto L_0x0137
        L_0x0148:
            r0 = move-exception
            r9 = r8
        L_0x014a:
            com.baidu.p020ar.util.ZipUtils.closeZipFile(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.load.FileManageTask.manageZipFile():java.lang.String");
    }

    /* access modifiers changed from: private */
    public void postProgress(double d) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mProgressTime > 30 && d - this.mProgress >= 1.0d) {
            publishProgress(Double.valueOf(d));
            this.mProgressTime = currentTimeMillis;
            this.mProgress = d;
        }
    }

    public void cancel() {
        this.mIsPause = false;
        cancel(true);
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Object[] objArr) {
        return manageFile();
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(3, "file manage cancel!", (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onError(String str) {
        if (this.mListener != null) {
            ActionResponseListener<String> actionResponseListener = this.mListener;
            actionResponseListener.onResponse(ResponseUtil.getActionResponseInfo(1, "file manage task execute error:" + str, (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            onProgressUpdate(Double.valueOf(100.0d));
            if (this.mListener != null) {
                this.mListener.onResponse(ResponseUtil.getActionResponseInfo(0, str, (String) null));
            }
        } else if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "file manage result is null!", (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Double... dArr) {
        super.onProgressUpdate(dArr);
        if (dArr.length > 0 && this.mListener != null) {
            this.mListener.onProgress(dArr[0].intValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onTimeout() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(2, "file manage time out!", (String) null));
        }
    }

    public void pause() {
        this.mIsPause = true;
    }

    public void resume() {
        this.mIsPause = false;
    }

    public void setParallel() {
        this.mUseParallel = true;
    }

    public void start() {
        if (this.mUseParallel) {
            executeOnExecutor(C0789a.m2077b(), new Object[0]);
        } else {
            execute((PARAMS[]) new Object[0]);
        }
    }

    public void startDelay(long j) {
        postDelay(j, this.mUseParallel ? 1 : 0);
    }
}
