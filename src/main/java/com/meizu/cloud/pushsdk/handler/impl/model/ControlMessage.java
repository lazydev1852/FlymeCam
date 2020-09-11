package com.meizu.cloud.pushsdk.handler.impl.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class ControlMessage implements Parcelable {
    public static final Parcelable.Creator<ControlMessage> CREATOR = new Parcelable.Creator<ControlMessage>() {
        public ControlMessage createFromParcel(Parcel parcel) {
            return new ControlMessage(parcel);
        }

        public ControlMessage[] newArray(int i) {
            return new ControlMessage[i];
        }
    };
    public static final String TAG = "ControlMessage";
    private Control control;
    private String controlMessage;
    private Statics statics;

    public int describeContents() {
        return 0;
    }

    public ControlMessage() {
    }

    public ControlMessage(String str, String str2, String str3) {
        this.controlMessage = str;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.control = Control.parse(jSONObject.getJSONObject(Control.TAG));
                this.statics = Statics.parse(jSONObject.getJSONObject(Statics.TAG));
                this.statics.setDeviceId(str2);
                this.statics.setSeqId(str3);
            } catch (JSONException e) {
                this.control = new Control();
                this.statics = new Statics();
                DebugLogger.m4828e(TAG, "parse control message error " + e.getMessage());
            }
        } else {
            this.control = new Control();
            this.statics = new Statics();
        }
    }

    protected ControlMessage(Parcel parcel) {
        this.controlMessage = parcel.readString();
        this.control = (Control) parcel.readParcelable(Control.class.getClassLoader());
        this.statics = (Statics) parcel.readParcelable(Statics.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.controlMessage);
        parcel.writeParcelable(this.control, i);
        parcel.writeParcelable(this.statics, i);
    }

    public String getControlMessage() {
        return this.controlMessage;
    }

    public void setControlMessage(String str) {
        this.controlMessage = str;
    }

    public Control getControl() {
        return this.control;
    }

    public void setControl(Control control2) {
        this.control = control2;
    }

    public Statics getStatics() {
        return this.statics;
    }

    public void setStatics(Statics statics2) {
        this.statics = statics2;
    }

    public static ControlMessage parse(String str) {
        ControlMessage controlMessage2 = new ControlMessage();
        try {
            JSONObject jSONObject = new JSONObject(str);
            controlMessage2.setControl(Control.parse(jSONObject.getJSONObject(Control.TAG)));
            controlMessage2.setStatics(Statics.parse(jSONObject.getJSONObject(Statics.TAG)));
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "parse control message error " + e.getMessage());
            controlMessage2.setStatics(new Statics());
            controlMessage2.setControl(new Control());
        }
        return controlMessage2;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.controlMessage + '\'' + ", control=" + this.control + ", statics=" + this.statics + '}';
    }
}
