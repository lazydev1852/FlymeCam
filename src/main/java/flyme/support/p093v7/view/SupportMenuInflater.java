package flyme.support.p093v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.menu.MenuItemImpl;
import flyme.support.p093v7.view.menu.MenuItemWrapperICS;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: flyme.support.v7.view.h */
public class SupportMenuInflater extends MenuInflater {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Class<?>[] f17139a = {Context.class};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Class<?>[] f17140b = f17139a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object[] f17141c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object[] f17142d = this.f17141c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f17143e;

    /* renamed from: f */
    private Object f17144f;

    public SupportMenuInflater(Context context) {
        super(context);
        this.f17143e = context;
        this.f17141c = new Object[]{context};
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflate(int r3, android.view.Menu r4) {
        /*
            r2 = this;
            boolean r0 = r4 instanceof androidx.core.internal.view.SupportMenu
            if (r0 != 0) goto L_0x0008
            super.inflate(r3, r4)
            return
        L_0x0008:
            r0 = 0
            android.content.Context r1 = r2.f17143e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.content.res.XmlResourceParser r3 = r1.getLayout(r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r3)     // Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
            r2.m18844a(r3, r0, r4)     // Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
            if (r3 == 0) goto L_0x001f
            r3.close()
        L_0x001f:
            return
        L_0x0020:
            r4 = move-exception
            r0 = r3
            goto L_0x003d
        L_0x0023:
            r4 = move-exception
            r0 = r3
            goto L_0x002c
        L_0x0026:
            r4 = move-exception
            r0 = r3
            goto L_0x0035
        L_0x0029:
            r4 = move-exception
            goto L_0x003d
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            android.view.InflateException r3 = new android.view.InflateException     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = "Error inflating menu XML"
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0029 }
            throw r3     // Catch:{ all -> 0x0029 }
        L_0x0034:
            r4 = move-exception
        L_0x0035:
            android.view.InflateException r3 = new android.view.InflateException     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = "Error inflating menu XML"
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0029 }
            throw r3     // Catch:{ all -> 0x0029 }
        L_0x003d:
            if (r0 == 0) goto L_0x0042
            r0.close()
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.view.SupportMenuInflater.inflate(int, android.view.Menu):void");
    }

    /* renamed from: a */
    private void m18844a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        C3157b bVar = new C3157b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (i) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        String name2 = xmlPullParser.getName();
                        if (!name2.equals("group")) {
                            if (!name2.equals("item")) {
                                if (!name2.equals("menu")) {
                                    str = name2;
                                    z2 = true;
                                    break;
                                } else {
                                    m18844a(xmlPullParser, attributeSet, bVar.mo25458c());
                                    break;
                                }
                            } else {
                                bVar.mo25457b(attributeSet);
                                break;
                            }
                        } else {
                            bVar.mo25455a(attributeSet);
                            break;
                        }
                    } else {
                        break;
                    }
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (!z2 || !name3.equals(str)) {
                        if (!name3.equals("group")) {
                            if (!name3.equals("item")) {
                                if (!name3.equals("menu")) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                            } else if (!bVar.mo25459d()) {
                                if (bVar.f17173z != null && bVar.f17173z.hasSubMenu()) {
                                    bVar.mo25458c();
                                    break;
                                } else {
                                    bVar.mo25456b();
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            bVar.mo25454a();
                            break;
                        }
                    } else {
                        str = null;
                        z2 = false;
                        break;
                    }
                    break;
            }
            i = xmlPullParser.next();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Object m18848c() {
        if (this.f17144f == null) {
            this.f17144f = m18843a((Object) this.f17143e);
        }
        return this.f17144f;
    }

    /* renamed from: a */
    private Object m18843a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m18843a((Object) ((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* renamed from: flyme.support.v7.view.h$a */
    /* compiled from: SupportMenuInflater */
    private static class C3156a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f17145a = {MenuItem.class};

        /* renamed from: b */
        private Object f17146b;

        /* renamed from: c */
        private Method f17147c;

        public C3156a(Object obj, String str) {
            this.f17146b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f17147c = cls.getMethod(str, f17145a);
            } catch (Exception e) {
                throw new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName(), e);
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f17147c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f17147c.invoke(this.f17146b, new Object[]{menuItem})).booleanValue();
                }
                this.f17147c.invoke(this.f17146b, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: flyme.support.v7.view.h$b */
    /* compiled from: SupportMenuInflater */
    private class C3157b {

        /* renamed from: b */
        private Menu f17149b;

        /* renamed from: c */
        private int f17150c;

        /* renamed from: d */
        private int f17151d;

        /* renamed from: e */
        private int f17152e;

        /* renamed from: f */
        private int f17153f;

        /* renamed from: g */
        private boolean f17154g;

        /* renamed from: h */
        private boolean f17155h;

        /* renamed from: i */
        private boolean f17156i;

        /* renamed from: j */
        private int f17157j;

        /* renamed from: k */
        private int f17158k;

        /* renamed from: l */
        private CharSequence f17159l;

        /* renamed from: m */
        private CharSequence f17160m;

        /* renamed from: n */
        private int f17161n;

        /* renamed from: o */
        private char f17162o;

        /* renamed from: p */
        private char f17163p;

        /* renamed from: q */
        private int f17164q;

        /* renamed from: r */
        private boolean f17165r;

        /* renamed from: s */
        private boolean f17166s;

        /* renamed from: t */
        private boolean f17167t;

        /* renamed from: u */
        private int f17168u;

        /* renamed from: v */
        private int f17169v;

        /* renamed from: w */
        private String f17170w;

        /* renamed from: x */
        private String f17171x;

        /* renamed from: y */
        private String f17172y;
        /* access modifiers changed from: private */

        /* renamed from: z */
        public ActionProvider f17173z;

        public C3157b(Menu menu) {
            this.f17149b = menu;
            mo25454a();
        }

        /* renamed from: a */
        public void mo25454a() {
            this.f17150c = 0;
            this.f17151d = 0;
            this.f17152e = 0;
            this.f17153f = 0;
            this.f17154g = true;
            this.f17155h = true;
        }

        /* renamed from: a */
        public void mo25455a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f17143e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f17150c = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f17151d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f17152e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f17153f = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f17154g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f17155h = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public void mo25457b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f17143e.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.f17157j = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.f17158k = (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.f17151d) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.f17152e) & 65535);
            this.f17159l = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.f17160m = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.f17161n = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.f17162o = m18851a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f17163p = m18851a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.f17164q = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f17164q = this.f17153f;
            }
            this.f17165r = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.f17166s = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.f17154g);
            this.f17167t = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.f17155h);
            this.f17168u = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.f17172y = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.f17169v = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.f17170w = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            this.f17171x = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.f17171x != null;
            if (z && this.f17169v == 0 && this.f17170w == null) {
                this.f17173z = (ActionProvider) m18853a(this.f17171x, SupportMenuInflater.f17140b, SupportMenuInflater.this.f17142d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f17173z = null;
            }
            obtainStyledAttributes.recycle();
            this.f17156i = false;
        }

        /* renamed from: a */
        private char m18851a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        private void m18854a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f17165r).setVisible(this.f17166s).setEnabled(this.f17167t).setCheckable(this.f17164q >= 1).setTitleCondensed(this.f17160m).setIcon(this.f17161n).setAlphabeticShortcut(this.f17162o).setNumericShortcut(this.f17163p);
            if (this.f17168u >= 0) {
                MenuItemCompat.setShowAsAction(menuItem, this.f17168u);
            }
            if (this.f17172y != null) {
                if (!SupportMenuInflater.this.f17143e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new C3156a(SupportMenuInflater.this.m18848c(), this.f17172y));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof MenuItemImpl;
            if (z2) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            }
            if (this.f17164q >= 2) {
                if (z2) {
                    ((MenuItemImpl) menuItem).mo25611a(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).mo25669a(true);
                }
            }
            if (this.f17170w != null) {
                MenuItemCompat.setActionView(menuItem, (View) m18853a(this.f17170w, SupportMenuInflater.f17139a, SupportMenuInflater.this.f17141c));
                z = true;
            }
            if (this.f17169v > 0) {
                if (!z) {
                    MenuItemCompat.setActionView(menuItem, this.f17169v);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f17173z != null) {
                MenuItemCompat.setActionProvider(menuItem, this.f17173z);
            }
        }

        /* renamed from: b */
        public void mo25456b() {
            this.f17156i = true;
            m18854a(this.f17149b.add(this.f17150c, this.f17157j, this.f17158k, this.f17159l));
        }

        /* renamed from: c */
        public SubMenu mo25458c() {
            this.f17156i = true;
            SubMenu addSubMenu = this.f17149b.addSubMenu(this.f17150c, this.f17157j, this.f17158k, this.f17159l);
            m18854a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: d */
        public boolean mo25459d() {
            return this.f17156i;
        }

        /* renamed from: a */
        private <T> T m18853a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = SupportMenuInflater.this.f17143e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
