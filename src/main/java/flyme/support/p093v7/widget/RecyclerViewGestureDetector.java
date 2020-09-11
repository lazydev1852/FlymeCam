package flyme.support.p093v7.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: flyme.support.v7.widget.r */
public class RecyclerViewGestureDetector {

    /* renamed from: d */
    private static final int f18561d = ViewConfiguration.getLongPressTimeout();

    /* renamed from: e */
    private static final int f18562e = ViewConfiguration.getTapTimeout();

    /* renamed from: a */
    private int f18563a;

    /* renamed from: b */
    private int f18564b;

    /* renamed from: c */
    private int f18565c;

    /* renamed from: f */
    private final Handler f18566f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C3345b f18567g;

    /* renamed from: h */
    private boolean f18568h;

    /* renamed from: i */
    private boolean f18569i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public MotionEvent f18570j;

    /* renamed from: k */
    private MotionEvent f18571k;

    /* renamed from: l */
    private float f18572l;

    /* renamed from: m */
    private float f18573m;

    /* renamed from: n */
    private float f18574n;

    /* renamed from: o */
    private float f18575o;

    /* renamed from: p */
    private boolean f18576p;

    /* renamed from: q */
    private VelocityTracker f18577q;

    /* renamed from: flyme.support.v7.widget.r$b */
    /* compiled from: RecyclerViewGestureDetector */
    public interface C3345b {
        /* renamed from: a */
        boolean mo26240a(MotionEvent motionEvent);

        /* renamed from: a */
        boolean mo26241a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        /* renamed from: b */
        void mo26242b(MotionEvent motionEvent);

        /* renamed from: b */
        boolean mo26244b(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        /* renamed from: c */
        void mo26246c(MotionEvent motionEvent);

        /* renamed from: d */
        boolean mo26247d(MotionEvent motionEvent);
    }

    /* renamed from: flyme.support.v7.widget.r$a */
    /* compiled from: RecyclerViewGestureDetector */
    private class C3344a extends Handler {
        C3344a() {
        }

        C3344a(Handler handler) {
            super(handler.getLooper());
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    RecyclerViewGestureDetector.this.f18567g.mo26242b(RecyclerViewGestureDetector.this.f18570j);
                    return;
                case 2:
                    RecyclerViewGestureDetector.this.m20775c();
                    return;
                default:
                    throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    public RecyclerViewGestureDetector(Context context, C3345b bVar) {
        this(context, bVar, (Handler) null);
    }

    public RecyclerViewGestureDetector(Context context, C3345b bVar, Handler handler) {
        if (handler != null) {
            this.f18566f = new C3344a(handler);
        } else {
            this.f18566f = new C3344a();
        }
        this.f18567g = bVar;
        m20772a(context);
    }

    /* renamed from: a */
    private void m20772a(Context context) {
        int i;
        if (this.f18567g != null) {
            this.f18576p = true;
            if (context == null) {
                i = ViewConfiguration.getTouchSlop();
                this.f18564b = ViewConfiguration.getMinimumFlingVelocity();
                this.f18565c = ViewConfiguration.getMaximumFlingVelocity();
            } else {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.f18564b = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f18565c = viewConfiguration.getScaledMaximumFlingVelocity();
                i = scaledTouchSlop;
            }
            this.f18563a = i * i;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
    }

    /* renamed from: a */
    public boolean mo26238a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f18577q == null) {
            this.f18577q = VelocityTracker.obtain();
        }
        this.f18577q.addMovement(motionEvent);
        int i = action & 255;
        boolean z = false;
        boolean z2 = i == 6;
        int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                f += motionEvent.getX(i2);
                f2 += motionEvent.getY(i2);
            }
        }
        float f3 = (float) (z2 ? pointerCount - 1 : pointerCount);
        float f4 = f / f3;
        float f5 = f2 / f3;
        switch (i) {
            case 0:
                this.f18572l = f4;
                this.f18574n = f4;
                this.f18573m = f5;
                this.f18575o = f5;
                if (this.f18570j != null) {
                    this.f18570j.recycle();
                }
                this.f18570j = MotionEvent.obtain(motionEvent);
                this.f18569i = true;
                this.f18568h = false;
                if (this.f18576p) {
                    this.f18566f.removeMessages(2);
                    this.f18566f.sendEmptyMessageAtTime(2, this.f18570j.getDownTime() + ((long) f18562e) + ((long) f18561d));
                }
                this.f18566f.sendEmptyMessageAtTime(1, this.f18570j.getDownTime() + ((long) f18562e));
                return false | this.f18567g.mo26240a(motionEvent);
            case 1:
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.f18568h) {
                    this.f18568h = false;
                } else if (this.f18569i) {
                    z = this.f18567g.mo26247d(motionEvent);
                } else {
                    VelocityTracker velocityTracker = this.f18577q;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f18565c);
                    float yVelocity = velocityTracker.getYVelocity(pointerId);
                    float xVelocity = velocityTracker.getXVelocity(pointerId);
                    if (Math.abs(yVelocity) > ((float) this.f18564b) || Math.abs(xVelocity) > ((float) this.f18564b)) {
                        z = this.f18567g.mo26241a(this.f18570j, motionEvent, xVelocity, yVelocity);
                    }
                }
                if (this.f18571k != null) {
                    this.f18571k.recycle();
                }
                this.f18571k = obtain;
                if (this.f18577q != null) {
                    this.f18577q.recycle();
                    this.f18577q = null;
                }
                this.f18566f.removeMessages(1);
                this.f18566f.removeMessages(2);
                return z;
            case 2:
                if (this.f18568h) {
                    return false;
                }
                float f6 = this.f18572l - f4;
                float f7 = this.f18573m - f5;
                if (this.f18569i) {
                    int i3 = (int) (f4 - this.f18574n);
                    int i4 = (int) (f5 - this.f18575o);
                    if ((i3 * i3) + (i4 * i4) <= this.f18563a) {
                        return false;
                    }
                    boolean b = this.f18567g.mo26244b(this.f18570j, motionEvent, f6, f7);
                    this.f18572l = f4;
                    this.f18573m = f5;
                    this.f18569i = false;
                    this.f18566f.removeMessages(1);
                    this.f18566f.removeMessages(2);
                    return b;
                } else if (Math.abs(f6) < 1.0f && Math.abs(f7) < 1.0f) {
                    return false;
                } else {
                    boolean b2 = this.f18567g.mo26244b(this.f18570j, motionEvent, f6, f7);
                    this.f18572l = f4;
                    this.f18573m = f5;
                    return b2;
                }
            case 3:
                m20771a();
                return false;
            case 5:
                this.f18572l = f4;
                this.f18574n = f4;
                this.f18573m = f5;
                this.f18575o = f5;
                m20774b();
                return false;
            case 6:
                this.f18572l = f4;
                this.f18574n = f4;
                this.f18573m = f5;
                this.f18575o = f5;
                this.f18577q.computeCurrentVelocity(1000, (float) this.f18565c);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.f18577q.getXVelocity(pointerId2);
                float yVelocity2 = this.f18577q.getYVelocity(pointerId2);
                for (int i5 = 0; i5 < pointerCount; i5++) {
                    if (i5 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i5);
                        if ((this.f18577q.getXVelocity(pointerId3) * xVelocity2) + (this.f18577q.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                            this.f18577q.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }

    /* renamed from: a */
    private void m20771a() {
        this.f18566f.removeMessages(1);
        this.f18566f.removeMessages(2);
        this.f18577q.recycle();
        this.f18577q = null;
        this.f18569i = false;
        this.f18568h = false;
    }

    /* renamed from: b */
    private void m20774b() {
        this.f18566f.removeMessages(1);
        this.f18566f.removeMessages(2);
        this.f18569i = false;
        this.f18568h = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20775c() {
        this.f18568h = true;
        this.f18567g.mo26246c(this.f18570j);
    }
}
