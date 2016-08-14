package fm.dex.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fm.dex.model.api.ApiService;
import fm.dex.model.entity.ChannelDao;
import fm.dex.model.entity.DaoMaster;
import fm.dex.model.entity.DaoSession;
import fm.dex.model.entity.ItemDao;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static fm.dex.model.api.ApiService.BASE_URL;

/**
 * Manages singleton instances.
 */
@Module
public final class AppModule {

    private static final String DB_NAME = "dexfm.db";

    private final Context context;

    public AppModule(Application application) {
        context = application.getApplicationContext();
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    OkHttpClient provideHttpClient() {
        OkHttpClient.Builder c = new OkHttpClient.Builder();
        return c.build();
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaAdapter() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    MoshiConverterFactory provideMoshiAdapter() {
        return MoshiConverterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, RxJavaCallAdapterFactory adapterFactory, MoshiConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    DaoSession provideDaoSession(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        return new DaoMaster(helper.getWritableDb()).newSession();
    }

    @Singleton
    @Provides
    ChannelDao provideChannelDao(DaoSession daoSession) {
        return daoSession.getChannelDao();
    }

    @Singleton
    @Provides
    ItemDao provideItemDao(DaoSession daoSession) {
        return daoSession.getItemDao();
    }
}
