package com.meizu.savior;

public interface SaviorExtension {
    Object accessDispatch(SaviorArguments saviorArguments);

    String describeSelfFunction();

    boolean isSupport(SaviorArguments saviorArguments);

    void notifyListner(String str);
}
