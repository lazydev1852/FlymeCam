package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.os.Build;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.OSUtils */
public class OSUtils {

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.OSUtils$ROM */
    public enum ROM {
        HUAWEI("huawei", "EMUI"),
        XIAOMI("xiaomi", "MIUI"),
        OPPO("oppo", "ColorOS"),
        VIVO("vivo", "FuntouchOS"),
        GOOGLE("google", "Google"),
        SAMSUNG("samsung", "SamSung"),
        SMARTISAN("smartisan", "SmartisanOS"),
        LETV("letv", "EUI"),
        HTC("htc", "Sense"),
        ZTE("zte", "MiFavor"),
        ONEPLUS("oneplus", "H2OS"),
        YULONG("yulong", "YuLong"),
        SONY("sony", "Sony"),
        LENOVO("lenovo", "Lenovo"),
        LG("lg", "LG"),
        OTHER("other", "UNKNOWN");
        
        /* access modifiers changed from: private */
        public String brand;
        /* access modifiers changed from: private */

        /* renamed from: os */
        public String f16002os;

        private ROM(String str, String str2) {
            this.f16002os = str2;
            this.brand = str;
        }
    }

    public static String getOtherBrandOs() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains(ROM.HUAWEI.brand)) {
            return ROM.HUAWEI.f16002os;
        }
        if (lowerCase.contains(ROM.XIAOMI.brand)) {
            return ROM.XIAOMI.f16002os;
        }
        if (lowerCase.contains(ROM.OPPO.brand)) {
            return ROM.OPPO.f16002os;
        }
        if (lowerCase.contains(ROM.VIVO.brand)) {
            return ROM.VIVO.f16002os;
        }
        if (lowerCase.contains(ROM.SAMSUNG.brand)) {
            return ROM.SAMSUNG.f16002os;
        }
        if (lowerCase.contains(ROM.SMARTISAN.brand)) {
            return ROM.SMARTISAN.f16002os;
        }
        if (lowerCase.contains(ROM.LG.brand)) {
            return ROM.LG.f16002os;
        }
        if (lowerCase.contains(ROM.LETV.brand)) {
            return ROM.LETV.f16002os;
        }
        if (lowerCase.contains(ROM.ZTE.brand)) {
            return ROM.ZTE.f16002os;
        }
        if (lowerCase.contains(ROM.YULONG.brand)) {
            return ROM.YULONG.f16002os;
        }
        if (lowerCase.contains(ROM.LENOVO.brand)) {
            return ROM.LENOVO.f16002os;
        }
        if (lowerCase.contains(ROM.SONY.brand)) {
            return ROM.SONY.f16002os;
        }
        if (lowerCase.contains(ROM.GOOGLE.brand)) {
            return ROM.GOOGLE.f16002os;
        }
        if (lowerCase.contains(ROM.ONEPLUS.brand)) {
            return ROM.ONEPLUS.f16002os;
        }
        if (lowerCase.contains(ROM.HTC.brand)) {
            return ROM.HTC.f16002os;
        }
        return ROM.OTHER.f16002os;
    }
}
