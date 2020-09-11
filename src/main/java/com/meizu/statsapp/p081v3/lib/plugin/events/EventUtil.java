package com.meizu.statsapp.p081v3.lib.plugin.events;

import android.content.Context;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.events.EventUtil */
public class EventUtil {
    public static ActionXEvent buildActionXEvent(Context context, String str, String str2, Map<String, String> map) {
        String str3;
        if (FlymeOSUtils.isBox(context)) {
            str3 = NetInfoUtils.getNetworkTypeForFlymeTv(context);
        } else {
            str3 = NetInfoUtils.getNetworkType(context);
        }
        ActionXEvent actionXEvent = new ActionXEvent(str, str3);
        actionXEvent.setTime(System.currentTimeMillis());
        actionXEvent.setPage(str2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str4 = (String) next.getKey();
                String str5 = (String) next.getValue();
                if (str5 != null && str5.indexOf(10) >= 0) {
                    next.setValue(str5.replace(10, 0));
                }
            }
        }
        actionXEvent.setProperties(map);
        actionXEvent.setEvent_attrib((Map<String, String>) null);
        return actionXEvent;
    }

    public static LogEvent buildLogEvent(Context context, String str, Map<String, String> map) {
        String str2;
        if (FlymeOSUtils.isBox(context)) {
            str2 = NetInfoUtils.getNetworkTypeForFlymeTv(context);
        } else {
            str2 = NetInfoUtils.getNetworkType(context);
        }
        LogEvent logEvent = new LogEvent(str, str2);
        logEvent.setTime(System.currentTimeMillis());
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str3 = (String) next.getKey();
                String str4 = (String) next.getValue();
                if (str4 != null && str4.indexOf(10) >= 0) {
                    next.setValue(str4.replace(10, 0));
                }
            }
        }
        logEvent.setProperties(map);
        return logEvent;
    }

    public static PageEvent buildPageEvent(Context context, String str, String str2, String str3) {
        String str4;
        if (FlymeOSUtils.isBox(context)) {
            str4 = NetInfoUtils.getNetworkTypeForFlymeTv(context);
        } else {
            str4 = NetInfoUtils.getNetworkType(context);
        }
        PageEvent pageEvent = new PageEvent(str, str4);
        pageEvent.setLaunch(str2);
        pageEvent.setTerminate(str3);
        return pageEvent;
    }
}
