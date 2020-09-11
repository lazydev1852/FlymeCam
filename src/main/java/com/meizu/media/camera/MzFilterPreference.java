package com.meizu.media.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class MzFilterPreference extends CameraPreference {

    /* renamed from: b */
    private int f7074b;

    /* renamed from: c */
    private String f7075c;

    /* renamed from: d */
    private String f7076d;

    /* renamed from: e */
    private String f7077e;

    public MzFilterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FilterItem, 0, 0);
        this.f7074b = obtainStyledAttributes.getResourceId(0, -1);
        this.f7075c = obtainStyledAttributes.getString(1);
        this.f7076d = obtainStyledAttributes.getString(2);
        this.f7077e = obtainStyledAttributes.getString(3);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    public int mo18347c() {
        return this.f7074b;
    }

    /* renamed from: d */
    public String mo18348d() {
        return this.f7075c;
    }

    /* renamed from: a */
    public String mo18346a() {
        return this.f7076d;
    }

    /* renamed from: e */
    public String mo18349e() {
        return this.f7077e;
    }
}
