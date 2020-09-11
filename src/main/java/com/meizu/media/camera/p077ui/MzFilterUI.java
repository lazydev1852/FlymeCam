package com.meizu.media.camera.p077ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.adapter.BaseViewHolder;
import com.meizu.media.camera.databinding.MzFilterControlBinding;
import com.meizu.media.camera.filter.CenterLockLayoutManager;
import com.meizu.media.camera.filter.CenterLockListener;
import com.meizu.media.camera.filter.FilterRecyclerView;
import com.meizu.media.camera.filter.MzDynamicFilterManager;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.views.SelectAdapter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.LinearLayoutManager;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.meizu.media.camera.ui.o */
public class MzFilterUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13300a;

    /* renamed from: b */
    private static final LogUtil.C2630a f13301b = new LogUtil.C2630a("MzFilterUI");

    /* renamed from: c */
    private MzFilterControlBinding f13302c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f13303d;

    /* renamed from: e */
    private Context f13304e;

    /* renamed from: f */
    private boolean f13305f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f13306g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FilterRecyclerView f13307h;

    /* renamed from: i */
    private TextView f13308i;

    /* renamed from: j */
    private View f13309j;

    /* renamed from: k */
    private MzUIController f13310k;

    /* renamed from: l */
    private ObjectAnimator f13311l;

    /* renamed from: m */
    private CameraUtil.ScreeAspectRatio f13312m;

    /* renamed from: n */
    private boolean f13313n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f13314o = false;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f13315p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f13316q = false;

    /* renamed from: r */
    private int f13317r = -1;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public CenterLockListener f13318s;

    public MzFilterUI(Context context, MzFilterControlBinding mzFilterControlBinding) {
        this.f13304e = context;
        this.f13302c = mzFilterControlBinding;
    }

    /* renamed from: a */
    public void mo22305a() {
        if (!PatchProxy.proxy(new Object[0], this, f13300a, false, 7185, new Class[0], Void.TYPE).isSupported && !this.f13305f) {
            this.f13303d = this.f13302c.f9716b;
            this.f13309j = this.f13302c.f9717c;
            this.f13307h = this.f13302c.f9718d;
            this.f13307h.setSelectorCanDraw(false);
            this.f13316q = true;
            this.f13308i = this.f13302c.f9715a;
            CenterLockLayoutManager aVar = new CenterLockLayoutManager(this.f13304e, this.f13304e.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f13304e.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_width), this.f13304e.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_checked_width));
            aVar.mo26076b(0);
            this.f13307h.setLayoutManager(aVar);
            this.f13318s = new CenterLockListener(this.f13304e.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f13304e.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_width), this.f13304e.getResources().getDimensionPixelSize(R.dimen.mz_filter_item_checked_width));
            this.f13307h.setOnScrollListener(this.f13318s);
            this.f13305f = true;
            if (NavigationBarUtils.m15972a()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13303d.getLayoutParams();
                layoutParams.bottomMargin += CameraUtil.m15899g();
                this.f13303d.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: a */
    public void mo22308a(MzUIController uVar) {
        this.f13310k = uVar;
    }

    /* renamed from: a */
    public void mo22311a(RecyclerView.C3260a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f13300a, false, 7186, new Class[]{RecyclerView.C3260a.class}, Void.TYPE).isSupported && this.f13307h != null) {
            this.f13307h.setAdapter(aVar);
            aVar.mo26541f();
            this.f13306g = true;
            this.f13316q = true;
        }
    }

    /* renamed from: a */
    public void mo22310a(MzRecyclerView.C3227j jVar) {
        if (!PatchProxy.proxy(new Object[]{jVar}, this, f13300a, false, 7187, new Class[]{MzRecyclerView.C3227j.class}, Void.TYPE).isSupported && this.f13307h != null) {
            this.f13307h.setOnItemClickListener(jVar);
            this.f13307h.mo26373a((RecyclerView.C3273k) new RecyclerView.C3273k() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13319a;

                /* renamed from: a */
                public void mo22325a(boolean z) {
                }

                /* renamed from: b */
                public void mo22327b(RecyclerView recyclerView, MotionEvent motionEvent) {
                }

                /* renamed from: a */
                public boolean mo22326a(RecyclerView recyclerView, MotionEvent motionEvent) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{recyclerView, motionEvent}, this, f13319a, false, 7204, new Class[]{RecyclerView.class, MotionEvent.class}, Boolean.TYPE);
                    if (proxy.isSupported) {
                        return ((Boolean) proxy.result).booleanValue();
                    }
                    switch (motionEvent.getAction()) {
                        case 0:
                            boolean unused = MzFilterUI.this.f13314o = true;
                            boolean unused2 = MzFilterUI.this.f13315p = false;
                            break;
                        case 1:
                            boolean unused3 = MzFilterUI.this.f13314o = false;
                            boolean unused4 = MzFilterUI.this.f13315p = false;
                            break;
                        case 2:
                            boolean unused5 = MzFilterUI.this.f13315p = true;
                            break;
                    }
                    return false;
                }
            });
        }
    }

    /* renamed from: b */
    public boolean mo22316b() {
        return this.f13313n;
    }

    /* renamed from: c */
    public boolean mo22318c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13300a, false, 7188, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int scrollState = this.f13307h.getScrollState();
        LogUtil.C2630a aVar = f13301b;
        LogUtil.m15942a(aVar, "mFilterList.getScrollState(): " + scrollState);
        switch (scrollState) {
            case 0:
                return false;
            case 1:
                if (this.f13314o) {
                    return true;
                }
                return false;
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: d */
    public void mo22319d() {
        if (!PatchProxy.proxy(new Object[0], this, f13300a, false, 7189, new Class[0], Void.TYPE).isSupported) {
            this.f13313n = true;
            mo22320d(true);
        }
    }

    /* renamed from: a */
    public void mo22313a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13300a, false, 7190, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13313n = false;
            this.f13314o = false;
            this.f13315p = false;
            if (z) {
                mo22320d(false);
                return;
            }
            this.f13303d.setVisibility(4);
            if (this.f13306g) {
                mo22321e().mo23410b(false);
            }
            EventBus.m21789a().mo27980d(6);
        }
    }

    /* renamed from: a */
    public void mo22312a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13300a, false, 7191, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f13308i.setText(str);
        }
    }

    /* renamed from: e */
    public SelectAdapter mo22321e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13300a, false, 7192, new Class[0], SelectAdapter.class);
        return proxy.isSupported ? (SelectAdapter) proxy.result : (SelectAdapter) this.f13307h.getAdapter();
    }

    /* renamed from: a */
    public void mo22306a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13300a, false, 7193, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f13307h != null) {
            if (!this.f13313n && this.f13306g) {
                mo22321e().mo23410b(false);
            }
            this.f13307h.mo26403g(i);
        }
    }

    /* renamed from: b */
    public void mo22315b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13300a, false, 7194, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13307h != null && this.f13307h.getAdapter() != null) {
            SelectAdapter pVar = (SelectAdapter) this.f13307h.getAdapter();
            int b = pVar.mo23409b();
            if (b == 0 && !z) {
                return;
            }
            if (b != pVar.mo20093a() - 1 || !z) {
                this.f13318s.mo20073a(false);
                this.f13307h.mo26403g(z ? b + 1 : b - 1);
            }
        }
    }

    /* renamed from: c */
    public void mo22317c(boolean z) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13300a, false, 7195, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f13309j == null || !mo22316b()) {
            return;
        }
        if (z) {
            this.f13309j.setVisibility(4);
            this.f13308i.setVisibility(4);
            return;
        }
        this.f13309j.setVisibility(0);
        this.f13308i.setVisibility(0);
    }

    /* renamed from: f */
    public boolean mo22323f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13300a, false, 7197, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13311l != null && this.f13311l.isRunning();
    }

    /* renamed from: d */
    public void mo22320d(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13300a, false, 7198, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f13311l != null && this.f13311l.isRunning()) {
                this.f13311l.end();
            }
            if (this.f13312m != null) {
                CameraUtil.ScreeAspectRatio screeAspectRatio = this.f13312m;
                CameraUtil.ScreeAspectRatio screeAspectRatio2 = CameraUtil.ScreeAspectRatio.Ratio_4_3;
            }
            if (z) {
                this.f13303d.setAlpha(0.01f);
                this.f13303d.setVisibility(0);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f13307h.getLayoutManager();
                if (linearLayoutManager != null && linearLayoutManager.mo26101o() == 0) {
                    View childAt = this.f13307h.getChildAt(0);
                    if (this.f13307h.mo26395e(childAt) != null) {
                        BaseViewHolder aVar = (BaseViewHolder) this.f13307h.mo26395e(childAt);
                        if (aVar instanceof MzDynamicFilterManager.C2074d) {
                            ((MzDynamicFilterManager.C2074d) aVar).mo20102a().setAlpha(1.0f);
                        }
                    }
                }
            }
            float f = z ? 0.0f : 1.0f;
            float f2 = z ? 1.0f : 0.0f;
            int i = z ? 260 : 96;
            this.f13311l = ObjectAnimator.ofFloat(this.f13303d, "alpha", new float[]{f, f2});
            if (z) {
                this.f13311l.setStartDelay(20);
            }
            this.f13311l.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.f13311l.setDuration((long) i);
            this.f13311l.addListener(new AnimatorListenerAdapter() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13321a;

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13321a, false, 7205, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        super.onAnimationStart(animator);
                        if (z) {
                            if (MzFilterUI.this.f13316q && MzFilterUI.this.f13306g) {
                                boolean unused = MzFilterUI.this.f13316q = false;
                                MzFilterUI.this.f13318s.mo20070a((RecyclerView) MzFilterUI.this.f13307h);
                            }
                            EventBus.m21789a().mo27980d(5);
                        }
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13321a, false, 7206, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        super.onAnimationEnd(animator);
                        if (!z) {
                            MzFilterUI.this.f13303d.setVisibility(4);
                            EventBus.m21789a().mo27980d(6);
                        }
                        if (!MzFilterUI.this.f13306g) {
                            return;
                        }
                        if (z) {
                            MzFilterUI.this.mo22321e().mo23410b(true);
                        } else {
                            MzFilterUI.this.mo22321e().mo23410b(false);
                        }
                    }
                }
            });
            this.f13311l.start();
        }
    }

    /* renamed from: a */
    public void mo22309a(CameraUtil.ScreeAspectRatio screeAspectRatio) {
        this.f13312m = screeAspectRatio;
    }

    /* renamed from: b */
    public void mo22314b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13300a, false, 7200, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13317r = i;
            if (this.f13317r == 1) {
                this.f13307h.setShouldIntercept(false);
            } else {
                this.f13307h.setShouldIntercept(true);
            }
        }
    }

    /* renamed from: a */
    public void mo22307a(FilterRecyclerView.C2066b bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f13300a, false, 7201, new Class[]{FilterRecyclerView.C2066b.class}, Void.TYPE).isSupported) {
            this.f13307h.setScrollListener(bVar);
        }
    }

    /* renamed from: e */
    public void mo22322e(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13300a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7202, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13306g) {
            mo22321e().mo23410b(z);
        }
    }

    /* renamed from: g */
    public void mo22324g() {
        if (!PatchProxy.proxy(new Object[0], this, f13300a, false, 7203, new Class[0], Void.TYPE).isSupported && this.f13307h != null) {
            this.f13307h.setOnScrollListener((RecyclerView.C3274l) null);
        }
    }
}
