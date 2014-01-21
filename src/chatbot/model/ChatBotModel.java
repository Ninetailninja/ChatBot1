package chatbot.model;

import java.util.ArrayList;

/**
 *Creates the objects for the chatbot. 
 * @author Michael Tuero
 *@version 1.4 10/15/13
 *
 */
public class ChatBotModel
{
	private ArrayList<String> conversationList;
	
	/**
	 * A String array of memes.
	 */
	private ArrayList<String> myMemes;
	/**
	 * An array list of random phrases.
	 */
	private ArrayList<String> randomList;
	/**
	 * A String array of things that has the properties of a Manuel.
	 */
	private ArrayList<String> manuel;
	
	/**
	 * The constructor of the Chatbot, initializes values and creates objects.
	 */
	public ChatBotModel()
	{
		myMemes = new ArrayList<String>();
		manuel = new ArrayList<String>();
		randomList = new ArrayList<String>();
		conversationList = new ArrayList<String>();
		
		fillTheConversationList();
		fillTheRandomList();
		fillTheList();
		fillManuel();
	}
	/**
	 * check to see if the input contains "batman".
	 * @param currentInput- what the user typed in.
	 * @return if "batman" was in the input, then return "I am the true Batman", otherwise return "OK why not."
	 */
	public String containsMethod(String currentInput)
	{
		String batman = "I am the true Batman";
		String otherWise = "OK why not.";
		
		if (currentInput.contains("batman"))
		{
			return batman;
		}
		
		return otherWise;
	}
	
	/**
	 * Alphabetizes the first middle and last names the user typed in.
	 * @param first - The first name.
	 * @param middle - The middle name.
	 * @param last - The last name.
	 * @return - the name in alphabetical order.
	 */
	public String alphabetizeYourName(String first, String middle, String last)
	{
		String nameInOrder = "";
		
		//checks if first is before middle
		if(first.compareTo(middle) < 0)
		{
			//checks if first is before last
			if(first.compareTo(last) < 0)
			{
				//checks if middle is before last
				if(middle.compareTo(last) < 0)
				{
					nameInOrder = first + ", " + middle + ", " + last;
				}
				else //last is before middle
				{
					nameInOrder = first + ", " + last + ", " + middle;
				}
			}
			else //last is before first
			{
				nameInOrder = last + ", " + first + ", " + middle;
			}
		}
		else //middle is before first
		{
			//checks if middle is before last
			if (middle.compareTo(last) < 0)
			{
				//checks if first is before last
				if(first.compareTo(last) < 0)
				{
					nameInOrder = middle + "," + first + "," + last;
				}
				else // last is before first
				{
					nameInOrder = middle + "," + last + "," + first;
				}
			}
			else //last is before middle
			{
				nameInOrder = last + "," + middle + "," + first;
			}
		}
		
		return nameInOrder;
	}
	/**
	 * gets a random phrase from the array list RandomList.
	 * @return - A random phrase from RandomList.
	 */
	public ArrayList<String> getRandomList()
	{
		return randomList;
	}
	/**
	 * sets the amount of phrases for the RandomList.
	 * @param randomList
	 */
	public void setRandomList(ArrayList<String> randomList)
	{
		this.randomList = randomList;
	}
	/**
	 * gets the Memes from myMemes array list.
	 * @return - myMemes.
	 */
	public ArrayList<String> getMyMemes()
	{
		return myMemes;
	}
	/**
	 * sets the values for the random list phrases.
	 */
	private void fillTheRandomList()
	{
		randomList.add("I like cheese");
		randomList.add("I hate essays");
		randomList.add("I like cereal");
		randomList.add("This is random");
		randomList.add("I like typing");
		
	}
	
	/**
	 * gets a random item from the randomList.
	 * @return A random element from the randomList.
	 */
	public String getRandomPhrase()
	{
		String randomPhrase = "";
		double myRandom = Math.random();
		int myRandomListPos = (int) (myRandom * randomList.size());
		
		randomPhrase = randomList.get(myRandomListPos);
		
		return randomPhrase;
	}
	
	/**
	 * Adds the Strings to the list of Memes.
	 */
	private void fillTheList()
	{
		myMemes.add("nicolas cage");
		myMemes.add("Arrow to the knee");
		myMemes.add("one does not simply");
		myMemes.add("y u no");
	}
	
	/**
	 * Adds the Strings to the list of Manuel.
	 */
	private void fillManuel()
	{
		manuel.add("Pony");
		manuel.add("Rainbows");
		manuel.add("meatbell");
		manuel.add("magikarp");
		manuel.add("Hello Kitty");
	}
	
	/**
	 * Checks to see if user input matched a string from the Manuel list.
	 * @param input - the user input.
	 * @return - returns true if input matched a Manuel phrase.
	 */
	public boolean manuelChecker(String input)
	{
		boolean isManuel = false;
		
		for(String currentPhrase : manuel)
		{
			if (input.contains(currentPhrase))
			{
				isManuel = true;
			}
		
		}
		
		return isManuel;
	}
	
	/**
	 * Checks the input to see if matches a String from the Meme list.
	 * @param input - The user input.
	 * @return - Returns whether or not the input matched a String from the Meme list.
	 */
	public boolean memeChecker(String input)
	{
		boolean hasMeme = false;
		
		//loop over all items to check if input is a meme.
		if(input != null)
		{
			
		for(String currentPhrase : myMemes)
			{
				if (currentPhrase.equalsIgnoreCase(input))
				{
					hasMeme = true;
				}
			
			}
		}
		return hasMeme;
	}
	private void fillTheConversationList()
	{
		conversationList.add("\n Hey I want to talk about 42");
		conversationList.add("\n Hey I want to talk about 17");
		conversationList.add("\n Hey I want to talk about 420");
	}
	
	public ArrayList<String> topicConversation()
	{
		return conversationList;
		
	}
	
}
