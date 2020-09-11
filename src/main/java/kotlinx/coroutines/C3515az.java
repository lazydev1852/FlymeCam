package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo27294d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.az */
/* compiled from: Exceptions.kt */
public final class C3515az extends CancellationException implements C3547r<C3515az> {
    @NotNull
    @JvmField

    /* renamed from: a */
    public final C3512ay f18880a;

    public C3515az(@NotNull String str, @Nullable Throwable th, @NotNull C3512ay ayVar) {
        super(str);
        this.f18880a = ayVar;
        if (th != null) {
            initCause(th);
        }
    }

    @NotNull
    public Throwable fillInStackTrace() {
        if (Debug.m21407b()) {
            return super.fillInStackTrace();
        }
        return this;
    }

    @Nullable
    /* renamed from: b */
    public C3515az mo27674a() {
        if (!Debug.m21407b()) {
            return null;
        }
        String message = getMessage();
        if (message == null) {
            C3443i.m21151a();
        }
        return new C3515az(message, this, this.f18880a);
    }

    @NotNull
    public String toString() {
        return super.toString() + "; job=" + this.f18880a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof C3515az) {
                C3515az azVar = (C3515az) obj;
                if (!C3443i.m21154a((Object) azVar.getMessage(), (Object) getMessage()) || !C3443i.m21154a((Object) azVar.f18880a, (Object) this.f18880a) || !C3443i.m21154a((Object) azVar.getCause(), (Object) getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String message = getMessage();
        if (message == null) {
            C3443i.m21151a();
        }
        int hashCode = ((message.hashCode() * 31) + this.f18880a.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }
}
