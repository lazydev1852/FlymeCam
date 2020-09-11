package com.mediatek.media.mediascanner;

import android.graphics.BitmapFactory;

public class ThumbnailUtilsExImpl extends ThumbnailUtilsEx {
    public void correctOptions(String str, BitmapFactory.Options options) {
        if (str.endsWith(".dcf")) {
            options.inSampleSize |= 256;
        }
    }
}
