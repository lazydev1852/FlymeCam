package com.meizu.media.mzfunnysnapsdk.AnimationNew;

import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONParser {
    public static ChangeQuickRedirect changeQuickRedirect;
    private String LAG = "JSONParser";
    JSON animationJson;
    private SpriteJSON json;
    String readJson;

    public void showAnimationPart(AnimationPart animationPart) {
    }

    public void showAnimationPartStream(AnimationPart animationPart) {
    }

    public JSONParser() {
        if (this.json == null) {
            this.json = new SpriteJSON();
        }
        if (this.json.parts_array == null) {
            this.json.parts_array = new ArrayList<>();
        }
    }

    public SpriteJSON getJsonInfo() {
        return this.json;
    }

    public AnimationPart getJsonPart(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 9041, new Class[]{Integer.TYPE}, AnimationPart.class);
        return proxy.isSupported ? (AnimationPart) proxy.result : this.json.parts_array.get(i);
    }

    public String getJsonVersion() {
        if (this.json == null) {
            return null;
        }
        return this.json.version;
    }

    public boolean loadJSONSD(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9042, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.readJson = readFileFromSD(str);
        this.animationJson = new JSON(this.readJson);
        this.json.version = this.animationJson.key(UxipConstants.RESPONSE_KEY_VERSION).stringValue();
        try {
            JSONArray jSONArray = new JSONArray(this.animationJson.key("parts").stringValue());
            this.json.parts_num = jSONArray.length();
            if (this.json.parts_num <= 0) {
                Log.e(this.LAG, "Read json is Error!");
                return false;
            }
            this.json.parts_array.clear();
            for (int i = 0; i < this.json.parts_num; i++) {
                this.json.parts_array.add(partParser(this.animationJson.key("parts").index(i)));
            }
            for (int i2 = 0; i2 < this.json.parts_num; i2++) {
                showAnimationPart(this.json.parts_array.get(i2));
            }
            return true;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loadJSONStream(InputStream inputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream}, this, changeQuickRedirect, false, 9043, new Class[]{InputStream.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.readJson = readFileFromAssetStream(inputStream);
        this.animationJson = new JSON(this.readJson);
        this.json.version = this.animationJson.key(UxipConstants.RESPONSE_KEY_VERSION).stringValue();
        Log.i(this.LAG + " Stream", "==========" + this.json.version);
        try {
            this.json.parts_num = new JSONArray(this.animationJson.key("parts").stringValue()).length();
            if (this.json.parts_num <= 0) {
                Log.e(this.LAG + " Stream", "Read json is Error!");
                return false;
            }
            this.json.parts_array.clear();
            for (int i = 0; i < this.json.parts_num; i++) {
                this.json.parts_array.add(partParser(this.animationJson.key("parts").index(i)));
            }
            for (int i2 = 0; i2 < this.json.parts_num; i2++) {
                showAnimationPartStream(this.json.parts_array.get(i2));
            }
            return true;
        } catch (JSONException e) {
            Log.i("FunnySnapFlow", "loadJSONStream: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public AnimationPart getAnimationPart(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect3, false, 9044, new Class[]{Integer.TYPE}, AnimationPart.class);
        if (proxy.isSupported) {
            return (AnimationPart) proxy.result;
        }
        if (!this.json.parts_array.isEmpty() && this.json.parts_array.size() > i) {
            return this.json.parts_array.get(i);
        }
        return null;
    }

    public AnimationPart getAnimationPart(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9045, new Class[]{String.class}, AnimationPart.class);
        if (proxy.isSupported) {
            return (AnimationPart) proxy.result;
        }
        if (this.json.parts_array.isEmpty()) {
            return null;
        }
        for (int i = 0; i < this.json.parts_array.size(); i++) {
            if (str.equals(this.json.parts_array.get(i).f15596id)) {
                return this.json.parts_array.get(i);
            }
        }
        return null;
    }

    private AnimationPart partParser(JSON json2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{json2}, this, changeQuickRedirect, false, 9046, new Class[]{JSON.class}, AnimationPart.class);
        if (proxy.isSupported) {
            return (AnimationPart) proxy.result;
        }
        if (json2 == null) {
            return null;
        }
        AnimationPart animationPart = new AnimationPart();
        animationPart.f15596id = json2.key("id").stringValue();
        if (animationPart.f15596id.isEmpty()) {
            return null;
        }
        animationPart.align = json2.key("align").stringValue();
        if (animationPart.align.isEmpty()) {
            return null;
        }
        animationPart.zPosition = json2.key("zPosition").doubleValue().floatValue();
        animationPart.width = json2.key("width").intValue();
        animationPart.height = json2.key("height").intValue();
        animationPart.frameCount = json2.key("frameCount").intValue();
        animationPart.framePerSecond = json2.key("framePerSecond").intValue();
        animationPart.triggerAction = json2.key("triggerAction").intValue();
        animationPart.triggerLoop = json2.key("triggerLoop").intValue();
        animationPart.triggerDelay = json2.key("triggerDelay").intValue();
        animationPart.triggerStop = json2.key("triggerStop").booleanValue();
        animationPart.globalScaleFactor = json2.key("globalScaleFactor").booleanValue();
        animationPart.localScale = json2.key("localScale").doubleValue().floatValue();
        JSON key = json2.key("scale");
        FacePoint2D facePoint2D = new FacePoint2D();
        facePoint2D.f15597x = key.key("pointA").index(0).key("x").doubleValue().floatValue();
        facePoint2D.f15598y = key.key("pointA").index(0).key("y").doubleValue().floatValue();
        facePoint2D.index = key.key("pointA").index(0).key("index").intValue();
        animationPart.scale_A = facePoint2D;
        FacePoint2D facePoint2D2 = new FacePoint2D();
        facePoint2D2.f15597x = key.key("pointB").index(0).key("x").doubleValue().floatValue();
        facePoint2D2.f15598y = key.key("pointB").index(0).key("y").doubleValue().floatValue();
        facePoint2D2.index = key.key("pointB").index(0).key("index").intValue();
        animationPart.scale_B = facePoint2D2;
        JSON key2 = json2.key("position");
        FacePoint2D facePoint2D3 = new FacePoint2D();
        facePoint2D3.f15597x = key2.key("positionX").index(0).key("x").doubleValue().floatValue();
        facePoint2D3.f15598y = key2.key("positionX").index(0).key("y").doubleValue().floatValue();
        facePoint2D3.index = key2.key("positionX").index(0).key("index").intValue();
        animationPart.position_X = facePoint2D3;
        FacePoint2D facePoint2D4 = new FacePoint2D();
        facePoint2D4.f15597x = key2.key("positionY").index(0).key("x").doubleValue().floatValue();
        facePoint2D4.f15598y = key2.key("positionY").index(0).key("y").doubleValue().floatValue();
        facePoint2D4.index = key2.key("positionY").index(0).key("index").intValue();
        animationPart.position_Y = facePoint2D4;
        return animationPart;
    }

    private String readFileFromAssetStream(InputStream inputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream}, this, changeQuickRedirect, false, 9047, new Class[]{InputStream.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[SYNTHETIC, Splitter:B:34:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074 A[SYNTHETIC, Splitter:B:39:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0087 A[SYNTHETIC, Splitter:B:48:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0091 A[SYNTHETIC, Splitter:B:53:0x0091] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String readFileFromSD(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r2] = r0
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r4 = 0
            r5 = 9048(0x2358, float:1.2679E-41)
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0021
            java.lang.Object r10 = r0.result
            java.lang.String r10 = (java.lang.String) r10
            return r10
        L_0x0021:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            r2.<init>(r10)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            r10.<init>(r3)     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
        L_0x0036:
            java.lang.String r1 = r10.readLine()     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            if (r1 == 0) goto L_0x0045
            r0.append(r1)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            goto L_0x0036
        L_0x0045:
            r2.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r1 = move-exception
            r1.printStackTrace()
        L_0x004d:
            r10.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0051:
            r0 = move-exception
            r1 = r10
            goto L_0x0085
        L_0x0054:
            r1 = move-exception
            r8 = r2
            r2 = r10
            r10 = r1
            goto L_0x005e
        L_0x0059:
            r0 = move-exception
            goto L_0x0085
        L_0x005b:
            r10 = move-exception
            r8 = r2
            r2 = r1
        L_0x005e:
            r1 = r8
            goto L_0x0065
        L_0x0060:
            r0 = move-exception
            r2 = r1
            goto L_0x0085
        L_0x0063:
            r10 = move-exception
            r2 = r1
        L_0x0065:
            r10.printStackTrace()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0072:
            if (r2 == 0) goto L_0x007c
            r2.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r10 = move-exception
            r10.printStackTrace()
        L_0x007c:
            java.lang.String r10 = r0.toString()
            return r10
        L_0x0081:
            r0 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L_0x0085:
            if (r2 == 0) goto L_0x008f
            r2.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r10 = move-exception
            r10.printStackTrace()
        L_0x008f:
            if (r1 == 0) goto L_0x0099
            r1.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0099:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.AnimationNew.JSONParser.readFileFromSD(java.lang.String):java.lang.String");
    }
}
