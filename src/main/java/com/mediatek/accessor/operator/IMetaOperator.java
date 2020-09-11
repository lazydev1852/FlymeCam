package com.mediatek.accessor.operator;

import com.mediatek.accessor.meta.data.DataItem;
import java.util.Map;

public interface IMetaOperator {
    void decrypt();

    void encrypt();

    void read();

    Map<String, byte[]> serialize();

    void setData(DataItem.DataCollections dataCollections);

    void write();
}
