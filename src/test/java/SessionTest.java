import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class SessionTest {
    ArrayList<Talk> talksToAllocateInSession;
    Session session;

    @Before
    public void initialize() {
        talksToAllocateInSession = new ArrayList<Talk>();
        session = new Session(talksToAllocateInSession, "morning");
    }

    @Test
    public void checkSessionIsMorning() {
        Assert.assertEquals(180, session.durationOfSessionToAllocateInMinutes);
    }

    @Test
    public void checkSessionNotAfterNoon() {
        Assert.assertNotSame(300, session.durationOfSessionToAllocateInMinutes);
    }

    @Test
    public void checkSessionContainsEvents() {
        Talk talk1 = new Talk("WooShoo ninja class information 30min");
        session.addTalkToEventList(talk1);
        ArrayList<Talk> talkList = new ArrayList<Talk>();
        talkList.add(talk1);
        Assert.assertSame(talkList.get(0), session.events.get(0));
    }

    @Test
    public void checkSessionRecognisesFull() {
        Talk talk1 = new Talk("WooShoo ninja class information 30min");
        Talk talk2 = new Talk("Ancient Crane fighting class information 60min");
        Talk talk3 = new Talk("Kung-Fu Panda movie analysis 40min");
        Talk talk4 = new Talk("The ABC's of BJJ 30min");
        Talk talk5 = new Talk("Channeling your inner Karate Kid 20min");
        session.addTalkToEventList(talk1);
        session.addTalkToEventList(talk2);
        session.addTalkToEventList(talk3);
        session.addTalkToEventList(talk4);
        session.addTalkToEventList(talk5);
        ArrayList<Talk> talkList = new ArrayList<Talk>();
        talkList.add(talk1);
        talkList.add(talk2);
        talkList.add(talk3);
        talkList.add(talk4);
        talkList.add(talk5);
        Assert.assertSame(true, session.checkIfSessionIsFull());
    }

    @Test
    public void checkTheListOfTalksCanBeUpdated(){
        Talk talk1 = new Talk("WooShoo ninja class information 30min");
        Talk talk2 = new Talk("Ancient Crane fighting class information 60min");
        Talk talk3 = new Talk("Kung-Fu Panda movie analysis 50min");
        session.addTalkToEventList(talk1);
        session.addTalkToEventList(talk2);
        session.addTalkToEventList(talk3);
        ArrayList<Talk> newTalks = new ArrayList<Talk>();
        Talk talk4 = new Talk("The ABC's of BJJ 30min");
        Talk talk5 = new Talk("Channeling your inner Karate Kid 30min");
        newTalks.add(talk4);
        newTalks.add(talk5);
        session.updateTalkList(newTalks);
        Assert.assertSame(2, session.getEventList().size());

    }

    @Test
    public void testSessionHasCapacity(){
        Talk talk1 = new Talk("WooShoo ninja class information 30min");
        Assert.assertTrue(session.checkIfSessionHasCapacity(talk1));
    }
}


