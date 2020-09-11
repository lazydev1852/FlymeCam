package com.meizu.media.camera.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* compiled from: StickerAdapter */
public class StickerItemHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public static ChangeQuickRedirect f7536a;

    /* renamed from: b */
    ImageView f7537b;

    /* renamed from: c */
    ImageView f7538c;

    /* renamed from: d */
    ImageView f7539d;

    /* renamed from: e */
    ImageView f7540e;

    /* renamed from: f */
    ProgressBar f7541f;

    /* renamed from: g */
    View f7542g;

    public StickerItemHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.f7542g = view;
        this.f7537b = (ImageView) view.findViewById(R.id.mz_funny_snap_item_img);
        this.f7540e = (ImageView) view.findViewById(R.id.mz_funny_snap_item_bg);
        this.f7541f = (ProgressBar) view.findViewById(R.id.loadingView);
        this.f7538c = (ImageView) view.findViewById(R.id.mz_funny_snap_left_corner_img);
        this.f7539d = (ImageView) view.findViewById(R.id.mz_funny_snap_right_corner_img);
        this.f7539d.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public void mo18774a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7536a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2261, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f7540e.setImageResource(R.drawable.mz_fs_sticker_select_bg);
            } else {
                this.f7540e.setImageBitmap((Bitmap) null);
            }
        }
    }
}
