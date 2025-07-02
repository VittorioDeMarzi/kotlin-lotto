class InputView {

    fun purchaseAmountInput(): String? {
        val purchaseAmount = readlnOrNull()
        return purchaseAmount
    }

    fun winningNumbersInput(): String? {
        val winningNumbers = readlnOrNull()
        return winningNumbers
    }

    fun bonusNumberInput(): String? {
        val bonusNumber = readlnOrNull()
        return bonusNumber
    }
}