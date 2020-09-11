package com.mediatek.accessor.operator;

import com.mediatek.accessor.meta.XmpMeta;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.util.Log;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPMetaFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XmpMetaOperator implements IMetaOperator {
    private static final String TAG = Log.Tag(XmpMetaOperator.class.getSimpleName());
    private static final String XMP_KEY = "XMP";
    private int mDest;
    private ArrayList<DataItem.ArrayItem> mListOfArrayItem = new ArrayList<>();
    private ArrayList<DataItem.BufferItem> mListOfBufferItem = new ArrayList<>();
    private ArrayList<DataItem.SimpleItem> mListOfSimpleValue = new ArrayList<>();
    private ArrayList<DataItem.StructItem> mListOfStructItem = new ArrayList<>();
    private XmpMeta mMeta = new XmpMeta();

    public void decrypt() {
    }

    public void encrypt() {
    }

    public XmpMetaOperator(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    this.mMeta.setMeta(XMPMetaFactory.m365a(bArr));
                    this.mMeta.setRegistry(XMPMetaFactory.m367a());
                }
            } catch (XMPException e) {
                Log.m3996e(TAG, "<XmpMetaOperator> XMPException ", e);
                this.mMeta = null;
                return;
            }
        }
        this.mMeta.setMeta(XMPMetaFactory.m370b());
        this.mMeta.setRegistry(XMPMetaFactory.m367a());
    }

    public void read() {
        Log.m3993d(TAG, "<read>");
        if (this.mListOfSimpleValue != null) {
            int size = this.mListOfSimpleValue.size();
            for (int i = 0; i < size; i++) {
                DataItem.SimpleItem simpleItem = this.mListOfSimpleValue.get(i);
                if (simpleItem.dest == this.mDest) {
                    simpleItem.value = this.mMeta.getPropertyString(simpleItem.nameSpaceItem.nameSpace, simpleItem.name);
                    String str = TAG;
                    Log.m3993d(str, "<read> after simpleValue.nameSpaceItem.nameSpace " + simpleItem.nameSpaceItem.nameSpace + ", simpleValue.name " + simpleItem.name + ", simpleValue.value " + simpleItem.value);
                    this.mListOfSimpleValue.set(i, simpleItem);
                }
            }
        }
        if (this.mListOfBufferItem != null) {
            int size2 = this.mListOfBufferItem.size();
            for (int i2 = 0; i2 < size2; i2++) {
                DataItem.BufferItem bufferItem = this.mListOfBufferItem.get(i2);
                if (bufferItem.dest == this.mDest) {
                    bufferItem.value = this.mMeta.getPropertyBase64(bufferItem.nameSpaceItem.nameSpace, bufferItem.name);
                    this.mListOfBufferItem.set(i2, bufferItem);
                }
            }
        }
        if (this.mListOfArrayItem != null) {
            int size3 = this.mListOfArrayItem.size();
            for (int i3 = 0; i3 < size3; i3++) {
                DataItem.ArrayItem arrayItem = this.mListOfArrayItem.get(i3);
                if (arrayItem.dest == this.mDest) {
                    arrayItem.value = this.mMeta.getArrayItem(arrayItem.nameSpaceItem.nameSpace, arrayItem.arrayName, i3);
                    this.mListOfArrayItem.set(i3, arrayItem);
                }
            }
        }
        if (this.mListOfStructItem != null) {
            int size4 = this.mListOfStructItem.size();
            for (int i4 = 0; i4 < size4; i4++) {
                DataItem.StructItem structItem = this.mListOfStructItem.get(i4);
                if (structItem.dest == this.mDest) {
                    this.mMeta.registerNamespace(structItem.structNameSpaceItem.nameSpace, structItem.structNameSpaceItem.nameSpacePrifix);
                    this.mMeta.registerNamespace(structItem.fieldNameSpaceItem.nameSpace, structItem.fieldNameSpaceItem.nameSpacePrifix);
                    structItem.fieldValue = String.valueOf(this.mMeta.getStructField(structItem.structNameSpaceItem.nameSpace, structItem.structName, structItem.fieldNameSpaceItem.nameSpace, structItem.fieldName));
                    this.mListOfStructItem.set(i4, structItem);
                }
            }
        }
    }

    public void write() {
        Log.m3993d(TAG, "<write>");
        if (this.mListOfSimpleValue != null) {
            int size = this.mListOfSimpleValue.size();
            for (int i = 0; i < size; i++) {
                DataItem.SimpleItem simpleItem = this.mListOfSimpleValue.get(i);
                if (simpleItem.dest == this.mDest && simpleItem.value != null) {
                    this.mMeta.registerNamespace(simpleItem.nameSpaceItem.nameSpace, simpleItem.nameSpaceItem.nameSpacePrifix);
                    this.mMeta.setPropertyString(simpleItem.nameSpaceItem.nameSpace, simpleItem.name, simpleItem.value);
                }
            }
        }
        if (this.mListOfBufferItem != null) {
            int size2 = this.mListOfBufferItem.size();
            new DataItem.BufferItem();
            for (int i2 = 0; i2 < size2; i2++) {
                DataItem.BufferItem bufferItem = this.mListOfBufferItem.get(i2);
                if (bufferItem.dest == this.mDest && bufferItem.value != null) {
                    this.mMeta.registerNamespace(bufferItem.nameSpaceItem.nameSpace, bufferItem.nameSpaceItem.nameSpacePrifix);
                    this.mMeta.setPropertyBase64(bufferItem.nameSpaceItem.nameSpace, bufferItem.name, bufferItem.value);
                }
            }
        }
        if (this.mListOfArrayItem != null) {
            int size3 = this.mListOfArrayItem.size();
            new DataItem.ArrayItem();
            for (int i3 = 0; i3 < size3; i3++) {
                DataItem.ArrayItem arrayItem = this.mListOfArrayItem.get(i3);
                if (arrayItem.dest == this.mDest && arrayItem.value != null) {
                    this.mMeta.registerNamespace(arrayItem.nameSpaceItem.nameSpace, arrayItem.nameSpaceItem.nameSpacePrifix);
                    this.mMeta.setArrayItem(arrayItem.nameSpaceItem.nameSpace, arrayItem.arrayName, i3, arrayItem.value);
                }
            }
        }
        if (this.mListOfStructItem != null) {
            int size4 = this.mListOfStructItem.size();
            new DataItem.StructItem();
            for (int i4 = 0; i4 < size4; i4++) {
                DataItem.StructItem structItem = this.mListOfStructItem.get(i4);
                if (structItem.dest == this.mDest && structItem.fieldValue != null) {
                    this.mMeta.registerNamespace(structItem.structNameSpaceItem.nameSpace, structItem.structNameSpaceItem.nameSpacePrifix);
                    this.mMeta.registerNamespace(structItem.fieldNameSpaceItem.nameSpace, structItem.fieldNameSpaceItem.nameSpacePrifix);
                    this.mMeta.setStructField(structItem.structNameSpaceItem.nameSpace, structItem.structName, structItem.fieldNameSpaceItem.nameSpace, structItem.fieldName, structItem.fieldValue);
                }
            }
        }
    }

    public Map<String, byte[]> serialize() {
        Log.m3993d(TAG, "<serialize>");
        HashMap hashMap = new HashMap();
        hashMap.put("XMP", this.mMeta.serialize());
        return hashMap;
    }

    public void setData(DataItem.DataCollections dataCollections) throws NullPointerException {
        if (dataCollections != null) {
            this.mDest = dataCollections.dest;
            this.mListOfSimpleValue = dataCollections.listOfSimpleValue;
            this.mListOfBufferItem = dataCollections.listOfBufferItem;
            this.mListOfArrayItem = dataCollections.listOfArrayItem;
            this.mListOfStructItem = dataCollections.listOfStructItem;
            return;
        }
        throw new NullPointerException("dataCollections is null!");
    }
}
