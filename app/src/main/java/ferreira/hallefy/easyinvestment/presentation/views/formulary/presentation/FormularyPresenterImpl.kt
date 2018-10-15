package ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation

import ferreira.hallefy.easyinvestment.domain.interactor.RequestSimulationUseCase
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.FormularyView
import ferreira.hallefy.easyinvestment.utils.diffDate
import ferreira.hallefy.easyinvestment.utils.isInvalidDate
import ferreira.hallefy.easyinvestment.utils.toFormatedDate
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class FormularyPresenterImpl @Inject constructor(
    var useCase: RequestSimulationUseCase,
    var view: FormularyView
) : FormularyPresenter{

    override fun request(requestParams: SimulationRequest) {

        if(validateFields(requestParams)) {
            var params = SimulationRequest(
                    view.getAmout(),
                    "CDI",
                    view.getPercentage(),
                    false,
                    view.getDate().toFormatedDate())
            useCase.execute(SimulationDisposable(), params)
            view.showProgress()
        }
    }

    override fun dispose() {
        useCase.dispose()
    }

    fun validateFields(requestParams: SimulationRequest): Boolean{
        return when {
            requestParams.investedAmount.isEmpty() -> {
                view.setErrorAmount()
                false
            }
            requestParams.maturityDate.isInvalidDate() -> {
                view.setErrorDate()
                false
            }
            diffDate(requestParams.maturityDate) <= 0 -> {
                view.setErrorDateOutRange()
                false
            }
            requestParams.rate.isEmpty() -> {
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