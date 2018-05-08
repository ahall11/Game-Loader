import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class accounts extends JPanel {
	private JButton account1, account2, account3, account4;
	private String[] username = {"","","",""};
	private String[] password = {"","","",""};
	private String[] accountNames = {"Empty Slot","Empty Slot", "Empty Slot", "Empty Slot" };
	/**
	 * Create the panel.
	 */
	public accounts() {
		//making buttons
		account1 = new JButton(accountNames[0]);
		account2 = new JButton(accountNames[1]);
		account3 = new JButton(accountNames[2]); 
		account4 = new JButton(accountNames[3]);
		//automatically made from eclipse swing developer
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(account1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(125)
							.addComponent(account2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(account3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(125)
							.addComponent(account4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(account1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(account2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(account3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(account4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

	}
	
	//used to set login info from config file
	public void setLogin(int AccountNumber, String input){
		String[] login;
		login = input.split("\\s+");
		username[AccountNumber] = login[0];
		password[AccountNumber] = login[1];
		if (AccountNumber == 0){
			account1.setText(login[0]);
		}
		if (AccountNumber == 1){
			account2.setText(login[0]);
		}
		if (AccountNumber == 2){
			account3.setText(login[0]);
		}
		if (AccountNumber == 3){
			account4.setText(login[0]);
		}
	}
	
	public JButton getButton(int num){
		if (num == 1){
			return account1;
		}
		if (num == 2){
			return account2;
		}
		if (num == 3){
			return account3;
		}
		if (num == 4){
			return account4;
		}
		return account1;
	}
	
	public String getUsername(int num){
		return username[num];
	}
	
	public String getPassword(int num){
		return password[num];
	}
}
