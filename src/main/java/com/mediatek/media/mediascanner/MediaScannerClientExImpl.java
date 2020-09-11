package com.mediatek.media.mediascanner;

import android.content.ContentValues;
import android.content.Context;
import android.drm.DrmManagerClient;
import android.media.MediaFile;
import android.media.MediaScanner;
import android.os.Build;
import android.util.Log;
import com.mediatek.media.MtkMediaStore;
import com.mediatek.mmsdk.BaseParameters;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MediaScannerClientExImpl extends MediaScannerClientEx {
    private static final int APP1 = 65505;
    private static final int APPXTAG_PLUS_LENGTHTAG_BYTE_COUNT = 4;
    private static final String CLASS_NAME_MY_MEDIA_SCANNER_CLIENT = "MyMediaScannerClient";
    private static final boolean DEBUG = (Log.isLoggable(TAG, 3) || "eng".equals(Build.TYPE));
    private static final String FIELD_NAME_CONTEXT = "mContext";
    private static final String FIELD_NAME_FILE_TYPE = "mFileType";
    private static final String FIELD_NAME_IS_DRM = "mIsDrm";
    private static final String FIELD_NAME_MIME_TYPE = "mMimeType";
    private static final String FIELD_NAME_MY_MEDIA_SCANNER_CLIENT = "mClient";
    private static final String METHOD_IS_DRM_ENABLED = "isDrmEnabled";
    private static final String MTK_REFOCUS_PREFIX = "MRefocus";
    private static final String NS_GDEPTH = "http://ns.google.com/photos/1.0/depthmap/";
    private static final int SOI = 65496;
    private static final int SOS = 65498;
    private static final String TAG = "MediaScannerClientExImpl";
    private static final String XMP_EXT_MAIN_HEADER1 = "http://ns.adobe.com/xmp/extension/";
    private static final String XMP_HEADER_START = "http://ns.adobe.com/xap/1.0/\u0000";
    private static Class sClassMyMediaScannerClient;
    private static Field sFieldClient = getField(MediaScanner.class, FIELD_NAME_MY_MEDIA_SCANNER_CLIENT);
    private static Field sFieldContext = getField(MediaScanner.class, FIELD_NAME_CONTEXT);
    private static Field sFieldFileType = getField(sClassMyMediaScannerClient, FIELD_NAME_FILE_TYPE);
    private static Field sFieldIsDrm = getField(sClassMyMediaScannerClient, FIELD_NAME_IS_DRM);
    private static Field sFieldMimeType = getField(sClassMyMediaScannerClient, FIELD_NAME_MIME_TYPE);
    private static Method sMethodIsDrmEnabled = getMethod(MediaScanner.class, METHOD_IS_DRM_ENABLED, new Class[0]);
    private ExMetaData mExMetaData;

    public static class ExMetaData {
        public String mDrmContentDescriptioin = null;
        public String mDrmContentName = null;
        public String mDrmContentUr = null;
        public String mDrmContentVendor = null;
        public long mDrmDataLen = -1;
        public String mDrmIconUri = null;
        public long mDrmMethod = -1;
        public long mDrmOffset = -1;
        public String mDrmRightsIssuer = null;
        public int mOrientation = 0;
    }

    static {
        for (Class cls : MediaScanner.class.getDeclaredClasses()) {
            if (cls.getSimpleName().equals(CLASS_NAME_MY_MEDIA_SCANNER_CLIENT)) {
                sClassMyMediaScannerClient = cls;
                sFieldIsDrm.setAccessible(true);
                sFieldFileType.setAccessible(true);
                sFieldMimeType.setAccessible(true);
                return;
            }
        }
    }

    public void init() {
        this.mExMetaData = new ExMetaData();
    }

    public void parseExMetaDataFromStringTag(String str, String str2, MediaScanner mediaScanner) {
        if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_CONTENT_URI)) {
            this.mExMetaData.mDrmContentUr = str2.trim();
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_OFFSET)) {
            this.mExMetaData.mDrmOffset = (long) parseSubstring(str2, 0, 0);
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_DATA_LEN)) {
            this.mExMetaData.mDrmDataLen = (long) parseSubstring(str2, 0, 0);
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_RIGHTS_ISSUER)) {
            this.mExMetaData.mDrmRightsIssuer = str2.trim();
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_CONTENT_NAME)) {
            this.mExMetaData.mDrmContentName = str2.trim();
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_CONTENT_DESCRIPTION)) {
            this.mExMetaData.mDrmContentDescriptioin = str2.trim();
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_CONTENT_VENDOR)) {
            this.mExMetaData.mDrmContentVendor = str2.trim();
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_ICON_URI)) {
            this.mExMetaData.mDrmIconUri = str2.trim();
        } else if (str.equalsIgnoreCase(MtkMediaStore.MediaColumns.DRM_METHOD)) {
            this.mExMetaData.mDrmMethod = (long) parseSubstring(str2, 0, 0);
        } else if (str.equalsIgnoreCase(BaseParameters.KEY_PICTURE_ROTATION)) {
            this.mExMetaData.mOrientation = parseSubstring(str2, 0, 0);
        }
    }

    public void addExMetaDataToContentValues(ContentValues contentValues, MediaScanner mediaScanner) {
        Object fieldOnObject = getFieldOnObject(sFieldClient, mediaScanner);
        if (fieldOnObject == null) {
            Log.e(TAG, "[addExMetaDataToContentValues] client is null, return");
            return;
        }
        if (((Boolean) getFieldOnObject(sFieldIsDrm, fieldOnObject)).booleanValue()) {
            contentValues.put(MtkMediaStore.MediaColumns.DRM_CONTENT_DESCRIPTION, this.mExMetaData.mDrmContentDescriptioin);
            contentValues.put(MtkMediaStore.MediaColumns.DRM_CONTENT_NAME, this.mExMetaData.mDrmContentName);
            contentValues.put(MtkMediaStore.MediaColumns.DRM_CONTENT_URI, this.mExMetaData.mDrmContentUr);
            contentValues.put(MtkMediaStore.MediaColumns.DRM_CONTENT_VENDOR, this.mExMetaData.mDrmContentVendor);
            contentValues.put(MtkMediaStore.MediaColumns.DRM_DATA_LEN, Long.valueOf(this.mExMetaData.mDrmDataLen));
            contentValues.put(MtkMediaStore.MediaColumns.DRM_ICON_URI, this.mExMetaData.mDrmIconUri);
            contentValues.put(MtkMediaStore.MediaColumns.DRM_OFFSET, Long.valueOf(this.mExMetaData.mDrmOffset));
            contentValues.put(MtkMediaStore.MediaColumns.DRM_RIGHTS_ISSUER, this.mExMetaData.mDrmRightsIssuer);
            contentValues.put(MtkMediaStore.MediaColumns.DRM_METHOD, Long.valueOf(this.mExMetaData.mDrmMethod));
        }
        if (MediaFile.isVideoFileType(((Integer) getFieldOnObject(sFieldFileType, fieldOnObject)).intValue())) {
            contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, Integer.valueOf(this.mExMetaData.mOrientation));
        }
    }

    public void correctFileType(String str, String str2, MediaScanner mediaScanner) {
        int lastIndexOf;
        Object fieldOnObject = getFieldOnObject(sFieldClient, mediaScanner);
        if (fieldOnObject == null) {
            Log.e(TAG, "[correctFileType] client is null, return");
        } else if (MediaFile.isImageFileType(((Integer) getFieldOnObject(sFieldFileType, fieldOnObject)).intValue()) && (lastIndexOf = str.lastIndexOf(".")) > 0 && str.substring(lastIndexOf + 1).toUpperCase().equals("DCF")) {
            if (DEBUG) {
                Log.v(TAG, "[correctFileType] detect a *.DCF file with input mime type = " + str2);
            }
            if (sFieldFileType != null) {
                try {
                    sFieldFileType.setInt(fieldOnObject, 0);
                } catch (IllegalAccessException e) {
                    Log.e(TAG, "[correctFileType] IllegalAccessException", e);
                }
            }
        }
    }

    public void correctMetaData(String str, MediaScanner mediaScanner) {
        Object fieldOnObject = getFieldOnObject(sFieldClient, mediaScanner);
        if (fieldOnObject == null) {
            Log.e(TAG, "[correctFileType] client is null, return");
        } else if (((Boolean) callMethodOnObject(mediaScanner, sMethodIsDrmEnabled, new Object[0])).booleanValue() && str.endsWith(".mudp")) {
            DrmManagerClient drmManagerClient = new DrmManagerClient((Context) getFieldOnObject(sFieldContext, mediaScanner));
            if (drmManagerClient.canHandle(str, (String) null)) {
                if (sFieldMimeType != null) {
                    try {
                        sFieldMimeType.set(fieldOnObject, drmManagerClient.getOriginalMimeType(str));
                    } catch (IllegalAccessException e) {
                        Log.e(TAG, "[correctMetaData] IllegalAccessException", e);
                    }
                }
                if (sFieldIsDrm != null) {
                    try {
                        sFieldIsDrm.setBoolean(fieldOnObject, true);
                    } catch (IllegalAccessException e2) {
                        Log.e(TAG, "[correctMetaData] IllegalAccessException", e2);
                    }
                }
                if (DEBUG) {
                    Log.d(TAG, "[correctMetaData] get cta file " + str + " with original mimetype = " + getFieldOnObject(sFieldMimeType, fieldOnObject));
                }
            }
        }
    }

    public void putExtensionContentValuesForImage(ContentValues contentValues, String str) {
        contentValues.put(MtkMediaStore.ImageColumns.CAMERA_REFOCUS, Integer.valueOf(isStereoPhoto(str) ? 1 : 0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0117 A[SYNTHETIC, Splitter:B:60:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014d A[SYNTHETIC, Splitter:B:73:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x017b A[SYNTHETIC, Splitter:B:82:0x017b] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isStereoPhoto(java.lang.String r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x000f
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x000e
            java.lang.String r7 = "MediaScannerClientExImpl"
            java.lang.String r1 = "<isStereoPhoto> filePath is null!!"
            android.util.Log.d(r7, r1)
        L_0x000e:
            return r0
        L_0x000f:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x003a
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x0039
            java.lang.String r1 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "<isStereoPhoto> "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = " not exists!!!"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.d(r1, r7)
        L_0x0039:
            return r0
        L_0x003a:
            long r1 = java.lang.System.currentTimeMillis()
            java.util.ArrayList r3 = parseApp1Info(r7)
            if (r3 == 0) goto L_0x01a7
            int r4 = r3.size()
            if (r4 >= 0) goto L_0x004c
            goto L_0x01a7
        L_0x004c:
            r4 = 0
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0143, IllegalArgumentException -> 0x010d }
            java.lang.String r6 = "r"
            r5.<init>(r7, r6)     // Catch:{ FileNotFoundException -> 0x0143, IllegalArgumentException -> 0x010d }
            r4 = 0
        L_0x0055:
            int r6 = r3.size()     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            if (r4 >= r6) goto L_0x00b6
            java.lang.Object r6 = r3.get(r4)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            com.mediatek.media.mediascanner.MediaScannerClientExImpl$Section r6 = (com.mediatek.media.mediascanner.MediaScannerClientExImpl.Section) r6     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            boolean r6 = isStereo(r6, r5)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            if (r6 == 0) goto L_0x00b3
            boolean r3 = DEBUG     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            if (r3 == 0) goto L_0x0086
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            java.lang.String r6 = "<isStereoPhoto> "
            r4.append(r6)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            java.lang.String r7 = " is stereo photo"
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            java.lang.String r7 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            android.util.Log.d(r3, r7)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
        L_0x0086:
            r5.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x0092
        L_0x008a:
            r7 = move-exception
            java.lang.String r0 = "MediaScannerClientExImpl"
            java.lang.String r3 = "<isStereoPhoto> IOException:"
            android.util.Log.e(r0, r3, r7)
        L_0x0092:
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x00b1
            java.lang.String r7 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "<isStereoPhoto> <performance> costs(ms): "
            r0.append(r3)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r7, r0)
        L_0x00b1:
            r7 = 1
            return r7
        L_0x00b3:
            int r4 = r4 + 1
            goto L_0x0055
        L_0x00b6:
            boolean r3 = DEBUG     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            if (r3 == 0) goto L_0x00d5
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            java.lang.String r6 = "<isStereoPhoto> "
            r4.append(r6)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            java.lang.String r7 = " is not stereo photo"
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            java.lang.String r7 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
            android.util.Log.d(r3, r7)     // Catch:{ FileNotFoundException -> 0x0107, IllegalArgumentException -> 0x0104, all -> 0x0101 }
        L_0x00d5:
            r5.close()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00e1
        L_0x00d9:
            r7 = move-exception
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.String r4 = "<isStereoPhoto> IOException:"
            android.util.Log.e(r3, r4, r7)
        L_0x00e1:
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0100
            java.lang.String r7 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<isStereoPhoto> <performance> costs(ms): "
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            r3.append(r4)
            java.lang.String r1 = r3.toString()
            android.util.Log.d(r7, r1)
        L_0x0100:
            return r0
        L_0x0101:
            r7 = move-exception
            goto L_0x0179
        L_0x0104:
            r7 = move-exception
            r4 = r5
            goto L_0x010e
        L_0x0107:
            r7 = move-exception
            r4 = r5
            goto L_0x0144
        L_0x010a:
            r7 = move-exception
            r5 = r4
            goto L_0x0179
        L_0x010d:
            r7 = move-exception
        L_0x010e:
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.String r5 = "<isStereoPhoto> IllegalArgumentException:"
            android.util.Log.e(r3, r5, r7)     // Catch:{ all -> 0x010a }
            if (r4 == 0) goto L_0x0123
            r4.close()     // Catch:{ IOException -> 0x011b }
            goto L_0x0123
        L_0x011b:
            r7 = move-exception
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.String r4 = "<isStereoPhoto> IOException:"
            android.util.Log.e(r3, r4, r7)
        L_0x0123:
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0142
            java.lang.String r7 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<isStereoPhoto> <performance> costs(ms): "
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            r3.append(r4)
            java.lang.String r1 = r3.toString()
            android.util.Log.d(r7, r1)
        L_0x0142:
            return r0
        L_0x0143:
            r7 = move-exception
        L_0x0144:
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.String r5 = "<isStereoPhoto> FileNotFoundException:"
            android.util.Log.e(r3, r5, r7)     // Catch:{ all -> 0x010a }
            if (r4 == 0) goto L_0x0159
            r4.close()     // Catch:{ IOException -> 0x0151 }
            goto L_0x0159
        L_0x0151:
            r7 = move-exception
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.String r4 = "<isStereoPhoto> IOException:"
            android.util.Log.e(r3, r4, r7)
        L_0x0159:
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0178
            java.lang.String r7 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<isStereoPhoto> <performance> costs(ms): "
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            r3.append(r4)
            java.lang.String r1 = r3.toString()
            android.util.Log.d(r7, r1)
        L_0x0178:
            return r0
        L_0x0179:
            if (r5 == 0) goto L_0x0187
            r5.close()     // Catch:{ IOException -> 0x017f }
            goto L_0x0187
        L_0x017f:
            r0 = move-exception
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.String r4 = "<isStereoPhoto> IOException:"
            android.util.Log.e(r3, r4, r0)
        L_0x0187:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x01a6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "<isStereoPhoto> <performance> costs(ms): "
            r0.append(r3)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "MediaScannerClientExImpl"
            android.util.Log.d(r1, r0)
        L_0x01a6:
            throw r7
        L_0x01a7:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x01c6
            java.lang.String r1 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "<isStereoPhoto> "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = ", no app1 sections"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.d(r1, r7)
        L_0x01c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.media.mediascanner.MediaScannerClientExImpl.isStereoPhoto(java.lang.String):boolean");
    }

    private static boolean isStereo(Section section, RandomAccessFile randomAccessFile) {
        try {
            if (section.mIsXmpMain) {
                randomAccessFile.seek(section.mOffset + 2);
                randomAccessFile.skipBytes("http://ns.adobe.com/xap/1.0/\u0000".length());
                byte[] bArr = new byte[((randomAccessFile.readUnsignedShort() - 2) - "http://ns.adobe.com/xap/1.0/\u0000".length())];
                randomAccessFile.read(bArr, 0, bArr.length);
                if (new String(bArr).contains(MTK_REFOCUS_PREFIX)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            Log.e(TAG, "<isStereo> IOException:", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb A[SYNTHETIC, Splitter:B:44:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00da A[SYNTHETIC, Splitter:B:51:0x00da] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.mediatek.media.mediascanner.MediaScannerClientExImpl.Section> parseApp1Info(java.lang.String r9) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x00a1, all -> 0x009c }
            java.lang.String r2 = "r"
            r1.<init>(r9, r2)     // Catch:{ IOException -> 0x00a1, all -> 0x009c }
            int r2 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x009a }
            r3 = 65496(0xffd8, float:9.178E-41)
            if (r2 == r3) goto L_0x003d
            boolean r2 = DEBUG     // Catch:{ IOException -> 0x009a }
            if (r2 == 0) goto L_0x001c
            java.lang.String r2 = "MediaScannerClientExImpl"
            java.lang.String r3 = "<parseApp1Info> error, find no SOI"
            android.util.Log.d(r2, r3)     // Catch:{ IOException -> 0x009a }
        L_0x001c:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ IOException -> 0x009a }
            r2.<init>()     // Catch:{ IOException -> 0x009a }
            r1.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x003c
        L_0x0025:
            r0 = move-exception
            java.lang.String r1 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<parseApp1Info> IOException, path "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.e(r1, r9, r0)
        L_0x003c:
            return r2
        L_0x003d:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ IOException -> 0x009a }
            r2.<init>()     // Catch:{ IOException -> 0x009a }
        L_0x0042:
            int r3 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x009a }
            r4 = -1
            if (r3 == r4) goto L_0x007e
            r4 = 65498(0xffda, float:9.1782E-41)
            if (r3 == r4) goto L_0x007e
            long r4 = r1.getFilePointer()     // Catch:{ IOException -> 0x009a }
            r6 = 2
            long r4 = r4 - r6
            int r6 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x009a }
            r7 = 65505(0xffe1, float:9.1792E-41)
            if (r3 != r7) goto L_0x0078
            com.mediatek.media.mediascanner.MediaScannerClientExImpl$Section r7 = new com.mediatek.media.mediascanner.MediaScannerClientExImpl$Section     // Catch:{ IOException -> 0x009a }
            r7.<init>(r3, r4, r6)     // Catch:{ IOException -> 0x009a }
            long r3 = r1.getFilePointer()     // Catch:{ IOException -> 0x009a }
            com.mediatek.media.mediascanner.MediaScannerClientExImpl$Section r5 = checkIfMainXmpInApp1(r1, r7)     // Catch:{ IOException -> 0x009a }
            if (r5 == 0) goto L_0x0075
            boolean r7 = r5.mIsXmpMain     // Catch:{ IOException -> 0x009a }
            if (r7 == 0) goto L_0x0075
            r2.add(r5)     // Catch:{ IOException -> 0x009a }
            goto L_0x007e
        L_0x0075:
            r1.seek(r3)     // Catch:{ IOException -> 0x009a }
        L_0x0078:
            int r6 = r6 + -2
            r1.skipBytes(r6)     // Catch:{ IOException -> 0x009a }
            goto L_0x0042
        L_0x007e:
            r1.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0099
        L_0x0082:
            r0 = move-exception
            java.lang.String r1 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<parseApp1Info> IOException, path "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.e(r1, r9, r0)
        L_0x0099:
            return r2
        L_0x009a:
            r2 = move-exception
            goto L_0x00a3
        L_0x009c:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x00d8
        L_0x00a1:
            r2 = move-exception
            r1 = r0
        L_0x00a3:
            java.lang.String r3 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r4.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r5 = "<parseApp1Info> IOException, path "
            r4.append(r5)     // Catch:{ all -> 0x00d7 }
            r4.append(r9)     // Catch:{ all -> 0x00d7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d7 }
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x00d7 }
            if (r1 == 0) goto L_0x00d6
            r1.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00d6
        L_0x00bf:
            r1 = move-exception
            java.lang.String r2 = "MediaScannerClientExImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<parseApp1Info> IOException, path "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.e(r2, r9, r1)
        L_0x00d6:
            return r0
        L_0x00d7:
            r0 = move-exception
        L_0x00d8:
            if (r1 == 0) goto L_0x00f5
            r1.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00f5
        L_0x00de:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "<parseApp1Info> IOException, path "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r2 = "MediaScannerClientExImpl"
            android.util.Log.e(r2, r9, r1)
        L_0x00f5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.media.mediascanner.MediaScannerClientExImpl.parseApp1Info(java.lang.String):java.util.ArrayList");
    }

    private static Section checkIfMainXmpInApp1(RandomAccessFile randomAccessFile, Section section) {
        if (section == null) {
            if (DEBUG) {
                Log.d(TAG, "<checkIfMainXmpInApp1> section is null!!!");
            }
            return null;
        }
        try {
            if (section.mMarker == 65505) {
                randomAccessFile.seek(section.mOffset + 4);
                byte[] bArr = new byte["http://ns.adobe.com/xmp/extension/".length()];
                randomAccessFile.read(bArr, 0, bArr.length);
                if ("http://ns.adobe.com/xap/1.0/\u0000".equals(new String(bArr, 0, "http://ns.adobe.com/xap/1.0/\u0000".length()))) {
                    section.mIsXmpMain = true;
                }
            }
            return section;
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "<checkIfMainXmpInApp1> UnsupportedEncodingException" + e);
            return null;
        } catch (IOException e2) {
            Log.e(TAG, "<checkIfMainXmpInApp1> IOException" + e2);
            return null;
        }
    }

    private static class Section {
        public boolean mIsXmpMain;
        public int mLength;
        public int mMarker;
        public long mOffset;

        public Section(int i, long j, int i2) {
            this.mMarker = i;
            this.mOffset = j;
            this.mLength = i2;
        }
    }

    private static int parseSubstring(String str, int i, int i2) {
        int length = str.length();
        if (i == length) {
            return i2;
        }
        int i3 = i + 1;
        char charAt = str.charAt(i);
        if (charAt < '0' || charAt > '9') {
            return i2;
        }
        int i4 = charAt - '0';
        while (i3 < length) {
            int i5 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < '0' || charAt2 > '9') {
                return i4;
            }
            i4 = (i4 * 10) + (charAt2 - '0');
            i3 = i5;
        }
        return i4;
    }

    private static Field getField(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "[getField]", e);
            return null;
        }
    }

    private static Object getFieldOnObject(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "[getFieldOnObject]", e);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "[getMethod]", e);
            return null;
        }
    }

    public static Object callMethodOnObject(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "[callMethodOnObject]", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "[callMethodOnObject]", e2);
            return null;
        }
    }
}
