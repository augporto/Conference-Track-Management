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
    boolean isFull;

    public Session(ArrayList<Talk> talksToAllocateInSession, String sessionTime) {
        events = talksToAllocateInSession;
        isFull = false;
        setSessionDuration(sessionTime);
    }

    public void setSessionDuration(String time) {
        if (time.equals("morning")) {
            durationOfSessionToAllocateInMinutes = 180;
        } else {
            durationOfSessionToAllocateInMinutes = 240;
        }
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

    public void updateTalkList(ArrayList<Talk> updatedTalks) {
        events = updatedTalks;
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
