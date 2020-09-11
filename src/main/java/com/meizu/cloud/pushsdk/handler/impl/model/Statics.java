package com.meizu.cloud.pushsdk.handler.impl.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class Statics implements Parcelable {
    public static final Parcelable.Creator<Statics> CREATOR = new Parcelable.Creator<Statics>() {
        public Statics createFromParcel(Parcel parcel) {
            return new Statics(parcel);
        }

        public Statics[] newArray(int i) {
            return new Statics[i];
        }
    };
    public static final String PUSH_EXTRA = "pushExtra";
    public static final String TAG = "statics";
    public static final String TASK_ID = "taskId";
    public static final String TIME = "time";
    private String deviceId;
    private boolean pushExtra = false;
    private String seqId;
    private String taskId;
    private String time;

    public int describeContents() {
        return 0;
    }

    public Statics() {
    }

    protected Statics(Parcel parcel) {
        boolean z = false;
        this.taskId = parcel.readString();
        this.time = parcel.readString();
        this.pushExtra = parcel.readByte() != 0 ? true : z;
        this.deviceId = parcel.readString();
        this.seqId = parcel.readString();
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public boolean getPushExtra() {
        return this.pushExtra;
    }

    public void setPushExtra(boolean z) {
        this.pushExtra = z;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getSeqId() {
        return this.seqId;
    }

    public void setSeqId(String str) {
        this.seqId = str;
    }

    public static Statics parse(JSONObject jSONObject) {
        Statics statics = new Statics();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(TASK_ID)) {
                    statics.setTaskId(jSONObject.getString(TASK_ID));
                }
                if (!jSONObject.isNull("time")) {
                    statics.setTime(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull(PUSH_EXTRA)) {
                    statics.setPushExtra(jSONObject.getInt(PUSH_EXTRA) != 0);
                }
            } catch (JSONException e) {
                DebugLogger.m4828e(TAG, " parse statics message error " + e.getMessage());
            }
        } else {
            DebugLogger.m4828e(TAG, "no control statics can parse ");
        }
        return statics;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.taskId);
        parcel.writeString(this.time);
        parcel.writeByte(this.pushExtra ? (byte) 1 : 0);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.seqId);
    }

    public String toString() {
        return "Statics{taskId='" + this.taskId + '\'' + ", time='" + this.time + '\'' + ", pushExtra=" + this.pushExtra + ", deviceId='" + this.deviceId + '\'' + ", seqId='" + this.seqId + '\'' + '}';
    }
}
