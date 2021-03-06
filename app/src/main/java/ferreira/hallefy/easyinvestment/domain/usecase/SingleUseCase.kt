package ferreira.hallefy.easyinvestment.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleUseCase<T, in Params> constructor(
    private val executorThread: Scheduler,
    private val uiThread: Scheduler,
    private val disposables: CompositeDisposable
) {

    protected abstract fun buildUseCaseObservable(params: Params): Single<T>

    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params) {
        val single = this.buildUseCaseObservable(params)
            .subscribeOn(executorThread)
            .observeOn(uiThread) as Single<T>
        addDisposable(single.subscribeWith(singleObserver))
    }

    open fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    open fun clear() {
        if (!disposables.isDisposed) {
            disposables.clear()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
