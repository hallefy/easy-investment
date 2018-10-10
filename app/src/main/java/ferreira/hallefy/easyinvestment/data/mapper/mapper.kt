package ferreira.hallefy.easyinvestment.data.mapper

import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness

fun SimulationResponse.toSimulationBusiness() : SimulationResponseBusiness =
        SimulationResponseBusiness(
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