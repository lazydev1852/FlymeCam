package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.e */
public class EventBusException extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public EventBusException(String str) {
        super(str);
    }

    public EventBusException(String str, Throwable th) {
        super(str, th);
    }
}
