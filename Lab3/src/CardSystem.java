import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Алина on 16.10.2016.
 */
public class CardSystem {

    public final static int travel_cost=4;
    public int card_id;

    private static CardSystem cardSystem;
    public static CardSystem getCardSystem(){
        if(cardSystem==null)
            cardSystem=new CardSystem();
        return cardSystem;
    }

    public TravelCard createValidatyCard(TravelCard.PersonType personType, TravelCard.ValidatyType type_validaty) {
        if (personType == null || type_validaty == null) {
            return null;
        }
        return new ValidatyCard(card_id++, personType, type_validaty);
    }

    public TravelCard createAmountCard(TravelCard.PersonType person_type, TravelCard.AmountType amount_limit) {
        if (person_type == null || amount_limit == null) {
            return null;
        }
        return new AmountCard(card_id++, person_type, amount_limit);
    }

    public TravelCard createAccumulativeCard(int balance) {
        return new AccumulativeCard(card_id++, travel_cost, balance);
    }

    public boolean refillingCard(AccumulativeCard card, int money) {
        if (money <= 0 || card == null) {
            return false;
        } else {
            card.setBalance(card.getBalance() + money);
            return true;
        }
    }


    private List<String> registry = new LinkedList<String>();

    public void addPass(TravelCard card, boolean passStatus) {
        registry.add(card.toString() + " Pass: " + passStatus);
    }

    public List<String> getFullRegister() {
        return registry;
    }

    public List<String> getAccumulativeRegister() {
        return getFilteredRegister("Balance");
    }

    public List<String> getAmountRegister() {
        return getFilteredRegister("Amount of travels");
    }

    public List<String> getValidatyRegister() {
        return getFilteredRegister("Validate date");
    }

    private List<String> getFilteredRegister(String filter) {
        if (filter == null || filter == "") {
            return registry;
        }
        List<String> result = new LinkedList<String>();
        for (String record : registry) {
            if (record.contains(filter)) {
                result.add(record);
            }
        }
        return result;
    }

}
