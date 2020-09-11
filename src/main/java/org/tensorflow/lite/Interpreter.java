package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Interpreter implements AutoCloseable {
    NativeInterpreterWrapper wrapper;

    public static class Options {
        boolean allowFp16PrecisionForFp32 = false;
        final List<Delegate> delegates = new ArrayList();
        int numThreads = -1;
        boolean useNNAPI = false;

        public Options setNumThreads(int i) {
            this.numThreads = i;
            return this;
        }

        public Options setUseNNAPI(boolean z) {
            this.useNNAPI = z;
            return this;
        }

        public Options setAllowFp16PrecisionForFp32(boolean z) {
            this.allowFp16PrecisionForFp32 = z;
            return this;
        }

        public Options addDelegate(Delegate delegate) {
            this.delegates.add(delegate);
            return this;
        }
    }

    public Interpreter(File file) {
        this(file, (Options) null);
    }

    @Deprecated
    public Interpreter(File file, int i) {
        this(file, new Options().setNumThreads(i));
    }

    public Interpreter(File file, Options options) {
        this.wrapper = new NativeInterpreterWrapper(file.getAbsolutePath(), options);
    }

    public Interpreter(ByteBuffer byteBuffer) {
        this(byteBuffer, (Options) null);
    }

    @Deprecated
    public Interpreter(ByteBuffer byteBuffer, int i) {
        this(byteBuffer, new Options().setNumThreads(i));
    }

    @Deprecated
    public Interpreter(MappedByteBuffer mappedByteBuffer) {
        this((ByteBuffer) mappedByteBuffer, (Options) null);
    }

    public Interpreter(ByteBuffer byteBuffer, Options options) {
        this.wrapper = new NativeInterpreterWrapper(byteBuffer, options);
    }

    public void run(Object obj, Object obj2) {
        Object[] objArr = {obj};
        HashMap hashMap = new HashMap();
        hashMap.put(0, obj2);
        runForMultipleInputsOutputs(objArr, hashMap);
    }

    public void runForMultipleInputsOutputs(Object[] objArr, Map<Integer, Object> map) {
        checkNotClosed();
        this.wrapper.run(objArr, map);
    }

    public void resizeInput(int i, int[] iArr) {
        checkNotClosed();
        this.wrapper.resizeInput(i, iArr);
    }

    public int getInputTensorCount() {
        checkNotClosed();
        return this.wrapper.getInputTensorCount();
    }

    public int getInputIndex(String str) {
        checkNotClosed();
        return this.wrapper.getInputIndex(str);
    }

    public Tensor getInputTensor(int i) {
        checkNotClosed();
        return this.wrapper.getInputTensor(i);
    }

    public int getOutputTensorCount() {
        checkNotClosed();
        return this.wrapper.getOutputTensorCount();
    }

    public int getOutputIndex(String str) {
        checkNotClosed();
        return this.wrapper.getOutputIndex(str);
    }

    public Tensor getOutputTensor(int i) {
        checkNotClosed();
        return this.wrapper.getOutputTensor(i);
    }

    public Long getLastNativeInferenceDurationNanoseconds() {
        checkNotClosed();
        return this.wrapper.getLastNativeInferenceDurationNanoseconds();
    }

    @Deprecated
    public void setUseNNAPI(boolean z) {
        checkNotClosed();
        this.wrapper.setUseNNAPI(z);
    }

    @Deprecated
    public void setNumThreads(int i) {
        checkNotClosed();
        this.wrapper.setNumThreads(i);
    }

    public void close() {
        if (this.wrapper != null) {
            this.wrapper.close();
            this.wrapper = null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    private void checkNotClosed() {
        if (this.wrapper == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }
}
