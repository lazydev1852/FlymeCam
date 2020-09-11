package com.meizu.media.camera.modemove.adapter.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "itemPosition", "", "getItemPosition", "()I", "mHolderManager", "Lcom/meizu/media/camera/modemove/adapter/holder/ViewHolderManager;", "getMHolderManager", "()Lcom/meizu/media/camera/modemove/adapter/holder/ViewHolderManager;", "setMHolderManager", "(Lcom/meizu/media/camera/modemove/adapter/holder/ViewHolderManager;)V", "mItemData", "", "getMItemData", "()Ljava/lang/Object;", "setMItemData", "(Ljava/lang/Object;)V", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: BaseViewHolder.kt */
public final class BaseViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public static ChangeQuickRedirect f11306a;
    @Nullable

    /* renamed from: b */
    private ViewHolderManager f11307b;
    @Nullable

    /* renamed from: c */
    private Object f11308c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(@NotNull View view) {
        super(view);
        C3443i.m21155b(view, "itemView");
    }

    @Nullable
    /* renamed from: a */
    public final ViewHolderManager mo20727a() {
        return this.f11307b;
    }

    /* renamed from: a */
    public final void mo20728a(@Nullable ViewHolderManager aVar) {
        this.f11307b = aVar;
    }

    /* renamed from: a */
    public final void mo20729a(@Nullable Object obj) {
        this.f11308c = obj;
    }

    @Nullable
    /* renamed from: b */
    public final Object mo20730b() {
        return this.f11308c;
    }

    /* renamed from: c */
    public final int mo20731c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11306a, false, 5283, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : getAdapterPosition();
    }
}
