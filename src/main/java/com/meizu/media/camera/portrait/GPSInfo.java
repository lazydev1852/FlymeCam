package com.meizu.media.camera.portrait;

import com.meizu.media.camera.p067d.Rational;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Arrays;

public class GPSInfo {
    private static final int EXIF_ASCII_PREFIX_SIZE = 8;
    private static final int GPS_PROCESSING_METHOD_SIZE = 33;
    public static ChangeQuickRedirect changeQuickRedirect;
    public int altRef;
    public Rational altitude;
    public int count;
    public char[] gpsDateStamp;
    public char[] gpsProcessingMethod;
    public Rational[] gpsTimeStamp = new Rational[3];
    public char[] latRef;
    public Rational[] latitude = new Rational[3];
    public char[] lonRef;
    public Rational[] longitude = new Rational[3];

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5409, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "{count:" + this.count + ", gpsProcessingMethod:" + String.valueOf(this.gpsProcessingMethod) + ", latitude:" + Arrays.toString(this.latitude) + ", latRef:" + String.valueOf(this.latRef) + ", longitude:" + Arrays.toString(this.longitude) + ", lonRef:" + String.valueOf(this.lonRef) + ", altitude:" + this.altitude + ", altRef:" + this.altRef + ", gpsDateStamp:" + String.valueOf(this.gpsDateStamp) + ", gpsTimeStamp:" + Arrays.toString(this.gpsTimeStamp) + "}";
    }
}
