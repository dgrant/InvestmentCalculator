package david.investor;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 07-May-02
 * Time: 22:44:08
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

public class SolveInvestment {
	private static final double NEWTON_DISCRETE_SLOPE_X_SPACING = 1E-3f;

	private static final double NEWTON_MAX_Y_ERROR = 1E-2f;

	private static final double NEWTON_MAX_ITERATIONS = 10f;

	// This function has tested okay
	public static double solveFinalValue(Investment workingInv) {
		double pmt = workingInv.getPayment();
		double i = workingInv.getInterestRate();
		double n = workingInv.getNumberOfTerms();
		boolean due = workingInv.getDue();
		double pv = workingInv.getPresentValue();

		if (due == true)
			pmt = pmt * (1 + i);
		double pmtPart;
		if (i != 0d)
			pmtPart = pmt * ((Math.pow(1 + i, n) - 1) / i);
		else
			pmtPart = pmt * n * (Math.pow(1 + i, n - 1));
		double pvPart = pv * Math.pow(1 + i, n);
		return pmtPart + pvPart;
	}

	// This function has tested okay
	public static double solvePresentValue(Investment workingInv) {
		double pmt = workingInv.getPayment();
		double i = workingInv.getInterestRate();
		double n = workingInv.getNumberOfTerms();
		boolean due = workingInv.getDue();
		double fv = workingInv.getFinalValue();

		if (due == true) {
			pmt = pmt * (1 + i);
		}
		double pmtPart = pmt * ((Math.pow(1 + i, n) - 1) / i);
		double pv = (fv - pmtPart) / (Math.pow(1 + i, n));
		return pv;
	}

	// This function has tested okay
	public static double solveNumberOfTerms(Investment workingInv) {
		double pmt = workingInv.getPayment();
		double i = workingInv.getInterestRate();
		boolean due = workingInv.getDue();
		double fv = workingInv.getFinalValue();
		double pv = workingInv.getPresentValue();

		if (due == true) {
			pmt = pmt * (1 + i);
		}
		double n = Math.log(((fv + (pmt / i)) / ((pmt / i) + pv)))
				/ Math.log(1 + i);
		return n;
	}

	public static double solvePayment(Investment workingInv) {
		double i = workingInv.getInterestRate();
		boolean due = workingInv.getDue();
		double fv = workingInv.getFinalValue();
		double pv = workingInv.getPresentValue();
		double n = workingInv.getNumberOfTerms();

		double pmt;
		if (i != 0d)
			pmt = (fv - (pv * Math.pow(1 + i, n)))
					/ ((Math.pow(1 + i, n) - 1) / i);
		else
			pmt = (fv - (pv * Math.pow(1 + i, n))) / n
					* (Math.pow(1 + i, n - 1));
		if (due == true) {
			pmt = pmt / (1 + i);
		}
		return pmt;
	}

	public static double solveInterestRate(Investment workingInv, double iGuess) {
		double error = 1, newIGuess;
		int iterations = 0;

		Investment inv = new Investment(workingInv);
		inv.setInterestRate(iGuess);

		while ((error > NEWTON_MAX_Y_ERROR)
				& (iterations != NEWTON_MAX_ITERATIONS)) {
			newIGuess = iGuess - (newtonGetF(inv) / newtonGetFPrime(inv));
			iGuess = newIGuess;
			inv.setInterestRate(iGuess);
			error = newtonGetF(inv);
			iterations++;
		}
		return iGuess;
	}

	private static double newtonGetF(Investment workingInv) {
		double f = solveFinalValue(workingInv) - workingInv.getFinalValue();
		return f;
	}

	private static double newtonGetFPrime(Investment workingInv) {
		Investment tempInv2 = new Investment(workingInv);
		Investment tempInv1 = new Investment(workingInv);

		tempInv2.setInterestRate(workingInv.getInterestRate()
				+ NEWTON_DISCRETE_SLOPE_X_SPACING);
		tempInv1.setInterestRate(workingInv.getInterestRate()
				- NEWTON_DISCRETE_SLOPE_X_SPACING);

		double rise = solveFinalValue(tempInv2) - solveFinalValue(tempInv1);
		double run = 2 * NEWTON_DISCRETE_SLOPE_X_SPACING;
		double slope = rise / run;
		return slope;
	}
}
