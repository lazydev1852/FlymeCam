package com.baidu.p020ar.load;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.load.util.ResponseUtil;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.util.ARLog;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.baidu.ar.load.QueryTask */
public class QueryTask extends ARAsyncTask<Object, Double, String> {
    public static final int REQUEST_MODE_GET = 0;
    public static final int REQUEST_MODE_POST = 1;
    public static final int STATUS_CANCEL = 3;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TIMEOUT = 2;
    private ExtraOperateListener mExtraOperateListener;
    private String mHttpParams = null;
    private boolean mIsPause = false;
    private ActionResponseListener<String> mListener;
    private int mRequestMode = 0;
    private String mUrl = null;
    private boolean mUseParallel = false;

    /* renamed from: com.baidu.ar.load.QueryTask$ExtraOperateListener */
    public interface ExtraOperateListener {
        String excuteChangeResult(String str);
    }

    public QueryTask(String str, String str2, int i, ActionResponseListener<String> actionResponseListener, ExtraOperateListener extraOperateListener) {
        this.mUrl = str;
        this.mHttpParams = str2;
        this.mRequestMode = i;
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

    private String doQuery() {
        String str;
        if (TextUtils.isEmpty(this.mUrl)) {
            str = "mUrl is null!";
        } else {
            String executeExtraOperation = executeExtraOperation(this.mHttpParams);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
                httpURLConnection.setConnectTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "application/json");
                if (this.mRequestMode == 0) {
                    httpURLConnection.setRequestMethod("GET");
                } else if (this.mRequestMode == 1) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    ARLog.m2695d("post params = " + executeExtraOperation);
                    dataOutputStream.write(executeExtraOperation.getBytes());
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                httpURLConnection.disconnect();
                checkPauseValid();
                return readLine;
            } catch (IOException e) {
                e.printStackTrace();
                str = "IOException: " + e.getMessage();
            }
        }
        ARLog.m2696e(str);
        return null;
    }

    private String executeExtraOperation(String str) {
        if (this.mExtraOperateListener == null) {
            return str;
        }
        String excuteChangeResult = this.mExtraOperateListener.excuteChangeResult(str);
        return !TextUtils.isEmpty(excuteChangeResult) ? excuteChangeResult : str;
    }

    public void cancel() {
        this.mIsPause = false;
        cancel(true);
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Object[] objArr) {
        if (TextUtils.isEmpty(this.mUrl)) {
            return null;
        }
        return doQuery();
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(3, "query cancel!", (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onError(String str) {
        if (this.mListener != null) {
            ActionResponseListener<String> actionResponseListener = this.mListener;
            actionResponseListener.onResponse(ResponseUtil.getActionResponseInfo(1, "query task execute error:" + str, (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            onProgressUpdate(Double.valueOf(100.0d));
            if (this.mListener != null) {
                this.mListener.onResponse(ResponseUtil.getActionResponseInfo(0, "query success!", str));
            }
        } else if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "query result is null!", (String) null));
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
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(2, "query time out!", (String) null));
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
