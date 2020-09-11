package com.baidu.p020ar.blend.filter.configdata;

import java.util.List;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.blend.filter.configdata.FilterData */
public class FilterData {

    /* renamed from: a */
    int f1405a;

    /* renamed from: b */
    PassType f1406b;

    /* renamed from: c */
    PassSubType f1407c;

    /* renamed from: d */
    String f1408d;

    /* renamed from: e */
    String f1409e;

    /* renamed from: f */
    String f1410f;

    /* renamed from: g */
    List<String> f1411g;

    /* renamed from: h */
    JSONObject f1412h;

    /* renamed from: com.baidu.ar.blend.filter.configdata.FilterData$AdjustType */
    public enum AdjustType {
        NONE(-1),
        INT(0),
        FLOAT(1),
        POINT(2),
        VEC3(3),
        VEC4(4),
        SIZE(5),
        MAP(6),
        MAT3(7),
        MAT4(8);
        
        private final int mValue;

        private AdjustType(int i) {
            this.mValue = i;
        }

        /* renamed from: a */
        public static AdjustType m1726a(int i) {
            for (AdjustType adjustType : values()) {
                if (adjustType.mo9948a() == i) {
                    return adjustType;
                }
            }
            return NONE;
        }

        /* renamed from: a */
        public int mo9948a() {
            return this.mValue;
        }
    }

    /* renamed from: com.baidu.ar.blend.filter.configdata.FilterData$PassSubType */
    public enum PassSubType {
        NONE("none"),
        BRIGHTNESS("brightness"),
        CONTRAST("contrast"),
        EXPOSURE("exposure"),
        SATURATION("saturation"),
        HSB("hsb"),
        SATURATION_PS("saturation_ps"),
        GRAY_SCALE("grayscale"),
        CURVE_PS("curve_ps"),
        CURVE_RIGHT("curve_right"),
        CURVE_LEFT("curve_left"),
        MULTI_PICTURE_BLEND("multi_picture_blend"),
        LOOK_UP("look_up"),
        GAUSSIAN_BLUR("gaussian_blur");
        
        private final String mValue;

        private PassSubType(String str) {
            this.mValue = str;
        }

        /* renamed from: a */
        public static PassSubType m1728a(String str) {
            if (str == null) {
                return NONE;
            }
            for (PassSubType passSubType : values()) {
                if (passSubType.mo9949a().equalsIgnoreCase(str)) {
                    return passSubType;
                }
            }
            return NONE;
        }

        /* renamed from: a */
        public String mo9949a() {
            return this.mValue;
        }
    }

    /* renamed from: com.baidu.ar.blend.filter.configdata.FilterData$PassType */
    public enum PassType {
        NONE("none"),
        CURVE("curve"),
        COLOR_ADJUST("color_adjust"),
        BEAUTY("beauty"),
        MASK_BLEND("mask_blend"),
        CUSTOM("custom"),
        STYLIZE("stylize");
        
        private final String mValue;

        private PassType(String str) {
            this.mValue = str;
        }

        /* renamed from: a */
        public static PassType m1730a(String str) {
            if (str == null) {
                return NONE;
            }
            for (PassType passType : values()) {
                if (passType.mo9950a().equalsIgnoreCase(str)) {
                    return passType;
                }
            }
            return NONE;
        }

        /* renamed from: a */
        public String mo9950a() {
            return this.mValue;
        }
    }

    /* renamed from: com.baidu.ar.blend.filter.configdata.FilterData$ResetType */
    public enum ResetType {
        NONE(-1),
        UPDATE(0),
        ADD(1),
        DELETE(2);
        
        private final int mValue;

        private ResetType(int i) {
            this.mValue = i;
        }

        /* renamed from: a */
        public static ResetType m1732a(int i) {
            for (ResetType resetType : values()) {
                if (resetType.mo9951a() == i) {
                    return resetType;
                }
            }
            return NONE;
        }

        /* renamed from: a */
        public int mo9951a() {
            return this.mValue;
        }
    }

    /* renamed from: a */
    public int mo9932a() {
        return this.f1405a;
    }

    /* renamed from: a */
    public void mo9933a(int i) {
        this.f1405a = i;
    }

    /* renamed from: a */
    public void mo9934a(PassSubType passSubType) {
        this.f1407c = passSubType;
    }

    /* renamed from: a */
    public void mo9935a(PassType passType) {
        this.f1406b = passType;
    }

    /* renamed from: a */
    public void mo9936a(String str) {
        this.f1408d = str;
    }

    /* renamed from: a */
    public void mo9937a(List<String> list) {
        this.f1411g = list;
    }

    /* renamed from: a */
    public void mo9938a(JSONObject jSONObject) {
        this.f1412h = jSONObject;
    }

    /* renamed from: b */
    public PassType mo9939b() {
        return this.f1406b;
    }

    /* renamed from: b */
    public void mo9940b(String str) {
        this.f1409e = str;
    }

    /* renamed from: c */
    public PassSubType mo9941c() {
        return this.f1407c;
    }

    /* renamed from: c */
    public void mo9942c(String str) {
        this.f1410f = str;
    }

    /* renamed from: d */
    public String mo9943d() {
        return this.f1408d;
    }

    /* renamed from: e */
    public String mo9944e() {
        return this.f1409e;
    }

    /* renamed from: f */
    public String mo9945f() {
        return this.f1410f;
    }

    /* renamed from: g */
    public List<String> mo9946g() {
        return this.f1411g;
    }

    /* renamed from: h */
    public JSONObject mo9947h() {
        return this.f1412h;
    }
}
