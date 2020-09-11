package com.meizu.share;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;

/* renamed from: com.meizu.share.c */
public class IntentParser {

    /* renamed from: a */
    private Intent f15740a;

    public IntentParser(Intent intent) {
        this.f15740a = intent;
        try {
            this.f15740a.getStringExtra("android.intent.extra.TITLE");
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public Intent mo23987a() {
        Parcelable parcelableExtra = this.f15740a.getParcelableExtra("android.intent.extra.INTENT");
        if (parcelableExtra instanceof Intent) {
            return (Intent) parcelableExtra;
        }
        Log.w("IntentParser", "Target is not an intent: " + parcelableExtra);
        return null;
    }

    /* renamed from: b */
    public String mo23988b() {
        return this.f15740a.getStringExtra("android.intent.extra.TITLE");
    }

    /* renamed from: c */
    public boolean mo23989c() {
        return this.f15740a.getExtras().containsKey("KEY_IS_NIGHT_MODE");
    }

    /* renamed from: d */
    public boolean mo23990d() {
        return this.f15740a.getBooleanExtra("KEY_IS_NIGHT_MODE", false);
    }

    /* renamed from: e */
    public boolean mo23991e() {
        return this.f15740a.getBooleanExtra("KEY_IS_FORCE_KEEP", false);
    }

    /* renamed from: f */
    public boolean mo23992f() {
        return this.f15740a.getBooleanExtra("KEY_IS_SHOW_CHECK_BOX", false);
    }

    /* renamed from: g */
    public boolean mo23993g() {
        return this.f15740a.getBooleanExtra("KEY_IS_CHECK_BOX_CHECKED", false);
    }

    /* renamed from: h */
    public String mo23994h() {
        return this.f15740a.getStringExtra("KEY_CHECK_BOX_TEXT");
    }

    /* renamed from: i */
    public boolean mo23995i() {
        return this.f15740a.getBooleanExtra("KEY_NEED_HIDE_STATUS_BAR_ON_LANDSCAPE", false);
    }

    /* renamed from: j */
    public boolean mo23996j() {
        return this.f15740a.getBooleanExtra("KEY_HIDE_STATUS_BAR_ON_PORTRAIT", false);
    }

    /* renamed from: k */
    public boolean mo23997k() {
        return this.f15740a.getBooleanExtra("KEY_SHOW_WHEN_LOCKED", false);
    }

    /* renamed from: l */
    public boolean mo23998l() {
        return this.f15740a.getBooleanExtra("KEY_DISMISS_KEYGUARD", false);
    }

    @Nullable
    /* renamed from: m */
    public Intent[] mo23999m() {
        Parcelable[] parcelableArrayExtra = this.f15740a.getParcelableArrayExtra("android.intent.extra.INITIAL_INTENTS");
        if (parcelableArrayExtra == null) {
            return null;
        }
        Intent[] intentArr = new Intent[parcelableArrayExtra.length];
        for (int i = 0; i < parcelableArrayExtra.length; i++) {
            if (!(parcelableArrayExtra[i] instanceof Intent)) {
                Log.w("IntentParser", "Initial intent #" + i + " not an Intent: " + parcelableArrayExtra[i]);
                return null;
            }
            intentArr[i] = (Intent) parcelableArrayExtra[i];
        }
        return intentArr;
    }

    @Nullable
    /* renamed from: n */
    public ComponentName[] mo24000n() {
        Parcelable[] parcelableArrayExtra = this.f15740a.getParcelableArrayExtra("android.intent.extra.EXCLUDE_COMPONENTS");
        if (parcelableArrayExtra == null) {
            return null;
        }
        ComponentName[] componentNameArr = new ComponentName[parcelableArrayExtra.length];
        for (int i = 0; i < parcelableArrayExtra.length; i++) {
            if (!(parcelableArrayExtra[i] instanceof ComponentName)) {
                Log.w("IntentParser", "Filtered component #" + i + " not a ComponentName: " + parcelableArrayExtra[i]);
                return null;
            }
            componentNameArr[i] = (ComponentName) parcelableArrayExtra[i];
        }
        return componentNameArr;
    }

    @Nullable
    /* renamed from: o */
    public IntentSender mo24001o() {
        return (IntentSender) this.f15740a.getParcelableExtra("KEY_MEIZU_INTENT_SENDER");
    }
}
