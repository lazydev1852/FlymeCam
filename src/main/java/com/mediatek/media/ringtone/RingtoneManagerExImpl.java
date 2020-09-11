package com.mediatek.media.ringtone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.mediatek.media.MtkMediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import libcore.io.IoUtils;

public class RingtoneManagerExImpl extends RingtoneManagerEx {
    private static final int DRM_LEVEL_ALL = 4;
    private static final int DRM_LEVEL_FL = 1;
    private static final int DRM_LEVEL_SD = 2;
    private static final String[] DRM_PROJECTION = {"_id", "is_drm", MtkMediaStore.MediaColumns.DRM_METHOD};
    private static final String EXTRA_DRM_LEVEL = "android.intent.extra.drm_level";
    private static final String TAG = "RingtoneManagerExImpl";

    public void preFilterDrmFilesForFlType(Context context, Uri uri) {
        Cursor cursor;
        String str = null;
        try {
            cursor = context.getContentResolver().query(uri, DRM_PROJECTION, (String) null, (String[]) null, (String) null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1) {
                        cursor.moveToFirst();
                        str = cursor.getString(1);
                        cursor.getString(2);
                        cursor.deactivate();
                    }
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(cursor);
                    throw th;
                }
            }
            IoUtils.closeQuietly(cursor);
            Log.d(TAG, "is_drm = " + str);
            if ("1".equals(str)) {
                throw new IllegalArgumentException("Ringtone DRM file must have is_drm = 1 & drm_method = 1 , But given file has is_drm = \"" + str);
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            IoUtils.closeQuietly(cursor);
            throw th;
        }
    }

    public String appendDrmToWhereClause(Activity activity) {
        Log.d(TAG, "[appendDrmToWhereClause] activity = " + activity);
        if (activity == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" and ");
        sb.append("(");
        sb.append("is_drm");
        sb.append("!=1");
        Intent intent = activity.getIntent();
        if (intent != null && intent.getIntExtra(EXTRA_DRM_LEVEL, 1) == 1) {
            sb.append(" or ");
            sb.append(MtkMediaStore.MediaColumns.DRM_METHOD);
            sb.append("=1");
        }
        sb.append(")");
        Log.d(TAG, "[appendDrmToWhereClause] return:" + sb.toString());
        return sb.toString();
    }

    public String[] getMtkMediaColumns() {
        return new String[]{"_id", PushConstants.TITLE, "\"" + MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "\"", "title_key", "is_drm", MtkMediaStore.MediaColumns.DRM_METHOD};
    }
}
