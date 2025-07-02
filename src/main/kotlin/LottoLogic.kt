import kotlin.random.Random

class LottoLogic {

    fun calculateNumberOfTickets(purchaseAmount: Int): Int{
       val numberOfTickets = purchaseAmount/1000
       return numberOfTickets
    }

    fun generateListOfSixRandomNumbers(): List<Int> {
        val listOfNumbers = List(size = 6) { Random.nextInt(50)}
        return listOfNumbers
    }

}
