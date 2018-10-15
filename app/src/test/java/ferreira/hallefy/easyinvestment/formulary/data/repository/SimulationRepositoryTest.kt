package ferreira.hallefy.easyinvestment.formulary.data.repository

import com.nhaarman.mockito_kotlin.mock
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.domain.repository.SimulationRepository
import ferreira.hallefy.easyinvestment.formulary.data.factory.SimulationRequestService
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import java.lang.AssertionError
import java.lang.Exception

class SimulationRepositoryTest {

    private lateinit var simulationRepository: SimulationRepository
    private lateinit var simulationRequest: SimulationRequest
    private lateinit var simulationResponse: SimulationResponseBusiness

    @Before
    fun setUp() {
        simulationRepository = mock()
        simulationResponse = mockk()
        simulationRequest = mockk()
    }

    @Test
    fun `assert value returned from repository is correct`() {
        SimulationRequestService.requestRepository(
                simulationRepository,
                simulationRequest,
                Single.just(simulationResponse))

        val repositoryObserver = simulationRepository.getSimulationInfo(simulationRequest)
                .test()

        repositoryObserver.apply {
            assertValue(simulationResponse)
            assertComplete()
        }
    }
}