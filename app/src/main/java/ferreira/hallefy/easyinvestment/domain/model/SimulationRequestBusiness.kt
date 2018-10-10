package ferreira.hallefy.easyinvestment.domain.model

data class SimulationRequest(
    var investedAmount: Double,
    var index: String,
    var rate: Int,
    var isTaxFree: Boolean,
    var maturityDate: String
)