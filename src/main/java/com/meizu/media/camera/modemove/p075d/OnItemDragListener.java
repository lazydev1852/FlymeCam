package com.meizu.media.camera.modemove.p075d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.modemove.adapter.BaseItemAdapter;
import com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder;
import com.meizu.media.camera.modemove.p073b.DragFloatViewHelper;
import com.meizu.media.camera.modemove.p074c.ItemData;
import com.meizu.media.camera.modemove.p074c.ItemDrag;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eJ\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u000eH\u0002J\u0018\u00100\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0002J\u0018\u00102\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0002J\u001e\u00104\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eJ\u0014\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u00107\u001a\u00020\u0001H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u00107\u001a\u00020\u0001H\u0002J\u0012\u0010=\u001a\u00020;2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0002J \u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000eH\u0016J\u0006\u0010D\u001a\u00020?J\u000e\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020*J&\u0010G\u001a\u00020;2\u0006\u0010@\u001a\u00020A2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000eJ\u0016\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020\u000eJ.\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020TJ(\u0010U\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020YH\u0002J\u000e\u0010[\u001a\u00020?2\u0006\u0010\\\u001a\u00020]R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u0011\u0010 \u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\fR\u0014\u0010\"\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\fR\u0014\u0010$\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0010¨\u0006_"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/listener/OnItemDragListener;", "", "()V", "helper", "Lcom/meizu/media/camera/modemove/helper/DragFloatViewHelper;", "getHelper", "()Lcom/meizu/media/camera/modemove/helper/DragFloatViewHelper;", "setHelper", "(Lcom/meizu/media/camera/modemove/helper/DragFloatViewHelper;)V", "horizontalLimit", "", "getHorizontalLimit", "()F", "horizontalScrollMaxSpeed", "", "getHorizontalScrollMaxSpeed", "()I", "mDragItemData", "Lcom/meizu/media/camera/modemove/item/ItemData;", "getMDragItemData", "()Lcom/meizu/media/camera/modemove/item/ItemData;", "setMDragItemData", "(Lcom/meizu/media/camera/modemove/item/ItemData;)V", "mScrollAnimator", "Landroid/animation/ValueAnimator;", "getMScrollAnimator", "()Landroid/animation/ValueAnimator;", "setMScrollAnimator", "(Landroid/animation/ValueAnimator;)V", "mToItemData", "getMToItemData", "setMToItemData", "moveLimit", "getMoveLimit", "scale", "getScale", "verticalLimit", "getVerticalLimit", "verticalScrollMaxSpeed", "getVerticalScrollMaxSpeed", "calcHorizontalScrollDistance", "view", "Landroid/view/View;", "touchX", "touchY", "calcScrollDistance", "touchLevel", "maxSpeed", "calcScrollHorizontalDirect", "viewWidth", "calcScrollVerticalDirect", "viewHeight", "calcVerticalScrollDistance", "getItemDrag", "Lcom/meizu/media/camera/modemove/item/ItemDrag;", "itemData", "getLocationInWindow", "", "isItemCanChangeRecycler", "", "isItemCanDrag", "isItemCanMove", "onDragFinish", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerPos", "itemPos", "onDragStart", "onDrawFloatView", "floatView", "onItemChanged", "fromPos", "toPos", "recyclerViewPos", "onItemSelected", "selectedView", "selectedPos", "onRecyclerChanged", "fromView", "toView", "itemFromPos", "itemToPos", "activity", "Lcom/meizu/media/camera/CameraActivity;", "scrollAnimate", "listener", "Landroid/animation/Animator$AnimatorListener;", "startLoc", "Landroid/graphics/Point;", "endLoc", "setItemViewHolder", "viewHolder", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.d.a */
public abstract class OnItemDragListener {

    /* renamed from: c */
    public static ChangeQuickRedirect f11339c;

    /* renamed from: d */
    public static final C2246a f11340d = new C2246a((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: a */
    private ItemData f11341a;
    @Nullable

    /* renamed from: b */
    private ItemData f11342b;
    @Nullable

    /* renamed from: e */
    private DragFloatViewHelper f11343e;
    @Nullable

    /* renamed from: f */
    private ValueAnimator f11344f;

    /* renamed from: a */
    private final int m12321a(float f, int i) {
        if (f > ((float) 1)) {
            f = 1.0f;
        }
        return (int) (f * ((float) i));
    }

    /* renamed from: a */
    public float mo20693a() {
        return 1.1f;
    }

    /* renamed from: c */
    public final void mo20756c() {
    }

    /* renamed from: d */
    private final int m12329d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11339c, false, 5312, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) (((float) 15) / mo20693a());
    }

    /* renamed from: e */
    private final int m12331e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11339c, false, 5313, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) (((float) 10) / mo20693a());
    }

    /* renamed from: f */
    private final float m12332f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11339c, false, 5314, new Class[0], Float.TYPE);
        return proxy.isSupported ? ((Float) proxy.result).floatValue() : 100.0f / mo20693a();
    }

    /* renamed from: g */
    private final float m12333g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11339c, false, 5315, new Class[0], Float.TYPE);
        return proxy.isSupported ? ((Float) proxy.result).floatValue() : 200.0f / mo20693a();
    }

    @Nullable
    /* renamed from: b */
    public final DragFloatViewHelper mo20755b() {
        return this.f11343e;
    }

    /* renamed from: a */
    public void mo20694a(@NotNull RecyclerView recyclerView, int i, int i2) {
        ValueAnimator valueAnimator;
        Object[] objArr = {recyclerView, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11339c;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5316, new Class[]{RecyclerView.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(recyclerView, "recyclerView");
            ItemData aVar = this.f11341a;
            if (aVar == null) {
                C3443i.m21151a();
            }
            aVar.mo20700a(0);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition != null) {
                View view = findViewHolderForAdapterPosition.itemView;
                C3443i.m21152a((Object) view, "holder.itemView");
                view.setVisibility(0);
            }
            if (this.f11344f != null) {
                ValueAnimator valueAnimator2 = this.f11344f;
                if (valueAnimator2 == null) {
                    C3443i.m21151a();
                }
                if (valueAnimator2.isRunning() && (valueAnimator = this.f11344f) != null) {
                    valueAnimator.end();
                }
            }
            this.f11343e = null;
        }
    }

    /* renamed from: a */
    public final void mo20750a(@NotNull BaseViewHolder baseViewHolder) {
        if (!PatchProxy.proxy(new Object[]{baseViewHolder}, this, f11339c, false, 5317, new Class[]{BaseViewHolder.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(baseViewHolder, "viewHolder");
            Object b = baseViewHolder.mo20730b();
            if (b instanceof ItemData) {
                this.f11341a = (ItemData) b;
                return;
            }
            throw new IllegalArgumentException("item dates should implement ItemData!");
        }
    }

    /* renamed from: a */
    public final boolean mo20753a(@NotNull RecyclerView recyclerView, @NotNull RecyclerView recyclerView2, int i, int i2, @NotNull CameraActivity cameraActivity) {
        Object b;
        Object[] objArr = {recyclerView, recyclerView2, new Integer(i), new Integer(i2), cameraActivity};
        ChangeQuickRedirect changeQuickRedirect = f11339c;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5318, new Class[]{RecyclerView.class, RecyclerView.class, Integer.TYPE, Integer.TYPE, CameraActivity.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(recyclerView, "fromView");
        C3443i.m21155b(recyclerView2, "toView");
        C3443i.m21155b(cameraActivity, PushConstants.INTENT_ACTIVITY_NAME);
        ItemData aVar = this.f11341a;
        if (aVar == null) {
            C3443i.m21151a();
        }
        if (!m12324a((Object) aVar)) {
            return false;
        }
        BaseItemAdapter baseItemAdapter = (BaseItemAdapter) recyclerView2.getAdapter();
        BaseItemAdapter baseItemAdapter2 = (BaseItemAdapter) recyclerView.getAdapter();
        if (baseItemAdapter == null || baseItemAdapter2 == null || (b = baseItemAdapter.mo20723b(i2)) == null || !m12326b(b) || !m12324a(b)) {
            return false;
        }
        if (b instanceof ItemData) {
            this.f11342b = (ItemData) b;
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (!(layoutManager == null || layoutManager2 == null)) {
                View findViewByPosition = layoutManager.findViewByPosition(i2);
                View findViewByPosition2 = layoutManager2.findViewByPosition(i);
                if (!(findViewByPosition == null || findViewByPosition2 == null)) {
                    if (this.f11343e == null) {
                        this.f11343e = new DragFloatViewHelper(cameraActivity);
                    } else if (this.f11344f != null) {
                        ValueAnimator valueAnimator = this.f11344f;
                        if (valueAnimator == null) {
                            C3443i.m21151a();
                        }
                        if (valueAnimator.isRunning()) {
                            ValueAnimator valueAnimator2 = this.f11344f;
                            if (valueAnimator2 == null) {
                                C3443i.m21151a();
                            }
                            valueAnimator2.end();
                            return false;
                        }
                    }
                    View findViewById = findViewByPosition.findViewById(R.id.mz_mode_menu_item_shadow_inside);
                    View findViewById2 = findViewByPosition2.findViewById(R.id.mz_mode_menu_item_shadow_inside);
                    C3443i.m21152a((Object) findViewById, "toItemViewInside");
                    int[] b2 = m12327b(findViewById);
                    C3443i.m21152a((Object) findViewById2, "fromItemViewInside");
                    int[] b3 = m12327b(findViewById2);
                    baseItemAdapter.mo20714a(i2);
                    ItemData aVar2 = this.f11341a;
                    if (aVar2 == null) {
                        C3443i.m21151a();
                    }
                    baseItemAdapter.mo20716a(i2, (Object) aVar2, false);
                    C2247b bVar = new C2247b(this, baseItemAdapter2, i, b);
                    DragFloatViewHelper aVar3 = this.f11343e;
                    if (aVar3 == null) {
                        C3443i.m21151a();
                    }
                    aVar3.mo20740a(findViewById, 0, 0, 1.0f);
                    DragFloatViewHelper aVar4 = this.f11343e;
                    if (aVar4 == null) {
                        C3443i.m21151a();
                    }
                    m12323a(aVar4, (Animator.AnimatorListener) bVar, new Point(b2[0], b2[1]), new Point(b3[0], b3[1]));
                }
            }
        }
        return true;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo27294d2 = {"com/meizu/media/camera/modemove/listener/OnItemDragListener$onRecyclerChanged$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.d.a$b */
    /* compiled from: OnItemDragListener.kt */
    public static final class C2247b implements Animator.AnimatorListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11345a;

        /* renamed from: b */
        final /* synthetic */ OnItemDragListener f11346b;

        /* renamed from: c */
        final /* synthetic */ BaseItemAdapter f11347c;

        /* renamed from: d */
        final /* synthetic */ int f11348d;

        /* renamed from: e */
        final /* synthetic */ Object f11349e;

        public void onAnimationCancel(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f11345a, false, 5333, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        public void onAnimationRepeat(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f11345a, false, 5334, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        public void onAnimationStart(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f11345a, false, 5331, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
            }
        }

        C2247b(OnItemDragListener aVar, BaseItemAdapter baseItemAdapter, int i, Object obj) {
            this.f11346b = aVar;
            this.f11347c = baseItemAdapter;
            this.f11348d = i;
            this.f11349e = obj;
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f11345a, false, 5332, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(animator, "animation");
                this.f11347c.mo20714a(this.f11348d);
                this.f11347c.mo20716a(this.f11348d, this.f11349e, true);
                DragFloatViewHelper b = this.f11346b.mo20755b();
                if (b != null) {
                    b.mo20741b();
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo20751a(@NotNull View view, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, new Integer(i)}, this, f11339c, false, 5319, new Class[]{View.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(view, "selectedView");
        ItemData aVar = this.f11341a;
        if (aVar == null) {
            C3443i.m21151a();
        }
        if (m12328c(aVar)) {
            ItemData aVar2 = this.f11341a;
            if (aVar2 == null) {
                C3443i.m21151a();
            }
            aVar2.mo20700a(4);
            view.setVisibility(4);
        }
        ItemData aVar3 = this.f11341a;
        if (aVar3 == null) {
            C3443i.m21151a();
        }
        return m12328c(aVar3);
    }

    /* renamed from: a */
    public final boolean mo20752a(@NotNull RecyclerView recyclerView, int i, int i2, int i3) {
        Object[] objArr = {recyclerView, new Integer(i), new Integer(i2), new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect = f11339c;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5320, new Class[]{RecyclerView.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(recyclerView, "recyclerView");
        BaseItemAdapter baseItemAdapter = (BaseItemAdapter) recyclerView.getAdapter();
        if (baseItemAdapter == null || !m12326b(baseItemAdapter.mo20723b(i2))) {
            return false;
        }
        baseItemAdapter.mo20715a(i, i2);
        return true;
    }

    /* renamed from: a */
    private final boolean m12324a(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f11339c, false, 5321, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ItemDrag d = m12330d(obj);
        if (d == null || d.mo20705c()) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private final boolean m12326b(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f11339c, false, 5322, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ItemDrag d = m12330d(obj);
        if (d == null || d.mo20703b()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private final boolean m12328c(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f11339c, false, 5323, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ItemDrag d = m12330d(obj);
        if (d == null || d.mo20707d()) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private final ItemDrag m12330d(Object obj) {
        if (obj instanceof ItemDrag) {
            return (ItemDrag) obj;
        }
        return null;
    }

    /* renamed from: a */
    public final int mo20748a(@NotNull View view, int i, int i2) {
        Object[] objArr = {view, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11339c;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5324, new Class[]{View.class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(view, "view");
        int a = m12322a(i, view.getWidth());
        if (a < 0) {
            return -m12321a((m12332f() - ((float) i)) / m12332f(), m12329d());
        }
        if (a > 0) {
            return m12321a((((float) (i - view.getWidth())) + m12332f()) / m12332f(), m12329d());
        }
        return 0;
    }

    /* renamed from: b */
    public final int mo20754b(@NotNull View view, int i, int i2) {
        Object[] objArr = {view, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11339c;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5325, new Class[]{View.class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C3443i.m21155b(view, "view");
        int b = m12325b(i2, view.getHeight());
        if (b < 0) {
            return -m12321a((m12333g() - ((float) i2)) / m12333g(), m12331e());
        }
        if (b > 0) {
            return m12321a((((float) (i2 - view.getHeight())) + m12333g()) / m12333g(), m12331e());
        }
        return 0;
    }

    /* renamed from: a */
    private final int m12322a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f11339c, false, 5326, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        float f = (float) i;
        if (f < m12332f()) {
            return -1;
        }
        return f > ((float) i2) - m12332f() ? 1 : 0;
    }

    /* renamed from: b */
    private final int m12325b(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f11339c, false, 5327, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        float f = (float) i;
        if (f < m12333g()) {
            return -1;
        }
        return f > ((float) i2) - m12333g() ? 1 : 0;
    }

    /* renamed from: a */
    public final void mo20749a(@NotNull View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f11339c, false, 5328, new Class[]{View.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(view, "floatView");
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.9f);
            view.setAlpha(1.0f);
        }
    }

    /* renamed from: b */
    private final int[] m12327b(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f11339c, false, 5329, new Class[]{View.class}, int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    /* renamed from: a */
    private final void m12323a(DragFloatViewHelper aVar, Animator.AnimatorListener animatorListener, Point point, Point point2) {
        if (!PatchProxy.proxy(new Object[]{aVar, animatorListener, point, point2}, this, f11339c, false, 5330, new Class[]{DragFloatViewHelper.class, Animator.AnimatorListener.class, Point.class, Point.class}, Void.TYPE).isSupported) {
            if (point.x != point2.x) {
                this.f11344f = ValueAnimator.ofFloat(new float[]{(float) point.x, (float) point2.x});
                float f = (((float) point.y) - ((float) point2.y)) / ((float) (point.x - point2.x));
                float f2 = ((float) point.y) - (((float) point.x) * f);
                ValueAnimator valueAnimator = this.f11344f;
                if (valueAnimator != null) {
                    valueAnimator.addUpdateListener(new C2248c(f, f2, aVar));
                }
            } else {
                this.f11344f = ValueAnimator.ofFloat(new float[]{(float) point.y, (float) point2.y});
                ValueAnimator valueAnimator2 = this.f11344f;
                if (valueAnimator2 != null) {
                    valueAnimator2.addUpdateListener(new C2249d(aVar, point));
                }
            }
            ValueAnimator valueAnimator3 = this.f11344f;
            if (valueAnimator3 != null) {
                valueAnimator3.setDuration(300);
            }
            ValueAnimator valueAnimator4 = this.f11344f;
            if (valueAnimator4 != null) {
                valueAnimator4.addListener(animatorListener);
            }
            ValueAnimator valueAnimator5 = this.f11344f;
            if (valueAnimator5 != null) {
                valueAnimator5.start();
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.d.a$c */
    /* compiled from: OnItemDragListener.kt */
    static final class C2248c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11350a;

        /* renamed from: b */
        final /* synthetic */ float f11351b;

        /* renamed from: c */
        final /* synthetic */ float f11352c;

        /* renamed from: d */
        final /* synthetic */ DragFloatViewHelper f11353d;

        C2248c(float f, float f2, DragFloatViewHelper aVar) {
            this.f11351b = f;
            this.f11352c = f2;
            this.f11353d = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f11350a, false, 5335, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                C3443i.m21152a((Object) valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    this.f11353d.mo20738a((int) floatValue, (int) ((this.f11351b * floatValue) + this.f11352c));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.d.a$d */
    /* compiled from: OnItemDragListener.kt */
    static final class C2249d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11354a;

        /* renamed from: b */
        final /* synthetic */ DragFloatViewHelper f11355b;

        /* renamed from: c */
        final /* synthetic */ Point f11356c;

        C2249d(DragFloatViewHelper aVar, Point point) {
            this.f11355b = aVar;
            this.f11356c = point;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f11354a, false, 5336, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                C3443i.m21152a((Object) valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    this.f11355b.mo20738a(this.f11356c.x, (int) ((Float) animatedValue).floatValue());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/listener/OnItemDragListener$Companion;", "", "()V", "sHorizontalLimit", "", "sHorizontalScrollMaxSpeed", "", "sVerticalLimit", "sVerticalScrollMaxSpeed", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.d.a$a */
    /* compiled from: OnItemDragListener.kt */
    public static final class C2246a {
        private C2246a() {
        }

        public /* synthetic */ C2246a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
