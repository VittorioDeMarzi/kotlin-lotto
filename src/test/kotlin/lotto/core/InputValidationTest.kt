package lotto.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class InputValidationTest {
    @Test
    fun `winning numbers should create a list of numbers`() {
        val inputValidation = InputValidation()
        val winningLottoString = "1,2,3,4,5,6"
        val winningLotto = inputValidation.createWinningLottoList(winningLottoString)
        assertThat(winningLotto).hasSize(6)
    }

    @Test
    fun `winning numbers should has to be exactly 6 numbers`() {
        val inputValidation = InputValidation()
        val winningLottoString = "1,2,3,4,5"
        assertThrows<IllegalArgumentException> { inputValidation.createWinningLottoList(winningLottoString) }
    }
}
