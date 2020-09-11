package com.meizu.media.cameraAlgorithm.agegender;

import com.meizu.savior.ChangeQuickRedirect;

public class AgeGenderInfo {
    public static ChangeQuickRedirect changeQuickRedirect;
    int mGender;
    int mIndex;
    int mNumber;

    public AgeGenderInfo() {
    }

    public AgeGenderInfo(int i, int i2, int i3) {
        this.mIndex = i;
        this.mGender = i2;
        this.mNumber = i3;
    }

    public int getGender() {
        return this.mGender;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getNum() {
        return this.mNumber;
    }

    public void setGender(int i) {
        this.mGender = i;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setNum(int i) {
        this.mNumber = i;
    }
}
