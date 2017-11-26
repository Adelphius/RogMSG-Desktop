package rogMsg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
//import javax.swing.JList;
//import java.awt.BorderLayout;
//import javax.swing.*;

@SuppressWarnings("serial")
public class ChatWindow extends javax.swing.JFrame
{
	private JFrame window;
	private JPanel groupControlPanel;
	private JLabel title;
	private JScrollPane userPane;
	private JList<User> userList;
	private JPanel mainChatPanel;
	private JTabbedPane chatTabs;
	private JScrollPane announcementTab;
	private JTextField messageField;
	private JButton submitButton;
	private JPanel listTab;
	private JPanel pollTab;
	private JTabbedPane extraControlPanel;
	private JButton logoutButton;
	private JButton newPollButton;
	private JButton addUserButton;
	private JButton newListButton;
	
	public ChatWindow()
	{
		initComponents();
	}
	
	private void initComponents()
	{
		window = new JFrame();
		window.setLayout(new GridLayout(1, 3));
		window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("GUI Test");
        
		groupControlPanel = new JPanel();
		groupControlPanel.setLayout(new GridLayout(4, 1));
		title = new JLabel();
		title.setText("Group Name");
		userPane = new JScrollPane();
		userList = new JList<>();
		userPane.add(userList);
		logoutButton = new JButton();
		logoutButton.setText("Log Out");
		addUserButton = new JButton();
		addUserButton.setText("Add User");
		groupControlPanel.add(title);
		groupControlPanel.add(userPane);
		groupControlPanel.add(addUserButton);
		groupControlPanel.add(logoutButton);
		
		mainChatPanel = new JPanel();
		mainChatPanel.setLayout(new GridLayout(3, 1));
		chatTabs = new JTabbedPane();
		announcementTab = new JScrollPane();
		messageField = new JTextField("enter text here");
		mainChatPanel.add(chatTabs);
		chatTabs.addTab("Announcements", announcementTab);
		mainChatPanel.add(messageField);
		submitButton = new JButton();
		submitButton.setText("Submit");
		mainChatPanel.add(submitButton);
		
		extraControlPanel = new JTabbedPane();
		pollTab = new JPanel();
		newPollButton = new JButton();
		newPollButton.setText("New Poll");
		listTab = new JPanel();
		newListButton = new JButton();
		newListButton.setText("New List");
		pollTab.add(newPollButton);
		listTab.add(newListButton);
		extraControlPanel.addTab("Polls", pollTab);
		extraControlPanel.addTab("Lists", listTab);
		
		window.add(groupControlPanel);
		window.add(mainChatPanel);
		window.add(extraControlPanel);
		window.setVisible(true);
		window.pack();
	}
	
//	public static void main(String[] args)
//	{
//		ChatWindow test = new ChatWindow();
//	}
}

