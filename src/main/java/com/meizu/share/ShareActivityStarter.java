package com.meizu.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.content.IntentCompat;
import com.meizu.share.activity.ChooserActivity;
import java.util.ArrayList;

/* renamed from: com.meizu.share.g */
public class ShareActivityStarter {

    /* renamed from: a */
    private C2825a f15742a;

    private ShareActivityStarter(C2825a aVar) {
        this.f15742a = aVar;
    }

    /* renamed from: a */
    public void mo24004a(Context context, Intent intent, int i) {
        Intent b = mo24005b(context, intent);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(b, i);
            return;
        }
        b.addFlags(268435456);
        context.startActivity(b);
    }

    /* renamed from: a */
    public void mo24003a(Context context, Intent intent) {
        mo24004a(context, intent, -1);
    }

    /* renamed from: b */
    public Intent mo24005b(Context context, Intent intent) {
        ClipData clipData;
        Intent intent2 = new Intent(context, ChooserActivity.class);
        m17136a(intent2, intent, this.f15742a);
        int i = Build.VERSION.SDK_INT >= 19 ? 67 : 3;
        if (Build.VERSION.SDK_INT >= 21) {
            i |= 128;
        }
        int flags = i & intent.getFlags();
        if (flags != 0) {
            ClipData clipData2 = intent.getClipData();
            if (clipData2 != null || intent.getData() == null) {
                clipData = clipData2;
            } else {
                clipData = new ClipData((CharSequence) null, intent.getType() != null ? new String[]{intent.getType()} : new String[0], new ClipData.Item(intent.getData()));
            }
            if (clipData != null) {
                intent2.setClipData(clipData);
                intent2.addFlags(flags);
            }
        }
        m17135a(intent2);
        return intent2;
    }

    /* renamed from: a */
    private void m17135a(Intent intent) {
        if (intent.getClipData() == null) {
            if (intent.getComponent() != null && ChooserActivity.class.getName().equals(intent.getComponent().getClassName())) {
                try {
                    Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
                    if (intent2 != null) {
                        m17135a(intent2);
                    }
                } catch (ClassCastException unused) {
                }
                try {
                    Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.intent.extra.INITIAL_INTENTS");
                    if (parcelableArrayExtra != null) {
                        for (Parcelable parcelable : parcelableArrayExtra) {
                            Intent intent3 = (Intent) parcelable;
                            if (intent3 != null) {
                                m17135a(intent3);
                            }
                        }
                    }
                } catch (ClassCastException unused2) {
                }
            }
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action)) {
                try {
                    Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                    CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
                    String stringExtra = intent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
                    if (uri != null || charSequenceExtra != null || stringExtra != null) {
                        intent.setClipData(new ClipData((CharSequence) null, new String[]{intent.getType()}, new ClipData.Item(charSequenceExtra, stringExtra, (Intent) null, uri)));
                        intent.addFlags(1);
                    }
                } catch (ClassCastException unused3) {
                }
            } else if ("android.intent.action.SEND_MULTIPLE".equals(action)) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                ArrayList<CharSequence> charSequenceArrayListExtra = intent.getCharSequenceArrayListExtra("android.intent.extra.TEXT");
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(IntentCompat.EXTRA_HTML_TEXT);
                int i = -1;
                if (parcelableArrayListExtra != null) {
                    i = parcelableArrayListExtra.size();
                }
                if (charSequenceArrayListExtra != null) {
                    if (i < 0 || i == charSequenceArrayListExtra.size()) {
                        i = charSequenceArrayListExtra.size();
                    } else {
                        return;
                    }
                }
                if (stringArrayListExtra != null) {
                    if (i < 0 || i == stringArrayListExtra.size()) {
                        i = stringArrayListExtra.size();
                    } else {
                        return;
                    }
                }
                if (i > 0) {
                    ClipData clipData = new ClipData((CharSequence) null, new String[]{intent.getType()}, m17134a(parcelableArrayListExtra, charSequenceArrayListExtra, stringArrayListExtra, 0));
                    for (int i2 = 1; i2 < i; i2++) {
                        clipData.addItem(m17134a(parcelableArrayListExtra, charSequenceArrayListExtra, stringArrayListExtra, i2));
                    }
                    intent.setClipData(clipData);
                    intent.addFlags(1);
                }
            } else if ("android.media.action.IMAGE_CAPTURE".equals(action) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(action) || "android.media.action.VIDEO_CAPTURE".equals(action)) {
                try {
                    Uri uri2 = (Uri) intent.getParcelableExtra("output");
                    if (uri2 != null) {
                        intent.setClipData(ClipData.newRawUri("", uri2));
                        intent.addFlags(3);
                    }
                } catch (ClassCastException unused4) {
                }
            }
        }
    }

    /* renamed from: a */
    private static ClipData.Item m17134a(ArrayList<Uri> arrayList, ArrayList<CharSequence> arrayList2, ArrayList<String> arrayList3, int i) {
        return new ClipData.Item(arrayList2 != null ? arrayList2.get(i) : null, arrayList3 != null ? arrayList3.get(i) : null, (Intent) null, arrayList != null ? arrayList.get(i) : null);
    }

    /* renamed from: a */
    private void m17136a(Intent intent, Intent intent2, C2825a aVar) {
        if (intent != null) {
            intent.putExtra("android.intent.extra.INTENT", intent2);
            intent.putExtra("android.intent.extra.TITLE", aVar.f15743a);
            intent.putExtra("KEY_IS_NIGHT_MODE", aVar.f15744b);
            intent.putExtra("KEY_IS_FORCE_KEEP", aVar.f15745c);
            intent.putExtra("KEY_IS_SHOW_CHECK_BOX", aVar.f15746d);
            intent.putExtra("KEY_IS_CHECK_BOX_CHECKED", aVar.f15747e);
            intent.putExtra("KEY_CHECK_BOX_TEXT", aVar.f15748f);
            intent.putExtra("KEY_NEED_HIDE_STATUS_BAR_ON_LANDSCAPE", aVar.f15749g);
            intent.putExtra("KEY_HIDE_STATUS_BAR_ON_PORTRAIT", aVar.f15750h);
            intent.putExtra("KEY_SHOW_WHEN_LOCKED", aVar.f15755m);
            intent.putExtra("KEY_DISMISS_KEYGUARD", aVar.f15754l);
            if (aVar.f15751i != null && aVar.f15751i.length > 0) {
                intent.putExtra("android.intent.extra.INITIAL_INTENTS", aVar.f15751i);
            }
            if (aVar.f15752j != null) {
                intent.putExtra("KEY_MEIZU_INTENT_SENDER", aVar.f15752j);
            }
            if (aVar.f15753k != null && aVar.f15753k.length > 0) {
                intent.putExtra("android.intent.extra.EXCLUDE_COMPONENTS", aVar.f15753k);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("intent can't be null");
    }

    /* renamed from: com.meizu.share.g$a */
    /* compiled from: ShareActivityStarter */
    public static class C2825a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f15743a = null;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f15744b = false;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f15745c = false;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f15746d = false;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f15747e = false;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f15748f = null;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public boolean f15749g = false;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public boolean f15750h = false;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Intent[] f15751i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public IntentSender f15752j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public ComponentName[] f15753k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public boolean f15754l = false;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public boolean f15755m = false;

        /* renamed from: a */
        public C2825a mo24006a(ComponentName[] componentNameArr) {
            this.f15753k = componentNameArr;
            return this;
        }

        /* renamed from: a */
        public ShareActivityStarter mo24007a() {
            return new ShareActivityStarter(this);
        }
    }
}
