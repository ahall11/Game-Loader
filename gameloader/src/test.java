import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class test implements MouseListener{
	private JFrame frame = new JFrame("User Hub");
	private JPanel panelCont = new JPanel();
	private home h = new home();
	private steam s = new steam();
	private internet i = new internet();
	private accounts a = new accounts();
	private games g = new games();
	private CardLayout c1 = new CardLayout();
	private String cardName;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */	
	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run(){
				try {
					new test();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public test() throws FileNotFoundException {
		getConfigData();
		//setting up the cardlayout panel to be able to switch with actions
		panelCont.setLayout(c1);
		panelCont.add(h, "home");
		panelCont.add(s, "steam");
		panelCont.add(i, "internet");
		panelCont.add(a, "accounts");
		panelCont.add(g, "games");
		//displaying the home panel first
		c1.show(panelCont, "home");
		
		//Below are the action listeners that change the panel and pipe information
		h.getInternet().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cardName = "internet";
				c1.show(panelCont, cardName);
				frame.pack();
			}
		});
		
		h.getSteam().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardName = "steam";
				c1.show(panelCont, cardName);
				frame.pack();
			}
		});
		
		s.getPick().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardName = "games";
				c1.show(panelCont, cardName);
				frame.pack();
				g.getNoGame().setVisible(false);
			}
		});
		
		s.getSwitch().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardName = "accounts";
				c1.show(panelCont, cardName);
				frame.pack();
				g.getNoGame().setVisible(true);
			}
		});
		
		a.getButton(1).addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!a.getButton(1).getText().equals("Empty")){
				c1.show(panelCont, "games");
				frame.pack();
				g.setUsername(a.getUsername(0));
				g.setPassword(a.getPassword(0));
				}
			}
		});
		
		a.getButton(2).addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!a.getButton(2).getText().equals("Empty")){
					c1.show(panelCont, "games");
					frame.pack();
					g.setUsername(a.getUsername(1));
					g.setPassword(a.getPassword(1));
				}
			}
		});
		
		a.getButton(3).addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!a.getButton(3).getText().equals("Empty")){
					c1.show(panelCont, "games");
					frame.pack();
					g.setUsername(a.getUsername(2));
					g.setPassword(a.getPassword(2));
				}
			}
		});
		
		a.getButton(4).addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!a.getButton(4).getText().equals("Empty")){
					c1.show(panelCont, "games");
					frame.pack();
					g.setUsername(a.getUsername(3));
					g.setPassword(a.getPassword(3));
				}
			}
		});
		
		//setting up the frame
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addMouseListener(this);
	}
	
	//this will get all of the data from the config file and save it into variables in the objects
	public void getConfigData() throws FileNotFoundException{
		boolean check = false;
		File file = new File("config.txt");
		Scanner inputFile = new Scanner(file);
		inputFile.nextLine();
		//saves location
		g.setLocation(inputFile.nextLine());
		inputFile.nextLine(); //skip a line
		//saves accounts
		for (int i = 0; i < 4; i++){
			String in = inputFile.nextLine();
			if (in.equals("")){
				a.setLogin(i, "Empty Slot");
			}
			else{
				a.setLogin(i, in);
			}
		}
		inputFile.nextLine(); //skip a line
		//saves the favorite websites
		if(inputFile.hasNextLine()){
			String a = inputFile.nextLine();
			i.setFavorite(a, "Empty Slot", "Empty Slot", "Empty Slot");
			if(inputFile.hasNextLine()){
				String b = inputFile.nextLine();
				i.setFavorite(a, b, "Empty Slot", "Empty Slot");
				if(inputFile.hasNextLine()){
					String c = inputFile.nextLine();
					i.setFavorite(a, b, c, "Empty Slot");
					if(inputFile.hasNextLine()){
						String d = inputFile.nextLine();
						i.setFavorite(a, b, c, d);
					}
				}
			}
		}
		else{
			i.setFavorite("Empty Slot", "Empty Slot", "Empty Slot", "Empty Slot");
		}		
	}
	
	//Allows you to right click to go back ONE STEP ONLY
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3){
			if (cardName.equals("steam")){
				c1.show(panelCont, "home");
				frame.pack();
			}
			else if (cardName.equals("internet")){
				c1.show(panelCont, "home");
				frame.pack();
			}
			else if (cardName.equals("games")){
				c1.show(panelCont, "steam");
				frame.pack();
			}
			else if (cardName.equals("accounts")){
				c1.show(panelCont, "steam");
				frame.pack();
			}
		}
	}
	
	//Listeners I didn't use
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}