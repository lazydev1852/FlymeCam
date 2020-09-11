package com.meizu.media.camera.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.lang.ref.WeakReference;

public class ToastTextView extends AppCompatTextView {

    /* renamed from: a */
    public static ChangeQuickRedirect f15143a;

    /* renamed from: b */
    private C2731a f15144b;

    public ToastTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16645b();
    }

    /* renamed from: b */
    private void m16645b() {
        if (!PatchProxy.proxy(new Object[0], this, f15143a, false, 8913, new Class[0], Void.TYPE).isSupported) {
            this.f15144b = new C2731a(this);
        }
    }

    public void setToastText(CharSequence charSequence) {
        if (!PatchProxy.proxy(new Object[]{charSequence}, this, f15143a, false, 8914, new Class[]{CharSequence.class}, Void.TYPE).isSupported) {
            this.f15144b.removeMessages(1);
            setVisibility(0);
            setText(charSequence);
            this.f15144b.sendEmptyMessageDelayed(1, 2000);
        }
    }

    /* renamed from: a */
    public void mo23268a() {
        if (!PatchProxy.proxy(new Object[0], this, f15143a, false, 8915, new Class[0], Void.TYPE).isSupported) {
            this.f15144b.removeMessages(1);
            setVisibility(4);
        }
    }

    /* renamed from: com.meizu.media.camera.views.ToastTextView$a */
    private static class C2731a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f15145a;

        /* renamed from: b */
        private final WeakReference<View> f15146b;

        public C2731a(View view) {
            this.f15146b = new WeakReference<>(view);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f15145a, false, 8916, new Class[]{Message.class}, Void.TYPE).isSupported && this.f15146b.get() != null) {
                ((View) this.f15146b.get()).setVisibility(4);
            }
        }
    }
}
