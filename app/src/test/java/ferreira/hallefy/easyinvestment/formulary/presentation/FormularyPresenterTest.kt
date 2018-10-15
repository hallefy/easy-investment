package ferreira.hallefy.easyinvestment.formulary.presentation

import com.nhaarman.mockito_kotlin.*
import ferreira.hallefy.easyinvestment.domain.interactor.RequestSimulationUseCase
import ferreira.hallefy.easyinvestment.domain.model.SimulationRequest
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation.FormularyPresenter
import ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation.FormularyPresenterImpl
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.FormularyView
import io.mockk.mockk
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Before
import org.junit.Test
import java.lang.Exception

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
    fun `test function validateFields call setErrorAmount`() {
        request = SimulationRequest("","CDI","", false, "31/02/2018")

        presenter.request(request)

        verify(view, times(1)).setErrorAmount()
    }

    @Test
    fun `test function validateFields call setErrorDate`() {
        request = SimulationRequest("R$200,00","CDI","", false, "31/02/2018")

        presenter.request(request)

        verify(view, times(1)).setErrorDate()
    }

    @Test
    fun `test function validateFields call setErrorDateOutRange`() {
        request = SimulationRequest("R$200,00","CDI","", false, "22/02/2018")

        presenter.request(request)

        verify(view, times(1)).setErrorDateOutRange()
    }

    @Test
    fun `test function validateFields call setErrorPercentage`() {
        request = SimulationRequest("R$200,00","CDI","", false, "22/02/2019")

        presenter.request(request)

        verify(view, times(1)).setErrorPercentage()
    }

    @Test
    fun `test useCase on receive response success`() {
        request = SimulationRequest("R$200,00","CDI","123", false, "22/02/2019")
        var response: SimulationResponseBusiness = mockk()
        presenter.request(request)

        verify(view, times(1)).showProgress()

        verify(useCase, times(1)).execute(disposable.capture(), eq(request))
        disposable.firstValue.onSuccess(response)

        verify(view, times(1)).hideProgress()
        verify(view, times(1)).startSimulation(response)
    }

    @Test
    fun `test useCase on receive response error`() {
        request = SimulationRequest("R$200,00","CDI","123", false, "22/02/2019")
        presenter.request(request)

        verify(view, times(1)).showProgress()

        verify(useCase, times(1)).execute(disposable.capture(), eq(request))
        disposable.firstValue.onError(Exception())

        verify(view, times(1)).hideProgress()
        verify(view, times(1)).showDialogError()
    }
}