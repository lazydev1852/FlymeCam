package com.mediatek.accessor.parser;

import com.mediatek.accessor.data.GoogleStereoInfo;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.operator.IMetaOperator;
import com.mediatek.accessor.operator.MetaOperatorFactory;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;
import java.util.Map;

public class GoogleStereoInfoParser implements IParser {
    private static final String ATTRIBUTE_CLEAR_IMAGE = "Data";
    private static final String ATTRIBUTE_DEPTH_MAP = "Data";
    private static final String ATTRIBUTE_GDEPTH_FAR = "Far";
    private static final String ATTRIBUTE_GDEPTH_FORMAT = "Format";
    private static final String ATTRIBUTE_GDEPTH_MIME = "Mime";
    private static final String ATTRIBUTE_GDEPTH_NEAR = "Near";
    private static final String ATTRIBUTE_GFOCUS_BLUR_INFINITY = "BlurAtInfinity";
    private static final String ATTRIBUTE_GFOCUS_FOCALDISTANCE = "FocalDistance";
    private static final String ATTRIBUTE_GFOCUS_FOCALPOINTX = "FocalPointX";
    private static final String ATTRIBUTE_GFOCUS_FOCALPOINTY = "FocalPointY";
    private static final String ATTRIBUTE_GIMAGE_MIME = "Mime";
    private static final String NS_GDEPTH = "http://ns.google.com/photos/1.0/depthmap/";
    private static final String NS_GFOCUS = "http://ns.google.com/photos/1.0/focus/";
    private static final String NS_GIMAGE = "http://ns.google.com/photos/1.0/image/";
    private static final String PRIFIX_GDEPTH = "GDepth";
    private static final String PRIFIX_GFOCUS = "GFocus";
    private static final String PRIFIX_GIMAGE = "GImage";
    private static final String TAG = Log.Tag(GoogleStereoInfoParser.class.getSimpleName());
    private DataItem.DataCollections mExtendardDataCollections = new DataItem.DataCollections();
    private IMetaOperator mExtendedMetaOperator;
    private GoogleStereoInfo mGoogleStereoInfo;
    private ArrayList<DataItem.BufferItem> mListOfBufferItem = new ArrayList<>();
    private ArrayList<DataItem.SimpleItem> mListOfSimpleValue = new ArrayList<>();
    private DataItem.DataCollections mStandardDataCollections = new DataItem.DataCollections();
    private IMetaOperator mStandardMetaOperator;

    public GoogleStereoInfoParser(byte[] bArr, byte[] bArr2, GoogleStereoInfo googleStereoInfo) {
        this.mStandardDataCollections.dest = 0;
        this.mExtendardDataCollections.dest = 1;
        this.mGoogleStereoInfo = googleStereoInfo;
        initSimpleValue();
        initBufferItem();
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
        this.mStandardMetaOperator = MetaOperatorFactory.getOperatorInstance(0, bArr, (Map<String, byte[]>) null);
        try {
            this.mStandardMetaOperator.setData(this.mStandardDataCollections);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        this.mExtendardDataCollections.listOfBufferItem = this.mListOfBufferItem;
        this.mExtendedMetaOperator = MetaOperatorFactory.getOperatorInstance(0, bArr2, (Map<String, byte[]>) null);
        try {
            this.mExtendedMetaOperator.setData(this.mExtendardDataCollections);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public GoogleStereoInfoParser(IMetaOperator iMetaOperator, IMetaOperator iMetaOperator2, GoogleStereoInfo googleStereoInfo) {
        this.mStandardDataCollections.dest = 0;
        this.mExtendardDataCollections.dest = 1;
        this.mGoogleStereoInfo = googleStereoInfo;
        initSimpleValue();
        initBufferItem();
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
        this.mStandardMetaOperator = iMetaOperator;
        try {
            this.mStandardMetaOperator.setData(this.mStandardDataCollections);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        this.mExtendardDataCollections.listOfBufferItem = this.mListOfBufferItem;
        this.mExtendedMetaOperator = iMetaOperator2;
        try {
            this.mExtendedMetaOperator.setData(this.mExtendardDataCollections);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public void read() {
        TraceHelper.beginSection(">>>>GoogleStereoInfoParser-read");
        Log.m3993d(TAG, "<read>");
        if (this.mStandardMetaOperator != null) {
            this.mStandardMetaOperator.read();
        }
        if (this.mExtendedMetaOperator != null) {
            this.mExtendedMetaOperator.read();
        }
        if (this.mGoogleStereoInfo == null) {
            Log.m3993d(TAG, "<read> mGoogleStereoInfo is null!");
            TraceHelper.endSection();
            return;
        }
        readSimpleValue();
        readBufferItem();
        String str = TAG;
        Log.m3993d(str, "<read> " + this.mGoogleStereoInfo);
        dumpValuesAndBuffers("read");
        TraceHelper.endSection();
    }

    public void write() {
        TraceHelper.beginSection(">>>>GoogleStereoInfoParser-write");
        Log.m3993d(TAG, "<write>");
        if (this.mGoogleStereoInfo == null) {
            Log.m3993d(TAG, "<write> mGoogleStereoInfo is null!");
            TraceHelper.endSection();
            return;
        }
        dumpValuesAndBuffers("write");
        writeSimpleValue();
        writeBufferItem();
        if (this.mStandardMetaOperator != null) {
            this.mStandardMetaOperator.write();
        }
        if (this.mExtendedMetaOperator != null) {
            this.mExtendedMetaOperator.write();
        }
        TraceHelper.endSection();
    }

    public SerializedInfo serialize() {
        TraceHelper.beginSection(">>>>GoogleStereoInfoParser-serialize");
        Log.m3993d(TAG, "<serialize>");
        SerializedInfo serializedInfo = new SerializedInfo();
        if (this.mStandardMetaOperator != null) {
            serializedInfo.standardXmpBuf = this.mStandardMetaOperator.serialize().get(SerializedInfo.XMP_KEY);
        }
        if (this.mExtendedMetaOperator != null) {
            serializedInfo.extendedXmpBuf = this.mExtendedMetaOperator.serialize().get(SerializedInfo.XMP_KEY);
        }
        TraceHelper.endSection();
        return serializedInfo;
    }

    private void initSimpleValue() {
        DataItem.SimpleItem simpleValueInstance = getSimpleValueInstance();
        simpleValueInstance.name = ATTRIBUTE_GFOCUS_BLUR_INFINITY;
        simpleValueInstance.nameSpaceItem.nameSpace = NS_GFOCUS;
        simpleValueInstance.nameSpaceItem.nameSpacePrifix = PRIFIX_GFOCUS;
        this.mListOfSimpleValue.add(simpleValueInstance);
        DataItem.SimpleItem simpleValueInstance2 = getSimpleValueInstance();
        simpleValueInstance2.name = ATTRIBUTE_GFOCUS_FOCALDISTANCE;
        simpleValueInstance2.nameSpaceItem.nameSpace = NS_GFOCUS;
        simpleValueInstance2.nameSpaceItem.nameSpacePrifix = PRIFIX_GFOCUS;
        this.mListOfSimpleValue.add(simpleValueInstance2);
        DataItem.SimpleItem simpleValueInstance3 = getSimpleValueInstance();
        simpleValueInstance3.name = ATTRIBUTE_GFOCUS_FOCALPOINTX;
        simpleValueInstance3.nameSpaceItem.nameSpace = NS_GFOCUS;
        simpleValueInstance3.nameSpaceItem.nameSpacePrifix = PRIFIX_GFOCUS;
        this.mListOfSimpleValue.add(simpleValueInstance3);
        DataItem.SimpleItem simpleValueInstance4 = getSimpleValueInstance();
        simpleValueInstance4.name = ATTRIBUTE_GFOCUS_FOCALPOINTY;
        simpleValueInstance4.nameSpaceItem.nameSpace = NS_GFOCUS;
        simpleValueInstance4.nameSpaceItem.nameSpacePrifix = PRIFIX_GFOCUS;
        this.mListOfSimpleValue.add(simpleValueInstance4);
        DataItem.SimpleItem simpleValueInstance5 = getSimpleValueInstance();
        simpleValueInstance5.name = "Mime";
        simpleValueInstance5.nameSpaceItem.nameSpace = NS_GIMAGE;
        simpleValueInstance5.nameSpaceItem.nameSpacePrifix = PRIFIX_GIMAGE;
        this.mListOfSimpleValue.add(simpleValueInstance5);
        DataItem.SimpleItem simpleValueInstance6 = getSimpleValueInstance();
        simpleValueInstance6.name = ATTRIBUTE_GDEPTH_FORMAT;
        simpleValueInstance6.nameSpaceItem.nameSpace = NS_GDEPTH;
        simpleValueInstance6.nameSpaceItem.nameSpacePrifix = PRIFIX_GDEPTH;
        this.mListOfSimpleValue.add(simpleValueInstance6);
        DataItem.SimpleItem simpleValueInstance7 = getSimpleValueInstance();
        simpleValueInstance7.name = ATTRIBUTE_GDEPTH_NEAR;
        simpleValueInstance7.nameSpaceItem.nameSpace = NS_GDEPTH;
        simpleValueInstance7.nameSpaceItem.nameSpacePrifix = PRIFIX_GDEPTH;
        this.mListOfSimpleValue.add(simpleValueInstance7);
        DataItem.SimpleItem simpleValueInstance8 = getSimpleValueInstance();
        simpleValueInstance8.name = ATTRIBUTE_GDEPTH_FAR;
        simpleValueInstance8.nameSpaceItem.nameSpace = NS_GDEPTH;
        simpleValueInstance8.nameSpaceItem.nameSpacePrifix = PRIFIX_GDEPTH;
        this.mListOfSimpleValue.add(simpleValueInstance8);
        DataItem.SimpleItem simpleValueInstance9 = getSimpleValueInstance();
        simpleValueInstance9.name = "Mime";
        simpleValueInstance9.nameSpaceItem.nameSpace = NS_GDEPTH;
        simpleValueInstance9.nameSpaceItem.nameSpacePrifix = PRIFIX_GDEPTH;
        this.mListOfSimpleValue.add(simpleValueInstance9);
    }

    private void initBufferItem() {
        DataItem.BufferItem bufferItem = getBufferItem();
        bufferItem.nameSpaceItem.nameSpace = NS_GIMAGE;
        bufferItem.nameSpaceItem.nameSpacePrifix = PRIFIX_GIMAGE;
        bufferItem.name = "Data";
        this.mListOfBufferItem.add(bufferItem);
        DataItem.BufferItem bufferItem2 = getBufferItem();
        bufferItem2.nameSpaceItem.nameSpace = NS_GDEPTH;
        bufferItem2.nameSpaceItem.nameSpacePrifix = PRIFIX_GDEPTH;
        bufferItem2.name = "Data";
        this.mListOfBufferItem.add(bufferItem2);
    }

    private void readSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            DataItem.SimpleItem simpleItem = this.mListOfSimpleValue.get(i);
            if (!(simpleItem == null || simpleItem.value == null || simpleItem.value.length() == 0)) {
                if (ATTRIBUTE_GFOCUS_BLUR_INFINITY.equals(simpleItem.name)) {
                    this.mGoogleStereoInfo.focusBlurAtInfinity = Double.parseDouble(simpleItem.value);
                } else if (ATTRIBUTE_GFOCUS_FOCALDISTANCE.equals(simpleItem.name)) {
                    this.mGoogleStereoInfo.focusFocalDistance = Double.parseDouble(simpleItem.value);
                } else if (ATTRIBUTE_GFOCUS_FOCALPOINTX.equals(simpleItem.name)) {
                    this.mGoogleStereoInfo.focusFocalPointX = Double.parseDouble(simpleItem.value);
                } else if (ATTRIBUTE_GFOCUS_FOCALPOINTY.equals(simpleItem.name)) {
                    this.mGoogleStereoInfo.focusFocalPointY = Double.parseDouble(simpleItem.value);
                } else if ("Mime".equals(simpleItem.name) && PRIFIX_GIMAGE.equals(simpleItem.nameSpaceItem.nameSpacePrifix)) {
                    this.mGoogleStereoInfo.imageMime = simpleItem.value;
                } else if (ATTRIBUTE_GDEPTH_FORMAT.equals(simpleItem.name)) {
                    this.mGoogleStereoInfo.depthFormat = simpleItem.value;
                } else if (ATTRIBUTE_GDEPTH_NEAR.equals(simpleItem.name)) {
                    this.mGoogleStereoInfo.depthNear = Double.parseDouble(simpleItem.value);
                } else if (ATTRIBUTE_GDEPTH_FAR.equals(simpleItem.name)) {
                    this.mGoogleStereoInfo.depthFar = Double.parseDouble(simpleItem.value);
                } else if ("Mime".equals(simpleItem.name) && PRIFIX_GDEPTH.equals(simpleItem.nameSpaceItem.nameSpacePrifix)) {
                    this.mGoogleStereoInfo.depthMime = simpleItem.value;
                }
            }
        }
    }

    private void readBufferItem() {
        int size = this.mListOfBufferItem.size();
        for (int i = 0; i < size; i++) {
            DataItem.BufferItem bufferItem = this.mListOfBufferItem.get(i);
            if (!(bufferItem == null || bufferItem.value == null)) {
                if ("Data".equals(bufferItem.name) && PRIFIX_GIMAGE.equals(bufferItem.nameSpaceItem.nameSpacePrifix)) {
                    this.mGoogleStereoInfo.clearImage = bufferItem.value;
                }
                if ("Data".equals(bufferItem.name) && PRIFIX_GDEPTH.equals(bufferItem.nameSpaceItem.nameSpacePrifix)) {
                    this.mGoogleStereoInfo.depthMap = bufferItem.value;
                }
            }
        }
    }

    private void writeSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfSimpleValue.get(i) != null) {
                if (ATTRIBUTE_GFOCUS_BLUR_INFINITY.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.focusBlurAtInfinity);
                } else if (ATTRIBUTE_GFOCUS_FOCALDISTANCE.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.focusFocalDistance);
                } else if (ATTRIBUTE_GFOCUS_FOCALPOINTX.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.focusFocalPointX);
                } else if (ATTRIBUTE_GFOCUS_FOCALPOINTY.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.focusFocalPointY);
                } else if ("Mime".equals(this.mListOfSimpleValue.get(i).name) && PRIFIX_GIMAGE.equals(this.mListOfSimpleValue.get(i).nameSpaceItem.nameSpacePrifix)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.imageMime);
                } else if (ATTRIBUTE_GDEPTH_FORMAT.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.depthFormat);
                } else if (ATTRIBUTE_GDEPTH_NEAR.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.depthNear);
                } else if (ATTRIBUTE_GDEPTH_FAR.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.depthFar);
                } else if ("Mime".equals(this.mListOfSimpleValue.get(i).name) && PRIFIX_GDEPTH.equals(this.mListOfSimpleValue.get(i).nameSpaceItem.nameSpacePrifix)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mGoogleStereoInfo.depthMime);
                }
            }
        }
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
    }

    private void writeBufferItem() {
        int size = this.mListOfBufferItem.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfBufferItem.get(i) != null) {
                if ("Data".equals(this.mListOfBufferItem.get(i).name) && this.mGoogleStereoInfo.clearImage != null && PRIFIX_GIMAGE.equals(this.mListOfBufferItem.get(i).nameSpaceItem.nameSpacePrifix)) {
                    this.mListOfBufferItem.get(i).value = this.mGoogleStereoInfo.clearImage;
                }
                if ("Data".equals(this.mListOfBufferItem.get(i).name) && this.mGoogleStereoInfo.depthMap != null && PRIFIX_GDEPTH.equals(this.mListOfBufferItem.get(i).nameSpaceItem.nameSpacePrifix)) {
                    this.mListOfBufferItem.get(i).value = this.mGoogleStereoInfo.depthMap;
                }
            }
        }
        this.mExtendardDataCollections.listOfBufferItem = this.mListOfBufferItem;
    }

    private DataItem.SimpleItem getSimpleValueInstance() {
        DataItem.SimpleItem simpleItem = new DataItem.SimpleItem();
        simpleItem.dest = 0;
        simpleItem.nameSpaceItem = new DataItem.NameSpaceItem();
        simpleItem.nameSpaceItem.dest = 0;
        return simpleItem;
    }

    private DataItem.BufferItem getBufferItem() {
        DataItem.BufferItem bufferItem = new DataItem.BufferItem();
        bufferItem.dest = 1;
        bufferItem.nameSpaceItem = new DataItem.NameSpaceItem();
        bufferItem.nameSpaceItem.dest = 1;
        return bufferItem;
    }

    private void dumpValuesAndBuffers(String str) {
        if (C1123Utils.ENABLE_BUFFER_DUMP) {
            String str2 = C1123Utils.DUMP_FILE_FOLDER + "/" + this.mGoogleStereoInfo.debugDir + "/";
            if (this.mGoogleStereoInfo.clearImage != null) {
                C1123Utils.writeBufferToFile(str2 + "GoogleStereoInfo_clearImage_" + str + ".raw", this.mGoogleStereoInfo.clearImage);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> clearImage is null!");
            }
            if (this.mGoogleStereoInfo.depthMap != null) {
                C1123Utils.writeBufferToFile(str2 + "GoogleStereoInfo_depthMap_" + str + ".raw", this.mGoogleStereoInfo.depthMap);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> depthMap is null!");
            }
            C1123Utils.writeStringToFile(str2 + "GoogleStereoInfo_" + str + ".txt", this.mGoogleStereoInfo.toString());
        }
    }
}
