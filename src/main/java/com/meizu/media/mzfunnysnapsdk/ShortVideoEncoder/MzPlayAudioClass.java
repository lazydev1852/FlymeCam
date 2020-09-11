package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.io.File;

public class MzPlayAudioClass {
    private static final String TAG = "ShortVideo PlayAudio";
    public static ChangeQuickRedirect changeQuickRedirect;
    private Context mContext;
    private MediaPlayer musicPlayer;

    public MzPlayAudioClass(Context context) {
        this.mContext = context;
    }

    public void startPlayer(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9314, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (TextUtils.isEmpty(str)) {
                Log.i("FunnySnapFlow", " MzPlayAudioClass startPlayer path null");
                return;
            }
            release();
            this.musicPlayer = MediaPlayer.create(this.mContext, Uri.parse(new File(str).getAbsolutePath()));
            if (this.musicPlayer != null) {
                this.musicPlayer.start();
                Log.i("FunnySnapFlow", " MzPlayAudioClass startPlayer()");
                this.musicPlayer.setLooping(true);
            }
        }
    }

    public void stopPlayer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9315, new Class[0], Void.TYPE).isSupported && this.musicPlayer != null) {
            Log.i("FunnySnapFlow", " MzPlayAudioClass stopPlayer()");
            this.musicPlayer.stop();
        }
    }

    public void release() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9316, new Class[0], Void.TYPE).isSupported && this.musicPlayer != null) {
            Log.i("FunnySnapFlow", " MzPlayAudioClass release()");
            this.musicPlayer.release();
            this.musicPlayer = null;
        }
    }
}
