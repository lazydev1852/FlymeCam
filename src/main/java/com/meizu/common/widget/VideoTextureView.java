package com.meizu.common.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

public class VideoTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a */
    private C1548a f6318a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Uri f6319b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MediaPlayer f6320c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Surface f6321d;

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public VideoTextureView(Context context) {
        super(context);
        m6243a();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6243a();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6243a();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m6243a();
    }

    /* renamed from: a */
    private void m6243a() {
        setSurfaceTextureListener(this);
    }

    public void setSourceUri(Uri uri) {
        this.f6319b = uri;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f6321d = new Surface(surfaceTexture);
        if (this.f6318a == null) {
            this.f6318a = new C1548a();
            this.f6318a.start();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f6320c.stop();
        this.f6320c.release();
        this.f6318a = null;
        return true;
    }

    /* renamed from: com.meizu.common.widget.VideoTextureView$a */
    private class C1548a extends Thread {
        private C1548a() {
        }

        public void run() {
            try {
                MediaPlayer unused = VideoTextureView.this.f6320c = new MediaPlayer();
                VideoTextureView.this.f6320c.setSurface(VideoTextureView.this.f6321d);
                VideoTextureView.this.f6320c.setDataSource(VideoTextureView.this.getContext(), VideoTextureView.this.f6319b);
                VideoTextureView.this.f6320c.setAudioStreamType(3);
                VideoTextureView.this.f6320c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        VideoTextureView.this.f6320c.start();
                    }
                });
                VideoTextureView.this.f6320c.setLooping(true);
                VideoTextureView.this.f6320c.prepare();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
