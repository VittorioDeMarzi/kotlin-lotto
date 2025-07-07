package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.TicketFactory
import lotto.model.WinningLogic
import lotto.model.WinningLotto
import lotto.model.WinningLottoFactory
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val ticketFactory: TicketFactory,
    private val winningLotto: WinningLottoFactory,
    private val winningLogic: WinningLogic,
) {
    fun run() {
        val purchaseAmount = inputView.purchaseAmountInput()
        val tickets = handlePurchase(purchaseAmount)
        val winningLotto = handleWinningLotto()
        val result = WinningLogic.determineWinningTickets(tickets, winningLotto)
        val profitRate = result.calculateProfitRate()
        resultView.displayWinningStatistics(result, profitRate)
    }

    fun handlePurchase(purchaseAmount: Int): List<Lotto> {
        val numberOfTickets = ticketFactory.calculateNumberOfTickets(purchaseAmount)
        val tickets = ticketFactory.generateTickets(numberOfTickets)
        resultView.displayNumberOfTickets(numberOfTickets)
        resultView.displayTickets(tickets)

        return tickets
    }

    fun handleWinningLotto(): WinningLotto {
        val winningLottoList = inputView.winningNumbersInput()
        val bonusNumber = LottoNumber.from(inputView.bonusNumberInput(winningLottoList))
        val winningLotto = winningLotto.from(winningLottoList, bonusNumber)
        return winningLotto
    }
}
