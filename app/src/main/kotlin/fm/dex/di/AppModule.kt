package fm.dex.di

import android.app.Application
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping
import com.pushtorefresh.storio.sqlite.StorIOSQLite
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import fm.dex.model.BASE_URL
import fm.dex.model.api.ApiService
import fm.dex.model.db.DbOpenHelper
import fm.dex.model.entities.Channel
import fm.dex.model.entities.Contributor
import fm.dex.model.entities.Item
import fm.dex.model.db.resolvers.*
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

    @Provides
    @Singleton
    fun provideStorIOSQLite(sqLiteOpenHelper: SQLiteOpenHelper): StorIOSQLite {
        return DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(sqLiteOpenHelper)
                .addTypeMapping(Channel::class.java, SQLiteTypeMapping.builder<Channel>()
                        .putResolver(ChannelPutResolver())
                        .getResolver(ChannelGetResolver())
                        .deleteResolver(ChannelDeleteResolver())
                        .build())
                .addTypeMapping(Contributor::class.java, SQLiteTypeMapping.builder<Contributor>()
                        .putResolver(ContributorPutResolver())
                        .getResolver(ContributorGetResolver())
                        .deleteResolver(ContributorDeleteResolver())
                        .build())
                .addTypeMapping(Item::class.java, SQLiteTypeMapping.builder<Item>()
                        .putResolver(ItemPutResolver())
                        .getResolver(ItemGetResolver())
                        .deleteResolver(ItemDeleteResolver())
                        .build())
                .build()
    }

    @Provides
    @Singleton
    fun provideSQLiteOpenHelper(context: Context): SQLiteOpenHelper {
        return DbOpenHelper(context)
    }
}
