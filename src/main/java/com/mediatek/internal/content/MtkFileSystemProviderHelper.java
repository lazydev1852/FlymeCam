package com.mediatek.internal.content;

import android.content.Context;
import android.drm.DrmManagerClient;
import android.media.MediaFile;
import android.net.Uri;
import android.os.SystemProperties;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.mediatek.media.MtkMediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;

public class MtkFileSystemProviderHelper {
    private static final Uri BASE_URI = new Uri.Builder().scheme(PushConstants.CONTENT).authority("com.android.externalstorage.documents").build();
    private static final boolean DEBUG = false;
    private static final String[] DEFAULT_DOCUMENT_PROJECTION = {"document_id", "mime_type", "_display_name", "last_modified", "flags", "_size", "_data", "is_drm", MtkMediaStore.MediaColumns.DRM_METHOD};
    private static final boolean LOG_INOTIFY = false;
    private static final String TAG = "FileSystemProvider";
    private Context mContext = null;
    private String[] mDefaultProjection;

    public MtkFileSystemProviderHelper(Context context) {
        this.mContext = context;
    }

    public static boolean isMtkDrmApp() {
        return SystemProperties.getBoolean("ro.mtk_oma_drm_support", false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0091, code lost:
        r13 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (r10 != null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        if (r10 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:16:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void supportDRM(java.io.File r10, android.database.MatrixCursor.RowBuilder r11, java.lang.String r12, java.lang.String r13, java.io.File r14) throws java.io.FileNotFoundException {
        /*
            r9 = this;
            java.lang.String r12 = r10.getName()
            boolean r0 = isMtkDrmApp()
            if (r0 == 0) goto L_0x00b1
            boolean r0 = r10.isDirectory()
            if (r0 != 0) goto L_0x00b1
            r0 = 46
            int r0 = r12.lastIndexOf(r0)
            r1 = 1
            r2 = 0
            if (r0 < 0) goto L_0x0024
            int r0 = r0 + r1
            java.lang.String r12 = r12.substring(r0)
            java.lang.String r12 = r12.toLowerCase()
            goto L_0x0025
        L_0x0024:
            r12 = r2
        L_0x0025:
            if (r12 == 0) goto L_0x00b1
            java.lang.String r0 = "dcf"
            boolean r12 = r12.equalsIgnoreCase(r0)
            if (r12 == 0) goto L_0x00b1
            java.lang.String r10 = "external"
            android.net.Uri r4 = android.provider.MediaStore.Files.getContentUri(r10)
            java.lang.String r6 = "_data = ?"
            java.lang.String r10 = "is_drm"
            java.lang.String r12 = "drm_method"
            java.lang.String r0 = "mime_type"
            java.lang.String[] r5 = new java.lang.String[]{r10, r12, r0}
            if (r14 == 0) goto L_0x009a
            android.content.Context r10 = r9.mContext     // Catch:{ IllegalStateException -> 0x0098, all -> 0x0095 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ IllegalStateException -> 0x0098, all -> 0x0095 }
            java.lang.String[] r7 = new java.lang.String[r1]     // Catch:{ IllegalStateException -> 0x0098, all -> 0x0095 }
            r10 = 0
            java.lang.String r12 = r14.getAbsolutePath()     // Catch:{ IllegalStateException -> 0x0098, all -> 0x0095 }
            r7[r10] = r12     // Catch:{ IllegalStateException -> 0x0098, all -> 0x0095 }
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ IllegalStateException -> 0x0098, all -> 0x0095 }
            if (r10 == 0) goto L_0x00a2
            boolean r12 = r10.moveToFirst()     // Catch:{ IllegalStateException -> 0x00ae, all -> 0x0093 }
            if (r12 == 0) goto L_0x00a2
            java.lang.String r12 = "is_drm"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ IllegalStateException -> 0x00ae, all -> 0x0093 }
            int r12 = r10.getInt(r12)     // Catch:{ IllegalStateException -> 0x00ae, all -> 0x0093 }
            java.lang.String r0 = "drm_method"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ IllegalStateException -> 0x00ae, all -> 0x0093 }
            int r0 = r10.getInt(r0)     // Catch:{ IllegalStateException -> 0x00ae, all -> 0x0093 }
            java.lang.String r1 = "mime_type"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ IllegalStateException -> 0x00ae, all -> 0x0093 }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ IllegalStateException -> 0x00ae, all -> 0x0093 }
            java.lang.String r13 = "is_drm"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IllegalStateException -> 0x0091, all -> 0x0093 }
            r11.add(r13, r12)     // Catch:{ IllegalStateException -> 0x0091, all -> 0x0093 }
            java.lang.String r12 = "drm_method"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalStateException -> 0x0091, all -> 0x0093 }
            r11.add(r12, r13)     // Catch:{ IllegalStateException -> 0x0091, all -> 0x0093 }
            r13 = r1
            goto L_0x00a2
        L_0x0091:
            r13 = r1
            goto L_0x00ae
        L_0x0093:
            r11 = move-exception
            goto L_0x00a8
        L_0x0095:
            r11 = move-exception
            r10 = r2
            goto L_0x00a8
        L_0x0098:
            r10 = r2
            goto L_0x00ae
        L_0x009a:
            java.lang.String r10 = "FileSystemProvider"
            java.lang.String r12 = "VisibleFile is null"
            android.util.Log.d(r10, r12)     // Catch:{ IllegalStateException -> 0x0098, all -> 0x0095 }
            r10 = r2
        L_0x00a2:
            if (r10 == 0) goto L_0x00b2
        L_0x00a4:
            r10.close()
            goto L_0x00b2
        L_0x00a8:
            if (r10 == 0) goto L_0x00ad
            r10.close()
        L_0x00ad:
            throw r11
        L_0x00ae:
            if (r10 == 0) goto L_0x00b2
            goto L_0x00a4
        L_0x00b1:
            r14 = r10
        L_0x00b2:
            java.lang.String r10 = "mime_type"
            r11.add(r10, r13)
            java.lang.String r10 = "_data"
            java.lang.String r12 = r14.getAbsolutePath()
            r11.add(r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.internal.content.MtkFileSystemProviderHelper.supportDRM(java.io.File, android.database.MatrixCursor$RowBuilder, java.lang.String, java.lang.String, java.io.File):void");
    }

    public String getTypeForNameMtk(File file, String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String lowerCase = str.substring(lastIndexOf + 1).toLowerCase();
            if (lowerCase.equalsIgnoreCase("dcf")) {
                return getTypeForDrmFile(file);
            }
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        String mimeTypeForFile = MediaFile.getMimeTypeForFile(str);
        return mimeTypeForFile != null ? mimeTypeForFile : "application/octet-stream";
    }

    private String getTypeForDrmFile(File file) {
        DrmManagerClient drmManagerClient = new DrmManagerClient(this.mContext);
        String file2 = file.toString();
        Log.d(TAG, "getTypeForFile rawFile = " + file2);
        return drmManagerClient.canHandle(file2, (String) null) ? drmManagerClient.getOriginalMimeType(file2) : "application/octet-stream";
    }

    public String[] getDefaultProjection() {
        return DEFAULT_DOCUMENT_PROJECTION;
    }
}
