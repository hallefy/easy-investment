package ferreira.hallefy.easyinvestment.domain.model

data class SimulationRequestBusiness(
    var investedAmount: Int,
    var index: String,
    var rate: Int,
    var isTaxFree: Boolean,
    var maturityDate: String
)