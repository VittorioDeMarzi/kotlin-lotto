package lotto.core

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test

class LottoTest {
    @MethodSource("factory")
    @ParameterizedTest
    fun `lotto should have 6 numbers`(ticket: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(ticket)
        }
    }

    @Test
    fun `lotto should have 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `check the right number of matches between two Lotto with 6 matches`() {
        val ticket = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val matches = ticket.countMatches(winningLotto)
        assertThat(matches).isEqualTo(6)
    }

    @Test
    fun `check if the bonus number is matched`() {
        val ticket = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val bonusNumber = 1
        assertThat(ticket.containsBonus(bonusNumber)).isTrue()
    }

    @Test
    fun `check if the bonus number is not matched`() {
        val ticket = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        assertThat(ticket.containsBonus(bonusNumber)).isFalse()
    }

    companion object {
        @JvmStatic
        fun factory(): List<List<Int>> {
            return listOf(
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6, 7),
            )
        }
    }
}
