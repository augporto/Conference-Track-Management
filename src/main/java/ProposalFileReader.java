import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProposalFileReader {
    ArrayList<String> talksToBeFormatted;
    ArrayList<Talk> formattedTalks;

    public ProposalFileReader(String file) {
        talksToBeFormatted = new ArrayList<String>();
        readProposal(file);
        formatAllTalksInProposal(talksToBeFormatted);
    }

    public void readProposal(String input) {
        talksToBeFormatted = new ArrayList<String>();
        try {
            String workingDirectory = System.getProperty("user.dir");
            String file = input.substring(59);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(workingDirectory + file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                talksToBeFormatted.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: The file was not found.");
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("ERROR: ??");   what is this error for??
        }
    }

    public ArrayList<Talk> formatAllTalksInProposal(ArrayList<String> talksToBeFormatted){
        formattedTalks = new ArrayList<Talk>();
        for(String theTalkToBeFormatted :talksToBeFormatted){
            Talk formattedTalk = new Talk(theTalkToBeFormatted);
            formattedTalks.add(formattedTalk);
        }
        return formattedTalks;
    }

    public ArrayList<Talk> getData(){
        return formattedTalks;
    }
}

