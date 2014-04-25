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
    ArrayList<Talk> mockTalkList;

    @Before
    public void initialize(){
        mockTalkList = new ArrayList<Talk>();
        track = new Track(mockTalkList);
        Talk talk1 = new Talk("Being Bruce Lee 40min");
        track.talksToAllocateToTrack.add(talk1);
        track.eventsInTrack.add("Ancient Crane fighting class information 60min");
        track.eventsInTrack.add("Kung-Fu Panda movie analysis 40min");
        track.eventsInTrack.add("The ABC's of BJJ 30min");
        track.eventsInTrack.add("Channeling your inner Karate Kid 20min");


    }

    @Test
    public void checkTrackContainsLunchAt12() {
        track.allocateLunchToTrack();
        for(int x=0; x<track.eventsInTrack.size();x++){
            if(track.eventsInTrack.get(x) == "12:00PM Lunch"){
                Assert.assertEquals(track.eventsInTrack.get(x), "12:00PM Lunch");
            }
        }
    }

    @Test
    public void checkTrackContainsNetworkingEventAfter4PM() {
        track.allocateNetworkingEventToTrack();
        for(int x=0; x<track.eventsInTrack.size();x++){
            if(track.eventsInTrack.get(x) == "04:00PM Networking Event"){
                Assert.assertEquals(track.eventsInTrack.get(x), "04:00PM Networking Event");
            }
        }
    }

    @Test
    public void CheckTimeFormatted(){
        Assert.assertEquals("10:00AM", track.timeToString());
    }

    @Test
    public void CheckTimeCanBeUpdated(){
        track.updateTime(track.talksToAllocateToTrack.get(0));
        Assert.assertEquals("10:40AM", track.timeToString());
    }





}
