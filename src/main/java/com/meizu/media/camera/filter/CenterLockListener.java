package com.meizu.media.camera.filter;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.meizu.media.camera.adapter.BaseViewHolder;
import com.meizu.media.camera.filter.MzDynamicFilterManager;
import com.meizu.media.camera.p077ui.MzARUI;
import com.meizu.media.camera.p077ui.MzFunnySnapUI;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.SelectAdapter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.LinearLayoutManager;
import flyme.support.p093v7.widget.RecyclerView;

/* renamed from: com.meizu.media.camera.filter.b */
public class CenterLockListener extends RecyclerView.C3274l {

    /* renamed from: a */
    public static ChangeQuickRedirect f10048a;

    /* renamed from: j */
    private static final LogUtil.C2630a f10049j = new LogUtil.C2630a("CenterLockListener");

    /* renamed from: b */
    private boolean f10050b = true;

    /* renamed from: c */
    private boolean f10051c = true;

    /* renamed from: d */
    private int f10052d;

    /* renamed from: e */
    private int f10053e;

    /* renamed from: f */
    private int f10054f;

    /* renamed from: g */
    private int f10055g;

    /* renamed from: h */
    private int f10056h;

    /* renamed from: i */
    private View f10057i;

    public CenterLockListener(int i, int i2, int i3) {
        this.f10052d = i;
        this.f10053e = i2;
        this.f10054f = i3;
    }

    public CenterLockListener(int i, int i2, int i3, int i4, int i5) {
        this.f10052d = i;
        this.f10053e = i2;
        this.f10054f = i3;
        this.f10055g = i4;
        this.f10056h = i5;
    }

    /* renamed from: a */
    public void mo20073a(boolean z) {
        this.f10051c = z;
    }

    /* renamed from: a */
    public void mo20071a(RecyclerView recyclerView, int i) {
        int top;
        int bottom;
        int top2;
        int bottom2;
        if (!PatchProxy.proxy(new Object[]{recyclerView, new Integer(i)}, this, f10048a, false, 4063, new Class[]{RecyclerView.class, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10049j;
            LogUtil.m15944a(aVar, "onScrollStateChanged: " + i + " mAutoSet: " + this.f10050b + " mIsNeedToScrollToCenter: " + this.f10051c, true);
            super.mo20071a(recyclerView, i);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (this.f10052d == 0) {
                if (linearLayoutManager.mo26093h() == 0) {
                    top2 = recyclerView.getLeft();
                    bottom2 = recyclerView.getRight();
                } else {
                    top2 = recyclerView.getTop();
                    bottom2 = recyclerView.getBottom();
                }
                this.f10052d = top2 + bottom2;
            }
            if (!this.f10050b && i == 0) {
                View a = m10308a(linearLayoutManager);
                if (a != null) {
                    this.f10057i = a;
                    if (linearLayoutManager.mo26093h() == 0) {
                        top = a.getLeft();
                        bottom = a.getRight();
                    } else {
                        top = a.getTop();
                        bottom = a.getBottom();
                    }
                    int i2 = ((top + bottom) / 2) - this.f10052d;
                    if (this.f10051c) {
                        if (linearLayoutManager.mo26093h() == 0) {
                            recyclerView.mo26367a(i2, 0, (Interpolator) new DecelerateInterpolator());
                        } else {
                            recyclerView.mo26367a(0, i2, (Interpolator) new DecelerateInterpolator());
                        }
                    }
                    SelectAdapter pVar = (SelectAdapter) recyclerView.getAdapter();
                    BaseViewHolder aVar2 = (BaseViewHolder) recyclerView.mo26395e(a);
                    if (aVar2 instanceof MzDynamicFilterManager.C2074d) {
                        pVar.mo23410b(true);
                    }
                    if (aVar2 instanceof MzDynamicFilterManager.C2071a) {
                        pVar.mo23410b(true);
                        int i3 = recyclerView.mo26424i(a);
                        if (i3 > 0) {
                            pVar.mo20095a(i3);
                            aVar2.mo18785a(true);
                        }
                    } else {
                        int i4 = recyclerView.mo26424i(a);
                        if (i4 >= 0) {
                            pVar.mo20095a(i4);
                            aVar2.mo18785a(true);
                        }
                    }
                    this.f10050b = true;
                    this.f10051c = true;
                } else {
                    return;
                }
            }
            if (i == 1 || i == 2) {
                this.f10050b = false;
            }
        }
    }

    /* renamed from: a */
    public void mo20070a(RecyclerView recyclerView) {
        int top;
        int bottom;
        int top2;
        int bottom2;
        if (!PatchProxy.proxy(new Object[]{recyclerView}, this, f10048a, false, 4064, new Class[]{RecyclerView.class}, Void.TYPE).isSupported && this.f10051c) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (this.f10052d == 0) {
                if (linearLayoutManager.mo26093h() == 0) {
                    top2 = recyclerView.getLeft();
                    bottom2 = recyclerView.getRight();
                } else {
                    top2 = recyclerView.getTop();
                    bottom2 = recyclerView.getBottom();
                }
                this.f10052d = top2 + bottom2;
            }
            View a = m10308a(linearLayoutManager);
            if (a != null) {
                if (linearLayoutManager.mo26093h() == 0) {
                    top = a.getLeft();
                    bottom = a.getRight();
                } else {
                    top = a.getTop();
                    bottom = a.getBottom();
                }
                int i = ((top + bottom) / 2) - this.f10052d;
                if (linearLayoutManager.mo26093h() == 0) {
                    mo20072a(recyclerView, i, 0);
                } else {
                    mo20072a(recyclerView, 0, i);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20072a(RecyclerView recyclerView, int i, int i2) {
        float f;
        RecyclerView recyclerView2 = recyclerView;
        int i3 = i;
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{recyclerView2, new Integer(i3), new Integer(i2)}, this, f10048a, false, 4065, new Class[]{RecyclerView.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.mo20072a(recyclerView, i, i2);
            int childCount = recyclerView.getChildCount();
            SelectAdapter pVar = (SelectAdapter) recyclerView.getAdapter();
            if (i3 == 0) {
                this.f10057i = recyclerView2.getChildAt(0);
                return;
            }
            int i4 = 0;
            while (i4 < childCount) {
                BaseViewHolder aVar = (BaseViewHolder) recyclerView2.mo26395e(recyclerView2.getChildAt(i4));
                LinearLayout.LayoutParams layoutParams = null;
                boolean z2 = aVar instanceof MzDynamicFilterManager.C2074d;
                if (z2) {
                    layoutParams = (LinearLayout.LayoutParams) ((MzDynamicFilterManager.C2074d) aVar).f10100f.getLayoutParams();
                } else if (aVar instanceof MzDynamicFilterManager.C2071a) {
                    layoutParams = (LinearLayout.LayoutParams) ((MzDynamicFilterManager.C2071a) aVar).f10087f.getLayoutParams();
                } else if ((aVar instanceof MzFunnySnapUI.C2565d) || (aVar instanceof MzARUI.C2461e)) {
                    layoutParams = (LinearLayout.LayoutParams) aVar.f7557a.getLayoutParams();
                }
                float left = (float) aVar.f18121j.getLeft();
                if (left > ((float) (this.f10052d - (this.f10054f / 2))) || left < ((float) ((this.f10052d - (this.f10054f / 2)) - this.f10053e))) {
                    f = (left > ((float) (this.f10052d + (this.f10054f / 2))) || left <= ((float) (this.f10052d - (this.f10054f / 2)))) ? 0.0f : (((float) (this.f10052d + (this.f10054f / 2))) - left) / ((float) this.f10054f);
                } else {
                    f = 1.0f - ((((float) (this.f10052d - (this.f10054f / 2))) - left) / ((float) this.f10053e));
                }
                double d = (double) f;
                if (d < 0.65d && !this.f10050b) {
                    aVar.mo18785a(z);
                }
                if (z2) {
                    layoutParams.width = (int) (((float) this.f10053e) + (f * ((float) (this.f10054f - this.f10053e))));
                    layoutParams.height = layoutParams.width;
                    if (d > 0.53d && aVar.f18121j != this.f10057i && pVar.f15561e) {
                        this.f10057i = aVar.f18121j;
                        DeviceUtil.m16194a((View) recyclerView2, 22507);
                        pVar.mo23410b(true);
                        pVar.mo20099b(aVar.mo26773g());
                    }
                    ((MzDynamicFilterManager.C2074d) aVar).f10100f.setLayoutParams(layoutParams);
                } else if (aVar instanceof MzDynamicFilterManager.C2071a) {
                    layoutParams.width = (int) (((float) this.f10053e) + (f * ((float) (this.f10054f - this.f10053e))));
                    layoutParams.height = layoutParams.width;
                    if (d > 0.53d && aVar.f18121j != this.f10057i && pVar.f15561e) {
                        this.f10057i = aVar.f18121j;
                        DeviceUtil.m16194a((View) recyclerView2, 22507);
                        pVar.mo23410b(true);
                        pVar.mo20099b(aVar.mo26773g());
                    }
                    ((MzDynamicFilterManager.C2071a) aVar).f10087f.setLayoutParams(layoutParams);
                } else if ((aVar instanceof MzFunnySnapUI.C2565d) || (aVar instanceof MzARUI.C2461e)) {
                    if (d > 0.53d && aVar.f18121j != this.f10057i) {
                        this.f10057i = aVar.f18121j;
                    }
                    layoutParams.width = (int) (((float) this.f10053e) + (((float) (this.f10054f - this.f10053e)) * f));
                    layoutParams.height = (int) (((float) this.f10055g) + (f * ((float) (this.f10056h - this.f10055g))));
                    aVar.f7557a.setLayoutParams(layoutParams);
                }
                i4++;
                z = false;
            }
        }
    }

    /* renamed from: a */
    private View m10308a(LinearLayoutManager linearLayoutManager) {
        int top;
        int bottom;
        boolean z = true;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{linearLayoutManager}, this, f10048a, false, 4066, new Class[]{LinearLayoutManager.class}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        View view = null;
        int i = 0;
        for (int o = linearLayoutManager.mo26101o(); o <= linearLayoutManager.mo26102p() && z; o++) {
            View c = linearLayoutManager.mo26080c(o);
            if (c != null) {
                if (linearLayoutManager.mo26093h() == 0) {
                    top = c.getLeft();
                    bottom = c.getRight();
                } else {
                    top = c.getTop();
                    bottom = c.getBottom();
                }
                int abs = Math.abs(this.f10052d - ((top + bottom) / 2));
                if (abs <= i || o == linearLayoutManager.mo26101o()) {
                    view = c;
                    i = abs;
                } else {
                    z = false;
                }
            }
        }
        return view;
    }
}
