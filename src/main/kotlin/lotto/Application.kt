package lotto

import lotto.controller.LottoController
import lotto.model.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoGame = LottoController(InputView, ResultView, LottoMachine())
    lottoGame.run()
}
