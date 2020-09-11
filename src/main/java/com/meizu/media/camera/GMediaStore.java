package com.meizu.media.camera;

import android.net.Uri;
import android.provider.BaseColumns;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.i */
public class GMediaStore {

    /* renamed from: a */
    private static final String f10394a = "i";

    /* renamed from: com.meizu.media.camera.i$a */
    public interface C2120a extends BaseColumns {
    }

    /* renamed from: com.meizu.media.camera.i$b */
    /* compiled from: GMediaStore */
    public static final class C2121b {

        /* renamed from: com.meizu.media.camera.i$b$b */
        public interface C2123b extends C2120a {
        }

        /* renamed from: com.meizu.media.camera.i$b$a */
        /* compiled from: GMediaStore */
        public static final class C2122a implements C2123b {

            /* renamed from: a */
            public static ChangeQuickRedirect f10395a;

            /* renamed from: b */
            public static final Uri f10396b = m10673a("internal");

            /* renamed from: c */
            public static final Uri f10397c = m10673a("external");

            /* renamed from: a */
            public static Uri m10673a(String str) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f10395a, true, 1083, new Class[]{String.class}, Uri.class);
                if (proxy.isSupported) {
                    return (Uri) proxy.result;
                }
                return Uri.parse("content://com.meizu.media.gallery.store/" + str + "/video/media");
            }
        }
    }
}
