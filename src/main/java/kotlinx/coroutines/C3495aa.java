package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.aa */
public final /* synthetic */ class C3495aa {

    /* renamed from: a */
    public static final /* synthetic */ int[] f18830a = new int[CoroutineStart.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f18831b = new int[CoroutineStart.values().length];

    static {
        f18830a[CoroutineStart.DEFAULT.ordinal()] = 1;
        f18830a[CoroutineStart.ATOMIC.ordinal()] = 2;
        f18830a[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
        f18830a[CoroutineStart.LAZY.ordinal()] = 4;
        f18831b[CoroutineStart.DEFAULT.ordinal()] = 1;
        f18831b[CoroutineStart.ATOMIC.ordinal()] = 2;
        f18831b[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
        f18831b[CoroutineStart.LAZY.ordinal()] = 4;
    }
}
