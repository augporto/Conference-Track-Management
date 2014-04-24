import org.junit.Assert;
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
    public SessionTest(){

    }

    @Test
    public void checkSessionIsMorning(){
        ArrayList<Talk> talksToAllocateInSession = new ArrayList<Talk>();
        Session session = new Session(talksToAllocateInSession, "morning");
        Assert.assertEquals(180,session.durationOfSessionToAllocateInMinutes);
    }

    @Test
    public void checkSessionNotAfterNoon(){
        ArrayList<Talk> talksToAllocateInSession = new ArrayList<Talk>();
        Session session = new Session(talksToAllocateInSession, "morning");
        Assert.assertNotSame(300, session.durationOfSessionToAllocateInMinutes);
    }

    @Test
    public void checkSessionContainsEvents(){
        ArrayList<Talk> talksToAllocateInSession = new ArrayList<Talk>();
        Session session = new Session(talksToAllocateInSession, "morning");
        Talk talk1 = new Talk("WooShoo ninja class 30min");
        Talk talk2 = new Talk("ancient crane fighting class 60min");
        Talk talk3 = new Talk("kung fu panda movie analysis 50min");
        Talk talk4 = new Talk("life outside of the matrix 50min");
        Talk talk5 = new Talk("how-to-do-the-slow-motion-bullet-dodge 60min");
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
        Assert.assertSame(talkList, session.events);
    }

    //this test is broken, should return an error after the fourth event is added
    @Test
    public void checkSessionRecognisesFull(){
//        ArrayList<Talk> talksToAllocateInSession = new ArrayList<Talk>();
//        Session session = new Session(talksToAllocateInSession);
//        session.setAsMorning();
//        Talk talk1 = new Talk("WooShoo ninja class 30min");
//        Talk talk2 = new Talk("ancient crane fighting class 60min");
//        Talk talk3 = new Talk("kung fu panda movie analysis 50min");
//        Talk talk4 = new Talk("life outside of the matrix 40min");
//        Talk talk5 = new Talk("how-to-do-the-slow-motion-bullet-dodge 60min");
//        session.addTalkToEventList(talk1);
//        session.addTalkToEventList(talk2);
//        session.addTalkToEventList(talk3);
//        session.addTalkToEventList(talk4);
//        session.addTalkToEventList(talk5);
//        ArrayList<Talk> talkList = new ArrayList<Talk>();
//        talkList.add(talk1);
//        talkList.add(talk2);
//        talkList.add(talk3);
//        talkList.add(talk4);
//        talkList.add(talk5);
//        Assert.assertSame(true, session.checkIfSessionIsFull());
    }
}


