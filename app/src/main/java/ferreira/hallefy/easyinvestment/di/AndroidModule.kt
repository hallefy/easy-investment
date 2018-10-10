package ferreira.hallefy.easyinvestment.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class AndroidModule {

    @Provides
    @Named("AndroidScheduler")
    fun provideMainScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named("SchedulerIO")
    fun provideIoScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Named("CompositeDisposable" )
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}