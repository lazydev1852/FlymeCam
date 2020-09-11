package com.meizu.common.renderer.effect;

import com.meizu.common.renderer.wrapper.GLES20Wrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.meizu.common.renderer.effect.f */
public class GLRecycler {

    /* renamed from: f */
    private static int[] f4469f = new int[1];

    /* renamed from: a */
    private final SynchronizedIntArray f4470a = new SynchronizedIntArray();

    /* renamed from: b */
    private final SynchronizedIntArray f4471b = new SynchronizedIntArray();

    /* renamed from: c */
    private final SynchronizedIntArray f4472c = new SynchronizedIntArray();

    /* renamed from: d */
    private final SynchronizedIntArray f4473d = new SynchronizedIntArray();

    /* renamed from: e */
    private final List<Integer> f4474e = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    public void mo15961a(int i, boolean z) {
        if (!z) {
            this.f4470a.mo15971a(i);
            return;
        }
        f4469f[0] = i;
        GLES20Wrapper.glDeleteTextures(1, f4469f, 0);
    }

    /* renamed from: b */
    public void mo15963b(int i, boolean z) {
        if (i != 0) {
            if (!z) {
                this.f4473d.mo15971a(i);
                return;
            }
            f4469f[0] = i;
            GLES20Wrapper.glDeleteRenderbuffers(1, f4469f, 0);
        }
    }

    /* renamed from: c */
    public void mo15964c(int i, boolean z) {
        if (i != 0) {
            if (!z) {
                this.f4472c.mo15971a(i);
                return;
            }
            f4469f[0] = i;
            GLES20Wrapper.glDeleteFramebuffers(1, f4469f, 0);
        }
    }

    /* renamed from: d */
    public void mo15965d(int i, boolean z) {
        if (i != 0) {
            if (!z) {
                this.f4474e.add(Integer.valueOf(i));
            } else {
                GLES20Wrapper.glDeleteProgram(i);
            }
        }
    }

    /* renamed from: a */
    public void mo15962a(boolean z) {
        SynchronizedIntArray jVar = this.f4470a;
        if (jVar.mo15970a() > 0) {
            if (z) {
                GLES20Wrapper.glDeleteTextures(jVar.mo15970a(), jVar.mo15972b(), 0);
            }
            jVar.mo15973c();
        }
        SynchronizedIntArray jVar2 = this.f4471b;
        if (jVar2.mo15970a() > 0) {
            if (z) {
                GLES20Wrapper.glDeleteBuffers(jVar2.mo15970a(), jVar2.mo15972b(), 0);
            }
            jVar2.mo15973c();
        }
        SynchronizedIntArray jVar3 = this.f4473d;
        if (jVar3.mo15970a() > 0) {
            if (z) {
                GLES20Wrapper.glDeleteRenderbuffers(jVar3.mo15970a(), jVar3.mo15972b(), 0);
            }
            jVar3.mo15973c();
        }
        SynchronizedIntArray jVar4 = this.f4472c;
        if (jVar4.mo15970a() > 0) {
            if (z) {
                GLES20Wrapper.glDeleteFramebuffers(jVar4.mo15970a(), jVar4.mo15972b(), 0);
            }
            jVar4.mo15973c();
        }
        if (z) {
            for (Integer intValue : this.f4474e) {
                GLES20Wrapper.glDeleteProgram(intValue.intValue());
            }
        }
        this.f4474e.clear();
    }
}
