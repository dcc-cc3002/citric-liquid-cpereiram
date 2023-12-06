package cl.uchile.dcc.citric
package controller.states.panel

import controller.GameController
import controller.states.{ApplyingState, GameState}

class EncounterPanelState(context: GameController) extends GameState(context) {
  override def applyEffect(): Unit = {
    context.state = new ApplyingState(context)
  }
}
