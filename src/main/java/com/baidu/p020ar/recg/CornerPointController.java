package com.baidu.p020ar.recg;

/* renamed from: com.baidu.ar.recg.CornerPointController */
public class CornerPointController {
    private ImgRecognitionClient mImgRecognitionClient;

    public ImgRecognitionClient getImgRecognitionClient() {
        if (this.mImgRecognitionClient == null) {
            System.loadLibrary("ImgRecognition");
            this.mImgRecognitionClient = new ImgRecognitionClient();
        }
        return this.mImgRecognitionClient;
    }

    public void release() {
        if (this.mImgRecognitionClient != null) {
            ImgRecognitionClient imgRecognitionClient = this.mImgRecognitionClient;
            ImgRecognitionClient.release();
            this.mImgRecognitionClient = null;
        }
    }
}
