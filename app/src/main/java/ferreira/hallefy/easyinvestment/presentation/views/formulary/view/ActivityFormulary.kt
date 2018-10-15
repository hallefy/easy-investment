package ferreira.hallefy.easyinvestment.presentation.views.formulary.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dmax.dialog.SpotsDialog
import ferreira.hallefy.easyinvestment.R
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.presentation.FormularyPresenter
import ferreira.hallefy.easyinvestment.presentation.views.resultinvestiment.view.ActivityResultInvestiment
import ferreira.hallefy.easyinvestment.utils.*
import kotlinx.android.synthetic.main.activity_form.*
import javax.inject.Inject



class ActivityFormulary : DaggerAppCompatActivity(), FormularyView {

    @Inject
    lateinit var presenter: FormularyPresenter
    lateinit var alertDialog: AlertDialog.Builder
    lateinit var progressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        setUp()
    }

    private fun setUp() {
        initListeners()
        setAlertDialog()
        setMasks()
    }

    private fun setAlertDialog() {
        alertDialog = AlertDialog.Builder(this)
        alertDialog.run {
            setMessage(getString(R.string.msg_error_dialog))
            setPositiveButton(getString(R.string.btn_tentar_novamente)) { _, _ ->
                presenter.request()
            }
            setNegativeButton(getString(R.string.btn_cancelar), null)
        }.create()

        progressDialog = SpotsDialog.Builder().setContext(this).build()
        progressDialog.apply {
            setMessage(getString(R.string.msg_progress_dialog))
            setCancelable(true)
            setOnCancelListener {
                presenter.dispose()
            }
        }
    }

    override fun showDialogError() {
        alertDialog.show()
    }

    override fun getAmout() : String {
        return inputAplicacao.text.toFormatedAmount()
    }

    override fun getDate() : String {
        return inputDataVencimento.text.toFormatedDate()
    }

    override fun getPercentage() : String {
        return inputPercentualCdi.text.toString()
    }

    override fun setErrorDate() {
        inputDataVencimento.error(getString(R.string.error_date))
    }

    override fun setErrorAmount() {
        inputAplicacao.error(getString(R.string.error_value_is_zero))
    }

    override fun setErrorPercentage() {
        inputPercentualCdi.error(getString(R.string.error_value_is_zero))
    }
    private fun setMasks() {
        inputAplicacao.setMoneyMask()
        inputDataVencimento.setDataMask()
        inputPercentualCdi.setMaskPercent()
    }

    override fun startSimulation(response: SimulationResponseBusiness) {
        var intent = Intent(this, ActivityResultInvestiment::class.java)
        intent.putExtra("response", response)

        startActivity(intent)
    }

    override fun showProgress() {
        progressDialog.show()
    }

    override fun hideProgress() {
        progressDialog.dismiss()
    }

    private fun initListeners() {
        btnSimular.setOnClickListener {
            presenter.request()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }
}
