package flyme.support.p093v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import flyme.support.p093v7.R;
import flyme.support.p093v7.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: flyme.support.v7.widget.RecyclerFastScrollLetter */
public class RecyclerFastScrollLetter extends LinearLayout {

    /* renamed from: x */
    private static Field f17908x;

    /* renamed from: a */
    private boolean f17909a;

    /* renamed from: b */
    private MzRecyclerView f17910b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f17911c;

    /* renamed from: d */
    private Drawable f17912d;

    /* renamed from: e */
    private float f17913e;

    /* renamed from: f */
    private float f17914f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f17915g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ObjectAnimator f17916h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f17917i;

    /* renamed from: j */
    private LinearLayout f17918j;

    /* renamed from: k */
    private float f17919k;

    /* renamed from: l */
    private float f17920l;

    /* renamed from: m */
    private float f17921m;

    /* renamed from: n */
    private float f17922n;

    /* renamed from: o */
    private Drawable f17923o;

    /* renamed from: p */
    private Drawable f17924p;

    /* renamed from: q */
    private Drawable f17925q;

    /* renamed from: r */
    private Map<String, String> f17926r;

    /* renamed from: s */
    private final C3249b f17927s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f17928t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f17929u;

    /* renamed from: v */
    private int f17930v;

    /* renamed from: w */
    private String f17931w;

    /* renamed from: flyme.support.v7.widget.RecyclerFastScrollLetter$a */
    public interface C3248a {
        /* renamed from: a */
        String mo26349a(float f);

        /* renamed from: b */
        int mo26350b(float f);
    }

    public RecyclerFastScrollLetter(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerFastScrollLetter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.RecyclerFastScrollLetterStyle);
    }

    public RecyclerFastScrollLetter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17909a = true;
        this.f17913e = 0.0f;
        this.f17914f = 0.0f;
        this.f17915g = 80.0f;
        this.f17916h = null;
        this.f17919k = 0.0f;
        this.f17920l = 0.0f;
        this.f17921m = 0.0f;
        this.f17922n = 0.0f;
        this.f17926r = null;
        this.f17927s = new C3249b();
        this.f17931w = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerFastScrollLetter, i, R.style.RecyclerFastScrollLetter);
        this.f17924p = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcLetterBarTouchUpBkDrawable);
        this.f17923o = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcLetterBarTouchDownBkDrawable);
        this.f17925q = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcLetterBarTouchMoveBkDrawable);
        this.f17912d = obtainStyledAttributes.getDrawable(R.styleable.RecyclerFastScrollLetter_mcOverlayBkDrawable);
        this.f17919k = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingLeft, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_left));
        this.f17921m = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingRight, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_right));
        this.f17920l = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingTop, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_top));
        this.f17922n = obtainStyledAttributes.getDimension(R.styleable.RecyclerFastScrollLetter_mcLetterBarPaddingBottom, getResources().getDimension(R.dimen.fastscroller_letterbar_padding_bottom));
        obtainStyledAttributes.recycle();
        m19550a(context);
    }

    public void setLetterBarTouchDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.f17924p = drawable;
        this.f17923o = drawable2;
        this.f17925q = drawable3;
    }

    /* renamed from: a */
    private void m19550a(Context context) {
        setOrientation(0);
        setClipChildren(false);
        LayoutInflater.from(context).inflate(R.layout.layout_recycler_fastscroller, this, true);
        this.f17911c = (TextView) findViewById(R.id.fastscroller_overlay);
        this.f17917i = findViewById(R.id.fastscroller_letterbar);
        this.f17918j = (LinearLayout) findViewById(R.id.fastscroller_letterbar_layout);
        this.f17911c.setVisibility(4);
        m19553c();
        setOverlayBackground(this.f17912d);
        setLetterBarBackground(this.f17924p);
        setLetterBarPadding(this.f17919k, this.f17920l, this.f17921m, this.f17922n);
        setLetterBarTouchDrawable(this.f17924p, this.f17923o, this.f17925q);
        try {
            if (1 == Settings.Global.getInt(context.getContentResolver(), "flymelab_flyme_night_mode", 0)) {
                Method declaredMethod = BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", new Class[]{Boolean.TYPE});
                declaredMethod.invoke(this.f17912d, new Object[]{true});
                declaredMethod.invoke(this.f17924p, new Object[]{true});
                declaredMethod.invoke(this.f17923o, new Object[]{true});
                declaredMethod.invoke(this.f17925q, new Object[]{true});
            }
        } catch (Exception unused) {
            Log.e("RecyclerView", "NightMode methods reflected failed!");
        }
    }

    /* renamed from: c */
    private void m19553c() {
        this.f17917i.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                RecyclerFastScrollLetter.this.f17917i.getViewTreeObserver().removeOnPreDrawListener(this);
                RecyclerFastScrollLetter.this.m19555d();
                float c = RecyclerFastScrollLetter.this.f17928t - RecyclerFastScrollLetter.this.f17915g;
                if (c < 0.0f) {
                    c = 0.0f;
                }
                RecyclerFastScrollLetter.this.setOverlayPositionRange(c, (RecyclerFastScrollLetter.this.f17929u + RecyclerFastScrollLetter.this.f17915g) - ((float) RecyclerFastScrollLetter.this.f17911c.getMeasuredHeight()));
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m19555d() {
        this.f17928t = this.f17917i.getY();
        this.f17930v = this.f17917i.getMeasuredHeight();
        this.f17929u = this.f17928t + ((float) this.f17930v);
    }

    public void setOverlayX(float f) {
        this.f17911c.setX(f);
    }

    public float getOverlayX() {
        return this.f17911c.getX();
    }

    public float getOverlayY() {
        return this.f17911c.getY();
    }

    public void setOverlayPositionRange(float f, float f2) {
        this.f17913e = f;
        this.f17914f = f2;
    }

    public float getOverlayMinY() {
        return this.f17913e;
    }

    public float getOverlayMaxY() {
        return this.f17914f;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m19555d();
        setOverlayPositionRange(this.f17928t, this.f17929u);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!this.f17909a) {
            return false;
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                if (motionEvent.getY() < this.f17928t || motionEvent.getY() > this.f17929u) {
                    return false;
                }
                if (getLayoutDirection() == 1) {
                    if (motionEvent.getX() > this.f17918j.getX() + ((float) this.f17918j.getPaddingLeft()) + ((float) this.f17918j.getWidth()) + ((float) this.f17918j.getPaddingRight())) {
                        return false;
                    }
                } else if (motionEvent.getX() < this.f17918j.getX()) {
                    return false;
                }
                setOverlayPosition(y);
                setRecyclerViewPosition(y);
                setLetterBarBackground(this.f17923o);
                if (this.f17916h != null) {
                    this.f17916h.cancel();
                }
                if (this.f17911c.getVisibility() == 4) {
                    mo26327a();
                }
                return true;
            case 1:
                if (motionEvent.getY() < this.f17928t || motionEvent.getY() > this.f17929u) {
                    mo26328b();
                }
                setLetterBarBackground(this.f17924p);
                break;
            case 2:
                if (motionEvent.getY() < this.f17928t || motionEvent.getY() > this.f17929u) {
                    return false;
                }
                setOverlayPosition(y);
                setRecyclerViewPosition(y);
                if (this.f17911c.getVisibility() == 4) {
                    mo26327a();
                }
                setLetterBarBackground(this.f17925q);
                return true;
            case 3:
                break;
            default:
                return super.onTouchEvent(motionEvent);
        }
        mo26328b();
        return true;
    }

    public void setRecyclerView(MzRecyclerView mzRecyclerView) {
        this.f17910b = mzRecyclerView;
        this.f17910b.setOnScrollListener(this.f17927s);
    }

    public MzRecyclerView getMzRecyclerView() {
        return this.f17910b;
    }

    @TargetApi(16)
    public void setLetterBarBackground(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (this.f17917i instanceof ImageView) {
            ((ImageView) this.f17917i).setImageDrawable(drawable);
        } else {
            this.f17917i.setBackground(drawable);
        }
    }

    @TargetApi(16)
    public void setOverlayBackground(Drawable drawable) {
        if (drawable != null) {
            this.f17911c.setBackground(drawable);
        }
    }

    public void setLetterBarPadding(float f, float f2, float f3, float f4) {
        this.f17919k = f;
        this.f17920l = f2;
        this.f17921m = f3;
        this.f17922n = f4;
        this.f17918j.setPadding((int) this.f17919k, (int) this.f17920l, (int) this.f17921m, (int) this.f17922n);
    }

    public void setFastScrollerEnabled(boolean z) {
        this.f17909a = z;
        setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    public float mo26326a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f3), f2);
    }

    private void setRecyclerViewPosition(float f) {
        int i;
        if (this.f17910b != null) {
            float a = mo26325a(f);
            RecyclerView.C3260a adapter = this.f17910b.getAdapter();
            if (adapter instanceof HeaderAndFooterWrapperAdapter) {
                HeaderAndFooterWrapperAdapter lVar = (HeaderAndFooterWrapperAdapter) adapter;
                i = lVar.mo27190b();
                adapter = lVar.mo27194e();
            } else {
                i = 0;
            }
            C3248a aVar = (C3248a) adapter;
            String a2 = aVar.mo26349a(a);
            if (a2 != null && !this.f17931w.equals(a2)) {
                m19557e();
                this.f17931w = a2;
            }
            int b = aVar.mo26350b(a);
            if (this.f17910b.getLayoutManager() instanceof GridLayoutManager) {
                ((GridLayoutManager) this.f17910b.getLayoutManager()).mo26077b(b + i, 0);
            }
            if (this.f17910b.getLayoutManager() instanceof LinearLayoutManager) {
                ((LinearLayoutManager) this.f17910b.getLayoutManager()).mo26077b(b + i, 0);
            }
            if (this.f17910b.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) this.f17910b.getLayoutManager()).mo26848a(b + i, 0);
            }
            this.f17911c.setText(a2);
        }
    }

    /* renamed from: e */
    private void m19557e() {
        if (m19559f()) {
            performHapticFeedback(20120);
        }
    }

    /* renamed from: f */
    private boolean m19559f() {
        try {
            if (f17908x == null) {
                f17908x = Class.forName("flyme.config.FlymeFeature").getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
            }
            return f17908x.getBoolean((Object) null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo26325a(float f) {
        if (f <= this.f17928t) {
            return 0.0f;
        }
        if (f >= this.f17929u) {
            return 1.0f;
        }
        return (f - this.f17928t) / ((float) this.f17930v);
    }

    private void setOverlayPosition(float f) {
        this.f17911c.setY(mo26326a(this.f17913e, this.f17914f, (float) ((int) (this.f17913e + (mo26325a(f) * (this.f17914f - this.f17913e))))));
        if (this.f17926r != null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            String charSequence = this.f17911c.getText().toString();
            if (this.f17926r.containsKey(charSequence)) {
                shapeDrawable.getPaint().setColor(Color.parseColor(this.f17926r.get(charSequence)));
                this.f17911c.setBackground(shapeDrawable);
            }
        }
    }

    public void setBackgroundColorSet(Map<String, String> map) {
        this.f17926r = map;
    }

    /* renamed from: a */
    public void mo26327a() {
        this.f17911c.setVisibility(0);
        if (this.f17916h != null) {
            this.f17916h.cancel();
        }
        this.f17916h = ObjectAnimator.ofFloat(this.f17911c, "alpha", new float[]{0.0f, 1.0f}).setDuration(100);
        this.f17916h.start();
    }

    /* renamed from: b */
    public void mo26328b() {
        if (this.f17916h != null) {
            this.f17916h.cancel();
        }
        this.f17916h = ObjectAnimator.ofFloat(this.f17911c, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
        this.f17916h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RecyclerFastScrollLetter.this.f17911c.setVisibility(4);
                ObjectAnimator unused = RecyclerFastScrollLetter.this.f17916h = null;
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                RecyclerFastScrollLetter.this.f17911c.setVisibility(4);
                ObjectAnimator unused = RecyclerFastScrollLetter.this.f17916h = null;
            }
        });
        this.f17916h.start();
    }

    /* renamed from: flyme.support.v7.widget.RecyclerFastScrollLetter$b */
    private class C3249b extends RecyclerView.C3274l {
        private C3249b() {
        }
    }

    public View getLetterBar() {
        return this.f17917i;
    }
}
