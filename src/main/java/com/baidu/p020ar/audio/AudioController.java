package com.baidu.p020ar.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;

/* renamed from: com.baidu.ar.audio.AudioController */
public class AudioController implements IAudio, C0601c {
    private static final String AUDIO_THREAD_NAME = "AudioHandlerThread";
    private static final String TAG = "AudioController";
    private static volatile AudioController sInstance;
    private C0599a mAudioEngine;
    private Handler mAudioHandler;
    private HandlerThread mAudioThread;

    /* renamed from: com.baidu.ar.audio.AudioController$a */
    private static class C0598a extends Handler {

        /* renamed from: a */
        private C0601c f957a;

        public C0598a(Looper looper, C0601c cVar) {
            super(looper);
            this.f957a = cVar;
        }

        public void handleMessage(Message message) {
            if (this.f957a != null) {
                this.f957a.handleMessage(message);
            }
        }
    }

    private AudioController() {
    }

    public static AudioController getInstance() {
        if (sInstance == null) {
            synchronized (AudioController.class) {
                if (sInstance == null) {
                    sInstance = new AudioController();
                }
            }
        }
        return sInstance;
    }

    private void handleQuit() {
        this.mAudioThread.getLooper().quit();
        this.mAudioThread = null;
        this.mAudioHandler = null;
        releaseInstance();
    }

    private void handleReleaseAudioEngine() {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.mo9469c();
        }
        this.mAudioEngine = null;
    }

    private void handleSetupAudioEngine(AudioParams audioParams) {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.mo9466a(audioParams);
        }
    }

    private void handleStartAudioEngine() {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.mo9464a();
        }
    }

    private void handleStopAudioEngine() {
        if (this.mAudioEngine != null) {
            this.mAudioEngine.mo9468b();
        }
    }

    private static void releaseInstance() {
        sInstance = null;
    }

    private void startAudioThread() {
        this.mAudioThread = new HandlerThread(AUDIO_THREAD_NAME);
        this.mAudioThread.start();
        this.mAudioHandler = new C0598a(this.mAudioThread.getLooper(), this);
    }

    public AudioParams getAudioParams() {
        if (this.mAudioEngine != null) {
            return this.mAudioEngine.mo9470d();
        }
        return null;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                handleSetupAudioEngine((AudioParams) message.obj);
                return;
            case 1002:
                handleStartAudioEngine();
                return;
            case 1003:
                handleStopAudioEngine();
                return;
            case 1004:
                handleReleaseAudioEngine();
                return;
            case ARPMessageType.MSG_TYPE_RESUME_MUSIC:
                handleQuit();
                return;
            default:
                return;
        }
    }

    public boolean hasPermission(Context context) {
        return C0600b.m1212a(context);
    }

    public boolean isRunning() {
        return this.mAudioThread != null && this.mAudioThread.isAlive();
    }

    public void releaseAudio() {
        if (this.mAudioHandler != null) {
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1004));
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(ARPMessageType.MSG_TYPE_RESUME_MUSIC));
        }
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.mAudioEngine == null) {
                this.mAudioEngine = new C0599a();
            }
            this.mAudioEngine.mo9467a(volumeListener);
        }
    }

    public boolean setupAudio(AudioParams audioParams, AudioCallback audioCallback) {
        if (isRunning()) {
            Log.e(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.mAudioEngine == null) {
            this.mAudioEngine = new C0599a();
        }
        this.mAudioEngine.mo9465a(audioCallback);
        startAudioThread();
        this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1001, audioParams));
        return true;
    }

    public void startAudio() {
        if (this.mAudioHandler != null) {
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1002));
        }
    }

    public void stopAudio() {
        handleStopAudioEngine();
    }
}
