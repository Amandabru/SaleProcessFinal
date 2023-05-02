package se.kth.iv1350.saleProcess.Integration;

/**
 * Responsible for creating the representations of all external systems.
 */
public class SystemCreator {
	private final ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
	private final ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
	private final DiscountDatabase discountDatabase= new DiscountDatabase();
	private final CashRegister cashRegister = new CashRegister();

	/**
	 * Get the <code>externalAccountingSystem</code> representing the external accounting system
	 * @return the <code>externalAccountingSystem</code> object
	 */
	public ExternalAccountingSystem getAccountingSystem() {
		return externalAccountingSystem;
	}

	/**
	 * Get the <code>externalInventorySystem</code> object representing the external inventory system
	 * @return the <code>externalInventorySystem</code> object
	 */
	public ExternalInventorySystem getInventorySystem() {
		return externalInventorySystem;
	}

	/**
	 * Get the <code>discountDatabase</code> object representing the discount database
	 * @return the <code>discountDatabase</code> object
	 */
	public DiscountDatabase getDiscountDatabase() {
		return discountDatabase;
	}

	/**
	 * Get the <code>cashRegister</code> object representing the cash register
	 * @return the <code>cashRegister</code> object
	 */
	public CashRegister getCashRegister() {
		return cashRegister;
	}

}
