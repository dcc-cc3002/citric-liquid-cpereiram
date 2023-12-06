package cl.uchile.dcc.citric
package controller

import controller.states.{GameState, StartingState}

import cl.uchile.dcc.citric.model.character.PlayerCharacter

import scala.util.Random

/**
 * Class that represents the controller of the game.
 * It has all the methods that can be called in the game.
 *
 * @constructor Creates a new game controller, setting up initial game state, player order and board.
 */
class GameController {
  /** The current state of the game. */
  var state: GameState = new StartingState(this)

  /** 4-Tuple with the players of the game. */
  private val players = List.empty[PlayerCharacter]

  // /** Extraction of players from the tuple. */
  // private val (p1, p2, p3, p4) = players

  // /** Shuffled list of the players with the order to play. */
  // private val playerOrder: List[PlayerCharacter] = Random.shuffle(List(p1, p2, p3, p4))

  /** The current chapter of the game. It initialize in 1. */
  private var currentChapter: Int = 1

  /** The current turn of the game. It initialize in 1. */
  private var currentTurn: Int = 1

  /** Index of the player who is playing currently. */
  private var currentPlayerIndex: Int = 0



}
