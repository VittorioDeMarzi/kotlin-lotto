

class Lotto(val ticket: Set<Int>) {
    constructor(ticket: List<Int>): this(ticket.toSet())

    init {
        require(ticket.size==6)
    }
}