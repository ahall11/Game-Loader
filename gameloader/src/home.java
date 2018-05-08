import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class home extends JPanel {
	private JButton steamButton = new JButton("");
	private JButton internetButton = new JButton("");
	/**
	 * Create the panel.
	 */
	public home() {		
		steamButton.setBorderPainted(false);
		steamButton.setContentAreaFilled(false);
		steamButton.setMargin(new Insets(0, 0, 0, 0));
		steamButton.setRolloverIcon(new ImageIcon(test.class.getResource("/imgs/steamIconSelect.png")));
		steamButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		steamButton.setBorder(null);
		steamButton.setBounds(117, 111, 128, 128);
		steamButton.setIcon(new ImageIcon(test.class.getResource("/imgs/steamIconNonSelect.png")));
		this.setLayout(null);
		this.add(steamButton);
		
		 
		internetButton.setBorder(null);
		internetButton.setBorderPainted(false);
		internetButton.setMargin(new Insets(0, 0, 0, 0));
		internetButton.setContentAreaFilled(false);
		internetButton.setRolloverIcon(new ImageIcon(test.class.getResource("/imgs/chromeIconSelect.png")));
		internetButton.setBounds(387, 111, 128, 128);
		internetButton.setIcon(new ImageIcon(test.class.getResource("/imgs/chromeIconNonSelect.png")));
		this.add(internetButton);
		this.setVisible(true);
	}
	
	public JButton getSteam(){
		return steamButton;
	}
	public JButton getInternet(){
		return internetButton;
	}
}
