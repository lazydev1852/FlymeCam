package com.meizu.media.camera.barcode.result;

import android.view.View;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.barcode.result.h */
public final class ResultButtonListener implements View.OnClickListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f8101a;

    /* renamed from: b */
    private final ResultHandler f8102b;

    /* renamed from: c */
    private final int f8103c;

    /* renamed from: d */
    private final String f8104d;

    public ResultButtonListener(ResultHandler iVar, int i, String str) {
        this.f8102b = iVar;
        this.f8103c = i;
        this.f8104d = str;
    }

    public void onClick(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f8101a, false, 2623, new Class[]{View.class}, Void.TYPE).isSupported) {
            this.f8102b.mo19171a(this.f8103c, this.f8104d);
        }
    }
}
