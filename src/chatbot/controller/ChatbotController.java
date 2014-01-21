package chatbot.controller;
import java.util.ArrayList;

import chatbot.model.ChatBotModel;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;

/**
 * Class for the user's control.
 * @author Michael Tuero
 *@version 1.2 10/23/13 adding real GUI
 */
public class ChatbotController
{
	/**
	 * Creates an instance of the chatBotView class.
	 */
	//private ChatbotView myView;
	private ChatBotModel myChatbot;
	private ChatbotFrame appFrame;
	
	
	public ChatbotController()
	{
//		myView = new ChatbotView();
		myChatbot = new ChatBotModel();
		
	}
	
	/**
	 * Starts the program for the user.
	 */
	public void start()
	{
		
//		myView.showApp();
		
		appFrame = new ChatbotFrame(this);
	}
	
	public String processMeme(String currentInput)
	{
		String memeResponse = "guess not";
		
		if(myChatbot.memeChecker(currentInput))
		{
			memeResponse = currentInput + " is a cool meme";
		}
		
		return memeResponse;
	}
	
	public String processConversation()
	{
		String currentConversation = "";
		
		currentConversation = conversationHelper(myChatbot.topicConversation());
		
		return currentConversation;
	}
	
	private String conversationHelper(ArrayList<String> conversationList)
	{
		String currentConversationPiece = "";
		
		if(conversationList.size() > 0)
		{
			currentConversationPiece = conversationList.remove(0);
			
		}
		
		return currentConversationPiece;
	}

	public ChatBotModel getMyChatbot()
	{
		return myChatbot;
	}

	public void setMyChatbot(ChatBotModel myChatbot)
	{
		this.myChatbot = myChatbot;
	}

	public ChatbotFrame getAppFrame()
	{
		return appFrame;
	}

	public void setAppFrame(ChatbotFrame appFrame)
	{
		this.appFrame = appFrame;
	}

}
