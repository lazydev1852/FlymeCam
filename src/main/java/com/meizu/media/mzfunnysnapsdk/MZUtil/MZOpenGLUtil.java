package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.Log;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MZOpenGLUtil {
    private static final String TAG = "MZOpenGLUtil";
    public static ChangeQuickRedirect changeQuickRedirect;

    public static boolean detectOpenGLES20(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, changeQuickRedirect, true, 9221, new Class[]{Context.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072) {
            return true;
        }
        return false;
    }

    public static int createTextureID() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9222, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        if (!GLES20.glIsTexture(iArr[0])) {
            GLES20.glGenTextures(1, iArr, 0);
        }
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static String loadAssetsString(Resources resources, String str) {
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{resources, str}, (Object) null, changeQuickRedirect2, true, 9223, new Class[]{Resources.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resources.getAssets().open(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return sb.toString();
                    }
                    sb.append(readLine);
                    sb.append(10);
                } catch (IOException unused) {
                    return null;
                }
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public static int loadShader(int i, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), str}, (Object) null, changeQuickRedirect, true, 9224, new Class[]{Integer.TYPE, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        String str2 = TAG;
        Log.e(str2, "Could not compile shader " + i + SystemInfoUtil.COLON);
        Log.e(TAG, GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, changeQuickRedirect, true, 9225, new Class[]{String.class, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            return glCreateProgram;
        }
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, loadShader);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e(TAG, "Could not link program");
        Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static void checkGlError(String str) {
        int glGetError;
        if (!PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 9226, new Class[]{String.class}, Void.TYPE).isSupported && (glGetError = GLES20.glGetError()) != 0) {
            String str2 = TAG;
            Log.e(str2, str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }
}
