package ferreira.hallefy.easyinvestiment.views.resultinvestiment.model

data class ResultInvestiment(
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

data class InvestmentParameter (
        var investedAmount: String,
        var yearlyInterestRate: String,
        var maturityTotalDays: String,
        var maturityBusinessDays: String,
        var maturityDate: String,
        var rate: String,
        var isTaxFree: String
)

