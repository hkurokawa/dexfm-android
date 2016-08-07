package fm.dex.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public final class AppModule {

    private final Context context;

    public AppModule(Application application) {
        context = application.getApplicationContext();
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public OkHttpClient provideHttpClient(Context context) {
//        File cacheDir = new File(context.getCacheDir(), CACHE_FILE_NAME);
//        Cache cache = new Cache(cacheDir, MAX_CACHE_SIZE);
        OkHttpClient.Builder c = new OkHttpClient.Builder();
        return c.build();
    }

}
