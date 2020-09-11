package flyme.support.p093v7.widget;

import androidx.appcompat.widget.ForwardingListener;

/* renamed from: flyme.support.v7.widget.PopupMenu$1 */
class PopupMenu$1 extends ForwardingListener {

    /* renamed from: a */
    final /* synthetic */ PopupMenu f17907a;

    /* access modifiers changed from: protected */
    public boolean onForwardingStarted() {
        this.f17907a.mo27224a();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onForwardingStopped() {
        this.f17907a.mo27225b();
        return true;
    }

    /* renamed from: a */
    public ListPopupWindow getPopup() {
        return this.f17907a.f18558c.mo25769c();
    }
}
