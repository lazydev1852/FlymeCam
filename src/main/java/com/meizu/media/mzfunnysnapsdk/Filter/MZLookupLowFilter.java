package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.media.mzfunnysnapsdk.Utils.BitmapTexture;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.io.IOException;

public class MZLookupLowFilter extends MZLookupBaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;

    public MZLookupLowFilter(Resources resources) {
        super(resources);
        this.textureSize = 1;
        this.mFragPath = "shader/beauty/lookup_low.glsl";
        this.mBitmap = new Bitmap[this.textureSize];
        try {
            this.mBitmap[0] = BitmapFactory.decodeStream(resources.getAssets().open("lookup/skinWhitenLookUpTableLow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9114, new Class[0], Void.TYPE).isSupported) {
            super.onCreate();
            this.externalBitmapTextures = new BitmapTexture[this.textureSize];
            for (int i = 0; i < this.textureSize; i++) {
                this.externalBitmapTextures[i] = new BitmapTexture();
                this.externalBitmapTextures[i].loadBitmap(this.mBitmap[i]);
            }
        }
    }

    public void onSetExpandData() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9115, new Class[0], Void.TYPE).isSupported) {
            super.onSetExpandData();
        }
    }

    public void destory() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9116, new Class[0], Void.TYPE).isSupported) {
            for (int i = 0; i < this.textureSize; i++) {
                this.externalBitmapTextures[i].destroy();
            }
        }
    }
}
