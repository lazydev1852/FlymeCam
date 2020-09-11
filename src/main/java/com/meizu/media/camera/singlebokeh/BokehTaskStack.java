package com.meizu.media.camera.singlebokeh;

import com.meizu.media.camera.singlebokeh.BokehProcessTask;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.LinkedList;

/* renamed from: com.meizu.media.camera.singlebokeh.b */
public class BokehTaskStack {

    /* renamed from: a */
    public static ChangeQuickRedirect f12188a;

    /* renamed from: b */
    private LinkedList<BokehProcessTask.C2362a> f12189b = new LinkedList<>();

    /* renamed from: a */
    public void mo21432a(BokehProcessTask.C2362a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f12188a, false, 6223, new Class[]{BokehProcessTask.C2362a.class}, Void.TYPE).isSupported) {
            this.f12189b.addFirst(aVar);
        }
    }

    /* renamed from: a */
    public BokehProcessTask.C2362a mo21431a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12188a, false, 6225, new Class[0], BokehProcessTask.C2362a.class);
        return proxy.isSupported ? (BokehProcessTask.C2362a) proxy.result : this.f12189b.removeFirst();
    }

    /* renamed from: b */
    public int mo21433b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12188a, false, 6226, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f12189b.size();
    }
}
