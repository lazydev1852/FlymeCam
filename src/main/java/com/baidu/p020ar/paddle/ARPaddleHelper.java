package com.baidu.p020ar.paddle;

import com.baidu.p020ar.p021a.p022a.p023a.C0487a;
import com.baidu.searchbox.ai.PaddleHelper;
import com.baidu.searchbox.ai.data.FloatMatrix;

/* renamed from: com.baidu.ar.paddle.ARPaddleHelper */
public class ARPaddleHelper implements C0487a {

    /* renamed from: a */
    PaddleHelper f1902a = new PaddleHelper();

    /* renamed from: b */
    C0487a.C0489b f1903b;

    /* renamed from: c */
    PaddleHelper.InitCallback f1904c = new PaddleHelper.InitCallback() {
        public void onFailure(int i, String str) {
            if (ARPaddleHelper.this.f1903b != null) {
                ARPaddleHelper.this.f1903b.mo8926a(i, str);
            }
        }

        public void onInited() {
            if (ARPaddleHelper.this.f1903b != null) {
                ARPaddleHelper.this.f1903b.mo8925a();
            }
        }
    };

    /* renamed from: d */
    C0487a.C0490c f1905d;

    /* renamed from: e */
    PaddleHelper.PredictCallback f1906e = new PaddleHelper.PredictCallback() {
        public void onFailure(int i, String str) {
            if (ARPaddleHelper.this.f1905d != null) {
                ARPaddleHelper.this.f1905d.mo8927a(i, str);
            }
        }

        public void onResult(FloatMatrix floatMatrix) {
            if (ARPaddleHelper.this.f1905d != null) {
                C0487a.C0488a aVar = new C0487a.C0488a();
                if (floatMatrix != null) {
                    aVar.mo8924a(floatMatrix.data, floatMatrix.width, floatMatrix.height);
                    ARPaddleHelper.this.f1905d.mo8928a(aVar);
                }
            }
        }
    };

    public void close() {
        try {
            this.f1902a.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int init(String str, String str2) {
        return this.f1902a.init(str, str2);
    }

    public int init(byte[] bArr, String str) {
        return this.f1902a.init(bArr, str);
    }

    public void initAsync(String str, String str2, C0487a.C0489b bVar) {
        this.f1903b = bVar;
        this.f1902a.initAsync(str, str2, this.f1904c);
    }

    public void initAsync(byte[] bArr, String str, C0487a.C0489b bVar) {
        this.f1903b = bVar;
        this.f1902a.initAsync(bArr, str, this.f1904c);
    }

    public void predictAsyncForFloatMatrix(float[] fArr, int i, int i2, int i3, C0487a.C0490c cVar) {
        this.f1905d = cVar;
        this.f1902a.predictAsyncForFloatMatrix(fArr, i, i2, i3, this.f1906e);
    }

    public C0487a.C0488a predictForFloatMatrix(float[] fArr, int i, int i2, int i3) {
        FloatMatrix predictForFloatMatrix = this.f1902a.predictForFloatMatrix(fArr, i, i2, i3);
        if (predictForFloatMatrix == null) {
            return null;
        }
        C0487a.C0488a aVar = new C0487a.C0488a();
        aVar.mo8924a(predictForFloatMatrix.data, predictForFloatMatrix.width, predictForFloatMatrix.height);
        return aVar;
    }
}
