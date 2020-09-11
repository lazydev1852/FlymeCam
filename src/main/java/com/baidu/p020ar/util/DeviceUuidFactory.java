package com.baidu.p020ar.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* renamed from: com.baidu.ar.util.DeviceUuidFactory */
public final class DeviceUuidFactory {

    /* renamed from: a */
    protected static UUID f2367a;

    public DeviceUuidFactory(Context context) {
        if (f2367a == null) {
            synchronized (DeviceUuidFactory.class) {
                if (f2367a == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                    String string = sharedPreferences.getString("device_id", (String) null);
                    if (string != null) {
                        f2367a = UUID.fromString(string);
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), Parameters.ANDROID_ID);
                        try {
                            if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                f2367a = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                            }
                            sharedPreferences.edit().putString("device_id", f2367a.toString()).commit();
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public UUID getDeviceUuid() {
        return f2367a;
    }
}
