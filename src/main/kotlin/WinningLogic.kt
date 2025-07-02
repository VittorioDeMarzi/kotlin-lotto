class WinningLogic(private val tickets: List<Lotto>, private val winningLotto: Lotto, private val bonusNumber: Int) {

//    fun matchLottos(ticket: Lotto, winningLotto: Lotto): Int {
//        val matchingList = ticket.countMatches()
//    }


    fun determineWinningTickets(): Map<Rank, Int> {
//        val mapOfResult = mutableMapOf<Rank, Int>()

        return tickets
            .map {
                val countMatches = it.countMatches(winningLotto)
                val hasBonus = it.containsBonus(bonusNumber)
                Rank.valueOf(countMatches, hasBonus)
            }.groupingBy { it }
            .eachCount()

//        tickets.forEach {
//            val countMatches = it.countMatches(winningLotto)
//            val hasBonus = it.containsBonus(bonusNumber)
//            val rank = Rank.valueOf(countMatches, hasBonus)
//            println(rank)
//            mapOfResult.put(rank, mapOfResult.getOrDefault(rank, 0) + 1)
//        }

//        return mapOfResult
    }
}