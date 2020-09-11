package com.meizu.sharewidget.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.sharewidget.OnResolveClickListener;
import com.meizu.sharewidget.ResolveFinder;
import com.meizu.sharewidget.ShareOnResolveClickListener;
import com.meizu.sharewidget.ShareResolveFinder;

public class ShareViewGroup extends IntentChooserView {

    /* renamed from: com.meizu.sharewidget.widget.ShareViewGroup$a */
    public interface C2890a {
        /* renamed from: a */
        void mo24077a(Intent intent, ResolveInfo resolveInfo, View view, int i, long j);
    }

    public ShareViewGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShareViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareViewGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: a */
    public ResolveFinder mo24100a(Context context) {
        return new ShareResolveFinder(context);
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: b */
    public OnResolveClickListener mo24105b(Context context) {
        return new ShareOnResolveClickListener();
    }

    public void setOnShareClickListener(C2890a aVar) {
        ((ShareOnResolveClickListener) this.f15940e).mo24095a(aVar);
    }

    @Deprecated
    public void setIsReturnResult(boolean z) {
        super.setForwardResult(z);
    }
}
