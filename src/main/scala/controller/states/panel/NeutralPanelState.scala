package cl.uchile.dcc.citric
package controller.states.panel

import controller.GameController
import controller.states.{ApplyingState, GameState}

/**
 * Class that represents the BonusPanelState of the game. It is a GameState.
 * @param context is the GameController of the game.
 */
class NeutralPanelState(context: GameController) extends GameState(context) {
  override def applyEffect(): Unit = {
    context.state = new ApplyingState(context)
  }
}
