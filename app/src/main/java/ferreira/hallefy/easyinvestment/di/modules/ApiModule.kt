package ferreira.hallefy.easyinvestment.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import ferreira.hallefy.easyinvestment.network.NetworkAPI
import ferreira.hallefy.easyinvestment.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
open class ApiModule {

    @Provides
    fun provideGsonConverterFactory(gson: Gson) : Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    open fun provideRetrofit(
        converterFactory: Converter.Factory,
        callAdapterFactory: CallAdapter.Factory,
        okHttpClient: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideRxJavaCallAdapterFactory() : CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideService(retrofit: Retrofit) : NetworkAPI = retrofit.create(NetworkAPI::class.java)
}