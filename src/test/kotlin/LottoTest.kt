import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @MethodSource("factory")
    @ParameterizedTest
    fun `lotto should have 6 numbers`(ticket: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(ticket)
        }
    }

    fun `lotto should have 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    companion object {
        @JvmStatic
        fun factory(): List<List<Int>> {
            return listOf(
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6, 7),
            )
        }
    }
}