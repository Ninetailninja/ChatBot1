package chatbot.view;

import chatbot.model.ChatBotModel;
import javax.swing.JOptionPane;

/**
 * Creates what the user can see during the program.
 * @author Michael Tuero
 *@version 1.4 10/15/13
 */
public class ChatbotView
{
	/**
	 * Creates a chatbot model to access the class.
	 */
	private ChatBotModel chatbot;
	/** 
	 * boolean used to determine if the conversations over or not.
	 */
	boolean end;
	
	
	public ChatbotView()
	{
		chatbot = new ChatBotModel();
		
	}
	
	/**
	 * Starts the program by asking if you want to talk.
	 */
	public void showApp()
	{
		String answer = "keep going";
		
		while(answer == null || !answer.equalsIgnoreCase("no"))
		{
			JOptionPane.showMessageDialog(null, chatbot.getRandomPhrase());
			answer = getInput();
			useInput(answer);
			
		}
		
	}
	
	/**
	 * gets the input from the user.
	 * @return - Returns the user's input for use.
	 */
	private String getInput()
	{
		String input;
		
		input = JOptionPane.showInputDialog("Do you want to talk?");
		return input;
	}
	
	/**
	 * uses input to start a conversation and check for memes or Manuel.
	 * @param input - The user input.
	 */
	private void useInput(String input)
	{
		if (chatbot.memeChecker(input) == true)
		{
			JOptionPane.showMessageDialog(null, "Crazy kids and your loud rap music.");
		}
		else if (chatbot.manuelChecker(input) == true)
		{
			JOptionPane.showMessageDialog(null, "Are you a Manuel?");
		}
		else if (input.equalsIgnoreCase("no"))
			JOptionPane.showMessageDialog(null, "Seriously? Ok bye.");
		else
			conversation(input);
	}
	
	/**
	 * Enhances the conversation further.
	 * @param input - The user input.
	 * @return - Return that the conversation is over.
	 */
	private boolean conversation(String input)
	{
		
		String name = "";
		String boyGirl = "";
		String videoGame = "";
		String likeGame = "";
		String likeToDo = "";
		String color = "";
		if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("sure"))
		{
			name = JOptionPane.showInputDialog("Cool what's your name?");
			boyGirl = JOptionPane.showInputDialog("Cool, are you a boy or a girl?");
		}
		if (boyGirl.equalsIgnoreCase("boy"))
		{
			likeGame = JOptionPane.showInputDialog("That's cool. Do you like videogames?");
			if (likeGame.equalsIgnoreCase("yes"))
			{
				videoGame = JOptionPane.showInputDialog("What's your favorite game?");
				likeToDo = JOptionPane.showInputDialog(videoGame + " is a fantastic game! \n What else do you like to do?");
				JOptionPane.showMessageDialog(null, "Cool I " + likeToDo + " also, but only on the weekends.");
				JOptionPane.showMessageDialog(null, "Well it was great talking to you I will talk to you again later. \n Goodbye.");
			}
			else
			{
				likeToDo = JOptionPane.showInputDialog("Lame, so what do you like to do then?");
				JOptionPane.showMessageDialog(null, "Cool I " + likeToDo + " also, but only on the weekends.");
				JOptionPane.showMessageDialog(null, "Well it was great talking to you " +name+ " I will talk to you again later. \n Goodbye.");
				
			}
		}
		else if (boyGirl.equalsIgnoreCase("girl"))
		{
			likeToDo = JOptionPane.showInputDialog("Coolio, what do you like to do?");
			color = JOptionPane.showInputDialog("That sounds funn. :) What's your favorite color?");
			JOptionPane.showMessageDialog(null, "Cool " + color + " is a nice color.");
			JOptionPane.showMessageDialog(null, "Well it was great talking with you " +name+ " but I have to go now have funn! :)");
			
		}
		return end = true;
		
	}
}
