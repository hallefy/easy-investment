package ferreira.hallefy.easyinvestment.network.model

data class InvestmentParameter(
    var investedAmount: Double,
    var yearlyInterestRate: Double,
    var maturityTotalDays: Int,
    var maturityBusinessDays: Int,
    var maturityDate: String,
    var rate: Int,
    var isTaxFree: Boolean
)

data class ResultInvestiment(
    var investmentParameter: InvestmentParameter,
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