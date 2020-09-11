package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;
import java.lang.reflect.InvocationTargetException;

public class FoldableTextView extends TextView implements View.OnClickListener {

    /* renamed from: a */
    private static int f5271a = 1;

    /* renamed from: b */
    private static int f5272b;

    /* renamed from: c */
    private CharSequence f5273c;

    /* renamed from: d */
    private CharSequence f5274d;

    /* renamed from: e */
    private int f5275e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1443a f5276f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f5277g;

    /* renamed from: h */
    private boolean f5278h;

    /* renamed from: i */
    private boolean f5279i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f5280j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CharSequence f5281k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CharSequence f5282l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f5283m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f5284n;

    /* renamed from: o */
    private Layout f5285o;

    /* renamed from: p */
    private int f5286p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f5287q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Float f5288r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f5289s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f5290t;

    /* renamed from: u */
    private boolean f5291u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f5292v;

    /* renamed from: w */
    private int f5293w;

    /* renamed from: x */
    private float f5294x;

    /* renamed from: y */
    private float f5295y;

    /* renamed from: z */
    private final Runnable f5296z;

    /* renamed from: com.meizu.common.widget.FoldableTextView$a */
    public interface C1443a {
        /* renamed from: a */
        boolean mo16725a(FoldableTextView foldableTextView, boolean z);
    }

    public boolean hasFocusable() {
        return false;
    }

    public FoldableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FoldableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_FoldableTextViewStyle);
    }

    public FoldableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5277g = true;
        this.f5278h = false;
        this.f5279i = true;
        this.f5280j = 0;
        this.f5283m = 0;
        this.f5284n = 0;
        this.f5285o = null;
        this.f5286p = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.f5287q = false;
        this.f5288r = Float.valueOf(1.0f);
        this.f5289s = true;
        this.f5291u = true;
        this.f5292v = false;
        this.f5293w = 0;
        this.f5296z = new Runnable() {
            public void run() {
                if (FoldableTextView.this.isLongClickable() && FoldableTextView.this.getWindowToken() != null && FoldableTextView.this.getParent() != null) {
                    FoldableTextView.this.performLongClick();
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FoldableTextView, i, R.style.Widget_MeizuCommon_FoldableTextView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.FoldableTextView_mzTextEllipse) {
                this.f5273c = obtainStyledAttributes.getText(index);
            } else if (index == R.styleable.FoldableTextView_mzTextUnfold) {
                this.f5274d = obtainStyledAttributes.getText(index);
            } else if (index == R.styleable.FoldableTextView_mzMaxFoldLine) {
                this.f5275e = obtainStyledAttributes.getInt(index, 0);
            } else if (index == R.styleable.FoldableTextView_mzUnfoldAlignViewEdge) {
                this.f5278h = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.FoldableTextView_mzClickToFold) {
                this.f5279i = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.FoldableTextView_mzNonSpanClickable) {
                this.f5291u = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.FoldableTextView_mzLinkColor) {
                this.f5280j = obtainStyledAttributes.getColor(index, 0);
                if (this.f5280j == 0) {
                    this.f5280j = ResourceUtils.m5165b(context) == null ? 0 : ResourceUtils.m5165b(context).intValue();
                }
            } else if (index == R.styleable.FoldableTextView_mzIsFold) {
                this.f5277g = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
        if (TextUtils.isEmpty(this.f5274d)) {
            this.f5274d = context.getString(R.string.more_item_label);
        }
        if (TextUtils.isEmpty(this.f5273c)) {
            this.f5273c = "...";
        }
        setMovementMethod(C1444b.m5783a());
        setOnClickListener(true);
    }

    public void setFoldText(String str, String str2, boolean z) {
        this.f5278h = z;
        if (str != null) {
            this.f5273c = str;
        } else {
            this.f5273c = "...";
        }
        if (str2 != null) {
            this.f5274d = str2;
        } else {
            this.f5274d = getContext().getString(R.string.more_item_label);
        }
    }

    public CharSequence getStrEllipse() {
        return this.f5273c;
    }

    public CharSequence getMoreText() {
        return this.f5274d;
    }

    public void setFolding(int i, C1443a aVar) {
        if (this.f5275e != i) {
            this.f5275e = i;
            setText(this.f5281k, TextView.BufferType.NORMAL);
        }
        this.f5276f = aVar;
    }

    public int getFoldLineMax() {
        return this.f5275e;
    }

    public void setClickToFold(boolean z) {
        this.f5279i = z;
    }

    public void setLinkColor(int i) {
        this.f5280j = i;
        invalidate();
    }

    public int getLinkColor() {
        return this.f5280j;
    }

    public boolean getFoldStatus() {
        return this.f5277g;
    }

    public void setFoldStatus(boolean z) {
        if (!this.f5292v && this.f5277g != z) {
            this.f5277g = z;
            requestLayout();
            invalidate();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FoldableTextView.class.getName());
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f5281k != null && this.f5282l != null && charSequence != null && !charSequence.toString().equals(this.f5281k.toString()) && !charSequence.toString().equals(this.f5282l.toString())) {
            this.f5281k = charSequence;
            this.f5282l = null;
            m5764b(charSequence);
            if (this.f5277g) {
                setHeight(this.f5284n);
            } else {
                setHeight(this.f5283m);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f5281k == null) {
            this.f5281k = getText();
        }
        m5764b(this.f5281k);
        if (!this.f5287q) {
            if (this.f5282l == null) {
                this.f5282l = m5757a(this.f5281k);
            }
            if (!this.f5277g || this.f5275e <= 0) {
                setText(this.f5281k, TextView.BufferType.SPANNABLE);
                setMeasuredDimension(i, this.f5283m);
                return;
            }
            setText(this.f5282l, TextView.BufferType.SPANNABLE);
            setMeasuredDimension(i, this.f5284n);
        } else if (!this.f5277g) {
            setMeasuredDimension(i, (int) (((float) this.f5284n) + (((float) (this.f5283m - this.f5284n)) * this.f5288r.floatValue())));
        } else {
            setMeasuredDimension(i, (int) (((float) this.f5283m) - (((float) (this.f5283m - this.f5284n)) * this.f5288r.floatValue())));
        }
    }

    /* renamed from: a */
    private CharSequence m5757a(CharSequence charSequence) {
        this.f5285o = getLayout();
        if (this.f5285o == null) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        DynamicLayout dynamicLayout = new DynamicLayout(spannableStringBuilder, this.f5285o.getPaint(), this.f5285o.getWidth(), this.f5285o.getAlignment(), 1.0f, 0.0f, false);
        if (dynamicLayout.getLineCount() <= this.f5275e || this.f5275e == 0) {
            return charSequence;
        }
        int i = this.f5275e;
        int lineVisibleEnd = dynamicLayout.getLineVisibleEnd(i - 1);
        if (TextUtils.isEmpty(this.f5273c)) {
            spannableStringBuilder.delete(lineVisibleEnd, spannableStringBuilder.length());
        } else {
            spannableStringBuilder.replace(lineVisibleEnd, spannableStringBuilder.length(), this.f5273c);
        }
        spannableStringBuilder.append(' ');
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(this.f5274d);
        spannableStringBuilder.setSpan(new MoreClickSpan("sans-serif-medium", charSequence), length, spannableStringBuilder.length(), 33);
        if (lineVisibleEnd > 0 && dynamicLayout.getLineCount() > i) {
            do {
                lineVisibleEnd--;
                spannableStringBuilder.delete(lineVisibleEnd, lineVisibleEnd + 1);
                if (lineVisibleEnd <= 0) {
                    break;
                }
            } while (dynamicLayout.getLineCount() <= i);
        } else if (this.f5278h) {
            while (true) {
                if (dynamicLayout.getLineCount() != i) {
                    break;
                }
                spannableStringBuilder.replace(length, length, " ");
                if (dynamicLayout.getLineCount() > i) {
                    spannableStringBuilder.delete(length, length + 1);
                    break;
                }
                length++;
            }
        }
        return spannableStringBuilder;
    }

    @SuppressLint({"ParcelCreator"})
    private class MoreClickSpan extends TypefaceSpan {

        /* renamed from: b */
        private final CharSequence f5301b;

        public MoreClickSpan(String str, CharSequence charSequence) {
            super(str);
            this.f5301b = charSequence;
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            if (FoldableTextView.this.f5280j == 0) {
                textPaint.setColor(textPaint.linkColor);
            } else {
                textPaint.setColor(FoldableTextView.this.f5280j);
            }
        }

        /* renamed from: a */
        public void mo16723a(View view) {
            if (!FoldableTextView.this.f5287q && !FoldableTextView.this.f5292v) {
                if (FoldableTextView.this.f5276f == null || FoldableTextView.this.f5276f.mo16725a(FoldableTextView.this, false)) {
                    boolean unused = FoldableTextView.this.f5277g = false;
                    FoldableTextView.this.setText(FoldableTextView.this.f5281k, TextView.BufferType.NORMAL);
                    FoldableTextView.this.m5762b();
                }
            }
        }
    }

    private void setOnClickListener(boolean z) {
        if (z) {
            setOnClickListener(this);
        } else {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    public void onClick(View view) {
        if (!C1444b.m5783a().f5303b) {
            mo16695a();
        }
    }

    /* renamed from: a */
    public void mo16695a() {
        if (!this.f5287q && !this.f5292v && this.f5279i) {
            if (this.f5277g) {
                if (this.f5276f == null || this.f5276f.mo16725a(this, false)) {
                    this.f5277g = false;
                    setText(this.f5281k, TextView.BufferType.NORMAL);
                    if (this.f5284n != 0) {
                        m5762b();
                    }
                }
            } else if (this.f5276f == null || this.f5276f.mo16725a(this, true)) {
                this.f5277g = true;
                if (this.f5283m != 0 && getLayout() != null && getLayout().getLineCount() > this.f5275e) {
                    m5762b();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5762b() {
        if (this.f5275e != 0) {
            this.f5287q = true;
            C1445c cVar = new C1445c();
            int[] iArr = new int[2];
            iArr[0] = this.f5277g ? this.f5283m : this.f5284n;
            iArr[1] = this.f5277g ? this.f5284n : this.f5283m;
            ObjectAnimator ofInt = ObjectAnimator.ofInt(cVar, "height", iArr);
            ofInt.setDuration((long) this.f5286p);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (FoldableTextView.this.f5277g) {
                        FoldableTextView.this.setText(FoldableTextView.this.f5282l, TextView.BufferType.SPANNABLE);
                        FoldableTextView.this.setMeasuredDimension(FoldableTextView.this.getMeasuredWidth(), FoldableTextView.this.f5284n);
                    } else {
                        FoldableTextView.this.setMeasuredDimension(FoldableTextView.this.getMeasuredWidth(), FoldableTextView.this.f5283m);
                    }
                    boolean unused = FoldableTextView.this.f5287q = false;
                    boolean unused2 = FoldableTextView.this.f5289s = !FoldableTextView.this.f5289s;
                }

                public void onAnimationCancel(Animator animator) {
                    if (FoldableTextView.this.f5277g) {
                        FoldableTextView.this.setText(FoldableTextView.this.f5282l, TextView.BufferType.SPANNABLE);
                        FoldableTextView.this.setMeasuredDimension(FoldableTextView.this.getMeasuredWidth(), FoldableTextView.this.f5284n);
                    } else {
                        FoldableTextView.this.setMeasuredDimension(FoldableTextView.this.getMeasuredWidth(), FoldableTextView.this.f5283m);
                    }
                    boolean unused = FoldableTextView.this.f5287q = false;
                }
            });
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float unused = FoldableTextView.this.f5288r = Float.valueOf(valueAnimator.getAnimatedFraction());
                    FoldableTextView.this.requestLayout();
                }
            });
            ofInt.start();
        }
    }

    /* renamed from: com.meizu.common.widget.FoldableTextView$c */
    private class C1445c {
        private C1445c() {
        }
    }

    /* renamed from: b */
    private void m5764b(CharSequence charSequence) {
        this.f5285o = getLayout();
        if (this.f5285o != null) {
            this.f5283m = (int) (((double) ((this.f5285o.getLineBottom(this.f5285o.getLineCount() - 1) - this.f5285o.getLineTop(0)) + getPaddingBottom() + getPaddingTop())) + 0.5d);
            if (this.f5285o.getLineCount() <= this.f5275e) {
                this.f5284n = this.f5283m;
            } else if (Build.VERSION.SDK_INT >= 16) {
                this.f5284n = (int) (((double) ((this.f5285o.getLineBottom(this.f5275e - 1) - this.f5285o.getLineTop(0)) + getPaddingBottom() + getPaddingTop())) + 0.5d + ((double) getLineSpacingExtra()));
            }
        }
    }

    public void setFoldDuration(int i) {
        this.f5286p = i;
    }

    /* renamed from: com.meizu.common.widget.FoldableTextView$b */
    public static class C1444b extends LinkMovementMethod {

        /* renamed from: a */
        static C1444b f5302a;

        /* renamed from: b */
        public boolean f5303b = false;

        /* renamed from: a */
        public static C1444b m5783a() {
            if (f5302a == null) {
                f5302a = new C1444b();
            }
            return f5302a;
        }

        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            this.f5303b = false;
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            if (layout == null) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            MoreClickSpan[] moreClickSpanArr = (MoreClickSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, MoreClickSpan.class);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (moreClickSpanArr.length != 0) {
                if (action == 1) {
                    moreClickSpanArr[0].mo16723a(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(moreClickSpanArr[0]), spannable.getSpanEnd(moreClickSpanArr[0]));
                }
                if (textView instanceof FoldableTextView) {
                    boolean unused = ((FoldableTextView) textView).f5290t = true;
                }
                return true;
            } else if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                    this.f5303b = true;
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                }
                if (textView instanceof FoldableTextView) {
                    boolean unused2 = ((FoldableTextView) textView).f5290t = true;
                }
                return true;
            } else {
                Selection.removeSelection(spannable);
                Touch.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1 || this.f5287q) {
            return false;
        }
        if (!this.f5291u && this.f5277g) {
            return C1444b.m5783a().onTouchEvent(this, (Spannable) getText(), motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f5294x = motionEvent.getX();
                this.f5295y = motionEvent.getY();
                this.f5293w = f5272b;
                removeCallbacks(this.f5296z);
                postDelayed(this.f5296z, (long) ViewConfiguration.getLongPressTimeout());
                break;
            case 1:
                if (this.f5293w != f5271a && !hasSelection()) {
                    C1444b.m5783a().onTouchEvent(this, (Spannable) getText(), motionEvent);
                    performClick();
                    this.f5293w = f5272b;
                }
                if (hasSelection() && this.f5293w != f5271a) {
                    Selection.setSelection((Spannable) getText(), 0);
                }
                removeCallbacks(this.f5296z);
                break;
            case 2:
                this.f5294x = motionEvent.getX();
                this.f5295y = motionEvent.getY();
                break;
            case 3:
                removeCallbacks(this.f5296z);
                break;
        }
        if (!this.f5289s || this.f5291u) {
            return true;
        }
        return false;
    }

    public boolean performLongClick() {
        boolean performLongClick = super.performLongClick();
        this.f5293w = f5271a;
        if (!performLongClick && this.f5291u) {
            m5759a(this.f5294x, this.f5295y);
        }
        return performLongClick;
    }

    /* renamed from: a */
    private void m5759a(float f, float f2) {
        Layout layout = getLayout();
        if (layout != null) {
            float min = Math.min((float) ((getHeight() - getTotalPaddingBottom()) - 1), Math.max(0.0f, f2 - ((float) getTotalPaddingTop()))) + ((float) getScrollY());
            float max = Math.max(0.0f, f - ((float) getTotalPaddingLeft()));
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) min), Math.min((float) ((getWidth() - getTotalPaddingRight()) - 1), max) + ((float) getScrollX()));
            if (offsetForHorizontal < getText().length()) {
                Selection.setSelection((Spannable) getText(), offsetForHorizontal, offsetForHorizontal + 1);
                try {
                    TextView.class.getDeclaredMethod("startSelectionActionMode", new Class[0]).invoke(this, new Object[0]);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void setNonSpanClickable(boolean z) {
        this.f5291u = z;
    }

    public void setForbidden(boolean z) {
        this.f5292v = z;
    }
}
