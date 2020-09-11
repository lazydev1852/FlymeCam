package com.baidu.p020ar.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import java.io.File;

/* renamed from: com.baidu.ar.util.MediaUtils */
public class MediaUtils {
    public static Bitmap getFrameAtTime(String str, long j, int i) {
        if (str == null) {
            return null;
        }
        try {
            if (!new File(str).exists()) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, i);
            Log.d("bdar", "get first Frame of video spendTime is " + (System.currentTimeMillis() - currentTimeMillis));
            return frameAtTime;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
