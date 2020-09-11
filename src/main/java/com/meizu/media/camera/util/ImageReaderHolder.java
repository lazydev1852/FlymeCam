package com.meizu.media.camera.util;

import android.graphics.Point;
import android.media.ImageReader;
import android.os.Handler;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ*\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo27294d2 = {"Lcom/meizu/media/camera/util/ImageReaderHolder;", "", "()V", "mImageReader", "Landroid/media/ImageReader;", "mPreviewSize", "Landroid/graphics/Point;", "cleanImageReader", "", "getImageReader", "maxImages", "", "imageFormat", "listener", "Landroid/media/ImageReader$OnImageAvailableListener;", "handler", "Landroid/os/Handler;", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.util.y */
public final class ImageReaderHolder {

    /* renamed from: a */
    public static ChangeQuickRedirect f14377a;

    /* renamed from: b */
    public static final C2666a f14378b = new C2666a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static ImageReaderHolder f14379e;

    /* renamed from: c */
    private Point f14380c;

    /* renamed from: d */
    private ImageReader f14381d;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo27294d2 = {"Lcom/meizu/media/camera/util/ImageReaderHolder$Companion;", "", "()V", "instance", "Lcom/meizu/media/camera/util/ImageReaderHolder;", "getInstance", "()Lcom/meizu/media/camera/util/ImageReaderHolder;", "setInstance", "(Lcom/meizu/media/camera/util/ImageReaderHolder;)V", "get", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.util.y$a */
    /* compiled from: ImageReaderHolder.kt */
    public static final class C2666a {

        /* renamed from: a */
        public static ChangeQuickRedirect f14382a;

        private C2666a() {
        }

        public /* synthetic */ C2666a(DefaultConstructorMarker gVar) {
            this();
        }

        /* renamed from: b */
        private final ImageReaderHolder m16295b() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14382a, false, 8097, new Class[0], ImageReaderHolder.class);
            if (proxy.isSupported) {
                return (ImageReaderHolder) proxy.result;
            }
            if (ImageReaderHolder.f14379e == null) {
                ImageReaderHolder.f14379e = new ImageReaderHolder();
            }
            return ImageReaderHolder.f14379e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            return r0;
         */
        @org.jetbrains.annotations.NotNull
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized com.meizu.media.camera.util.ImageReaderHolder mo22759a() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002a }
                com.meizu.savior.ChangeQuickRedirect r3 = f14382a     // Catch:{ all -> 0x002a }
                r4 = 0
                r5 = 8099(0x1fa3, float:1.1349E-41)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x002a }
                java.lang.Class<com.meizu.media.camera.util.y> r7 = com.meizu.media.camera.util.ImageReaderHolder.class
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002a }
                boolean r1 = r0.isSupported     // Catch:{ all -> 0x002a }
                if (r1 == 0) goto L_0x001c
                java.lang.Object r0 = r0.result     // Catch:{ all -> 0x002a }
                com.meizu.media.camera.util.y r0 = (com.meizu.media.camera.util.ImageReaderHolder) r0     // Catch:{ all -> 0x002a }
                monitor-exit(r8)
                return r0
            L_0x001c:
                r0 = r8
                com.meizu.media.camera.util.y$a r0 = (com.meizu.media.camera.util.ImageReaderHolder.C2666a) r0     // Catch:{ all -> 0x002a }
                com.meizu.media.camera.util.y r0 = r0.m16295b()     // Catch:{ all -> 0x002a }
                if (r0 != 0) goto L_0x0028
                kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x002a }
            L_0x0028:
                monitor-exit(r8)
                return r0
            L_0x002a:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.ImageReaderHolder.C2666a.mo22759a():com.meizu.media.camera.util.y");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r1.y != r0.y) goto L_0x0072;
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.media.ImageReader mo22757a(int r11, int r12, @org.jetbrains.annotations.Nullable android.media.ImageReader.OnImageAvailableListener r13, @org.jetbrains.annotations.Nullable android.os.Handler r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 4
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x00cc }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x00cc }
            r2.<init>(r11)     // Catch:{ all -> 0x00cc }
            r3 = 0
            r1[r3] = r2     // Catch:{ all -> 0x00cc }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x00cc }
            r2.<init>(r12)     // Catch:{ all -> 0x00cc }
            r4 = 1
            r1[r4] = r2     // Catch:{ all -> 0x00cc }
            r2 = 2
            r1[r2] = r13     // Catch:{ all -> 0x00cc }
            r5 = 3
            r1[r5] = r14     // Catch:{ all -> 0x00cc }
            com.meizu.savior.ChangeQuickRedirect r6 = f14377a     // Catch:{ all -> 0x00cc }
            r7 = 0
            r8 = 8095(0x1f9f, float:1.1344E-41)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x00cc }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00cc }
            r0[r3] = r9     // Catch:{ all -> 0x00cc }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00cc }
            r0[r4] = r3     // Catch:{ all -> 0x00cc }
            java.lang.Class<android.media.ImageReader$OnImageAvailableListener> r3 = android.media.ImageReader.OnImageAvailableListener.class
            r0[r2] = r3     // Catch:{ all -> 0x00cc }
            java.lang.Class<android.os.Handler> r2 = android.os.Handler.class
            r0[r5] = r2     // Catch:{ all -> 0x00cc }
            java.lang.Class<android.media.ImageReader> r9 = android.media.ImageReader.class
            r2 = r10
            r3 = r6
            r4 = r7
            r5 = r8
            r6 = r0
            r7 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00cc }
            boolean r1 = r0.isSupported     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x0047
            java.lang.Object r11 = r0.result     // Catch:{ all -> 0x00cc }
            android.media.ImageReader r11 = (android.media.ImageReader) r11     // Catch:{ all -> 0x00cc }
            monitor-exit(r10)
            return r11
        L_0x0047:
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00cc }
            android.graphics.Point r0 = r0.mo19524l()     // Catch:{ all -> 0x00cc }
            android.graphics.Point r1 = r10.f14380c     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x0072
            android.graphics.Point r1 = r10.f14380c     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x005f
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00cc }
        L_0x005f:
            int r1 = r1.x     // Catch:{ all -> 0x00cc }
            int r2 = r0.x     // Catch:{ all -> 0x00cc }
            if (r1 != r2) goto L_0x0072
            android.graphics.Point r1 = r10.f14380c     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x006c
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00cc }
        L_0x006c:
            int r1 = r1.y     // Catch:{ all -> 0x00cc }
            int r2 = r0.y     // Catch:{ all -> 0x00cc }
            if (r1 == r2) goto L_0x0091
        L_0x0072:
            r10.f14380c = r0     // Catch:{ all -> 0x00cc }
            android.media.ImageReader r0 = r10.f14381d     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x0091
            android.media.ImageReader r0 = r10.f14381d     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x007f
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00cc }
        L_0x007f:
            r0.close()     // Catch:{ all -> 0x00cc }
            android.media.ImageReader r0 = r10.f14381d     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x0089
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00cc }
        L_0x0089:
            r1 = 0
            r0.setOnImageAvailableListener(r1, r1)     // Catch:{ all -> 0x00cc }
            android.media.ImageReader r1 = (android.media.ImageReader) r1     // Catch:{ all -> 0x00cc }
            r10.f14381d = r1     // Catch:{ all -> 0x00cc }
        L_0x0091:
            android.media.ImageReader r0 = r10.f14381d     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x00ad
            android.graphics.Point r0 = r10.f14380c     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x009c
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00cc }
        L_0x009c:
            int r0 = r0.x     // Catch:{ all -> 0x00cc }
            android.graphics.Point r1 = r10.f14380c     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x00a5
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00cc }
        L_0x00a5:
            int r1 = r1.y     // Catch:{ all -> 0x00cc }
            android.media.ImageReader r11 = android.media.ImageReader.newInstance(r0, r1, r12, r11)     // Catch:{ all -> 0x00cc }
            r10.f14381d = r11     // Catch:{ all -> 0x00cc }
        L_0x00ad:
            android.media.ImageReader r11 = r10.f14381d     // Catch:{ all -> 0x00cc }
            if (r11 != 0) goto L_0x00b4
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00cc }
        L_0x00b4:
            monitor-enter(r11)     // Catch:{ all -> 0x00cc }
            android.media.ImageReader r12 = r10.f14381d     // Catch:{ all -> 0x00c9 }
            if (r12 != 0) goto L_0x00bc
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00c9 }
        L_0x00bc:
            r12.setOnImageAvailableListener(r13, r14)     // Catch:{ all -> 0x00c9 }
            android.media.ImageReader r12 = r10.f14381d     // Catch:{ all -> 0x00c9 }
            if (r12 != 0) goto L_0x00c6
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x00c9 }
        L_0x00c6:
            monitor-exit(r11)     // Catch:{ all -> 0x00cc }
            monitor-exit(r10)
            return r12
        L_0x00c9:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00cc }
            throw r12     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.ImageReaderHolder.mo22757a(int, int, android.media.ImageReader$OnImageAvailableListener, android.os.Handler):android.media.ImageReader");
    }

    /* renamed from: a */
    public final void mo22758a() {
        if (!PatchProxy.proxy(new Object[0], this, f14377a, false, 8096, new Class[0], Void.TYPE).isSupported && this.f14381d != null) {
            ImageReader imageReader = this.f14381d;
            if (imageReader == null) {
                C3443i.m21151a();
            }
            synchronized (imageReader) {
                ImageReader imageReader2 = this.f14381d;
                if (imageReader2 == null) {
                    C3443i.m21151a();
                }
                imageReader2.close();
                ImageReader imageReader3 = this.f14381d;
                if (imageReader3 == null) {
                    C3443i.m21151a();
                }
                imageReader3.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                this.f14381d = null;
                Unit tVar = Unit.f18749a;
            }
        }
    }
}
