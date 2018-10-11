package ferreira.hallefy.easyinvestment.formulary.data.source

import com.nhaarman.mockito_kotlin.mock
import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.data.repository.SimulationDataStore
import ferreira.hallefy.easyinvestment.data.repository.SimulationDataStoreImpl
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.formulary.data.factory.SimulationRequestService
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class SimulationServiceTest {

    private lateinit var simulationDataStore: SimulationDataStore
    private lateinit var simulationDataStoreImpl: SimulationDataStoreImpl
    private lateinit var simulationResponse: SimulationResponse
    private lateinit var simulationRequest: SimulationRequest

    @Before
    fun setUp() {
        simulationDataStore = mock()
        simulationDataStoreImpl = SimulationDataStoreImpl(simulationDataStore)
        simulationResponse = mockk()
        simulationRequest = mockk()
    }

    @Test
    fun `test if data store implementation return right values`() {
        SimulationRequestService.requestService(
                simulationDataStore,
                simulationRequest,
                Single.just(simulationResponse)
        )

        val dataStoreObserver = simulationDataStore.getSimulationInfo(simulationRequest).test()

        dataStoreObserver.apply {
            assertValue(simulationResponse)
            assertComplete()
        }
    }
}