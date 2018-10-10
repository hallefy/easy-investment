package ferreira.hallefy.easyinvestment.network

import ferreira.hallefy.easyinvestment.network.model.ResultInvestiment
import ferreira.hallefy.easyinvestment.utils.Constants.END_POINT
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    @GET(END_POINT)
    fun request(
            @Query("investedAmount") investedAmount: Int,
            @Query("index") index: String,
            @Query("rate") rate: Int,
            @Query("isTaxFree") isTaxFree: Boolean,
            @Query("maturityDate") maturityDate: String
    ) : Single<ResultInvestiment>

}