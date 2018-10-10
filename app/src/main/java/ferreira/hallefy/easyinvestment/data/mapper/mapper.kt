package ferreira.hallefy.easyinvestment.data.mapper

import ferreira.hallefy.easyinvestment.data.model.InvestmentParameterData
import ferreira.hallefy.easyinvestment.data.model.SimulationResponse
import ferreira.hallefy.easyinvestment.domain.model.InvestmentParameterBusiness
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness

fun SimulationResponse.toSimulationBusiness(): SimulationResponseBusiness =
    SimulationResponseBusiness(
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

fun SimulationResponse.toInvestmentParameter() =
    investmentParameter.toInvestmentData()

fun InvestmentParameterData.toInvestmentData(): InvestmentParameterBusiness =
    InvestmentParameterBusiness(investedAmount,
        yearlyInterestRate,
        maturityTotalDays,
        maturityBusinessDays,
        maturityDate,
        rate,
        isTaxFree)