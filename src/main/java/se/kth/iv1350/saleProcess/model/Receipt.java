package se.kth.iv1350.saleProcess.model;

import java.time.LocalDateTime;

/**
 * A representation of the receipt of a Sale.
 */
public class Receipt {
	private final Sale sale;

	/**
	 * Creates a new instance.
	 * @param sale the object for the current <code>Sale</code>
	 */
	Receipt (Sale sale) {
		this.sale = sale;
	}

	/**
	 * Creates a readable string from the content in receipt
	 * @return A formatted string representing the content of the receipt
	 */
	public String createReceiptString() {
		StringBuilder builder = new StringBuilder();
		appendLine(builder, "Receipt");

		LocalDateTime saleTime = LocalDateTime.now();
		builder.append("Time of sale: ");
		appendLine(builder, saleTime.toString());
		endSection(builder);

		appendLine(builder, "Bought Items: ");
		for (LineItem item : sale.getSoldItems()) {
			addToLine(builder, item.getItem().getName());
			addToLine(builder, item.getItem().getPrice().toString() + " kr");
			addToLine(builder, "* " + item.getQuantity());
			appendLine(builder, "(" + (item.getPrice().toString()) + " kr)");
		}
		endSection(builder);
		builder.append("Total Cost Including VAT: ");
		addToLine(builder, sale.getRunningTotalIncludingTax().toString());
		endSection(builder);

		builder.append("Total VAT: ");
		addToLine(builder, sale.getTotalVat().toString());
		endSection(builder);

		builder.append("Change: ");
		appendLine(builder, sale.getChange().toString());

		return builder.toString();
	}

	private void appendLine(StringBuilder builder, String line) {
		builder.append(line);
		builder.append("\n");
	}

	private void addToLine(StringBuilder builder, String substring) {
		builder.append(substring);
		builder.append(" ");
	}

	private void endSection(StringBuilder builder) {
		builder.append("\n");
	}
}
