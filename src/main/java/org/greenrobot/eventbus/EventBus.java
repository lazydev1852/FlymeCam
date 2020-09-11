package org.greenrobot.eventbus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* renamed from: org.greenrobot.eventbus.c */
public class EventBus {

    /* renamed from: a */
    public static String f19023a = "EventBus";

    /* renamed from: b */
    static volatile EventBus f19024b;

    /* renamed from: c */
    private static final EventBusBuilder f19025c = new EventBusBuilder();

    /* renamed from: d */
    private static final Map<Class<?>, List<Class<?>>> f19026d = new HashMap();

    /* renamed from: e */
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> f19027e;

    /* renamed from: f */
    private final Map<Object, List<Class<?>>> f19028f;

    /* renamed from: g */
    private final Map<Class<?>, Object> f19029g;

    /* renamed from: h */
    private final ThreadLocal<C3590a> f19030h;

    /* renamed from: i */
    private final HandlerPoster f19031i;

    /* renamed from: j */
    private final BackgroundPoster f19032j;

    /* renamed from: k */
    private final AsyncPoster f19033k;

    /* renamed from: l */
    private final SubscriberMethodFinder f19034l;

    /* renamed from: m */
    private final ExecutorService f19035m;

    /* renamed from: n */
    private final boolean f19036n;

    /* renamed from: o */
    private final boolean f19037o;

    /* renamed from: p */
    private final boolean f19038p;

    /* renamed from: q */
    private final boolean f19039q;

    /* renamed from: r */
    private final boolean f19040r;

    /* renamed from: s */
    private final boolean f19041s;

    /* renamed from: t */
    private final int f19042t;

    /* renamed from: a */
    public static EventBus m21789a() {
        if (f19024b == null) {
            synchronized (EventBus.class) {
                if (f19024b == null) {
                    f19024b = new EventBus();
                }
            }
        }
        return f19024b;
    }

    public EventBus() {
        this(f19025c);
    }

    EventBus(EventBusBuilder dVar) {
        this.f19030h = new ThreadLocal<C3590a>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public C3590a initialValue() {
                return new C3590a();
            }
        };
        this.f19027e = new HashMap();
        this.f19028f = new HashMap();
        this.f19029g = new ConcurrentHashMap();
        this.f19031i = new HandlerPoster(this, Looper.getMainLooper(), 10);
        this.f19032j = new BackgroundPoster(this);
        this.f19033k = new AsyncPoster(this);
        this.f19042t = dVar.f19061j != null ? dVar.f19061j.size() : 0;
        this.f19034l = new SubscriberMethodFinder(dVar.f19061j, dVar.f19059h, dVar.f19058g);
        this.f19037o = dVar.f19052a;
        this.f19038p = dVar.f19053b;
        this.f19039q = dVar.f19054c;
        this.f19040r = dVar.f19055d;
        this.f19036n = dVar.f19056e;
        this.f19041s = dVar.f19057f;
        this.f19035m = dVar.f19060i;
    }

    /* renamed from: a */
    public void mo27974a(Object obj) {
        List<SubscriberMethod> a = this.f19034l.mo27991a(obj.getClass());
        synchronized (this) {
            for (SubscriberMethod a2 : a) {
                m21792a(obj, a2);
            }
        }
    }

    /* renamed from: a */
    private void m21792a(Object obj, SubscriberMethod kVar) {
        Class<?> cls = kVar.f19080c;
        Subscription mVar = new Subscription(obj, kVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f19027e.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f19027e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(mVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            } else if (i == size || kVar.f19081d > ((Subscription) copyOnWriteArrayList.get(i)).f19098b.f19081d) {
                copyOnWriteArrayList.add(i, mVar);
            } else {
                i++;
            }
        }
        copyOnWriteArrayList.add(i, mVar);
        List list = this.f19028f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f19028f.put(obj, list);
        }
        list.add(cls);
        if (!kVar.f19082e) {
            return;
        }
        if (this.f19041s) {
            for (Map.Entry next : this.f19029g.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    m21797b(mVar, next.getValue());
                }
            }
            return;
        }
        m21797b(mVar, this.f19029g.get(cls));
    }

    /* renamed from: b */
    private void m21797b(Subscription mVar, Object obj) {
        if (obj != null) {
            m21795a(mVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    /* renamed from: b */
    public synchronized boolean mo27978b(Object obj) {
        return this.f19028f.containsKey(obj);
    }

    /* renamed from: a */
    private void m21790a(Object obj, Class<?> cls) {
        List list = this.f19027e.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                Subscription mVar = (Subscription) list.get(i);
                if (mVar.f19097a == obj) {
                    mVar.f19099c = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* renamed from: c */
    public synchronized void mo27979c(Object obj) {
        List<Class> list = this.f19028f.get(obj);
        if (list != null) {
            for (Class a : list) {
                m21790a(obj, (Class<?>) a);
            }
            this.f19028f.remove(obj);
        } else {
            String str = f19023a;
            Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* renamed from: d */
    public void mo27980d(Object obj) {
        C3590a aVar = this.f19030h.get();
        List<Object> list = aVar.f19045a;
        list.add(obj);
        if (!aVar.f19046b) {
            aVar.f19047c = Looper.getMainLooper() == Looper.myLooper();
            aVar.f19046b = true;
            if (!aVar.f19050f) {
                while (!list.isEmpty()) {
                    try {
                        m21791a(list.remove(0), aVar);
                    } finally {
                        aVar.f19046b = false;
                        aVar.f19047c = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    /* renamed from: a */
    private void m21791a(Object obj, C3590a aVar) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.f19041s) {
            List<Class<?>> a = m21788a(cls);
            int size = a.size();
            z = false;
            for (int i = 0; i < size; i++) {
                z |= m21796a(obj, aVar, a.get(i));
            }
        } else {
            z = m21796a(obj, aVar, cls);
        }
        if (!z) {
            if (this.f19038p) {
                String str = f19023a;
                Log.d(str, "No subscribers registered for event " + cls);
            }
            if (this.f19040r && cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                mo27980d(new NoSubscriberEvent(this, obj));
            }
        }
    }

    /* renamed from: a */
    private boolean m21796a(Object obj, C3590a aVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f19027e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Subscription mVar = (Subscription) it.next();
            aVar.f19049e = obj;
            aVar.f19048d = mVar;
            try {
                m21795a(mVar, obj, aVar.f19047c);
                if (aVar.f19050f) {
                    return true;
                }
            } finally {
                aVar.f19049e = null;
                aVar.f19048d = null;
                aVar.f19050f = false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m21795a(Subscription mVar, Object obj, boolean z) {
        switch (mVar.f19098b.f19079b) {
            case POSTING:
                mo27976a(mVar, obj);
                return;
            case MAIN:
                if (z) {
                    mo27976a(mVar, obj);
                    return;
                } else {
                    this.f19031i.mo27984a(mVar, obj);
                    return;
                }
            case BACKGROUND:
                if (z) {
                    this.f19032j.mo27972a(mVar, obj);
                    return;
                } else {
                    mo27976a(mVar, obj);
                    return;
                }
            case ASYNC:
                this.f19033k.mo27966a(mVar, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + mVar.f19098b.f19079b);
        }
    }

    /* renamed from: a */
    private static List<Class<?>> m21788a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f19026d) {
            list = f19026d.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    m21793a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f19026d.put(cls, list);
            }
        }
        return list;
    }

    /* renamed from: a */
    static void m21793a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                m21793a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27975a(PendingPost hVar) {
        Object obj = hVar.f19069a;
        Subscription mVar = hVar.f19070b;
        PendingPost.m21808a(hVar);
        if (mVar.f19099c) {
            mo27976a(mVar, obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27976a(Subscription mVar, Object obj) {
        try {
            mVar.f19098b.f19078a.invoke(mVar.f19097a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            m21794a(mVar, obj, e.getCause());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    /* renamed from: a */
    private void m21794a(Subscription mVar, Object obj, Throwable th) {
        if (obj instanceof SubscriberExceptionEvent) {
            if (this.f19037o) {
                String str = f19023a;
                Log.e(str, "SubscriberExceptionEvent subscriber " + mVar.f19097a.getClass() + " threw an exception", th);
                SubscriberExceptionEvent jVar = (SubscriberExceptionEvent) obj;
                String str2 = f19023a;
                Log.e(str2, "Initial event " + jVar.f19076c + " caused exception in " + jVar.f19077d, jVar.f19075b);
            }
        } else if (!this.f19036n) {
            if (this.f19037o) {
                String str3 = f19023a;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + mVar.f19097a.getClass(), th);
            }
            if (this.f19039q) {
                mo27980d(new SubscriberExceptionEvent(this, th, obj, mVar.f19097a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    /* renamed from: org.greenrobot.eventbus.c$a */
    /* compiled from: EventBus */
    static final class C3590a {

        /* renamed from: a */
        final List<Object> f19045a = new ArrayList();

        /* renamed from: b */
        boolean f19046b;

        /* renamed from: c */
        boolean f19047c;

        /* renamed from: d */
        Subscription f19048d;

        /* renamed from: e */
        Object f19049e;

        /* renamed from: f */
        boolean f19050f;

        C3590a() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ExecutorService mo27977b() {
        return this.f19035m;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f19042t + ", eventInheritance=" + this.f19041s + "]";
    }
}
