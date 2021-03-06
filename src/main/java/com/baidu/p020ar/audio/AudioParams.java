package com.baidu.p020ar.audio;

/* renamed from: com.baidu.ar.audio.AudioParams */
public class AudioParams {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 20480;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 1;
    public static final int DEFAULT_BUFFER_FRAME_COUNT = 32;
    public static final int DEFAULT_CHANNEL_CONFIG = 16;
    public static final int DEFAULT_FRAME_SIZE = 640;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    public static final int SAMPLES_PER_FRAME = 1024;
    private int mAudioBufferSize = DEFAULT_AUDIO_BUFFER_SIZE;
    private int mAudioFormat = 2;
    private int mAudioSource = 1;
    private int mChannelConfig = 16;
    private int mFrameBufferCount = 32;
    private int mFrameSize = DEFAULT_FRAME_SIZE;
    private int mSampleRate = DEFAULT_SAMPLE_RATE;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AudioParams)) {
            return false;
        }
        AudioParams audioParams = (AudioParams) obj;
        return this.mAudioSource == audioParams.mAudioSource && this.mSampleRate == audioParams.getSampleRate() && this.mChannelConfig == audioParams.getChannelConfig() && this.mAudioFormat == audioParams.getAudioFormat() && this.mFrameSize == audioParams.getFrameSize();
    }

    public int getAudioBufferSize() {
        return this.mAudioBufferSize;
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    public int getFrameBufferCount() {
        return this.mFrameBufferCount;
    }

    public int getFrameSize() {
        return this.mFrameSize;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int hashCode() {
        return ((((((((this.mAudioSource + 31) * 31) + this.mSampleRate) * 31) + this.mChannelConfig) * 31) + this.mAudioFormat) * 31) + this.mFrameSize;
    }

    public void setAudioBufferSize(int i) {
        this.mAudioBufferSize = i;
    }

    public void setAudioFormat(int i) {
        this.mAudioFormat = i;
    }

    public void setAudioSource(int i) {
        this.mAudioSource = i;
    }

    public void setChannelConfig(int i) {
        this.mChannelConfig = i;
    }

    public void setFrameBufferCount(int i) {
        this.mFrameBufferCount = i;
    }

    public void setFrameSize(int i) {
        this.mFrameSize = i;
    }

    public void setSampleRate(int i) {
        this.mSampleRate = i;
    }
}
