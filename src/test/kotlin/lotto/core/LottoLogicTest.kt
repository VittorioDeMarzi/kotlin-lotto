package lotto.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test

class LottoLogicTest {
    val lottoLogic = LottoLogic()

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000])
    fun `calculate the right number of tickets`(purchaseAmounts: Int) {
        val rightNumberOfTickets = purchaseAmounts / 1000
        val numberOfTickets = lottoLogic.calculateNumberOfTickets(purchaseAmounts)
        assertThat(rightNumberOfTickets).isEqualTo(rightNumberOfTickets)
    }

    @Test
    fun `generate a list of 6 numbers`() {
        val listOfNumbers = lottoLogic.generateListOfSixRandomNumbers()
        assertThat(listOfNumbers).hasSize(6)
    }

    @Test
    fun `generate the right number of tickets`() {
        val numberOfTickets = 6
        val tickets = lottoLogic.generateTickets(numberOfTickets)
        assertThat(tickets).hasSize(numberOfTickets)
    }

    companion object {
        @JvmStatic
        fun purchaseAmount(): List<Int> {
            return listOf(1000, 2000, 3000)
        }
    }
}
