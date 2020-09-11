package flyme.support.p093v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.TwoStateTextView */
public class TwoStateTextView extends TextView {

    /* renamed from: a */
    private int f18402a;

    /* renamed from: b */
    private int f18403b;

    /* renamed from: c */
    private String f18404c;

    /* renamed from: d */
    private String f18405d;

    /* renamed from: e */
    private State f18406e;

    /* renamed from: f */
    private boolean f18407f;

    /* renamed from: flyme.support.v7.widget.TwoStateTextView$State */
    private enum State {
        COMPLETED,
        PROGRESS
    }

    public TwoStateTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18402a = 0;
        this.f18403b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f18407f = false;
        m20384a();
    }

    /* renamed from: a */
    private void m20384a() {
        this.f18404c = getContext().getResources().getString(R.string.mz_action_bar_multi_choice_select_all);
        this.f18405d = getContext().getResources().getString(R.string.mz_action_bar_multi_choice_select_all_cancel);
    }

    public void setTotalCount(int i) {
        this.f18402a = i;
        this.f18407f = true;
    }

    public void setSelectedCount(int i) {
        this.f18403b = i;
        m20385b();
    }

    /* renamed from: b */
    private void m20385b() {
        if (this.f18407f) {
            this.f18407f = false;
            if (this.f18403b >= this.f18402a) {
                this.f18406e = State.COMPLETED;
                setText(this.f18405d);
                return;
            }
            this.f18406e = State.PROGRESS;
            setText(this.f18404c);
        } else if (this.f18406e == State.PROGRESS && this.f18403b >= this.f18402a) {
            setText(this.f18405d);
            this.f18406e = State.COMPLETED;
        } else if (this.f18406e == State.COMPLETED && this.f18403b < this.f18402a) {
            setText(this.f18404c);
            this.f18406e = State.PROGRESS;
        }
    }
}
