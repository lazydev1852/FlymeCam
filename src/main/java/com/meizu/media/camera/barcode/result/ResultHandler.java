package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.PaintDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.H5Activity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.barcode.entity.BarcodeRequest;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p064a.DataAdapter;
import com.meizu.media.camera.p066c.AsyncDrawable;
import com.meizu.media.camera.p066c.UriAsyncDrawable;
import com.meizu.media.camera.util.AsyncDrawableJobExecutor;
import com.meizu.media.camera.util.IntentHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.p053a.p054a.MeizuPayExportPlatform;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.share.ShareActivityStarter;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.meizu.media.camera.barcode.result.i */
public abstract class ResultHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final LogUtil.C2630a f8105a = new LogUtil.C2630a("ResultHandler");

    /* renamed from: b */
    public static ChangeQuickRedirect f8106b;

    /* renamed from: f */
    private static final String[] f8107f = {"home", "work", "mobile", "voice"};

    /* renamed from: g */
    private static final String[] f8108g = {"home", "work", "mobile", "fax", "pager", "main", "voice", "cell"};

    /* renamed from: h */
    private static final String[] f8109h = {"home", "work"};

    /* renamed from: i */
    private static final int[] f8110i = {1, 2, 4, 3};

    /* renamed from: j */
    private static final int[] f8111j = {1, 3, 2, 4, 6, 12, 7, 12};

    /* renamed from: k */
    private static final int[] f8112k = {1, 2};

    /* renamed from: c */
    protected final Activity f8113c;

    /* renamed from: d */
    protected String f8114d;

    /* renamed from: e */
    protected String f8115e;

    /* renamed from: l */
    private final ParsedResult f8116l;

    /* renamed from: m */
    private Context f8117m;

    /* renamed from: a */
    public abstract ArrayList<ResultInfoItem> mo19170a();

    /* renamed from: a */
    public abstract void mo19171a(int i, String str);

    /* renamed from: b */
    public abstract ResultInfoHeader mo19174b();

    /* renamed from: c */
    public abstract ArrayList<ResultActionBarItem> mo19175c();

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final boolean mo19244j(String str) {
        return false;
    }

    ResultHandler(Activity activity, ParsedResult parsedResult) {
        this.f8113c = activity;
        this.f8116l = parsedResult;
        this.f8117m = ContextBuilder.m6349a(activity, true, true);
    }

    /* renamed from: d */
    public final ParsedResult mo19232d() {
        return this.f8116l;
    }

    /* renamed from: e */
    public String mo19234e() {
        return this.f8114d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final Activity mo19236f() {
        return this.f8113c;
    }

    /* renamed from: g */
    public final ParsedResultType mo19238g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8106b, false, 2624, new Class[0], ParsedResultType.class);
        return proxy.isSupported ? (ParsedResultType) proxy.result : this.f8116l.getType();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19226a(String[] strArr, String[] strArr2) {
        Class[] clsArr = {String[].class, String[].class};
        if (!PatchProxy.proxy(new Object[]{strArr, strArr2}, this, f8106b, false, 2625, clsArr, Void.TYPE).isSupported) {
            mo19227a((String[]) null, (String[]) null, (String) null, strArr, strArr2, (String[]) null, (String[]) null, (String) null, (String) null, (String[]) null, (String[]) null, (String) null, (String) null, (String[]) null, (String) null, (String[]) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19227a(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String[] strArr9, String str6, String[] strArr10) {
        char c;
        int i;
        String[] strArr11 = strArr2;
        String str7 = str;
        String[] strArr12 = strArr3;
        String[] strArr13 = strArr4;
        String[] strArr14 = strArr5;
        String[] strArr15 = strArr6;
        String str8 = str2;
        String str9 = str3;
        String str10 = str6;
        Object[] objArr = new Object[16];
        objArr[0] = strArr;
        objArr[1] = strArr11;
        objArr[2] = str7;
        objArr[3] = strArr12;
        objArr[4] = strArr13;
        objArr[5] = strArr14;
        objArr[6] = strArr15;
        objArr[7] = str8;
        objArr[8] = str9;
        objArr[9] = strArr7;
        objArr[10] = strArr8;
        objArr[11] = str4;
        objArr[12] = str5;
        objArr[13] = strArr9;
        Object[] objArr2 = objArr;
        objArr2[14] = str6;
        objArr2[15] = strArr10;
        String str11 = str9;
        if (!PatchProxy.proxy(objArr2, this, f8106b, false, 2626, new Class[]{String[].class, String[].class, String.class, String[].class, String[].class, String[].class, String[].class, String.class, String.class, String[].class, String[].class, String.class, String.class, String[].class, String.class, String[].class}, Void.TYPE).isSupported) {
            mo19247n("ADD_CONTACT");
            Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
            m8627a(intent, "name", strArr != null ? strArr[0] : null);
            m8627a(intent, "phonetic_name", str7);
            ArrayList arrayList = new ArrayList();
            if (strArr12 != null) {
                for (int i2 = 0; i2 < strArr12.length; i2++) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                    contentValues.put("data1", strArr12[i2]);
                    if (strArr13 != null && i2 < strArr13.length) {
                        int q = mo19179q(strArr13[i2]);
                        if (q >= 0) {
                            contentValues.put("data2", Integer.valueOf(q));
                        } else {
                            contentValues.put("data2", 0);
                        }
                    }
                    arrayList.add(contentValues);
                }
            }
            if (strArr14 != null) {
                for (int i3 = 0; i3 < strArr14.length; i3++) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("mimetype", "vnd.android.cursor.item/email_v2");
                    contentValues2.put("data1", strArr14[i3]);
                    if (strArr15 != null && i3 < strArr15.length) {
                        int p = mo19178p(strArr15[i3]);
                        if (p >= 0) {
                            contentValues2.put("data2", Integer.valueOf(p));
                        } else {
                            contentValues2.put("data2", 0);
                        }
                    }
                    arrayList.add(contentValues2);
                }
            }
            String[] strArr16 = strArr9;
            if (strArr16 != null) {
                for (String str12 : strArr16) {
                    if (str12 != null && !str12.isEmpty()) {
                        ContentValues contentValues3 = new ContentValues(2);
                        contentValues3.put("mimetype", "vnd.android.cursor.item/website");
                        contentValues3.put("data1", str12);
                        arrayList.add(contentValues3);
                    }
                }
            }
            String str13 = str6;
            if (str13 != null) {
                ContentValues contentValues4 = new ContentValues(3);
                contentValues4.put("mimetype", "vnd.android.cursor.item/contact_event");
                contentValues4.put("data2", 3);
                contentValues4.put("data1", str13);
                arrayList.add(contentValues4);
            }
            if (strArr11 != null) {
                int length = strArr11.length;
                int i4 = 0;
                while (true) {
                    if (i4 < length) {
                        String str14 = strArr11[i4];
                        if (str14 != null && !str14.isEmpty()) {
                            ContentValues contentValues5 = new ContentValues(3);
                            contentValues5.put("mimetype", "vnd.android.cursor.item/nickname");
                            contentValues5.put("data2", 1);
                            contentValues5.put("data1", str14);
                            arrayList.add(contentValues5);
                            break;
                        }
                        i4++;
                    } else {
                        break;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                intent.putParcelableArrayListExtra("data", arrayList);
            }
            StringBuilder sb = new StringBuilder();
            if (str8 != null) {
                c = 10;
                sb.append(10);
                sb.append(str8);
            } else {
                c = 10;
            }
            if (strArr10 != null) {
                sb.append(c);
                sb.append(strArr10[0]);
                sb.append(',');
                i = 1;
                sb.append(strArr10[1]);
            } else {
                i = 1;
            }
            if (sb.length() > 0) {
                m8627a(intent, "notes", sb.substring(i));
            }
            m8627a(intent, "im_handle", str11);
            String[] strArr17 = strArr7;
            if (strArr17 != null) {
                for (int i5 = 0; i5 < strArr17.length; i5++) {
                    ContentValues contentValues6 = new ContentValues();
                    contentValues6.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
                    contentValues6.put("data1", strArr17[i5]);
                    String[] strArr18 = strArr8;
                    if (strArr18 != null && i5 < strArr18.length) {
                        int r = m8633r(strArr18[i5]);
                        if (r >= 0) {
                            contentValues6.put("data2", Integer.valueOf(r));
                        } else {
                            contentValues6.put("data2", 3);
                            arrayList.add(contentValues6);
                        }
                    }
                    arrayList.add(contentValues6);
                }
            }
            m8627a(intent, "company", str4);
            m8627a(intent, "job_title", str5);
            mo19228b(intent);
        }
    }

    /* renamed from: p */
    private static int mo19178p(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8106b, true, 2627, new Class[]{String.class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : m8624a(str, f8107f, f8110i);
    }

    /* renamed from: q */
    private static int mo19179q(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8106b, true, 2628, new Class[]{String.class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : m8624a(str, f8108g, f8111j);
    }

    /* renamed from: r */
    private static int m8633r(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8106b, true, 2629, new Class[]{String.class}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : m8624a(str, f8109h, f8112k);
    }

    /* renamed from: a */
    private static int m8624a(String str, String[] strArr, int[] iArr) {
        ChangeQuickRedirect changeQuickRedirect = f8106b;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, strArr, iArr}, (Object) null, changeQuickRedirect, true, 2630, new Class[]{String.class, String[].class, int[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (str == null) {
            return -1;
        }
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (str.startsWith(str2) || str.startsWith(str2.toUpperCase(Locale.ENGLISH))) {
                return iArr[i];
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19224a(String str, String str2, String str3) {
        Class[] clsArr = {String.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2, str3}, this, f8106b, false, 2631, clsArr, Void.TYPE).isSupported) {
            mo19225a("mailto:" + str, str, str2, str3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19225a(String str, String str2, String str3, String str4) {
        Class[] clsArr = {String.class, String.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2, str3, str4}, this, f8106b, false, 2632, clsArr, Void.TYPE).isSupported) {
            mo19247n("EMAIL");
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
            if (str2 != null) {
                intent.putExtra("android.intent.extra.EMAIL", new String[]{str2});
            }
            m8627a(intent, "android.intent.extra.SUBJECT", str3);
            m8627a(intent, "android.intent.extra.TEXT", str4);
            mo19228b(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19223a(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f8106b, false, 2633, clsArr, Void.TYPE).isSupported) {
            mo19230b("smsto:" + str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo19230b(String str, String str2) {
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f8106b, false, 2634, new Class[]{String.class, String.class}, Void.TYPE).isSupported) {
            mo19247n("SEND_SMS");
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
            m8627a(intent, "sms_body", str2);
            intent.putExtra("compose_mode", true);
            mo19228b(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19221a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2635, new Class[]{String.class}, Void.TYPE).isSupported) {
            mo19247n("DIAL");
            mo19228b(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo19229b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2636, new Class[]{String.class}, Void.TYPE).isSupported) {
            mo19247n("DIAL");
            mo19228b(new Intent("android.intent.action.DIAL", Uri.parse(str)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo19231c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2637, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f8105a, "openURL:" + str);
            mo19247n("OPEN_URL");
            if (str.startsWith("HTTP://")) {
                str = "http" + str.substring(4);
            } else if (str.startsWith("HTTPS://")) {
                str = "https" + str.substring(5);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            if (CameraModeType.ModeType.BARCODE == IntentHelper.m16298a(this.f8113c.getIntent(), (ContentResolver) null)) {
                intent.putExtra("com.android.browser.application_id", "com.android.browser");
            }
            mo19228b(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19222a(String str, Boolean bool, String str2) {
        Class[] clsArr = {String.class, Boolean.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, bool, str2}, this, f8106b, false, 2638, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f8105a;
            LogUtil.m15942a(aVar, "openApp pkgName:" + str);
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                mo19235e(str2);
            } else if (this.f8113c.getPackageManager().getLaunchIntentForPackage(str) != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(str);
                if (bool.booleanValue()) {
                    intent.setDataAndType(Uri.parse(str2), "*/*");
                } else {
                    intent.setData(Uri.parse(str2));
                }
                intent.setFlags(268435456);
                mo19220a(intent, str2);
            } else {
                mo19231c(str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19220a(Intent intent, String str) {
        Class[] clsArr = {Intent.class, String.class};
        if (!PatchProxy.proxy(new Object[]{intent, str}, this, f8106b, false, 2639, clsArr, Void.TYPE).isSupported) {
            try {
                this.f8113c.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                mo19231c(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo19233d(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2640, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f8105a, "openAliPay");
            if (MeizuPayExportPlatform.m4005a(mo19236f())) {
                this.f8114d = this.f8113c.getResources().getString(R.string.mz_barcode_auto_alipay_result_hint);
                MeizuPayExportPlatform.m4004a(mo19236f(), 800001, str, true);
                return;
            }
            mo19231c(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo19235e(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2641, new Class[]{String.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f8105a, "openWechatScanner");
            EventBus.m21789a().mo27980d(12);
            Intent intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(268468224);
            mo19220a(intent, str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo19237f(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2642, new Class[]{String.class}, Void.TYPE).isSupported) {
            mo19247n("SHARE");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            ShareActivityStarter.C2825a aVar = new ShareActivityStarter.C2825a();
            Uri referrer = this.f8113c.getReferrer();
            if (referrer != null && "com.meizu.setup".equals(referrer.getAuthority())) {
                aVar.mo24006a(new ComponentName[]{new ComponentName("com.android.mms", "com.android.mms.ui.ComposeMessageActivity")});
            }
            aVar.mo24007a().mo24003a(this.f8113c, intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo19239g(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2643, new Class[]{String.class}, Void.TYPE).isSupported) {
            mo19247n("COPY");
            if (str != null) {
                try {
                    m8625a(this.f8113c.getApplicationContext()).setPrimaryClip(ClipData.newPlainText((CharSequence) null, str));
                } catch (NullPointerException e) {
                    LogUtil.m15950b(f8105a, "Clipboard bug", e);
                } catch (IllegalStateException e2) {
                    LogUtil.m15950b(f8105a, "Clipboard bug", e2);
                }
                Toast.makeText(this.f8113c.getApplicationContext(), R.string.mz_bar_code_copy, 0).show();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo19240h(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2644, new Class[]{String.class}, Void.TYPE).isSupported) {
            mo19247n("SEARCH_DETAIL");
            Uri parse = Uri.parse(BarcodeRequest.m8527d(str));
            Intent intent = new Intent(this.f8113c, H5Activity.class);
            intent.setData(parse);
            this.f8113c.startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final boolean mo19243i(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2645, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (str.startsWith("HTTP://")) {
            str = "http" + str.substring(4);
        } else if (str.startsWith("HTTPS://")) {
            str = "https" + str.substring(5);
        }
        if (!str.startsWith("https://member.meizu.com/qrCodeLogin?key=")) {
            return false;
        }
        Intent intent = new Intent("com.meizu.account.QRLOGIN");
        intent.putExtra("QR_DATA", str);
        mo19228b(intent);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final boolean mo19245k(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2646, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!str.startsWith("customizecenter://com.meizu.customizecenter")) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        mo19228b(intent);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19219a(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8106b, false, 2648, new Class[]{Intent.class}, Void.TYPE).isSupported && intent != null) {
            LogUtil.C2630a aVar = f8105a;
            LogUtil.m15942a(aVar, "Launching intent: " + intent + " with extras: " + intent.getExtras());
            this.f8113c.startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo19228b(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f8106b, false, 2649, new Class[]{Intent.class}, Void.TYPE).isSupported && intent != null) {
            try {
                mo19219a(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this.f8113c.getApplicationContext(), R.string.mz_barcode_intent_failed, 0).show();
            }
        }
    }

    /* renamed from: a */
    private static void m8627a(Intent intent, String str, String str2) {
        Class[] clsArr = {Intent.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{intent, str, str2}, (Object) null, f8106b, true, 2650, clsArr, Void.TYPE).isSupported && str2 != null && !str2.isEmpty()) {
            intent.putExtra(str, str2);
        }
    }

    /* renamed from: l */
    public static boolean m8630l(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8106b, true, 2651, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return str != null && !str.isEmpty();
    }

    /* renamed from: a */
    public String mo19218a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f8106b, false, 2652, new Class[]{Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : this.f8113c.getString(i);
    }

    /* renamed from: b */
    private int m8628b(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f8106b, false, 2653, new Class[]{Integer.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f8117m.getResources().getDimensionPixelSize(i);
    }

    /* renamed from: a */
    private static ClipboardManager m8625a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f8106b, true, 2654, new Class[]{Context.class}, ClipboardManager.class);
        return proxy.isSupported ? (ClipboardManager) proxy.result : (ClipboardManager) context.getSystemService("clipboard");
    }

    /* renamed from: a */
    public RelativeLayout.LayoutParams mo19217a(int i, int i2, int i3, int i4) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f8106b, false, 2655, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, RelativeLayout.LayoutParams.class);
        if (proxy.isSupported) {
            return (RelativeLayout.LayoutParams) proxy.result;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        if (i != 0) {
            marginLayoutParams.leftMargin = m8628b(i);
        }
        if (i2 != 0) {
            marginLayoutParams.topMargin = m8628b(i2);
        }
        if (i3 != 0) {
            marginLayoutParams.rightMargin = m8628b(i3);
        }
        if (i4 != 0) {
            marginLayoutParams.bottomMargin = m8628b(i4);
        }
        return new RelativeLayout.LayoutParams(marginLayoutParams);
    }

    /* renamed from: h */
    public boolean mo19241h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8106b, false, 2656, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) mo19236f().getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 29) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
                return false;
            }
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    /* renamed from: s */
    private boolean m8634s(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2657, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] < 0 || charArray[i] >= 65533) && (charArray[i] <= 65533 || charArray[i] >= 65535)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public String mo19246m(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2658, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            if (m8634s(new String(str.getBytes("ISO-8859-1"), "UTF-8"))) {
                return new String(str.getBytes("ISO-8859-1"), "GBK");
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: n */
    public void mo19247n(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f8106b, false, 2659, new Class[]{String.class}, Void.TYPE).isSupported) {
            HashMap hashMap = new HashMap();
            if (this.f8115e != null) {
                hashMap.put("type", this.f8115e);
            } else {
                hashMap.put("type", mo19238g().toString());
            }
            hashMap.put("operate", str);
            UsageStatsHelper.m16042a((Context) this.f8113c.getApplication()).mo22693a("handle_scan", (Map<String, String>) hashMap);
        }
    }

    /* renamed from: i */
    public void mo19242i() {
        if (!PatchProxy.proxy(new Object[0], this, f8106b, false, 2660, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a(this.f8113c.getApplicationContext()).mo22688a(new String[]{"mode"});
            a.put("torch", CameraController.m8868g().mo19534q().key);
            a.put("capture_time", Long.toString(System.currentTimeMillis()));
            if (this.f8115e != null) {
                a.put("scan_result", this.f8115e);
            } else {
                a.put("scan_result", mo19238g().toString());
            }
            UsageStatsHelper.m16042a(this.f8113c.getApplicationContext()).mo22693a("capture_info", a);
        }
    }

    /* renamed from: o */
    public AsyncDrawable mo19248o(String str) {
        String str2 = str;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str2}, this, f8106b, false, 2661, new Class[]{String.class}, AsyncDrawable.class);
        if (proxy.isSupported) {
            return (AsyncDrawable) proxy.result;
        }
        if (str2 == null || str.isEmpty()) {
            return null;
        }
        UriAsyncDrawable eVar = new UriAsyncDrawable(mo19236f().getApplicationContext(), str2.replace("56", "144"), 135, 135, 4, 1, AsyncDrawableJobExecutor.m16126a(), new PaintDrawable(17170443), -1, (DataAdapter.C1784a) null, (String) null, -1);
        eVar.mo19374a();
        eVar.mo19382a(0);
        return eVar;
    }

    /* renamed from: a */
    public static void m8626a(Context context, File file) {
        if (!PatchProxy.proxy(new Object[]{context, file}, (Object) null, f8106b, true, 2662, new Class[]{Context.class, File.class}, Void.TYPE).isSupported) {
            try {
                final Object invoke = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]).invoke((Object) null, new Object[0]);
                final Class<?> cls = Class.forName("android.app.ResultInfo");
                final Object newInstance = cls.getConstructor(new Class[]{String.class, Integer.TYPE, Integer.TYPE, Intent.class}).newInstance(new Object[]{null, 4660, -1, new Intent((String) null, Uri.parse(new File(file, "scanImage").toString()))});
                final ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.scanner.ui.BaseScanUI"), 0);
                new Thread(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f8118a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f8118a, false, 2663, new Class[0], Void.TYPE).isSupported) {
                            try {
                                Thread.sleep(100);
                                invoke.getClass().getMethod("sendResultToActivity", new Class[]{ActivityInfo.class, cls}).invoke(invoke, new Object[]{activityInfo, newInstance});
                            } catch (Exception e) {
                                LogUtil.C2630a j = ResultHandler.f8105a;
                                LogUtil.m15942a(j, "send image exception : " + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            } catch (Exception e) {
                LogUtil.C2630a aVar = f8105a;
                LogUtil.m15942a(aVar, "get am method exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
