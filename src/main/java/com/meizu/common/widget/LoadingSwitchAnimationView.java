package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.meizu.common.R;

public class LoadingSwitchAnimationView extends View {

    /* renamed from: a */
    public static int f5592a = 1;

    /* renamed from: b */
    public static int f5593b = 2;

    /* renamed from: c */
    public static int f5594c = 3;

    /* renamed from: A */
    float f5595A;

    /* renamed from: B */
    float f5596B;

    /* renamed from: C */
    float f5597C;

    /* renamed from: D */
    float f5598D;

    /* renamed from: E */
    float f5599E;

    /* renamed from: F */
    float f5600F;

    /* renamed from: G */
    boolean f5601G;

    /* renamed from: H */
    boolean f5602H;

    /* renamed from: I */
    int f5603I;

    /* renamed from: J */
    boolean f5604J;

    /* renamed from: K */
    float f5605K;

    /* renamed from: L */
    float f5606L;

    /* renamed from: M */
    C1454a f5607M;

    /* renamed from: N */
    float f5608N;

    /* renamed from: O */
    float f5609O;

    /* renamed from: P */
    float[] f5610P;

    /* renamed from: Q */
    float[] f5611Q;

    /* renamed from: R */
    float f5612R;

    /* renamed from: S */
    float f5613S;

    /* renamed from: T */
    float[] f5614T;

    /* renamed from: U */
    float[] f5615U;

    /* renamed from: V */
    float[] f5616V;

    /* renamed from: W */
    float f5617W;

    /* renamed from: aa */
    int f5618aa;

    /* renamed from: ab */
    int f5619ab;

    /* renamed from: ac */
    private int f5620ac;

    /* renamed from: ad */
    private int f5621ad;

    /* renamed from: d */
    Paint f5622d;

    /* renamed from: e */
    Paint f5623e;

    /* renamed from: f */
    Paint f5624f;

    /* renamed from: g */
    Paint f5625g;

    /* renamed from: h */
    Paint f5626h;

    /* renamed from: i */
    Paint f5627i;

    /* renamed from: j */
    Paint f5628j;

    /* renamed from: k */
    Paint f5629k;

    /* renamed from: l */
    float f5630l;

    /* renamed from: m */
    float f5631m;

    /* renamed from: n */
    Bitmap f5632n;

    /* renamed from: o */
    Bitmap f5633o;

    /* renamed from: p */
    Bitmap f5634p;

    /* renamed from: q */
    Bitmap f5635q;

    /* renamed from: r */
    Path f5636r;

    /* renamed from: s */
    RectF f5637s;

    /* renamed from: t */
    RectF f5638t;

    /* renamed from: u */
    RectF f5639u;

    /* renamed from: v */
    RectF f5640v;

    /* renamed from: w */
    float f5641w;

    /* renamed from: x */
    float f5642x;

    /* renamed from: y */
    float f5643y;

    /* renamed from: z */
    float f5644z;

    /* renamed from: com.meizu.common.widget.LoadingSwitchAnimationView$a */
    public interface C1454a {
    }

    public LoadingSwitchAnimationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoadingSwitchAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingSwitchAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5620ac = 300;
        this.f5621ad = 2;
        this.f5641w = 0.0f;
        this.f5642x = 0.0f;
        this.f5601G = false;
        this.f5602H = true;
        this.f5604J = true;
        this.f5605K = 0.0f;
        this.f5606L = 180.0f;
        this.f5612R = 10.0f;
        this.f5617W = 67.5f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingSwitchAnimationView);
        this.f5618aa = obtainStyledAttributes.getInteger(R.styleable.LoadingSwitchAnimationView_animateDuration, this.f5620ac);
        this.f5619ab = obtainStyledAttributes.getInteger(R.styleable.LoadingSwitchAnimationView_itemCount, this.f5621ad);
        obtainStyledAttributes.recycle();
        this.f5622d = new Paint();
        this.f5622d.setColor(getResources().getColor(R.color.background_color));
        this.f5622d.setAntiAlias(true);
        this.f5622d.setStyle(Paint.Style.FILL);
        this.f5635q = BitmapFactory.decodeResource(getResources(), R.drawable.reflesh_on);
        this.f5634p = BitmapFactory.decodeResource(getResources(), R.drawable.reflesh_off);
        this.f5633o = BitmapFactory.decodeResource(getResources(), R.drawable.back_home_on);
        this.f5632n = BitmapFactory.decodeResource(getResources(), R.drawable.back_home_off);
        this.f5636r = new Path();
        this.f5637s = new RectF();
        this.f5638t = new RectF();
        this.f5639u = new RectF();
        this.f5640v = new RectF();
        this.f5610P = new float[2];
        this.f5611Q = new float[2];
        this.f5614T = new float[2];
        this.f5615U = new float[2];
        this.f5616V = new float[2];
        this.f5625g = new Paint();
        this.f5625g.setAlpha(255);
        this.f5626h = new Paint();
        this.f5626h.setAlpha(0);
        this.f5623e = new Paint();
        this.f5623e.setAlpha(0);
        this.f5624f = new Paint();
        this.f5624f.setAlpha(255);
        this.f5627i = new Paint();
        this.f5627i.setColor(getResources().getColor(R.color.background_color));
        this.f5627i.setAntiAlias(true);
        this.f5627i.setStyle(Paint.Style.FILL);
        this.f5627i.setAlpha(0);
        this.f5628j = new Paint();
        this.f5628j.setAlpha(0);
        this.f5629k = new Paint();
        this.f5629k.setAlpha(0);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5630l = (float) getWidth();
        this.f5631m = (float) getHeight();
        this.f5616V[0] = this.f5630l / 2.0f;
        this.f5616V[1] = 135.0f;
        if (this.f5619ab == 2) {
            this.f5600F = 144.0f;
            this.f5603I = f5592a;
        } else if (this.f5619ab == 3) {
            this.f5600F = 240.0f;
            this.f5603I = f5594c;
        }
        this.f5614T[0] = (this.f5630l / 2.0f) - this.f5600F;
        this.f5614T[1] = 135.0f;
        this.f5615U[0] = (this.f5630l / 2.0f) + this.f5600F;
        this.f5615U[1] = 135.0f;
        this.f5640v.left = this.f5616V[0] - this.f5617W;
        this.f5640v.top = this.f5616V[1] - this.f5617W;
        this.f5640v.right = this.f5616V[0] + this.f5617W;
        this.f5640v.bottom = this.f5616V[1] + this.f5617W;
        this.f5638t.left = this.f5614T[0] - this.f5617W;
        this.f5638t.top = this.f5614T[1] - this.f5617W;
        this.f5638t.right = this.f5614T[0] + this.f5617W;
        this.f5638t.bottom = this.f5614T[1] + this.f5617W;
        this.f5639u.left = this.f5615U[0] - this.f5617W;
        this.f5639u.top = this.f5615U[1] - this.f5617W;
        this.f5639u.right = this.f5615U[0] + this.f5617W;
        this.f5639u.bottom = this.f5615U[1] + this.f5617W;
        this.f5637s.left = this.f5638t.left;
        this.f5637s.top = this.f5638t.top;
        this.f5637s.right = this.f5638t.right;
        this.f5637s.bottom = this.f5638t.bottom;
        this.f5608N = this.f5637s.width();
        this.f5609O = this.f5637s.height();
        this.f5613S = this.f5637s.right;
        this.f5643y = this.f5638t.right;
        this.f5644z = this.f5643y - this.f5638t.left;
        this.f5595A = this.f5639u.left;
        this.f5596B = this.f5639u.right - this.f5595A;
        this.f5595A = this.f5639u.left;
        this.f5596B = this.f5639u.right - this.f5595A;
        this.f5597C = this.f5640v.left;
        this.f5598D = this.f5640v.right;
        this.f5599E = this.f5640v.right - this.f5640v.left;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5604J) {
            m5865a(canvas);
        } else {
            m5866b(canvas);
        }
    }

    /* renamed from: a */
    private void m5865a(Canvas canvas) {
        canvas.drawOval(this.f5637s, this.f5627i);
        canvas.drawBitmap(this.f5632n, (Rect) null, this.f5639u, this.f5629k);
        if (this.f5642x < 265.0f) {
            this.f5606L = ((264.0f - this.f5642x) * 180.0f) / 264.0f;
            canvas.save();
            canvas.rotate(this.f5606L, this.f5638t.centerX(), this.f5638t.centerY());
            canvas.drawBitmap(this.f5634p, (Rect) null, this.f5638t, this.f5628j);
            canvas.restore();
            return;
        }
        canvas.drawBitmap(this.f5635q, (Rect) null, this.f5638t, this.f5627i);
    }

    /* renamed from: b */
    private void m5866b(Canvas canvas) {
        this.f5610P[0] = this.f5613S + this.f5641w + this.f5612R;
        this.f5610P[1] = this.f5637s.top;
        this.f5611Q[0] = this.f5613S + this.f5641w + this.f5612R;
        this.f5611Q[1] = this.f5637s.bottom;
        canvas.drawOval(this.f5637s, this.f5622d);
        this.f5636r.reset();
        this.f5636r.moveTo(this.f5637s.left + (this.f5637s.width() / 2.0f), this.f5637s.top);
        this.f5636r.cubicTo(this.f5610P[0], this.f5610P[1], this.f5611Q[0], this.f5611Q[1], this.f5637s.left + (this.f5637s.width() / 2.0f), this.f5637s.bottom);
        this.f5636r.close();
        canvas.drawPath(this.f5636r, this.f5622d);
        canvas.drawBitmap(this.f5634p, (Rect) null, this.f5638t, this.f5623e);
        canvas.drawBitmap(this.f5635q, (Rect) null, this.f5638t, this.f5624f);
        canvas.drawBitmap(this.f5632n, (Rect) null, this.f5639u, this.f5625g);
        canvas.drawBitmap(this.f5633o, (Rect) null, this.f5639u, this.f5626h);
    }

    public void setAnimationEndListener(C1454a aVar) {
        this.f5607M = aVar;
    }

    public int getCurrentSelection() {
        return this.f5637s.centerX() > this.f5630l / 2.0f ? f5593b : f5592a;
    }

    public void setAnimateDuration(int i) {
        this.f5618aa = i;
    }

    public void setSelectedIconBackGroundColor(int i) {
        this.f5622d.setColor(i);
        this.f5627i.setColor(i);
        this.f5627i.setAlpha(0);
    }

    public void setLeftIconUnSelected(Bitmap bitmap) {
        this.f5634p = bitmap;
    }

    public void setLeftIconSelected(Bitmap bitmap) {
        this.f5635q = bitmap;
    }

    public void setRightIconUnSelected(Bitmap bitmap) {
        this.f5632n = bitmap;
    }

    public void setRightIconSelected(Bitmap bitmap) {
        this.f5633o = bitmap;
    }
}
