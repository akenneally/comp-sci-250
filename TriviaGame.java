import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/**
 * Programming Challenge 15: Trivia Game
 * This program demonstrates the trivia game.
 *
 * Create a simple trivia game for two players
 * Starting with player 1, each player gets a turn at answering 5 trivia questions
 * (There are a total of 10 questions, 5 for each player)
 *
 * When a question is displayed, four possible answers are also displayed.
 * Only one of the answers is correct,
 * and if the player selects the correct answer, he or she earns a point.
 *
 * After answers have been selected for all the questions,
 * the program displays the number of points earned by each player and
 * declares the player with the highest number of points the winner.
 */

public class TriviaGame
{
	// Constants
	private static final int NUM_QUESTIONS = 10;
	private static final int NUM_PLAYERS = 2;
	
	public static void main(String args[]) throws IOException
	{
		// Variables
		int playerTurn = 1;    // The current player

		// Create an array of Player objects for player #1 and player #2.
		ArrayList<Player> players = new ArrayList<>();
		for (int i = 0; i < NUM_PLAYERS; i++)
		{
			players.add(new Player());
		}

		// Create an array to hold Question objects.
		ArrayList<Question> questions = new ArrayList<>();

		// Initialize the array with data.
		initQuestions(questions);

		// Play the game.
		for (Question q: questions)
		{
			// Display the question.
			displayQuestion(q, playerTurn);

			// Get the player's answer.
			players.get(playerTurn - 1).chooseAnswer();

			// See if the correct answer was chosen.
			if (players.get(playerTurn - 1).getCurrentAnswer() == q.getCorrectAnswerNumber())
			{
				// The player's chosen answer is correct.
				System.out.println("Correct!\n");
				players.get(playerTurn - 1).incrementPoints();
			}
			else
			{
				// The player chose the wrong answer.
				System.out.println("Sorry, that is incorrect. The correct " + "answer is " + 
						q.getCorrectAnswerNumber() + ": " + q.getCorrectAnswer() + ".\n");
			}
			// Switch players for the next iteration.
			if (playerTurn == 1)
				playerTurn = 2;
			else
				playerTurn = 1;
		}

		// Show the game results.
		showGameResults(players);
	}

	/**
	 * The initQuestions method uses the contents of the
	 * "Trivia.txt" file to populate the qArray parameter with Question objects.
	 * @param qArrayList
	 */
	public static void initQuestions(ArrayList<Question> qArrayList) throws IOException
	{
		// Open the trivia.txt file.
		File file = new File("Trivia.txt");
		Scanner inputFile = new Scanner(file);

		// Populate the qArrayList with data from the file.
		for (int i = 0; i < NUM_QUESTIONS; i++)
		{
			// Create a Question object in the array.
			qArrayList.add(new Question());

			// Get the question text from the file.
			qArrayList.get(i).setQuestion(inputFile.nextLine());

			// Get the possible answers.
			for (int j = 0; j < 4; j++)
			{
				qArrayList.get(i).setPossibleAnswer(inputFile.nextLine(), j);
			}

			// Get the correct answer.
			qArrayList.get(i).setCorrectAnswerNumber(Integer.parseInt(inputFile.nextLine()));
		}
	}

	/**
	 * The displayQuestion method displays a question.
	 */
	public static void displayQuestion(Question q, int playerNum)
	{
		// Display the player number.
		System.out.println("Question for player #" + playerNum);
		System.out.println("------------------------");

		// Display the question.
		System.out.println(q.getQuestionText());
		for (int i = 0; i < 4; i++)
		{
			System.out.println((i+1) + ". " + q.getPossibleAnswer(i));
		}
	}

	/**
	 * The showGameResults method shows the game results.
	 * @param players
	 */

	public static void showGameResults(ArrayList<Player> players)
	{
		// Display the stats.
		System.out.println("Game Over!");
		System.out.println("---------------------");
		System.out.println("Player 1's points: " + players.get(0).getPoints());
		System.out.println("Player 2's points: " + players.get(1).getPoints());

		// Declare the winner.
		if (players.get(0).getPoints() > players.get(1).getPoints())
			System.out.println("Player 1 wins!");
		else if (players.get(1).getPoints() > players.get(0).getPoints())
			System.out.println("Player 2 wins!");
		else
			System.out.println("It's a TIE!");
	}
}