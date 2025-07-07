package lotto.model

import lotto.view.Error

object InputValidation {
    fun validatePurchaseAmount(purchaseAmount: Int): Int {
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT.message }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000.message }
        return purchaseAmount
    }

    fun validateWinningNumbersInput(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { Error.DUPLICATE_WINNING.message } // Numbers must be unique
        require(numbers.all { it in 1..50 }) { Error.OUT_OF_RANGE.message } // any number must be in range 1 - 50
        require(numbers.size == 6) { Error.INVALID_LOTTO_SIZE.message } // Winning lotto has to be 6 numbers
    }

    fun validateBonusNumberInput(
        winningNumbers: Set<Int>,
        bonusNumberInput: Int,
    ) {
        require(bonusNumberInput in 1..50) { Error.OUT_OF_RANGE.message } // bonus number must be in range 1 - 50
        require(!winningNumbers.contains(bonusNumberInput)) { Error.BONUS.message } // bonus number must not be in the winningLotto numbers
    }
}
