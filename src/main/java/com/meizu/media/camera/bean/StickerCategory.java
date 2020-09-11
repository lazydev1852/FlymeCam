package com.meizu.media.camera.bean;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010JH\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006'"}, mo27294d2 = {"Lcom/meizu/media/camera/bean/StickerCategory;", "", "categoryId", "", "nameCN", "", "nameTW", "nameEN", "hasUpdate", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCategoryId", "()I", "setCategoryId", "(I)V", "getHasUpdate", "()Ljava/lang/Boolean;", "setHasUpdate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNameCN", "()Ljava/lang/String;", "setNameCN", "(Ljava/lang/String;)V", "getNameEN", "setNameEN", "getNameTW", "setNameTW", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/meizu/media/camera/bean/StickerCategory;", "equals", "other", "hashCode", "toString", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.bean.a */
public final class StickerCategory {

    /* renamed from: a */
    public static ChangeQuickRedirect f8207a;

    /* renamed from: b */
    private int f8208b;
    @Nullable

    /* renamed from: c */
    private String f8209c;
    @Nullable

    /* renamed from: d */
    private String f8210d;
    @Nullable

    /* renamed from: e */
    private String f8211e;
    @Nullable

    /* renamed from: f */
    private Boolean f8212f;

    public StickerCategory() {
        this(0, (String) null, (String) null, (String) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, this, f8207a, false, 2740, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this != obj) {
            if (obj instanceof StickerCategory) {
                StickerCategory aVar = (StickerCategory) obj;
                if (!(this.f8208b == aVar.f8208b) || !C3443i.m21154a((Object) this.f8209c, (Object) aVar.f8209c) || !C3443i.m21154a((Object) this.f8210d, (Object) aVar.f8210d) || !C3443i.m21154a((Object) this.f8211e, (Object) aVar.f8211e) || !C3443i.m21154a((Object) this.f8212f, (Object) aVar.f8212f)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8207a, false, 2739, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int i2 = this.f8208b * 31;
        String str = this.f8209c;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8210d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8211e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.f8212f;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8207a, false, 2738, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "StickerCategory(categoryId=" + this.f8208b + ", nameCN=" + this.f8209c + ", nameTW=" + this.f8210d + ", nameEN=" + this.f8211e + ", hasUpdate=" + this.f8212f + ")";
    }

    public StickerCategory(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool) {
        this.f8208b = i;
        this.f8209c = str;
        this.f8210d = str2;
        this.f8211e = str3;
        this.f8212f = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ StickerCategory(int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Boolean r9, int r10, kotlin.jvm.p108b.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = 0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            r1 = 0
            if (r5 == 0) goto L_0x0010
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        L_0x0010:
            r2 = r6
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0018
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
        L_0x0018:
            r3 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0020
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8
        L_0x0020:
            r1 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0029
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
        L_0x0029:
            r10 = r9
            r5 = r4
            r6 = r11
            r7 = r2
            r8 = r3
            r9 = r1
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.bean.StickerCategory.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.b.g):void");
    }

    /* renamed from: a */
    public final int mo19360a() {
        return this.f8208b;
    }

    /* renamed from: a */
    public final void mo19361a(int i) {
        this.f8208b = i;
    }

    /* renamed from: a */
    public final void mo19362a(@Nullable Boolean bool) {
        this.f8212f = bool;
    }

    /* renamed from: a */
    public final void mo19363a(@Nullable String str) {
        this.f8209c = str;
    }

    @Nullable
    /* renamed from: b */
    public final String mo19364b() {
        return this.f8209c;
    }

    /* renamed from: b */
    public final void mo19365b(@Nullable String str) {
        this.f8210d = str;
    }

    @Nullable
    /* renamed from: c */
    public final String mo19366c() {
        return this.f8210d;
    }

    /* renamed from: c */
    public final void mo19367c(@Nullable String str) {
        this.f8211e = str;
    }

    @Nullable
    /* renamed from: d */
    public final String mo19368d() {
        return this.f8211e;
    }

    @Nullable
    /* renamed from: e */
    public final Boolean mo19369e() {
        return this.f8212f;
    }
}
