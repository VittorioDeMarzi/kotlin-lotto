package lotto.ui

object InputView {
    fun purchaseAmountInput(): Int {
        println("Please enter the purchase amount.")
        val purchaseAmount =
            readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
        return purchaseAmount
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
