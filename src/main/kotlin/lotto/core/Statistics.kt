package lotto.core

class Statistics(val result: Map<Rank, Int>, val purchaseAmount: Int) {
    fun calculateRate(): Double {
        val totalWinning =
            result
                .entries.sumOf { (rank, count) ->
                    rank.winningMoney * count
                }
        return totalWinning.toDouble() / purchaseAmount
    }
}
