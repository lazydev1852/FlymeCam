package com.baidu.p020ar.arplay.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.baidu.ar.arplay.core.ARPTouchInput */
public class ARPTouchInput {

    /* renamed from: v */
    private static final double[] f815v = {1.5707963267948966d, 3.141592653589793d};
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f816A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f817B = false;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f818C = false;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f819D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f820E = false;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f821F = false;

    /* renamed from: G */
    private boolean f822G = true;

    /* renamed from: H */
    private boolean f823H = false;

    /* renamed from: I */
    private int f824I = 0;

    /* renamed from: J */
    private int f825J = 0;

    /* renamed from: K */
    private C0575a f826K = null;

    /* renamed from: L */
    private Map<Integer, Vector<Float>> f827L = new HashMap();

    /* renamed from: M */
    private boolean f828M = false;

    /* renamed from: a */
    ARPMessage.MessageHandler f829a = new ARPMessage.MessageHandler() {
        public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get("disable_all") != null) {
                    if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                        boolean unused = ARPTouchInput.this.f851x = true;
                    } else {
                        boolean unused2 = ARPTouchInput.this.f851x = false;
                    }
                }
                if (hashMap.get("disable_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                        boolean unused3 = ARPTouchInput.this.f852y = true;
                    } else {
                        boolean unused4 = ARPTouchInput.this.f852y = false;
                    }
                }
                if (hashMap.get("disable_double_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                        boolean unused5 = ARPTouchInput.this.f853z = true;
                    } else {
                        boolean unused6 = ARPTouchInput.this.f853z = false;
                    }
                }
                if (hashMap.get("disable_long_press") != null) {
                    if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                        boolean unused7 = ARPTouchInput.this.f816A = true;
                    } else {
                        boolean unused8 = ARPTouchInput.this.f816A = false;
                    }
                }
                if (hashMap.get("disable_swipe") != null) {
                    if (1 == ((Integer) hashMap.get("disable_swipe")).intValue()) {
                        boolean unused9 = ARPTouchInput.this.f817B = true;
                    } else {
                        boolean unused10 = ARPTouchInput.this.f817B = false;
                    }
                }
                if (hashMap.get("disable_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                        boolean unused11 = ARPTouchInput.this.f818C = true;
                    } else {
                        boolean unused12 = ARPTouchInput.this.f818C = false;
                    }
                }
                if (hashMap.get("disable_two_finger_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                        boolean unused13 = ARPTouchInput.this.f819D = true;
                    } else {
                        boolean unused14 = ARPTouchInput.this.f819D = false;
                    }
                }
                if (hashMap.get("disable_pinch") != null) {
                    if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                        boolean unused15 = ARPTouchInput.this.f820E = true;
                    } else {
                        boolean unused16 = ARPTouchInput.this.f820E = false;
                    }
                }
                if (hashMap.get("disable_two_finger_rotate") == null) {
                    return;
                }
                if (1 == ((Integer) hashMap.get("disable_two_finger_rotate")).intValue()) {
                    boolean unused17 = ARPTouchInput.this.f821F = true;
                } else {
                    boolean unused18 = ARPTouchInput.this.f821F = false;
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TouchEventStatus f830b = TouchEventStatus.EStatSingleFingerCandidate;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f831c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f832d = -1;

    /* renamed from: e */
    private float f833e = -1.0f;

    /* renamed from: f */
    private float f834f = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f835g = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f836h = -1.0f;

    /* renamed from: i */
    private long f837i = -1;

    /* renamed from: j */
    private int f838j = -1;

    /* renamed from: k */
    private float f839k = -1.0f;

    /* renamed from: l */
    private float f840l = -1.0f;

    /* renamed from: m */
    private float f841m = -1.0f;

    /* renamed from: n */
    private float f842n = -1.0f;

    /* renamed from: o */
    private long f843o = -1;

    /* renamed from: p */
    private double f844p = -1.0d;

    /* renamed from: q */
    private double f845q = -1.0d;

    /* renamed from: r */
    private double f846r = -1.0d;

    /* renamed from: s */
    private C0576b f847s;

    /* renamed from: t */
    private boolean f848t = true;

    /* renamed from: u */
    private boolean f849u = false;

    /* renamed from: w */
    private SwipeDirection f850w = SwipeDirection.ESWIPE_RIGHT;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f851x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f852y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f853z = false;

    /* renamed from: com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType */
    public enum GestureEventType {
        EGESTURE_CLICK,
        EGESTURE_DOUBLE_CLICK,
        EGESTURE_LONG_PRESS,
        EGESTURE_SWIPE,
        EGESTURE_SINGLE_FINGER_SCROLL,
        EGESTURE_TWO_FINGER_SCROLL,
        EGESTURE_TWO_FINGER_PINCH,
        EGESTURE_TWO_FINGER_UNPINCH,
        EGESTURE_TWO_FINGER_ROTATE,
        EGESTURE_CLEAR
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPTouchInput$SwipeDirection */
    public enum SwipeDirection {
        ESWIPE_RIGHT,
        ESWIPE_LEFT,
        ESWIPE_UP,
        ESWIPE_DOWN
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus */
    public enum TouchEventStatus {
        EStatSingleFingerCandidate,
        EStatTwoFingersCandidate,
        EStatLongPresss,
        EStatScroll,
        EStatSwipe,
        EStatTwoFingersScroll,
        EStatPinch,
        EStatUnPinch,
        EScrollAfterLongPress,
        EStatPinchAndUnpinch,
        EStatTwoFingerRotate,
        EStatUnknown
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPTouchInput$TouchPhase */
    public enum TouchPhase {
        ETOUCH_BEGIN,
        ETOUCH_MOVE,
        ETOUCH_END,
        ETOUCH_CANCEL
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPTouchInput$a */
    private static class C0575a {

        /* renamed from: a */
        public int f890a;

        /* renamed from: b */
        public float f891b;

        /* renamed from: c */
        public float f892c;

        /* renamed from: d */
        public long f893d;

        private C0575a() {
        }
    }

    /* renamed from: com.baidu.ar.arplay.core.ARPTouchInput$b */
    private static class C0576b extends Handler {

        /* renamed from: a */
        WeakReference<ARPTouchInput> f894a;

        public C0576b(Looper looper, ARPTouchInput aRPTouchInput) {
            super(looper);
            this.f894a = new WeakReference<>(aRPTouchInput);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.baidu.ar.arplay.core.ARPTouchInput} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r20) {
            /*
                r19 = this;
                r0 = r19
                r1 = r20
                super.handleMessage(r20)
                int r2 = r1.what
                switch(r2) {
                    case 1: goto L_0x007d;
                    case 2: goto L_0x000e;
                    default: goto L_0x000c;
                }
            L_0x000c:
                goto L_0x0109
            L_0x000e:
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r2 = r0.f894a
                java.lang.Object r2 = r2.get()
                com.baidu.ar.arplay.core.ARPTouchInput r2 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r2
                if (r2 == 0) goto L_0x0109
                java.lang.Object r3 = r1.obj
                if (r3 == 0) goto L_0x0109
                java.lang.Object r1 = r1.obj
                com.baidu.ar.arplay.core.ARPTouchInput$a r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput.C0575a) r1
                boolean r2 = r2.f852y
                if (r2 != 0) goto L_0x0051
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r2 = r0.f894a
                java.lang.Object r2 = r2.get()
                r3 = r2
                com.baidu.ar.arplay.core.ARPTouchInput r3 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r3
                com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r2 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLICK
                int r4 = r2.ordinal()
                long r5 = r1.f893d
                int r7 = r1.f890a
                float r8 = r1.f891b
                float r9 = r1.f892c
                r10 = -1082130432(0xffffffffbf800000, float:-1.0)
                r11 = -1082130432(0xffffffffbf800000, float:-1.0)
                r12 = -1
                r13 = -1082130432(0xffffffffbf800000, float:-1.0)
                r14 = -1082130432(0xffffffffbf800000, float:-1.0)
                r15 = -1082130432(0xffffffffbf800000, float:-1.0)
                r16 = -1082130432(0xffffffffbf800000, float:-1.0)
                r17 = -1
                r18 = 0
                r3.mo9223a(r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            L_0x0051:
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                r2 = r1
                com.baidu.ar.arplay.core.ARPTouchInput r2 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r2
                com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r1 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLEAR
                int r3 = r1.ordinal()
                r4 = -1
                r6 = -1
                r7 = -1082130432(0xffffffffbf800000, float:-1.0)
                r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x0067:
                r9 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10 = -1082130432(0xffffffffbf800000, float:-1.0)
                r11 = -1
                r12 = -1082130432(0xffffffffbf800000, float:-1.0)
                r13 = -1082130432(0xffffffffbf800000, float:-1.0)
                r14 = -1082130432(0xffffffffbf800000, float:-1.0)
                r15 = -1082130432(0xffffffffbf800000, float:-1.0)
                r16 = -1
                r17 = 0
                r2.mo9223a(r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                goto L_0x0109
            L_0x007d:
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                if (r1 == 0) goto L_0x0109
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r1 = r1.f830b
                com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r2 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatSingleFingerCandidate
                if (r1 != r2) goto L_0x0109
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                boolean r1 = r1.f831c
                if (r1 == 0) goto L_0x0109
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r2 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatLongPresss
                com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus unused = r1.f830b = r2
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                boolean r1 = r1.f851x
                if (r1 != 0) goto L_0x0109
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                boolean r1 = r1.f816A
                if (r1 != 0) goto L_0x0109
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                r2 = r1
                com.baidu.ar.arplay.core.ARPTouchInput r2 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r2
                com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r1 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_LONG_PRESS
                int r3 = r1.ordinal()
                java.util.Calendar r1 = java.util.Calendar.getInstance()
                long r4 = r1.getTimeInMillis()
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                int r6 = r1.f832d
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                float r7 = r1.f835g
                java.lang.ref.WeakReference<com.baidu.ar.arplay.core.ARPTouchInput> r1 = r0.f894a
                java.lang.Object r1 = r1.get()
                com.baidu.ar.arplay.core.ARPTouchInput r1 = (com.baidu.p020ar.arplay.core.ARPTouchInput) r1
                float r8 = r1.f836h
                goto L_0x0067
            L_0x0109:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.core.ARPTouchInput.C0576b.handleMessage(android.os.Message):void");
        }
    }

    public ARPTouchInput(Looper looper) {
        this.f847s = new C0576b(looper, this);
    }

    /* renamed from: a */
    private double m1090a(double d, double d2, double d3, double d4) {
        double atan2 = Math.atan2(d4, d3) - Math.atan2(d2, d);
        return atan2 > 3.141592653589793d ? atan2 - 6.283185307179586d : atan2 < -3.141592653589793d ? atan2 + 6.283185307179586d : atan2;
    }

    /* renamed from: a */
    private double m1091a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    /* renamed from: a */
    private double m1092a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f3 - f;
        float f10 = f4 - f2;
        float f11 = f7 - f5;
        float f12 = f8 - f6;
        mo9225a(String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", new Object[]{Float.valueOf(f9), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12)}));
        double sqrt = ((double) ((f9 * f11) + (f10 * f12))) / (Math.sqrt((double) ((f9 * f9) + (f10 * f10))) * Math.sqrt((double) ((f11 * f11) + (f12 * f12))));
        try {
            sqrt = Double.parseDouble(new DecimalFormat("#.00").format(sqrt));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        double acos = Math.acos(sqrt);
        mo9225a("touchopt" + String.format("angle is %1.3f", new Object[]{Double.valueOf(Math.toDegrees(acos))}));
        return acos;
    }

    /* renamed from: a */
    private void m1095a(int i, float f, float f2, float f3, float f4, long j, int i2, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        if (this.f823H) {
            f8 = f;
            f6 = f3;
            f9 = ((float) this.f825J) - f2;
            f7 = -f4;
        } else {
            f9 = f;
            f8 = f2;
            f7 = f3;
            f6 = f4;
        }
        ARPEngine.getInstance().onTouchUpdate(i, f9, f8, f7, f6, j, i2, f5);
    }

    /* renamed from: b */
    private float m1097b(MotionEvent motionEvent) {
        try {
            return (motionEvent.getX(motionEvent.findPointerIndex(this.f832d)) - this.f835g) / ((float) (motionEvent.getEventTime() - this.f837i));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: c */
    private float m1100c(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.f832d)) - this.f836h) / ((float) (motionEvent.getEventTime() - this.f837i));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: c */
    private void m1101c() {
        this.f830b = TouchEventStatus.EStatSingleFingerCandidate;
        this.f831c = true;
        this.f844p = -1.0d;
        this.f847s.removeMessages(1);
        if (!this.f847s.hasMessages(2)) {
            mo9223a(GestureEventType.EGESTURE_CLEAR.ordinal(), -1, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        }
    }

    /* renamed from: d */
    private float m1104d(MotionEvent motionEvent) {
        try {
            return (motionEvent.getX(motionEvent.findPointerIndex(this.f838j)) - this.f841m) / ((float) (motionEvent.getEventTime() - this.f843o));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: d */
    private void m1105d() {
        if (this.f847s.hasMessages(2)) {
            this.f847s.removeMessages(2);
            if (this.f826K != null) {
                if (!this.f852y) {
                    mo9223a(GestureEventType.EGESTURE_CLICK.ordinal(), this.f826K.f893d, this.f826K.f890a, this.f826K.f891b, this.f826K.f892c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                }
                mo9223a(GestureEventType.EGESTURE_CLEAR.ordinal(), -1, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                this.f826K = null;
                return;
            }
        }
    }

    /* renamed from: e */
    private float m1108e(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.f838j)) - this.f842n) / ((float) (motionEvent.getEventTime() - this.f843o));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: f */
    private float m1111f(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.f832d));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: g */
    private float m1114g(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.f832d));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: h */
    private float m1117h(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.f838j));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: i */
    private float m1120i(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.f838j));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: j */
    private void m1122j(MotionEvent motionEvent) {
        float f;
        long j;
        float f2;
        float f3;
        float f4;
        float f5;
        int i;
        TouchPhase touchPhase;
        float f6;
        float f7;
        float f8;
        float f9;
        int i2;
        MotionEvent motionEvent2 = motionEvent;
        if (motionEvent.getPointerCount() > 0) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    i = motionEvent2.getPointerId(actionIndex);
                    f5 = motionEvent2.getX(actionIndex);
                    f4 = motionEvent2.getY(actionIndex);
                    f3 = 0.0f;
                    f2 = 0.0f;
                    Vector vector = new Vector(2);
                    vector.add(Float.valueOf(f5));
                    vector.add(Float.valueOf(f4));
                    this.f827L.put(Integer.valueOf(i), vector);
                    j = motionEvent.getEventTime();
                    f = motionEvent2.getPressure(actionIndex);
                    touchPhase = TouchPhase.ETOUCH_BEGIN;
                    break;
                case 1:
                case 6:
                    int actionIndex2 = motionEvent.getActionIndex();
                    i = motionEvent2.getPointerId(actionIndex2);
                    f5 = motionEvent2.getX(actionIndex2);
                    f4 = motionEvent2.getY(actionIndex2);
                    if (this.f827L.containsKey(Integer.valueOf(i))) {
                        Vector vector2 = this.f827L.get(Integer.valueOf(i));
                        this.f827L.remove(Integer.valueOf(i));
                        float floatValue = f5 - ((Float) vector2.elementAt(0)).floatValue();
                        f7 = f4 - ((Float) vector2.elementAt(1)).floatValue();
                        f6 = floatValue;
                    } else {
                        f6 = 0.0f;
                        f7 = 0.0f;
                    }
                    j = motionEvent.getEventTime();
                    f = motionEvent2.getPressure(actionIndex2);
                    touchPhase = TouchPhase.ETOUCH_END;
                    break;
                case 2:
                    int pointerCount = motionEvent.getPointerCount();
                    int i3 = 0;
                    while (i3 < pointerCount) {
                        int pointerId = motionEvent2.getPointerId(i3);
                        float x = motionEvent2.getX(i3);
                        float y = motionEvent2.getY(i3);
                        if (this.f827L.containsKey(Integer.valueOf(pointerId))) {
                            Vector vector3 = this.f827L.get(Integer.valueOf(pointerId));
                            f9 = x - ((Float) vector3.firstElement()).floatValue();
                            f8 = y - ((Float) vector3.lastElement()).floatValue();
                            vector3.setElementAt(Float.valueOf(x), 0);
                            vector3.setElementAt(Float.valueOf(y), 1);
                        } else {
                            f9 = 0.0f;
                            f8 = 0.0f;
                        }
                        if (Math.abs(f9) > 0.1f || Math.abs(f8) > 0.1f) {
                            long eventTime = motionEvent.getEventTime();
                            float pressure = motionEvent2.getPressure(i3);
                            i2 = i3;
                            m1095a(pointerId, x, y, f9, f8, eventTime, TouchPhase.ETOUCH_MOVE.ordinal(), pressure);
                        } else {
                            i2 = i3;
                        }
                        i3 = i2 + 1;
                    }
                    return;
                case 3:
                    int actionIndex3 = motionEvent.getActionIndex();
                    i = motionEvent2.getPointerId(actionIndex3);
                    f5 = motionEvent2.getX(actionIndex3);
                    f4 = motionEvent2.getY(actionIndex3);
                    if (this.f827L.containsKey(Integer.valueOf(i))) {
                        Vector vector4 = this.f827L.get(Integer.valueOf(i));
                        this.f827L.remove(Integer.valueOf(i));
                        float floatValue2 = f5 - ((Float) vector4.elementAt(0)).floatValue();
                        f2 = f4 - ((Float) vector4.elementAt(1)).floatValue();
                        f3 = floatValue2;
                    } else {
                        f3 = 0.0f;
                        f2 = 0.0f;
                    }
                    j = motionEvent.getEventTime();
                    f = motionEvent2.getPressure(actionIndex3);
                    touchPhase = TouchPhase.ETOUCH_CANCEL;
                    break;
                default:
                    return;
            }
            m1095a(i, f5, f4, f3, f2, j, touchPhase.ordinal(), f);
        }
    }

    /* renamed from: a */
    public void mo9221a() {
        ARPMessage.getInstance().registerMessageHandler(11, this.f829a);
    }

    /* renamed from: a */
    public void mo9222a(int i, int i2) {
        this.f825J = i2;
        this.f824I = i;
    }

    /* renamed from: a */
    public void mo9223a(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (this.f823H) {
            f12 = f;
            f10 = f5;
            f13 = ((float) this.f825J) - f2;
            f11 = ((float) this.f825J) - f6;
        } else {
            f13 = f;
            f12 = f2;
            f11 = f5;
            f10 = f6;
        }
        ARPEngine.getInstance().onGestureUpdate(i, j, i2, f13, f12, f3, f4, i3, f11, f10, f7, f8, i4, f9);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (1 == r50.getActionMasked()) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        m1101c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x065c, code lost:
        r15.f830b = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.f883l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0094, code lost:
        if (1 == r50.getActionMasked()) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fd, code lost:
        if (1 == r50.getActionMasked()) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x018b, code lost:
        r15.f842n = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x018d, code lost:
        r15.f843o = r50.getEventTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0199, code lost:
        if (1 == r50.getActionMasked()) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x05fe A[Catch:{ Exception -> 0x064d }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0610 A[Catch:{ Exception -> 0x064d }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9224a(android.view.MotionEvent r50) {
        /*
            r49 = this;
            r15 = r49
            r14 = r50
            boolean r0 = r15.f828M
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r0 = r15.f822G
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            r49.m1122j(r50)
            int[] r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.C05742.f855a
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r1 = r15.f830b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 65280(0xff00, float:9.1477E-41)
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            r2 = 4632233691727265792(0x4049000000000000, double:50.0)
            r4 = 6
            r5 = 1
            r7 = 5
            r18 = 4626322717216342016(0x4034000000000000, double:20.0)
            r13 = 0
            r8 = 2
            r12 = 1
            switch(r0) {
                case 1: goto L_0x07cd;
                case 2: goto L_0x0656;
                case 3: goto L_0x04af;
                case 4: goto L_0x046b;
                case 5: goto L_0x037c;
                case 6: goto L_0x019d;
                case 7: goto L_0x0101;
                case 8: goto L_0x0097;
                case 9: goto L_0x003b;
                case 10: goto L_0x0031;
                case 11: goto L_0x0031;
                case 12: goto L_0x0031;
                default: goto L_0x002e;
            }
        L_0x002e:
            r0 = r15
            goto L_0x0a94
        L_0x0031:
            int r0 = r50.getActionMasked()
            if (r12 != r0) goto L_0x002e
        L_0x0037:
            r49.m1101c()
            goto L_0x002e
        L_0x003b:
            int r0 = r50.getActionMasked()
            if (r8 != r0) goto L_0x0090
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x007b
            boolean r0 = r15.f818C
            if (r0 != 0) goto L_0x007b
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_SINGLE_FINGER_SCROLL
            int r1 = r0.ordinal()
            long r2 = r50.getEventTime()
            int r4 = r15.f832d
            float r5 = r50.getX()
            float r6 = r50.getY()
            float r7 = r49.m1097b((android.view.MotionEvent) r50)
            float r8 = r49.m1100c((android.view.MotionEvent) r50)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = -1
            r17 = 0
            r0 = r49
            r14 = r16
            r15 = r17
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x007b:
            float r0 = r49.m1111f((android.view.MotionEvent) r50)
            r15 = r49
            r15.f835g = r0
            float r0 = r49.m1114g((android.view.MotionEvent) r50)
        L_0x0087:
            r15.f836h = r0
            long r0 = r50.getEventTime()
            r15.f837i = r0
            goto L_0x002e
        L_0x0090:
            int r0 = r50.getActionMasked()
            if (r12 != r0) goto L_0x065c
            goto L_0x0037
        L_0x0097:
            int r0 = r50.getActionMasked()
            if (r8 != r0) goto L_0x00f9
            float r0 = r15.f833e
            float r1 = r15.f834f
            float r4 = r50.getX()
            float r5 = r50.getY()
            double r0 = r15.m1091a((float) r0, (float) r1, (float) r4, (float) r5)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EScrollAfterLongPress
            r15.f830b = r0
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x00ec
            boolean r0 = r15.f818C
            if (r0 != 0) goto L_0x00ec
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_SINGLE_FINGER_SCROLL
            int r1 = r0.ordinal()
            long r2 = r50.getEventTime()
            int r4 = r15.f832d
            float r5 = r50.getX()
            float r6 = r50.getY()
            float r7 = r49.m1097b((android.view.MotionEvent) r50)
            float r8 = r49.m1100c((android.view.MotionEvent) r50)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = -1
            r16 = 0
            r0 = r49
            r15 = r16
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x00ec:
            float r0 = r49.m1111f((android.view.MotionEvent) r50)
            r15 = r49
            r15.f835g = r0
            float r0 = r49.m1114g((android.view.MotionEvent) r50)
            goto L_0x0087
        L_0x00f9:
            int r0 = r50.getActionMasked()
            if (r12 != r0) goto L_0x065c
            goto L_0x0037
        L_0x0101:
            int r0 = r50.getActionMasked()
            if (r8 != r0) goto L_0x0195
            float r14 = r49.m1111f((android.view.MotionEvent) r50)
            float r13 = r49.m1114g((android.view.MotionEvent) r50)
            float r12 = r49.m1117h((android.view.MotionEvent) r50)
            float r11 = r49.m1120i(r50)
            float r0 = r15.f841m
            float r1 = r15.f835g
            float r0 = r0 - r1
            double r1 = (double) r0
            float r0 = r15.f842n
            float r3 = r15.f836h
            float r0 = r0 - r3
            double r3 = (double) r0
            float r0 = r12 - r14
            double r5 = (double) r0
            float r0 = r11 - r13
            double r7 = (double) r0
            r0 = r49
            double r0 = r0.m1090a((double) r1, (double) r3, (double) r5, (double) r7)
            boolean r2 = r15.f851x
            if (r2 != 0) goto L_0x0170
            boolean r2 = r15.f821F
            if (r2 != 0) goto L_0x0170
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r2 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_TWO_FINGER_ROTATE
            int r2 = r2.ordinal()
            long r3 = r50.getEventTime()
            int r5 = r15.f832d
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r9 = r15.f838j
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            r17 = -1082130432(0xffffffffbf800000, float:-1.0)
            r18 = -1
            float r10 = (float) r0
            r0 = r49
            r1 = r2
            r2 = r3
            r4 = r5
            r5 = r14
            r6 = r13
            r19 = r10
            r10 = r12
            r20 = r11
            r21 = r12
            r12 = r16
            r22 = r13
            r13 = r17
            r23 = r14
            r14 = r18
            r15 = r19
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r23
            goto L_0x0177
        L_0x0170:
            r20 = r11
            r21 = r12
            r22 = r13
            r0 = r14
        L_0x0177:
            r15 = r49
            r15.f835g = r0
            r0 = r22
            r15.f836h = r0
            long r0 = r50.getEventTime()
            r15.f837i = r0
            r0 = r21
            r15.f841m = r0
            r0 = r20
        L_0x018b:
            r15.f842n = r0
        L_0x018d:
            long r0 = r50.getEventTime()
            r15.f843o = r0
            goto L_0x002e
        L_0x0195:
            int r0 = r50.getActionMasked()
            if (r12 != r0) goto L_0x065c
            goto L_0x0037
        L_0x019d:
            int r0 = r50.getActionMasked()
            if (r7 != r0) goto L_0x01ab
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatUnknown
            r15.f830b = r0
            r15.f848t = r12
            goto L_0x002e
        L_0x01ab:
            int r0 = r50.getActionMasked()
            if (r4 != r0) goto L_0x01f1
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatScroll
            r15.f830b = r0
            int r0 = r50.getAction()
            r0 = r0 & r1
            int r0 = r0 >>> 8
            int r1 = r15.f832d
            if (r0 != r1) goto L_0x01c4
            int r0 = r15.f838j
            r15.f832d = r0
        L_0x01c4:
            r15.f848t = r12
            com.baidu.ar.arplay.core.ARPEngine r16 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLEAR
            int r17 = r0.ordinal()
            r18 = -1
            r20 = -1
            r21 = -1082130432(0xffffffffbf800000, float:-1.0)
            r22 = -1082130432(0xffffffffbf800000, float:-1.0)
            r23 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = -1082130432(0xffffffffbf800000, float:-1.0)
            r25 = -1
            r26 = -1082130432(0xffffffffbf800000, float:-1.0)
            r27 = -1082130432(0xffffffffbf800000, float:-1.0)
            r28 = -1082130432(0xffffffffbf800000, float:-1.0)
            r29 = -1082130432(0xffffffffbf800000, float:-1.0)
            r30 = -1
            r31 = 0
            r32 = 1
            r16.onGestureUpdateWithScaleFinish(r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            goto L_0x002e
        L_0x01f1:
            int r0 = r50.getActionMasked()
            if (r8 != r0) goto L_0x065c
            long r0 = r50.getEventTime()
            long r2 = r15.f837i
            long r0 = r0 - r2
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x002e
            long r0 = r50.getEventTime()
            long r2 = r15.f843o
            long r0 = r0 - r2
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x002e
            float r14 = r49.m1111f((android.view.MotionEvent) r50)
            float r11 = r49.m1114g((android.view.MotionEvent) r50)
            float r10 = r49.m1117h((android.view.MotionEvent) r50)
            float r9 = r49.m1120i(r50)
            double r7 = r15.m1091a((float) r14, (float) r11, (float) r10, (float) r9)
            double r0 = r15.f844p
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x02dc
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x02d1
            boolean r0 = r15.f820E
            if (r0 != 0) goto L_0x02d1
            boolean r0 = r15.f848t
            if (r0 != 0) goto L_0x0288
            boolean r0 = r15.f849u
            if (r0 == 0) goto L_0x0278
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLEAR
            int r1 = r0.ordinal()
            r2 = -1
            r4 = -1
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            r17 = -1
            r18 = -1082130432(0xffffffffbf800000, float:-1.0)
            r19 = -1082130432(0xffffffffbf800000, float:-1.0)
            r20 = -1082130432(0xffffffffbf800000, float:-1.0)
            r21 = -1082130432(0xffffffffbf800000, float:-1.0)
            r22 = -1
            r23 = 0
            r0 = r49
            r33 = r7
            r7 = r12
            r8 = r16
            r12 = r9
            r9 = r17
            r35 = r10
            r10 = r18
            r36 = r11
            r11 = r19
            r37 = r12
            r12 = r20
            r13 = r21
            r38 = r14
            r14 = r22
            r15 = r23
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0282
        L_0x0278:
            r33 = r7
            r37 = r9
            r35 = r10
            r36 = r11
            r38 = r14
        L_0x0282:
            r14 = 0
            r15 = r49
            r15.f849u = r14
            goto L_0x0293
        L_0x0288:
            r33 = r7
            r37 = r9
            r35 = r10
            r36 = r11
            r38 = r14
            r14 = 0
        L_0x0293:
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_TWO_FINGER_UNPINCH
            int r1 = r0.ordinal()
            long r2 = r50.getEventTime()
            int r4 = r15.f832d
            float r7 = r49.m1097b((android.view.MotionEvent) r50)
            float r8 = r49.m1100c((android.view.MotionEvent) r50)
            int r9 = r15.f838j
            float r12 = r49.m1104d((android.view.MotionEvent) r50)
            float r13 = r49.m1108e((android.view.MotionEvent) r50)
            r16 = -1
            r17 = 0
            r0 = r49
            r5 = r38
            r6 = r36
            r10 = r35
            r11 = r37
            r14 = r16
            r15 = r17
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r15 = r49
            boolean r0 = r15.f848t
            if (r0 == 0) goto L_0x0362
            r0 = 0
            r15.f849u = r0
            goto L_0x0362
        L_0x02d1:
            r37 = r9
            r35 = r10
            r36 = r11
            r38 = r14
            r0 = r7
            goto L_0x0364
        L_0x02dc:
            r33 = r7
            r37 = r9
            r35 = r10
            r36 = r11
            r38 = r14
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x0362
            boolean r0 = r15.f820E
            if (r0 != 0) goto L_0x0362
            boolean r0 = r15.f848t
            if (r0 != 0) goto L_0x0325
            boolean r0 = r15.f849u
            if (r0 != 0) goto L_0x031f
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLEAR
            int r1 = r0.ordinal()
            r2 = -1
            r4 = -1
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = -1
            r17 = 0
            r0 = r49
            r12 = r13
            r13 = r14
            r14 = r16
            r15 = r17
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x031f:
            r14 = 1
            r15 = r49
            r15.f849u = r14
            goto L_0x0326
        L_0x0325:
            r14 = 1
        L_0x0326:
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_TWO_FINGER_PINCH
            int r1 = r0.ordinal()
            long r2 = r50.getEventTime()
            int r4 = r15.f832d
            float r7 = r49.m1097b((android.view.MotionEvent) r50)
            float r8 = r49.m1100c((android.view.MotionEvent) r50)
            int r9 = r15.f838j
            float r12 = r49.m1104d((android.view.MotionEvent) r50)
            float r13 = r49.m1108e((android.view.MotionEvent) r50)
            r16 = -1
            r17 = 0
            r0 = r49
            r5 = r38
            r6 = r36
            r10 = r35
            r11 = r37
            r14 = r16
            r15 = r17
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r15 = r49
            boolean r0 = r15.f848t
            if (r0 == 0) goto L_0x0362
            r14 = 1
            r15.f849u = r14
        L_0x0362:
            r0 = r33
        L_0x0364:
            r15.f844p = r0
            r0 = r38
            r15.f835g = r0
            r0 = r36
            r15.f836h = r0
            long r0 = r50.getEventTime()
            r15.f837i = r0
            r0 = r35
            r15.f841m = r0
            r0 = r37
            goto L_0x018b
        L_0x037c:
            int r0 = r50.getActionMasked()
            if (r7 != r0) goto L_0x0384
            goto L_0x065c
        L_0x0384:
            int r0 = r50.getActionMasked()
            if (r4 != r0) goto L_0x03d7
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatScroll
            r15.f830b = r0
            int r0 = r50.getAction()
            r0 = r0 & r1
            int r0 = r0 >>> 8
            int r1 = r15.f832d
            if (r0 != r1) goto L_0x03b1
            int r0 = r15.f838j
            r15.f832d = r0
            float r0 = r15.f839k
            r15.f833e = r0
            float r0 = r15.f840l
            r15.f834f = r0
            float r0 = r15.f841m
            r15.f835g = r0
            float r0 = r15.f842n
            r15.f836h = r0
            long r0 = r15.f843o
            r15.f837i = r0
        L_0x03b1:
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLEAR
            int r1 = r0.ordinal()
            r2 = -1
            r4 = -1
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = -1
            r16 = 0
            r0 = r49
            r15 = r16
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0a94
        L_0x03d7:
            int r0 = r50.getActionMasked()
            if (r8 != r0) goto L_0x0467
            long r0 = r50.getEventTime()
            r15 = r49
            long r2 = r15.f837i
            long r0 = r0 - r2
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x002e
            long r0 = r50.getEventTime()
            long r2 = r15.f843o
            long r0 = r0 - r2
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x002e
            float r14 = r49.m1111f((android.view.MotionEvent) r50)
            float r13 = r49.m1114g((android.view.MotionEvent) r50)
            float r12 = r49.m1117h((android.view.MotionEvent) r50)
            float r11 = r49.m1120i(r50)
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x044a
            boolean r0 = r15.f819D
            if (r0 != 0) goto L_0x044a
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_TWO_FINGER_SCROLL
            int r1 = r0.ordinal()
            long r2 = r50.getEventTime()
            int r4 = r15.f832d
            float r7 = r49.m1097b((android.view.MotionEvent) r50)
            float r8 = r49.m1100c((android.view.MotionEvent) r50)
            int r9 = r15.f838j
            float r16 = r49.m1104d((android.view.MotionEvent) r50)
            float r17 = r49.m1108e((android.view.MotionEvent) r50)
            r18 = -1
            r19 = 0
            r0 = r49
            r5 = r14
            r6 = r13
            r10 = r12
            r39 = r11
            r40 = r12
            r12 = r16
            r41 = r13
            r13 = r17
            r42 = r14
            r14 = r18
            r15 = r19
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r42
            goto L_0x0451
        L_0x044a:
            r39 = r11
            r40 = r12
            r41 = r13
            r0 = r14
        L_0x0451:
            r15 = r49
            r15.f835g = r0
            r0 = r41
            r15.f836h = r0
            long r0 = r50.getEventTime()
            r15.f837i = r0
            r0 = r40
            r15.f841m = r0
            r0 = r39
            goto L_0x018b
        L_0x0467:
            r15 = r49
            goto L_0x065c
        L_0x046b:
            r14 = 1
            int r0 = r50.getActionMasked()
            if (r14 != r0) goto L_0x04ab
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x04ab
            boolean r0 = r15.f817B
            if (r0 != 0) goto L_0x04ab
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_SWIPE
            int r1 = r0.ordinal()
            long r2 = r50.getEventTime()
            int r4 = r15.f832d
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            com.baidu.ar.arplay.core.ARPTouchInput$SwipeDirection r0 = r15.f850w
            int r14 = r0.ordinal()
            r16 = 0
            r0 = r49
            r15 = r16
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r49.m1101c()
            goto L_0x0a94
        L_0x04ab:
            r0 = r49
            goto L_0x0a94
        L_0x04af:
            r14 = 1
            int r0 = r50.getActionMasked()     // Catch:{ Exception -> 0x064b }
            if (r7 != r0) goto L_0x0544
            r15 = r49
            int r0 = r15.f832d     // Catch:{ Exception -> 0x064b }
            r13 = r50
            int r0 = r13.findPointerIndex(r0)     // Catch:{ Exception -> 0x064b }
            float r0 = r13.getX(r0)     // Catch:{ Exception -> 0x064b }
            r15.f833e = r0     // Catch:{ Exception -> 0x064b }
            int r0 = r15.f832d     // Catch:{ Exception -> 0x064b }
            int r0 = r13.findPointerIndex(r0)     // Catch:{ Exception -> 0x064b }
            float r0 = r13.getY(r0)     // Catch:{ Exception -> 0x064b }
            r15.f834f = r0     // Catch:{ Exception -> 0x064b }
            float r0 = r15.f833e     // Catch:{ Exception -> 0x064b }
            r15.f835g = r0     // Catch:{ Exception -> 0x064b }
            float r0 = r15.f834f     // Catch:{ Exception -> 0x064b }
            r15.f836h = r0     // Catch:{ Exception -> 0x064b }
            long r0 = r50.getEventTime()     // Catch:{ Exception -> 0x064b }
            r15.f837i = r0     // Catch:{ Exception -> 0x064b }
            int r0 = r50.getActionIndex()     // Catch:{ Exception -> 0x064b }
            int r0 = r13.getPointerId(r0)     // Catch:{ Exception -> 0x064b }
            r15.f838j = r0     // Catch:{ Exception -> 0x064b }
            int r0 = r15.f838j     // Catch:{ Exception -> 0x064b }
            int r0 = r13.findPointerIndex(r0)     // Catch:{ Exception -> 0x064b }
            float r0 = r13.getX(r0)     // Catch:{ Exception -> 0x064b }
            r15.f839k = r0     // Catch:{ Exception -> 0x064b }
            int r0 = r15.f838j     // Catch:{ Exception -> 0x064b }
            int r0 = r13.findPointerIndex(r0)     // Catch:{ Exception -> 0x064b }
            float r0 = r13.getY(r0)     // Catch:{ Exception -> 0x064b }
            r15.f840l = r0     // Catch:{ Exception -> 0x064b }
            long r0 = r50.getEventTime()     // Catch:{ Exception -> 0x064b }
            r15.f843o = r0     // Catch:{ Exception -> 0x064b }
            float r0 = r15.f839k     // Catch:{ Exception -> 0x064b }
            r15.f841m = r0     // Catch:{ Exception -> 0x064b }
            float r0 = r15.f840l     // Catch:{ Exception -> 0x064b }
            r15.f842n = r0     // Catch:{ Exception -> 0x064b }
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatTwoFingersCandidate     // Catch:{ Exception -> 0x064b }
            r15.f830b = r0     // Catch:{ Exception -> 0x064b }
            boolean r0 = r15.f851x     // Catch:{ Exception -> 0x064b }
            if (r0 != 0) goto L_0x0540
            boolean r0 = r15.f818C     // Catch:{ Exception -> 0x064b }
            if (r0 != 0) goto L_0x0540
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLEAR     // Catch:{ Exception -> 0x064b }
            int r1 = r0.ordinal()     // Catch:{ Exception -> 0x064b }
            r2 = -1
            r4 = -1
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = -1
            r16 = 0
            r0 = r49
            r15 = r16
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x064b }
        L_0x0540:
            r15 = r49
            goto L_0x002e
        L_0x0544:
            r13 = r50
            int r0 = r50.getActionMasked()     // Catch:{ Exception -> 0x064b }
            if (r4 != r0) goto L_0x0554
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatUnknown     // Catch:{ Exception -> 0x064b }
            r15 = r49
        L_0x0550:
            r15.f830b = r0     // Catch:{ Exception -> 0x064d }
            goto L_0x002e
        L_0x0554:
            r15 = r49
            int r0 = r50.getActionMasked()     // Catch:{ Exception -> 0x064d }
            if (r14 != r0) goto L_0x0561
            r49.m1101c()     // Catch:{ Exception -> 0x064d }
            goto L_0x002e
        L_0x0561:
            int r0 = r50.getActionMasked()     // Catch:{ Exception -> 0x064d }
            if (r8 != r0) goto L_0x0647
            long r0 = r50.getEventTime()     // Catch:{ Exception -> 0x064d }
            long r2 = r15.f837i     // Catch:{ Exception -> 0x064d }
            r4 = 0
            long r0 = r0 - r2
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x002e
            float r14 = r49.m1111f((android.view.MotionEvent) r50)     // Catch:{ Exception -> 0x064d }
            float r12 = r49.m1114g((android.view.MotionEvent) r50)     // Catch:{ Exception -> 0x064d }
            boolean r0 = r15.f851x     // Catch:{ Exception -> 0x064d }
            if (r0 != 0) goto L_0x05b8
            boolean r0 = r15.f818C     // Catch:{ Exception -> 0x064b }
            if (r0 != 0) goto L_0x05b8
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_SINGLE_FINGER_SCROLL     // Catch:{ Exception -> 0x064b }
            int r1 = r0.ordinal()     // Catch:{ Exception -> 0x064b }
            long r2 = r50.getEventTime()     // Catch:{ Exception -> 0x064b }
            int r4 = r15.f832d     // Catch:{ Exception -> 0x064b }
            float r7 = r49.m1097b((android.view.MotionEvent) r50)     // Catch:{ Exception -> 0x064b }
            float r8 = r49.m1100c((android.view.MotionEvent) r50)     // Catch:{ Exception -> 0x064b }
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r20 = -1082130432(0xffffffffbf800000, float:-1.0)
            r21 = -1082130432(0xffffffffbf800000, float:-1.0)
            r22 = -1
            r23 = 0
            r0 = r49
            r5 = r14
            r6 = r12
            r43 = r12
            r12 = r20
            r13 = r21
            r44 = r14
            r14 = r22
            r15 = r23
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x064b }
            goto L_0x05bc
        L_0x05b8:
            r43 = r12
            r44 = r14
        L_0x05bc:
            r15 = r49
            float r0 = r15.f835g     // Catch:{ Exception -> 0x064d }
            r1 = r44
            float r14 = r1 - r0
            float r0 = r15.f836h     // Catch:{ Exception -> 0x064d }
            r2 = r43
            float r12 = r2 - r0
            long r3 = r50.getEventTime()     // Catch:{ Exception -> 0x064d }
            long r5 = r15.f837i     // Catch:{ Exception -> 0x064d }
            r0 = 0
            long r3 = r3 - r5
            float r0 = (float) r3     // Catch:{ Exception -> 0x064d }
            float r0 = r14 / r0
            long r3 = r50.getEventTime()     // Catch:{ Exception -> 0x064d }
            long r5 = r15.f837i     // Catch:{ Exception -> 0x064d }
            r7 = 0
            long r3 = r3 - r5
            float r3 = (float) r3     // Catch:{ Exception -> 0x064d }
            float r3 = r12 / r3
            float r4 = java.lang.Math.abs(r14)     // Catch:{ Exception -> 0x064d }
            float r5 = java.lang.Math.abs(r12)     // Catch:{ Exception -> 0x064d }
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0610
            float r4 = java.lang.Math.abs(r14)     // Catch:{ Exception -> 0x064d }
            double r4 = (double) r4     // Catch:{ Exception -> 0x064d }
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x0610
            float r0 = java.lang.Math.abs(r0)     // Catch:{ Exception -> 0x064d }
            double r4 = (double) r0     // Catch:{ Exception -> 0x064d }
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0610
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0608
            com.baidu.ar.arplay.core.ARPTouchInput$SwipeDirection r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.SwipeDirection.ESWIPE_RIGHT     // Catch:{ Exception -> 0x064d }
        L_0x0605:
            r15.f850w = r0     // Catch:{ Exception -> 0x064d }
            goto L_0x060b
        L_0x0608:
            com.baidu.ar.arplay.core.ARPTouchInput$SwipeDirection r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.SwipeDirection.ESWIPE_LEFT     // Catch:{ Exception -> 0x064d }
            goto L_0x0605
        L_0x060b:
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatSwipe     // Catch:{ Exception -> 0x064d }
            r15.f830b = r0     // Catch:{ Exception -> 0x064d }
            goto L_0x063b
        L_0x0610:
            float r0 = java.lang.Math.abs(r12)     // Catch:{ Exception -> 0x064d }
            float r4 = java.lang.Math.abs(r14)     // Catch:{ Exception -> 0x064d }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x063b
            float r0 = java.lang.Math.abs(r12)     // Catch:{ Exception -> 0x064d }
            double r4 = (double) r0     // Catch:{ Exception -> 0x064d }
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x063b
            float r0 = java.lang.Math.abs(r3)     // Catch:{ Exception -> 0x064d }
            double r3 = (double) r0     // Catch:{ Exception -> 0x064d }
            int r0 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x063b
            r0 = 0
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0638
            com.baidu.ar.arplay.core.ARPTouchInput$SwipeDirection r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.SwipeDirection.ESWIPE_DOWN     // Catch:{ Exception -> 0x064d }
        L_0x0635:
            r15.f850w = r0     // Catch:{ Exception -> 0x064d }
            goto L_0x060b
        L_0x0638:
            com.baidu.ar.arplay.core.ARPTouchInput$SwipeDirection r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.SwipeDirection.ESWIPE_UP     // Catch:{ Exception -> 0x064d }
            goto L_0x0635
        L_0x063b:
            r15.f835g = r1     // Catch:{ Exception -> 0x064d }
            r15.f836h = r2     // Catch:{ Exception -> 0x064d }
            long r0 = r50.getEventTime()     // Catch:{ Exception -> 0x064d }
            r15.f837i = r0     // Catch:{ Exception -> 0x064d }
            goto L_0x002e
        L_0x0647:
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatUnknown     // Catch:{ Exception -> 0x064d }
            goto L_0x0550
        L_0x064b:
            r15 = r49
        L_0x064d:
            java.lang.String r0 = " BaiduArView"
            java.lang.String r1 = "Monkey event.getX Exception"
            android.util.Log.e(r0, r1)
            goto L_0x002e
        L_0x0656:
            int r0 = r50.getActionMasked()
            if (r7 != r0) goto L_0x0662
        L_0x065c:
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatUnknown
            r15.f830b = r0
            goto L_0x002e
        L_0x0662:
            int r0 = r50.getActionMasked()
            if (r4 != r0) goto L_0x0669
            goto L_0x065c
        L_0x0669:
            int r0 = r50.getActionMasked()
            if (r8 != r0) goto L_0x065c
            float r14 = r49.m1111f((android.view.MotionEvent) r50)
            float r13 = r49.m1114g((android.view.MotionEvent) r50)
            float r12 = r49.m1117h((android.view.MotionEvent) r50)
            float r11 = r49.m1120i(r50)
            float r0 = r15.f833e
            float r1 = r15.f834f
            double r0 = r15.m1091a((float) r0, (float) r1, (float) r14, (float) r13)
            float r4 = r15.f839k
            float r5 = r15.f840l
            double r4 = r15.m1091a((float) r4, (float) r5, (float) r12, (float) r11)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x069e
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0698
            goto L_0x069e
        L_0x0698:
            r3 = r11
            r2 = r12
            r1 = r13
            r0 = r14
            goto L_0x07bd
        L_0x069e:
            int r0 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0698
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0698
            float r1 = r15.f833e
            float r2 = r15.f834f
            float r5 = r15.f839k
            float r6 = r15.f840l
            r0 = r49
            r3 = r14
            r4 = r13
            r7 = r12
            r8 = r11
            double r9 = r0.m1092a((float) r1, (float) r2, (float) r3, (float) r4, (float) r5, (float) r6, (float) r7, (float) r8)
            r0 = 4605249457297304856(0x3fe921fb54442d18, double:0.7853981633974483)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x071f
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatTwoFingersScroll
            r15.f830b = r0
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x0717
            boolean r0 = r15.f819D
            if (r0 != 0) goto L_0x0717
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_TWO_FINGER_SCROLL
            int r1 = r0.ordinal()
            long r2 = r50.getDownTime()
            int r4 = r15.f832d
            float r7 = r49.m1097b((android.view.MotionEvent) r50)
            float r8 = r49.m1100c((android.view.MotionEvent) r50)
            int r9 = r15.f838j
            float r16 = r49.m1104d((android.view.MotionEvent) r50)
            float r17 = r49.m1108e((android.view.MotionEvent) r50)
            r18 = -1
            r19 = 0
            r0 = r49
            r5 = r14
            r6 = r13
            r10 = r12
            r45 = r11
            r46 = r12
            r12 = r16
            r47 = r13
            r13 = r17
            r48 = r14
            r14 = r18
            r15 = r19
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            java.lang.String r0 = "touchopt"
            java.lang.String r1 = "EStatTwoFingersScroll"
            android.util.Log.d(r0, r1)
            r3 = r45
            r2 = r46
            r1 = r47
            r0 = r48
            goto L_0x071b
        L_0x0717:
            r3 = r11
            r2 = r12
            r1 = r13
            r0 = r14
        L_0x071b:
            r15 = r49
            goto L_0x07bd
        L_0x071f:
            r45 = r11
            r46 = r12
            r47 = r13
            r48 = r14
            r0 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x07a9
            r11 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x07a9
            r15 = r49
            float r0 = r15.f833e
            float r1 = r15.f839k
            float r0 = r0 + r1
            r1 = 1073741824(0x40000000, float:2.0)
            float r13 = r0 / r1
            float r0 = r15.f834f
            float r2 = r15.f840l
            float r0 = r0 + r2
            float r14 = r0 / r1
            float r3 = r15.f833e
            float r4 = r15.f834f
            float r5 = r15.f833e
            float r6 = r15.f834f
            r0 = r49
            r1 = r13
            r2 = r14
            r7 = r48
            r8 = r47
            double r16 = r0.m1092a((float) r1, (float) r2, (float) r3, (float) r4, (float) r5, (float) r6, (float) r7, (float) r8)
            float r3 = r15.f839k
            float r4 = r15.f840l
            float r5 = r15.f839k
            float r6 = r15.f840l
            r7 = r46
            r8 = r45
            double r0 = r0.m1092a((float) r1, (float) r2, (float) r3, (float) r4, (float) r5, (float) r6, (float) r7, (float) r8)
            double r16 = r16 - r11
            double r2 = java.lang.Math.abs(r16)
            r4 = 4603834609746899168(0x3fe41b2f769cf0e0, double:0.6283185307179586)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x079a
            double r0 = r0 - r11
            double r0 = java.lang.Math.abs(r0)
            r2 = 4603834609746899168(0x3fe41b2f769cf0e0, double:0.6283185307179586)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x078d
            goto L_0x079a
        L_0x078d:
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatPinchAndUnpinch
            r15.f830b = r0
            r3 = r45
            r2 = r46
            r1 = r47
            r0 = r48
            goto L_0x07b7
        L_0x079a:
            r3 = r45
            r2 = r46
            r1 = r47
            r0 = r48
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r4 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatTwoFingerRotate
            r15.f830b = r4
            r15.f846r = r9
            goto L_0x07bd
        L_0x07a9:
            r3 = r45
            r2 = r46
            r1 = r47
            r0 = r48
            r15 = r49
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r4 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatPinchAndUnpinch
            r15.f830b = r4
        L_0x07b7:
            double r4 = r15.m1091a((float) r0, (float) r1, (float) r2, (float) r3)
            r15.f844p = r4
        L_0x07bd:
            r15.f835g = r0
            r15.f836h = r1
            long r0 = r50.getEventTime()
            r15.f837i = r0
            r15.f841m = r2
            r15.f842n = r3
            goto L_0x018d
        L_0x07cd:
            r0 = 0
            r14 = 1
            int r1 = r50.getActionMasked()
            r4 = 3
            r5 = 600(0x258, double:2.964E-321)
            if (r1 != 0) goto L_0x0861
            java.lang.String r1 = "touchopt"
            java.lang.String r2 = "touchinv Action Down when EStatSingleFingerCandidate"
            android.util.Log.d(r1, r2)
            int r1 = r50.getActionIndex()
            r13 = r50
            int r1 = r13.getPointerId(r1)
            r15.f832d = r1
            float r1 = r50.getX()
            r15.f833e = r1
            float r1 = r50.getY()
            r15.f834f = r1
            float r1 = r15.f833e
            r15.f835g = r1
            float r1 = r15.f834f
            r15.f836h = r1
            long r1 = r50.getEventTime()
            r15.f837i = r1
            com.baidu.ar.arplay.core.ARPTouchInput$b r1 = r15.f847s
            boolean r1 = r1.hasMessages(r8)
            if (r1 == 0) goto L_0x082c
            com.baidu.ar.arplay.core.ARPTouchInput$a r1 = r15.f826K
            if (r1 == 0) goto L_0x082c
            com.baidu.ar.arplay.core.ARPTouchInput$a r1 = r15.f826K
            float r1 = r1.f891b
            com.baidu.ar.arplay.core.ARPTouchInput$a r2 = r15.f826K
            float r2 = r2.f892c
            float r3 = r50.getX()
            float r7 = r50.getY()
            double r1 = r15.m1091a((float) r1, (float) r2, (float) r3, (float) r7)
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x082c
            r49.m1105d()
        L_0x082c:
            com.baidu.ar.arplay.core.ARPTouchInput$b r1 = r15.f847s
            r1.sendEmptyMessageDelayed(r14, r5)
            java.lang.String r1 = "touchopt"
            java.lang.String r2 = "touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d"
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            float r5 = r15.f833e
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r3[r0] = r5
            float r0 = r15.f834f
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r3[r14] = r0
            long r5 = r15.f837i
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            r3[r8] = r0
            int r0 = r15.f832d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r4] = r0
            java.lang.String r0 = java.lang.String.format(r2, r3)
            android.util.Log.d(r1, r0)
            goto L_0x002e
        L_0x0861:
            r13 = r50
            int r1 = r50.getActionMasked()
            if (r8 != r1) goto L_0x0952
            float r1 = r15.f833e
            float r7 = r15.f834f
            float r9 = r50.getX()
            float r10 = r50.getY()
            double r9 = r15.m1091a((float) r1, (float) r7, (float) r9, (float) r10)
            java.lang.String r1 = "touchopt"
            java.lang.String r7 = "touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            float r11 = r50.getX()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r4[r0] = r11
            float r11 = r50.getY()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r4[r14] = r11
            java.lang.Double r11 = java.lang.Double.valueOf(r9)
            r4[r8] = r11
            java.lang.String r4 = java.lang.String.format(r7, r4)
            android.util.Log.d(r1, r4)
            int r1 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r1 >= 0) goto L_0x08f6
            long r0 = r50.getEventTime()
            long r2 = r50.getDownTime()
            long r0 = r0 - r2
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0946
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatLongPresss
            r15.f830b = r0
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x08ed
            boolean r0 = r15.f816A
            if (r0 != 0) goto L_0x08ed
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_LONG_PRESS
            int r1 = r0.ordinal()
            long r2 = r50.getDownTime()
            int r4 = r15.f832d
            float r5 = r50.getX()
            float r6 = r50.getY()
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            r17 = -1
            r18 = 0
            r0 = r49
            r13 = r16
            r14 = r17
            r15 = r18
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x08ed:
            r15 = r49
            com.baidu.ar.arplay.core.ARPTouchInput$b r0 = r15.f847s
            r14 = 1
            r0.removeMessages(r14)
            goto L_0x0946
        L_0x08f6:
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x08fd
            r15.f831c = r0
            goto L_0x0946
        L_0x08fd:
            r49.m1105d()
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatScroll
            r15.f830b = r0
            boolean r0 = r15.f851x
            if (r0 != 0) goto L_0x093e
            boolean r0 = r15.f818C
            if (r0 != 0) goto L_0x093e
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_SINGLE_FINGER_SCROLL
            int r1 = r0.ordinal()
            long r2 = r50.getEventTime()
            int r4 = r15.f832d
            float r5 = r50.getX()
            float r6 = r50.getY()
            float r7 = r49.m1097b((android.view.MotionEvent) r50)
            float r8 = r49.m1100c((android.view.MotionEvent) r50)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = -1
            r17 = 0
            r0 = r49
            r14 = r16
            r15 = r17
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x093e:
            r15 = r49
            com.baidu.ar.arplay.core.ARPTouchInput$b r0 = r15.f847s
            r1 = 1
            r0.removeMessages(r1)
        L_0x0946:
            float r0 = r50.getX()
            r15.f835g = r0
            float r0 = r50.getY()
            goto L_0x0087
        L_0x0952:
            r1 = 1
            int r2 = r50.getActionMasked()
            if (r1 != r2) goto L_0x0a3a
            float r1 = r15.f833e
            float r2 = r15.f834f
            float r3 = r50.getX()
            float r4 = r50.getY()
            double r1 = r15.m1091a((float) r1, (float) r2, (float) r3, (float) r4)
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 >= 0) goto L_0x0a35
            long r1 = r50.getEventTime()
            long r3 = r50.getDownTime()
            long r1 = r1 - r3
            r3 = 300(0x12c, double:1.48E-321)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0a35
            boolean r1 = r15.f851x
            if (r1 != 0) goto L_0x0a35
            boolean r1 = r15.f853z
            if (r1 == 0) goto L_0x09e9
            boolean r1 = r15.f852y
            if (r1 != 0) goto L_0x09e6
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r1 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLICK
            int r1 = r1.ordinal()
            long r2 = r50.getDownTime()
            r4 = r50
        L_0x0994:
            int r5 = r4.getPointerId(r0)
            float r6 = r50.getX()
            float r7 = r50.getY()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10 = -1
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = -1
            r17 = 0
            r0 = r49
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r16
            r15 = r17
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r0 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_CLEAR
            int r1 = r0.ordinal()
            r2 = -1
            r4 = -1
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = -1
            r15 = 0
            r0 = r49
            r0.mo9223a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0a36
        L_0x09e6:
            r0 = r49
            goto L_0x0a36
        L_0x09e9:
            r4 = r50
            com.baidu.ar.arplay.core.ARPTouchInput$b r1 = r15.f847s
            boolean r1 = r1.hasMessages(r8)
            if (r1 == 0) goto L_0x0a03
            com.baidu.ar.arplay.core.ARPTouchInput$b r1 = r15.f847s
            r1.removeMessages(r8)
            com.baidu.ar.arplay.core.ARPTouchInput$GestureEventType r1 = com.baidu.p020ar.arplay.core.ARPTouchInput.GestureEventType.EGESTURE_DOUBLE_CLICK
            int r1 = r1.ordinal()
            long r2 = r50.getDownTime()
            goto L_0x0994
        L_0x0a03:
            android.os.Message r1 = android.os.Message.obtain()
            r1.what = r8
            com.baidu.ar.arplay.core.ARPTouchInput$a r2 = new com.baidu.ar.arplay.core.ARPTouchInput$a
            r3 = 0
            r2.<init>()
            int r0 = r4.getPointerId(r0)
            r2.f890a = r0
            float r0 = r50.getX()
            r2.f891b = r0
            float r0 = r50.getY()
            r2.f892c = r0
            long r3 = r50.getDownTime()
            r2.f893d = r3
            r1.obj = r2
            r0 = r49
            r0.f826K = r2
            com.baidu.ar.arplay.core.ARPTouchInput$b r2 = r0.f847s
            r3 = 400(0x190, double:1.976E-321)
            r2.sendMessageDelayed(r1, r3)
            goto L_0x0a36
        L_0x0a35:
            r0 = r15
        L_0x0a36:
            r49.m1101c()
            goto L_0x0a94
        L_0x0a3a:
            r0 = r15
            r4 = r50
            int r1 = r50.getActionMasked()
            if (r7 != r1) goto L_0x0a94
            boolean r1 = r0.f831c
            if (r1 == 0) goto L_0x0a8e
            int r1 = r50.getActionIndex()
            int r1 = r4.getPointerId(r1)
            r0.f838j = r1
            int r1 = r0.f838j
            int r1 = r4.findPointerIndex(r1)
            float r1 = r4.getX(r1)
            r0.f839k = r1
            int r1 = r0.f838j
            int r1 = r4.findPointerIndex(r1)
            float r1 = r4.getY(r1)
            r0.f840l = r1
            long r1 = r50.getEventTime()
            r0.f843o = r1
            float r1 = r0.f839k
            r0.f841m = r1
            float r1 = r0.f840l
            r0.f842n = r1
            float r1 = r50.getX()
            float r2 = r50.getY()
            float r3 = r0.f839k
            float r4 = r0.f840l
            double r1 = r0.m1091a((float) r1, (float) r2, (float) r3, (float) r4)
            r0.f845q = r1
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r1 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatTwoFingersCandidate
        L_0x0a8b:
            r0.f830b = r1
            goto L_0x0a91
        L_0x0a8e:
            com.baidu.ar.arplay.core.ARPTouchInput$TouchEventStatus r1 = com.baidu.p020ar.arplay.core.ARPTouchInput.TouchEventStatus.EStatUnknown
            goto L_0x0a8b
        L_0x0a91:
            r49.m1105d()
        L_0x0a94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.core.ARPTouchInput.mo9224a(android.view.MotionEvent):void");
    }

    /* renamed from: a */
    public void mo9225a(String str) {
        Log.d("ar TouchEventLog ", str);
    }

    /* renamed from: a */
    public void mo9226a(boolean z) {
        this.f828M = z;
    }

    /* renamed from: b */
    public void mo9227b() {
        ARPMessage.getInstance().removeMessageHandeler(this.f829a);
    }

    /* renamed from: b */
    public void mo9228b(boolean z) {
        this.f822G = z;
    }

    /* renamed from: c */
    public void mo9229c(boolean z) {
        this.f823H = z;
    }
}
