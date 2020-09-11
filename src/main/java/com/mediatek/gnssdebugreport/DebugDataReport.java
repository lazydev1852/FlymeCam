package com.mediatek.gnssdebugreport;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.savior.Constants;

public class DebugDataReport implements Parcelable {
    public static final Parcelable.Creator<DebugDataReport> CREATOR = new Parcelable.Creator<DebugDataReport>() {
        public DebugDataReport createFromParcel(Parcel parcel) {
            return new DebugDataReport(parcel);
        }

        public DebugDataReport[] newArray(int i) {
            return new DebugDataReport[i];
        }
    };
    public static final String DATA_KEY = "DebugDataReport";
    private double mCB;
    private double mClkTemp;
    private double mCompCB;
    private int mEPOage;
    private int mHaveEPO;
    private double mInitLlhHeight;
    private double mInitLlhLati;
    private double mInitLlhLongi;
    private float mInitPacc;
    private int mInitSrc;
    private int mLsvalid;
    private int mMPEvalid;
    private int mPga;
    private int mSaturation;
    private float mSensorHACC;
    private int mSvnum;
    private long mTT4SV;
    private float mTop4CNR;
    private long mTtff;

    public int describeContents() {
        return 0;
    }

    public DebugDataReport(double d, double d2, double d3, int i, int i2, long j, int i3, long j2, float f, double d4, double d5, double d6, int i4, float f2, int i5, int i6, float f3, int i7, int i8) {
        this.mCB = d;
        this.mCompCB = d2;
        this.mClkTemp = d3;
        this.mSaturation = i;
        this.mPga = i2;
        this.mTtff = j;
        this.mSvnum = i3;
        this.mTT4SV = j2;
        this.mTop4CNR = f;
        this.mInitLlhLongi = d4;
        this.mInitLlhLati = d5;
        this.mInitLlhHeight = d6;
        this.mInitSrc = i4;
        this.mInitPacc = f2;
        this.mHaveEPO = i5;
        this.mEPOage = i6;
        this.mSensorHACC = f3;
        this.mMPEvalid = i7;
        this.mLsvalid = i8;
    }

    public DebugDataReport(Parcel parcel) {
        this.mCB = parcel.readDouble();
        this.mCompCB = parcel.readDouble();
        this.mClkTemp = parcel.readDouble();
        this.mSaturation = parcel.readInt();
        this.mPga = parcel.readInt();
        this.mTtff = parcel.readLong();
        this.mSvnum = parcel.readInt();
        this.mTT4SV = parcel.readLong();
        this.mTop4CNR = parcel.readFloat();
        this.mInitLlhLongi = parcel.readDouble();
        this.mInitLlhLati = parcel.readDouble();
        this.mInitLlhHeight = parcel.readDouble();
        this.mInitSrc = parcel.readInt();
        this.mInitPacc = parcel.readFloat();
        this.mHaveEPO = parcel.readInt();
        this.mEPOage = parcel.readInt();
        this.mSensorHACC = parcel.readFloat();
        this.mMPEvalid = parcel.readInt();
        this.mLsvalid = parcel.readInt();
    }

    public double getCB() {
        return this.mCB;
    }

    public double getmCompCB() {
        return this.mCompCB;
    }

    public double getClkTemp() {
        return this.mClkTemp;
    }

    public int getSaturation() {
        return this.mSaturation;
    }

    public int getPga() {
        return this.mPga;
    }

    public long getTtff() {
        return this.mTtff;
    }

    public int getSvnum() {
        return this.mSvnum;
    }

    public long getTT4SV() {
        return this.mTT4SV;
    }

    public float getTop4CNR() {
        return this.mTop4CNR;
    }

    public double getInitLlhLongi() {
        return this.mInitLlhLongi;
    }

    public double getInitLlhLati() {
        return this.mInitLlhLati;
    }

    public double getInitLlhHeight() {
        return this.mInitLlhHeight;
    }

    public int getInitSrc() {
        return this.mInitSrc;
    }

    public float getInitPacc() {
        return this.mInitPacc;
    }

    public int getHaveEPO() {
        return this.mHaveEPO;
    }

    public int getEPOage() {
        return this.mEPOage;
    }

    public float getSensorHACC() {
        return this.mSensorHACC;
    }

    public int getMPEvalid() {
        return this.mMPEvalid;
    }

    public int getLsvalid() {
        return this.mLsvalid;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mCB);
        parcel.writeDouble(this.mCompCB);
        parcel.writeDouble(this.mClkTemp);
        parcel.writeInt(this.mSaturation);
        parcel.writeInt(this.mPga);
        parcel.writeLong(this.mTtff);
        parcel.writeInt(this.mSvnum);
        parcel.writeLong(this.mTT4SV);
        parcel.writeFloat(this.mTop4CNR);
        parcel.writeDouble(this.mInitLlhLongi);
        parcel.writeDouble(this.mInitLlhLati);
        parcel.writeDouble(this.mInitLlhHeight);
        parcel.writeInt(this.mInitSrc);
        parcel.writeFloat(this.mInitPacc);
        parcel.writeInt(this.mHaveEPO);
        parcel.writeInt(this.mEPOage);
        parcel.writeFloat(this.mSensorHACC);
        parcel.writeInt(this.mMPEvalid);
        parcel.writeInt(this.mLsvalid);
    }

    public String toString() {
        return Constants.ARRAY_TYPE + this.mCB + ", " + this.mCompCB + ", " + this.mClkTemp + ", " + this.mSaturation + ", " + this.mPga + ", " + this.mTtff + ", " + this.mSvnum + ", " + this.mTT4SV + ", " + this.mTop4CNR + ", " + this.mInitLlhLongi + ", " + this.mInitLlhLati + ", " + this.mInitLlhHeight + ", " + this.mInitSrc + ", " + this.mInitPacc + ", " + this.mHaveEPO + ", " + this.mEPOage + ", " + this.mSensorHACC + ", " + this.mMPEvalid + ", " + this.mLsvalid + "]";
    }
}
