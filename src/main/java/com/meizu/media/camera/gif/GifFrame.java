package com.meizu.media.camera.gif;

import android.graphics.Bitmap;

/* renamed from: com.meizu.media.camera.gif.b */
public class GifFrame {

    /* renamed from: a */
    public Bitmap f10245a;

    /* renamed from: b */
    public int f10246b;

    public GifFrame(Bitmap bitmap, int i) {
        this.f10245a = bitmap;
        this.f10246b = i >= 20 ? i : 20;
    }
}
