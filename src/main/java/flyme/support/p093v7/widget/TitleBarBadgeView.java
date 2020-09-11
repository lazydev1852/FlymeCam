package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.TitleBarBadgeView */
public class TitleBarBadgeView extends View {

    /* renamed from: e */
    private static int f18329e = 16;

    /* renamed from: f */
    private static int f18330f = 16;

    /* renamed from: a */
    private int f18331a;

    /* renamed from: b */
    private int f18332b;

    /* renamed from: c */
    private Paint f18333c;

    /* renamed from: d */
    private boolean f18334d = false;

    /* renamed from: g */
    private int f18335g;

    /* renamed from: h */
    private int f18336h;

    /* renamed from: a */
    private int m20323a(int i, int i2, int i3) {
        return (i2 == Integer.MIN_VALUE || i2 != 1073741824) ? i3 : i;
    }

    public TitleBarBadgeView(Context context) {
        super(context);
        m20325a(context, (AttributeSet) null);
    }

    public TitleBarBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20325a(context, attributeSet);
    }

    public TitleBarBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20325a(context, attributeSet);
    }

    /* renamed from: a */
    private void m20325a(Context context, AttributeSet attributeSet) {
        m20326b(context, attributeSet);
        m20324a();
    }

    /* renamed from: b */
    private void m20326b(Context context, AttributeSet attributeSet) {
        TypedArray a = mo26943a(context, attributeSet, R.styleable.TitleBarBadgeView);
        if (a != null) {
            this.f18331a = a.getColor(R.styleable.TitleBarBadgeView_mcTBBadgeColor, getResources().getColor(R.color.mz_tab_view_dot_color));
            this.f18332b = (int) a.getDimension(R.styleable.TitleBarBadgeView_mcTBBadgeRadius, getResources().getDimension(R.dimen.mz_title_bar_badge_radius));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TypedArray mo26943a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    private void m20324a() {
        this.f18333c = new Paint();
        this.f18333c.setColor(this.f18331a);
        this.f18333c.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f18334d) {
            canvas.drawCircle((float) (((this.f18336h + 0) / 2) + 0), (float) (getHeight() / 2), (float) this.f18332b, this.f18333c);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.f18336h = m20323a(size, mode, f18330f);
        this.f18335g = m20323a(size2, mode2, f18329e);
        setMeasuredDimension(this.f18336h, this.f18335g);
    }

    public int getBadgeColor() {
        return this.f18331a;
    }

    public void setBadgeColor(int i) {
        this.f18331a = i;
        invalidate();
    }

    public int getBadgeRadius() {
        return this.f18332b;
    }

    public void setBadgeRadius(int i) {
        this.f18332b = i;
        invalidate();
    }

    public void setShow(boolean z) {
        this.f18334d = z;
    }
}
