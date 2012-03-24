package tenpin;

import junit.framework.Assert;
import org.junit.Test;
import tenpin.game.GameValidator;

public class TenPinBowlingValidatorUTest {
    private GameValidator testObject = new GameValidator();


    @Test
    public void testValidateName() {
        Assert.assertFalse(testObject.validateName(""));
        Assert.assertFalse(testObject.validateName(" "));
        Assert.assertTrue(testObject.validateName("A"));
        Assert.assertTrue(testObject.validateName("Ernie"));
        Assert.assertTrue(testObject.validateName("Ernie1"));
        Assert.assertTrue(testObject.validateName("Ernie McCracken"));
        Assert.assertTrue(testObject.validateName("Ernie McCracken1"));
    }

    @Test
    public void testValidateNumberBetween1And10() {
        for (Integer i = 0; i <= 10; i++) {
            Assert.assertTrue(testObject.validateBallScore(i.toString()));
        }
        Assert.assertFalse(testObject.validateBallScore("-1"));
        Assert.assertFalse(testObject.validateBallScore("11"));
    }

    @Test
    public void testValidateNumberGreaterThanZero() {
        Assert.assertFalse(testObject.validateNumberOfPlayers("0"));
        Assert.assertFalse(testObject.validateNumberOfPlayers("-1"));
        Assert.assertTrue(testObject.validateNumberOfPlayers("1"));
        Assert.assertTrue(testObject.validateNumberOfPlayers("10"));
    }
}
