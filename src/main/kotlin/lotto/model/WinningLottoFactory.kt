package lotto.model

object WinningLottoFactory {
    fun from(
        listOfInt: List<Int>,
        bonusNumber: Int,
    ): WinningLotto {
        return WinningLotto(Lotto(listOfInt), bonusNumber)
    }
}
