package se.kth.iv1350.saleProcess.Integration;


import se.kth.iv1350.saleProcess.utils.Amount;

/**
 * A representation of the cash register which keeps track of balance.
 */
public class CashRegister {
	private Amount balance = new Amount();

	/**
	 * Updated the balance in the cash register
	 * @param payment the amount the customer have paid for the bought sale.
	 */
	public void updateBalance(Amount payment) {
		balance = balance.plus(payment);
	}

}
