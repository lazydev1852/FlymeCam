package flyme.support.p093v7.widget;

/* renamed from: flyme.support.v7.widget.s */
public class RtlSpacingHelper {

    /* renamed from: a */
    private int f18579a = 0;

    /* renamed from: b */
    private int f18580b = 0;

    /* renamed from: c */
    private int f18581c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f18582d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f18583e = 0;

    /* renamed from: f */
    private int f18584f = 0;

    /* renamed from: g */
    private boolean f18585g = false;

    /* renamed from: h */
    private boolean f18586h = false;

    RtlSpacingHelper() {
    }

    /* renamed from: a */
    public int mo27229a() {
        return this.f18579a;
    }

    /* renamed from: b */
    public int mo27232b() {
        return this.f18580b;
    }

    /* renamed from: c */
    public int mo27234c() {
        return this.f18585g ? this.f18580b : this.f18579a;
    }

    /* renamed from: d */
    public int mo27235d() {
        return this.f18585g ? this.f18579a : this.f18580b;
    }

    /* renamed from: a */
    public void mo27230a(int i, int i2) {
        this.f18581c = i;
        this.f18582d = i2;
        this.f18586h = true;
        if (this.f18585g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f18579a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f18580b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f18579a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f18580b = i2;
        }
    }

    /* renamed from: b */
    public void mo27233b(int i, int i2) {
        this.f18586h = false;
        if (i != Integer.MIN_VALUE) {
            this.f18583e = i;
            this.f18579a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f18584f = i2;
            this.f18580b = i2;
        }
    }

    /* renamed from: a */
    public void mo27231a(boolean z) {
        if (z != this.f18585g) {
            this.f18585g = z;
            if (!this.f18586h) {
                this.f18579a = this.f18583e;
                this.f18580b = this.f18584f;
            } else if (z) {
                this.f18579a = this.f18582d != Integer.MIN_VALUE ? this.f18582d : this.f18583e;
                this.f18580b = this.f18581c != Integer.MIN_VALUE ? this.f18581c : this.f18584f;
            } else {
                this.f18579a = this.f18581c != Integer.MIN_VALUE ? this.f18581c : this.f18583e;
                this.f18580b = this.f18582d != Integer.MIN_VALUE ? this.f18582d : this.f18584f;
            }
        }
    }
}
