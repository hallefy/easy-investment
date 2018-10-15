package ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation

import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest

interface FormularyPresenter {
    fun dispose()
    fun request(requestParams: SimulationRequest)
}