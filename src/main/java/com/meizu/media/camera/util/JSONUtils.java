package com.meizu.media.camera.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.aa */
public class JSONUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f14060a;

    /* renamed from: a */
    public static <T> T m15932a(String str, TypeReference<T> typeReference) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, typeReference}, (Object) null, f14060a, true, 8106, new Class[]{String.class, TypeReference.class}, Object.class);
        if (proxy.isSupported) {
            return (Object) proxy.result;
        }
        try {
            return JSON.parseObject(str, typeReference, new Feature[0]);
        } catch (JSONException e) {
            if ("unclosed string : '".equals(e.getMessage())) {
                return JSON.parseObject(str.replace("\\'", "'"), typeReference, new Feature[0]);
            }
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
