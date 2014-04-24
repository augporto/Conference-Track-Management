import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Track {
    protected ArrayList<String> eventsInTrack;
    private ArrayList<Talk> talksToAllocateToTrack;
    private Time time = new Time(9, 0, "AM");

    public Track(ArrayList<Talk> masterOfTalksToBeSorted) {
        eventsInTrack = new ArrayList<String>();
        assembleTrack(masterOfTalksToBeSorted);
    }

    public void assembleTrack(ArrayList<Talk> talks) {
        talksToAllocateToTrack = talks;
        orderTalks(talksToAllocateToTrack);
        assembleTrack();
    }

    public void assembleTrack() {
        allocateSession(talksToAllocateToTrack, "morning");
        allocateLunch();
        allocateSession(talksToAllocateToTrack, "afternoon");
        allocateNetworkingEvent();
    }

    public void allocateSession(ArrayList<Talk> talksToIncludeInSession, String sessionSegment) {
        Session session = new Session(talksToIncludeInSession, sessionSegment);
        talksToIncludeInSession = sortTalksIntoSessionFormat(session, talksToIncludeInSession);
        session.updateTalkList(talksToIncludeInSession);
        addSessionToTrack(session);
        talksToAllocateToTrack = deleteSortedTalksFromMaster(talksToAllocateToTrack, talksToIncludeInSession);
    }

    public void addSessionToTrack(Session session) {
        ArrayList<Talk> eventsInSession = session.getEventList();
        for (Talk talk : eventsInSession) {
            String finalEvent = time.toString() + " " + talk.toString();
            eventsInTrack.add(finalEvent);
            updateTime(talk);
        }
    }

    public ArrayList<Talk> sortTalksIntoSessionFormat(Session sessionToSortFor, ArrayList<Talk> talksToBeSorted) {
        ArrayList<Talk> talksAllocatedForSession = new ArrayList<Talk>();
        ArrayList<Talk> talksToBeFormatted = talksToBeSorted;
        int minutesToSortInto = sessionToSortFor.durationOfSessionToAllocateInMinutes;
        while (minutesToSortInto != 0) {
            for(Talk talk: talksToBeFormatted){
                if (minutesToSortInto >= talk.durationInMinutes) {
                    minutesToSortInto = minutesToSortInto - talk.durationInMinutes;
                    talksAllocatedForSession.add(talk);
                }
            }
            if (breakLoopConditions(sessionToSortFor, talksToBeSorted, minutesToSortInto)) {
                break;
            }
        }
        return talksAllocatedForSession;
    }

    public boolean breakLoopConditions(Session sessionToSort, ArrayList<Talk> talksToSort, int minutesToSortInto){
        if(talksToSort.size() == 0){
            return true;
        } else if(sessionToSort.durationOfSessionToAllocateInMinutes == 240 && minutesToSortInto <= 60){
            return true;
        }
        return false;
    }

    public ArrayList<Talk> deleteSortedTalksFromMaster(ArrayList<Talk> master, ArrayList<Talk> toBeDeleted) {
        for (int x = 0; x < master.size(); x++) {
            for (Talk toDeleted : toBeDeleted) {
                if (master.get(x).equals(toDeleted)) {
                    master.remove(x);
                }
            }
        }
        return master;
    }

    public void orderTalks(ArrayList<Talk> talksToBeOrdered){
        int maxTalkDuration = 60;
        ArrayList<Talk> orderedTalks = new ArrayList<Talk>();
        while(talksToBeOrdered.size() !=0){
            for(int x = maxTalkDuration; x >0; x--){
                for(int y = 0; y<talksToBeOrdered.size();y++){
                    if(talksToBeOrdered.get(y).durationInMinutes == x){
                        orderedTalks.add(talksToBeOrdered.get(y));
                        talksToBeOrdered.remove(y);
                        y--;
                    }
                }
            }
        }
        talksToAllocateToTrack = orderedTalks;
    }

    public String updateTime(Talk talkJustAdded) {
        int talkTime = talkJustAdded.durationInMinutes;
        time.adjust(talkTime);
        return time.toString();
    }

    public void allocateLunch() {
        eventsInTrack.add("12:00PM Lunch");
        time.adjust(60);
    }

    public void allocateNetworkingEvent() {
        checkNetworkEventTimeIsInBoundary();
        eventsInTrack.add(time.toString() + " Networking Event");
    }

    public void checkNetworkEventTimeIsInBoundary() {
        if (time.hour < 4) {
            time.adjust((4 - time.hour) * 60);
        }
    }

    public ArrayList<Talk> getUnallocatedTalks(){
        return talksToAllocateToTrack;
    }

    public void printTrackList() {
        for (String tracks : eventsInTrack) {
            System.out.println(tracks);
        }
        System.out.println();

    }
}
