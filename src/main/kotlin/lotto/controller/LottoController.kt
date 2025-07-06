package lotto.controller

import lotto.model.LottoLogic
import lotto.model.Statistics
import lotto.model.WinningLogic
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.purchaseAmountInput()
        val lottoMachine = LottoLogic()

        val numberOfTickets = lottoMachine.calculateNumberOfTickets(purchaseAmount)
        val tickets = lottoMachine.generateTickets(numberOfTickets)

        val winningLottoList = InputView.winningNumbersInput()
        val winningLotto = lottoMachine.generateWinningLotto(winningLottoList)

        val bonusNumber = InputView.bonusNumberInput(winningLottoList)

        val result = WinningLogic(tickets, winningLotto, bonusNumber).determineWinningTickets()

        val statistics = Statistics(result, purchaseAmount)

        ResultView.displayNumberOfTickets(numberOfTickets)
        ResultView.displayTickets(tickets)
        ResultView.displayWinningRanks(result)
        ResultView.displayWinningRate(statistics.calculateRate())
    }
}
