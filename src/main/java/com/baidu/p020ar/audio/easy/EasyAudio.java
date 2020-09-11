package com.baidu.p020ar.audio.easy;

import android.util.Log;
import com.baidu.p020ar.audio.AudioCallback;
import com.baidu.p020ar.audio.AudioController;
import com.baidu.p020ar.audio.AudioParams;
import com.baidu.p020ar.audio.VolumeListener;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.ar.audio.easy.EasyAudio */
public class EasyAudio implements AudioCallback, VolumeListener, IEasyAudio {
    private static final String TAG = "EasyAudio";
    private static volatile EasyAudio sInstance;
    private final Lock mAudioCallbackLock = new ReentrantLock(true);
    private AudioController mAudioController;
    private ArrayList<EasyAudioCallback> mCallbackList;
    private ArrayList<VolumeListener> mVolumeListenerList;
    private final Lock mVolumeListenerLock = new ReentrantLock(true);

    private EasyAudio() {
    }

    public static EasyAudio getInstance() {
        if (sInstance == null) {
            synchronized (EasyAudio.class) {
                if (sInstance == null) {
                    sInstance = new EasyAudio();
                }
            }
        }
        return sInstance;
    }

    private synchronized void releaseEasyAudio() {
        if (this.mCallbackList != null) {
            this.mCallbackList.clear();
        }
        this.mCallbackList = null;
        if (this.mVolumeListenerList != null) {
            this.mVolumeListenerList.clear();
        }
        this.mVolumeListenerList = null;
        releaseInstance();
    }

    private static void releaseInstance() {
        sInstance = null;
    }

    private synchronized void stopAndReleaseAudioController() {
        if (this.mAudioController != null) {
            this.mAudioController.stopAudio();
            this.mAudioController.releaseAudio();
            this.mAudioController = null;
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        this.mAudioCallbackLock.lock();
        try {
            if (this.mCallbackList != null) {
                Iterator<EasyAudioCallback> it = this.mCallbackList.iterator();
                while (it.hasNext()) {
                    it.next().onAudioFrameAvailable(byteBuffer, i, j);
                }
            }
        } finally {
            this.mAudioCallbackLock.unlock();
        }
    }

    public void onAudioRelease() {
        releaseEasyAudio();
    }

    public void onAudioSetup(boolean z) {
        if (z) {
            if (this.mAudioController != null) {
                this.mAudioController.startAudio();
            }
        } else if (this.mCallbackList != null && this.mCallbackList.get(0) != null) {
            this.mCallbackList.get(0).onAudioStart(false, (AudioParams) null);
            release();
        }
    }

    public void onAudioStart(boolean z) {
        if (!(this.mCallbackList == null || this.mCallbackList.get(0) == null || this.mAudioController == null)) {
            this.mCallbackList.get(0).onAudioStart(z, this.mAudioController.getAudioParams());
        }
        if (!z) {
            release();
        }
    }

    public void onAudioStop(boolean z) {
        if (this.mCallbackList != null && this.mCallbackList.get(0) != null) {
            this.mCallbackList.get(0).onAudioStop(z);
        }
    }

    public void onRealtimeVolume(int i) {
        this.mVolumeListenerLock.lock();
        try {
            if (this.mVolumeListenerList != null) {
                Iterator<VolumeListener> it = this.mVolumeListenerList.iterator();
                while (it.hasNext()) {
                    it.next().onRealtimeVolume(i);
                }
            }
        } finally {
            this.mVolumeListenerLock.unlock();
        }
    }

    public void release() {
        stopAndReleaseAudioController();
        releaseEasyAudio();
    }

    public void removeVolumeListener(VolumeListener volumeListener) {
        if (volumeListener == null) {
            Log.e(TAG, "VolumeListener can not be null!!!");
            return;
        }
        this.mVolumeListenerLock.lock();
        try {
            if (this.mVolumeListenerList != null && this.mVolumeListenerList.size() > 0 && this.mVolumeListenerList.contains(volumeListener)) {
                this.mVolumeListenerList.remove(volumeListener);
            }
        } finally {
            this.mVolumeListenerLock.unlock();
        }
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        String str;
        String str2;
        if (volumeListener == null) {
            str = TAG;
            str2 = "VolumeListener can not be null!!!";
        } else {
            if (this.mVolumeListenerList == null) {
                this.mVolumeListenerList = new ArrayList<>();
            }
            if (this.mVolumeListenerList.contains(volumeListener)) {
                str = TAG;
                str2 = "setVolumeListener volumeListener has been added!!!";
            } else {
                if (this.mAudioController == null) {
                    this.mAudioController = AudioController.getInstance();
                }
                this.mVolumeListenerLock.lock();
                try {
                    if (this.mVolumeListenerList.size() == 0) {
                        this.mAudioController.setVolumeListener(this);
                    }
                    this.mVolumeListenerList.add(volumeListener);
                    return;
                } finally {
                    this.mVolumeListenerLock.unlock();
                }
            }
        }
        Log.e(str, str2);
    }

    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        String str;
        String str2;
        if (audioParams == null || easyAudioCallback == null) {
            str = TAG;
            str2 = "AudioParams && EasyAudioCallback can not be null!!!";
        } else {
            if (this.mAudioController == null) {
                this.mAudioController = AudioController.getInstance();
            }
            if (this.mCallbackList == null) {
                this.mCallbackList = new ArrayList<>();
            }
            if (this.mCallbackList.contains(easyAudioCallback)) {
                str = TAG;
                str2 = "EasyAudio has been started!!!";
            } else {
                if (this.mAudioController.isRunning()) {
                    easyAudioCallback.onAudioStart(true, this.mAudioController.getAudioParams());
                } else {
                    this.mCallbackList.clear();
                    this.mAudioController.setupAudio(audioParams, this);
                }
                this.mAudioCallbackLock.lock();
                try {
                    this.mCallbackList.add(easyAudioCallback);
                    return;
                } finally {
                    this.mAudioCallbackLock.unlock();
                }
            }
        }
        Log.e(str, str2);
    }

    /* JADX INFO: finally extract failed */
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        if (easyAudioCallback == null) {
            Log.e(TAG, "EasyAudioCallback can not be null!!!");
        } else if (this.mCallbackList == null || !this.mCallbackList.contains(easyAudioCallback)) {
            Log.e(TAG, "Please confirm EasyAudio has been started!!!");
        } else if (this.mCallbackList.size() > 1) {
            this.mAudioCallbackLock.lock();
            try {
                boolean remove = this.mCallbackList.remove(easyAudioCallback);
                this.mAudioCallbackLock.unlock();
                easyAudioCallback.onAudioStop(remove);
            } catch (Throwable th) {
                this.mAudioCallbackLock.unlock();
                throw th;
            }
        } else {
            stopAndReleaseAudioController();
        }
    }
}
