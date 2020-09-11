package com.mediatek.accessor.parser;

import com.mediatek.accessor.data.SegmentMaskInfo;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.operator.IMetaOperator;
import com.mediatek.accessor.operator.MetaOperatorFactory;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;
import java.util.Map;

public class SegmentMaskInfoParser implements IParser {
    private static final String ATTRIBUTE_MASK_HEIGHT = "SegmentMaskHeight";
    private static final String ATTRIBUTE_MASK_WIDTH = "SegmentMaskWidth";
    private static final String ATTRIBUTE_SEGMENT_BOTTOM = "SegmentBottom";
    private static final String ATTRIBUTE_SEGMENT_LEFT = "SegmentLeft";
    private static final String ATTRIBUTE_SEGMENT_MASK_BUFFER = "JPSMASK";
    private static final String ATTRIBUTE_SEGMENT_RIGHT = "SegmentRight";
    private static final String ATTRIBUTE_SEGMENT_TOP = "SegmentTop";
    private static final String ATTRIBUTE_SEGMENT_X = "SegmentX";
    private static final String ATTRIBUTE_SEGMENT_Y = "SegmentY";
    private static final String NS_STEREO = "http://ns.mediatek.com/segment/";
    private static final String PRIFIX_STEREO = "MSegment";
    private static final String TAG = Log.Tag(SegmentMaskInfoParser.class.getSimpleName());
    private DataItem.DataCollections mCustomizedDataCollections = new DataItem.DataCollections();
    private IMetaOperator mCustomizedMetaOperator;
    private ArrayList<DataItem.BufferItem> mListOfCustDataItem = new ArrayList<>();
    private ArrayList<DataItem.SimpleItem> mListOfSimpleValue = new ArrayList<>();
    private SegmentMaskInfo mSegmentMaskInfo;
    private DataItem.DataCollections mStandardDataCollections = new DataItem.DataCollections();
    private IMetaOperator mStandardMetaOperator;

    public SegmentMaskInfoParser(byte[] bArr, Map<String, byte[]> map, SegmentMaskInfo segmentMaskInfo) {
        this.mStandardDataCollections.dest = 0;
        this.mSegmentMaskInfo = segmentMaskInfo;
        initSimpleValue();
        initCustDataItem();
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
        this.mStandardMetaOperator = MetaOperatorFactory.getOperatorInstance(0, bArr, (Map<String, byte[]>) null);
        try {
            this.mStandardMetaOperator.setData(this.mStandardDataCollections);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        this.mCustomizedDataCollections.listOfCustomDataItem = this.mListOfCustDataItem;
        this.mCustomizedMetaOperator = MetaOperatorFactory.getOperatorInstance(1, (byte[]) null, map);
        try {
            this.mCustomizedMetaOperator.setData(this.mCustomizedDataCollections);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public void read() {
        TraceHelper.beginSection(">>>>SegmentMaskInfoParser-read");
        Log.m3993d(TAG, "<read>");
        if (this.mStandardMetaOperator != null) {
            this.mStandardMetaOperator.read();
        }
        if (this.mCustomizedMetaOperator != null) {
            this.mCustomizedMetaOperator.read();
        }
        if (this.mSegmentMaskInfo == null) {
            Log.m3993d(TAG, "<read> mSegmentMaskInfo is null!");
            TraceHelper.endSection();
            return;
        }
        readSimpleValue();
        readCustDataItem();
        String str = TAG;
        Log.m3993d(str, "<read> " + this.mSegmentMaskInfo);
        dumpValuesAndBuffers("read");
        TraceHelper.endSection();
    }

    public void write() {
        TraceHelper.beginSection(">>>>SegmentMaskInfoParser-write");
        Log.m3993d(TAG, "<write>");
        if (this.mSegmentMaskInfo == null) {
            Log.m3993d(TAG, "<write> mSegmentMaskInfo is null!");
            TraceHelper.endSection();
            return;
        }
        dumpValuesAndBuffers("write");
        writeSimpleValue();
        writeCustDataItem();
        if (this.mStandardMetaOperator != null) {
            this.mStandardMetaOperator.write();
        }
        if (this.mCustomizedMetaOperator != null) {
            this.mCustomizedMetaOperator.write();
        }
        TraceHelper.endSection();
    }

    public SerializedInfo serialize() {
        TraceHelper.beginSection(">>>>SegmentMaskInfoParser-serialize");
        Log.m3993d(TAG, "<serialize>");
        SerializedInfo serializedInfo = new SerializedInfo();
        if (this.mStandardMetaOperator != null) {
            serializedInfo.standardXmpBuf = this.mStandardMetaOperator.serialize().get(SerializedInfo.XMP_KEY);
        }
        if (this.mCustomizedMetaOperator != null) {
            serializedInfo.customizedBufMap = this.mCustomizedMetaOperator.serialize();
        }
        TraceHelper.endSection();
        return serializedInfo;
    }

    private void initSimpleValue() {
        DataItem.SimpleItem simpleValueInstance = getSimpleValueInstance();
        simpleValueInstance.name = ATTRIBUTE_MASK_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance);
        DataItem.SimpleItem simpleValueInstance2 = getSimpleValueInstance();
        simpleValueInstance2.name = ATTRIBUTE_MASK_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance2);
        DataItem.SimpleItem simpleValueInstance3 = getSimpleValueInstance();
        simpleValueInstance3.name = ATTRIBUTE_SEGMENT_X;
        this.mListOfSimpleValue.add(simpleValueInstance3);
        DataItem.SimpleItem simpleValueInstance4 = getSimpleValueInstance();
        simpleValueInstance4.name = ATTRIBUTE_SEGMENT_Y;
        this.mListOfSimpleValue.add(simpleValueInstance4);
        DataItem.SimpleItem simpleValueInstance5 = getSimpleValueInstance();
        simpleValueInstance5.name = ATTRIBUTE_SEGMENT_LEFT;
        this.mListOfSimpleValue.add(simpleValueInstance5);
        DataItem.SimpleItem simpleValueInstance6 = getSimpleValueInstance();
        simpleValueInstance6.name = ATTRIBUTE_SEGMENT_TOP;
        this.mListOfSimpleValue.add(simpleValueInstance6);
        DataItem.SimpleItem simpleValueInstance7 = getSimpleValueInstance();
        simpleValueInstance7.name = ATTRIBUTE_SEGMENT_RIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance7);
        DataItem.SimpleItem simpleValueInstance8 = getSimpleValueInstance();
        simpleValueInstance8.name = ATTRIBUTE_SEGMENT_BOTTOM;
        this.mListOfSimpleValue.add(simpleValueInstance8);
    }

    private void initCustDataItem() {
        DataItem.BufferItem bufferItem = new DataItem.BufferItem();
        bufferItem.name = "JPSMASK";
        this.mListOfCustDataItem.add(bufferItem);
    }

    private void readSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            DataItem.SimpleItem simpleItem = this.mListOfSimpleValue.get(i);
            if (!(simpleItem == null || simpleItem.value == null || simpleItem.value.length() == 0)) {
                if (ATTRIBUTE_MASK_WIDTH.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.maskWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_MASK_HEIGHT.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.maskHeight = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_SEGMENT_X.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.segmentX = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_SEGMENT_Y.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.segmentY = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_SEGMENT_LEFT.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.segmentLeft = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_SEGMENT_TOP.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.segmentTop = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_SEGMENT_RIGHT.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.segmentRight = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_SEGMENT_BOTTOM.equals(simpleItem.name)) {
                    this.mSegmentMaskInfo.segmentBottom = Integer.parseInt(simpleItem.value);
                }
            }
        }
    }

    private void readCustDataItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            DataItem.BufferItem bufferItem = this.mListOfCustDataItem.get(i);
            if (!(bufferItem == null || bufferItem.value == null || !"JPSMASK".equals(bufferItem.name))) {
                this.mSegmentMaskInfo.maskBuffer = bufferItem.value;
            }
        }
    }

    private void writeSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfSimpleValue.get(i) != null) {
                if (ATTRIBUTE_MASK_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.maskWidth);
                } else if (ATTRIBUTE_MASK_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.maskHeight);
                } else if (ATTRIBUTE_SEGMENT_X.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.segmentX);
                } else if (ATTRIBUTE_SEGMENT_Y.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.segmentY);
                } else if (ATTRIBUTE_SEGMENT_LEFT.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.segmentLeft);
                } else if (ATTRIBUTE_SEGMENT_TOP.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.segmentTop);
                } else if (ATTRIBUTE_SEGMENT_RIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.segmentRight);
                } else if (ATTRIBUTE_SEGMENT_BOTTOM.equals(this.mListOfSimpleValue.get(i).name)) {
                    this.mListOfSimpleValue.get(i).value = String.valueOf(this.mSegmentMaskInfo.segmentBottom);
                }
            }
        }
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
    }

    private void writeCustDataItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            if (!(this.mListOfCustDataItem.get(i) == null || !"JPSMASK".equals(this.mListOfCustDataItem.get(i).name) || this.mSegmentMaskInfo.maskBuffer == null)) {
                this.mListOfCustDataItem.get(i).value = this.mSegmentMaskInfo.maskBuffer;
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
            String str2 = C1123Utils.DUMP_FILE_FOLDER + "/" + this.mSegmentMaskInfo.debugDir + "/";
            if (this.mSegmentMaskInfo.maskBuffer != null) {
                C1123Utils.writeBufferToFile(str2 + "SegmentMaskInfo_maskBuffer_" + str + ".raw", this.mSegmentMaskInfo.maskBuffer);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> maskBuffer is null!");
            }
            C1123Utils.writeStringToFile(str2 + "SegmentMaskInfo_" + str + ".txt", this.mSegmentMaskInfo.toString());
        }
    }
}
