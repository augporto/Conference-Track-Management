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
    private int hours = 9;
    private int minutes = 0;
    private String period = "AM";

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
            String finalEvent = timeToString() + " " + talk.toString();
            eventsInTrack.add(finalEvent);
            updateTime(talk);
        }
    }

    public ArrayList<Talk> sortTalksIntoSessionFormat(Session sessionToSortFor, ArrayList<Talk> talksToBeSorted) {
        ArrayList<Talk> talksAllocatedForSession = new ArrayList<Talk>();
        int minutesToSortInto = sessionToSortFor.durationOfSessionToAllocateInMinutes;
        while (minutesToSortInto != 0) {
            for (Talk talk : talksToBeSorted) {
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

    public boolean breakLoopConditions(Session sessionToSort, ArrayList<Talk> talksToSort, int minutesToSortInto) {
        if (talksToSort.size() == 0) {
            return true;
        } else if (sessionToSort.durationOfSessionToAllocateInMinutes == 240 && minutesToSortInto <= 60) {
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

    public void orderTalks(ArrayList<Talk> talksToBeOrdered) {
        int maxTalkDuration = 60;
        ArrayList<Talk> orderedTalks = new ArrayList<Talk>();
        while (talksToBeOrdered.size() != 0) {
            for (int x = maxTalkDuration; x > 0; x--) {
                for (int y = 0; y < talksToBeOrdered.size(); y++) {
                    if (talksToBeOrdered.get(y).durationInMinutes == x) {
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
        int accumulatedTime = getAccumulatedTime() + talkJustAdded.durationInMinutes;
        if (accumulatedTime >= (12 * 60)) {
            period = "PM";
            accumulatedTime = accumulatedTime - (12 * 60);
        } else {
            period = "AM";
        }
        hours = accumulatedTime / 60;
        minutes = accumulatedTime % 60;

        return timeToString();
    }

    public String timeToString() {
        String hour = "0";
        String minute = "0";
        if (hours < 10) {
            hour += hours;
        } else {
            hour = Integer.toString(hours);
        }
        if (minutes < 10) {
            minute += minutes;
        } else {
            minute = Integer.toString(minutes);
        }
        return hour + ":" + minute + period;
    }

    public int getAccumulatedTime() {
        int accumulatedTime = 0;
        if (period.equals("PM")) {
            accumulatedTime += 12 * 60;
        }
        accumulatedTime += hours * 60;
        accumulatedTime += minutes;
        return accumulatedTime;
    }

    public void allocateLunch() {
        eventsInTrack.add("12:00PM Lunch");
        hours += 1;
    }

    public void allocateNetworkingEvent() {
        checkNetworkEventTimeIsInBoundary();
        eventsInTrack.add(timeToString() + " Networking Event");
    }

    public void checkNetworkEventTimeIsInBoundary() {
        if (hours < 4 && period.equals("PM")) {
            hours = 4;
        }
    }

    public ArrayList<Talk> getUnallocatedTalks() {
        return talksToAllocateToTrack;
    }

    public void printTrackList() {
        for (String tracks : eventsInTrack) {
            System.out.println(tracks);
        }
        System.out.println();

    }
}
