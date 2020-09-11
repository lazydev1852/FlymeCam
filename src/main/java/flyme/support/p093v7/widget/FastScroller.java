package flyme.support.p093v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.baidu.p020ar.base.MsgField;
import flyme.support.p093v7.R;
import flyme.support.p093v7.widget.RecyclerView;

@VisibleForTesting
/* renamed from: flyme.support.v7.widget.i */
public class FastScroller extends RecyclerView.C3265f implements RecyclerView.C3273k {

    /* renamed from: g */
    private static final int[] f18464g = {16842919};

    /* renamed from: h */
    private static final int[] f18465h = new int[0];

    /* renamed from: A */
    private final int[] f18466A = new int[2];
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final ValueAnimator f18467B = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f18468C = 0;

    /* renamed from: D */
    private final Runnable f18469D = new Runnable() {
        public void run() {
            FastScroller.this.mo27156a(230);
        }
    };

    /* renamed from: E */
    private final RecyclerView.C3274l f18470E = new RecyclerView.C3274l() {
        /* renamed from: a */
        public void mo20072a(RecyclerView recyclerView, int i, int i2) {
            FastScroller.this.mo27157a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }

        /* renamed from: a */
        public void mo20071a(RecyclerView recyclerView, int i) {
            super.mo20071a(recyclerView, i);
            if (i == 0) {
                FastScroller.this.m20560b(3);
            }
        }
    };
    @VisibleForTesting

    /* renamed from: a */
    int f18471a;
    @VisibleForTesting

    /* renamed from: b */
    int f18472b;
    @VisibleForTesting

    /* renamed from: c */
    float f18473c;
    @VisibleForTesting

    /* renamed from: d */
    int f18474d;
    @VisibleForTesting

    /* renamed from: e */
    int f18475e;
    @VisibleForTesting

    /* renamed from: f */
    float f18476f;

    /* renamed from: i */
    private final int f18477i;

    /* renamed from: j */
    private final int f18478j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final StateListDrawable f18479k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Drawable f18480l;

    /* renamed from: m */
    private final int f18481m;

    /* renamed from: n */
    private final int f18482n;

    /* renamed from: o */
    private final StateListDrawable f18483o;

    /* renamed from: p */
    private final Drawable f18484p;

    /* renamed from: q */
    private final int f18485q;

    /* renamed from: r */
    private final int f18486r;

    /* renamed from: s */
    private int f18487s = 0;

    /* renamed from: t */
    private int f18488t = 0;

    /* renamed from: u */
    private RecyclerView f18489u;

    /* renamed from: v */
    private boolean f18490v = false;

    /* renamed from: w */
    private boolean f18491w = false;

    /* renamed from: x */
    private int f18492x = 0;

    /* renamed from: y */
    private int f18493y = 0;

    /* renamed from: z */
    private final int[] f18494z = new int[2];

    /* renamed from: a */
    public void mo22325a(boolean z) {
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        if (stateListDrawable != null) {
            this.f18479k = stateListDrawable;
            this.f18481m = Math.max(i, stateListDrawable.getIntrinsicWidth());
            this.f18471a = stateListDrawable.getIntrinsicHeight();
        } else {
            this.f18479k = new StateListDrawable();
            this.f18481m = i;
        }
        if (drawable != null) {
            this.f18480l = drawable;
        } else {
            this.f18480l = recyclerView.getResources().getDrawable(R.drawable.line_drawable);
        }
        if (stateListDrawable2 != null) {
            this.f18483o = stateListDrawable2;
        } else {
            this.f18483o = this.f18479k;
        }
        if (drawable2 != null) {
            this.f18484p = drawable2;
        } else {
            this.f18484p = recyclerView.getResources().getDrawable(R.drawable.line_drawable);
        }
        this.f18482n = Math.max(i, this.f18480l.getIntrinsicWidth());
        this.f18485q = Math.max(i, this.f18483o.getIntrinsicWidth());
        this.f18486r = Math.max(i, this.f18484p.getIntrinsicWidth());
        this.f18477i = i2;
        this.f18478j = i3;
        this.f18479k.setAlpha(255);
        this.f18480l.setAlpha(255);
        this.f18467B.addListener(new C3329a());
        this.f18467B.addUpdateListener(new C3330b());
        mo27158a(recyclerView);
    }

    /* renamed from: a */
    public void mo27158a(@Nullable RecyclerView recyclerView) {
        if (this.f18489u != recyclerView) {
            if (this.f18489u != null) {
                m20568f();
            }
            this.f18489u = recyclerView;
            if (this.f18489u != null) {
                m20567e();
            }
        }
    }

    /* renamed from: e */
    private void m20567e() {
        this.f18489u.mo26371a((RecyclerView.C3265f) this);
        this.f18489u.mo26373a((RecyclerView.C3273k) this);
        this.f18489u.mo26374a(this.f18470E);
    }

    /* renamed from: f */
    private void m20568f() {
        this.f18489u.mo26382b((RecyclerView.C3265f) this);
        this.f18489u.mo26383b((RecyclerView.C3273k) this);
        this.f18489u.mo26384b(this.f18470E);
        m20571i();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m20569g() {
        this.f18489u.invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20560b(int i) {
        if (i == 2 && this.f18492x != 2) {
            this.f18479k.setState(f18464g);
            m20571i();
        }
        if (i == 0) {
            m20569g();
        } else if (i == 3) {
            mo27160b();
        } else {
            mo27155a();
        }
        if (this.f18492x == 2 && i != 2) {
            this.f18479k.setState(f18465h);
            m20565c((int) MsgField.IMSG_SAVE_PICTURE);
        } else if (i == 1 || i == 3) {
            m20565c((int) MsgField.IMSG_SAVE_PICTURE);
        }
        this.f18492x = i;
    }

    /* renamed from: h */
    private boolean m20570h() {
        return ViewCompat.getLayoutDirection(this.f18489u) == 1;
    }

    /* renamed from: a */
    public void mo27155a() {
        int i = this.f18468C;
        if (i != 0) {
            if (i != 6) {
                switch (i) {
                    case 3:
                        this.f18467B.cancel();
                        break;
                    case 4:
                        break;
                    default:
                        return;
                }
            } else {
                this.f18467B.cancel();
            }
            this.f18468C = 5;
            this.f18467B.setFloatValues(new float[]{((Float) this.f18467B.getAnimatedValue()).floatValue(), 1.0f});
            this.f18467B.setDuration(150);
            this.f18467B.setStartDelay(0);
            this.f18467B.start();
            return;
        }
        this.f18468C = 1;
        this.f18467B.setFloatValues(new float[]{((Float) this.f18467B.getAnimatedValue()).floatValue(), 1.0f});
        this.f18467B.setDuration(150);
        this.f18467B.setStartDelay(0);
        this.f18467B.start();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo27156a(int i) {
        switch (this.f18468C) {
            case 1:
            case 5:
            case 6:
                this.f18467B.cancel();
                break;
            case 2:
            case 4:
                break;
            default:
                return;
        }
        this.f18468C = 3;
        this.f18467B.setFloatValues(new float[]{((Float) this.f18467B.getAnimatedValue()).floatValue(), 0.0f});
        this.f18467B.setDuration((long) i);
        this.f18467B.start();
    }

    /* renamed from: b */
    public void mo27160b() {
        int i = this.f18468C;
        if (i != 5) {
            switch (i) {
                case 0:
                case 2:
                    break;
                case 1:
                case 3:
                    break;
                default:
                    return;
            }
        }
        this.f18467B.cancel();
        this.f18468C = 6;
        this.f18467B.setFloatValues(new float[]{((Float) this.f18467B.getAnimatedValue()).floatValue(), 0.5f});
        this.f18467B.setDuration(150);
        this.f18467B.start();
    }

    /* renamed from: i */
    private void m20571i() {
        this.f18489u.removeCallbacks(this.f18469D);
    }

    /* renamed from: c */
    private void m20565c(int i) {
        m20571i();
        this.f18489u.postDelayed(this.f18469D, (long) i);
    }

    /* renamed from: a */
    public void mo26548a(Canvas canvas, RecyclerView recyclerView, RecyclerView.C3283r rVar) {
        if (this.f18487s != this.f18489u.getWidth() || this.f18488t != this.f18489u.getHeight()) {
            this.f18487s = this.f18489u.getWidth();
            this.f18488t = this.f18489u.getHeight();
            m20560b(0);
        } else if (this.f18468C != 0) {
            if (this.f18490v) {
                m20556a(canvas);
            }
            if (this.f18491w) {
                m20561b(canvas);
            }
        }
    }

    /* renamed from: a */
    private void m20556a(Canvas canvas) {
        int c = (this.f18487s - this.f18481m) - ((int) m20563c(16.0f));
        int i = this.f18472b;
        this.f18479k.setBounds(0, 0, this.f18481m, this.f18471a);
        this.f18480l.setBounds(0, 0, this.f18482n, this.f18488t);
        if (m20570h()) {
            this.f18480l.draw(canvas);
            canvas.translate((float) this.f18481m, (float) i);
            canvas.scale(-1.0f, 1.0f);
            this.f18479k.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f18481m), (float) (-i));
            return;
        }
        canvas.translate((float) c, 0.0f);
        this.f18480l.draw(canvas);
        canvas.translate(0.0f, (float) i);
        this.f18479k.draw(canvas);
        canvas.translate((float) (-c), (float) (-i));
    }

    /* renamed from: b */
    private void m20561b(Canvas canvas) {
        int i = this.f18488t - this.f18485q;
        int i2 = this.f18475e - (this.f18474d / 2);
        this.f18483o.setBounds(0, 0, this.f18474d, this.f18485q);
        this.f18484p.setBounds(0, 0, this.f18487s, this.f18486r);
        canvas.translate(0.0f, (float) i);
        this.f18484p.draw(canvas);
        canvas.translate((float) i2, 0.0f);
        this.f18483o.draw(canvas);
        canvas.translate((float) (-i2), (float) (-i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27157a(int i, int i2) {
        int computeVerticalScrollRange = this.f18489u.computeVerticalScrollRange();
        int i3 = this.f18488t;
        this.f18490v = computeVerticalScrollRange - i3 > 0 && this.f18488t >= this.f18477i;
        int computeHorizontalScrollRange = this.f18489u.computeHorizontalScrollRange();
        int i4 = this.f18487s;
        this.f18491w = computeHorizontalScrollRange - i4 > 0 && this.f18487s >= this.f18477i;
        if (this.f18490v || this.f18491w) {
            if (this.f18490v) {
                this.f18472b = ((i3 - this.f18471a) * i2) / computeVerticalScrollRange;
            }
            if (this.f18491w) {
                float f = (float) i4;
                this.f18475e = (int) ((f * (((float) i) + (f / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f18474d = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            if (this.f18492x == 0 || this.f18492x == 1 || this.f18492x == 3) {
                m20560b(1);
            }
        } else if (this.f18492x != 0) {
            m20560b(0);
        }
    }

    /* renamed from: a */
    public boolean mo22326a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f18492x == 1 || this.f18492x == 3) {
            boolean a = mo27159a(motionEvent.getX(), motionEvent.getY());
            boolean b = mo27161b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!a && !b) {
                return false;
            }
            if (b) {
                this.f18493y = 1;
                this.f18476f = (float) ((int) motionEvent.getX());
            } else if (a) {
                this.f18493y = 2;
                this.f18473c = (float) ((int) motionEvent.getY());
            }
            m20560b(2);
        } else if (this.f18492x == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void mo22327b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f18492x != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a = mo27159a(motionEvent.getX(), motionEvent.getY());
                boolean b = mo27161b(motionEvent.getX(), motionEvent.getY());
                if (a || b) {
                    if (b) {
                        this.f18493y = 1;
                        this.f18476f = (float) ((int) motionEvent.getX());
                    } else if (a) {
                        this.f18493y = 2;
                        this.f18473c = (float) ((int) motionEvent.getY());
                    }
                    m20560b(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f18492x == 2) {
                this.f18473c = 0.0f;
                this.f18476f = 0.0f;
                m20560b(3);
                this.f18493y = 0;
            } else if (motionEvent.getAction() == 2 && this.f18492x == 2) {
                mo27155a();
                if (this.f18493y == 1) {
                    m20559b(motionEvent.getX());
                }
                if (this.f18493y == 2) {
                    m20555a(motionEvent.getY());
                }
            }
        }
    }

    /* renamed from: a */
    private void m20555a(float f) {
        int[] j = m20572j();
        float max = Math.max((float) j[0], Math.min((float) j[1], f));
        if (Math.abs(((float) this.f18472b) - max) >= 2.0f) {
            int a = m20553a(this.f18473c, max, j, this.f18489u.computeVerticalScrollRange(), this.f18489u.computeVerticalScrollOffset(), this.f18488t);
            if (a != 0) {
                this.f18489u.scrollBy(0, a);
            }
            this.f18473c = max;
        }
    }

    /* renamed from: b */
    private void m20559b(float f) {
        int[] k = m20573k();
        float max = Math.max((float) k[0], Math.min((float) k[1], f));
        if (Math.abs(((float) this.f18475e) - max) >= 2.0f) {
            int a = m20553a(this.f18476f, max, k, this.f18489u.computeHorizontalScrollRange(), this.f18489u.computeHorizontalScrollOffset(), this.f18487s);
            if (a != 0) {
                this.f18489u.scrollBy(a, 0);
            }
            this.f18476f = max;
        }
    }

    /* renamed from: a */
    private int m20553a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo27159a(float f, float f2) {
        if (!m20570h() ? f >= ((float) ((this.f18487s - this.f18481m) - ((int) m20563c(16.0f)))) : f <= ((float) (this.f18481m / 2))) {
            return f2 >= ((float) this.f18472b) && f2 <= ((float) (this.f18472b + this.f18471a));
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public boolean mo27161b(float f, float f2) {
        return f2 >= ((float) (this.f18488t - this.f18485q)) && f >= ((float) (this.f18475e - (this.f18474d / 2))) && f <= ((float) (this.f18475e + (this.f18474d / 2)));
    }

    /* renamed from: j */
    private int[] m20572j() {
        this.f18494z[0] = this.f18478j;
        this.f18494z[1] = this.f18488t - this.f18478j;
        return this.f18494z;
    }

    /* renamed from: k */
    private int[] m20573k() {
        this.f18466A[0] = this.f18478j;
        this.f18466A[1] = this.f18487s - this.f18478j;
        return this.f18466A;
    }

    /* renamed from: flyme.support.v7.widget.i$a */
    /* compiled from: FastScroller */
    private class C3329a extends AnimatorListenerAdapter {

        /* renamed from: b */
        private boolean f18498b;

        private C3329a() {
            this.f18498b = false;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f18498b) {
                this.f18498b = false;
            } else if (((Float) FastScroller.this.f18467B.getAnimatedValue()).floatValue() == 0.0f) {
                int unused = FastScroller.this.f18468C = 0;
                FastScroller.this.m20560b(0);
            } else if (((double) ((Float) FastScroller.this.f18467B.getAnimatedValue()).floatValue()) == 0.5d) {
                int unused2 = FastScroller.this.f18468C = 4;
                FastScroller.this.m20560b(3);
            } else {
                int unused3 = FastScroller.this.f18468C = 2;
                FastScroller.this.m20569g();
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f18498b = true;
        }
    }

    /* renamed from: flyme.support.v7.widget.i$b */
    /* compiled from: FastScroller */
    private class C3330b implements ValueAnimator.AnimatorUpdateListener {
        private C3330b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f18479k.setAlpha(floatValue);
            FastScroller.this.f18480l.setAlpha(floatValue);
            FastScroller.this.m20569g();
        }
    }

    /* renamed from: c */
    private float m20563c(float f) {
        return TypedValue.applyDimension(1, f, this.f18489u.getResources().getDisplayMetrics());
    }
}
