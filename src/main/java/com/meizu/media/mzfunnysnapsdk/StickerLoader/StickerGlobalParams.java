package com.meizu.media.mzfunnysnapsdk.StickerLoader;

import com.meizu.media.mzfunnysnapsdk.MZUtil.FaceArcsoft;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.media.mzfunnysnapsdk.Utils.ConUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class StickerGlobalParams {
    public static ChangeQuickRedirect changeQuickRedirect;
    private static StickerGlobalParams instance;
    private float[] eye2eyeDistance;
    public float[] eyesAngle;
    private float[] eyescenter2noseDistance;
    public FaceArcsoft.Face[] faces_readout;
    public float[] scaleFactor;

    public static StickerGlobalParams getInstance() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9368, new Class[0], StickerGlobalParams.class);
        if (proxy.isSupported) {
            return (StickerGlobalParams) proxy.result;
        }
        if (instance == null) {
            synchronized (StickerGlobalParams.class) {
                if (instance == null) {
                    instance = new StickerGlobalParams();
                }
            }
        }
        return instance;
    }

    public void updateParameters(FaceArcsoft.Face[] faceArr) {
        if (!PatchProxy.proxy(new Object[]{faceArr}, this, changeQuickRedirect, false, 9369, new Class[]{FaceArcsoft.Face[].class}, Void.TYPE).isSupported) {
            if (this.eye2eyeDistance != null) {
                this.eye2eyeDistance = null;
            }
            if (this.eyescenter2noseDistance != null) {
                this.eyescenter2noseDistance = null;
            }
            if (this.scaleFactor != null) {
                this.scaleFactor = null;
            }
            if (this.eyesAngle != null) {
                this.eyesAngle = null;
            }
            if (faceArr == null) {
                this.faces_readout = null;
                return;
            }
            this.faces_readout = faceArr;
            int length = this.faces_readout.length;
            this.eye2eyeDistance = new float[length];
            this.eyescenter2noseDistance = new float[length];
            this.scaleFactor = new float[length];
            this.eyesAngle = new float[length];
            for (int i = 0; i < length; i++) {
                this.eye2eyeDistance[i] = ConUtil.points2distance(this.faces_readout[i].points[105].x, this.faces_readout[i].points[105].y, this.faces_readout[i].points[104].x, this.faces_readout[i].points[104].y);
                this.eyescenter2noseDistance[i] = ConUtil.points2distance(this.faces_readout[i].points[43].x, this.faces_readout[i].points[43].y, this.faces_readout[i].points[87].x, this.faces_readout[i].points[87].y);
                float anchorDistance_Global = C2777StickerLoader.getInstance().getAnchorDistance_Global();
                if (this.eye2eyeDistance[i] > this.eyescenter2noseDistance[i]) {
                    this.scaleFactor[i] = ((this.eye2eyeDistance[i] * 0.6f) + (this.eyescenter2noseDistance[i] * 0.4f)) / anchorDistance_Global;
                } else {
                    this.scaleFactor[i] = ((this.eye2eyeDistance[i] * 0.4f) + (this.eyescenter2noseDistance[i] * 0.6f)) / anchorDistance_Global;
                }
                int i2 = GlobalParams.globalScaleIndexes[0];
                int i3 = GlobalParams.globalScaleIndexes[1];
                this.eyesAngle[i] = ConUtil.points2angle(((float) GlobalParams.DEFAULT_WIDTH) - this.faces_readout[i].points[i3].x, -this.faces_readout[i].points[i3].y, ((float) GlobalParams.DEFAULT_WIDTH) - this.faces_readout[i].points[i2].x, -this.faces_readout[i].points[i2].y);
            }
        }
    }
}
