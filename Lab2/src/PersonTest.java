import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Алина on 02.10.2016.
 */
public class PersonTest {

    @Test
    public void testEquals() throws Exception {
        EqualsVerifier.forClass(Person.class).verify();

    }
}