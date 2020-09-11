package com.baidu.p020ar.load.downloader;

/* renamed from: com.baidu.ar.load.downloader.IDownloadParamsParser */
public interface IDownloadParamsParser {

    /* renamed from: com.baidu.ar.load.downloader.IDownloadParamsParser$DownloadParam */
    public static class DownloadParam {
        public static final int STATUS_ERROR = 100;
        public static final int STATUS_OK = 0;
        public String mDownloadPath;
        public String mDownloadUrl;
        public int mErrorCode;
        public String mFileManagePath;
    }

    DownloadParam parser(String str);
}
