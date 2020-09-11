package com.meizu.safe.engine.url;

import com.meizu.media.camera.R;
import com.meizu.media.camera.app.AndroidContext;

/* renamed from: com.meizu.safe.engine.url.d */
public class UrlChkUtils {
    /* renamed from: a */
    public static String m16978a(MzUrlCheckResult mzUrlCheckResult) {
        if (mzUrlCheckResult.f15641b == 0) {
            return "";
        }
        switch (mzUrlCheckResult.f15642c) {
            case 1:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_CHEAT1);
            case 2:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_CHEAT2);
            case 3:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_FAULTSALES);
            case 4:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_MALICEFILE);
            case 5:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_LOTTERYWEB);
            case 6:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_SEXYWEB);
            case 7:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_RISKWEB);
            case 8:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_ILLEGALCONTENT);
            default:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_type_EVIL_NOEVIL);
        }
    }

    /* renamed from: b */
    public static String m16979b(MzUrlCheckResult mzUrlCheckResult) {
        if (mzUrlCheckResult.f15641b == 0 || mzUrlCheckResult.f15642c == 0) {
            return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_REGULAR);
        }
        int i = mzUrlCheckResult.f15643d;
        switch (i) {
            case 0:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_REGULAR);
            case 1:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_COCKHORSE);
            case 2:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_DEFAULT_CHEAT);
            case 3:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_MONEY_CHEAT);
            case 4:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_SP_SERVICE);
            case 5:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_STEAL_ACCOUNT);
            case 6:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_TIPS_CHEAT);
            case 7:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_TIPS_DEFAULT);
            case 8:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_GAMES_HANG);
            case 9:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_MAKE_MONEY);
            case 10:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_SEX);
            case 11:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_PRIVATE_SERVER);
            case 12:
                return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_MSG_REACTIONARY);
            default:
                switch (i) {
                    case 18:
                        return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_MSG_SHADINESS);
                    case 19:
                        return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_MSG_BLOG);
                    default:
                        return AndroidContext.m8284a().mo19002b().getString(R.string.harm_url_desc_HARM_UNKNOWN);
                }
        }
    }
}
