package com.meizu.common.renderer.functor;

import android.os.Build;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.meizu.common.renderer.functor.a */
public class InvokeFunctor extends DrawGLFunctor {
    public void invoke() {
        invokeFunctorInternal(true);
    }

    public void invoke(boolean z) {
        invokeFunctorInternal(z);
    }

    /* access modifiers changed from: protected */
    public boolean invokeFunctorInternal(boolean z) {
        if (this.mNativeFunctor != 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (EGL10.EGL_NO_CONTEXT.equals(((EGL10) EGLContext.getEGL()).eglGetCurrentContext())) {
                    Log.e("glrenderer", "invokeFunctor fail,sdk version = " + Build.VERSION.SDK_INT);
                    return false;
                }
                onInvoke(1);
                return true;
            } else if (sMethod_invokeFunctor != null) {
                try {
                    sMethod_invokeFunctor.invoke((Object) null, new Object[]{Long.valueOf(this.mNativeFunctor), Boolean.valueOf(z)});
                } catch (Exception e) {
                    Log.e("glrenderer", "invokeFunctor method doesn't exist" + e.getMessage());
                }
                return true;
            }
        }
        return false;
    }
}
