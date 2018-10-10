package ferreira.hallefy.easyinvestment.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import ferreira.hallefy.easyinvestment.di.modules.AndroidModule
import ferreira.hallefy.easyinvestment.di.modules.ApiModule
import ferreira.hallefy.easyinvestment.di.modules.AplicationModule
import ferreira.hallefy.easyinvestment.di.modules.ClientModule
import javax.inject.Singleton


@Singleton
@Component(modules = ([AndroidSupportInjectionModule::class,
    AndroidModule::class,
    ActivityBuilder::class,
    AplicationModule::class,
    ClientModule::class,
    ApiModule::class]))

interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}
