package cl.uchile.dcc.citric
package exceptions

/**
 * Custom exception to signal an invalid transition encountered.
 * @param details A descriptive message detailing the nature of the invalid transition.
 */
class InvalidTransitionException(details: String) extends Exception(details) {
}
