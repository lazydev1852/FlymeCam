package flyme.support.p093v7.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: flyme.support.v7.widget.RecyclerViewAccessibilityDelegate */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: a */
    final RecyclerView f18134a;

    /* renamed from: b */
    final AccessibilityDelegateCompat f18135b = new AccessibilityDelegateCompat() {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!RecyclerViewAccessibilityDelegate.this.mo26794a() && RecyclerViewAccessibilityDelegate.this.f18134a.getLayoutManager() != null) {
                RecyclerViewAccessibilityDelegate.this.f18134a.getLayoutManager().mo26580a(view, accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (RecyclerViewAccessibilityDelegate.this.mo26794a() || RecyclerViewAccessibilityDelegate.this.f18134a.getLayoutManager() == null) {
                return false;
            }
            return RecyclerViewAccessibilityDelegate.this.f18134a.getLayoutManager().mo26597a(view, i, bundle);
        }
    };

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f18134a = recyclerView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo26794a() {
        return this.f18134a.mo26357G();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (mo26794a() || this.f18134a.getLayoutManager() == null) {
            return false;
        }
        return this.f18134a.getLayoutManager().mo26595a(i, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (!mo26794a() && this.f18134a.getLayoutManager() != null) {
            this.f18134a.getLayoutManager().mo26583a(accessibilityNodeInfoCompat);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !mo26794a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo26065a(accessibilityEvent);
            }
        }
    }

    /* renamed from: b */
    public AccessibilityDelegateCompat mo26795b() {
        return this.f18135b;
    }
}
