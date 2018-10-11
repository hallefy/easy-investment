package ferreira.hallefy.easyinvestment.formulary.data.mapper

import ferreira.hallefy.easyinvestment.data.mapper.toSimulationBusiness
import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class DataMapperTest {

    private lateinit var simulationResponseBusiness: SimulationResponseBusiness
    private lateinit var simulationResponse: SimulationResponse

    @Before
    fun setUp() {
        simulationResponse = mockk()
        simulationResponseBusiness = mockk()
    }


    @Test
    fun `test if mapper return right values`() {
        with(mockk<SimulationResponse>()) {
            every {
                simulationResponse.toSimulationBusiness()
            } returns simulationResponseBusiness
        }
    }
}