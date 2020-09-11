package com.mediatek.accessor.parser;

import com.mediatek.accessor.data.GoogleStereoInfo;
import com.mediatek.accessor.data.SegmentMaskInfo;
import com.mediatek.accessor.data.StereoBufferInfo;
import com.mediatek.accessor.data.StereoCaptureInfo;
import com.mediatek.accessor.data.StereoConfigInfo;
import com.mediatek.accessor.data.StereoDepthInfo;
import java.util.Map;

public class ParserFactory {
    public static final int GOOGLE_STEREO_INFO = 0;
    public static final int SEGMENT_MASK_INFO = 1;
    public static final int STEREO_BUFFER_INFO = 2;
    public static final int STEREO_CAPTURE_INFO = 5;
    public static final int STEREO_CONFIG_INFO = 3;
    public static final int STEREO_DEPTH_INFO = 4;

    public static IParser getParserInstance(int i, Object obj, byte[] bArr, byte[] bArr2, Map<String, byte[]> map) {
        switch (i) {
            case 0:
                return new GoogleStereoInfoParser(bArr, bArr2, (GoogleStereoInfo) obj);
            case 1:
                return new SegmentMaskInfoParser(bArr, map, (SegmentMaskInfo) obj);
            case 2:
                return new StereoBufferInfoParser(map, (StereoBufferInfo) obj);
            case 3:
                return new StereoConfigInfoParser(bArr, bArr2, map, (StereoConfigInfo) obj);
            case 4:
                return new StereoDepthInfoParser(bArr, bArr2, map, (StereoDepthInfo) obj);
            case 5:
                return new StereoCaptureInfoParser(bArr, bArr2, map, (StereoCaptureInfo) obj);
            default:
                return null;
        }
    }
}
