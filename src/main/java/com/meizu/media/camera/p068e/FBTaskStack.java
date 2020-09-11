package com.meizu.media.camera.p068e;

import com.meizu.media.camera.p068e.FBProcessTask;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.LinkedList;

/* renamed from: com.meizu.media.camera.e.d */
public class FBTaskStack {

    /* renamed from: a */
    public static ChangeQuickRedirect f9924a;

    /* renamed from: b */
    private LinkedList<FBProcessTask.C2040a> f9925b = new LinkedList<>();

    /* renamed from: a */
    public void mo20011a(FBProcessTask.C2040a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f9924a, false, 4044, new Class[]{FBProcessTask.C2040a.class}, Void.TYPE).isSupported) {
            this.f9925b.addFirst(aVar);
        }
    }

    /* renamed from: a */
    public FBProcessTask.C2040a mo20010a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9924a, false, 4046, new Class[0], FBProcessTask.C2040a.class);
        return proxy.isSupported ? (FBProcessTask.C2040a) proxy.result : this.f9925b.removeFirst();
    }

    /* renamed from: b */
    public int mo20012b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9924a, false, 4047, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f9925b.size();
    }
}
