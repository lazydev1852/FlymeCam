package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.zxing.client.result.CalendarParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/* renamed from: com.meizu.media.camera.barcode.result.b */
public final class CalendarResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8080a;

    /* renamed from: f */
    private static final LogUtil.C2630a f8081f = new LogUtil.C2630a("CalendarResultHandler");

    public CalendarResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_calendar_result_hint);
    }

    /* renamed from: a */
    private void m8578a(String str, Date date, boolean z, Date date2, String str2, String str3, String[] strArr) {
        String str4 = str;
        boolean z2 = z;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        Object[] objArr = {str4, date, new Byte(z2 ? (byte) 1 : 0), date2, str5, str6, strArr2};
        ChangeQuickRedirect changeQuickRedirect = f8080a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2583, new Class[]{String.class, Date.class, Boolean.TYPE, Date.class, String.class, String.class, String[].class}, Void.TYPE).isSupported) {
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.item/event");
            long time = date.getTime();
            intent.putExtra("beginTime", time);
            if (z2) {
                intent.putExtra("allDay", true);
            }
            if (date2 != null) {
                time = date2.getTime();
            } else if (z2) {
                time += 86400000;
            }
            intent.putExtra("endTime", time);
            intent.putExtra(PushConstants.TITLE, str4);
            intent.putExtra("eventLocation", str5);
            intent.putExtra("description", str6);
            if (strArr2 != null) {
                intent.putExtra("android.intent.extra.EMAIL", strArr2);
            }
            try {
                mo19219a(intent);
            } catch (ActivityNotFoundException unused) {
                LogUtil.m15956e(f8081f, "No calendar app available that responds to android.intent.action.INSERT");
                intent.setAction("android.intent.action.EDIT");
                mo19228b(intent);
            }
        }
    }

    /* renamed from: k */
    private String m8579k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8080a, false, 2584, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        CalendarParsedResult calendarParsedResult = (CalendarParsedResult) mo19232d();
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(calendarParsedResult.getSummary(), sb);
        Date start = calendarParsedResult.getStart();
        ParsedResult.maybeAppend(m8577a(calendarParsedResult.isStartAllDay(), start), sb);
        Date end = calendarParsedResult.getEnd();
        if (end != null) {
            ParsedResult.maybeAppend(m8577a(calendarParsedResult.isEndAllDay(), (!calendarParsedResult.isEndAllDay() || start.equals(end)) ? end : new Date(end.getTime() - 86400000)), sb);
        }
        ParsedResult.maybeAppend(calendarParsedResult.getLocation(), sb);
        ParsedResult.maybeAppend(calendarParsedResult.getOrganizer(), sb);
        ParsedResult.maybeAppend(calendarParsedResult.getAttendees(), sb);
        ParsedResult.maybeAppend(calendarParsedResult.getDescription(), sb);
        return sb.toString();
    }

    /* renamed from: a */
    private static String m8577a(boolean z, Date date) {
        DateFormat dateFormat;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), date};
        ChangeQuickRedirect changeQuickRedirect = f8080a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 2585, new Class[]{Boolean.TYPE, Date.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (date == null) {
            return null;
        }
        if (z) {
            dateFormat = DateFormat.getDateInstance(2);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateFormat.format(date);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        String str2;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), str}, this, f8080a, false, 2586, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            if (i == 4) {
                mo19247n("ADD_CALENDAR");
                CalendarParsedResult calendarParsedResult = (CalendarParsedResult) mo19232d();
                String description = calendarParsedResult.getDescription();
                String organizer = calendarParsedResult.getOrganizer();
                if (organizer != null) {
                    if (description == null) {
                        str2 = organizer;
                        m8578a(calendarParsedResult.getSummary(), calendarParsedResult.getStart(), calendarParsedResult.isStartAllDay(), calendarParsedResult.getEnd(), calendarParsedResult.getLocation(), str2, calendarParsedResult.getAttendees());
                    }
                    description = description + 10 + organizer;
                }
                str2 = description;
                m8578a(calendarParsedResult.getSummary(), calendarParsedResult.getStart(), calendarParsedResult.isStartAllDay(), calendarParsedResult.getEnd(), calendarParsedResult.getLocation(), str2, calendarParsedResult.getAttendees());
            } else if (i == 8) {
                mo19237f(m8579k());
            }
        }
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8080a, false, 2587, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        CalendarParsedResult calendarParsedResult = (CalendarParsedResult) mo19232d();
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        String summary = calendarParsedResult.getSummary();
        if (m8630l(summary)) {
            ResultInfoItem mVar = new ResultInfoItem();
            mVar.mo19272a(mo19236f().getString(R.string.mz_calendar_summary));
            mVar.mo19277b(summary);
            arrayList.add(mVar);
        }
        Date start = calendarParsedResult.getStart();
        String a = m8577a(calendarParsedResult.isStartAllDay(), start);
        if (m8630l(a)) {
            ResultInfoItem mVar2 = new ResultInfoItem();
            mVar2.mo19272a(mo19236f().getString(R.string.mz_calendar_start));
            mVar2.mo19277b(a);
            arrayList.add(mVar2);
        }
        Date end = calendarParsedResult.getEnd();
        String a2 = m8577a(calendarParsedResult.isEndAllDay(), (end == null || !calendarParsedResult.isEndAllDay() || start.equals(end)) ? end : new Date(end.getTime() - 86400000));
        if (m8630l(a2)) {
            ResultInfoItem mVar3 = new ResultInfoItem();
            mVar3.mo19272a(mo19236f().getString(R.string.mz_calendar_end));
            mVar3.mo19277b(a2);
            arrayList.add(mVar3);
        }
        String location = calendarParsedResult.getLocation();
        if (m8630l(location)) {
            ResultInfoItem mVar4 = new ResultInfoItem();
            mVar4.mo19272a(mo19236f().getString(R.string.mz_calendar_location));
            mVar4.mo19277b(location);
            arrayList.add(mVar4);
        }
        String description = calendarParsedResult.getDescription();
        String organizer = calendarParsedResult.getOrganizer();
        if (organizer != null) {
            if (description == null) {
                description = organizer;
            } else {
                description = description + 10 + organizer;
            }
        }
        if (m8630l(description)) {
            ResultInfoItem mVar5 = new ResultInfoItem();
            mVar5.mo19272a(mo19236f().getString(R.string.mz_calendar_description));
            mVar5.mo19277b(description);
            arrayList.add(mVar5);
        }
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8080a, false, 2588, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        ResultInfoHeader lVar = new ResultInfoHeader();
        lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_calendar));
        lVar.mo19257a(mo19236f().getString(R.string.mz_calendar));
        lVar.mo19260b(mo19236f().getString(R.string.mz_calendar_title));
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8080a, false, 2589, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        ResultActionBarItem gVar = new ResultActionBarItem();
        int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
        MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.mz_barcode_save_calendar));
        Typeface create = Typeface.create("sans-serif-medium", 0);
        kVar.mo23384a(create);
        kVar.mo23383a(color);
        gVar.mo19212a((Drawable) kVar);
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 4, (String) null));
        arrayList.add(gVar);
        if (!((CameraActivity) mo19236f()).mo17636c()) {
            ResultActionBarItem gVar2 = new ResultActionBarItem();
            MzTextDrawable kVar2 = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.share));
            kVar2.mo23384a(create);
            kVar2.mo23383a(color);
            gVar2.mo19212a((Drawable) kVar2);
            gVar2.mo19213a((View.OnClickListener) new ResultButtonListener(this, 8, (String) null));
            arrayList.add(gVar2);
        }
        return arrayList;
    }
}
