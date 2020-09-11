package com.baidu.p020ar.p021a.p026b.p029c;

import android.os.Bundle;
import com.baidu.p020ar.p021a.p022a.p024b.C0494b;
import com.baidu.p020ar.p021a.p026b.p027a.C0499a;
import com.baidu.p020ar.p021a.p026b.p027a.C0500b;
import com.baidu.p020ar.slam.TrackParams;

/* renamed from: com.baidu.ar.a.b.c.a */
public class C0505a extends C0500b {

    /* renamed from: e */
    private C0494b f612e;

    public C0505a(byte[] bArr, int i, int i2, C0494b bVar, C0499a aVar) {
        super(bArr, i, i2, aVar);
        this.f612e = bVar;
    }

    /* renamed from: b */
    public void mo8962b() {
        if (this.f612e != null) {
            TrackParams a = this.f612e.mo8944a(mo8963c());
            if (a != null) {
                float f = a.processTime;
                int i = a.trackQuality;
                int a2 = this.f612e.mo8942a((int) f);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("slam_track_result", this.f612e.mo8948b());
                bundle.putInt("slam_track_quality", i);
                bundle.putFloat("slam_process_time", f);
                bundle.putString("slam_track_status", a.extendedStatusStr);
                bundle.putInt("average_time", a2);
                if (this.f596c != null) {
                    this.f596c.mo8959a(bundle);
                }
            } else if (this.f596c != null) {
                this.f596c.mo8959a((Bundle) null);
            }
        }
    }
}
