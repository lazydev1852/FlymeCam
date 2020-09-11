package mediatek.app;

import android.app.ContextImpl;
import android.app.SystemServiceRegistry;
import android.util.Log;
import com.mediatek.search.SearchEngineManager;
import java.util.HashMap;

public final class MtkSystemServiceRegistry {
    private static final String TAG = "MtkSystemServiceRegistry";
    private static HashMap<String, SystemServiceRegistry.ServiceFetcher<?>> sSystemServiceFetchers;
    private static HashMap<Class<?>, String> sSystemServiceNames;

    private MtkSystemServiceRegistry() {
    }

    public static void registerAllService() {
        Log.i(TAG, "registerAllService start");
        registerService(SearchEngineManager.SEARCH_ENGINE_SERVICE, SearchEngineManager.class, new SystemServiceRegistry.CachedServiceFetcher<SearchEngineManager>() {
            public SearchEngineManager createService(ContextImpl contextImpl) {
                return new SearchEngineManager(contextImpl);
            }
        });
    }

    public static void setMtkSystemServiceName(HashMap<Class<?>, String> hashMap, HashMap<String, SystemServiceRegistry.ServiceFetcher<?>> hashMap2) {
        Log.i(TAG, "setMtkSystemServiceName start names" + hashMap + ",fetchers" + hashMap2);
        sSystemServiceNames = hashMap;
        sSystemServiceFetchers = hashMap2;
    }

    private static <T> void registerService(String str, Class<T> cls, SystemServiceRegistry.ServiceFetcher<T> serviceFetcher) {
        sSystemServiceNames.put(cls, str);
        sSystemServiceFetchers.put(str, serviceFetcher);
    }
}
