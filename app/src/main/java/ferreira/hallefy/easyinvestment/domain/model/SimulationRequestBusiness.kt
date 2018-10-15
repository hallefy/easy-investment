package ferreira.hallefy.easyinvestment.domain.model

data class SimulationRequest(
    var investedAmount: String,
    var index: String,
    var rate: String,
    var isTaxFree: Boolean,
    var maturityDate: String
)