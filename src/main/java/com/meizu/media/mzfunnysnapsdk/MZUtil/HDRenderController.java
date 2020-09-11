package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.Filter.GroupFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.LookupFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.MZLookupLowFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.SkinSmoothFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.StaticReshapeFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.StaticStickerAsFilter;
import com.meizu.media.mzfunnysnapsdk.Filter.StaticWaterMarkFilter;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FaceArcsoft;
import com.meizu.media.mzfunnysnapsdk.R;
import com.meizu.media.mzfunnysnapsdk.StickerLoader.C2777StickerLoader;
import com.meizu.media.mzfunnysnapsdk.StickerLoader.HDStickerGlobalParams;
import com.meizu.media.mzfunnysnapsdk.Utils.BitmapUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;

public class HDRenderController {
    public static ChangeQuickRedirect changeQuickRedirect;
    private boolean BOOLEAN_SAVE_PIC = false;
    private boolean BOOLEAN_WATERMARK = true;
    public int[] currentStickerIndex;
    public FaceArcsoft.Face[] currrentFacesReadout;
    public EGLController mBackEnv;
    public LookupFilter mLookupFilter;
    private Resources mRes;
    public SkinSmoothFilter mSkinSmoothFilter;
    public StaticReshapeFilter mStaticReshapeFilter;
    public StaticStickerAsFilter mStaticStickerAsFilter;
    public MZLookupLowFilter mzLookupLowFilter;

    public HDRenderController(Resources resources) {
        this.mRes = resources;
    }

    public void getCurrentInfo() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9213, new Class[0], Void.TYPE).isSupported) {
            this.currentStickerIndex = C2777StickerLoader.getInstance().getCurrentStickerIndex();
            HDStickerGlobalParams.getInstance().updateParameters(GlobalParams.faces_readout_current);
            this.currrentFacesReadout = HDStickerGlobalParams.getInstance().faces_readout;
        }
    }

    public void setWaterMarkSwitch(boolean z) {
        this.BOOLEAN_WATERMARK = z;
    }

    public Bitmap executeMakeUp(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, changeQuickRedirect, false, 9214, new Class[]{Bitmap.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Log.i("FunnySnapFlowHD", "executeMakeUp()");
        if (this.mBackEnv != null) {
            this.mBackEnv = null;
        }
        GroupFilter groupFilter = new GroupFilter(this.mRes);
        Log.i("FunnySnapFlowHD", "CurrentFilter:" + GlobalParams.intCurrentFilter);
        if (GlobalParams.intCurrentFilter != 0) {
            LookupFilter lookupFilter = new LookupFilter(this.mRes);
            lookupFilter.setMaskImage(FilterList.sLutFilterTable[GlobalParams.intCurrentFilter].getResourcePath());
            lookupFilter.setFlag(80);
            groupFilter.addFilter(lookupFilter);
        }
        if (this.currrentFacesReadout != null) {
            Log.i("FunnySnapFlowHD", "skinSmoothLevel:" + GlobalParams.skinSmoothLevel);
            this.mSkinSmoothFilter = new SkinSmoothFilter(this.mRes);
            this.mSkinSmoothFilter.setFlag(GlobalParams.skinSmoothLevel);
            groupFilter.addFilter(this.mSkinSmoothFilter);
            this.mStaticReshapeFilter = new StaticReshapeFilter(this.mRes, bitmap.getWidth(), bitmap.getHeight(), this.currrentFacesReadout);
            groupFilter.addFilter(this.mStaticReshapeFilter);
        }
        this.mStaticStickerAsFilter = new StaticStickerAsFilter(this.mRes, bitmap.getWidth(), bitmap.getHeight(), this.currrentFacesReadout);
        groupFilter.addFilter(this.mStaticStickerAsFilter);
        if (GlobalParams.BOOLEAN_WATERMARK) {
            StaticWaterMarkFilter staticWaterMarkFilter = new StaticWaterMarkFilter(this.mRes, bitmap.getWidth(), bitmap.getHeight(), true);
            staticWaterMarkFilter.setWaterMark(BitmapFactory.decodeResource(this.mRes, R.drawable.mz_funny_snap_watermark));
            groupFilter.addFilter(staticWaterMarkFilter);
        }
        groupFilter.setOutputByTexture(false);
        this.mBackEnv = new EGLController(bitmap, groupFilter, Thread.currentThread().getName());
        if (this.mBackEnv == null) {
            return null;
        }
        Bitmap bitmap2 = this.mBackEnv.getBitmap();
        this.mBackEnv.destroy();
        if (bitmap2 == null) {
            return null;
        }
        Bitmap flipBitmap = BitmapUtil.flipBitmap(bitmap2);
        if (this.BOOLEAN_SAVE_PIC) {
            try {
                BitmapUtil.saveBitmap(bitmap, BitmapUtil.getCharacterAndNumber() + "FunnySnap_origin.jpg");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BitmapUtil.saveBitmap(flipBitmap, BitmapUtil.getCharacterAndNumber() + "FunnySnap_makeup.jpg");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FunnySnapFlowHD", "HDRender executed! ");
        bitmap.recycle();
        return flipBitmap;
    }
}
