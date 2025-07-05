package lotto.ui

import lotto.core.InputValidation

object InputView {
    fun purchaseAmountInput(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount:")
                val input = readlnOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                return InputValidation.validatePurchaseAmount(input)
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    fun winningNumbersInput(): List<Int> {
        while (true) {
            println("Please enter last week’s winning numbers.")
            val winningNumbers = readlnOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
            try {
                val winningLottoNumbers = winningNumbers.split(",").map { it.toInt() }
                InputValidation.validateWinningNumbersInput(winningLottoNumbers)
                return winningLottoNumbers
            } catch (e: IllegalArgumentException) {
                println(Error.INVALID_INPUT.message + " " + e.message)
            }
        }
    }

    fun bonusNumberInput(): Int {
        println("Please enter the bonus number.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
    }
}
