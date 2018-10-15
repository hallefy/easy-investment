package ferreira.hallefy.easyinvestment.presentation.views.formulary.view

import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness

interface FormularyView {
    fun getAmout(): String
    fun getDate(): String
    fun getPercentage(): String
    fun setErrorDate()
    fun startSimulation(response: SimulationResponseBusiness)
    fun setErrorPercentage()
    fun setErrorAmount()
    fun showDialogError()
    fun showProgress()
    fun hideProgress()
    fun setErrorDateOutRange()
}