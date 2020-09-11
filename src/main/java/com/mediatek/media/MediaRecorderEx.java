package com.mediatek.media;

import android.media.MediaRecorder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MediaRecorderEx {
    private static final String CLASS_NAME = "android.media.MediaRecorder";
    private static final String METHOD_NAME = "setParameter";
    private static final Class[] METHOD_TYPES = {String.class};
    private static final String TAG = "MediaRecorderEx";
    private static Method sSetParameter;

    static {
        try {
            sSetParameter = Class.forName(CLASS_NAME).getDeclaredMethod(METHOD_NAME, METHOD_TYPES);
            if (sSetParameter != null) {
                sSetParameter.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.e("@M_MediaRecorderEx", "NoSuchMethodException: setParameter");
        } catch (ClassNotFoundException unused2) {
            Log.e("@M_MediaRecorderEx", "ClassNotFoundException: android.media.MediaRecorder");
        }
    }

    private static void setParameter(MediaRecorder mediaRecorder, String str) {
        if (sSetParameter != null) {
            try {
                sSetParameter.invoke(mediaRecorder, new Object[]{str});
            } catch (IllegalAccessException e) {
                Log.e("@M_MediaRecorderEx", "IllegalAccessException!", e);
            } catch (InvocationTargetException e2) {
                Log.e("@M_MediaRecorderEx", "InvocationTargetException!", e2);
            } catch (IllegalArgumentException e3) {
                Log.e("@M_MediaRecorderEx", "IllegalArgumentException!", e3);
            } catch (NullPointerException e4) {
                Log.e("@M_MediaRecorderEx", "NullPointerException!", e4);
            }
        } else {
            Log.e("@M_MediaRecorderEx", "setParameter: Null method!");
        }
    }

    public static void pause(MediaRecorder mediaRecorder) throws IllegalStateException {
        if (mediaRecorder == null) {
            Log.e("@M_MediaRecorderEx", "Null MediaRecorder!");
        } else {
            mediaRecorder.setParametersExtra("media-param-pause=1");
        }
    }

    public final class HDRecordMode {
        public static final int INDOOR = 1;
        public static final int NORMAL = 0;
        public static final int OUTDOOR = 2;

        private HDRecordMode() {
        }
    }

    public static void setHDRecordMode(MediaRecorder mediaRecorder, int i, boolean z) throws IllegalStateException, IllegalArgumentException {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Illegal HDRecord mode:" + i);
        } else if (z) {
            setParameter(mediaRecorder, "audio-param-hdrecvideomode=" + i);
        } else {
            setParameter(mediaRecorder, "audio-param-hdrecvoicemode=" + i);
        }
    }

    public static void setArtistTag(MediaRecorder mediaRecorder, String str) throws IllegalStateException {
        setParameter(mediaRecorder, "media-param-tag-artist=" + str);
    }

    public static void setAlbumTag(MediaRecorder mediaRecorder, String str) throws IllegalStateException {
        setParameter(mediaRecorder, "media-param-tag-album=" + str);
    }

    public static void setPreprocessEffect(MediaRecorder mediaRecorder, int i) throws IllegalStateException {
        setParameter(mediaRecorder, "audio-param-preprocesseffect=" + i);
    }

    public static void setVideoBitOffSet(MediaRecorder mediaRecorder, int i, boolean z) {
        if (z) {
            setParameter(mediaRecorder, "param-use-64bit-offset=" + i);
            Log.v("@M_MediaRecorderEx", "setVideoBitOffSet is true,offset= " + i);
        }
    }

    public static void setLivePhotoTag(MediaRecorder mediaRecorder, int i) {
        mediaRecorder.setParametersExtra("media-param-tag-livephoto=" + i);
    }

    public static void startLivePhotoMode(MediaRecorder mediaRecorder) {
        mediaRecorder.setParametersExtra("media-param-livephoto=1");
    }

    public static void stopLivePhotoMode(MediaRecorder mediaRecorder) {
        mediaRecorder.setParametersExtra("media-param-capture-livephoto=1");
    }
}
