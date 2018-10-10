package ferreira.hallefy.easyinvestment.di.modules

import dagger.Module
import dagger.Provides
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.FormularyView


@Module
class ActivityFormularyModule {

    @Provides
    fun provideView(view : ActivityFormulary): FormularyView = view
}