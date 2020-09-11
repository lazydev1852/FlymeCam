package com.meizu.sharewidget.p080a;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.meizu.sharewidget.a.b */
/* compiled from: ImageLoader */
public class C2859b {

    /* renamed from: a */
    private ThreadPoolExecutor f15838a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map<C2858a, C2861a> f15839b;

    /* renamed from: c */
    private Handler f15840c;

    /* renamed from: d */
    private C2864b f15841d = new C2864b() {
        @UiThread
        /* renamed from: a */
        public void mo24054a(C2858a aVar, List<WeakReference<ImageView>> list, Drawable drawable) {
            aVar.f15835c = drawable;
            C2859b.this.f15839b.remove(aVar);
            for (WeakReference<ImageView> weakReference : list) {
                ImageView imageView = (ImageView) weakReference.get();
                if (imageView != null && aVar.equals(imageView.getTag())) {
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        @UiThread
        /* renamed from: a */
        public void mo24055a(C2858a aVar, List<WeakReference<ImageView>> list, Exception exc) {
            C2859b.this.f15839b.remove(aVar);
        }
    };

    /* renamed from: com.meizu.sharewidget.a.b$b */
    /* compiled from: ImageLoader */
    interface C2864b {
        @UiThread
        /* renamed from: a */
        void mo24054a(C2858a aVar, List<WeakReference<ImageView>> list, Drawable drawable);

        @UiThread
        /* renamed from: a */
        void mo24055a(C2858a aVar, List<WeakReference<ImageView>> list, Exception exc);
    }

    public C2859b(ThreadPoolExecutor threadPoolExecutor) {
        this.f15838a = threadPoolExecutor;
        this.f15839b = new HashMap();
        this.f15840c = new Handler(Looper.getMainLooper());
    }

    @UiThread
    /* renamed from: a */
    public void mo24053a(@NonNull ImageView imageView, @NonNull C2858a aVar, int i, @NonNull PackageManager packageManager, @NonNull Resources resources, int i2, int i3) {
        ImageView imageView2 = imageView;
        C2858a aVar2 = aVar;
        if (aVar2.f15835c != null) {
            imageView.setImageDrawable(aVar2.f15835c);
        } else if (aVar2.f15833a != null) {
            imageView.setTag(aVar);
            C2861a aVar3 = this.f15839b.get(aVar);
            if (aVar3 == null) {
                C2861a aVar4 = new C2861a(this.f15840c, this.f15841d, aVar, i, packageManager, resources, i2, i3);
                if (this.f15838a == null || this.f15838a.isShutdown()) {
                    AsyncTask.execute(aVar4);
                } else {
                    this.f15838a.submit(aVar4);
                }
                aVar4.mo24056a(imageView);
                this.f15839b.put(aVar, aVar4);
                return;
            }
            aVar3.mo24056a(imageView);
        }
    }

    /* renamed from: com.meizu.sharewidget.a.b$a */
    /* compiled from: ImageLoader */
    private static class C2861a implements Runnable {

        /* renamed from: a */
        private Handler f15843a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public List<WeakReference<ImageView>> f15844b = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C2864b f15845c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C2858a f15846d;

        /* renamed from: e */
        private int f15847e;

        /* renamed from: f */
        private PackageManager f15848f;

        /* renamed from: g */
        private Resources f15849g;

        /* renamed from: h */
        private int f15850h;

        /* renamed from: i */
        private int f15851i;

        public C2861a(@NonNull Handler handler, @NonNull C2864b bVar, @NonNull C2858a aVar, int i, @NonNull PackageManager packageManager, @NonNull Resources resources, int i2, int i3) {
            this.f15843a = handler;
            this.f15845c = bVar;
            this.f15846d = aVar;
            this.f15847e = i;
            this.f15848f = packageManager;
            this.f15849g = resources;
            this.f15850h = i2;
            this.f15851i = i3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo24056a(ImageView imageView) {
            this.f15844b.add(new WeakReference(imageView));
        }

        public void run() {
            Drawable a = m17239a(this.f15848f, this.f15846d.f15833a, this.f15847e);
            final Drawable a2 = C2879k.m17283a(a, this.f15850h, this.f15851i, this.f15849g, false);
            if (a == null) {
                this.f15843a.post(new Runnable() {
                    public void run() {
                        C2861a.this.f15845c.mo24055a(C2861a.this.f15846d, (List<WeakReference<ImageView>>) C2861a.this.f15844b, new Exception("displayIcon == null"));
                    }
                });
            } else {
                this.f15843a.post(new Runnable() {
                    public void run() {
                        C2861a.this.f15845c.mo24054a(C2861a.this.f15846d, (List<WeakReference<ImageView>>) C2861a.this.f15844b, a2);
                    }
                });
            }
        }

        /* renamed from: a */
        private Drawable m17239a(@NonNull PackageManager packageManager, ResolveInfo resolveInfo, int i) {
            Drawable a;
            Drawable a2;
            try {
                if (resolveInfo.resolvePackageName != null && resolveInfo.icon != 0 && (a2 = m17240a(packageManager.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon, i)) != null) {
                    return a2;
                }
                int iconResource = resolveInfo.getIconResource();
                if (!(iconResource == 0 || (a = m17240a(packageManager.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource, i)) == null)) {
                    return a;
                }
                return resolveInfo.loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }

        /* renamed from: a */
        private Drawable m17240a(Resources resources, int i, int i2) {
            try {
                return resources.getDrawableForDensity(i, i2);
            } catch (Resources.NotFoundException unused) {
                return null;
            }
        }
    }
}
