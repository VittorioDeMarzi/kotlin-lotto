package lotto.core

import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.model.Rank
import lotto.model.WinningLogic
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class WinningLogicTest {
    @Test
    fun `calculate right number of Ranks`() {
        val winningLotto = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val ticket1 = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val ticket2 = Lotto(listOf<Int>(1, 2, 3, 4, 5, 8))
        val ticket3 = Lotto(listOf<Int>(1, 2, 3, 4, 5, 9))
        val tickets = listOf<Lotto>(ticket1, ticket2, ticket3)
        val bonusNumber = 9
        val winningLogic = WinningLogic(tickets, winningLotto, bonusNumber)
        val mapOfResult = winningLogic.determineWinningTickets()
        assertThat(mapOfResult.size).isEqualTo(3)

        assertThat(mapOfResult.getOrDefault(Rank.FIRST, 0)).isEqualTo(1)
        assertThat(mapOfResult.getOrDefault(Rank.SECOND, 0)).isEqualTo(1)
        assertThat(mapOfResult.getOrDefault(Rank.THIRD, 0)).isEqualTo(1)
    }

    @Test
    fun `generate right winning Lotto`() {
        val listOfInt = listOf<Int>(1, 2, 3, 4, 5, 6)
        val expectedWinningLotto = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val lottoMachine = LottoMachine()
        val actualWinningLotto = lottoMachine.generateWinningLotto(listOfInt)
        assertThat(expectedWinningLotto).isEqualTo(actualWinningLotto)
    }
}
