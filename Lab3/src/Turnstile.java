import java.time.LocalDate;

/**
 * Created by Алина on 16.10.2016.
 */
public class Turnstile {
    public int all_passes, all_denials;
    public int card_id;
    public final static int travel_cost=4;
    //    LocalDate today = LocalDate.now();

    private CardSystem cardSystem = new CardSystem();

    public Turnstile(CardSystem cardSystem){ this.cardSystem=cardSystem; }

    public boolean passAccess(TravelCard Card){
        if(Card!=null&&Card.pass()) {
            boolean res=Card.pass();
            return true;
        }else return false;
    }


//    public int print_all_access(){
//        System.out.println("All passes = "+all_passes);
//        System.out.println("All denials of access = "+all_denials);
//    }
//    public int print_separeted_data(){
//        System.out.println("Pupil cards: ");
//        System.out.println("Passes = "+passes+"; ");
//        System.out.println("Denials of access = "+denials+";\n");
//
//        System.out.println("Student cards: ");
//        System.out.println("Passes = "+passes+"; ");
//        System.out.println("Denials of access = "+denials+";\n");
//
//        System.out.println("Common cards: ");
//        System.out.println("Passes = "+passes+"; ");
//        System.out.println("Denials of access = "+denials+";\n");
//
//        System.out.println("Accumulative cards: ");
//        System.out.println("Passes = "+passes+"; ");
//        System.out.println("Denials of access = "+denials+";\n");
//    }
}
