package com.meizu.media.camera.gif;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.R;
import com.meizu.media.camera.gif.GifPlayer;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.views.MzGifSeekBar;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.app.AppCompatActivity;
import flyme.support.p093v7.view.menu.MenuItemImpl;
import flyme.support.p093v7.widget.ActionMenuView;

public class GifCropActivity extends AppCompatActivity implements View.OnClickListener, GifPlayer.C2092b, MzGifSeekBar.C2712a {

    /* renamed from: a */
    public static ChangeQuickRedirect f10186a;

    /* renamed from: b */
    private ImageView f10187b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public GifPlayer f10188c;

    /* renamed from: d */
    private ImageView f10189d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MzGifSeekBar f10190e;

    /* renamed from: f */
    private View f10191f;

    /* renamed from: g */
    private int f10192g = 0;

    /* renamed from: h */
    private int f10193h = 0;

    /* renamed from: i */
    private boolean f10194i = false;

    /* renamed from: j */
    private boolean f10195j = false;

    /* renamed from: k */
    private BroadcastReceiver f10196k = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f10197a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f10197a, false, 4142, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                GifCropActivity.this.finish();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f10186a, false, 4127, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            super.onCreate(bundle);
            getWindow().addFlags(1024);
            mo25149a(1);
            if (NavigationBarUtils.m15972a()) {
                NavigationBarUtils.m15969a(getWindow());
            }
            Context a = ContextBuilder.m6349a(this, true, true);
            setContentView(LayoutInflater.from(a).inflate(R.layout.mz_gif_crop_activity, (ViewGroup) null, false));
            Intent intent = getIntent();
            this.f10195j = getIntent().getBooleanExtra("is_secure_camera", false);
            if (this.f10195j) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= 524288;
                window.setAttributes(attributes);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                registerReceiver(this.f10196k, intentFilter);
            }
            ActionBar d = mo25161d();
            d.mo25046b(getResources().getDrawable(R.color.mz_gif_smartbar_color));
            d.mo25050c((int) R.drawable.mz_titlebar_ic_back_dark);
            d.mo25058e();
            findViewById(R.id.action_bar_container).setVisibility(8);
            if (!"com.meizu.media.camera.gif/gif".equals(intent.getType())) {
                finish();
                return;
            }
            if (bundle != null) {
                this.f10192g = bundle.getInt("gif_play_from");
                this.f10193h = bundle.getInt("gif_play_to");
            }
            this.f10187b = (ImageView) findViewById(R.id.gif_image_view);
            this.f10187b.setMinimumHeight(CameraUtil.m15809a());
            this.f10189d = (ImageView) findViewById(R.id.gif_play);
            this.f10189d.setOnClickListener(this);
            this.f10189d.setEnabled(false);
            int i = bundle != null ? bundle.getInt("gif_frame_count") : 10;
            this.f10190e = (MzGifSeekBar) findViewById(R.id.gif_crop_bar);
            if (NavigationBarUtils.m15972a() && !DeviceHelper.f13874aa) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10190e.getLayoutParams();
                layoutParams.topMargin = a.getResources().getDimensionPixelSize(R.dimen.mz_gif_seekbar_margin_top) - CameraUtil.m15912r();
                this.f10190e.setLayoutParams(layoutParams);
            }
            this.f10190e.setProgressChangeListener(this);
            this.f10190e.setItemsCount(i);
            this.f10190e.setEnabled(false);
            this.f10188c = new GifPlayer(getIntent().getStringExtra("gif_file_path"), this);
            this.f10191f = findViewById(R.id.gif_loading_view);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.topMargin = CameraUtil.m15901h() + (CameraUtil.m15809a() / 2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(marginLayoutParams);
            layoutParams2.addRule(14, -1);
            this.f10191f.setLayoutParams(layoutParams2);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{menu}, this, f10186a, false, 4128, new Class[]{Menu.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        getMenuInflater().inflate(R.menu.mz_gif_crop_menu, menu);
        MenuItem findItem = menu.findItem(R.id.mz_gif_menu_recapture);
        MenuItem findItem2 = menu.findItem(R.id.mz_gif_menu_ok);
        if (findItem2 instanceof MenuItemImpl) {
            ((MenuItemImpl) findItem2).mo25605a(getResources().getColorStateList(R.color.mz_gif_seekbar_play_color));
        }
        if (findItem instanceof MenuItemImpl) {
            ((MenuItemImpl) findItem).mo25605a(getResources().getColorStateList(R.color.white));
        }
        ActionMenuView actionMenuView = (ActionMenuView) findViewById(R.id.mz_action_menu_view);
        if (actionMenuView != null) {
            actionMenuView.setBottonBarStyleDivider();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{menuItem}, this, f10186a, false, 4129, new Class[]{MenuItem.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f10194i) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f10194i = true;
        switch (menuItem.getItemId()) {
            case R.id.mz_gif_menu_ok:
                this.f10191f.setVisibility(0);
                this.f10188c.mo20195e();
                return true;
            case R.id.mz_gif_menu_recapture:
                setResult(0);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onBackPressed() {
        if (!PatchProxy.proxy(new Object[0], this, f10186a, false, 4130, new Class[0], Void.TYPE).isSupported) {
            super.onBackPressed();
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f10186a, false, 4131, new Class[0], Void.TYPE).isSupported) {
            super.onPause();
            if (this.f10188c != null && this.f10188c.mo20194d()) {
                new Handler().postDelayed(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f10199a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f10199a, false, 4143, new Class[0], Void.TYPE).isSupported) {
                            GifCropActivity.this.f10188c.mo20192c();
                            GifCropActivity.this.f10190e.mo23069c();
                            GifCropActivity.this.mo20147a();
                        }
                    }
                }, 250);
            }
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f10186a, false, 4132, new Class[0], Void.TYPE).isSupported) {
            if (this.f10195j) {
                unregisterReceiver(this.f10196k);
            }
            super.onDestroy();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f10186a, false, 4133, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            bundle.putInt("gif_frame_count", this.f10188c.mo20188a());
            bundle.putInt("gif_play_from", this.f10192g);
            bundle.putInt("gif_play_to", this.f10193h);
            super.onSaveInstanceState(bundle);
        }
    }

    /* renamed from: a */
    public void mo20150a(MzGifSeekBar mzGifSeekBar, int i) {
        Object[] objArr = {mzGifSeekBar, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10186a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4134, new Class[]{MzGifSeekBar.class, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f10188c.mo20193c(i);
            this.f10192g = i;
            this.f10188c.mo20189a(this.f10192g);
        }
    }

    /* renamed from: b */
    public void mo20152b(MzGifSeekBar mzGifSeekBar, int i) {
        Object[] objArr = {mzGifSeekBar, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10186a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4135, new Class[]{MzGifSeekBar.class, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f10188c.mo20193c(i);
            this.f10193h = i;
            this.f10188c.mo20191b(this.f10193h);
        }
    }

    public void onClick(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f10186a, false, 4136, new Class[]{View.class}, Void.TYPE).isSupported && view.getId() == this.f10189d.getId()) {
            this.f10188c.mo20190b();
            this.f10190e.mo23067b();
            this.f10189d.setImageAlpha(77);
            this.f10189d.setEnabled(false);
            this.f10190e.setEnabled(false);
        }
    }

    /* renamed from: a */
    public void mo20149a(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f10186a, false, 4137, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            this.f10187b.setImageBitmap(bitmap);
        }
    }

    /* renamed from: a */
    public void mo20147a() {
        if (!PatchProxy.proxy(new Object[0], this, f10186a, false, 4138, new Class[0], Void.TYPE).isSupported) {
            this.f10189d.setImageAlpha(255);
            this.f10189d.setEnabled(true);
            this.f10190e.setEnabled(true);
        }
    }

    /* renamed from: b */
    public void mo20151b() {
        if (!PatchProxy.proxy(new Object[0], this, f10186a, false, 4139, new Class[0], Void.TYPE).isSupported) {
            setResult(-1);
            this.f10191f.setVisibility(8);
            finish();
        }
    }

    /* renamed from: c */
    public void mo20153c() {
        if (!PatchProxy.proxy(new Object[0], this, f10186a, false, 4140, new Class[0], Void.TYPE).isSupported) {
            if (this.f10193h == 0) {
                this.f10193h = this.f10188c.mo20188a() - 1;
            } else {
                this.f10188c.mo20189a(this.f10192g);
                this.f10188c.mo20191b(this.f10193h);
                this.f10188c.mo20193c(this.f10192g);
            }
            this.f10190e.setItemsCount(this.f10188c.mo20188a());
            this.f10191f.setVisibility(8);
            this.f10189d.setEnabled(true);
            this.f10190e.setEnabled(true);
        }
    }

    /* renamed from: a */
    public void mo20148a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f10186a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4141, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            this.f10190e.mo23065a(j);
        }
    }
}
