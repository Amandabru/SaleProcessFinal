package se.kth.iv1350.saleProcess.Integration.Discount;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that stores the customer id that are eligible for discounts.
 *
 */
public class DiscountDatabase {
	CompositeDiscountCalculator discountCalculator = new CompositeDiscountCalculator();
	List <DiscountCalculator> discountCalcList = new ArrayList<>();

	/**
	 * Creates new instance of <code>DiscountDatabase</code> that represents a real database
	 */
	public DiscountDatabase(){
		discountCalcList.add(new PremiumCustomerDiscountCalculator());
		discountCalcList.add(new SeniorCustomerDiscountCalculator());
		addDiscountAlgorithms();
	}

	/**
	 * Checks if the customer is elegible for a discount, either the premium or senior discount.
	 * @param customerId The id of the customer being the personal number
	 * @param sale the <code>sale</code> object representing the sale
	 * @return the largest discount
	 */
	public Amount fetchDiscount(int customerId, Sale sale) {
		Amount discount = discountCalculator.calculateDiscount(sale, customerId);
		return discount;
	}
	private void addDiscountAlgorithms() {
		for (DiscountCalculator discountCalc : discountCalcList) {
			discountCalculator.addDiscountCalculator(discountCalc);
		}
	}

}
