package lotto.model

import lotto.view.Error

data class Lotto(private val numbers: Set<Int>) {
    constructor(numbers: List<Int>) : this(numbers.toSet())

    init {
        require(numbers.all { it in 1..50 }) { Error.OUT_OF_RANGE.message } // any number must be in range 1 - 50
        require(numbers.size == 6) { Error.INVALID_LOTTO_SIZE.message } // Lotto has to be 6 numbers
    }

    fun countMatches(winningTicket: Lotto): Int {
        return this.numbers.intersect(winningTicket.numbers).size
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun getLottoNumbers(): Set<Int> {
        return numbers
    }
}
