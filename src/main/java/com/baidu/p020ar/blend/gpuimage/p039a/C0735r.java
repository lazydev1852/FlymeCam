package com.baidu.p020ar.blend.gpuimage.p039a;

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.mediatek.accessor.packer.PackUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.baidu.ar.blend.gpuimage.a.r */
public class C0735r extends C0712g {

    /* renamed from: a */
    protected int[] f1567a = {-1};

    /* renamed from: l */
    private int f1568l;

    /* renamed from: m */
    private PointF[] f1569m;

    /* renamed from: n */
    private PointF[] f1570n;

    /* renamed from: o */
    private PointF[] f1571o;

    /* renamed from: p */
    private PointF[] f1572p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ArrayList<Float> f1573q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ArrayList<Float> f1574r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ArrayList<Float> f1575s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ArrayList<Float> f1576t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public byte[] f1577u;

    public C0735r() {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D toneCurveTexture;\n\n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp float redCurveValue = texture2D(toneCurveTexture, vec2(textureColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(toneCurveTexture, vec2(textureColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(toneCurveTexture, vec2(textureColor.b, 0.0)).b;\n\n     gl_FragColor = vec4(redCurveValue, greenCurveValue, blueCurveValue, textureColor.a);\n }");
        PointF[] pointFArr = {new PointF(0.0f, 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f, 1.0f)};
        this.f1569m = pointFArr;
        this.f1570n = pointFArr;
        this.f1571o = pointFArr;
        this.f1572p = pointFArr;
    }

    /* renamed from: a */
    private ArrayList<Point> m1882a(Point[] pointArr) {
        Point[] pointArr2 = pointArr;
        ArrayList<Double> b = m1885b(pointArr);
        int i = 0;
        int size = b != null ? b.size() : 0;
        if (size < 1) {
            return null;
        }
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            if (b != null) {
                dArr[i2] = b.get(i2).doubleValue();
            }
        }
        ArrayList<Point> arrayList = new ArrayList<>(size + 1);
        while (i < size - 1) {
            Point point = pointArr2[i];
            int i3 = i + 1;
            Point point2 = pointArr2[i3];
            int i4 = point.x;
            while (i4 < point2.x) {
                double d = ((double) (i4 - point.x)) / ((double) (point2.x - point.x));
                double d2 = 1.0d - d;
                double d3 = (double) (point2.x - point.x);
                int i5 = size;
                Point point3 = point;
                ArrayList<Point> arrayList2 = arrayList;
                double d4 = (((double) point.y) * d2) + (((double) point2.y) * d) + (((d3 * d3) / 6.0d) * (((((d2 * d2) * d2) - d2) * dArr[i]) + ((((d * d) * d) - d) * dArr[i3])));
                double d5 = 255.0d;
                if (d4 <= 255.0d) {
                    d5 = d4 < 0.0d ? 0.0d : d4;
                }
                Point point4 = new Point(i4, (int) Math.round(d5));
                ArrayList<Point> arrayList3 = arrayList2;
                arrayList3.add(point4);
                i4++;
                arrayList = arrayList3;
                size = i5;
                point = point3;
                Point[] pointArr3 = pointArr;
            }
            i = i3;
            pointArr2 = pointArr;
        }
        ArrayList<Point> arrayList4 = arrayList;
        if (arrayList4.size() == 255) {
            Point[] pointArr4 = pointArr;
            arrayList4.add(pointArr4[pointArr4.length - 1]);
        }
        return arrayList4;
    }

    /* renamed from: b */
    private ArrayList<Double> m1885b(Point[] pointArr) {
        int i;
        Point[] pointArr2 = pointArr;
        int length = pointArr2.length;
        if (length <= 1) {
            return null;
        }
        double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{length, 3});
        double[] dArr2 = new double[length];
        char c = 0;
        dArr[0][1] = 1.0d;
        double d = 0.0d;
        dArr[0][0] = 0.0d;
        dArr[0][2] = 0.0d;
        int i2 = 1;
        while (true) {
            i = length - 1;
            if (i2 >= i) {
                break;
            }
            Point point = pointArr2[i2 - 1];
            Point point2 = pointArr2[i2];
            int i3 = i2 + 1;
            Point point3 = pointArr2[i3];
            dArr[i2][c] = ((double) (point2.x - point.x)) / 6.0d;
            dArr[i2][1] = ((double) (point3.x - point.x)) / 3.0d;
            dArr[i2][2] = ((double) (point3.x - point2.x)) / 6.0d;
            dArr2[i2] = (((double) (point3.y - point2.y)) / ((double) (point3.x - point2.x))) - (((double) (point2.y - point.y)) / ((double) (point2.x - point.x)));
            i2 = i3;
            c = 0;
            d = 0.0d;
        }
        double d2 = d;
        dArr2[c] = d2;
        dArr2[i] = d2;
        dArr[i][1] = 1.0d;
        dArr[i][c] = d2;
        dArr[i][2] = d2;
        int i4 = 1;
        while (i4 < length) {
            double d3 = dArr[i4][c];
            int i5 = i4 - 1;
            double d4 = d3 / dArr[i5][1];
            double[] dArr3 = dArr[i4];
            dArr3[1] = dArr3[1] - (dArr[i5][2] * d4);
            dArr[i4][0] = 0.0d;
            dArr2[i4] = dArr2[i4] - (d4 * dArr2[i5]);
            i4++;
            c = 0;
        }
        for (int i6 = length - 2; i6 >= 0; i6--) {
            int i7 = i6 + 1;
            double d5 = dArr[i6][2] / dArr[i7][1];
            double[] dArr4 = dArr[i6];
            dArr4[1] = dArr4[1] - (dArr[i7][0] * d5);
            dArr[i6][2] = 0.0d;
            dArr2[i6] = dArr2[i6] - (d5 * dArr2[i7]);
        }
        ArrayList<Double> arrayList = new ArrayList<>(length);
        for (int i8 = 0; i8 < length; i8++) {
            arrayList.add(Double.valueOf(dArr2[i8] / dArr[i8][1]));
        }
        return arrayList;
    }

    /* renamed from: d */
    private short m1888d(InputStream inputStream) {
        return (short) (inputStream.read() | (inputStream.read() << 8));
    }

    /* renamed from: e */
    private ArrayList<Float> m1889e(PointF[] pointFArr) {
        ArrayList<Float> arrayList = null;
        if (pointFArr != null && pointFArr.length > 0) {
            PointF[] pointFArr2 = (PointF[]) pointFArr.clone();
            Arrays.sort(pointFArr2, new Comparator<PointF>() {
                /* renamed from: a */
                public int compare(PointF pointF, PointF pointF2) {
                    if (pointF.x < pointF2.x) {
                        return -1;
                    }
                    return pointF.x > pointF2.x ? 1 : 0;
                }
            });
            Point[] pointArr = new Point[pointFArr2.length];
            for (int i = 0; i < pointFArr.length; i++) {
                PointF pointF = pointFArr2[i];
                pointArr[i] = new Point((int) (pointF.x * 255.0f), (int) (pointF.y * 255.0f));
            }
            ArrayList<Point> a = m1882a(pointArr);
            if (a == null) {
                return null;
            }
            Point point = a.get(0);
            if (point != null && point.x > 0) {
                for (int i2 = point.x; i2 >= 0; i2--) {
                    a.add(0, new Point(i2, 0));
                }
            }
            Point point2 = a.get(a.size() - 1);
            if (point2 != null && point2.x < 255) {
                int i3 = point2.x;
                while (true) {
                    i3++;
                    if (i3 > 255) {
                        break;
                    }
                    a.add(new Point(i3, 255));
                }
            }
            arrayList = new ArrayList<>(a.size());
            Iterator<Point> it = a.iterator();
            while (it.hasNext()) {
                Point next = it.next();
                Point point3 = new Point(next.x, next.x);
                float sqrt = (float) Math.sqrt(Math.pow((double) (point3.x - next.x), 2.0d) + Math.pow((double) (point3.y - next.y), 2.0d));
                if (point3.y > next.y) {
                    sqrt = -sqrt;
                }
                arrayList.add(Float.valueOf(sqrt));
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    private void m1891m() {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                GLES20.glActiveTexture(33987);
                GLES20.glBindTexture(3553, C0735r.this.f1567a[0]);
                if (C0735r.this.f1574r.size() >= 256 && C0735r.this.f1575s.size() >= 256 && C0735r.this.f1576t.size() >= 256 && C0735r.this.f1573q.size() >= 256) {
                    byte[] unused = C0735r.this.f1577u = new byte[1024];
                    for (int i = 0; i < 256; i++) {
                        int i2 = i * 4;
                        float f = (float) i;
                        C0735r.this.f1577u[i2 + 2] = (byte) (((int) Math.min(Math.max(((Float) C0735r.this.f1576t.get(i)).floatValue() + f + ((Float) C0735r.this.f1573q.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                        C0735r.this.f1577u[i2 + 1] = (byte) (((int) Math.min(Math.max(((Float) C0735r.this.f1575s.get(i)).floatValue() + f + ((Float) C0735r.this.f1573q.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                        C0735r.this.f1577u[i2] = (byte) (((int) Math.min(Math.max(f + ((Float) C0735r.this.f1574r.get(i)).floatValue() + ((Float) C0735r.this.f1573q.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                        C0735r.this.f1577u[i2 + 3] = -1;
                    }
                    GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(C0735r.this.f1577u));
                }
            }
        });
    }

    /* renamed from: n */
    private void m1892n() {
        mo9992a((Runnable) new Runnable() {
            public void run() {
                GLES20.glActiveTexture(33987);
                GLES20.glBindTexture(3553, C0735r.this.f1567a[0]);
                GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(C0735r.this.f1577u));
            }
        });
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1568l = GLES20.glGetUniformLocation(mo10012j(), "toneCurveTexture");
        GLES20.glActiveTexture(33987);
        GLES20.glGenTextures(1, this.f1567a, 0);
        GLES20.glBindTexture(3553, this.f1567a[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, PackUtils.FIXED_BUFFER_SIZE, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        if (this.f1577u != null && this.f1577u.length == 1024) {
            GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(this.f1577u));
        }
    }

    /* renamed from: a */
    public void mo10049a(InputStream inputStream) {
        try {
            m1888d(inputStream);
            short d = m1888d(inputStream);
            ArrayList arrayList = new ArrayList(d);
            for (int i = 0; i < d; i++) {
                int d2 = m1888d(inputStream);
                PointF[] pointFArr = new PointF[d2];
                for (int i2 = 0; i2 < d2; i2++) {
                    pointFArr[i2] = new PointF(((float) m1888d(inputStream)) * 0.003921569f, ((float) m1888d(inputStream)) * 0.003921569f);
                }
                arrayList.add(pointFArr);
            }
            inputStream.close();
            this.f1569m = (PointF[]) arrayList.get(0);
            this.f1570n = (PointF[]) arrayList.get(1);
            this.f1571o = (PointF[]) arrayList.get(2);
            this.f1572p = (PointF[]) arrayList.get(3);
            mo10050a(this.f1569m);
            mo10052b(this.f1570n);
            mo10054c(this.f1571o);
            mo10055d(this.f1572p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NegativeArraySizeException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo10050a(PointF[] pointFArr) {
        this.f1569m = pointFArr;
        this.f1573q = m1889e(this.f1569m);
        m1891m();
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
    }

    /* JADX WARNING: type inference failed for: r11v3, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r9v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v8, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v13, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10051b(java.io.InputStream r11) {
        /*
            r10 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r0.<init>()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r1 = 100
            byte[] r2 = new byte[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x0009:
            r3 = 0
            int r4 = r11.read(r2, r3, r1)     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r4 <= 0) goto L_0x0014
            r0.write(r2, r3, r4)     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            goto L_0x0009
        L_0x0014:
            r11.close()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r0.toByteArray()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r0.close()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r10.f1577u = r1     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r1 = 256(0x100, float:3.59E-43)
            int[] r2 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int[] r4 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int[] r5 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int[] r6 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r7 = 0
        L_0x002f:
            if (r7 >= r1) goto L_0x0041
            byte r8 = r11[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r6[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r6[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r8 >= 0) goto L_0x003e
            r8 = r6[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r8 = r8 + r1
            r6[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x003e:
            int r7 = r7 + 1
            goto L_0x002f
        L_0x0041:
            r7 = 256(0x100, float:3.59E-43)
        L_0x0043:
            r8 = 512(0x200, float:7.175E-43)
            if (r7 >= r8) goto L_0x0059
            int r8 = r7 + -256
            byte r9 = r11[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r2[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r9 = r2[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r9 >= 0) goto L_0x0056
            r9 = r2[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r9 = r9 + r1
            r2[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x0056:
            int r7 = r7 + 1
            goto L_0x0043
        L_0x0059:
            r7 = 768(0x300, float:1.076E-42)
            if (r8 >= r7) goto L_0x006f
            int r7 = r8 + -512
            byte r9 = r11[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r4[r7] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r9 = r4[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r9 >= 0) goto L_0x006c
            r9 = r4[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r9 = r9 + r1
            r4[r7] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x006c:
            int r8 = r8 + 1
            goto L_0x0059
        L_0x006f:
            if (r7 >= r0) goto L_0x0083
            int r8 = r7 + -768
            byte r9 = r11[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r5[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r9 = r5[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r9 >= 0) goto L_0x0080
            r9 = r5[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r9 = r9 + r1
            r5[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x0080:
            int r7 = r7 + 1
            goto L_0x006f
        L_0x0083:
            if (r3 >= r1) goto L_0x00b6
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r0 = r3 * 4
            r7 = r6[r3]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r7 = r5[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r11[r0] = r7     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r7 = r0 + 1
            r8 = r6[r3]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r4[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r11[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r7 = r0 + 2
            r8 = r6[r3]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r2[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r11[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r0 = r0 + 3
            r7 = -1
            r11[r0] = r7     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r3 = r3 + 1
            goto L_0x0083
        L_0x00b6:
            r10.m1892n()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            goto L_0x00c3
        L_0x00ba:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x00c3
        L_0x00bf:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.gpuimage.p039a.C0735r.mo10051b(java.io.InputStream):void");
    }

    /* renamed from: b */
    public void mo10052b(PointF[] pointFArr) {
        this.f1570n = pointFArr;
        this.f1574r = m1889e(this.f1570n);
        m1891m();
    }

    /* JADX WARNING: type inference failed for: r11v3, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r9v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v8, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v13, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10053c(java.io.InputStream r11) {
        /*
            r10 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r0.<init>()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r1 = 100
            byte[] r2 = new byte[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x0009:
            r3 = 0
            int r4 = r11.read(r2, r3, r1)     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r4 <= 0) goto L_0x0014
            r0.write(r2, r3, r4)     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            goto L_0x0009
        L_0x0014:
            r11.close()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r0.toByteArray()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r0.close()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r10.f1577u = r1     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r1 = 256(0x100, float:3.59E-43)
            int[] r2 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int[] r4 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int[] r5 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int[] r6 = new int[r1]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r7 = 0
        L_0x002f:
            if (r7 >= r1) goto L_0x0041
            byte r8 = r11[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r6[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r6[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r8 >= 0) goto L_0x003e
            r8 = r6[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r8 = r8 + r1
            r6[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x003e:
            int r7 = r7 + 1
            goto L_0x002f
        L_0x0041:
            r7 = 256(0x100, float:3.59E-43)
        L_0x0043:
            r8 = 512(0x200, float:7.175E-43)
            if (r7 >= r8) goto L_0x0059
            int r8 = r7 + -256
            byte r9 = r11[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r2[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r9 = r2[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r9 >= 0) goto L_0x0056
            r9 = r2[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r9 = r9 + r1
            r2[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x0056:
            int r7 = r7 + 1
            goto L_0x0043
        L_0x0059:
            r7 = 768(0x300, float:1.076E-42)
            if (r8 >= r7) goto L_0x006f
            int r7 = r8 + -512
            byte r9 = r11[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r4[r7] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r9 = r4[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r9 >= 0) goto L_0x006c
            r9 = r4[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r9 = r9 + r1
            r4[r7] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x006c:
            int r8 = r8 + 1
            goto L_0x0059
        L_0x006f:
            if (r7 >= r0) goto L_0x0083
            int r8 = r7 + -768
            byte r9 = r11[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r5[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r9 = r5[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            if (r9 >= 0) goto L_0x0080
            r9 = r5[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r9 = r9 + r1
            r5[r8] = r9     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
        L_0x0080:
            int r7 = r7 + 1
            goto L_0x006f
        L_0x0083:
            if (r3 >= r1) goto L_0x00b6
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r0 = r3 * 4
            r7 = r5[r3]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r7 = r6[r7]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r11[r0] = r7     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r7 = r0 + 1
            r8 = r4[r3]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r6[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r11[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r7 = r0 + 2
            r8 = r2[r3]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r6[r8]     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            r11[r7] = r8     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            byte[] r11 = r10.f1577u     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r0 = r0 + 3
            r7 = -1
            r11[r0] = r7     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            int r3 = r3 + 1
            goto L_0x0083
        L_0x00b6:
            r10.m1892n()     // Catch:{ IOException -> 0x00bf, ArrayIndexOutOfBoundsException -> 0x00ba }
            goto L_0x00c3
        L_0x00ba:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x00c3
        L_0x00bf:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.blend.gpuimage.p039a.C0735r.mo10053c(java.io.InputStream):void");
    }

    /* renamed from: c */
    public void mo10054c(PointF[] pointFArr) {
        this.f1571o = pointFArr;
        this.f1575s = m1889e(this.f1571o);
        m1891m();
    }

    /* renamed from: d */
    public void mo10055d(PointF[] pointFArr) {
        this.f1572p = pointFArr;
        this.f1576t = m1889e(this.f1572p);
        m1891m();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo10008f() {
        if (this.f1567a[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f1567a[0]);
            GLES20.glUniform1i(this.f1568l, 3);
        }
    }
}
