package com.mediatek.accessor.parser;

import com.mediatek.accessor.data.StereoDepthInfo;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.operator.IMetaOperator;
import com.mediatek.accessor.operator.MetaOperatorFactory;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;
import java.util.Map;

public class StereoDepthInfoParser implements IParser {
    private static final String ATTRIBUTE_DEBUG_BUFFER = "DEBUGBF";
    private static final String ATTRIBUTE_DEPTH_BUFFER = "DEPTHBF";
    private static final String ATTRIBUTE_DEPTH_BUFFER_HEIGHT = "DepthBufferHeight";
    private static final String ATTRIBUTE_DEPTH_BUFFER_WIDTH = "DepthBufferWidth";
    private static final String ATTRIBUTE_DEPTH_MAP = "Data";
    private static final String ATTRIBUTE_DEPTH_MAP_HEIGHT = "XmpDepthHeight";
    private static final String ATTRIBUTE_DEPTH_MAP_WIDTH = "XmpDepthWidth";
    private static final String ATTRIBUTE_DEPTH_OF_FIELD_LAST = "DepthOfFieldLast";
    private static final String ATTRIBUTE_META_BUFFER_HEIGHT = "MetaBufferHeight";
    private static final String ATTRIBUTE_META_BUFFER_WIDTH = "MetaBufferWidth";
    private static final String ATTRIBUTE_TOUCH_COORDX_LAST = "TouchCoordXLast";
    private static final String ATTRIBUTE_TOUCH_COORDY_LAST = "TouchCoordYLast";
    private static final String NS_GDEPTH = "http://ns.google.com/photos/1.0/depthmap/";
    private static final String NS_STEREO = "http://ns.mediatek.com/refocus/jpsconfig/";
    private static final String PRIFIX_GDEPTH = "GDepth";
    private static final String PRIFIX_STEREO = "MRefocus";
    private static final String TAG = Log.Tag(StereoDepthInfoParser.class.getSimpleName());
    private DataItem.DataCollections mCustomizedDataCollections = new DataItem.DataCollections();
    private IMetaOperator mCustomizedMetaOperator;
    private DataItem.DataCollections mExtendardDataCollections = new DataItem.DataCollections();
    private IMetaOperator mExtendedMetaOperator;
    private ArrayList<DataItem.BufferItem> mListOfBufferItem = new ArrayList<>();
    private ArrayList<DataItem.BufferItem> mListOfCustDataItem = new ArrayList<>();
    private ArrayList<DataItem.SimpleItem> mListOfSimpleValue = new ArrayList<>();
    private DataItem.DataCollections mStandardDataCollections = new DataItem.DataCollections();
    private IMetaOperator mStandardMetaOperator;
    private StereoDepthInfo mStereoDepthInfo;

    public StereoDepthInfoParser(byte[] bArr, byte[] bArr2, Map<String, byte[]> map, StereoDepthInfo stereoDepthInfo) {
        this.mStandardDataCollections.dest = 0;
        this.mExtendardDataCollections.dest = 1;
        this.mStereoDepthInfo = stereoDepthInfo;
        initSimpleValue();
        initBufferItem();
        initCustDataItem();
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
        this.mCustomizedDataCollections.listOfCustomDataItem = this.mListOfCustDataItem;
        this.mCustomizedMetaOperator = MetaOperatorFactory.getOperatorInstance(1, (byte[]) null, map);
        try {
            this.mCustomizedMetaOperator.setData(this.mCustomizedDataCollections);
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        }
    }

    public StereoDepthInfoParser(IMetaOperator iMetaOperator, IMetaOperator iMetaOperator2, IMetaOperator iMetaOperator3, StereoDepthInfo stereoDepthInfo) {
        this.mStandardDataCollections.dest = 0;
        this.mExtendardDataCollections.dest = 1;
        this.mStereoDepthInfo = stereoDepthInfo;
        initSimpleValue();
        initBufferItem();
        initCustDataItem();
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
        this.mCustomizedDataCollections.listOfCustomDataItem = this.mListOfCustDataItem;
        this.mCustomizedMetaOperator = iMetaOperator3;
        try {
            this.mCustomizedMetaOperator.setData(this.mCustomizedDataCollections);
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        }
    }

    public void read() {
        TraceHelper.beginSection(">>>>StereoDepthInfoParser-read");
        Log.m3993d(TAG, "<read>");
        if (this.mStandardMetaOperator != null) {
            this.mStandardMetaOperator.read();
        }
        if (this.mExtendedMetaOperator != null) {
            this.mExtendedMetaOperator.read();
        }
        if (this.mCustomizedMetaOperator != null) {
            this.mCustomizedMetaOperator.read();
        }
        if (this.mStereoDepthInfo == null) {
            Log.m3993d(TAG, "<read> mStereoDepthInfo is null!");
            TraceHelper.endSection();
            return;
        }
        readSimpleValue();
        readBufferItem();
        readCustDataItem();
        String str = TAG;
        Log.m3993d(str, "<read> " + this.mStereoDepthInfo);
        dumpValuesAndBuffers("read");
        TraceHelper.endSection();
    }

    public void write() {
        TraceHelper.beginSection(">>>>StereoDepthInfoParser-write");
        Log.m3993d(TAG, "<write>");
        if (this.mStereoDepthInfo == null) {
            Log.m3993d(TAG, "<write> mStereoDepthInfo is null!");
            TraceHelper.endSection();
            return;
        }
        dumpValuesAndBuffers("write");
        writeSimpleValue();
        writeBufferItem();
        writeCustDataItem();
        if (this.mStandardMetaOperator != null) {
            this.mStandardMetaOperator.write();
        }
        if (this.mExtendedMetaOperator != null) {
            this.mExtendedMetaOperator.write();
        }
        if (this.mCustomizedMetaOperator != null) {
            this.mCustomizedMetaOperator.write();
        }
        TraceHelper.endSection();
    }

    public SerializedInfo serialize() {
        TraceHelper.beginSection(">>>>StereoDepthInfoParser-serialize");
        Log.m3993d(TAG, "<serialize>");
        SerializedInfo serializedInfo = new SerializedInfo();
        if (this.mStandardMetaOperator != null) {
            serializedInfo.standardXmpBuf = this.mStandardMetaOperator.serialize().get(SerializedInfo.XMP_KEY);
        }
        if (this.mExtendedMetaOperator != null) {
            serializedInfo.extendedXmpBuf = this.mExtendedMetaOperator.serialize().get(SerializedInfo.XMP_KEY);
        }
        if (this.mCustomizedMetaOperator != null) {
            serializedInfo.customizedBufMap = this.mCustomizedMetaOperator.serialize();
        }
        TraceHelper.endSection();
        return serializedInfo;
    }

    private void initSimpleValue() {
        DataItem.SimpleItem simpleValueInstance = getSimpleValueInstance();
        simpleValueInstance.name = ATTRIBUTE_META_BUFFER_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance);
        DataItem.SimpleItem simpleValueInstance2 = getSimpleValueInstance();
        simpleValueInstance2.name = ATTRIBUTE_META_BUFFER_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance2);
        DataItem.SimpleItem simpleValueInstance3 = getSimpleValueInstance();
        simpleValueInstance3.name = ATTRIBUTE_TOUCH_COORDX_LAST;
        this.mListOfSimpleValue.add(simpleValueInstance3);
        DataItem.SimpleItem simpleValueInstance4 = getSimpleValueInstance();
        simpleValueInstance4.name = ATTRIBUTE_TOUCH_COORDY_LAST;
        this.mListOfSimpleValue.add(simpleValueInstance4);
        DataItem.SimpleItem simpleValueInstance5 = getSimpleValueInstance();
        simpleValueInstance5.name = ATTRIBUTE_DEPTH_OF_FIELD_LAST;
        this.mListOfSimpleValue.add(simpleValueInstance5);
        DataItem.SimpleItem simpleValueInstance6 = getSimpleValueInstance();
        simpleValueInstance6.name = ATTRIBUTE_DEPTH_BUFFER_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance6);
        DataItem.SimpleItem simpleValueInstance7 = getSimpleValueInstance();
        simpleValueInstance7.name = ATTRIBUTE_DEPTH_BUFFER_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance7);
        DataItem.SimpleItem simpleValueInstance8 = getSimpleValueInstance();
        simpleValueInstance8.name = ATTRIBUTE_DEPTH_MAP_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance8);
        DataItem.SimpleItem simpleValueInstance9 = getSimpleValueInstance();
        simpleValueInstance9.name = ATTRIBUTE_DEPTH_MAP_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance9);
    }

    private void initBufferItem() {
        DataItem.BufferItem bufferItem = new DataItem.BufferItem();
        bufferItem.dest = 1;
        bufferItem.nameSpaceItem = new DataItem.NameSpaceItem();
        bufferItem.nameSpaceItem.dest = 1;
        bufferItem.nameSpaceItem.nameSpace = NS_GDEPTH;
        bufferItem.nameSpaceItem.nameSpacePrifix = PRIFIX_GDEPTH;
        bufferItem.name = ATTRIBUTE_DEPTH_MAP;
        this.mListOfBufferItem.add(bufferItem);
    }

    private void initCustDataItem() {
        DataItem.BufferItem bufferItem = new DataItem.BufferItem();
        bufferItem.name = "DEPTHBF";
        this.mListOfCustDataItem.add(bufferItem);
        DataItem.BufferItem bufferItem2 = new DataItem.BufferItem();
        bufferItem2.name = "DEBUGBF";
        this.mListOfCustDataItem.add(bufferItem2);
    }

    private void readSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            DataItem.SimpleItem simpleItem = this.mListOfSimpleValue.get(i);
            if (!(simpleItem == null || simpleItem.value == null || simpleItem.value.length() == 0)) {
                if (ATTRIBUTE_META_BUFFER_WIDTH.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.metaBufferWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_META_BUFFER_HEIGHT.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.metaBufferHeight = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_TOUCH_COORDX_LAST.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.touchCoordXLast = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_TOUCH_COORDY_LAST.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.touchCoordYLast = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_DEPTH_OF_FIELD_LAST.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.depthOfFieldLast = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_DEPTH_BUFFER_WIDTH.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.depthBufferWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_DEPTH_BUFFER_HEIGHT.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.depthBufferHeight = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_DEPTH_MAP_WIDTH.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.depthMapWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_DEPTH_MAP_HEIGHT.equals(simpleItem.name)) {
                    this.mStereoDepthInfo.depthMapHeight = Integer.parseInt(simpleItem.value);
                }
            }
        }
    }

    private void readBufferItem() {
        int size = this.mListOfBufferItem.size();
        for (int i = 0; i < size; i++) {
            DataItem.BufferItem bufferItem = this.mListOfBufferItem.get(i);
            if (!(bufferItem == null || bufferItem.value == null || !ATTRIBUTE_DEPTH_MAP.equals(bufferItem.name))) {
                this.mStereoDepthInfo.depthMap = bufferItem.value;
            }
        }
    }

    private void readCustDataItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            DataItem.BufferItem bufferItem = this.mListOfCustDataItem.get(i);
            if (!(bufferItem == null || bufferItem.value == null)) {
                if ("DEPTHBF".equals(bufferItem.name)) {
                    this.mStereoDepthInfo.depthBuffer = bufferItem.value;
                } else if ("DEBUGBF".equals(bufferItem.name) && C1123Utils.ENABLE_BUFFER_DUMP) {
                    this.mStereoDepthInfo.debugBuffer = bufferItem.value;
                }
            }
        }
    }

    private void writeSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfSimpleValue.get(i) != null) {
                if (ATTRIBUTE_META_BUFFER_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.metaBufferWidth);
                } else if (ATTRIBUTE_META_BUFFER_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.metaBufferHeight);
                } else if (ATTRIBUTE_TOUCH_COORDX_LAST.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.touchCoordXLast);
                } else if (ATTRIBUTE_TOUCH_COORDY_LAST.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.touchCoordYLast);
                } else if (ATTRIBUTE_DEPTH_OF_FIELD_LAST.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.depthOfFieldLast);
                } else if (ATTRIBUTE_DEPTH_BUFFER_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.depthBufferWidth);
                } else if (ATTRIBUTE_DEPTH_BUFFER_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.depthBufferHeight);
                } else if (ATTRIBUTE_DEPTH_MAP_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.depthMapWidth);
                } else if (ATTRIBUTE_DEPTH_MAP_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoDepthInfo.depthMapHeight);
                }
            }
        }
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
    }

    private void writeBufferItem() {
        int size = this.mListOfBufferItem.size();
        for (int i = 0; i < size; i++) {
            if (!(this.mListOfBufferItem.get(i) == null || !ATTRIBUTE_DEPTH_MAP.equals(this.mListOfBufferItem.get(i).name) || this.mStereoDepthInfo.depthMap == null)) {
                this.mListOfBufferItem.get(i).value = this.mStereoDepthInfo.depthMap;
            }
        }
        this.mExtendardDataCollections.listOfBufferItem = this.mListOfBufferItem;
    }

    private void writeCustDataItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfCustDataItem.get(i) != null) {
                if ("DEPTHBF".equals(this.mListOfCustDataItem.get(i).name) && this.mStereoDepthInfo.depthBuffer != null) {
                    this.mListOfCustDataItem.get(i).value = this.mStereoDepthInfo.depthBuffer;
                } else if ("DEBUGBF".equals(this.mListOfCustDataItem.get(i).name) && this.mStereoDepthInfo.debugBuffer != null) {
                    this.mListOfCustDataItem.get(i).value = this.mStereoDepthInfo.debugBuffer;
                }
            }
        }
        this.mCustomizedDataCollections.listOfCustomDataItem = this.mListOfCustDataItem;
    }

    private DataItem.SimpleItem getSimpleValueInstance() {
        DataItem.SimpleItem simpleItem = new DataItem.SimpleItem();
        simpleItem.dest = 0;
        simpleItem.nameSpaceItem = new DataItem.NameSpaceItem();
        simpleItem.nameSpaceItem.dest = 0;
        simpleItem.nameSpaceItem.nameSpace = NS_STEREO;
        simpleItem.nameSpaceItem.nameSpacePrifix = PRIFIX_STEREO;
        return simpleItem;
    }

    private void dumpValuesAndBuffers(String str) {
        if (C1123Utils.ENABLE_BUFFER_DUMP) {
            String str2 = C1123Utils.DUMP_FILE_FOLDER + "/" + this.mStereoDepthInfo.debugDir + "/";
            if (this.mStereoDepthInfo.depthBuffer != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoDepthInfo_depthBuffer_" + str + ".raw", this.mStereoDepthInfo.depthBuffer);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> depthBuffer is null!");
            }
            if (this.mStereoDepthInfo.depthMap != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoDepthInfo_depthMap_" + str + ".raw", this.mStereoDepthInfo.depthMap);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> depthMap is null!");
            }
            if (this.mStereoDepthInfo.debugBuffer != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoDepthInfo_debugBuffer_" + str + ".raw", this.mStereoDepthInfo.debugBuffer);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> debugBuffer is null!");
            }
            C1123Utils.writeStringToFile(str2 + "StereoDepthInfo_" + str + ".txt", this.mStereoDepthInfo.toString());
        }
    }
}
