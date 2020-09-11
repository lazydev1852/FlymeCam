package com.meizu.update.display;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.UpdateEndListener;
import com.meizu.update.display.DisplayBase;
import com.meizu.update.p083a.FileCacheHelper;
import com.meizu.update.util.Loger;

public class UpdateDialogActivityWrapper extends Activity {

    /* renamed from: a */
    private DisplayBase f16247a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UpdateInfo updateInfo = (UpdateInfo) getIntent().getParcelableExtra("extra_update_info");
        if (updateInfo == null) {
            finish();
            return;
        }
        DisplayBase displayBase = null;
        switch (getIntent().getIntExtra("dialog_type", -1)) {
            case 1:
                displayBase = new ExecEndDisplayManager(this, updateInfo, true);
                break;
            case 2:
                displayBase = new ExecEndDisplayManager(this, updateInfo, false);
                break;
            case 3:
                displayBase = new UpdateDisplayManager(this, (UpdateEndListener) null, updateInfo, false);
                break;
            case 4:
                displayBase = new DownloadingDisplayManager(this, updateInfo);
                break;
            case 5:
                displayBase = new UdResultDisplayManager(this, updateInfo, FileCacheHelper.m17533b((Context) this, updateInfo.mVersionName), false);
                break;
        }
        if (displayBase != null) {
            displayBase.mo24761a((DisplayBase.C2999a) new DisplayBase.C2999a() {
                /* renamed from: a */
                public void mo24778a() {
                    UpdateDialogActivityWrapper.this.finish();
                }
            });
            displayBase.mo24764b();
            this.f16247a = displayBase;
            return;
        }
        finish();
    }

    /* renamed from: a */
    public static void m17717a(Context context, UpdateInfo updateInfo, int i) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, UpdateDialogActivityWrapper.class));
        intent.setFlags(872415232);
        intent.putExtra("extra_update_info", updateInfo);
        intent.putExtra("dialog_type", i);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f16247a != null) {
            this.f16247a.mo24766c();
            this.f16247a = null;
            Loger.m17941b("mBaseDialog onDestroy");
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
