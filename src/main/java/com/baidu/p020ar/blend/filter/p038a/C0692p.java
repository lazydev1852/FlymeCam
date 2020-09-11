package com.baidu.p020ar.blend.filter.p038a;

import com.baidu.p020ar.blend.filter.configdata.FilterData;

/* renamed from: com.baidu.ar.blend.filter.a.p */
public class C0692p {
    /* renamed from: a */
    public static C0694q m1703a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        FilterData.PassType b = filterData.mo9939b();
        FilterData.PassSubType c = filterData.mo9941c();
        switch (b) {
            case COLOR_ADJUST:
                switch (c) {
                    case BRIGHTNESS:
                        return new C0676b();
                    case CONTRAST:
                        return new C0677c();
                    case SATURATION:
                        return new C0690n();
                    case SATURATION_PS:
                        return new C0691o();
                    case EXPOSURE:
                        return new C0683h();
                    case GRAY_SCALE:
                        return new C0685j();
                    case HSB:
                        return new C0686k();
                    default:
                        return null;
                }
            case BEAUTY:
                return new C0675a();
            case MASK_BLEND:
                switch (c) {
                    case LOOK_UP:
                        return new C0688l();
                    case MULTI_PICTURE_BLEND:
                        return new C0689m();
                    case CURVE_PS:
                        return new C0679e();
                    case CURVE_RIGHT:
                        return new C0680f();
                    case CURVE_LEFT:
                        return new C0678d();
                    default:
                        return null;
                }
            case CUSTOM:
                return new C0681g();
            case STYLIZE:
                if (C06931.f1401a[c.ordinal()] != 13) {
                    return null;
                }
                return new C0684i();
            default:
                return null;
        }
    }
}
