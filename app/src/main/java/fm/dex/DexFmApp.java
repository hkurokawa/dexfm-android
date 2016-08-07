package fm.dex;

import android.app.Application;
import android.support.annotation.NonNull;

import fm.dex.di.AppComponent;
import fm.dex.di.AppModule;
import fm.dex.di.DaggerAppComponent;

public final class DexFmApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getComponent() {
        return appComponent;
    }
}
