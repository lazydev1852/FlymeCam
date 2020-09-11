package com.mediatek.media;

import com.mediatek.media.mediascanner.MediaFileEx;
import com.mediatek.media.mediascanner.MediaFileExImpl;
import com.mediatek.media.mediascanner.MediaScannerClientEx;
import com.mediatek.media.mediascanner.MediaScannerClientExImpl;
import com.mediatek.media.mediascanner.ThumbnailUtilsEx;
import com.mediatek.media.mediascanner.ThumbnailUtilsExImpl;
import com.mediatek.media.ringtone.RingtoneManagerEx;
import com.mediatek.media.ringtone.RingtoneManagerExImpl;

public class MediaFactoryImpl extends MediaFactory {
    public MediaFileEx getMediaFileEx() {
        return new MediaFileExImpl();
    }

    public MediaScannerClientEx getMediaScannerClientEx() {
        return new MediaScannerClientExImpl();
    }

    public RingtoneManagerEx getRingtoneManagerEx() {
        return new RingtoneManagerExImpl();
    }

    public ThumbnailUtilsEx getThumbnailUtilsEx() {
        return new ThumbnailUtilsExImpl();
    }
}
