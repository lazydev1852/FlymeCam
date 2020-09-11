package com.meizu.imageproc;

import android.view.Surface;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo27294d2 = {"Lcom/meizu/imageproc/SurfaceWrapper;", "", "()V", "createSurface", "Landroid/view/Surface;", "nativeObject", "", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.imageproc.b */
public final class SurfaceWrapper {

    /* renamed from: a */
    public static ChangeQuickRedirect f6471a;

    /* renamed from: b */
    public static final SurfaceWrapper f6472b = new SurfaceWrapper();

    private SurfaceWrapper() {
    }

    @Nullable
    /* renamed from: a */
    public final Surface mo17628a(long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, this, f6471a, false, 563, new Class[]{Long.TYPE}, Surface.class);
        if (proxy.isSupported) {
            return (Surface) proxy.result;
        }
        Surface surface = null;
        try {
            Class<?> cls = Class.forName("android.view.Surface");
            C3443i.m21152a((Object) cls, "Class.forName(\"android.view.Surface\")");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Long.TYPE});
            C3443i.m21152a((Object) declaredConstructor, "surfaceClass.getDeclared…:class.javaPrimitiveType)");
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(new Object[]{Long.valueOf(j)});
            if (newInstance != null) {
                return (Surface) newInstance;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.Surface");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return surface;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return surface;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return surface;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return surface;
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            return surface;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return surface;
        }
    }
}
