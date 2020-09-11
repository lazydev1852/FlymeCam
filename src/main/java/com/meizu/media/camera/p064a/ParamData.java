package com.meizu.media.camera.p064a;

import android.graphics.Rect;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import com.meizu.media.camera.util.Contants;
import java.io.Serializable;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.a.f */
public class ParamData implements Serializable {

    /* renamed from: A */
    public String f7459A;

    /* renamed from: B */
    public String f7460B;

    /* renamed from: C */
    public boolean f7461C;

    /* renamed from: D */
    public boolean f7462D;

    /* renamed from: E */
    public boolean f7463E;

    /* renamed from: a */
    public UUID f7464a;

    /* renamed from: b */
    public String f7465b;

    /* renamed from: c */
    public long f7466c;

    /* renamed from: d */
    public int f7467d;

    /* renamed from: e */
    public Location f7468e;

    /* renamed from: f */
    public byte[] f7469f;

    /* renamed from: g */
    public FaceBeautyData f7470g;

    /* renamed from: h */
    public Contants.CameraService.RequestCode f7471h;

    /* renamed from: i */
    public int f7472i;

    /* renamed from: j */
    public int f7473j;

    /* renamed from: k */
    public boolean f7474k;

    /* renamed from: l */
    public boolean f7475l;

    /* renamed from: m */
    public boolean f7476m;

    /* renamed from: n */
    public int f7477n;

    /* renamed from: o */
    public int f7478o;

    /* renamed from: p */
    public Rect f7479p;

    /* renamed from: q */
    public TotalCaptureResult f7480q;

    /* renamed from: r */
    public boolean f7481r;

    /* renamed from: s */
    public boolean f7482s;

    /* renamed from: t */
    public boolean f7483t;

    /* renamed from: u */
    public XmpMetaData f7484u;

    /* renamed from: v */
    public CaptureResultData f7485v;

    /* renamed from: w */
    public int f7486w;

    /* renamed from: x */
    public boolean f7487x;

    /* renamed from: y */
    public boolean f7488y;

    /* renamed from: z */
    public String f7489z;

    public ParamData(UUID uuid, Contants.CameraService.RequestCode requestCode) {
        this.f7464a = uuid;
        this.f7471h = requestCode;
    }

    /* renamed from: a */
    public ParamData mo18731a(String str) {
        this.f7465b = str;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18724a(long j) {
        this.f7466c = j;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18723a(int i) {
        this.f7467d = i;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18727a(Location location) {
        this.f7468e = location;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18733a(byte[] bArr) {
        this.f7469f = bArr;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18729a(FaceBeautyData dVar) {
        this.f7470g = dVar;
        return this;
    }

    /* renamed from: b */
    public ParamData mo18734b(int i) {
        this.f7472i = i;
        return this;
    }

    /* renamed from: c */
    public ParamData mo18737c(int i) {
        this.f7473j = i;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18732a(boolean z) {
        this.f7474k = z;
        return this;
    }

    /* renamed from: b */
    public ParamData mo18736b(boolean z) {
        this.f7475l = z;
        return this;
    }

    /* renamed from: c */
    public ParamData mo18739c(boolean z) {
        this.f7476m = z;
        return this;
    }

    /* renamed from: d */
    public ParamData mo18740d(int i) {
        this.f7477n = i;
        return this;
    }

    /* renamed from: e */
    public ParamData mo18743e(int i) {
        this.f7478o = i;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18725a(Rect rect) {
        this.f7479p = rect;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18726a(TotalCaptureResult totalCaptureResult) {
        this.f7480q = totalCaptureResult;
        return this;
    }

    /* renamed from: d */
    public ParamData mo18742d(boolean z) {
        this.f7481r = z;
        return this;
    }

    /* renamed from: e */
    public ParamData mo18744e(boolean z) {
        this.f7482s = z;
        return this;
    }

    /* renamed from: f */
    public ParamData mo18746f(boolean z) {
        this.f7483t = z;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18730a(XmpMetaData gVar) {
        this.f7484u = gVar;
        return this;
    }

    /* renamed from: a */
    public ParamData mo18728a(CaptureResultData bVar) {
        this.f7485v = bVar;
        return this;
    }

    /* renamed from: f */
    public ParamData mo18745f(int i) {
        this.f7486w = i;
        return this;
    }

    /* renamed from: g */
    public ParamData mo18747g(boolean z) {
        this.f7487x = z;
        return this;
    }

    /* renamed from: h */
    public ParamData mo18748h(boolean z) {
        this.f7488y = z;
        return this;
    }

    /* renamed from: b */
    public ParamData mo18735b(String str) {
        this.f7489z = str;
        return this;
    }

    /* renamed from: c */
    public ParamData mo18738c(String str) {
        this.f7459A = str;
        return this;
    }

    /* renamed from: d */
    public ParamData mo18741d(String str) {
        this.f7460B = str;
        return this;
    }

    /* renamed from: i */
    public ParamData mo18749i(boolean z) {
        this.f7461C = z;
        return this;
    }

    /* renamed from: j */
    public ParamData mo18750j(boolean z) {
        this.f7462D = z;
        return this;
    }

    /* renamed from: k */
    public ParamData mo18751k(boolean z) {
        this.f7463E = z;
        return this;
    }
}
