package lotto.ui

import lotto.core.Lotto
import lotto.core.Rank

object ResultView {
    fun displayNumberOfTickets(numberOfTickets: Int) {
        println("You have purchased $numberOfTickets tickets.")
    }

    fun displayTickets(tickets: List<Lotto>) {
        tickets.forEach {
            it.displayLotto()
        }
    }

    fun displayWinningRanks() {
        println(Rank.THIRD.display())
    }
}
