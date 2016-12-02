import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Алина on 05.11.2016.
 */
public class ZooTest {

    Zoo zoo;

    CageForMammals validCageForMammals;
    CageForMammals invalidCageForMammals;
    CageForBirds validCageForBirds;
    CageForBirds invalidCageForBirds;
    CageForLions validCageForLions;
    CageForLions invalidCageForLions;
    CageForFarriers validCageForFarriers;
    CageForFarriers invalidCageForFarriers;

    @Before
    public void setUp() throws Exception {
        zoo=new Zoo();
        validCageForLions = new CageForLions();
        validCageForFarriers = new CageForFarriers();
        validCageForBirds = new CageForBirds();
        zoo.addCage(validCageForLions);
        zoo.addCage(validCageForFarriers);
        zoo.addCage(validCageForBirds);
    }

    @Test
    public void testAddCage_validCageForLions_expectedTrue() throws Exception {
        Lion lion = new Lion();
        CageForLions lions = (CageForLions) zoo.cages.get(0);
        lions.add(lion);

        Girafee girafee = new Girafee();
        Zebra zebra = new Zebra();
        CageForFarriers farriers =(CageForFarriers)zoo.cages.get(1);
        farriers.add(girafee);
        farriers.add(zebra);

        Eagle eagle = new Eagle();
        CageForBirds birds = (CageForBirds) zoo.cages.get(2);
        birds.add(eagle);

        int i=0;
        for(Cage c: zoo.cages)
            System.out.println(zoo.cages.get(i++));
    }

    @Test
    public void testGetCountOfAnimals() throws Exception {
        System.out.println(zoo.getCountOfAnimals());
    }
}