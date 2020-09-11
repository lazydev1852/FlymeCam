package com.mediatek.view.impl;

import com.mediatek.view.SurfaceExt;
import com.mediatek.view.SurfaceFactory;

public class SurfaceFactoryImpl extends SurfaceFactory {
    public SurfaceExt getSurfaceExt() {
        return new SurfaceExtimpl();
    }
}
