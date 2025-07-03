import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `value of first rank`() {
        val matchCount = 6
        val matchBonus = false
        val rank = Rank.valueOf(matchCount, matchBonus)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `value of second rank`() {
        val matchCount = 5
        val matchBonus = true
        val rank = Rank.valueOf(matchCount, matchBonus)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `value of third rank`() {
        val matchCount = 5
        val matchBonus = false
        val rank = Rank.valueOf(matchCount, matchBonus)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `value of fourth rank`() {
        val matchCount = 4
        val matchBonus = false
        val rank = Rank.valueOf(matchCount, matchBonus)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `value of fifth rank`() {
        val matchCount = 3
        val matchBonus = false
        val rank = Rank.valueOf(matchCount, matchBonus)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }
}
