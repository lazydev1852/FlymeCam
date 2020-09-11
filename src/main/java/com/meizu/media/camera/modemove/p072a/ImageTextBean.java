package com.meizu.media.camera.modemove.p072a;

import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.modemove.p074c.ItemData;
import com.meizu.media.camera.modemove.p074c.ItemDrag;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B/\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u000e\u0010\n\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0016H\u0016J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\b\u0010#\u001a\u00020\u0007H\u0016R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/bean/ImageTextBean;", "Lcom/meizu/media/camera/modemove/item/ItemDrag;", "Lcom/meizu/media/camera/modemove/item/ItemData;", "()V", "modeType", "Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "movable", "", "changeRecycler", "draggable", "canShowInSlide", "(Lcom/meizu/media/camera/mode/CameraModeType$ModeType;ZZZZ)V", "mCanShowInSlide", "mChangeRecycler", "mDraggable", "mMovable", "mShowDisableIcon", "getModeType", "()Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "setModeType", "(Lcom/meizu/media/camera/mode/CameraModeType$ModeType;)V", "visibility", "", "canChangeRecycler", "", "show", "getVisibility", "isDraggable", "isMovable", "setChangeRecycler", "setDraggable", "setMovable", "setVisibility", "int", "showDisableIcon", "showDisableMoveIcon", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.a.a */
public final class ImageTextBean implements ItemData, ItemDrag {
    @Nullable

    /* renamed from: a */
    private CameraModeType.ModeType f11290a;

    /* renamed from: b */
    private boolean f11291b;

    /* renamed from: c */
    private boolean f11292c;

    /* renamed from: d */
    private boolean f11293d;

    /* renamed from: e */
    private boolean f11294e;

    /* renamed from: f */
    private boolean f11295f;

    /* renamed from: g */
    private int f11296g;

    @Nullable
    /* renamed from: a */
    public final CameraModeType.ModeType mo20699a() {
        return this.f11290a;
    }

    public ImageTextBean() {
    }

    public ImageTextBean(@NotNull CameraModeType.ModeType modeType, boolean z, boolean z2, boolean z3, boolean z4) {
        C3443i.m21155b(modeType, "modeType");
        this.f11290a = modeType;
        this.f11291b = z;
        this.f11292c = z2;
        this.f11293d = z3;
        this.f11294e = z4;
    }

    /* renamed from: a */
    public final void mo20701a(boolean z) {
        this.f11291b = z;
    }

    /* renamed from: b */
    public final void mo20702b(boolean z) {
        this.f11292c = z;
    }

    /* renamed from: c */
    public final void mo20704c(boolean z) {
        this.f11293d = z;
    }

    /* renamed from: d */
    public final void mo20706d(boolean z) {
        this.f11294e = z;
    }

    /* renamed from: e */
    public final void mo20708e(boolean z) {
        this.f11295f = z;
    }

    /* renamed from: b */
    public boolean mo20703b() {
        return this.f11291b;
    }

    /* renamed from: c */
    public boolean mo20705c() {
        return this.f11292c;
    }

    /* renamed from: d */
    public boolean mo20707d() {
        return this.f11293d;
    }

    /* renamed from: e */
    public boolean mo20709e() {
        return this.f11294e;
    }

    /* renamed from: f */
    public boolean mo20710f() {
        return this.f11295f;
    }

    /* renamed from: a */
    public void mo20700a(int i) {
        this.f11296g = i;
    }

    /* renamed from: g */
    public int mo20711g() {
        return this.f11296g;
    }
}
