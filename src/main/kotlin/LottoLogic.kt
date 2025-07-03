class LottoLogic {
    fun calculateNumberOfTickets(purchaseAmount: Int): Int {
        val numberOfTickets = purchaseAmount / 1000
        return numberOfTickets
    }

    fun generateListOfSixRandomNumbers(): List<Int> {
        val listOfNumbers = (1..50).shuffled().take(6)
        return listOfNumbers
    }

    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val listOfTickets = mutableListOf<Lotto>()
        repeat(numberOfTickets) {
            val lotto = Lotto(generateListOfSixRandomNumbers())
            listOfTickets.add(lotto)
        }
        return listOfTickets
    }
}
