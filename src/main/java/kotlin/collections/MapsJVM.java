package kotlin.collections;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Tuples;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\b\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0001\u001a2\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\f\u001aY\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u000e\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u000f\"\u0004\b\u0001\u0010\n2*\u0010\u0010\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\f0\u0011\"\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\u0012\u001a@\u0010\u0013\u001a\u0002H\n\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u00142\u0006\u0010\u0015\u001a\u0002H\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\u0017H\b¢\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u001a*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\bH\b\u001a2\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\bH\u0000\u001a1\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\bH\b\u001a:\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u000e\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u000f\"\u0004\b\u0001\u0010\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\b\u001a@\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\b2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\t0 \"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006!"}, mo27294d2 = {"INT_MAX_POWER_OF_TWO", "", "checkBuilderCapacity", "", "capacity", "mapCapacity", "expectedSize", "mapOf", "", "K", "V", "pair", "Lkotlin/Pair;", "sortedMapOf", "Ljava/util/SortedMap;", "", "pairs", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "comparator", "Ljava/util/Comparator;", "kotlin-stdlib"}, mo27295k = 5, mo27296mv = {1, 1, 16}, mo27298xi = 1, mo27299xs = "kotlin/collections/MapsKt")
/* renamed from: kotlin.collections.z */
public class MapsJVM extends MapWithDefault {
    @PublishedApi
    /* renamed from: a */
    public static final int m20983a(int i) {
        return i < 0 ? i : i < 3 ? i + 1 : i < 1073741824 ? (int) ((((float) i) / 0.75f) + 1.0f) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    @NotNull
    /* renamed from: a */
    public static final <K, V> Map<K, V> m20985a(@NotNull Tuples<? extends K, ? extends V> lVar) {
        C3443i.m21155b(lVar, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(lVar.mo27517a(), lVar.mo27518b());
        C3443i.m21152a((Object) singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    @NotNull
    /* renamed from: a */
    public static final <K, V> Map<K, V> m20984a(@NotNull Map<? extends K, ? extends V> map) {
        C3443i.m21155b(map, "$this$toSingletonMap");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C3443i.m21152a((Object) singletonMap, "java.util.Collections.singletonMap(key, value)");
        C3443i.m21152a((Object) singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
