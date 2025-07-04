package lotto.core

import lotto.ui.InputView
import lotto.ui.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.purchaseAmountInput()
        val lottoMachine = LottoLogic()

        val numberOfTickets = lottoMachine.calculateNumberOfTickets(purchaseAmount)
        val tickets = lottoMachine.generateTickets(numberOfTickets)

        val winningLottoString = InputView.winningNumbersInput()
        val inputValidation = InputValidation()
        val winningLottoList = inputValidation.createWinningLottoList(winningLottoString)
        val winningLotto = lottoMachine.generateWinningLotto(winningLottoList)

        val bonusNumber = InputView.bonusNumberInput()

        val result = WinningLogic(tickets, winningLotto, bonusNumber).determineWinningTickets()

        val statistics = Statistics(result, purchaseAmount)

        ResultView.displayNumberOfTickets(numberOfTickets)
        ResultView.displayTickets(tickets)
        ResultView.displayWinningRanks(result)
        ResultView.displayWinningRate(statistics.calculateRate())
    }
}
