package com.meizu.media.mzfunnysnapsdk.AssetsZip;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class BitmapFileDescription {
    public static ChangeQuickRedirect changeQuickRedirect;
    int endPos;
    String name;
    int startPos;

    public BitmapFileDescription(String str, int i, int i2) {
        this.name = str;
        this.startPos = i;
        this.endPos = i2;
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9049, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "name: " + this.name + " startPos: " + this.startPos + " endPos: " + this.endPos;
    }
}
