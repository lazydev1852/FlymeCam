package org.tensorflow.lite;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class Tensor {
    private final DataType dtype;
    private long nativeHandle;
    private int[] shapeCopy;

    private static native ByteBuffer buffer(long j);

    private static native long create(long j, int i);

    private static native void delete(long j);

    private static native int dtype(long j);

    private static native int numBytes(long j);

    private static native void readMultiDimensionalArray(long j, Object obj);

    private static native int[] shape(long j);

    private static native void writeDirectBuffer(long j, ByteBuffer byteBuffer);

    private static native void writeMultiDimensionalArray(long j, Object obj);

    static Tensor fromIndex(long j, int i) {
        return new Tensor(create(j, i));
    }

    /* access modifiers changed from: package-private */
    public void close() {
        delete(this.nativeHandle);
        this.nativeHandle = 0;
    }

    public DataType dataType() {
        return this.dtype;
    }

    public int numDimensions() {
        return this.shapeCopy.length;
    }

    public int numBytes() {
        return numBytes(this.nativeHandle);
    }

    public int numElements() {
        return computeNumElements(this.shapeCopy);
    }

    public int[] shape() {
        return this.shapeCopy;
    }

    /* access modifiers changed from: package-private */
    public void setTo(Object obj) {
        throwExceptionIfTypeIsIncompatible(obj);
        if (isByteBuffer(obj)) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            if (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()) {
                buffer().put(byteBuffer);
            } else {
                writeDirectBuffer(this.nativeHandle, byteBuffer);
            }
        } else {
            writeMultiDimensionalArray(this.nativeHandle, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public Object copyTo(Object obj) {
        throwExceptionIfTypeIsIncompatible(obj);
        if (obj instanceof ByteBuffer) {
            ((ByteBuffer) obj).put(buffer());
            return obj;
        }
        readMultiDimensionalArray(this.nativeHandle, obj);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public int[] getInputShapeIfDifferent(Object obj) {
        if (isByteBuffer(obj)) {
            return null;
        }
        int[] computeShapeOf = computeShapeOf(obj);
        if (Arrays.equals(this.shapeCopy, computeShapeOf)) {
            return null;
        }
        return computeShapeOf;
    }

    /* access modifiers changed from: package-private */
    public void refreshShape() {
        this.shapeCopy = shape(this.nativeHandle);
    }

    static DataType dataTypeOf(Object obj) {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            while (cls.isArray()) {
                cls = cls.getComponentType();
            }
            if (Float.TYPE.equals(cls)) {
                return DataType.FLOAT32;
            }
            if (Integer.TYPE.equals(cls)) {
                return DataType.INT32;
            }
            if (Byte.TYPE.equals(cls)) {
                return DataType.UINT8;
            }
            if (Long.TYPE.equals(cls)) {
                return DataType.INT64;
            }
            if (String.class.equals(cls)) {
                return DataType.STRING;
            }
        }
        throw new IllegalArgumentException("DataType error: cannot resolve DataType of " + obj.getClass().getName());
    }

    static int[] computeShapeOf(Object obj) {
        int[] iArr = new int[computeNumDimensions(obj)];
        fillShape(obj, 0, iArr);
        return iArr;
    }

    static int computeNumElements(int[] iArr) {
        int i = 1;
        for (int i2 : iArr) {
            i *= i2;
        }
        return i;
    }

    static int computeNumDimensions(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return 0;
        }
        if (Array.getLength(obj) != 0) {
            return computeNumDimensions(Array.get(obj, 0)) + 1;
        }
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    static void fillShape(Object obj, int i, int[] iArr) {
        if (iArr != null && i != iArr.length) {
            int length = Array.getLength(obj);
            if (iArr[i] == 0) {
                iArr[i] = length;
            } else if (iArr[i] != length) {
                throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", new Object[]{Integer.valueOf(iArr[i]), Integer.valueOf(length), Integer.valueOf(i)}));
            }
            for (int i2 = 0; i2 < length; i2++) {
                fillShape(Array.get(obj, i2), i + 1, iArr);
            }
        }
    }

    private void throwExceptionIfTypeIsIncompatible(Object obj) {
        if (isByteBuffer(obj)) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            if (byteBuffer.capacity() != numBytes()) {
                throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite buffer with %d bytes and a ByteBuffer with %d bytes.", new Object[]{Integer.valueOf(numBytes()), Integer.valueOf(byteBuffer.capacity())}));
            }
            return;
        }
        DataType dataTypeOf = dataTypeOf(obj);
        if (dataTypeOf == this.dtype) {
            int[] computeShapeOf = computeShapeOf(obj);
            if (!Arrays.equals(computeShapeOf, this.shapeCopy)) {
                throw new IllegalArgumentException(String.format("Cannot copy between a TensorFlowLite tensor with shape %s and a Java object with shape %s.", new Object[]{Arrays.toString(this.shapeCopy), Arrays.toString(computeShapeOf)}));
            }
            return;
        }
        throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", new Object[]{this.dtype, obj.getClass().getName(), dataTypeOf}));
    }

    private static boolean isByteBuffer(Object obj) {
        return obj instanceof ByteBuffer;
    }

    private Tensor(long j) {
        this.nativeHandle = j;
        this.dtype = DataType.fromC(dtype(j));
        this.shapeCopy = shape(j);
    }

    private ByteBuffer buffer() {
        return buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
    }

    static {
        TensorFlowLite.init();
    }
}
