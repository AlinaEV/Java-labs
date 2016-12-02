/**
 * Created by Алина on 16.10.2016.
 */
public class AmountCard extends TravelCard {
    private AmountType amount_limit;
    private int amount_of_travel;

    public AmountCard(int id, PersonType person_type, AmountType amount_limit){
        super(id,person_type);
        this.amount_limit=amount_limit;
        this.amount_of_travel=amount_limit.getAmount_of_travel();
    }

    public int getAmount_of_travel(){ return amount_of_travel; }

    @Override
    public boolean pass() {
        if (this.getAmount_of_travel() > 0) {
            amount_of_travel--;
            return true;
        } else {
            return false;
        }
    }
}
