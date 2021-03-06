package com.baidu.p020ar.recorder.filter;

import android.content.Context;
import com.baidu.p020ar.recorder.p047e.C0859d;

/* renamed from: com.baidu.ar.recorder.filter.d */
public class C0870d extends C0868b {
    public C0870d(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo10544a(Context context) {
        return C0859d.m2465a("uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;//fragment中没有默认的浮点数精度修饰符。因此，对于浮点数，浮点数向量和矩阵变量声明，必须声明包含一个精度修饰符。\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
    }

    /* renamed from: f */
    public int mo10554f() {
        return 3553;
    }
}
