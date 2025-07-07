package lotto.model

import lotto.view.Error

object TicketFactory {
    fun calculateNumberOfTickets(purchaseAmount: Int): Int {
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT.message }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000.message }
        return purchaseAmount / 1000
    }

    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val listOfTickets = mutableListOf<Lotto>()
        repeat(numberOfTickets) {
            val lotto = Lotto(Random.generateSetOfSixRandomNumbers())
            listOfTickets.add(lotto)
        }
        return listOfTickets
    }
}
