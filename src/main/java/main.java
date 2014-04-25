import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class main {
    public static void main(String[] args) {
        String userInputFile = "/Users/user/Desktop/GitProjects/Conference-Track-Management/src/main/resources/input.txt";
        ArrayList<Talk> fileContents = readTheFile(userInputFile);
        constructTheConference(fileContents);
    }

    public static ArrayList<Talk> readTheFile(String file) {
        ProposalFileReader proposalFileReader = new ProposalFileReader(file);
        return proposalFileReader.getTalkData();
    }

    public static void constructTheConference(ArrayList<Talk> fileContents) {
        Conference conference = new Conference();
        conference.addTwoTracks(fileContents);
        printConferenceSchedule(conference);
    }

    public static void printConferenceSchedule(Conference conference){
        conference.printTwoTracks();
    }
}
