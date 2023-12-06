package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/**
 * Class that represents the IdleState of the game. It is a GameState.
 * @param context is the GameController of the game.
 */
class ApplyingState(context: GameController) extends GameState(context) {
  /**
   * Method that change the game to the Norma Check state.
   */
  override def normaCheck(): Unit = {
    context.state = new CheckingNormaState(context)
  }

  /**
   * Method that begins the battle against other players or a Wild unit.
   */
  override def beginBattle(): Unit = {
    context.state = new BattleState(context)
  }

  /**
   * Method that ends the turn, changing the game to the IdleState.
   */
  override def turnEnded(): Unit = {
    context.state = new IdleState(context)
  }
}
