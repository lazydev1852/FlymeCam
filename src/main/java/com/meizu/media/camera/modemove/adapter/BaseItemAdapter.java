package com.meizu.media.camera.modemove.adapter;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder;
import com.meizu.media.camera.modemove.adapter.holder.ViewHolderManager;
import com.meizu.media.camera.modemove.p072a.ImageTextBean;
import com.meizu.media.camera.modemove.p074c.ItemDrag;
import com.meizu.media.camera.modemove.p074c.ItemManager;
import com.meizu.media.camera.modemove.p075d.OnItemLongClickListener;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.C3360h;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0011J&\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0014\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019J&\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0013J\u0014\u0010*\u001a\u00020\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010+\u001a\u00020\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u000e\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0005J\u000e\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\rJ\u0016\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/adapter/BaseItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "()V", "mAdapterTag", "", "mCurrentViewType", "", "mDataItems", "", "", "mHolderManagers", "Landroid/util/SparseArray;", "Lcom/meizu/media/camera/modemove/adapter/holder/ViewHolderManager;", "mItemLongClickListener", "Lcom/meizu/media/camera/modemove/listener/OnItemLongClickListener;", "mSetFromOutSide", "", "addDataItem", "", "position", "item", "notifyAll", "addDataItems", "items", "", "addItem", "getItem", "getItemCount", "getItemViewType", "getTag", "moveDataItem", "fromPosition", "toPosition", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeDataItem", "resetItemIcon", "setDataItems", "setItem", "dataItems", "setItemLongClickListener", "itemLongClickListener", "setTag", "tag", "setViewHolderManager", "holderManager", "updateItemIcon", "itemDrag", "Lcom/meizu/media/camera/modemove/item/ItemDrag;", "updateSlideList", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: BaseItemAdapter.kt */
public final class BaseItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    /* renamed from: a */
    public static ChangeQuickRedirect f11297a;

    /* renamed from: b */
    public static final C2242a f11298b = new C2242a((DefaultConstructorMarker) null);

    /* renamed from: i */
    private static final LogUtil.C2630a f11299i = new LogUtil.C2630a("BaseItemAdapter");

    /* renamed from: c */
    private List<Object> f11300c = new ArrayList();

    /* renamed from: d */
    private OnItemLongClickListener f11301d;

    /* renamed from: e */
    private final SparseArray<ViewHolderManager> f11302e = new SparseArray<>();

    /* renamed from: f */
    private int f11303f = -1;

    /* renamed from: g */
    private boolean f11304g;

    /* renamed from: h */
    private String f11305h;

    /* renamed from: a */
    public final void mo20718a(@NotNull ViewHolderManager aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f11297a, false, 5265, new Class[]{ViewHolderManager.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(aVar, "holderManager");
            LogUtil.C2630a aVar2 = f11299i;
            LogUtil.m15942a(aVar2, "init holderManager in setViewHolderManager, " + aVar);
            this.f11302e.put(0, aVar);
            this.f11304g = true;
        }
    }

    /* renamed from: a */
    public final void mo20721a(@NotNull String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f11297a, false, 5266, new Class[]{String.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(str, "tag");
            this.f11305h = str;
        }
    }

    @Nullable
    /* renamed from: a */
    public final String mo20713a() {
        return this.f11305h;
    }

    /* renamed from: a */
    public final void mo20720a(@NotNull OnItemLongClickListener bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f11297a, false, 5267, new Class[]{OnItemLongClickListener.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar, "itemLongClickListener");
            this.f11301d = bVar;
        }
    }

    /* renamed from: a */
    public final void mo20722a(@NotNull List<Object> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f11297a, false, 5268, new Class[]{List.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(list, "mDataItems");
            mo20726c(list);
        }
    }

    /* renamed from: a */
    public final void mo20716a(int i, @NotNull Object obj, boolean z) {
        Object[] objArr = {new Integer(i), obj, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11297a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5269, new Class[]{Integer.TYPE, Object.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(obj, "item");
            m12251a(i, (List<? extends Object>) C3360h.m20955a(obj), z);
        }
    }

    /* renamed from: b */
    public final void mo20725b(@NotNull List<? extends Object> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f11297a, false, 5270, new Class[]{List.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(list, "items");
            m12251a(this.f11300c.size(), list, false);
        }
    }

    /* renamed from: a */
    private final void m12251a(int i, List<? extends Object> list, boolean z) {
        Object[] objArr = {new Integer(i), list, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11297a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5271, new Class[]{Integer.TYPE, List.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            m12252b(i, list, z);
        }
    }

    /* renamed from: b */
    private final void m12252b(int i, List<? extends Object> list, boolean z) {
        Object[] objArr = {new Integer(i), list, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11297a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5272, new Class[]{Integer.TYPE, List.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f11300c.addAll(i, list);
            if (z) {
                notifyDataSetChanged();
            } else {
                notifyItemRangeInserted(i, list.size());
            }
        }
    }

    /* renamed from: c */
    public final void mo20726c(@NotNull List<Object> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f11297a, false, 5273, new Class[]{List.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(list, "dataItems");
            this.f11300c = list;
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public final void mo20715a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f11297a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5274, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && i < this.f11300c.size()) {
            this.f11300c.add(i2, this.f11300c.remove(i));
            notifyItemMoved(i, i2);
        }
    }

    /* renamed from: a */
    public final void mo20714a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11297a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5275, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i < this.f11300c.size()) {
            this.f11300c.remove(i);
            notifyItemRangeRemoved(i, 1);
        }
    }

    @Nullable
    /* renamed from: b */
    public final Object mo20723b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11297a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5276, new Class[]{Integer.TYPE}, Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (i < this.f11300c.size()) {
            return this.f11300c.get(i);
        }
        return null;
    }

    @NotNull
    /* renamed from: a */
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        ViewHolderManager aVar;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f11297a, false, 5277, new Class[]{ViewGroup.class, Integer.TYPE}, BaseViewHolder.class);
        if (proxy.isSupported) {
            return (BaseViewHolder) proxy.result;
        }
        C3443i.m21155b(viewGroup, "parent");
        if (this.f11304g) {
            aVar = this.f11302e.get(i);
        } else {
            LogUtil.C2630a aVar2 = f11299i;
            LogUtil.m15942a(aVar2, "onCreateViewHolder, mCurrentViewType = " + this.f11303f);
            aVar = this.f11302e.get(this.f11303f);
        }
        BaseViewHolder a = aVar.mo20696a(viewGroup);
        a.mo20728a(aVar);
        LogUtil.C2630a aVar3 = f11299i;
        LogUtil.m15942a(aVar3, "onCreateViewHolder, " + a.mo20727a());
        return a;
    }

    /* renamed from: a */
    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i) {
        if (!PatchProxy.proxy(new Object[]{baseViewHolder, new Integer(i)}, this, f11297a, false, 5278, new Class[]{BaseViewHolder.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(baseViewHolder, "holder");
            Object b = mo20723b(i);
            ViewHolderManager a = baseViewHolder.mo20727a();
            if (a != null) {
                if (b == null) {
                    C3443i.m21151a();
                }
                a.mo20735a(baseViewHolder, b, this.f11301d, i);
            }
            baseViewHolder.itemView.setTag(-121, baseViewHolder);
            baseViewHolder.mo20729a(b);
        }
    }

    public int getItemCount() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11297a, false, 5279, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f11300c.size();
    }

    public int getItemViewType(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11297a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 5280, new Class[]{Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f11302e.get(i) == null) {
            Object obj = this.f11300c.get(i);
            if (obj instanceof ItemManager) {
                this.f11303f = i;
                ViewHolderManager a = ((ItemManager) obj).mo20747a();
                LogUtil.C2630a aVar = f11299i;
                LogUtil.m15942a(aVar, "add holderManager in getItemViewType, " + a + ", position = " + i);
                this.f11302e.put(i, a);
            }
        }
        return super.getItemViewType(i);
    }

    /* renamed from: a */
    public final void mo20719a(@NotNull ItemDrag bVar, boolean z) {
        if (!PatchProxy.proxy(new Object[]{bVar, new Byte(z ? (byte) 1 : 0)}, this, f11297a, false, 5281, new Class[]{ItemDrag.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(bVar, "itemDrag");
            for (Object next : this.f11300c) {
                if (next instanceof ImageTextBean) {
                    if (!z) {
                        ImageTextBean aVar = (ImageTextBean) next;
                        if (!aVar.mo20705c()) {
                            aVar.mo20708e(true);
                        }
                    } else if (!bVar.mo20705c()) {
                        ((ImageTextBean) next).mo20708e(true);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public final void mo20724b() {
        if (!PatchProxy.proxy(new Object[0], this, f11297a, false, 5282, new Class[0], Void.TYPE).isSupported) {
            for (Object next : this.f11300c) {
                if (next instanceof ImageTextBean) {
                    ImageTextBean aVar = (ImageTextBean) next;
                    if (aVar.mo20705c() || aVar.mo20703b() || aVar.mo20707d()) {
                        aVar.mo20708e(false);
                    } else {
                        aVar.mo20708e(true);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/adapter/BaseItemAdapter$Companion;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.modemove.adapter.BaseItemAdapter$a */
    /* compiled from: BaseItemAdapter.kt */
    public static final class C2242a {
        private C2242a() {
        }

        public /* synthetic */ C2242a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
