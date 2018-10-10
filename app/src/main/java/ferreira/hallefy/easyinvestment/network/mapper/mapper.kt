package ferreira.hallefy.easyinvestment.network.mapper

import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.network.model.ResultInvestiment

fun ResultInvestiment.toSimulationResponse(): SimulationResponse =
        SimulationResponse(
            grossAmount,
            taxesAmount,
            netAmount,
            grossAmountProfit,
            netAmountProfit,
            annualGrossRateProfit,
            monthlyGrossRateProfit,
            dailyGrossRateProfit,
            taxesRate,
            rateProfit,
            annualNetRateProfit
        )