package com.meizu.media.camera.portrait;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, mo27294d2 = {"Lcom/meizu/media/camera/portrait/FocusPoint;", "", "()V", "x", "", "y", "(II)V", "px", "getPx", "()I", "setPx", "(I)V", "py", "getPy", "setPy", "toString", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: FocusPoint.kt */
public final class FocusPoint {
    public static ChangeQuickRedirect changeQuickRedirect;

    /* renamed from: px */
    private int f11408px;

    /* renamed from: py */
    private int f11409py;

    public final int getPx() {
        return this.f11408px;
    }

    public final void setPx(int i) {
        this.f11408px = i;
    }

    public final int getPy() {
        return this.f11409py;
    }

    public final void setPy(int i) {
        this.f11409py = i;
    }

    public FocusPoint() {
    }

    public FocusPoint(int i, int i2) {
        this.f11408px = i;
        this.f11409py = i2;
    }

    @NotNull
    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 5406, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(this.f11408px);
        sb.append(',');
        sb.append(this.f11409py);
        sb.append(')');
        return sb.toString();
    }
}
