package com.meizu.statsapp.p081v3.lib.plugin.net;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.NetResponse */
public class NetResponse implements Parcelable {
    public static final Parcelable.Creator<NetResponse> CREATOR = new Parcelable.Creator<NetResponse>() {
        public NetResponse createFromParcel(Parcel parcel) {
            return new NetResponse(parcel);
        }

        public NetResponse[] newArray(int i) {
            return new NetResponse[i];
        }
    };
    private String responseBody;
    private int responseCode;

    public int describeContents() {
        return 0;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public NetResponse(int i, String str) {
        this.responseCode = i;
        this.responseBody = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.responseCode);
            jSONObject.put("body", this.responseBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }

    protected NetResponse(Parcel parcel) {
        this.responseCode = parcel.readInt();
        this.responseBody = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.responseCode);
        parcel.writeString(this.responseBody);
    }
}
