package kotlin.p100c;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo27294d2 = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.c.a */
public final class MathJVM {
    @JvmField

    /* renamed from: a */
    public static final double f18635a = Math.log(2.0d);
    @JvmField

    /* renamed from: b */
    public static final double f18636b = Math.ulp(1.0d);
    @JvmField

    /* renamed from: c */
    public static final double f18637c = Math.sqrt(f18636b);
    @JvmField

    /* renamed from: d */
    public static final double f18638d = Math.sqrt(f18637c);
    @JvmField

    /* renamed from: e */
    public static final double f18639e;
    @JvmField

    /* renamed from: f */
    public static final double f18640f;

    /* renamed from: g */
    public static final MathJVM f18641g = new MathJVM();

    static {
        double d = (double) 1;
        f18639e = d / f18637c;
        f18640f = d / f18638d;
    }

    private MathJVM() {
    }
}
