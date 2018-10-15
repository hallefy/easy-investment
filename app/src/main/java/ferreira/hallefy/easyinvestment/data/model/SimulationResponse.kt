package ferreira.hallefy.easyinvestment.data.model


data class InvestmentParameterData(
    var investedAmount: Double,
    var yearlyInterestRate: Double,
    var maturityTotalDays: Int,
    var maturityBusinessDays: Int,
    var maturityDate: String,
    var rate: Int,
    var isTaxFree: Boolean
)

data class SimulationResponse(
    var investmentParameter: InvestmentParameterData,
    var grossAmount: Double,
    var taxesAmount: Double,
    var netAmount: Double,
    var grossAmountProfit: Double,
    var netAmountProfit: Double,
    var annualGrossRateProfit: Double,
    var monthlyGrossRateProfit: Double,
    var dailyGrossRateProfit: Double,
    var taxesRate: Double,
    var rateProfit: Double,
    var annualNetRateProfit: Double
)