package com.meizu.cloud.pushsdk.networking.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meizu.cloud.pushsdk.networking.interfaces.DownloadProgressListener;
import com.meizu.cloud.pushsdk.networking.model.Progress;
import java.lang.ref.WeakReference;

public class DownloadProgressHandler extends Handler {
    private final WeakReference<DownloadProgressListener> mDownloadProgressListenerWeakRef;

    public DownloadProgressHandler(DownloadProgressListener downloadProgressListener) {
        super(Looper.getMainLooper());
        this.mDownloadProgressListenerWeakRef = new WeakReference<>(downloadProgressListener);
    }

    public void handleMessage(Message message) {
        DownloadProgressListener downloadProgressListener = (DownloadProgressListener) this.mDownloadProgressListenerWeakRef.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (downloadProgressListener != null) {
            Progress progress = (Progress) message.obj;
            downloadProgressListener.onProgress(progress.currentBytes, progress.totalBytes);
        }
    }
}
