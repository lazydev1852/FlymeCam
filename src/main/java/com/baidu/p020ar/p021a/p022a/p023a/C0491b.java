package com.baidu.p020ar.p021a.p022a.p023a;

import android.content.Context;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.p020ar.rotate.Orientation;
import java.lang.ref.WeakReference;

/* renamed from: com.baidu.ar.a.a.a.b */
public class C0491b {

    /* renamed from: a */
    C0487a f538a;

    /* renamed from: b */
    float[] f539b = new float[((this.f540c * this.f541d) * 3)];

    /* renamed from: c */
    private int f540c = Opcodes.IF_ICMPNE;

    /* renamed from: d */
    private int f541d = Opcodes.IF_ICMPNE;

    /* renamed from: e */
    private boolean f542e = false;

    /* renamed from: f */
    private int f543f = 0;

    /* renamed from: g */
    private Orientation f544g = Orientation.PORTRAIT;

    /* renamed from: h */
    private String f545h = null;

    /* renamed from: i */
    private String f546i = null;

    /* renamed from: j */
    private String f547j = "1";

    /* renamed from: k */
    private float f548k = 124.0f;

    /* renamed from: l */
    private float f549l = 117.0f;

    /* renamed from: m */
    private float f550m = 104.0f;

    /* renamed from: n */
    private float f551n = 1.0f;

    /* renamed from: o */
    private float f552o = 1.0f;

    /* renamed from: p */
    private float f553p = 1.0f;

    /* renamed from: q */
    private Context f554q;

    /* renamed from: r */
    private RenderScript f555r;

    /* renamed from: s */
    private ScriptIntrinsicYuvToRGB f556s;

    public C0491b(Context context, String str, String str2, C0487a aVar) {
        this.f554q = (Context) new WeakReference(context).get();
        this.f545h = str;
        this.f546i = str2;
        this.f538a = aVar;
        this.f555r = RenderScript.create(this.f554q);
        this.f556s = ScriptIntrinsicYuvToRGB.create(this.f555r, Element.RGBA_8888(this.f555r));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r1 = 180;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0096  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle mo8929a(byte[] r16, int r17, int r18) {
        /*
            r15 = this;
            r0 = r15
            boolean r1 = r0.f542e
            r2 = 0
            if (r1 != 0) goto L_0x0007
            return r2
        L_0x0007:
            android.content.Context r1 = r0.f554q
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            r12 = 0
            int r1 = r0.f543f
            r3 = 180(0xb4, float:2.52E-43)
            r4 = -90
            r5 = 90
            r6 = 1
            r7 = 0
            if (r1 != r6) goto L_0x0039
            java.lang.String r1 = r0.f547j
            java.lang.String r8 = "2"
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x0036
            int[] r1 = com.baidu.p020ar.p021a.p022a.p023a.C0491b.C04921.f557a
            com.baidu.ar.rotate.Orientation r8 = r0.f544g
            int r8 = r8.ordinal()
            r1 = r1[r8]
            switch(r1) {
                case 1: goto L_0x0033;
                case 2: goto L_0x0050;
                case 3: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0036
        L_0x0031:
            r1 = 0
            goto L_0x0052
        L_0x0033:
            r1 = 180(0xb4, float:2.52E-43)
            goto L_0x0052
        L_0x0036:
            r1 = -90
            goto L_0x0052
        L_0x0039:
            java.lang.String r1 = r0.f547j
            java.lang.String r8 = "2"
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x0050
            int[] r1 = com.baidu.p020ar.p021a.p022a.p023a.C0491b.C04921.f557a
            com.baidu.ar.rotate.Orientation r8 = r0.f544g
            int r8 = r8.ordinal()
            r1 = r1[r8]
            switch(r1) {
                case 1: goto L_0x0033;
                case 2: goto L_0x0036;
                case 3: goto L_0x0031;
                default: goto L_0x0050;
            }
        L_0x0050:
            r1 = 90
        L_0x0052:
            com.baidu.ar.imgseg.a r3 = com.baidu.p020ar.imgseg.C0766a.m1990a()
            int r8 = r0.f541d
            int r9 = r0.f540c
            r14 = 3
            float[] r10 = new float[r14]
            float r4 = r0.f548k
            r10[r7] = r4
            float r4 = r0.f549l
            r10[r6] = r4
            float r4 = r0.f550m
            r5 = 2
            r10[r5] = r4
            float[] r11 = new float[r14]
            float r4 = r0.f551n
            r11[r7] = r4
            float r4 = r0.f552o
            r11[r6] = r4
            float r4 = r0.f553p
            r11[r5] = r4
            float[] r13 = r0.f539b
            r4 = r16
            r5 = r18
            r6 = r17
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r1
            r3.mo10114a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.baidu.ar.a.a.a.a r3 = r0.f538a
            float[] r4 = r0.f539b
            int r5 = r0.f540c
            int r6 = r0.f541d
            com.baidu.ar.a.a.a.a$a r3 = r3.predictForFloatMatrix(r4, r5, r6, r14)
            if (r3 == 0) goto L_0x0098
            float[] r2 = r3.f535a
        L_0x0098:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = "result"
            r3.putFloatArray(r4, r2)
            java.lang.String r2 = "previewData"
            r4 = r16
            r3.putByteArray(r2, r4)
            java.lang.String r2 = "pixelBytes"
            int r4 = r0.f540c
            int r5 = r0.f541d
            int r4 = r4 * r5
            int r4 = r4 * 3
            byte[] r4 = new byte[r4]
            r3.putByteArray(r2, r4)
            java.lang.String r2 = "orientation"
            r3.putInt(r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.p021a.p022a.p023a.C0491b.mo8929a(byte[], int, int):android.os.Bundle");
    }

    /* renamed from: a */
    public void mo8930a(float f, float f2, float f3, float f4, float f5, float f6) {
        if (f >= 0.0f) {
            this.f548k = f;
        }
        if (f3 >= 0.0f) {
            this.f550m = f3;
        }
        if (f2 >= 0.0f) {
            this.f549l = f2;
        }
        if (f4 >= 0.0f) {
            this.f551n = f4;
        }
        if (f5 >= 0.0f) {
            this.f552o = f5;
        }
        if (f6 >= 0.0f) {
            this.f553p = f6;
        }
    }

    /* renamed from: a */
    public void mo8931a(int i) {
        this.f543f = i;
    }

    /* renamed from: a */
    public void mo8932a(int i, int i2) {
        this.f540c = i;
        this.f541d = i2;
    }

    /* renamed from: a */
    public void mo8933a(Orientation orientation) {
        this.f544g = orientation;
    }

    /* renamed from: a */
    public void mo8934a(String str) {
        this.f545h = str;
    }

    /* renamed from: a */
    public boolean mo8935a() {
        int init = this.f538a.init(this.f545h, this.f546i);
        Log.e("bdar", "Paddle init result:" + init);
        if (init != 0) {
            return false;
        }
        this.f542e = true;
        return true;
    }

    /* renamed from: b */
    public void mo8936b(String str) {
        this.f547j = str;
    }

    /* renamed from: b */
    public boolean mo8937b() {
        if (this.f538a != null) {
            try {
                this.f538a.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("bdar", "Paddle close Exception:" + e.getMessage());
            }
        }
        return false;
    }

    /* renamed from: c */
    public void mo8938c() {
        if (this.f556s != null) {
            this.f556s.destroy();
            this.f556s = null;
        }
        if (this.f555r != null) {
            this.f555r.finish();
            this.f555r.destroy();
            this.f555r = null;
        }
        if (this.f554q != null) {
            this.f554q = null;
        }
    }
}
