package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionBarPolicy;

/* renamed from: flyme.support.v7.widget.FloatTabCollapseButton */
public class FloatTabCollapseButton extends TabCollapseButton {

    /* renamed from: a */
    private static final Interpolator f17624a = PathInterpolatorCompat.create(0.18f, 0.236f, 0.1f, 1.0f);

    /* renamed from: b */
    private int f17625b;

    /* renamed from: c */
    private final float f17626c;

    public FloatTabCollapseButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzFloatTabContainerCollapseButtonStyle);
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17625b = ActionBarPolicy.m18758a(context).mo25416e();
        setVisibility(8);
        this.f17626c = getResources().getDisplayMetrics().density * 8.0f;
        setBackgroundDrawable((Drawable) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f17625b, 1073741824));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ViewPropertyAnimatorCompatSet mo26048a(boolean z) {
        return super.mo26048a(z);
    }
}
