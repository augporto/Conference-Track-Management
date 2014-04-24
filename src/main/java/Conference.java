import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Conference {
    private Track trackOne;
    private Track trackTwo;
    ArrayList<Talk> ConferenceTalksToBeAllocatedASession;

    public Conference(ArrayList<Talk> ProposedTalks) {
        ConferenceTalksToBeAllocatedASession = ProposedTalks;
        addTwoTracks(ConferenceTalksToBeAllocatedASession);
        printTwoTracks();
    }

    public void addTwoTracks(ArrayList<Talk> trackContents) {
        trackOne = new Track(trackContents);
        ArrayList<Talk> unallocatedTrackContents = trackOne.getUnallocatedTalks();
        trackTwo = new Track(unallocatedTrackContents);
    }

    public void printTwoTracks() {
        System.out.println("Track1:");
        trackOne.printTrackList();
        System.out.println("Track2:");
        trackTwo.printTrackList();


    }
}
