package com.baidu.p020ar.load;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.p020ar.load.util.ResponseUtil;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.FileUtils;
import com.baidu.p020ar.util.HttpUtils;
import com.baidu.p020ar.util.IoUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.baidu.ar.load.DownloadTask */
public class DownloadTask extends ARAsyncTask<Object, Double, String> {
    public static final int STATUS_CANCEL = 3;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TIMEOUT = 2;
    private FileStoreStrategy mFileStoreStrategy = FileStoreStrategy.SKIP;
    private boolean mIsPause = false;
    private ActionResponseListener<String> mListener;
    private String mTargetPath = null;
    private String mUrl = null;
    private boolean mUseParallel = false;

    /* renamed from: com.baidu.ar.load.DownloadTask$FileStoreStrategy */
    public enum FileStoreStrategy {
        COVER,
        SKIP
    }

    public DownloadTask(String str, String str2, FileStoreStrategy fileStoreStrategy, ActionResponseListener<String> actionResponseListener) {
        this.mUrl = str;
        this.mTargetPath = str2;
        this.mFileStoreStrategy = fileStoreStrategy;
        this.mListener = actionResponseListener;
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

    private String doDownload() {
        BufferedInputStream bufferedInputStream;
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream2;
        if (TextUtils.isEmpty(this.mUrl)) {
            ARLog.m2696e("download url is null!");
            return null;
        } else if (TextUtils.isEmpty(this.mTargetPath)) {
            ARLog.m2696e("targetPath is null!");
            return null;
        } else {
            int length = HttpUtils.getLength(this.mUrl);
            ARLog.m2695d("download length = " + length);
            if (length <= 0) {
                ARLog.m2696e("download file totalSize is smaller than 0!");
                return null;
            }
            File file = new File(this.mTargetPath);
            if (file.exists()) {
                if (file.length() == ((long) length) && this.mFileStoreStrategy != FileStoreStrategy.COVER) {
                    return this.mTargetPath;
                }
                file.delete();
            }
            String str = this.mTargetPath + "tmp";
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            } else if (FileUtils.ensureDirectoryExist(file2.getParentFile())) {
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    ARLog.m2696e("create file error!");
                    return null;
                }
            } else {
                ARLog.m2696e("create file directory failed!");
                return null;
            }
            try {
                URLConnection openConnection = new URL(this.mUrl).openConnection();
                openConnection.setConnectTimeout(ComponentMessageType.MSG_TYPE_ON_SHAKE);
                openConnection.setRequestProperty("Range", "bytes=0-" + length);
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(0);
                    int i = 8192;
                    byte[] bArr = new byte[8192];
                    bufferedInputStream = new BufferedInputStream(openConnection.getInputStream(), 8192);
                    double d = 0.0d;
                    long j = 0;
                    int i2 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr, 0, i);
                            if (read != -1) {
                                ARLog.m2695d("one while read start n =" + read);
                                randomAccessFile.write(bArr, 0, read);
                                i2 += read;
                                double d2 = ((double) (((float) i2) / ((float) length))) * 100.0d;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - j > 30 && d2 - d >= 1.0d) {
                                    publishProgress(Double.valueOf(d2));
                                    d = d2;
                                    j = currentTimeMillis;
                                }
                                ARLog.m2695d("one while read end count = " + i2);
                                checkPauseValid();
                                if (isCancelled()) {
                                    ARLog.m2695d("cancelled");
                                    IoUtils.closeQuietly(bufferedInputStream);
                                    IoUtils.closeQuietly(randomAccessFile);
                                    return null;
                                }
                                i = 8192;
                            } else {
                                IoUtils.closeQuietly(bufferedInputStream);
                                IoUtils.closeQuietly(randomAccessFile);
                                try {
                                    file2.renameTo(new File(this.mTargetPath));
                                    checkPauseValid();
                                    return this.mTargetPath;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    ARLog.m2696e("temp file rename error!");
                                    return null;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            bufferedInputStream2 = bufferedInputStream;
                            try {
                                e.printStackTrace();
                                ARLog.m2696e(e.getMessage());
                                IoUtils.closeQuietly(bufferedInputStream2);
                                IoUtils.closeQuietly(randomAccessFile);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                IoUtils.closeQuietly(bufferedInputStream);
                                IoUtils.closeQuietly(randomAccessFile);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            IoUtils.closeQuietly(bufferedInputStream);
                            IoUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    bufferedInputStream2 = null;
                    e.printStackTrace();
                    ARLog.m2696e(e.getMessage());
                    IoUtils.closeQuietly(bufferedInputStream2);
                    IoUtils.closeQuietly(randomAccessFile);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                    IoUtils.closeQuietly(bufferedInputStream);
                    IoUtils.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedInputStream2 = null;
                randomAccessFile = null;
                e.printStackTrace();
                ARLog.m2696e(e.getMessage());
                IoUtils.closeQuietly(bufferedInputStream2);
                IoUtils.closeQuietly(randomAccessFile);
                return null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                bufferedInputStream = null;
                IoUtils.closeQuietly(bufferedInputStream);
                IoUtils.closeQuietly(randomAccessFile);
                throw th;
            }
        }
    }

    public void cancel() {
        this.mIsPause = false;
        cancel(true);
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Object[] objArr) {
        return doDownload();
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(3, "download cancel!", (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onError(String str) {
        if (this.mListener != null) {
            ActionResponseListener<String> actionResponseListener = this.mListener;
            actionResponseListener.onResponse(ResponseUtil.getActionResponseInfo(1, "download task execute error:" + str, (String) null));
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
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "download result is null!", (String) null));
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
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(2, "download time out!", (String) null));
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
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } else {
            execute((PARAMS[]) new Object[0]);
        }
    }

    public void startDelay(long j) {
        postDelay(j, this.mUseParallel ? 1 : 0);
    }
}
