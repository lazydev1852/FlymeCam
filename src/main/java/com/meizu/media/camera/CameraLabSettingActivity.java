package com.meizu.media.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.meizu.common.widget.Switch;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.StatusbarColorUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.PkgType;
import com.meizu.statsapp.p081v3.UsageStatsProxy3;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.app.AppCompatActivity;

public class CameraLabSettingActivity extends AppCompatActivity {

    /* renamed from: a */
    public static ChangeQuickRedirect f6632a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f6633b = new LogUtil.C2630a("LabSetting");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Button f6634c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f6635d;

    /* renamed from: e */
    private TextView f6636e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Switch f6637f;

    /* renamed from: g */
    private int f6638g;

    /* renamed from: h */
    private TextureView f6639h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MediaPlayer f6640i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Surface f6641j;

    /* renamed from: k */
    private BroadcastReceiver f6642k = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6651a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f6651a, false, 754, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                boolean booleanExtra = intent.getBooleanExtra("available", false);
                LogUtil.C2630a a = CameraLabSettingActivity.f6633b;
                LogUtil.m15952c(a, "Receive FlymeLab State available: " + booleanExtra);
                if (!booleanExtra) {
                    Settings.Global.putInt(CameraLabSettingActivity.this.getContentResolver(), "enable_back_trace_mode", 0);
                    CameraLabSettingActivity.this.finish();
                }
            }
        }
    };

    public void attachBaseContext(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f6632a, false, 741, new Class[]{Context.class}, Void.TYPE).isSupported) {
            super.attachBaseContext(new ContextWrapper(context) {

                /* renamed from: a */
                public static ChangeQuickRedirect f6643a;

                public Object getSystemService(String str) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f6643a, false, 749, new Class[]{String.class}, Object.class);
                    if (proxy.isSupported) {
                        return proxy.result;
                    }
                    if ("audio".equals(str)) {
                        return getApplicationContext().getSystemService(str);
                    }
                    return super.getSystemService(str);
                }
            });
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6632a, false, 742, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            requestWindowFeature(8);
            requestWindowFeature(9);
            getWindow().setStatusBarColor(-1);
            StatusbarColorUtils.m16005a((Activity) this, true);
            super.onCreate(bundle);
            UsageStatsProxy3.init(getApplication(), PkgType.APP, "CQ6ADXDR9CCDBP1LEH0XB36Y");
            ActionBar d = mo25161d();
            if (d != null) {
                d.mo25037a((int) R.string.mz_cam_mode_back_trace);
                d.mo25041a(true);
            }
            if (NavigationBarUtils.m15973a(getApplicationContext().getResources())) {
                NavigationBarUtils.m15971a(getWindow(), true);
                NavigationBarUtils.m15970a(getWindow(), -1, true);
            }
            setContentView((int) R.layout.mz_lab_setting);
            this.f6638g = getApplicationContext().getResources().getDimensionPixelSize(R.dimen.mz_setting_line_margin);
            if (1 != Settings.Global.getInt(getContentResolver(), "enable_back_trace_mode", 0)) {
                z = false;
            }
            this.f6635d = z;
            this.f6639h = (TextureView) findViewById(R.id.mz_lab_back_trace_video);
            if (getApplicationInfo().targetSdkVersion <= 23) {
                this.f6639h.setBackgroundColor(-1);
            }
            this.f6639h.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6645a;

                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    if (!PatchProxy.proxy(new Object[]{surfaceTexture, new Integer(i), new Integer(i2)}, this, f6645a, false, 750, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                        try {
                            Surface unused = CameraLabSettingActivity.this.f6641j = new Surface(surfaceTexture);
                            MediaPlayer unused2 = CameraLabSettingActivity.this.f6640i = MediaPlayer.create(CameraLabSettingActivity.this, "zh".equals(DeviceUtil.m16207g()) ? R.raw.lab_back_trace_video_cn : R.raw.lab_back_trace_video_en);
                            CameraLabSettingActivity.this.f6640i.setSurface(CameraLabSettingActivity.this.f6641j);
                            CameraLabSettingActivity.this.f6640i.setLooping(true);
                            CameraLabSettingActivity.this.f6640i.setVideoScalingMode(2);
                            CameraLabSettingActivity.this.f6640i.setOnPreparedListener($$Lambda$jX_tASEdjv03obJy5rjdfXVUzvw.INSTANCE);
                        } catch (Exception e) {
                            LogUtil.C2630a a = CameraLabSettingActivity.f6633b;
                            LogUtil.m15949b(a, "Error playing intro video: " + e.getMessage());
                        }
                    }
                }

                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTexture}, this, f6645a, false, 751, new Class[]{SurfaceTexture.class}, Boolean.TYPE);
                    if (proxy.isSupported) {
                        return ((Boolean) proxy.result).booleanValue();
                    }
                    CameraLabSettingActivity.this.m6515b();
                    return false;
                }
            });
            this.f6634c = (Button) findViewById(R.id.mz_lab_back_trace_btn);
            this.f6634c.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6647a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f6647a, false, 752, new Class[]{View.class}, Void.TYPE).isSupported) {
                        Intent intent = new Intent("android.intent.action.MAIN");
                        intent.setPackage("com.meizu.media.camera");
                        intent.addCategory("android.intent.category.LAUNCHER");
                        intent.putExtra("lab_camera_mode_type", CameraModeType.ModeType.BACK_TRACE.toString());
                        intent.setFlags(268468224);
                        UsageStatsHelper.m16042a(CameraLabSettingActivity.this.getApplicationContext()).mo22695b("click_lab_open_backtrace");
                        CameraLabSettingActivity.this.startActivity(intent);
                    }
                }
            });
            this.f6634c.setEnabled(this.f6635d);
            this.f6636e = (TextView) findViewById(R.id.mz_lab_switch_item_title);
            this.f6637f = (Switch) findViewById(R.id.mz_lab_back_trace_switch);
            this.f6636e.setText(R.string.mz_cam_mode_back_trace);
            this.f6637f.setChecked(this.f6635d);
            ((RelativeLayout) findViewById(R.id.mz_lab_back_trace_itemlayout)).setOnTouchListener(new View.OnTouchListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6649a;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, motionEvent}, this, f6649a, false, 753, new Class[]{View.class, MotionEvent.class}, Boolean.TYPE);
                    if (proxy.isSupported) {
                        return ((Boolean) proxy.result).booleanValue();
                    }
                    boolean unused = CameraLabSettingActivity.this.f6635d = true ^ CameraLabSettingActivity.this.f6635d;
                    CameraLabSettingActivity.this.f6637f.setCheckedWithHapticFeedback(CameraLabSettingActivity.this.f6635d);
                    CameraLabSettingActivity.this.f6634c.setEnabled(CameraLabSettingActivity.this.f6635d);
                    UsageStatsHelper.m16042a(CameraLabSettingActivity.this.getApplicationContext()).mo22691a("click_lab_enable_backtrace", "enable", CameraLabSettingActivity.this.f6635d ? "1" : "0");
                    Settings.Global.putInt(CameraLabSettingActivity.this.getContentResolver(), "enable_back_trace_mode", CameraLabSettingActivity.this.f6635d ? 1 : 0);
                    CameraLabSettingActivity.this.sendBroadcast(new Intent("com.meizu.camera.ACTION_FINISH_ACTIVITY"));
                    return false;
                }
            });
            registerReceiver(this.f6642k, new IntentFilter("com.meizu.media.camera.action.flymelab.AVAILABLE_CHANGED"));
        }
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f6632a, false, 743, new Class[0], Void.TYPE).isSupported) {
            if (this.f6640i != null && !this.f6640i.isPlaying()) {
                this.f6640i.start();
            }
            super.onResume();
            UsageStatsHelper.m16045a("page_flyme_lab");
            UsageStatsHelper.m16042a((Context) this).mo22697c("page_flyme_lab");
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f6632a, false, 744, new Class[0], Void.TYPE).isSupported) {
            if (this.f6640i != null && this.f6640i.isPlaying()) {
                this.f6640i.pause();
            }
            super.onPause();
            UsageStatsHelper.m16042a((Context) this).mo22699d("page_flyme_lab");
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f6632a, false, 745, new Class[0], Void.TYPE).isSupported) {
            m6515b();
            this.f6639h = null;
            unregisterReceiver(this.f6642k);
            super.onDestroy();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6515b() {
        if (!PatchProxy.proxy(new Object[0], this, f6632a, false, 746, new Class[0], Void.TYPE).isSupported) {
            if (this.f6640i != null) {
                this.f6640i.stop();
                this.f6640i.release();
                this.f6640i = null;
            }
            if (this.f6641j != null) {
                this.f6641j.release();
                this.f6641j = null;
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{menuItem}, this, f6632a, false, 747, new Class[]{MenuItem.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return true;
    }
}
