import java.util.ArrayList;

/**
 * Created by ����� on 06.11.2016.
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

    public int getMaxCapacity() { return maxCapacity; }//��������� ����������� ������� ����
    public int getCountOfAnimals(){ return countOfAnimals; } //��������� ������� �������� ����

    public void add(E e)throws ExceptionCageFull {  //��������� ������� � ������. ���� �� ����� � ������ �������, ������� ������� ��������� �������� ��������.
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
