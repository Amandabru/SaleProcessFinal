package se.kth.iv1350.saleProcess.utils;

/**
 * Class representing an Amount that is used for prices and payments.
 */
public final class Amount {
    private final float amount;

    /**
     * Creates a new instance, representing the amount 0.
     */
    public Amount() {
        this(0);
    }

    /**
     * Creates a new instance, representing the specified amount.
     *
     * @param amount The amount represented by the newly created instance.
     */
    public Amount(float amount) {
        this.amount = amount;
    }

    /**
     * Adds an <code>Amount</code> object to this object.
     * @param other The <code>Amount</code> to add.
     * @return the result of the addition.
     */
    public Amount plus(Amount other) {
        return new Amount(amount + other.amount);
    }

    /**
     * Multiplies this object with the value of <code>other</code>.
     * @param other the float to multiply with.
     * @return the result of the multiplication.
     */
    public Amount multiply(float other) {
        return new Amount(amount*other);
    }

    /**
     * Subtracts an <code>Amount</code> object to this object.
     * @param other The <code>Amount</code> to subtract.
     * @return the result of the subtraction.
     */
    public Amount minus(Amount other) {
        return new Amount(amount - other.amount);
    }

    /**
     * Converts <code>amount</code> from int to a string
     * @return the <code>amount</code> value stringified.
     */
    @Override
    public String toString() {
        return String.format("%.2f", amount);
    }
}
