package com.meizu.update.p091e;

import com.meizu.update.component.StateListener;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* renamed from: com.meizu.update.e.a */
public class StateCallbackKeeper {

    /* renamed from: a */
    private static LinkedList<WeakReference<StateListener>> f16288a;

    /* renamed from: a */
    public static synchronized LinkedList<WeakReference<StateListener>> m17770a() {
        LinkedList<WeakReference<StateListener>> linkedList;
        synchronized (StateCallbackKeeper.class) {
            linkedList = f16288a;
        }
        return linkedList;
    }
}
