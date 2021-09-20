import java.util.Scanner;

/**
 * Programming Challenge 15: Trivia Game
 * The Player class stores data about a player in the trivia game.
 */

public class Player
{
	private int points;        // Player's points
	private int currentAnswer; // Current chosen answer

	/**
	 * The constructor initializes the player 
	 * number and sets points to zero.
	 */
	public Player()
	{
		points = 0;
		currentAnswer = 0;
	}

	/**
	 * The chooseAnswer method gets the player's chosen
	 * answer to the current question.
	 */
	public void chooseAnswer()
	{
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Get the user's chosen answer.
		System.out.print("Enter the number of the correct answer: ");
		currentAnswer = keyboard.nextInt();
	}

	/**
	 * @return returns the current chosen answer.
	 */
	public int getCurrentAnswer()
	{
		return currentAnswer;
	}

	/**
	 * The incrementPoints method increments the player's points.
	 */
	public void incrementPoints()
	{
		points++;
	}

	/**
	 * @return returns the player's points.
	 */
	public int getPoints()
	{
		return points;
	}

}