package com.meizu.common.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.common.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
@TargetApi(18)
@Deprecated
public class FastScrollLetter extends View {

    /* renamed from: V */
    private static Field f5190V = null;

    /* renamed from: b */
    private static final String f5191b = "FastScrollLetter";

    /* renamed from: c */
    private static final String[] f5192c = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};

    /* renamed from: A */
    private int f5193A;

    /* renamed from: B */
    private int f5194B;

    /* renamed from: C */
    private int f5195C;

    /* renamed from: D */
    private Bitmap f5196D;

    /* renamed from: E */
    private AbsListView f5197E;

    /* renamed from: F */
    private SectionIndexer f5198F;

    /* renamed from: G */
    private String f5199G;

    /* renamed from: H */
    private int f5200H;

    /* renamed from: I */
    private SparseArray<Integer> f5201I;

    /* renamed from: J */
    private int f5202J;

    /* renamed from: K */
    private int f5203K;

    /* renamed from: L */
    private int f5204L;

    /* renamed from: M */
    private int f5205M;

    /* renamed from: N */
    private C1434a f5206N;

    /* renamed from: O */
    private int f5207O;

    /* renamed from: P */
    private Map<String, String> f5208P;

    /* renamed from: Q */
    private int[] f5209Q;

    /* renamed from: R */
    private int[] f5210R;

    /* renamed from: S */
    private CircleColorType f5211S;

    /* renamed from: T */
    private Method f5212T;

    /* renamed from: U */
    private Method f5213U;

    /* renamed from: a */
    Paint f5214a;

    /* renamed from: d */
    private boolean f5215d;

    /* renamed from: e */
    private boolean f5216e;

    /* renamed from: f */
    private int f5217f;

    /* renamed from: g */
    private TextView f5218g;

    /* renamed from: h */
    private String f5219h;

    /* renamed from: i */
    private int f5220i;

    /* renamed from: j */
    private int f5221j;

    /* renamed from: k */
    private String[] f5222k;

    /* renamed from: l */
    private String[] f5223l;

    /* renamed from: m */
    private String[] f5224m;

    /* renamed from: n */
    private String f5225n;

    /* renamed from: o */
    private int f5226o;

    /* renamed from: p */
    private int f5227p;

    /* renamed from: q */
    private int f5228q;

    /* renamed from: r */
    private int f5229r;

    /* renamed from: s */
    private int f5230s;

    /* renamed from: t */
    private int f5231t;

    /* renamed from: u */
    private int f5232u;

    /* renamed from: v */
    private int f5233v;

    /* renamed from: w */
    private int f5234w;

    /* renamed from: x */
    private int f5235x;

    /* renamed from: y */
    private int f5236y;

    /* renamed from: z */
    private int f5237z;

    public enum CircleColorType {
        GRAY_SINGLE,
        COLORFUL,
        CUSTOM
    }

    /* renamed from: com.meizu.common.widget.FastScrollLetter$a */
    public interface C1434a {
        /* renamed from: a */
        int mo16664a(int i);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FastScrollLetter.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setHideLetterNum(String str, int i) {
        this.f5199G = str;
        this.f5200H = i;
        String[] strArr = new String[((((this.f5223l.length - 1) / (this.f5200H + 1)) * 2) + 2)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f5223l.length) {
            int i4 = i3 + 1;
            strArr[i3] = this.f5223l[i2];
            i3 = i4 + 1;
            strArr[i4] = this.f5199G;
            i2 += this.f5200H + 1;
        }
        strArr[strArr.length - 1] = this.f5223l[this.f5223l.length - 1];
        this.f5223l = strArr;
    }

    public void setHideLetterStr(String str, Bitmap bitmap) {
        if (bitmap != null) {
            this.f5196D = bitmap;
        }
        this.f5199G = str;
    }

    public void setOverlayTextLetters(String[] strArr) {
        this.f5222k = strArr;
        if (this.f5222k == null || this.f5222k.length == 0) {
            setOverLayText(this.f5225n);
        }
    }

    public void setHideLetter(SparseArray<Integer> sparseArray, String[] strArr) {
        this.f5201I = sparseArray;
        this.f5223l = strArr;
    }

    public void setOverlayParam(int i, int i2) {
        if (i != -1) {
            this.f5230s = i;
            this.f5229r = i;
        }
        if (i2 != -1) {
            this.f5231t = i2;
        }
    }

    public void setFastScrollAlwaysVisible(boolean z) {
        this.f5215d = z;
        if (this.f5215d) {
            setVisibility(0);
        }
    }

    public void setLetterActiveColor(int i, int i2) {
        this.f5235x = i2;
        this.f5234w = i;
        this.f5214a.setColor(this.f5234w);
        invalidate();
    }

    public void setFastScrollEnabled(boolean z) {
        this.f5216e = z;
        setVisibility(z ? 0 : 8);
    }

    public void setLetters(String[] strArr) {
        this.f5223l = strArr;
        this.f5224m = strArr;
        setOverlayTextLetters(strArr);
    }

    public void setTopLetter(String str) {
        this.f5225n = str;
        if (this.f5222k == null || this.f5222k.length == 0) {
            setOverLayText(this.f5225n);
        }
    }

    public void setHeaderHeight(int i) {
        this.f5205M = i;
    }

    public void setLetterParam(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != -1) {
            this.f5233v = i;
            this.f5214a.setTextSize((float) this.f5233v);
        }
        if (i2 != -1) {
            this.f5234w = i2;
            this.f5235x = this.f5234w;
            this.f5214a.setColor(this.f5234w);
            invalidate();
        }
        this.f5236y = i3;
        this.f5237z = i4;
        if (i5 != -1) {
            this.f5193A = i5;
        }
        if (i6 != -1) {
            this.f5194B = i6;
        }
    }

    public void setLayoutPaddingLeft(int i) {
        this.f5195C = i;
    }

    @TargetApi(16)
    public void setLetterBackground(Drawable drawable) {
        setBackground(drawable);
    }

    @TargetApi(16)
    public void setOverlayBackground(Drawable drawable) {
        this.f5218g.setBackground(drawable);
    }

    @TargetApi(17)
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onSizeChanged(i, i2, i3, i4);
        int width = this.f5197E.getWidth() - (this.f5193A + this.f5194B);
        int width2 = this.f5197E.getWidth() - this.f5193A;
        if (this.f5236y == -1 || this.f5237z == -1) {
            i6 = (this.f5197E.getHeight() - (this.f5224m.length * this.f5233v)) / 2;
            this.f5236y = i6;
            this.f5237z = i6;
            i5 = this.f5197E.getHeight() - i6;
        } else {
            i6 = this.f5236y;
            i5 = this.f5197E.getHeight() - this.f5237z;
        }
        boolean b = m5723b((Activity) getContext());
        float f = 1.0f;
        if (b) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            f = ((float) displayMetrics.heightPixels) / ((float) Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels));
            this.f5214a.setTextSize(((float) this.f5233v) * f);
        } else {
            this.f5214a.setTextSize((float) this.f5233v);
        }
        if (this.f5197E.getLayoutDirection() == 0) {
            if (b) {
                i6 = (int) (((float) i6) * f);
            }
            if (b) {
                i5 = this.f5197E.getHeight() - ((int) (f * ((float) this.f5237z)));
            }
            layout(width, i6, width2, i5);
        } else {
            int i7 = this.f5193A;
            if (b) {
                i6 = (int) (((float) i6) * f);
            }
            int i8 = this.f5193A + this.f5194B;
            if (b) {
                i5 = this.f5197E.getHeight() - ((int) (f * ((float) this.f5237z)));
            }
            layout(i7, i6, i8, i5);
        }
        this.f5218g.measure(this.f5229r, this.f5229r);
        setOverlayTextLayout(0.0f);
    }

    /* renamed from: a */
    private boolean m5718a(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            if (this.f5212T == null) {
                Class<?> cls = Class.forName("meizu.splitmode.FlymeSplitModeManager");
                this.f5213U = cls.getMethod("getInstance", new Class[]{Context.class});
                this.f5212T = cls.getMethod("isSplitMode", new Class[0]);
            }
            return ((Boolean) this.f5212T.invoke(this.f5213U.invoke((Object) null, new Object[]{activity}), new Object[0])).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e(f5191b, "isFlymeSplitemode ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.e(f5191b, "isFlymeSplitemode NoSuchMethodException");
            return false;
        } catch (InvocationTargetException unused3) {
            Log.e(f5191b, "isFlymeSplitemode InvocationTargetException");
            return false;
        } catch (IllegalAccessException unused4) {
            Log.e(f5191b, "isFlymeSplitemode IllegalAccessException");
            return false;
        }
    }

    /* renamed from: b */
    private boolean m5723b(Activity activity) {
        if (Build.VERSION.SDK_INT > 23) {
            return activity.isInMultiWindowMode();
        }
        return m5718a(activity);
    }

    public void setSectionCompare(C1434a aVar) {
        this.f5206N = aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f5216e || this.f5197E.getScrollY() != 0) {
            return false;
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        if (y < 0.0f) {
            y = 0.0f;
        }
        if (this.f5223l == null || this.f5223l.length == 0 || this.f5197E == null || this.f5218g == null || this.f5222k == null || this.f5222k.length == 0) {
            return false;
        }
        int a = m5711a(y - ((float) this.f5236y));
        switch (action) {
            case 0:
                if (a < 0) {
                    return false;
                }
                this.f5203K = (int) motionEvent.getY();
                if (m5717a(motionEvent.getX(), motionEvent.getY())) {
                    this.f5214a.setColor(this.f5235x);
                    invalidate();
                    this.f5197E.requestDisallowInterceptTouchEvent(true);
                    m5726d();
                    setOverlayTextLayout(motionEvent.getY());
                    m5716a(true, (View) this);
                    m5715a(motionEvent, a);
                    this.f5217f = 1;
                    return true;
                } else if (!this.f5225n.equals("") && m5722b(motionEvent.getX(), motionEvent.getY())) {
                    this.f5220i = -1;
                    this.f5214a.setColor(this.f5235x);
                    invalidate();
                    this.f5217f = 1;
                    setOverlayTextLayout((float) getTop());
                    m5716a(true, (View) this);
                    m5713a();
                    return true;
                }
            case 1:
            case 3:
            case 4:
                this.f5197E.requestDisallowInterceptTouchEvent(false);
                if (this.f5217f == 1) {
                    this.f5220i = -1;
                    this.f5214a.setColor(this.f5234w);
                    invalidate();
                    setOverlayTextLayout((float) this.f5203K);
                    m5716a(false, (View) this);
                    this.f5217f = 0;
                    return true;
                }
                break;
            case 2:
                break;
        }
        if (this.f5217f == 1) {
            if (a >= 0 && a < this.f5222k.length) {
                this.f5203K = (int) motionEvent.getY();
                if (this.f5220i == -1) {
                    setOverlayTextLayout(motionEvent.getY());
                }
                m5715a(motionEvent, a);
            } else if (!this.f5225n.equals("") && m5722b(motionEvent.getX(), motionEvent.getY())) {
                this.f5220i = -1;
                m5713a();
            }
        }
        if (this.f5217f == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f5195C;
        if (this.f5197E.getLayoutDirection() == 1) {
            i = this.f5195C * -1;
        }
        String[] strArr = this.f5223l;
        if (strArr != null && strArr.length != 0) {
            int height = getHeight();
            int width = getWidth();
            this.f5221j = height / strArr.length;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                int i3 = width / 2;
                float measureText = (((float) i3) - (this.f5214a.measureText(strArr[i2]) / 2.0f)) + ((float) i);
                float f = (float) ((this.f5221j * i2) + this.f5221j);
                if (this.f5196D == null || !strArr[i2].equals(this.f5199G)) {
                    canvas.drawText(strArr[i2], measureText, f, this.f5214a);
                } else {
                    canvas.drawBitmap(this.f5196D, (float) ((i3 - (this.f5196D.getWidth() / 2)) + i), (float) ((this.f5221j * i2) + (this.f5221j / 2)), this.f5214a);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m5717a(float f, float f2) {
        return ((float) getLeft()) < f && f < ((float) getRight()) && ((float) getTop()) < f2 && ((float) getBottom()) > f2;
    }

    /* renamed from: b */
    private boolean m5722b(float f, float f2) {
        return ((float) getLeft()) < f && f < ((float) getRight()) && ((float) getTop()) > f2 && ((float) getBottom()) > f2;
    }

    /* renamed from: a */
    private int m5711a(float f) {
        this.f5221j = getHeight() / this.f5223l.length;
        int ceil = (int) (Math.ceil((double) (f / ((float) this.f5221j))) - 1.0d);
        if (ceil < 0 || ceil >= this.f5223l.length) {
            return -1;
        }
        int i = 0;
        if (this.f5201I == null) {
            int i2 = 0;
            while (i < ceil) {
                i2 = this.f5223l[i].equals(this.f5199G) ? i2 + this.f5200H : i2 + 1;
                i++;
            }
            float f2 = f - ((float) (this.f5221j * ceil));
            if (this.f5200H == 0) {
                this.f5200H = 1;
            }
            if (this.f5223l[ceil].equals(this.f5199G)) {
                return i2 + ((int) (f2 / ((float) (this.f5221j / this.f5200H))));
            }
            return i2;
        }
        int i3 = 0;
        while (i < ceil) {
            i3 = this.f5223l[i].equals(this.f5199G) ? i3 + this.f5201I.get(i).intValue() : i3 + 1;
            i++;
        }
        float f3 = f - ((float) (this.f5221j * ceil));
        if (!this.f5223l[ceil].equals(this.f5199G)) {
            return i3;
        }
        return i3 + ((int) Math.floor((double) ((f3 / ((float) this.f5221j)) * ((float) this.f5201I.get(ceil).intValue()))));
    }

    /* renamed from: a */
    private void m5713a() {
        setOverLayText(this.f5225n);
        if (this.f5197E instanceof ListView) {
            this.f5197E.setSelectionFromTop(0, -this.f5205M);
        } else {
            this.f5197E.setSelection(this.f5204L);
        }
    }

    /* renamed from: a */
    private int m5712a(int i) {
        if (this.f5206N != null) {
            return this.f5206N.mo16664a(i);
        }
        String str = this.f5222k[i];
        Object[] sections = this.f5198F.getSections();
        if (sections == null) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= sections.length) {
                i3 = -1;
                break;
            } else if (sections[i3].toString().equals(str)) {
                break;
            } else {
                i3++;
            }
        }
        if (this.f5207O == 2 && i3 >= 0) {
            return i3;
        }
        if (this.f5207O != 1 || i3 == -1) {
            return -1;
        }
        int positionForSection = this.f5198F.getPositionForSection(i3);
        if (this.f5197E instanceof ListView) {
            i2 = ((ListView) this.f5197E).getFooterViewsCount();
        }
        if (positionForSection >= this.f5197E.getCount() - i2 || this.f5198F.getSectionForPosition(positionForSection) != i3) {
            return -1;
        }
        return i3;
    }

    /* renamed from: a */
    private void m5714a(int i, float f) {
        ListAdapter listAdapter = (ListAdapter) this.f5197E.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) listAdapter;
            this.f5204L = headerViewListAdapter.getHeadersCount();
            listAdapter = headerViewListAdapter.getWrappedAdapter();
        }
        if (listAdapter instanceof SectionIndexer) {
            this.f5198F = (SectionIndexer) listAdapter;
            int i2 = this.f5220i;
            int b = m5719b(i);
            if (this.f5220i == -1) {
                b = m5724c(i);
            }
            if (this.f5220i < 0 || this.f5220i >= this.f5222k.length) {
                if (this.f5225n != null && !this.f5225n.equals("")) {
                    setOverLayText(this.f5225n);
                }
            } else if (i2 != this.f5220i) {
                setOverLayText(this.f5220i);
                if (this.f5197E instanceof ListView) {
                    this.f5197E.setSelectionFromTop(this.f5204L + b, -this.f5205M);
                } else {
                    this.f5197E.setSelection(b + this.f5204L);
                }
            }
        } else {
            Log.w(f5191b, "mSectionIndexer is null, adapter is not implements");
        }
    }

    private void setOverLayText(int i) {
        setOverLayText(this.f5222k[i]);
    }

    private void setOverLayText(String str) {
        int i = this.f5228q;
        if (str != this.f5219h) {
            this.f5219h = str;
            switch (this.f5219h.length()) {
                case 1:
                    i = this.f5226o;
                    break;
                case 2:
                case 3:
                case 4:
                    i = this.f5227p;
                    break;
            }
            int i2 = 0;
            this.f5218g.setTextSize(0, (float) i);
            this.f5218g.setText(this.f5219h);
            m5720b();
            if (this.f5208P != null) {
                String str2 = this.f5208P.get(this.f5219h);
                if (str2 != null) {
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                    shapeDrawable.getPaint().setColor(Color.parseColor(str2));
                    this.f5218g.setBackground(shapeDrawable);
                    return;
                }
                return;
            }
            Object[] sections = this.f5198F.getSections();
            if (sections != null) {
                while (true) {
                    if (i2 >= sections.length) {
                        i2 = -1;
                    } else if (!sections[i2].toString().equals(str)) {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
                    shapeDrawable2.getPaint().setColor(getResources().getColor(this.f5210R[i2 % this.f5210R.length]));
                    this.f5218g.setBackground(shapeDrawable2);
                }
            }
        }
    }

    /* renamed from: b */
    private void m5720b() {
        if (m5725c()) {
            performHapticFeedback(20120);
        }
    }

    /* renamed from: c */
    private boolean m5725c() {
        try {
            if (f5190V == null) {
                f5190V = Class.forName("flyme.config.FlymeFeature").getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
            }
            return f5190V.getBoolean((Object) null);
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

    /* renamed from: b */
    private int m5719b(int i) {
        this.f5220i = -1;
        int i2 = i;
        int i3 = -1;
        while (i3 == -1) {
            int i4 = i2 - 1;
            if (i2 >= this.f5222k.length || i2 < 0) {
                break;
            }
            int a = m5712a(i2);
            if (!(a == -1 || (i3 = this.f5198F.getPositionForSection(a)) == -1)) {
                this.f5220i = Math.max(i2, 0);
            }
            i2 = i4;
        }
        return i3;
    }

    /* renamed from: c */
    private int m5724c(int i) {
        int i2 = i;
        int i3 = -1;
        while (i3 == -1) {
            i2++;
            if (i2 >= this.f5222k.length || i2 < 0) {
                break;
            }
            int a = m5712a(i2);
            if (a != -1) {
                i3 = this.f5198F.getPositionForSection(a);
            }
        }
        if (this.f5220i < 0 && i2 < this.f5222k.length) {
            this.f5220i = i2;
        }
        return i3 == -1 ? this.f5197E.getCount() : i3;
    }

    /* renamed from: a */
    private void m5716a(boolean z, View view) {
        m5721b(z, (View) this.f5218g);
        if (!this.f5215d) {
            m5721b(z, view);
        }
    }

    /* renamed from: b */
    private void m5721b(final boolean z, final View view) {
        if (view.getAnimation() == null) {
            if (z && view.getVisibility() == 0) {
                return;
            }
            if (!z && view.getVisibility() == 4) {
                return;
            }
        }
        float f = 1.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (!z) {
            f = 0.0f;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(z ? 0 : 4);
            }
        });
        alphaAnimation.setDuration(180);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setAnimation(alphaAnimation);
        alphaAnimation.startNow();
    }

    @TargetApi(17)
    private void setOverlayTextLayout(float f) {
        this.f5202J = (int) f;
        int width = this.f5197E.getWidth() - (this.f5231t + this.f5229r);
        int i = (int) (((float) this.f5232u) + f);
        int width2 = this.f5197E.getWidth() - this.f5231t;
        int i2 = this.f5230s + i;
        this.f5218g.setTranslationY(0.0f);
        if (this.f5197E.getLayoutDirection() == 0) {
            this.f5218g.layout(width, i, width2, i2);
        } else {
            this.f5218g.layout(this.f5231t, i, this.f5231t + this.f5229r, i2);
        }
    }

    /* renamed from: d */
    private void m5726d() {
        MotionEvent obtain = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0);
        this.f5197E.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: a */
    private void m5715a(MotionEvent motionEvent, int i) {
        this.f5218g.setTranslationY((float) (((int) ((((float) this.f5232u) + motionEvent.getY()) - ((float) this.f5202J))) + (this.f5230s / 2)));
        m5714a(i, motionEvent.getY());
    }

    public int getOverlayTextWidth() {
        return this.f5229r;
    }

    public int getOverlayTextMarginRight() {
        return this.f5231t;
    }

    public int getLetterTextColor() {
        return this.f5234w;
    }

    public int getLetterTextSize() {
        return this.f5233v;
    }

    public int getLetterMarginTop() {
        return this.f5236y;
    }

    public int getLetterMarginBottom() {
        return this.f5237z;
    }

    public int getLetterMarginRight() {
        return this.f5193A;
    }

    public int getLetterWidth() {
        return this.f5194B;
    }

    public String[] getOverlayTextLetters() {
        return this.f5222k;
    }

    public String[] getLetters() {
        return this.f5224m;
    }

    public int getHeaderHeight() {
        return this.f5205M;
    }

    public int getPaddingLeft() {
        return this.f5195C;
    }

    public int getHideNum() {
        return this.f5200H;
    }

    public String getHideStr() {
        return this.f5199G;
    }

    public void setOverlayTextBackgroundColor(Map<String, String> map) {
        this.f5208P = map;
    }

    public Map<String, String> getOverlayTextBackgroundColor() {
        return this.f5208P;
    }

    public void setCircleColorResIds(@NonNull int... iArr) {
        if (this.f5211S == CircleColorType.CUSTOM) {
            this.f5210R = iArr;
        }
    }

    public void setCircleColorType(@NonNull CircleColorType circleColorType) {
        this.f5211S = circleColorType;
        if (circleColorType != CircleColorType.CUSTOM) {
            if (circleColorType == CircleColorType.COLORFUL) {
                this.f5210R = this.f5209Q;
            } else if (circleColorType == CircleColorType.GRAY_SINGLE) {
                this.f5210R = new int[]{R.color.mc_fast_scroll_letter_color_gray};
            }
        }
    }
}
