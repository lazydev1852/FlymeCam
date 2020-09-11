package flyme.support.p093v7.p095b;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/* renamed from: flyme.support.v7.b.a */
public class Localization {

    /* renamed from: a */
    private int f17043a;

    /* renamed from: b */
    private String f17044b;
    @StringRes

    /* renamed from: c */
    private int f17045c;
    @DrawableRes

    /* renamed from: d */
    private int f17046d;

    public Localization(int i, String str, @DrawableRes int i2) {
        this.f17043a = i;
        this.f17044b = str;
        this.f17046d = i2;
    }

    /* renamed from: a */
    public int mo25361a() {
        return this.f17043a;
    }

    /* renamed from: a */
    public String mo25362a(Context context) {
        if (this.f17045c != 0) {
            return context.getResources().getString(this.f17045c);
        }
        return this.f17044b;
    }
}
