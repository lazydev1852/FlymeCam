package com.meizu.media.camera.util;

import androidx.core.view.ViewCompat;

/* renamed from: com.meizu.media.camera.util.j */
public class ByteUtil {
    /* renamed from: a */
    public static byte[] m16164a(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s & 65280) >> 8)};
    }

    /* renamed from: a */
    public static byte[] m16163a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }
}
