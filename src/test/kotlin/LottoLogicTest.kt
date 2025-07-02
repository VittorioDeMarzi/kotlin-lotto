import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LottoLogicTest {

    val lottoLogic = LottoLogic()

    @Test
    fun `calculate the right NumberOfTickets`(){
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
  
}