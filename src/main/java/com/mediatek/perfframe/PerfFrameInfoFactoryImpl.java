package com.mediatek.perfframe;

public class PerfFrameInfoFactoryImpl extends PerfFrameInfoFactory {
    public PerfFrameInfoManager makePerfFrameInfoManager() {
        return PerfFrameInfoManagerImpl.getInstance();
    }
}
