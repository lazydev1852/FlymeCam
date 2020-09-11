package com.meizu.media.camera;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.StatusbarColorUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.CameraOnlineSwitcherFragment;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.PkgType;
import com.meizu.statsapp.p081v3.UsageStatsProxy3;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.app.AppCompatActivity;

public class CameraOnlineSettingActivity extends AppCompatActivity {

    /* renamed from: a */
    public static ChangeQuickRedirect f6653a;

    public void onCreate(@Nullable Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6653a, false, 755, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            requestWindowFeature(8);
            requestWindowFeature(9);
            super.onCreate(bundle);
            UsageStatsProxy3.init(getApplication(), PkgType.APP, "CQ6ADXDR9CCDBP1LEH0XB36Y");
            ActionBar d = mo25161d();
            if (d != null) {
                d.mo25037a((int) R.string.mz_online_setting_title);
                d.mo25045b(12);
            }
            getWindow().setStatusBarColor(0);
            StatusbarColorUtils.m16005a((Activity) this, true);
            int i = 1280;
            if (Build.VERSION.SDK_INT >= 29) {
                i = 1296;
            }
            getWindow().getDecorView().setSystemUiVisibility(i);
            StatusbarColorUtils.m16005a((Activity) this, true);
            if (NavigationBarUtils.m15973a(getApplicationContext().getResources())) {
                NavigationBarUtils.m15971a(getWindow(), true);
                NavigationBarUtils.m15970a(getWindow(), -1, true);
            }
            m6520a();
        }
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f6653a, false, 756, new Class[0], Void.TYPE).isSupported) {
            super.onResume();
            UsageStatsHelper.m16045a("page_camera_manage");
            UsageStatsHelper.m16042a((Context) this).mo22697c("page_camera_manage");
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f6653a, false, 757, new Class[0], Void.TYPE).isSupported) {
            super.onPause();
            UsageStatsHelper.m16042a((Context) this).mo22699d("page_camera_manage");
        }
    }

    /* renamed from: a */
    private void m6520a() {
        if (!PatchProxy.proxy(new Object[0], this, f6653a, false, 758, new Class[0], Void.TYPE).isSupported) {
            getFragmentManager().beginTransaction().add(16908290, new CameraOnlineSwitcherFragment(), (String) null).commit();
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f6653a, false, 759, new Class[0], Void.TYPE).isSupported) {
            super.onDestroy();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{menuItem}, this, f6653a, false, 760, new Class[]{MenuItem.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return true;
    }
}
