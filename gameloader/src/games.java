import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class games extends JPanel {
	private JButton battle = new JButton("");
	private JButton csgo = new JButton("");
	private JButton rocket = new JButton("");
	private JButton golf = new JButton("");
	private JButton btnNoGame;
	private String location = new String(""); //\"C:\\windows\\programfiles\\steam\"
	private String username = new String(""), password = new String("");
	private String command = new String("");
	/**
	 * Create the panel.
	 */
	public games() {
		//For battlerite button
		battle.setBorderPainted(false);
		battle.setContentAreaFilled(false);
		battle.setMargin(new Insets(0, 0, 0, 0));
		battle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		battle.setBorder(null);
		battle.setBounds(98, 26, 128, 128);
		battle.setIcon(new ImageIcon(test.class.getResource("/imgs/battleriteIcon.png"))); 
		this.setLayout(null);
		this.add(battle);
		battle.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				runCommand("504370");
				System.exit(0);
			}
		});
		
		//For CSGO button
		csgo.setBorderPainted(false);
		csgo.setContentAreaFilled(false);
		csgo.setMargin(new Insets(0, 0, 0, 0));
		csgo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		csgo.setBorder(null);
		csgo.setBounds(423, 26, 128, 128);
		csgo.setIcon(new ImageIcon(test.class.getResource("/imgs/csgoIcon.png")));
		this.setLayout(null);
		this.add(csgo);
		csgo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				runCommand("730");
				System.exit(0);
			}
		});
		
		//For rocket league button
		rocket.setBorderPainted(false);
		rocket.setContentAreaFilled(false);
		rocket.setMargin(new Insets(0, 0, 0, 0));
		rocket.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rocket.setBorder(null);
		rocket.setBounds(98, 207, 128, 128);
		rocket.setIcon(new ImageIcon(test.class.getResource("/imgs/rocketleagueIcon.png")));
		this.setLayout(null);
		this.add(rocket);
		rocket.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				runCommand("252950");
				System.exit(0);
			}
		});
		
		//For golf with friends
		golf.setBorderPainted(false);
		golf.setContentAreaFilled(false);
		golf.setMargin(new Insets(0, 0, 0, 0));
		golf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		golf.setBorder(null);
		golf.setBounds(423, 207, 128, 128);
		golf.setIcon(new ImageIcon(test.class.getResource("/imgs/golfIcon.png")));
		this.setLayout(null);
		this.add(golf);
		golf.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				runCommand("431240");
				System.exit(0);
			}
		});
		
		//no game button
		btnNoGame = new JButton("No Game");
		btnNoGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNoGame.setBounds(265, 155, 89, 53);
		add(btnNoGame);
		btnNoGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				runCommand("");
				System.exit(0);
			}
		});
	}
	
	//Used to run the command line arguments for opening steam
	public void runCommand(String gamecode){
		//this is for just switching accounts without picking game
		if (gamecode.equals("")){
			command =  location.substring(1, 3) + " & cd " + location + " & start Steam.exe \"\" -login " + username + " " + password;
		}
		//this is for launching a game while switching accounts
		if (!username.equals("")){  
			try {
				Runtime.getRuntime().exec("wmic process where name=\"steam.exe\" delete");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			command =  location.substring(1, 3) + " & cd " + location + " & start Steam.exe \"\" -login " + username + " " + password + " -applaunch " + gamecode;
		}
		//This is for playing game without switching accounts
		else{
			command = location.substring(1, 3) + " & cd " + location + " & start Steam.exe \"\" -applaunch " + gamecode;
		}
		String[] cmd = {
				"cmd",
				"/c",
				command,
			
		};
		try {
			//exectures the cmd string[] on command line
			Process pr = Runtime.getRuntime().exec(cmd);
			//waits for it to be finish
			pr.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setUsername(String u){
		username = u;
	}
	
	public void setPassword(String p){
		password = p;
	}
	
	public void setLocation(String loc){
		location = loc;
	}
	
	public JButton getNoGame(){
		return btnNoGame;
	}
}
