package com.meizu.media.camera;

import android.content.Context;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.meizu.media.camera.x */
public class PreferenceInflater {

    /* renamed from: a */
    public static ChangeQuickRedirect f14395a;

    /* renamed from: b */
    private static final String f14396b = PreferenceInflater.class.getPackage().getName();

    /* renamed from: c */
    private static final Class<?>[] f14397c = {Context.class, AttributeSet.class};

    /* renamed from: d */
    private static final ArrayMap<String, Constructor<?>> f14398d = new ArrayMap<>();

    /* renamed from: e */
    private Context f14399e;

    /* renamed from: f */
    private String f14400f = f14396b;

    public PreferenceInflater(Context context) {
        this.f14399e = context;
    }

    /* renamed from: a */
    public synchronized CameraPreference mo22769a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14395a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2080, new Class[]{Integer.TYPE}, CameraPreference.class);
        if (proxy.isSupported) {
            return (CameraPreference) proxy.result;
        }
        return m16320a((XmlPullParser) this.f14399e.getResources().getXml(i));
    }

    /* renamed from: a */
    private CameraPreference m16319a(String str, Object[] objArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, objArr}, this, f14395a, false, 2081, new Class[]{String.class, Object[].class}, CameraPreference.class);
        if (proxy.isSupported) {
            return (CameraPreference) proxy.result;
        }
        String str2 = this.f14400f + "." + str;
        Constructor<?> constructor = f14398d.get(str2);
        if (constructor == null) {
            try {
                constructor = this.f14399e.getClassLoader().loadClass(str2).getConstructor(f14397c);
                f14398d.put(str2, constructor);
            } catch (NoSuchMethodException e) {
                throw new InflateException("Error inflating class " + str2, e);
            } catch (ClassNotFoundException e2) {
                throw new InflateException("No such class: " + str2, e2);
            } catch (Exception e3) {
                throw new InflateException("While create instance of" + str2, e3);
            }
        }
        return (CameraPreference) constructor.newInstance(objArr);
    }

    /* renamed from: a */
    private CameraPreference m16320a(XmlPullParser xmlPullParser) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{xmlPullParser}, this, f14395a, false, 2082, new Class[]{XmlPullParser.class}, CameraPreference.class);
        if (proxy.isSupported) {
            return (CameraPreference) proxy.result;
        }
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        Object[] objArr = {this.f14399e, asAttributeSet};
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                } else if (next == 2) {
                    CameraPreference a = m16319a(xmlPullParser.getName(), objArr);
                    int depth = xmlPullParser.getDepth();
                    if (depth > arrayList.size()) {
                        arrayList.add(a);
                    } else {
                        arrayList.set(depth - 1, a);
                    }
                    if (depth > 1) {
                        ((PreferenceGroup) arrayList.get(depth - 2)).mo18592a(a);
                    }
                }
            } catch (XmlPullParserException e) {
                throw new InflateException(e);
            } catch (IOException e2) {
                throw new InflateException(xmlPullParser.getPositionDescription(), e2);
            }
        }
        if (arrayList.size() != 0) {
            return (CameraPreference) arrayList.get(0);
        }
        throw new InflateException("No root element found");
    }
}
