package com.meizu.flyme.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.meizu.flyme.palette.a */
public class PrimaryColor {

    /* renamed from: a */
    private static final C1564b f6440a = new C1564b();

    /* renamed from: com.meizu.flyme.palette.a$a */
    /* compiled from: PrimaryColor */
    public static class C1563a {

        /* renamed from: a */
        public int f6441a;

        /* renamed from: b */
        public int f6442b;

        /* renamed from: c */
        public int f6443c;

        /* renamed from: d */
        public float f6444d;

        /* renamed from: e */
        public float f6445e;

        /* renamed from: f */
        public float f6446f;

        /* renamed from: g */
        public int f6447g;

        /* renamed from: h */
        public int f6448h;

        /* renamed from: i */
        public int f6449i;

        /* renamed from: j */
        public boolean f6450j;

        public C1563a(int i, int i2, int i3, float f, float f2, float f3, int i4, int i5) {
            this.f6441a = i;
            this.f6442b = i2;
            this.f6443c = i3;
            this.f6444d = f;
            this.f6445e = f2;
            this.f6446f = f3;
            this.f6447g = i4;
            this.f6448h = i5;
            this.f6449i = f3 > 0.5f ? 1 : 0;
            this.f6450j = false;
        }
    }

    /* renamed from: a */
    public static int m6344a(List<Palette.Swatch> list) {
        int i;
        int i2 = ViewCompat.MEASURED_STATE_MASK;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<Palette.Swatch> it = list.iterator();
            while (true) {
                i = 1;
                if (!it.hasNext()) {
                    break;
                }
                Palette.Swatch next = it.next();
                int rgb = next.getRgb();
                int red = Color.red(rgb);
                int green = Color.green(rgb);
                int blue = Color.blue(rgb);
                float[] hsl = next.getHsl();
                float f = hsl[0];
                float f2 = hsl[1];
                float f3 = hsl[2];
                int population = next.getPopulation();
                C1563a aVar = r8;
                C1563a aVar2 = new C1563a(red, green, blue, f, f2, f3, rgb, population);
                arrayList.add(aVar);
            }
            Collections.sort(arrayList, f6440a);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                C1563a aVar3 = (C1563a) arrayList.get(i3);
                if (!aVar3.f6450j) {
                    aVar3.f6450j = true;
                    for (int i4 = i3 + 1; i4 < arrayList.size(); i4++) {
                        C1563a aVar4 = (C1563a) arrayList.get(i4);
                        if (!aVar4.f6450j && Math.abs(aVar3.f6444d - aVar4.f6444d) < 20.0f && Math.abs(aVar3.f6445e - aVar4.f6445e) < 0.2f && Math.abs(aVar3.f6446f - aVar4.f6446f) < 0.3f) {
                            aVar4.f6450j = true;
                            aVar3.f6448h += aVar4.f6448h;
                        }
                    }
                    arrayList2.add(aVar3);
                }
            }
            if (arrayList2.size() > 0) {
                C1563a aVar5 = (C1563a) arrayList2.get(0);
                if (aVar5.f6449i == 1) {
                    while (true) {
                        if (i >= arrayList2.size()) {
                            break;
                        } else if (aVar5.f6448h < ((C1563a) arrayList2.get(i)).f6448h * 2) {
                            aVar5 = (C1563a) arrayList2.get(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                i2 = aVar5.f6447g;
            }
            arrayList.clear();
            arrayList2.clear();
        }
        return i2;
    }

    /* renamed from: a */
    public static int m6343a(Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            Palette generate = Palette.from(bitmap).clearFilters().addFilter(HSLFilter.f6439a).generate();
            Palette.Swatch vibrantSwatch = generate.getVibrantSwatch();
            if (!m6345a(generate.getDarkVibrantSwatch())) {
                vibrantSwatch = generate.getDarkVibrantSwatch();
            } else if (!m6345a(generate.getDarkMutedSwatch())) {
                vibrantSwatch = generate.getDarkMutedSwatch();
            } else if (!m6345a(generate.getVibrantSwatch())) {
                vibrantSwatch = generate.getVibrantSwatch();
            } else if (!m6345a(generate.getLightVibrantSwatch())) {
                vibrantSwatch = generate.getLightVibrantSwatch();
            } else if (!m6345a(generate.getMutedSwatch())) {
                vibrantSwatch = generate.getMutedSwatch();
            } else if (!m6345a(generate.getLightMutedSwatch())) {
                vibrantSwatch = generate.getLightMutedSwatch();
            }
            i = vibrantSwatch != null ? vibrantSwatch.getRgb() : m6344a(generate.getSwatches());
        } else {
            i = ViewCompat.MEASURED_STATE_MASK;
        }
        return m6342a(i);
    }

    /* renamed from: a */
    private static boolean m6345a(Palette.Swatch swatch) {
        if (swatch == null) {
            return true;
        }
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(swatch.getRgb(), fArr);
        if (fArr[1] < 0.05f) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m6342a(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        if (fArr[2] > 0.92f && fArr[0] >= 50.0f && fArr[0] <= 180.0f) {
            fArr[2] = 0.92f;
        }
        if (((double) fArr[1]) < 0.35d && ((double) fArr[1]) > 0.1d && ((double) fArr[2]) > 0.05d) {
            fArr[1] = 0.4f;
        }
        return Color.HSVToColor(fArr);
    }

    /* renamed from: com.meizu.flyme.palette.a$b */
    /* compiled from: PrimaryColor */
    private static class C1564b implements Comparator<C1563a> {
        private C1564b() {
        }

        /* renamed from: a */
        public int compare(C1563a aVar, C1563a aVar2) {
            return aVar2.f6448h - aVar.f6448h;
        }
    }
}
