package com.meizu.media.mzfunnysnapsdk.StickerLoader;

import android.graphics.PointF;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.AnimationPart;
import com.meizu.media.mzfunnysnapsdk.AssetsZip.StickerPart;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.media.mzfunnysnapsdk.MZUtil.LoadZip;
import com.meizu.media.mzfunnysnapsdk.MZUtil.TimerCount;
import com.meizu.media.mzfunnysnapsdk.Utils.ConUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.mzfunnysnapsdk.StickerLoader.StickerLoader */
public class C2777StickerLoader {
    private static final String TAG = "StickerLoader";
    private static int[] align = null;
    private static PointF[] anchorCenter = null;
    private static float[] anchorDistance = null;
    private static float anchorDistance_Global = 210.0f;
    public static ChangeQuickRedirect changeQuickRedirect;
    private static C2777StickerLoader instance;
    public static TimerCount[] mTimerCount;
    public ArrayList<StickerPart> mZipSticker;

    public static C2777StickerLoader getInstance() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9370, new Class[0], C2777StickerLoader.class);
        if (proxy.isSupported) {
            return (C2777StickerLoader) proxy.result;
        }
        if (instance == null) {
            synchronized (C2777StickerLoader.class) {
                if (instance == null) {
                    instance = new C2777StickerLoader();
                }
            }
        }
        return instance;
    }

    public void selectSticker(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9371, new Class[]{String.class}, Void.TYPE).isSupported) {
            LoadZip loadZip = new LoadZip();
            if (loadZip.loadZipFile(str)) {
                if (this.mZipSticker != null) {
                    for (int i = 0; i < this.mZipSticker.size(); i++) {
                        if (!(this.mZipSticker.get(i) == null || this.mZipSticker.get(i).bitmap == null || this.mZipSticker.get(i).bitmap.part_array == null || this.mZipSticker.get(i).bitmap.part_array.isEmpty())) {
                            int size = this.mZipSticker.get(i).bitmap.part_array.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                if (this.mZipSticker.get(i).bitmap.part_array.get(i2) != null && !this.mZipSticker.get(i).bitmap.part_array.get(i2).isRecycled()) {
                                    this.mZipSticker.get(i).bitmap.part_array.get(i2).recycle();
                                }
                            }
                        }
                    }
                    this.mZipSticker.clear();
                    this.mZipSticker = null;
                }
                Log.i("FunnySnapFlow", "StickerLoader selectSticker() ");
                this.mZipSticker = loadZip.getStickerPartList();
                if (this.mZipSticker != null) {
                    if (anchorDistance != null) {
                        anchorDistance = null;
                    }
                    if (anchorCenter != null) {
                        anchorCenter = null;
                    }
                    if (align != null) {
                        align = null;
                    }
                    if (mTimerCount != null) {
                        for (int i3 = 0; i3 < mTimerCount.length; i3++) {
                            if (mTimerCount[i3] != null) {
                                mTimerCount[i3].stopTimer();
                            }
                        }
                    }
                    int size2 = this.mZipSticker.size();
                    anchorDistance = new float[size2];
                    anchorCenter = new PointF[size2];
                    align = new int[size2];
                    mTimerCount = new TimerCount[size2];
                    for (int i4 = 0; i4 < size2; i4++) {
                        AnimationPart animationPart = this.mZipSticker.get(i4).json;
                        mTimerCount[i4] = new TimerCount(animationPart.frameCount, animationPart.triggerAction);
                        mTimerCount[i4].startTimer(1000 / ((long) animationPart.framePerSecond));
                        if (align == null) {
                            Log.e(TAG, " align == null ");
                            return;
                        }
                        if (animationPart.align.equals("none")) {
                            align[i4] = 0;
                            PointF pointF = new PointF();
                            PointF pointF2 = new PointF();
                            pointF.x = this.mZipSticker.get(i4).json.scale_A.f15597x;
                            pointF.y = this.mZipSticker.get(i4).json.scale_A.f15598y;
                            pointF2.x = this.mZipSticker.get(i4).json.scale_B.f15597x;
                            pointF2.y = this.mZipSticker.get(i4).json.scale_B.f15598y;
                            if (anchorDistance == null) {
                                Log.e(TAG, " anchorDistance == null ");
                                return;
                            }
                            anchorDistance[i4] = ConUtil.points2distance(pointF2.x, pointF2.y, pointF.x, pointF.y);
                            if (anchorCenter == null) {
                                Log.e(TAG, " anchorCenter == null ");
                                return;
                            }
                            anchorCenter[i4] = new PointF();
                            float f = animationPart.position_X.f15597x;
                            float f2 = animationPart.position_Y.f15597x;
                            float f3 = animationPart.position_X.f15598y;
                            float f4 = animationPart.position_Y.f15598y;
                            anchorCenter[i4].x = (f + f2) / 2.0f;
                            anchorCenter[i4].y = (f3 + f4) / 2.0f;
                            if (animationPart.globalScaleFactor) {
                                GlobalParams.globalScaleIndexes[0] = animationPart.scale_A.index;
                                GlobalParams.globalScaleIndexes[1] = animationPart.scale_B.index;
                                GlobalParams.globalScaleDistanceIndexes = i4;
                                anchorDistance_Global = ConUtil.points2distance(pointF2.x, pointF2.y, pointF.x, pointF.y);
                            }
                        } else if (animationPart.align.equals("fullscreen")) {
                            align[i4] = 1;
                        } else if (animationPart.align.equals("top")) {
                            align[i4] = 2;
                        } else if (animationPart.align.equals("bottom")) {
                            align[i4] = 3;
                        } else if (animationPart.align.equals("left")) {
                            align[i4] = 4;
                        } else if (animationPart.align.equals("right")) {
                            align[i4] = 5;
                        } else {
                            Log.e(TAG, "align parameter error! ");
                        }
                    }
                    GlobalParams.isStickerReadyToRender = true;
                    GlobalParams.strCurrentSticker = str;
                }
            }
        }
    }

    public int[] getCurrentStickerIndex() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9372, new Class[0], int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        if (mTimerCount == null) {
            return null;
        }
        int[] iArr = new int[mTimerCount.length];
        for (int i = 0; i < mTimerCount.length; i++) {
            if (mTimerCount[i] != null) {
                iArr[i] = mTimerCount[i].getFrameCurrent();
            }
        }
        return iArr;
    }

    public float[] getAnchorDistance() {
        return anchorDistance;
    }

    public float getAnchorDistance_Global() {
        return anchorDistance_Global;
    }

    public PointF[] getAnchorCenter() {
        return anchorCenter;
    }

    public int[] getAlign() {
        return align;
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9373, new Class[0], Void.TYPE).isSupported && this.mZipSticker != null && this.mZipSticker.size() > 0) {
            Log.i("FunnySnapFlow", "StickerLoader release() ");
            for (int i = 0; i < this.mZipSticker.size(); i++) {
                if (!(this.mZipSticker.get(i) == null || this.mZipSticker.get(i).bitmap == null || this.mZipSticker.get(i).bitmap.part_array == null || this.mZipSticker.get(i).bitmap.part_array.isEmpty())) {
                    int size = this.mZipSticker.get(i).bitmap.part_array.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.mZipSticker.get(i).bitmap.part_array.get(i2) != null && !this.mZipSticker.get(i).bitmap.part_array.get(i2).isRecycled()) {
                            this.mZipSticker.get(i).bitmap.part_array.get(i2).recycle();
                        }
                    }
                }
            }
            this.mZipSticker.clear();
            this.mZipSticker = null;
            if (anchorDistance != null) {
                anchorDistance = null;
            }
            if (anchorCenter != null) {
                anchorCenter = null;
            }
            if (align != null) {
                align = null;
            }
            if (mTimerCount != null) {
                for (int i3 = 0; i3 < mTimerCount.length; i3++) {
                    if (mTimerCount[i3] != null) {
                        mTimerCount[i3].stopTimer();
                    }
                }
            }
        }
    }
}
