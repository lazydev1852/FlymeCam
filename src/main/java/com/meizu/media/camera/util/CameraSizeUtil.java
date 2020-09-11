package com.meizu.media.camera.util;

import android.graphics.Point;
import com.mediatek.mmsdk.BaseParameters;
import com.meizu.media.camera.MzCamcorderProfileManager;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.media.camera.util.l */
public class CameraSizeUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14257a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14258b = new LogUtil.C2630a("CameraSizeUtil");

    /* renamed from: c */
    private static List<String> f14259c = new ArrayList();

    /* renamed from: d */
    private static Map<Integer, List<String>> f14260d = new HashMap();

    /* renamed from: e */
    private static Object f14261e = new Object();

    /* renamed from: a */
    public static String[] m16179a() {
        String[] strArr;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14257a, true, 7823, new Class[0], String[].class);
        if (proxy.isSupported) {
            return (String[]) proxy.result;
        }
        synchronized (f14261e) {
            strArr = (String[]) f14259c.toArray(new String[f14259c.size()]);
        }
        return strArr;
    }

    /* renamed from: a */
    public static Point m16173a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14257a, true, 7824, new Class[]{String.class}, Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        int indexOf = str.indexOf(120);
        if (indexOf == -1) {
            return null;
        }
        return new Point(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
    }

    /* renamed from: a */
    public static void m16177a(boolean z) {
        String str;
        List list;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, (Object) null, f14257a, true, 7825, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (f14261e) {
                LogUtil.m15942a(f14258b, "updatePictureSizeList start");
                if (CameraController.m8868g().mo19522k() == null || (list = f14260d.get(Integer.valueOf(CameraController.m8868g().mo19522k().mo19733b()))) == null || list.size() == 0) {
                    List<Point> o = CameraController.m8868g().mo19530o();
                    if (o != null) {
                        if (DeviceHelper.f13838R) {
                            Point point = null;
                            Point point2 = null;
                            Point point3 = null;
                            Point point4 = null;
                            for (Point next : o) {
                                int i = next.x;
                                int i2 = next.y;
                                if (i > i2) {
                                    if ((DeviceHelper.f13895av || DeviceHelper.f13896aw) && i >= DeviceHelper.f13951by) {
                                        LogUtil.m15952c(f14258b, "updatePictureSizeList not to chose 48M picsize: " + i + "x" + i2);
                                    } else {
                                        str = DeviceSizeTable.m16185a(i, i2, (String) null);
                                    }
                                } else if ((DeviceHelper.f13895av || DeviceHelper.f13896aw) && i >= DeviceHelper.f13950bx) {
                                    LogUtil.m15952c(f14258b, "updatePictureSizeList not to chose 48M picsize: " + i + "x" + i2);
                                } else {
                                    str = DeviceSizeTable.m16185a(i2, i, (String) null);
                                }
                                if (str.equals("4 : 3")) {
                                    if (point != null) {
                                        if (!m16178a(next, point)) {
                                        }
                                    }
                                    point = next;
                                } else if (str.equals("16 : 9")) {
                                    if (point2 != null) {
                                        if (!m16178a(next, point2)) {
                                        }
                                    }
                                    point2 = next;
                                } else if (DeviceHelper.f13874aa && DeviceHelper.f13883aj && str.equals(m16174a(CameraUtil.m15809a(), CameraUtil.m15865b()))) {
                                    if (point4 != null) {
                                        if (!m16178a(next, point4)) {
                                        }
                                    }
                                    point4 = next;
                                } else if (str.equals("18 : 9")) {
                                    if (point3 != null) {
                                        if (!m16178a(next, point3)) {
                                        }
                                    }
                                    point3 = next;
                                }
                            }
                            f14259c.clear();
                            if (point != null) {
                                f14259c.add(point.x + "x" + point.y);
                            }
                            if (point2 != null) {
                                f14259c.add(point2.x + "x" + point2.y);
                            }
                            if (point4 != null) {
                                f14259c.add(point4.x + "x" + point4.y);
                            } else if (point3 != null) {
                                f14259c.add(point3.x + "x" + point3.y);
                            }
                            if (CameraController.m8868g().mo19522k() != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(f14259c);
                                f14260d.put(Integer.valueOf(CameraController.m8868g().mo19522k().mo19733b()), arrayList);
                            }
                            LogUtil.m15952c(f14258b, "updatePictureSizeList finished: " + f14259c);
                            return;
                        }
                        f14259c.clear();
                        for (Point next2 : o) {
                            f14259c.add(next2.x + "x" + next2.y);
                        }
                        return;
                    }
                    return;
                }
                f14259c.clear();
                f14259c.addAll(list);
                LogUtil.m15952c(f14258b, "updatePictureSizeList end: " + f14259c);
            }
        }
    }

    /* renamed from: a */
    public static boolean m16178a(Point point, Point point2) {
        if (point == null || point2 == null || (((float) point.x) * ((float) point.y)) / 1000000.0f <= (((float) point2.x) * ((float) point2.y)) / 1000000.0f) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static ArrayList<String> m16176a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14257a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7826, new Class[]{Integer.TYPE}, ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (DeviceHelper.f13871aX) {
            if (MzCamcorderProfileManager.m10857b(i, DeviceHelper.f13957cD)) {
                arrayList.add(Integer.toString(DeviceHelper.f13957cD));
            }
        } else if (MzCamcorderProfileManager.m10857b(i, 4)) {
            arrayList.add(Integer.toString(4));
        }
        if (MzCamcorderProfileManager.m10857b(i, 5)) {
            arrayList.add(Integer.toString(5));
        }
        if (MzCamcorderProfileManager.m10857b(i, 6)) {
            arrayList.add(Integer.toString(6));
        }
        if (MzCamcorderProfileManager.m10857b(i, DeviceHelper.f14003cx)) {
            arrayList.add(Integer.toString(DeviceHelper.f14003cx));
        }
        if (MzCamcorderProfileManager.m10857b(i, DeviceHelper.f14004cy)) {
            arrayList.add(Integer.toString(DeviceHelper.f14004cy));
        }
        if (MzCamcorderProfileManager.m10857b(i, DeviceHelper.f14005cz)) {
            arrayList.add(Integer.toString(DeviceHelper.f14005cz));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static String m16180b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14257a, true, 7827, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if ((DeviceHelper.f13871aX && String.valueOf(DeviceHelper.f13957cD).equals(str)) || String.valueOf(4).equals(str)) {
            return "480P";
        }
        if (String.valueOf(DeviceHelper.f14004cy).equals(str)) {
            return "4k";
        }
        if (String.valueOf(5).equals(str)) {
            return "720P";
        }
        if (String.valueOf(6).equals(str)) {
            return "1080P";
        }
        if (String.valueOf(DeviceHelper.f14003cx).equals(str)) {
            return "1080P60fps";
        }
        return String.valueOf(DeviceHelper.f14005cz).equals(str) ? "4K60fps" : "720P";
    }

    /* renamed from: c */
    public static String m16181c(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14257a, true, 7828, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (str == null) {
            LogUtil.m15952c(f14258b, "setVideoCapturePictureSize(candidate) can't be null");
            return null;
        }
        int indexOf = str.indexOf(120);
        if (indexOf == -1) {
            return null;
        }
        int parseInt = Integer.parseInt(str.substring(0, indexOf));
        int parseInt2 = Integer.parseInt(str.substring(indexOf + 1));
        CameraController.m8868g().mo19500c(parseInt, parseInt2, new boolean[0]);
        CameraController g = CameraController.m8868g();
        g.mo19471a("video-size", parseInt + "x" + parseInt2, new boolean[0]);
        LogUtil.C2630a aVar = f14258b;
        LogUtil.m15952c(aVar, "video/pic-size " + parseInt + "x" + parseInt2);
        return parseInt + "x" + parseInt2;
    }

    /* renamed from: a */
    public static String m16175a(String str, List<Point> list) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, list}, (Object) null, f14257a, true, 7829, new Class[]{String.class, List.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (list == null) {
            LogUtil.m15952c(f14258b, "setCameraPictureSize(supported) can't be null");
        }
        if (str == null) {
            LogUtil.m15952c(f14258b, "setCameraPictureSize(candidate) can't be null");
            return null;
        }
        int indexOf = str.indexOf(120);
        if (indexOf == -1) {
            return null;
        }
        int parseInt = Integer.parseInt(str.substring(0, indexOf));
        int parseInt2 = Integer.parseInt(str.substring(indexOf + 1));
        for (int i = 0; i < list.size(); i++) {
            Point point = list.get(i);
            if (point.x == parseInt && point.y == parseInt2) {
                LogUtil.C2630a aVar = f14258b;
                LogUtil.m15942a(aVar, "setPictureSize w: " + parseInt + " h: " + parseInt2);
                if (CameraController.m8868g().mo19516h() == CameraController.CameraApi.API1) {
                    CameraController g = CameraController.m8868g();
                    g.mo19471a(BaseParameters.KEY_PICTURE_SIZE, parseInt + "x" + parseInt2, new boolean[0]);
                } else {
                    CameraController.m8868g().mo19500c(parseInt, parseInt2, new boolean[0]);
                }
                return parseInt + "x" + parseInt2;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m16182d(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14257a, true, 7830, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (m16179a().length == 0) {
            return null;
        }
        synchronized (f14261e) {
            try {
                if ("4 : 3".equals(str)) {
                    String str2 = m16179a()[0];
                    return str2;
                } else if ("16 : 9".equals(str)) {
                    String str3 = m16179a()[1];
                    return str3;
                } else if (!"18 : 9".equals(str) && (!DeviceHelper.f13874aa || !DeviceHelper.f13883aj || !m16174a(CameraUtil.m15809a(), CameraUtil.m15865b()).equals(str))) {
                    return null;
                } else {
                    String str4 = m16179a()[2];
                    return str4;
                }
            } catch (Exception unused) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a */
    public static String m16174a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, (Object) null, f14257a, true, 7831, new Class[]{Integer.TYPE, Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return String.format("%.1f : %.0f", new Object[]{Float.valueOf(((float) i2) / (((float) i) / 9.0f)), Float.valueOf(9.0f)});
    }
}
