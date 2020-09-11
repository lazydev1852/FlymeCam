package com.baidu.p020ar.blend.gpuimage.p039a;

/* renamed from: com.baidu.ar.blend.gpuimage.a.d */
public class C0709d extends C0739s {
    public C0709d() {
        super(" precision highp float;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     vec4 firstTexture = texture2D(inputImageTexture, textureCoordinate);\n     vec4 secondTexture = texture2D(inputImageTexture2, textureCoordinate2);\n     \n     vec4 outputColor;\n     \n     float a = secondTexture.a + firstTexture.a * (1.0 - secondTexture.a);\n     outputColor.r = secondTexture.r + firstTexture.r * (1.0 - secondTexture.a);\n     \n     outputColor.g = secondTexture.g + firstTexture.g * (1.0 - secondTexture.a);\n     \n     outputColor.b = secondTexture.b + firstTexture.b * (1.0 - secondTexture.a);\n     \n     outputColor.a = a;\n     \n     gl_FragColor = outputColor;\n }");
    }
}