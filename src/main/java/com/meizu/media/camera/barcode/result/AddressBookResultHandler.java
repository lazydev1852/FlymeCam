package com.meizu.media.camera.barcode.result;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.meizu.media.camera.barcode.result.a */
public final class AddressBookResultHandler extends ResultHandler {

    /* renamed from: a */
    public static ChangeQuickRedirect f8078a;

    /* renamed from: f */
    private static final DateFormat[] f8079f = {new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH), new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)};

    static {
        for (DateFormat lenient : f8079f) {
            lenient.setLenient(false);
        }
    }

    public AddressBookResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
        this.f8114d = activity.getResources().getString(R.string.mz_barcode_auto_address_book_result_hint);
    }

    /* renamed from: a */
    public void mo19171a(int i, String str) {
        int i2 = i;
        String str2 = str;
        Object[] objArr = {new Integer(i2), str2};
        ChangeQuickRedirect changeQuickRedirect = f8078a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2577, new Class[]{Integer.TYPE, String.class}, Void.TYPE).isSupported) {
            AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) mo19232d();
            if (i2 == 5) {
                mo19231c(addressBookParsedResult.getURLs()[0]);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        mo19221a(str2);
                        return;
                    case 2:
                        mo19224a(str2, (String) null, (String) null);
                        return;
                    case 3:
                        String[] addresses = addressBookParsedResult.getAddresses();
                        String[] addressTypes = addressBookParsedResult.getAddressTypes();
                        mo19227a(addressBookParsedResult.getNames(), addressBookParsedResult.getNicknames(), addressBookParsedResult.getPronunciation(), addressBookParsedResult.getPhoneNumbers(), addressBookParsedResult.getPhoneTypes(), addressBookParsedResult.getEmails(), addressBookParsedResult.getEmailTypes(), addressBookParsedResult.getNote(), addressBookParsedResult.getInstantMessenger(), addresses, addressTypes, addressBookParsedResult.getOrg(), addressBookParsedResult.getTitle(), addressBookParsedResult.getURLs(), addressBookParsedResult.getBirthday(), addressBookParsedResult.getGeo());
                        return;
                    default:
                        return;
                }
            } else {
                mo19237f(m8571k());
            }
        }
    }

    /* renamed from: p */
    private static Date m8572p(String str) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f8078a, true, 2578, new Class[]{String.class}, Date.class);
        if (proxy.isSupported) {
            return (Date) proxy.result;
        }
        DateFormat[] dateFormatArr = f8079f;
        while (i < dateFormatArr.length) {
            try {
                return dateFormatArr[i].parse(str);
            } catch (ParseException unused) {
                i++;
            }
        }
        return null;
    }

    /* renamed from: k */
    private String m8571k() {
        Date p;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8078a, false, 2579, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) mo19232d();
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(addressBookParsedResult.getNames(), sb);
        int length = sb.length();
        String pronunciation = addressBookParsedResult.getPronunciation();
        if (pronunciation != null && !pronunciation.isEmpty()) {
            sb.append("\n(");
            sb.append(pronunciation);
            sb.append(')');
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getTitle(), sb);
        ParsedResult.maybeAppend(addressBookParsedResult.getOrg(), sb);
        ParsedResult.maybeAppend(addressBookParsedResult.getAddresses(), sb);
        String[] phoneNumbers = addressBookParsedResult.getPhoneNumbers();
        if (phoneNumbers != null) {
            for (String str : phoneNumbers) {
                if (str != null) {
                    ParsedResult.maybeAppend(PhoneNumberUtils.formatNumber(str), sb);
                }
            }
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getEmails(), sb);
        ParsedResult.maybeAppend(addressBookParsedResult.getURLs(), sb);
        String birthday = addressBookParsedResult.getBirthday();
        if (!(birthday == null || birthday.isEmpty() || (p = m8572p(birthday)) == null)) {
            ParsedResult.maybeAppend(DateFormat.getDateInstance(2).format(Long.valueOf(p.getTime())), sb);
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getNote(), sb);
        if (length <= 0) {
            return sb.toString();
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new StyleSpan(1), 0, length, 0);
        return spannableString.toString();
    }

    /* renamed from: a */
    public ArrayList<ResultInfoItem> mo19170a() {
        String str;
        String str2;
        String str3;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8078a, false, 2580, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) mo19232d();
        ArrayList<ResultInfoItem> arrayList = new ArrayList<>();
        String title = addressBookParsedResult.getTitle();
        if (m8630l(title)) {
            ResultInfoItem mVar = new ResultInfoItem();
            mVar.mo19272a(mo19236f().getString(R.string.mz_address_info_title));
            mVar.mo19277b(title);
            arrayList.add(mVar);
        }
        String[] phoneNumbers = addressBookParsedResult.getPhoneNumbers();
        if (phoneNumbers != null) {
            String[] phoneTypes = addressBookParsedResult.getPhoneTypes();
            for (int i = 0; i < phoneNumbers.length; i++) {
                ResultInfoItem mVar2 = new ResultInfoItem();
                mVar2.mo19277b(phoneNumbers[i]);
                if (phoneTypes == null || !m8630l(phoneTypes[i])) {
                    str3 = mo19236f().getString(R.string.mz_address_info_phone);
                } else {
                    str3 = phoneTypes[i];
                }
                mVar2.mo19272a(str3);
                mVar2.mo19270a((View.OnClickListener) new ResultButtonListener(this, 1, phoneNumbers[i]));
                arrayList.add(mVar2);
            }
        }
        String[] emails = addressBookParsedResult.getEmails();
        if (emails != null) {
            String[] emailTypes = addressBookParsedResult.getEmailTypes();
            for (int i2 = 0; i2 < emails.length; i2++) {
                ResultInfoItem mVar3 = new ResultInfoItem();
                mVar3.mo19277b(emails[i2]);
                if (emailTypes == null || !m8630l(emailTypes[i2])) {
                    str2 = mo19236f().getString(R.string.mz_address_info_mail);
                } else {
                    str2 = emailTypes[i2];
                }
                mVar3.mo19272a(str2);
                mVar3.mo19270a((View.OnClickListener) new ResultButtonListener(this, 2, emails[i2]));
                arrayList.add(mVar3);
            }
        }
        String[] addresses = addressBookParsedResult.getAddresses();
        if (addresses != null) {
            String[] addressTypes = addressBookParsedResult.getAddressTypes();
            for (int i3 = 0; i3 < addresses.length; i3++) {
                ResultInfoItem mVar4 = new ResultInfoItem();
                mVar4.mo19277b(addresses[i3]);
                if (addressTypes == null || !m8630l(addressTypes[i3])) {
                    str = mo19236f().getString(R.string.mz_address_info_addr);
                } else {
                    str = addressTypes[i3];
                }
                mVar4.mo19272a(str);
                arrayList.add(mVar4);
            }
        }
        String[] uRLs = addressBookParsedResult.getURLs();
        if (uRLs != null) {
            for (String b : uRLs) {
                ResultInfoItem mVar5 = new ResultInfoItem();
                mVar5.mo19277b(b);
                mVar5.mo19272a(mo19236f().getString(R.string.mz_address_info_url));
                mVar5.mo19270a((View.OnClickListener) new ResultButtonListener(this, 5, (String) null));
                arrayList.add(mVar5);
            }
        }
        String birthday = addressBookParsedResult.getBirthday();
        if (m8630l(birthday)) {
            ResultInfoItem mVar6 = new ResultInfoItem();
            mVar6.mo19272a(mo19236f().getString(R.string.mz_address_info_birthday));
            mVar6.mo19277b(birthday);
            arrayList.add(mVar6);
        }
        String note = addressBookParsedResult.getNote();
        if (m8630l(note)) {
            ResultInfoItem mVar7 = new ResultInfoItem();
            mVar7.mo19272a(mo19236f().getString(R.string.mz_address_info_note));
            mVar7.mo19277b(note);
            arrayList.add(mVar7);
        }
        return arrayList;
    }

    /* renamed from: b */
    public ResultInfoHeader mo19174b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8078a, false, 2581, new Class[0], ResultInfoHeader.class);
        if (proxy.isSupported) {
            return (ResultInfoHeader) proxy.result;
        }
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) mo19232d();
        ResultInfoHeader lVar = new ResultInfoHeader();
        lVar.mo19256a(mo19236f().getResources().getDrawable(R.drawable.mz_barcode_contact));
        String[] names = addressBookParsedResult.getNames();
        if (names != null) {
            StringBuilder sb = new StringBuilder();
            for (String append : names) {
                sb.append(append);
                sb.append(" ");
            }
            lVar.mo19257a(sb.toString());
        }
        String org2 = addressBookParsedResult.getOrg();
        if (org2 != null) {
            lVar.mo19260b(org2);
        }
        return lVar;
    }

    /* renamed from: c */
    public ArrayList<ResultActionBarItem> mo19175c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8078a, false, 2582, new Class[0], ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<ResultActionBarItem> arrayList = new ArrayList<>();
        ResultActionBarItem gVar = new ResultActionBarItem();
        int color = mo19236f().getResources().getColor(R.color.mz_barcode_result_button_text);
        MzTextDrawable kVar = new MzTextDrawable(mo19236f().getApplicationContext(), mo19236f().getResources().getString(R.string.mz_barcode_save_contact));
        Typeface create = Typeface.create("sans-serif-medium", 0);
        kVar.mo23384a(create);
        kVar.mo23383a(color);
        gVar.mo19212a((Drawable) kVar);
        gVar.mo19213a((View.OnClickListener) new ResultButtonListener(this, 3, (String) null));
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
