package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Exceptions;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlinx.coroutines.C3512ay;
import kotlinx.coroutines.p111a.C3479f;
import kotlinx.coroutines.p111a.C3480g;
import kotlinx.coroutines.p111a.C3485j;
import kotlinx.coroutines.p111a.LockFreeLinkedList;
import kotlinx.coroutines.p111a.StackTraceRecovery;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00030\u00012\u00030Å\u0001:\u0006Ô\u0001Õ\u0001Ö\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010\\\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0004\bZ\u0010[JF\u0010e\u001a\u00020d2\u0006\u0010]\u001a\u00020\u00012\u0006\u0010^\u001a\u00020\u00012'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b¢\u0006\u0004\be\u0010fJ6\u0010e\u001a\u00020d2'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b¢\u0006\u0004\be\u0010gJ\u0013\u0010h\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\bh\u0010\u001dJ\u000f\u0010i\u001a\u00020\u0001H\u0002¢\u0006\u0004\bi\u0010jJ\u0013\u0010k\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\bk\u0010\u001dJ&\u0010n\u001a\u00020m2\u0014\u0010l\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110_H\b¢\u0006\u0004\bn\u0010oJ\u001b\u0010p\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bp\u0010-J\u0019\u0010r\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bq\u0010(J\u001b\u0010t\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bs\u0010-JD\u0010u\u001a\u0006\u0012\u0002\b\u00030\t2'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b2\u0006\u0010]\u001a\u00020\u0001H\u0002¢\u0006\u0004\bu\u0010vJ\u000f\u0010x\u001a\u00020/H\u0010¢\u0006\u0004\bw\u00101J\u001f\u0010y\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\by\u0010zJ2\u0010|\u001a\u00020\u0011\"\u000e\b\u0000\u0010{\u0018\u0001*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\b¢\u0006\u0004\b|\u0010zJ\u0019\u0010]\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b]\u0010+J\u0019\u0010}\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b}\u0010\u0016J\u0010\u0010\u0001\u001a\u00020\u0011H\u0010¢\u0006\u0004\b~\u0010J\u001a\u0010\u0001\u001a\u00020\u00112\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00112\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0006\b\u0001\u0010\u0001JI\u0010\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010l\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050_ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JX\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012$\u0010l\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00112\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0006\b\u0001\u0010\u0001JX\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012$\u0010l\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0001\u0010jJ\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u0001\u00101J\u0011\u0010\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u0001\u00101J$\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\"\u0010¢\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J(\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J&\u0010¦\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¦\u0001\u0010§\u0001J-\u0010¨\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0010¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0019\u0010«\u0001\u001a\u0004\u0018\u000108*\u00030ª\u0001H\u0002¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001f\u0010­\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b­\u0001\u0010zJ&\u0010®\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b®\u0001\u0010¯\u0001R\u001d\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020X0°\u00018F@\u0006¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u001a\u0010µ\u0001\u001a\u0004\u0018\u00010\r8D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010OR\u0018\u0010·\u0001\u001a\u00020\u00018D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010jR\u0018\u0010¹\u0001\u001a\u00020\u00018P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010jR\u0018\u0010º\u0001\u001a\u00020\u00018V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\bº\u0001\u0010jR\u0015\u0010»\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b»\u0001\u0010jR\u0015\u0010¼\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010jR\u0015\u0010½\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b½\u0001\u0010jR\u0018\u0010¾\u0001\u001a\u00020\u00018T@\u0014X\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010jR\u001b\u0010Â\u0001\u001a\u0007\u0012\u0002\b\u00030¿\u00018F@\u0006¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010Ä\u0001\u001a\u00020\u00018P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010jR\u0017\u0010È\u0001\u001a\u00030Å\u00018F@\u0006¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R.\u0010Î\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010É\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u000e¢\u0006\u0010\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00058@@\u0000X\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010LR \u0010Ñ\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058B@\u0002X\u0004¢\u0006\u0007\u001a\u0005\bÐ\u0001\u0010>R\u001d\u0010Ò\u0001\u001a\u00020\u0001*\u0002038B@\u0002X\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006×\u0001"}, mo27294d2 = {"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
/* renamed from: kotlinx.coroutines.bc */
/* compiled from: JobSupport.kt */
public class C3519bc implements C3512ay, C3527bi, C3539j {

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f18883c = AtomicReferenceFieldUpdater.newUpdater(C3519bc.class, Object.class, "a");

    /* renamed from: a */
    private volatile Object f18884a;

    /* renamed from: d */
    private volatile Object f18885d;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo27558c(@Nullable Object obj) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo27686c(@Nullable Throwable th) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo27687d(@NotNull Throwable th) {
        return false;
    }

    /* renamed from: f */
    public void mo27563f() {
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: g */
    public String mo27564g() {
        return "Job was cancelled";
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo27690g(@Nullable Object obj) {
    }

    /* renamed from: n */
    public boolean mo27694n() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo27696p() {
        return false;
    }

    /* renamed from: q */
    public boolean mo27697q() {
        return true;
    }

    public C3519bc(boolean z) {
        this.f18884a = z ? C3523bd.f18903g : C3523bd.f18902f;
        this.f18885d = null;
    }

    /* renamed from: a */
    public <R> R mo27411a(R r, @NotNull C3425m<? super R, ? super CoroutineContext.C3378b, ? extends R> mVar) {
        return C3512ay.C3513a.m21502a(this, r, mVar);
    }

    @Nullable
    /* renamed from: a */
    public <E extends CoroutineContext.C3378b> E mo27412a(@NotNull CoroutineContext.C3380c<E> cVar) {
        return C3512ay.C3513a.m21503a((C3512ay) this, cVar);
    }

    @NotNull
    /* renamed from: a */
    public CoroutineContext mo27413a(@NotNull CoroutineContext gVar) {
        return C3512ay.C3513a.m21504a((C3512ay) this, gVar);
    }

    @NotNull
    /* renamed from: b */
    public CoroutineContext mo27414b(@NotNull CoroutineContext.C3380c<?> cVar) {
        return C3512ay.C3513a.m21506b(this, cVar);
    }

    @NotNull
    /* renamed from: o_ */
    public final CoroutineContext.C3380c<?> mo27415o_() {
        return C3512ay.f18878b;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, mo27294d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.bc$c */
    /* compiled from: LockFreeLinkedList.kt */
    public static final class C3522c extends C3480g.C3481a {

        /* renamed from: a */
        final /* synthetic */ C3480g f18894a;

        /* renamed from: b */
        final /* synthetic */ C3519bc f18895b;

        /* renamed from: c */
        final /* synthetic */ Object f18896c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3522c(C3480g gVar, C3480g gVar2, C3519bc bcVar, Object obj) {
            super(gVar2);
            this.f18894a = gVar;
            this.f18895b = bcVar;
            this.f18896c = obj;
        }

        @Nullable
        /* renamed from: a */
        public Object mo27570a(@NotNull C3480g gVar) {
            if (this.f18895b.mo27692l() == this.f18896c) {
                return null;
            }
            return C3479f.m21310a();
        }
    }

    @Nullable
    /* renamed from: k */
    public final C3537h mo27691k() {
        return (C3537h) this.f18885d;
    }

    /* renamed from: a */
    public final void mo27684a(@Nullable C3537h hVar) {
        this.f18885d = hVar;
    }

    /* renamed from: a */
    public final void mo27681a(@Nullable C3512ay ayVar) {
        if (Debug.m21406a()) {
            if (!(mo27691k() == null)) {
                throw new AssertionError();
            }
        }
        if (ayVar == null) {
            mo27684a((C3537h) C3526bg.f18905a);
            return;
        }
        ayVar.mo27673j();
        C3537h a = ayVar.mo27671a(this);
        mo27684a(a);
        if (mo27693m()) {
            a.mo27642a();
            mo27684a((C3537h) C3526bg.f18905a);
        }
    }

    /* renamed from: c */
    public boolean mo27559c() {
        Object l = mo27692l();
        return (l instanceof C3508au) && ((C3508au) l).mo27643b();
    }

    /* renamed from: m */
    public final boolean mo27693m() {
        return !(mo27692l() instanceof C3508au);
    }

    /* renamed from: a */
    private final Object m21520a(C3521b bVar, Object obj) {
        boolean f;
        Throwable a;
        boolean z = false;
        if (Debug.m21406a()) {
            if (!(mo27692l() == bVar)) {
                throw new AssertionError();
            }
        }
        if (Debug.m21406a() && !(!bVar.mo27706e())) {
            throw new AssertionError();
        } else if (!Debug.m21406a() || bVar.mo27704c()) {
            C3542l lVar = (C3542l) (!(obj instanceof C3542l) ? null : obj);
            Throwable th = lVar != null ? lVar.f18930a : null;
            synchronized (bVar) {
                f = bVar.mo27707f();
                List<Throwable> b = bVar.mo27702b(th);
                a = m21522a(bVar, (List<? extends Throwable>) b);
                if (a != null) {
                    m21527a(a, (List<? extends Throwable>) b);
                }
            }
            if (!(a == null || a == th)) {
                obj = new C3542l(a, false, 2, (DefaultConstructorMarker) null);
            }
            if (a != null) {
                if (m21542e(a) || mo27687d(a)) {
                    z = true;
                }
                if (z) {
                    if (obj != null) {
                        ((C3542l) obj).mo27739c();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                }
            }
            if (!f) {
                mo27686c(a);
            }
            mo27558c(obj);
            boolean compareAndSet = f18883c.compareAndSet(this, bVar, C3523bd.m21598a(obj));
            if (!Debug.m21406a() || compareAndSet) {
                m21536b((C3508au) bVar, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private final Throwable m21522a(C3521b bVar, List<? extends Throwable> list) {
        Object obj;
        Object obj2;
        boolean z;
        boolean z2;
        if (!list.isEmpty()) {
            Iterable iterable = list;
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            Throwable th = (Throwable) obj;
            if (th != null) {
                return th;
            }
            Throwable th2 = (Throwable) list.get(0);
            if (th2 instanceof Timeout) {
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    Throwable th3 = (Throwable) obj2;
                    if (th3 == th2 || !(th3 instanceof Timeout)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                Throwable th4 = (Throwable) obj2;
                if (th4 != null) {
                    return th4;
                }
            }
            return th2;
        } else if (!bVar.mo27707f()) {
            return null;
        } else {
            String str = null;
            return new C3515az(mo27564g(), (Throwable) null, this);
        }
    }

    /* renamed from: a */
    private final void m21527a(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Throwable a = !Debug.m21408c() ? th : StackTraceRecovery.m21351a(th);
            for (Throwable th2 : list) {
                if (Debug.m21408c()) {
                    th2 = StackTraceRecovery.m21351a(th2);
                }
                if (th2 != th && th2 != a && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    Exceptions.m20931a(th, th2);
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m21532a(C3508au auVar, Object obj) {
        if (Debug.m21406a()) {
            if (!((auVar instanceof JobSupport) || (auVar instanceof C3518bb))) {
                throw new AssertionError();
            }
        }
        if (Debug.m21406a()) {
            if (!(!(obj instanceof C3542l))) {
                throw new AssertionError();
            }
        }
        if (!f18883c.compareAndSet(this, auVar, C3523bd.m21598a(obj))) {
            return false;
        }
        mo27686c((Throwable) null);
        mo27558c(obj);
        m21536b(auVar, obj);
        return true;
    }

    /* renamed from: b */
    private final void m21536b(C3508au auVar, Object obj) {
        C3537h k = mo27691k();
        if (k != null) {
            k.mo27642a();
            mo27684a((C3537h) C3526bg.f18905a);
        }
        Throwable th = null;
        if (!(obj instanceof C3542l)) {
            obj = null;
        }
        C3542l lVar = (C3542l) obj;
        if (lVar != null) {
            th = lVar.f18930a;
        }
        if (auVar instanceof C3518bb) {
            try {
                ((C3518bb) auVar).mo27669b(th);
            } catch (Throwable th2) {
                mo27554a((Throwable) new C3546q("Exception in completion handler " + auVar + " for " + this, th2));
            }
        } else {
            C3525bf p_ = auVar.mo27644p_();
            if (p_ != null) {
                m21539b(p_, th);
            }
        }
    }

    /* renamed from: a */
    private final void m21530a(C3525bf bfVar, Throwable th) {
        mo27686c(th);
        Throwable th2 = null;
        LockFreeLinkedList eVar = bfVar;
        Object e = eVar.mo27586e();
        if (e != null) {
            for (C3480g gVar = (C3480g) e; !C3443i.m21154a((Object) gVar, (Object) eVar); gVar = gVar.mo27587f()) {
                if (gVar instanceof C3517ba) {
                    C3518bb bbVar = (C3518bb) gVar;
                    try {
                        bbVar.mo27669b(th);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            Exceptions.m20931a(th2, th3);
                            if (th2 != null) {
                            }
                        }
                        Unit tVar = Unit.f18749a;
                        th2 = new C3546q("Exception in completion handler " + bbVar + " for " + this, th3);
                    }
                }
            }
            if (th2 != null) {
                mo27554a(th2);
            }
            m21542e(th);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: e */
    private final boolean m21542e(Throwable th) {
        if (mo27696p()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        C3537h k = mo27691k();
        if (k == null || k == C3526bg.f18905a) {
            return z;
        }
        if (k.mo27711a(th) || z) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private final int mo27553a(Object obj) {
        if (obj instanceof JobSupport) {
            if (((JobSupport) obj).mo27643b()) {
                return 0;
            }
            if (!f18883c.compareAndSet(this, obj, C3523bd.f18903g)) {
                return -1;
            }
            mo27563f();
            return 1;
        } else if (!(obj instanceof C3507at)) {
            return 0;
        } else {
            if (!f18883c.compareAndSet(this, obj, ((C3507at) obj).mo27644p_())) {
                return -1;
            }
            mo27563f();
            return 1;
        }
    }

    @NotNull
    /* renamed from: i */
    public final CancellationException mo27672i() {
        Object l = mo27692l();
        if (l instanceof C3521b) {
            Throwable d = ((C3521b) l).mo27705d();
            if (d != null) {
                CancellationException a = mo27680a(d, DebugStrings.m21412b(this) + " is cancelling");
                if (a != null) {
                    return a;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (l instanceof C3508au) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (l instanceof C3542l) {
            return m21523a(this, ((C3542l) l).f18930a, (String) null, 1, (Object) null);
        } else {
            return new C3515az(DebugStrings.m21412b(this) + " has completed normally", (Throwable) null, this);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ CancellationException m21523a(C3519bc bcVar, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return bcVar.mo27680a(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: a */
    public final CancellationException mo27680a(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException != null) {
            return cancellationException;
        }
        if (str == null) {
            str = mo27564g();
        }
        return new C3515az(str, th, this);
    }

    @NotNull
    /* renamed from: a */
    public final Job mo27670a(boolean z, boolean z2, @NotNull C3414b<? super Throwable, Unit> bVar) {
        Throwable th = null;
        C3518bb<?> bbVar = null;
        while (true) {
            Object l = mo27692l();
            if (l instanceof JobSupport) {
                JobSupport alVar = (JobSupport) l;
                if (alVar.mo27643b()) {
                    if (bbVar == null) {
                        bbVar = m21524a(bVar, z);
                    }
                    if (f18883c.compareAndSet(this, l, bbVar)) {
                        return bbVar;
                    }
                } else {
                    m21528a(alVar);
                }
            } else if (l instanceof C3508au) {
                C3525bf p_ = ((C3508au) l).mo27644p_();
                if (p_ != null) {
                    Throwable th2 = null;
                    Job akVar = C3526bg.f18905a;
                    if (z && (l instanceof C3521b)) {
                        synchronized (l) {
                            th2 = ((C3521b) l).mo27705d();
                            if (th2 == null || ((bVar instanceof C3538i) && !((C3521b) l).mo27704c())) {
                                if (bbVar == null) {
                                    bbVar = m21524a(bVar, z);
                                }
                                if (m21531a(l, p_, bbVar)) {
                                    if (th2 == null) {
                                        Job akVar2 = bbVar;
                                        return akVar2;
                                    }
                                    akVar = bbVar;
                                }
                            }
                            Unit tVar = Unit.f18749a;
                        }
                    }
                    if (th2 != null) {
                        if (z2) {
                            bVar.mo27487a(th2);
                        }
                        return akVar;
                    }
                    if (bbVar == null) {
                        bbVar = m21524a(bVar, z);
                    }
                    if (m21531a(l, p_, bbVar)) {
                        return bbVar;
                    }
                } else if (l != null) {
                    m21537b((C3518bb<?>) (C3518bb) l);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                }
            } else {
                if (z2) {
                    if (!(l instanceof C3542l)) {
                        l = null;
                    }
                    C3542l lVar = (C3542l) l;
                    if (lVar != null) {
                        th = lVar.f18930a;
                    }
                    bVar.mo27487a(th);
                }
                return C3526bg.f18905a;
            }
        }
    }

    /* renamed from: a */
    private final C3518bb<?> m21524a(C3414b<? super Throwable, Unit> bVar, boolean z) {
        boolean z2 = false;
        C3517ba baVar = null;
        if (z) {
            if (bVar instanceof C3517ba) {
                baVar = bVar;
            }
            C3517ba baVar2 = baVar;
            if (baVar2 != null) {
                if (Debug.m21406a()) {
                    if (baVar2.f18882b == this) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                if (baVar2 != null) {
                    return baVar2;
                }
            }
            return new C3510aw(this, bVar);
        }
        if (bVar instanceof C3518bb) {
            baVar = bVar;
        }
        C3518bb<?> bbVar = baVar;
        if (bbVar != null) {
            if (Debug.m21406a()) {
                if (bbVar.f18882b == this && !(bbVar instanceof C3517ba)) {
                    z2 = true;
                }
                if (!z2) {
                    throw new AssertionError();
                }
            }
            if (bbVar != null) {
                return bbVar;
            }
        }
        return new C3511ax(this, bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x000b A[LOOP_START] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m21531a(java.lang.Object r2, kotlinx.coroutines.C3525bf r3, kotlinx.coroutines.C3518bb<?> r4) {
        /*
            r1 = this;
            kotlinx.coroutines.a.g r3 = (kotlinx.coroutines.p111a.C3480g) r3
            kotlinx.coroutines.bc$c r0 = new kotlinx.coroutines.bc$c
            kotlinx.coroutines.a.g r4 = (kotlinx.coroutines.p111a.C3480g) r4
            r0.<init>(r4, r4, r1, r2)
            kotlinx.coroutines.a.g$a r0 = (kotlinx.coroutines.p111a.C3480g.C3481a) r0
        L_0x000b:
            kotlinx.coroutines.a.g r2 = r3.mo27588g()
            int r2 = r2.mo27584a(r4, r3, r0)
            switch(r2) {
                case 1: goto L_0x0019;
                case 2: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x000b
        L_0x0017:
            r2 = 0
            goto L_0x001a
        L_0x0019:
            r2 = 1
        L_0x001a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C3519bc.m21531a(java.lang.Object, kotlinx.coroutines.bf, kotlinx.coroutines.bb):boolean");
    }

    /* renamed from: a */
    private final void m21528a(JobSupport alVar) {
        C3525bf bfVar = new C3525bf();
        f18883c.compareAndSet(this, alVar, alVar.mo27643b() ? bfVar : new C3507at(bfVar));
    }

    /* renamed from: b */
    private final void m21537b(C3518bb<?> bbVar) {
        bbVar.mo27585a((C3480g) new C3525bf());
        f18883c.compareAndSet(this, bbVar, bbVar.mo27587f());
    }

    /* renamed from: a */
    public final void mo27683a(@NotNull C3527bi biVar) {
        mo27688e((Object) biVar);
    }

    /* renamed from: b */
    public boolean mo27685b(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!mo27688e((Object) th) || !mo27697q()) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public final boolean mo27688e(@Nullable Object obj) {
        Object c = C3523bd.f18898b;
        if (mo27694n() && (c = mo27561d(obj)) == C3523bd.f18897a) {
            return true;
        }
        if (c == C3523bd.f18898b) {
            c = m21544i(obj);
        }
        if (c == C3523bd.f18898b || c == C3523bd.f18897a) {
            return true;
        }
        if (c == C3523bd.f18900d) {
            return false;
        }
        mo27690g(c);
        return true;
    }

    @NotNull
    /* renamed from: o */
    public CancellationException mo27695o() {
        Throwable th;
        Object l = mo27692l();
        CancellationException cancellationException = null;
        if (l instanceof C3521b) {
            th = ((C3521b) l).mo27705d();
        } else if (l instanceof C3542l) {
            th = ((C3542l) l).f18930a;
        } else if (!(l instanceof C3508au)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + l).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new C3515az("Parent job is " + m21546k(l), th, this);
    }

    /* renamed from: h */
    private final Throwable m21543h(Object obj) {
        boolean z;
        if (obj != null) {
            z = obj instanceof Throwable;
        } else {
            z = true;
        }
        if (z) {
            if (obj != null) {
                return (Throwable) obj;
            }
            String str = null;
            return new C3515az(mo27564g(), (Throwable) null, this);
        } else if (obj != null) {
            return ((C3527bi) obj).mo27695o();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r7 == null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        m21530a(((kotlinx.coroutines.C3519bc.C3521b) r2).mo27644p_(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
        return kotlinx.coroutines.C3523bd.m21601c();
     */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m21544i(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0004:
            java.lang.Object r2 = r6.mo27692l()
            boolean r3 = r2 instanceof kotlinx.coroutines.C3519bc.C3521b
            if (r3 == 0) goto L_0x0055
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.bc$b r3 = (kotlinx.coroutines.C3519bc.C3521b) r3     // Catch:{ all -> 0x0052 }
            boolean r3 = r3.mo27706e()     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x001c
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18900d     // Catch:{ all -> 0x0052 }
            monitor-exit(r2)
            return r7
        L_0x001c:
            r3 = r2
            kotlinx.coroutines.bc$b r3 = (kotlinx.coroutines.C3519bc.C3521b) r3     // Catch:{ all -> 0x0052 }
            boolean r3 = r3.mo27707f()     // Catch:{ all -> 0x0052 }
            if (r7 != 0) goto L_0x0027
            if (r3 != 0) goto L_0x0034
        L_0x0027:
            if (r1 == 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            java.lang.Throwable r1 = r6.m21543h(r7)     // Catch:{ all -> 0x0052 }
        L_0x002e:
            r7 = r2
            kotlinx.coroutines.bc$b r7 = (kotlinx.coroutines.C3519bc.C3521b) r7     // Catch:{ all -> 0x0052 }
            r7.mo27703c(r1)     // Catch:{ all -> 0x0052 }
        L_0x0034:
            r7 = r2
            kotlinx.coroutines.bc$b r7 = (kotlinx.coroutines.C3519bc.C3521b) r7     // Catch:{ all -> 0x0052 }
            java.lang.Throwable r7 = r7.mo27705d()     // Catch:{ all -> 0x0052 }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r7 = r0
        L_0x0041:
            monitor-exit(r2)
            if (r7 == 0) goto L_0x004d
            kotlinx.coroutines.bc$b r2 = (kotlinx.coroutines.C3519bc.C3521b) r2
            kotlinx.coroutines.bf r0 = r2.mo27644p_()
            r6.m21530a((kotlinx.coroutines.C3525bf) r0, (java.lang.Throwable) r7)
        L_0x004d:
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18898b
            return r7
        L_0x0052:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0055:
            boolean r3 = r2 instanceof kotlinx.coroutines.C3508au
            if (r3 == 0) goto L_0x00ab
            if (r1 == 0) goto L_0x005c
            goto L_0x0060
        L_0x005c:
            java.lang.Throwable r1 = r6.m21543h(r7)
        L_0x0060:
            r3 = r2
            kotlinx.coroutines.au r3 = (kotlinx.coroutines.C3508au) r3
            boolean r4 = r3.mo27643b()
            if (r4 == 0) goto L_0x0074
            boolean r2 = r6.m21533a((kotlinx.coroutines.C3508au) r3, (java.lang.Throwable) r1)
            if (r2 == 0) goto L_0x0004
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18898b
            return r7
        L_0x0074:
            kotlinx.coroutines.l r3 = new kotlinx.coroutines.l
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.m21519a((java.lang.Object) r2, (java.lang.Object) r3)
            kotlinx.coroutines.a.m r4 = kotlinx.coroutines.C3523bd.f18898b
            if (r3 == r4) goto L_0x008e
            kotlinx.coroutines.a.m r2 = kotlinx.coroutines.C3523bd.f18899c
            if (r3 != r2) goto L_0x008d
            goto L_0x0004
        L_0x008d:
            return r3
        L_0x008e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Cannot happen in "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x00ab:
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18900d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C3519bc.m21544i(java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    private final C3525bf m21525a(C3508au auVar) {
        C3525bf p_ = auVar.mo27644p_();
        if (p_ != null) {
            return p_;
        }
        if (auVar instanceof JobSupport) {
            return new C3525bf();
        }
        if (auVar instanceof C3518bb) {
            m21537b((C3518bb<?>) (C3518bb) auVar);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + auVar).toString());
    }

    /* renamed from: a */
    private final boolean m21533a(C3508au auVar, Throwable th) {
        if (Debug.m21406a()) {
            if (!(!(auVar instanceof C3521b))) {
                throw new AssertionError();
            }
        }
        if (!Debug.m21406a() || auVar.mo27643b()) {
            C3525bf a = m21525a(auVar);
            if (a == null) {
                return false;
            }
            if (!f18883c.compareAndSet(this, auVar, new C3521b(a, false, th))) {
                return false;
            }
            m21530a(a, th);
            return true;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private final Object m21519a(Object obj, Object obj2) {
        if (!(obj instanceof C3508au)) {
            return C3523bd.f18898b;
        }
        if ((!(obj instanceof JobSupport) && !(obj instanceof C3518bb)) || (obj instanceof C3538i) || (obj2 instanceof C3542l)) {
            return m21540c((C3508au) obj, obj2);
        }
        if (m21532a((C3508au) obj, obj2)) {
            return obj2;
        }
        return C3523bd.f18899c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0072, code lost:
        if (r2 == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0074, code lost:
        m21530a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0077, code lost:
        r7 = m21535b(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007b, code lost:
        if (r7 == null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0081, code lost:
        if (m21534a(r1, r7, r8) == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0085, code lost:
        return kotlinx.coroutines.C3523bd.f18897a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x008a, code lost:
        return m21520a(r1, r8);
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m21540c(kotlinx.coroutines.C3508au r7, java.lang.Object r8) {
        /*
            r6 = this;
            kotlinx.coroutines.bf r0 = r6.m21525a((kotlinx.coroutines.C3508au) r7)
            if (r0 == 0) goto L_0x008e
            boolean r1 = r7 instanceof kotlinx.coroutines.C3519bc.C3521b
            r2 = 0
            if (r1 != 0) goto L_0x000d
            r1 = r2
            goto L_0x000e
        L_0x000d:
            r1 = r7
        L_0x000e:
            kotlinx.coroutines.bc$b r1 = (kotlinx.coroutines.C3519bc.C3521b) r1
            if (r1 == 0) goto L_0x0013
            goto L_0x0019
        L_0x0013:
            kotlinx.coroutines.bc$b r1 = new kotlinx.coroutines.bc$b
            r3 = 0
            r1.<init>(r0, r3, r2)
        L_0x0019:
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            monitor-enter(r1)
            boolean r3 = r1.mo27704c()     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x0029
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18898b     // Catch:{ all -> 0x008b }
            monitor-exit(r1)
            return r7
        L_0x0029:
            r3 = 1
            r1.mo27701a((boolean) r3)     // Catch:{ all -> 0x008b }
            if (r1 == r7) goto L_0x003d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f18883c     // Catch:{ all -> 0x008b }
            boolean r4 = r4.compareAndSet(r6, r7, r1)     // Catch:{ all -> 0x008b }
            if (r4 != 0) goto L_0x003d
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18899c     // Catch:{ all -> 0x008b }
            monitor-exit(r1)
            return r7
        L_0x003d:
            boolean r4 = kotlinx.coroutines.Debug.m21406a()     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0053
            boolean r4 = r1.mo27706e()     // Catch:{ all -> 0x008b }
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x004b
            goto L_0x0053
        L_0x004b:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x008b }
            r7.<init>()     // Catch:{ all -> 0x008b }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x008b }
            throw r7     // Catch:{ all -> 0x008b }
        L_0x0053:
            boolean r4 = r1.mo27707f()     // Catch:{ all -> 0x008b }
            boolean r5 = r8 instanceof kotlinx.coroutines.C3542l     // Catch:{ all -> 0x008b }
            if (r5 != 0) goto L_0x005d
            r5 = r2
            goto L_0x005e
        L_0x005d:
            r5 = r8
        L_0x005e:
            kotlinx.coroutines.l r5 = (kotlinx.coroutines.C3542l) r5     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x0067
            java.lang.Throwable r5 = r5.f18930a     // Catch:{ all -> 0x008b }
            r1.mo27703c(r5)     // Catch:{ all -> 0x008b }
        L_0x0067:
            java.lang.Throwable r5 = r1.mo27705d()     // Catch:{ all -> 0x008b }
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x006f
            r2 = r5
        L_0x006f:
            kotlin.t r3 = kotlin.Unit.f18749a     // Catch:{ all -> 0x008b }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0077
            r6.m21530a((kotlinx.coroutines.C3525bf) r0, (java.lang.Throwable) r2)
        L_0x0077:
            kotlinx.coroutines.i r7 = r6.m21535b((kotlinx.coroutines.C3508au) r7)
            if (r7 == 0) goto L_0x0086
            boolean r7 = r6.m21534a((kotlinx.coroutines.C3519bc.C3521b) r1, (kotlinx.coroutines.C3538i) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0086
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18897a
            return r7
        L_0x0086:
            java.lang.Object r7 = r6.m21520a((kotlinx.coroutines.C3519bc.C3521b) r1, (java.lang.Object) r8)
            return r7
        L_0x008b:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        L_0x008e:
            kotlinx.coroutines.a.m r7 = kotlinx.coroutines.C3523bd.f18899c
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C3519bc.m21540c(kotlinx.coroutines.au, java.lang.Object):java.lang.Object");
    }

    /* renamed from: j */
    private final Throwable m21545j(@Nullable Object obj) {
        if (!(obj instanceof C3542l)) {
            obj = null;
        }
        C3542l lVar = (C3542l) obj;
        if (lVar != null) {
            return lVar.f18930a;
        }
        return null;
    }

    /* renamed from: b */
    private final C3538i m21535b(C3508au auVar) {
        C3538i iVar = (C3538i) (!(auVar instanceof C3538i) ? null : auVar);
        if (iVar != null) {
            return iVar;
        }
        C3525bf p_ = auVar.mo27644p_();
        if (p_ != null) {
            return m21526a((C3480g) p_);
        }
        return null;
    }

    /* renamed from: a */
    private final boolean m21534a(C3521b bVar, C3538i iVar, Object obj) {
        while (C3512ay.C3513a.m21505a(iVar.f18922a, false, false, new C3520a(this, bVar, iVar, obj), 1, (Object) null) == C3526bg.f18905a) {
            iVar = m21526a((C3480g) iVar);
            if (iVar == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21538b(C3521b bVar, C3538i iVar, Object obj) {
        if (Debug.m21406a()) {
            if (!(mo27692l() == bVar)) {
                throw new AssertionError();
            }
        }
        C3538i a = m21526a((C3480g) iVar);
        if (a == null || !m21534a(bVar, a, obj)) {
            mo27690g(m21520a(bVar, obj));
        }
    }

    /* renamed from: a */
    private final C3538i m21526a(@NotNull C3480g gVar) {
        while (gVar.mo27583d()) {
            gVar = gVar.mo27588g();
        }
        while (true) {
            gVar = gVar.mo27587f();
            if (!gVar.mo27583d()) {
                if (gVar instanceof C3538i) {
                    return (C3538i) gVar;
                }
                if (gVar instanceof C3525bf) {
                    return null;
                }
            }
        }
    }

    @NotNull
    /* renamed from: a */
    public final C3537h mo27671a(@NotNull C3539j jVar) {
        Job a = C3512ay.C3513a.m21505a(this, true, false, new C3538i(this, jVar), 2, (Object) null);
        if (a != null) {
            return (C3537h) a;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    /* renamed from: a */
    public void mo27554a(@NotNull Throwable th) {
        throw th;
    }

    @NotNull
    public String toString() {
        return mo27698r() + '@' + DebugStrings.m21410a((Object) this);
    }

    @NotNull
    @InternalCoroutinesApi
    /* renamed from: r */
    public final String mo27698r() {
        return mo27565h() + '{' + m21546k(mo27692l()) + '}';
    }

    @NotNull
    /* renamed from: h */
    public String mo27565h() {
        return DebugStrings.m21412b(this);
    }

    /* renamed from: k */
    private final String m21546k(Object obj) {
        if (!(obj instanceof C3521b)) {
            return obj instanceof C3508au ? ((C3508au) obj).mo27643b() ? "Active" : "New" : obj instanceof C3542l ? "Cancelled" : "Completed";
        }
        C3521b bVar = (C3521b) obj;
        if (bVar.mo27707f()) {
            return "Cancelling";
        }
        return bVar.mo27704c() ? "Completing" : "Active";
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0013\u0010$\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001c\u0010\u0002\u001a\u00020\u00018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, mo27294d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.bc$b */
    /* compiled from: JobSupport.kt */
    private static final class C3521b implements C3508au {

        /* renamed from: a */
        private volatile int f18890a;

        /* renamed from: b */
        private volatile Object f18891b;

        /* renamed from: c */
        private volatile Object f18892c = null;
        @NotNull

        /* renamed from: d */
        private final C3525bf f18893d;

        @NotNull
        /* renamed from: p_ */
        public C3525bf mo27644p_() {
            return this.f18893d;
        }

        public C3521b(@NotNull C3525bf bfVar, boolean z, @Nullable Throwable th) {
            this.f18893d = bfVar;
            this.f18890a = z ? 1 : 0;
            this.f18891b = th;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
        /* renamed from: c */
        public final boolean mo27704c() {
            return this.f18890a;
        }

        /* renamed from: a */
        public final void mo27701a(boolean z) {
            this.f18890a = z ? 1 : 0;
        }

        @Nullable
        /* renamed from: d */
        public final Throwable mo27705d() {
            return (Throwable) this.f18891b;
        }

        /* renamed from: a */
        public final void mo27700a(@Nullable Throwable th) {
            this.f18891b = th;
        }

        /* renamed from: g */
        private final Object m21584g() {
            return this.f18892c;
        }

        /* renamed from: a */
        private final void m21583a(Object obj) {
            this.f18892c = obj;
        }

        /* renamed from: e */
        public final boolean mo27706e() {
            return m21584g() == C3523bd.f18901e;
        }

        /* renamed from: f */
        public final boolean mo27707f() {
            return mo27705d() != null;
        }

        /* renamed from: b */
        public boolean mo27643b() {
            return mo27705d() == null;
        }

        @NotNull
        /* renamed from: b */
        public final List<Throwable> mo27702b(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            Object g = m21584g();
            if (g == null) {
                arrayList = m21585h();
            } else if (g instanceof Throwable) {
                ArrayList<Throwable> h = m21585h();
                h.add(g);
                arrayList = h;
            } else if (g instanceof ArrayList) {
                arrayList = (ArrayList) g;
            } else {
                throw new IllegalStateException(("State is " + g).toString());
            }
            Throwable d = mo27705d();
            if (d != null) {
                arrayList.add(0, d);
            }
            if (th != null && (!C3443i.m21154a((Object) th, (Object) d))) {
                arrayList.add(th);
            }
            m21583a((Object) C3523bd.f18901e);
            return arrayList;
        }

        /* renamed from: c */
        public final void mo27703c(@NotNull Throwable th) {
            Throwable d = mo27705d();
            if (d == null) {
                mo27700a(th);
            } else if (th != d) {
                Object g = m21584g();
                if (g == null) {
                    m21583a((Object) th);
                } else if (g instanceof Throwable) {
                    if (th != g) {
                        ArrayList<Throwable> h = m21585h();
                        h.add(g);
                        h.add(th);
                        m21583a((Object) h);
                    }
                } else if (g instanceof ArrayList) {
                    ((ArrayList) g).add(th);
                } else {
                    throw new IllegalStateException(("State is " + g).toString());
                }
            }
        }

        /* renamed from: h */
        private final ArrayList<Throwable> m21585h() {
            return new ArrayList<>(4);
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + mo27707f() + ", completing=" + mo27704c() + ", rootCause=" + mo27705d() + ", exceptions=" + m21584g() + ", list=" + mo27644p_() + ']';
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo27294d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.bc$a */
    /* compiled from: JobSupport.kt */
    private static final class C3520a extends C3518bb<C3512ay> {

        /* renamed from: a */
        private final C3519bc f18886a;

        /* renamed from: g */
        private final C3521b f18887g;

        /* renamed from: h */
        private final C3538i f18888h;

        /* renamed from: i */
        private final Object f18889i;

        /* renamed from: a */
        public /* synthetic */ Object mo27487a(Object obj) {
            mo27669b((Throwable) obj);
            return Unit.f18749a;
        }

        public C3520a(@NotNull C3519bc bcVar, @NotNull C3521b bVar, @NotNull C3538i iVar, @Nullable Object obj) {
            super(iVar.f18922a);
            this.f18886a = bcVar;
            this.f18887g = bVar;
            this.f18888h = iVar;
            this.f18889i = obj;
        }

        /* renamed from: b */
        public void mo27669b(@Nullable Throwable th) {
            this.f18886a.m21538b(this.f18887g, this.f18888h, this.f18889i);
        }

        @NotNull
        public String toString() {
            return "ChildCompletion[" + this.f18888h + ", " + this.f18889i + ']';
        }
    }

    @Nullable
    /* renamed from: l */
    public final Object mo27692l() {
        while (true) {
            Object obj = this.f18884a;
            if (!(obj instanceof C3485j)) {
                return obj;
            }
            ((C3485j) obj).mo27574c(this);
        }
    }

    /* renamed from: b */
    private final void m21539b(@NotNull C3525bf bfVar, Throwable th) {
        Throwable th2 = null;
        LockFreeLinkedList eVar = bfVar;
        Object e = eVar.mo27586e();
        if (e != null) {
            for (C3480g gVar = (C3480g) e; !C3443i.m21154a((Object) gVar, (Object) eVar); gVar = gVar.mo27587f()) {
                if (gVar instanceof C3518bb) {
                    C3518bb bbVar = (C3518bb) gVar;
                    try {
                        bbVar.mo27669b(th);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            Exceptions.m20931a(th2, th3);
                            if (th2 != null) {
                            }
                        }
                        Unit tVar = Unit.f18749a;
                        th2 = new C3546q("Exception in completion handler " + bbVar + " for " + this, th3);
                    }
                }
            }
            if (th2 != null) {
                mo27554a(th2);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo27673j() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.mo27692l()
            int r0 = r1.mo27553a((java.lang.Object) r0)
            switch(r0) {
                case 0: goto L_0x000e;
                case 1: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0000
        L_0x000c:
            r0 = 1
            return r0
        L_0x000e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C3519bc.mo27673j():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27682a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.C3518bb<?> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.mo27692l()
            boolean r1 = r0 instanceof kotlinx.coroutines.C3518bb
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f18883c
            kotlinx.coroutines.al r2 = kotlinx.coroutines.C3523bd.f18903g
            boolean r0 = r1.compareAndSet(r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.C3508au
            if (r1 == 0) goto L_0x0028
            kotlinx.coroutines.au r0 = (kotlinx.coroutines.C3508au) r0
            kotlinx.coroutines.bf r0 = r0.mo27644p_()
            if (r0 == 0) goto L_0x0027
            r4.mo27582c()
        L_0x0027:
            return
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C3519bc.mo27682a(kotlinx.coroutines.bb):void");
    }

    /* renamed from: d */
    private final Object mo27561d(Object obj) {
        Object a;
        do {
            Object l = mo27692l();
            if (!(l instanceof C3508au) || ((l instanceof C3521b) && ((C3521b) l).mo27704c())) {
                return C3523bd.f18898b;
            }
            a = m21519a(l, (Object) new C3542l(m21543h(obj), false, 2, (DefaultConstructorMarker) null));
        } while (a == C3523bd.f18899c);
        return a;
    }

    @Nullable
    /* renamed from: f */
    public final Object mo27689f(@Nullable Object obj) {
        Object a;
        do {
            a = m21519a(mo27692l(), obj);
            if (a == C3523bd.f18898b) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, " + "but is being completed with " + obj, m21545j(obj));
            }
        } while (a == C3523bd.f18899c);
        return a;
    }
}
