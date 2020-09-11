package com.baidu.p020ar.blend.gpuimage.p039a;

/* renamed from: com.baidu.ar.blend.gpuimage.a.i */
public class C0725i extends C0743u {

    /* renamed from: m */
    protected float f1540m;

    public C0725i() {
        this(4.0f);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0725i(float r6) {
        /*
            r5 = this;
            int r0 = (int) r6
            r1 = 1082130432(0x40800000, float:4.0)
            java.lang.String r2 = m1840b(r0, r1)
            java.lang.String r3 = m1841c(r0, r1)
            java.lang.String r4 = m1840b(r0, r1)
            java.lang.String r0 = m1841c(r0, r1)
            r5.<init>(r2, r3, r4, r0)
            r0 = 1065353216(0x3f800000, float:1.0)
            r5.f1540m = r0
            r5.f1540m = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.gpuimage.p039a.C0725i.<init>(float):void");
    }

    /* renamed from: b */
    public static String m1840b(int i, float f) {
        String format;
        String str;
        Object[] objArr;
        if (i < 1) {
            return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[7];\n\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    \n    // Calculate the positions for the blur\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n   blurCoordinates[0] = textureCoordinate;   blurCoordinates[1] = textureCoordinate + singleStepOffset * 1.485005;\n   blurCoordinates[2] = textureCoordinate - singleStepOffset * 1.485005;\n   blurCoordinates[3] = textureCoordinate + singleStepOffset * 3.465057;\n   blurCoordinates[4] = textureCoordinate - singleStepOffset * 3.465057;\n   blurCoordinates[5] = textureCoordinate + singleStepOffset * 5.393111;\n   blurCoordinates[6] = textureCoordinate - singleStepOffset * 5.393111;\n}\n";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = (i * 2) + 1;
        sb.append(String.format("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 blurCoordinates[%d];\n\nvoid main()\n{\n    gl_Position = position;\n    \n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n", new Object[]{Integer.valueOf(i2)}));
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 - i;
            if (i4 < 0) {
                str = "    blurCoordinates[%d] = inputTextureCoordinate.xy - singleStepOffset * %f;\n";
                objArr = new Object[]{Integer.valueOf(i3), Float.valueOf((float) (-i4))};
            } else if (i4 > 0) {
                str = "    blurCoordinates[%d] = inputTextureCoordinate.xy + singleStepOffset * %f;\n";
                objArr = new Object[]{Integer.valueOf(i3), Float.valueOf((float) i4)};
            } else {
                format = String.format("    blurCoordinates[%d] = inputTextureCoordinate.xy;\n", new Object[]{Integer.valueOf(i3)});
                sb.append(format);
            }
            format = String.format(str, objArr);
            sb.append(format);
        }
        sb.append(String.format("}\n", new Object[0]));
        return sb.toString();
    }

    /* renamed from: c */
    public static String m1841c(int i, float f) {
        String str;
        Object[] objArr;
        int i2 = i;
        if (i2 < 1) {
            return "uniform sampler2D inputImageTexture;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[7];\n\nvoid main()\n{\n    lowp vec3 sum = vec3(0.0);\n    lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n    \n    sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.098853;\n    sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.188148;\n    sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.188148;\n    sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.154351;\n    sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.154351;\n    sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.098795;\n    sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.098795;\n    gl_FragColor = vec4(sum,fragColor.a);\n}";
        }
        int i3 = i2 + 1;
        float[] fArr = new float[i3];
        int i4 = 0;
        float f2 = 0.0f;
        while (i4 < i3) {
            double d = (double) f;
            fArr[i4] = (float) ((1.0d / Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow((double) i4, 2.0d)) / (Math.pow(d, 2.0d) * 2.0d)));
            f2 = i4 == 0 ? f2 + fArr[i4] : (float) (((double) f2) + (((double) fArr[i4]) * 2.0d));
            i4++;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            fArr[i5] = fArr[i5] / f2;
        }
        StringBuilder sb = new StringBuilder();
        int i6 = (i2 * 2) + 1;
        sb.append(String.format("uniform sampler2D inputImageTexture;\n\nvarying highp vec2 blurCoordinates[%d];\n\nvoid main()\n{\n   lowp vec4 sum = vec4(0.0);\n", new Object[]{Integer.valueOf(i6)}));
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 - i2;
            if (i8 < 0) {
                str = "    sum += texture2D(inputImageTexture, blurCoordinates[%d]) * %f;\n";
                objArr = new Object[]{Integer.valueOf(i7), Float.valueOf(fArr[-i8])};
            } else {
                str = "    sum += texture2D(inputImageTexture, blurCoordinates[%d]) * %f;\n";
                objArr = new Object[]{Integer.valueOf(i7), Float.valueOf(fArr[i8])};
            }
            sb.append(String.format(str, objArr));
        }
        sb.append(String.format("    gl_FragColor = sum;\n}\n", new Object[0]));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo10032a(float f) {
        this.f1540m = f;
        mo9992a((Runnable) new Runnable() {
            public void run() {
                C0725i.this.mo10063q();
            }
        });
    }

    /* renamed from: o */
    public float mo10033o() {
        return this.f1540m;
    }

    /* renamed from: p */
    public float mo10034p() {
        return this.f1540m;
    }
}
