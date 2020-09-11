package kotlin.jvm.p108b;

import com.meizu.savior.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C3452p;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.C3360h;
import kotlin.collections.C3366x;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p107a.C3415c;
import kotlin.jvm.p107a.C3416d;
import kotlin.jvm.p107a.C3417e;
import kotlin.jvm.p107a.C3418f;
import kotlin.jvm.p107a.C3419g;
import kotlin.jvm.p107a.C3420h;
import kotlin.jvm.p107a.C3421i;
import kotlin.jvm.p107a.C3422j;
import kotlin.jvm.p107a.C3423k;
import kotlin.jvm.p107a.C3424l;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p107a.C3426n;
import kotlin.jvm.p107a.C3427o;
import kotlin.jvm.p107a.C3428p;
import kotlin.jvm.p107a.C3429q;
import kotlin.jvm.p107a.C3430r;
import kotlin.jvm.p107a.C3431s;
import kotlin.jvm.p107a.C3432t;
import kotlin.jvm.p107a.C3433u;
import kotlin.jvm.p107a.C3434v;
import kotlin.jvm.p107a.C3435w;
import kotlin.jvm.p107a.Functions;
import kotlin.reflect.KClass;
import kotlin.text.C3467f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010J\u001a\u00020-H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002060\b8VX\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010>8VX\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010A¨\u0006L"}, mo27294d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.jvm.b.e */
public final class ClassReference implements ClassBasedDeclarationContainer, KClass<Object> {

    /* renamed from: a */
    public static final C3442a f18721a = new C3442a((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final Map<Class<? extends Function<?>>, Integer> f18722c;

    /* renamed from: d */
    private static final HashMap<String, String> f18723d;

    /* renamed from: e */
    private static final HashMap<String, String> f18724e;

    /* renamed from: f */
    private static final HashMap<String, String> f18725f;

    /* renamed from: g */
    private static final Map<String, String> f18726g;
    @NotNull

    /* renamed from: b */
    private final Class<?> f18727b;

    public ClassReference(@NotNull Class<?> cls) {
        C3443i.m21155b(cls, "jClass");
        this.f18727b = cls;
    }

    @NotNull
    /* renamed from: a */
    public Class<?> mo27499a() {
        return this.f18727b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ClassReference) && C3443i.m21154a((Object) JvmClassMapping.m21128a(this), (Object) JvmClassMapping.m21128a((KClass) obj));
    }

    public int hashCode() {
        return JvmClassMapping.m21128a(this).hashCode();
    }

    @NotNull
    public String toString() {
        return mo27499a().toString() + " (Kotlin reflection is not available)";
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo27294d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.jvm.b.e$a */
    /* compiled from: ClassReference.kt */
    public static final class C3442a {
        private C3442a() {
        }

        public /* synthetic */ C3442a(DefaultConstructorMarker gVar) {
            this();
        }
    }

    static {
        int i = 0;
        Iterable b = C3360h.m20960b(Functions.class, C3414b.class, C3425m.class, C3429q.class, C3430r.class, C3431s.class, C3432t.class, C3433u.class, C3434v.class, C3435w.class, C3415c.class, C3416d.class, C3417e.class, C3418f.class, C3419g.class, C3420h.class, C3421i.class, C3422j.class, C3423k.class, C3424l.class, C3426n.class, C3427o.class, C3428p.class);
        Collection arrayList = new ArrayList(C3360h.m20962a(b, 10));
        for (Object next : b) {
            int i2 = i + 1;
            if (i < 0) {
                C3360h.m20961b();
            }
            arrayList.add(C3452p.m21202a((Class) next, Integer.valueOf(i)));
            i = i2;
        }
        f18722c = C3366x.m20937a((List) arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Constants.BOOLEAN, "kotlin.Boolean");
        hashMap.put(Constants.CHAR, "kotlin.Char");
        hashMap.put(Constants.BYTE, "kotlin.Byte");
        hashMap.put(Constants.SHORT, "kotlin.Short");
        hashMap.put(Constants.INT, "kotlin.Int");
        hashMap.put(Constants.FLOAT, "kotlin.Float");
        hashMap.put(Constants.LONG, "kotlin.Long");
        hashMap.put(Constants.DOUBLE, "kotlin.Double");
        f18723d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(Constants.LANG_BOOLEAN, "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put(Constants.LANG_BYTE, "kotlin.Byte");
        hashMap2.put(Constants.LANG_SHORT, "kotlin.Short");
        hashMap2.put(Constants.LANG_INT, "kotlin.Int");
        hashMap2.put(Constants.LANG_FLOAT, "kotlin.Float");
        hashMap2.put(Constants.LANG_LONG, "kotlin.Long");
        hashMap2.put(Constants.LANG_DOUBLE, "kotlin.Double");
        f18724e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(f18723d);
        hashMap3.putAll(f18724e);
        Collection<String> values = f18723d.values();
        C3443i.m21152a((Object) values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            C3443i.m21152a((Object) str, "kotlinName");
            sb.append(C3467f.m21245a(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            Tuples a = C3452p.m21202a(sb2, str + ".Companion");
            hashMap3.put(a.mo27517a(), a.mo27518b());
        }
        Map map = hashMap3;
        for (Map.Entry next2 : f18722c.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f18725f = hashMap3;
        Map map2 = f18725f;
        Map<String, String> linkedHashMap = new LinkedHashMap<>(C3366x.m20983a(map2.size()));
        for (Map.Entry entry : map2.entrySet()) {
            linkedHashMap.put(entry.getKey(), C3467f.m21245a((String) entry.getValue(), '.', (String) null, 2, (Object) null));
        }
        f18726g = linkedHashMap;
    }
}
