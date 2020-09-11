package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo27294d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.coroutines.jvm.internal.e */
/* compiled from: DebugMetadata.kt */
public final class C3389e {
    @SinceKotlin(version = "1.3")
    @Nullable
    @JvmName(name = "getStackTraceElement")
    /* renamed from: a */
    public static final StackTraceElement m21060a(@NotNull ContinuationImpl aVar) {
        int i;
        String str;
        C3443i.m21155b(aVar, "$this$getStackTraceElementImpl");
        DebugMetadata b = m21062b(aVar);
        if (b == null) {
            return null;
        }
        m21061a(1, b.mo27437v());
        int c = m21063c(aVar);
        if (c < 0) {
            i = -1;
        } else {
            i = b.mo27433l()[c];
        }
        String a = C3390g.f18683b.mo27446a(aVar);
        if (a == null) {
            str = b.mo27430c();
        } else {
            str = a + '/' + b.mo27430c();
        }
        return new StackTraceElement(str, b.mo27434m(), b.mo27431f(), i);
    }

    /* renamed from: b */
    private static final DebugMetadata m21062b(@NotNull ContinuationImpl aVar) {
        return (DebugMetadata) aVar.getClass().getAnnotation(DebugMetadata.class);
    }

    /* renamed from: c */
    private static final int m21063c(@NotNull ContinuationImpl aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            C3443i.m21152a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static final void m21061a(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
        }
    }
}
