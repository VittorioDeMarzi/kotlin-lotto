package lotto

import lotto.controller.LottoController
import lotto.model.LottoLogic
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoGame = LottoController(InputView, ResultView, LottoLogic())
    lottoGame.run()
}
