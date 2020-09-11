package com.meizu.media.camera.p066c;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.media.camera.p064a.AsyncResource;
import com.meizu.media.camera.p064a.DataAdapter;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.c.a */
public abstract class AsyncDrawable extends TransitionDrawable {

    /* renamed from: a */
    public static ChangeQuickRedirect f8217a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Drawable f8218d;

    /* renamed from: e */
    private final C1868a f8219e;

    /* renamed from: f */
    private final int f8220f;

    /* renamed from: g */
    private final DataAdapter.C1784a f8221g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<WeakReference<TransitionDrawable>> f8222h;

    /* renamed from: a */
    public abstract void mo19375a(Drawable drawable);

    /* renamed from: b */
    public abstract ThreadPool.C2637b<Drawable> mo19377b();

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AsyncDrawable(com.meizu.media.camera.p064a.AsyncResource.C1783a<android.graphics.drawable.Drawable> r4, android.graphics.drawable.Drawable r5, int r6, com.meizu.media.camera.p064a.DataAdapter.C1784a r7) {
        /*
            r3 = this;
            r0 = 2
            android.graphics.drawable.Drawable[] r0 = new android.graphics.drawable.Drawable[r0]
            r1 = 0
            if (r5 != 0) goto L_0x000b
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            r5.<init>(r1)
        L_0x000b:
            r0[r1] = r5
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            r5.<init>(r1)
            r2 = 1
            r0[r2] = r5
            r3.<init>(r0)
            r3.mo19383a((int) r1, (int) r1)
            r3.mo19383a((int) r2, (int) r2)
            android.graphics.drawable.Drawable r5 = r3.mo19382a(r2)
            r3.f8218d = r5
            com.meizu.media.camera.c.a$a r5 = new com.meizu.media.camera.c.a$a
            r5.<init>(r4)
            r3.f8219e = r5
            r3.f8220f = r6
            r3.f8221g = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p066c.AsyncDrawable.<init>(com.meizu.media.camera.a.a$a, android.graphics.drawable.Drawable, int, com.meizu.media.camera.a.c$a):void");
    }

    /* renamed from: a */
    public void mo19374a() {
        if (!PatchProxy.proxy(new Object[0], this, f8217a, false, 3734, new Class[0], Void.TYPE).isSupported) {
            this.f8219e.mo18712b();
        }
    }

    /* renamed from: b */
    public void mo19378b(Drawable drawable) {
        if (!PatchProxy.proxy(new Object[]{drawable}, this, f8217a, false, 3741, new Class[]{Drawable.class}, Void.TYPE).isSupported && this.f8221g != null) {
            this.f8221g.mo18719a(this.f8220f);
        }
    }

    /* renamed from: a */
    public void mo19376a(ImageView imageView) {
        if (!PatchProxy.proxy(new Object[]{imageView}, this, f8217a, false, 3742, new Class[]{ImageView.class}, Void.TYPE).isSupported) {
            Drawable.Callback callback = getCallback();
            if (callback == null || callback == imageView) {
                imageView.setImageDrawable(this);
                return;
            }
            Drawable a = mo19382a(1);
            if (a == this.f8218d) {
                imageView.setImageDrawable(mo19379c());
            } else {
                imageView.setImageDrawable(a.getConstantState().newDrawable());
            }
        }
    }

    /* renamed from: c */
    public Drawable mo19379c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8217a, false, 3743, new Class[0], Drawable.class);
        if (proxy.isSupported) {
            return (Drawable) proxy.result;
        }
        if (this.f8222h == null) {
            this.f8222h = new ArrayList<>();
        }
        TransitionDrawable dVar = (TransitionDrawable) getConstantState().newDrawable();
        this.f8222h.add(new WeakReference(dVar));
        return dVar;
    }

    /* renamed from: com.meizu.media.camera.c.a$a */
    /* compiled from: AsyncDrawable */
    private class C1868a extends AsyncResource<Drawable> {

        /* renamed from: b */
        public static ChangeQuickRedirect f8223b;

        public C1868a(AsyncResource.C1783a<Drawable> aVar) {
            super(aVar);
        }

        /* renamed from: c */
        public ThreadPool.C2637b<Drawable> mo18714c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8223b, false, 3744, new Class[0], ThreadPool.C2637b.class);
            return proxy.isSupported ? (ThreadPool.C2637b) proxy.result : AsyncDrawable.this.mo19377b();
        }

        /* renamed from: a */
        public void mo18711a(Drawable drawable) {
            if (!PatchProxy.proxy(new Object[]{drawable}, this, f8223b, false, 3745, new Class[]{Drawable.class}, Void.TYPE).isSupported) {
                if (drawable != null) {
                    AsyncDrawable.this.mo19384a(1, drawable);
                    AsyncDrawable.this.mo19413b(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                } else {
                    AsyncDrawable.this.mo19384a(1, AsyncDrawable.this.f8218d);
                }
                if (AsyncDrawable.this.f8222h != null) {
                    for (int size = AsyncDrawable.this.f8222h.size() - 1; size >= 0; size--) {
                        TransitionDrawable dVar = (TransitionDrawable) ((WeakReference) AsyncDrawable.this.f8222h.get(size)).get();
                        if (dVar == null) {
                            AsyncDrawable.this.f8222h.remove(size);
                        } else if (drawable != null) {
                            dVar.mo19384a(1, drawable.getConstantState().newDrawable());
                            dVar.mo19413b(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                        } else {
                            dVar.mo19384a(1, AsyncDrawable.this.f8218d);
                        }
                    }
                }
                AsyncDrawable.this.mo19378b(drawable);
            }
        }

        /* renamed from: b */
        public void mo18713b(Drawable drawable) {
            if (!PatchProxy.proxy(new Object[]{drawable}, this, f8223b, false, 3746, new Class[]{Drawable.class}, Void.TYPE).isSupported) {
                AsyncDrawable.this.mo19375a(drawable);
                if (AsyncDrawable.this.mo19382a(1) != AsyncDrawable.this.f8218d) {
                    AsyncDrawable.this.mo19384a(1, AsyncDrawable.this.f8218d);
                }
            }
        }
    }
}
