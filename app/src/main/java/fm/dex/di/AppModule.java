package fm.dex.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

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

}
