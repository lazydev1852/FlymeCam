package com.mediatek.mmsdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.savior.Constants;
import java.util.HashMap;

public class BaseParameters implements Parcelable {
    public static final String CAMERA_MM_SERVICE_BINDER_NAME = "media.mmsdk";
    public static final Parcelable.Creator<BaseParameters> CREATOR = new Parcelable.Creator<BaseParameters>() {
        public BaseParameters createFromParcel(Parcel parcel) {
            Log.i(BaseParameters.TAG, "createFromParcel");
            return new BaseParameters(parcel);
        }

        public BaseParameters[] newArray(int i) {
            Log.i(BaseParameters.TAG, "newArray");
            return new BaseParameters[i];
        }
    };
    public static final String KEY_CALLBACK_MSG_TYPE = "callback-msg-type";
    public static final String KEY_EFFECT_NAME_CFB = "capture_face_beauty";
    public static final String KEY_EFFECT_NAME_HDR = "hdr";
    public static final String KEY_FACE_BEAUTY_SHAPE = "fb-sharp";
    public static final String KEY_FACE_BEAUTY_SHAPE_MAX = "fb-sharp-max";
    public static final String KEY_FACE_BEAUTY_SHAPE_MIN = "fb-sharp-min";
    public static final String KEY_FACE_BEAUTY_SKIN_COLOR = "fb-skin-color";
    public static final String KEY_FACE_BEAUTY_SKIN_COLOR_MAX = "fb-skin-color-max";
    public static final String KEY_FACE_BEAUTY_SKIN_COLOR_MIN = "fb-skin-color-min";
    public static final String KEY_FACE_BEAUTY_SLIM_FACE = "fb-slim-face";
    public static final String KEY_FACE_BEAUTY_SLIM_FACE_MAX = "fb-slim-face-max";
    public static final String KEY_FACE_BEAUTY_SLIM_FACE_MIN = "fb-slim-face-min";
    public static final String KEY_FACE_BEAUTY_SMOOTH = "fb-smooth-level";
    public static final String KEY_FACE_BEAUTY_SMOOTH_MAX = "fb-smooth-level-max";
    public static final String KEY_FACE_BEAUTY_SMOOTH_MIN = "fb-smooth-level-min";
    public static final String KEY_IMAGE_FORMAT = "picture-format";
    public static final String KEY_OUT_PUT_CAPTURE_NUMBER = "picture-number";
    public static final String KEY_PICTURE_HEIGHT = "picture-height";
    public static final String KEY_PICTURE_ROTATION = "rotation";
    public static final String KEY_PICTURE_SIZE = "picture-size";
    public static final String KEY_PICTURE_WIDTH = "picture-width";
    private static final String TAG = "BaseParameters";
    private HashMap<String, String> mMap;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Log.i(TAG, "writeToParcel");
        parcel.writeString(flatten());
    }

    public void readFromParcel(Parcel parcel) {
        Log.i(TAG, "readFromParcel");
        this.mMap = new HashMap<>(128);
        int dataSize = parcel.dataSize();
        int dataPosition = parcel.dataPosition();
        Log.i(TAG, "readFromParcel - in.dataSize " + dataSize);
        Log.i(TAG, "readFromParcel - in.dataPosition " + dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        for (int i = 0; i < createByteArray.length; i++) {
            Log.i(TAG, i + " - " + createByteArray[i] + ", " + ((char) createByteArray[i]));
        }
        parcel.setDataPosition(dataPosition);
        Log.i(TAG, "readFromParcel - in.dataPosition2 " + parcel.dataPosition());
        int readInt = parcel.readInt();
        Log.i(TAG, "totalSize=" + readInt);
        String readString = parcel.readString();
        if (readString != null) {
            Log.i(TAG, "readFromParcel - string=" + readString);
            unflatten(readString);
            return;
        }
        Log.e(TAG, "can't read string from parcel");
    }

    private BaseParameters(Parcel parcel) {
        Log.i(TAG, "BaseParameters(Parcel in)");
        readFromParcel(parcel);
    }

    public BaseParameters() {
        this.mMap = new HashMap<>(128);
    }

    public BaseParameters copy() {
        BaseParameters baseParameters = new BaseParameters();
        baseParameters.mMap = new HashMap<>(this.mMap);
        return baseParameters;
    }

    public void copyFrom(BaseParameters baseParameters) {
        if (baseParameters != null) {
            this.mMap.putAll(baseParameters.mMap);
            return;
        }
        throw new NullPointerException("other must not be null");
    }

    public boolean same(BaseParameters baseParameters) {
        if (this == baseParameters) {
            return true;
        }
        return baseParameters != null && this.mMap.equals(baseParameters.mMap);
    }

    @Deprecated
    public void dump() {
        Log.e(TAG, "dump: size=" + this.mMap.size());
        for (String next : this.mMap.keySet()) {
            Log.e(TAG, "dump: " + next + "=" + this.mMap.get(next));
        }
    }

    public String flatten() {
        StringBuilder sb = new StringBuilder(128);
        for (String next : this.mMap.keySet()) {
            sb.append(next);
            sb.append("=");
            sb.append(this.mMap.get(next));
            sb.append(Constants.PACKNAME_END);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void unflatten(String str) {
        this.mMap.clear();
        TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter<>(';');
        simpleStringSplitter.setString(str);
        for (String str2 : simpleStringSplitter) {
            int indexOf = str2.indexOf(61);
            if (indexOf != -1) {
                this.mMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
    }

    public void remove(String str) {
        this.mMap.remove(str);
    }

    public void set(String str, String str2) {
        if (str.indexOf(61) != -1 || str.indexOf(59) != -1 || str.indexOf(0) != -1) {
            Log.e(TAG, "Key \"" + str + "\" contains invalid character (= or ; or \\0)");
        } else if (str2.indexOf(61) == -1 && str2.indexOf(59) == -1 && str2.indexOf(0) == -1) {
            put(str, str2);
        } else {
            Log.e(TAG, "Value \"" + str2 + "\" contains invalid character (= or ; or \\0)");
        }
    }

    public void set(String str, int i) {
        put(str, Integer.toString(i));
    }

    private void put(String str, String str2) {
        this.mMap.remove(str);
        this.mMap.put(str, str2);
    }

    public String get(String str) {
        return this.mMap.get(str);
    }

    public int getInt(String str) {
        return Integer.parseInt(this.mMap.get(str));
    }
}
