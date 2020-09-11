package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.C3447o;
import kotlin.jvm.p108b.FunctionBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, mo27294d2 = {"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
/* renamed from: kotlin.coroutines.jvm.internal.i */
/* compiled from: ContinuationImpl.kt */
public abstract class C3393i extends C3388c implements FunctionBase<Object> {

    /* renamed from: a */
    private final int f18688a;

    /* renamed from: g */
    public int mo27447g() {
        return this.f18688a;
    }

    public C3393i(int i, @Nullable Continuation<Object> dVar) {
        super(dVar);
        this.f18688a = i;
    }

    @NotNull
    public String toString() {
        if (mo27442e() != null) {
            return super.toString();
        }
        String a = C3447o.m21168a((FunctionBase) this);
        C3443i.m21152a((Object) a, "Reflection.renderLambdaToString(this)");
        return a;
    }
}
