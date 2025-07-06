package lotto.controller

import lotto.model.Statistics
import lotto.model.TicketFactory
import lotto.model.WinningLogic
import lotto.model.WinningLottoFactory
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val ticketFactory: TicketFactory,
    private val winningLotto: WinningLottoFactory,
) {
    fun run() {
        val purchaseAmount = inputView.purchaseAmountInput()
        val numberOfTickets = ticketFactory.calculateNumberOfTickets(purchaseAmount)
        val tickets = ticketFactory.generateTickets(numberOfTickets)

        resultView.displayNumberOfTickets(numberOfTickets)
        resultView.displayTickets(tickets)

        val winningLottoList = inputView.winningNumbersInput()
        val bonusNumber = inputView.bonusNumberInput(winningLottoList)

        val winningLotto = winningLotto.from(winningLottoList, bonusNumber)

        val result = WinningLogic(tickets, winningLotto).determineWinningTickets()
        val statistics = Statistics(result, purchaseAmount)
        resultView.displayWinningRanks(result)
        resultView.displayWinningRate(statistics.calculateRate())
    }
}
