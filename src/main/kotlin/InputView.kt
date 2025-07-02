class InputView {

    fun purchaseAmountInput(): String? {
        println("Please enter the purchase amount.")
        val purchaseAmount = readlnOrNull()
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