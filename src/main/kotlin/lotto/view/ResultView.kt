package lotto.view

import lotto.model.Lotto
import lotto.model.Rank

object ResultView {
    fun displayNumberOfTickets(numberOfTickets: Int) {
        println("You have purchased $numberOfTickets tickets.")
    }

    fun displayTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.displayLotto())
        }
    }

    fun displayWinningRanks(mapOfResult: Map<Rank, Int>) {
        println()
        println("Winning Statistics")
        println("-----------------------")
        val rankList = listOf<Rank>(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH)

        rankList.forEach {
            println("${it.display()} - ${mapOfResult.getOrDefault(it, 0)} tickets")
        }
    }

    fun displayWinningRate(rate: Double) {
        println("Total return rate is " + String.format("%.2f", rate) + " (A rate below 1 means a loss)")
    }
}
