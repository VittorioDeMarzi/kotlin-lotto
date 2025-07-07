package lotto.model

import lotto.view.Error

object TicketFactory {
    fun calculateNumberOfTickets(purchaseAmount: Int): Int {
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT.message }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000.message }
        return purchaseAmount / 1000
    }

    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        return List(numberOfTickets) { Lotto.fromInts(Random.generateSetOfSixRandomNumbers()) }
    }
}
