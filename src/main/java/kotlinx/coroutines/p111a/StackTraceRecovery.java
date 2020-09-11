package kotlinx.coroutines.p111a;

import java.util.ArrayDeque;
import kotlin.C3450n;
import kotlin.C3452p;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Tuples;
import kotlin.TypeCastException;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.p108b.C3443i;
import kotlin.text.C3467f;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a9\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\r\u001a\u0002H\n2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u000f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u00192\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u000fH\u0002¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\n2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\nH\u0000¢\u0006\u0002\u0010\"\u001a,\u0010!\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\n2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030#H\b¢\u0006\u0002\u0010$\u001a \u0010%\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\nH\b¢\u0006\u0002\u0010\"\u001a\u001f\u0010&\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\nH\u0000¢\u0006\u0002\u0010\"\u001a1\u0010'\u001a\u0018\u0012\u0004\u0012\u0002H\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u00190(\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u00020+*\u00060\u0007j\u0002`\u00102\n\u0010,\u001a\u00060\u0007j\u0002`\u0010H\u0002\u001a#\u0010-\u001a\u00020.*\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u00192\u0006\u0010/\u001a\u00020\u0001H\u0002¢\u0006\u0002\u00100\u001a\u0014\u00101\u001a\u00020\u0017*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a\u0010\u00102\u001a\u00020+*\u00060\u0007j\u0002`\u0010H\u0000\u001a\u001b\u00103\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u00104\"\u00020\u00142\u00020\u0014*\f\b\u0000\u00105\"\u00020\u00072\u00020\u0007\u0002\u0004\n\u0002\b\u0019¨\u00066"}, mo27294d2 = {"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.l */
public final class StackTraceRecovery {

    /* renamed from: a */
    private static final String f18812a;

    /* renamed from: b */
    private static final String f18813b;

    static {
        Object obj;
        Object obj2;
        try {
            Result.C3448a aVar = Result.f18741a;
            obj = Result.m21195d(Class.forName("kotlin.coroutines.jvm.internal.a").getCanonicalName());
        } catch (Throwable th) {
            Result.C3448a aVar2 = Result.f18741a;
            obj = Result.m21195d(C3450n.m21198a(th));
        }
        if (Result.m21193b(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.a";
        }
        f18812a = (String) obj;
        try {
            Result.C3448a aVar3 = Result.f18741a;
            obj2 = Result.m21195d(Class.forName("kotlinx.coroutines.a.l").getCanonicalName());
        } catch (Throwable th2) {
            Result.C3448a aVar4 = Result.f18741a;
            obj2 = Result.m21195d(C3450n.m21198a(th2));
        }
        if (Result.m21193b(obj2) != null) {
            obj2 = "kotlinx.coroutines.a.l";
        }
        f18813b = (String) obj2;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final <E extends Throwable> E m21358b(E e, CoroutineStackFrame dVar) {
        Tuples b = m21359b(e);
        E e2 = (Throwable) b.mo27519c();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) b.mo27520d();
        Throwable a = ExceptionsConstuctor.m21293a(e2);
        if (a == null || (!C3443i.m21154a((Object) a.getMessage(), (Object) e2.getMessage()))) {
            return e;
        }
        ArrayDeque a2 = m21354a(dVar);
        if (a2.isEmpty()) {
            return e;
        }
        if (e2 != e) {
            m21355a(stackTraceElementArr, (ArrayDeque<StackTraceElement>) a2);
        }
        return m21352a(e2, a, a2);
    }

    /* renamed from: a */
    private static final <E extends Throwable> E m21352a(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(m21350a("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int a = m21349a(stackTrace, f18812a);
        int i = 0;
        if (a == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e2.setStackTrace((StackTraceElement[]) array);
                return e2;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + a)];
        for (int i2 = 0; i2 < a; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[a + i] = stackTraceElement;
            i++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    /* renamed from: b */
    private static final <E extends Throwable> Tuples<E, StackTraceElement[]> m21359b(@NotNull E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !C3443i.m21154a((Object) cause.getClass(), (Object) e.getClass())) {
            return C3452p.m21202a(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (m21356a(stackTrace[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return C3452p.m21202a(cause, stackTrace);
        }
        return C3452p.m21202a(e, new StackTraceElement[0]);
    }

    @NotNull
    /* renamed from: a */
    public static final <E extends Throwable> E m21351a(@NotNull E e) {
        E cause = e.getCause();
        if (cause != null) {
            boolean z = true;
            if (!(!C3443i.m21154a((Object) cause.getClass(), (Object) e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (m21356a(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                return z ? cause : e;
            }
        }
        return e;
    }

    /* renamed from: a */
    private static final ArrayDeque<StackTraceElement> m21354a(CoroutineStackFrame dVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement d = dVar.mo27441d();
        if (d != null) {
            arrayDeque.add(d);
        }
        while (true) {
            if (!(dVar instanceof CoroutineStackFrame)) {
                dVar = null;
            }
            if (dVar == null || (dVar = dVar.mo27440c()) == null) {
                return arrayDeque;
            }
            StackTraceElement d2 = dVar.mo27441d();
            if (d2 != null) {
                arrayDeque.add(d2);
            }
        }
        return arrayDeque;
    }

    @NotNull
    @InternalCoroutinesApi
    /* renamed from: a */
    public static final StackTraceElement m21350a(@NotNull String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    /* renamed from: a */
    public static final boolean m21356a(@NotNull StackTraceElement stackTraceElement) {
        return C3467f.m21232b(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    /* renamed from: a */
    private static final boolean m21357a(@NotNull StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && C3443i.m21154a((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && C3443i.m21154a((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && C3443i.m21154a((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    /* renamed from: a */
    private static final void m21355a(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (m21356a(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 >= i2) {
            while (true) {
                if (m21357a(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i2) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private static final int m21349a(@NotNull StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (C3443i.m21154a((Object) str, (Object) stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }
}
