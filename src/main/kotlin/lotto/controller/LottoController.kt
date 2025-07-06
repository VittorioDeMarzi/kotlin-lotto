package lotto.controller

import lotto.model.LottoMachine
import lotto.model.Statistics
import lotto.model.WinningLogic
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val lottoMachine: LottoMachine,
) {
    fun run() {
        val purchaseAmount = inputView.purchaseAmountInput()

        val numberOfTickets = lottoMachine.calculateNumberOfTickets(purchaseAmount)
        val tickets = lottoMachine.generateTickets(numberOfTickets)

        val winningLottoList = inputView.winningNumbersInput()
        val winningLotto = lottoMachine.generateWinningLotto(winningLottoList)

        val bonusNumber = InputView.bonusNumberInput(winningLottoList)

        val result = WinningLogic(tickets, winningLotto, bonusNumber).determineWinningTickets()

        val statistics = Statistics(result, purchaseAmount)

        resultView.displayNumberOfTickets(numberOfTickets)
        resultView.displayTickets(tickets)
        resultView.displayWinningRanks(result)
        resultView.displayWinningRate(statistics.calculateRate())
    }
}
