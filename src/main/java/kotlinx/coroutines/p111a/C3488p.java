package kotlinx.coroutines.p111a;

import androidx.appcompat.widget.ActivityChooserView;
import kotlin.Metadata;
import kotlin.text.C3467f;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, mo27294d2 = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, mo27295k = 5, mo27296mv = {1, 1, 16}, mo27299xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* renamed from: kotlinx.coroutines.a.p */
/* compiled from: SystemProps.common.kt */
public final /* synthetic */ class C3488p {
    /* renamed from: a */
    public static final boolean m21373a(@NotNull String str, boolean z) {
        String a = C3487n.m21365a(str);
        return a != null ? Boolean.parseBoolean(a) : z;
    }

    /* renamed from: a */
    public static /* synthetic */ int m21370a(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        return C3487n.m21361a(str, i, i2, i3);
    }

    /* renamed from: a */
    public static final int m21369a(@NotNull String str, int i, int i2, int i3) {
        return (int) C3487n.m21363a(str, (long) i, (long) i2, (long) i3);
    }

    /* renamed from: a */
    public static /* synthetic */ long m21372a(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return C3487n.m21363a(str, j, j4, j3);
    }

    /* renamed from: a */
    public static final long m21371a(@NotNull String str, long j, long j2, long j3) {
        String a = C3487n.m21365a(str);
        if (a == null) {
            return j;
        }
        Long b = C3467f.m21224b(a);
        if (b != null) {
            long longValue = b.longValue();
            if (j2 <= longValue && j3 >= longValue) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + a + '\'').toString());
    }
}
