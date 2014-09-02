package david.investor;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 9-Jun-02
 * Time: 3:00:12 AM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import javax.swing.JApplet;

public class InvestmentApplet extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		InvestmentPanel myPanel = new InvestmentPanel();
		this.getContentPane().add(myPanel);
		this.setVisible(true);
	}
}
