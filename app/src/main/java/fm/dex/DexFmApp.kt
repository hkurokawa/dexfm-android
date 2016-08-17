package fm.dex

import android.app.Application

import fm.dex.di.AppComponent
import fm.dex.di.AppModule
import fm.dex.di.DaggerAppComponent

class DexFmApp : Application() {

    var component: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
