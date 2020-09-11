package com.meizu.share.utils;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.meizu.share.p079b.DisplayResolveInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.share.utils.b */
/* compiled from: ImageLoader */
public class C2828b {

    /* renamed from: c */
    private static volatile C2828b f15767c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Map<DisplayResolveInfo, C2830a> f15768a = new HashMap();

    /* renamed from: b */
    private Handler f15769b = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private C2833b f15770d = new C2833b() {
        @UiThread
        /* renamed from: a */
        public void mo24014a(DisplayResolveInfo bVar, List<WeakReference<ImageView>> list, Drawable drawable) {
            bVar.f15736c = drawable;
            C2828b.this.f15768a.remove(bVar);
            for (WeakReference<ImageView> weakReference : list) {
                ImageView imageView = (ImageView) weakReference.get();
                if (imageView != null && bVar.equals(imageView.getTag())) {
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        @UiThread
        /* renamed from: a */
        public void mo24015a(DisplayResolveInfo bVar, List<WeakReference<ImageView>> list, Exception exc) {
            C2828b.this.f15768a.remove(bVar);
        }
    };

    /* renamed from: com.meizu.share.utils.b$b */
    /* compiled from: ImageLoader */
    interface C2833b {
        @UiThread
        /* renamed from: a */
        void mo24014a(DisplayResolveInfo bVar, List<WeakReference<ImageView>> list, Drawable drawable);

        @UiThread
        /* renamed from: a */
        void mo24015a(DisplayResolveInfo bVar, List<WeakReference<ImageView>> list, Exception exc);
    }

    /* renamed from: a */
    public static C2828b m17174a() {
        if (f15767c == null) {
            synchronized (C2828b.class) {
                if (f15767c == null) {
                    f15767c = new C2828b();
                }
            }
        }
        return f15767c;
    }

    private C2828b() {
    }

    @UiThread
    /* renamed from: a */
    public void mo24013a(@NonNull ImageView imageView, @NonNull DisplayResolveInfo bVar, int i, @NonNull PackageManager packageManager, @NonNull Resources resources, int i2, int i3) {
        ImageView imageView2 = imageView;
        DisplayResolveInfo bVar2 = bVar;
        if (bVar2.f15736c != null) {
            imageView.setImageDrawable(bVar2.f15736c);
        } else if (bVar2.f15734a != null) {
            imageView.setTag(bVar);
            C2830a aVar = this.f15768a.get(bVar);
            if (aVar == null) {
                C2830a aVar2 = new C2830a(this.f15769b, this.f15770d, bVar, i, packageManager, resources, i2, i3);
                Executor.m17171a().mo24010a(aVar2);
                aVar2.mo24016a(imageView);
                this.f15768a.put(bVar, aVar2);
                return;
            }
            aVar.mo24016a(imageView);
        }
    }

    /* renamed from: com.meizu.share.utils.b$a */
    /* compiled from: ImageLoader */
    private static class C2830a implements Runnable {

        /* renamed from: a */
        private Handler f15772a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public List<WeakReference<ImageView>> f15773b = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C2833b f15774c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public DisplayResolveInfo f15775d;

        /* renamed from: e */
        private int f15776e;

        /* renamed from: f */
        private PackageManager f15777f;

        /* renamed from: g */
        private Resources f15778g;

        /* renamed from: h */
        private int f15779h;

        /* renamed from: i */
        private int f15780i;

        public C2830a(@NonNull Handler handler, @NonNull C2833b bVar, @NonNull DisplayResolveInfo bVar2, int i, @NonNull PackageManager packageManager, @NonNull Resources resources, int i2, int i3) {
            this.f15772a = handler;
            this.f15774c = bVar;
            this.f15775d = bVar2;
            this.f15776e = i;
            this.f15777f = packageManager;
            this.f15778g = resources;
            this.f15779h = i2;
            this.f15780i = i3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo24016a(ImageView imageView) {
            this.f15773b.add(new WeakReference(imageView));
        }

        public void run() {
            Drawable a = m17179a(this.f15777f, this.f15775d.f15734a, this.f15776e);
            final Drawable a2 = StrokeDrawableUtils.m17210a(a, this.f15779h, this.f15780i, this.f15778g, false);
            if (a == null) {
                this.f15772a.post(new Runnable() {
                    public void run() {
                        C2830a.this.f15774c.mo24015a(C2830a.this.f15775d, (List<WeakReference<ImageView>>) C2830a.this.f15773b, new Exception("displayIcon == null"));
                    }
                });
            } else {
                this.f15772a.post(new Runnable() {
                    public void run() {
                        C2830a.this.f15774c.mo24014a(C2830a.this.f15775d, (List<WeakReference<ImageView>>) C2830a.this.f15773b, a2);
                    }
                });
            }
        }

        /* renamed from: a */
        private Drawable m17179a(@NonNull PackageManager packageManager, ResolveInfo resolveInfo, int i) {
            Drawable a;
            Drawable a2;
            try {
                if (resolveInfo.resolvePackageName != null && resolveInfo.icon != 0 && (a2 = m17180a(packageManager.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon, i)) != null) {
                    return a2;
                }
                int iconResource = resolveInfo.getIconResource();
                if (!(iconResource == 0 || iconResource == resolveInfo.activityInfo.applicationInfo.icon || (a = m17180a(packageManager.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource, i)) == null)) {
                    return a;
                }
                return resolveInfo.loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }

        /* renamed from: a */
        private Drawable m17180a(Resources resources, int i, int i2) {
            try {
                return resources.getDrawableForDensity(i, i2);
            } catch (Resources.NotFoundException unused) {
                return null;
            }
        }
    }
}
