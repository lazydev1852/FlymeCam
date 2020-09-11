package com.baidu.p020ar.audio.easy;

import com.baidu.p020ar.audio.AudioParams;
import java.nio.ByteBuffer;

/* renamed from: com.baidu.ar.audio.easy.EasyAudioCallback */
public interface EasyAudioCallback {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioStart(boolean z, AudioParams audioParams);

    void onAudioStop(boolean z);
}
