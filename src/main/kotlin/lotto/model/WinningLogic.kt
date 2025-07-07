package lotto.model

object WinningLogic {
    fun determineWinningTickets2(
        tickets: List<Lotto>,
        winningLotto: WinningLotto,
    ): Map<Rank, Int> {
        return tickets
            .map {
                val countMatches = winningLotto.countMatches(it)
                val hasBonus = winningLotto.isBonusMatched(it)
                Rank.valueOf(countMatches, hasBonus)
            }.groupingBy { it }
            .eachCount()
    }
}
