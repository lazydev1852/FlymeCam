package com.meizu.common.renderer.wrapper;

import android.opengl.GLES30;
import com.meizu.common.renderer.GLRendererNotProguard;
import com.meizu.common.renderer.effect.ShaderUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

@GLRendererNotProguard
public class GLES30Wrapper {
    public static void glReadBuffer(int i) {
        GLES30.glReadBuffer(i);
        ShaderUtils.m5097a();
    }

    public static void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, Buffer buffer) {
        GLES30.glDrawRangeElements(i, i2, i3, i4, i5, buffer);
        ShaderUtils.m5097a();
    }

    public static void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, int i6) {
        GLES30.glDrawRangeElements(i, i2, i3, i4, i5, i6);
        ShaderUtils.m5097a();
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Buffer buffer) {
        GLES30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, buffer);
        ShaderUtils.m5097a();
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        GLES30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        ShaderUtils.m5097a();
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Buffer buffer) {
        GLES30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, buffer);
        ShaderUtils.m5097a();
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        GLES30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
        ShaderUtils.m5097a();
    }

    public static void glCopyTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        GLES30.glCopyTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9);
        ShaderUtils.m5097a();
    }

    public static void glCompressedTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        GLES30.glCompressedTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        ShaderUtils.m5097a();
    }

    public static void glCompressedTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        GLES30.glCompressedTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9);
        ShaderUtils.m5097a();
    }

    public static void glCompressedTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Buffer buffer) {
        GLES30.glCompressedTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, buffer);
        ShaderUtils.m5097a();
    }

    public static void glCompressedTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        GLES30.glCompressedTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
        ShaderUtils.m5097a();
    }

    public static void glGenQueries(int i, int[] iArr, int i2) {
        GLES30.glGenQueries(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenQueries(int i, IntBuffer intBuffer) {
        GLES30.glGenQueries(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glDeleteQueries(int i, int[] iArr, int i2) {
        GLES30.glDeleteQueries(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteQueries(int i, IntBuffer intBuffer) {
        GLES30.glDeleteQueries(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static boolean glIsQuery(int i) {
        boolean glIsQuery = GLES30.glIsQuery(i);
        ShaderUtils.m5097a();
        return glIsQuery;
    }

    public static void glBeginQuery(int i, int i2) {
        GLES30.glBeginQuery(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glEndQuery(int i) {
        GLES30.glEndQuery(i);
        ShaderUtils.m5097a();
    }

    public static void glGetQueryiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glGetQueryiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetQueryiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetQueryiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetQueryObjectuiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glGetQueryObjectuiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetQueryObjectuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetQueryObjectuiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static boolean glUnmapBuffer(int i) {
        boolean glUnmapBuffer = GLES30.glUnmapBuffer(i);
        ShaderUtils.m5097a();
        return glUnmapBuffer;
    }

    public static Buffer glGetBufferPointerv(int i, int i2) {
        Buffer glGetBufferPointerv = GLES30.glGetBufferPointerv(i, i2);
        ShaderUtils.m5097a();
        return glGetBufferPointerv;
    }

    public static void glDrawBuffers(int i, int[] iArr, int i2) {
        GLES30.glDrawBuffers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDrawBuffers(int i, IntBuffer intBuffer) {
        GLES30.glDrawBuffers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix2x3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES30.glUniformMatrix2x3fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix2x3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix2x3fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix3x2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES30.glUniformMatrix3x2fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix3x2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix3x2fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix2x4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES30.glUniformMatrix2x4fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix2x4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix2x4fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix4x2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES30.glUniformMatrix4x2fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix4x2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix4x2fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix3x4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES30.glUniformMatrix3x4fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix3x4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix3x4fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix4x3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES30.glUniformMatrix4x3fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix4x3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix4x3fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glBlitFramebuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        GLES30.glBlitFramebuffer(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        ShaderUtils.m5097a();
    }

    public static void glRenderbufferStorageMultisample(int i, int i2, int i3, int i4, int i5) {
        GLES30.glRenderbufferStorageMultisample(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glFramebufferTextureLayer(int i, int i2, int i3, int i4, int i5) {
        GLES30.glFramebufferTextureLayer(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static Buffer glMapBufferRange(int i, int i2, int i3, int i4) {
        Buffer glMapBufferRange = GLES30.glMapBufferRange(i, i2, i3, i4);
        ShaderUtils.m5097a();
        return glMapBufferRange;
    }

    public static void glFlushMappedBufferRange(int i, int i2, int i3) {
        GLES30.glFlushMappedBufferRange(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glBindVertexArray(int i) {
        GLES30.glBindVertexArray(i);
        ShaderUtils.m5097a();
    }

    public static void glDeleteVertexArrays(int i, int[] iArr, int i2) {
        GLES30.glDeleteVertexArrays(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteVertexArrays(int i, IntBuffer intBuffer) {
        GLES30.glDeleteVertexArrays(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGenVertexArrays(int i, int[] iArr, int i2) {
        GLES30.glGenVertexArrays(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenVertexArrays(int i, IntBuffer intBuffer) {
        GLES30.glGenVertexArrays(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static boolean glIsVertexArray(int i) {
        boolean glIsVertexArray = GLES30.glIsVertexArray(i);
        ShaderUtils.m5097a();
        return glIsVertexArray;
    }

    public static void glGetIntegeri_v(int i, int i2, int[] iArr, int i3) {
        GLES30.glGetIntegeri_v(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetIntegeri_v(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetIntegeri_v(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glBeginTransformFeedback(int i) {
        GLES30.glBeginTransformFeedback(i);
        ShaderUtils.m5097a();
    }

    public static void glEndTransformFeedback() {
        GLES30.glEndTransformFeedback();
        ShaderUtils.m5097a();
    }

    public static void glBindBufferRange(int i, int i2, int i3, int i4, int i5) {
        GLES30.glBindBufferRange(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glBindBufferBase(int i, int i2, int i3) {
        GLES30.glBindBufferBase(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glTransformFeedbackVaryings(int i, String[] strArr, int i2) {
        GLES30.glTransformFeedbackVaryings(i, strArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGetTransformFeedbackVarying(int i, int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, int[] iArr3, int i6, byte[] bArr, int i7) {
        GLES30.glGetTransformFeedbackVarying(i, i2, i3, iArr, i4, iArr2, i5, iArr3, i6, bArr, i7);
        ShaderUtils.m5097a();
    }

    public static void glGetTransformFeedbackVarying(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, byte b) {
        GLES30.glGetTransformFeedbackVarying(i, i2, i3, intBuffer, intBuffer2, intBuffer3, b);
        ShaderUtils.m5097a();
    }

    public static void glGetTransformFeedbackVarying(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        GLES30.glGetTransformFeedbackVarying(i, i2, i3, intBuffer, intBuffer2, intBuffer3, byteBuffer);
        ShaderUtils.m5097a();
    }

    public static String glGetTransformFeedbackVarying(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        String glGetTransformFeedbackVarying = GLES30.glGetTransformFeedbackVarying(i, i2, iArr, i3, iArr2, i4);
        ShaderUtils.m5097a();
        return glGetTransformFeedbackVarying;
    }

    public static String glGetTransformFeedbackVarying(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        String glGetTransformFeedbackVarying = GLES30.glGetTransformFeedbackVarying(i, i2, intBuffer, intBuffer2);
        ShaderUtils.m5097a();
        return glGetTransformFeedbackVarying;
    }

    public static void glVertexAttribIPointer(int i, int i2, int i3, int i4, Buffer buffer) {
        GLES30.glVertexAttribIPointer(i, i2, i3, i4, buffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribIPointer(int i, int i2, int i3, int i4, int i5) {
        GLES30.glVertexAttribIPointer(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glGetVertexAttribIiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glGetVertexAttribIiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetVertexAttribIiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetVertexAttribIiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetVertexAttribIuiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glGetVertexAttribIuiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetVertexAttribIuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetVertexAttribIuiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribI4i(int i, int i2, int i3, int i4, int i5) {
        GLES30.glVertexAttribI4i(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribI4ui(int i, int i2, int i3, int i4, int i5) {
        GLES30.glVertexAttribI4ui(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribI4iv(int i, int[] iArr, int i2) {
        GLES30.glVertexAttribI4iv(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribI4iv(int i, IntBuffer intBuffer) {
        GLES30.glVertexAttribI4iv(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribI4uiv(int i, int[] iArr, int i2) {
        GLES30.glVertexAttribI4uiv(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribI4uiv(int i, IntBuffer intBuffer) {
        GLES30.glVertexAttribI4uiv(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformuiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glGetUniformuiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetUniformuiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static int glGetFragDataLocation(int i, String str) {
        int glGetFragDataLocation = GLES30.glGetFragDataLocation(i, str);
        ShaderUtils.m5097a();
        return glGetFragDataLocation;
    }

    public static void glUniform1ui(int i, int i2) {
        GLES30.glUniform1ui(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glUniform2ui(int i, int i2, int i3) {
        GLES30.glUniform2ui(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform3ui(int i, int i2, int i3, int i4) {
        GLES30.glUniform3ui(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glUniform4ui(int i, int i2, int i3, int i4, int i5) {
        GLES30.glUniform4ui(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glUniform1uiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glUniform1uiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform1uiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glUniform1uiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform2uiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glUniform2uiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform2uiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glUniform2uiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform3uiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glUniform3uiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform3uiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glUniform3uiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform4uiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glUniform4uiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform4uiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glUniform4uiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glClearBufferiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glClearBufferiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glClearBufferiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glClearBufferiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glClearBufferuiv(int i, int i2, int[] iArr, int i3) {
        GLES30.glClearBufferuiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glClearBufferuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glClearBufferuiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glClearBufferfv(int i, int i2, float[] fArr, int i3) {
        GLES30.glClearBufferfv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glClearBufferfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES30.glClearBufferfv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glClearBufferfi(int i, int i2, float f, int i3) {
        GLES30.glClearBufferfi(i, i2, f, i3);
        ShaderUtils.m5097a();
    }

    public static String glGetStringi(int i, int i2) {
        String glGetStringi = GLES30.glGetStringi(i, i2);
        ShaderUtils.m5097a();
        return glGetStringi;
    }

    public static void glCopyBufferSubData(int i, int i2, int i3, int i4, int i5) {
        GLES30.glCopyBufferSubData(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformIndices(int i, String[] strArr, int[] iArr, int i2) {
        GLES30.glGetUniformIndices(i, strArr, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformIndices(int i, String[] strArr, IntBuffer intBuffer) {
        GLES30.glGetUniformIndices(i, strArr, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetActiveUniformsiv(int i, int i2, int[] iArr, int i3, int i4, int[] iArr2, int i5) {
        GLES30.glGetActiveUniformsiv(i, i2, iArr, i3, i4, iArr2, i5);
        ShaderUtils.m5097a();
    }

    public static void glGetActiveUniformsiv(int i, int i2, IntBuffer intBuffer, int i3, IntBuffer intBuffer2) {
        GLES30.glGetActiveUniformsiv(i, i2, intBuffer, i3, intBuffer2);
        ShaderUtils.m5097a();
    }

    public static int glGetUniformBlockIndex(int i, String str) {
        int glGetUniformBlockIndex = GLES30.glGetUniformBlockIndex(i, str);
        ShaderUtils.m5097a();
        return glGetUniformBlockIndex;
    }

    public static void glGetActiveUniformBlockiv(int i, int i2, int i3, int[] iArr, int i4) {
        GLES30.glGetActiveUniformBlockiv(i, i2, i3, iArr, i4);
        ShaderUtils.m5097a();
    }

    public static void glGetActiveUniformBlockiv(int i, int i2, int i3, IntBuffer intBuffer) {
        GLES30.glGetActiveUniformBlockiv(i, i2, i3, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetActiveUniformBlockName(int i, int i2, int i3, int[] iArr, int i4, byte[] bArr, int i5) {
        GLES30.glGetActiveUniformBlockName(i, i2, i3, iArr, i4, bArr, i5);
        ShaderUtils.m5097a();
    }

    public static void glGetActiveUniformBlockName(int i, int i2, Buffer buffer, Buffer buffer2) {
        GLES30.glGetActiveUniformBlockName(i, i2, buffer, buffer2);
        ShaderUtils.m5097a();
    }

    public static String glGetActiveUniformBlockName(int i, int i2) {
        String glGetActiveUniformBlockName = GLES30.glGetActiveUniformBlockName(i, i2);
        ShaderUtils.m5097a();
        return glGetActiveUniformBlockName;
    }

    public static void glUniformBlockBinding(int i, int i2, int i3) {
        GLES30.glUniformBlockBinding(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glDrawArraysInstanced(int i, int i2, int i3, int i4) {
        GLES30.glDrawArraysInstanced(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glDrawElementsInstanced(int i, int i2, int i3, Buffer buffer, int i4) {
        GLES30.glDrawElementsInstanced(i, i2, i3, buffer, i4);
        ShaderUtils.m5097a();
    }

    public static void glDrawElementsInstanced(int i, int i2, int i3, int i4, int i5) {
        GLES30.glDrawElementsInstanced(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static long glFenceSync(int i, int i2) {
        long glFenceSync = GLES30.glFenceSync(i, i2);
        ShaderUtils.m5097a();
        return glFenceSync;
    }

    public static boolean glIsSync(long j) {
        boolean glIsSync = GLES30.glIsSync(j);
        ShaderUtils.m5097a();
        return glIsSync;
    }

    public static void glDeleteSync(long j) {
        GLES30.glDeleteSync(j);
        ShaderUtils.m5097a();
    }

    public static int glClientWaitSync(long j, int i, long j2) {
        int glClientWaitSync = GLES30.glClientWaitSync(j, i, j2);
        ShaderUtils.m5097a();
        return glClientWaitSync;
    }

    public static void glWaitSync(long j, int i, long j2) {
        GLES30.glWaitSync(j, i, j2);
        ShaderUtils.m5097a();
    }

    public static void glGetInteger64v(int i, long[] jArr, int i2) {
        GLES30.glGetInteger64v(i, jArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGetInteger64v(int i, LongBuffer longBuffer) {
        GLES30.glGetInteger64v(i, longBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetSynciv(long j, int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        GLES30.glGetSynciv(j, i, i2, iArr, i3, iArr2, i4);
        ShaderUtils.m5097a();
    }

    public static void glGetSynciv(long j, int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        GLES30.glGetSynciv(j, i, i2, intBuffer, intBuffer2);
        ShaderUtils.m5097a();
    }

    public static void glGetInteger64i_v(int i, int i2, long[] jArr, int i3) {
        GLES30.glGetInteger64i_v(i, i2, jArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetInteger64i_v(int i, int i2, LongBuffer longBuffer) {
        GLES30.glGetInteger64i_v(i, i2, longBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetBufferParameteri64v(int i, int i2, long[] jArr, int i3) {
        GLES30.glGetBufferParameteri64v(i, i2, jArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetBufferParameteri64v(int i, int i2, LongBuffer longBuffer) {
        GLES30.glGetBufferParameteri64v(i, i2, longBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGenSamplers(int i, int[] iArr, int i2) {
        GLES30.glGenSamplers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenSamplers(int i, IntBuffer intBuffer) {
        GLES30.glGenSamplers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glDeleteSamplers(int i, int[] iArr, int i2) {
        GLES30.glDeleteSamplers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteSamplers(int i, IntBuffer intBuffer) {
        GLES30.glDeleteSamplers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static boolean glIsSampler(int i) {
        boolean glIsSampler = GLES30.glIsSampler(i);
        ShaderUtils.m5097a();
        return glIsSampler;
    }

    public static void glBindSampler(int i, int i2) {
        GLES30.glBindSampler(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glSamplerParameteri(int i, int i2, int i3) {
        GLES30.glSamplerParameteri(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glSamplerParameteriv(int i, int i2, int[] iArr, int i3) {
        GLES30.glSamplerParameteriv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glSamplerParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glSamplerParameteriv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glSamplerParameterf(int i, int i2, float f) {
        GLES30.glSamplerParameterf(i, i2, f);
        ShaderUtils.m5097a();
    }

    public static void glSamplerParameterfv(int i, int i2, float[] fArr, int i3) {
        GLES30.glSamplerParameterfv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glSamplerParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES30.glSamplerParameterfv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetSamplerParameteriv(int i, int i2, int[] iArr, int i3) {
        GLES30.glGetSamplerParameteriv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetSamplerParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetSamplerParameteriv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetSamplerParameterfv(int i, int i2, float[] fArr, int i3) {
        GLES30.glGetSamplerParameterfv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetSamplerParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES30.glGetSamplerParameterfv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribDivisor(int i, int i2) {
        GLES30.glVertexAttribDivisor(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBindTransformFeedback(int i, int i2) {
        GLES30.glBindTransformFeedback(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteTransformFeedbacks(int i, int[] iArr, int i2) {
        GLES30.glDeleteTransformFeedbacks(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteTransformFeedbacks(int i, IntBuffer intBuffer) {
        GLES30.glDeleteTransformFeedbacks(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGenTransformFeedbacks(int i, int[] iArr, int i2) {
        GLES30.glGenTransformFeedbacks(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenTransformFeedbacks(int i, IntBuffer intBuffer) {
        GLES30.glGenTransformFeedbacks(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static boolean glIsTransformFeedback(int i) {
        boolean glIsTransformFeedback = GLES30.glIsTransformFeedback(i);
        ShaderUtils.m5097a();
        return glIsTransformFeedback;
    }

    public static void glPauseTransformFeedback() {
        GLES30.glPauseTransformFeedback();
        ShaderUtils.m5097a();
    }

    public static void glResumeTransformFeedback() {
        GLES30.glResumeTransformFeedback();
        ShaderUtils.m5097a();
    }

    public static void glGetProgramBinary(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4, Buffer buffer) {
        GLES30.glGetProgramBinary(i, i2, iArr, i3, iArr2, i4, buffer);
        ShaderUtils.m5097a();
    }

    public static void glGetProgramBinary(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, Buffer buffer) {
        GLES30.glGetProgramBinary(i, i2, intBuffer, intBuffer2, buffer);
        ShaderUtils.m5097a();
    }

    public static void glProgramBinary(int i, int i2, Buffer buffer, int i3) {
        GLES30.glProgramBinary(i, i2, buffer, i3);
        ShaderUtils.m5097a();
    }

    public static void glProgramParameteri(int i, int i2, int i3) {
        GLES30.glProgramParameteri(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glInvalidateFramebuffer(int i, int i2, int[] iArr, int i3) {
        GLES30.glInvalidateFramebuffer(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glInvalidateFramebuffer(int i, int i2, IntBuffer intBuffer) {
        GLES30.glInvalidateFramebuffer(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glInvalidateSubFramebuffer(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        GLES30.glInvalidateSubFramebuffer(i, i2, iArr, i3, i4, i5, i6, i7);
        ShaderUtils.m5097a();
    }

    public static void glInvalidateSubFramebuffer(int i, int i2, IntBuffer intBuffer, int i3, int i4, int i5, int i6) {
        GLES30.glInvalidateSubFramebuffer(i, i2, intBuffer, i3, i4, i5, i6);
        ShaderUtils.m5097a();
    }

    public static void glTexStorage2D(int i, int i2, int i3, int i4, int i5) {
        GLES30.glTexStorage2D(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glTexStorage3D(int i, int i2, int i3, int i4, int i5, int i6) {
        GLES30.glTexStorage3D(i, i2, i3, i4, i5, i6);
        ShaderUtils.m5097a();
    }

    public static void glGetInternalformativ(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        GLES30.glGetInternalformativ(i, i2, i3, i4, iArr, i5);
        ShaderUtils.m5097a();
    }

    public static void glGetInternalformativ(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        GLES30.glGetInternalformativ(i, i2, i3, i4, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        GLES30.glReadPixels(i, i2, i3, i4, i5, i6, i7);
        ShaderUtils.m5097a();
    }
}
