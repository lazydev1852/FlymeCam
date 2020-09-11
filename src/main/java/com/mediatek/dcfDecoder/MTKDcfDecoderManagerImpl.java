package com.mediatek.dcfDecoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mediatek.dcfdecoder.DcfDecoder;
import java.io.FileDescriptor;
import java.io.InputStream;

public final class MTKDcfDecoderManagerImpl extends MTKDcfDecoderManager {
    public Bitmap decodeDrmImageIfNeededImpl(byte[] bArr, InputStream inputStream, BitmapFactory.Options options) {
        return DcfDecoder.decodeDrmImageIfNeeded(bArr, inputStream, options);
    }

    public Bitmap decodeDrmImageIfNeededImpl(FileDescriptor fileDescriptor, BitmapFactory.Options options) {
        return DcfDecoder.decodeDrmImageIfNeeded(fileDescriptor, options);
    }

    public Bitmap decodeDrmImageIfNeededImpl(byte[] bArr, BitmapFactory.Options options) {
        return DcfDecoder.decodeDrmImageIfNeeded(bArr, options);
    }
}
