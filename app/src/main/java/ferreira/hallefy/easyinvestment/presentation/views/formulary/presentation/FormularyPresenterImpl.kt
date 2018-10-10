package ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation

import android.util.Log
import ferreira.hallefy.easyinvestment.domain.interactor.RequestSimulationUseCase
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.FormularyView
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class FormularyPresenterImpl @Inject constructor(
    var useCase: RequestSimulationUseCase,
    var view: FormularyView
) : FormularyPresenter{

    override fun request() {
        var params = SimulationRequest(3000.0, "CDI", 123, false, "2023-03-03")
        useCase.execute(SimulationDisposable(), params)
    }

    override fun dispose() {
        useCase.dispose()
    }

    inner class SimulationDisposable : DisposableSingleObserver<SimulationResponseBusiness>() {
        override fun onSuccess(response: SimulationResponseBusiness) {
            Log.i("hallefy", "response: $response")
        }

        override fun onError(e: Throwable?) {
            Log.i("hallefy", "exception: $e")
        }
    }
}