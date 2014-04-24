import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class main {
    private static String userInput;
    public static void main(String[] args) {
        userInput = "/Users/user/Desktop/GitProjects/Conference-Track-Management/src/main/resources/input.txt";
        ArrayList<Talk> fileContents = readTheFile();
        makeTheConference(fileContents);
    }

    public static ArrayList<Talk> readTheFile(){
        ProposalFileReader proposalFileReader = new ProposalFileReader(userInput);
        return proposalFileReader.getData();
    }

    public static void makeTheConference(ArrayList<Talk> fileContents){
        Conference conference = new Conference(fileContents);
    }
}
