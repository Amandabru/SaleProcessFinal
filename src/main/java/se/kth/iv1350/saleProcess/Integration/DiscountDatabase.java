package se.kth.iv1350.saleProcess.Integration;

import se.kth.iv1350.saleProcess.model.AddedItemInformation;
import se.kth.iv1350.saleProcess.model.Sale;
import se.kth.iv1350.saleProcess.utils.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to be implemented when alternative flows are considered.
 */
public class DiscountDatabase {

	private final List<DiscountDTO> discounts = new ArrayList<>();
	private final List<int> premiumCustomers = new ArrayList<int>();
	private final List<int> seniorCustomers = new ArrayList<int>();

	public DiscountDatabase(){
		premiumCustomers.add(19980530);
		premiumCustomers.add(19980704);
		seniorCustomers.add(19001025);
	}

	public Amount fetchDiscount(int customerId, Sale sale) {
		Amount premiumPrice = new Amount();
		Amount seniorPrice = new Amount();

		if(premiumCustomers.contains(customerId)){
			premiumPrice = new PremiumCustomerDiscountCalculator().calculateDiscount(sale);
		}

		if(seniorCustomers.contains(customerId)){
			seniorPrice = new SeniorCustomerDiscountCalculator().calculateDiscount(sale);
		}

		if(premiumPrice.isLarger(seniorPrice)){
			return seniorPrice;
		}
		else{
			return premiumPrice;
		}



	}

}
