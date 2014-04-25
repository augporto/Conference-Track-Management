import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 24/04/2014
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConferenceTest {
    ArrayList<Talk> testList;
    Conference conference;

    @Before
    public void initialize(){
        testList = new ArrayList<Talk>();
        conference = new Conference();
        conference.addTwoTracks(testList);
    }

    @Test
    public void testTwoTracksCreated(){
        Assert.assertNotNull(conference.trackOne);
        Assert.assertNotNull(conference.trackTwo);
    }

}
