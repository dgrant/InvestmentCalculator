package david.investor;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 27-May-02
 * Time: 10:20:41 PM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ca.davidgrant.ui.CurrencyTextField;
import ca.davidgrant.ui.DoubleTextField;
import ca.davidgrant.ui.PercentTextField;

public class InvestmentPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Panels to hold each row of stuff
	JPanel labelsPanel;

	JPanel textPanel;

	JPanel buttonPanel;

	// Labels for text boxes
	JLabel pvLabel;

	JLabel fvLabel;

	JLabel nLabel;

	JLabel iLabel;

	JLabel pmtLabel;

	JLabel dueLabel;

	// Text boxes
	CurrencyTextField pvTextField;

	CurrencyTextField fvTextField;

	DoubleTextField nTextField;

	PercentTextField iTextField;

	CurrencyTextField pmtTextField;

	JComboBox dueComboBox;

	// Solve buttons
	JButton pvSolveButton;

	JButton fvSolveButton;

	JButton nSolveButton;

	JButton iSolveButton;

	JButton pmtSolveButton;

	JButton fv2pvButton;

	/**
	 * Constructor
	 */
	public InvestmentPanel() {
		super();
		createUI();
		this.setVisible(true);
	}

	/**
	 * Set up the GUI
	 */
	private void createUI() {
		labelsPanel = new JPanel(new GridLayout(0, 1, 0, 15));
		textPanel = new JPanel(new GridLayout(0, 1, 0, 6));
		buttonPanel = new JPanel(new GridLayout(0, 1, 0, 5));

		pvLabel = new JLabel("Present Value:", SwingConstants.RIGHT);
		fvLabel = new JLabel("Final Value:", SwingConstants.RIGHT);
		nLabel = new JLabel("Number of Terms:", SwingConstants.RIGHT);
		iLabel = new JLabel("Interest Rate:", SwingConstants.RIGHT);
		pmtLabel = new JLabel("Payment Amount:", SwingConstants.RIGHT);
		dueLabel = new JLabel("Payments at:", SwingConstants.RIGHT);

		pvTextField = new CurrencyTextField(0, 10);
		fvTextField = new CurrencyTextField(0, 10);
		nTextField = new DoubleTextField(1, 10);
		iTextField = new PercentTextField(0.0, 10);
		pmtTextField = new CurrencyTextField(0, 10);

		String[] comboBoxChoices = { "End of Term", "Beginning of Term" };
		dueComboBox = new JComboBox(comboBoxChoices);
		dueComboBox.setSelectedIndex(0);

		pvSolveButton = new JButton("Solve");
		fvSolveButton = new JButton("Solve");
		nSolveButton = new JButton("Solve");
		iSolveButton = new JButton("Solve");
		pmtSolveButton = new JButton("Solve");
		fv2pvButton = new JButton("FV->PV");

		pvSolveButton.addActionListener(this);
		fvSolveButton.addActionListener(this);
		nSolveButton.addActionListener(this);
		iSolveButton.addActionListener(this);
		pmtSolveButton.addActionListener(this);
		fv2pvButton.addActionListener(this);

		labelsPanel.add(pvLabel);
		labelsPanel.add(fvLabel);
		labelsPanel.add(nLabel);
		labelsPanel.add(iLabel);
		labelsPanel.add(pmtLabel);
		labelsPanel.add(dueLabel);

		textPanel.add(pvTextField);
		textPanel.add(fvTextField);
		textPanel.add(nTextField);
		textPanel.add(iTextField);
		textPanel.add(pmtTextField);
		textPanel.add(dueComboBox);

		buttonPanel.add(pvSolveButton);
		buttonPanel.add(fvSolveButton);
		buttonPanel.add(nSolveButton);
		buttonPanel.add(iSolveButton);
		buttonPanel.add(pmtSolveButton);
		buttonPanel.add(fv2pvButton);

		this.add(labelsPanel);
		this.add(textPanel);
		this.add(buttonPanel);
	}

	/**
	 * Actions to perform if the solve buttons are clicked on
	 */
	public void actionPerformed(ActionEvent e) {
		Investment myInvestment = new Investment();

		// Load all text box values into david.invest.david.invest
		myInvestment.setPresentValue(pvTextField.getNumber());
		myInvestment.setFinalValue(fvTextField.getNumber());
		myInvestment.setNumberOfTerms(nTextField.getNumber());
		myInvestment.setInterestRate(iTextField.getNumber() / 100);
		myInvestment.setPayment(pmtTextField.getNumber());

		// Process the "due" combo-box
		if (dueComboBox.getSelectedIndex() == 0) {
			myInvestment.setDue(false);
		} else if (dueComboBox.getSelectedIndex() == 1) {
			myInvestment.setDue(true);
		}

		if (e.getSource() == pvSolveButton) {
			pvTextField.setNumber(SolveInvestment
					.solvePresentValue(myInvestment));
		} else if (e.getSource() == fvSolveButton) {
			fvTextField
					.setNumber(SolveInvestment.solveFinalValue(myInvestment));
		} else if (e.getSource() == nSolveButton) {
			DecimalFormat df = new DecimalFormat("0.###");
			nTextField.setText(df.format(SolveInvestment
					.solveNumberOfTerms(myInvestment)));
		} else if (e.getSource() == iSolveButton) {
			iTextField.setNumber(SolveInvestment.solveInterestRate(
					myInvestment, 0.001) * 100d);
		} else if (e.getSource() == pmtSolveButton) {
			pmtTextField.setNumber(SolveInvestment.solvePayment(myInvestment));
		} else if (e.getSource() == fv2pvButton) {
			pvTextField.setText(fvTextField.getText());
		}
	}
}
