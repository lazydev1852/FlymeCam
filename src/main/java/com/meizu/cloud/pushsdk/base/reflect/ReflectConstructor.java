package com.meizu.cloud.pushsdk.base.reflect;

import com.meizu.cloud.pushsdk.base.Logger;
import java.lang.reflect.Constructor;

public class ReflectConstructor {
    private String TAG = "ReflectConstructor";
    private ReflectClass mReflectClass;
    private Class<?>[] mTypes;

    ReflectConstructor(ReflectClass reflectClass, Class<?>... clsArr) {
        this.mReflectClass = reflectClass;
        this.mTypes = clsArr;
    }

    public <T> ReflectResult<T> newInstance(Object... objArr) {
        ReflectResult<T> reflectResult = new ReflectResult<>();
        try {
            Constructor<?> declaredConstructor = this.mReflectClass.getRealClass().getDeclaredConstructor(this.mTypes);
            declaredConstructor.setAccessible(true);
            reflectResult.value = declaredConstructor.newInstance(objArr);
            reflectResult.f4119ok = true;
        } catch (Exception e) {
            Logger.get().mo14453e(this.TAG, "newInstance", e);
        }
        return reflectResult;
    }
}
