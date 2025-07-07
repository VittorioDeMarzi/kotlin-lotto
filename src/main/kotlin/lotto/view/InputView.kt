package lotto.view

import lotto.model.InputValidation

object InputView {
    fun purchaseAmountInput(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount:")
                val input = readln().toIntOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                return InputValidation.validatePurchaseAmount(input)
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    fun winningNumbersInput(): List<Int> {
        while (true) {
            try {
                println("Please enter last week’s winning numbers.")
                val winningNumbers = readlnOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                val winningLottoNumbers = winningNumbers.split(",").map { it.toInt() }
                InputValidation.validateWinningNumbersInput(winningLottoNumbers)
                return winningLottoNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNumberInput(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonusNumber = readln().toIntOrNull() ?: throw IllegalArgumentException(Error.INVALID_INPUT.message)
                InputValidation.validateBonusNumberInput(winningNumbers, bonusNumber)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
