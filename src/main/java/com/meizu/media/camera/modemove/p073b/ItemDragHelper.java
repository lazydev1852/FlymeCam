package com.meizu.media.camera.modemove.p073b;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.modemove.adapter.BaseItemAdapter;
import com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder;
import com.meizu.media.camera.modemove.p075d.OnItemDragListener;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 G2\u00020\u0001:\u0002GHB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018H\u0002J\u0012\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010 H\u0002J*\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0002J2\u00100\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010 2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0018H\u0002J\u0018\u00105\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0002J \u00106\u001a\u00020.2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u00107\u001a\u00020\fH\u0002J\u000e\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020:J\"\u0010;\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020.H\u0002J \u0010?\u001a\u00020.2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010'\u001a\u00020 2\u0006\u00102\u001a\u00020\u0011H\u0002J\u000e\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020\bJ\u0016\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0011J\b\u0010F\u001a\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/helper/ItemDragHelper;", "", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mActivity", "Lcom/meizu/media/camera/CameraActivity;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/meizu/media/camera/CameraActivity;)V", "mDragListener", "Lcom/meizu/media/camera/modemove/listener/OnItemDragListener;", "mFloatViewHelper", "Lcom/meizu/media/camera/modemove/helper/DragFloatViewHelper;", "<set-?>", "", "mIsDrag", "getMIsDrag", "()Z", "mItemViewHeight", "", "mLastItemChangeTime", "", "mLastItemPos", "mLastRecyclerPos", "mLastRecyclerView", "mLastTouchRawX", "", "mLastTouchRawY", "mScrollRunnable", "com/meizu/media/camera/modemove/helper/ItemDragHelper$mScrollRunnable$1", "Lcom/meizu/media/camera/modemove/helper/ItemDragHelper$mScrollRunnable$1;", "mTouchStayTime", "findRecyclerView", "view", "Landroid/view/View;", "getInsideLocation", "", "recyclerView", "touchRawX", "touchRawY", "getPositionByChildView", "itemView", "getTargetItemPos", "itemTargetView", "childY", "lastRecyclerPos", "currRecyclerPos", "initParams", "", "isChangeRecyclerView", "isItemNeedChange", "lastItemPos", "itemPos", "itemY", "itemX", "isSelectedRecyclerView", "moveIfNecessary", "needDecideByTime", "onTouch", "event", "Landroid/view/MotionEvent;", "scrollIfNecessary", "curX", "curY", "scrollRunnableStart", "scrollToRightPositionWhenItemChanged", "setOnItemDragListener", "onItemDragListener", "startDrag", "viewHolder", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "position", "stopDrag", "Companion", "EmptyDragListener", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.b.b */
public final class ItemDragHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f11317a = null;

    /* renamed from: b */
    public static final C2243a f11318b = new C2243a((DefaultConstructorMarker) null);

    /* renamed from: q */
    private static final LogUtil.C2630a f11319q = new LogUtil.C2630a("ItemDragHelper");

    /* renamed from: r */
    private static final int f11320r = -1;

    /* renamed from: c */
    private OnItemDragListener f11321c = new C2244b();

    /* renamed from: d */
    private final DragFloatViewHelper f11322d = new DragFloatViewHelper(this.f11334p);

    /* renamed from: e */
    private boolean f11323e;

    /* renamed from: f */
    private long f11324f;

    /* renamed from: g */
    private int f11325g = f11320r;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RecyclerView f11326h;

    /* renamed from: i */
    private int f11327i = f11320r;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f11328j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f11329k;

    /* renamed from: l */
    private int f11330l;

    /* renamed from: m */
    private long f11331m;

    /* renamed from: n */
    private final C2245c f11332n = new C2245c(this);
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final RecyclerView f11333o;

    /* renamed from: p */
    private final CameraActivity f11334p;

    public ItemDragHelper(@NotNull RecyclerView recyclerView, @NotNull CameraActivity cameraActivity) {
        C3443i.m21155b(recyclerView, "mRecyclerView");
        C3443i.m21155b(cameraActivity, "mActivity");
        this.f11333o = recyclerView;
        this.f11334p = cameraActivity;
    }

    /* renamed from: a */
    public final boolean mo20744a() {
        return this.f11323e;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo27294d2 = {"com/meizu/media/camera/modemove/helper/ItemDragHelper$mScrollRunnable$1", "Ljava/lang/Runnable;", "run", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.b.b$c */
    /* compiled from: ItemDragHelper.kt */
    public static final class C2245c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f11336a;

        /* renamed from: b */
        final /* synthetic */ ItemDragHelper f11337b;

        C2245c(ItemDragHelper bVar) {
            this.f11337b = bVar;
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f11336a, false, 5311, new Class[0], Void.TYPE).isSupported) {
                float[] a = this.f11337b.m12300a(this.f11337b.f11333o, this.f11337b.f11328j, this.f11337b.f11329k);
                ItemDragHelper bVar = this.f11337b;
                RecyclerView d = this.f11337b.f11326h;
                if (d == null) {
                    C3443i.m21151a();
                }
                float[] a2 = bVar.m12300a(d, this.f11337b.f11328j, this.f11337b.f11329k);
                boolean a3 = this.f11337b.m12298a(this.f11337b.f11333o, (int) a[0], (int) a[1]);
                boolean a4 = this.f11337b.m12298a(this.f11337b.f11326h, (int) a2[0], (int) a2[1]);
                if (!this.f11337b.mo20744a()) {
                    return;
                }
                if (a3 || a4) {
                    this.f11337b.m12293a(this.f11337b.f11328j, this.f11337b.f11329k, false);
                    RecyclerView d2 = this.f11337b.f11326h;
                    if (d2 == null) {
                        C3443i.m21151a();
                    }
                    Runnable runnable = this;
                    d2.removeCallbacks(runnable);
                    RecyclerView d3 = this.f11337b.f11326h;
                    if (d3 == null) {
                        C3443i.m21151a();
                    }
                    ViewCompat.postOnAnimation(d3, runnable);
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/helper/ItemDragHelper$EmptyDragListener;", "Lcom/meizu/media/camera/modemove/listener/OnItemDragListener;", "(Lcom/meizu/media/camera/modemove/helper/ItemDragHelper;)V", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.b.b$b */
    /* compiled from: ItemDragHelper.kt */
    private final class C2244b extends OnItemDragListener {
        public C2244b() {
        }
    }

    /* renamed from: a */
    public final void mo20742a(@NotNull BaseViewHolder baseViewHolder, int i) {
        if (!PatchProxy.proxy(new Object[]{baseViewHolder, new Integer(i)}, this, f11317a, false, 5297, new Class[]{BaseViewHolder.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(baseViewHolder, "viewHolder");
            View view = baseViewHolder.itemView;
            C3443i.m21152a((Object) view, "viewHolder.itemView");
            int c = baseViewHolder.mo20731c();
            this.f11321c.mo20750a(baseViewHolder);
            if (this.f11321c.mo20751a(view, c)) {
                this.f11323e = true;
                m12304b();
                this.f11327i = c;
                LogUtil.C2630a aVar = f11319q;
                LogUtil.m15942a(aVar, "startDrag: mLastItemPos " + this.f11327i);
                this.f11321c.mo20756c();
                this.f11322d.mo20739a(view, this.f11328j, this.f11329k, this.f11321c.mo20693a(), i == 0);
                OnItemDragListener aVar2 = this.f11321c;
                View a = this.f11322d.mo20737a();
                if (a == null) {
                    C3443i.m21151a();
                }
                aVar2.mo20749a(a);
                this.f11322d.mo20738a((int) this.f11328j, (int) this.f11329k);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    this.f11330l = view.getHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }

    /* renamed from: b */
    private final void m12304b() {
        this.f11325g = f11320r;
        this.f11326h = null;
    }

    /* renamed from: a */
    public final void mo20743a(@NotNull OnItemDragListener aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f11317a, false, 5298, new Class[]{OnItemDragListener.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(aVar, "onItemDragListener");
            this.f11321c = aVar;
        }
    }

    /* renamed from: a */
    public final boolean mo20745a(@NotNull MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f11317a, false, 5299, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(motionEvent, NotificationCompat.CATEGORY_EVENT);
        float f = (float) 30;
        if (Math.abs(motionEvent.getRawX() - this.f11328j) >= f || Math.abs(motionEvent.getRawY() - this.f11329k) >= f) {
            this.f11324f = System.currentTimeMillis();
        }
        this.f11328j = motionEvent.getRawX();
        this.f11329k = motionEvent.getRawY();
        if (!this.f11323e) {
            return false;
        }
        this.f11322d.mo20738a((int) this.f11328j, (int) this.f11329k);
        m12293a(this.f11328j, this.f11329k, true);
        m12307c();
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3 || motionEvent.getActionMasked() == 4) {
            m12309d();
        }
        return true;
    }

    /* renamed from: c */
    private final void m12307c() {
        if (!PatchProxy.proxy(new Object[0], this, f11317a, false, 5300, new Class[0], Void.TYPE).isSupported && this.f11326h != null) {
            RecyclerView recyclerView = this.f11326h;
            if (recyclerView == null) {
                C3443i.m21151a();
            }
            recyclerView.removeCallbacks(this.f11332n);
            this.f11332n.run();
            RecyclerView recyclerView2 = this.f11326h;
            if (recyclerView2 == null) {
                C3443i.m21151a();
            }
            recyclerView2.invalidate();
        }
    }

    /* renamed from: d */
    private final void m12309d() {
        if (!PatchProxy.proxy(new Object[0], this, f11317a, false, 5301, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11319q, "stop drag");
            if (this.f11323e) {
                OnItemDragListener aVar = this.f11321c;
                RecyclerView recyclerView = this.f11326h;
                if (recyclerView == null) {
                    C3443i.m21151a();
                }
                aVar.mo20694a(recyclerView, this.f11325g, this.f11327i);
                this.f11322d.mo20741b();
            }
            this.f11323e = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12293a(float f, float f2, boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Float(f), new Float(f2), new Byte(z ? (byte) 1 : 0)}, this, f11317a, false, 5302, new Class[]{Float.TYPE, Float.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            float[] a = m12300a(this.f11333o, f, f2);
            View findChildViewUnder = this.f11333o.findChildViewUnder(a[0], a[1]);
            int b = m12303b(findChildViewUnder);
            RecyclerView a2 = m12291a(findChildViewUnder);
            if (b != f11320r && a2 != null) {
                float[] a3 = m12300a(a2, f, f2);
                float f3 = a3[0];
                float f4 = a3[1];
                View findChildViewUnder2 = a2.findChildViewUnder(f3, f4);
                int a4 = m12290a(findChildViewUnder2, f4, this.f11325g, b);
                if (m12305b(this.f11325g, b)) {
                    this.f11325g = b;
                    this.f11326h = a2;
                } else if (m12296a(this.f11325g, b)) {
                    if (z && System.currentTimeMillis() - this.f11324f <= ((long) 500)) {
                        return;
                    }
                    if (a4 != f11320r) {
                        OnItemDragListener aVar = this.f11321c;
                        RecyclerView recyclerView = this.f11326h;
                        if (recyclerView == null) {
                            C3443i.m21151a();
                        }
                        if (aVar.mo20753a(recyclerView, a2, this.f11327i, a4, this.f11334p)) {
                            UsageStatsHelper.m16042a(this.f11334p.getApplicationContext()).mo22691a("mode_setting_change", "value", "2");
                            this.f11325g = b;
                            this.f11326h = a2;
                            this.f11327i = a4;
                            LogUtil.C2630a aVar2 = f11319q;
                            LogUtil.m15942a(aVar2, "after change recyclerView, mLastItemPos = " + this.f11327i);
                            return;
                        }
                        return;
                    }
                }
                if (a4 != f11320r) {
                    if (m12297a(findChildViewUnder2, this.f11327i, a4, f4, f3) && this.f11321c.mo20752a(a2, this.f11327i, a4, this.f11325g)) {
                        RecyclerView.Adapter adapter = a2.getAdapter();
                        if (adapter instanceof BaseItemAdapter) {
                            UsageStatsHelper.m16042a(this.f11334p.getApplicationContext()).mo22691a("mode_setting_change", "value", TextUtils.equals(((BaseItemAdapter) adapter).mo20713a(), "TopRecycler") ? "1" : ExifInterface.GPS_MEASUREMENT_3D);
                        }
                        if (findChildViewUnder2 == null) {
                            C3443i.m21151a();
                        }
                        m12294a(a2, findChildViewUnder2, a4);
                        this.f11327i = a4;
                        LogUtil.C2630a aVar3 = f11319q;
                        LogUtil.m15942a(aVar3, "after change item, mLastItemPos = " + this.f11327i);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final void m12294a(RecyclerView recyclerView, View view, int i) {
        if (!PatchProxy.proxy(new Object[]{recyclerView, view, new Integer(i)}, this, f11317a, false, 5303, new Class[]{RecyclerView.class, View.class, Integer.TYPE}, Void.TYPE).isSupported) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ItemTouchHelper.ViewDropHandler) {
                OrientationHelper createVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
                int decoratedStart = createVerticalHelper.getDecoratedStart(view);
                int decoratedEnd = createVerticalHelper.getDecoratedEnd(view);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (this.f11327i <= i) {
                    decoratedStart = decoratedEnd - this.f11330l;
                }
                linearLayoutManager.scrollToPositionWithOffset(i, decoratedStart);
            }
            if (this.f11327i == 0 || i == 0) {
                recyclerView.scrollToPosition(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final float[] m12300a(RecyclerView recyclerView, float f, float f2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{recyclerView, new Float(f), new Float(f2)}, this, f11317a, false, 5304, new Class[]{RecyclerView.class, Float.TYPE, Float.TYPE}, float[].class);
        if (proxy.isSupported) {
            return (float[]) proxy.result;
        }
        int[] iArr = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        float[] fArr = {f - ((float) iArr[0]), f2 - ((float) iArr[1])};
        fArr[1] = Math.min(Math.max(fArr[1], (float) recyclerView.getPaddingTop()), (float) (recyclerView.getHeight() - recyclerView.getPaddingBottom()));
        return fArr;
    }

    /* renamed from: a */
    private final RecyclerView m12291a(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f11317a, false, 5305, new Class[]{View.class}, RecyclerView.class);
        if (proxy.isSupported) {
            return (RecyclerView) proxy.result;
        }
        if (view == null) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RecyclerView a = m12291a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m12298a(RecyclerView recyclerView, int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{recyclerView, new Integer(i), new Integer(i2)}, this, f11317a, false, 5306, new Class[]{RecyclerView.class, Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f11323e) {
            return false;
        }
        if (recyclerView == null) {
            C3443i.m21151a();
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return false;
        }
        C3443i.m21152a((Object) layoutManager, "recyclerView!!.layoutManager ?: return false");
        int a = layoutManager.canScrollHorizontally() ? this.f11321c.mo20748a((View) recyclerView, i, i2) : 0;
        int b = layoutManager.canScrollVertically() ? this.f11321c.mo20754b(recyclerView, i, i2) : 0;
        if (!(a == 0 && b == 0)) {
            recyclerView.scrollBy(a, b);
        }
        if (a == 0 && b == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final int m12290a(View view, float f, int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, new Float(f), new Integer(i), new Integer(i2)}, this, f11317a, false, 5307, new Class[]{View.class, Float.TYPE, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int b = m12303b(view);
        return (b != f11320r && b == this.f11327i && i == i2) ? f11320r : b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a0 A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m12297a(android.view.View r17, int r18, int r19, float r20, float r21) {
        /*
            r16 = this;
            r7 = r16
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r0 = 5
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r13 = 0
            r1[r13] = r17
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r9)
            r14 = 1
            r1[r14] = r2
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r15 = 2
            r1[r15] = r2
            java.lang.Float r2 = new java.lang.Float
            r2.<init>(r11)
            r3 = 3
            r1[r3] = r2
            java.lang.Float r2 = new java.lang.Float
            r2.<init>(r12)
            r4 = 4
            r1[r4] = r2
            com.meizu.savior.ChangeQuickRedirect r2 = f11317a
            java.lang.Class[] r5 = new java.lang.Class[r0]
            java.lang.Class<android.view.View> r0 = android.view.View.class
            r5[r13] = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            r5[r14] = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            r5[r15] = r0
            java.lang.Class r0 = java.lang.Float.TYPE
            r5[r3] = r0
            java.lang.Class r0 = java.lang.Float.TYPE
            r5[r4] = r0
            java.lang.Class r6 = java.lang.Boolean.TYPE
            r3 = 0
            r4 = 5308(0x14bc, float:7.438E-42)
            r0 = r1
            r1 = r16
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0061
            java.lang.Object r0 = r0.result
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x0061:
            if (r17 == 0) goto L_0x00c0
            int r0 = f11320r
            if (r9 == r0) goto L_0x00c0
            int r0 = f11320r
            if (r10 == r0) goto L_0x00c0
            if (r9 == r10) goto L_0x00c0
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r7.f11331m
            long r0 = r0 - r2
            r2 = 300(0x12c, float:4.2E-43)
            long r2 = (long) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x007c
            goto L_0x00c0
        L_0x007c:
            int r0 = r17.getTop()
            int r1 = r17.getLeft()
            int r2 = r17.getHeight()
            int r3 = r17.getWidth()
            if (r9 >= r10) goto L_0x00a2
            long r3 = java.lang.System.currentTimeMillis()
            r7.f11331m = r3
            float r1 = (float) r1
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x00a0
            int r2 = r2 / r15
            int r0 = r0 + r2
            float r0 = (float) r0
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00bf
        L_0x00a0:
            r13 = 1
            goto L_0x00bf
        L_0x00a2:
            long r4 = java.lang.System.currentTimeMillis()
            r7.f11331m = r4
            int r3 = r3 / r15
            int r1 = r1 + r3
            float r1 = (float) r1
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x00a0
            double r3 = (double) r11
            double r0 = (double) r0
            double r5 = (double) r2
            r8 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            double r5 = r5 * r8
            double r0 = r0 + r5
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00bf
            goto L_0x00a0
        L_0x00bf:
            return r13
        L_0x00c0:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.modemove.p073b.ItemDragHelper.m12297a(android.view.View, int, int, float, float):boolean");
    }

    /* renamed from: b */
    private final int m12303b(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f11317a, false, 5309, new Class[]{View.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (view == null) {
            return f11320r;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                return ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        } catch (Exception e) {
            e.printStackTrace();
            return f11320r;
        }
    }

    /* renamed from: a */
    private final boolean m12296a(int i, int i2) {
        return (i == i2 || i == f11320r || i2 == f11320r) ? false : true;
    }

    /* renamed from: b */
    private final boolean m12305b(int i, int i2) {
        return i == f11320r && i2 != f11320r;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/helper/ItemDragHelper$Companion;", "", "()V", "NONE", "", "getNONE", "()I", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.b.b$a */
    /* compiled from: ItemDragHelper.kt */
    public static final class C2243a {
        private C2243a() {
        }

        public /* synthetic */ C2243a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
