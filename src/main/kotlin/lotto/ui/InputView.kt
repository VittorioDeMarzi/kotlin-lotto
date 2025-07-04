package lotto.ui

object InputView {
    fun purchaseAmountInput(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount:")
                val purchaseAmount = readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
                require(purchaseAmount >= 1000) { throw IllegalArgumentException(Error.LOW_PURCHASE_AMOUNT.message) }
                require(purchaseAmount % 1000 == 0) { throw IllegalArgumentException(Error.NOT_DIVISIBLE_BY_1000.message) }
                return purchaseAmount
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    fun winningNumbersInput(): String {
        println("Please enter last week’s winning numbers.")
        val winningNumbers = readlnOrNull() ?: throw IllegalArgumentException("Invalid input")
        return winningNumbers
    }

    fun bonusNumberInput(): Int {
        println("Please enter the bonus number.")
        val bonusNumber = readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
        return bonusNumber
    }
}
