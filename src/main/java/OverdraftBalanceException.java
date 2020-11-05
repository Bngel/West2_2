public class OverdraftBalanceException extends RuntimeException {

    private double amount;

    public OverdraftBalanceException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}