package flyme.support.p093v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* renamed from: flyme.support.v7.widget.PermissionScrollView */
public class PermissionScrollView extends ScrollView {

    /* renamed from: a */
    private C3245a f17905a;

    /* renamed from: flyme.support.v7.widget.PermissionScrollView$a */
    public interface C3245a {
        /* renamed from: a */
        void mo25432a(View view, int i, int i2, int i3, int i4);
    }

    public PermissionScrollView(Context context) {
        super(context);
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnScrollChangeListener(C3245a aVar) {
        this.f17905a = aVar;
    }

    public PermissionScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnScrollChangeListener(new C3245a() {
            /* renamed from: a */
            public void mo25432a(View view, int i, int i2, int i3, int i4) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f17905a != null) {
            this.f17905a.mo25432a(this, i, i2, i3, i4);
        }
    }
}
