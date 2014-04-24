import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Session {
    public ArrayList<Talk> events;
    public int durationOfSessionToAllocateInMinutes;
    public boolean isFull;

    public Session(ArrayList<Talk> talksToAllocateInSession) {
        events = talksToAllocateInSession;
        isFull = false;
    }

    public void addTalkToEventList(Talk unlistedTalk) {
        if (checkIfSessionHasCapacity(unlistedTalk)) {
            events.add(unlistedTalk);
            durationOfSessionToAllocateInMinutes -= unlistedTalk.durationInMinutes;
        } else if (checkIfSessionIsFull()) {
            System.out.println("Session is full.");
        }
    }

    public boolean checkIfSessionHasCapacity(Talk unlistedTalk) {
        if (durationOfSessionToAllocateInMinutes < unlistedTalk.durationInMinutes) {
            return false;
        } else {
            return true;
        }
    }

    public void setAsMorning() {
        durationOfSessionToAllocateInMinutes = 180;
    }

    public void setAsAfternoon() {
        durationOfSessionToAllocateInMinutes = 300;
    }

    public String checkSessionType() {
        String type;
        if (durationOfSessionToAllocateInMinutes == 180) {
            return type = "Morning Session";
        } else {
            return type = "Afternoon Session";
        }
    }

    public boolean sessionFull() {
        System.out.println("ERROR: Session is full");
        return true;
    }

    public boolean checkIfSessionIsFull() {
        if (durationOfSessionToAllocateInMinutes == 0) {
            isFull = true;
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<Talk> getEventList() {
        return events;
    }

}
