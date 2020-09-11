package com.mediatek.media.mediascanner;

import android.media.MediaFile;
import android.os.SystemProperties;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MediaFileExImpl extends MediaFileEx {
    private static final String ADD_FILE_TYPE = "addFileType";
    private static final int FILE_TYPE_3GA = 193;
    private static final int FILE_TYPE_3GPP3 = 199;
    private static final int FILE_TYPE_ADPCM = 113;
    private static final int FILE_TYPE_APE = 111;
    private static final int FILE_TYPE_CAF = 112;
    private static final int FILE_TYPE_FLA = 196;
    private static final int FILE_TYPE_FLV = 398;
    private static final int FILE_TYPE_MP2 = 197;
    private static final int FILE_TYPE_MP2PS = 393;
    private static final int FILE_TYPE_MP2TS = 308;
    private static final int FILE_TYPE_OGM = 394;
    private static final int FILE_TYPE_QUICKTIME_AUDIO = 194;
    private static final int FILE_TYPE_QUICKTIME_VIDEO = 397;
    private static final int FILE_TYPE_RA = 198;
    private static final String TAG = "MediaFileExImpl";
    private static Method sAddFileType = getMethod(MediaFile.class, ADD_FILE_TYPE, String.class, Integer.TYPE, String.class);
    private static Method sAddFileTypeMoreDetail = getMethod(MediaFile.class, ADD_FILE_TYPE, String.class, Integer.TYPE, String.class, Integer.TYPE, Boolean.TYPE);

    private static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "[getMethod]", e);
            return null;
        }
    }

    private static Object callMethodOnObject(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "[callMethodOnObject]", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "[callMethodOnObject]", e2);
            return null;
        }
    }

    public void addMoreVideoFileType() {
        callMethodOnObject((Object) null, sAddFileType, "MTS", Integer.valueOf(FILE_TYPE_MP2TS), "video/mp2ts");
        callMethodOnObject((Object) null, sAddFileType, "M2TS", Integer.valueOf(FILE_TYPE_MP2TS), "video/mp2ts");
        callMethodOnObject((Object) null, sAddFileType, "MOV", Integer.valueOf(FILE_TYPE_QUICKTIME_VIDEO), "video/quicktime");
        callMethodOnObject((Object) null, sAddFileType, "QT", Integer.valueOf(FILE_TYPE_QUICKTIME_VIDEO), "video/quicktime");
        callMethodOnObject((Object) null, sAddFileType, "OGV", Integer.valueOf(FILE_TYPE_OGM), "video/ogm");
        callMethodOnObject((Object) null, sAddFileType, "OGM", Integer.valueOf(FILE_TYPE_OGM), "video/ogm");
        if (SystemProperties.getBoolean("ro.mtk_flv_playback_support", false)) {
            callMethodOnObject((Object) null, sAddFileType, "FLV", Integer.valueOf(FILE_TYPE_FLV), "video/x-flv");
            callMethodOnObject((Object) null, sAddFileType, "F4V", Integer.valueOf(FILE_TYPE_FLV), "video/x-flv");
            callMethodOnObject((Object) null, sAddFileType, "PFV", Integer.valueOf(FILE_TYPE_FLV), "video/x-flv");
            callMethodOnObject((Object) null, sAddFileType, "FLA", Integer.valueOf(FILE_TYPE_FLA), "audio/x-flv");
        }
        if (SystemProperties.getBoolean("ro.mtk_mtkps_playback_support", false)) {
            callMethodOnObject((Object) null, sAddFileType, "PS", Integer.valueOf(FILE_TYPE_MP2PS), "video/mp2p");
            callMethodOnObject((Object) null, sAddFileType, "VOB", Integer.valueOf(FILE_TYPE_MP2PS), "video/mp2p");
            callMethodOnObject((Object) null, sAddFileType, "DAT", Integer.valueOf(FILE_TYPE_MP2PS), "video/mp2p");
        }
    }

    public void addMoreAudioFileType() {
        callMethodOnObject((Object) null, sAddFileType, "3GP", 199, "audio/3gpp");
        callMethodOnObject((Object) null, sAddFileType, "3GA", 193, "audio/3gpp");
        callMethodOnObject((Object) null, sAddFileType, "MOV", Integer.valueOf(FILE_TYPE_QUICKTIME_AUDIO), "audio/quicktime");
        callMethodOnObject((Object) null, sAddFileType, "QT", Integer.valueOf(FILE_TYPE_QUICKTIME_AUDIO), "audio/quicktime");
        if (SystemProperties.getBoolean("ro.mtk_audio_alac_support", false)) {
            callMethodOnObject((Object) null, sAddFileType, "CAF", 112, "audio/alac");
        }
        if (SystemProperties.getBoolean("ro.mtk_audio_alac_support", false)) {
            callMethodOnObject((Object) null, sAddFileType, "WAV", 113, "audio/adpcm");
        }
        callMethodOnObject((Object) null, sAddFileTypeMoreDetail, "WAV", 103, "audio/wav", 12296, true);
        callMethodOnObject((Object) null, sAddFileTypeMoreDetail, "OGG", 107, "audio/vorbis", 47362, true);
        callMethodOnObject((Object) null, sAddFileTypeMoreDetail, "OGG", 107, "audio/webm", 47362, true);
        if (SystemProperties.getBoolean("ro.mtk_support_mp2_playback", false)) {
            callMethodOnObject((Object) null, sAddFileType, "MP2", Integer.valueOf(FILE_TYPE_MP2), "audio/mpeg");
        }
        if (SystemProperties.getBoolean("ro.mtk_audio_ape_support", false)) {
            callMethodOnObject((Object) null, sAddFileType, "APE", 111, "audio/ape");
        }
        if (SystemProperties.getBoolean("ro.mtk_oma_drm_support", false)) {
            callMethodOnObject((Object) null, sAddFileType, "DCF", 101, "audio/mpeg");
        }
    }
}
