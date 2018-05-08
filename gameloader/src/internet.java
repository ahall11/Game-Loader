import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.awt.event.ActionEvent;

public class internet extends JPanel {
	private JTextField websiteInput;
	private JButton account1, account2, account3, account4;
	private String[] webPages = {"Empty Slot","Empty Slot", "Empty Slot", "Empty Slot" };
	private String[] favoriteURL = {"","","",""};
	private URI favoriteURI1, favoriteURI2, favoriteURI3, favoriteURI4;
	private URI address;

	/**
	 * Create the panel.
	 * @throws MalformedURLException 
	 */
	public internet(){
		// for text field
		websiteInput = new JTextField();
		websiteInput.setText("http://www.");
		websiteInput.setToolTipText("");
		websiteInput.setColumns(10);
		 
		//For button actions
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = websiteInput.getText();
				try {
					address = new URI(input);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				openSite(address);
			}
		});
		
		account1 = new JButton(webPages[0]);
		account1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openSite(favoriteURI1);
			}
		});
		
		account2 = new JButton(webPages[1]);
		account2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openSite(favoriteURI2);
			}
		});
		
		account3 = new JButton(webPages[2]);
		account3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openSite(favoriteURI3);
			}
		});
		
		
		account4 = new JButton(webPages[3]);
		account4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openSite(favoriteURI4);
			}
		});
		
		//Button layout made with swing developer in eclipse
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(account1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(account3, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(account2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(account4, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(websiteInput, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(websiteInput, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(account1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(account2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(account4, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(account3, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	//opens websites with a URI
	public void openSite(URI address){
		if(Desktop.isDesktopSupported()){
			try {
				Desktop.getDesktop().browse(address);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//sets favorite websites and renames the JButtons
	public void setFavorite(String a, String b, String c, String d){
		favoriteURL[0] = a;
		favoriteURL[1] = b;
		favoriteURL[2] = c;
		favoriteURL[3] = d;
		account1.setText(a);
		account2.setText(b);
		account3.setText(c);
		account4.setText(d);
		try {
			if(!a.equals("Empty Slot")){
				favoriteURI1 = new URI(a);
			}
			else{
				favoriteURI1 = new URI("http://google.com");
			}
			if(!b.equals("Empty Slot")){
				favoriteURI2 = new URI(b);
			}
			else{
				favoriteURI2 = new URI("http://google.com");
			}
			if(!c.equals("Empty Slot")){
				favoriteURI3 = new URI(c);
			}
			else{
				favoriteURI3 = new URI("http://google.com");
			}
			if(!d.equals("Empty Slot")){
				favoriteURI4 = new URI(d);
			}
			else{
				favoriteURI4 = new URI("http://google.com");
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
