package com.meizu.common.renderer.wrapper;

import android.opengl.GLES20;
import com.meizu.common.renderer.GLRendererNotProguard;
import com.meizu.common.renderer.effect.ShaderUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@GLRendererNotProguard
public class GLES20Wrapper {
    public static void glActiveTexture(int i) {
        GLES20.glActiveTexture(i);
        ShaderUtils.m5097a();
    }

    public static void glAttachShader(int i, int i2) {
        GLES20.glAttachShader(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBindAttribLocation(int i, int i2, String str) {
        GLES20.glBindAttribLocation(i, i2, str);
        ShaderUtils.m5097a();
    }

    public static void glBindBuffer(int i, int i2) {
        GLES20.glBindBuffer(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBindFramebuffer(int i, int i2) {
        GLES20.glBindFramebuffer(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBindRenderbuffer(int i, int i2) {
        GLES20.glBindRenderbuffer(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBindTexture(int i, int i2) {
        GLES20.glBindTexture(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBlendColor(float f, float f2, float f3, float f4) {
        GLES20.glBlendColor(f, f2, f3, f4);
        ShaderUtils.m5097a();
    }

    public static void glBlendEquation(int i) {
        GLES20.glBlendEquation(i);
        ShaderUtils.m5097a();
    }

    public static void glBlendEquationSeparate(int i, int i2) {
        GLES20.glBlendEquationSeparate(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBlendFunc(int i, int i2) {
        GLES20.glBlendFunc(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        GLES20.glBlendFuncSeparate(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glBufferData(int i, int i2, Buffer buffer, int i3) {
        GLES20.glBufferData(i, i2, buffer, i3);
        ShaderUtils.m5097a();
    }

    public static void glBufferSubData(int i, int i2, int i3, Buffer buffer) {
        GLES20.glBufferSubData(i, i2, i3, buffer);
        ShaderUtils.m5097a();
    }

    public static int glCheckFramebufferStatus(int i) {
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(i);
        ShaderUtils.m5097a();
        return glCheckFramebufferStatus;
    }

    public static void glClear(int i) {
        GLES20.glClear(i);
        ShaderUtils.m5097a();
    }

    public static void glClearColor(float f, float f2, float f3, float f4) {
        GLES20.glClearColor(f, f2, f3, f4);
        ShaderUtils.m5097a();
    }

    public static void glClearDepthf(float f) {
        GLES20.glClearDepthf(f);
        ShaderUtils.m5097a();
    }

    public static void glClearStencil(int i) {
        GLES20.glClearStencil(i);
        ShaderUtils.m5097a();
    }

    public static void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        GLES20.glColorMask(z, z2, z3, z4);
        ShaderUtils.m5097a();
    }

    public static void glCompileShader(int i) {
        GLES20.glCompileShader(i);
        ShaderUtils.m5097a();
    }

    public static void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {
        GLES20.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
        ShaderUtils.m5097a();
    }

    public static void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        GLES20.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        ShaderUtils.m5097a();
    }

    public static void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLES20.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        ShaderUtils.m5097a();
    }

    public static void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLES20.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        ShaderUtils.m5097a();
    }

    public static int glCreateProgram() {
        int glCreateProgram = GLES20.glCreateProgram();
        ShaderUtils.m5097a();
        return glCreateProgram;
    }

    public static int glCreateShader(int i) {
        int glCreateShader = GLES20.glCreateShader(i);
        ShaderUtils.m5097a();
        return glCreateShader;
    }

    public static void glCullFace(int i) {
        GLES20.glCullFace(i);
        ShaderUtils.m5097a();
    }

    public static void glDeleteBuffers(int i, int[] iArr, int i2) {
        GLES20.glDeleteBuffers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteBuffers(int i, IntBuffer intBuffer) {
        GLES20.glDeleteBuffers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glDeleteFramebuffers(int i, int[] iArr, int i2) {
        GLES20.glDeleteFramebuffers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteFramebuffers(int i, IntBuffer intBuffer) {
        GLES20.glDeleteFramebuffers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glDeleteProgram(int i) {
        GLES20.glDeleteProgram(i);
        ShaderUtils.m5097a();
    }

    public static void glDeleteRenderbuffers(int i, int[] iArr, int i2) {
        GLES20.glDeleteRenderbuffers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteRenderbuffers(int i, IntBuffer intBuffer) {
        GLES20.glDeleteRenderbuffers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glDeleteShader(int i) {
        GLES20.glDeleteShader(i);
        ShaderUtils.m5097a();
    }

    public static void glDeleteTextures(int i, int[] iArr, int i2) {
        GLES20.glDeleteTextures(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glDeleteTextures(int i, IntBuffer intBuffer) {
        GLES20.glDeleteTextures(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glDepthFunc(int i) {
        GLES20.glDepthFunc(i);
        ShaderUtils.m5097a();
    }

    public static void glDepthMask(boolean z) {
        GLES20.glDepthMask(z);
        ShaderUtils.m5097a();
    }

    public static void glDepthRangef(float f, float f2) {
        GLES20.glDepthRangef(f, f2);
        ShaderUtils.m5097a();
    }

    public static void glDetachShader(int i, int i2) {
        GLES20.glDetachShader(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glDisable(int i) {
        GLES20.glDisable(i);
        ShaderUtils.m5097a();
    }

    public static void glDisableVertexAttribArray(int i) {
        GLES20.glDisableVertexAttribArray(i);
        ShaderUtils.m5097a();
    }

    public static void glDrawArrays(int i, int i2, int i3) {
        GLES20.glDrawArrays(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glDrawElements(int i, int i2, int i3, int i4) {
        GLES20.glDrawElements(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glDrawElements(int i, int i2, int i3, Buffer buffer) {
        GLES20.glDrawElements(i, i2, i3, buffer);
        ShaderUtils.m5097a();
    }

    public static void glEnable(int i) {
        GLES20.glEnable(i);
        ShaderUtils.m5097a();
    }

    public static void glEnableVertexAttribArray(int i) {
        GLES20.glEnableVertexAttribArray(i);
        ShaderUtils.m5097a();
    }

    public static void glFinish() {
        GLES20.glFinish();
        ShaderUtils.m5097a();
    }

    public static void glFlush() {
        GLES20.glFlush();
        ShaderUtils.m5097a();
    }

    public static void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        GLES20.glFramebufferRenderbuffer(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        GLES20.glFramebufferTexture2D(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glFrontFace(int i) {
        GLES20.glFrontFace(i);
        ShaderUtils.m5097a();
    }

    public static void glGenBuffers(int i, int[] iArr, int i2) {
        GLES20.glGenBuffers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenBuffers(int i, IntBuffer intBuffer) {
        GLES20.glGenBuffers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGenerateMipmap(int i) {
        GLES20.glGenerateMipmap(i);
        ShaderUtils.m5097a();
    }

    public static void glGenFramebuffers(int i, int[] iArr, int i2) {
        GLES20.glGenFramebuffers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenFramebuffers(int i, IntBuffer intBuffer) {
        GLES20.glGenFramebuffers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGenRenderbuffers(int i, int[] iArr, int i2) {
        GLES20.glGenRenderbuffers(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenRenderbuffers(int i, IntBuffer intBuffer) {
        GLES20.glGenRenderbuffers(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGenTextures(int i, int[] iArr, int i2) {
        GLES20.glGenTextures(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGenTextures(int i, IntBuffer intBuffer) {
        GLES20.glGenTextures(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetActiveAttrib(int i, int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, int[] iArr3, int i6, byte[] bArr, int i7) {
        GLES20.glGetActiveAttrib(i, i2, i3, iArr, i4, iArr2, i5, iArr3, i6, bArr, i7);
        ShaderUtils.m5097a();
    }

    public static String glGetActiveAttrib(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        String glGetActiveAttrib = GLES20.glGetActiveAttrib(i, i2, iArr, i3, iArr2, i4);
        ShaderUtils.m5097a();
        return glGetActiveAttrib;
    }

    public static String glGetActiveAttrib(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        String glGetActiveAttrib = GLES20.glGetActiveAttrib(i, i2, intBuffer, intBuffer2);
        ShaderUtils.m5097a();
        return glGetActiveAttrib;
    }

    public static void glGetActiveUniform(int i, int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, int[] iArr3, int i6, byte[] bArr, int i7) {
        GLES20.glGetActiveUniform(i, i2, i3, iArr, i4, iArr2, i5, iArr3, i6, bArr, i7);
        ShaderUtils.m5097a();
    }

    public static String glGetActiveUniform(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        String glGetActiveUniform = GLES20.glGetActiveUniform(i, i2, iArr, i3, iArr2, i4);
        ShaderUtils.m5097a();
        return glGetActiveUniform;
    }

    public static String glGetActiveUniform(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        String glGetActiveUniform = GLES20.glGetActiveUniform(i, i2, intBuffer, intBuffer2);
        ShaderUtils.m5097a();
        return glGetActiveUniform;
    }

    public static void glGetAttachedShaders(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        GLES20.glGetAttachedShaders(i, i2, iArr, i3, iArr2, i4);
        ShaderUtils.m5097a();
    }

    public static void glGetAttachedShaders(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        GLES20.glGetAttachedShaders(i, i2, intBuffer, intBuffer2);
        ShaderUtils.m5097a();
    }

    public static int glGetAttribLocation(int i, String str) {
        int glGetAttribLocation = GLES20.glGetAttribLocation(i, str);
        ShaderUtils.m5097a();
        return glGetAttribLocation;
    }

    public static void glGetBooleanv(int i, boolean[] zArr, int i2) {
        GLES20.glGetBooleanv(i, zArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGetBooleanv(int i, IntBuffer intBuffer) {
        GLES20.glGetBooleanv(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetBufferParameteriv(int i, int i2, int[] iArr, int i3) {
        GLES20.glGetBufferParameteriv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetBufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetBufferParameteriv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetFloatv(int i, float[] fArr, int i2) {
        GLES20.glGetFloatv(i, fArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGetFloatv(int i, FloatBuffer floatBuffer) {
        GLES20.glGetFloatv(i, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, int[] iArr, int i4) {
        GLES20.glGetFramebufferAttachmentParameteriv(i, i2, i3, iArr, i4);
        ShaderUtils.m5097a();
    }

    public static void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, IntBuffer intBuffer) {
        GLES20.glGetFramebufferAttachmentParameteriv(i, i2, i3, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetIntegerv(int i, int[] iArr, int i2) {
        GLES20.glGetIntegerv(i, iArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glGetIntegerv(int i, IntBuffer intBuffer) {
        GLES20.glGetIntegerv(i, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetProgramiv(int i, int i2, int[] iArr, int i3) {
        GLES20.glGetProgramiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetProgramiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetProgramiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static String glGetProgramInfoLog(int i) {
        String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(i);
        ShaderUtils.m5097a();
        return glGetProgramInfoLog;
    }

    public static void glGetRenderbufferParameteriv(int i, int i2, int[] iArr, int i3) {
        GLES20.glGetRenderbufferParameteriv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetRenderbufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetRenderbufferParameteriv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetShaderiv(int i, int i2, int[] iArr, int i3) {
        GLES20.glGetShaderiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetShaderiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetShaderiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static String glGetShaderInfoLog(int i) {
        String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(i);
        ShaderUtils.m5097a();
        return glGetShaderInfoLog;
    }

    public static void glGetShaderPrecisionFormat(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        GLES20.glGetShaderPrecisionFormat(i, i2, iArr, i3, iArr2, i4);
        ShaderUtils.m5097a();
    }

    public static void glGetShaderPrecisionFormat(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        GLES20.glGetShaderPrecisionFormat(i, i2, intBuffer, intBuffer2);
        ShaderUtils.m5097a();
    }

    public static void glGetShaderSource(int i, int i2, int[] iArr, int i3, byte[] bArr, int i4) {
        GLES20.glGetShaderSource(i, i2, iArr, i3, bArr, i4);
        ShaderUtils.m5097a();
    }

    public static String glGetShaderSource(int i) {
        String glGetShaderSource = GLES20.glGetShaderSource(i);
        ShaderUtils.m5097a();
        return glGetShaderSource;
    }

    public static String glGetString(int i) {
        String glGetString = GLES20.glGetString(i);
        ShaderUtils.m5097a();
        return glGetString;
    }

    public static void glGetTexParameterfv(int i, int i2, float[] fArr, int i3) {
        GLES20.glGetTexParameterfv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glGetTexParameterfv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetTexParameteriv(int i, int i2, int[] iArr, int i3) {
        GLES20.glGetTexParameteriv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetTexParameteriv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformfv(int i, int i2, float[] fArr, int i3) {
        GLES20.glGetUniformfv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glGetUniformfv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformiv(int i, int i2, int[] iArr, int i3) {
        GLES20.glGetUniformiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetUniformiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetUniformiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static int glGetUniformLocation(int i, String str) {
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, str);
        ShaderUtils.m5097a();
        return glGetUniformLocation;
    }

    public static void glGetVertexAttribfv(int i, int i2, float[] fArr, int i3) {
        GLES20.glGetVertexAttribfv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetVertexAttribfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glGetVertexAttribfv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glGetVertexAttribiv(int i, int i2, int[] iArr, int i3) {
        GLES20.glGetVertexAttribiv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glGetVertexAttribiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetVertexAttribiv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glHint(int i, int i2) {
        GLES20.glHint(i, i2);
        ShaderUtils.m5097a();
    }

    public static boolean glIsBuffer(int i) {
        boolean glIsBuffer = GLES20.glIsBuffer(i);
        ShaderUtils.m5097a();
        return glIsBuffer;
    }

    public static boolean glIsEnabled(int i) {
        boolean glIsEnabled = GLES20.glIsEnabled(i);
        ShaderUtils.m5097a();
        return glIsEnabled;
    }

    public static boolean glIsFramebuffer(int i) {
        boolean glIsFramebuffer = GLES20.glIsFramebuffer(i);
        ShaderUtils.m5097a();
        return glIsFramebuffer;
    }

    public static boolean glIsProgram(int i) {
        boolean glIsProgram = GLES20.glIsProgram(i);
        ShaderUtils.m5097a();
        return glIsProgram;
    }

    public static boolean glIsRenderbuffer(int i) {
        boolean glIsRenderbuffer = GLES20.glIsRenderbuffer(i);
        ShaderUtils.m5097a();
        return glIsRenderbuffer;
    }

    public static boolean glIsShader(int i) {
        boolean glIsShader = GLES20.glIsShader(i);
        ShaderUtils.m5097a();
        return glIsShader;
    }

    public static boolean glIsTexture(int i) {
        boolean glIsTexture = GLES20.glIsTexture(i);
        ShaderUtils.m5097a();
        return glIsTexture;
    }

    public static void glLineWidth(float f) {
        GLES20.glLineWidth(f);
        ShaderUtils.m5097a();
    }

    public static void glLinkProgram(int i) {
        GLES20.glLinkProgram(i);
        ShaderUtils.m5097a();
    }

    public static void glPixelStorei(int i, int i2) {
        GLES20.glPixelStorei(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glPolygonOffset(float f, float f2) {
        GLES20.glPolygonOffset(f, f2);
        ShaderUtils.m5097a();
    }

    public static void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, Buffer buffer) {
        GLES20.glReadPixels(i, i2, i3, i4, i5, i6, buffer);
        ShaderUtils.m5097a();
    }

    public static void glReleaseShaderCompiler() {
        GLES20.glReleaseShaderCompiler();
        ShaderUtils.m5097a();
    }

    public static void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        GLES20.glRenderbufferStorage(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glSampleCoverage(float f, boolean z) {
        GLES20.glSampleCoverage(f, z);
        ShaderUtils.m5097a();
    }

    public static void glScissor(int i, int i2, int i3, int i4) {
        GLES20.glScissor(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glShaderBinary(int i, int[] iArr, int i2, int i3, Buffer buffer, int i4) {
        GLES20.glShaderBinary(i, iArr, i2, i3, buffer, i4);
        ShaderUtils.m5097a();
    }

    public static void glShaderBinary(int i, IntBuffer intBuffer, int i2, Buffer buffer, int i3) {
        GLES20.glShaderBinary(i, intBuffer, i2, buffer, i3);
        ShaderUtils.m5097a();
    }

    public static void glShaderSource(int i, String str) {
        GLES20.glShaderSource(i, str);
        ShaderUtils.m5097a();
    }

    public static void glStencilFunc(int i, int i2, int i3) {
        GLES20.glStencilFunc(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        GLES20.glStencilFuncSeparate(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glStencilMask(int i) {
        GLES20.glStencilMask(i);
        ShaderUtils.m5097a();
    }

    public static void glStencilMaskSeparate(int i, int i2) {
        GLES20.glStencilMaskSeparate(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glStencilOp(int i, int i2, int i3) {
        GLES20.glStencilOp(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        GLES20.glStencilOpSeparate(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        GLES20.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        ShaderUtils.m5097a();
    }

    public static void glTexParameterf(int i, int i2, float f) {
        GLES20.glTexParameterf(i, i2, f);
        ShaderUtils.m5097a();
    }

    public static void glTexParameterfv(int i, int i2, float[] fArr, int i3) {
        GLES20.glTexParameterfv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glTexParameterfv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glTexParameteri(int i, int i2, int i3) {
        GLES20.glTexParameteri(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glTexParameteriv(int i, int i2, int[] iArr, int i3) {
        GLES20.glTexParameteriv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glTexParameteriv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        GLES20.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform1f(int i, float f) {
        GLES20.glUniform1f(i, f);
        ShaderUtils.m5097a();
    }

    public static void glUniform1fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform1fv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform1fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform1fv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform1i(int i, int i2) {
        GLES20.glUniform1i(i, i2);
        ShaderUtils.m5097a();
    }

    public static void glUniform1iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform1iv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform1iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform1iv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform2f(int i, float f, float f2) {
        GLES20.glUniform2f(i, f, f2);
        ShaderUtils.m5097a();
    }

    public static void glUniform2fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform2fv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform2fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform2fv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform2i(int i, int i2, int i3) {
        GLES20.glUniform2i(i, i2, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform2iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform2iv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform2iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform2iv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform3f(int i, float f, float f2, float f3) {
        GLES20.glUniform3f(i, f, f2, f3);
        ShaderUtils.m5097a();
    }

    public static void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform3fv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform3fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform3fv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform3i(int i, int i2, int i3, int i4) {
        GLES20.glUniform3i(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }

    public static void glUniform3iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform3iv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform3iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform3iv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform4f(int i, float f, float f2, float f3, float f4) {
        GLES20.glUniform4f(i, f, f2, f3, f4);
        ShaderUtils.m5097a();
    }

    public static void glUniform4fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform4fv(i, i2, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform4fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform4fv(i, i2, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        GLES20.glUniform4i(i, i2, i3, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glUniform4iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform4iv(i, i2, iArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniform4iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform4iv(i, i2, intBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES20.glUniformMatrix2fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES20.glUniformMatrix2fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES20.glUniformMatrix3fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES20.glUniformMatrix3fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES20.glUniformMatrix4fv(i, i2, z, fArr, i3);
        ShaderUtils.m5097a();
    }

    public static void glUniformMatrix4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES20.glUniformMatrix4fv(i, i2, z, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glUseProgram(int i) {
        GLES20.glUseProgram(i);
        ShaderUtils.m5097a();
    }

    public static void glValidateProgram(int i) {
        GLES20.glValidateProgram(i);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib1f(int i, float f) {
        GLES20.glVertexAttrib1f(i, f);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib1fv(int i, float[] fArr, int i2) {
        GLES20.glVertexAttrib1fv(i, fArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib1fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib1fv(i, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib2f(int i, float f, float f2) {
        GLES20.glVertexAttrib2f(i, f, f2);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib2fv(int i, float[] fArr, int i2) {
        GLES20.glVertexAttrib2fv(i, fArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib2fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib2fv(i, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib3f(int i, float f, float f2, float f3) {
        GLES20.glVertexAttrib3f(i, f, f2, f3);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib3fv(int i, float[] fArr, int i2) {
        GLES20.glVertexAttrib3fv(i, fArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib3fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib3fv(i, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib4f(int i, float f, float f2, float f3, float f4) {
        GLES20.glVertexAttrib4f(i, f, f2, f3, f4);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib4fv(int i, float[] fArr, int i2) {
        GLES20.glVertexAttrib4fv(i, fArr, i2);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttrib4fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib4fv(i, floatBuffer);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        GLES20.glVertexAttribPointer(i, i2, i3, z, i4, i5);
        ShaderUtils.m5097a();
    }

    public static void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, Buffer buffer) {
        GLES20.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
        ShaderUtils.m5097a();
    }

    public static void glViewport(int i, int i2, int i3, int i4) {
        GLES20.glViewport(i, i2, i3, i4);
        ShaderUtils.m5097a();
    }
}
