package com.meizu.common.fastscrollletter;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.common.R;
import com.meizu.common.p060a.PathInterpolatorCompat;
import com.meizu.common.util.ScreenUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NavigationView extends View {

    /* renamed from: a */
    public static String[] f4238a = {"#", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};

    /* renamed from: A */
    private int f4239A;

    /* renamed from: B */
    private int f4240B;

    /* renamed from: C */
    private Paint f4241C;

    /* renamed from: D */
    private boolean f4242D;

    /* renamed from: E */
    private boolean f4243E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f4244F;

    /* renamed from: b */
    final Interpolator f4245b = new PathInterpolatorCompat(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: c */
    final int f4246c = 150;

    /* renamed from: d */
    final int f4247d = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

    /* renamed from: e */
    private Context f4248e;

    /* renamed from: f */
    private C1306a f4249f;

    /* renamed from: g */
    private ArrayList<String> f4250g;

    /* renamed from: h */
    private ArrayList<String> f4251h;

    /* renamed from: i */
    private ArrayList<String> f4252i;

    /* renamed from: j */
    private Map<String, Bitmap> f4253j;

    /* renamed from: k */
    private Map<String, Bitmap> f4254k;

    /* renamed from: l */
    private Map<String, Bitmap> f4255l;

    /* renamed from: m */
    private Map<String, Bitmap> f4256m;

    /* renamed from: n */
    private int f4257n;

    /* renamed from: o */
    private int f4258o;

    /* renamed from: p */
    private int f4259p;

    /* renamed from: q */
    private boolean f4260q;

    /* renamed from: r */
    private boolean f4261r;

    /* renamed from: s */
    private ArrayList<RectF> f4262s;

    /* renamed from: t */
    private int f4263t;

    /* renamed from: u */
    private int f4264u;

    /* renamed from: v */
    private int f4265v;

    /* renamed from: w */
    private int f4266w;

    /* renamed from: x */
    private int f4267x;

    /* renamed from: y */
    private int f4268y;

    /* renamed from: z */
    private int f4269z;

    /* renamed from: com.meizu.common.fastscrollletter.NavigationView$a */
    public interface C1306a {
        /* renamed from: a */
        void mo15813a();

        /* renamed from: a */
        void mo15814a(float f);

        /* renamed from: a */
        void mo15815a(String str, int i);

        /* renamed from: b */
        void mo15816b();

        /* renamed from: c */
        void mo15817c();

        /* renamed from: d */
        int mo15818d();

        /* renamed from: e */
        int mo15819e();

        /* renamed from: f */
        int mo15820f();

        /* renamed from: g */
        int mo15821g();
    }

    public NavigationView(Context context) {
        super(context);
        this.f4248e = context;
        m4932b();
    }

    /* renamed from: b */
    private void m4932b() {
        this.f4250g = new ArrayList<>();
        this.f4251h = new ArrayList<>();
        this.f4252i = new ArrayList<>();
        this.f4253j = new HashMap();
        this.f4254k = new HashMap();
        this.f4255l = new HashMap();
        this.f4256m = new HashMap();
        this.f4262s = new ArrayList<>();
        String[] strArr = f4238a;
        for (int i = 0; i < strArr.length; i++) {
            this.f4250g.add(strArr[i]);
            this.f4251h.add(strArr[i]);
        }
        this.f4258o = 1;
        this.f4257n = 1;
        this.f4259p = 0;
        this.f4260q = true;
        this.f4261r = true;
        this.f4263t = m4931b(R.color.mc_fastscroll_navigation_letter_normal_background_color);
        this.f4264u = m4931b(R.color.mc_fastscroll_navigation_letter_active_background_color);
        this.f4265v = m4931b(R.color.mc_fastscroll_letter_text_color);
        this.f4266w = m4931b(R.color.mc_fastscroll_letter_active_text_color);
        this.f4267x = ScreenUtil.m5168a(this.f4248e, m4926a(R.dimen.mc_fastscroll_letter_text_size));
        this.f4268y = m4926a(R.dimen.mc_fastscroll_navigation_letter_vertical_space);
        this.f4269z = m4926a(R.dimen.mc_fastscroll_letter_layout_padding_left);
        this.f4239A = m4926a(R.dimen.mc_fastscroll_letter_layout_margin_right);
        this.f4240B = m4926a(R.dimen.mc_fastscroll_letter_layout_wdith);
        this.f4241C = new Paint(1);
        this.f4241C.setTextAlign(Paint.Align.CENTER);
        this.f4244F = this.f4265v;
    }

    /* renamed from: a */
    public void mo15833a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f4248e.obtainStyledAttributes(attributeSet, R.styleable.FastScrollLetter, R.attr.MeizuCommon_FastScrollLetter, 0);
        this.f4263t = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterNormalBackgroundColor, this.f4263t);
        this.f4264u = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterActiveBackgroundColor, this.f4264u);
        this.f4265v = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterNormalTextColor, this.f4265v);
        this.f4266w = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcNavigationLetterActiveTextColor, this.f4266w);
        this.f4267x = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterTextSize, (float) this.f4267x);
        this.f4268y = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterVerticalSpace, (float) this.f4268y);
        this.f4269z = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterLeftPadding, (float) this.f4269z);
        this.f4239A = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterRightMargin, (float) this.f4239A);
        this.f4240B = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationLetterWidth, (float) this.f4240B);
        this.f4244F = this.f4265v;
        m4934c();
        setBackgroundColor(this.f4263t);
        invalidate();
    }

    /* renamed from: a */
    private int m4926a(int i) {
        return this.f4248e.getResources().getDimensionPixelSize(i);
    }

    /* renamed from: b */
    private int m4931b(int i) {
        return this.f4248e.getResources().getColor(i);
    }

    public void setHideNavigationLetter(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            this.f4253j.put(strArr[i], (Object) null);
            this.f4255l.put(strArr[i], (Object) null);
        }
    }

    public void setHideNavigationLetter(String str, Bitmap bitmap, Bitmap bitmap2) {
        this.f4254k.put(str, bitmap);
        this.f4256m.put(str, bitmap2);
    }

    public void setNavigationLetters(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.f4250g = arrayList;
            this.f4251h = (ArrayList) arrayList.clone();
            this.f4261r = true;
            invalidate();
        }
    }

    public void setNavigationLetterNormalBackgroundColor(int i) {
        this.f4263t = i;
        setBackgroundColor(i);
    }

    public void setNavigationLetterActiveBackgroundColor(int i) {
        this.f4264u = i;
    }

    public void setNavigationLetterNormalTextColor(int i) {
        this.f4265v = i;
        this.f4244F = i;
        this.f4261r = true;
        invalidate();
    }

    public void setNavigationLetterActiveTextColor(int i) {
        this.f4266w = i;
        this.f4261r = true;
        invalidate();
    }

    public void setNavigationLetterTextSize(int i) {
        this.f4267x = i;
        this.f4261r = true;
        m4934c();
        invalidate();
    }

    public void setNavigationLetterVerticalSpace(int i) {
        this.f4268y = i;
        this.f4261r = true;
        m4934c();
        invalidate();
    }

    public void setNavigationLetterRightMargin(int i) {
        this.f4239A = i;
        this.f4261r = true;
        m4934c();
    }

    public void setNavigationLetterWidth(int i) {
        this.f4240B = i;
        this.f4261r = true;
        m4934c();
    }

    public void setHideTopPassCount(int i) {
        this.f4257n = i;
    }

    public void setHideBottomPassCount(int i) {
        this.f4258o = i;
    }

    public void setIntervalHide(int i) {
        this.f4259p = i;
        this.f4260q = false;
    }

    public void setAutoHideLetter(boolean z) {
        this.f4260q = z;
        this.f4259p = 0;
        setNavigationLetters(this.f4250g);
    }

    /* renamed from: a */
    public void mo15831a() {
        if (this.f4260q) {
            this.f4253j.clear();
            this.f4255l.clear();
            int d = this.f4249f.mo15818d() - ScreenUtil.m5167a(this.f4248e, 44.0d);
            this.f4259p = 0;
            int i = 0;
            while (i < 50) {
                if ((this.f4267x + this.f4268y) * (this.f4251h.size() - i) > d) {
                    i++;
                } else if (i == 0) {
                    this.f4259p = 0;
                    return;
                } else if (i <= 0 || ((double) i) >= ((double) this.f4251h.size()) * 0.1d) {
                    double d2 = (double) i;
                    if (d2 >= ((double) this.f4251h.size()) * 0.1d && d2 < ((double) this.f4251h.size()) * 0.2d) {
                        this.f4259p = 2;
                        return;
                    } else if (d2 >= ((double) this.f4251h.size()) * 0.2d && d2 < ((double) this.f4251h.size()) * 0.3d) {
                        this.f4259p = 3;
                        return;
                    } else if (d2 >= ((double) this.f4251h.size()) * 0.3d && d2 < ((double) this.f4251h.size()) * 0.4d) {
                        this.f4259p = 4;
                        return;
                    } else if (d2 >= ((double) this.f4251h.size()) * 0.4d && d2 < ((double) this.f4251h.size()) * 0.5d) {
                        this.f4259p = 5;
                        return;
                    } else if (d2 >= ((double) this.f4251h.size()) * 0.4d && d2 < ((double) this.f4251h.size()) * 0.5d) {
                        this.f4259p = 6;
                        return;
                    } else if (d2 >= ((double) this.f4251h.size()) * 0.5d && d2 < ((double) this.f4251h.size()) * 0.6d) {
                        this.f4259p = 7;
                        return;
                    } else if (d2 >= ((double) this.f4251h.size()) * 0.6d && d2 < ((double) this.f4251h.size()) * 0.7d) {
                        this.f4259p = 8;
                        return;
                    } else if (d2 >= ((double) this.f4251h.size()) * 0.7d && d2 < ((double) this.f4251h.size()) * 0.8d) {
                        this.f4259p = 9;
                        return;
                    } else if (d2 < ((double) this.f4251h.size()) * 0.8d || d2 >= ((double) this.f4251h.size()) * 0.9d) {
                        this.f4259p = 11;
                        return;
                    } else {
                        this.f4259p = 10;
                        return;
                    }
                } else {
                    this.f4259p = 1;
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private void m4934c() {
        int i = 0;
        int i2 = 0;
        while (i < this.f4251h.size()) {
            if (m4933b(this.f4251h.get(i))) {
                int i3 = i + 1;
                while (i3 < this.f4251h.size() && m4933b(this.f4251h.get(i3))) {
                    i++;
                    i3++;
                }
            }
            i2++;
            i++;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.height = i2 * (this.f4267x + this.f4268y);
        layoutParams.width = this.f4240B;
        layoutParams.rightMargin = this.f4239A;
        setLayoutParams(layoutParams);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f4249f.mo15816b();
                this.f4249f.mo15813a();
                String a = m4929a(motionEvent.getY());
                this.f4249f.mo15815a(a, m4928a(a));
                this.f4249f.mo15814a(motionEvent.getY());
                if (!this.f4242D) {
                    this.f4242D = true;
                    mo15832a(this.f4265v, this.f4266w, 150);
                    invalidate();
                }
                setBackgroundColor(this.f4264u);
                break;
            case 1:
                this.f4249f.mo15817c();
                if (this.f4242D) {
                    this.f4242D = false;
                    mo15832a(this.f4266w, this.f4265v, (int) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    invalidate();
                }
                setBackgroundColor(this.f4263t);
                break;
            case 2:
                float y = motionEvent.getY();
                if (y < 0.0f) {
                    y = 0.0f;
                }
                if (y > ((float) getHeight())) {
                    y = (float) getHeight();
                }
                String a2 = m4929a(y);
                this.f4249f.mo15815a(a2, m4928a(a2));
                this.f4249f.mo15814a(y);
                if (!this.f4242D) {
                    this.f4242D = true;
                    mo15832a(this.f4265v, this.f4266w, 150);
                    invalidate();
                }
                setBackgroundColor(this.f4264u);
                break;
            case 3:
                this.f4249f.mo15817c();
                break;
        }
        return true;
    }

    /* renamed from: a */
    private String m4929a(float f) {
        int i = (int) (f / ((float) (this.f4267x + this.f4268y)));
        if (i < 0) {
            i = 0;
        }
        if (i >= this.f4252i.size()) {
            i = this.f4252i.size() - 1;
        }
        if (i < 0) {
            return null;
        }
        if (this.f4252i.get(i).contains(">>")) {
            int i2 = (this.f4267x + this.f4268y) * i;
            int i3 = (this.f4267x + this.f4268y) * (i + 1);
            String[] split = this.f4252i.get(i).split(SystemInfoUtil.COMMA);
            int parseInt = Integer.parseInt(split[1]);
            float f2 = ((float) (i3 - i2)) / ((float) parseInt);
            for (int i4 = 0; i4 < parseInt; i4++) {
                float f3 = (float) i2;
                if ((((float) i4) * f2) + f3 <= f && f3 + (((float) (i4 + 1)) * f2) >= f) {
                    return split[i4 + 2];
                }
            }
        }
        return this.f4252i.get(i);
    }

    /* renamed from: a */
    private int m4928a(String str) {
        for (int i = 0; i < this.f4251h.size(); i++) {
            if (this.f4251h.get(i).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4243E) {
            int i = 0;
            if (this.f4261r) {
                int e = this.f4249f.mo15819e() + 1;
                int g = this.f4249f.mo15821g();
                int f = this.f4249f.mo15820f();
                if (e == 0 || e < g || f > 0) {
                    setVisibility(0);
                    this.f4261r = false;
                    mo15831a();
                    int i2 = this.f4257n;
                    while (i2 < this.f4251h.size()) {
                        for (int i3 = 1; i3 < this.f4259p + 1; i3++) {
                            if ((this.f4251h.size() - i2) - i3 > this.f4258o) {
                                int i4 = i2 + i3;
                                this.f4253j.put(this.f4251h.get(i4), (Object) null);
                                this.f4255l.put(this.f4251h.get(i4), (Object) null);
                            }
                        }
                        i2 += this.f4259p + 1;
                    }
                    int size = (this.f4251h.size() - this.f4258o) - 1;
                    if (this.f4259p > 0 && size >= 0) {
                        this.f4253j.put(this.f4251h.get(size), (Object) null);
                        this.f4255l.put(this.f4251h.get(size), (Object) null);
                    }
                    for (String next : this.f4254k.keySet()) {
                        this.f4253j.remove(next);
                        this.f4253j.put(next, this.f4254k.get(next));
                        this.f4255l.remove(next);
                        this.f4255l.put(next, this.f4256m.get(next));
                    }
                    m4934c();
                    return;
                }
                setVisibility(8);
            } else if (this.f4251h != null) {
                this.f4241C.setTextSize((float) this.f4267x);
                this.f4252i.clear();
                int i5 = 0;
                while (i < this.f4251h.size()) {
                    if (m4933b(this.f4251h.get(i))) {
                        String str = this.f4251h.get(i) + SystemInfoUtil.COMMA;
                        int i6 = i + 1;
                        int i7 = i;
                        int i8 = 1;
                        while (i6 < this.f4251h.size() && m4933b(this.f4251h.get(i6))) {
                            i8++;
                            i7++;
                            str = str + this.f4251h.get(i6) + SystemInfoUtil.COMMA;
                            i6++;
                        }
                        this.f4252i.add(">>," + i8 + SystemInfoUtil.COMMA + str);
                        i = i7;
                    } else {
                        this.f4252i.add(this.f4251h.get(i));
                    }
                    if (this.f4262s.size() <= i5) {
                        this.f4262s.add(new RectF());
                    }
                    int i9 = i5 + 1;
                    this.f4262s.get(i5).set(0.0f, (float) ((this.f4267x + this.f4268y) * i5), (float) this.f4240B, (float) ((this.f4267x + this.f4268y) * i9));
                    m4930a(canvas, this.f4262s.get(i5), this.f4251h.get(i));
                    i++;
                    i5 = i9;
                }
            }
        }
    }

    /* renamed from: a */
    private void m4930a(Canvas canvas, RectF rectF, String str) {
        this.f4241C.setColor(Color.argb(0, 0, 0, 0));
        canvas.drawRect(rectF, this.f4241C);
        this.f4241C.setColor(this.f4244F);
        if (m4933b(str)) {
            Bitmap bitmap = (this.f4242D ? this.f4253j : this.f4255l).get(str);
            if (bitmap == null) {
                canvas.drawCircle((float) (this.f4269z + (this.f4267x / 2)), rectF.centerY(), (float) (this.f4267x / 5), this.f4241C);
            } else {
                canvas.drawBitmap(bitmap, (float) ((this.f4269z + (this.f4267x / 2)) - (bitmap.getWidth() / 2)), rectF.centerY() - ((float) (bitmap.getHeight() / 2)), this.f4241C);
            }
        } else {
            Paint.FontMetricsInt fontMetricsInt = this.f4241C.getFontMetricsInt();
            canvas.drawText(str, (float) (this.f4269z + (this.f4267x / 2)), (float) ((int) ((((rectF.bottom + rectF.top) - ((float) fontMetricsInt.bottom)) - ((float) fontMetricsInt.top)) / 2.0f)), this.f4241C);
        }
    }

    /* renamed from: b */
    private boolean m4933b(String str) {
        if (this.f4253j == null) {
            return false;
        }
        for (String equals : this.f4253j.keySet()) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setCallBack(C1306a aVar) {
        this.f4249f = aVar;
    }

    /* renamed from: a */
    public void mo15832a(int i, int i2, int i3) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = NavigationView.this.f4244F = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NavigationView.this.invalidate();
            }
        });
        ofObject.setInterpolator(this.f4245b);
        ofObject.setDuration((long) i3);
        ofObject.start();
    }
}
