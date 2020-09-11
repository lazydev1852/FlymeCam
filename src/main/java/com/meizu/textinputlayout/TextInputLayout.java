package com.meizu.textinputlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.meizu.textinputlayout.ValueAnimatorCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class TextInputLayout extends LinearLayout {

    /* renamed from: q */
    private static Field f16049q;

    /* renamed from: r */
    private static Field f16050r;

    /* renamed from: s */
    private static Field f16051s;

    /* renamed from: t */
    private static Method f16052t;

    /* renamed from: a */
    private int f16053a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f16054b;

    /* renamed from: c */
    private CharSequence f16055c;

    /* renamed from: d */
    private Paint f16056d;

    /* renamed from: e */
    private boolean f16057e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f16058f;

    /* renamed from: g */
    private int f16059g;

    /* renamed from: h */
    private ColorStateList f16060h;

    /* renamed from: i */
    private ColorStateList f16061i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final CollapsingTextHelper f16062j;

    /* renamed from: k */
    private boolean f16063k;

    /* renamed from: l */
    private ValueAnimatorCompat f16064l;

    /* renamed from: m */
    private int f16065m;

    /* renamed from: n */
    private int f16066n;

    /* renamed from: o */
    private boolean f16067o;

    /* renamed from: p */
    private int f16068p;

    public TextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f16053a = 300;
        this.f16062j = new CollapsingTextHelper(this);
        this.f16065m = 6;
        this.f16066n = 0;
        this.f16067o = true;
        this.f16068p = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f16062j.mo24646a(AnimationUtils.f16076b);
        this.f16062j.mo24652b((Interpolator) new AccelerateInterpolator());
        this.f16062j.mo24656d(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzTextInputLayout, i, R.style.MzTextInputLayoutTextAppearance);
        this.f16055c = obtainStyledAttributes.getText(R.styleable.MzTextInputLayout_android_hint);
        this.f16063k = obtainStyledAttributes.getBoolean(R.styleable.MzTextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(R.styleable.MzTextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.MzTextInputLayout_android_textColorHint);
            this.f16061i = colorStateList;
            this.f16060h = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(R.styleable.MzTextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.MzTextInputLayout_hintTextAppearance, 0));
        }
        this.f16059g = obtainStyledAttributes.getResourceId(R.styleable.MzTextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.MzTextInputLayout_errorEnabled, false);
        obtainStyledAttributes.recycle();
        this.f16065m = context.getResources().getDimensionPixelSize(R.dimen.mz_text_input_layout_default_margin_top);
        setErrorEnabled(z);
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new TextInputAccessibilityDelegate());
    }

    private Interpolator getInterpolator() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);
        }
        return new C2963a();
    }

    /* renamed from: com.meizu.textinputlayout.TextInputLayout$a */
    private class C2963a implements Interpolator {
        private C2963a() {
        }

        public float getInterpolation(float f) {
            return (float) (1.0d - Math.pow((double) (1.0f - f), 2.0d));
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            setEditText((EditText) view);
            super.addView(view, 0, m17423a(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        this.f16062j.mo24645a(typeface);
    }

    public void setEditText(EditText editText) {
        if (this.f16054b == null) {
            this.f16054b = editText;
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                this.f16054b.setGravity(5);
            }
            this.f16062j.mo24645a(this.f16054b.getTypeface());
            this.f16062j.mo24641a(this.f16054b.getTextSize());
            this.f16062j.mo24654c(this.f16054b.getGravity());
            this.f16054b.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    TextInputLayout.this.m17427a(true);
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (TextInputLayout.this.f16054b != null && TextInputLayout.this.f16054b.getText().length() == 0) {
                        TextInputLayout.this.setErrorEnabled(false);
                        if (Build.VERSION.SDK_INT >= 21) {
                            TextInputLayout.this.f16054b.setBackgroundTintList((ColorStateList) null);
                        }
                    }
                }
            });
            if (this.f16060h == null) {
                this.f16060h = this.f16054b.getHintTextColors();
            }
            if (TextUtils.isEmpty(this.f16055c)) {
                setHint(this.f16054b.getHint());
                this.f16054b.setHint((CharSequence) null);
            }
            if (this.f16058f != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16054b.getLayoutParams();
                ViewCompat.setPaddingRelative(this.f16058f, ViewCompat.getPaddingStart(this.f16054b), this.f16065m, ViewCompat.getPaddingEnd(this.f16054b), this.f16054b.getPaddingBottom());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f16058f.getLayoutParams();
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                this.f16058f.setLayoutParams(layoutParams2);
            }
            m17427a(false);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    /* renamed from: a */
    private LinearLayout.LayoutParams m17423a(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f16056d == null) {
            this.f16056d = new Paint();
        }
        this.f16056d.setTypeface(this.f16062j.mo24648b());
        this.f16056d.setTextSize(this.f16062j.mo24655d());
        layoutParams2.topMargin = (((int) (-this.f16056d.ascent())) * 13) / 10;
        this.f16066n = layoutParams2.topMargin;
        return layoutParams2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17427a(boolean z) {
        int i;
        boolean z2 = this.f16054b != null && !TextUtils.isEmpty(this.f16054b.getText());
        boolean a = m17428a(getDrawableState(), 16842908);
        if (!(this.f16060h == null || this.f16061i == null)) {
            this.f16062j.mo24650b(this.f16060h.getDefaultColor());
            CollapsingTextHelper bVar = this.f16062j;
            if (a) {
                i = this.f16061i.getDefaultColor();
            } else {
                i = this.f16060h.getDefaultColor();
            }
            bVar.mo24642a(i);
        }
        if (z2 || a) {
            m17430b(z);
        } else {
            m17432c(z);
        }
    }

    @Nullable
    public EditText getEditText() {
        return this.f16054b;
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f16055c = charSequence;
        this.f16062j.mo24647a(charSequence);
        sendAccessibilityEvent(2048);
    }

    @Nullable
    public CharSequence getHint() {
        return this.f16055c;
    }

    public void setHintTextAppearance(@StyleRes int i) {
        this.f16062j.mo24658e(i);
        this.f16061i = ColorStateList.valueOf(this.f16062j.mo24660g());
        if (this.f16054b != null) {
            m17427a(false);
            this.f16054b.setLayoutParams(m17423a(this.f16054b.getLayoutParams()));
            this.f16054b.requestLayout();
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.f16057e != z) {
            if (this.f16058f != null) {
                ViewCompat.animate(this.f16058f).cancel();
            }
            if (z) {
                this.f16058f = new TextView(getContext());
                this.f16058f.setTextAppearance(getContext(), this.f16059g);
                this.f16058f.setVisibility(4);
                if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    this.f16058f.setGravity(GravityCompat.END);
                }
                addView(this.f16058f);
                if (this.f16054b != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16054b.getLayoutParams();
                    ViewCompat.setPaddingRelative(this.f16058f, ViewCompat.getPaddingStart(this.f16054b), this.f16065m, ViewCompat.getPaddingEnd(this.f16054b), 0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f16058f.getLayoutParams();
                    layoutParams2.leftMargin = layoutParams.leftMargin;
                    layoutParams2.rightMargin = layoutParams.rightMargin;
                    this.f16058f.setLayoutParams(layoutParams2);
                }
            } else {
                getContext().getResources();
                ViewCompat.setBackgroundTintList(this.f16054b, (ColorStateList) null);
                m17425a(this.f16054b, this.f16068p);
                removeView(this.f16058f);
                this.f16058f = null;
            }
            this.f16057e = z;
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        boolean z;
        if (this.f16057e) {
            z = false;
        } else if (!TextUtils.isEmpty(charSequence)) {
            setErrorEnabled(true);
            z = true;
        } else {
            return;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            ViewCompat.setAlpha(this.f16058f, 0.0f);
            this.f16058f.setText(charSequence);
            ViewCompat.animate(this.f16058f).alpha(1.0f).setDuration((long) this.f16053a).setInterpolator(AnimationUtils.f16076b).setListener(new ViewPropertyAnimatorListenerAdapter() {
                public void onAnimationStart(View view) {
                    view.setVisibility(0);
                }
            }).start();
            if (z) {
                int[] iArr = {this.f16058f.getCurrentTextColor(), getContext().getResources().getColor(R.color.mz_text_input_normal_color)};
                ViewCompat.setBackgroundTintList(this.f16054b, new ColorStateList(new int[][]{new int[]{16842910, 16842908}, new int[0]}, iArr));
                m17425a(this.f16054b, R.drawable.mz_text_cursor_error_color);
            }
        } else if (this.f16058f.getVisibility() == 0) {
            ViewCompat.animate(this.f16058f).alpha(0.0f).setDuration((long) this.f16053a).setInterpolator(AnimationUtils.f16076b).setListener(new ViewPropertyAnimatorListenerAdapter() {
                public void onAnimationEnd(View view) {
                    view.setVisibility(4);
                }
            }).start();
            getContext().getResources();
            ViewCompat.setBackgroundTintList(this.f16054b, (ColorStateList) null);
            m17425a(this.f16054b, this.f16068p);
        }
        sendAccessibilityEvent(2048);
    }

    @Nullable
    public CharSequence getError() {
        if (!this.f16057e || this.f16058f == null || this.f16058f.getVisibility() != 0) {
            return null;
        }
        return this.f16058f.getText();
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f16063k = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f16067o) {
            this.f16062j.mo24644a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f16054b != null) {
            int left = this.f16054b.getLeft() + this.f16054b.getCompoundPaddingLeft();
            int right = this.f16054b.getRight() - this.f16054b.getCompoundPaddingRight();
            this.f16062j.mo24643a(left, this.f16054b.getTop() + this.f16054b.getCompoundPaddingTop(), right, this.f16054b.getBottom() - this.f16054b.getCompoundPaddingBottom());
            this.f16062j.mo24651b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.f16062j.mo24657e();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        m17427a(ViewCompat.isLaidOut(this));
    }

    /* renamed from: b */
    private void m17430b(boolean z) {
        if (this.f16064l != null && this.f16064l.mo24666b()) {
            this.f16064l.mo24668d();
        }
        if (!z || !this.f16063k) {
            this.f16062j.mo24649b(1.0f);
        } else {
            m17424a(1.0f);
        }
    }

    /* renamed from: c */
    private void m17432c(boolean z) {
        if (this.f16064l != null && this.f16064l.mo24666b()) {
            this.f16064l.mo24668d();
        }
        if (!z || !this.f16063k) {
            this.f16062j.mo24649b(0.0f);
        } else {
            m17424a(0.0f);
        }
    }

    /* renamed from: a */
    private void m17424a(float f) {
        if (this.f16062j.mo24653c() != f) {
            if (this.f16064l == null) {
                this.f16064l = ViewUtils.m17511a();
                this.f16064l.mo24664a(getInterpolator());
                this.f16064l.mo24663a(this.f16053a);
                this.f16064l.mo24665a((ValueAnimatorCompat.C2966a) new ValueAnimatorCompat.C2966a() {
                    /* renamed from: a */
                    public void mo24638a(ValueAnimatorCompat eVar) {
                        TextInputLayout.this.f16062j.mo24649b(eVar.mo24667c());
                    }
                });
            }
            this.f16064l.mo24662a(this.f16062j.mo24653c(), f);
            this.f16064l.mo24661a();
        }
    }

    private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        private TextInputAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence f = TextInputLayout.this.f16062j.mo24659f();
            if (!TextUtils.isEmpty(f)) {
                accessibilityEvent.getText().add(f);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence f = TextInputLayout.this.f16062j.mo24659f();
            if (!TextUtils.isEmpty(f)) {
                accessibilityNodeInfoCompat.setText(f);
            }
            if (TextInputLayout.this.f16054b != null) {
                accessibilityNodeInfoCompat.setLabelFor(TextInputLayout.this.f16054b);
            }
            CharSequence text = TextInputLayout.this.f16058f != null ? TextInputLayout.this.f16058f.getText() : null;
            if (!TextUtils.isEmpty(text)) {
                accessibilityNodeInfoCompat.setContentInvalid(true);
                accessibilityNodeInfoCompat.setError(text);
            }
        }
    }

    /* renamed from: a */
    private static boolean m17428a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public void setAnimationDuration(int i) {
        this.f16053a = i;
    }

    public void setCollapsedTextColor(int i) {
        this.f16061i = ColorStateList.valueOf(i);
    }

    public void setErrorPaddingTop(int i) {
        this.f16065m = i;
        invalidate();
    }

    public TextView getErrorView() {
        return this.f16058f;
    }

    public int getLabelTextHeight() {
        return this.f16066n;
    }

    public void setLabelEnable(boolean z) {
        this.f16067o = z;
    }

    public boolean getLabelEnable() {
        return this.f16067o;
    }

    public boolean getErrorEnabled() {
        return this.f16057e;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextInputLayout.class.getName());
    }

    /* renamed from: a */
    private void m17425a(EditText editText, int i) {
        if (i >= 0) {
            try {
                if (f16049q == null) {
                    f16049q = TextView.class.getDeclaredField("mCursorDrawableRes");
                    f16049q.setAccessible(true);
                    this.f16068p = f16049q.getInt(editText);
                }
                f16049q.setInt(editText, 0);
                if (f16051s == null) {
                    f16051s = TextView.class.getDeclaredField("mEditor");
                    f16051s.setAccessible(true);
                }
                Object obj = f16051s.get(editText);
                Class<?> cls = Class.forName("android.widget.Editor");
                if (Build.VERSION.SDK_INT < 28) {
                    if (f16050r == null) {
                        f16050r = cls.getDeclaredField("mCursorDrawable");
                        f16050r.setAccessible(true);
                    }
                    f16050r.set(obj, new Drawable[]{null, null});
                }
                if (f16052t == null) {
                    if (Build.VERSION.SDK_INT < 28) {
                        f16052t = cls.getDeclaredMethod("updateCursorsPositions", new Class[0]);
                    } else {
                        f16052t = cls.getDeclaredMethod("updateCursorPosition", new Class[0]);
                    }
                    f16052t.setAccessible(true);
                }
                f16052t.invoke(obj, new Object[0]);
                f16049q.setInt(editText, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
