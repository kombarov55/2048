package model

import view.Controller
import view.KeyEventSender
import view.MainFrame


class GameInstance: Runnable {

    override fun run() {
        val model = Game()
        val controller = Controller()
        val ui = MainFrame()
        val keyEventSender = KeyEventSender(controller)

        wireComponents(model, controller, ui, keyEventSender)

        while (!controller.isGameOver);
    }

    fun wireComponents(game: Game, controller: Controller, mainFrame: MainFrame, keyEventSender: KeyEventSender) {
        controller.setGame(game)
        controller.setUI(mainFrame)
        mainFrame.setKeyListener(keyEventSender)
        mainFrame.setController(controller)
    }
}