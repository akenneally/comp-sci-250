/**
 * Programming Challenge 15: Trivia Game
 * The Question class stores data about a series of questions in the trivia game.
 */

public class Question
{
	// Constant for the number of questions
	public final int POSSIBLE_ANSWERS = 4;

	// The trivia question
	private String questionText;

	// An array to hold possible answers.
	private String possibleAnswers[] = new String[POSSIBLE_ANSWERS];

	// The number (1, 2, 3, or 4) of the correct answer.
	private int correctAnswer;

	/**
	 * No-arg constructor
	 */
	public Question()
	{
		// Initialize all fields to "" or 0;
		questionText = "";
		correctAnswer = 0;
		for (int i = 0; i < POSSIBLE_ANSWERS; i++)
			setPossibleAnswer("", i);
	}

	/**
	 * sets the question text.
	 * @param question
	 */
	public void setQuestion(String question)
	{
		questionText = question;
	}

	/**
	 * sets the answer text and the answer number.
	 * @param text
	 * @param num
	 */
	public void setPossibleAnswer(String text, int num)
	{
		possibleAnswers[num] = text;
	}

	/**
	 * sets the correct answer number.
	 * @param num
	 */
	public void setCorrectAnswerNumber(int num)
	{
		correctAnswer = num;
	}

	/**
	 * 
	 * @return returns this object's question text.
	 */
	public String getQuestionText()
	{
		return questionText;
	}

	/**
	 * 
	 * @param num
	 * @return returns one of the possible answers to this object's question.
	 */
	public String getPossibleAnswer(int num)
	{
		return possibleAnswers[num];
	}

	/**
	 * 
	 * @return returns the number of the correct answer.
	 */
	public int getCorrectAnswerNumber()
	{
		return correctAnswer;
	}

	/**
	 * 
	 * @return returns the correct answer.
	 */
	public String getCorrectAnswer()
	{
		return possibleAnswers[correctAnswer - 1];
	}
}