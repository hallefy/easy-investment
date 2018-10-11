package ferreira.hallefy.easyinvestment.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ferreira.hallefy.easyinvestment.BuildConfig
import ferreira.hallefy.easyinvestment.di.ApplicationQualifier
import ferreira.hallefy.easyinvestment.utils.isNetworkAvailable
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class ClientModule {

    @Provides
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        @ApplicationQualifier context: Context
    ): OkHttpClient {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->

                val request: Request.Builder = chain.request().newBuilder()

                if (!isNetworkAvailable(context)) {
                    val cacheControl = CacheControl.Builder()
                        .maxStale(10, TimeUnit.DAYS)
                        .build()

                    request.cacheControl(cacheControl)
                }

                return@addInterceptor chain.proceed(request.build())
            }

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(loggingInterceptor)
        }

        return okHttpClient.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}