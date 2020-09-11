package flyme.support.p093v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.PermissionChecker;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.util.Calendar;

/* renamed from: flyme.support.v7.app.e */
public class TwilightManager {

    /* renamed from: a */
    private static final C3138a f16978a = new C3138a();

    /* renamed from: b */
    private final Context f16979b;

    /* renamed from: c */
    private final LocationManager f16980c;

    TwilightManager(Context context) {
        this.f16979b = context;
        this.f16980c = (LocationManager) context.getSystemService("location");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25327a() {
        C3138a aVar = f16978a;
        if (m18601a(aVar)) {
            return aVar.f16981a;
        }
        Location b = m18602b();
        if (b != null) {
            m18600a(b);
            return aVar.f16981a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    /* renamed from: b */
    private Location m18602b() {
        Location location = null;
        Location a = PermissionChecker.checkSelfPermission(this.f16979b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m18599a(Parameters.NETWORK) : null;
        if (PermissionChecker.checkSelfPermission(this.f16979b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m18599a("gps");
        }
        return (location == null || a == null) ? location != null ? location : a : location.getTime() > a.getTime() ? location : a;
    }

    /* renamed from: a */
    private Location m18599a(String str) {
        if (this.f16980c == null) {
            return null;
        }
        try {
            if (this.f16980c.isProviderEnabled(str)) {
                return this.f16980c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m18601a(C3138a aVar) {
        return aVar != null && aVar.f16986f > System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m18600a(@NonNull Location location) {
        long j;
        C3138a aVar = f16978a;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator a = TwilightCalculator.m18597a();
        TwilightCalculator dVar = a;
        dVar.mo25326a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f16975a;
        dVar.mo25326a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f16977c == 1;
        long j3 = a.f16976b;
        long j4 = j2;
        long j5 = a.f16975a;
        long j6 = j3;
        a.mo25326a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j7 = a.f16976b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f16981a = z;
        aVar.f16982b = j4;
        aVar.f16983c = j6;
        aVar.f16984d = j5;
        aVar.f16985e = j7;
        aVar.f16986f = j;
    }

    /* renamed from: flyme.support.v7.app.e$a */
    /* compiled from: TwilightManager */
    private static class C3138a {

        /* renamed from: a */
        boolean f16981a;

        /* renamed from: b */
        long f16982b;

        /* renamed from: c */
        long f16983c;

        /* renamed from: d */
        long f16984d;

        /* renamed from: e */
        long f16985e;

        /* renamed from: f */
        long f16986f;

        private C3138a() {
        }
    }
}
