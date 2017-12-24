package game;

import java.util.ArrayList;

/**
 * @author Gabor Mihucz 2239495M
 */

/**
 * Creating the abstract class GamePlayer
 * Fields: 'name' and static Symbol
 * ArrayLists: 'myHistory', 'otherHistory', for the chosen symbols for the two opponents
 */

public abstract class GamePlayer {

	private String name;
	protected static ArrayList<Symbol> myHistory = new ArrayList<Symbol>();
	protected static ArrayList<Symbol> otherHistory = new ArrayList<Symbol>();

	/**
	 * Constructor for the class. The class can be created with a String 'name'
	 */

	public GamePlayer(String name) {
		this.name = name;
	}

	/**
	 * Getter and Setter for 'name'
	 */

	public String getName() {
		return this.name;

	}

	public void setName(String name) {
		this.name = name;

	}

	/**
	 * The addHistory method that will add the current player's chosen Symbol and
	 * the opponent's chosen Symbol to the corresponding ArrayLists
	 */

	public void addHistory(Symbol mySymbol, Symbol otherSymbol) {
		GamePlayer.myHistory.add(mySymbol);
		GamePlayer.otherHistory.add(otherSymbol);
	}

	/**
	 * The abstract class chooseSymbol, which will be overridden by the subclasses 'HumanPlayer' and 'ComputerPlayer'
	 */
	
	public abstract Symbol chooseSymbol();

}
