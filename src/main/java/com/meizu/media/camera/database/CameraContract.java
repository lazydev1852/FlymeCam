package com.meizu.media.camera.database;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: com.meizu.media.camera.database.a */
public class CameraContract {

    /* renamed from: a */
    public static final Uri f9490a = Uri.parse("content://com.meizu.flyme.camera");

    /* renamed from: com.meizu.media.camera.database.a$a */
    /* compiled from: CameraContract */
    public static final class C2035a implements BaseColumns {

        /* renamed from: a */
        public static final Uri f9491a = Uri.withAppendedPath(CameraContract.f9490a, "arSticker");
    }

    /* renamed from: com.meizu.media.camera.database.a$b */
    /* compiled from: CameraContract */
    public static final class C2036b implements BaseColumns {

        /* renamed from: a */
        public static final Uri f9492a = Uri.withAppendedPath(CameraContract.f9490a, "sticker");
    }

    /* renamed from: com.meizu.media.camera.database.a$c */
    /* compiled from: CameraContract */
    public static final class C2037c implements BaseColumns {

        /* renamed from: a */
        public static final Uri f9493a = Uri.withAppendedPath(CameraContract.f9490a, "stickerCategory");
    }
}
