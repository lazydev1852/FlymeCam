package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.R;

public class StretchSearchView extends RelativeLayout {

    /* renamed from: A */
    private float f6124A;

    /* renamed from: B */
    private float f6125B;

    /* renamed from: C */
    private float f6126C;

    /* renamed from: D */
    private float f6127D;

    /* renamed from: E */
    private float f6128E;

    /* renamed from: F */
    private float f6129F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public RelativeLayout f6130G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public View f6131H;

    /* renamed from: I */
    private ImageView f6132I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public ImageView f6133J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public ImageView f6134K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public SearchEditText f6135L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public RelativeLayout f6136M;

    /* renamed from: N */
    private TextView f6137N;

    /* renamed from: O */
    private int f6138O;

    /* renamed from: P */
    private String f6139P;

    /* renamed from: Q */
    private String f6140Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public C1530b f6141R;

    /* renamed from: S */
    private C1529a f6142S;

    /* renamed from: a */
    private Context f6143a;

    /* renamed from: b */
    private int f6144b;

    /* renamed from: c */
    private int f6145c;

    /* renamed from: d */
    private int f6146d;

    /* renamed from: e */
    private int f6147e;

    /* renamed from: f */
    private int f6148f;

    /* renamed from: g */
    private int f6149g;

    /* renamed from: h */
    private int f6150h;

    /* renamed from: i */
    private int f6151i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f6152j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f6153k;

    /* renamed from: l */
    private boolean f6154l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f6155m;

    /* renamed from: n */
    private boolean f6156n;

    /* renamed from: o */
    private boolean f6157o;

    /* renamed from: p */
    private boolean f6158p;

    /* renamed from: q */
    private boolean f6159q;

    /* renamed from: r */
    private boolean f6160r;

    /* renamed from: s */
    private int f6161s;

    /* renamed from: t */
    private boolean f6162t;

    /* renamed from: u */
    private boolean f6163u;

    /* renamed from: v */
    private int f6164v;

    /* renamed from: w */
    private int f6165w;

    /* renamed from: x */
    private float f6166x;

    /* renamed from: y */
    private float f6167y;

    /* renamed from: z */
    private float f6168z;

    /* renamed from: com.meizu.common.widget.StretchSearchView$a */
    public interface C1529a {
    }

    /* renamed from: com.meizu.common.widget.StretchSearchView$b */
    public interface C1530b {
        /* renamed from: a */
        void mo17399a(View view);

        /* renamed from: a */
        void mo17400a(View view, float f);

        /* renamed from: b */
        void mo17401b(View view);
    }

    public StretchSearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StretchSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_StretchSearchViewStyle);
    }

    public StretchSearchView(Context context, int i) {
        this(context);
        this.f6161s = i;
    }

    public StretchSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6144b = 0;
        this.f6145c = 0;
        this.f6146d = 0;
        this.f6147e = 0;
        this.f6148f = 0;
        this.f6149g = 0;
        this.f6150h = 0;
        this.f6151i = 0;
        this.f6152j = false;
        this.f6154l = false;
        this.f6155m = false;
        this.f6156n = true;
        this.f6157o = true;
        this.f6158p = true;
        this.f6159q = true;
        this.f6160r = true;
        this.f6161s = 1;
        this.f6162t = false;
        this.f6163u = false;
        this.f6164v = 320;
        this.f6165w = this.f6164v;
        this.f6166x = 0.0f;
        this.f6167y = 1.0f;
        this.f6168z = 0.0f;
        this.f6124A = 1.0f;
        this.f6125B = 0.0f;
        this.f6126C = 1.0f;
        this.f6127D = 1.0f;
        this.f6128E = 0.9f;
        this.f6129F = 0.0f;
        this.f6138O = -1;
        this.f6139P = "搜索";
        this.f6141R = null;
        this.f6142S = null;
        this.f6153k = -1;
        this.f6143a = context;
        TypedArray obtainStyledAttributes = this.f6143a.obtainStyledAttributes(attributeSet, R.styleable.StretchSearchView, i, 0);
        this.f6161s = obtainStyledAttributes.getInteger(R.styleable.StretchSearchView_mcStretchTpye, this.f6161s);
        this.f6155m = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcHasVoiceIcon, this.f6155m);
        this.f6152j = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcPlayStretchOnPreDraw, this.f6152j);
        this.f6163u = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcAlignRightWhenAnim, this.f6163u);
        this.f6162t = obtainStyledAttributes.getBoolean(R.styleable.StretchSearchView_mcUseSysInterpolater, this.f6162t);
        this.f6164v = obtainStyledAttributes.getInteger(R.styleable.StretchSearchView_mcStretchDuration, this.f6164v);
        this.f6165w = obtainStyledAttributes.getInteger(R.styleable.StretchSearchView_mcShortenDuration, this.f6165w);
        this.f6139P = obtainStyledAttributes.getString(R.styleable.StretchSearchView_mcSearchTextHint);
        this.f6140Q = obtainStyledAttributes.getString(R.styleable.StretchSearchView_mcTextViewContent);
        this.f6129F = obtainStyledAttributes.getFloat(R.styleable.StretchSearchView_mcSearchLayoutInitAlpha, this.f6129F);
        this.f6138O = obtainStyledAttributes.getColor(R.styleable.StretchSearchView_mcTextViewColor, -1);
        this.f6148f = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutMarginLeftAdjust, (float) this.f6148f);
        this.f6151i = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutMarginRightAdjust, (float) this.f6151i);
        this.f6149g = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutPaddingLeft, (float) this.f6149g);
        this.f6150h = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcLayoutPaddingRight, (float) this.f6150h);
        this.f6146d = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchWidthFrom, 0.0f);
        this.f6147e = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchWidthTo, 0.0f);
        this.f6144b = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchXfrom, 0.0f);
        this.f6145c = (int) obtainStyledAttributes.getDimension(R.styleable.StretchSearchView_mcStretchXto, 0.0f);
        obtainStyledAttributes.recycle();
        mo17316a();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17317a(Context context) {
        String str;
        this.f6131H = null;
        if (this.f6161s == 0) {
            this.f6131H = View.inflate(context, R.layout.mc_stretch_search_layout_ext, this);
            str = "R.layout.mc_move_search_layout";
        } else if (3 == this.f6161s) {
            this.f6131H = View.inflate(context, R.layout.mc_move_search_layout, this);
            str = "R.layout.mc_move_search_layout";
        } else if (2 == this.f6161s) {
            this.f6131H = View.inflate(context, R.layout.mc_stretch_search_layout_ext, this);
            str = "R.layout.mc_stretch_search_layout_ext";
        } else {
            this.f6131H = View.inflate(context, R.layout.mc_stretch_search_layout, this);
            str = "R.layout.mc_stretch_search_layout";
        }
        if (this.f6131H != null) {
            this.f6130G = (RelativeLayout) this.f6131H.findViewById(R.id.mc_stretch_search_layout);
            this.f6136M = (RelativeLayout) this.f6131H.findViewById(R.id.mc_search_layout);
            this.f6134K = (ImageView) this.f6131H.findViewById(R.id.mc_voice_icon);
            this.f6132I = (ImageView) this.f6131H.findViewById(R.id.mc_search_icon);
            this.f6133J = (ImageView) this.f6131H.findViewById(R.id.mc_search_icon_input_clear);
            this.f6135L = (SearchEditText) this.f6131H.findViewById(R.id.mc_search_edit);
            this.f6135L.setAlpha(this.f6129F);
            this.f6135L.setHint(this.f6139P);
            if (this.f6154l) {
                this.f6137N = (TextView) this.f6131H.findViewById(R.id.mc_search_textview);
                this.f6137N.setTextColor(this.f6138O);
                this.f6137N.setText(this.f6140Q);
                this.f6137N.setAlpha(0.0f);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.rightMargin = this.f6151i;
            this.f6136M.setLayoutParams(layoutParams);
            this.f6130G.setPadding(this.f6149g, this.f6130G.getTop(), this.f6150h, this.f6130G.getBottom());
            this.f6130G.requestLayout();
            return;
        }
        throw new IllegalArgumentException("StretchSearchView cannot inflate " + str + "!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17316a() {
        mo17319b();
        mo17317a(this.f6143a);
        mo17348h();
        mo17320c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo17319b() {
        boolean z = false;
        this.f6154l = 2 == this.f6161s || 4 == this.f6161s || this.f6161s == 0;
        if (true != this.f6163u) {
            z = true;
        }
        this.f6157o = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo17320c() {
        this.f6132I.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StretchSearchView.this.mo17351k();
            }
        });
        this.f6133J.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StretchSearchView.this.f6135L.setText("");
            }
        });
        this.f6135L.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                String obj = StretchSearchView.this.f6135L.getText().toString();
                if (obj == null || obj.isEmpty()) {
                    StretchSearchView.this.f6133J.setVisibility(8);
                    if (StretchSearchView.this.f6153k == 2 && StretchSearchView.this.f6155m) {
                        StretchSearchView.this.f6134K.setVisibility(0);
                    }
                    StretchSearchView.this.mo17318a(true);
                    return;
                }
                if (StretchSearchView.this.f6155m) {
                    StretchSearchView.this.f6134K.setVisibility(8);
                }
                StretchSearchView.this.f6133J.setVisibility(0);
            }
        });
        if (4 == this.f6161s || 3 == this.f6161s) {
            this.f6135L.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StretchSearchView.this.mo17351k();
                }
            });
        }
        m6139l();
    }

    /* renamed from: l */
    private void m6139l() {
        this.f6130G.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                StretchSearchView.this.f6130G.getViewTreeObserver().removeOnPreDrawListener(this);
                StretchSearchView.this.mo17321d();
                if (!StretchSearchView.this.f6152j) {
                    return true;
                }
                StretchSearchView.this.mo17351k();
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo17321d() {
        if (this.f6161s != 0) {
            mo17323f();
            mo17322e();
        }
        if (3 == this.f6161s || 4 == this.f6161s) {
            mo17324g();
        }
        Log.i("StretchSearchView", "Stretch width from " + this.f6146d + " to " + this.f6147e + ", move X from " + this.f6144b + " to " + this.f6145c + " !");
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo17322e() {
        this.f6146d = this.f6136M.getMeasuredWidth();
        this.f6147e = getMaxStretchWidth();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo17323f() {
        this.f6144b = (int) this.f6136M.getX();
        this.f6145c = getMinMoveX();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo17324g() {
        int i = this.f6144b;
        int measureText = (((int) this.f6135L.getPaint().measureText(this.f6135L.getHint().toString())) / 2) + this.f6132I.getMeasuredWidth();
        this.f6146d = (getMaxStretchWidth() / 2) + measureText;
        this.f6144b = (this.f6130G.getMeasuredWidth() / 2) - measureText;
        this.f6145c = getMinMoveX();
        this.f6136M.setX((float) this.f6144b);
        Log.i("StretchSearchView", "Reset stretch layout, search icon location X to layout right:  " + this.f6146d + ",search icon location X: " + this.f6144b + " !");
        ImageView imageView = (ImageView) this.f6130G.findViewById(R.id.mc_stretch_search_layout_1);
        if (imageView != null) {
            imageView.setX((float) (this.f6145c - this.f6132I.getPaddingLeft()));
        }
    }

    /* access modifiers changed from: protected */
    public int getMaxStretchWidth() {
        int measuredWidth = this.f6130G.getMeasuredWidth();
        int paddingLeft = this.f6130G.getPaddingLeft();
        return this.f6154l ? (measuredWidth - this.f6137N.getLayoutParams().width) - paddingLeft : (measuredWidth - paddingLeft) - this.f6130G.getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public int getMinMoveX() {
        return ((int) this.f6130G.getX()) + this.f6130G.getPaddingLeft() + this.f6148f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo17348h() {
        if (3 == this.f6161s || 4 == this.f6161s) {
            this.f6131H.setVisibility(0);
            this.f6135L.setVisibility(0);
            this.f6135L.setBackground((Drawable) null);
            this.f6168z = 0.8f;
        } else {
            this.f6131H.setVisibility(0);
            this.f6135L.setVisibility(8);
        }
        this.f6153k = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo17349i() {
        this.f6131H.requestLayout();
        this.f6131H.setVisibility(0);
        this.f6135L.setVisibility(0);
        this.f6135L.setText("");
        if (this.f6154l) {
            this.f6137N.setVisibility(0);
            this.f6137N.setAlpha(0.0f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo17350j() {
        this.f6131H.requestLayout();
        this.f6135L.mo17270a(true);
        if (this.f6155m) {
            this.f6134K.setVisibility(0);
        }
    }

    /* renamed from: k */
    public void mo17351k() {
        m6140m();
    }

    /* renamed from: m */
    private void m6140m() {
        if (this.f6153k == 0 || this.f6153k == 4) {
            this.f6153k = 1;
            mo17349i();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) this.f6164v);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f6136M, "x", new float[]{(float) this.f6145c});
            ofFloat.setDuration((long) this.f6164v);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f6136M, "width", new float[]{(float) this.f6147e});
            ofFloat2.setDuration((long) this.f6164v);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StretchSearchView.this.f6136M.setLayoutParams(new RelativeLayout.LayoutParams((int) ((Float) valueAnimator.getAnimatedValue()).floatValue(), StretchSearchView.this.f6136M.getHeight()));
                }
            });
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f6136M, "StretchSearchViewAnimValue", new float[]{this.f6125B, this.f6126C});
            ofFloat3.setDuration((long) this.f6164v);
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (StretchSearchView.this.f6141R != null) {
                        StretchSearchView.this.f6141R.mo17400a(StretchSearchView.this.f6131H, floatValue);
                    }
                }
            });
            animatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (StretchSearchView.this.f6141R != null) {
                        StretchSearchView.this.f6141R.mo17399a(StretchSearchView.this.f6131H);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    StretchSearchView.this.mo17350j();
                    int unused = StretchSearchView.this.f6153k = 2;
                    if (StretchSearchView.this.f6141R != null) {
                        StretchSearchView.this.f6141R.mo17401b(StretchSearchView.this.f6131H);
                    }
                }
            });
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f6133J, "alpha", new float[]{this.f6166x, this.f6167y});
            ofFloat4.setDuration((long) this.f6164v);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f6135L, "alpha", new float[]{this.f6168z, this.f6124A});
            ofFloat5.setDuration((long) this.f6164v);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f6132I, "scaleX", new float[]{this.f6127D, this.f6128E});
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f6132I, "scaleY", new float[]{this.f6127D, this.f6128E});
            ofFloat6.setDuration((long) this.f6164v);
            ofFloat7.setDuration((long) this.f6164v);
            if (this.f6162t) {
                ofFloat.setInterpolator(getMovingInterpolater());
                ofFloat2.setInterpolator(getStretchInterpolater());
                ofFloat6.setInterpolator(getScaleInterpolater());
                ofFloat7.setInterpolator(getScaleInterpolater());
            }
            animatorSet.play(ofFloat3);
            if (this.f6157o) {
                animatorSet.play(ofFloat3).with(ofFloat);
            }
            if (this.f6159q) {
                animatorSet.play(ofFloat3).with(ofFloat4);
            }
            if (this.f6160r) {
                animatorSet.play(ofFloat3).with(ofFloat5);
            }
            if (this.f6156n) {
                animatorSet.play(ofFloat3).with(ofFloat2);
            }
            if (this.f6158p) {
                animatorSet.play(ofFloat3).with(ofFloat6).with(ofFloat7);
            }
            if (this.f6154l) {
                ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f6137N, "alpha", new float[]{0.0f, 1.0f});
                ofFloat8.setDuration((long) ((this.f6164v * 2) / 3));
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration((long) ((this.f6164v * 2) / 3));
                animatorSet2.play(ofFloat8).after((long) (this.f6164v / 3));
                animatorSet2.start();
            }
            animatorSet.start();
        }
    }

    /* renamed from: a */
    public void mo17318a(boolean z) {
        this.f6135L.mo17270a(z);
    }

    public void setAutoPlayStretchOnPreDraw(boolean z) {
        this.f6152j = z;
    }

    public void setHaveVoiceIcon(boolean z) {
        this.f6155m = z;
    }

    public void setPlayStretchWidthAnim(boolean z) {
        this.f6156n = z;
    }

    public void setPlayMoveXAnim(boolean z) {
        this.f6157o = z;
    }

    public void setPlaySearchImgScaleAnim(boolean z) {
        this.f6158p = z;
    }

    public void setPlaySearchclearAlphaAnim(boolean z) {
        this.f6159q = z;
    }

    public void setPlayInputTextAlhpaAnim(boolean z) {
        this.f6160r = z;
    }

    public void setCustomAnimValueFrom(float f) {
        this.f6125B = f;
    }

    public float getCustomAnimValueFrom() {
        return this.f6125B;
    }

    public void setCustomAnimValueTo(float f) {
        this.f6126C = f;
    }

    public float getCustomAnimValueTo() {
        return this.f6167y;
    }

    public void setInputTextAlphaFrom(float f) {
        this.f6168z = f;
    }

    public float getInputTextAlphaFrom() {
        return this.f6168z;
    }

    public void setInputTextAlphaTo(float f) {
        this.f6124A = f;
    }

    public float getInputTextAlphaTo() {
        return this.f6167y;
    }

    public void setInputClearAlphaFrom(float f) {
        this.f6168z = f;
    }

    public float getInputClearAlphaFrom() {
        return this.f6168z;
    }

    public void setInputClearAlphaTo(float f) {
        this.f6124A = f;
    }

    public int getInputClearAlphaTo() {
        return this.f6147e;
    }

    public void setVoiceIconListener(View.OnClickListener onClickListener) {
        if (this.f6155m) {
            this.f6134K.setOnClickListener(onClickListener);
        }
    }

    public void setBtnListener(View.OnClickListener onClickListener) {
        if (this.f6137N != null) {
            this.f6137N.setOnClickListener(onClickListener);
        }
    }

    public void setEditTextListener(View.OnClickListener onClickListener) {
        this.f6135L.setOnClickListener(onClickListener);
    }

    public int getStretchWidthFrom() {
        return this.f6146d;
    }

    public void setStretchWidthFrom(int i) {
        this.f6146d = i;
    }

    public int getStretchWidthTo() {
        return this.f6147e;
    }

    public void setStretchWidthTo(int i) {
        this.f6147e = i;
    }

    public int getStretchXfrom() {
        return this.f6144b;
    }

    public void setStretchXfrom(int i) {
        this.f6144b = i;
    }

    public int getStretchXto() {
        return this.f6145c;
    }

    public void setStretchXto(int i) {
        this.f6145c = i;
    }

    public float getScaleFrom() {
        return this.f6127D;
    }

    public void setScaleFrom(float f) {
        this.f6127D = f;
    }

    public float getScaleTo() {
        return this.f6128E;
    }

    public void setScaleTo(float f) {
        this.f6128E = f;
    }

    public int getLayoutMarginLeftAdjust() {
        return this.f6148f;
    }

    public void setLayoutMarginLeftAdjust(int i) {
        this.f6148f = i;
    }

    public int getLayoutMarginRightAdjust() {
        return this.f6151i;
    }

    public void setLayoutMarginRightAdjust(int i) {
        this.f6151i = i;
    }

    public String getSearchText() {
        return this.f6135L.getText().toString();
    }

    public void setSearchText(String str) {
        this.f6135L.setText(str);
    }

    public String getBtnText() {
        if (!this.f6154l) {
            return null;
        }
        return this.f6137N.getText().toString();
    }

    public void setBtnText(String str) {
        if (this.f6154l) {
            this.f6137N.setText(str);
        }
    }

    public boolean getUseInterpolater() {
        return this.f6162t;
    }

    public void setUseInterpolater(boolean z) {
        this.f6162t = z;
    }

    public boolean getIsAlignRight() {
        return this.f6163u;
    }

    public void setIsAlignRigh(boolean z) {
        this.f6163u = z;
    }

    private Interpolator getMovingInterpolater() {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(0.3333f, 0.0f, 0.1f, 1.0f) : new DecelerateInterpolator();
    }

    private Interpolator getScaleInterpolater() {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(0.3333f, 0.0f, 0.0f, 1.0f) : new DecelerateInterpolator();
    }

    private Interpolator getStretchInterpolater() {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f) : new DecelerateInterpolator();
    }

    public void setStretchAnimDuration(int i) {
        this.f6164v = i;
    }

    public int getStretchAnimDuration() {
        return this.f6164v;
    }

    public void setShortenAnimDuration(int i) {
        this.f6165w = i;
    }

    public int getShortenAnimDuration() {
        return this.f6165w;
    }

    public int getAnimationState() {
        return this.f6153k;
    }

    public void setOnStretchAnimationListener(C1530b bVar) {
        this.f6141R = bVar;
    }

    public void setOnShortenAnimationListener(C1529a aVar) {
        this.f6142S = aVar;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(StretchSearchView.class.getName());
    }
}
