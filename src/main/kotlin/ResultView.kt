object ResultView {
    fun displayNumberOfTickets(numberOfTickets: Int) {
        println("You have purchased $numberOfTickets tickets.")
    }

    fun displayWinningRanks() {
        println(Rank.THIRD.display())
    }
}
