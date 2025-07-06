package lotto.model

import lotto.view.Error

object LottoMachine {
    fun calculateNumberOfTickets(purchaseAmount: Int): Int {
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT.message }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000.message }
        return purchaseAmount / 1000
    }

    fun generateListOfSixRandomNumbers(): List<Int> {
        return (1..50).shuffled().take(6)
    }

    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val listOfTickets = mutableListOf<Lotto>()
        repeat(numberOfTickets) {
            val lotto = Lotto(Random.generateListOfSixRandomNumbers())
            listOfTickets.add(lotto)
        }
        return listOfTickets
    }
}
