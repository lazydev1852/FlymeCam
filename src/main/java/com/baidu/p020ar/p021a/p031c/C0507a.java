package com.baidu.p020ar.p021a.p031c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.baidu.ar.a.c.a */
public class C0507a {

    /* renamed from: a */
    List<Integer> f614a = new ArrayList();

    /* renamed from: b */
    Integer[] f615b = new Integer[this.f617d];

    /* renamed from: c */
    Comparator<Integer> f616c = new Comparator<Integer>() {
        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            if (num.intValue() > num2.intValue()) {
                return 1;
            }
            return num.intValue() < num2.intValue() ? -1 : 0;
        }
    };

    /* renamed from: d */
    private int f617d = 10;

    /* renamed from: a */
    private int m908a(Integer[] numArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += numArr[i3].intValue();
        }
        return i2;
    }

    /* renamed from: b */
    private int m909b() {
        int size = this.f614a.size();
        if (size > this.f617d) {
            return 0;
        }
        if (size == 1) {
            return this.f614a.get(0).intValue();
        }
        if (size == 0) {
            return 0;
        }
        if (size == 2) {
            return (int) ((((float) (this.f614a.get(0).intValue() + this.f614a.get(1).intValue())) * 1.0f) / 2.0f);
        }
        if (this.f615b.length != this.f617d) {
            this.f615b = new Integer[this.f617d];
        }
        System.arraycopy(this.f614a.toArray(), 0, this.f615b, 0, size);
        Arrays.sort(this.f615b, 0, size, this.f616c);
        int intValue = this.f615b[0].intValue();
        return (int) ((((float) ((m908a(this.f615b, size) - intValue) - this.f615b[size - 1].intValue())) * 1.0f) / ((float) (size - 2)));
    }

    /* renamed from: b */
    private void m910b(int i) {
        if (this.f614a.size() >= this.f617d) {
            this.f614a.remove(0);
        }
        this.f614a.add(Integer.valueOf(i));
    }

    /* renamed from: a */
    public int mo8973a(int i) {
        m910b(i);
        return m909b();
    }

    /* renamed from: a */
    public void mo8974a() {
        this.f614a.clear();
        this.f615b = null;
    }
}
