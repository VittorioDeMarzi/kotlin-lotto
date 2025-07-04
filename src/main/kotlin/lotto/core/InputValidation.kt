package lotto.core

import lotto.ui.Error

object InputValidation {
    fun validatePurchaseAmount(input: String): Int {
        val purchaseAmount = input.toIntOrNull() ?: throw IllegalArgumentException(lotto.ui.Error.INVALID_INPUT.message)
        require(purchaseAmount >= 1000) { Error.LOW_PURCHASE_AMOUNT.message }
        require(purchaseAmount % 1000 == 0) { Error.NOT_DIVISIBLE_BY_1000.message }
        return purchaseAmount
    }

    fun createWinningLottoList(winningLottoString: String): List<Int> {
        try {
            val winningLottoList = winningLottoString.split(",").map { it.toInt() }
            require(winningLottoList.size == 6) { throw IllegalArgumentException() }

            return winningLottoList
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input")
        }
    }
}
