package com.meizu.media.mzfunnysnapsdk.AnimationNew;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.Constants;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSON {
    public static ChangeQuickRedirect changeQuickRedirect;
    private JSONArray jsArr;
    private JSONObject jsObj;
    private Object value;

    public JSON(Object obj) {
        obj = ArrayList.class.isInstance(obj) ? new JSONArray((ArrayList) obj) : obj;
        if (obj == null) {
            this.value = null;
        } else if (obj.toString().trim().startsWith("{")) {
            try {
                this.jsObj = new JSONObject(obj.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (obj.toString().trim().startsWith(Constants.ARRAY_TYPE)) {
            try {
                this.jsArr = new JSONArray(obj.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            this.value = obj;
        }
    }

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9017, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (isNull()) {
            return "";
        }
        return value().toString();
    }

    public int count() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9018, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.jsObj != null) {
            return this.jsObj.length();
        }
        if (this.jsArr != null) {
            return this.jsArr.length();
        }
        return 0;
    }

    public JSON key(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9019, new Class[]{String.class}, JSON.class);
        if (proxy.isSupported) {
            return (JSON) proxy.result;
        }
        if (this.jsObj == null) {
            return new JSON((Object) null);
        }
        try {
            Object obj = this.jsObj.get(str);
            if (obj != null) {
                return new JSON(obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSON((Object) null);
    }

    public JSON index(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect3, false, 9020, new Class[]{Integer.TYPE}, JSON.class);
        if (proxy.isSupported) {
            return (JSON) proxy.result;
        }
        if (this.jsArr == null) {
            return new JSON((Object) null);
        }
        try {
            return new JSON(this.jsArr.get(i));
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSON((Object) null);
        }
    }

    public String stringValue() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9021, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (value() != null && !isNull()) {
            return String.valueOf(value());
        }
        return "";
    }

    public int intValue() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9022, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (value() == null) {
            return 0;
        }
        try {
            return Integer.valueOf(value().toString()).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public long longValue() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9023, new Class[0], Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        if (value() == null) {
            return 0;
        }
        try {
            return Long.valueOf(value().toString()).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public Double doubleValue() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9024, new Class[0], Double.class);
        if (proxy.isSupported) {
            return (Double) proxy.result;
        }
        if (value() == null) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(value().toString());
        } catch (NumberFormatException unused) {
            return Double.valueOf(0.0d);
        }
    }

    public boolean booleanValue() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9025, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (value() == null) {
            return false;
        }
        return stringValue().equals("true");
    }

    public Object value() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9026, new Class[0], Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (nullableValue() != null) {
            return nullableValue();
        }
        return new JSON((Object) null);
    }

    public boolean isNull() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9027, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return (this.value == null && this.jsArr == null && this.jsObj == null) || String.valueOf(value()).equals("null");
    }

    private Object nullableValue() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9028, new Class[0], Object.class);
        if (proxy.isSupported) {
            return proxy.result;
        }
        if (this.value != null) {
            return this.value;
        }
        if (this.jsObj != null) {
            return this.jsObj.toString();
        }
        if (this.jsArr != null) {
            return this.jsArr.toString();
        }
        return null;
    }

    public boolean exist() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9029, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return nullableValue() != null;
    }

    public JSONObject getJsonObject() {
        return this.jsObj;
    }

    public JSONArray getJsonArray() {
        return this.jsArr;
    }

    public void removeWithKey(String str) {
        JSONObject jsonObject;
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9030, new Class[]{String.class}, Void.TYPE).isSupported && str != null && (jsonObject = getJsonObject()) != null) {
            jsonObject.remove(str);
            this.jsObj = jsonObject;
        }
    }

    public void addEditWithKey(String str, Object obj) {
        JSONObject jsonObject;
        Class[] clsArr = {String.class, Object.class};
        if (!PatchProxy.proxy(new Object[]{str, obj}, this, changeQuickRedirect, false, 9031, clsArr, Void.TYPE).isSupported && obj != null && str != null && (jsonObject = getJsonObject()) != null) {
            if (JSON.class.isInstance(obj)) {
                JSON json = (JSON) obj;
                if (json.getJsonArray() != null) {
                    obj = json.getJsonArray();
                } else if (json.getJsonObject() != null) {
                    obj = json.getJsonObject();
                } else {
                    obj = json.value();
                }
            }
            try {
                jsonObject.putOpt(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.jsObj = jsonObject;
        }
    }

    public void addWithIndex(Object obj, int i) {
        JSONArray jsonArray;
        if (!PatchProxy.proxy(new Object[]{obj, new Integer(i)}, this, changeQuickRedirect, false, 9032, new Class[]{Object.class, Integer.TYPE}, Void.TYPE).isSupported && obj != null && (jsonArray = getJsonArray()) != null) {
            try {
                if (JSON.class.isInstance(obj)) {
                    if (((JSON) obj).getJsonArray() != null) {
                        if (i == -1) {
                            jsonArray.put(((JSON) obj).getJsonArray());
                        } else {
                            jsonArray.put(i, ((JSON) obj).getJsonArray());
                        }
                    } else if (((JSON) obj).getJsonObject() != null) {
                        if (i == -1) {
                            jsonArray.put(((JSON) obj).getJsonObject());
                        } else {
                            jsonArray.put(i, ((JSON) obj).getJsonObject());
                        }
                    } else if (i == -1) {
                        jsonArray.put(((JSON) obj).value());
                    } else {
                        jsonArray.put(i, ((JSON) obj).value());
                    }
                } else if (i == -1) {
                    jsonArray.put(obj);
                } else if (i > -1) {
                    jsonArray.put(i, obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.jsArr = jsonArray;
        }
    }

    public void add(Object obj) {
        if (!PatchProxy.proxy(new Object[]{obj}, this, changeQuickRedirect, false, 9033, new Class[]{Object.class}, Void.TYPE).isSupported) {
            addWithIndex(obj, -1);
        }
    }

    public void removeWithIndex(int i) {
        JSONArray jsonArray;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 9034, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (jsonArray = getJsonArray()) != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                if (i2 != i) {
                    try {
                        jSONArray.put(jsonArray.get(i2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.jsArr = jSONArray;
        }
    }

    public void remove(Object obj) {
        JSONArray jsonArray;
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{obj}, this, changeQuickRedirect, false, 9035, new Class[]{Object.class}, Void.TYPE).isSupported && obj != null && (jsonArray = getJsonArray()) != null) {
            JSONArray jSONArray = new JSONArray();
            while (i < jsonArray.length()) {
                try {
                    if (!JSONObject.class.isInstance(obj) || !JSONObject.class.isInstance(jsonArray.get(i))) {
                        if (!jsonArray.get(i).equals(obj)) {
                            jSONArray.put(jsonArray.get(i));
                        }
                        i++;
                    } else {
                        if (!jsonObjectComparesEqual((JSONObject) jsonArray.get(i), (JSONObject) obj, (Collection<String>) null, (Collection<String>) null)) {
                            jSONArray.put(jsonArray.get(i));
                        }
                        i++;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.jsArr = jSONArray;
        }
    }

    public static JSON create(Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj}, (Object) null, changeQuickRedirect, true, 9036, new Class[]{Object.class}, JSON.class);
        return proxy.isSupported ? (JSON) proxy.result : new JSON(obj.toString());
    }

    public static JSONObject dic(Object... objArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{objArr}, (Object) null, changeQuickRedirect, true, 9037, new Class[]{Object[].class}, JSONObject.class);
        if (proxy.isSupported) {
            return (JSONObject) proxy.result;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < objArr.length; i += 2) {
            try {
                Object obj = objArr[i + 1];
                if (JSON.class.isInstance(obj)) {
                    if (((JSON) obj).getJsonArray() != null) {
                        obj = ((JSON) obj).getJsonArray();
                    } else if (((JSON) obj).getJsonObject() != null) {
                        obj = ((JSON) obj).getJsonObject();
                    }
                }
                String str = objArr[i];
                if (obj == null) {
                    obj = JSONObject.NULL;
                }
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONArray array(Object... objArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{objArr}, (Object) null, changeQuickRedirect, true, 9038, new Class[]{Object[].class}, JSONArray.class);
        if (proxy.isSupported) {
            return (JSONArray) proxy.result;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object put : objArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static boolean jsonObjectComparesEqual(JSONObject jSONObject, JSONObject jSONObject2, Collection<String> collection, Collection<String> collection2) {
        Object obj;
        Object obj2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{jSONObject, jSONObject2, collection, collection2}, (Object) null, changeQuickRedirect, true, 9039, new Class[]{JSONObject.class, JSONObject.class, Collection.class, Collection.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Set<String> keySet = keySet(jSONObject);
        keySet.addAll(keySet(jSONObject2));
        if (collection != null) {
            keySet.retainAll(collection);
        }
        if (collection2 != null) {
            keySet.removeAll(collection2);
        }
        for (String next : keySet) {
            try {
                obj = jSONObject.get(next);
            } catch (JSONException unused) {
                obj = null;
            }
            try {
                obj2 = jSONObject.get(next);
            } catch (JSONException unused2) {
                obj2 = null;
            }
            if (obj != null) {
                if (!obj.equals(obj2)) {
                    return false;
                }
            } else if (obj2 != null && !obj2.equals(obj)) {
                return false;
            }
        }
        return true;
    }

    private static Set<String> keySet(JSONObject jSONObject) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{jSONObject}, (Object) null, changeQuickRedirect, true, 9040, new Class[]{JSONObject.class}, Set.class);
        if (proxy.isSupported) {
            return (Set) proxy.result;
        }
        TreeSet treeSet = new TreeSet();
        Iterator it = new AsIterable(jSONObject.keys()).iterator();
        while (it.hasNext()) {
            treeSet.add((String) it.next());
        }
        return treeSet;
    }

    private static class AsIterable<T> implements Iterable<T> {
        public static ChangeQuickRedirect changeQuickRedirect;
        private Iterator<T> iterator;

        public AsIterable(Iterator<T> it) {
            this.iterator = it;
        }

        public Iterator<T> iterator() {
            return this.iterator;
        }
    }
}
