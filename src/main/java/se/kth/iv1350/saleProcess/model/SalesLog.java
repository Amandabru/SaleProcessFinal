package se.kth.iv1350.saleProcess.model;


import se.kth.iv1350.saleProcess.Integration.ExternalAccountingSystem;
import se.kth.iv1350.saleProcess.Integration.ExternalInventorySystem;

/**
 * Class that updates the external systems with the sale information
 */
public class SalesLog {
	private final ExternalAccountingSystem accountingSys;
	private final ExternalInventorySystem inventorySys;

	/**
	 * Creates a new instance
	 * @param accountSys the external accounting system
	 * @param inventorySys the external inventory system
	 */
	SalesLog(ExternalAccountingSystem accountSys, ExternalInventorySystem inventorySys) {
		this.accountingSys = accountSys;
		this.inventorySys = inventorySys;
	}

	/**
	 * Updates the external inventory and accounting systems
	 * @param sale the <code>Sale</code> object representing the current sale
	 */
	void updateSystems(Sale sale) {
		accountingSys.recordSale(sale);
		inventorySys.updateInventory(sale);
	}

}
