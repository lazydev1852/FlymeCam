package com.meizu.savior;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;
import com.meizu.savior.PatchManipulate;
import com.meizu.savior.net.Utf8StringRequest;
import com.meizu.savior.utils.MD5Util;
import com.meizu.savior.utils.NetworkUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchManipulateImp extends PatchManipulate {
    private static final String TAG = "savior";
    /* access modifiers changed from: private */
    public RequestQueue mRequestQueue;

    /* access modifiers changed from: private */
    public boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* access modifiers changed from: private */
    public void downloadPatchFile(Context context, Patch patch, PatchManipulate.PatchFetchCallback patchFetchCallback) {
        final Context context2 = context;
        final Patch patch2 = patch;
        final PatchManipulate.PatchFetchCallback patchFetchCallback2 = patchFetchCallback;
        this.mRequestQueue.mo8703a(new Request<byte[]>(patch.getUrl(), new Response.C0451a() {
            public void onErrorResponse(VolleyError tVar) {
                Log.w(PatchManipulateImp.TAG, "onErrorResponse volleyError :" + tVar.getMessage());
            }
        }) {
            /* access modifiers changed from: protected */
            public void deliverResponse(byte[] bArr) {
            }

            /* access modifiers changed from: protected */
            public Response<byte[]> parseNetworkResponse(NetworkResponse kVar) {
                int i;
                try {
                    i = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    i = -1;
                }
                if (i == -1) {
                    return null;
                }
                File filesDir = context2.getFilesDir();
                File file = new File(filesDir, PatchManipulateImp.TAG + File.separator + Constants.PATCH_SUFFIX + "_" + i + ".jar");
                if (file.getParentFile().exists()) {
                    boolean unused = PatchManipulateImp.this.deleteDir(file.getParentFile());
                }
                file.getParentFile().mkdirs();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(kVar.f326b);
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                String mD5FromFile = MD5Util.getMD5FromFile(file);
                if (!patch2.getMd5().equals(mD5FromFile)) {
                    file.delete();
                    Log.w(PatchManipulateImp.TAG, "fileMd5:" + mD5FromFile);
                    Log.w(PatchManipulateImp.TAG, "parseNetworkResponse, md5 is not match!");
                    return null;
                }
                patch2.setLocalPath(file.getAbsolutePath());
                if (patchFetchCallback2 != null) {
                    patchFetchCallback2.onPatchFetched(patch2);
                }
                PatchManipulateImp.this.mRequestQueue.mo8707b();
                return Response.m610a(kVar.f326b, HttpHeaderParser.m669a(kVar));
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadPatchFromLocal(Context context, PatchManipulate.PatchFetchCallback patchFetchCallback) {
        int i;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            i = -1;
        }
        if (i != -1) {
            File filesDir = context.getFilesDir();
            File file = new File(filesDir, TAG + File.separator + Constants.PATCH_SUFFIX + "_" + i + ".jar");
            if (!file.exists()) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
                if (!"0".equals(sharedPreferences.getString("patchVersion", "0"))) {
                    sharedPreferences.edit().putString("patchVersion", "0").apply();
                    return;
                }
                return;
            }
            Patch patch = new Patch();
            patch.setLocalPath(file.getAbsolutePath());
            patch.setPatchesInfoImplClassFullName("com.meizu.savior.patch.PatchesInfoImpl");
            if (patchFetchCallback != null) {
                patchFetchCallback.onPatchFetched(patch);
            }
        }
    }

    /* access modifiers changed from: private */
    public JSONObject safeParseJson(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Log.e(TAG, "JSON parse ERROR" + e.getMessage());
        } catch (Throwable unused) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void fetchPatch(final Context context, final PatchManipulate.PatchFetchCallback patchFetchCallback) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            loadPatchFromLocal(context, patchFetchCallback);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
        sharedPreferences.edit().putLong(Constants.PARAM_PATCH_DOWNLOAD_DATE, System.currentTimeMillis()).apply();
        if (sharedPreferences.getInt(Constants.PARAM_PKG_VERSION, -1) == -1) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                sharedPreferences.edit().putInt(Constants.PARAM_PKG_VERSION, packageInfo.versionCode).apply();
                Log.i(TAG, "package version is " + packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.m723a(context);
            this.mRequestQueue.mo8704a();
        }
        final Context context2 = context;
        C28023 r1 = new Utf8StringRequest(1, Constants.PATCH_QUERY_URL, new Response.C0452b<String>() {
            public void onResponse(String str) {
                Log.i(PatchManipulateImp.TAG, "onResponse s:" + str);
                JSONObject access$000 = PatchManipulateImp.this.safeParseJson(str);
                if (access$000 == null) {
                    Log.e(PatchManipulateImp.TAG, "jsonObject is null!");
                    return;
                }
                try {
                    int i = access$000.getInt("code");
                    if (i == 200) {
                        JSONObject jSONObject = access$000.getJSONObject("value");
                        if (jSONObject == null) {
                            Log.e(PatchManipulateImp.TAG, "values is null!");
                            return;
                        }
                        Patch patch = new Patch();
                        patch.setUrl(jSONObject.getString(Constants.KEY_LINK));
                        patch.setMd5(jSONObject.getString("md5"));
                        patch.setPatchVerCode(jSONObject.getInt("patchVersion"));
                        patch.setPatchesInfoImplClassFullName("com.meizu.savior.patch.PatchesInfoImpl");
                        PatchManipulateImp.this.downloadPatchFile(context, patch, patchFetchCallback);
                    } else if (i == 19002) {
                        PatchManipulateImp.this.mRequestQueue.mo8707b();
                        PatchManipulateImp.this.loadPatchFromLocal(context, patchFetchCallback);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.C0451a() {
            public void onErrorResponse(VolleyError tVar) {
                Log.w(PatchManipulateImp.TAG, "onErrorResponse volleyError :" + tVar.getMessage());
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                String string = context2.getSharedPreferences(context2.getPackageName(), 0).getString("patchVersion", "0");
                try {
                    PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0);
                    hashMap.put(Constants.PARAM_APK_VERSION_NAME, packageInfo.versionName);
                    String[] split = string.split("_");
                    if (split == null || split.length <= 1 || !split[0].equals(String.valueOf(packageInfo.versionCode))) {
                        hashMap.put("patchVersion", String.valueOf(0));
                    } else {
                        hashMap.put("patchVersion", split[1]);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                hashMap.put(Constants.PARAM_PKG_NAME, context2.getPackageName());
                hashMap.put(Constants.PARAM_FLYME_VERSION, Build.DISPLAY);
                hashMap.put(Constants.PARAM_MODEL, Build.MODEL);
                Log.i(PatchManipulateImp.TAG, "Build.DISPLAY:" + Build.DISPLAY);
                Log.i(PatchManipulateImp.TAG, "Build.MODEL:" + Build.MODEL);
                hashMap.put("sign", MD5Util.sortAndSign(MD5Util.getSecretKey(context2), hashMap));
                return hashMap;
            }
        };
        r1.setRetryPolicy(new DefaultRetryPolicy());
        this.mRequestQueue.mo8703a(r1);
    }
}
