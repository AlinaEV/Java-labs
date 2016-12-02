import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Алина on 24.10.2016.
 */
public class TurnstileTest1 {

    CardSystem cardSystem;
    Turnstile turnstile;
    TravelCard validValidateCard;
    TravelCard invalidValidateCardMock;
    TravelCard validAmountCard;
    TravelCard invalidAmountCardMock;
    TravelCard validAccumulativeCard;
    TravelCard invalidAccumulativeCard;
    static List<String> example;

    @Before
    public void setUp() throws Exception {
        cardSystem = CardSystem.getCardSystem();
        turnstile = new Turnstile(cardSystem);

        validValidateCard = cardSystem.createValidatyCard(TravelCard.PersonType.STUDENT, TravelCard.ValidatyType.MONTH);
        invalidValidateCardMock = new TravelCard(1,TravelCard.PersonType.PUPIL) {
            @Override
            public boolean pass() {
                return false;
            }
        };

        validAmountCard = cardSystem.createAmountCard(TravelCard.PersonType.PUPIL, TravelCard.AmountType.FIVE);
        invalidAmountCardMock = new AmountCard(2,TravelCard.PersonType.PUPIL, TravelCard.AmountType.FIVE){
            @Override
            public boolean pass() {
                return false;
            }
        };

        validAccumulativeCard = cardSystem.createAccumulativeCard(100);
        invalidAccumulativeCard = cardSystem.createAccumulativeCard(0);
        cardSystem.addPass(validValidateCard, true);

        example = cardSystem.getFullRegister();
    }

    @After
    public void tearDown() throws Exception {
        turnstile = null;
        cardSystem = null;
    }

    @Test
    public void testPassAccess_nullCard_expectedFalse() throws Exception {
        assertFalse(turnstile.passAccess(null));
    }

    @Test
    public void testPassAccess_validValidatetCard_expectedTrue() throws Exception {
        assertTrue(turnstile.passAccess(validValidateCard));
    }

    @Test
    public void testPassAccess_invalidValidateCard_expectedFalse() throws Exception {
        assertFalse(turnstile.passAccess(invalidValidateCardMock));
    }

    @Test
    public void testPassAccess_validAmountCard_expectedTrue() throws Exception {
        assertTrue(turnstile.passAccess(validAmountCard));
    }

    @Test
    public void testPassAccess_invalidAmountCard_expectedFalse() throws Exception {
        assertFalse(turnstile.passAccess(invalidAmountCardMock));
    }

    @Test
    public void testPassAccess_validAccumulativeCard_expectedTrue() throws Exception {
        assertTrue(turnstile.passAccess(validAccumulativeCard));
    }

    @Test
    public void testPassAccess_invalidAccumulativeCard_expectedFalse() throws Exception {
        assertFalse(turnstile.passAccess(invalidAccumulativeCard));
    }

    @Test
    public void testGetFullRegistry_validValidatyRecord() throws Exception {
        assertEquals(validValidateCard.toString() + " Pass: true", example.get(0));
    }
}