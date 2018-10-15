package ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation

import android.util.Log
import ferreira.hallefy.easyinvestment.domain.interactor.RequestSimulationUseCase
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.FormularyView
import ferreira.hallefy.easyinvestment.utils.isDateValid
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class FormularyPresenterImpl @Inject constructor(
    var useCase: RequestSimulationUseCase,
    var view: FormularyView
) : FormularyPresenter{

    override fun request() {
        if(validateFields()) {
            var params = SimulationRequest(
                    view.getAmout(),
                    "CDI",
                    view.getPercentage(),
                    false,
                    view.getDate())
            useCase.execute(SimulationDisposable(), params)
            view.showProgress()
        }
    }

    override fun dispose() {
        useCase.dispose()
    }

    fun validateFields() : Boolean{
        return when {
            view.getAmout().isEmpty() -> {
                view.setErrorAmount()
                false
            }
            isDateValid(view.getDate()) -> {
                view.setErrorDate()
                false
            }
            view.getPercentage().isEmpty() -> {
                view.setErrorPercentage()
                false
            }
            else -> true
        }
    }

    inner class SimulationDisposable : DisposableSingleObserver<SimulationResponseBusiness>() {
        override fun onSuccess(response: SimulationResponseBusiness) {
            view.hideProgress()
            view.startSimulation(response)
        }

        override fun onError(e: Throwable?) {
            view.hideProgress()
            view.showDialogError()
        }
    }
}