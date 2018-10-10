package ferreira.hallefy.easyinvestment.network.mapper

import ferreira.hallefy.easyinvestment.data.model.InvestmentParameterData
import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.network.model.InvestmentParameter
import ferreira.hallefy.easyinvestment.network.model.ResultInvestiment

fun ResultInvestiment.toSimulationResponse(): SimulationResponse =
        SimulationResponse(
            toInvestmentParameter(),
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
            annualNetRateProfit)

fun ResultInvestiment.toInvestmentParameter() =
        investmentParameter.toInvestmentData()

fun InvestmentParameter.toInvestmentData(): InvestmentParameterData =
        InvestmentParameterData(investedAmount,
            yearlyInterestRate,
            maturityTotalDays,
            maturityBusinessDays,
            maturityDate,
            rate,
            isTaxFree)