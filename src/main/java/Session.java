import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 23/04/2014
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Session {
    public int totalDurationOfSessionInMinutes;
    public int durationFilledUpByTalks;
    public ArrayList<Talk> events;

    public Session(){
        events = new ArrayList<Talk>();
        durationFilledUpByTalks = 0;
    }

    public void setAsMorning(){
        totalDurationOfSessionInMinutes = 180;
    }

    public void setAsAfternoon(){
        int amountOtTimePost4PMTheNetworkingEventStarts = 0;
        totalDurationOfSessionInMinutes = 240-amountOtTimePost4PMTheNetworkingEventStarts;
    }

    public String checkSessionType(){
        String type="";
        if(totalDurationOfSessionInMinutes == 180){
            return type = "Morning Session";
        } else{
            return type = "Afternoon Session";
        }
    }

    public void addTalkToEventList(Talk unlistedTalk){
        if(checkIfSessionHasCapacity(unlistedTalk)){
            events.add(unlistedTalk);
            durationFilledUpByTalks += unlistedTalk.durationInMinutes;
        } else if (checkIfSessionIsFull()){
            System.out.println("Session is full.");
        }
    }

    public boolean checkIfSessionHasCapacity(Talk unlistedTalk){
        if((totalDurationOfSessionInMinutes - durationFilledUpByTalks)< unlistedTalk.durationInMinutes){
            return false;
        } else{
            return true;
        }
    }

    public boolean sessionFull(){
        System.out.println("ERROR: Session is full");
        return true;
    }

    public boolean checkIfSessionIsFull(){
        if(totalDurationOfSessionInMinutes == durationFilledUpByTalks){
            return true;
        }else{
            return false;
        }
    }

}
