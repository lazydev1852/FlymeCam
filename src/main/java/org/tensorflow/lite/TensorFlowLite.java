package org.tensorflow.lite;

import java.io.PrintStream;

public final class TensorFlowLite {
    private static final String FALLBACK_LIBNAME = "tensorflowlite_flex_jni";
    private static final String PRIMARY_LIBNAME = "tensorflowlite_jni";

    static native void initTensorFlow();

    public static native String version();

    private TensorFlowLite() {
    }

    static boolean init() {
        try {
            System.loadLibrary(PRIMARY_LIBNAME);
            return true;
        } catch (UnsatisfiedLinkError e) {
            try {
                System.loadLibrary(FALLBACK_LIBNAME);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                PrintStream printStream = System.err;
                printStream.println("TensorFlowLite: failed to load native library: " + e.getMessage());
                return false;
            }
        }
    }

    static {
        init();
    }
}
