package com.baidu.p020ar.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.baidu.ar.util.SystemInfoUtil */
public class SystemInfoUtil {
    public static final String COLON = ":";
    public static final String COMMA = ",";
    public static final String LINE_END = "\r\n";

    /* renamed from: NA */
    public static final String f2381NA = "N/A";
    public static String log = "";
    public static String name = "";
    public static String value = "";

    /* renamed from: com.baidu.ar.util.SystemInfoUtil$a */
    class C0918a implements FileFilter {
        C0918a() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static boolean checkFlashFeature(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static List<String> getAllInfos(Context context, GL10 gl10) {
        log = "";
        name = "";
        value = "";
        long[] romMemroy = getRomMemroy();
        long sDCardTotalSize = getSDCardTotalSize();
        long sDAvailableSizeByM = getSDAvailableSizeByM();
        log += "基本信息：\n";
        getBaseInfo(context);
        log += "\n存储：\n";
        log += getLogStr("可用/内存大小", getAvailMemory(context) + "/" + getRamMemory(context) + "MB");
        log += getLogStr("可用/ROM存储", romMemroy[1] + "/" + romMemroy[0] + "MB");
        log += getLogStr("可用/SDCard存储", sDAvailableSizeByM + "/" + sDCardTotalSize + "MB");
        log += getLogStr("Heap Size", ((int) (Runtime.getRuntime().maxMemory() / 1048576)) + "MB");
        log += "\nCPU信息：\n";
        log += getLogStr("CPU名称", getCpuName());
        log += getLogStr("核心数", String.valueOf(getNumCores()));
        log += getLogStr("最低频率", getMinCpuFreq() + "MHz");
        log += getLogStr("最高频率", getMaxCpuFreq() + "MHz");
        log += getLogStr("当前频率", getCurCpuFreq() + "MHz");
        log += "\nGPU信息：\n";
        getGPUInfo(gl10);
        ArrayList arrayList = new ArrayList();
        arrayList.add(log);
        arrayList.add(name);
        arrayList.add(value);
        return arrayList;
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b A[SYNTHETIC, Splitter:B:25:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065 A[SYNTHETIC, Splitter:B:30:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x015b A[SYNTHETIC, Splitter:B:38:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0165 A[SYNTHETIC, Splitter:B:43:0x0165] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getBaseInfo(android.content.Context r7) {
        /*
            java.lang.String r0 = "null"
            java.lang.String r1 = "null"
            java.lang.String r2 = "null"
            java.lang.String r3 = "null"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3}
            java.lang.String r1 = "/proc/version"
            r2 = 2
            r3 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            java.lang.String r1 = "utf-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            r4.<init>(r5, r1)     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004e }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x0049, all -> 0x0045 }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ Exception -> 0x0049, all -> 0x0045 }
            r5 = 0
            r3 = r3[r2]     // Catch:{ Exception -> 0x0049, all -> 0x0045 }
            r0[r5] = r3     // Catch:{ Exception -> 0x0049, all -> 0x0045 }
            r1.close()     // Catch:{ Exception -> 0x0049, all -> 0x0045 }
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0041:
            r4.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0045:
            r7 = move-exception
            r3 = r1
            goto L_0x0159
        L_0x0049:
            r3 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x0056
        L_0x004e:
            r1 = move-exception
            goto L_0x0056
        L_0x0050:
            r7 = move-exception
            r4 = r3
            goto L_0x0159
        L_0x0054:
            r1 = move-exception
            r4 = r3
        L_0x0056:
            r1.printStackTrace()     // Catch:{ all -> 0x0158 }
            if (r3 == 0) goto L_0x0063
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0063:
            if (r4 == 0) goto L_0x006d
            r4.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r1 = move-exception
            r1.printStackTrace()
        L_0x006d:
            r1 = 1
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            r0[r1] = r3
            java.lang.String r1 = android.os.Build.MODEL
            r0[r2] = r1
            r1 = 3
            java.lang.String r2 = android.os.Build.DISPLAY
            r0[r1] = r2
            android.content.res.Resources r0 = r7.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            android.content.res.Resources r7 = r7.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r7 = r7.densityDpi
            float r7 = (float) r7
            java.lang.String r1 = ""
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = log
            r2.append(r3)
            java.lang.String r3 = "手机厂商"
            java.lang.String r4 = android.os.Build.BRAND
            java.lang.String r3 = getLogStr(r3, r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            log = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = log
            r2.append(r3)
            java.lang.String r3 = "手机型号"
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r3 = getLogStr(r3, r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            log = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = log
            r2.append(r3)
            java.lang.String r3 = "SDK版本"
            java.lang.String r4 = android.os.Build.VERSION.SDK
            java.lang.String r3 = getLogStr(r3, r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            log = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = log
            r2.append(r3)
            java.lang.String r3 = "系统版本"
            java.lang.String r4 = android.os.Build.VERSION.RELEASE
            java.lang.String r3 = getLogStr(r3, r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            log = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = log
            r2.append(r3)
            java.lang.String r3 = "屏幕分辨率"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r0.widthPixels
            r4.append(r5)
            java.lang.String r5 = "*"
            r4.append(r5)
            int r0 = r0.heightPixels
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r0 = getLogStr(r3, r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            log = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = log
            r0.append(r2)
            java.lang.String r2 = "屏幕密度"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r7 = "dpi"
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            java.lang.String r7 = getLogStr(r2, r7)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            log = r7
            return r1
        L_0x0158:
            r7 = move-exception
        L_0x0159:
            if (r3 == 0) goto L_0x0163
            r3.close()     // Catch:{ IOException -> 0x015f }
            goto L_0x0163
        L_0x015f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0163:
            if (r4 == 0) goto L_0x016d
            r4.close()     // Catch:{ IOException -> 0x0169 }
            goto L_0x016d
        L_0x0169:
            r0 = move-exception
            r0.printStackTrace()
        L_0x016d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.SystemInfoUtil.getBaseInfo(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[SYNTHETIC, Splitter:B:32:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005d A[SYNTHETIC, Splitter:B:37:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006d A[SYNTHETIC, Splitter:B:45:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0077 A[SYNTHETIC, Splitter:B:50:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCpuName() {
        /*
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.lang.String r3 = "/proc/cpuinfo"
            r2.<init>(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.lang.String r3 = "utf-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0045, all -> 0x0040 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0045, all -> 0x0040 }
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = ":\\s+"
            r5 = 2
            java.lang.String[] r3 = r3.split(r4, r5)     // Catch:{ Exception -> 0x003e }
            r4 = 0
        L_0x0024:
            int r5 = r3.length     // Catch:{ Exception -> 0x003e }
            if (r4 >= r5) goto L_0x002a
            int r4 = r4 + 1
            goto L_0x0024
        L_0x002a:
            r4 = 1
            r3 = r3[r4]     // Catch:{ Exception -> 0x003e }
            r2.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0035:
            r1.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003d:
            return r3
        L_0x003e:
            r3 = move-exception
            goto L_0x004e
        L_0x0040:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x006b
        L_0x0045:
            r3 = move-exception
            r2 = r0
            goto L_0x004e
        L_0x0048:
            r1 = move-exception
            r2 = r0
            goto L_0x006b
        L_0x004b:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L_0x004e:
            r3.printStackTrace()     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r2 = move-exception
            r2.printStackTrace()
        L_0x005b:
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0065:
            return r0
        L_0x0066:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r6
        L_0x006b:
            if (r0 == 0) goto L_0x0075
            r0.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0075:
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.SystemInfoUtil.getCpuName():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r5 = r2;
        r2 = r0;
        r0 = r5;
        r6 = r3;
        r3 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006b, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0075, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0084, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0085, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x008f, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[SYNTHETIC, Splitter:B:33:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070 A[SYNTHETIC, Splitter:B:38:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080 A[SYNTHETIC, Splitter:B:46:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008a A[SYNTHETIC, Splitter:B:51:0x008a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCurCpuFreq() {
        /*
            java.lang.String r0 = "N/A"
            r1 = 0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r4 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r3.<init>(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r4 = "utf-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            java.lang.String r1 = r3.readLine()     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.lang.String r0 = r1.trim()     // Catch:{ Exception -> 0x0041, all -> 0x0049 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0041, all -> 0x0049 }
            int r0 = r0 / 1000
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0041, all -> 0x0049 }
            r3.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0038:
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0079
        L_0x003c:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0079
        L_0x0041:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x0061
        L_0x0049:
            r0 = move-exception
            r1 = r3
            goto L_0x007e
        L_0x004c:
            r1 = move-exception
            r5 = r3
            r3 = r0
            r0 = r2
            r2 = r1
            r1 = r5
            goto L_0x0061
        L_0x0053:
            r0 = move-exception
            goto L_0x007e
        L_0x0055:
            r3 = move-exception
            r5 = r3
            r3 = r0
            r0 = r2
            r2 = r5
            goto L_0x0061
        L_0x005b:
            r0 = move-exception
            r2 = r1
            goto L_0x007e
        L_0x005e:
            r2 = move-exception
            r3 = r0
            r0 = r1
        L_0x0061:
            r2.printStackTrace()     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x006e
            r1.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x006e:
            if (r0 == 0) goto L_0x0078
            r0.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0078:
            r0 = r3
        L_0x0079:
            return r0
        L_0x007a:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L_0x007e:
            if (r1 == 0) goto L_0x0088
            r1.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0088:
            if (r2 == 0) goto L_0x0092
            r2.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0092:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.SystemInfoUtil.getCurCpuFreq():java.lang.String");
    }

    public static void getGPUInfo(GL10 gl10) {
        log += getLogStr("GL_VENDOR", gl10.glGetString(7936));
        log += getLogStr("GL_RENDERER", gl10.glGetString(7937));
        log += getLogStr("GL_VERSION", gl10.glGetString(7938));
    }

    public static String getLogStr(String str, String str2) {
        if (!TextUtils.isEmpty(name)) {
            name += COMMA;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(TextUtils.isEmpty(str) ? f2381NA : str);
        name = sb.toString();
        if (!TextUtils.isEmpty(value)) {
            value += COMMA;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(value);
        sb2.append(TextUtils.isEmpty(str2) ? f2381NA : str2);
        value = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = f2381NA;
        }
        sb3.append(str);
        sb3.append(": ");
        if (TextUtils.isEmpty(str2)) {
            str2 = f2381NA;
        }
        sb3.append(str2);
        sb3.append("\n");
        return sb3.toString();
    }

    public static String getMaxCpuFreq() {
        String str;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr, IoUtils.UTF_8);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            str = f2381NA;
        }
        return String.valueOf(str);
    }

    public static String getMinCpuFreq() {
        String str;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr, IoUtils.UTF_8);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception unused) {
            str = f2381NA;
        }
        return str.trim();
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C0918a());
            ARLog.m2695d("CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            ARLog.m2695d("CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c A[SYNTHETIC, Splitter:B:31:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0086 A[SYNTHETIC, Splitter:B:36:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[SYNTHETIC, Splitter:B:45:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a1 A[SYNTHETIC, Splitter:B:50:0x00a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getRamMemory(android.content.Context r9) {
        /*
            java.lang.String r9 = "/proc/meminfo"
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            r2.<init>(r9)     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            java.lang.String r9 = "utf-8"
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r9)     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            r1.<init>(r2, r9)     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            r2 = 8192(0x2000, float:1.14794E-41)
            r9.<init>(r1, r2)     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            java.lang.String r0 = r9.readLine()     // Catch:{ Exception -> 0x0062 }
            java.lang.String r2 = "\\s+"
            java.lang.String[] r2 = r0.split(r2)     // Catch:{ Exception -> 0x0062 }
            int r3 = r2.length     // Catch:{ Exception -> 0x0062 }
            r4 = 0
        L_0x0026:
            if (r4 >= r3) goto L_0x0049
            r5 = r2[r4]     // Catch:{ Exception -> 0x0062 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0062 }
            r6.<init>()     // Catch:{ Exception -> 0x0062 }
            r6.append(r0)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r7 = ", "
            r6.append(r7)     // Catch:{ Exception -> 0x0062 }
            r6.append(r5)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r5 = "\t"
            r6.append(r5)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0062 }
            com.baidu.p020ar.util.ARLog.m2697i(r5)     // Catch:{ Exception -> 0x0062 }
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0049:
            r0 = 1
            r0 = r2[r0]     // Catch:{ Exception -> 0x0062 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0062 }
            long r2 = (long) r0
            r9.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0059:
            r1.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0090
        L_0x005d:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0090
        L_0x0062:
            r0 = move-exception
            goto L_0x0077
        L_0x0064:
            r9 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x0095
        L_0x0069:
            r9 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x0077
        L_0x006e:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
            goto L_0x0095
        L_0x0073:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
        L_0x0077:
            r0.printStackTrace()     // Catch:{ all -> 0x0094 }
            if (r9 == 0) goto L_0x0084
            r9.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0084:
            if (r1 == 0) goto L_0x008e
            r1.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r9 = move-exception
            r9.printStackTrace()
        L_0x008e:
            r2 = 0
        L_0x0090:
            r0 = 1024(0x400, double:5.06E-321)
            long r2 = r2 / r0
            return r2
        L_0x0094:
            r0 = move-exception
        L_0x0095:
            if (r9 == 0) goto L_0x009f
            r9.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r9 = move-exception
            r9.printStackTrace()
        L_0x009f:
            if (r1 == 0) goto L_0x00a9
            r1.close()     // Catch:{ IOException -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00a9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.util.SystemInfoUtil.getRamMemory(android.content.Context):long");
    }

    public static long[] getRomMemroy() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        return new long[]{(((long) statFs.getBlockCount()) * blockSize) / 1048576, (blockSize * ((long) statFs.getAvailableBlocks())) / 1048576};
    }

    public static long getSDAvailableSizeByM() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1048576;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static long getSDCardTotalSize() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return 0;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1048576;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static boolean isHasGyroscope(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null;
    }

    public static boolean isNexus6P() {
        return "Nexus 6P".equals(Build.MODEL) || "AOSP on angler".equals(Build.MODEL);
    }

    public static boolean isScreenOrientationLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
