package com.baidu.p020ar.slam;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.baidu.ar.slam.TrackModel */
public class TrackModel implements Parcelable {
    public static final Parcelable.Creator<TrackModel> CREATOR = new Parcelable.Creator() {
        /* renamed from: a */
        public TrackModel[] newArray(int i) {
            return new TrackModel[i];
        }

        public Object createFromParcel(Parcel parcel) {
            TrackModel trackModel = new TrackModel();
            trackModel.setId(parcel.readString());
            trackModel.setPose(parcel.createFloatArray());
            return trackModel;
        }
    };

    /* renamed from: id */
    public String f2245id;
    public float[] pose;

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f2245id;
    }

    public float[] getPose() {
        return this.pose;
    }

    public void setId(String str) {
        this.f2245id = str;
    }

    public void setPose(float[] fArr) {
        this.pose = fArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2245id);
        parcel.writeFloatArray(this.pose);
    }
}
