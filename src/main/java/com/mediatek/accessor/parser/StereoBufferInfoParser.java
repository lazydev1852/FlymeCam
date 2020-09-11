package com.mediatek.accessor.parser;

import com.mediatek.accessor.data.StereoBufferInfo;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.operator.IMetaOperator;
import com.mediatek.accessor.operator.MetaOperatorFactory;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;
import java.util.Map;

public class StereoBufferInfoParser implements IParser {
    private static final String ATTRIBUTE_JPS_BUFFER = "JPSDATA";
    private static final String ATTRIBUTE_SEGMENT_MASK_BUFFER = "JPSMASK";
    private static final String TAG = Log.Tag(StereoBufferInfoParser.class.getSimpleName());
    private DataItem.DataCollections mCustomizedDataCollections = new DataItem.DataCollections();
    private IMetaOperator mCustomizedMetaOperator;
    private ArrayList<DataItem.BufferItem> mListOfCustDataItem = new ArrayList<>();
    private StereoBufferInfo mStereoBufferInfo;

    public StereoBufferInfoParser(Map<String, byte[]> map, StereoBufferInfo stereoBufferInfo) {
        this.mStereoBufferInfo = stereoBufferInfo;
        initCustDataItem();
        this.mCustomizedDataCollections.listOfCustomDataItem = this.mListOfCustDataItem;
        this.mCustomizedMetaOperator = MetaOperatorFactory.getOperatorInstance(1, (byte[]) null, map);
        try {
            this.mCustomizedMetaOperator.setData(this.mCustomizedDataCollections);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public StereoBufferInfoParser(IMetaOperator iMetaOperator, StereoBufferInfo stereoBufferInfo) {
        this.mStereoBufferInfo = stereoBufferInfo;
        initCustDataItem();
        this.mCustomizedDataCollections.listOfCustomDataItem = this.mListOfCustDataItem;
        this.mCustomizedMetaOperator = iMetaOperator;
        try {
            this.mCustomizedMetaOperator.setData(this.mCustomizedDataCollections);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        TraceHelper.beginSection(">>>>StereoBufferInfoParser-read");
        Log.m3993d(TAG, "<read>");
        if (this.mCustomizedMetaOperator != null) {
            this.mCustomizedMetaOperator.read();
        }
        if (this.mStereoBufferInfo == null) {
            Log.m3993d(TAG, "<read> mStereoBufferInfo is null!");
            TraceHelper.endSection();
            return;
        }
        readBufferItem();
        String str = TAG;
        Log.m3993d(str, "<read> " + this.mStereoBufferInfo);
        dumpValuesAndBuffers("read");
        TraceHelper.endSection();
    }

    public void write() {
        TraceHelper.beginSection(">>>>StereoBufferInfoParser-write");
        Log.m3993d(TAG, "<write>");
        if (this.mStereoBufferInfo == null) {
            Log.m3993d(TAG, "<write> mStereoBufferInfo is null!");
            TraceHelper.endSection();
            return;
        }
        dumpValuesAndBuffers("write");
        writeCustDataItem();
        if (this.mCustomizedMetaOperator != null) {
            this.mCustomizedMetaOperator.write();
        }
        TraceHelper.endSection();
    }

    public SerializedInfo serialize() {
        TraceHelper.beginSection(">>>>StereoBufferInfoParser-serialize");
        Log.m3993d(TAG, "<serialize>");
        SerializedInfo serializedInfo = new SerializedInfo();
        if (this.mCustomizedMetaOperator != null) {
            serializedInfo.customizedBufMap = this.mCustomizedMetaOperator.serialize();
        }
        TraceHelper.endSection();
        return serializedInfo;
    }

    private void initCustDataItem() {
        DataItem.BufferItem bufferItem = new DataItem.BufferItem();
        bufferItem.name = "JPSDATA";
        this.mListOfCustDataItem.add(bufferItem);
        DataItem.BufferItem bufferItem2 = new DataItem.BufferItem();
        bufferItem2.name = "JPSMASK";
        this.mListOfCustDataItem.add(bufferItem2);
    }

    private void readBufferItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            DataItem.BufferItem bufferItem = this.mListOfCustDataItem.get(i);
            if (!(bufferItem == null || bufferItem.value == null)) {
                if ("JPSDATA".equals(bufferItem.name)) {
                    this.mStereoBufferInfo.jpsBuffer = bufferItem.value;
                } else if ("JPSMASK".equals(bufferItem.name)) {
                    this.mStereoBufferInfo.maskBuffer = bufferItem.value;
                }
            }
        }
    }

    private void writeCustDataItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfCustDataItem.get(i) != null) {
                if ("JPSDATA".equals(this.mListOfCustDataItem.get(i).name) && this.mStereoBufferInfo.jpsBuffer != null) {
                    this.mListOfCustDataItem.get(i).value = this.mStereoBufferInfo.jpsBuffer;
                } else if ("JPSMASK".equals(this.mListOfCustDataItem.get(i).name) && this.mStereoBufferInfo.maskBuffer != null) {
                    this.mListOfCustDataItem.get(i).value = this.mStereoBufferInfo.maskBuffer;
                }
            }
        }
        this.mCustomizedDataCollections.listOfCustomDataItem = this.mListOfCustDataItem;
    }

    private void dumpValuesAndBuffers(String str) {
        if (C1123Utils.ENABLE_BUFFER_DUMP) {
            String str2 = C1123Utils.DUMP_FILE_FOLDER + "/" + this.mStereoBufferInfo.debugDir + "/";
            if (this.mStereoBufferInfo.maskBuffer != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoBufferInfo_maskBuffer_" + str + ".raw", this.mStereoBufferInfo.maskBuffer);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> maskBuffer is null!");
            }
            if (this.mStereoBufferInfo.jpsBuffer != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoBufferInfo_jpsBuffer_" + str + ".raw", this.mStereoBufferInfo.jpsBuffer);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> jpsBuffer is null!");
            }
            C1123Utils.writeStringToFile(str2 + "StereoBufferInfo_" + str + ".txt", this.mStereoBufferInfo.toString());
        }
    }
}
