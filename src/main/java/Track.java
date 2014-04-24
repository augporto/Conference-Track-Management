import java.sql.Time;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Track {
    ArrayList<String> componentsOfTheTrack;
    Time time = new Time(9,0,0);
    String period = "AM";


    public Track(ArrayList<Talk> talks){
        ArrayList<Talk> TalksToBeAllocatedASession = talks;
        assembleTrack(TalksToBeAllocatedASession);
    }

    public void assembleTrack(ArrayList<Talk> talksToAllocate){
        componentsOfTheTrack = new ArrayList<String>();

        Session morningSession = new Session(talksToAllocate);
        morningSession.setAsMorning();

        addSessionToTrack(morningSession);

        componentsOfTheTrack.add("12:00PM Lunch");

        Session afternoonSession = new Session(talksToAllocate);
        afternoonSession.setAsAfternoon();

        addSessionToTrack(afternoonSession);

        componentsOfTheTrack.add("PM Networking Event");
    }

    public void addSessionToTrack(Session session){
        ArrayList<Talk> eventsInSession = session.getEventList();
        for (Talk talk :eventsInSession){
            String timeToAdd = (time.toString().substring(0,5) + period);
            String finalEvent = timeToAdd + " " + talk.toString();
            componentsOfTheTrack.add(finalEvent);
            updateTime(talk);
        }
    }

    public void concatenateTimeToTalkInput(){
        System.out.println(time.toString().substring(0,5));
        time.setHours(16);
        System.out.println(time.toString().substring(0,5));
    }

    public void updateTime(Talk talkJustAdded){
        int talkTime = talkJustAdded.durationInMinutes;
        Clock clock = new Clock();
        time = new Time(time.getHours()+(talkTime/60),00,00);
        if(time.getHours()<=12){
            period = "AM";
        } else{
            period = "PM";
        }
    }

    public void printTrackList(){
        for(String tracks: componentsOfTheTrack){
            System.out.println(tracks);
        }
    }
}
