package ferreira.hallefy.easyinvestment.data.repository

import ferreira.hallefy.easyinvestment.data.mapper.toSimulationBusiness
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.domain.repository.SimulationRepository
import io.reactivex.Single
import javax.inject.Inject

class SimulationDataRepository @Inject constructor(val repository: SimulationDataStoreImpl) : SimulationRepository {

    override fun getSimulationInfo(params: SimulationRequest): Single<SimulationResponseBusiness> {
        return repository.getSimulationInfo(params).map {
            it.toSimulationBusiness()
        }
    }
}