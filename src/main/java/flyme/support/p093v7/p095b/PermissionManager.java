package flyme.support.p093v7.p095b;

import android.content.Context;
import flyme.support.p093v7.appcompat.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: flyme.support.v7.b.e */
public class PermissionManager {

    /* renamed from: d */
    private static volatile PermissionManager f17058d;

    /* renamed from: a */
    private Map<String, Localization> f17059a;

    /* renamed from: b */
    private Map<String, Set<String>> f17060b;

    /* renamed from: c */
    private PackageManagerProxy f17061c;

    /* renamed from: a */
    public static PermissionManager m18704a(Context context) {
        if (f17058d == null) {
            synchronized (PermissionManager.class) {
                if (f17058d == null) {
                    f17058d = new PermissionManager(context);
                }
            }
        }
        return f17058d;
    }

    private PermissionManager(Context context) {
        this.f17061c = new PackageManagerProxy(context.getApplicationContext().getPackageManager());
        m18705a();
        m18709b();
    }

    /* renamed from: a */
    private void m18705a() {
        this.f17059a = new HashMap();
        this.f17059a.put("meizu.permission-group.NETWORK", new Localization(0, (String) null, R.drawable.mz_permission_net));
        this.f17059a.put("android.permission-group.LOCATION", new Localization(1, "定位", R.drawable.mz_permission_location));
        this.f17059a.put("android.permission-group.CAMERA", new Localization(2, (String) null, R.drawable.mz_permission_camera));
        this.f17059a.put("android.permission-group.MICROPHONE", new Localization(3, (String) null, R.drawable.mz_permission_microphone));
        this.f17059a.put("android.permission-group.PHONE", new Localization(4, (String) null, R.drawable.mz_permission_phone));
        this.f17059a.put("android.permission-group.SMS", new Localization(5, "信息", R.drawable.mz_permission_sms));
        this.f17059a.put("android.permission-group.CONTACTS", new Localization(6, (String) null, R.drawable.mz_permission_contacts));
        this.f17059a.put("android.permission-group.CALL_LOG", new Localization(7, (String) null, R.drawable.mz_permission_calllog));
        this.f17059a.put("android.permission-group.STORAGE", new Localization(8, "手机存储", R.drawable.mz_permission_storage));
        this.f17059a.put("meizu.permission-group.BLUETOOTH", new Localization(9, (String) null, R.drawable.mz_permission_net));
        this.f17059a.put("meizu.permission-group.CHANGE_NETWORK", new Localization(10, (String) null, R.drawable.mz_permission_net));
        this.f17059a.put("android.permission-group.CALENDAR", new Localization(11, (String) null, R.drawable.mz_permission_calendar));
        this.f17059a.put("android.permission-group.SENSORS", new Localization(12, (String) null, R.drawable.mz_permission_sensors));
        this.f17059a.put("android.permission-group.ACTIVITY_RECOGNITION", new Localization(13, (String) null, R.drawable.mz_permission_sensors));
        this.f17059a.put("meizu.permission-group.OTHER", new Localization(14, (String) null, R.drawable.mz_permission_other));
        this.f17059a.put("android.permission.CALL_PHONE", new Localization(0, (String) null, 0));
        this.f17059a.put("android.permission.ANSWER_PHONE_CALLS", new Localization(1, "接听电话", 0));
        this.f17059a.put("android.permission.USE_SIP", new Localization(2, "拨打或接听 SIP 电话", 0));
        this.f17059a.put("android.permission.READ_PHONE_NUMBERS", new Localization(3, (String) null, 0));
        this.f17059a.put("android.permission.READ_PHONE_STATE", new Localization(4, "读取手机状态和识别码", 0));
        this.f17059a.put("com.android.voicemail.permission.ADD_VOICEMAIL", new Localization(5, (String) null, 0));
        this.f17059a.put("android.permission.ACCEPT_HANDOVER", new Localization(6, "继续进行来自其他应用的通话", 0));
        this.f17059a.put("android.permission.ACCESS_UCE_OPTIONS_SERVICE", new Localization(7, (String) null, 0));
        this.f17059a.put("android.permission.ACCESS_UCE_PRESENCE_SERVICE", new Localization(8, (String) null, 0));
        this.f17059a.put("android.permission.READ_CALL_LOG", new Localization(0, (String) null, 0));
        this.f17059a.put("android.permission.WRITE_CALL_LOG", new Localization(1, "修改通话记录", 0));
        this.f17059a.put("android.permission.PROCESS_OUTGOING_CALLS", new Localization(2, "修改默认电话应用", 0));
        this.f17059a.put("android.permission.READ_SMS", new Localization(0, "读取短信或彩信", 0));
        this.f17059a.put("android.permission.READ_CELL_BROADCASTS", new Localization(1, "读取小区广播", 0));
        this.f17059a.put("android.permission.SEND_SMS", new Localization(2, "发送短信或彩信", 0));
        this.f17059a.put("android.permission.RECEIVE_SMS", new Localization(3, "接收短信", 0));
        this.f17059a.put("android.permission.RECEIVE_MMS", new Localization(4, "接收彩信", 0));
        this.f17059a.put("android.permission.RECEIVE_WAP_PUSH", new Localization(5, "接收 WAP 讯息", 0));
        this.f17059a.put("android.permission.WRITE_SMS", new Localization(6, "修改短信或彩信", 0));
        this.f17059a.put("android.permission.READ_CONTACTS", new Localization(0, (String) null, 0));
        this.f17059a.put("android.permission.WRITE_CONTACTS", new Localization(1, "修改联系人", 0));
        this.f17059a.put("android.permission.GET_ACCOUNTS", new Localization(2, "读取应用账号", 0));
        this.f17059a.put("android.permission.CAMERA", new Localization(0, "拍照或录像", 0));
        this.f17059a.put("android.permission.RECORD_AUDIO", new Localization(0, "使用麦克风或录音", 0));
        this.f17059a.put("android.permission.ACCESS_FINE_LOCATION", new Localization(0, "获取确切位置信息", 0));
        this.f17059a.put("android.permission.ACCESS_COARSE_LOCATION", new Localization(1, "获取大致位置信息", 0));
        this.f17059a.put("android.permission.ACCESS_BACKGROUND_LOCATION", new Localization(2, "应用在后台时获取位置信息", 0));
        this.f17059a.put("android.permission.READ_CALENDAR", new Localization(0, "读取日历", 0));
        this.f17059a.put("android.permission.WRITE_CALENDAR", new Localization(1, "修改日历", 0));
        this.f17059a.put("android.permission.READ_EXTERNAL_STORAGE", new Localization(0, "读取照片、媒体内容和文件", 0));
        this.f17059a.put("android.permission.WRITE_EXTERNAL_STORAGE", new Localization(1, "修改照片、媒体内容和文件", 0));
        this.f17059a.put("android.permission.CHANGE_WIFI_STATE", new Localization(0, "开启或关闭无线网络", 0));
        this.f17059a.put("android.permission.BLUETOOTH", new Localization(0, (String) null, 0));
        this.f17059a.put("android.permission.BLUETOOTH_ADMIN", new Localization(1, (String) null, 0));
        this.f17059a.put("android.permission.BODY_SENSORS", new Localization(0, "读取身体传感器数据", 0));
        this.f17059a.put("android.permission.USE_FINGERPRINT", new Localization(1, (String) null, 0));
        this.f17059a.put("android.permission.USE_BIOMETRIC", new Localization(2, (String) null, 0));
        this.f17059a.put("android.permission.ACTIVITY_RECOGNITION", new Localization(0, "识别健身运动类型和状态", 0));
        this.f17059a.put("android.permission.INTERNET", new Localization(0, "连接移动网络和无线网络", 0));
        this.f17059a.put("android.permission.ACCESS_NETWORK_STATE", new Localization(1, (String) null, 0));
        this.f17059a.put("android.permission.CHANGE_NETWORK_STATE", new Localization(2, "修改网络连接", 0));
    }

    /* renamed from: b */
    private void m18709b() {
        this.f17060b = new HashMap();
        for (String next : this.f17061c.mo25364a()) {
            this.f17060b.put(next, this.f17061c.mo25365a(next));
        }
    }

    /* renamed from: a */
    public String mo25381a(Context context, String str) {
        return new Permission(str, this.f17059a.get(str), this.f17061c).mo25369a(context);
    }

    /* renamed from: a */
    public List<PermissionGroup> mo25382a(String[] strArr, String[] strArr2, int[] iArr) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList<PermissionGroup> arrayList = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (m18706a(str)) {
                PermissionGroup a = m18703a((List<PermissionGroup>) arrayList, str);
                if (!(strArr2 == null || i >= strArr2.length || strArr2[i] == null)) {
                    a.mo25379b(strArr2[i]);
                }
                if (!(iArr == null || i >= iArr.length || iArr[i] == 0)) {
                    a.mo25376a(iArr[i]);
                }
                for (String b : this.f17060b.get(str)) {
                    m18707b(arrayList, b);
                }
            } else {
                Permission b2 = m18707b(arrayList, str);
                if (!(strArr2 == null || i >= strArr2.length || strArr2[i] == null)) {
                    b2.mo25370a(strArr2[i]);
                }
            }
        }
        Collections.sort(arrayList);
        for (PermissionGroup a2 : arrayList) {
            Collections.sort(a2.mo25375a());
        }
        return arrayList;
    }

    /* renamed from: a */
    private PermissionGroup m18703a(List<PermissionGroup> list, String str) {
        for (PermissionGroup next : list) {
            if (next.mo25378b().equals(str)) {
                return next;
            }
        }
        PermissionGroup dVar = new PermissionGroup(str, this.f17059a.get(str), this.f17061c);
        list.add(dVar);
        return dVar;
    }

    /* renamed from: b */
    private Permission m18707b(List<PermissionGroup> list, String str) {
        for (PermissionGroup a : list) {
            Permission a2 = a.mo25373a(str);
            if (a2 != null) {
                return a2;
            }
        }
        Permission cVar = new Permission(str, this.f17059a.get(str), this.f17061c);
        String b = m18708b(str);
        if (b == null) {
            b = "meizu.permission-group.OTHER";
        }
        m18703a(list, b).mo25377a(cVar);
        return cVar;
    }

    /* renamed from: a */
    private boolean m18706a(String str) {
        return this.f17060b.containsKey(str);
    }

    /* renamed from: b */
    private String m18708b(String str) {
        for (Map.Entry next : this.f17060b.entrySet()) {
            Iterator it = ((Set) next.getValue()).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return (String) next.getKey();
                    }
                }
            }
        }
        return null;
    }
}
