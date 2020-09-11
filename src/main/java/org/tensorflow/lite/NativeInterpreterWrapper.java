package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.Interpreter;

public final class NativeInterpreterWrapper implements AutoCloseable {
    private static final int ERROR_BUFFER_SIZE = 512;
    private final List<Delegate> delegates;
    private long errorHandle;
    private long inferenceDurationNanoseconds;
    private Tensor[] inputTensors;
    private Map<String, Integer> inputsIndexes;
    private long interpreterHandle;
    private boolean isMemoryAllocated;
    private ByteBuffer modelByteBuffer;
    private long modelHandle;
    private Tensor[] outputTensors;
    private Map<String, Integer> outputsIndexes;

    private static native long allocateTensors(long j, long j2);

    private static native void allowFp16PrecisionForFp32(long j, boolean z);

    private static native void applyDelegate(long j, long j2, long j3);

    private static native long createErrorReporter(int i);

    private static native long createInterpreter(long j, long j2, int i);

    private static native long createModel(String str, long j);

    private static native long createModelWithBuffer(ByteBuffer byteBuffer, long j);

    private static native void delete(long j, long j2, long j3);

    private static native int getInputCount(long j);

    private static native String[] getInputNames(long j);

    private static native int getInputTensorIndex(long j, int i);

    private static native int getOutputCount(long j);

    private static native int getOutputDataType(long j, int i);

    private static native String[] getOutputNames(long j);

    private static native float getOutputQuantizationScale(long j, int i);

    private static native int getOutputQuantizationZeroPoint(long j, int i);

    private static native int getOutputTensorIndex(long j, int i);

    private static native void numThreads(long j, int i);

    private static native boolean resizeInput(long j, long j2, int i, int[] iArr);

    private static native boolean run(long j, long j2);

    private static native void useNNAPI(long j, boolean z);

    NativeInterpreterWrapper(String str) {
        this(str, (Interpreter.Options) null);
    }

    NativeInterpreterWrapper(String str, Interpreter.Options options) {
        this.inferenceDurationNanoseconds = -1;
        this.isMemoryAllocated = false;
        this.delegates = new ArrayList();
        long createErrorReporter = createErrorReporter(512);
        init(createErrorReporter, createModel(str, createErrorReporter), options);
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer) {
        this(byteBuffer, (Interpreter.Options) null);
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer, Interpreter.Options options) {
        this.inferenceDurationNanoseconds = -1;
        this.isMemoryAllocated = false;
        this.delegates = new ArrayList();
        if (byteBuffer == null || (!(byteBuffer instanceof MappedByteBuffer) && (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()))) {
            throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
        }
        this.modelByteBuffer = byteBuffer;
        long createErrorReporter = createErrorReporter(512);
        init(createErrorReporter, createModelWithBuffer(this.modelByteBuffer, createErrorReporter), options);
    }

    private void init(long j, long j2, Interpreter.Options options) {
        if (options == null) {
            options = new Interpreter.Options();
        }
        this.errorHandle = j;
        this.modelHandle = j2;
        this.interpreterHandle = createInterpreter(j2, j, options.numThreads);
        this.inputTensors = new Tensor[getInputCount(this.interpreterHandle)];
        this.outputTensors = new Tensor[getOutputCount(this.interpreterHandle)];
        if (options.useNNAPI) {
            setUseNNAPI(options.useNNAPI);
        }
        if (options.allowFp16PrecisionForFp32) {
            setAllowFp16PrecisionForFp32(options.allowFp16PrecisionForFp32);
        }
        for (Delegate next : options.delegates) {
            applyDelegate(this.interpreterHandle, j, next.getNativeHandle());
            this.delegates.add(next);
        }
        allocateTensors(this.interpreterHandle, j);
        this.isMemoryAllocated = true;
    }

    public void close() {
        for (int i = 0; i < this.inputTensors.length; i++) {
            if (this.inputTensors[i] != null) {
                this.inputTensors[i].close();
                this.inputTensors[i] = null;
            }
        }
        for (int i2 = 0; i2 < this.outputTensors.length; i2++) {
            if (this.outputTensors[i2] != null) {
                this.outputTensors[i2].close();
                this.outputTensors[i2] = null;
            }
        }
        delete(this.errorHandle, this.modelHandle, this.interpreterHandle);
        this.errorHandle = 0;
        this.modelHandle = 0;
        this.interpreterHandle = 0;
        this.modelByteBuffer = null;
        this.inputsIndexes = null;
        this.outputsIndexes = null;
        this.isMemoryAllocated = false;
        this.delegates.clear();
    }

    /* access modifiers changed from: package-private */
    public void run(Object[] objArr, Map<Integer, Object> map) {
        this.inferenceDurationNanoseconds = -1;
        if (objArr == null || objArr.length == 0) {
            throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
        } else if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
        } else {
            for (int i = 0; i < objArr.length; i++) {
                int[] inputShapeIfDifferent = getInputTensor(i).getInputShapeIfDifferent(objArr[i]);
                if (inputShapeIfDifferent != null) {
                    resizeInput(i, inputShapeIfDifferent);
                }
            }
            boolean z = !this.isMemoryAllocated;
            if (z) {
                allocateTensors(this.interpreterHandle, this.errorHandle);
                this.isMemoryAllocated = true;
            }
            for (int i2 = 0; i2 < objArr.length; i2++) {
                getInputTensor(i2).setTo(objArr[i2]);
            }
            long nanoTime = System.nanoTime();
            run(this.interpreterHandle, this.errorHandle);
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (z) {
                for (int i3 = 0; i3 < this.outputTensors.length; i3++) {
                    if (this.outputTensors[i3] != null) {
                        this.outputTensors[i3].refreshShape();
                    }
                }
            }
            for (Map.Entry next : map.entrySet()) {
                getOutputTensor(((Integer) next.getKey()).intValue()).copyTo(next.getValue());
            }
            this.inferenceDurationNanoseconds = nanoTime2;
        }
    }

    /* access modifiers changed from: package-private */
    public void resizeInput(int i, int[] iArr) {
        if (resizeInput(this.interpreterHandle, this.errorHandle, i, iArr)) {
            this.isMemoryAllocated = false;
            if (this.inputTensors[i] != null) {
                this.inputTensors[i].refreshShape();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setUseNNAPI(boolean z) {
        useNNAPI(this.interpreterHandle, z);
    }

    /* access modifiers changed from: package-private */
    public void setAllowFp16PrecisionForFp32(boolean z) {
        allowFp16PrecisionForFp32(this.interpreterHandle, z);
    }

    /* access modifiers changed from: package-private */
    public void setNumThreads(int i) {
        numThreads(this.interpreterHandle, i);
    }

    /* access modifiers changed from: package-private */
    public int getInputIndex(String str) {
        if (this.inputsIndexes == null) {
            String[] inputNames = getInputNames(this.interpreterHandle);
            this.inputsIndexes = new HashMap();
            if (inputNames != null) {
                for (int i = 0; i < inputNames.length; i++) {
                    this.inputsIndexes.put(inputNames[i], Integer.valueOf(i));
                }
            }
        }
        if (this.inputsIndexes.containsKey(str)) {
            return this.inputsIndexes.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any input. Names of inputs and their indexes are %s", new Object[]{str, this.inputsIndexes.toString()}));
    }

    /* access modifiers changed from: package-private */
    public int getOutputIndex(String str) {
        if (this.outputsIndexes == null) {
            String[] outputNames = getOutputNames(this.interpreterHandle);
            this.outputsIndexes = new HashMap();
            if (outputNames != null) {
                for (int i = 0; i < outputNames.length; i++) {
                    this.outputsIndexes.put(outputNames[i], Integer.valueOf(i));
                }
            }
        }
        if (this.outputsIndexes.containsKey(str)) {
            return this.outputsIndexes.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any output. Names of outputs and their indexes are %s", new Object[]{str, this.outputsIndexes.toString()}));
    }

    /* access modifiers changed from: package-private */
    public Long getLastNativeInferenceDurationNanoseconds() {
        if (this.inferenceDurationNanoseconds < 0) {
            return null;
        }
        return Long.valueOf(this.inferenceDurationNanoseconds);
    }

    /* access modifiers changed from: package-private */
    public int getOutputQuantizationZeroPoint(int i) {
        return getOutputQuantizationZeroPoint(this.interpreterHandle, i);
    }

    /* access modifiers changed from: package-private */
    public float getOutputQuantizationScale(int i) {
        return getOutputQuantizationScale(this.interpreterHandle, i);
    }

    /* access modifiers changed from: package-private */
    public int getInputTensorCount() {
        return this.inputTensors.length;
    }

    /* access modifiers changed from: package-private */
    public Tensor getInputTensor(int i) {
        if (i < 0 || i >= this.inputTensors.length) {
            throw new IllegalArgumentException("Invalid input Tensor index: " + i);
        }
        Tensor tensor = this.inputTensors[i];
        if (tensor != null) {
            return tensor;
        }
        Tensor[] tensorArr = this.inputTensors;
        Tensor fromIndex = Tensor.fromIndex(this.interpreterHandle, getInputTensorIndex(this.interpreterHandle, i));
        tensorArr[i] = fromIndex;
        return fromIndex;
    }

    /* access modifiers changed from: package-private */
    public int getOutputTensorCount() {
        return this.outputTensors.length;
    }

    /* access modifiers changed from: package-private */
    public Tensor getOutputTensor(int i) {
        if (i < 0 || i >= this.outputTensors.length) {
            throw new IllegalArgumentException("Invalid output Tensor index: " + i);
        }
        Tensor tensor = this.outputTensors[i];
        if (tensor != null) {
            return tensor;
        }
        Tensor[] tensorArr = this.outputTensors;
        Tensor fromIndex = Tensor.fromIndex(this.interpreterHandle, getOutputTensorIndex(this.interpreterHandle, i));
        tensorArr[i] = fromIndex;
        return fromIndex;
    }

    static {
        TensorFlowLite.init();
    }
}
