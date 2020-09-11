package kotlinx.coroutines;

import kotlin.Exceptions;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\b\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0000¨\u0006\r"}, mo27294d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.w */
/* compiled from: CoroutineExceptionHandler.kt */
public final class C3564w {
    @InternalCoroutinesApi
    /* renamed from: a */
    public static final void m21759a(@NotNull CoroutineContext gVar, @NotNull Throwable th) {
        try {
            CoroutineExceptionHandler uVar = (CoroutineExceptionHandler) gVar.mo27412a(CoroutineExceptionHandler.f18999a);
            if (uVar != null) {
                uVar.mo27781a(gVar, th);
            } else {
                CoroutineExceptionHandlerImpl.m21757a(gVar, th);
            }
        } catch (Throwable th2) {
            CoroutineExceptionHandlerImpl.m21757a(gVar, m21758a(th, th2));
        }
    }

    @NotNull
    /* renamed from: a */
    public static final Throwable m21758a(@NotNull Throwable th, @NotNull Throwable th2) {
        if (th == th2) {
            return th;
        }
        Throwable runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        Exceptions.m20931a(runtimeException, th);
        return runtimeException;
    }
}
