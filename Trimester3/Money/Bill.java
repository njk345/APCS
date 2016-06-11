public class Bill implements Money{
    private int amount;
    public Bill(int amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public String toString() {
        return "$" + amount;
    }
}
