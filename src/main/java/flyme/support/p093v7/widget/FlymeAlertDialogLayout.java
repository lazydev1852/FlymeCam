package flyme.support.p093v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0011R;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: flyme.support.v7.widget.FlymeAlertDialogLayout */
public class FlymeAlertDialogLayout extends LinearLayoutCompat {

    /* renamed from: a */
    private int f17627a;

    /* renamed from: b */
    private Context f17628b;

    public FlymeAlertDialogLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlymeAlertDialogLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlymeAlertDialogLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17627a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f17628b = context;
    }

    public void setMaxHeight(int i) {
        this.f17627a = i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!m19254a(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: a */
    private boolean m19254a(int i, int i2) {
        int id;
        int i3 = i;
        int i4 = i2;
        int childCount = getChildCount();
        View view = null;
        int i5 = 0;
        while (true) {
            int i6 = 8;
            if (i5 < childCount) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8 && ((id = childAt.getId()) == C0011R.C0013id.contentPanel || id == C0011R.C0013id.customPanel)) {
                    if (view != null) {
                        return false;
                    }
                    view = childAt;
                }
                i5++;
            } else if (view == null) {
                return false;
            } else {
                int min = Math.min(this.f17627a, View.MeasureSpec.getSize(i2));
                int mode = View.MeasureSpec.getMode(i);
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int i7 = min - paddingTop;
                int childCount2 = getChildCount();
                int i8 = paddingTop;
                int i9 = 0;
                int i10 = 0;
                while (i9 < childCount2) {
                    View childAt2 = getChildAt(i9);
                    if (childAt2.getVisibility() != i6 && childAt2 != view) {
                        if (childAt2.getLayoutParams().height == -1) {
                            childAt2.measure(i3, View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
                        } else if (childAt2.getLayoutParams().height == -2) {
                            childAt2.measure(i3, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                        } else {
                            childAt2.measure(i3, View.MeasureSpec.makeMeasureSpec(childAt2.getLayoutParams().height, 1073741824));
                        }
                        i8 += childAt2.getMeasuredHeight();
                        int i11 = min - i8;
                        int combineMeasuredStates = View.combineMeasuredStates(i10, childAt2.getMeasuredState());
                        if (i11 <= 0) {
                            return false;
                        }
                        i10 = combineMeasuredStates;
                        i7 = i11;
                    }
                    i9++;
                    i6 = 8;
                }
                view.measure(i3, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                if (view.getMeasuredHeight() > i7) {
                    return false;
                }
                int measuredHeight = i8 + view.getMeasuredHeight();
                int combineMeasuredStates2 = View.combineMeasuredStates(i10, view.getMeasuredState());
                int i12 = 0;
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt3 = getChildAt(i13);
                    if (childAt3.getVisibility() != 8) {
                        i12 = Math.max(i12, childAt3.getMeasuredWidth());
                    }
                }
                setMeasuredDimension(View.resolveSizeAndState(i12 + getPaddingLeft() + getPaddingRight(), i3, combineMeasuredStates2), View.resolveSizeAndState(measuredHeight, i4, 0));
                if (mode == 1073741824) {
                    return true;
                }
                m19255b(childCount, i4);
                return true;
            }
        }
    }

    /* renamed from: b */
    private void m19255b(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }
}
