/**
 * Created by Алина on 16.10.2016.
 */
public class AccumulativeCard extends TravelCard {
    private int balance;
    private int travelCost;

    public AccumulativeCard(int id, int travelCost, int balance){
        super(id, PersonType.COMMON);
        this.travelCost = travelCost;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean pass() {
        if (balance >= travelCost) {
            balance -= travelCost;
            return true;
        } else {
            return false;
        }
    }
}
