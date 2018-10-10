package ferreira.hallefy.easyinvestment.formulary.data.factory

import com.nhaarman.mockito_kotlin.whenever
import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.data.repository.SimulationDataStore
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.domain.repository.SimulationRepository
import io.reactivex.Single

class SimulationRequestService {

    companion object {

        fun requestService(
            service: SimulationDataStore,
            params: SimulationRequest,
            response: Single<SimulationResponse>
        ) {
            whenever(service.getSimulationInfo(params)).thenReturn(response)
        }

        fun requestRepository(
            repository: SimulationRepository,
            params: SimulationRequest,
            response: Single<SimulationResponseBusiness>
        ) {
            whenever(repository.getSimulationInfo(params)).thenReturn(response)
        }
    }
}