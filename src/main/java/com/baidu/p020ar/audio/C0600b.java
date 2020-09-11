package com.baidu.p020ar.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Build;
import android.util.Log;

/* renamed from: com.baidu.ar.audio.b */
public class C0600b {

    /* renamed from: a */
    private static final String f968a = "b";

    C0600b() {
    }

    /* renamed from: a */
    public static double m1210a(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            if (i2 >= 32768) {
                i2 = 65535 - i2;
            }
            d += (double) Math.abs(i2);
        }
        return Math.log10(((d / ((double) bArr.length)) / 2.0d) + 1.0d) * 10.0d;
    }

    /* renamed from: a */
    private static boolean m1211a() {
        AudioRecord audioRecord = new AudioRecord(1, AudioParams.DEFAULT_SAMPLE_RATE, 16, 2, AudioParams.DEFAULT_FRAME_SIZE);
        try {
            audioRecord.startRecording();
            boolean z = audioRecord.getRecordingState() == 3;
            byte[] bArr = new byte[AudioParams.DEFAULT_AUDIO_BUFFER_SIZE];
            boolean z2 = z;
            int i = 0;
            while (true) {
                if (i >= 20) {
                    break;
                }
                audioRecord.read(bArr, 0, bArr.length);
                double a = m1210a(bArr);
                String str = f968a;
                Log.i(str, "checkPermissionUnderVersionM volume = " + a);
                z2 = a != 0.0d;
                if (z2) {
                    break;
                }
                i++;
            }
            audioRecord.stop();
            audioRecord.release();
            return z2;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1212a(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? m1213a(context, context.getApplicationContext().getPackageName()) : m1211a();
    }

    /* renamed from: a */
    private static boolean m1213a(Context context, String str) {
        return context.getPackageManager().checkPermission("android.permission.RECORD_AUDIO", str) == 0;
    }

    /* renamed from: b */
    public static double m1214b(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            if (i2 >= 32768) {
                i2 = 65535 - i2;
            }
            d += (double) (i2 * i2);
        }
        return Math.min(5000.0d, Math.sqrt((d / ((double) bArr.length)) / 2.0d)) / 50.0d;
    }
}
