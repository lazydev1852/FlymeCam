package com.baidu.p020ar.blend.gpuimage.p039a;

/* renamed from: com.baidu.ar.blend.gpuimage.a.p */
public class C0733p extends C0739s {
    public C0733p() {
        super("varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     lowp vec4 firstTexture = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 secondTexture = texture2D(inputImageTexture2, textureCoordinate2);\n     \n     \n     gl_FragColor = vec4(firstTexture.x, firstTexture.y, firstTexture.z, secondTexture.w);\n }");
    }
}
