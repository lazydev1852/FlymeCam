package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContextImpl;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.text.C3467f;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo27294d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.x */
/* compiled from: CoroutineContext.kt */
public final class C3565x extends CoroutineContextImpl implements ThreadContextElement<String> {

    /* renamed from: a */
    public static final C3566a f19002a = new C3566a((DefaultConstructorMarker) null);

    /* renamed from: b */
    private final long f19003b;

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof C3565x) && this.f19003b == ((C3565x) obj).f19003b;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f19003b;
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: a */
    public <R> R mo27411a(R r, @NotNull C3425m<? super R, ? super CoroutineContext.C3378b, ? extends R> mVar) {
        return ThreadContextElement.C3529a.m21615a(this, r, mVar);
    }

    @Nullable
    /* renamed from: a */
    public <E extends CoroutineContext.C3378b> E mo27412a(@NotNull CoroutineContext.C3380c<E> cVar) {
        return ThreadContextElement.C3529a.m21616a(this, cVar);
    }

    @NotNull
    /* renamed from: a */
    public CoroutineContext mo27413a(@NotNull CoroutineContext gVar) {
        return ThreadContextElement.C3529a.m21617a(this, gVar);
    }

    @NotNull
    /* renamed from: b */
    public CoroutineContext mo27414b(@NotNull CoroutineContext.C3380c<?> cVar) {
        return ThreadContextElement.C3529a.m21618b(this, cVar);
    }

    /* renamed from: b */
    public final long mo27783b() {
        return this.f19003b;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo27294d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.x$a */
    /* compiled from: CoroutineContext.kt */
    public static final class C3566a implements CoroutineContext.C3380c<C3565x> {
        private C3566a() {
        }

        public /* synthetic */ C3566a(DefaultConstructorMarker gVar) {
            this();
        }
    }

    public C3565x(long j) {
        super(f19002a);
        this.f19003b = j;
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.f19003b + ')';
    }

    @NotNull
    /* renamed from: b */
    public String mo27714c(@NotNull CoroutineContext gVar) {
        String str;
        CoroutineName yVar = (CoroutineName) gVar.mo27412a(CoroutineName.f19004a);
        if (yVar == null || (str = yVar.mo27788b()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int b = C3467f.m21256b((CharSequence) name, " @", 0, false, 6, (Object) null);
        if (b < 0) {
            b = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + b + 10);
        if (name != null) {
            String substring = name.substring(0, b);
            C3443i.m21152a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(this.f19003b);
            String sb2 = sb.toString();
            C3443i.m21152a((Object) sb2, "StringBuilder(capacity).…builderAction).toString()");
            currentThread.setName(sb2);
            return name;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public void mo27713a(@NotNull CoroutineContext gVar, @NotNull String str) {
        Thread.currentThread().setName(str);
    }
}
