package lotto.model

class LottoMachine {
    fun calculateNumberOfTickets(purchaseAmount: Int): Int {
        return purchaseAmount / 1000
    }

    fun generateListOfSixRandomNumbers(): List<Int> {
        return (1..50).shuffled().take(6)
    }

    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val listOfTickets = mutableListOf<Lotto>()
        repeat(numberOfTickets) {
            val lotto = Lotto(generateListOfSixRandomNumbers())
            listOfTickets.add(lotto)
        }
        return listOfTickets
    }

    fun generateWinningLotto(listOfInt: List<Int>): Lotto {
        return Lotto(listOfInt)
    }
}
