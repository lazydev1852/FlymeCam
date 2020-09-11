package com.baidu.p020ar.load.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.p020ar.load.DownloadTask;
import com.baidu.p020ar.load.FileManageTask;
import com.baidu.p020ar.load.QueryTask;
import com.baidu.p020ar.load.downloader.DownloadController;
import com.baidu.p020ar.load.util.DownloadConstants;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.MD5Utils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.ar.load.downloader.DownloadManager */
public class DownloadManager {
    private static volatile DownloadManager sInstance;
    private boolean mActivityResumed = false;
    Map<String, DownloadController> mDownloadControllerMap = new HashMap();

    private DownloadManager() {
    }

    public static DownloadManager getInstance() {
        if (sInstance == null) {
            synchronized (DownloadManager.class) {
                if (sInstance == null) {
                    sInstance = new DownloadManager();
                }
            }
        }
        return sInstance;
    }

    public static void releaseInstance() {
        synchronized (DownloadManager.class) {
            sInstance = null;
        }
    }

    private void setDownloadControllerMapResumed(boolean z) {
        for (DownloadController a : this.mDownloadControllerMap.values()) {
            a.mo10201a(this.mActivityResumed);
        }
    }

    public void cancel(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = str + "_main";
        } else {
            str3 = str + "_" + str2;
        }
        DownloadController downloadController = this.mDownloadControllerMap.get(MD5Utils.md5(str3));
        if (downloadController != null) {
            downloadController.mo10210e();
        }
    }

    public void cancel(String str, String str2, ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = str + "_main";
        } else {
            str3 = str + "_" + str2;
        }
        DownloadController downloadController = this.mDownloadControllerMap.get(MD5Utils.md5(str3));
        if (downloadController != null) {
            downloadController.mo10199a(actionResponseListener, actionResponseListener2, actionResponseListener3);
        }
    }

    public void cancelAll() {
        for (DownloadController d : this.mDownloadControllerMap.values()) {
            d.mo10209d();
        }
        this.mDownloadControllerMap.clear();
        releaseInstance();
    }

    public void doQuery(String str, String str2, Bundle bundle, QueryTask.ExtraOperateListener extraOperateListener, ActionResponseListener<String> actionResponseListener) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            ARLog.m2696e("arkey cannot be null!!!");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = str + "_main";
        } else {
            str3 = str + "_" + str2;
        }
        String md5 = MD5Utils.md5(str3);
        DownloadController downloadController = this.mDownloadControllerMap.get(md5);
        if (downloadController != null) {
            if (downloadController.mo10202a()) {
                downloadController.mo10205b(actionResponseListener, (ActionResponseListener<String>) null, (ActionResponseListener<String>) null);
                return;
            }
            this.mDownloadControllerMap.remove(md5);
        }
        DownloadController downloadController2 = new DownloadController();
        downloadController2.mo10201a(this.mActivityResumed);
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadConstants.QUERY_INFO, bundle);
        hashMap.put(DownloadConstants.QUERY_EXTRA_OPERATOR, extraOperateListener);
        hashMap.put(DownloadConstants.DOWNLOAD_SAVE_PATH, "");
        hashMap.put(DownloadConstants.FILE_STORE_STRATEGY, DownloadTask.FileStoreStrategy.SKIP);
        hashMap.put(DownloadConstants.USE_PARALLEL, false);
        hashMap.put(DownloadConstants.TARGET_PATH, "");
        hashMap.put(DownloadConstants.FILE_MERGE_STRATEGY, FileManageTask.FileMergeStrategy.SKIP);
        hashMap.put(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR, (Object) null);
        hashMap.put(DownloadConstants.QUERY_CALLBACK, actionResponseListener);
        hashMap.put(DownloadConstants.DOWNLOAD_CALLBACK, (Object) null);
        hashMap.put(DownloadConstants.FILE_MANAGE_CALLBACK, (Object) null);
        hashMap.put(DownloadConstants.DOWNLOAD_PARAMS_PARSER, (Object) null);
        downloadController2.mo10198a(DownloadController.EVENT.START_QUERY, (Map<String, Object>) hashMap);
        this.mDownloadControllerMap.put(md5, downloadController2);
    }

    public void downloadRes(String str, String str2, Bundle bundle, QueryTask.ExtraOperateListener extraOperateListener, IDownloadParamsParser iDownloadParamsParser, String str3, DownloadTask.FileStoreStrategy fileStoreStrategy, String str4, boolean z, FileManageTask.FileMergeStrategy fileMergeStrategy, FileManageTask.ExtraOperateListener extraOperateListener2, ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        StringBuilder sb;
        String str5;
        String str6 = str;
        ActionResponseListener<String> actionResponseListener4 = actionResponseListener;
        ActionResponseListener<String> actionResponseListener5 = actionResponseListener2;
        ActionResponseListener<String> actionResponseListener6 = actionResponseListener3;
        if (TextUtils.isEmpty(str)) {
            ARLog.m2696e("arkey cannot be null!!!");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
            sb.append(str);
            str5 = "_main";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            str5 = str2;
        }
        sb.append(str5);
        String md5 = MD5Utils.md5(sb.toString());
        DownloadController downloadController = this.mDownloadControllerMap.get(md5);
        if (downloadController != null) {
            if (downloadController.mo10202a()) {
                downloadController.mo10205b(actionResponseListener4, actionResponseListener5, actionResponseListener6);
                return;
            }
            this.mDownloadControllerMap.remove(md5);
        }
        DownloadController downloadController2 = new DownloadController();
        downloadController2.mo10201a(this.mActivityResumed);
        HashMap hashMap = new HashMap();
        Bundle bundle2 = bundle;
        hashMap.put(DownloadConstants.QUERY_INFO, bundle);
        QueryTask.ExtraOperateListener extraOperateListener3 = extraOperateListener;
        hashMap.put(DownloadConstants.QUERY_EXTRA_OPERATOR, extraOperateListener);
        String str7 = str3;
        hashMap.put(DownloadConstants.DOWNLOAD_SAVE_PATH, str3);
        hashMap.put(DownloadConstants.FILE_STORE_STRATEGY, fileStoreStrategy);
        hashMap.put(DownloadConstants.USE_PARALLEL, Boolean.valueOf(z));
        hashMap.put(DownloadConstants.TARGET_PATH, str4);
        hashMap.put(DownloadConstants.FILE_MERGE_STRATEGY, fileMergeStrategy);
        hashMap.put(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR, extraOperateListener2);
        hashMap.put(DownloadConstants.QUERY_CALLBACK, actionResponseListener4);
        hashMap.put(DownloadConstants.DOWNLOAD_CALLBACK, actionResponseListener5);
        hashMap.put(DownloadConstants.FILE_MANAGE_CALLBACK, actionResponseListener6);
        IDownloadParamsParser iDownloadParamsParser2 = iDownloadParamsParser;
        hashMap.put(DownloadConstants.DOWNLOAD_PARAMS_PARSER, iDownloadParamsParser);
        downloadController2.mo10198a(DownloadController.EVENT.START_QUERY, (Map<String, Object>) hashMap);
        this.mDownloadControllerMap.put(md5, downloadController2);
    }

    public void downloadRes(String str, String str2, String str3, DownloadTask.FileStoreStrategy fileStoreStrategy, String str4, boolean z, FileManageTask.FileMergeStrategy fileMergeStrategy, FileManageTask.ExtraOperateListener extraOperateListener, ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2) {
        String str5;
        if (TextUtils.isEmpty(str2)) {
            ARLog.m2696e("arkey cannot be null!!!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str5 = MD5Utils.md5(str2);
        } else {
            str5 = MD5Utils.md5(str + "_" + str2);
        }
        DownloadController downloadController = this.mDownloadControllerMap.get(str5);
        if (downloadController != null) {
            if (downloadController.mo10202a()) {
                downloadController.mo10205b((ActionResponseListener<String>) null, actionResponseListener, actionResponseListener2);
                return;
            }
            this.mDownloadControllerMap.remove(str5);
        }
        DownloadController downloadController2 = new DownloadController();
        downloadController2.mo10201a(this.mActivityResumed);
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadConstants.DOWNLOAD_URL, str2);
        hashMap.put(DownloadConstants.DOWNLOAD_SAVE_PATH, str3);
        hashMap.put(DownloadConstants.FILE_STORE_STRATEGY, fileStoreStrategy);
        hashMap.put(DownloadConstants.TARGET_PATH, str4);
        hashMap.put(DownloadConstants.USE_PARALLEL, Boolean.valueOf(z));
        hashMap.put(DownloadConstants.FILE_MERGE_STRATEGY, fileMergeStrategy);
        hashMap.put(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR, extraOperateListener);
        hashMap.put(DownloadConstants.DOWNLOAD_CALLBACK, actionResponseListener);
        hashMap.put(DownloadConstants.FILE_MANAGE_CALLBACK, actionResponseListener2);
        downloadController2.mo10198a(DownloadController.EVENT.START_DOWNLOAD, (Map<String, Object>) hashMap);
        this.mDownloadControllerMap.put(str5, downloadController2);
    }

    public void onActivityPaused() {
        this.mActivityResumed = false;
        setDownloadControllerMapResumed(false);
    }

    public void onActivityResumed() {
        this.mActivityResumed = true;
        setDownloadControllerMapResumed(true);
    }

    public void pause(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = str + "_main";
        } else {
            str3 = str + "_" + str2;
        }
        DownloadController downloadController = this.mDownloadControllerMap.get(MD5Utils.md5(str3));
        if (downloadController != null) {
            downloadController.mo10207c();
        }
    }

    public void pauseAll() {
        for (DownloadController c : this.mDownloadControllerMap.values()) {
            c.mo10207c();
        }
    }

    public void resume(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = str + "_main";
        } else {
            str3 = str + "_" + str2;
        }
        DownloadController downloadController = this.mDownloadControllerMap.get(MD5Utils.md5(str3));
        if (downloadController != null) {
            downloadController.mo10203b();
        }
    }

    public void resumeAll() {
        for (DownloadController b : this.mDownloadControllerMap.values()) {
            b.mo10203b();
        }
    }
}
