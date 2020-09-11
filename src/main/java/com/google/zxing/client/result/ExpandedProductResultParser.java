package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;

public final class ExpandedProductResultParser extends ResultParser {
    public ExpandedProductParsedResult parse(Result result) {
        ExpandedProductParsedResult expandedProductParsedResult = null;
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = getMassagedText(result);
        HashMap hashMap = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        int i = 0;
        while (i < massagedText.length()) {
            String findAIvalue = findAIvalue(i, massagedText);
            if (findAIvalue == null) {
                return expandedProductParsedResult;
            }
            int length = i + findAIvalue.length() + 2;
            String findValue = findValue(length, massagedText);
            int length2 = length + findValue.length();
            if (findAIvalue.equals("00")) {
                str2 = findValue;
            } else if (findAIvalue.equals("01")) {
                str = findValue;
            } else if (findAIvalue.equals("10")) {
                str3 = findValue;
            } else if (findAIvalue.equals("11")) {
                str4 = findValue;
            } else if (findAIvalue.equals("13")) {
                str5 = findValue;
            } else if (findAIvalue.equals("15")) {
                str6 = findValue;
            } else if (findAIvalue.equals("17")) {
                str7 = findValue;
            } else {
                String str14 = massagedText;
                if (findAIvalue.equals("3100") || findAIvalue.equals("3101") || findAIvalue.equals("3102") || findAIvalue.equals("3103") || findAIvalue.equals("3104") || findAIvalue.equals("3105") || findAIvalue.equals("3106") || findAIvalue.equals("3107") || findAIvalue.equals("3108") || findAIvalue.equals("3109")) {
                    str9 = ExpandedProductParsedResult.KILOGRAM;
                    str10 = findAIvalue.substring(3);
                } else if (findAIvalue.equals("3200") || findAIvalue.equals("3201") || findAIvalue.equals("3202") || findAIvalue.equals("3203") || findAIvalue.equals("3204") || findAIvalue.equals("3205") || findAIvalue.equals("3206") || findAIvalue.equals("3207") || findAIvalue.equals("3208") || findAIvalue.equals("3209")) {
                    str9 = ExpandedProductParsedResult.POUND;
                    str10 = findAIvalue.substring(3);
                } else if (findAIvalue.equals("3920") || findAIvalue.equals("3921") || findAIvalue.equals("3922") || findAIvalue.equals("3923")) {
                    str12 = findAIvalue.substring(3);
                    str11 = findValue;
                    i = length2;
                    massagedText = str14;
                    expandedProductParsedResult = null;
                } else if (!findAIvalue.equals("3930") && !findAIvalue.equals("3931") && !findAIvalue.equals("3932") && !findAIvalue.equals("3933")) {
                    hashMap.put(findAIvalue, findValue);
                    i = length2;
                    massagedText = str14;
                    expandedProductParsedResult = null;
                } else if (findValue.length() < 4) {
                    return null;
                } else {
                    str11 = findValue.substring(3);
                    str13 = findValue.substring(0, 3);
                    str12 = findAIvalue.substring(3);
                    i = length2;
                    massagedText = str14;
                    expandedProductParsedResult = null;
                }
                str8 = findValue;
                i = length2;
                massagedText = str14;
                expandedProductParsedResult = null;
            }
            i = length2;
            expandedProductParsedResult = null;
        }
        return new ExpandedProductParsedResult(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
    }

    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String substring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (findAIvalue(i2, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
