package com.meizu.media.camera;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.util.C2644av;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.StatusbarColorUtils;
import com.meizu.media.camera.views.PagerCornerIndicator;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.utils.reflect.SystemProperties;
import flyme.support.p092v4.view.ViewPager;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class CameraAicyActivity extends AppCompatActivity {

    /* renamed from: a */
    public static ChangeQuickRedirect f6619a;

    /* renamed from: b */
    private static final LogUtil.C2630a f6620b = new LogUtil.C2630a("AicyActivity");

    /* renamed from: c */
    private ViewPager f6621c;

    /* renamed from: d */
    private LinearLayout f6622d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PagerCornerIndicator f6623e;

    /* renamed from: f */
    private Context f6624f;

    /* renamed from: g */
    private ViewPagerAdapter f6625g = new ViewPagerAdapter();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<View> f6626h = new ArrayList();

    /* renamed from: i */
    private ViewPager.C3054e f6627i = new ViewPager.C3054e() {

        /* renamed from: a */
        public static ChangeQuickRedirect f6628a;

        /* renamed from: a */
        public void mo17730a(int i, float f, int i2) {
        }

        /* renamed from: b */
        public void mo17731b(int i) {
        }

        /* renamed from: a */
        public void mo17729a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f6628a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 737, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && CameraAicyActivity.this.f6623e != null) {
                CameraAicyActivity.this.f6623e.setSelectIndex(i);
            }
        }
    };

    public void onCreate(@Nullable Bundle bundle) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6619a, false, 731, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            Resources resources = getResources();
            Configuration configuration = getResources().getConfiguration();
            configuration.fontScale = 1.0f;
            configuration.densityDpi = SystemProperties.getInt("persist.sys.density", SystemProperties.getInt("ro.sf.lcd_density", 480).intValue()).intValue();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            requestWindowFeature(8);
            requestWindowFeature(9);
            View decorView = getWindow().getDecorView();
            int i2 = 1280;
            if (Build.VERSION.SDK_INT >= 29) {
                i2 = 1296;
            }
            decorView.setSystemUiVisibility(i2);
            getWindow().setStatusBarColor(0);
            StatusbarColorUtils.m16005a((Activity) this, true);
            super.onCreate(bundle);
            ActionBar d = mo25161d();
            if (d != null) {
                d.mo25037a((int) R.string.mz_aicy_action_bar_title);
                d.mo25039a(getResources().getDrawable(R.color.transparent, (Resources.Theme) null));
                d.mo25041a(true);
            }
            if (NavigationBarUtils.m15973a(getApplicationContext().getResources())) {
                NavigationBarUtils.m15971a(getWindow(), true);
                NavigationBarUtils.m15970a(getWindow(), -1, true);
            }
            this.f6624f = ContextBuilder.m6349a(this, true, true);
            setContentView((int) R.layout.mz_aicy_activity);
            m6504a();
            this.f6621c = (ViewPager) findViewById(R.id.aicy_view);
            this.f6622d = (LinearLayout) findViewById(R.id.aicy_indicator_layout);
            this.f6623e = (PagerCornerIndicator) findViewById(R.id.aicy_indicator);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6622d.getLayoutParams();
            if (DeviceHelper.f13874aa) {
                int dimensionPixelSize = this.f6624f.getResources().getDimensionPixelSize(R.dimen.mz_aicy_margin_bottom_18_9);
                if (NavigationBarUtils.m15973a(getApplicationContext().getResources())) {
                    i = this.f6624f.getResources().getDimensionPixelSize(R.dimen.mz_aicy_margin_offset_18_9);
                }
                layoutParams.bottomMargin = dimensionPixelSize - i;
            } else {
                int dimensionPixelSize2 = this.f6624f.getResources().getDimensionPixelSize(R.dimen.mz_aicy_margin_bottom);
                if (NavigationBarUtils.m15973a(getApplicationContext().getResources())) {
                    i = this.f6624f.getResources().getDimensionPixelSize(R.dimen.mz_aicy_margin_offset);
                }
                layoutParams.bottomMargin = dimensionPixelSize2 - i;
            }
            this.f6622d.setLayoutParams(layoutParams);
            if (this.f6623e != null) {
                this.f6623e.setIndicatorNumber(DeviceHelper.f13877ad ? 6 : 5);
            }
            this.f6621c.setAdapter(this.f6625g);
            this.f6621c.mo24936a(this.f6627i);
        }
    }

    /* renamed from: a */
    private void m6504a() {
        if (!PatchProxy.proxy(new Object[0], this, f6619a, false, 732, new Class[0], Void.TYPE).isSupported) {
            LayoutInflater from = LayoutInflater.from(this);
            Object[] objArr = {Integer.valueOf(R.drawable.mz_aicy_asd), Integer.valueOf(R.drawable.mz_aicy_beauty), Integer.valueOf(R.drawable.mz_aicy_super_night), Integer.valueOf(R.drawable.mz_aicy_search_photo), Integer.valueOf(R.drawable.mz_aicy_things_clues), Integer.valueOf(R.drawable.mz_aicy_document)};
            Object[] stringArray = this.f6624f.getResources().getStringArray(R.array.mz_aicy_title_values);
            Object[] stringArray2 = this.f6624f.getResources().getStringArray(R.array.mz_aicy_content_values);
            if (!DeviceHelper.f13877ad) {
                objArr = C2644av.m16108a(0, objArr);
                stringArray = C2644av.m16108a(0, stringArray);
                stringArray2 = C2644av.m16108a(0, stringArray2);
            }
            if (DeviceHelper.f14032dx) {
                int i = 0;
                while (true) {
                    if (i >= stringArray.length) {
                        break;
                    } else if (stringArray[i].equals(this.f6624f.getResources().getString(R.string.mz_aicy_super_night_title))) {
                        stringArray[i] = getResources().getString(R.string.mz_aicy_super_night_title_ver_3);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            int dimensionPixelOffset = this.f6624f.getResources().getDimensionPixelOffset(R.dimen.mz_aicy_image_height_18_9);
            int dimensionPixelOffset2 = this.f6624f.getResources().getDimensionPixelOffset(R.dimen.mz_aicy_image_height);
            float f = ((float) dimensionPixelOffset2) / ((float) dimensionPixelOffset);
            for (int i2 = 0; i2 < objArr.length; i2++) {
                View inflate = from.inflate(R.layout.mz_aicy_pager_item, (ViewGroup) null, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.aicy_item_image);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                if (DeviceHelper.f13874aa) {
                    layoutParams.height = dimensionPixelOffset;
                } else {
                    layoutParams.width = (int) (((float) CameraUtil.m15809a()) * f);
                    layoutParams.height = dimensionPixelOffset2;
                }
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(Integer.valueOf(objArr[i2].toString()).intValue());
                ((TextView) inflate.findViewById(R.id.aicy_item_title)).setText(stringArray[i2].toString());
                ((TextView) inflate.findViewById(R.id.aicy_item_content)).setText(stringArray2[i2].toString());
                this.f6626h.add(inflate);
            }
        }
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f6619a, false, 733, new Class[0], Void.TYPE).isSupported) {
            super.onResume();
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f6619a, false, 734, new Class[0], Void.TYPE).isSupported) {
            super.onPause();
        }
    }

    public void onDestroy() {
        if (!PatchProxy.proxy(new Object[0], this, f6619a, false, 735, new Class[0], Void.TYPE).isSupported) {
            super.onDestroy();
            if (this.f6621c != null) {
                this.f6621c.mo24945b(this.f6627i);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{menuItem}, this, f6619a, false, 736, new Class[]{MenuItem.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return true;
    }

    class ViewPagerAdapter extends PagerAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f6630a;

        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        ViewPagerAdapter() {
        }

        public int getCount() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6630a, false, 738, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : CameraAicyActivity.this.f6626h.size();
        }

        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f6630a, false, 739, new Class[]{ViewGroup.class, Integer.TYPE}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            if (i >= CameraAicyActivity.this.f6626h.size()) {
                return super.instantiateItem(viewGroup, i);
            }
            viewGroup.addView((View) CameraAicyActivity.this.f6626h.get(i));
            return CameraAicyActivity.this.f6626h.get(i);
        }

        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            Object[] objArr = {viewGroup, new Integer(i), obj};
            ChangeQuickRedirect changeQuickRedirect = f6630a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 740, new Class[]{ViewGroup.class, Integer.TYPE, Object.class}, Void.TYPE).isSupported) {
                viewGroup.removeView((View) obj);
            }
        }
    }
}
