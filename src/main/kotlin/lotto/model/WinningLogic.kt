package lotto.model

class WinningLogic(
    private val tickets: List<Lotto>,
    private val winningLotto: WinningLotto,
) {
    fun determineWinningTickets(): Map<Rank, Int> {
        return tickets
            .map {
                val countMatches = winningLotto.countMatches(it)
                val hasBonus = winningLotto.isBonusMatched(it)
                Rank.valueOf(countMatches, hasBonus)
            }.groupingBy { it }
            .eachCount()
    }
}
