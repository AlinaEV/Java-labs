import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Алина on 27.11.2016.
 */
public class LambdaLabTest {

    List<String> validUnsortedList;
    String validResultList;

    @Before
    public void setUp() throws Exception {
        validUnsortedList = Arrays.asList("Rafaello", "Svitoch", "Roshen", "Trufallie", "Ferero", "sweet", "sweets", "good", "Alina");
        validResultList = "Svitoch, Roshen, Alina";
    }

    @Test
    public void testGetNumberOfDiffSymbols_expectedTrue() throws Exception {
        assertEquals(4, LambdaLab.getNumberOfDiffSymbols("Hello"));
    }

    @Test
    public void testGetResultString() throws Exception {
        String[] args = null;
        assertEquals(validResultList, LambdaLab.getResultString(validUnsortedList));
    }
}