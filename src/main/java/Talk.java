/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Talk {
    public String title;
    public int durationInMinutes;
    private boolean switchForIfTalkContainsLightningDuration = false;

    public Talk(String input) {
        breakDownTheTalkInput(input);
    }

    private void breakDownTheTalkInput(String talkInput) {
        title = findAndSetTitle(talkInput);
        durationInMinutes = findAndSetTheDuration(talkInput);
    }

    private String findAndSetTitle(String talkContents) {
        for (int x = 0; x < talkContents.length(); x++) {
            try {
                Integer.parseInt(talkContents.substring(x, x + 1));
                return talkContents.substring(0, x - 1);
            } catch (NumberFormatException e) {

            }
        }
        switchForIfTalkContainsLightningDuration = true;
        return talkContents.substring(0, talkContents.length() - 10);
    }

    private int findAndSetTheDuration(String talkContents) {
        if (!switchForIfTalkContainsLightningDuration) {
            durationInMinutes = Integer.parseInt(talkContents.substring(title.length() + 1, title.length() + 3));
        } else {
            durationInMinutes = 5;
        }
        return durationInMinutes;
    }

    public String toString(){
        String talkAsString = (title + " " + durationInMinutes + "mins");
        return talkAsString;
    }
}
