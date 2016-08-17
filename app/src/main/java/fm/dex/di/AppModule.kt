package fm.dex.di

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import fm.dex.model.api.ApiService
import fm.dex.model.entity.ChannelDao
import fm.dex.model.entity.DaoMaster
import fm.dex.model.entity.DaoSession
import fm.dex.model.entity.ItemDao
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

import fm.dex.model.api.ApiService.BASE_URL

/**
 * Manages singleton instances.
 */
@Module
class AppModule(application: Application) {

    private val context: Context

    init {
        context = application.applicationContext
    }

    @Provides
    internal fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    internal fun provideHttpClient(): OkHttpClient {
        val c = OkHttpClient.Builder()
        return c.build()
    }

    @Singleton
    @Provides
    internal fun provideRxJavaAdapter(): RxJavaCallAdapterFactory {
        return RxJavaCallAdapterFactory.create()
    }

    @Singleton
    @Provides
    internal fun provideMoshiAdapter(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(client: OkHttpClient, adapterFactory: RxJavaCallAdapterFactory, converterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder().client(client).baseUrl(BASE_URL).addCallAdapterFactory(adapterFactory).addConverterFactory(converterFactory).build()
    }

    @Singleton
    @Provides
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    internal fun provideDaoSession(context: Context): DaoSession {
        val helper = DaoMaster.DevOpenHelper(context, DB_NAME)
        return DaoMaster(helper.writableDb).newSession()
    }

    @Singleton
    @Provides
    internal fun provideChannelDao(daoSession: DaoSession): ChannelDao {
        return daoSession.channelDao
    }

    @Singleton
    @Provides
    internal fun provideItemDao(daoSession: DaoSession): ItemDao {
        return daoSession.itemDao
    }

    companion object {

        private val DB_NAME = "dexfm.db"
    }
}
