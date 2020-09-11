package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.TabCollapseButton */
public class TabCollapseButton extends AppCompatImageView implements ViewPropertyAnimatorListener {

    /* renamed from: a */
    private static final Interpolator f18320a = PathInterpolatorCompat.create(0.18f, 0.367f, 0.0f, 1.0f);

    /* renamed from: b */
    private boolean f18321b;

    /* renamed from: c */
    private C3311a f18322c;

    /* renamed from: d */
    private ViewPropertyAnimatorCompatSet f18323d;

    /* renamed from: e */
    private Matrix f18324e;

    /* renamed from: flyme.support.v7.widget.TabCollapseButton$a */
    public interface C3311a {
        /* renamed from: a */
        void mo26933a(TabCollapseButton tabCollapseButton);
    }

    public void onAnimationCancel(View view) {
    }

    public void onAnimationStart(View view) {
    }

    public TabCollapseButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzTabContainerCollapseButtonStyle);
    }

    public TabCollapseButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18321b = true;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TabCollapseButton.this.mo26926a();
            }
        });
        setBackgroundDrawable((Drawable) null);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        super.onLayout(z, i, i2, i3, i4);
        if (z && getScaleType() == ImageView.ScaleType.MATRIX) {
            int intrinsicWidth = getDrawable().getIntrinsicWidth();
            int intrinsicHeight = getDrawable().getIntrinsicHeight();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if (intrinsicWidth > width || intrinsicHeight > height) {
                f = Math.min(((float) width) / ((float) intrinsicWidth), ((float) height) / ((float) intrinsicHeight));
            } else {
                f = 1.0f;
            }
            float f2 = (float) width;
            this.f18324e.setScale(f, f);
            this.f18324e.postTranslate((float) Math.round((f2 - (((float) intrinsicWidth) * f)) * 0.5f), 0.0f);
            setImageMatrix(this.f18324e);
            setPivotX(f2 * 0.5f);
            setPivotY(((float) intrinsicHeight) * 0.5f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26926a() {
        if (this.f18322c != null) {
            this.f18322c.mo26933a(this);
        }
    }

    public void setCollapsed(boolean z) {
        if (this.f18321b != z) {
            this.f18321b = z;
            m20319b(this.f18321b);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    /* renamed from: a */
    public ViewPropertyAnimatorCompatSet mo26048a(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        if (z) {
            ViewCompat.setRotation(this, 180.0f);
            viewPropertyAnimatorCompat = ViewCompat.animate(this).rotation(360.0f);
        } else {
            ViewCompat.setRotation(this, 0.0f);
            viewPropertyAnimatorCompat = ViewCompat.animate(this).rotation(180.0f);
        }
        viewPropertyAnimatorCompat.setInterpolator(f18320a);
        viewPropertyAnimatorCompat.setDuration(350);
        viewPropertyAnimatorCompatSet.play(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompatSet.setListener(this);
        return viewPropertyAnimatorCompatSet;
    }

    /* renamed from: b */
    private void m20319b(boolean z) {
        if (this.f18323d != null) {
            this.f18323d.cancel();
        }
        this.f18323d = mo26048a(z);
        this.f18323d.start();
    }

    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        return true;
    }

    public void setOnTabCollapseButtonClickListener(C3311a aVar) {
        this.f18322c = aVar;
    }

    public void onAnimationEnd(View view) {
        if (this.f18321b) {
            ViewCompat.setRotation(this, 0.0f);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (getScaleType() == ImageView.ScaleType.MATRIX && this.f18324e == null) {
            this.f18324e = new Matrix();
        }
    }
}
