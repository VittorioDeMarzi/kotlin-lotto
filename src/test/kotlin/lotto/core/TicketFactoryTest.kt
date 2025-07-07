package lotto.core

import lotto.model.LottoNumber
import lotto.model.TicketFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketFactoryTest {
    val ticketFactory = TicketFactory

    //  calculate number of tickets
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

    // generate manual tickets
    @Test
    fun `should generate list of Lotto from list of manual ticket sets`() {
        val manualTicketsList =
            listOf(
                setOf(1, 2, 3, 4, 5, 6),
                setOf(10, 11, 12, 13, 14, 15),
            )

        val result = ticketFactory.generateManualTickets(manualTicketsList)

        assertThat(result).hasSize(2)

        val expectedFirst = setOf(1, 2, 3, 4, 5, 6).map(LottoNumber::from).toSet()
        val expectedSecond = setOf(10, 11, 12, 13, 14, 15).map(LottoNumber::from).toSet()

        assertThat(result[0].getLottoNumbers()).isEqualTo(expectedFirst)
        assertThat(result[1].getLottoNumbers()).isEqualTo(expectedSecond)
    }
}
