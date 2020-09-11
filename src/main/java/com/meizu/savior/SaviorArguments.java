package com.meizu.savior;

public class SaviorArguments {
    public Object current;
    public boolean isStatic;
    public int methodNumber;
    public Object[] paramsArray;
    public Class[] paramsClassTypes;
    public Class returnType;

    public SaviorArguments(Object[] objArr, Object obj, boolean z, int i, Class[] clsArr, Class cls) {
        this.paramsArray = objArr;
        this.current = obj;
        this.isStatic = z;
        this.methodNumber = i;
        this.paramsClassTypes = clsArr;
        this.returnType = cls;
    }
}
