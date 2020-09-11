package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.json.JSONException;
import org.json.JSONObject;

public class NotifyOption implements Parcelable {
    public static final Parcelable.Creator<NotifyOption> CREATOR = new Parcelable.Creator<NotifyOption>() {
        public NotifyOption createFromParcel(Parcel parcel) {
            return new NotifyOption(parcel);
        }

        public NotifyOption[] newArray(int i) {
            return new NotifyOption[i];
        }
    };
    private static final String NOTIFY_ID = "ni";
    private static final String NOTIFY_KEY = "nk";
    public static final String NOTIFY_OPTION = "no";
    public static final int NO_VALID_NOTIFY_ID = 0;
    private static final String TAG = "NotifyOption";
    private int notifyId = 0;
    private String notifyKey;

    public int describeContents() {
        return 0;
    }

    public NotifyOption() {
    }

    protected NotifyOption(Parcel parcel) {
        this.notifyId = parcel.readInt();
        this.notifyKey = parcel.readString();
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public void setNotifyId(int i) {
        this.notifyId = i;
    }

    public String getNotifyKey() {
        return this.notifyKey;
    }

    public void setNotifyKey(String str) {
        this.notifyKey = str;
    }

    public String toString() {
        return "NotifyOption{notifyId=" + this.notifyId + ", notifyKey='" + this.notifyKey + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.notifyId);
        parcel.writeString(this.notifyKey);
    }

    public static NotifyOption parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                DebugLogger.m4828e(TAG, "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static NotifyOption parse(JSONObject jSONObject) {
        NotifyOption notifyOption = new NotifyOption();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(NOTIFY_ID)) {
                    notifyOption.setNotifyId(jSONObject.getInt(NOTIFY_ID));
                }
                if (!jSONObject.isNull(NOTIFY_KEY)) {
                    notifyOption.setNotifyKey(jSONObject.getString(NOTIFY_KEY));
                }
            } catch (JSONException e) {
                DebugLogger.m4828e(TAG, "parse json obj error " + e.getMessage());
            }
        } else {
            DebugLogger.m4828e(TAG, "no such tag NotifyOption");
        }
        return notifyOption;
    }

    public static NotifyOption getNotifyOptionSetting(MessageV3 messageV3) {
        NotifyOption notifyOption;
        try {
            notifyOption = !TextUtils.isEmpty(messageV3.getNotificationMessage()) ? parse(new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject(PushConstants.EXTRA).getJSONObject(NOTIFY_OPTION)) : null;
        } catch (Exception e) {
            DebugLogger.m4828e(TAG, "parse flyme NotifyOption setting error " + e.getMessage() + " so get from notificationMessage");
            notifyOption = getNotifyOptionSetting(messageV3.getNotificationMessage());
        }
        DebugLogger.m4829i(TAG, "current notify option is " + notifyOption);
        return notifyOption;
    }

    private static NotifyOption getNotifyOptionSetting(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return parse(new JSONObject(str).getString(NOTIFY_OPTION));
            }
            return null;
        } catch (JSONException e) {
            DebugLogger.m4828e(TAG, "parse notificationMessage error " + e.getMessage());
            return null;
        }
    }

    public static int getNotifyId(MessageV3 messageV3) {
        NotifyOption notifyOptionSetting = getNotifyOptionSetting(messageV3);
        if (notifyOptionSetting != null) {
            return notifyOptionSetting.getNotifyId();
        }
        return 0;
    }
}
