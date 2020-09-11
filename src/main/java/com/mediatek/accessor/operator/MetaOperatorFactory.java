package com.mediatek.accessor.operator;

import java.util.Map;

public class MetaOperatorFactory {
    public static final int CUSTOMIZED_META_OPERATOR = 1;
    public static final int XMP_META_OPERATOR = 0;

    public static IMetaOperator getOperatorInstance(int i, byte[] bArr, Map<String, byte[]> map) {
        switch (i) {
            case 0:
                return new XmpMetaOperator(bArr);
            case 1:
                return new CustomizedMetaOperator(map);
            default:
                return null;
        }
    }
}
