package fm.dex.model.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import fm.dex.model.entity.Response;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import rx.Observable;

@Singleton
public final class ApiClient {

    private static final String BASE_URL = "https://raw.githubusercontent.com";

    private final ApiService service;

    @Inject
    public ApiClient(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }

    public Observable<Response> getFeeds() {
        return service.getFeeds();
    }

}
