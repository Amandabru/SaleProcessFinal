package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that stores the customer id that are eligible for discounts.
 *
 */
public class DiscountDatabase {

	private final List<Integer> premiumCustomers = new ArrayList<Integer>();
	private final List<Integer> seniorCustomers = new ArrayList<Integer>();
	CompositeDiscountCalculator discountCalculator = new CompositeDiscountCalculator();
	List <DiscountCalculator> discountCalcList = new ArrayList<>();

	/**
	 * Creates new instance of <code>DiscountDatabase</code> that represents a real database
	 */
	public DiscountDatabase(){
		premiumCustomers.add(19550530);
		seniorCustomers.add(19550530);
		premiumCustomers.add(19980704);
		seniorCustomers.add(19001025);
		discountCalcList.add(new PremiumCustomerDiscountCalculator());
		discountCalcList.add(new SeniorCustomerDiscountCalculator());
	}

	/**
	 * Checks if the customer is elegible for a discount, either the premium or senior discount.
	 * @param customerId The id of the customer being the personal number
	 * @param sale the <code>sale</code> object representing the sale
	 * @return the largest discount
	 */
	public Amount fetchDiscount(int customerId, Sale sale) {
		Amount premiumDiscount = new Amount();
		Amount seniorDiscount = new Amount();
		if(premiumCustomers.contains(customerId)){
			premiumDiscount = new PremiumCustomerDiscountCalculator().calculateDiscount(sale);
		}

		if(seniorCustomers.contains(customerId)){
			seniorDiscount = new SeniorCustomerDiscountCalculator().calculateDiscount(sale);
		}

		if(premiumDiscount.isLarger(seniorDiscount)){
			return premiumDiscount;
		}
		else{
			return seniorDiscount;
		}

	}
	private void addDiscountAlgorithms() {
		for (DiscountCalculator discountCalc : discountCalcList) {
			discountCalculator.addDiscountCalculator(discountCalc);
		}
	}

}
