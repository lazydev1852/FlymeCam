package org.apaches.commons.codec.language;

import java.util.Locale;
import org.apaches.commons.codec.EncoderException;
import org.apaches.commons.codec.StringEncoder;

public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    public String metaphone(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuilder sb = new StringBuilder(40);
        StringBuilder sb2 = new StringBuilder(10);
        int i = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c != 'G' && c != 'K' && c != 'P') {
                switch (c) {
                    case 'W':
                        if (charArray[1] != 'R') {
                            if (charArray[1] != 'H') {
                                sb.append(charArray);
                                break;
                            } else {
                                sb.append(charArray, 1, charArray.length - 1);
                                sb.setCharAt(0, 'W');
                                break;
                            }
                        } else {
                            sb.append(charArray, 1, charArray.length - 1);
                            break;
                        }
                    case 'X':
                        charArray[0] = 'S';
                        sb.append(charArray);
                        break;
                    default:
                        sb.append(charArray);
                        break;
                }
            } else if (charArray[1] == 'N') {
                sb.append(charArray, 1, charArray.length - 1);
            } else {
                sb.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            sb.append(charArray, 1, charArray.length - 1);
        } else {
            sb.append(charArray);
        }
        int length = sb.length();
        while (sb2.length() < getMaxCodeLen() && i < length) {
            char charAt = sb.charAt(i);
            if (charAt == 'C' || !isPreviousChar(sb, i, charAt)) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        if (i == 0) {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'B':
                        if (!isPreviousChar(sb, i, 'M') || !isLastChar(length, i)) {
                            sb2.append(charAt);
                            break;
                        }
                    case 'C':
                        if (!isPreviousChar(sb, i, 'S') || isLastChar(length, i) || FRONTV.indexOf(sb.charAt(i + 1)) < 0) {
                            if (!regionMatch(sb, i, "CIA")) {
                                if (isLastChar(length, i) || FRONTV.indexOf(sb.charAt(i + 1)) < 0) {
                                    if (!isPreviousChar(sb, i, 'S') || !isNextChar(sb, i, 'H')) {
                                        if (isNextChar(sb, i, 'H')) {
                                            if (i == 0 && length >= 3 && isVowel(sb, 2)) {
                                                sb2.append('K');
                                                break;
                                            } else {
                                                sb2.append('X');
                                                break;
                                            }
                                        } else {
                                            sb2.append('K');
                                            break;
                                        }
                                    } else {
                                        sb2.append('K');
                                        break;
                                    }
                                } else {
                                    sb2.append('S');
                                    break;
                                }
                            } else {
                                sb2.append('X');
                                break;
                            }
                        }
                        break;
                    case 'D':
                        if (!isLastChar(length, i + 1) && isNextChar(sb, i, 'G')) {
                            int i2 = i + 2;
                            if (FRONTV.indexOf(sb.charAt(i2)) >= 0) {
                                sb2.append('J');
                                i = i2;
                                break;
                            }
                        }
                        sb2.append('T');
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        sb2.append(charAt);
                        break;
                    case 'G':
                        int i3 = i + 1;
                        if ((!isLastChar(length, i3) || !isNextChar(sb, i, 'H')) && ((isLastChar(length, i3) || !isNextChar(sb, i, 'H') || isVowel(sb, i + 2)) && (i <= 0 || (!regionMatch(sb, i, "GN") && !regionMatch(sb, i, "GNED"))))) {
                            boolean isPreviousChar = isPreviousChar(sb, i, 'G');
                            if (!isLastChar(length, i) && FRONTV.indexOf(sb.charAt(i3)) >= 0 && !isPreviousChar) {
                                sb2.append('J');
                                break;
                            } else {
                                sb2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'H':
                        if (!isLastChar(length, i) && ((i <= 0 || VARSON.indexOf(sb.charAt(i - 1)) < 0) && isVowel(sb, i + 1))) {
                            sb2.append('H');
                            break;
                        }
                    case 'K':
                        if (i > 0) {
                            if (!isPreviousChar(sb, i, 'C')) {
                                sb2.append(charAt);
                                break;
                            }
                        } else {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'P':
                        if (!isNextChar(sb, i, 'H')) {
                            sb2.append(charAt);
                            break;
                        } else {
                            sb2.append('F');
                            break;
                        }
                    case 'Q':
                        sb2.append('K');
                        break;
                    case 'S':
                        if (!regionMatch(sb, i, "SH") && !regionMatch(sb, i, "SIO") && !regionMatch(sb, i, "SIA")) {
                            sb2.append('S');
                            break;
                        } else {
                            sb2.append('X');
                            break;
                        }
                        break;
                    case 'T':
                        if (!regionMatch(sb, i, "TIA") && !regionMatch(sb, i, "TIO")) {
                            if (!regionMatch(sb, i, "TCH")) {
                                if (!regionMatch(sb, i, "TH")) {
                                    sb2.append('T');
                                    break;
                                } else {
                                    sb2.append('0');
                                    break;
                                }
                            }
                        } else {
                            sb2.append('X');
                            break;
                        }
                        break;
                    case 'V':
                        sb2.append('F');
                        break;
                    case 'W':
                    case 'Y':
                        if (!isLastChar(length, i) && isVowel(sb, i + 1)) {
                            sb2.append(charAt);
                            break;
                        }
                    case 'X':
                        sb2.append('K');
                        sb2.append('S');
                        break;
                    case 'Z':
                        sb2.append('S');
                        break;
                }
                i++;
            } else {
                i++;
            }
            if (sb2.length() > getMaxCodeLen()) {
                sb2.setLength(getMaxCodeLen());
            }
        }
        return sb2.toString();
    }

    private boolean isVowel(StringBuilder sb, int i) {
        return VOWELS.indexOf(sb.charAt(i)) >= 0;
    }

    private boolean isPreviousChar(StringBuilder sb, int i, char c) {
        if (i <= 0 || i >= sb.length() || sb.charAt(i - 1) != c) {
            return false;
        }
        return true;
    }

    private boolean isNextChar(StringBuilder sb, int i, char c) {
        if (i < 0 || i >= sb.length() - 1 || sb.charAt(i + 1) != c) {
            return false;
        }
        return true;
    }

    private boolean regionMatch(StringBuilder sb, int i, String str) {
        if (i < 0 || (str.length() + i) - 1 >= sb.length()) {
            return false;
        }
        return sb.substring(i, str.length() + i).equals(str);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public String encode(String str) {
        return metaphone(str);
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }
}
