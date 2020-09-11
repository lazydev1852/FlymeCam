package com.meizu.media.camera.portrait;

import com.meizu.media.camera.util.ByteUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayOutputStream;

public class CameraImageParam {
    public static ChangeQuickRedirect changeQuickRedirect;
    public int i32LeftFullHeight;
    public int i32LeftFullWidth;
    public int i32RightFullHeight;
    public int i32RightFullWidth;

    public void toByteArray(ByteArrayOutputStream byteArrayOutputStream) {
        if (!PatchProxy.proxy(new Object[]{byteArrayOutputStream}, this, changeQuickRedirect, false, 5401, new Class[]{ByteArrayOutputStream.class}, Void.TYPE).isSupported) {
            byte[] a = ByteUtil.m16163a(this.i32LeftFullWidth);
            byteArrayOutputStream.write(a, 0, a.length);
            byte[] a2 = ByteUtil.m16163a(this.i32LeftFullHeight);
            byteArrayOutputStream.write(a2, 0, a2.length);
            byte[] a3 = ByteUtil.m16163a(this.i32RightFullWidth);
            byteArrayOutputStream.write(a3, 0, a3.length);
            byte[] a4 = ByteUtil.m16163a(this.i32RightFullHeight);
            byteArrayOutputStream.write(a4, 0, a4.length);
        }
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5402, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "{main WxH:" + this.i32LeftFullWidth + "x" + this.i32LeftFullHeight + ", aux WxH:" + this.i32RightFullWidth + "x" + this.i32RightFullHeight + "}";
    }
}
