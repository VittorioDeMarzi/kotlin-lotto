package lotto.core

import lotto.ui.Error

data class Lotto(private val numbers: Set<Int>) {
    constructor(numbers: List<Int>) : this(numbers.toSet())

    init {
        require(numbers.toSet().size == numbers.size) { lotto.ui.Error.DUPLICATE_WINNING.message } // Numbers must be unique
        require(numbers.all { it in 1..50 }) { lotto.ui.Error.OUT_OF_RANGE.message } // any number must be in range 1 - 50
        require(numbers.size == 6) { Error.INVALID_WINNING_SIZE.message } // Winning lotto has to be 6 numbers
    }

    fun countMatches(winningTicket: Lotto): Int {
        return this.numbers.intersect(winningTicket.numbers).size
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun displayLotto(): String {
        return numbers.joinToString(",", prefix = "[", postfix = "]")
    }
}
