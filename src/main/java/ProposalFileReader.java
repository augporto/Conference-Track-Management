import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProposalFileReader {
    Scanner sc = new Scanner(System.in);
    public ProposalFileReader(String file){
        readProposal(file);
    }

    public List<String> readProposal(String input){
        String file = input;
        List<String> unformattedTalks=new ArrayList<String>();
        try {
            String workingDirectory = System.getProperty("user.dir");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(workingDirectory+"/src/main/resources/input.txt"));
            String line;
            while ((line = sc.nextLine())!= null){
                unformattedTalks.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return  unformattedTalks;
    }
}

