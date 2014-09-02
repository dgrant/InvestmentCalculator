package david.investor;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 20-Jun-02
 * Time: 12:31:23 AM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import javax.swing.JFrame;

public class InvestmentFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvestmentFrame() {
		super("Investor 0.1");
		InvestmentPanel mainPanel = new InvestmentPanel();
		this.getContentPane().add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
