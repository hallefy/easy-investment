package ferreira.hallefy.easyinvestment.data.repository

import ferreira.hallefy.easyinvestment.data.model.SimulationRequest
import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import io.reactivex.Single

interface SimulationRemote {
    fun getSimulationInfo(params: SimulationRequest) : Single<SimulationResponse>
}