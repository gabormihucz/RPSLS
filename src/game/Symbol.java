package game;

/**
 * @author Gabor Mihucz 2239495M
 */

/**
 * Creation of the enum type Symbol with 5 constants
 */

public enum Symbol {
	ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

	/**
	 * This method will be used to decide which one of the two opponents won.
	 */

	public GameResult getResult(Symbol opponent) {

		/**
		 * If the current instance of the enum type is the same as the argument that
		 * this method received, return DRAW
		 */

		if (this.equals(opponent)) {
			return GameResult.DRAW;
		} else {

			/**
			 * Else consider each case separately depending on the current Symbol and the
			 * opponent's Symbol in order to return WIN or LOSE
			 */

			switch (this) {
			case ROCK:
				if (opponent.equals(SCISSORS) || opponent.equals(LIZARD)) {
					return GameResult.WIN;
				} else {
					return GameResult.LOSE;
				}
			case PAPER:
				if (opponent.equals(ROCK) || opponent.equals(SPOCK)) {
					return GameResult.WIN;
				} else {
					return GameResult.LOSE;
				}
			case SCISSORS:
				if (opponent.equals(PAPER) || opponent.equals(LIZARD)) {
					return GameResult.WIN;
				} else {
					return GameResult.LOSE;
				}
			case LIZARD:
				if (opponent.equals(SPOCK) || opponent.equals(PAPER)) {
					return GameResult.WIN;
				} else {
					return GameResult.LOSE;
				}
			case SPOCK:
				if (opponent.equals(SCISSORS) || opponent.equals(ROCK)) {
					return GameResult.WIN;
				} else {
					return GameResult.LOSE;
				}

			}
		}

		return null;
	}
}
