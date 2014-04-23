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

    public Conference(String input){
        addTwoTracks();
        printTwoTracks();
    }

    public void addTwoTracks(){
        track1 = new Track();
        track1.name = "Track 1";
        track2 = new Track();
        track2.name = "Track 2";
    }

    public void printTwoTracks(){
        System.out.println(track1.name + ":");
        System.out.println(track1);
        System.out.println();
        System.out.println(track2.name + ":");
        System.out.println(track2);
        System.out.println();


    }
}
