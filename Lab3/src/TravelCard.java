import java.time.LocalDate;

/**
 * Created by Алина on 16.10.2016.
 */
public abstract class TravelCard {
    private int id;
    private PersonType person_type;
    private AmountType amount_of_travel;

    LocalDate today = LocalDate.now();

    public enum PersonType {
        PUPIL,
        STUDENT,
        COMMON;
    }
    public enum ValidatyType {
        TEN_DAYS(10),
        MONTH(30);
        private int daysLeft;
        ValidatyType(int daysLeft) {
            this.daysLeft = daysLeft;
        }
        public int getDaysLeft() {
            return daysLeft;
        }
    }
    public enum AmountType {
        FIVE(5),
        TEN(10);
        private int tripsLeft;

        AmountType(int tripsLeft) {
            this.tripsLeft = tripsLeft;
        }

        public int getAmount_of_travel() {
            return tripsLeft;
        }
    }



    public TravelCard( int id, PersonType person_type){
        this.id=id;
        this.person_type=person_type;
//        this.amount_of_travel=amount_of_travel;
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public PersonType getPerson_type(){
        return person_type;       //0-pupil,1-student,2-common
    }
    public void setPerson_type(PersonType person_type){ this.person_type=person_type; }

//    public LocalDate getValidaty(){
//        return validaty;        //0-one month,1-ten days,-1-unexpired
//    }
//    public void setValidaty(int validaty){
//        if(validaty==0)
//            this.validaty=today.plusMonths(1);//+1month
//        if(validaty==1)
//            this.validaty=today.plusDays(10);//+10days
//    }
//
//    public AmountType getAmount_of_travel(){
//        return amount_of_travel;//0- 5travels, 1- 10travels
//    }
//    public void setAmount_of_travel(AmountType amount_of_travel){
//        this.amount_of_travel=amount_of_travel;
//    }
    public abstract boolean pass();

    @Override
    public String toString() {
        return "TravelCard{" +
                "id=" + id +
                '}';
    }
}
