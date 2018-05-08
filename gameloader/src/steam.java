import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class steam extends JPanel {
	private JButton switchButton = new JButton("Switch Accounts");
	private JButton pickButton = new JButton("Pick A Game");
	private JLabel lblSteam = new JLabel("Steam");
	/**
	 * Create the panel.
	 */
	public steam() {
		SpringLayout springLayout = new SpringLayout();
		//switch accounts button
		springLayout.putConstraint(SpringLayout.NORTH, switchButton, 131, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, switchButton, 37, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, switchButton, 231, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, switchButton, 287, SpringLayout.WEST, this);
		setLayout(springLayout);
		add(switchButton);
		
		//pick game button
		springLayout.putConstraint(SpringLayout.NORTH, pickButton, 0, SpringLayout.NORTH, switchButton);
		springLayout.putConstraint(SpringLayout.WEST, pickButton, 76, SpringLayout.EAST, switchButton);
		springLayout.putConstraint(SpringLayout.SOUTH, pickButton, 0, SpringLayout.SOUTH, switchButton);
		springLayout.putConstraint(SpringLayout.EAST, pickButton, -37, SpringLayout.EAST, this);
		add(pickButton);
		
		//Steam label
		springLayout.putConstraint(SpringLayout.NORTH, lblSteam, 23, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSteam, 290, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSteam, 64, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblSteam, -255, SpringLayout.EAST, this);
		lblSteam.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblSteam);

	}
	
	public JButton getSwitch(){
		return switchButton;
	}
	
	public JButton getPick(){
		return pickButton;
	}
	
}
