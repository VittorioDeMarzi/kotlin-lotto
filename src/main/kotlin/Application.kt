fun main() {
    val purchaseAmount = InputView.purchaseAmountInput()
    val lottoMachine = LottoLogic()

    val numberOfTickets = lottoMachine.calculateNumberOfTickets(purchaseAmount)

    ResultView.displayNumberOfTickets(numberOfTickets)
    ResultView.displayWinningRanks()
}
