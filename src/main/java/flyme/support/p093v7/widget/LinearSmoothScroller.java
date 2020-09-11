package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: flyme.support.v7.widget.n */
public class LinearSmoothScroller extends RecyclerView.C3280q {

    /* renamed from: a */
    private final float f18546a;

    /* renamed from: c */
    protected final Interpolator f18547c = PathInterpolatorCompat.create(0.35f, 0.56f, 0.2f, 1.0f);

    /* renamed from: d */
    protected final DecelerateInterpolator f18548d = new DecelerateInterpolator();

    /* renamed from: e */
    protected PointF f18549e;

    /* renamed from: f */
    protected int f18550f = 0;

    /* renamed from: g */
    protected int f18551g = 0;

    /* renamed from: a */
    private int m20691a(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26724a() {
    }

    public LinearSmoothScroller(Context context) {
        this.f18546a = mo20066a(context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo20069a(View view, RecyclerView.C3283r rVar, RecyclerView.C3280q.C3281a aVar) {
        int b = mo27201b(view, mo27202c());
        int a = mo27198a(view, mo27204d());
        int b2 = mo27200b((int) Math.sqrt((double) ((b * b) + (a * a))));
        if (b2 > 0) {
            aVar.mo26739a(-b, -a, b2, this.f18548d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26725a(int i, int i2, RecyclerView.C3283r rVar, RecyclerView.C3280q.C3281a aVar) {
        if (mo26737j() == 0) {
            mo26733f();
            return;
        }
        this.f18550f = m20691a(this.f18550f, i);
        this.f18551g = m20691a(this.f18551g, i2);
        if (this.f18550f == 0 && this.f18551g == 0) {
            mo27199a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo26728b() {
        this.f18551g = 0;
        this.f18550f = 0;
        this.f18549e = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo20066a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo27200b(int i) {
        return (int) Math.ceil(((double) mo27203c(i)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo27203c(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f18546a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo27202c() {
        if (this.f18549e == null || this.f18549e.x == 0.0f) {
            return 0;
        }
        return this.f18549e.x > 0.0f ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo27204d() {
        if (this.f18549e == null || this.f18549e.y == 0.0f) {
            return 0;
        }
        return this.f18549e.y > 0.0f ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27199a(RecyclerView.C3280q.C3281a aVar) {
        PointF a = mo20068a(mo26736i());
        if (a == null || (a.x == 0.0f && a.y == 0.0f)) {
            aVar.mo26738a(mo26736i());
            mo26733f();
            return;
        }
        mo26726a(a);
        this.f18549e = a;
        this.f18550f = (int) (a.x * 10000.0f);
        this.f18551g = (int) (a.y * 10000.0f);
        aVar.mo26739a((int) (((float) this.f18550f) * 1.2f), (int) (((float) this.f18551g) * 1.2f), (int) (((float) mo27203c(ComponentMessageType.MSG_TYPE_ON_SHAKE)) * 1.2f), this.f18547c);
    }

    /* renamed from: a */
    public int mo20067a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                int i7 = i4 - i2;
                if (i7 < 0) {
                    return i7;
                }
                return 0;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    /* renamed from: a */
    public int mo27198a(View view, int i) {
        RecyclerView.C3266g e = mo26732e();
        if (e == null || !e.mo26092g()) {
            return 0;
        }
        RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
        return mo20067a(e.mo26640i(view) - hVar.topMargin, e.mo26644k(view) + hVar.bottomMargin, e.mo26560D(), e.mo26558B() - e.mo26562F(), i);
    }

    /* renamed from: b */
    public int mo27201b(View view, int i) {
        RecyclerView.C3266g e = mo26732e();
        if (e == null || !e.mo22258a()) {
            return 0;
        }
        RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
        return mo20067a(e.mo26638h(view) - hVar.leftMargin, e.mo26642j(view) + hVar.rightMargin, e.mo26559C(), e.mo26557A() - e.mo26561E(), i);
    }

    @Nullable
    /* renamed from: a */
    public PointF mo20068a(int i) {
        RecyclerView.C3266g e = mo26732e();
        if (e instanceof RecyclerView.C3280q.C3282b) {
            return ((RecyclerView.C3280q.C3282b) e).mo26084d(i);
        }
        Log.w("LinearSmoothScroller", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + RecyclerView.C3280q.C3282b.class.getCanonicalName());
        return null;
    }
}
