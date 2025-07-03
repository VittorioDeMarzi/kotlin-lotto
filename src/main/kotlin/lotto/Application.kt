package lotto

import lotto.core.LottoLogic
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val purchaseAmount = InputView.purchaseAmountInput()
    val lottoMachine = LottoLogic()

    val numberOfTickets = lottoMachine.calculateNumberOfTickets(purchaseAmount)
    val tickets = lottoMachine.generateTickets(numberOfTickets)

    val winningLotto = InputView.winningNumbersInput()

    ResultView.displayNumberOfTickets(numberOfTickets)
    ResultView.displayWinningRanks()
    ResultView.displayTickets(tickets)
}
