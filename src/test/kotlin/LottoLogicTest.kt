import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LottoLogicTest {

    val lottoLogic = LottoLogic()

    @Test
    fun `calculate the right number of tickets`(){
        val purchaseAmount = 10000
        val rightNumberOfTickets = purchaseAmount/1000
        val numberOfTickets = lottoLogic.calculateNumberOfTickets(purchaseAmount)
        assertThat(rightNumberOfTickets).isEqualTo(numberOfTickets)
    }

    @Test
    fun `generate a list of 6 numbers`() {
        val listOfNumbers = lottoLogic.generateListOfSixRandomNumbers()
        assertThat(listOfNumbers).hasSize(6)
    }

    @Test
    fun `generate the right number of tickets`() {
        val numberOfTickets = 6
        val tickets = lottoLogic.generateTickets(numberOfTickets)
        assertThat(tickets).hasSize(numberOfTickets)
    }
}