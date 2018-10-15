package ferreira.hallefy.easyinvestment.formulary.presentation

import com.nhaarman.mockito_kotlin.*
import ferreira.hallefy.easyinvestment.domain.interactor.RequestSimulationUseCase
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation.FormularyPresenter
import ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation.FormularyPresenterImpl
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.FormularyView
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Before
import org.junit.Test

class FormularyPresenterTest {

    private lateinit var view : FormularyView
    private lateinit var presenter: FormularyPresenter
    private lateinit var request: SimulationRequest
    private lateinit var useCase : RequestSimulationUseCase
    private lateinit var disposable : KArgumentCaptor<DisposableSingleObserver<SimulationResponseBusiness>>

    @Before
    fun setUp() {
        view = mock()
        useCase = mock()
        disposable = argumentCaptor()
        presenter = FormularyPresenterImpl(useCase, view)
    }

    @Test
    fun `test function validateFields`() {
        request = SimulationRequest("","CDI","", false, "31/02/2018")

        presenter.request(request)

        verify(view, times(1)).setErrorAmount()
    }
}