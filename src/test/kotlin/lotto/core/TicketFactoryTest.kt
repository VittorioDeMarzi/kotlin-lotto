package lotto.core

import lotto.model.TicketFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketFactoryTest {
    val ticketFactory = TicketFactory

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000])
    fun `calculate the right number of tickets`(purchaseAmounts: Int) {
        val rightNumberOfTickets = purchaseAmounts / 1000
        val numberOfTickets = ticketFactory.calculateNumberOfTickets(purchaseAmounts)
        assertThat(rightNumberOfTickets).isEqualTo(numberOfTickets)
    }

    @Test
    fun `Should throw exception if purchase Amount is negative`() {
        val purchaseAmount = -10
        assertThrows<IllegalArgumentException> {
            ticketFactory.calculateNumberOfTickets(purchaseAmount)
        }
    }

    @Test
    fun `generate the right number of tickets`() {
        val numberOfTickets = 6
        val tickets = ticketFactory.generateAutomaticTickets(numberOfTickets)
        assertThat(tickets).hasSize(numberOfTickets)
    }

    companion object {
        @JvmStatic
        fun purchaseAmount(): List<Int> {
            return listOf(1000, 2000, 3000)
        }
    }
}
