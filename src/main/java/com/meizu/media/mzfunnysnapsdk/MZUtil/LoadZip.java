package com.meizu.media.mzfunnysnapsdk.MZUtil;

import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.JSONParser;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.SpriteJSON;
import com.meizu.media.mzfunnysnapsdk.AssetsZip.BitmapPart;
import com.meizu.media.mzfunnysnapsdk.AssetsZip.StickerPart;
import com.meizu.media.mzfunnysnapsdk.AssetsZip.UnZipClass;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

public class LoadZip {
    public static ChangeQuickRedirect changeQuickRedirect;
    private JSONParser jsonStream;
    private BitmapPart[] mParts;
    private UnZipClass mZip;

    public boolean loadZipFile(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9215, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.mZip != null) {
            this.mZip = null;
            this.mParts = null;
            this.jsonStream = null;
        }
        this.mZip = new UnZipClass();
        try {
            if (!this.mZip.readZipFile(str)) {
                return false;
            }
            this.mParts = this.mZip.getBitmapParts();
            this.jsonStream = this.mZip.getJson();
            return true;
        } catch (Exception e) {
            Log.e("ceshi", e.getMessage());
            return false;
        }
    }

    public SpriteJSON getJson() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9216, new Class[0], SpriteJSON.class);
        if (proxy.isSupported) {
            return (SpriteJSON) proxy.result;
        }
        if (this.mZip == null) {
            return null;
        }
        return this.jsonStream.getJsonInfo();
    }

    public BitmapPart getBitmapPart(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect3, false, 9217, new Class[]{Integer.TYPE}, BitmapPart.class);
        if (proxy.isSupported) {
            return (BitmapPart) proxy.result;
        }
        if (this.mZip == null) {
            return null;
        }
        return this.mZip.getBitmapPart(i);
    }

    public BitmapPart getBitmapPart(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9218, new Class[]{String.class}, BitmapPart.class);
        if (proxy.isSupported) {
            return (BitmapPart) proxy.result;
        }
        if (this.mZip == null) {
            return null;
        }
        return this.mZip.getBitmapPart(str);
    }

    public BitmapPart[] getBitmapParts() {
        if (this.mZip == null) {
            return null;
        }
        return this.mParts;
    }

    public StickerPart[] getStickerPart() {
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9219, new Class[0], StickerPart[].class);
        if (proxy.isSupported) {
            return (StickerPart[]) proxy.result;
        }
        if (this.mZip == null || (i = this.jsonStream.getJsonInfo().parts_num) <= 0) {
            return null;
        }
        StickerPart[] stickerPartArr = new StickerPart[i];
        for (int i2 = 0; i2 < i; i2++) {
            stickerPartArr[i2] = new StickerPart();
            stickerPartArr[i2].json = this.jsonStream.getJsonPart(i2);
            stickerPartArr[i2].bitmap = getBitmapPart(stickerPartArr[i2].json.f15596id);
        }
        return stickerPartArr;
    }

    public ArrayList<StickerPart> getStickerPartList() {
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9220, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        if (this.mZip == null || (i = this.jsonStream.getJsonInfo().parts_num) <= 0) {
            return null;
        }
        ArrayList<StickerPart> arrayList = new ArrayList<>();
        arrayList.clear();
        for (int i2 = 0; i2 < i; i2++) {
            StickerPart stickerPart = new StickerPart();
            stickerPart.json = this.jsonStream.getJsonPart(i2);
            stickerPart.bitmap = getBitmapPart(stickerPart.json.f15596id);
            arrayList.add(i2, stickerPart);
        }
        return arrayList;
    }
}
