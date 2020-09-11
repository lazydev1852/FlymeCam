package com.mediatek.accessor.operator;

import com.mediatek.accessor.meta.CustomizedMeta;
import com.mediatek.accessor.meta.data.DataItem;
import com.mediatek.accessor.util.Log;
import java.util.ArrayList;
import java.util.Map;

public class CustomizedMetaOperator implements IMetaOperator {
    private static final String TAG = Log.Tag(CustomizedMetaOperator.class.getSimpleName());
    private CustomizedMeta mCustMeta;
    private ArrayList<DataItem.BufferItem> mListOfCustDataItem = new ArrayList<>();

    public void decrypt() {
    }

    public void encrypt() {
    }

    public CustomizedMetaOperator(Map<String, byte[]> map) {
        this.mCustMeta = new CustomizedMeta(map);
    }

    public void read() {
        Log.m3993d(TAG, "<read>");
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            if (this.mListOfCustDataItem.get(i) != null) {
                this.mListOfCustDataItem.get(i).value = this.mCustMeta.getPropertyBuffer(this.mListOfCustDataItem.get(i).name);
            }
        }
    }

    public void write() {
        Log.m3993d(TAG, "<write>");
        int size = this.mListOfCustDataItem.size();
        for (int i = 0; i < size; i++) {
            if (!(this.mListOfCustDataItem.get(i) == null || this.mListOfCustDataItem.get(i).value == null)) {
                this.mCustMeta.setPropertyBuffer(this.mListOfCustDataItem.get(i).name, this.mListOfCustDataItem.get(i).value);
            }
        }
    }

    public Map<String, byte[]> serialize() {
        Log.m3993d(TAG, "<serialize>");
        return this.mCustMeta.serialize();
    }

    public void setData(DataItem.DataCollections dataCollections) throws NullPointerException {
        if (dataCollections != null) {
            this.mListOfCustDataItem = dataCollections.listOfCustomDataItem;
            return;
        }
        throw new NullPointerException("dataCollections is null!");
    }
}
