package com.mediatek.accessor.util;

import com.meizu.savior.Constants;
import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    private static final double INVALID_VALUE_DOUBLE = -1.0d;
    private static final int INVALID_VALUE_INT = -1;
    private static final String TAG = Log.Tag(JsonParser.class.getSimpleName());
    private JSONObject mJsonObject;

    public JsonParser(String str) {
        try {
            this.mJsonObject = new JSONObject(str);
        } catch (JSONException e) {
            Log.m3996e(TAG, "<JsonParser> exception", e);
        }
    }

    public JsonParser(byte[] bArr) {
        try {
            this.mJsonObject = new JSONObject(new String(bArr));
        } catch (JSONException e) {
            Log.m3996e(TAG, "<JsonParser> exception", e);
        }
    }

    public int getValueIntFromObject(String str, String str2, String str3) {
        if (this.mJsonObject == null || str3 == null) {
            Log.m3993d(TAG, "<getValueIntFromObject> error!!");
            return -1;
        } else if (str == null) {
            try {
                return this.mJsonObject.getInt(str3);
            } catch (JSONException unused) {
                String str4 = TAG;
                Log.m3995e(str4, "<getValueIntFromObject> warning, " + str + "." + str2 + "." + str3);
                return -1;
            }
        } else {
            JSONObject jSONObject = this.mJsonObject.getJSONObject(str);
            if (str2 != null) {
                jSONObject = jSONObject.getJSONObject(str2);
            }
            if (jSONObject != null) {
                return jSONObject.getInt(str3);
            }
            return -1;
        }
    }

    public double getValueDoubleFromObject(String str, String str2, String str3) {
        if (this.mJsonObject == null || str == null || str3 == null) {
            Log.m3993d(TAG, "<getValueDoubleFromObject> error!!");
            return INVALID_VALUE_DOUBLE;
        }
        try {
            JSONObject jSONObject = this.mJsonObject.getJSONObject(str);
            if (str2 != null) {
                jSONObject = jSONObject.getJSONObject(str2);
            }
            if (jSONObject != null) {
                return jSONObject.getDouble(str3);
            }
            return INVALID_VALUE_DOUBLE;
        } catch (JSONException unused) {
            String str4 = TAG;
            Log.m3995e(str4, "<getValueDoubleFromObject> warning, " + str + "." + str2 + "." + str3);
            return INVALID_VALUE_DOUBLE;
        }
    }

    public String getValueStringFromObject(String str, String str2, String str3) {
        if (this.mJsonObject == null || str == null || str3 == null) {
            Log.m3993d(TAG, "<getValueStringFromObject> error!!");
            return "";
        }
        try {
            JSONObject jSONObject = this.mJsonObject.getJSONObject(str);
            if (str2 != null) {
                jSONObject = jSONObject.getJSONObject(str2);
            }
            if (jSONObject != null) {
                return jSONObject.getString(str3);
            }
            return "";
        } catch (JSONException unused) {
            String str4 = TAG;
            Log.m3995e(str4, "<getValueStringFromObject> warning, " + str + "." + str2 + "." + str3);
            return "";
        }
    }

    public boolean getValueBooleanFromObject(String str, String str2, String str3) {
        if (this.mJsonObject == null || str == null || str3 == null) {
            Log.m3993d(TAG, "<getValueBooleanFromObject> error!!");
            return false;
        }
        try {
            JSONObject jSONObject = this.mJsonObject.getJSONObject(str);
            if (str2 != null) {
                jSONObject = jSONObject.getJSONObject(str2);
            }
            if (jSONObject != null) {
                return jSONObject.getBoolean(str3);
            }
            return false;
        } catch (JSONException unused) {
            String str4 = TAG;
            Log.m3995e(str4, "<getValueBooleanFromObject> warning, " + str + "." + str2 + "." + str3);
            return false;
        }
    }

    public boolean getValueBooleanOrThrow(String str, String str2, String str3) throws JSONException {
        if (this.mJsonObject == null || str == null || str3 == null) {
            Log.m3993d(TAG, "<getValueBooleanOrThrow> error!!");
            return false;
        }
        JSONObject jSONObject = this.mJsonObject.getJSONObject(str);
        if (str2 != null) {
            jSONObject = jSONObject.getJSONObject(str2);
        }
        if (jSONObject != null) {
            return jSONObject.getBoolean(str3);
        }
        return false;
    }

    public int[][] getInt2DArrayFromObject(String str, String str2) {
        JSONObject jSONObject;
        int[][] iArr = null;
        if (this.mJsonObject == null || str2 == null) {
            Log.m3993d(TAG, "<getInt2DArrayFromObject> error!!");
            return iArr;
        }
        if (str == null) {
            try {
                jSONObject = this.mJsonObject;
            } catch (JSONException unused) {
                Log.m3995e(TAG, "<getInt2DArrayFromObject> warning, " + str + "." + str2);
                return iArr;
            }
        } else {
            jSONObject = this.mJsonObject.getJSONObject(str);
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str2);
        if (jSONArray == null) {
            return iArr;
        }
        int length = jSONArray.length();
        int length2 = jSONArray.getJSONArray(0).length();
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{length, length2});
        for (int i = 0; i < length; i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            if (jSONArray2 != null) {
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr2[i][i2] = jSONArray2.getInt(i2);
                }
            }
        }
        return iArr2;
    }

    public int[] getIntArrayFromObject(String str, String str2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        if (this.mJsonObject == null || str2 == null) {
            Log.m3993d(TAG, "<getIntArrayFromObject> error!!");
            return null;
        }
        if (str == null) {
            try {
                jSONObject = this.mJsonObject;
            } catch (JSONException unused) {
                String str3 = TAG;
                Log.m3995e(str3, "<getIntArrayFromObject> warning, " + str + "." + str2);
                return null;
            }
        } else {
            jSONObject = this.mJsonObject.getJSONObject(str);
        }
        if (jSONObject == null || (jSONArray = jSONObject.getJSONArray(str2)) == null) {
            return null;
        }
        int length = jSONArray.length();
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = jSONArray.getInt(i);
        }
        return iArr;
    }

    public int getObjectPropertyValueFromArray(String str, int i, String str2) {
        if (this.mJsonObject == null || str == null || str2 == null) {
            Log.m3993d(TAG, "<getObjectPropertyValueFromArray> error!!");
            return -1;
        }
        try {
            JSONArray jSONArray = this.mJsonObject.getJSONArray(str);
            if (jSONArray != null) {
                int length = jSONArray.length();
                if (i >= 0) {
                    if (i <= length) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            return jSONObject.getInt(str2);
                        }
                    }
                }
                String str3 = TAG;
                Log.m3993d(str3, "<getObjectPropertyValueFromArray> index error: " + i);
                return -1;
            }
            return -1;
        } catch (JSONException unused) {
            String str4 = TAG;
            Log.m3995e(str4, "<getObjectPropertyValueFromArray> warning, " + str + Constants.ARRAY_TYPE + i + "]." + str2);
            return -1;
        }
    }

    public int getArrayLength(String str) {
        if (this.mJsonObject == null || str == null) {
            Log.m3993d(TAG, "<getArrayLength> error!!");
            return -1;
        }
        try {
            JSONArray jSONArray = this.mJsonObject.getJSONArray(str);
            if (jSONArray != null) {
                return jSONArray.length();
            }
            return -1;
        } catch (JSONException unused) {
            String str2 = TAG;
            Log.m3995e(str2, "<getArrayLength> warning, " + str);
            return -1;
        }
    }
}
