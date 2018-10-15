package ferreira.hallefy.easyinvestment.domain.interactor

import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.domain.repository.SimulationRepository
import ferreira.hallefy.easyinvestment.domain.usecase.SingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class RequestSimulationUseCase @Inject constructor(
    val repository: SimulationRepository,
    @Named("SchedulerIO") executorThread: Scheduler,
    @Named("AndroidScheduler") uiThread: Scheduler,
    @Named("CompositeDisposable") disposables: CompositeDisposable
) : SingleUseCase<SimulationResponseBusiness, SimulationRequest>(
    executorThread,
    uiThread,
    disposables
) {
    public override fun buildUseCaseObservable(params: SimulationRequest): Single<SimulationResponseBusiness> {
        return repository.getSimulationInfo(params)
    }
}