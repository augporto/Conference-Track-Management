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
    String name;
    Session morningSession;
    String lunch;
    Session afternoonSession;
    String networkingEvent;

    ArrayList<String> componentsOfTheTrack;

    Time time = new Time(9,0,0);
    String period = "AM";


    public Track(){
        assembleTrack();
        printTrackList();
    }

    public void setName(String name){
       name = this.name;
    }

    public void assembleTrack(){
        componentsOfTheTrack = new ArrayList<String>();
        morningSession = new Session();
        morningSession.setAsMorning();
        formatSessionTracksByAddingTime(morningSession);
        lunch = "12:00PM Lunch";
        componentsOfTheTrack.add(lunch);
        afternoonSession = new Session();
        afternoonSession.setAsAfternoon();
        formatSessionTracksByAddingTime(afternoonSession);
        formatSessionTracksByAddingTime(afternoonSession);
        networkingEvent = "PM Networking Event";
        componentsOfTheTrack.add(networkingEvent);
    }

    public void formatSessionTracksByAddingTime(Session session){
        ArrayList<Talk> eventsInSession = session.getEventList();
        for (Talk talks :eventsInSession){
            String timeToAdd = (time.toString().substring(0,5) + period);
            String finalEvent = timeToAdd + " " + talks.title + " " + talks.durationInMinutes;
            componentsOfTheTrack.add(finalEvent);
        }
    }

    public void concatenateTimeToTalkInput(){
        System.out.println(time.toString().substring(0,5));
        time.setHours(16);
        System.out.println(time.toString().substring(0,5));
    }

    public void updateTime(){
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
