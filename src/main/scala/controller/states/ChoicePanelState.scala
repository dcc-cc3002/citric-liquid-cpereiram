package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.controller.states.panel.{BonusPanelState, DropPanelState, EncounterPanelState, HomePanelState, NeutralPanelState}

/**
 * Class that represents the state of the game when the player is choosing a panel.
 * @param context the context of the game.
 */
class ChoicePanelState(context: GameController) extends GameState(context) {
  /**
   * Method that makes a transition to the BonusPanelState.
   */
  override def chooseBonusPanel(): Unit = {
    context.state = new BonusPanelState(context)
  }

  /**
   * Method that makes a transition to the DropPanelState.
   */
  override def chooseDropPanel(): Unit = {
    context.state = new DropPanelState(context)
  }

  /**
   * Method that makes a transition to the EncounterPanelState.
   */
  override def chooseEncounterPanel(): Unit = {
    context.state = new EncounterPanelState(context)
  }

  /**
   * Method that makes a transition to the HomePanelState.
   */
  override def chooseHomePanel(): Unit = {
    context.state = new HomePanelState(context)
  }

  /**
   * Method that makes a transition to the NeutralPanelState.
   */
  override def chooseNeutralPanel(): Unit = {
    context.state = new NeutralPanelState(context)
  }
}
