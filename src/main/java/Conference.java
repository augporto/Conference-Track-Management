import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Conference {
    Track track1;
    Track track2;
    ArrayList<Talk> ConferenceTalksToBeAllocatedASession;

    public Conference(ArrayList<Talk> ProposedTalks){
        ConferenceTalksToBeAllocatedASession = ProposedTalks;
        addTwoTracks(ConferenceTalksToBeAllocatedASession);
        printTwoTracks();
    }

    public void addTwoTracks(ArrayList<Talk> trackContents){
        track1 = new Track(trackContents);
        removePreviouslyAllocatedContent();
        track2 = new Track(trackContents);
    }

    public void removePreviouslyAllocatedContent(){

    }

    public void printTwoTracks(){
        System.out.println("Track1:");
        track1.printTrackList();
        System.out.println();
        System.out.println("track2:");
        track2.printTrackList();
        System.out.println();


    }
}
