package org.apaches.commons.codec.language.p118bm;

import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apaches.commons.codec.language.p118bm.Languages;
import org.apaches.commons.codec.language.p118bm.Rule;

/* renamed from: org.apaches.commons.codec.language.bm.PhoneticEngine */
public class PhoneticEngine {
    private static /* synthetic */ int[] $SWITCH_TABLE$org$apaches$commons$codec$language$bm$NameType = null;
    private static final int DEFAULT_MAX_PHONEMES = 20;
    private static final Map<NameType, Set<String>> NAME_PREFIXES = new EnumMap(NameType.class);
    private final boolean concat;
    private final Lang lang;
    private final int maxPhonemes;
    private final NameType nameType;
    private final RuleType ruleType;

    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|6|7|8|9|10|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$org$apaches$commons$codec$language$bm$NameType() {
        /*
            int[] r0 = $SWITCH_TABLE$org$apaches$commons$codec$language$bm$NameType
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            org.apaches.commons.codec.language.bm.NameType[] r0 = org.apaches.commons.codec.language.p118bm.NameType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            org.apaches.commons.codec.language.bm.NameType r1 = org.apaches.commons.codec.language.p118bm.NameType.ASHKENAZI     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            org.apaches.commons.codec.language.bm.NameType r1 = org.apaches.commons.codec.language.p118bm.NameType.GENERIC     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            org.apaches.commons.codec.language.bm.NameType r1 = org.apaches.commons.codec.language.p118bm.NameType.SEPHARDIC     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            $SWITCH_TABLE$org$apaches$commons$codec$language$bm$NameType = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apaches.commons.codec.language.p118bm.PhoneticEngine.$SWITCH_TABLE$org$apaches$commons$codec$language$bm$NameType():int[]");
    }

    /* renamed from: org.apaches.commons.codec.language.bm.PhoneticEngine$PhonemeBuilder */
    static final class PhonemeBuilder {
        private final Set<Rule.Phoneme> phonemes;

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(new Rule.Phoneme((CharSequence) "", languageSet));
        }

        private PhonemeBuilder(Rule.Phoneme phoneme) {
            this.phonemes = new LinkedHashSet();
            this.phonemes.add(phoneme);
        }

        private PhonemeBuilder(Set<Rule.Phoneme> set) {
            this.phonemes = set;
        }

        /* synthetic */ PhonemeBuilder(Set set, PhonemeBuilder phonemeBuilder) {
            this((Set<Rule.Phoneme>) set);
        }

        public void append(CharSequence charSequence) {
            for (Rule.Phoneme append : this.phonemes) {
                append.append(charSequence);
            }
        }

        public void apply(Rule.PhonemeExpr phonemeExpr, int i) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(i);
            loop0:
            for (Rule.Phoneme next : this.phonemes) {
                Iterator<Rule.Phoneme> it = phonemeExpr.getPhonemes().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Rule.Phoneme next2 = it.next();
                        Languages.LanguageSet restrictTo = next.getLanguages().restrictTo(next2.getLanguages());
                        if (!restrictTo.isEmpty()) {
                            Rule.Phoneme phoneme = new Rule.Phoneme(next, next2, restrictTo);
                            if (linkedHashSet.size() < i) {
                                linkedHashSet.add(phoneme);
                                if (linkedHashSet.size() >= i) {
                                    break loop0;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
            this.phonemes.clear();
            this.phonemes.addAll(linkedHashSet);
        }

        public Set<Rule.Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            StringBuilder sb = new StringBuilder();
            for (Rule.Phoneme next : this.phonemes) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(next.getPhonemeText());
            }
            return sb.toString();
        }
    }

    /* renamed from: org.apaches.commons.codec.language.bm.PhoneticEngine$RulesApplication */
    private static final class RulesApplication {
        private final Map<String, List<Rule>> finalRules;
        private boolean found;

        /* renamed from: i */
        private int f19017i;
        private final CharSequence input;
        private final int maxPhonemes;
        private PhonemeBuilder phonemeBuilder;

        public RulesApplication(Map<String, List<Rule>> map, CharSequence charSequence, PhonemeBuilder phonemeBuilder2, int i, int i2) {
            if (map != null) {
                this.finalRules = map;
                this.phonemeBuilder = phonemeBuilder2;
                this.input = charSequence;
                this.f19017i = i;
                this.maxPhonemes = i2;
                return;
            }
            throw new NullPointerException("The finalRules argument must not be null");
        }

        public int getI() {
            return this.f19017i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i;
            this.found = false;
            List list = this.finalRules.get(this.input.subSequence(this.f19017i, this.f19017i + 1));
            if (list != null) {
                Iterator it = list.iterator();
                i = 1;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Rule rule = (Rule) it.next();
                    int length = rule.getPattern().length();
                    if (rule.patternAndContextMatches(this.input, this.f19017i)) {
                        this.phonemeBuilder.apply(rule.getPhoneme(), this.maxPhonemes);
                        this.found = true;
                        i = length;
                        break;
                    }
                    i = length;
                }
            } else {
                i = 1;
            }
            if (!this.found) {
                i = 1;
            }
            this.f19017i += i;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        NAME_PREFIXES.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"bar", "ben", "da", "de", "van", "von"}))));
        NAME_PREFIXES.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{Parameters.ALTITUDE, "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
        NAME_PREFIXES.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
    }

    private static String join(Iterable<String> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public PhoneticEngine(NameType nameType2, RuleType ruleType2, boolean z) {
        this(nameType2, ruleType2, z, 20);
    }

    public PhoneticEngine(NameType nameType2, RuleType ruleType2, boolean z, int i) {
        if (ruleType2 != RuleType.RULES) {
            this.nameType = nameType2;
            this.ruleType = ruleType2;
            this.concat = z;
            this.lang = Lang.instance(nameType2);
            this.maxPhonemes = i;
            return;
        }
        throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES);
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, Map<String, List<Rule>> map) {
        if (map == null) {
            throw new NullPointerException("finalRules can not be null");
        } else if (map.isEmpty()) {
            return phonemeBuilder;
        } else {
            TreeSet treeSet = new TreeSet(Rule.Phoneme.COMPARATOR);
            for (Rule.Phoneme next : phonemeBuilder.getPhonemes()) {
                PhonemeBuilder empty = PhonemeBuilder.empty(next.getLanguages());
                String charSequence = next.getPhonemeText().toString();
                PhonemeBuilder phonemeBuilder2 = empty;
                int i = 0;
                while (i < charSequence.length()) {
                    RulesApplication invoke = new RulesApplication(map, charSequence, phonemeBuilder2, i, this.maxPhonemes).invoke();
                    boolean isFound = invoke.isFound();
                    phonemeBuilder2 = invoke.getPhonemeBuilder();
                    if (!isFound) {
                        phonemeBuilder2.append(charSequence.subSequence(i, i + 1));
                    }
                    i = invoke.getI();
                }
                treeSet.addAll(phonemeBuilder2.getPhonemes());
            }
            return new PhonemeBuilder(treeSet, (PhonemeBuilder) null);
        }
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public String encode(String str, Languages.LanguageSet languageSet) {
        String str2;
        Map<String, List<Rule>> instanceMap = Rule.getInstanceMap(this.nameType, RuleType.RULES, languageSet);
        Map<String, List<Rule>> instanceMap2 = Rule.getInstanceMap(this.nameType, this.ruleType, "common");
        Map<String, List<Rule>> instanceMap3 = Rule.getInstanceMap(this.nameType, this.ruleType, languageSet);
        String trim = str.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
        if (this.nameType == NameType.GENERIC) {
            if (trim.length() < 2 || !trim.substring(0, 2).equals("d'")) {
                for (String str3 : NAME_PREFIXES.get(this.nameType)) {
                    if (trim.startsWith(String.valueOf(str3) + " ")) {
                        String substring = trim.substring(str3.length() + 1);
                        String str4 = String.valueOf(str3) + substring;
                        return "(" + encode(substring) + ")-(" + encode(str4) + ")";
                    }
                }
            } else {
                String substring2 = trim.substring(2);
                String str5 = "d" + substring2;
                return "(" + encode(substring2) + ")-(" + encode(str5) + ")";
            }
        }
        List<String> asList = Arrays.asList(trim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList<>();
        switch ($SWITCH_TABLE$org$apaches$commons$codec$language$bm$NameType()[this.nameType.ordinal()]) {
            case 1:
                arrayList.addAll(asList);
                arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
                break;
            case 2:
                arrayList.addAll(asList);
                break;
            case 3:
                for (String split : asList) {
                    String[] split2 = split.split("'");
                    arrayList.add(split2[split2.length - 1]);
                }
                arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
                break;
            default:
                throw new IllegalStateException("Unreachable case: " + this.nameType);
        }
        if (this.concat) {
            str2 = join(arrayList, " ");
        } else if (arrayList.size() == 1) {
            str2 = (String) asList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String encode : arrayList) {
                sb.append("-");
                sb.append(encode(encode));
            }
            return sb.substring(1);
        }
        PhonemeBuilder empty = PhonemeBuilder.empty(languageSet);
        int i = 0;
        while (i < str2.length()) {
            RulesApplication invoke = new RulesApplication(instanceMap, str2, empty, i, this.maxPhonemes).invoke();
            i = invoke.getI();
            empty = invoke.getPhonemeBuilder();
        }
        return applyFinalRules(applyFinalRules(empty, instanceMap2), instanceMap3).makeString();
    }

    public Lang getLang() {
        return this.lang;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }

    public int getMaxPhonemes() {
        return this.maxPhonemes;
    }
}
