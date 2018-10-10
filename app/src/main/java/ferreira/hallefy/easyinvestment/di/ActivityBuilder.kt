package ferreira.hallefy.easyinvestment.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ferreira.hallefy.easyinvestment.di.modules.ActivityFormularyModule
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ActivityFormularyModule::class])
    abstract fun bindActivityFormulary(): ActivityFormulary
}