fun main() {
    val purchaseAmount = InputView.purchaseAmountInput()
    val lottoMachine = LottoLogic()

    val numberOfTickets = lottoMachine.calculateNumberOfTickets(purchaseAmount)
    val tickets = lottoMachine.generateTickets(numberOfTickets)

    ResultView.displayNumberOfTickets(numberOfTickets)
    ResultView.displayWinningRanks()
    ResultView.displayTickets(tickets)
}
