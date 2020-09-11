package com.meizu.savior.utils;

import com.meizu.savior.ChangeQuickRedirect;
import java.util.Map;
import java.util.WeakHashMap;

public class PatchTemplate implements ChangeQuickRedirect {
    public static final String MATCH_ALL_PARAMETER = "(\\w*\\.)*\\w*";
    private static final Map<Object, Object> keyToValueRelation = new WeakHashMap();

    public static Object fixObj(Object obj) {
        if (!(obj instanceof Byte)) {
            return obj;
        }
        return new Boolean(((Byte) obj).byteValue() != 0);
    }

    public Object accessDispatch(String str, Object[] objArr) {
        return null;
    }

    public boolean isSupport(String str, Object[] objArr) {
        return true;
    }
}
