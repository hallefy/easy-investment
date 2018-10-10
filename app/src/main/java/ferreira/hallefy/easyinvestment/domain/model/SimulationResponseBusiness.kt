package ferreira.hallefy.easyinvestment.domain.model

data class SimulationResponseBusiness(
    var grossAmount: String,
    var taxesAmount: String,
    var netAmount: String,
    var grossAmountProfit: String,
    var netAmountProfit: String,
    var annualGrossRateProfit: String,
    var monthlyGrossRateProfit: String,
    var dailyGrossRateProfit: String,
    var taxesRate: String,
    var rateProfit: String,
    var annualNetRateProfit: String
)