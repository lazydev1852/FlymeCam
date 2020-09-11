package com.meizu.media.camera.modemove.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.media.camera.modemove.p072a.ImageTextBean;
import com.meizu.media.camera.modemove.p074c.ItemData;
import com.meizu.media.camera.modemove.p075d.OnItemLongClickListener;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0004J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0004J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0004H\u0004J(\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J \u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0004H&J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0004H\u0004R\u0014\u0010\u0003\u001a\u00020\u00048eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/adapter/holder/ViewHolderManager;", "", "()V", "itemLayoutId", "", "getItemLayoutId", "()I", "bindView", "", "holder", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "data", "Lcom/meizu/media/camera/modemove/item/ItemData;", "getItemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "getView", "view", "id", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onBindViewHolder", "t", "longClickListener", "Lcom/meizu/media/camera/modemove/listener/OnItemLongClickListener;", "position", "onCreateViewHolder", "setVisibility", "itemView", "visibility", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.adapter.holder.a */
public abstract class ViewHolderManager {

    /* renamed from: c */
    public static ChangeQuickRedirect f11309c;

    @LayoutRes
    /* renamed from: a */
    public abstract int mo20695a();

    @NotNull
    /* renamed from: a */
    public abstract BaseViewHolder mo20696a(@NotNull ViewGroup viewGroup);

    /* renamed from: a */
    public abstract void mo20697a(@NotNull BaseViewHolder baseViewHolder, @NotNull Object obj, int i);

    /* renamed from: a */
    public final void mo20735a(@NotNull BaseViewHolder baseViewHolder, @NotNull Object obj, @Nullable OnItemLongClickListener bVar, int i) {
        Object[] objArr = {baseViewHolder, obj, bVar, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f11309c;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 5284, new Class[]{BaseViewHolder.class, Object.class, OnItemLongClickListener.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(baseViewHolder, "holder");
            C3443i.m21155b(obj, "t");
            if ((obj instanceof ImageTextBean) && !((ImageTextBean) obj).mo20710f()) {
                baseViewHolder.itemView.setOnLongClickListener(bVar);
            }
            if (obj instanceof ItemData) {
                m12273a(baseViewHolder, (ItemData) obj);
            }
            mo20697a(baseViewHolder, obj, i);
        }
    }

    /* renamed from: a */
    private final void m12273a(BaseViewHolder baseViewHolder, ItemData aVar) {
        Class[] clsArr = {BaseViewHolder.class, ItemData.class};
        if (!PatchProxy.proxy(new Object[]{baseViewHolder, aVar}, this, f11309c, false, 5285, clsArr, Void.TYPE).isSupported) {
            View view = baseViewHolder.itemView;
            C3443i.m21152a((Object) view, "holder.itemView");
            mo20734a(view, aVar.mo20711g());
        }
    }

    /* renamed from: a */
    public final void mo20734a(@NotNull View view, int i) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i)}, this, f11309c, false, 5286, new Class[]{View.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(view, "itemView");
            view.setVisibility(i);
        }
    }

    @NotNull
    /* renamed from: a */
    public final View mo20732a(@NotNull ViewGroup viewGroup, @NotNull Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, context}, this, f11309c, false, 5287, new Class[]{ViewGroup.class, Context.class}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        C3443i.m21155b(viewGroup, "parent");
        C3443i.m21155b(context, "context");
        View inflate = LayoutInflater.from(context).inflate(mo20695a(), viewGroup, false);
        C3443i.m21152a((Object) inflate, "LayoutInflater.from(cont…mLayoutId, parent, false)");
        return inflate;
    }

    @NotNull
    /* renamed from: a */
    public final View mo20733a(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewHolder, new Integer(i)}, this, f11309c, false, 5288, new Class[]{RecyclerView.ViewHolder.class, Integer.TYPE}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        C3443i.m21155b(viewHolder, "viewHolder");
        View findViewById = viewHolder.itemView.findViewById(i);
        C3443i.m21152a((Object) findViewById, "viewHolder.itemView.findViewById(id)");
        return findViewById;
    }

    @NotNull
    /* renamed from: b */
    public final View mo20736b(@NotNull View view, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, new Integer(i)}, this, f11309c, false, 5289, new Class[]{View.class, Integer.TYPE}, View.class);
        if (proxy.isSupported) {
            return (View) proxy.result;
        }
        C3443i.m21155b(view, "view");
        View findViewById = view.findViewById(i);
        C3443i.m21152a((Object) findViewById, "view.findViewById(id)");
        return findViewById;
    }
}
