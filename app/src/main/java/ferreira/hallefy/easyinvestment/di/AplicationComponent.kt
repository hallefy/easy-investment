package ferreira.hallefy.easyinvestment.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import ferreira.hallefy.easyinvestment.di.modules.AplicationModule
import javax.inject.Singleton


@Singleton
@Component(modules = ([AndroidSupportInjectionModule::class,
    AndroidModule::class,
    ActivityBuilder::class,
    AplicationModule::class,
    ClientModule::class]))

interface AplicationComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AplicationComponent
    }
}
