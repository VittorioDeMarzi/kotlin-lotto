package lotto.model

import lotto.view.Error

data class WinningLotto(private val lotto: Lotto, private val bonusNumber: Int) {
    init {
        require(!lotto.containsBonus(bonusNumber)) { throw IllegalArgumentException(Error.BONUS.message) }
        require(bonusNumber in 1..45) { Error.BONUS_OUT_OF_RANGE }
    }

    fun countMatches(other: Lotto): Int {
        return lotto.countMatches(other)
    }

    fun isBonusMatched(lotto: Lotto): Boolean = lotto.containsBonus(bonusNumber)
}
