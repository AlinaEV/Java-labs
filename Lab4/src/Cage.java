import java.util.ArrayList;

/**
 * Created by Алина on 06.11.2016.
 */

//exceptions
class ExceptionCageFull extends Exception {
    ExceptionCageFull(String s) { super(s); }
}
class ExceptionAnimalAbsent extends Exception {
    ExceptionAnimalAbsent(String s) { super(s); }
}

//cage
public class Cage<E extends Animal>{
    private int maxCapacity;
    private ArrayList<E> animals;
    private int countOfAnimals;

    public Cage() {
        this.animals=new ArrayList<E>();
        maxCapacity=10;
        countOfAnimals=0;
    }

    public int getMaxCapacity() { return maxCapacity; }//отримання максимальної кількості місць
    public int getCountOfAnimals(){ return countOfAnimals; } //отримання кількості зайнятих місць

    public void add(E e)throws ExceptionCageFull {  //Розміщення тварини у вольєрі. Якщо всі м’ясця у вольєрі зайнято, функція повинна ініціювати виключну ситуацію.
        if(getCountOfAnimals()==getMaxCapacity())
            throw new ExceptionCageFull("Cage if full! ");
        else {
            animals.add(e);
            countOfAnimals++;
        }
    }

    public void delete(E e) throws ExceptionAnimalAbsent {
        if(!animals.contains(e))
            throw new ExceptionAnimalAbsent("This animal isn't here... ");
        else
            animals.remove(e);
    }
}
