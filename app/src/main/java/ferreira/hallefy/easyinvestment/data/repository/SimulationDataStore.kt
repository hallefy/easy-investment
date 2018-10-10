package ferreira.hallefy.easyinvestment.data.repository

import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import io.reactivex.Single

interface SimulationDataStore {
    fun getSimulationInfo(params: SimulationRequest) : Single<SimulationResponse>
}