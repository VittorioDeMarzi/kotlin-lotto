package lotto.core

import lotto.model.InputValidation
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class InputValidationTest {
    // Purchase Validation Test
    @Test
    fun `should throw if less then 1000`() {
        val number = 999
        assertThrows<IllegalArgumentException> { InputValidation.validatePurchaseAmount(number) }
    }

    @Test
    fun `winning numbers should be unique numbers`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> { InputValidation.validateWinningNumbersInput(winningLotto) }
    }

    @Test
    fun `winning numbers should has to be exactly 6 numbers`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> { InputValidation.validateWinningNumbersInput(winningLotto) }
    }

    @Test
    fun `winning numbers should has to be exactly 6 numbers_2`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> { InputValidation.validateWinningNumbersInput(winningLotto) }
    }

    @Test
    fun `winning numbers must be in range 1 - 50`() {
        val winningLotto = listOf<Int>(1, 2, 3, 4, 5, 51)
        assertThrows<IllegalArgumentException> { InputValidation.validateWinningNumbersInput(winningLotto) }
    }

    @Test
    fun `manual numbers of tickets must be in range 0 - numberMaximaTickets`() {
        val numberManualTicketsInput = 10
        val numberTicketsAvailable = 9
        assertThrows<IllegalArgumentException> {
            InputValidation.validateNumberManualTicketsInput(
                numberManualTickets = numberManualTicketsInput,
                maximalNumberOfTickets = numberTicketsAvailable,
            )
        }
    }

    @Test
    fun `manual numbers of tickets must be greater than 0`() {
        val numberManualTicketsInput = -10
        val numberTicketsAvailable = 9
        assertThrows<IllegalArgumentException> {
            InputValidation.validateNumberManualTicketsInput(
                numberManualTickets = numberManualTicketsInput,
                maximalNumberOfTickets = numberTicketsAvailable,
            )
        }
    }
}
