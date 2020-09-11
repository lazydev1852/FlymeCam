package com.iflytek.business.speech;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SharedProvider extends ContentProvider {

    /* renamed from: a */
    private final String f2453a = "SharedProvider";

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        Logging.m2835b("SharedProvider", "openAssetFile");
        try {
            String substring = uri.getPath().substring(1);
            Logging.m2835b("SharedProvider", "openAssetFile | path: " + substring);
            return getContext().getAssets().openFd(substring);
        } catch (IOException e) {
            Logging.m2832a("SharedProvider", "", e);
            return null;
        }
    }
}
