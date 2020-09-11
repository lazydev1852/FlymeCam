package com.arcsoft.livebroadcast;

import android.graphics.Rect;
import java.util.Arrays;

public class ArcSpotlightFaceInfo {
    public int faceCount;
    public float[] faceOrientations;
    public float[] faceOutlineMappingPointValues;
    public float[] faceOutlinePointValues;
    public Rect[] faceRects;

    public ArcSpotlightFaceInfo() {
        this.faceCount = 0;
        this.faceOrientations = new float[30];
        this.faceRects = new Rect[10];
        this.faceOutlinePointValues = new float[2440];
        this.faceOutlineMappingPointValues = new float[2120];
        this.faceCount = 0;
        for (int i = 0; i < this.faceRects.length; i++) {
            this.faceRects[i] = new Rect();
        }
    }

    public void setEmpty() {
        this.faceCount = 0;
        for (int i = 0; i < this.faceOrientations.length; i++) {
            this.faceOrientations[i] = 0.0f;
        }
        for (Rect empty : this.faceRects) {
            empty.setEmpty();
        }
        Arrays.fill(this.faceOutlinePointValues, 0.0f);
        Arrays.fill(this.faceOutlineMappingPointValues, 0.0f);
    }

    public boolean set(ArcSpotlightFaceInfo arcSpotlightFaceInfo) {
        if (arcSpotlightFaceInfo == null) {
            return false;
        }
        this.faceCount = arcSpotlightFaceInfo.faceCount;
        for (int i = 0; i < this.faceOrientations.length; i++) {
            this.faceOrientations[i] = arcSpotlightFaceInfo.faceOrientations[i];
        }
        for (int i2 = 0; i2 < this.faceOutlinePointValues.length; i2++) {
            this.faceOutlinePointValues[i2] = arcSpotlightFaceInfo.faceOutlinePointValues[i2];
        }
        for (int i3 = 0; i3 < this.faceOutlineMappingPointValues.length; i3++) {
            this.faceOutlineMappingPointValues[i3] = arcSpotlightFaceInfo.faceOutlineMappingPointValues[i3];
        }
        for (int i4 = 0; i4 < this.faceRects.length; i4++) {
            this.faceRects[i4].set(arcSpotlightFaceInfo.faceRects[i4]);
        }
        return true;
    }
}
