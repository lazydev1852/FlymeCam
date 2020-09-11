package com.baidu.p020ar.audio;

/* renamed from: com.baidu.ar.audio.IAudio */
public interface IAudio {
    void releaseAudio();

    void setVolumeListener(VolumeListener volumeListener);

    boolean setupAudio(AudioParams audioParams, AudioCallback audioCallback);

    void startAudio();

    void stopAudio();
}
