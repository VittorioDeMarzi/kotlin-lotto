package lotto.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatisticsTest {
    @Test
    fun `calculate the right winning rate`() {
        val result = mapOf<Rank, Int>(Rank.SECOND to 3)
        val purchaseAmount = 10000
        val expectedRate = (Rank.SECOND.winningMoney * 3).toDouble() / purchaseAmount

        val statistics = Statistics(result, purchaseAmount)
        val actualRate = statistics.calculateRate()
        assertThat(actualRate).isEqualTo(expectedRate)
    }
}
