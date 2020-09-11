package com.meizu.media.camera.portrait;

import android.graphics.Rect;
import com.meizu.media.camera.util.ByteUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class BokehFace {
    public static final int BOKEH_MAX_FACE_NUM = 16;
    public static ChangeQuickRedirect changeQuickRedirect;
    public int[] faceAnglesArray = new int[16];
    public Rect[] faceArray = new Rect[16];
    public int i32FacesNum;
    public int i32ImgDegree;

    public void toByteArray(ByteArrayOutputStream byteArrayOutputStream) {
        if (!PatchProxy.proxy(new Object[]{byteArrayOutputStream}, this, changeQuickRedirect, false, 5399, new Class[]{ByteArrayOutputStream.class}, Void.TYPE).isSupported) {
            byte[] a = ByteUtil.m16163a(this.i32ImgDegree);
            byteArrayOutputStream.write(a, 0, a.length);
            byte[] a2 = ByteUtil.m16163a(this.i32FacesNum);
            byteArrayOutputStream.write(a2, 0, a2.length);
            for (int i = 0; i < 16; i++) {
                byte[] a3 = ByteUtil.m16163a(this.faceArray[i].left);
                byteArrayOutputStream.write(a3, 0, a3.length);
                byte[] a4 = ByteUtil.m16163a(this.faceArray[i].top);
                byteArrayOutputStream.write(a4, 0, a4.length);
                byte[] a5 = ByteUtil.m16163a(this.faceArray[i].right);
                byteArrayOutputStream.write(a5, 0, a5.length);
                byte[] a6 = ByteUtil.m16163a(this.faceArray[i].bottom);
                byteArrayOutputStream.write(a6, 0, a6.length);
            }
            for (int i2 = 0; i2 < 16; i2++) {
                byte[] a7 = ByteUtil.m16163a(this.faceAnglesArray[i2]);
                byteArrayOutputStream.write(a7, 0, a7.length);
            }
        }
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5400, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "{i32ImgDegree:" + this.i32ImgDegree + ",i32FacesNum:" + this.i32FacesNum + ",faceArray:" + Arrays.toString(this.faceArray) + "}";
    }
}
