import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrackTest {
    Track track;
    public void TrackTest() {

    }

    @Before
    public void initialise(){
        ArrayList<Talk> mockTalkList = new ArrayList<Talk>();
        track = new Track(mockTalkList);
        track.componentsOfTheTrack.add("WooShoo ninja class information 30min");
        track.componentsOfTheTrack.add("Ancient Crane fighting class information 60min");
        track.componentsOfTheTrack.add("Kung-Fu Panda movie analysis 40min");
        track.componentsOfTheTrack.add("The ABC's of BJJ 30min");
        track.componentsOfTheTrack.add("Channeling your inner Karate Kid 20min");


    }

    @Test
    public void checkTrackContainsLunchAt12() {
        track.allocateLunch();
        for(int x=0; x<track.componentsOfTheTrack.size();x++){
            if(track.componentsOfTheTrack.get(x) == "12:00PM Lunch"){
                Assert.assertEquals(track.componentsOfTheTrack.get(x), "12:00PM Lunch");
            }
        }
    }

    @Test
    public void checkTrackContainsNetworkingEventAtAtleast4PM() {
        track.allocateNetworkingEvent();
        for(int x=0; x<track.componentsOfTheTrack.size();x++){
            if(track.componentsOfTheTrack.get(x) == "04:00PM Networking Event"){
                Assert.assertEquals(track.componentsOfTheTrack.get(x), "04:00PM Networking Event");
            }
        }
    }

    @Test
    public void checkNoEventsListedTwice() {

    }

    @Test
    public void checkAllEventsListed() {

    }






}
