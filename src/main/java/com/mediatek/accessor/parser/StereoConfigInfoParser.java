package com.mediatek.accessor.parser;

import com.mediatek.accessor.data.StereoConfigInfo;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.operator.IMetaOperator;
import com.mediatek.accessor.operator.MetaOperatorFactory;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.util.ArrayList;
import java.util.Map;

public class StereoConfigInfoParser implements IParser {
    private static final String ATTRIBUTE_CLEAR_IMAGE_IN_APP1 = "Data";
    private static final String ATTRIBUTE_CLEAR_IMAGE_IN_APP15 = "CLRIMAG";
    private static final String ATTRIBUTE_CONV_OFFSET = "ConvOffset";
    private static final String ATTRIBUTE_CUR_DAC = "CurDac";
    private static final String ATTRIBUTE_DEPTH_ROTATION = "DepthRotation";
    private static final String ATTRIBUTE_DOF_LEVEL = "DOF";
    private static final String ATTRIBUTE_FACE_BOTTOM = "FaceBottom";
    private static final String ATTRIBUTE_FACE_COUNT = "FaceCount";
    private static final String ATTRIBUTE_FACE_FLAG = "IsFace";
    private static final String ATTRIBUTE_FACE_LEFT = "FaceLeft";
    private static final String ATTRIBUTE_FACE_RATIO = "FaceRatio";
    private static final String ATTRIBUTE_FACE_RIGHT = "FaceRight";
    private static final String ATTRIBUTE_FACE_RIP = "FaceRip";
    private static final String ATTRIBUTE_FACE_STRUCT_NAME = "FDInfo";
    private static final String ATTRIBUTE_FACE_TOP = "FaceTop";
    private static final String ATTRIBUTE_FOCUSINFO_BOTTOM = "FocusBottom";
    private static final String ATTRIBUTE_FOCUSINFO_LEFT = "FocusLeft";
    private static final String ATTRIBUTE_FOCUSINFO_RIGHT = "FocusRight";
    private static final String ATTRIBUTE_FOCUSINFO_STRUCT_NAME = "FocusInfo";
    private static final String ATTRIBUTE_FOCUSINFO_TOP = "FocusTop";
    private static final String ATTRIBUTE_FOCUSINFO_TYPE = "FocusType";
    private static final String ATTRIBUTE_JPS_HEIGHT = "JpsHeight";
    private static final String ATTRIBUTE_JPS_WIDTH = "JpsWidth";
    private static final String ATTRIBUTE_LDC_BUFFER_IN_APP1 = "LDC";
    private static final String ATTRIBUTE_LDC_BUFFER_IN_APP15 = "LDCDATA";
    private static final String ATTRIBUTE_LDC_HEIGHT = "LdcHeight";
    private static final String ATTRIBUTE_LDC_WIDTH = "LdcWidth";
    private static final String ATTRIBUTE_MAIN_CAM_POS = "MainCamPos";
    private static final String ATTRIBUTE_MASK_HEIGHT = "MaskHeight";
    private static final String ATTRIBUTE_MASK_WIDTH = "MaskWidth";
    private static final String ATTRIBUTE_MAX_DAC = "MacDac";
    private static final String ATTRIBUTE_MIN_DAC = "MinDac";
    private static final String ATTRIBUTE_ORIENTATION = "Orientation";
    private static final String ATTRIBUTE_POS_X = "PosX";
    private static final String ATTRIBUTE_POS_Y = "PosY";
    private static final String ATTRIBUTE_TOUCH_COORDX_1ST = "TouchCoordX1st";
    private static final String ATTRIBUTE_TOUCH_COORDY_1ST = "TouchCoordY1st";
    private static final String ATTRIBUTE_VIEW_HEIGHT = "ViewHeight";
    private static final String ATTRIBUTE_VIEW_WIDTH = "ViewWidth";
    private static final String NS_FACE_FIELD = "FD";
    private static final String NS_FOCUS_FIELD = "FOC";
    private static final String NS_GIMAGE = "http://ns.google.com/photos/1.0/image/";
    private static final String NS_STEREO = "http://ns.mediatek.com/refocus/jpsconfig/";
    private static final String PRIFIX_FACE = "FD";
    private static final String PRIFIX_FOCUS = "FOC";
    private static final String PRIFIX_GIMAGE = "GImage";
    private static final String PRIFIX_STEREO = "MRefocus";
    private static final int SUPPORT_FACE_COUNT = 3;
    private static final String TAG = Log.Tag(StereoConfigInfoParser.class.getSimpleName());
    private DataItem.DataCollections mCustomizedDataCollections = new DataItem.DataCollections();
    private IMetaOperator mCustomizedMetaOperator;
    private DataItem.DataCollections mExtendardDataCollections = new DataItem.DataCollections();
    private IMetaOperator mExtendedMetaOperator;
    private ArrayList<DataItem.BufferItem> mListOfBufferItem = new ArrayList<>();
    private ArrayList<DataItem.BufferItem> mListOfCustDataItem = new ArrayList<>();
    private ArrayList<DataItem.SimpleItem> mListOfSimpleValue = new ArrayList<>();
    private ArrayList<DataItem.StructItem> mListOfStructItem = new ArrayList<>();
    private DataItem.DataCollections mStandardDataCollections = new DataItem.DataCollections();
    private IMetaOperator mStandardMetaOperator;
    private StereoConfigInfo mStereoConfigInfo;

    public StereoConfigInfoParser(byte[] bArr, byte[] bArr2, Map<String, byte[]> map, StereoConfigInfo stereoConfigInfo) {
        this.mStandardDataCollections.dest = 0;
        this.mExtendardDataCollections.dest = 1;
        this.mStereoConfigInfo = stereoConfigInfo;
        initSimpleValue();
        initBufferItem();
        initStructItem();
        initCustDataItem();
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
        this.mStandardDataCollections.listOfStructItem = this.mListOfStructItem;
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

    public StereoConfigInfoParser(IMetaOperator iMetaOperator, IMetaOperator iMetaOperator2, IMetaOperator iMetaOperator3, StereoConfigInfo stereoConfigInfo) {
        this.mStandardDataCollections.dest = 0;
        this.mExtendardDataCollections.dest = 1;
        this.mStereoConfigInfo = stereoConfigInfo;
        initSimpleValue();
        initBufferItem();
        initStructItem();
        initCustDataItem();
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
        this.mStandardDataCollections.listOfStructItem = this.mListOfStructItem;
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
        TraceHelper.beginSection(">>>>StereoConfigInfoParser-read");
        Log.m3993d(TAG, "<read>");
        if (this.mStandardMetaOperator != null) {
            this.mStandardMetaOperator.read();
        }
        if (this.mCustomizedMetaOperator != null) {
            this.mCustomizedMetaOperator.read();
        }
        if (this.mStereoConfigInfo == null) {
            Log.m3993d(TAG, "<read> mStereoConfigInfo is null!");
            TraceHelper.endSection();
            return;
        }
        readSimpleValue();
        readStructItem();
        readCustDataItem();
        if ((this.mStereoConfigInfo.clearImage == null || this.mStereoConfigInfo.ldcBuffer == null) && this.mExtendedMetaOperator != null) {
            this.mExtendedMetaOperator.read();
            readBufferItem();
        }
        String str = TAG;
        Log.m3993d(str, "<read> " + this.mStereoConfigInfo);
        dumpValuesAndBuffers("read");
        TraceHelper.endSection();
    }

    public void write() {
        TraceHelper.beginSection(">>>>StereoConfigInfoParser-write");
        Log.m3993d(TAG, "<write>");
        if (this.mStereoConfigInfo == null) {
            Log.m3993d(TAG, "<write> mStereoConfigInfo is null!");
            TraceHelper.endSection();
            return;
        }
        dumpValuesAndBuffers("write");
        writeSimpleValue();
        writeStructItem();
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
        TraceHelper.beginSection(">>>>StereoConfigInfoParser-serialize");
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
        simpleValueInstance.name = ATTRIBUTE_JPS_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance);
        DataItem.SimpleItem simpleValueInstance2 = getSimpleValueInstance();
        simpleValueInstance2.name = ATTRIBUTE_JPS_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance2);
        DataItem.SimpleItem simpleValueInstance3 = getSimpleValueInstance();
        simpleValueInstance3.name = ATTRIBUTE_MASK_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance3);
        DataItem.SimpleItem simpleValueInstance4 = getSimpleValueInstance();
        simpleValueInstance4.name = ATTRIBUTE_MASK_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance4);
        DataItem.SimpleItem simpleValueInstance5 = getSimpleValueInstance();
        simpleValueInstance5.name = ATTRIBUTE_POS_X;
        this.mListOfSimpleValue.add(simpleValueInstance5);
        DataItem.SimpleItem simpleValueInstance6 = getSimpleValueInstance();
        simpleValueInstance6.name = ATTRIBUTE_POS_Y;
        this.mListOfSimpleValue.add(simpleValueInstance6);
        DataItem.SimpleItem simpleValueInstance7 = getSimpleValueInstance();
        simpleValueInstance7.name = ATTRIBUTE_VIEW_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance7);
        DataItem.SimpleItem simpleValueInstance8 = getSimpleValueInstance();
        simpleValueInstance8.name = ATTRIBUTE_VIEW_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance8);
        DataItem.SimpleItem simpleValueInstance9 = getSimpleValueInstance();
        simpleValueInstance9.name = "Orientation";
        this.mListOfSimpleValue.add(simpleValueInstance9);
        DataItem.SimpleItem simpleValueInstance10 = getSimpleValueInstance();
        simpleValueInstance10.name = ATTRIBUTE_DEPTH_ROTATION;
        this.mListOfSimpleValue.add(simpleValueInstance10);
        DataItem.SimpleItem simpleValueInstance11 = getSimpleValueInstance();
        simpleValueInstance11.name = ATTRIBUTE_MAIN_CAM_POS;
        this.mListOfSimpleValue.add(simpleValueInstance11);
        DataItem.SimpleItem simpleValueInstance12 = getSimpleValueInstance();
        simpleValueInstance12.name = ATTRIBUTE_TOUCH_COORDX_1ST;
        this.mListOfSimpleValue.add(simpleValueInstance12);
        DataItem.SimpleItem simpleValueInstance13 = getSimpleValueInstance();
        simpleValueInstance13.name = ATTRIBUTE_TOUCH_COORDY_1ST;
        this.mListOfSimpleValue.add(simpleValueInstance13);
        DataItem.SimpleItem simpleValueInstance14 = getSimpleValueInstance();
        simpleValueInstance14.name = ATTRIBUTE_FACE_COUNT;
        this.mListOfSimpleValue.add(simpleValueInstance14);
        DataItem.SimpleItem simpleValueInstance15 = getSimpleValueInstance();
        simpleValueInstance15.name = ATTRIBUTE_DOF_LEVEL;
        this.mListOfSimpleValue.add(simpleValueInstance15);
        DataItem.SimpleItem simpleValueInstance16 = getSimpleValueInstance();
        simpleValueInstance16.name = ATTRIBUTE_LDC_WIDTH;
        this.mListOfSimpleValue.add(simpleValueInstance16);
        DataItem.SimpleItem simpleValueInstance17 = getSimpleValueInstance();
        simpleValueInstance17.name = ATTRIBUTE_LDC_HEIGHT;
        this.mListOfSimpleValue.add(simpleValueInstance17);
        DataItem.SimpleItem simpleValueInstance18 = getSimpleValueInstance();
        simpleValueInstance18.name = ATTRIBUTE_FACE_FLAG;
        this.mListOfSimpleValue.add(simpleValueInstance18);
        DataItem.SimpleItem simpleValueInstance19 = getSimpleValueInstance();
        simpleValueInstance19.name = ATTRIBUTE_FACE_RATIO;
        this.mListOfSimpleValue.add(simpleValueInstance19);
        DataItem.SimpleItem simpleValueInstance20 = getSimpleValueInstance();
        simpleValueInstance20.name = ATTRIBUTE_CUR_DAC;
        this.mListOfSimpleValue.add(simpleValueInstance20);
        DataItem.SimpleItem simpleValueInstance21 = getSimpleValueInstance();
        simpleValueInstance21.name = ATTRIBUTE_MIN_DAC;
        this.mListOfSimpleValue.add(simpleValueInstance21);
        DataItem.SimpleItem simpleValueInstance22 = getSimpleValueInstance();
        simpleValueInstance22.name = ATTRIBUTE_MAX_DAC;
        this.mListOfSimpleValue.add(simpleValueInstance22);
        DataItem.SimpleItem simpleValueInstance23 = getSimpleValueInstance();
        simpleValueInstance23.name = ATTRIBUTE_CONV_OFFSET;
        this.mListOfSimpleValue.add(simpleValueInstance23);
    }

    private void initBufferItem() {
        DataItem.BufferItem bufferItem = getBufferItem();
        bufferItem.nameSpaceItem.nameSpace = NS_STEREO;
        bufferItem.nameSpaceItem.nameSpacePrifix = PRIFIX_STEREO;
        bufferItem.name = ATTRIBUTE_LDC_BUFFER_IN_APP1;
        this.mListOfBufferItem.add(bufferItem);
        DataItem.BufferItem bufferItem2 = getBufferItem();
        bufferItem2.nameSpaceItem.nameSpace = NS_GIMAGE;
        bufferItem2.nameSpaceItem.nameSpacePrifix = PRIFIX_GIMAGE;
        bufferItem2.name = ATTRIBUTE_CLEAR_IMAGE_IN_APP1;
        this.mListOfBufferItem.add(bufferItem2);
    }

    private void initStructItem() {
        for (int i = 0; i < 3; i++) {
            DataItem.StructItem structItemInstance = getStructItemInstance("FD", "FD");
            structItemInstance.structName = ATTRIBUTE_FACE_STRUCT_NAME + i;
            structItemInstance.fieldName = ATTRIBUTE_FACE_LEFT;
            this.mListOfStructItem.add(structItemInstance);
            DataItem.StructItem structItemInstance2 = getStructItemInstance("FD", "FD");
            structItemInstance2.structName = ATTRIBUTE_FACE_STRUCT_NAME + i;
            structItemInstance2.fieldName = ATTRIBUTE_FACE_TOP;
            this.mListOfStructItem.add(structItemInstance2);
            DataItem.StructItem structItemInstance3 = getStructItemInstance("FD", "FD");
            structItemInstance3.structName = ATTRIBUTE_FACE_STRUCT_NAME + i;
            structItemInstance3.fieldName = ATTRIBUTE_FACE_RIGHT;
            this.mListOfStructItem.add(structItemInstance3);
            DataItem.StructItem structItemInstance4 = getStructItemInstance("FD", "FD");
            structItemInstance4.structName = ATTRIBUTE_FACE_STRUCT_NAME + i;
            structItemInstance4.fieldName = ATTRIBUTE_FACE_BOTTOM;
            this.mListOfStructItem.add(structItemInstance4);
            DataItem.StructItem structItemInstance5 = getStructItemInstance("FD", "FD");
            structItemInstance5.structName = ATTRIBUTE_FACE_STRUCT_NAME + i;
            structItemInstance5.fieldName = ATTRIBUTE_FACE_RIP;
            this.mListOfStructItem.add(structItemInstance5);
        }
        DataItem.StructItem structItemInstance6 = getStructItemInstance("FOC", "FOC");
        structItemInstance6.structName = ATTRIBUTE_FOCUSINFO_STRUCT_NAME;
        structItemInstance6.fieldName = ATTRIBUTE_FOCUSINFO_LEFT;
        this.mListOfStructItem.add(structItemInstance6);
        DataItem.StructItem structItemInstance7 = getStructItemInstance("FOC", "FOC");
        structItemInstance7.structName = ATTRIBUTE_FOCUSINFO_STRUCT_NAME;
        structItemInstance7.fieldName = ATTRIBUTE_FOCUSINFO_TOP;
        this.mListOfStructItem.add(structItemInstance7);
        DataItem.StructItem structItemInstance8 = getStructItemInstance("FOC", "FOC");
        structItemInstance8.structName = ATTRIBUTE_FOCUSINFO_STRUCT_NAME;
        structItemInstance8.fieldName = ATTRIBUTE_FOCUSINFO_RIGHT;
        this.mListOfStructItem.add(structItemInstance8);
        DataItem.StructItem structItemInstance9 = getStructItemInstance("FOC", "FOC");
        structItemInstance9.structName = ATTRIBUTE_FOCUSINFO_STRUCT_NAME;
        structItemInstance9.fieldName = ATTRIBUTE_FOCUSINFO_BOTTOM;
        this.mListOfStructItem.add(structItemInstance9);
        DataItem.StructItem structItemInstance10 = getStructItemInstance("FOC", "FOC");
        structItemInstance10.structName = ATTRIBUTE_FOCUSINFO_STRUCT_NAME;
        structItemInstance10.fieldName = ATTRIBUTE_FOCUSINFO_TYPE;
        this.mListOfStructItem.add(structItemInstance10);
    }

    private void initCustDataItem() {
        DataItem.BufferItem bufferItem = new DataItem.BufferItem();
        bufferItem.name = "LDCDATA";
        this.mListOfCustDataItem.add(bufferItem);
        DataItem.BufferItem bufferItem2 = new DataItem.BufferItem();
        bufferItem2.name = "CLRIMAG";
        this.mListOfCustDataItem.add(bufferItem2);
    }

    private void readSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            DataItem.SimpleItem simpleItem = this.mListOfSimpleValue.get(i);
            if (!(simpleItem == null || simpleItem.value == null || simpleItem.value.length() == 0)) {
                if (ATTRIBUTE_JPS_WIDTH.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.jpsWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_JPS_HEIGHT.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.jpsHeight = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_MASK_WIDTH.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.maskWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_MASK_HEIGHT.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.maskHeight = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_POS_X.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.posX = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_POS_Y.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.posY = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_VIEW_WIDTH.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.viewWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_VIEW_HEIGHT.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.viewHeight = Integer.parseInt(simpleItem.value);
                } else if ("Orientation".equals(simpleItem.name)) {
                    this.mStereoConfigInfo.imageOrientation = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_DEPTH_ROTATION.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.depthOrientation = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_MAIN_CAM_POS.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.mainCamPos = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_TOUCH_COORDX_1ST.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.touchCoordX1st = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_TOUCH_COORDY_1ST.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.touchCoordY1st = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_FACE_COUNT.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.faceCount = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_DOF_LEVEL.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.dofLevel = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_CONV_OFFSET.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.convOffset = Float.valueOf(simpleItem.value).floatValue();
                } else if (ATTRIBUTE_LDC_WIDTH.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.ldcWidth = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_LDC_HEIGHT.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.ldcHeight = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_FACE_FLAG.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.isFace = Boolean.valueOf(simpleItem.value).booleanValue();
                } else if (ATTRIBUTE_FACE_RATIO.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.faceRatio = Float.valueOf(simpleItem.value).floatValue();
                } else if (ATTRIBUTE_CUR_DAC.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.curDac = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_MIN_DAC.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.minDac = Integer.parseInt(simpleItem.value);
                } else if (ATTRIBUTE_MAX_DAC.equals(simpleItem.name)) {
                    this.mStereoConfigInfo.maxDac = Integer.parseInt(simpleItem.value);
                }
            }
        }
    }

    private void readBufferItem() {
        Log.m3993d(TAG, "<readBufferItem>");
        int size = this.mListOfBufferItem.size();
        for (int i = 0; i < size; i++) {
            DataItem.BufferItem bufferItem = this.mListOfBufferItem.get(i);
            if (!(bufferItem == null || bufferItem.value == null)) {
                if (ATTRIBUTE_LDC_BUFFER_IN_APP1.equals(bufferItem.name) && this.mStereoConfigInfo.ldcBuffer == null) {
                    this.mStereoConfigInfo.ldcBuffer = bufferItem.value;
                    Log.m3993d(TAG, "<readBufferItem> ldcBuffer get value from APP1.");
                } else if (ATTRIBUTE_CLEAR_IMAGE_IN_APP1.equals(bufferItem.name) && this.mStereoConfigInfo.clearImage == null) {
                    this.mStereoConfigInfo.clearImage = bufferItem.value;
                    Log.m3993d(TAG, "<readBufferItem> clearImage get value from APP1.");
                }
            }
        }
    }

    private void readStructItem() {
        this.mStereoConfigInfo.fdInfoArray = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int size = this.mListOfStructItem.size();
            this.mStereoConfigInfo.fdInfoArray.add(i, new StereoConfigInfo.FaceDetectionInfo());
            for (int i2 = 0; i2 < size; i2++) {
                DataItem.StructItem structItem = this.mListOfStructItem.get(i2);
                if (!(structItem == null || structItem.fieldName == null || structItem.fieldValue == null || structItem.fieldValue.length() == 0)) {
                    if ((ATTRIBUTE_FACE_STRUCT_NAME + i).equals(structItem.structName)) {
                        if (ATTRIBUTE_FACE_LEFT.equals(structItem.fieldName)) {
                            this.mStereoConfigInfo.fdInfoArray.get(i).faceLeft = Integer.parseInt(structItem.fieldValue);
                        } else if (ATTRIBUTE_FACE_TOP.equals(structItem.fieldName)) {
                            this.mStereoConfigInfo.fdInfoArray.get(i).faceTop = Integer.parseInt(structItem.fieldValue);
                        } else if (ATTRIBUTE_FACE_RIGHT.equals(structItem.fieldName)) {
                            this.mStereoConfigInfo.fdInfoArray.get(i).faceRight = Integer.parseInt(structItem.fieldValue);
                        } else if (ATTRIBUTE_FACE_BOTTOM.equals(structItem.fieldName)) {
                            this.mStereoConfigInfo.fdInfoArray.get(i).faceBottom = Integer.parseInt(structItem.fieldValue);
                        } else if (ATTRIBUTE_FACE_RIP.equals(structItem.fieldName)) {
                            this.mStereoConfigInfo.fdInfoArray.get(i).faceRip = Integer.parseInt(structItem.fieldValue);
                        }
                    }
                }
            }
        }
        this.mStereoConfigInfo.focusInfo = new StereoConfigInfo.FocusInfo();
        int size2 = this.mListOfStructItem.size();
        for (int i3 = 0; i3 < size2; i3++) {
            DataItem.StructItem structItem2 = this.mListOfStructItem.get(i3);
            if (!(structItem2 == null || structItem2.fieldName == null || structItem2.fieldValue == null || structItem2.fieldValue.length() == 0 || !ATTRIBUTE_FOCUSINFO_STRUCT_NAME.equals(structItem2.structName))) {
                if (ATTRIBUTE_FOCUSINFO_LEFT.equals(structItem2.fieldName)) {
                    this.mStereoConfigInfo.focusInfo.focusLeft = Integer.parseInt(structItem2.fieldValue);
                } else if (ATTRIBUTE_FOCUSINFO_TOP.equals(structItem2.fieldName)) {
                    this.mStereoConfigInfo.focusInfo.focusTop = Integer.parseInt(structItem2.fieldValue);
                } else if (ATTRIBUTE_FOCUSINFO_RIGHT.equals(structItem2.fieldName)) {
                    this.mStereoConfigInfo.focusInfo.focusRight = Integer.parseInt(structItem2.fieldValue);
                } else if (ATTRIBUTE_FOCUSINFO_BOTTOM.equals(structItem2.fieldName)) {
                    this.mStereoConfigInfo.focusInfo.focusBottom = Integer.parseInt(structItem2.fieldValue);
                } else if (ATTRIBUTE_FOCUSINFO_TYPE.equals(structItem2.fieldName)) {
                    this.mStereoConfigInfo.focusInfo.focusType = Integer.parseInt(structItem2.fieldValue);
                }
            }
        }
    }

    private void readCustDataItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            DataItem.BufferItem bufferItem = this.mListOfCustDataItem.get(i);
            if (!(bufferItem == null || bufferItem.value == null)) {
                if ("CLRIMAG".equals(bufferItem.name)) {
                    this.mStereoConfigInfo.clearImage = bufferItem.value;
                }
                if ("LDCDATA".equals(bufferItem.name)) {
                    this.mStereoConfigInfo.ldcBuffer = bufferItem.value;
                }
            }
        }
    }

    private void writeSimpleValue() {
        int size = this.mListOfSimpleValue.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfSimpleValue.get(i) == null) {
                Log.m3993d(TAG, "mListOfSimpleValue.get(i) is null!");
            } else if (ATTRIBUTE_JPS_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.jpsWidth);
            } else if (ATTRIBUTE_JPS_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.jpsHeight);
            } else if (ATTRIBUTE_MASK_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.maskWidth);
            } else if (ATTRIBUTE_MASK_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.maskHeight);
            } else if (ATTRIBUTE_POS_X.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.posX);
            } else if (ATTRIBUTE_POS_Y.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.posY);
            } else if (ATTRIBUTE_VIEW_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.viewWidth);
            } else if (ATTRIBUTE_VIEW_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.viewHeight);
            } else if ("Orientation".equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.imageOrientation);
            } else if (ATTRIBUTE_DEPTH_ROTATION.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.depthOrientation);
            } else if (ATTRIBUTE_MAIN_CAM_POS.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.mainCamPos);
            } else if (ATTRIBUTE_TOUCH_COORDX_1ST.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.touchCoordX1st);
                String str = TAG;
                Log.m3993d(str, "touchCoordX1st.value " + this.mListOfSimpleValue.get(i).value);
            } else if (ATTRIBUTE_TOUCH_COORDY_1ST.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.touchCoordY1st);
                String str2 = TAG;
                Log.m3993d(str2, "touchCoordY1st.value " + this.mListOfSimpleValue.get(i).value);
            } else if (ATTRIBUTE_FACE_COUNT.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(Math.min(this.mStereoConfigInfo.faceCount, 3));
            } else if (ATTRIBUTE_DOF_LEVEL.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.dofLevel);
            } else if (ATTRIBUTE_CONV_OFFSET.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.convOffset);
            } else if (ATTRIBUTE_LDC_WIDTH.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.ldcWidth);
            } else if (ATTRIBUTE_LDC_HEIGHT.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.ldcHeight);
            } else if (ATTRIBUTE_FACE_FLAG.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.isFace);
            } else if (ATTRIBUTE_FACE_RATIO.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.faceRatio);
            } else if (ATTRIBUTE_CUR_DAC.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.curDac);
            } else if (ATTRIBUTE_MIN_DAC.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.minDac);
            } else if (ATTRIBUTE_MAX_DAC.equals(this.mListOfSimpleValue.get(i).name)) {
                this.mListOfSimpleValue.get(i).value = String.valueOf(this.mStereoConfigInfo.maxDac);
            }
        }
        this.mStandardDataCollections.listOfSimpleValue = this.mListOfSimpleValue;
    }

    private void writeStructItem() {
        if (this.mStereoConfigInfo.fdInfoArray != null) {
            int min = Math.min(this.mStereoConfigInfo.fdInfoArray.size(), 3);
            for (int i = 0; i < min; i++) {
                int size = this.mListOfStructItem.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.mListOfStructItem.get(i2) == null) {
                        Log.m3993d(TAG, "mListOfStructItem.get(j) is null!");
                    } else if (this.mStereoConfigInfo.fdInfoArray.get(i) == null) {
                        Log.m3993d(TAG, "mStereoConfigInfo.fdInfoArray.get(i) is null!");
                    } else {
                        if ((ATTRIBUTE_FACE_STRUCT_NAME + i).equals(this.mListOfStructItem.get(i2).structName)) {
                            if (ATTRIBUTE_FACE_LEFT.equals(this.mListOfStructItem.get(i2).fieldName)) {
                                this.mListOfStructItem.get(i2).fieldValue = String.valueOf(this.mStereoConfigInfo.fdInfoArray.get(i).faceLeft);
                            } else if (ATTRIBUTE_FACE_TOP.equals(this.mListOfStructItem.get(i2).fieldName)) {
                                this.mListOfStructItem.get(i2).fieldValue = String.valueOf(this.mStereoConfigInfo.fdInfoArray.get(i).faceTop);
                            } else if (ATTRIBUTE_FACE_RIGHT.equals(this.mListOfStructItem.get(i2).fieldName)) {
                                this.mListOfStructItem.get(i2).fieldValue = String.valueOf(this.mStereoConfigInfo.fdInfoArray.get(i).faceRight);
                            } else if (ATTRIBUTE_FACE_BOTTOM.equals(this.mListOfStructItem.get(i2).fieldName)) {
                                this.mListOfStructItem.get(i2).fieldValue = String.valueOf(this.mStereoConfigInfo.fdInfoArray.get(i).faceBottom);
                            } else if (ATTRIBUTE_FACE_RIP.equals(this.mListOfStructItem.get(i2).fieldName)) {
                                this.mListOfStructItem.get(i2).fieldValue = String.valueOf(this.mStereoConfigInfo.fdInfoArray.get(i).faceRip);
                            }
                        }
                    }
                }
            }
        }
        if (this.mStereoConfigInfo.focusInfo != null) {
            int size2 = this.mListOfStructItem.size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (this.mListOfStructItem.get(i3) == null) {
                    Log.m3993d(TAG, "mListOfStructItem.get(j) is null!");
                } else if (ATTRIBUTE_FOCUSINFO_STRUCT_NAME.equals(this.mListOfStructItem.get(i3).structName)) {
                    if (ATTRIBUTE_FOCUSINFO_LEFT.equals(this.mListOfStructItem.get(i3).fieldName)) {
                        this.mListOfStructItem.get(i3).fieldValue = String.valueOf(this.mStereoConfigInfo.focusInfo.focusLeft);
                    } else if (ATTRIBUTE_FOCUSINFO_TOP.equals(this.mListOfStructItem.get(i3).fieldName)) {
                        this.mListOfStructItem.get(i3).fieldValue = String.valueOf(this.mStereoConfigInfo.focusInfo.focusTop);
                    } else if (ATTRIBUTE_FOCUSINFO_RIGHT.equals(this.mListOfStructItem.get(i3).fieldName)) {
                        this.mListOfStructItem.get(i3).fieldValue = String.valueOf(this.mStereoConfigInfo.focusInfo.focusRight);
                    } else if (ATTRIBUTE_FOCUSINFO_BOTTOM.equals(this.mListOfStructItem.get(i3).fieldName)) {
                        this.mListOfStructItem.get(i3).fieldValue = String.valueOf(this.mStereoConfigInfo.focusInfo.focusBottom);
                    } else if (ATTRIBUTE_FOCUSINFO_TYPE.equals(this.mListOfStructItem.get(i3).fieldName)) {
                        this.mListOfStructItem.get(i3).fieldValue = String.valueOf(this.mStereoConfigInfo.focusInfo.focusType);
                    }
                }
            }
        }
        this.mStandardDataCollections.listOfStructItem = this.mListOfStructItem;
    }

    private void writeCustDataItem() {
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfCustDataItem.get(i) != null) {
                if ("LDCDATA".equals(this.mListOfCustDataItem.get(i).name) && this.mStereoConfigInfo.ldcBuffer != null) {
                    this.mListOfCustDataItem.get(i).value = this.mStereoConfigInfo.ldcBuffer;
                } else if ("CLRIMAG".equals(this.mListOfCustDataItem.get(i).name) && this.mStereoConfigInfo.clearImage != null) {
                    this.mListOfCustDataItem.get(i).value = this.mStereoConfigInfo.clearImage;
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

    private DataItem.StructItem getStructItemInstance(String str, String str2) {
        DataItem.StructItem structItem = new DataItem.StructItem();
        structItem.dest = 0;
        structItem.structNameSpaceItem = new DataItem.NameSpaceItem();
        structItem.structNameSpaceItem.nameSpace = NS_STEREO;
        structItem.structNameSpaceItem.nameSpacePrifix = PRIFIX_STEREO;
        structItem.fieldNameSpaceItem = new DataItem.NameSpaceItem();
        structItem.fieldNameSpaceItem.nameSpace = str;
        structItem.fieldNameSpaceItem.nameSpacePrifix = str2;
        return structItem;
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
            String str2 = C1123Utils.DUMP_FILE_FOLDER + "/" + this.mStereoConfigInfo.debugDir + "/";
            if (this.mStereoConfigInfo.clearImage != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoConfigInfo_clearImage_" + str + ".raw", this.mStereoConfigInfo.clearImage);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> clearImage is null!");
            }
            if (this.mStereoConfigInfo.ldcBuffer != null) {
                C1123Utils.writeBufferToFile(str2 + "StereoConfigInfo_ldcBuffer_" + str + ".raw", this.mStereoConfigInfo.ldcBuffer);
            } else {
                Log.m3993d(TAG, "<dumpValuesAndBuffers> ldcBuffer is null!");
            }
            C1123Utils.writeStringToFile(str2 + "StereoConfigInfo_" + str + ".txt", this.mStereoConfigInfo.toString());
        }
    }
}
