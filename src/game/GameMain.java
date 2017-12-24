package game;

import java.util.Scanner;

/**
 * Main method for Rock-Paper-Scissors-Lizard-Spock game.
 * 
 * JP2 Laboratory 7 2017.
 * 
 * @author mefoster
 */
public class GameMain {

	/**
	 * Prompts the user for the tournament parameters and then runs a tournament.
	 */
	public static void main(String[] args) {
		// Read everything from standard input
		Scanner stdin = new Scanner(System.in);

		// First player is always a computer
		GamePlayer player1 = new ComputerPlayer("Computer");

		// Second player may be a computer or a human
		GamePlayer player2;
		System.out.println("Enter name of human player, or empty string for two computer players");
		String name = stdin.nextLine();
		if (name.length() == 0) {
			System.out.println("Using two computer players");
			player2 = new ComputerPlayer("Computer2");
		} else {
			player2 = new HumanPlayer(name, stdin);
		}

		// Get the number of games required to win the tournament -- and be sure
		// it is a positive integer
		int numGames = -1;
		while (numGames <= 0) {
			System.out.println("Enter number of games to win: ");
			try {
				numGames = stdin.nextInt();
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
			if (numGames <= 0) {
				System.out.println("Invalid input!");
			}
		}

		// Run the tournament with the given parameters
		GamePlayer winner = playTournament(player1, player2, numGames);

		System.out.println("------------------");
		System.out.println("Overall winner is: " + winner.getName());

		stdin.close();
	}

	private static GamePlayer playTournament(GamePlayer player1, GamePlayer player2, int numGames) {

		/**
		 * Create an int array with 2 elements for the score, with 0 and 0 as start. The
		 * first element of the array is the score of player1, the second element of the
		 * array is the score of player2.
		 */

		int[] score;
		score = new int[2];
		score[0] = 0;
		score[1] = 0;

		/**
		 * While loop to see if either players' score equals the number of games that
		 * needs to be won to win the game
		 */

		while (score[0] != numGames && score[1] != numGames) {

			/**
			 * Prompt players to choose symbols
			 */

			Symbol s1 = player1.chooseSymbol();
			Symbol s2 = player2.chooseSymbol();

			/**
			 * Call addHistory for both symbols
			 */

			player1.addHistory(s1, s2);
			player1.addHistory(s2, s1);

			System.out.println(player1.getName() + " chose: " + s1.toString());
			System.out.println(player2.getName() + " chose: " + s2.toString());

			/**
			 * Call the getResult method on the chosen symbols, and update the score
			 * elements according to the result (Also write the result.)
			 */

			if (s1.getResult(s2) == GameResult.DRAW) {
				System.out.println("Draw!");
			} else if (s1.getResult(s2) == GameResult.WIN) {
				score[0]++;
				System.out.println(player1.getName() + " has won this round! Score: " + score[0] + ":" + score[1]);

			} else {
				score[1]++;
				System.out.println(player2.getName() + " has won this round! Score: " + score[0] + ":" + score[1]);

			}
		}

		/**
		 * Return the winner according to which player's score is greater after the
		 * while loop finished
		 */

		if (score[0] > score[1]) {
			return player1;
		} else {
			return player2;
		}
	}
}
