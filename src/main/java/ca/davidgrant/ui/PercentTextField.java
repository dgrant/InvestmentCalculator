package ca.davidgrant.ui;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 9-Jun-02
 * Time: 2:15:06 AM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ca.davidgrant.util.StringUtils;

public class PercentTextField extends JTextField implements FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double actualValue;

	/**
	 * Other constructor
	 */
	public PercentTextField(double d, int columns) {
		super(columns);
		StringBuffer sBuf = new StringBuffer(Double.toString(d));
		sBuf.append("%");
		this.setText(sBuf.toString());
		this.addFocusListener(this);
	}

	/**
	 * Other constructor
	 */
	public PercentTextField(double d) {
		this(d, 10);
	}

	public double getNumber() {
		return actualValue;
	}

	public void setNumber(double d) {
		if (Double.isNaN(d)) {
			actualValue = 0d;
			super.setText("0.0%");
		} else {
			actualValue = d;
			DecimalFormat df = new DecimalFormat("0.000");
			StringBuffer sBuf = new StringBuffer(df.format(d));
			sBuf.append("%");
			super.setText(sBuf.toString());
		}
	}

	public void focusLost(FocusEvent e) {
		String s = StringUtils.stripLetters(this.getText()); // Strip any
		// characters
		if (s.indexOf(".") != s.lastIndexOf(".")) { // Check for two decimal
			// points
			s = s.substring(0, s.lastIndexOf("."));
		}
		actualValue = Double.parseDouble(s);
		System.out.println(actualValue);
		this.setNumber(actualValue);
	}

	public void focusGained(FocusEvent fe) {
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame("Percent Text Field Test Frame");
		PercentTextField percentField = new PercentTextField(8.34, 5);
		JPanel testPanel = new JPanel();
		JButton testButton = new JButton("click me");

		testPanel.add(percentField);
		testPanel.add(testButton);

		testPanel.setVisible(true);

		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.getContentPane().add(testPanel);
		testFrame.setVisible(true);
		testFrame.pack();
	}
}
