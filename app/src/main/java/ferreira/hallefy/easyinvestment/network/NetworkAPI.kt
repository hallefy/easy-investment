package ferreira.hallefy.easyinvestment.network

import ferreira.hallefy.easyinvestment.presentation.views.resultinvestiment.model.ResultInvestiment
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    companion object {
        const val URL = "https://api-simulator-calc.easynvest.com.br/calculator/simulate"
    }

    @GET(URL)
    fun request(
            @Query("investedAmount") investedAmount: Int,
            @Query("index") index: String,
            @Query("rate") rate: Int,
            @Query("isTaxFree") isTaxFree: Boolean,
            @Query("maturityDate") maturityDate: String
    ) : Single<ResultInvestiment>

}