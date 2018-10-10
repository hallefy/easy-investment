package ferreira.hallefy.easyinvestment.data.repository

import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import io.reactivex.Single
import javax.inject.Inject

class SimulationDataStoreImpl @Inject constructor(val store: SimulationDataStore): SimulationDataStore {
    override fun getSimulationInfo(params: SimulationRequest): Single<SimulationResponse> {
        return store.getSimulationInfo(params)
    }
}