package com.meizu.media.camera.portrait;

import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.media.camera.util.ByteUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayOutputStream;

public class DualExif {
    public static ChangeQuickRedirect changeQuickRedirect;
    public FractionNum apertureValue;
    public String dateTime;
    public short dateTimeLen;
    public FractionNum exposureTime;
    public short flashFired;
    public FractionNum focalLength;
    public GPSInfo gpsInfo;
    public short isoSpeed;
    public String manufacturer;
    public String model;
    public short orientation;
    public String subSecTime;
    public short subSecTimeLen;
    public int usedSize;

    public void toByteArray(ByteArrayOutputStream byteArrayOutputStream) {
        if (!PatchProxy.proxy(new Object[]{byteArrayOutputStream}, this, changeQuickRedirect, false, 5403, new Class[]{ByteArrayOutputStream.class}, Void.TYPE).isSupported) {
            byte[] a = ByteUtil.m16164a(244);
            byteArrayOutputStream.write(a, 0, a.length);
            byte[] bArr = new byte[10];
            char[] charArray = this.manufacturer.toCharArray();
            ArrayCopy.arrayCopyCharToByte(charArray, 0, bArr, 0, charArray.length);
            byteArrayOutputStream.write(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[10];
            char[] charArray2 = this.model.toCharArray();
            ArrayCopy.arrayCopyCharToByte(charArray2, 0, bArr2, 0, charArray2.length);
            byteArrayOutputStream.write(bArr2, 0, bArr2.length);
            char[] charArray3 = this.dateTime.toCharArray();
            char[] charArray4 = this.subSecTime.toCharArray();
            byte[] a2 = ByteUtil.m16164a((short) charArray3.length);
            byteArrayOutputStream.write(a2, 0, a2.length);
            byte[] a3 = ByteUtil.m16164a((short) charArray4.length);
            byteArrayOutputStream.write(a3, 0, a3.length);
            byte[] bArr3 = new byte[30];
            ArrayCopy.arrayCopyCharToByte(charArray3, 0, bArr3, 0, charArray3.length);
            byteArrayOutputStream.write(bArr3, 0, bArr3.length);
            byte[] bArr4 = new byte[10];
            ArrayCopy.arrayCopyCharToByte(charArray4, 0, bArr4, 0, charArray4.length);
            byteArrayOutputStream.write(bArr4, 0, bArr4.length);
            if (this.gpsInfo.count > 0) {
                byte[] a4 = ByteUtil.m16164a((short) this.gpsInfo.count);
                byteArrayOutputStream.write(a4, 0, a4.length);
                byte[] bArr5 = new byte[41];
                byteArrayOutputStream.write(bArr5, 0, bArr5.length);
                byte[] a5 = ByteUtil.m16163a((int) this.gpsInfo.latitude[0].mo19954a());
                byteArrayOutputStream.write(a5, 0, a5.length);
                byte[] a6 = ByteUtil.m16163a((int) this.gpsInfo.latitude[0].mo19955b());
                byteArrayOutputStream.write(a6, 0, a6.length);
                byte[] a7 = ByteUtil.m16163a((int) this.gpsInfo.latitude[1].mo19954a());
                byteArrayOutputStream.write(a7, 0, a7.length);
                byte[] a8 = ByteUtil.m16163a((int) this.gpsInfo.latitude[1].mo19955b());
                byteArrayOutputStream.write(a8, 0, a8.length);
                byte[] a9 = ByteUtil.m16163a((int) this.gpsInfo.latitude[2].mo19954a());
                byteArrayOutputStream.write(a9, 0, a9.length);
                byte[] a10 = ByteUtil.m16163a((int) this.gpsInfo.latitude[2].mo19955b());
                byteArrayOutputStream.write(a10, 0, a10.length);
                byte[] bArr6 = new byte[2];
                ArrayCopy.arrayCopyCharToByte(this.gpsInfo.latRef, 0, bArr6, 0, this.gpsInfo.latRef.length);
                byteArrayOutputStream.write(bArr6, 0, bArr6.length);
                byte[] a11 = ByteUtil.m16163a((int) this.gpsInfo.longitude[0].mo19954a());
                byteArrayOutputStream.write(a11, 0, a11.length);
                byte[] a12 = ByteUtil.m16163a((int) this.gpsInfo.longitude[0].mo19955b());
                byteArrayOutputStream.write(a12, 0, a12.length);
                byte[] a13 = ByteUtil.m16163a((int) this.gpsInfo.longitude[1].mo19954a());
                byteArrayOutputStream.write(a13, 0, a13.length);
                byte[] a14 = ByteUtil.m16163a((int) this.gpsInfo.longitude[1].mo19955b());
                byteArrayOutputStream.write(a14, 0, a14.length);
                byte[] a15 = ByteUtil.m16163a((int) this.gpsInfo.longitude[2].mo19954a());
                byteArrayOutputStream.write(a15, 0, a15.length);
                byte[] a16 = ByteUtil.m16163a((int) this.gpsInfo.longitude[2].mo19955b());
                byteArrayOutputStream.write(a16, 0, a16.length);
                byte[] bArr7 = new byte[2];
                ArrayCopy.arrayCopyCharToByte(this.gpsInfo.lonRef, 0, bArr7, 0, this.gpsInfo.lonRef.length);
                byteArrayOutputStream.write(bArr7, 0, bArr7.length);
                byte[] a17 = ByteUtil.m16163a((int) this.gpsInfo.altitude.mo19954a());
                byteArrayOutputStream.write(a17, 0, a17.length);
                byte[] a18 = ByteUtil.m16163a((int) this.gpsInfo.altitude.mo19955b());
                byteArrayOutputStream.write(a18, 0, a18.length);
                byteArrayOutputStream.write(this.gpsInfo.altRef);
                byte[] bArr8 = new byte[20];
                ArrayCopy.arrayCopyCharToByte(this.gpsInfo.gpsDateStamp, 0, bArr8, 0, this.gpsInfo.gpsDateStamp.length);
                byteArrayOutputStream.write(bArr8, 0, bArr8.length);
                byte[] a19 = ByteUtil.m16163a((int) this.gpsInfo.gpsTimeStamp[0].mo19954a());
                byteArrayOutputStream.write(a19, 0, a19.length);
                byte[] a20 = ByteUtil.m16163a((int) this.gpsInfo.gpsTimeStamp[0].mo19955b());
                byteArrayOutputStream.write(a20, 0, a20.length);
                byte[] a21 = ByteUtil.m16163a((int) this.gpsInfo.gpsTimeStamp[1].mo19954a());
                byteArrayOutputStream.write(a21, 0, a21.length);
                byte[] a22 = ByteUtil.m16163a((int) this.gpsInfo.gpsTimeStamp[1].mo19955b());
                byteArrayOutputStream.write(a22, 0, a22.length);
                byte[] a23 = ByteUtil.m16163a((int) this.gpsInfo.gpsTimeStamp[2].mo19954a());
                byteArrayOutputStream.write(a23, 0, a23.length);
                byte[] a24 = ByteUtil.m16163a((int) this.gpsInfo.gpsTimeStamp[2].mo19955b());
                byteArrayOutputStream.write(a24, 0, a24.length);
            } else {
                byte[] bArr9 = new byte[Opcodes.LCMP];
                byteArrayOutputStream.write(bArr9, 0, bArr9.length);
            }
            byte[] a25 = ByteUtil.m16163a((int) this.focalLength.numerator);
            byteArrayOutputStream.write(a25, 0, a25.length);
            byte[] a26 = ByteUtil.m16163a((int) this.focalLength.denominator);
            byteArrayOutputStream.write(a26, 0, a26.length);
            byte[] a27 = ByteUtil.m16164a(this.orientation);
            byteArrayOutputStream.write(a27, 0, a27.length);
            byte[] a28 = ByteUtil.m16163a((int) this.exposureTime.numerator);
            byteArrayOutputStream.write(a28, 0, a28.length);
            byte[] a29 = ByteUtil.m16163a((int) this.exposureTime.denominator);
            byteArrayOutputStream.write(a29, 0, a29.length);
            byte[] a30 = ByteUtil.m16163a((int) this.apertureValue.numerator);
            byteArrayOutputStream.write(a30, 0, a30.length);
            byte[] a31 = ByteUtil.m16163a((int) this.apertureValue.denominator);
            byteArrayOutputStream.write(a31, 0, a31.length);
            byte[] a32 = ByteUtil.m16164a(this.isoSpeed);
            byteArrayOutputStream.write(a32, 0, a32.length);
            byte[] a33 = ByteUtil.m16164a(this.flashFired);
            byteArrayOutputStream.write(a33, 0, a33.length);
        }
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5404, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "{manufacturer:" + String.valueOf(this.manufacturer) + ", model:" + String.valueOf(this.model) + ", focalLength:" + this.focalLength + ", orientation:" + this.orientation + ", exposureTime:" + this.exposureTime + ", apertureValue:" + this.apertureValue + ", isoSpeed:" + this.isoSpeed + ", flashFired:" + this.flashFired + ", \ngps:" + this.gpsInfo + "}";
    }
}
