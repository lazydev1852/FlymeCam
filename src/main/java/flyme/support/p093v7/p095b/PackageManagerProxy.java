package flyme.support.p093v7.p095b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.os.Build;
import flyme.support.p093v7.appcompat.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: flyme.support.v7.b.b */
public class PackageManagerProxy {

    /* renamed from: a */
    private PackageManager f17047a;

    public PackageManagerProxy(PackageManager packageManager) {
        this.f17047a = packageManager;
    }

    /* renamed from: a */
    public List<String> mo25364a() {
        ArrayList arrayList = new ArrayList();
        for (PermissionGroupInfo permissionGroupInfo : this.f17047a.getAllPermissionGroups(128)) {
            arrayList.add(permissionGroupInfo.name);
        }
        arrayList.add("meizu.permission-group.NETWORK");
        arrayList.add("meizu.permission-group.CHANGE_NETWORK");
        arrayList.add("meizu.permission-group.BLUETOOTH");
        arrayList.add("meizu.permission-group.OTHER");
        if (Build.VERSION.SDK_INT >= 29) {
            arrayList.remove("android.permission-group.UNDEFINED");
        }
        return arrayList;
    }

    /* renamed from: a */
    public Set<String> mo25365a(String str) {
        HashSet hashSet = new HashSet();
        if ("meizu.permission-group.NETWORK".equals(str)) {
            hashSet.add("android.permission.INTERNET");
            hashSet.add("android.permission.ACCESS_NETWORK_STATE");
            hashSet.add("android.permission.CHANGE_NETWORK_STATE");
        } else if ("meizu.permission-group.CHANGE_NETWORK".equals(str)) {
            hashSet.add("android.permission.CHANGE_WIFI_STATE");
        } else if ("meizu.permission-group.BLUETOOTH".equals(str)) {
            hashSet.add("android.permission.BLUETOOTH");
            hashSet.add("android.permission.BLUETOOTH_ADMIN");
        } else if (!"meizu.permission-group.OTHER".equals(str)) {
            try {
                for (PermissionInfo permissionInfo : this.f17047a.queryPermissionsByGroup(str, 128)) {
                    hashSet.add(permissionInfo.name);
                }
                if ("android.permission-group.SMS".equals(str)) {
                    hashSet.add("android.permission.WRITE_SMS");
                }
            } catch (Exception unused) {
            }
        }
        m18686a(str, (Set<String>) hashSet);
        return hashSet;
    }

    /* renamed from: a */
    private void m18686a(String str, Set<String> set) {
        if (Build.VERSION.SDK_INT >= 29) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1639857183:
                    if (str.equals("android.permission-group.CONTACTS")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1410061184:
                    if (str.equals("android.permission-group.PHONE")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1250730292:
                    if (str.equals("android.permission-group.CALENDAR")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1243751087:
                    if (str.equals("android.permission-group.CALL_LOG")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1140935117:
                    if (str.equals("android.permission-group.CAMERA")) {
                        c = 8;
                        break;
                    }
                    break;
                case 225035509:
                    if (str.equals("android.permission-group.ACTIVITY_RECOGNITION")) {
                        c = 9;
                        break;
                    }
                    break;
                case 421761675:
                    if (str.equals("android.permission-group.SENSORS")) {
                        c = 5;
                        break;
                    }
                    break;
                case 828638019:
                    if (str.equals("android.permission-group.LOCATION")) {
                        c = 3;
                        break;
                    }
                    break;
                case 852078861:
                    if (str.equals("android.permission-group.STORAGE")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1581272376:
                    if (str.equals("android.permission-group.MICROPHONE")) {
                        c = 10;
                        break;
                    }
                    break;
                case 1795181803:
                    if (str.equals("android.permission-group.SMS")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    set.add("android.permission.READ_CALENDAR");
                    set.add("android.permission.WRITE_CALENDAR");
                    return;
                case 1:
                    set.add("android.permission.READ_SMS");
                    set.add("android.permission.RECEIVE_WAP_PUSH");
                    set.add("android.permission.RECEIVE_MMS");
                    set.add("android.permission.RECEIVE_SMS");
                    set.add("android.permission.SEND_SMS");
                    set.add("android.permission.READ_CELL_BROADCASTS");
                    return;
                case 2:
                    set.add("android.permission.READ_CALL_LOG");
                    set.add("android.permission.WRITE_CALL_LOG");
                    set.add("android.permission.PROCESS_OUTGOING_CALLS");
                    return;
                case 3:
                    set.add("android.permission.ACCESS_FINE_LOCATION");
                    set.add("android.permission.ACCESS_COARSE_LOCATION");
                    set.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    return;
                case 4:
                    set.add("android.permission.ANSWER_PHONE_CALLS");
                    set.add("android.permission.READ_PHONE_NUMBERS");
                    set.add("android.permission.READ_PHONE_STATE");
                    set.add("android.permission.CALL_PHONE");
                    set.add("android.permission.ACCEPT_HANDOVER");
                    set.add("android.permission.USE_SIP");
                    set.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                    return;
                case 5:
                    set.add("android.permission.BODY_SENSORS");
                    return;
                case 6:
                    set.add("android.permission.READ_EXTERNAL_STORAGE");
                    set.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    set.add("android.permission.ACCESS_MEDIA_LOCATION");
                    return;
                case 7:
                    set.add("android.permission.WRITE_CONTACTS");
                    set.add("android.permission.GET_ACCOUNTS");
                    set.add("android.permission.READ_CONTACTS");
                    return;
                case 8:
                    set.add("android.permission.CAMERA");
                    return;
                case 9:
                    set.add("android.permission.ACTIVITY_RECOGNITION");
                    return;
                case 10:
                    set.add("android.permission.RECORD_AUDIO");
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public String mo25363a(Context context, String str) {
        if ("meizu.permission-group.NETWORK".equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_net);
        }
        if ("meizu.permission-group.CHANGE_NETWORK".equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_change_network);
        }
        if ("meizu.permission-group.BLUETOOTH".equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_bluetooth);
        }
        if ("meizu.permission-group.OTHER".equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_other);
        }
        try {
            return this.f17047a.getPermissionGroupInfo(str, 128).loadLabel(this.f17047a).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String mo25366b(String str) {
        try {
            PermissionInfo permissionInfo = this.f17047a.getPermissionInfo(str, 128);
            if (permissionInfo.labelRes == 0) {
                return null;
            }
            return permissionInfo.loadLabel(this.f17047a).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
