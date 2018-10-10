package ferreira.hallefy.easyinvestment.data.model

data class SimulationRequest(
    var investedAmount: Int,
    var index: String,
    var rate: Int,
    var isTaxFree: Boolean,
    var maturityDate: String
)