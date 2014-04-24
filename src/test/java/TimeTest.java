import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 24/04/2014
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeTest {
    Time time;
    public TimeTest(){

    }

    @Before
    public void initialize(){
        time = new Time(10,30,"AM");
    }

    @Test
    public void checkTimeFormatCorrect(){
        Time time = new Time(10,30,"AM");
        String theTime = time.toString();
        Assert.assertEquals("10:30AM", theTime);

    }

    @Test
    public void checkTimeCanBeUpdatedInMinutes(){
        time.adjust(40);
        String theTime = time.toString();
        Assert.assertEquals("11:10AM", theTime);
    }

    @Test
    public void checkPeriodSwitch(){
        time.adjust(120);
        String theTime = time.toString();
        Assert.assertEquals("12:30PM", theTime);
    }

    @Test
    public void checkTimeHoursDigital(){
        time.adjust(180);
        String theTime = time.toString();
        Assert.assertEquals("01:30PM", theTime);
    }

}
