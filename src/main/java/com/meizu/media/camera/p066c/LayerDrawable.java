package com.meizu.media.camera.p066c;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.c.b */
public class LayerDrawable extends Drawable implements Drawable.Callback {

    /* renamed from: b */
    public static ChangeQuickRedirect f8225b;

    /* renamed from: a */
    private final Rect f8226a;

    /* renamed from: c */
    C1871b f8227c;

    /* renamed from: d */
    private int f8228d;

    /* renamed from: e */
    private int[] f8229e;

    /* renamed from: f */
    private int[] f8230f;

    /* renamed from: g */
    private int[] f8231g;

    /* renamed from: h */
    private int[] f8232h;

    /* renamed from: i */
    private boolean f8233i;

    LayerDrawable(Drawable[] drawableArr, C1871b bVar) {
        this(bVar, (Resources) null);
        int length = drawableArr.length;
        C1870a[] aVarArr = new C1870a[length];
        for (int i = 0; i < length; i++) {
            aVarArr[i] = new C1870a();
            aVarArr[i].f8234a = drawableArr[i];
            drawableArr[i].setCallback(this);
            this.f8227c.f8244e |= drawableArr[i].getChangingConfigurations();
        }
        this.f8227c.f8241b = length;
        this.f8227c.f8242c = aVarArr;
        mo19385d();
    }

    LayerDrawable() {
        this((C1871b) null, (Resources) null);
    }

    private LayerDrawable(C1871b bVar, Resources resources) {
        this.f8226a = new Rect();
        this.f8228d = 0;
        C1871b a = m8837a(bVar, resources);
        this.f8227c = a;
        if (a.f8241b > 0) {
            mo19385d();
        }
    }

    /* renamed from: a */
    private C1871b m8837a(C1871b bVar, Resources resources) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bVar, resources}, this, f8225b, false, 3747, new Class[]{C1871b.class, Resources.class}, C1871b.class);
        return proxy.isSupported ? (C1871b) proxy.result : new C1871b(bVar, this, resources);
    }

    /* renamed from: a */
    public void mo19383a(int i, int i2) {
        this.f8227c.f8242c[i].f8239f = i2;
    }

    /* renamed from: a */
    public Drawable mo19382a(int i) {
        return this.f8227c.f8242c[i].f8234a;
    }

    /* renamed from: a */
    public boolean mo19384a(int i, Drawable drawable) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), drawable}, this, f8225b, false, 3748, new Class[]{Integer.TYPE, Drawable.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1870a[] aVarArr = this.f8227c.f8242c;
        for (int i2 = this.f8227c.f8241b - 1; i2 >= 0; i2--) {
            if (aVarArr[i2].f8239f == i) {
                if (aVarArr[i2].f8234a != null) {
                    if (drawable != null) {
                        drawable.setBounds(aVarArr[i2].f8234a.getBounds());
                    }
                    aVarArr[i2].f8234a.setCallback((Drawable.Callback) null);
                }
                if (drawable != null) {
                    drawable.setCallback(this);
                }
                aVarArr[i2].f8234a = drawable;
                return true;
            }
        }
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (!PatchProxy.proxy(new Object[]{drawable}, this, f8225b, false, 3749, new Class[]{Drawable.class}, Void.TYPE).isSupported && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (!PatchProxy.proxy(new Object[]{drawable, runnable, new Long(j)}, this, f8225b, false, 3750, new Class[]{Drawable.class, Runnable.class, Long.TYPE}, Void.TYPE).isSupported && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (!PatchProxy.proxy(new Object[]{drawable, runnable}, this, f8225b, false, 3751, new Class[]{Drawable.class, Runnable.class}, Void.TYPE).isSupported && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void draw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f8225b, false, 3752, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            C1870a[] aVarArr = this.f8227c.f8242c;
            int i = this.f8227c.f8241b;
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2].f8234a.draw(canvas);
            }
        }
    }

    public int getChangingConfigurations() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8225b, false, 3753, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : super.getChangingConfigurations() | this.f8227c.f8243d | this.f8227c.f8244e;
    }

    public boolean getPadding(Rect rect) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{rect}, this, f8225b, false, 3754, new Class[]{Rect.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        C1870a[] aVarArr = this.f8227c.f8242c;
        int i = this.f8227c.f8241b;
        for (int i2 = 0; i2 < i; i2++) {
            m8838a(i2, aVarArr[i2]);
            rect.left += this.f8229e[i2];
            rect.top += this.f8230f[i2];
            rect.right += this.f8231g[i2];
            rect.bottom += this.f8232h[i2];
        }
        return true;
    }

    public boolean setVisible(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f8225b;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3755, new Class[]{Boolean.TYPE, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        boolean visible = super.setVisible(z, z2);
        C1870a[] aVarArr = this.f8227c.f8242c;
        int i = this.f8227c.f8241b;
        for (int i2 = 0; i2 < i; i2++) {
            aVarArr[i2].f8234a.setVisible(z, z2);
        }
        return visible;
    }

    public void setDither(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f8225b, false, 3756, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            C1870a[] aVarArr = this.f8227c.f8242c;
            int i = this.f8227c.f8241b;
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2].f8234a.setDither(z);
            }
        }
    }

    public void setAlpha(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f8225b, false, 3757, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            C1870a[] aVarArr = this.f8227c.f8242c;
            int i2 = this.f8227c.f8241b;
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3].f8234a.setAlpha(i);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (!PatchProxy.proxy(new Object[]{colorFilter}, this, f8225b, false, 3758, new Class[]{ColorFilter.class}, Void.TYPE).isSupported) {
            C1870a[] aVarArr = this.f8227c.f8242c;
            int i = this.f8227c.f8241b;
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2].f8234a.setColorFilter(colorFilter);
            }
        }
    }

    public int getOpacity() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8225b, false, 3759, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f8228d != 0) {
            return this.f8228d;
        }
        return this.f8227c.mo19405a();
    }

    public boolean isStateful() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8225b, false, 3760, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f8227c.mo19406b();
    }

    public boolean onStateChange(int[] iArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{iArr}, this, f8225b, false, 3761, new Class[]{int[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1870a[] aVarArr = this.f8227c.f8242c;
        int i = this.f8227c.f8241b;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            C1870a aVar = aVarArr[i2];
            if (aVar.f8234a.setState(iArr)) {
                z2 = true;
            }
            if (m8838a(i2, aVar)) {
                z = true;
            }
        }
        if (z) {
            onBoundsChange(getBounds());
        }
        return z2;
    }

    public boolean onLevelChange(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f8225b, false, 3762, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1870a[] aVarArr = this.f8227c.f8242c;
        int i2 = this.f8227c.f8241b;
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < i2; i3++) {
            C1870a aVar = aVarArr[i3];
            if (aVar.f8234a.setLevel(i)) {
                z2 = true;
            }
            if (m8838a(i3, aVar)) {
                z = true;
            }
        }
        if (z) {
            onBoundsChange(getBounds());
        }
        return z2;
    }

    public void onBoundsChange(Rect rect) {
        if (!PatchProxy.proxy(new Object[]{rect}, this, f8225b, false, 3763, new Class[]{Rect.class}, Void.TYPE).isSupported) {
            C1870a[] aVarArr = this.f8227c.f8242c;
            int i = this.f8227c.f8241b;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                C1870a aVar = aVarArr[i6];
                aVar.f8234a.setBounds(rect.left + aVar.f8235b + i2, rect.top + aVar.f8236c + i3, (rect.right - aVar.f8237d) - i4, (rect.bottom - aVar.f8238e) - i5);
                i2 += this.f8229e[i6];
                i4 += this.f8231g[i6];
                i3 += this.f8230f[i6];
                i5 += this.f8232h[i6];
            }
        }
    }

    public int getIntrinsicWidth() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8225b, false, 3764, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C1870a[] aVarArr = this.f8227c.f8242c;
        int i = this.f8227c.f8241b;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        for (int i5 = 0; i5 < i; i5++) {
            C1870a aVar = aVarArr[i5];
            int intrinsicWidth = aVar.f8234a.getIntrinsicWidth() + aVar.f8235b + aVar.f8237d + i2 + i3;
            if (intrinsicWidth > i4) {
                i4 = intrinsicWidth;
            }
            i2 += this.f8229e[i5];
            i3 += this.f8231g[i5];
        }
        return i4;
    }

    public int getIntrinsicHeight() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8225b, false, 3765, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C1870a[] aVarArr = this.f8227c.f8242c;
        int i = this.f8227c.f8241b;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        for (int i5 = 0; i5 < i; i5++) {
            C1870a aVar = aVarArr[i5];
            int intrinsicHeight = aVar.f8234a.getIntrinsicHeight() + aVar.f8236c + aVar.f8238e + i2 + i3;
            if (intrinsicHeight > i4) {
                i4 = intrinsicHeight;
            }
            i2 += this.f8230f[i5];
            i3 += this.f8232h[i5];
        }
        return i4;
    }

    /* renamed from: a */
    private boolean m8838a(int i, C1870a aVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), aVar}, this, f8225b, false, 3766, new Class[]{Integer.TYPE, C1870a.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Rect rect = this.f8226a;
        aVar.f8234a.getPadding(rect);
        if (rect.left == this.f8229e[i] && rect.top == this.f8230f[i] && rect.right == this.f8231g[i] && rect.bottom == this.f8232h[i]) {
            return false;
        }
        this.f8229e[i] = rect.left;
        this.f8230f[i] = rect.top;
        this.f8231g[i] = rect.right;
        this.f8232h[i] = rect.bottom;
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo19385d() {
        int i = this.f8227c.f8241b;
        if (this.f8229e == null || this.f8229e.length < i) {
            this.f8229e = new int[i];
            this.f8230f = new int[i];
            this.f8231g = new int[i];
            this.f8232h = new int[i];
        }
    }

    public Drawable.ConstantState getConstantState() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8225b, false, 3767, new Class[0], Drawable.ConstantState.class);
        if (proxy.isSupported) {
            return (Drawable.ConstantState) proxy.result;
        }
        if (!this.f8227c.mo19407c()) {
            return null;
        }
        this.f8227c.f8243d = getChangingConfigurations();
        return this.f8227c;
    }

    public Drawable mutate() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8225b, false, 3768, new Class[0], Drawable.class);
        if (proxy.isSupported) {
            return (Drawable) proxy.result;
        }
        if (!this.f8233i && super.mutate() == this) {
            if (this.f8227c.mo19407c()) {
                this.f8227c = new C1871b(this.f8227c, this, (Resources) null);
                C1870a[] aVarArr = this.f8227c.f8242c;
                int i = this.f8227c.f8241b;
                for (int i2 = 0; i2 < i; i2++) {
                    aVarArr[i2].f8234a.mutate();
                }
                this.f8233i = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    /* renamed from: com.meizu.media.camera.c.b$a */
    /* compiled from: LayerDrawable */
    static class C1870a {

        /* renamed from: a */
        public Drawable f8234a;

        /* renamed from: b */
        public int f8235b;

        /* renamed from: c */
        public int f8236c;

        /* renamed from: d */
        public int f8237d;

        /* renamed from: e */
        public int f8238e;

        /* renamed from: f */
        public int f8239f;

        C1870a() {
        }
    }

    /* renamed from: com.meizu.media.camera.c.b$b */
    /* compiled from: LayerDrawable */
    static class C1871b extends Drawable.ConstantState {

        /* renamed from: a */
        public static ChangeQuickRedirect f8240a;

        /* renamed from: b */
        int f8241b;

        /* renamed from: c */
        C1870a[] f8242c;

        /* renamed from: d */
        int f8243d;

        /* renamed from: e */
        int f8244e;

        /* renamed from: f */
        private boolean f8245f = false;

        /* renamed from: g */
        private int f8246g;

        /* renamed from: h */
        private boolean f8247h = false;

        /* renamed from: i */
        private boolean f8248i;

        /* renamed from: j */
        private boolean f8249j;

        /* renamed from: k */
        private boolean f8250k;

        C1871b(C1871b bVar, LayerDrawable bVar2, Resources resources) {
            if (bVar != null) {
                C1870a[] aVarArr = bVar.f8242c;
                int i = bVar.f8241b;
                this.f8241b = i;
                this.f8242c = new C1870a[i];
                this.f8243d = bVar.f8243d;
                this.f8244e = bVar.f8244e;
                for (int i2 = 0; i2 < i; i2++) {
                    C1870a[] aVarArr2 = this.f8242c;
                    C1870a aVar = new C1870a();
                    aVarArr2[i2] = aVar;
                    C1870a aVar2 = aVarArr[i2];
                    if (resources != null) {
                        aVar.f8234a = aVar2.f8234a.getConstantState().newDrawable(resources);
                    } else {
                        aVar.f8234a = aVar2.f8234a.getConstantState().newDrawable();
                    }
                    aVar.f8234a.setCallback(bVar2);
                    aVar.f8235b = aVar2.f8235b;
                    aVar.f8236c = aVar2.f8236c;
                    aVar.f8237d = aVar2.f8237d;
                    aVar.f8238e = aVar2.f8238e;
                    aVar.f8239f = aVar2.f8239f;
                }
                this.f8245f = bVar.f8245f;
                this.f8246g = bVar.f8246g;
                this.f8247h = bVar.f8247h;
                this.f8248i = bVar.f8248i;
                this.f8250k = true;
                this.f8249j = true;
                return;
            }
            this.f8241b = 0;
            this.f8242c = null;
        }

        public Drawable newDrawable() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8240a, false, 3769, new Class[0], Drawable.class);
            return proxy.isSupported ? (Drawable) proxy.result : new LayerDrawable(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{resources}, this, f8240a, false, 3770, new Class[]{Resources.class}, Drawable.class);
            return proxy.isSupported ? (Drawable) proxy.result : new LayerDrawable(this, resources);
        }

        public int getChangingConfigurations() {
            return this.f8243d;
        }

        /* renamed from: a */
        public final int mo19405a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8240a, false, 3771, new Class[0], Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            if (this.f8245f) {
                return this.f8246g;
            }
            int i = this.f8241b;
            int opacity = i > 0 ? this.f8242c[0].f8234a.getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, this.f8242c[i2].f8234a.getOpacity());
            }
            this.f8246g = opacity;
            this.f8245f = true;
            return opacity;
        }

        /* renamed from: b */
        public final boolean mo19406b() {
            boolean z = false;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8240a, false, 3772, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (this.f8247h) {
                return this.f8248i;
            }
            int i = this.f8241b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (this.f8242c[i2].f8234a.isStateful()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            this.f8248i = z;
            this.f8247h = true;
            return z;
        }

        /* renamed from: c */
        public boolean mo19407c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8240a, false, 3773, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (!this.f8249j && this.f8242c != null) {
                this.f8250k = true;
                int i = this.f8241b;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        break;
                    } else if (this.f8242c[i2].f8234a.getConstantState() == null) {
                        this.f8250k = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                this.f8249j = true;
            }
            return this.f8250k;
        }
    }
}
