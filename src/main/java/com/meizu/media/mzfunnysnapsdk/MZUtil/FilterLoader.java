package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.Filter.LookupFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.LookupFilterFactory;
import com.meizu.media.mzfunnysnapsdk.Filter.MZLookupLowFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.ReshapeFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.SkinSmoothFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.StickerAsFilter;
import com.meizu.media.mzfunnysnapsdk.StickerLoader.C2777StickerLoader;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class FilterLoader {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int mDefaultLookupFilter = 90;
    private int mDefaultSkinSmoothFilter = 50;
    private int mHeight = 0;
    private LookupFilter mLookupFilter;
    private ReshapeFilter mReshapeFilter;
    private SkinSmoothFilter mSkinSmoothFilter;
    private StickerAsFilter mStickerAsFilter;
    private String mStrStickerPath;
    private int mWidth = 0;
    private MZLookupLowFilter mzLookupLowFilter;
    private StickerTask task;

    public FilterLoader(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        this.task = new StickerTask();
    }

    public void setupFilter(Resources resources, TextureController textureController) {
        if (!PatchProxy.proxy(new Object[]{resources, textureController}, this, changeQuickRedirect, false, 9196, new Class[]{Resources.class, TextureController.class}, Void.TYPE).isSupported) {
            Log.i("FunnySnapFlow", "FilterLoader setupFilter(Res)");
            this.mLookupFilter = new LookupFilter(resources);
            this.mLookupFilter.setMaskImage(LookupFilterFactory.C2762Filter.NATURE.getResourcePath());
            GlobalParams.intCurrentFilter = 1;
            this.mLookupFilter.setFlag(this.mDefaultLookupFilter);
            textureController.addFilter(this.mLookupFilter);
            this.mSkinSmoothFilter = new SkinSmoothFilter(resources);
            this.mSkinSmoothFilter.setFlag(this.mDefaultSkinSmoothFilter);
            textureController.addFilter(this.mSkinSmoothFilter);
            this.mReshapeFilter = new ReshapeFilter(resources);
            this.mReshapeFilter.updataReshapeFilterRatio(this.mWidth, this.mHeight);
            textureController.addFilter(this.mReshapeFilter);
            this.mStickerAsFilter = new StickerAsFilter(resources);
            this.mStickerAsFilter.updataStickerFilterRatio(this.mWidth, this.mHeight);
            textureController.addFilter(this.mStickerAsFilter);
        }
    }

    public void setFilter(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 9197, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Log.i("FunnySnapFlow", "FilterLoader setupFilter(ID)");
            if (this.mLookupFilter == null) {
                Log.e("mz0419", "mLookupFilter is null !");
            } else if (i == 0) {
                this.mLookupFilter.setFlag(0);
                GlobalParams.intCurrentFilter = 0;
            } else {
                new BitmapFactory.Options().inScaled = false;
                Log.e("mz0419", "更换滤镜为" + FilterList.sLutFilterTable[i].getFilterNameCn());
                GlobalParams.intCurrentFilter = i;
                if (FilterList.sLutFilterTable[i].getFilterType().equals("LookupFilter")) {
                    String resourcePath = FilterList.sLutFilterTable[i].getResourcePath();
                    Log.i("FunnySnapFlow", "更换LUT为" + FilterList.sLutFilterTable[i].getResourcePath());
                    if (!TextUtils.isEmpty(resourcePath)) {
                        this.mLookupFilter.setMaskImage(resourcePath);
                        this.mLookupFilter.setFlag(this.mDefaultLookupFilter);
                        return;
                    }
                    return;
                }
                this.mLookupFilter.setFlag(0);
                Log.e("mz0419", "滤镜为None时，只输出原图");
            }
        }
    }

    public String getFilterNameCn(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 9198, new Class[]{Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : FilterList.sLutFilterTable[i].getFilterNameCn();
    }

    public String getFilterNameEn(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 9199, new Class[]{Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : FilterList.sLutFilterTable[i].getFilterNameEn();
    }

    public int getFilterAmount() {
        return FilterList.sLutFilterTable.length;
    }

    public void setFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9200, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mDefaultSkinSmoothFilter = i;
            if (this.mSkinSmoothFilter != null) {
                this.mSkinSmoothFilter.setFlag(i);
            }
        }
    }

    public void setFilterFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9201, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mDefaultLookupFilter = i;
            if (this.mLookupFilter != null) {
                this.mLookupFilter.setFlag(i);
            }
        }
    }

    public void setSkinSmoothFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9202, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.mDefaultSkinSmoothFilter = i;
            GlobalParams.skinSmoothLevel = i;
            if (this.mSkinSmoothFilter != null) {
                this.mSkinSmoothFilter.setFlag(i);
            }
        }
    }

    public void setReshapeFlag(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9203, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Log.i("mz0424", "flag: " + i);
            if (this.mReshapeFilter != null) {
                this.mReshapeFilter.setFlag(i);
            }
        }
    }

    public void updataStickerFilterRatio(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9204, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.mStickerAsFilter != null) {
            this.mStickerAsFilter.updataStickerFilterRatio(i, i2);
        }
    }

    public void updataReshapeFilterRatio(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9205, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && this.mReshapeFilter != null) {
            this.mReshapeFilter.updataReshapeFilterRatio(i, i2);
        }
    }

    public void changeStickerFilterGroup(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9206, new Class[]{String.class}, Void.TYPE).isSupported && !str.isEmpty() && !str.equals(this.mStrStickerPath)) {
            if (this.task != null && !this.task.isCancelled()) {
                this.task.cancel(true);
                this.task = null;
            }
            this.task = new StickerTask();
            this.task.execute(new String[]{str});
            this.mStrStickerPath = str;
            Log.i("FunnySnapFlow", "FilterLoader change sticker");
        }
    }

    public void removeStickerFilterGroup() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9207, new Class[0], Void.TYPE).isSupported) {
            if (this.task != null && !this.task.isCancelled()) {
                this.task.cancel(true);
                this.task = null;
            }
            GlobalParams.isStickerReadyToRender = false;
            this.mStrStickerPath = "";
            GlobalParams.strCurrentSticker = "";
            Log.i("FunnySnapFlow", "FilterLoader remove sticker");
        }
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9208, new Class[0], Void.TYPE).isSupported) {
            C2777StickerLoader.getInstance().release();
        }
    }

    public class StickerTask extends AsyncTask<String, Void, String> {
        public static ChangeQuickRedirect changeQuickRedirect;

        public StickerTask() {
        }

        public String doInBackground(String... strArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, changeQuickRedirect, false, 9209, new Class[]{String[].class}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if (isCancelled()) {
                return null;
            }
            GlobalParams.isStickerReadyToRender = false;
            GlobalParams.strCurrentSticker = "";
            C2777StickerLoader.getInstance().selectSticker(strArr[0]);
            return strArr[0];
        }

        public void onPostExecute(String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9210, new Class[]{String.class}, Void.TYPE).isSupported) {
                Log.i("FunnySnapFlow", "task finish changeStickerFilterGroup: " + str);
            }
        }
    }
}
