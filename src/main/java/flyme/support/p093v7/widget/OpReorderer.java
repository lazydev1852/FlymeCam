package flyme.support.p093v7.widget;

import flyme.support.p093v7.widget.AdapterHelper;
import java.util.List;

/* renamed from: flyme.support.v7.widget.o */
public class OpReorderer {

    /* renamed from: a */
    final C3339a f18552a;

    /* renamed from: flyme.support.v7.widget.o$a */
    /* compiled from: OpReorderer */
    interface C3339a {
        /* renamed from: a */
        AdapterHelper.C3324b mo27063a(int i, int i2, int i3, Object obj);

        /* renamed from: a */
        void mo27065a(AdapterHelper.C3324b bVar);
    }

    public OpReorderer(C3339a aVar) {
        this.f18552a = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27205a(List<AdapterHelper.C3324b> list) {
        while (true) {
            int b = m20707b(list);
            if (b != -1) {
                m20706a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m20706a(List<AdapterHelper.C3324b> list, int i, int i2) {
        AdapterHelper.C3324b bVar = list.get(i);
        AdapterHelper.C3324b bVar2 = list.get(i2);
        int i3 = bVar2.f18448a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    m20708c(list, i, bVar, i2, bVar2);
                    return;
                case 2:
                    mo27206a(list, i, bVar, i2, bVar2);
                    return;
                default:
                    return;
            }
        } else {
            mo27207b(list, i, bVar, i2, bVar2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27206a(java.util.List<flyme.support.p093v7.widget.AdapterHelper.C3324b> r9, int r10, flyme.support.p093v7.widget.AdapterHelper.C3324b r11, int r12, flyme.support.p093v7.widget.AdapterHelper.C3324b r13) {
        /*
            r8 = this;
            int r0 = r11.f18449b
            int r1 = r11.f18451d
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x001c
            int r0 = r13.f18449b
            int r1 = r11.f18449b
            if (r0 != r1) goto L_0x001a
            int r0 = r13.f18451d
            int r1 = r11.f18451d
            int r4 = r11.f18449b
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x001a
            r0 = 0
        L_0x0018:
            r2 = 1
            goto L_0x002f
        L_0x001a:
            r0 = 0
            goto L_0x002f
        L_0x001c:
            int r0 = r13.f18449b
            int r1 = r11.f18451d
            int r1 = r1 + r3
            if (r0 != r1) goto L_0x002e
            int r0 = r13.f18451d
            int r1 = r11.f18449b
            int r4 = r11.f18451d
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x002e
            r0 = 1
            goto L_0x0018
        L_0x002e:
            r0 = 1
        L_0x002f:
            int r1 = r11.f18451d
            int r4 = r13.f18449b
            r5 = 2
            if (r1 >= r4) goto L_0x003c
            int r1 = r13.f18449b
            int r1 = r1 - r3
            r13.f18449b = r1
            goto L_0x005b
        L_0x003c:
            int r1 = r11.f18451d
            int r4 = r13.f18449b
            int r6 = r13.f18451d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x005b
            int r10 = r13.f18451d
            int r10 = r10 - r3
            r13.f18451d = r10
            r11.f18448a = r5
            r11.f18451d = r3
            int r10 = r13.f18451d
            if (r10 != 0) goto L_0x005a
            r9.remove(r12)
            flyme.support.v7.widget.o$a r9 = r8.f18552a
            r9.mo27065a(r13)
        L_0x005a:
            return
        L_0x005b:
            int r1 = r11.f18449b
            int r4 = r13.f18449b
            r6 = 0
            if (r1 > r4) goto L_0x0068
            int r1 = r13.f18449b
            int r1 = r1 + r3
            r13.f18449b = r1
            goto L_0x0089
        L_0x0068:
            int r1 = r11.f18449b
            int r4 = r13.f18449b
            int r7 = r13.f18451d
            int r4 = r4 + r7
            if (r1 >= r4) goto L_0x0089
            int r1 = r13.f18449b
            int r4 = r13.f18451d
            int r1 = r1 + r4
            int r4 = r11.f18449b
            int r1 = r1 - r4
            flyme.support.v7.widget.o$a r4 = r8.f18552a
            int r7 = r11.f18449b
            int r7 = r7 + r3
            flyme.support.v7.widget.c$b r6 = r4.mo27063a(r5, r7, r1, r6)
            int r1 = r11.f18449b
            int r3 = r13.f18449b
            int r1 = r1 - r3
            r13.f18451d = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r9.set(r10, r13)
            r9.remove(r12)
            flyme.support.v7.widget.o$a r9 = r8.f18552a
            r9.mo27065a(r11)
            return
        L_0x0097:
            if (r0 == 0) goto L_0x00d0
            if (r6 == 0) goto L_0x00b5
            int r0 = r11.f18449b
            int r1 = r6.f18449b
            if (r0 <= r1) goto L_0x00a8
            int r0 = r11.f18449b
            int r1 = r6.f18451d
            int r0 = r0 - r1
            r11.f18449b = r0
        L_0x00a8:
            int r0 = r11.f18451d
            int r1 = r6.f18449b
            if (r0 <= r1) goto L_0x00b5
            int r0 = r11.f18451d
            int r1 = r6.f18451d
            int r0 = r0 - r1
            r11.f18451d = r0
        L_0x00b5:
            int r0 = r11.f18449b
            int r1 = r13.f18449b
            if (r0 <= r1) goto L_0x00c2
            int r0 = r11.f18449b
            int r1 = r13.f18451d
            int r0 = r0 - r1
            r11.f18449b = r0
        L_0x00c2:
            int r0 = r11.f18451d
            int r1 = r13.f18449b
            if (r0 <= r1) goto L_0x0106
            int r0 = r11.f18451d
            int r1 = r13.f18451d
            int r0 = r0 - r1
            r11.f18451d = r0
            goto L_0x0106
        L_0x00d0:
            if (r6 == 0) goto L_0x00ec
            int r0 = r11.f18449b
            int r1 = r6.f18449b
            if (r0 < r1) goto L_0x00df
            int r0 = r11.f18449b
            int r1 = r6.f18451d
            int r0 = r0 - r1
            r11.f18449b = r0
        L_0x00df:
            int r0 = r11.f18451d
            int r1 = r6.f18449b
            if (r0 < r1) goto L_0x00ec
            int r0 = r11.f18451d
            int r1 = r6.f18451d
            int r0 = r0 - r1
            r11.f18451d = r0
        L_0x00ec:
            int r0 = r11.f18449b
            int r1 = r13.f18449b
            if (r0 < r1) goto L_0x00f9
            int r0 = r11.f18449b
            int r1 = r13.f18451d
            int r0 = r0 - r1
            r11.f18449b = r0
        L_0x00f9:
            int r0 = r11.f18451d
            int r1 = r13.f18449b
            if (r0 < r1) goto L_0x0106
            int r0 = r11.f18451d
            int r1 = r13.f18451d
            int r0 = r0 - r1
            r11.f18451d = r0
        L_0x0106:
            r9.set(r10, r13)
            int r13 = r11.f18449b
            int r0 = r11.f18451d
            if (r13 == r0) goto L_0x0113
            r9.set(r12, r11)
            goto L_0x0116
        L_0x0113:
            r9.remove(r12)
        L_0x0116:
            if (r6 == 0) goto L_0x011b
            r9.add(r10, r6)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.OpReorderer.mo27206a(java.util.List, int, flyme.support.v7.widget.c$b, int, flyme.support.v7.widget.c$b):void");
    }

    /* renamed from: c */
    private void m20708c(List<AdapterHelper.C3324b> list, int i, AdapterHelper.C3324b bVar, int i2, AdapterHelper.C3324b bVar2) {
        int i3 = bVar.f18451d < bVar2.f18449b ? -1 : 0;
        if (bVar.f18449b < bVar2.f18449b) {
            i3++;
        }
        if (bVar2.f18449b <= bVar.f18449b) {
            bVar.f18449b += bVar2.f18451d;
        }
        if (bVar2.f18449b <= bVar.f18451d) {
            bVar.f18451d += bVar2.f18451d;
        }
        bVar2.f18449b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27207b(java.util.List<flyme.support.p093v7.widget.AdapterHelper.C3324b> r8, int r9, flyme.support.p093v7.widget.AdapterHelper.C3324b r10, int r11, flyme.support.p093v7.widget.AdapterHelper.C3324b r12) {
        /*
            r7 = this;
            int r0 = r10.f18451d
            int r1 = r12.f18449b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000f
            int r0 = r12.f18449b
            int r0 = r0 - r4
            r12.f18449b = r0
            goto L_0x0028
        L_0x000f:
            int r0 = r10.f18451d
            int r1 = r12.f18449b
            int r5 = r12.f18451d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            int r0 = r12.f18451d
            int r0 = r0 - r4
            r12.f18451d = r0
            flyme.support.v7.widget.o$a r0 = r7.f18552a
            int r1 = r10.f18449b
            java.lang.Object r5 = r12.f18450c
            flyme.support.v7.widget.c$b r0 = r0.mo27063a(r2, r1, r4, r5)
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r1 = r10.f18449b
            int r5 = r12.f18449b
            if (r1 > r5) goto L_0x0035
            int r1 = r12.f18449b
            int r1 = r1 + r4
            r12.f18449b = r1
            goto L_0x0056
        L_0x0035:
            int r1 = r10.f18449b
            int r5 = r12.f18449b
            int r6 = r12.f18451d
            int r5 = r5 + r6
            if (r1 >= r5) goto L_0x0056
            int r1 = r12.f18449b
            int r3 = r12.f18451d
            int r1 = r1 + r3
            int r3 = r10.f18449b
            int r1 = r1 - r3
            flyme.support.v7.widget.o$a r3 = r7.f18552a
            int r5 = r10.f18449b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f18450c
            flyme.support.v7.widget.c$b r3 = r3.mo27063a(r2, r5, r1, r4)
            int r2 = r12.f18451d
            int r2 = r2 - r1
            r12.f18451d = r2
        L_0x0056:
            r8.set(r11, r10)
            int r10 = r12.f18451d
            if (r10 <= 0) goto L_0x0061
            r8.set(r9, r12)
            goto L_0x0069
        L_0x0061:
            r8.remove(r9)
            flyme.support.v7.widget.o$a r10 = r7.f18552a
            r10.mo27065a(r12)
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r8.add(r9, r0)
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            r8.add(r9, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.OpReorderer.mo27207b(java.util.List, int, flyme.support.v7.widget.c$b, int, flyme.support.v7.widget.c$b):void");
    }

    /* renamed from: b */
    private int m20707b(List<AdapterHelper.C3324b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f18448a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
