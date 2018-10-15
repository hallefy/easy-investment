package ferreira.hallefy.easyinvestment.formulary.domain.usecase

import com.nhaarman.mockito_kotlin.*
import ferreira.hallefy.easyinvestment.domain.interactor.RequestSimulationUseCase
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.domain.repository.SimulationRepository
import ferreira.hallefy.easyinvestment.formulary.data.factory.SimulationRequestService
import io.mockk.mockk
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetSimulationTest {

    lateinit var simulationRepository: SimulationRepository
    lateinit var simulationUseCase: RequestSimulationUseCase
    lateinit var disposable: CompositeDisposable
    lateinit var simulationRequest: SimulationRequest
    lateinit var simulationResponseBusiness: SimulationResponseBusiness

    @Before
    fun setUp() {
        simulationRepository = mock()
        disposable = mockk()
        simulationRequest = mockk()
        simulationResponseBusiness = mockk()

        simulationUseCase = RequestSimulationUseCase(
                simulationRepository,
                AndroidSchedulers.mainThread(),
                Schedulers.io(),
                disposable
        )
    }

    @Test
    fun `test if use case works`() {
        simulationUseCase.buildUseCaseObservable(simulationRequest)

        verify(simulationRepository).getSimulationInfo(simulationRequest)
    }

    @Test
    fun `test if useCase complete task`() {
        SimulationRequestService.requestRepository(
                simulationRepository,
                simulationRequest,
                Single.just(simulationResponseBusiness)
        )

        val observerUseCase = simulationUseCase.buildUseCaseObservable(simulationRequest).test()
        observerUseCase.assertComplete()
    }

    @Test
    fun `assert value returned by use case`() {
        SimulationRequestService.requestRepository(
                simulationRepository,
                simulationRequest,
                Single.just(simulationResponseBusiness)
        )

        val observerUseCase = simulationUseCase.buildUseCaseObservable(simulationRequest).test()
        observerUseCase.assertValue(simulationResponseBusiness)
    }
}