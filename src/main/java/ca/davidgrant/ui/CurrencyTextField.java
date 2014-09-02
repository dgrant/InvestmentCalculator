package ca.davidgrant.ui;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 9-Jun-02
 * Time: 1:56:50 AM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JTextField;

/**
 * CurrencyTextField is an extension of the JTextField class. It is a text field
 * used to store currency amounts
 */
public class CurrencyTextField extends JTextField implements FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Other constructor
	 */
	public CurrencyTextField(double d, int columns) {
		super(columns);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		String s = currencyFormatter.format(d);
		this.setText(s);
		this.addFocusListener(this);
	}

	/**
	 * Other constructor
	 */
	public CurrencyTextField(double d) {
		this(d, 10);
	}

	/**
	 * @return the number (currency) in the text field
	 */
	public double getNumber() {
		String s = super.getText();
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		try {
			double d = currencyFormatter.parse(s).doubleValue();
			return d;
		} catch (ParseException pe) {
			System.out.println(pe.getMessage());
			pe.printStackTrace();
			return Double.NaN;
		}
	}

	/**
	 * Set the new currency amount to show in the text field
	 * 
	 * @param d
	 *            the new amount to show in text field
	 */
	public void setNumber(double d) {
		if (Double.isNaN(d)) {
			super.setText("$0.00");
		} else {
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
			String s = currencyFormatter.format(d);
			super.setText(s);
		}
	}

	public void focusLost(FocusEvent fe) {
		if (this.getText().indexOf('$') == -1) {
			this.setNumber(Double.parseDouble(this.getText()));
		} else {
			this.setNumber(this.getNumber());
		}
	}

	public void focusGained(FocusEvent fe) {

	}

}
