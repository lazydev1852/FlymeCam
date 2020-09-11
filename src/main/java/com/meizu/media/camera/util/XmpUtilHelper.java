package com.meizu.media.camera.util;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMeta;
import com.p006a.p007a.XMPMetaFactory;
import com.p006a.p007a.p008a.XMPMetaImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.meizu.media.camera.util.ax */
public class XmpUtilHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f14198a;

    /* renamed from: b */
    private static LogUtil.C2630a f14199b = new LogUtil.C2630a("XmpUtilHelper");

    static {
        try {
            XMPMetaFactory.m367a().mo7596a("http://com.meizu.media/camera/2.0", "MZCamera");
        } catch (XMPException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static byte[] m16124a(byte[] bArr, XmpMetaData gVar) {
        ChangeQuickRedirect changeQuickRedirect = f14198a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, gVar}, (Object) null, changeQuickRedirect, true, 8272, new Class[]{byte[].class, XmpMetaData.class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        LogUtil.m15942a(f14199b, "writeXmpMata byte[]");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XmpUtil.m16117a(new ByteArrayInputStream(bArr), byteArrayOutputStream, m16121a(gVar));
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static void m16123a(String str, XmpMetaData gVar) {
        Class[] clsArr = {String.class, XmpMetaData.class};
        if (!PatchProxy.proxy(new Object[]{str, gVar}, (Object) null, f14198a, true, 8273, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14199b;
            LogUtil.m15942a(aVar, "writeXmpMata " + str);
            XmpUtil.m16118a(str, m16121a(gVar));
        }
    }

    /* renamed from: a */
    public static XmpMetaData m16122a(XMPMetaImpl mVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{mVar}, (Object) null, f14198a, true, 8276, new Class[]{XMPMetaImpl.class}, XmpMetaData.class);
        if (proxy.isSupported) {
            return (XmpMetaData) proxy.result;
        }
        XmpMetaData gVar = new XmpMetaData();
        if (mVar != null) {
            try {
                String b = mVar.mo7538b("http://com.meizu.media/camera/2.0", "CaptureMode");
                boolean booleanValue = mVar.mo7546e("http://com.meizu.media/camera/2.0", "IsHDRActive").booleanValue();
                String b2 = mVar.mo7538b("http://com.meizu.media/camera/2.0", "LensFacing");
                int intValue = mVar.mo7547f("http://com.meizu.media/camera/2.0", ExifInterface.TAG_SCENE_TYPE).intValue();
                gVar.mo18754a(b);
                gVar.mo18755a(booleanValue);
                gVar.mo18756b("Front".equals(b2));
                gVar.mo18753a(intValue);
            } catch (XMPException e) {
                e.printStackTrace();
            }
        }
        return gVar;
    }

    /* renamed from: a */
    private static XMPMeta m16121a(XmpMetaData gVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{gVar}, (Object) null, f14198a, true, 8277, new Class[]{XmpMetaData.class}, XMPMeta.class);
        if (proxy.isSupported) {
            return (XMPMeta) proxy.result;
        }
        XMPMeta b = XMPMetaFactory.m370b();
        try {
            b.mo7530a("http://com.meizu.media/camera/2.0", "CaptureMode", (Object) gVar.mo18752a());
            b.mo7534a("http://com.meizu.media/camera/2.0", "IsHDRActive", gVar.mo18757b());
            b.mo7530a("http://com.meizu.media/camera/2.0", "LensFacing", (Object) gVar.mo18758c() ? "Front" : "Back");
            b.mo7539b("http://com.meizu.media/camera/2.0", ExifInterface.TAG_SCENE_TYPE, gVar.mo18759d());
        } catch (XMPException e) {
            e.printStackTrace();
        }
        return b;
    }
}
