package game;

import java.util.Collections;
import java.util.Map;
import java.util.stream.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

/**
 * 
 * @author Gabor Mihucz 2239495M
 *
 */

public class ComputerPlayer extends GamePlayer {

	public ComputerPlayer(String name) {
		super(name);
	}

	@Override
	public Symbol chooseSymbol() {

		/**
		 * Creating a Map with Symbols as keys, and a List of Symbols as values
		 */

		Map<Symbol, List<Symbol>> defeatMap = new HashMap<Symbol, List<Symbol>>() {

			/**
			 * Each Symbol-key will get a value of a 2-element list, containing the symbols
			 * that defeat it
			 */

			{
				List<Symbol> defeatedBy = Arrays.asList(Symbol.ROCK, Symbol.SCISSORS);
				put(Symbol.LIZARD, defeatedBy);
			}
			{
				List<Symbol> defeatedBy = Arrays.asList(Symbol.LIZARD, Symbol.PAPER);
				put(Symbol.SPOCK, defeatedBy);
			}
			{
				List<Symbol> defeatedBy = Arrays.asList(Symbol.SPOCK, Symbol.PAPER);
				put(Symbol.ROCK, defeatedBy);
			}
			{
				List<Symbol> defeatedBy = Arrays.asList(Symbol.ROCK, Symbol.SPOCK);
				put(Symbol.SCISSORS, defeatedBy);
			}
			{
				List<Symbol> defeatedBy = Arrays.asList(Symbol.LIZARD, Symbol.SCISSORS);
				put(Symbol.PAPER, defeatedBy);
			}
		};

		/**
		 * Creating a map of symbols as keys, and Long numbers as values that show how
		 * many times each symbol appears in the opponent's History (arraylist) (e -> e
		 * is the identity function, hence each key is mapped to itself
		 * Collectors.counting() counts how many times each key appears in the list)
		 */

		Map<Symbol, Long> counted = GamePlayer.otherHistory.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		Symbol mostUsedSymbol;

		/**
		 * If the map of symbols with their frequencies is empty, choose a random symbol
		 */

		if (counted.isEmpty()) {
			Random rand = new Random();
			int n = rand.nextInt(5);
			List<Symbol> pickAtRandom = Arrays.asList(Symbol.ROCK, Symbol.SCISSORS, Symbol.PAPER, Symbol.SPOCK,
					Symbol.LIZARD);
			return pickAtRandom.get(n);

		}
		/**
		 * Otherwise, get the Symbol that appears the most in the map
		 */
		else {
			mostUsedSymbol = Collections
					.max(counted.entrySet(),
							(entry1, entry2) -> entry1.getValue().intValue() - (int) entry2.getValue().intValue())
					.getKey();
			/**
			 * If the most used symbol appears once, return a random symbol
			 */
			if (counted.get(mostUsedSymbol) == 1) {
				Random rand = new Random();
				int n = rand.nextInt(5);
				List<Symbol> pickAtRandom = Arrays.asList(Symbol.ROCK, Symbol.SCISSORS, Symbol.PAPER, Symbol.SPOCK,
						Symbol.LIZARD);
				return pickAtRandom.get(n);
			} else {

				/**
				 * Otherwise, return a random symbol from the two that defeats the opponent's
				 * most used symbol
				 */

				Random rand = new Random();
				int n = rand.nextInt(2);
				System.out.println(n);
				for (Symbol sym : Symbol.values()) {

					if (mostUsedSymbol.equals(sym)) {
						return defeatMap.get(mostUsedSymbol).get(n);
					}
				}

			}
			return null;

		}

	}
}