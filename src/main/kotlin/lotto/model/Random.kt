package lotto.model

object Random {
    fun generateSetOfSixRandomNumbers(): Set<LottoNumber> {
        return (1..50).map(LottoNumber::from).shuffled().toSet()
    }
}
