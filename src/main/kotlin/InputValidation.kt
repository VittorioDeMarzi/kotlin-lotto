class InputValidation {
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
