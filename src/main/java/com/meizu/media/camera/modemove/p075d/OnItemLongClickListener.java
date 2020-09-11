package com.meizu.media.camera.modemove.p075d;

import android.view.View;
import com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder;
import com.meizu.savior.ChangeQuickRedirect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H$J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/listener/OnItemLongClickListener;", "Landroid/view/View$OnLongClickListener;", "()V", "onItemLongClick", "", "viewHolder", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "onLongClick", "", "view", "Landroid/view/View;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.d.b */
public abstract class OnItemLongClickListener implements View.OnLongClickListener {

    /* renamed from: e */
    public static ChangeQuickRedirect f11357e;

    /* renamed from: a */
    public abstract void mo20698a(@NotNull BaseViewHolder baseViewHolder);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onLongClick(@org.jetbrains.annotations.NotNull android.view.View r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f11357e
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.view.View> r2 = android.view.View.class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r4 = 0
            r5 = 5337(0x14d9, float:7.479E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0025
            java.lang.Object r10 = r1.result
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            return r10
        L_0x0025:
            java.lang.String r1 = "view"
            kotlin.jvm.p108b.C3443i.m21155b(r10, r1)
            r1 = 0
            com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder r1 = (com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder) r1
            r2 = -121(0xffffffffffffff87, float:NaN)
            java.lang.Object r10 = r10.getTag(r2)
            boolean r2 = r10 instanceof com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder
            if (r2 == 0) goto L_0x003a
            r1 = r10
            com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder r1 = (com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder) r1
        L_0x003a:
            if (r1 != 0) goto L_0x003d
            return r8
        L_0x003d:
            r9.mo20698a(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.modemove.p075d.OnItemLongClickListener.onLongClick(android.view.View):boolean");
    }
}
