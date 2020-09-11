package androidx.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ViewStubProxy {
    /* access modifiers changed from: private */
    public ViewDataBinding mContainingBinding;
    /* access modifiers changed from: private */
    public ViewStub.OnInflateListener mOnInflateListener;
    private ViewStub.OnInflateListener mProxyListener = new ViewStub.OnInflateListener() {
        public void onInflate(ViewStub viewStub, View view) {
            View unused = ViewStubProxy.this.mRoot = view;
            ViewDataBinding unused2 = ViewStubProxy.this.mViewDataBinding = DataBindingUtil.bind(ViewStubProxy.this.mContainingBinding.mBindingComponent, view, viewStub.getLayoutResource());
            ViewStub unused3 = ViewStubProxy.this.mViewStub = null;
            if (ViewStubProxy.this.mOnInflateListener != null) {
                ViewStubProxy.this.mOnInflateListener.onInflate(viewStub, view);
                ViewStub.OnInflateListener unused4 = ViewStubProxy.this.mOnInflateListener = null;
            }
            ViewStubProxy.this.mContainingBinding.invalidateAll();
            ViewStubProxy.this.mContainingBinding.forceExecuteBindings();
        }
    };
    /* access modifiers changed from: private */
    public View mRoot;
    /* access modifiers changed from: private */
    public ViewDataBinding mViewDataBinding;
    /* access modifiers changed from: private */
    public ViewStub mViewStub;

    public ViewStubProxy(@NonNull ViewStub viewStub) {
        this.mViewStub = viewStub;
        this.mViewStub.setOnInflateListener(this.mProxyListener);
    }

    public void setContainingBinding(@NonNull ViewDataBinding viewDataBinding) {
        this.mContainingBinding = viewDataBinding;
    }

    public boolean isInflated() {
        return this.mRoot != null;
    }

    public View getRoot() {
        return this.mRoot;
    }

    @Nullable
    public ViewDataBinding getBinding() {
        return this.mViewDataBinding;
    }

    @Nullable
    public ViewStub getViewStub() {
        return this.mViewStub;
    }

    public void setOnInflateListener(@Nullable ViewStub.OnInflateListener onInflateListener) {
        if (this.mViewStub != null) {
            this.mOnInflateListener = onInflateListener;
        }
    }
}
