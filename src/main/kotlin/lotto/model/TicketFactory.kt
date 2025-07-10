package lotto.model

import lotto.view.Error

object TicketFactory {
    fun calculateNumberOfTickets(purchaseAmount: Int): Int {
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT.message }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000.message }
        return purchaseAmount / 1000
    }

    fun handleTicketGeneration(
        manualTicketsList: List<Set<Int>>,
        automaticTicketsNumber: Int,
    ): List<Lotto> {
        val automaticTickets = generateAutomaticTickets(automaticTicketsNumber)
        val manualTickets = generateManualTickets(manualTicketsList)
        return automaticTickets.plus(manualTickets)
    }

    private fun generateAutomaticTickets(numberOfTickets: Int): List<Lotto> {
        return List(numberOfTickets) { Lotto.fromInts(Random.generateSetOfSixRandomNumbers()) }
    }

    private fun generateManualTickets(manualTicketsList: List<Set<Int>>): List<Lotto> {
        return manualTicketsList
            .map { ticket -> Lotto.fromInts(ticket) }
            .toList()
    }
}
