import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алина on 30.10.2016.
 */

public class Zoo {
    public List<Cage<? extends Animal>> cages = new ArrayList<>();

    public long getCountOfAnimals(){
        long sum=0;
        for(Cage i: cages)
            ++sum;
        return sum;
    }

//    public <T extends Cage> void addCage( T cage){
//        cages.add(cage);
//    }

    public void addCage(Cage<? extends Animal> cage){
        cages.add(cage);
    }
}

