package ferreira.hallefy.easyinvestment.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ferreira.hallefy.easyinvestment.di.ApplicationQualifier

@Module
abstract class AplicationModule {

    @Binds
    @ApplicationQualifier
    internal abstract fun provideContext(application: Application): Context
}