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
    ArrayList<Talk> talksToBeAssembled;
    Time time = new Time(9, 0, "AM");

    public Track(ArrayList<Talk> talks) {
        ArrayList<Talk> masterOfTalksToBeSorted = talks;
        componentsOfTheTrack = new ArrayList<String>();
        assembleTrack(masterOfTalksToBeSorted);
    }

    public void assembleTrack(ArrayList<Talk> talks) {
        talksToBeAssembled = talks;
        assembleTrack();
    }

    public void assembleTrack() {
        allocateMorningSession(talksToBeAssembled);
        allocateLunch();
        allocateAfternoonSession(talksToBeAssembled);
        allocateNetworkingEvent();
    }

    public void allocateMorningSession(ArrayList<Talk> talksToIncludeInMorningSession) {
        Session morningSession = new Session(talksToIncludeInMorningSession, "morning");
        talksToIncludeInMorningSession = sortTalksIntoSessionFormat(morningSession, talksToIncludeInMorningSession);
        morningSession.updateTalkList(talksToIncludeInMorningSession);
        addSessionToTrack(morningSession);
        talksToBeAssembled = deleteSortedTalksFromMaster(talksToBeAssembled, talksToIncludeInMorningSession);
    }

    public void allocateAfternoonSession(ArrayList<Talk> talksToIncludeInAfternoonSession) {
        Session afternoonSession = new Session(talksToIncludeInAfternoonSession, "afternoon");
        talksToIncludeInAfternoonSession = sortTalksIntoSessionFormat(afternoonSession, talksToIncludeInAfternoonSession);
        afternoonSession.updateTalkList(talksToIncludeInAfternoonSession);
        addSessionToTrack(afternoonSession);
        talksToBeAssembled = deleteSortedTalksFromMaster(talksToBeAssembled, talksToIncludeInAfternoonSession);
    }

    public void addSessionToTrack(Session session) {
        ArrayList<Talk> eventsInSession = session.getEventList();
        for (Talk talk : eventsInSession) {
            String finalEvent = time.toString() + " " + talk.toString();
            componentsOfTheTrack.add(finalEvent);
            updateTime(talk);
        }
    }

    public ArrayList<Talk> sortTalksIntoSessionFormat(Session sessionToSortFor, ArrayList<Talk> talksToBeSorted) {
        ArrayList<Talk> talksAllocatedForSession = new ArrayList<Talk>();
        ArrayList<Talk> TalksToBeFormatted = talksToBeSorted;
        int minutesToSortInto = sessionToSortFor.durationOfSessionToAllocateInMinutes;
        while (minutesToSortInto != 0) {
            for (int x = 0; x < TalksToBeFormatted.size(); x++) {
                if (minutesToSortInto >= TalksToBeFormatted.get(x).durationInMinutes) {
                    minutesToSortInto = minutesToSortInto - TalksToBeFormatted.get(x).durationInMinutes;
                    talksAllocatedForSession.add(TalksToBeFormatted.get(x));
                    TalksToBeFormatted.remove(x);
                }
            }
            if (talksToBeSorted.size() == 0 || (sessionToSortFor.durationOfSessionToAllocateInMinutes == 240 && minutesToSortInto <= 60)) {
                break;
            }
        }
        return talksAllocatedForSession;
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

    public String updateTime(Talk talkJustAdded) {
        int talkTime = talkJustAdded.durationInMinutes;
        time.adjust(talkTime);
        return time.toString();
    }

    public void allocateLunch() {
        componentsOfTheTrack.add("12:00PM Lunch");
        time.adjust(60);
    }

    public void allocateNetworkingEvent() {
        if(time.hour <4){
            time.adjust((4-time.hour)*60);
        }
        componentsOfTheTrack.add(time.toString() + " Networking Event");
    }

    public void printTrackList() {
        for (String tracks : componentsOfTheTrack) {
            System.out.println(tracks);
        }
        System.out.println();

    }
}
