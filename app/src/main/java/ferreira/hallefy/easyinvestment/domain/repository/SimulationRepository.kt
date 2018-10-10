package ferreira.hallefy.easyinvestment.domain.repository

import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import io.reactivex.Single

interface SimulationRepository {
    fun getSimulationInfo(params: SimulationRequest) : Single<SimulationResponseBusiness>
}