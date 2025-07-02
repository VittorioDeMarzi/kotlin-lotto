class Lotto(private val ticket: Set<Int>) {
    constructor(ticket: List<Int>): this(ticket.toSet())


    init {
        require(ticket.size==6)
    }

    fun countMatches(winningTicket: Lotto): Int {
        return this.ticket.intersect(winningTicket.ticket).size
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return ticket.contains(bonusNumber)
    }


}