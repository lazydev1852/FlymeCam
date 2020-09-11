package flyme.support.p093v7.app;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* renamed from: flyme.support.v7.app.WebViewActivity */
public class WebViewActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25318a() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo25319b() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 29) {
            m18547a(mo25318a());
            m18548b(mo25319b());
        }
        m18549c();
        WebView webView = new WebView(this);
        String stringExtra = getIntent().getStringExtra("KEY_URL");
        if (!TextUtils.isEmpty(stringExtra)) {
            webView.loadUrl(stringExtra);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(getIntent().getBooleanExtra("KEY_ENABLE_JAVA_SCRIPT", false));
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(false);
            settings.setSupportZoom(false);
            settings.setDisplayZoomControls(false);
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.addView(webView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setFitsSystemWindows(true);
            setContentView((View) frameLayout);
            return;
        }
        throw new IllegalStateException("url can't be null");
    }

    @RequiresApi(api = 23)
    /* renamed from: a */
    private void m18547a(boolean z) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
    }

    @RequiresApi(api = 26)
    /* renamed from: b */
    private void m18548b(boolean z) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & -17);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* renamed from: c */
    private void m18549c() {
        ActionBar d = mo25161d();
        if (d != null) {
            d.mo25041a(true);
            d.mo25040a((CharSequence) getIntent().getStringExtra("KEY_TITLE"));
        }
    }
}
