package fm.dex.di

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import fm.dex.model.BASE_URL
import fm.dex.model.api.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Manages singleton instances.
 */
@Module
class AppModule(application: Application) {

    val context: Context

    init {
        context = application.applicationContext
    }

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val c = OkHttpClient.Builder()
        return c.build()
    }

    @Singleton
    @Provides
    fun provideRxJavaAdapter(): RxJavaCallAdapterFactory {
        return RxJavaCallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideMoshiAdapter(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, adapterFactory: RxJavaCallAdapterFactory, converterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder().client(client).baseUrl(BASE_URL).addCallAdapterFactory(adapterFactory).addConverterFactory(converterFactory).build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDaoSession(context: Context): Int {
        return 1
    }
}
