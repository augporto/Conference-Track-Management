import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 24/04/2014
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProposalFileReaderTest {
    ProposalFileReader proposalFileReader;

    @Before
    public void initialize(){
        String userInputFile = "/Users/user/Desktop/GitProjects/Conference-Track-Management/src/main/resources/input.txt";
        proposalFileReader = new ProposalFileReader(userInputFile);
    }

    @Test
    public void fileIsReadAndAddedToListWithoutErrors(){
        ArrayList<Talk> testData= proposalFileReader.getTalkData();

        Assert.assertSame(19, testData.size());
    }

}
