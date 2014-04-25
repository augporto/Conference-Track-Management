import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * author : Robert Blasetti
 * Date: 23/04/2014
 * Time: 12:24 PM
 */
public class TalkTest {

    @Test
    public void testTalkFormatBreakDownOfTitle() {
        String toTest = "Bitcoin Benefits for Martial Artists 30min";
        Talk talk = new Talk(toTest);
        Assert.assertEquals("Bitcoin Benefits for Martial Artists", talk.title);
    }

    @Test
    public void testTalkFormatBreakDownOfDuration() {
        String toTest = "Bitcoin Benefits for Martial Artist 15min";
        Talk talk = new Talk(toTest);
        int testDuration = 15;
        Assert.assertEquals(testDuration, talk.durationInMinutes);
    }

    @Test
    public void testTalkFormatBreakDownOfDurationWhenNotNumeric() {
        String toTest = "Bitcoin Benefits for Martial Artists lightning";
        Talk talk = new Talk(toTest);
        int testDuration = 5;
        Assert.assertEquals(testDuration, talk.durationInMinutes);
    }
}
