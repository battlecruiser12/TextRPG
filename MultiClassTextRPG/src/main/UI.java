package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, choiceButtonPanel, characterCreationPanel, classButtonPanel, charCreationBottomPanel;
	JLabel titleNameLabel, characterCreationBox;
	JButton startButton, choice1, choice2, choice3, choice4, fighter, wizard, druid, bard, warlock, paladin, sorcerer, artificer, cleric, barbarian, monk, back, confirm;
	JTextArea mainTextArea, characterCreationTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 64);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
	Game game;
	ArrayList<JPanel> uiArrayList = new ArrayList<JPanel>();
	public UI(Game game) {
		this.game = game;
	}
	
	private ButtonHandler bHandler;
	
	public void createUI(ButtonHandler bHandler) {
		this.bHandler = bHandler;
		// window
		window = new JFrame("Arcane World");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.getContentPane().setBackground(Color.black);
		try {
			window.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./graphics/menuBackground.png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
		// title screen
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		//titleNamePanel.setBackground(Color.black);
		titleNamePanel.setOpaque(false);
		titleNameLabel = new JLabel("ARCANE WORLD");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		uiArrayList.add(titleNamePanel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		//startButtonPanel.setBackground(Color.black);
		startButtonPanel.setOpaque(false);
		startButton = choiceButton("", "start");
		startButton.setBounds(300, 400, 200, 100);
		startButton.setToolTipText("Start a new game.");
		startButton.setIcon(new ImageIcon("./graphics/startButton.png"));
		startButton.setPreferredSize(new Dimension(200, 54));
		startButtonPanel.add(startButton);
		uiArrayList.add(startButtonPanel);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);

		// character creation screen
		characterCreationPanel = new JPanel();
		characterCreationPanel.setBounds(250, 50, 500, 450);
		//characterCreationPanel.setBackground(Color.black);
		characterCreationPanel.setOpaque(false);
		window.add(characterCreationPanel);
		uiArrayList.add(characterCreationPanel);
		characterCreationBox = new JLabel(new ImageIcon("./graphics/charCreationBox.png"));
		characterCreationPanel.add(characterCreationBox);

		
		characterCreationTextArea = new JTextArea("Select a class");
		characterCreationTextArea.setBounds(10, 10, 430, 450);
		characterCreationTextArea.setFont(normalFont);

		characterCreationTextArea.setOpaque(false);
		characterCreationTextArea.setForeground(Color.white);
		characterCreationTextArea.setLineWrap(true);
		characterCreationTextArea.setWrapStyleWord(true);
		characterCreationTextArea.setEditable(false);
		
		characterCreationBox.add(characterCreationTextArea);
		characterCreationPanel.setVisible(false);
		
		charCreationBottomPanel = new JPanel();
		charCreationBottomPanel.setBounds(270, 505, 460, 50);
		charCreationBottomPanel.setBackground(Color.black);
		back = choiceButton("Back", "back");
		confirm = choiceButton("Confirm", "confirm");
		charCreationBottomPanel.add(back);
		charCreationBottomPanel.add(confirm);
		charCreationBottomPanel.setLayout(new GridLayout(1,2));
		window.add(charCreationBottomPanel);
		charCreationBottomPanel.setVisible(false);
		uiArrayList.add(charCreationBottomPanel);
		
		
		// choose class
		classButtonPanel = new JPanel();
		classButtonPanel.setBounds(50, 25, 150, 500);
		classButtonPanel.setBackground(Color.black);
		fighter = choiceButton("Fighter", "fighter");
		classButtonPanel.add(fighter);
		wizard = choiceButton("Wizard", "wizard");
		classButtonPanel.add(wizard);
		druid = choiceButton("Druid", "druid");
		classButtonPanel.add(druid);
		bard = choiceButton("Bard", "bard");
		classButtonPanel.add(bard);
		warlock = choiceButton("Warlock", "warlock");
		classButtonPanel.add(warlock);
		paladin = choiceButton("Paladin", "paladin");
		classButtonPanel.add(paladin);
		sorcerer = choiceButton("Sorcerer", "sorcerer");
		classButtonPanel.add(sorcerer);
		artificer = choiceButton("Artificer", "artificer");
		classButtonPanel.add(artificer);
		cleric = choiceButton("Cleric", "cleric");
		classButtonPanel.add(cleric);
		barbarian = choiceButton("Barbarian", "barbarian");
		classButtonPanel.add(barbarian);
		monk = choiceButton("Monk", "monk");
		classButtonPanel.add(monk);
		window.add(classButtonPanel);
		classButtonPanel.setLayout(new GridLayout(11, 1));
		classButtonPanel.setVisible(false);
		uiArrayList.add(classButtonPanel);
		
		// default choices
		choiceButtonPanel = new JPanel();
		choice1 = choiceButton("choice1", "c1");
		choiceButtonPanel.add(choice1);
		choice2 = choiceButton("choice2", "c2");
		choiceButtonPanel.add(choice2);
		choice3 = choiceButton("choice3", "c3");
		choiceButtonPanel.add(choice3);
		choice4 = choiceButton("choice4", "c4");
		choiceButtonPanel.add(choice4);
		window.add(choiceButtonPanel);
		choiceButtonPanel.setVisible(false);
		uiArrayList.add(choiceButtonPanel);
		
		
		refreshWindow(window);
		

	}
	
	public void charCreationClassInfo(String pClass) {
		switch(pClass) {
		case "fighter":
			characterCreationTextArea.setText("Fighters excel in physical combat.\n"
					+ "Base HP: 35\n"
					+ "Health increase per level: 9\n"
					+ "You may wield any type of weapon, but are proficient in simple and martial weapons.\n"
					+ "You may wear any type of armor.");
			break;
		case "wizard":
			characterCreationTextArea.setText("Wizards attain their magical abilities through rigorous studies of the arcane.\n"
					+ "Base HP: 20\n"
					+ "Health increase per level: 7\n"
					+ "You may wield staves, wands, swords, and daggers.\n"
					+ "You may not wear any type of armor.");
			break;
		case "druid":
			characterCreationTextArea.setText("Druids are students and protectors of the natural world and its denizens.\n"
					+ "Base HP: 24\n"
					+ "Health increaes per level: 9\n"
					+ "You may wield staves, swords, daggers, maces, spears, and clubs.\n"
					+ "You may wear light or medium armor that isn't made out of metal.\n"
					+ "Druids possess the ability to shapeshift into any beasts they have encountered.");
			break;
		case "bard":
			characterCreationTextArea.setText("Bards infuse magic into their speech or music, granting buffs to their allies and charming or manipulating their foes.\n"
					+ "Base HP: 22\n"
					+ "Health increase per level: 8\n"
					+ "You may wield swords, daggers, and small crossbows.\n"
					+ "You may wear light armor.\n"
					+ "");
			break;
		case "warlock":
			characterCreationTextArea.setText("Warlocks gain their magical abilities through a pact with a powerful and supernatural being.\n"
					+ "Base HP: 22\n"
					+ "Health increase per level: 8\n"
					+ "You may wield staves, wands, swords, and daggers.\n"
					+ "You may wear light armor.");
			break;
		case "paladin":
			characterCreationTextArea.setText("Paladins are warriors bound to an oath, be it to a deity or a cause.\n"
					+ "Base HP: 33\n"
					+ "Health increase per level: 9\n"
					+ "You may wield any weapon, but are proficient in simple and martial weapons.\n"
					+ "You may wear any armor.");
			break;
		case "sorcerer":
			characterCreationTextArea.setText("Sorcerers gain their magical abilities through means beyond their control, be it through inheritence or an archfey pulling a prank.\n"
					+ "Base HP: 26\n"
					+ "Health increase per level: 8\n"
					+ "You may wield staves, swords, and daggers.\n"
					+ "You may not wear any armor.");
			break;
		case "artificer":
			characterCreationTextArea.setText("Artificers are tinkerers that infuse magic into their creations, allowing the creation of anything from simple explosives to animate constructs.\n"
					+ "Base HP: 24\n"
					+ "Health increase per level: 7\n"
					+ "You may wield simple weapons and firearms.\n"
					+ "You may wear light or medium armor.\n"
					+ "Artificers can craft mechinical items if they have access to the correct tools and materials.");
		}
	}
	
	

	
	public JButton choiceButton(String name, String output) {
		JButton button = new JButton(name);
		//button.setBackground(Color.black);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setForeground(Color.white);
		button.setFont(normalFont);
		button.setFocusPainted(false);
		button.addActionListener(bHandler);
		button.setActionCommand(output);
		return button;
	}
	
	public void refreshWindow(JFrame window) {
		window.setVisible(true);
		window.setVisible(false);
		window.setVisible(true);
	}
}
