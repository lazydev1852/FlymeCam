package com.meizu.media.camera.util;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import android.media.Image;
import com.meizu.media.camera.Exif;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* renamed from: com.meizu.media.camera.util.u */
public class FormatUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14346a;

    /* renamed from: b */
    public static final LogUtil.C2630a f14347b = new LogUtil.C2630a("FormatUtil");

    /* renamed from: a */
    public static byte[] m16270a(Image image) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{image}, (Object) null, f14346a, true, 8075, new Class[]{Image.class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        int rowStride = image.getPlanes()[0].getRowStride();
        ByteBuffer buffer2 = image.getPlanes()[2].getBuffer();
        int remaining = buffer.remaining();
        int remaining2 = buffer2.remaining();
        image.getWidth();
        int height = rowStride * image.getHeight();
        byte[] bArr = new byte[((height * 3) / 2)];
        buffer.get(bArr, 0, remaining);
        buffer2.get(bArr, height, remaining2);
        return bArr;
    }

    /* renamed from: a */
    public static String m16269a(double d) {
        Object[] objArr = {new Double(d)};
        ChangeQuickRedirect changeQuickRedirect = f14346a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 8076, new Class[]{Double.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        double d2 = d % 1.0d;
        String valueOf = String.valueOf((int) d);
        double d3 = d2 * 60.0d;
        double d4 = d3 % 1.0d;
        int i = (int) d3;
        if (i < 0) {
            i *= -1;
        }
        String valueOf2 = String.valueOf(i);
        int i2 = (int) (d4 * 60.0d);
        if (i2 < 0) {
            i2 *= -1;
        }
        String valueOf3 = String.valueOf(i2);
        return valueOf + "/1," + valueOf2 + "/1," + valueOf3 + "/1";
    }

    /* renamed from: a */
    public static byte[] m16272a(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, Location location, long j, TotalCaptureResult totalCaptureResult, boolean... zArr) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean[] zArr2 = zArr;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, new Integer(i5), new Integer(i6), new Integer(i7), rect, new Integer(i4), location, new Long(j), totalCaptureResult, zArr2}, (Object) null, f14346a, true, 8077, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Rect.class, Integer.TYPE, Location.class, Long.TYPE, TotalCaptureResult.class, boolean[].class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        new YuvImage(bArr, 17, i, i2, new int[]{i7, i7, i7}).compressToJpeg(new Rect(0, 0, i5, i6), 97, byteArrayOutputStream);
        return Exif.m10045a(byteArrayOutputStream.toByteArray(), i4, location, j, totalCaptureResult, false, zArr2 != null && zArr2.length > 0 && zArr2[0]);
    }

    /* renamed from: a */
    public static byte[] m16271a(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, Location location, long j, TotalCaptureResult totalCaptureResult, XmpMetaData gVar, boolean... zArr) {
        XmpMetaData gVar2 = gVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3), rect, new Integer(i4), location, new Long(j), totalCaptureResult, gVar2, zArr}, (Object) null, f14346a, true, 8078, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Rect.class, Integer.TYPE, Location.class, Long.TYPE, TotalCaptureResult.class, XmpMetaData.class, boolean[].class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        byte[] a = m16272a(bArr, i, i2, i3, rect, i4, location, j, totalCaptureResult, zArr);
        return gVar2 != null ? XmpUtilHelper.m16124a(a, gVar2) : a;
    }

    /* renamed from: b */
    public static byte[] m16273b(Image image) {
        Rect rect;
        int i;
        int i2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{image}, (Object) null, f14346a, true, 8079, new Class[]{Image.class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        Rect cropRect = image.getCropRect();
        image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i3 = width * height;
        byte[] bArr = new byte[((i3 * 3) / 2)];
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i4 < planes.length) {
            switch (i4) {
                case 0:
                    i5 = 0;
                    i6 = 1;
                    break;
                case 1:
                    i5 = i3 + 1;
                    break;
                case 2:
                    i5 = i3;
                    break;
            }
            i6 = 2;
            ByteBuffer buffer = planes[i4].getBuffer();
            int rowStride = planes[i4].getRowStride();
            int pixelStride = planes[i4].getPixelStride();
            int i7 = i4 == 0 ? 0 : 1;
            int i8 = width >> i7;
            int i9 = height >> i7;
            int i10 = width;
            buffer.position(((cropRect.top >> i7) * rowStride) + ((cropRect.left >> i7) * pixelStride));
            int i11 = 0;
            while (i11 < i9) {
                if (pixelStride == 1 && i6 == 1) {
                    buffer.get(bArr, i5, i8);
                    i2 = i5 + i8;
                    rect = cropRect;
                    i = i8;
                } else {
                    rect = cropRect;
                    i = ((i8 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i);
                    int i12 = i5;
                    for (int i13 = 0; i13 < i8; i13++) {
                        bArr[i12] = bArr2[i13 * pixelStride];
                        i12 += i6;
                    }
                    i2 = i12;
                }
                if (i11 < i9 - 1) {
                    buffer.position((buffer.position() + rowStride) - i);
                }
                i11++;
                cropRect = rect;
            }
            Rect rect2 = cropRect;
            i4++;
            width = i10;
        }
        return bArr;
    }
}
