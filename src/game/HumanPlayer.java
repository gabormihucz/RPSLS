package game;

import java.util.Scanner;

/**
 * 
 * @author Gabor Mihucz 2239495M
 *
 */

/**
 * Creating the class HumanPlayer which is a subclass of GamePlayer
 */

public class HumanPlayer extends GamePlayer {

	/**
	 * HumanPlayer is created with a Scanner object, and a String name which is
	 * inherited from GamePlayer
	 */

	private Scanner input;

	public HumanPlayer(String name, Scanner stdin) {
		super(name);
		input = stdin;
	}

	@Override
	public Symbol chooseSymbol() {

		/**
		 * Prompt user to enter a valid input
		 */

		boolean valid = false;
		while (!valid) {
			System.out.println("Please enter one of the following values: ROCK, PAPER, SCISSORS, LIZARD, SPOCK");
			String userInput = input.next();

			/**
			 * Check each Symbol, if the Symbol's name equals the userInput, end the loop,
			 * and return the symbol that matches the user input
			 */

			for (Symbol sym : Symbol.values()) {
				if (sym.name().equals(userInput)) {
					valid = true;
					return sym;

				}

			}
		}

		return null;
	}

}
