package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.InvalidTransitionException

/** Represents a state in the game's state machine, providing a base class for different game states.
 * This class forms part of the State design pattern, where it encapsulates the behavior associated
 * with a specific state of the [[GameController]].
 *
 * Upon instantiation, [[GameState]] automatically sets itself as the current state in the provided
 * [[GameController]] context. This class provides a skeletal implementation for game states, including
 * methods for performing actions and transitioning to other states. The specific behaviors and transitions
 * are meant to be defined in subclasses representing concrete states of the game.
 *
 * @constructor Initializes a new game state and sets it as the current state in the provided GameController context.
 * @param context The GameController that this state is associated with.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @author [[https://www.github.com/zelcris Cristóbal Pereira M.]]
 * @since 2023O.1
 * @version 2023P
 */
class GameState protected(val context: GameController) {
  context.state = this

  /**
   * Method that throws an InvalidTransitionException.
   * @param targetState The state that the game is trying to transition to.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"Can't transition from ${this.getClass.getSimpleName} to $targetState")
  }

  /**
   * Method that starts the game.
   */
  def startGame(): Unit = {
    transitionError("StartingState")
}

  /**
   * Method that rolls the dice.
   */
  def rollDice(): Unit = {
    transitionError("ChoicePanelState")
  }

  /**
   * Method that applies the effect of the current panel.
   */
  def applyEffect(): Unit = {
    transitionError("ApplyingState")
  }

  /**
   * Method that makes a transition to the BonusPanelState.
   */
  def chooseBonusPanel(): Unit = {
    transitionError("BonusPanelState")
  }

  /**
   * Method that makes a transition to the DropPanelState.
   */
  def chooseDropPanel(): Unit = {
    transitionError("DropPanelState")
  }

  /**
   * Method that makes a transition to the EncounterPanelState.
   */
  def chooseEncounterPanel(): Unit = {
    transitionError("EncounterPanelState")
  }

  /**
   * Method that makes a transition to the HomePanelState.
   */
  def chooseHomePanel(): Unit = {
    transitionError("HomePanelState")
  }

  /**
   * Method that makes a transition to the NeutralPanelState.
   */
  def chooseNeutralPanel(): Unit = {
    transitionError("NeutralPanelState")
  }

  /**
   * Method that moves the player to the next panel.
   */
  def nextTurn(): Unit = {
    transitionError("PlayerState")
  }

  /**
   * Method that ends the turn.
   * Could be called in three different situations:
   * - When the player end the turn.
   * - When the player ends a battle.
   * - When the player ends a norma check, without winning.
   */
  def turnEnded(): Unit = {
    transitionError("IdleState")
  }

  /**
   * Method that change the game to the GameOverState.
   */
  def endGame(): Unit = {
    transitionError("GameOverState")
  }

  /**
   * Method that change the game to the StatingState.
   */
  def newGame(): Unit = {
    transitionError("StartingState")
  }

  /**
   * Method that change the game to the Norma Check state.
   */
  def normaCheck(): Unit = {
    transitionError("CheckingNormaState")
  }

  /**
   * Method that begins the battle against other players or a Wild unit.
   */
  def beginBattle(): Unit = {
    transitionError("BattleState")
  }

}
