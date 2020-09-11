package com.meizu.media.mzfunnysnapsdk.Filter;

import com.meizu.media.mzfunnysnapsdk.R;
import com.meizu.savior.ChangeQuickRedirect;

public class LookupFilterFactory {
    private static final String LOOKUPFILTR = "LookupFilter";
    private static final String TAG = "LookupFilterFactory";

    /* renamed from: com.meizu.media.mzfunnysnapsdk.Filter.LookupFilterFactory$Filter */
    public enum C2762Filter {
        NONE(0, "None", "lookup/original512.zip", R.drawable.origin, "无效果", "無效果", "none", R.color.orgin),
        NATURE(1, LookupFilterFactory.LOOKUPFILTR, "lookup/Nature201806.zip", R.drawable.nature, "自然", "自然", "nature", R.color.nature),
        SOMMER(2, LookupFilterFactory.LOOKUPFILTR, "lookup/sommer201806.zip", R.drawable.sommer, "水光", "水光", "sommer", R.color.sommer),
        FEIYAN(3, LookupFilterFactory.LOOKUPFILTR, "lookup/feiyan201806.zip", R.drawable.feiyan, "白皙", "白皙", "white", R.color.feiyan),
        PINK(4, LookupFilterFactory.LOOKUPFILTR, "lookup/pink.zip", R.drawable.pink, "粉黛", "粉黛", "pink", R.color.pink),
        BLUE(5, LookupFilterFactory.LOOKUPFILTR, "lookup/blue.zip", R.drawable.blue, "可爱", "可愛", "cute", R.color.blue),
        ROMANCE(6, LookupFilterFactory.LOOKUPFILTR, "lookup/romance201806.zip", R.drawable.romance, "浪漫", "浪漫", "romance", R.color.romance),
        FACEBEAUTY(7, LookupFilterFactory.LOOKUPFILTR, "lookup/skinWhiten.zip", R.drawable.skin, "嫩肤", "嫩膚", "skin", R.color.skin);
        
        public static ChangeQuickRedirect changeQuickRedirect;
        private int mColorID;
        private int mFilterID;
        private String mFilterType;
        private String mRenderNameCn;
        private String mRenderNameEn;
        private String mRenderNameTrCn;
        private int mResourceID;
        private String mResourcePath;

        private C2762Filter(int i, String str, String str2, int i2, String str3, String str4, String str5, int i3) {
            this.mFilterID = i;
            this.mFilterType = str;
            this.mResourcePath = str2;
            this.mResourceID = i2;
            this.mRenderNameCn = str3;
            this.mRenderNameTrCn = str4;
            this.mRenderNameEn = str5;
            this.mColorID = i3;
        }

        public int getFilterID() {
            return this.mFilterID;
        }

        public String getFilterType() {
            return this.mFilterType;
        }

        public String getResourcePath() {
            return this.mResourcePath;
        }

        public int getResourceID() {
            return this.mResourceID;
        }

        public String getFilterNameCn() {
            return this.mRenderNameCn;
        }

        public String getFilterNameTrCn() {
            return this.mRenderNameTrCn;
        }

        public String getFilterNameEn() {
            return this.mRenderNameEn;
        }

        public int getColorID() {
            return this.mColorID;
        }
    }
}
