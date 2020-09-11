package com.meizu.cloud.pushsdk.pushtracer.emitter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.cloud.pushsdk.networking.http.Call;
import com.meizu.cloud.pushsdk.networking.http.HttpURLConnectionCall;
import com.meizu.cloud.pushsdk.networking.http.MediaType;
import com.meizu.cloud.pushsdk.networking.http.Request;
import com.meizu.cloud.pushsdk.networking.http.RequestBody;
import com.meizu.cloud.pushsdk.networking.http.Response;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import com.meizu.cloud.pushsdk.pushtracer.constant.TrackerConstants;
import com.meizu.cloud.pushsdk.pushtracer.dataload.DataLoad;
import com.meizu.cloud.pushsdk.pushtracer.dataload.SelfDescribingJson;
import com.meizu.cloud.pushsdk.pushtracer.storage.Store;
import com.meizu.cloud.pushsdk.pushtracer.utils.Logger;
import com.meizu.cloud.pushsdk.pushtracer.utils.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public abstract class Emitter {
    protected final MediaType JSON = MediaType.parse(TrackerConstants.POST_CONTENT_TYPE);
    protected int POST_STM_BYTES = 22;
    protected int POST_WRAPPER_BYTES = 88;
    private final String TAG = Emitter.class.getSimpleName();
    protected BufferOption bufferOption;
    protected long byteLimitGet;
    protected long byteLimitPost;
    protected Call call;
    protected Context context;
    protected int emitterTick;
    protected int emptyLimit;
    protected HostnameVerifier hostnameVerifier;
    protected HttpMethod httpMethod;
    /* access modifiers changed from: protected */
    public AtomicBoolean isRunning = new AtomicBoolean(false);
    protected RequestCallback requestCallback;
    protected RequestSecurity requestSecurity;
    protected int sendLimit;
    protected SSLSocketFactory sslSocketFactory;
    protected TimeUnit timeUnit;
    protected String uri;
    protected Uri.Builder uriBuilder;

    public abstract void add(DataLoad dataLoad);

    public abstract void add(DataLoad dataLoad, boolean z);

    public abstract void flush();

    public abstract boolean getEmitterStatus();

    public abstract Store getEventStore();

    /* access modifiers changed from: protected */
    public boolean isSuccessfulSend(int i) {
        return i >= 200 && i < 300;
    }

    public abstract void shutdown();

    public static class EmitterBuilder {
        protected static Class<? extends Emitter> defaultEmitterClass;
        protected BufferOption bufferOption;
        protected long byteLimitGet;
        protected long byteLimitPost;
        protected Call call;
        protected final Context context;
        private Class<? extends Emitter> emitterClass;
        protected int emitterTick;
        protected int emptyLimit;
        protected HostnameVerifier hostnameVerifier;
        protected HttpMethod httpMethod;
        protected RequestCallback requestCallback;
        protected RequestSecurity requestSecurity;
        protected int sendLimit;
        protected SSLSocketFactory sslSocketFactory;
        protected TimeUnit timeUnit;
        protected final String uri;

        public EmitterBuilder(String str, Context context2) {
            this(str, context2, defaultEmitterClass);
        }

        public EmitterBuilder(String str, Context context2, Class<? extends Emitter> cls) {
            this.requestCallback = null;
            this.httpMethod = HttpMethod.POST;
            this.bufferOption = BufferOption.Single;
            this.requestSecurity = RequestSecurity.HTTPS;
            this.emitterTick = 5;
            this.sendLimit = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            this.emptyLimit = 5;
            this.byteLimitGet = 40000;
            this.byteLimitPost = 40000;
            this.timeUnit = TimeUnit.SECONDS;
            this.call = new HttpURLConnectionCall();
            this.uri = str;
            this.context = context2;
            this.emitterClass = cls;
        }

        public EmitterBuilder method(HttpMethod httpMethod2) {
            this.httpMethod = httpMethod2;
            return this;
        }

        public EmitterBuilder option(BufferOption bufferOption2) {
            this.bufferOption = bufferOption2;
            return this;
        }

        public EmitterBuilder security(RequestSecurity requestSecurity2) {
            this.requestSecurity = requestSecurity2;
            return this;
        }

        public EmitterBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public EmitterBuilder hostnameVerifier(HostnameVerifier hostnameVerifier2) {
            this.hostnameVerifier = hostnameVerifier2;
            return this;
        }

        public EmitterBuilder callback(RequestCallback requestCallback2) {
            this.requestCallback = requestCallback2;
            return this;
        }

        public EmitterBuilder tick(int i) {
            this.emitterTick = i;
            return this;
        }

        public EmitterBuilder sendLimit(int i) {
            this.sendLimit = i;
            return this;
        }

        public EmitterBuilder emptyLimit(int i) {
            this.emptyLimit = i;
            return this;
        }

        public EmitterBuilder byteLimitGet(long j) {
            this.byteLimitGet = j;
            return this;
        }

        public EmitterBuilder byteLimitPost(long j) {
            this.byteLimitPost = j;
            return this;
        }

        public EmitterBuilder timeUnit(TimeUnit timeUnit2) {
            this.timeUnit = timeUnit2;
            return this;
        }

        public EmitterBuilder call(Call call2) {
            if (call2 != null) {
                this.call = call2;
                String simpleName = EmitterBuilder.class.getSimpleName();
                Logger.m4856i(simpleName, "set new call " + call2, new Object[0]);
            }
            return this;
        }

        public EmitterBuilder call(Class<Call> cls) {
            try {
                this.call = cls.newInstance();
                String simpleName = EmitterBuilder.class.getSimpleName();
                Logger.m4856i(simpleName, "set new call " + this.call, new Object[0]);
            } catch (Exception e) {
                String simpleName2 = EmitterBuilder.class.getSimpleName();
                Logger.m4856i(simpleName2, "error new call " + e, new Object[0]);
            }
            return this;
        }
    }

    public Emitter(EmitterBuilder emitterBuilder) {
        this.httpMethod = emitterBuilder.httpMethod;
        this.requestCallback = emitterBuilder.requestCallback;
        this.context = emitterBuilder.context;
        this.bufferOption = emitterBuilder.bufferOption;
        this.requestSecurity = emitterBuilder.requestSecurity;
        this.sslSocketFactory = emitterBuilder.sslSocketFactory;
        this.hostnameVerifier = emitterBuilder.hostnameVerifier;
        this.emitterTick = emitterBuilder.emitterTick;
        this.emptyLimit = emitterBuilder.emptyLimit;
        this.sendLimit = emitterBuilder.sendLimit;
        this.byteLimitGet = emitterBuilder.byteLimitGet;
        this.byteLimitPost = emitterBuilder.byteLimitPost;
        this.uri = emitterBuilder.uri;
        this.timeUnit = emitterBuilder.timeUnit;
        this.call = emitterBuilder.call;
        buildEmitterUri();
        Logger.m4856i(this.TAG, "Emitter created successfully!", new Object[0]);
    }

    private void buildEmitterUri() {
        String str = this.TAG;
        Logger.m4855e(str, "security " + this.requestSecurity, new Object[0]);
        if (this.requestSecurity == RequestSecurity.HTTP) {
            this.uriBuilder = Uri.parse("http://" + this.uri).buildUpon();
        } else {
            this.uriBuilder = Uri.parse("https://" + this.uri).buildUpon();
        }
        if (this.httpMethod == HttpMethod.GET) {
            this.uriBuilder.appendPath("i");
        } else {
            this.uriBuilder.appendEncodedPath("push_data_report/mobile");
        }
    }

    private void buildHttpsSecurity() {
        if (this.requestSecurity == RequestSecurity.HTTPS) {
            if (this.sslSocketFactory == null) {
                Logger.m4855e(this.TAG, "Https Ensure you have set SSLSocketFactory", new Object[0]);
            }
            if (this.hostnameVerifier == null) {
                Logger.m4855e(this.TAG, "Https Ensure you have set HostnameVerifier", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public LinkedList<RequestResult> performSyncEmit(LinkedList<ReadyRequest> linkedList) {
        LinkedList<RequestResult> linkedList2 = new LinkedList<>();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ReadyRequest readyRequest = (ReadyRequest) it.next();
            int requestSender = requestSender(readyRequest.getRequest());
            if (readyRequest.isOversize()) {
                linkedList2.add(new RequestResult(true, readyRequest.getEventIds()));
            } else {
                linkedList2.add(new RequestResult(isSuccessfulSend(requestSender), readyRequest.getEventIds()));
            }
        }
        return linkedList2;
    }

    /* access modifiers changed from: protected */
    public int requestSender(Request request) {
        Response response = null;
        try {
            Logger.m4854d(this.TAG, "Sending request: %s", request);
            Response execute = this.call.execute(request);
            try {
                int code = execute.code();
                close(execute);
                return code;
            } catch (IOException e) {
                IOException iOException = e;
                response = execute;
                e = iOException;
                try {
                    Logger.m4855e(this.TAG, "Request sending failed: %s", Log.getStackTraceString(e));
                    close(response);
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    close(response);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                response = execute;
                close(response);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            Logger.m4855e(this.TAG, "Request sending failed: %s", Log.getStackTraceString(e));
            close(response);
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public void close(Response response) {
        if (response != null) {
            try {
                if (response.body() != null) {
                    response.body().close();
                }
            } catch (Exception unused) {
                Logger.m4854d(this.TAG, "Unable to close source data", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public LinkedList<ReadyRequest> buildRequests(EmittableEvents emittableEvents) {
        int size = emittableEvents.getEvents().size();
        LinkedList<Long> eventIds = emittableEvents.getEventIds();
        LinkedList<ReadyRequest> linkedList = new LinkedList<>();
        if (this.httpMethod == HttpMethod.GET) {
            for (int i = 0; i < size; i++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(eventIds.get(i));
                DataLoad dataLoad = emittableEvents.getEvents().get(i);
                linkedList.add(new ReadyRequest(dataLoad.getByteSize() + ((long) this.POST_STM_BYTES) > this.byteLimitGet, requestBuilderGet(dataLoad), linkedList2));
            }
        } else {
            for (int i2 = 0; i2 < size; i2 += this.bufferOption.getCode()) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList arrayList = new ArrayList();
                long j = 0;
                LinkedList linkedList4 = linkedList3;
                int i3 = i2;
                while (i3 < this.bufferOption.getCode() + i2 && i3 < size) {
                    DataLoad dataLoad2 = emittableEvents.getEvents().get(i3);
                    ArrayList arrayList2 = arrayList;
                    long byteSize = dataLoad2.getByteSize() + ((long) this.POST_STM_BYTES);
                    LinkedList linkedList5 = linkedList4;
                    long j2 = j;
                    if (((long) this.POST_WRAPPER_BYTES) + byteSize > this.byteLimitPost) {
                        ArrayList arrayList3 = new ArrayList();
                        LinkedList linkedList6 = new LinkedList();
                        arrayList3.add(dataLoad2);
                        linkedList6.add(eventIds.get(i3));
                        linkedList.add(new ReadyRequest(true, requestBuilderPost(arrayList3), linkedList6));
                        arrayList = arrayList2;
                        linkedList4 = linkedList5;
                        j = j2;
                    } else {
                        long j3 = j2 + byteSize;
                        long j4 = j3;
                        if (((long) this.POST_WRAPPER_BYTES) + j3 + ((long) (arrayList2.size() - 1)) > this.byteLimitPost) {
                            linkedList.add(new ReadyRequest(false, requestBuilderPost(arrayList2), linkedList5));
                            ArrayList arrayList4 = new ArrayList();
                            LinkedList linkedList7 = new LinkedList();
                            arrayList4.add(dataLoad2);
                            linkedList7.add(eventIds.get(i3));
                            linkedList4 = linkedList7;
                            j = byteSize;
                            arrayList = arrayList4;
                        } else {
                            arrayList = arrayList2;
                            linkedList4 = linkedList5;
                            arrayList.add(dataLoad2);
                            linkedList4.add(eventIds.get(i3));
                            j = j4;
                        }
                    }
                    i3++;
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new ReadyRequest(false, requestBuilderPost(arrayList), linkedList4));
                }
            }
        }
        return linkedList;
    }

    private Request requestBuilderGet(DataLoad dataLoad) {
        addStmToEvent(dataLoad, "");
        this.uriBuilder.clearQuery();
        HashMap hashMap = (HashMap) dataLoad.getMap();
        for (String str : hashMap.keySet()) {
            this.uriBuilder.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new Request.Builder().url(this.uriBuilder.build().toString()).get().build();
    }

    private Request requestBuilderPost(ArrayList<DataLoad> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<DataLoad> it = arrayList.iterator();
        while (it.hasNext()) {
            DataLoad next = it.next();
            stringBuffer.append(next.toString());
            arrayList2.add(next.getMap());
        }
        SelfDescribingJson selfDescribingJson = new SelfDescribingJson("push_group_data", (Object) arrayList2);
        String str = this.TAG;
        Logger.m4854d(str, "final SelfDescribingJson " + selfDescribingJson, new Object[0]);
        String uri2 = this.uriBuilder.build().toString();
        return new Request.Builder().url(uri2).post(RequestBody.create(this.JSON, selfDescribingJson.toString())).build();
    }

    private void addStmToEvent(DataLoad dataLoad, String str) {
        if (str.equals("")) {
            str = Util.getTimestamp();
        }
        dataLoad.add(Parameters.SENT_TIMESTAMP, str);
    }

    public void setBufferOption(BufferOption bufferOption2) {
        if (!this.isRunning.get()) {
            this.bufferOption = bufferOption2;
        }
    }

    public void setHttpMethod(HttpMethod httpMethod2) {
        if (!this.isRunning.get()) {
            this.httpMethod = httpMethod2;
            buildEmitterUri();
        }
    }

    public void setRequestSecurity(RequestSecurity requestSecurity2) {
        if (!this.isRunning.get()) {
            this.requestSecurity = requestSecurity2;
            buildEmitterUri();
        }
    }

    public void setEmitterUri(String str) {
        if (!this.isRunning.get()) {
            this.uri = str;
            buildEmitterUri();
        }
    }

    public String getEmitterUri() {
        return this.uriBuilder.clearQuery().build().toString();
    }

    public RequestCallback getRequestCallback() {
        return this.requestCallback;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public BufferOption getBufferOption() {
        return this.bufferOption;
    }

    public RequestSecurity getRequestSecurity() {
        return this.requestSecurity;
    }

    public int getEmitterTick() {
        return this.emitterTick;
    }

    public int getEmptyLimit() {
        return this.emptyLimit;
    }

    public int getSendLimit() {
        return this.sendLimit;
    }

    public long getByteLimitGet() {
        return this.byteLimitGet;
    }

    public long getByteLimitPost() {
        return this.byteLimitPost;
    }
}
