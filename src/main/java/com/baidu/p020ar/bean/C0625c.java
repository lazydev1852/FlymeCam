package com.baidu.p020ar.bean;

import java.util.Map;

/* renamed from: com.baidu.ar.bean.c */
public class C0625c {

    /* renamed from: a */
    private Map<String, C0626a> f1141a;

    /* renamed from: com.baidu.ar.bean.c$a */
    public static class C0626a {

        /* renamed from: a */
        private String f1142a;

        /* renamed from: b */
        private String f1143b;

        /* renamed from: c */
        private String f1144c;

        /* renamed from: d */
        private String f1145d;

        /* renamed from: a */
        public String mo9703a() {
            return this.f1142a;
        }

        /* renamed from: a */
        public void mo9704a(String str) {
            this.f1142a = str;
        }

        /* renamed from: b */
        public String mo9705b() {
            return this.f1143b;
        }

        /* renamed from: b */
        public void mo9706b(String str) {
            this.f1143b = str;
        }

        /* renamed from: c */
        public String mo9707c() {
            return this.f1144c;
        }

        /* renamed from: c */
        public void mo9708c(String str) {
            this.f1144c = str;
        }

        /* renamed from: d */
        public void mo9709d(String str) {
            this.f1145d = str;
        }
    }

    /* renamed from: a */
    public C0626a mo9701a(String str) {
        return this.f1141a.get(str);
    }

    /* renamed from: a */
    public void mo9702a(Map<String, C0626a> map) {
        this.f1141a = map;
    }
}
