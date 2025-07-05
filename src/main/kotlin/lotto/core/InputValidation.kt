package lotto.core

import lotto.ui.Error

object InputValidation {
    fun validatePurchaseAmount(input: String): Int {
        val purchaseAmount = input.toIntOrNull() ?: throw IllegalArgumentException(lotto.ui.Error.INVALID_INPUT.message)
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000 }
        return purchaseAmount
    }

    fun validateWinningNumbersInput(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { Error.DUPLICATE_WINNING } // Numbers must be unique
        require(numbers.all { it in 1..50 }) { Error.OUT_OF_RANGE } // any number must be in range 1 - 50
        require(numbers.size == 6) { Error.INVALID_WINNING_SIZE } // Winning lotto has to be 6 numbers
    }
}
