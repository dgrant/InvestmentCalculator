package david.investor;

import java.text.DecimalFormat;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 07-May-02
 * Time: 00:06:06
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

/**
 * david.invest.david.invest class
 */
public class Investment {
	/**
	 * Interest rate stored as a decimal number, so 5% = 0.05
	 */
	private double interestRate = 0d;

	/**
	 * Number of terms between present value and final value
	 */
	private double numberOfTerms = 0d;

	/**
	 * The amount of each payment at regular intervals
	 */
	private double payment = 0d;

	/**
	 * The present value at terms = 0
	 */
	private double presentValue = 0d;

	/**
	 * The final value after n terms have elapsed
	 */
	private double finalValue = 0d;

	/**
	 * If due is false, then payments are made at the end of each term. If due
	 * is true, then payments are "due" at the start of each term.
	 */
	private boolean due = false;

	/**
	 * A plain constructor
	 */
	public Investment() {
		this(0d, 0d, 0d, 0d, 0d, false);
	}

	/**
	 * Constructor
	 */
	public Investment(Investment investmentToCopy) {
		this(investmentToCopy.interestRate, investmentToCopy.numberOfTerms,
				investmentToCopy.payment, investmentToCopy.presentValue,
				investmentToCopy.finalValue, investmentToCopy.due);
	}

	/**
	 * A Constructor
	 * 
	 * @param newInterestRate
	 *            The new interest rate to initialize private member
	 * @param newNumberOfTerms
	 *            The new number of terms to initialize private member
	 * @param newPayment
	 *            The new payment value to initialize private member
	 * @param newPresentValue
	 *            The new present value to initialize private member
	 * @param newFinalValue
	 *            The new final value to initalize private member
	 * @param newDue
	 *            The new value of due to initialize private member
	 */
	public Investment(double newInterestRate, double newNumberOfTerms,
			double newPayment, double newPresentValue, double newFinalValue,
			boolean newDue) {
		this.interestRate = newInterestRate;
		this.numberOfTerms = newNumberOfTerms;
		this.payment = newPayment;
		this.presentValue = newPresentValue;
		this.finalValue = newFinalValue;
		this.due = newDue;
	}

	/**
	 * @return the current final value of the investment
	 */
	public double getFinalValue() {
		return this.finalValue;
	}

	/**
	 * @return the current payment value stored
	 */
	public double getPayment() {
		return this.payment;
	}

	/**
	 * @return the interest rate
	 */
	public double getInterestRate() {
		return this.interestRate;
	}

	/**
	 * @return the number of terms
	 */
	public double getNumberOfTerms() {
		return this.numberOfTerms;
	}

	/**
	 * @return the state of the due variable. true means that payments are at
	 *         beginning of term, false means that payments are at end of term
	 */
	public boolean getDue() {
		return this.due;
	}

	/**
	 * @return the present value of the investment
	 */
	public double getPresentValue() {
		return this.presentValue;
	}

	/**
	 * @param newFinalValue
	 *            the new final value of the investment
	 */
	public void setFinalValue(double newFinalValue) {
		this.finalValue = newFinalValue;
	}

	/**
	 * @param newPayment
	 *            the new payment amount for the investment
	 */
	public void setPayment(double newPayment) {
		this.payment = newPayment;
	}

	/**
	 * @param newInterestRate
	 *            the new interest rate for the investment (a number between 0
	 *            and 1). Note: it is stored as a number between 0 and 1.
	 */
	public void setInterestRate(double newInterestRate) {
		this.interestRate = newInterestRate;
	}

	/**
	 * @param newNumberOfTerms
	 *            the new number of terms
	 */
	public void setNumberOfTerms(double newNumberOfTerms) {
		this.numberOfTerms = newNumberOfTerms;
	}

	/**
	 * @param newDue
	 *            the new state of the due boolean variable
	 */
	public void setDue(boolean newDue) {
		this.due = newDue;
	}

	/**
	 * @param newPresentValue
	 *            the new present value of the investment
	 */
	public void setPresentValue(double newPresentValue) {
		this.presentValue = newPresentValue;
	}

	/**
	 * Overriddent toString() method
	 */
	public String toString() {
		StringBuffer sbuf = new StringBuffer();

		DecimalFormat df = new DecimalFormat("0.##");
		sbuf.append("Present Value: $" + df.format(presentValue) + "\n");
		sbuf.append("Payment Value: $" + df.format(payment) + "\n");
		sbuf.append("Number of Terms: " + df.format(numberOfTerms) + "\n");
		sbuf.append("Interest Rate: " + df.format(interestRate) + "%\n");
		sbuf.append("Final Value: $" + df.format(finalValue) + "\n");
		sbuf.append("Payments at ");
		if (due)
			sbuf.append("beginning ");
		else
			sbuf.append("end ");
		sbuf.append("of term.");

		return sbuf.toString();
	}
}