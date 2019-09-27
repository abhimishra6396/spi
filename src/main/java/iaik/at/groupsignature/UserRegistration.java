package iaik.at.groupsignature;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {

    private List<UserMessage> userRecords;

    private static UserRegistration userregd = null;

    UserRegistration(){
        userRecords = new ArrayList<UserMessage>();
    }
    public static UserRegistration getInstance() {
        if(userregd == null) {
            userregd = new UserRegistration();
            return userregd;
        }
        else {
            return userregd;
        }
    }
    public void add(UserMessage std) {
        userRecords.add(std);
    }
    /*public String upDateUser(UserMessage std) {
        for(int i=0; i<userRecords.size(); i++)
        {
            UserMessage usern = userRecords.get(i);
            userRecords.set(i, std);//update the new record
                return "Update successful";
            }
        }
        return "Update un-successful";
    }
    public String deleteUser(String registrationNumber) {
        for(int i=0; i<userRecords.size(); i++)
        {
            UserMessage stdn = userRecords.get(i);
            if(stdn.getRegistrationNumber().equals(registrationNumber)){
                userRecords.remove(i);//update the new record
                return "Delete successful";
            }
        }
        return "Delete un-successful";
    }*/
    public List<UserMessage> getUserRecords() {
        return userRecords;
    }
}
