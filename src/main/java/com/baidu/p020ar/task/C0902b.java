package com.baidu.p020ar.task;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.p035b.C0602a;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.UrlUtils;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.task.b */
public class C0902b extends AsyncTask<String, Void, String> implements HttpHandle {

    /* renamed from: a */
    private Context f2304a;

    /* renamed from: b */
    private String f2305b;

    /* renamed from: c */
    private HttpResponseListener<JSONObject> f2306c;

    private C0902b() {
    }

    public C0902b(Context context, String str, HttpResponseListener<JSONObject> httpResponseListener) {
        this.f2304a = context;
        this.f2305b = str;
        this.f2306c = httpResponseListener;
    }

    public C0902b(String str, HttpResponseListener<JSONObject> httpResponseListener) {
        this.f2306c = httpResponseListener;
        this.f2305b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            if (UrlUtils.getAipAuthUrl().equals(this.f2305b)) {
                this.f2305b += "?access_token=" + C0602a.m1216a(this.f2304a);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f2305b).openConnection();
            httpURLConnection.setConnectTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "application/json");
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            ARLog.m2695d("post params = " + strArr[0]);
            dataOutputStream.write(strArr[0].getBytes(StandardCharsets.UTF_8));
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            return readLine;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (str == null) {
            ARLog.m2696e("result = null");
            if (this.f2306c != null) {
                this.f2306c.onErrorResponse("http error! result is null");
                return;
            }
            return;
        }
        try {
            if (this.f2306c != null) {
                this.f2306c.onResponse(new JSONObject(str));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void finish() {
        cancel(true);
        this.f2304a = null;
        this.f2306c = null;
    }
}
