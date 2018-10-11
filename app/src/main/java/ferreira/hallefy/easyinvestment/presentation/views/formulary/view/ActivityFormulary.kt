package ferreira.hallefy.easyinvestment.presentation.views.formulary.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import dagger.android.support.DaggerAppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
//
//        var skeletonScreen = Skeleton.bind(viewForm)
//                .load(R.layout.form_skeleton)
//                .show()
//
//       Handler().postDelayed({
//            skeletonScreen.hide()
//        }, 2000)

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
            setMessage("Ocorrou um erro ao processar sua solicitação.")
            setPositiveButton("Tentar novamente") { _, _ ->
                presenter.request()
            }
            setNegativeButton("Cancelar", null)
        }.create()
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
        goToActivity(ActivityResultInvestiment::class.java)
    }

    private fun initListeners() {

        btnSimular.setOnClickListener {
            presenter.request()
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.dispose()
    }
}
