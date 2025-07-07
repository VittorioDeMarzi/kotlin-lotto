package lotto.model

object Random {
    fun generateListOfSixRandomNumbers(): List<Int> {
        return (1..50).shuffled().take(6)
    }
}
