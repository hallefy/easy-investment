package ferreira.hallefy.easyinvestment.network

import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.data.repository.SimulationDataStore
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.network.mapper.toSimulationResponse
import io.reactivex.Single
import javax.inject.Inject

class RemoteImpl @Inject constructor(val service: NetworkAPI) : SimulationDataStore{

    override fun getSimulationInfo(params: SimulationRequest): Single<SimulationResponse> {
        return service.request(params.investedAmount,params.index,params.rate,params.isTaxFree,params.maturityDate)
            .map {
                it.toSimulationResponse()
            }
    }

}