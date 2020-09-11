package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, mo27294d2 = {"Lcom/meizu/media/camera/views/ThunbnailRotateImageView;", "Lcom/meizu/media/camera/views/RotateImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setImageBitmap", "", "bm", "Landroid/graphics/Bitmap;", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* compiled from: ThunbnailRotateImageView.kt */
public final class ThunbnailRotateImageView extends RotateImageView {

    /* renamed from: a */
    public static ChangeQuickRedirect f15142a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThunbnailRotateImageView(@NotNull Context context) {
        super(context);
        C3443i.m21155b(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThunbnailRotateImageView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        C3443i.m21155b(context, "context");
        C3443i.m21155b(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThunbnailRotateImageView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C3443i.m21155b(context, "context");
        C3443i.m21155b(attributeSet, "attrs");
    }

    public void setImageBitmap(@Nullable Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f15142a, false, 8909, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            if (bitmap == null || bitmap.isRecycled()) {
                setBackground((Drawable) null);
            } else {
                setBackgroundResource(R.drawable.mz_imageview_selector);
            }
            super.setImageBitmap(bitmap);
        }
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        if (!PatchProxy.proxy(new Object[]{drawable}, this, f15142a, false, 8910, new Class[]{Drawable.class}, Void.TYPE).isSupported) {
            if (drawable == null) {
                setBackground((Drawable) null);
            } else {
                setBackgroundResource(R.drawable.mz_imageview_selector);
            }
            super.setImageDrawable(drawable);
        }
    }
}
