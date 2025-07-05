package lotto.core

import lotto.ui.Error

class WinningLotto(val lotto: Lotto, val bonusNumber: Int) {
    init {
        require(!lotto.containsBonus(bonusNumber)) { throw IllegalArgumentException(Error.BONUS.message) }
    }
}
