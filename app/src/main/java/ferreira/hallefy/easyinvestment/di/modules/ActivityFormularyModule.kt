package ferreira.hallefy.easyinvestment.di.modules

import dagger.Module
import dagger.Provides
import ferreira.hallefy.easyinvestment.data.repository.SimulationDataRepository
import ferreira.hallefy.easyinvestment.data.repository.SimulationDataStore
import ferreira.hallefy.easyinvestment.data.repository.SimulationDataStoreImpl
import ferreira.hallefy.easyinvestment.domain.interactor.RequestSimulationUseCase
import ferreira.hallefy.easyinvestment.domain.repository.SimulationRepository
import ferreira.hallefy.easyinvestment.network.NetworkAPI
import ferreira.hallefy.easyinvestment.network.RemoteImpl
import ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation.FormularyPresenter
import ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation.FormularyPresenterImpl
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.FormularyView


@Module
class ActivityFormularyModule {

    @Provides
    fun provideRemoteImpl(remote: NetworkAPI) : SimulationDataStore =
        RemoteImpl(remote)

    @Provides
    fun provideRepository(repository: SimulationDataStoreImpl): SimulationRepository =
        SimulationDataRepository(repository)

    @Provides
    fun provideView(view : ActivityFormulary): FormularyView = view

    @Provides
    fun providePresenter(useCase: RequestSimulationUseCase,
                         view: FormularyView): FormularyPresenter =
            FormularyPresenterImpl(useCase, view)
}