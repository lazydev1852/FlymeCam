package com.baidu.p020ar.paddle;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.p020ar.imgseg.C0766a;
import com.baidu.p020ar.p021a.C0486a;
import com.baidu.p020ar.p021a.p022a.p023a.C0487a;
import com.baidu.p020ar.p021a.p022a.p023a.C0491b;
import com.baidu.p020ar.p021a.p026b.p027a.C0499a;
import com.baidu.p020ar.rotate.Orientation;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.mediatek.media.MtkMediaStore;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.baidu.ar.paddle.PaddleController */
public class PaddleController {
    public static final int PADDLE_GESTURE_CONTROL = 5001;
    public static final int PADDLE_GESTURE_STATUS_DETECTED = 5002;
    public static final int PADDLE_IMG_SEG_CONTROL = 5011;
    public static final String PADDLE_TYPE_GESTURE = "1";
    public static final String PADDLE_TYPE_IMG_SEG = "2";
    public static final String SDK_TO_LUA_GESTURE_RESULT_BODY = "gesture_result";
    public static final String SDK_TO_LUA_GESTURE_RESULT_COUNT = "gesture_count";
    public static final String SDK_TO_LUA_GESTURE_RESULT_RESERVED = "reserved";
    public static final String SDK_TO_LUA_GESTURE_RESULT_SCORE = "score";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TYPE = "type";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X1 = "x1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X2 = "x2";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y1 = "y1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y2 = "y2";

    /* renamed from: A */
    private ArrayList<Float> f1909A = new ArrayList<>();

    /* renamed from: B */
    private float f1910B = -1.0f;

    /* renamed from: C */
    private float f1911C = -1.0f;

    /* renamed from: D */
    private float f1912D = -1.0f;

    /* renamed from: E */
    private ArrayList<Float> f1913E = new ArrayList<>();

    /* renamed from: F */
    private ArrayList<Float> f1914F = new ArrayList<>();

    /* renamed from: G */
    private ArrayList<Float> f1915G = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f1916H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f1917I;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public STATE f1918a = STATE.CLOSED;

    /* renamed from: b */
    private C0491b f1919b;

    /* renamed from: c */
    private C0818a f1920c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f1921d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f1922e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ActionListener f1923f;

    /* renamed from: g */
    private C0487a f1924g;

    /* renamed from: h */
    private ArrayList<String> f1925h = new ArrayList<>();

    /* renamed from: i */
    private String f1926i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f1927j = "1";

    /* renamed from: k */
    private ArrayList<String> f1928k = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f1929l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f1930m = 0;

    /* renamed from: n */
    private ArrayList<Integer> f1931n = new ArrayList<>();

    /* renamed from: o */
    private ArrayList<Integer> f1932o = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public float f1933p = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public float f1934q = -1.0f;

    /* renamed from: r */
    private ArrayList<Float> f1935r = new ArrayList<>();

    /* renamed from: s */
    private ArrayList<Float> f1936s = new ArrayList<>();

    /* renamed from: t */
    private String f1937t;

    /* renamed from: u */
    private ArrayList<String> f1938u = new ArrayList<>();

    /* renamed from: v */
    private float f1939v = -1.0f;

    /* renamed from: w */
    private float f1940w = -1.0f;

    /* renamed from: x */
    private float f1941x = -1.0f;

    /* renamed from: y */
    private ArrayList<Float> f1942y = new ArrayList<>();

    /* renamed from: z */
    private ArrayList<Float> f1943z = new ArrayList<>();

    /* renamed from: com.baidu.ar.paddle.PaddleController$ActionListener */
    public interface ActionListener {
        void onGestureResult(HashMap hashMap);

        void onImgSegResult(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

        void startImgSeg(String str);

        void stopImgSeg();
    }

    /* renamed from: com.baidu.ar.paddle.PaddleController$STATE */
    private enum STATE {
        INITING,
        INITED,
        CLOSING,
        CLOSED,
        WAIT_CLOSE
    }

    /* renamed from: com.baidu.ar.paddle.PaddleController$a */
    public static class C0818a implements C0499a {

        /* renamed from: a */
        private PaddleController f1951a;

        public C0818a(PaddleController paddleController) {
            this.f1951a = (PaddleController) new WeakReference(paddleController).get();
        }

        /* renamed from: a */
        private HashMap m2160a(float[] fArr) {
            float f;
            String str;
            int length = fArr.length / 7;
            HashMap hashMap = new HashMap();
            hashMap.put("id", 5002);
            hashMap.put(PaddleController.SDK_TO_LUA_GESTURE_RESULT_COUNT, Integer.valueOf(length));
            int i = 0;
            while (i < length) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                int i2 = i + 1;
                sb.append(i2);
                String concat = PaddleController.SDK_TO_LUA_GESTURE_RESULT_BODY.concat(sb.toString());
                HashMap hashMap2 = new HashMap();
                for (int i3 = 0; i3 < 7; i3++) {
                    switch (i3) {
                        case 0:
                            str = PaddleController.SDK_TO_LUA_GESTURE_RESULT_RESERVED;
                            f = fArr[(i * 7) + i3];
                            break;
                        case 1:
                            str = "type";
                            f = fArr[(i * 7) + i3];
                            break;
                        case 2:
                            str = PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE;
                            f = fArr[(i * 7) + i3];
                            break;
                        case 3:
                            str = PaddleController.SDK_TO_LUA_GESTURE_RESULT_X1;
                            f = fArr[(i * 7) + i3];
                            break;
                        case 4:
                            str = PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y1;
                            f = fArr[(i * 7) + i3];
                            break;
                        case 5:
                            str = PaddleController.SDK_TO_LUA_GESTURE_RESULT_X2;
                            f = fArr[(i * 7) + i3];
                            break;
                        case 6:
                            str = PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y2;
                            f = fArr[(i * 7) + i3];
                            break;
                    }
                    hashMap2.put(str, Float.valueOf(f));
                }
                hashMap.put(concat, hashMap2);
                i = i2;
            }
            return hashMap;
        }

        /* renamed from: a */
        public void mo8959a(Bundle bundle) {
            if (bundle == null) {
                boolean unused = this.f1951a.f1922e = true;
                return;
            }
            float[] floatArray = bundle.getFloatArray("result");
            byte[] byteArray = bundle.getByteArray("pixelBytes");
            byte[] byteArray2 = bundle.getByteArray("previewData");
            int i = bundle.getInt(MtkMediaStore.VideoColumns.ORIENTATION, -90);
            if (!(floatArray == null || floatArray.length == 0 || this.f1951a == null || this.f1951a.f1923f == null || !this.f1951a.f1927j.equals("1"))) {
                this.f1951a.f1923f.onGestureResult(m2160a(floatArray));
                StatisticHelper.getInstance().statisticPaddleFrameRate(StatisticConstants.PADDLE_GESTURE_FRAME_AVG_TIME);
            }
            if (!(this.f1951a == null || this.f1951a.f1923f == null || !this.f1951a.f1927j.equals("2"))) {
                byte[] bArr = new byte[(this.f1951a.f1917I * this.f1951a.f1916H * 4)];
                if (floatArray != null && floatArray.length > 0) {
                    C0766a.m1990a().mo10115a(byteArray, floatArray, this.f1951a.f1930m, this.f1951a.f1929l, this.f1951a.f1916H, this.f1951a.f1917I, this.f1951a.f1933p, this.f1951a.f1934q, bArr);
                    if (!(this.f1951a == null || this.f1951a.f1923f == null)) {
                        this.f1951a.f1923f.onImgSegResult(bArr, this.f1951a.f1916H, this.f1951a.f1917I, byteArray2, i);
                    }
                    StatisticHelper.getInstance().statisticPaddleFrameRate(StatisticConstants.PADDLE_IMG_SEG_FRAME_AVG_TIME);
                }
            }
            if (this.f1951a != null) {
                boolean unused2 = this.f1951a.f1922e = true;
            }
            if (this.f1951a != null && this.f1951a.f1918a == STATE.WAIT_CLOSE) {
                this.f1951a.setEnabled(false, this.f1951a.f1927j);
            }
        }
    }

    public PaddleController(Context context, ArrayList<String> arrayList, String str, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<Integer> arrayList4, ArrayList<Float> arrayList5, ArrayList<Float> arrayList6, ArrayList<String> arrayList7, ArrayList<Float> arrayList8, ArrayList<Float> arrayList9, ArrayList<Float> arrayList10, ArrayList<Float> arrayList11, ArrayList<Float> arrayList12, ArrayList<Float> arrayList13, C0487a aVar, ActionListener actionListener) {
        this.f1925h = arrayList;
        this.f1926i = str;
        this.f1928k = arrayList2;
        this.f1931n = arrayList3;
        this.f1932o = arrayList4;
        this.f1935r = arrayList5;
        this.f1936s = arrayList6;
        this.f1938u = arrayList7;
        this.f1942y = arrayList8;
        this.f1943z = arrayList9;
        this.f1909A = arrayList10;
        this.f1913E = arrayList11;
        this.f1914F = arrayList12;
        this.f1915G = arrayList13;
        this.f1924g = aVar;
        this.f1923f = actionListener;
        this.f1920c = new C0818a(this);
        if (this.f1919b == null) {
            Context context2 = context;
            this.f1919b = new C0491b(context, (String) null, this.f1926i, this.f1924g);
        }
    }

    /* renamed from: a */
    private void m2142a(String str) {
        StatisticHelper instance;
        String str2;
        if (StatisticHelper.getInstance().getPaddleFrameCount() > 0 && StatisticHelper.getInstance().getPaddleFrameCount() < StatisticHelper.getInstance().getPaddleMaxFrameCount()) {
            StatisticHelper.getInstance().setPaddleMaxFrameCount(StatisticHelper.getInstance().getPaddleFrameCount() + 1);
            if (str.equals("2")) {
                instance = StatisticHelper.getInstance();
                str2 = StatisticConstants.PADDLE_IMG_SEG_FRAME_AVG_TIME;
            } else if (str.equals("1")) {
                instance = StatisticHelper.getInstance();
                str2 = StatisticConstants.PADDLE_GESTURE_FRAME_AVG_TIME;
            }
            instance.statisticPaddleFrameRate(str2);
        }
        StatisticHelper.getInstance().resetAllPaddleValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2143a(boolean z) {
        if (!z) {
            m2142a(this.f1927j);
        }
        if (this.f1927j.equals("2") && this.f1923f != null) {
            if (z) {
                this.f1923f.startImgSeg(this.f1937t);
            } else {
                this.f1923f.stopImgSeg();
            }
        }
    }

    /* renamed from: a */
    private boolean m2144a() {
        if (this.f1919b != null) {
            return this.f1919b.mo8935a();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2146b() {
        if (this.f1919b != null) {
            C0486a.m834a(this.f1919b);
        }
    }

    /* renamed from: b */
    private void m2148b(String str) {
        if (this.f1919b != null) {
            int indexOf = this.f1928k.indexOf(str);
            this.f1927j = str;
            this.f1919b.mo8936b(str);
            if (this.f1925h.size() > indexOf && !TextUtils.isEmpty(this.f1925h.get(indexOf))) {
                this.f1919b.mo8934a(this.f1925h.get(indexOf));
            }
            if (this.f1931n.size() > indexOf && this.f1932o.size() > indexOf && this.f1931n.get(indexOf).intValue() > 0 && this.f1932o.get(indexOf).intValue() > 0) {
                this.f1919b.mo8932a(this.f1931n.get(indexOf).intValue(), this.f1932o.get(indexOf).intValue());
                this.f1929l = this.f1931n.get(indexOf).intValue();
                this.f1930m = this.f1932o.get(indexOf).intValue();
            }
            if (this.f1935r.size() > indexOf && this.f1935r.get(indexOf).floatValue() >= 0.0f) {
                this.f1933p = this.f1935r.get(indexOf).floatValue();
            }
            if (this.f1936s.size() > indexOf && this.f1936s.get(indexOf).floatValue() >= 0.0f) {
                this.f1934q = this.f1936s.get(indexOf).floatValue();
            }
            if (this.f1938u.size() > indexOf && !TextUtils.isEmpty(this.f1925h.get(indexOf))) {
                this.f1937t = this.f1938u.get(indexOf);
            }
            if (this.f1942y.size() > indexOf && this.f1942y.get(indexOf).floatValue() >= 0.0f) {
                this.f1939v = this.f1942y.get(indexOf).floatValue();
            }
            if (this.f1943z.size() > indexOf && this.f1943z.get(indexOf).floatValue() >= 0.0f) {
                this.f1940w = this.f1943z.get(indexOf).floatValue();
            }
            if (this.f1909A.size() > indexOf && this.f1909A.get(indexOf).floatValue() >= 0.0f) {
                this.f1941x = this.f1909A.get(indexOf).floatValue();
            }
            if (this.f1913E.size() > indexOf && this.f1913E.get(indexOf).floatValue() >= 0.0f) {
                this.f1910B = this.f1913E.get(indexOf).floatValue();
            }
            if (this.f1914F.size() > indexOf && this.f1914F.get(indexOf).floatValue() >= 0.0f) {
                this.f1911C = this.f1914F.get(indexOf).floatValue();
            }
            if (this.f1915G.size() > indexOf && this.f1915G.get(indexOf).floatValue() >= 0.0f) {
                this.f1912D = this.f1915G.get(indexOf).floatValue();
            }
            this.f1919b.mo8930a(this.f1939v, this.f1940w, this.f1941x, this.f1910B, this.f1911C, this.f1912D);
        }
    }

    public void onOrientationChange(Orientation orientation) {
        if (this.f1919b != null) {
            this.f1919b.mo8933a(orientation);
        }
    }

    public void release() {
        setEnabled(false, this.f1927j);
        C0766a.m1990a().mo10116b();
        if (this.f1919b != null) {
            this.f1919b.mo8938c();
            if (!this.f1921d) {
                this.f1919b = null;
            }
        }
        if (this.f1920c != null) {
            this.f1920c = null;
        }
        if (this.f1923f != null) {
            this.f1923f = null;
        }
        if (this.f1924g != null) {
            this.f1924g = null;
        }
    }

    public void runPaddle(byte[] bArr, int i, int i2) {
        if (this.f1921d && this.f1922e && this.f1918a == STATE.INITED) {
            this.f1922e = false;
            this.f1916H = i;
            this.f1917I = i2;
            C0486a.m838a(bArr, i, i2, this.f1919b, (C0499a) this.f1920c, 1);
        }
    }

    public void setCameraType(int i) {
        this.f1919b.mo8931a(i);
    }

    public boolean setEnabled(boolean z, String str) {
        if (z && this.f1921d && !this.f1927j.equals(str)) {
            if (this.f1928k == null || this.f1928k.size() <= 0 || !this.f1928k.contains(str)) {
                return false;
            }
            setEnabled(false, this.f1927j);
            setEnabled(z, str);
        }
        if ((z == this.f1921d && this.f1927j.equals(str)) || ((!z && this.f1921d && !this.f1927j.equals(str)) || this.f1918a == STATE.INITING || this.f1918a == STATE.CLOSING || TextUtils.isEmpty(str))) {
            return false;
        }
        if (!z) {
            this.f1918a = STATE.CLOSING;
            if (!this.f1922e) {
                this.f1918a = STATE.WAIT_CLOSE;
                return true;
            }
            new Thread(new Runnable() {
                public void run() {
                    PaddleController.this.m2146b();
                    boolean unused = PaddleController.this.f1921d = false;
                    STATE unused2 = PaddleController.this.f1918a = STATE.CLOSED;
                    PaddleController.this.m2143a(PaddleController.this.f1921d);
                    String unused3 = PaddleController.this.f1927j = "1";
                }
            }).start();
        } else if (this.f1918a == STATE.WAIT_CLOSE) {
            return true;
        } else {
            this.f1918a = STATE.INITING;
            if (this.f1928k == null || this.f1928k.size() <= 0 || !this.f1928k.contains(str)) {
                this.f1918a = STATE.CLOSED;
                return false;
            }
            m2148b(str);
            if (m2144a()) {
                this.f1921d = true;
                this.f1918a = STATE.INITED;
                m2143a(this.f1921d);
            } else {
                this.f1921d = false;
                this.f1918a = STATE.CLOSED;
            }
        }
        return true;
    }
}
