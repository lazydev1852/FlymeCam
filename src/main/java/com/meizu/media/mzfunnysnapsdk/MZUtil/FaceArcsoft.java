package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.graphics.PointF;
import android.graphics.Rect;
import com.arcsoft.livebroadcast.ArcSpotlightFaceInfo;
import com.arcsoft.livebroadcast.ArcSpotlightFaceStatus;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class FaceArcsoft {
    private static final int FACE_POINTS_SUM = 212;
    private static final int FACE_POINT_NUMBER = 106;
    public static ChangeQuickRedirect changeQuickRedirect;

    public static class Face {
        public int index;
        public float[] leftEyestatus;
        public float[] moutstatus;
        public float pitch;
        public PointF[] points;
        public Rect rect;
        public float[] rightEyestatus;
        public float roll;
        public float yaw;
    }

    public static Face[] processFaceResult(ArcSpotlightFaceInfo arcSpotlightFaceInfo, ArcSpotlightFaceStatus arcSpotlightFaceStatus) {
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{arcSpotlightFaceInfo, arcSpotlightFaceStatus}, (Object) null, changeQuickRedirect, true, 9195, new Class[]{ArcSpotlightFaceInfo.class, ArcSpotlightFaceStatus.class}, Face[].class);
        if (proxy.isSupported) {
            return (Face[]) proxy.result;
        }
        if (arcSpotlightFaceInfo == null || (i = arcSpotlightFaceInfo.faceCount) <= 0) {
            return null;
        }
        Face[] faceArr = new Face[i];
        for (int i2 = 0; i2 < i; i2++) {
            faceArr[i2] = new Face();
            faceArr[i2].index = i2;
            int i3 = i2 * 3;
            faceArr[i2].pitch = arcSpotlightFaceInfo.faceOrientations[i3];
            faceArr[i2].yaw = arcSpotlightFaceInfo.faceOrientations[i3 + 1];
            faceArr[i2].roll = arcSpotlightFaceInfo.faceOrientations[i3 + 2];
            faceArr[i2].rect = arcSpotlightFaceInfo.faceRects[i2];
            faceArr[i2].points = new PointF[106];
            for (int i4 = 0; i4 < 106; i4++) {
                faceArr[i2].points[i4] = new PointF();
                PointF pointF = faceArr[i2].points[i4];
                float[] fArr = arcSpotlightFaceInfo.faceOutlineMappingPointValues;
                int i5 = (i2 * FACE_POINTS_SUM) + (i4 * 2);
                pointF.x = fArr[i5];
                faceArr[i2].points[i4].y = arcSpotlightFaceInfo.faceOutlineMappingPointValues[i5 + 1];
            }
        }
        return faceArr;
    }
}
