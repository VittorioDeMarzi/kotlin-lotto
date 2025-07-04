package lotto.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class InputValidationTest {
    // Purchase Validation Test
    @Test
    fun `should throw if less then 1000`() {
        val number = "999"
        assertThrows<IllegalArgumentException> { InputValidation.validatePurchaseAmount(number) }
    }

    @Test
    fun `winning numbers should create a list of numbers`() {
        val winningLottoString = "1,2,3,4,5,6"
        val winningLotto = InputValidation.createWinningLottoList(winningLottoString)
        assertThat(winningLotto).hasSize(6)
    }

    @Test
    fun `winning numbers should has to be exactly 6 numbers`() {
        val winningLottoString = "1,2,3,4,5"
        assertThrows<IllegalArgumentException> { InputValidation.createWinningLottoList(winningLottoString) }
    }
}
