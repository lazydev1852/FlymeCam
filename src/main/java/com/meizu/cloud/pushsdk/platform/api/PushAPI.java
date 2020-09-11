package com.meizu.cloud.pushsdk.platform.api;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.networking.AndroidNetworking;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.networking.interfaces.OkHttpResponseAndStringRequestListener;
import com.meizu.cloud.pushsdk.platform.SignUtils;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PushAPI {
    public static final String TAG = "PushAPI";
    public String API_SERVER = "https://api-push.meizu.com/garcia/api/client/";
    private String CHANGE_ALL_SWITCH_STATUS_URL_PRIX = (this.API_SERVER + "message/changeAllSwitch");
    private String CHANGE_REGISTER_SWITCH_STATUS_URL_PRIX = (this.API_SERVER + "message/changeRegisterSwitch");
    private String CHECK_REGISTER_SWITCH_STATUS_URL_PRIX = (this.API_SERVER + "message/getRegisterSwitch");
    private String CHECK_SUBSCRIBE_ALIAS_URL_PRIX = (this.API_SERVER + "message/getSubAlias");
    private String CHECK_SUBSCRIBE_TAGS_URL_PRIX = (this.API_SERVER + "message/getSubTags");
    private String REGISTER_URL_PRIX = (this.API_SERVER + "message/registerPush");
    private String SUBSCRIBE_ALIAS_URL_PRIX = (this.API_SERVER + "message/subscribeAlias");
    private String SUBSCRIBE_TAGS_URL_PRIX = (this.API_SERVER + "message/subscribeTags");
    private String UNREGISTER_URL_ADVANCE_PRIX = (this.API_SERVER + "advance/unRegisterPush");
    private String UNREGISTER_URL_PRIX = (this.API_SERVER + "message/unRegisterPush");
    private String UNSUBSCRIBE_ALIAS_URL_PRIX = (this.API_SERVER + "message/unSubscribeAlias");
    private String UNSUBSCRIBE_ALL_TAGS_URL_RPIX = (this.API_SERVER + "message/unSubAllTags");
    private String UNSUBSCRIBE_TAGS_URL_PRIX = (this.API_SERVER + "message/unSubscribeTags");
    private String UPLOAD_LOG_FILE_URL_PRIX = (this.API_SERVER + "log/upload");

    public PushAPI(Context context) {
        AndroidNetworking.enableLogging();
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            this.API_SERVER = "https://api-push.in.meizu.com/garcia/api/client/";
            this.REGISTER_URL_PRIX = this.API_SERVER + "message/registerPush";
            this.UNREGISTER_URL_PRIX = this.API_SERVER + "message/unRegisterPush";
            this.UNREGISTER_URL_ADVANCE_PRIX = this.API_SERVER + "advance/unRegisterPush";
            this.CHECK_REGISTER_SWITCH_STATUS_URL_PRIX = this.API_SERVER + "message/getRegisterSwitch";
            this.CHANGE_REGISTER_SWITCH_STATUS_URL_PRIX = this.API_SERVER + "message/changeRegisterSwitch";
            this.CHANGE_ALL_SWITCH_STATUS_URL_PRIX = this.API_SERVER + "message/changeAllSwitch";
            this.SUBSCRIBE_TAGS_URL_PRIX = this.API_SERVER + "message/subscribeTags";
            this.UNSUBSCRIBE_TAGS_URL_PRIX = this.API_SERVER + "message/unSubscribeTags";
            this.UNSUBSCRIBE_ALL_TAGS_URL_RPIX = this.API_SERVER + "message/unSubAllTags";
            this.CHECK_SUBSCRIBE_TAGS_URL_PRIX = this.API_SERVER + "message/getSubTags";
            this.SUBSCRIBE_ALIAS_URL_PRIX = this.API_SERVER + "message/subscribeAlias";
            this.UNSUBSCRIBE_ALIAS_URL_PRIX = this.API_SERVER + "message/unSubscribeAlias";
            this.CHECK_SUBSCRIBE_ALIAS_URL_PRIX = this.API_SERVER + "message/getSubAlias";
        }
    }

    public void register(String str, String str2, String str3, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "register post map " + linkedHashMap2);
        AndroidNetworking.post(this.REGISTER_URL_PRIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse register(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "register post map " + linkedHashMap2);
        return AndroidNetworking.post(this.REGISTER_URL_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void unRegister(String str, String str2, String str3, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "unregister post map " + linkedHashMap2);
        AndroidNetworking.get(this.UNREGISTER_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse unRegister(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "unregister post map " + linkedHashMap2);
        return AndroidNetworking.get(this.UNREGISTER_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().executeForString();
    }

    public ANResponse unRegister(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("packageName", str);
        linkedHashMap.put("deviceId", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        DebugLogger.m4829i(TAG, "advance unregister post map " + linkedHashMap2);
        return AndroidNetworking.post(this.UNREGISTER_URL_ADVANCE_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void checkPush(String str, String str2, String str3, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "checkPush post map " + linkedHashMap2);
        AndroidNetworking.get(this.CHECK_REGISTER_SWITCH_STATUS_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse checkPush(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "checkPush post map " + linkedHashMap2);
        return AndroidNetworking.get(this.CHECK_REGISTER_SWITCH_STATUS_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().executeForString();
    }

    public void switchPush(String str, String str2, String str3, int i, boolean z, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("msgType", String.valueOf(i));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, this.CHANGE_ALL_SWITCH_STATUS_URL_PRIX + " switchPush post map " + linkedHashMap2);
        AndroidNetworking.post(this.CHANGE_REGISTER_SWITCH_STATUS_URL_PRIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse switchPush(String str, String str2, String str3, int i, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("msgType", String.valueOf(i));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, this.CHANGE_ALL_SWITCH_STATUS_URL_PRIX + " switchPush post map " + linkedHashMap2);
        return AndroidNetworking.post(this.CHANGE_REGISTER_SWITCH_STATUS_URL_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void switchPush(String str, String str2, String str3, boolean z, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, this.CHANGE_ALL_SWITCH_STATUS_URL_PRIX + " switchPush post map " + linkedHashMap2);
        AndroidNetworking.post(this.CHANGE_ALL_SWITCH_STATUS_URL_PRIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse switchPush(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, this.CHANGE_ALL_SWITCH_STATUS_URL_PRIX + " switchPush post map " + linkedHashMap2);
        return AndroidNetworking.post(this.CHANGE_ALL_SWITCH_STATUS_URL_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void subScribeTags(String str, String str2, String str3, String str4, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        AndroidNetworking.post(this.SUBSCRIBE_TAGS_URL_PRIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse subScribeTags(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        return AndroidNetworking.post(this.SUBSCRIBE_TAGS_URL_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void unSubScribeTags(String str, String str2, String str3, String str4, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        AndroidNetworking.post(this.UNSUBSCRIBE_TAGS_URL_PRIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse unSubScribeTags(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        return AndroidNetworking.post(this.UNSUBSCRIBE_TAGS_URL_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void unSubAllScribeTags(String str, String str2, String str3, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeAllTags post map " + linkedHashMap2);
        AndroidNetworking.post(this.UNSUBSCRIBE_ALL_TAGS_URL_RPIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse unSubAllScribeTags(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeAllTags post map " + linkedHashMap2);
        return AndroidNetworking.post(this.UNSUBSCRIBE_ALL_TAGS_URL_RPIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void checkSubScribeTags(String str, String str2, String str3, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "checkPush post map " + linkedHashMap2);
        AndroidNetworking.get(this.CHECK_SUBSCRIBE_TAGS_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse checkSubScribeTags(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "checkPush post map " + linkedHashMap2);
        return AndroidNetworking.get(this.CHECK_SUBSCRIBE_TAGS_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().executeForString();
    }

    public void subScribeAlias(String str, String str2, String str3, String str4, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("appKey", str2);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        AndroidNetworking.post(this.SUBSCRIBE_ALIAS_URL_PRIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse subScribeAlias(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("appKey", str2);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        return AndroidNetworking.post(this.SUBSCRIBE_ALIAS_URL_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void unSubScribeAlias(String str, String str2, String str3, String str4, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        AndroidNetworking.post(this.UNSUBSCRIBE_ALIAS_URL_PRIX).addBodyParameter(linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse unSubScribeAlias(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "subScribeTags post map " + linkedHashMap2);
        return AndroidNetworking.post(this.UNSUBSCRIBE_ALIAS_URL_PRIX).addBodyParameter(linkedHashMap2).build().executeForString();
    }

    public void checkSubScribeAlias(String str, String str2, String str3, OkHttpResponseAndStringRequestListener okHttpResponseAndStringRequestListener) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "checkPush post map " + linkedHashMap2);
        AndroidNetworking.get(this.CHECK_SUBSCRIBE_ALIAS_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().getAsOkHttpResponseAndString(okHttpResponseAndStringRequestListener);
    }

    public ANResponse checkSubScribeAlias(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, str2));
        DebugLogger.m4829i(TAG, "checkPush post map " + linkedHashMap2);
        return AndroidNetworking.get(this.CHECK_SUBSCRIBE_ALIAS_URL_PRIX).addQueryParameter((HashMap<String, String>) linkedHashMap2).build().executeForString();
    }

    public ANResponse<String> uploadLogFile(String str, String str2, String str3, File file) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msgId", str);
        linkedHashMap.put("deviceId", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", SignUtils.getSignature(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMap2.put("errorMsg", str3);
        }
        DebugLogger.m4829i(TAG, "uploadLogFile post map " + linkedHashMap2);
        return AndroidNetworking.upload(this.UPLOAD_LOG_FILE_URL_PRIX).addMultipartParameter(linkedHashMap2).addMultipartFile("logFile", file).build().executeForString();
    }
}
