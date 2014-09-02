package david.investor;

/*
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 07-May-02
 * Time: 00:07:30
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

public class InvestmentTestClass {
	public static void main(String arg[]) {
		Investment myInvestment = new Investment();
		// System.out.println("Choices:");
		myInvestment.setPresentValue(10000);
		myInvestment.setPayment(2000);
		myInvestment.setInterestRate(0.1);
		myInvestment.setNumberOfTerms(10);
		myInvestment.setDue(false);
		myInvestment.setFinalValue(SolveInvestment
				.solveFinalValue(myInvestment));

		System.out.println(myInvestment.toString());
	}
}
