package se.kth.iv1350.saleProcess.Integration;


import se.kth.iv1350.saleProcess.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Records sales. A placeholder for the external accounting
 * system which has not been implemented yet.
 */

public class ExternalAccountingSystem {
	private final List<Sale> sales = new ArrayList<>();

	/**
	 * Records the sale by adding the <code>Sale</code> object to the sales list.
	 * The list represents a database in the current assignment
	 * @param sale the <code>Sale</code> object representing the current sale.
	 */
	public void recordSale(Sale sale) {
		sales.add(sale);
	}

}
