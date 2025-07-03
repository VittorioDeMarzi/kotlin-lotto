package lotto.ui

object InputView {
    fun purchaseAmountInput(): Int {
        println("Please enter the purchase amount.")
        val purchaseAmount =
            readln().toIntOrNull() ?: throw IllegalArgumentException("The purchase amount has to be a valid number.")
        return purchaseAmount
    }

    fun winningNumbersInput(): String? {
        println("Please enter last week’s winning numbers.")
        val winningNumbers = readlnOrNull()
        return winningNumbers
    }

    fun bonusNumberInput(): String? {
        println("Please enter the bonus number.")
        val bonusNumber = readlnOrNull()
        return bonusNumber
    }
}
