package org.tensorflow.lite;

import com.meizu.savior.Constants;

public enum DataType {
    FLOAT32(1),
    INT32(2),
    UINT8(3),
    INT64(4),
    STRING(5);
    
    private static final DataType[] values = null;
    private final int value;

    static {
        values = values();
    }

    private DataType(int i) {
        this.value = i;
    }

    public int byteSize() {
        switch (this) {
            case FLOAT32:
                return 4;
            case INT32:
                return 4;
            case UINT8:
                return 1;
            case INT64:
                return 8;
            case STRING:
                return -1;
            default:
                throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo28026c() {
        return this.value;
    }

    static DataType fromC(int i) {
        for (DataType dataType : values) {
            if (dataType.value == i) {
                return dataType;
            }
        }
        throw new IllegalArgumentException("DataType error: DataType " + i + " is not recognized in Java (version " + TensorFlowLite.version() + ")");
    }

    /* access modifiers changed from: package-private */
    public String toStringName() {
        switch (this) {
            case FLOAT32:
                return Constants.FLOAT;
            case INT32:
                return Constants.INT;
            case UINT8:
                return Constants.BYTE;
            case INT64:
                return Constants.LONG;
            case STRING:
                return "string";
            default:
                throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
        }
    }
}
