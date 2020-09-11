package flyme.support.p093v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import flyme.support.p093v7.appcompat.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: flyme.support.v7.app.b */
public class AppCompatViewInflater {

    /* renamed from: a */
    private static final Class<?>[] f16955a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final int[] f16956b = {16843375};

    /* renamed from: c */
    private static final String[] f16957c = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: d */
    private static final Map<String, Constructor<? extends View>> f16958d = new ArrayMap();

    /* renamed from: e */
    private final Object[] f16959e = new Object[2];

    AppCompatViewInflater() {
    }

    /* renamed from: a */
    public final View mo25321a(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m18560a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = TintContextWrapper.wrap(context2);
        }
        View view2 = null;
        char c = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                view2 = new AppCompatTextView(context2, attributeSet);
                break;
            case 1:
                view2 = new AppCompatImageView(context2, attributeSet);
                break;
            case 2:
                view2 = new AppCompatButton(context2, attributeSet);
                break;
            case 3:
                view2 = new AppCompatEditText(context2, attributeSet);
                break;
            case 4:
                view2 = new AppCompatSpinner(context2, attributeSet);
                break;
            case 5:
                view2 = new AppCompatImageButton(context2, attributeSet);
                break;
            case 6:
                view2 = new AppCompatCheckBox(context2, attributeSet);
                break;
            case 7:
                view2 = new AppCompatRadioButton(context2, attributeSet);
                break;
            case 8:
                view2 = new AppCompatCheckedTextView(context2, attributeSet);
                break;
            case 9:
                view2 = new AppCompatAutoCompleteTextView(context2, attributeSet);
                break;
            case 10:
                view2 = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                break;
            case 11:
                view2 = new AppCompatRatingBar(context2, attributeSet);
                break;
            case 12:
                view2 = new AppCompatSeekBar(context2, attributeSet);
                break;
        }
        if (view2 == null && context != context2) {
            view2 = m18561a(context2, str, attributeSet);
        }
        if (view2 != null) {
            m18563a(view2, attributeSet);
        }
        return view2;
    }

    /* renamed from: a */
    private View m18561a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            this.f16959e[0] = context;
            this.f16959e[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String a : f16957c) {
                    View a2 = m18562a(context, str, a);
                    if (a2 != null) {
                        return a2;
                    }
                }
                this.f16959e[0] = null;
                this.f16959e[1] = null;
                return null;
            }
            View a3 = m18562a(context, str, (String) null);
            this.f16959e[0] = null;
            this.f16959e[1] = null;
            return a3;
        } catch (Exception unused) {
            return null;
        } finally {
            this.f16959e[0] = null;
            this.f16959e[1] = null;
        }
    }

    /* renamed from: a */
    private void m18563a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || ViewCompat.hasOnClickListeners(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f16956b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C3133a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private View m18562a(Context context, String str, String str2) throws InflateException {
        String str3;
        Constructor<? extends U> constructor = f16958d.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(f16955a);
                f16958d.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f16959e);
    }

    /* renamed from: a */
    private static Context m18560a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).getThemeResId() != resourceId) ? new ContextThemeWrapper(context, resourceId) : context;
        }
        return context;
    }

    /* renamed from: flyme.support.v7.app.b$a */
    /* compiled from: AppCompatViewInflater */
    private static class C3133a implements View.OnClickListener {

        /* renamed from: a */
        private final View f16960a;

        /* renamed from: b */
        private final String f16961b;

        /* renamed from: c */
        private Method f16962c;

        /* renamed from: d */
        private Context f16963d;

        public C3133a(@NonNull View view, @NonNull String str) {
            this.f16960a = view;
            this.f16961b = str;
        }

        public void onClick(@NonNull View view) {
            if (this.f16962c == null) {
                m18565a(this.f16960a.getContext(), this.f16961b);
            }
            try {
                this.f16962c.invoke(this.f16963d, new Object[]{view});
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        @NonNull
        /* renamed from: a */
        private void m18565a(@Nullable Context context, @NonNull String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f16961b, new Class[]{View.class})) != null) {
                        this.f16962c = method;
                        this.f16963d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f16960a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f16960a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f16961b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f16960a.getClass() + str2);
        }
    }
}
