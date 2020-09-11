package kotlinx.coroutines.p111a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.C3450n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.Lambda;
import kotlin.p098a.C3355a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018"}, mo27294d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.d */
public final class ExceptionsConstuctor {

    /* renamed from: a */
    private static final int f18779a = m21291a(Throwable.class, -1);

    /* renamed from: b */
    private static final ReentrantReadWriteLock f18780b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private static final WeakHashMap<Class<? extends Throwable>, C3414b<Throwable, Throwable>> f18781c = new WeakHashMap<>();

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "E", "", "it", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.d$f */
    /* compiled from: ExceptionsConstuctor.kt */
    static final class C3477f extends Lambda implements C3414b {

        /* renamed from: a */
        public static final C3477f f18786a = new C3477f();

        C3477f() {
            super(1);
        }

        @Nullable
        /* renamed from: a */
        public final Void mo27487a(@NotNull Throwable th) {
            return null;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "E", "", "it", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.d$g */
    /* compiled from: ExceptionsConstuctor.kt */
    static final class C3478g extends Lambda implements C3414b {

        /* renamed from: a */
        public static final C3478g f18787a = new C3478g();

        C3478g() {
            super(1);
        }

        @Nullable
        /* renamed from: a */
        public final Void mo27487a(@NotNull Throwable th) {
            return null;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    public static final <E extends java.lang.Throwable> E m21293a(@org.jetbrains.annotations.NotNull E r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.C3547r
            r1 = 0
            if (r0 == 0) goto L_0x0027
            kotlin.m$a r0 = kotlin.Result.f18741a     // Catch:{ Throwable -> 0x0012 }
            kotlinx.coroutines.r r9 = (kotlinx.coroutines.C3547r) r9     // Catch:{ Throwable -> 0x0012 }
            java.lang.Throwable r9 = r9.mo27674a()     // Catch:{ Throwable -> 0x0012 }
            java.lang.Object r9 = kotlin.Result.m21195d(r9)     // Catch:{ Throwable -> 0x0012 }
            goto L_0x001d
        L_0x0012:
            r9 = move-exception
            kotlin.m$a r0 = kotlin.Result.f18741a
            java.lang.Object r9 = kotlin.C3450n.m21198a((java.lang.Throwable) r9)
            java.lang.Object r9 = kotlin.Result.m21195d(r9)
        L_0x001d:
            boolean r0 = kotlin.Result.m21191a(r9)
            if (r0 == 0) goto L_0x0024
            r9 = r1
        L_0x0024:
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x0027:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f18780b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.a.b<java.lang.Throwable, java.lang.Throwable>> r2 = f18781c     // Catch:{ all -> 0x0124 }
            java.lang.Class r3 = r9.getClass()     // Catch:{ all -> 0x0124 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0124 }
            kotlin.jvm.a.b r2 = (kotlin.jvm.p107a.C3414b) r2     // Catch:{ all -> 0x0124 }
            r0.unlock()
            if (r2 == 0) goto L_0x0048
            java.lang.Object r9 = r2.mo27487a(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x0048:
            int r0 = f18779a
            java.lang.Class r2 = r9.getClass()
            r3 = 0
            int r2 = m21291a(r2, r3)
            if (r0 == r2) goto L_0x009f
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f18780b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            int r4 = r0.getWriteHoldCount()
            if (r4 != 0) goto L_0x0066
            int r4 = r0.getReadHoldCount()
            goto L_0x0067
        L_0x0066:
            r4 = 0
        L_0x0067:
            r5 = 0
        L_0x0068:
            if (r5 >= r4) goto L_0x0070
            r2.unlock()
            int r5 = r5 + 1
            goto L_0x0068
        L_0x0070:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.a.b<java.lang.Throwable, java.lang.Throwable>> r5 = f18781c     // Catch:{ all -> 0x0092 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0092 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0092 }
            kotlinx.coroutines.a.d$f r6 = kotlinx.coroutines.p111a.ExceptionsConstuctor.C3477f.f18786a     // Catch:{ all -> 0x0092 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0092 }
            kotlin.t r9 = kotlin.Unit.f18749a     // Catch:{ all -> 0x0092 }
        L_0x0086:
            if (r3 >= r4) goto L_0x008e
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0086
        L_0x008e:
            r0.unlock()
            return r1
        L_0x0092:
            r9 = move-exception
        L_0x0093:
            if (r3 >= r4) goto L_0x009b
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0093
        L_0x009b:
            r0.unlock()
            throw r9
        L_0x009f:
            r0 = r1
            kotlin.jvm.a.b r0 = (kotlin.jvm.p107a.C3414b) r0
            java.lang.Class r2 = r9.getClass()
            java.lang.reflect.Constructor[] r2 = r2.getConstructors()
            kotlinx.coroutines.a.d$e r4 = new kotlinx.coroutines.a.d$e
            r4.<init>()
            java.util.Comparator r4 = (java.util.Comparator) r4
            java.util.List r2 = kotlin.collections.C3359b.m20953c(r2, r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x00b9:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00cb
            java.lang.Object r0 = r2.next()
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            kotlin.jvm.a.b r0 = m21294a((java.lang.reflect.Constructor<?>) r0)
            if (r0 == 0) goto L_0x00b9
        L_0x00cb:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = f18780b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r2.readLock()
            int r5 = r2.getWriteHoldCount()
            if (r5 != 0) goto L_0x00dc
            int r5 = r2.getReadHoldCount()
            goto L_0x00dd
        L_0x00dc:
            r5 = 0
        L_0x00dd:
            r6 = 0
        L_0x00de:
            if (r6 >= r5) goto L_0x00e6
            r4.unlock()
            int r6 = r6 + 1
            goto L_0x00de
        L_0x00e6:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.a.b<java.lang.Throwable, java.lang.Throwable>> r6 = f18781c     // Catch:{ all -> 0x0117 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x0117 }
            java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0117 }
            if (r0 == 0) goto L_0x00f9
            r8 = r0
            goto L_0x00fd
        L_0x00f9:
            kotlinx.coroutines.a.d$g r8 = kotlinx.coroutines.p111a.ExceptionsConstuctor.C3478g.f18787a     // Catch:{ all -> 0x0117 }
            kotlin.jvm.a.b r8 = (kotlin.jvm.p107a.C3414b) r8     // Catch:{ all -> 0x0117 }
        L_0x00fd:
            r6.put(r7, r8)     // Catch:{ all -> 0x0117 }
            kotlin.t r6 = kotlin.Unit.f18749a     // Catch:{ all -> 0x0117 }
        L_0x0102:
            if (r3 >= r5) goto L_0x010a
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0102
        L_0x010a:
            r2.unlock()
            if (r0 == 0) goto L_0x0116
            java.lang.Object r9 = r0.mo27487a(r9)
            r1 = r9
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0116:
            return r1
        L_0x0117:
            r9 = move-exception
        L_0x0118:
            if (r3 >= r5) goto L_0x0120
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0118
        L_0x0120:
            r2.unlock()
            throw r9
        L_0x0124:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p111a.ExceptionsConstuctor.m21293a(java.lang.Throwable):java.lang.Throwable");
    }

    /* renamed from: a */
    private static final C3414b<Throwable, Throwable> m21294a(Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        switch (parameterTypes.length) {
            case 0:
                return new C3475d(constructor);
            case 1:
                Class cls = parameterTypes[0];
                if (C3443i.m21154a((Object) cls, (Object) Throwable.class)) {
                    return new C3473b(constructor);
                }
                if (C3443i.m21154a((Object) cls, (Object) String.class)) {
                    return new C3474c(constructor);
                }
                return null;
            case 2:
                if (!C3443i.m21154a((Object) parameterTypes[0], (Object) String.class) || !C3443i.m21154a((Object) parameterTypes[1], (Object) Throwable.class)) {
                    return null;
                }
                return new C3472a(constructor);
            default:
                return null;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, mo27294d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.d$a */
    /* compiled from: ExceptionsConstuctor.kt */
    public static final class C3472a extends Lambda implements C3414b<Throwable, Throwable> {

        /* renamed from: a */
        final /* synthetic */ Constructor f18782a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3472a(Constructor constructor) {
            super(1);
            this.f18782a = constructor;
        }

        @Nullable
        /* renamed from: a */
        public final Throwable mo27487a(@NotNull Throwable th) {
            Object obj;
            try {
                Result.C3448a aVar = Result.f18741a;
                Object newInstance = this.f18782a.newInstance(new Object[]{th.getMessage(), th});
                if (newInstance != null) {
                    obj = Result.m21195d((Throwable) newInstance);
                    if (Result.m21191a(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th2) {
                Result.C3448a aVar2 = Result.f18741a;
                obj = Result.m21195d(C3450n.m21198a(th2));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, mo27294d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.d$b */
    /* compiled from: ExceptionsConstuctor.kt */
    public static final class C3473b extends Lambda implements C3414b<Throwable, Throwable> {

        /* renamed from: a */
        final /* synthetic */ Constructor f18783a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3473b(Constructor constructor) {
            super(1);
            this.f18783a = constructor;
        }

        @Nullable
        /* renamed from: a */
        public final Throwable mo27487a(@NotNull Throwable th) {
            Object obj;
            try {
                Result.C3448a aVar = Result.f18741a;
                Object newInstance = this.f18783a.newInstance(new Object[]{th});
                if (newInstance != null) {
                    obj = Result.m21195d((Throwable) newInstance);
                    if (Result.m21191a(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th2) {
                Result.C3448a aVar2 = Result.f18741a;
                obj = Result.m21195d(C3450n.m21198a(th2));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, mo27294d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.d$c */
    /* compiled from: ExceptionsConstuctor.kt */
    public static final class C3474c extends Lambda implements C3414b<Throwable, Throwable> {

        /* renamed from: a */
        final /* synthetic */ Constructor f18784a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3474c(Constructor constructor) {
            super(1);
            this.f18784a = constructor;
        }

        @Nullable
        /* renamed from: a */
        public final Throwable mo27487a(@NotNull Throwable th) {
            Object obj;
            try {
                Result.C3448a aVar = Result.f18741a;
                Object newInstance = this.f18784a.newInstance(new Object[]{th.getMessage()});
                if (newInstance != null) {
                    Throwable th2 = (Throwable) newInstance;
                    th2.initCause(th);
                    obj = Result.m21195d(th2);
                    if (Result.m21191a(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th3) {
                Result.C3448a aVar2 = Result.f18741a;
                obj = Result.m21195d(C3450n.m21198a(th3));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, mo27294d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.d$d */
    /* compiled from: ExceptionsConstuctor.kt */
    public static final class C3475d extends Lambda implements C3414b<Throwable, Throwable> {

        /* renamed from: a */
        final /* synthetic */ Constructor f18785a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3475d(Constructor constructor) {
            super(1);
            this.f18785a = constructor;
        }

        @Nullable
        /* renamed from: a */
        public final Throwable mo27487a(@NotNull Throwable th) {
            Object obj;
            try {
                Result.C3448a aVar = Result.f18741a;
                Object newInstance = this.f18785a.newInstance(new Object[0]);
                if (newInstance != null) {
                    Throwable th2 = (Throwable) newInstance;
                    th2.initCause(th);
                    obj = Result.m21195d(th2);
                    if (Result.m21191a(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th3) {
                Result.C3448a aVar2 = Result.f18741a;
                obj = Result.m21195d(C3450n.m21198a(th3));
            }
        }
    }

    /* renamed from: a */
    private static final int m21291a(@NotNull Class<?> cls, int i) {
        Integer num;
        JvmClassMapping.m21129a(cls);
        try {
            Result.C3448a aVar = Result.f18741a;
            num = Result.m21195d(Integer.valueOf(m21292a(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            Result.C3448a aVar2 = Result.f18741a;
            num = Result.m21195d(C3450n.m21198a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m21191a(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    /* renamed from: a */
    static /* synthetic */ int m21292a(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m21295b(cls, i);
    }

    /* renamed from: b */
    private static final int m21295b(@NotNull Class<?> cls, int i) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            Class<? super Object> cls2 = cls;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(declaredFields[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo27294d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.d$e */
    /* compiled from: Comparisons.kt */
    public static final class C3476e<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return C3355a.m20930a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
        }
    }
}
