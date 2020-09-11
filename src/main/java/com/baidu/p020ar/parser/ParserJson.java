package com.baidu.p020ar.parser;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.p020ar.arplay.representation.Number3D;
import com.baidu.p020ar.bean.ARResource;
import com.baidu.p020ar.bean.AttrData;
import com.baidu.p020ar.bean.C0623a;
import com.baidu.p020ar.bean.C0624b;
import com.baidu.p020ar.bean.C0627d;
import com.baidu.p020ar.bean.C0628e;
import com.baidu.p020ar.bean.C0629f;
import com.baidu.p020ar.bean.FunctionType;
import com.baidu.p020ar.bean.TipBean;
import com.baidu.p020ar.bean.TrackRes;
import com.baidu.p020ar.constants.ARConfigKey;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.Constants;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.mediatek.mmsdk.BaseParameters;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.parser.ParserJson */
public final class ParserJson {
    private ParserJson() {
    }

    /* renamed from: a */
    private static Number3D m2163a(String str) {
        Number3D number3D = new Number3D();
        try {
            String[] split = str.split(SystemInfoUtil.COMMA);
            number3D.setAll(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue(), Float.valueOf(split[2]).floatValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number3D;
    }

    /* renamed from: a */
    private static ARResource m2164a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("ar_key");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        int optInt = jSONObject.optInt("ar_type");
        String optString2 = jSONObject.optString(ARResourceKey.THUMBNAIL);
        String optString3 = jSONObject.optString(ARResourceKey.HTTP_VERSION_CODE);
        ARResource aRResource = new ARResource();
        aRResource.setKey(optString);
        aRResource.setType(optInt);
        aRResource.setThumbnailUrl(optString2);
        aRResource.setVersionCode(optString3);
        return aRResource;
    }

    /* renamed from: a */
    private static TipBean m2165a(JSONObject jSONObject, String str) {
        int parseInt;
        TipBean tipBean = new TipBean();
        try {
            if (jSONObject.has("udt_tip_simple")) {
                tipBean.setDemarcateTip(jSONObject.getString("udt_tip_simple"));
            }
            if (jSONObject.has("udt_tip_detail")) {
                tipBean.setDemarcateFailedTip(jSONObject.getString("udt_tip_detail"));
            }
            if (jSONObject.has("hint")) {
                tipBean.setHint(jSONObject.getString("hint"));
            }
            if (jSONObject.has("too_far_hint")) {
                tipBean.setTooFarHint(jSONObject.getString("too_far_hint"));
            }
            if (jSONObject.has("too_near_hint")) {
                tipBean.setTooNearHint(jSONObject.getString("too_near_hint"));
            }
            if (jSONObject.has("not_find_hint")) {
                tipBean.setNotFindHint(jSONObject.getString("not_find_hint"));
            }
            if (jSONObject.has("far_threshold")) {
                tipBean.setFarThreshold(Float.parseFloat(jSONObject.getString("far_threshold")));
            }
            if (jSONObject.has("near_threshold")) {
                tipBean.setNearThreshold(Float.parseFloat(jSONObject.getString("near_threshold")));
            }
            if (jSONObject.has("case_type") && (parseInt = Integer.parseInt(jSONObject.getString("case_type"))) >= 0 && parseInt < AttrData.CaseType.values().length) {
                tipBean.setCaseType(AttrData.CaseType.values()[parseInt]);
            }
            if (jSONObject.has("udt_mode")) {
                tipBean.setUdtMode(Integer.parseInt(jSONObject.getString("udt_mode")));
            }
            if (jSONObject.has("help_url")) {
                tipBean.setHelpUrl(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("help_url_show_once")) {
                tipBean.setHelpUrlShowOnce(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("help_url_show_once")) {
                tipBean.setHelpUrlShowOnce(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("slam_texture_tip")) {
                tipBean.setFindPerfectPlane(jSONObject.getString("slam_texture_tip"));
            }
            if (jSONObject.has("help_url")) {
                tipBean.setPlayDesUrl(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("slam_device_orientation_tip")) {
                tipBean.setAlignPlane(jSONObject.getString("slam_device_orientation_tip"));
            }
            if (jSONObject.has("image_target_path")) {
                tipBean.setTrackTargePicPath(jSONObject.getString("image_target_path"));
            }
            if (jSONObject.has("hide_shot_immediately")) {
                tipBean.setHideCaptureGroupImmediately(jSONObject.getInt("hide_shot_immediately"));
            }
            if (jSONObject.has("show_tips_by_case")) {
                tipBean.setShowTipsByCase(jSONObject.getInt("show_tips_by_case"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipBean;
    }

    /* renamed from: b */
    private static C0629f m2166b(JSONObject jSONObject, String str) {
        C0629f fVar = new C0629f();
        try {
            if (str.length() > 0) {
                fVar.mo9729a(str.substring(0, str.lastIndexOf(47)));
            }
            if (jSONObject.has("id")) {
                fVar.mo9732b(jSONObject.getString("id"));
            }
            if (jSONObject.has("name")) {
                fVar.mo9735c(jSONObject.getString("name"));
            }
            if (jSONObject.has("model_path")) {
                fVar.mo9738d(jSONObject.getString("model_path"));
            }
            if (jSONObject.has("template_width")) {
                fVar.mo9734c(jSONObject.getInt("template_width"));
            }
            if (jSONObject.has("template_height")) {
                fVar.mo9737d(jSONObject.getInt("template_height"));
            }
            if (jSONObject.has("target_width")) {
                fVar.mo9727a(jSONObject.getInt("target_width"));
            }
            if (jSONObject.has("target_height")) {
                fVar.mo9731b(jSONObject.getInt("target_height"));
            }
            if (jSONObject.has("centre_pos")) {
                fVar.mo9728a(m2163a(jSONObject.getString("centre_pos")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Constants.DEBUG) {
            ARLog.m2695d(fVar.toString());
        }
        return fVar;
    }

    public static ARResource parseARResource(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ARResource aRResource = new ARResource();
        try {
            if (jSONObject.has(ARResourceKey.HTTP_ERR_CODE)) {
                aRResource.setErrCode(jSONObject.getInt(ARResourceKey.HTTP_ERR_CODE));
            }
            if (jSONObject.has(ARResourceKey.HTTP_ERR_MSG)) {
                aRResource.setErrMsg(jSONObject.getString(ARResourceKey.HTTP_ERR_MSG));
            }
            if (jSONObject.has(ARResourceKey.HTTP_RET)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(ARResourceKey.HTTP_RET);
                if (jSONObject2.has("ar_key")) {
                    aRResource.setKey(jSONObject2.getString("ar_key"));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_AR_RESOURCE)) {
                    aRResource.setResourceUrl(jSONObject2.getString(ARResourceKey.HTTP_AR_RESOURCE));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_AR_MULTI_RESOURCE)) {
                    JSONArray jSONArray = jSONObject2.getJSONArray(ARResourceKey.HTTP_AR_MULTI_RESOURCE);
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    aRResource.setMultiResourceUrl(strArr);
                }
                if (jSONObject2.has(ARResourceKey.HTTP_AR_REDIRECT_URL)) {
                    aRResource.setRedirectUrl(jSONObject2.getString(ARResourceKey.HTTP_AR_REDIRECT_URL));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_VERSION_CODE)) {
                    aRResource.setVersionCode(jSONObject2.getString(ARResourceKey.HTTP_VERSION_CODE));
                }
                if (jSONObject2.has("ar_type")) {
                    aRResource.setType(Integer.parseInt(jSONObject2.getString("ar_type")));
                }
                if (jSONObject2.has("md5")) {
                    aRResource.setZipMD5(jSONObject2.getString("md5"));
                }
                if (jSONObject2.has(ARResourceKey.AR_HARDWARE_SATISFIED)) {
                    aRResource.setHardwareSatisfied(jSONObject2.getBoolean(ARResourceKey.AR_HARDWARE_SATISFIED));
                }
                if (jSONObject2.has(ARResourceKey.AC_ID)) {
                    aRResource.setAcId(jSONObject2.getString(ARResourceKey.AC_ID));
                }
                if (jSONObject2.has(ARResourceKey.HTTP_REFUSED)) {
                    boolean z = true;
                    if (Integer.parseInt(jSONObject2.getString(ARResourceKey.HTTP_REFUSED)) != 1) {
                        z = false;
                    }
                    aRResource.setRefused(z);
                }
                if (jSONObject2.has(ARResourceKey.SHOW_AUDIO_DIALOG)) {
                    aRResource.setShowAudioDialog(jSONObject2.getBoolean(ARResourceKey.SHOW_AUDIO_DIALOG));
                }
                aRResource.setCodeDownloadUrl(jSONObject2.optString(ARResourceKey.AR_CODE_URL));
                JSONArray optJSONArray = jSONObject2.optJSONArray(ARResourceKey.HTTP_POWER);
                if (optJSONArray != null) {
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(FunctionType.getValueOf(next), Boolean.valueOf(optJSONObject.getBoolean(next)));
                            }
                        }
                    }
                    aRResource.setFunctionMap(hashMap);
                }
            }
            return aRResource;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TrackRes parseCaseConfig(String str, String str2, String str3) {
        String defaultJsonPath = ARFileUtils.getDefaultJsonPath(str);
        String targetJsonPath = ARFileUtils.getTargetJsonPath(str);
        TrackRes trackRes = null;
        try {
            if (new File(defaultJsonPath).exists() && !TextUtils.isEmpty(str2)) {
                trackRes = parseDefaultJSON(str2, defaultJsonPath);
            }
            if (trackRes == null && new File(targetJsonPath).exists() && !TextUtils.isEmpty(str3)) {
                return parseTrackRes(str3, targetJsonPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trackRes;
    }

    public static TrackRes parseDefaultJSON(String str, String str2) {
        TrackRes trackRes = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("ar_configs")) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("ar_configs");
            if (jSONArray.length() == 0) {
                return null;
            }
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
            if (!jSONObject2.has("ar_target")) {
                return null;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("ar_target");
            TrackRes trackRes2 = new TrackRes();
            try {
                if (jSONObject3.has("targets")) {
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("targets");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        try {
                            arrayList.add(m2166b((JSONObject) jSONArray2.get(i), str2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    trackRes2.setTargetBeanList(arrayList);
                }
                if (jSONObject3.has("UI")) {
                    trackRes2.setTipBean(m2165a(jSONObject3.getJSONObject("UI"), str2));
                }
                if (jSONObject.has(NotificationCompat.CATEGORY_SERVICE)) {
                    trackRes2.setService(parseService(jSONObject.getJSONObject(NotificationCompat.CATEGORY_SERVICE), str2));
                }
                return trackRes2;
            } catch (Exception e2) {
                e = e2;
                trackRes = trackRes2;
                e.printStackTrace();
                return trackRes;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return trackRes;
        }
    }

    public static C0623a parseDuMixRes(String str) {
        C0623a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar = new C0623a();
            try {
                if (jSONObject.has(ARConfigKey.OLD_AR_TYPE)) {
                    aVar.mo9669a(jSONObject.getInt(ARConfigKey.OLD_AR_TYPE));
                }
                if (jSONObject.has("supportFrontCamera")) {
                    aVar.mo9670a(jSONObject.getBoolean("supportFrontCamera"));
                }
                if (jSONObject.has("containMusic")) {
                    aVar.mo9671b(jSONObject.getBoolean("containMusic"));
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return aVar;
            }
        } catch (Exception e2) {
            e = e2;
            aVar = null;
            e.printStackTrace();
            return aVar;
        }
        return aVar;
    }

    public static C0624b parsePaddle(JSONObject jSONObject, String str) {
        C0624b bVar = new C0624b();
        try {
            if (jSONObject.has("path")) {
                bVar.mo9677a(jSONObject.getString("path"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bVar;
    }

    public static List<C0624b> parsePaddleList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C0624b bVar = new C0624b();
                if (jSONObject.has("path")) {
                    bVar.mo9677a(jSONObject.getString("path"));
                }
                if (jSONObject.has("type")) {
                    bVar.mo9681b(jSONObject.getString("type"));
                }
                if (jSONObject.has("width")) {
                    bVar.mo9676a(jSONObject.getInt("width"));
                }
                if (jSONObject.has("height")) {
                    bVar.mo9680b(jSONObject.getInt("height"));
                }
                if (jSONObject.has("fg_thres")) {
                    bVar.mo9675a((float) jSONObject.getDouble("fg_thres"));
                }
                if (jSONObject.has("bg_thres")) {
                    bVar.mo9679b((float) jSONObject.getDouble("bg_thres"));
                }
                if (jSONObject.has("node_name")) {
                    bVar.mo9684c(jSONObject.getString("node_name"));
                }
                if (jSONObject.has("r_mean")) {
                    bVar.mo9683c((float) jSONObject.getDouble("r_mean"));
                }
                if (jSONObject.has("g_mean")) {
                    bVar.mo9686d((float) jSONObject.getDouble("g_mean"));
                }
                if (jSONObject.has("b_mean")) {
                    bVar.mo9688e((float) jSONObject.getDouble("b_mean"));
                }
                if (jSONObject.has("r_scale")) {
                    bVar.mo9690f((float) jSONObject.getDouble("r_scale"));
                }
                if (jSONObject.has("g_scale")) {
                    bVar.mo9692g((float) jSONObject.getDouble("g_scale"));
                }
                if (jSONObject.has("b_scale")) {
                    bVar.mo9694h((float) jSONObject.getDouble("b_scale"));
                }
                arrayList.add(bVar);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static List<ARResource> parseRecommendList(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || jSONObject.optInt("errorNum", -1) != 0 || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            ARResource a = m2164a(optJSONArray.optJSONObject(i));
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static C0627d parseService(JSONObject jSONObject, String str) {
        C0627d dVar = new C0627d();
        try {
            if (jSONObject.has("open_track_service")) {
                dVar.mo9711a(jSONObject.getInt("open_track_service"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dVar;
    }

    public static C0628e parseSlamModel(JSONObject jSONObject, String str) {
        C0628e eVar = new C0628e();
        try {
            if (jSONObject.has("id")) {
                eVar.mo9714a(jSONObject.getString("id"));
            }
            if (jSONObject.has("place_type")) {
                eVar.mo9713a(jSONObject.getInt("place_type"));
            }
            if (jSONObject.has("position")) {
                eVar.mo9718b(jSONObject.getString("position"));
            }
            if (jSONObject.has("distance")) {
                eVar.mo9717b(jSONObject.getInt("distance"));
            }
            if (jSONObject.has("pitch_angle")) {
                eVar.mo9720c(jSONObject.getInt("pitch_angle"));
            }
            if (jSONObject.has(BaseParameters.KEY_PICTURE_ROTATION)) {
                eVar.mo9721c(jSONObject.getString(BaseParameters.KEY_PICTURE_ROTATION));
            }
            if (jSONObject.has("immediately_place_model")) {
                boolean z = true;
                if (jSONObject.getInt("immediately_place_model") != 1) {
                    z = false;
                }
                eVar.mo9715a(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eVar;
    }

    public static TrackRes parseTrackRes(String str, String str2) {
        try {
            TrackRes trackRes = new TrackRes();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("targets")) {
                JSONArray jSONArray = jSONObject.getJSONArray("targets");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(m2166b((JSONObject) jSONArray.get(i), str2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                trackRes.setTargetBeanList(arrayList);
            }
            if (jSONObject.has("UI")) {
                trackRes.setTipBean(m2165a(jSONObject.getJSONObject("UI"), str2));
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_SERVICE)) {
                trackRes.setService(parseService(jSONObject.getJSONObject(NotificationCompat.CATEGORY_SERVICE), str2));
            }
            if (jSONObject.has("slam_model")) {
                trackRes.setSlamModel(parseSlamModel(jSONObject.getJSONObject("slam_model"), str2));
            }
            if (jSONObject.has("paddle_config")) {
                trackRes.setPaddle(parsePaddleList(jSONObject.getJSONArray("paddle_config")));
            } else if (jSONObject.has("paddle_model")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("paddle_model");
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(parsePaddle(jSONObject2, str2));
                trackRes.setPaddle(arrayList2);
            }
            return trackRes;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
