package ferreira.hallefy.easyinvestment.domain.model

import java.math.BigDecimal

data class SimulationRequest(
    var investedAmount: String,
    var index: String,
    var rate: String,
    var isTaxFree: Boolean,
    var maturityDate: String
)