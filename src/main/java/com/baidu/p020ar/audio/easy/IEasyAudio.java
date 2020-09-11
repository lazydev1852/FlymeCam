package com.baidu.p020ar.audio.easy;

import com.baidu.p020ar.audio.AudioParams;
import com.baidu.p020ar.audio.VolumeListener;

/* renamed from: com.baidu.ar.audio.easy.IEasyAudio */
public interface IEasyAudio {
    void release();

    void removeVolumeListener(VolumeListener volumeListener);

    void setVolumeListener(VolumeListener volumeListener);

    void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback);

    void stopAudio(EasyAudioCallback easyAudioCallback);
}
