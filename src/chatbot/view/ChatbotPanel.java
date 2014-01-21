package chatbot.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotController;
import chatbot.model.ChatBotModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotPanel extends JPanel
{

	private ChatbotController baseController;
	private JButton submitButton;
	private JTextField userInputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	private ChatBotModel appBot;
	private JScrollPane textPane;
	private int clickCount;
	
	public ChatbotPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getMyChatbot();
		submitButton = new JButton("Submit this to the Chatbot!");
		userInputField = new JTextField(30);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.SOUTH, userInputField, -17, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 138, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -25, SpringLayout.SOUTH, this);
		textPane = new JScrollPane(chatArea);
		clickCount = 0;
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		startChat();
	}
	
	private void startChat()
	{
		chatArea.setText(appBot.getRandomPhrase());
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(userInputField);
		this.add(textPane);
		chatArea = new JTextArea(10, 30);
		userInputField.setSize(10, 15);
		baseLayout.putConstraint(SpringLayout.NORTH, userInputField, 47, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, userInputField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, 165, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		add(chatArea);
		
		
		
		
		
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
	}
	
	private void setupLayout()
	{
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String currentInput = userInputField.getText();
				
				if(clickCount % 7 == 0)
				{
					String currentConversation = baseController.processConversation();
					if(currentConversation.length() != 0)
					{
						chatArea.append(currentConversation);
						clickCount--;
					}
				}
				else if(clickCount % 11 == 0)
				{
					chatArea.append(baseController.processMeme(currentInput));
				}
				else if(clickCount % 15 == 0)
				{
					chatArea.append("\n" + currentInput);
				}
				
				
			}
		});
	}
}
