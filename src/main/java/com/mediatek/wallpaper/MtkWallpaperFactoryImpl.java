package com.mediatek.wallpaper;

import android.content.Context;
import android.util.Log;
import com.mediatek.common.wallpaper.IWallpaperPlugin;
import com.mediatek.common.wallpaper.OpWallpaperCustomizationFactoryBase;
import java.io.InputStream;

public final class MtkWallpaperFactoryImpl extends MtkWallpaperFactory {
    private static final String TAG = "MtkWallpaperFactoryImpl";
    private static MtkWallpaperFactoryImpl sInstance;

    public static MtkWallpaperFactoryImpl getInstance() {
        if (sInstance == null) {
            sInstance = new MtkWallpaperFactoryImpl();
        }
        return sInstance;
    }

    public InputStream openDefaultWallpaper(Context context, int i) {
        IWallpaperPlugin makeWallpaperPlugin = OpWallpaperCustomizationFactoryBase.getOpFactory(context).makeWallpaperPlugin(context);
        if (makeWallpaperPlugin == null) {
            return null;
        }
        Log.d(TAG, "get the wallpaper image from the plug-in");
        if (makeWallpaperPlugin.getPluginResources(context) != null) {
            return makeWallpaperPlugin.getPluginResources(context).openRawResource(makeWallpaperPlugin.getPluginDefaultImage());
        }
        return null;
    }
}
