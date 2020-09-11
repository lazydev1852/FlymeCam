package com.meizu.media.camera;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.p020ar.util.IoUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class H5Activity extends AppCompatActivity {

    /* renamed from: a */
    public static ChangeQuickRedirect f6759a;

    /* renamed from: b */
    private WebView f6760b;

    public void onCreate(Bundle bundle) {
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f6759a, false, 1084, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            super.onCreate(bundle);
            setContentView((int) R.layout.activity_description);
            this.f6760b = (WebView) findViewById(R.id.fullscreen_content);
            final View findViewById = findViewById(R.id.back);
            findViewById.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6761a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f6761a, false, 1087, new Class[]{View.class}, Void.TYPE).isSupported) {
                        H5Activity.this.finish();
                    }
                }
            });
            this.f6760b.getSettings().setUseWideViewPort(true);
            this.f6760b.getSettings().setJavaScriptEnabled(true);
            this.f6760b.getSettings().setDomStorageEnabled(true);
            final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.emptyToast);
            if (Build.VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            this.f6760b.setWebViewClient(new WebViewClient() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6763a;

                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    if (!PatchProxy.proxy(new Object[]{webView, webResourceRequest, webResourceError}, this, f6763a, false, 1088, new Class[]{WebView.class, WebResourceRequest.class, WebResourceError.class}, Void.TYPE).isSupported) {
                        webView.loadData("", "text/html; charset=UTF-8", (String) null);
                        frameLayout.setVisibility(0);
                    }
                }

                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    if (!PatchProxy.proxy(new Object[]{webView, webResourceRequest, webResourceResponse}, this, f6763a, false, 1089, new Class[]{WebView.class, WebResourceRequest.class, WebResourceResponse.class}, Void.TYPE).isSupported) {
                        webView.loadData("", "text/html; charset=UTF-8", (String) null);
                        frameLayout.setVisibility(0);
                    }
                }

                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (!PatchProxy.proxy(new Object[]{webView, sslErrorHandler, sslError}, this, f6763a, false, 1090, new Class[]{WebView.class, SslErrorHandler.class, SslError.class}, Void.TYPE).isSupported) {
                        webView.loadData("", "text/html; charset=UTF-8", (String) null);
                        frameLayout.setVisibility(0);
                    }
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    if (!PatchProxy.proxy(new Object[]{webView, str, bitmap}, this, f6763a, false, 1091, new Class[]{WebView.class, String.class, Bitmap.class}, Void.TYPE).isSupported) {
                        if (str.contains("https://m.kuaidi100.com/app/query/?")) {
                            findViewById.setVisibility(0);
                        } else {
                            findViewById.setVisibility(8);
                        }
                    }
                }
            });
            if (getIntent().getData() != null) {
                this.f6760b.loadUrl(getIntent().getData().toString());
            } else {
                try {
                    FileInputStream openFileInput = openFileInput("CoachPageCache");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    for (int read = openFileInput.read(bArr); read != -1; read = openFileInput.read(bArr)) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    this.f6760b.loadData(byteArrayOutputStream.toString(IoUtils.UTF_8), "text/html; charset=UTF-8", (String) null);
                } catch (FileNotFoundException unused) {
                    m6596a();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frameLayout.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f6767a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f6767a, false, 1092, new Class[]{View.class}, Void.TYPE).isSupported) {
                        H5Activity.this.m6596a();
                        frameLayout.setVisibility(4);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6596a() {
        if (!PatchProxy.proxy(new Object[0], this, f6759a, false, 1085, new Class[0], Void.TYPE).isSupported) {
            if (getIntent().getData() != null) {
                this.f6760b.loadUrl(getIntent().getData().toString());
            } else {
                this.f6760b.loadUrl("http://web-photos.meizu.com/camera/light_paint.html");
            }
        }
    }

    public void onResume() {
        if (!PatchProxy.proxy(new Object[0], this, f6759a, false, 1086, new Class[0], Void.TYPE).isSupported) {
            super.onResume();
            this.f6760b.setSystemUiVisibility(4869);
        }
    }
}
