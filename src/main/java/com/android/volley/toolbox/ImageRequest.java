package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;

/* renamed from: com.android.volley.toolbox.l */
public class ImageRequest extends Request<Bitmap> {

    /* renamed from: g */
    private static final Object f411g = new Object();

    /* renamed from: a */
    private final Object f412a;
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: b */
    private Response.C0452b<Bitmap> f413b;

    /* renamed from: c */
    private final Bitmap.Config f414c;

    /* renamed from: d */
    private final int f415d;

    /* renamed from: e */
    private final int f416e;

    /* renamed from: f */
    private final ImageView.ScaleType f417f;

    public ImageRequest(String str, Response.C0452b<Bitmap> bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, @Nullable Response.C0451a aVar) {
        super(0, str, aVar);
        this.f412a = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f413b = bVar;
        this.f414c = config;
        this.f415d = i;
        this.f416e = i2;
        this.f417f = scaleType;
    }

    @Deprecated
    public ImageRequest(String str, Response.C0452b<Bitmap> bVar, int i, int i2, Bitmap.Config config, Response.C0451a aVar) {
        this(str, bVar, i, i2, ImageView.ScaleType.CENTER_INSIDE, config, aVar);
    }

    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* renamed from: a */
    private static int m718a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = ((double) i4) / ((double) i3);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d2 = (double) i2;
                return ((double) i) * d < d2 ? (int) (d2 / d) : i;
            }
            double d3 = (double) i2;
            return ((double) i) * d > d3 ? (int) (d3 / d) : i;
        }
    }

    /* access modifiers changed from: protected */
    public Response<Bitmap> parseNetworkResponse(NetworkResponse kVar) {
        Response<Bitmap> a;
        synchronized (f411g) {
            try {
                a = m719a(kVar);
            } catch (OutOfMemoryError e) {
                VolleyLog.m729c("Caught OOM for %d byte image, url=%s", Integer.valueOf(kVar.f326b.length), getUrl());
                return Response.m609a(new ParseError((Throwable) e));
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }

    /* renamed from: a */
    private Response<Bitmap> m719a(NetworkResponse kVar) {
        Bitmap bitmap;
        byte[] bArr = kVar.f326b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f415d == 0 && this.f416e == 0) {
            options.inPreferredConfig = this.f414c;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int a = m718a(this.f415d, this.f416e, i, i2, this.f417f);
            int a2 = m718a(this.f416e, this.f415d, i2, i, this.f417f);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m717a(i, i2, a, a2);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > a || bitmap.getHeight() > a2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a, a2, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap == null) {
            return Response.m609a(new ParseError(kVar));
        }
        return Response.m610a(bitmap, HttpHeaderParser.m669a(kVar));
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f412a) {
            this.f413b = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(Bitmap bitmap) {
        Response.C0452b<Bitmap> bVar;
        synchronized (this.f412a) {
            bVar = this.f413b;
        }
        if (bVar != null) {
            bVar.onResponse(bitmap);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static int m717a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }
}
