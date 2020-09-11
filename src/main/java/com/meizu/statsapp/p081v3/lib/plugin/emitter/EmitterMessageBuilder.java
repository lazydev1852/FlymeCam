package com.meizu.statsapp.p081v3.lib.plugin.emitter;

import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.EmitterMessageBuilder */
public class EmitterMessageBuilder {
    protected static String elementSeparate = new String(separate02);
    protected static String fieldSeparate = new String(separate01);
    protected static String mapSeparate = new String(separate03);
    protected static String newlineSeparate = new String("\n");
    protected static byte[] separate00 = {0};
    protected static byte[] separate01 = {1};
    protected static byte[] separate02 = {2};
    protected static byte[] separate03 = {3};

    protected static int booleanToInt(boolean z) {
        return z ? 1 : 0;
    }

    public static String buildEvents(List<TrackerPayload> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(UxipConstants.EVENT_UPLOAD_MAJOR_VERSION);
        sb.append(UxipConstants.EVENT_UPLOAD_MIN_VERSION);
        for (TrackerPayload parcelOneEvent : list) {
            sb.append(parcelOneEvent(parcelOneEvent));
        }
        return sb.toString();
    }

    protected static String parcelOneEvent(TrackerPayload trackerPayload) {
        StringBuilder sb = new StringBuilder();
        sb.append(newlineSeparate);
        sb.append("0");
        parcelDevice(trackerPayload, sb);
        parcelApp(trackerPayload, sb);
        parcelEvent(trackerPayload, sb);
        parceIDIdentify(trackerPayload, sb);
        return sb.toString();
    }

    protected static void parcelDevice(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.getMap().get(Parameters.BRAND);
        if (obj != null && (obj instanceof String)) {
            sb.append(obj);
        }
        sb.append(fieldSeparate);
        Object obj2 = trackerPayload.getMap().get(Parameters.DEVICE);
        if (obj2 != null && (obj2 instanceof String)) {
            sb.append(obj2);
        }
        sb.append(fieldSeparate);
        Object obj3 = trackerPayload.getMap().get(Parameters.PRODUCT_MODEL);
        if (obj3 != null && (obj3 instanceof String)) {
            sb.append(obj3);
        }
        sb.append(fieldSeparate);
        Object obj4 = trackerPayload.getMap().get("os_type");
        if (obj4 != null && (obj4 instanceof String)) {
            sb.append(obj4);
        }
        sb.append(fieldSeparate);
        Object obj5 = trackerPayload.getMap().get("os_version");
        if (obj5 != null && (obj5 instanceof String)) {
            sb.append(obj5);
        }
        sb.append(fieldSeparate);
        Object obj6 = trackerPayload.getMap().get(Parameters.f15985OS);
        if (obj6 != null && (obj6 instanceof String)) {
            sb.append(obj6);
        }
        sb.append(fieldSeparate);
        Object obj7 = trackerPayload.getMap().get(Parameters.FLYME_VER);
        if (obj7 != null && (obj7 instanceof String)) {
            sb.append(obj7);
        }
        sb.append(fieldSeparate);
        Object obj8 = trackerPayload.getMap().get(Parameters.BUILD_MASK);
        if (obj8 != null && (obj8 instanceof String)) {
            sb.append(obj8);
        }
        sb.append(fieldSeparate);
        Object obj9 = trackerPayload.getMap().get("umid");
        if (obj9 != null && (obj9 instanceof String)) {
            sb.append(obj9);
        }
        sb.append(fieldSeparate);
        Object obj10 = trackerPayload.getMap().get("imei");
        if (obj10 != null && (obj10 instanceof String)) {
            sb.append(obj10);
        }
        sb.append(fieldSeparate);
        Object obj11 = trackerPayload.getMap().get(Parameters.MAC_ADDRESS);
        if (obj11 != null && (obj11 instanceof String)) {
            sb.append(obj11);
        }
        sb.append(fieldSeparate);
        Object obj12 = trackerPayload.getMap().get("sn");
        if (obj12 != null && (obj12 instanceof String)) {
            sb.append(obj12);
        }
        sb.append(fieldSeparate);
        Object obj13 = trackerPayload.getMap().get(Parameters.ANDROID_ID);
        if (obj13 != null && (obj13 instanceof String)) {
            sb.append(obj13);
        }
        sb.append(fieldSeparate);
        Object obj14 = trackerPayload.getMap().get(Parameters.ANDROID_AD_ID);
        if (obj14 != null && (obj14 instanceof String)) {
            sb.append(obj14);
        }
        sb.append(fieldSeparate);
        Object obj15 = trackerPayload.getMap().get(Parameters.IMSI1);
        if (obj15 != null && (obj15 instanceof String)) {
            sb.append(obj15);
        }
        sb.append(fieldSeparate);
        Object obj16 = trackerPayload.getMap().get(Parameters.IMSI2);
        if (obj16 != null && (obj16 instanceof String)) {
            sb.append(obj16);
        }
        sb.append(fieldSeparate);
        Object obj17 = trackerPayload.getMap().get(Parameters.TER_TYPE);
        if (obj17 != null && (obj17 instanceof Integer)) {
            sb.append(obj17);
        }
        sb.append(fieldSeparate);
        Object obj18 = trackerPayload.getMap().get(Parameters.SRE);
        if (obj18 != null && (obj18 instanceof String)) {
            sb.append(obj18);
        }
        sb.append(fieldSeparate);
        Object obj19 = trackerPayload.getMap().get("lla");
        if (obj19 != null && (obj19 instanceof String)) {
            sb.append(obj19);
        }
        sb.append(fieldSeparate);
        Object obj20 = trackerPayload.getMap().get(Parameters.ROOT);
        if (obj20 != null && (obj20 instanceof Boolean)) {
            sb.append(booleanToInt(((Boolean) obj20).booleanValue()));
        }
        sb.append(fieldSeparate);
        Object obj21 = trackerPayload.getMap().get(Parameters.FLYME_UID);
        if (obj21 != null && (obj21 instanceof String)) {
            sb.append(obj21);
        }
        sb.append(fieldSeparate);
        Object obj22 = trackerPayload.getMap().get(Parameters.COUNTRY);
        if (obj22 != null && (obj22 instanceof String)) {
            sb.append(obj22);
        }
        sb.append(fieldSeparate);
        Object obj23 = trackerPayload.getMap().get(Parameters.OPERATOR);
        if (obj23 != null && (obj23 instanceof String)) {
            sb.append(obj23);
        }
        sb.append(fieldSeparate);
        Object obj24 = trackerPayload.getMap().get(Parameters.INTERNATIONAL);
        if (obj24 != null && (obj24 instanceof Boolean)) {
            sb.append(booleanToInt(((Boolean) obj24).booleanValue()));
        }
        sb.append(fieldSeparate);
    }

    protected static void parcelApp(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.getMap().get(Parameters.PKG_KEY);
        if (obj != null && (obj instanceof String)) {
            sb.append(obj);
        }
        sb.append(fieldSeparate);
        Object obj2 = trackerPayload.getMap().get(Parameters.PKG_TYPE);
        if (obj2 != null && (obj2 instanceof Integer)) {
            sb.append(obj2);
        }
        sb.append(fieldSeparate);
        Object obj3 = trackerPayload.getMap().get(Parameters.PKG_NAME);
        if (obj3 != null && (obj3 instanceof String)) {
            sb.append(obj3);
        }
        sb.append(fieldSeparate);
        Object obj4 = trackerPayload.getMap().get(Parameters.PKG_VER);
        if (obj4 != null && (obj4 instanceof String)) {
            sb.append(obj4);
        }
        sb.append(fieldSeparate);
        Object obj5 = trackerPayload.getMap().get(Parameters.PKG_VER_CODE);
        if (obj5 != null && (obj5 instanceof Integer)) {
            sb.append(obj5);
        }
        sb.append(fieldSeparate);
        Object obj6 = trackerPayload.getMap().get(Parameters.SDK_VER);
        if (obj6 != null && (obj6 instanceof String)) {
            sb.append(obj6);
        }
        sb.append(fieldSeparate);
        Object obj7 = trackerPayload.getMap().get(Parameters.CHANNEL_ID);
        if (obj7 != null && (obj7 instanceof String)) {
            sb.append(obj7);
        }
        sb.append(fieldSeparate);
    }

    protected static void parcelEvent(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.getMap().get(Parameters.SOURCE);
        if (obj != null && (obj instanceof String)) {
            sb.append(obj);
        }
        sb.append(fieldSeparate);
        Object obj2 = trackerPayload.getMap().get(Parameters.SESSION_ID);
        if (obj2 != null && (obj2 instanceof String)) {
            sb.append(obj2);
        }
        sb.append(fieldSeparate);
        Object obj3 = trackerPayload.getMap().get(Parameters.NETWORK);
        if (obj3 != null && (obj3 instanceof String)) {
            sb.append(obj3);
        }
        sb.append(fieldSeparate);
        Object obj4 = trackerPayload.getMap().get(Parameters.LONGITUDE);
        if (obj4 != null && (obj4 instanceof Double)) {
            sb.append(obj4);
        }
        sb.append(fieldSeparate);
        Object obj5 = trackerPayload.getMap().get(Parameters.LATITUDE);
        if (obj5 != null && (obj5 instanceof Double)) {
            sb.append(obj5);
        }
        sb.append(fieldSeparate);
        Object obj6 = trackerPayload.getMap().get("page");
        if (obj6 != null && (obj6 instanceof String)) {
            sb.append(obj6);
        }
        sb.append(fieldSeparate);
        Object obj7 = trackerPayload.getMap().get(Parameters.LAUNCH);
        if (obj7 != null && (obj7 instanceof String)) {
            sb.append(obj7);
        }
        sb.append(fieldSeparate);
        Object obj8 = trackerPayload.getMap().get("type");
        if (obj8 != null && (obj8 instanceof String)) {
            sb.append(obj8);
        }
        sb.append(fieldSeparate);
        Object obj9 = trackerPayload.getMap().get("name");
        if (obj9 != null && (obj9 instanceof String)) {
            sb.append(obj9);
        }
        sb.append(fieldSeparate);
        Object obj10 = trackerPayload.getMap().get("value");
        boolean z = true;
        if (obj10 != null && (obj10 instanceof Map)) {
            boolean z2 = true;
            for (Map.Entry entry : ((Map) obj10).entrySet()) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(elementSeparate);
                }
                if (entry.getKey() != null) {
                    sb.append((String) entry.getKey());
                }
                sb.append(mapSeparate);
                if (entry.getValue() != null) {
                    sb.append((String) entry.getValue());
                }
            }
        }
        sb.append(fieldSeparate);
        Object obj11 = trackerPayload.getMap().get(Parameters.EVENT_ATTRIB);
        if (obj11 != null && (obj11 instanceof Map)) {
            for (Map.Entry entry2 : ((Map) obj11).entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(elementSeparate);
                }
                if (entry2.getKey() != null) {
                    sb.append((String) entry2.getKey());
                }
                sb.append(mapSeparate);
                if (entry2.getValue() != null) {
                    sb.append((String) entry2.getValue());
                }
            }
        }
        sb.append(fieldSeparate);
        Object obj12 = trackerPayload.getMap().get(Parameters.TERMINATE);
        if (obj12 != null && (obj12 instanceof String)) {
            sb.append(obj12);
        }
        sb.append(fieldSeparate);
        Object obj13 = trackerPayload.getMap().get("time");
        if (obj13 != null && (obj13 instanceof Long)) {
            sb.append(obj13);
        }
        sb.append(fieldSeparate);
        Object obj14 = trackerPayload.getMap().get(Parameters.CSEQ);
        if (obj14 != null && (obj14 instanceof Long)) {
            sb.append(obj14);
        }
        sb.append(fieldSeparate);
        Object obj15 = trackerPayload.getMap().get(Parameters.DEBUG);
        if (obj15 != null && (obj15 instanceof Boolean)) {
            sb.append(booleanToInt(((Boolean) obj15).booleanValue()));
        }
        sb.append(fieldSeparate);
        Object obj16 = trackerPayload.getMap().get(Parameters.LOC_TIME);
        if (obj16 != null && (obj16 instanceof Long)) {
            sb.append(obj16);
        }
        sb.append(fieldSeparate);
    }

    protected static void parceIDIdentify(TrackerPayload trackerPayload, StringBuilder sb) {
        Object obj = trackerPayload.getMap().get(Parameters.UDID);
        if (obj != null && (obj instanceof String)) {
            sb.append(obj);
        }
        sb.append(fieldSeparate);
        Object obj2 = trackerPayload.getMap().get(Parameters.OAID);
        if (obj2 != null && (obj2 instanceof String)) {
            sb.append(obj2);
        }
        sb.append(fieldSeparate);
        Object obj3 = trackerPayload.getMap().get(Parameters.VAID);
        if (obj3 != null && (obj3 instanceof String)) {
            sb.append(obj3);
        }
        sb.append(fieldSeparate);
        Object obj4 = trackerPayload.getMap().get(Parameters.AAID);
        if (obj4 != null && (obj4 instanceof String)) {
            sb.append(obj4);
        }
    }
}
