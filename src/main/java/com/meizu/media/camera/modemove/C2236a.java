package com.meizu.media.camera.modemove;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.modemove.adapter.BaseItemAdapter;
import com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder;
import com.meizu.media.camera.modemove.adapter.holder.ViewHolderManager;
import com.meizu.media.camera.modemove.p072a.ImageTextBean;
import com.meizu.media.camera.modemove.p073b.ItemDragHelper;
import com.meizu.media.camera.modemove.p074c.ItemDrag;
import com.meizu.media.camera.modemove.p074c.ItemManager;
import com.meizu.media.camera.modemove.p075d.OnItemDragListener;
import com.meizu.media.camera.modemove.p075d.OnItemLongClickListener;
import com.meizu.media.camera.modemove.p076e.ImageAndTextManager;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.PreferenceUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.C3360h;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u00042345B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020\"J\b\u0010*\u001a\u00020\"H\u0002J\u0006\u0010+\u001a\u00020\bJ\"\u0010,\u001a\u00020\"2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015J\u000e\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u001eJ\u0006\u00101\u001a\u00020\"R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/ModeMoveController;", "", "mActivity", "Lcom/meizu/media/camera/CameraActivity;", "mRootView", "Landroid/view/View;", "(Lcom/meizu/media/camera/CameraActivity;Landroid/view/View;)V", "<set-?>", "", "isShowing", "()Z", "mBaseAdapter", "Lcom/meizu/media/camera/modemove/adapter/BaseItemAdapter;", "mDragHelper", "Lcom/meizu/media/camera/modemove/helper/ItemDragHelper;", "mHintText", "Landroid/widget/TextView;", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mModeMenuAdapter", "mModeMenuData", "", "mModeTypesInModeMenu", "Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "mModeTypesInSlideMenu", "mMoveControl", "Landroid/widget/FrameLayout;", "mMoveMenu", "Landroidx/recyclerview/widget/RecyclerView;", "mMoveStateListener", "Lcom/meizu/media/camera/modemove/ModeMoveController$ModeMoveStateListener;", "mSlideMenuAdapter", "mSlideMenuData", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "getItemList", "", "position", "", "hideModeMove", "initLayout", "isDragging", "setModeList", "modeMoreList", "modeSlideList", "setMoveStateListener", "listener", "showModeMove", "Companion", "ModeMoveStateListener", "OnBaseDragListener", "RecyclerViewManager", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.a */
/* compiled from: ModeMoveController.kt */
public final class C2236a {

    /* renamed from: a */
    public static ChangeQuickRedirect f11263a;

    /* renamed from: b */
    public static final C2237a f11264b = new C2237a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static final LogUtil.C2630a f11265s = new LogUtil.C2630a("ModeMoveController");

    /* renamed from: c */
    private RecyclerView f11266c;

    /* renamed from: d */
    private BaseItemAdapter f11267d;

    /* renamed from: e */
    private List<? extends Object> f11268e;

    /* renamed from: f */
    private List<? extends Object> f11269f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ItemDragHelper f11270g;

    /* renamed from: h */
    private FrameLayout f11271h;

    /* renamed from: i */
    private boolean f11272i;

    /* renamed from: j */
    private C2238b f11273j;

    /* renamed from: k */
    private LinearLayoutManager f11274k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public BaseItemAdapter f11275l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public BaseItemAdapter f11276m;

    /* renamed from: n */
    private List<? extends CameraModeType.ModeType> f11277n = new ArrayList();

    /* renamed from: o */
    private List<? extends CameraModeType.ModeType> f11278o = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TextView f11279p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final CameraActivity f11280q;

    /* renamed from: r */
    private final View f11281r;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/ModeMoveController$ModeMoveStateListener;", "", "enterModeMoveMenu", "", "exitModeMoveMenu", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.a$b */
    /* compiled from: ModeMoveController.kt */
    public interface C2238b {
        /* renamed from: a */
        void mo20691a();

        /* renamed from: b */
        void mo20692b();
    }

    public C2236a(@NotNull CameraActivity cameraActivity, @NotNull View view) {
        C3443i.m21155b(cameraActivity, "mActivity");
        C3443i.m21155b(view, "mRootView");
        this.f11280q = cameraActivity;
        this.f11281r = view;
        m12222f();
    }

    /* renamed from: a */
    public final boolean mo20687a() {
        return this.f11272i;
    }

    /* renamed from: f */
    private final void m12222f() {
        if (!PatchProxy.proxy(new Object[0], this, f11263a, false, 5252, new Class[0], Void.TYPE).isSupported) {
            ViewStub viewStub = (ViewStub) this.f11281r.findViewById(R.id.main_view_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            this.f11271h = (FrameLayout) this.f11281r.findViewById(R.id.mode_move_content);
            FrameLayout frameLayout = this.f11271h;
            if (frameLayout == null) {
                C3443i.m21151a();
            }
            frameLayout.setPadding(0, CameraUtil.m15901h(), 0, 0);
            FrameLayout frameLayout2 = this.f11271h;
            if (frameLayout2 == null) {
                C3443i.m21151a();
            }
            View findViewById = frameLayout2.findViewById(R.id.mode_move_menu);
            if (findViewById != null) {
                this.f11266c = (RecyclerView) findViewById;
                this.f11267d = new BaseItemAdapter();
                BaseItemAdapter baseItemAdapter = this.f11267d;
                if (baseItemAdapter == null) {
                    C3443i.m21151a();
                }
                baseItemAdapter.mo20725b((List<? extends Object>) C3360h.m20960b(new ItemManager(new C2240d()), new ItemManager(new C2240d())));
                this.f11274k = new ModeMoveController$initLayout$1(this, this.f11280q.getApplicationContext(), 1, false);
                RecyclerView recyclerView = this.f11266c;
                if (recyclerView == null) {
                    C3443i.m21151a();
                }
                recyclerView.setLayoutManager(this.f11274k);
                RecyclerView recyclerView2 = this.f11266c;
                if (recyclerView2 == null) {
                    C3443i.m21151a();
                }
                recyclerView2.setAdapter(this.f11267d);
                RecyclerView recyclerView3 = this.f11266c;
                if (recyclerView3 == null) {
                    C3443i.m21151a();
                }
                this.f11270g = new ItemDragHelper(recyclerView3, this.f11280q);
                ItemDragHelper bVar = this.f11270g;
                if (bVar == null) {
                    C3443i.m21151a();
                }
                bVar.mo20743a((OnItemDragListener) new C2239c());
                FrameLayout frameLayout3 = this.f11271h;
                if (frameLayout3 == null) {
                    C3443i.m21151a();
                }
                frameLayout3.setVisibility(8);
                FrameLayout frameLayout4 = this.f11271h;
                if (frameLayout4 == null) {
                    C3443i.m21151a();
                }
                frameLayout4.setClickable(true);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
    }

    /* renamed from: a */
    public final void mo20685a(@NotNull C2238b bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f11263a, false, 5253, new Class[]{C2238b.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar, "listener");
            this.f11273j = bVar;
        }
    }

    /* renamed from: a */
    public final void mo20686a(@NotNull List<? extends CameraModeType.ModeType> list, @NotNull List<? extends CameraModeType.ModeType> list2) {
        Class[] clsArr = {List.class, List.class};
        if (!PatchProxy.proxy(new Object[]{list, list2}, this, f11263a, false, 5254, clsArr, Void.TYPE).isSupported) {
            C3443i.m21155b(list, "modeMoreList");
            C3443i.m21155b(list2, "modeSlideList");
            this.f11277n = list;
            this.f11278o = list2;
        }
    }

    /* renamed from: b */
    public final void mo20688b() {
        if (!PatchProxy.proxy(new Object[0], this, f11263a, false, 5255, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11265s, "showModeMove");
            C2238b bVar = this.f11273j;
            if (bVar == null) {
                C3443i.m21151a();
            }
            bVar.mo20691a();
            FrameLayout frameLayout = this.f11271h;
            if (frameLayout == null) {
                C3443i.m21151a();
            }
            frameLayout.setVisibility(0);
            this.f11272i = true;
        }
    }

    /* renamed from: c */
    public final void mo20689c() {
        if (!PatchProxy.proxy(new Object[0], this, f11263a, false, 5256, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f11265s, "hideModeMove");
            List<? extends Object> list = this.f11268e;
            if (list == null) {
                C3443i.m21151a();
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<? extends Object> list2 = this.f11268e;
                if (list2 == null) {
                    C3443i.m21151a();
                }
                Object obj = list2.get(i);
                if (obj instanceof ImageTextBean) {
                    CameraModeType.ModeType a = ((ImageTextBean) obj).mo20699a();
                    Context context = this.f11280q;
                    if (a == null) {
                        C3443i.m21151a();
                    }
                    PreferenceUtil.m15984d(context, a.toString(), String.valueOf(-100 - i));
                }
            }
            List<? extends Object> list3 = this.f11269f;
            if (list3 == null) {
                C3443i.m21151a();
            }
            int size2 = list3.size();
            for (int i2 = 0; i2 < size2; i2++) {
                List<? extends Object> list4 = this.f11269f;
                if (list4 == null) {
                    C3443i.m21151a();
                }
                Object obj2 = list4.get(i2);
                if (obj2 instanceof ImageTextBean) {
                    CameraModeType.ModeType a2 = ((ImageTextBean) obj2).mo20699a();
                    Context context2 = this.f11280q;
                    if (a2 == null) {
                        C3443i.m21151a();
                    }
                    PreferenceUtil.m15984d(context2, a2.toString(), String.valueOf(i2));
                }
            }
            C2238b bVar = this.f11273j;
            if (bVar == null) {
                C3443i.m21151a();
            }
            bVar.mo20692b();
            FrameLayout frameLayout = this.f11271h;
            if (frameLayout == null) {
                C3443i.m21151a();
            }
            frameLayout.setVisibility(8);
            this.f11272i = false;
        }
    }

    /* renamed from: a */
    public final void mo20684a(@NotNull MotionEvent motionEvent) {
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f11263a, false, 5257, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(motionEvent, NotificationCompat.CATEGORY_EVENT);
            ItemDragHelper bVar = this.f11270g;
            if (bVar == null) {
                C3443i.m21151a();
            }
            bVar.mo20745a(motionEvent);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/ModeMoveController$OnBaseDragListener;", "Lcom/meizu/media/camera/modemove/listener/OnItemDragListener;", "(Lcom/meizu/media/camera/modemove/ModeMoveController;)V", "scale", "", "getScale", "()F", "onDragFinish", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "itemRecyclerPos", "", "itemPos", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.a$c */
    /* compiled from: ModeMoveController.kt */
    public final class C2239c extends OnItemDragListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f11282a;

        public C2239c() {
        }

        /* renamed from: a */
        public float mo20693a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11282a, false, 5260, new Class[0], Float.TYPE);
            return proxy.isSupported ? ((Float) proxy.result).floatValue() : super.mo20693a();
        }

        /* renamed from: a */
        public void mo20694a(@NotNull RecyclerView recyclerView, int i, int i2) {
            if (!PatchProxy.proxy(new Object[]{recyclerView, new Integer(i), new Integer(i2)}, this, f11282a, false, 5261, new Class[]{RecyclerView.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                C3443i.m21155b(recyclerView, "recyclerView");
                super.mo20694a(recyclerView, i, i2);
                LogUtil.m15942a(C2236a.f11265s, "onDragFinish");
                if (C2236a.this.f11279p != null) {
                    TextView a = C2236a.this.f11279p;
                    if (a == null) {
                        C3443i.m21151a();
                    }
                    a.setText(C2236a.this.f11280q.getResources().getString(R.string.mz_mode_move_show_in_slide_menu_hint));
                }
                BaseItemAdapter c = C2236a.this.f11276m;
                if (c == null) {
                    C3443i.m21151a();
                }
                c.mo20724b();
                BaseItemAdapter d = C2236a.this.f11275l;
                if (d == null) {
                    C3443i.m21151a();
                }
                d.mo20724b();
            }
        }
    }

    /* renamed from: d */
    public final boolean mo20690d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11263a, false, 5258, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11270g == null) {
            return false;
        }
        ItemDragHelper bVar = this.f11270g;
        if (bVar == null) {
            C3443i.m21151a();
        }
        return bVar.mo20744a();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/ModeMoveController$RecyclerViewManager;", "Lcom/meizu/media/camera/modemove/adapter/holder/ViewHolderManager;", "(Lcom/meizu/media/camera/modemove/ModeMoveController;)V", "itemLayoutId", "", "getItemLayoutId", "()I", "onBindViewHolder", "", "holder", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "data", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.a$d */
    /* compiled from: ModeMoveController.kt */
    public final class C2240d extends ViewHolderManager {

        /* renamed from: a */
        public static ChangeQuickRedirect f11284a;

        /* renamed from: a */
        public int mo20695a() {
            return R.layout.move_item_recycler_view;
        }

        public C2240d() {
            LogUtil.C2630a e = C2236a.f11265s;
            LogUtil.m15942a(e, "init ViewManager, " + this);
        }

        @NotNull
        /* renamed from: a */
        public BaseViewHolder mo20696a(@NotNull ViewGroup viewGroup) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup}, this, f11284a, false, 5262, new Class[]{ViewGroup.class}, BaseViewHolder.class);
            if (proxy.isSupported) {
                return (BaseViewHolder) proxy.result;
            }
            C3443i.m21155b(viewGroup, "parent");
            Context f = C2236a.this.f11280q.mo17639f();
            C3443i.m21152a((Object) f, "mActivity.resourcesContext");
            return new BaseViewHolder(mo20732a(viewGroup, f));
        }

        /* renamed from: a */
        public void mo20697a(@NotNull BaseViewHolder baseViewHolder, @NotNull Object obj, int i) {
            int i2;
            int i3 = 3;
            Object[] objArr = {baseViewHolder, obj, new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f11284a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5263, new Class[]{BaseViewHolder.class, Object.class, Integer.TYPE}, Void.TYPE).isSupported) {
                C3443i.m21155b(baseViewHolder, "holder");
                C3443i.m21155b(obj, "data");
                View view = baseViewHolder.itemView;
                C3443i.m21152a((Object) view, "holder.itemView");
                view.getLayoutParams().width = -1;
                BaseItemAdapter baseItemAdapter = new BaseItemAdapter();
                RecyclerView.ViewHolder viewHolder = baseViewHolder;
                View a = mo20733a(viewHolder, (int) R.id.item_group_recycler);
                if (a != null) {
                    RecyclerView recyclerView = (RecyclerView) a;
                    View a2 = mo20733a(viewHolder, (int) R.id.item_group_layout);
                    if (a2 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) a2;
                        if (i == 0) {
                            i2 = 0;
                        } else {
                            i2 = C2236a.this.f11280q.getResources().getColor(R.color.mz_mode_move_bottom_view_bg);
                        }
                        relativeLayout.setBackgroundColor(i2);
                        C2236a aVar = C2236a.this;
                        View a3 = mo20733a(viewHolder, (int) R.id.mode_move_hint);
                        if (a3 != null) {
                            aVar.f11279p = (TextView) a3;
                            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                            if (layoutParams != null) {
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                                if (i == 1) {
                                    C2236a.this.f11276m = baseItemAdapter;
                                    TextView a4 = C2236a.this.f11279p;
                                    if (a4 == null) {
                                        C3443i.m21151a();
                                    }
                                    a4.setText(C2236a.this.f11280q.getResources().getString(R.string.mz_mode_move_show_in_slide_menu_hint));
                                    TextView a5 = C2236a.this.f11279p;
                                    if (a5 == null) {
                                        C3443i.m21151a();
                                    }
                                    a5.setVisibility(0);
                                    Context f = C2236a.this.f11280q.mo17639f();
                                    C3443i.m21152a((Object) f, "mActivity.resourcesContext");
                                    layoutParams2.leftMargin = f.getResources().getDimensionPixelOffset(R.dimen.mz_mode_move_bottom_view_margin);
                                    layoutParams2.rightMargin = layoutParams2.leftMargin;
                                    Context f2 = C2236a.this.f11280q.mo17639f();
                                    C3443i.m21152a((Object) f2, "mActivity.resourcesContext");
                                    layoutParams2.bottomMargin = f2.getResources().getDimensionPixelOffset(R.dimen.mz_mode_move_bottom_view_margin_bottom);
                                    ViewGroup.LayoutParams layoutParams3 = relativeLayout.getLayoutParams();
                                    if (layoutParams3 != null) {
                                        RecyclerView.LayoutParams layoutParams4 = (RecyclerView.LayoutParams) layoutParams3;
                                        if (DeviceHelper.f13874aa) {
                                            layoutParams4.height = CameraUtil.m15897f();
                                        } else {
                                            Context f3 = C2236a.this.f11280q.mo17639f();
                                            C3443i.m21152a((Object) f3, "mActivity.resourcesContext");
                                            layoutParams4.topMargin = f3.getResources().getDimensionPixelOffset(R.dimen.mz_mode_move_bottom_view_margin_top);
                                        }
                                        relativeLayout.setLayoutParams(layoutParams4);
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                                    }
                                } else {
                                    Context f4 = C2236a.this.f11280q.mo17639f();
                                    C3443i.m21152a((Object) f4, "mActivity.resourcesContext");
                                    int dimensionPixelOffset = f4.getResources().getDimensionPixelOffset(R.dimen.mz_mode_menu_padding_left);
                                    Context f5 = C2236a.this.f11280q.mo17639f();
                                    C3443i.m21152a((Object) f5, "mActivity.resourcesContext");
                                    int dimensionPixelOffset2 = f5.getResources().getDimensionPixelOffset(R.dimen.mz_mode_menu_padding_right);
                                    Context f6 = C2236a.this.f11280q.mo17639f();
                                    C3443i.m21152a((Object) f6, "mActivity.resourcesContext");
                                    recyclerView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, f6.getResources().getDimensionPixelOffset(R.dimen.mz_mode_menu_padding_bottom));
                                    baseItemAdapter.mo20721a("TopRecycler");
                                    C2236a.this.f11275l = baseItemAdapter;
                                }
                                recyclerView.setLayoutParams(layoutParams2);
                                Context context = view.getContext();
                                if (i != 0) {
                                    i3 = 4;
                                }
                                ModeMoveController modeMoveController$RecyclerViewManager$onBindViewHolder$gridLayoutManager$1 = new ModeMoveController(view, i, context, i3);
                                recyclerView.setLayoutManager(modeMoveController$RecyclerViewManager$onBindViewHolder$gridLayoutManager$1);
                                baseItemAdapter.mo20718a((ViewHolderManager) new ImageAndTextManager(C2236a.this.f11280q, modeMoveController$RecyclerViewManager$onBindViewHolder$gridLayoutManager$1.getSpanCount()));
                                baseItemAdapter.mo20722a((List<Object>) C2236a.this.m12212a(i));
                                recyclerView.setAdapter(baseItemAdapter);
                                baseItemAdapter.mo20720a((OnItemLongClickListener) new C2241a(this, baseItemAdapter, i));
                                return;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
                }
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
        }

        @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, mo27294d2 = {"com/meizu/media/camera/modemove/ModeMoveController$RecyclerViewManager$onBindViewHolder$1", "Lcom/meizu/media/camera/modemove/listener/OnItemLongClickListener;", "onItemLongClick", "", "viewHolder", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
        /* renamed from: com.meizu.media.camera.modemove.a$d$a */
        /* compiled from: ModeMoveController.kt */
        public static final class C2241a extends OnItemLongClickListener {

            /* renamed from: a */
            public static ChangeQuickRedirect f11286a;

            /* renamed from: b */
            final /* synthetic */ C2240d f11287b;

            /* renamed from: c */
            final /* synthetic */ BaseItemAdapter f11288c;

            /* renamed from: d */
            final /* synthetic */ int f11289d;

            C2241a(C2240d dVar, BaseItemAdapter baseItemAdapter, int i) {
                this.f11287b = dVar;
                this.f11288c = baseItemAdapter;
                this.f11289d = i;
            }

            /* renamed from: a */
            public void mo20698a(@NotNull BaseViewHolder baseViewHolder) {
                if (!PatchProxy.proxy(new Object[]{baseViewHolder}, this, f11286a, false, 5264, new Class[]{BaseViewHolder.class}, Void.TYPE).isSupported) {
                    C3443i.m21155b(baseViewHolder, "viewHolder");
                    ItemDragHelper e = C2236a.this.f11270g;
                    if (e == null) {
                        C3443i.m21151a();
                    }
                    if (!e.mo20744a() && C2236a.this.mo20687a()) {
                        ItemDrag bVar = (ItemDrag) baseViewHolder.mo20730b();
                        if (bVar == null) {
                            C3443i.m21151a();
                        }
                        if (!bVar.mo20709e() && C2236a.this.f11279p != null) {
                            TextView a = C2236a.this.f11279p;
                            if (a == null) {
                                C3443i.m21151a();
                            }
                            a.setText(C2236a.this.f11280q.getResources().getString(R.string.mz_mode_move_disable_in_slide_menu_hint));
                        }
                        if (bVar.mo20703b() && bVar.mo20707d()) {
                            if (C3443i.m21154a((Object) this.f11288c, (Object) C2236a.this.f11275l)) {
                                BaseItemAdapter c = C2236a.this.f11276m;
                                if (c == null) {
                                    C3443i.m21151a();
                                }
                                c.mo20719a(bVar, true);
                            } else {
                                BaseItemAdapter d = C2236a.this.f11275l;
                                if (d == null) {
                                    C3443i.m21151a();
                                }
                                d.mo20719a(bVar, false);
                            }
                        }
                        ItemDragHelper e2 = C2236a.this.f11270g;
                        if (e2 == null) {
                            C3443i.m21151a();
                        }
                        e2.mo20742a(baseViewHolder, this.f11289d);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final List<Object> m12212a(int i) {
        int i2 = i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i2)}, this, f11263a, false, 5259, new Class[]{Integer.TYPE}, List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        List<? extends CameraModeType.ModeType> list = i2 == 0 ? this.f11277n : this.f11278o;
        ArrayList arrayList = new ArrayList();
        for (CameraModeType.ModeType modeType : list) {
            ImageTextBean aVar = new ImageTextBean(modeType, true, true, true, true);
            int txtId = modeType.getTxtId();
            if (txtId != R.string.mz_cam_mode_amazing) {
                if (txtId != R.string.mz_cam_mode_auto) {
                    if (txtId != R.string.mz_cam_mode_bar_code) {
                        if (txtId != R.string.video_camera_label) {
                            arrayList.add(aVar);
                        }
                    }
                }
                aVar.mo20701a(false);
                aVar.mo20704c(false);
                aVar.mo20702b(false);
                aVar.mo20708e(true);
                arrayList.add(aVar);
            }
            aVar.mo20702b(false);
            aVar.mo20706d(false);
            arrayList.add(aVar);
        }
        if (i2 == 0) {
            this.f11268e = arrayList;
        } else {
            this.f11269f = arrayList;
        }
        return arrayList;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/ModeMoveController$Companion;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.a$a */
    /* compiled from: ModeMoveController.kt */
    public static final class C2237a {
        private C2237a() {
        }

        public /* synthetic */ C2237a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
