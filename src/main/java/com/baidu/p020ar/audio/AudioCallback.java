package com.baidu.p020ar.audio;

import java.nio.ByteBuffer;

/* renamed from: com.baidu.ar.audio.AudioCallback */
public interface AudioCallback {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioRelease();

    void onAudioSetup(boolean z);

    void onAudioStart(boolean z);

    void onAudioStop(boolean z);
}
