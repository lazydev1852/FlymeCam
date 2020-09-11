package com.meizu.savior;

public interface ChangeQuickRedirect {
    Object accessDispatch(String str, Object[] objArr);

    boolean isSupport(String str, Object[] objArr);
}
