package com.meizu.media.camera.portrait;

import com.meizu.media.camera.util.ByteUtil;
import com.meizu.media.camera.util.MzDataInputStream;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ASVLOffScreen {
    public static final int FORMAT_DEPTH16 = 3074;
    public static final int FORMAT_NV12 = 2049;
    public static final int FORMAT_NV21 = 2050;
    public static ChangeQuickRedirect changeQuickRedirect;
    public int i32Height;
    public int i32Width;
    public int[] pi32Pitch = new int[4];
    public byte[] ppu8Plane;
    public long u32PixelArrayFormat;
    public int[] u32ScanLine = new int[4];

    public ASVLOffScreen() {
    }

    public ASVLOffScreen(byte[] bArr) throws IOException {
        MzDataInputStream agVar = new MzDataInputStream(new ByteArrayInputStream(bArr), ByteOrder.LITTLE_ENDIAN);
        this.u32PixelArrayFormat = agVar.mo22666b();
        this.i32Width = agVar.mo22664a();
        this.i32Height = agVar.mo22664a();
        this.u32ScanLine[0] = agVar.mo22664a();
        this.u32ScanLine[1] = agVar.mo22664a();
        this.u32ScanLine[2] = agVar.mo22664a();
        this.u32ScanLine[3] = agVar.mo22664a();
        this.pi32Pitch[0] = agVar.mo22664a();
        this.pi32Pitch[1] = agVar.mo22664a();
        this.pi32Pitch[2] = agVar.mo22664a();
        this.pi32Pitch[3] = agVar.mo22664a();
        agVar.close();
    }

    public ASVLOffScreen clone() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5396, new Class[0], ASVLOffScreen.class);
        if (proxy.isSupported) {
            return (ASVLOffScreen) proxy.result;
        }
        ASVLOffScreen aSVLOffScreen = new ASVLOffScreen();
        aSVLOffScreen.u32PixelArrayFormat = this.u32PixelArrayFormat;
        aSVLOffScreen.i32Width = this.i32Width;
        aSVLOffScreen.i32Height = this.i32Height;
        aSVLOffScreen.u32ScanLine = Arrays.copyOf(this.u32ScanLine, 4);
        aSVLOffScreen.pi32Pitch = Arrays.copyOf(this.pi32Pitch, 4);
        aSVLOffScreen.ppu8Plane = new byte[this.ppu8Plane.length];
        return aSVLOffScreen;
    }

    public void toByteArray(ByteArrayOutputStream byteArrayOutputStream) {
        if (!PatchProxy.proxy(new Object[]{byteArrayOutputStream}, this, changeQuickRedirect, false, 5397, new Class[]{ByteArrayOutputStream.class}, Void.TYPE).isSupported) {
            byte[] a = ByteUtil.m16163a((int) this.u32PixelArrayFormat);
            byteArrayOutputStream.write(a, 0, a.length);
            byte[] a2 = ByteUtil.m16163a(this.i32Width);
            byteArrayOutputStream.write(a2, 0, a2.length);
            byte[] a3 = ByteUtil.m16163a(this.i32Height);
            byteArrayOutputStream.write(a3, 0, a3.length);
            byte[] a4 = ByteUtil.m16163a(this.u32ScanLine[0]);
            byteArrayOutputStream.write(a4, 0, a4.length);
            byte[] a5 = ByteUtil.m16163a(this.u32ScanLine[1]);
            byteArrayOutputStream.write(a5, 0, a5.length);
            byte[] a6 = ByteUtil.m16163a(this.u32ScanLine[2]);
            byteArrayOutputStream.write(a6, 0, a6.length);
            byte[] a7 = ByteUtil.m16163a(this.u32ScanLine[3]);
            byteArrayOutputStream.write(a7, 0, a7.length);
            byte[] a8 = ByteUtil.m16163a(this.pi32Pitch[0]);
            byteArrayOutputStream.write(a8, 0, a8.length);
            byte[] a9 = ByteUtil.m16163a(this.pi32Pitch[1]);
            byteArrayOutputStream.write(a9, 0, a9.length);
            byte[] a10 = ByteUtil.m16163a(this.pi32Pitch[2]);
            byteArrayOutputStream.write(a10, 0, a10.length);
            byte[] a11 = ByteUtil.m16163a(this.pi32Pitch[3]);
            byteArrayOutputStream.write(a11, 0, a11.length);
        }
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5398, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "{WxH:" + this.i32Width + "x" + this.i32Height + ",format:" + this.u32PixelArrayFormat + ",pitch:" + Arrays.toString(this.pi32Pitch) + ",u32ScanLine" + Arrays.toString(this.u32ScanLine) + "}";
    }
}
