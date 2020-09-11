package com.mediatek.accessor;

import com.mediatek.accessor.data.GoogleStereoInfo;
import com.mediatek.accessor.data.SegmentMaskInfo;
import com.mediatek.accessor.data.StereoBufferInfo;
import com.mediatek.accessor.data.StereoCaptureInfo;
import com.mediatek.accessor.data.StereoConfigInfo;
import com.mediatek.accessor.data.StereoDepthInfo;
import com.mediatek.accessor.packer.PackInfo;
import com.mediatek.accessor.packer.PackerManager;
import com.mediatek.accessor.parser.IParser;
import com.mediatek.accessor.parser.ParserFactory;
import com.mediatek.accessor.parser.SerializedInfo;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.ReadWriteLockFileUtils;
import com.mediatek.accessor.util.StereoInfoJsonParser;
import com.mediatek.accessor.util.TraceHelper;

public class StereoInfoAccessor {
    private static final String TAG = Log.Tag(StereoInfoAccessor.class.getSimpleName());

    public byte[] writeStereoCaptureInfo(StereoCaptureInfo stereoCaptureInfo) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-writeStereoCaptureInfo");
        Log.m3993d(TAG, "<writeStereoCaptureInfo> captureInfo " + stereoCaptureInfo);
        if (stereoCaptureInfo == null) {
            Log.m3993d(TAG, "<writeStereoCaptureInfo> captureInfo is null!");
            TraceHelper.endSection();
            return null;
        }
        String str = C1123Utils.DUMP_FILE_FOLDER + "/" + stereoCaptureInfo.debugDir + "/";
        if (C1123Utils.ENABLE_BUFFER_DUMP) {
            C1123Utils.writeBufferToFile(str + "StereoCaptureInfo_oriJpgBuffer_write.jpg", stereoCaptureInfo.jpgBuffer);
        }
        PackInfo packInfo = new PackInfo();
        PackerManager packerManager = new PackerManager();
        packInfo.unpackedJpgBuf = stereoCaptureInfo.jpgBuffer;
        IParser parserInstance = ParserFactory.getParserInstance(5, stereoCaptureInfo, packInfo.unpackedStandardXmpBuf, packInfo.unpackedExtendedXmpBuf, packInfo.unpackedCustomizedBufMap);
        parserInstance.write();
        serialize(packInfo, parserInstance);
        byte[] pack = packerManager.pack(packInfo);
        if (C1123Utils.ENABLE_BUFFER_DUMP) {
            C1123Utils.writeBufferToFile(str + "StereoCaptureInfo_packedJpgBuffer_write.jpg", pack);
        }
        TraceHelper.endSection();
        return pack;
    }

    public void writeStereoDepthInfo(String str, StereoDepthInfo stereoDepthInfo) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-writeStereoDepthInfo");
        String str2 = TAG;
        Log.m3993d(str2, "<writeStereoDepthInfo> filePath " + str + ", depthInfo " + stereoDepthInfo);
        if (stereoDepthInfo == null) {
            Log.m3993d(TAG, "<writeStereoDepthInfo> depthInfo is null!");
            TraceHelper.endSection();
            return;
        }
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.writeLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<writeStereoDepthInfo> fileBuffer is null!");
                TraceHelper.endSection();
                return;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                stereoDepthInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            unpack.unpackedJpgBuf = readFileToBuffer;
            IParser parserInstance = ParserFactory.getParserInstance(4, stereoDepthInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap);
            parserInstance.write();
            serialize(unpack, parserInstance);
            packerManager.pack(unpack);
            C1123Utils.writeBufferToFile(str, unpack.packedJpgBuf);
            ReadWriteLockFileUtils.writeUnlock(str);
            TraceHelper.endSection();
        } finally {
            ReadWriteLockFileUtils.writeUnlock(str);
        }
    }

    public void writeSegmentMaskInfo(String str, SegmentMaskInfo segmentMaskInfo) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-writeSegmentMaskInfo");
        String str2 = TAG;
        Log.m3993d(str2, "<writeSegmentMaskInfo> filePath " + str + ", maskInfo " + segmentMaskInfo);
        if (segmentMaskInfo == null) {
            Log.m3993d(TAG, "<writeSegmentMaskInfo> maskInfo is null!");
            TraceHelper.endSection();
            return;
        }
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.writeLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<writeSegmentMaskInfo> fileBuffer is null!");
                TraceHelper.endSection();
                return;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                segmentMaskInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            unpack.unpackedJpgBuf = readFileToBuffer;
            IParser parserInstance = ParserFactory.getParserInstance(1, segmentMaskInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap);
            parserInstance.write();
            serialize(unpack, parserInstance);
            packerManager.pack(unpack);
            C1123Utils.writeBufferToFile(str, unpack.packedJpgBuf);
            ReadWriteLockFileUtils.writeUnlock(str);
            TraceHelper.endSection();
        } finally {
            ReadWriteLockFileUtils.writeUnlock(str);
        }
    }

    public void writeRefocusImage(String str, StereoConfigInfo stereoConfigInfo, byte[] bArr) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-writeRefocusImage");
        String str2 = TAG;
        Log.m3993d(str2, "<writeRefocusImage> filePath " + str + ", StereoConfigInfo " + stereoConfigInfo);
        if (stereoConfigInfo == null) {
            Log.m3993d(TAG, "<writeRefocusImage> configInfo is null!");
            TraceHelper.endSection();
            return;
        }
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.writeLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<writeRefocusImage> fileBuffer is null!");
                TraceHelper.endSection();
                return;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                stereoConfigInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            unpack.unpackedJpgBuf = readFileToBuffer;
            IParser parserInstance = ParserFactory.getParserInstance(3, stereoConfigInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap);
            parserInstance.write();
            serialize(unpack, parserInstance);
            unpack.unpackedBlurImageBuf = bArr;
            packerManager.pack(unpack);
            C1123Utils.writeBufferToFile(str, unpack.packedJpgBuf);
            ReadWriteLockFileUtils.writeUnlock(str);
            TraceHelper.endSection();
        } finally {
            ReadWriteLockFileUtils.writeUnlock(str);
        }
    }

    public StereoDepthInfo readStereoDepthInfo(String str) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-readStereoDepthInfo");
        String str2 = TAG;
        Log.m3993d(str2, "<readStereoDepthInfo> filePath " + str);
        StereoDepthInfo stereoDepthInfo = new StereoDepthInfo();
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.readLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<readStereoDepthInfo> fileBuffer is null!");
                TraceHelper.endSection();
                return stereoDepthInfo;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                stereoDepthInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            unpack.unpackedJpgBuf = readFileToBuffer;
            ParserFactory.getParserInstance(4, stereoDepthInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap).read();
            ReadWriteLockFileUtils.readUnlock(str);
            TraceHelper.endSection();
            return stereoDepthInfo;
        } finally {
            ReadWriteLockFileUtils.readUnlock(str);
        }
    }

    public SegmentMaskInfo readSegmentMaskInfo(String str) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-readSegmentMaskInfo");
        String str2 = TAG;
        Log.m3993d(str2, "<readSegmentMaskInfo> filePath " + str);
        SegmentMaskInfo segmentMaskInfo = new SegmentMaskInfo();
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.readLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<readSegmentMaskInfo> fileBuffer is null!");
                TraceHelper.endSection();
                return segmentMaskInfo;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                segmentMaskInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            ParserFactory.getParserInstance(1, segmentMaskInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap).read();
            ReadWriteLockFileUtils.readUnlock(str);
            TraceHelper.endSection();
            return segmentMaskInfo;
        } finally {
            ReadWriteLockFileUtils.readUnlock(str);
        }
    }

    public StereoBufferInfo readStereoBufferInfo(String str) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-readStereoBufferInfo");
        String str2 = TAG;
        Log.m3993d(str2, "<readStereoBufferInfo> filePath " + str);
        StereoBufferInfo stereoBufferInfo = new StereoBufferInfo();
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.readLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<readStereoBufferInfo> fileBuffer is null!");
                TraceHelper.endSection();
                return stereoBufferInfo;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                stereoBufferInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            ParserFactory.getParserInstance(2, stereoBufferInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap).read();
            ReadWriteLockFileUtils.readUnlock(str);
            TraceHelper.endSection();
            return stereoBufferInfo;
        } finally {
            ReadWriteLockFileUtils.readUnlock(str);
        }
    }

    public StereoConfigInfo readStereoConfigInfo(String str) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-readStereoConfigInfo");
        String str2 = TAG;
        Log.m3993d(str2, "<readStereoConfigInfo> filePath " + str);
        StereoConfigInfo stereoConfigInfo = new StereoConfigInfo();
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.readLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<readStereoConfigInfo> fileBuffer is null!");
                TraceHelper.endSection();
                return stereoConfigInfo;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                stereoConfigInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            ParserFactory.getParserInstance(3, stereoConfigInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap).read();
            ReadWriteLockFileUtils.readUnlock(str);
            TraceHelper.endSection();
            return stereoConfigInfo;
        } finally {
            ReadWriteLockFileUtils.readUnlock(str);
        }
    }

    public GoogleStereoInfo readGoogleStereoInfo(String str) {
        TraceHelper.beginSection(">>>>StereoInfoAccessor-readGoogleStereoInfo");
        String str2 = TAG;
        Log.m3993d(str2, "<readGoogleStereoInfo> filePath " + str);
        GoogleStereoInfo googleStereoInfo = new GoogleStereoInfo();
        PackerManager packerManager = new PackerManager();
        try {
            ReadWriteLockFileUtils.readLock(str);
            byte[] readFileToBuffer = C1123Utils.readFileToBuffer(str);
            if (readFileToBuffer == null) {
                Log.m3993d(TAG, "<readGoogleStereoInfo> fileBuffer is null!");
                TraceHelper.endSection();
                return googleStereoInfo;
            }
            String fileNameFromPath = C1123Utils.getFileNameFromPath(str);
            if (fileNameFromPath != null && fileNameFromPath.length() > 0) {
                googleStereoInfo.debugDir = fileNameFromPath;
            }
            PackInfo unpack = packerManager.unpack(readFileToBuffer);
            ParserFactory.getParserInstance(0, googleStereoInfo, unpack.unpackedStandardXmpBuf, unpack.unpackedExtendedXmpBuf, unpack.unpackedCustomizedBufMap).read();
            ReadWriteLockFileUtils.readUnlock(str);
            TraceHelper.endSection();
            return googleStereoInfo;
        } finally {
            ReadWriteLockFileUtils.readUnlock(str);
        }
    }

    public int getGeoVerifyLevel(byte[] bArr) {
        if (bArr != null) {
            return new StereoInfoJsonParser(bArr).getGeoVerifyLevel();
        }
        Log.m3993d(TAG, "<getGeoVerifyLevel> configBuffer is null!!");
        return -1;
    }

    public int getPhoVerifyLevel(byte[] bArr) {
        if (bArr != null) {
            return new StereoInfoJsonParser(bArr).getPhoVerifyLevel();
        }
        Log.m3993d(TAG, "<getPhoVerifyLevel> configBuffer is null!!");
        return -1;
    }

    public int getMtkChaVerifyLevel(byte[] bArr) {
        if (bArr != null) {
            return new StereoInfoJsonParser(bArr).getMtkChaVerifyLevel();
        }
        Log.m3993d(TAG, "<getMtkChaVerifyLevel> configBuffer is null!!");
        return -1;
    }

    private void serialize(PackInfo packInfo, IParser iParser) {
        SerializedInfo serialize = iParser.serialize();
        packInfo.unpackedStandardXmpBuf = serialize.standardXmpBuf;
        packInfo.unpackedExtendedXmpBuf = serialize.extendedXmpBuf;
        packInfo.unpackedCustomizedBufMap = serialize.customizedBufMap;
    }
}
