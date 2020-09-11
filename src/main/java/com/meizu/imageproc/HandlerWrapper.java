package com.meizu.imageproc;

import android.os.Handler;
import android.os.Looper;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/imageproc/HandlerWrapper;", "", "()V", "createHandler", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "callback", "Landroid/os/Handler$Callback;", "async", "", "effectlib_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.imageproc.a */
public final class HandlerWrapper {

    /* renamed from: a */
    public static ChangeQuickRedirect f6469a;

    /* renamed from: b */
    public static final HandlerWrapper f6470b = new HandlerWrapper();

    private HandlerWrapper() {
    }

    @Nullable
    /* renamed from: a */
    public final Handler mo17627a(@NotNull Looper looper, @NotNull Handler.Callback callback, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{looper, callback, new Byte(z ? (byte) 1 : 0)}, this, f6469a, false, MsgConstants.SLAM_GESTURE_INTERACTION, new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}, Handler.class);
        if (proxy.isSupported) {
            return (Handler) proxy.result;
        }
        C3443i.m21155b(looper, "looper");
        C3443i.m21155b(callback, "callback");
        Handler handler = null;
        try {
            Class<?> cls = Class.forName("android.os.Handler");
            C3443i.m21152a((Object) cls, "Class.forName(\"android.os.Handler\")");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});
            C3443i.m21152a((Object) declaredConstructor, "handlerClass.getDeclared…:class.javaPrimitiveType)");
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(new Object[]{looper, callback, Boolean.valueOf(z)});
            if (newInstance != null) {
                return (Handler) newInstance;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return handler;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return handler;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return handler;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return handler;
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            return handler;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return handler;
        }
    }
}
