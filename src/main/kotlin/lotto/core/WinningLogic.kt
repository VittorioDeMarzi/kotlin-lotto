package lotto.core

class WinningLogic(private val tickets: List<Lotto>, private val winningLotto: Lotto, private val bonusNumber: Int) {
    fun determineWinningTickets(): Map<Rank, Int> {
        return tickets
            .map {
                val countMatches = it.countMatches(winningLotto)
                val hasBonus = it.containsBonus(bonusNumber)
                Rank.valueOf(countMatches, hasBonus)
            }.groupingBy { it }
            .eachCount()
    }
}
