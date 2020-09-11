package com.baidu.p020ar.arplay.webview;

import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.webview.GLWebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.baidu.ar.arplay.webview.GLWebViewManager */
public class GLWebViewManager {

    /* renamed from: b */
    private static GLWebViewManager f921b;

    /* renamed from: a */
    WebViewClient f922a = new WebViewClient() {
        public void onPageCommitVisible(WebView webView, String str) {
            super.onPageCommitVisible(webView, str);
            int intValue = ((Integer) webView.getTag()).intValue();
            GLWebViewManager.this.m1171a(intValue);
            GLWebViewManager.this.m1185d(intValue);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceError != null) {
                C0595a aVar = new C0595a();
                aVar.f944b = webResourceError.getErrorCode();
                if (webResourceError.getDescription() != null) {
                    aVar.f945c = webResourceError.getDescription().toString();
                }
                GLWebViewManager.this.m1172a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceResponse != null) {
                C0595a aVar = new C0595a();
                aVar.f944b = webResourceResponse.getStatusCode();
                aVar.f945c = webResourceResponse.getReasonPhrase();
                GLWebViewManager.this.m1172a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                C0595a aVar = new C0595a();
                aVar.f944b = sslError.getPrimaryError();
                aVar.f945c = "ssl error!";
                GLWebViewManager.this.m1172a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };

    /* renamed from: c */
    private Context f923c;

    /* renamed from: d */
    private ViewGroup f924d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnTouchListener f925e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnTouchListener f926f;

    /* renamed from: g */
    private String f927g;

    /* renamed from: h */
    private List<GLWebView> f928h = new ArrayList();

    /* renamed from: i */
    private ViewGroup f929i;

    /* renamed from: j */
    private WebView f930j;

    /* renamed from: k */
    private Handler f931k = new Handler(Looper.getMainLooper()) {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
            r3 = com.baidu.p020ar.arplay.webview.GLWebViewManager.m1170a(r2.f933a, r0.f915a);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r3) {
            /*
                r2 = this;
                super.handleMessage(r3)
                java.lang.Object r0 = r3.obj
                boolean r0 = r0 instanceof com.baidu.p020ar.arplay.webview.GLWebView.C0586a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r3.obj
                com.baidu.ar.arplay.webview.GLWebView$a r0 = (com.baidu.p020ar.arplay.webview.GLWebView.C0586a) r0
                goto L_0x000f
            L_0x000e:
                r0 = 0
            L_0x000f:
                int r1 = r3.what
                switch(r1) {
                    case 103: goto L_0x0048;
                    case 104: goto L_0x002d;
                    case 105: goto L_0x001b;
                    case 106: goto L_0x0015;
                    default: goto L_0x0014;
                }
            L_0x0014:
                goto L_0x004d
            L_0x0015:
                com.baidu.ar.arplay.webview.GLWebViewManager r3 = com.baidu.p020ar.arplay.webview.GLWebViewManager.this
                r3.m1179b((com.baidu.p020ar.arplay.webview.GLWebView.C0586a) r0)
                goto L_0x004d
            L_0x001b:
                int r3 = r3.arg1
                com.baidu.ar.arplay.webview.GLWebViewManager r0 = com.baidu.p020ar.arplay.webview.GLWebViewManager.this
                com.baidu.ar.arplay.webview.GLWebView r3 = r0.m1183c(r3)
                if (r3 == 0) goto L_0x004d
                r0 = 1
                r3.setIsNeedRender(r0)
                r3.invalidate()
                goto L_0x004d
            L_0x002d:
                if (r0 == 0) goto L_0x004d
                com.baidu.ar.arplay.webview.GLWebViewManager r3 = com.baidu.p020ar.arplay.webview.GLWebViewManager.this
                int r1 = r0.f915a
                com.baidu.ar.arplay.webview.GLWebView r3 = r3.m1183c(r1)
                if (r3 == 0) goto L_0x004d
                java.lang.String r1 = r0.f917c
                if (r1 == 0) goto L_0x004d
                java.lang.String r0 = r0.f917c
                com.baidu.ar.arplay.webview.GLWebViewManager$1$1 r1 = new com.baidu.ar.arplay.webview.GLWebViewManager$1$1
                r1.<init>(r3)
                r3.evaluateJavascript(r0, r1)
                goto L_0x004d
            L_0x0048:
                com.baidu.ar.arplay.webview.GLWebViewManager r3 = com.baidu.p020ar.arplay.webview.GLWebViewManager.this
                r3.m1173a((com.baidu.p020ar.arplay.webview.GLWebView.C0586a) r0)
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.webview.GLWebViewManager.C05871.handleMessage(android.os.Message):void");
        }
    };

    /* renamed from: l */
    private WebChromeClient f932l = new WebChromeClient() {
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                GLWebViewManager.this.m1185d(((GLWebView) webView).getWebViewData().f915a);
            }
        }
    };

    /* renamed from: com.baidu.ar.arplay.webview.GLWebViewManager$a */
    public class C0595a {

        /* renamed from: a */
        public String f943a = "android";

        /* renamed from: b */
        public int f944b = 0;

        /* renamed from: c */
        public String f945c;

        public C0595a() {
        }
    }

    /* renamed from: a */
    private GLWebView m1169a(int i, int i2) {
        final GLWebView gLWebView = new GLWebView(this.f923c);
        ViewGroup.LayoutParams layoutParams = this.f924d instanceof FrameLayout ? new FrameLayout.LayoutParams(i, i2) : this.f924d instanceof LinearLayout ? new LinearLayout.LayoutParams(i, i2) : this.f924d instanceof RelativeLayout ? new RelativeLayout.LayoutParams(i, i2) : null;
        gLWebView.setBackgroundColor(17170445);
        gLWebView.setWebViewClient(this.f922a);
        gLWebView.setWebChromeClient(this.f932l);
        gLWebView.setHorizontalScrollBarEnabled(false);
        gLWebView.setVerticalScrollBarEnabled(false);
        WebSettings settings = gLWebView.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 17) {
            gLWebView.addJavascriptInterface(new Object() {
                @JavascriptInterface
                public void updateFinish(String str) {
                    if (gLWebView != null) {
                        GLWebViewManager.this.m1185d(((Integer) gLWebView.getTag()).intValue());
                    }
                }
            }, "NativeCallback");
        }
        gLWebView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (GLWebViewManager.this.f925e != null) {
                    return GLWebViewManager.this.f925e.onTouch(view, motionEvent);
                }
                return false;
            }
        });
        this.f924d.addView(gLWebView, layoutParams);
        this.f928h.add(gLWebView);
        return gLWebView;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1171a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", "webView_operation_load_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1172a(int i, C0595a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", "webView_operation_load_failed");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("platform", aVar.f943a);
        hashMap3.put("error_code", Integer.valueOf(aVar.f944b));
        hashMap3.put("error_msg", aVar.f945c);
        hashMap2.put("data", hashMap3);
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        m1185d(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1173a(GLWebView.C0586a aVar) {
        if (aVar != null && m1176a()) {
            GLWebView a = m1169a(aVar.f919e, aVar.f920f);
            a.setWebViewData(aVar);
            C0597b.m1195a().mo9430a(aVar.f915a, aVar.f919e, aVar.f920f);
            a.setTag(Integer.valueOf(aVar.f915a));
            String str = aVar.f918d;
            if (!aVar.f916b) {
                str = "file://" + this.f927g.concat(File.separator).concat(aVar.f918d);
            }
            a.loadUrl(str);
            a.invalidate();
            a.setIsNeedRender(true);
            updateWebView(aVar);
        }
    }

    /* renamed from: a */
    private boolean m1176a() {
        if (this.f923c != null && this.f924d != null) {
            return true;
        }
        Log.e("GLWebView", "GLWebView context or root is null!");
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1178b(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", "webView_operation_update_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1179b(GLWebView.C0586a aVar) {
        if (aVar != null && m1182b()) {
            if (this.f930j == null) {
                this.f930j = new WebView(this.f923c);
                this.f930j.setBackgroundColor(17170445);
                WebSettings settings = this.f930j.getSettings();
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(true);
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                settings.setJavaScriptEnabled(true);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                this.f930j.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (GLWebViewManager.this.f926f != null) {
                            return GLWebViewManager.this.f926f.onTouch(view, motionEvent);
                        }
                        return false;
                    }
                });
                this.f929i.addView(this.f930j, layoutParams);
            }
            String str = aVar.f918d;
            if (!aVar.f916b) {
                str = "file://" + this.f927g.concat(File.separator).concat(aVar.f918d);
            }
            this.f930j.loadUrl(str);
            this.f930j.invalidate();
        }
    }

    /* renamed from: b */
    private boolean m1182b() {
        if (this.f923c != null && this.f929i != null) {
            return true;
        }
        Log.e("GLWebView", "Native WebView context or root is null!");
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public GLWebView m1183c(int i) {
        for (GLWebView next : this.f928h) {
            if (next != null && next.getWebViewData() != null && next.getWebViewData().f915a == i) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1185d(int i) {
        Message obtainMessage = this.f931k.obtainMessage();
        obtainMessage.what = 105;
        obtainMessage.arg1 = i;
        this.f931k.sendMessage(obtainMessage);
    }

    public static GLWebViewManager getInstance() {
        if (f921b == null) {
            synchronized (GLWebViewManager.class) {
                if (f921b == null) {
                    f921b = new GLWebViewManager();
                }
            }
        }
        return f921b;
    }

    public void initialGLWebViewContext(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.f923c = context;
        this.f924d = viewGroup;
        this.f925e = onTouchListener;
        ARPEngine.getInstance().setHtmlUpdateCallback(new ARPEngine.C0568b() {
            /* renamed from: a */
            public boolean mo9185a(int i, int i2) {
                GLWebViewManager.this.m1185d(i);
                return true;
            }
        });
    }

    public void initialNativeWebViewContext(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.f923c = context;
        this.f929i = viewGroup;
        this.f926f = onTouchListener;
    }

    public void loadGLWebView(GLWebView.C0586a aVar) {
        Message obtainMessage = this.f931k.obtainMessage();
        obtainMessage.what = 103;
        obtainMessage.obj = aVar;
        this.f931k.sendMessage(obtainMessage);
    }

    public void loadNativeWebView(GLWebView.C0586a aVar) {
        Message obtainMessage = this.f931k.obtainMessage();
        obtainMessage.what = 106;
        obtainMessage.obj = aVar;
        this.f931k.sendMessage(obtainMessage);
    }

    public void release() {
        this.f923c = null;
        C0597b.m1195a().mo9431b();
        for (GLWebView next : this.f928h) {
            if (next != null) {
                if (next.getParent() == this.f924d) {
                    this.f924d.removeView(next);
                }
                next.destroy();
            }
        }
        ARPEngine.getInstance().setHtmlUpdateCallback((ARPEngine.C0568b) null);
        this.f931k.removeCallbacksAndMessages((Object) null);
        this.f931k = null;
        this.f928h.clear();
        this.f928h = null;
        f921b = null;
        this.f930j = null;
        this.f926f = null;
    }

    public void setResDir(String str) {
        this.f927g = str;
    }

    public void updateWebView(GLWebView.C0586a aVar) {
        Message obtainMessage = this.f931k.obtainMessage();
        obtainMessage.what = 104;
        obtainMessage.obj = aVar;
        GLWebView c = m1183c(aVar.f915a);
        if (c != null) {
            c.setWebViewData(aVar);
            this.f931k.sendMessage(obtainMessage);
        }
    }
}
