import java.util.*;
public abstract class Coin implements Money{
    public Coin() {}
    public abstract double getAmount();
    public abstract String toString();
    public static void main(String[] args) {
        System.out.print("\f");
        ArrayList<Money> piggyBank = new ArrayList<Money>();
        for (int i = 0; i < 10; i++) {
            int choice = (int)(Math.random() * 4);
            switch(choice) {
                case 0:
                    piggyBank.add(new Quarter());
                    break;
                case 1:
                    piggyBank.add(new Dime());
                    break;
                case 2:
                    piggyBank.add(new Nickel());
                    break;
                case 3:
                    piggyBank.add(new Bill((int)(Math.random() * 100)));
            }
        }
        System.out.println(piggyBank);
        double amount = 0;
        for (Iterator<Money> iter = piggyBank.iterator(); iter.hasNext();) {
            amount += iter.next().getAmount();
        }
        System.out.printf("The PiggyBank Holds $%.2f\n", amount);
    }
}
