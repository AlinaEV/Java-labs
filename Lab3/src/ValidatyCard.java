import java.time.LocalDate;

/**
 * Created by Алина on 16.10.2016.
 */
public class ValidatyCard extends TravelCard {
    private ValidatyType type_validaty;//0-one month,1-ten days,-1-unexpired
    private LocalDate validaty;
    LocalDate today = LocalDate.now();

    public ValidatyCard(int id, PersonType person_type, ValidatyType type_validaty){
        super(id,person_type);
        this.type_validaty=type_validaty;
        this.validaty=today.plusDays(type_validaty.getDaysLeft());//+n_days
    }

    public LocalDate getValidaty(){ return validaty;}

    @Override
    public boolean pass() {
        return today.isBefore(LocalDate.of(this.getValidaty().getYear(),
                this.getValidaty().getMonth(), this.getValidaty().getDayOfMonth()));
    }
}
