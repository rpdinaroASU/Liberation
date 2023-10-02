package SecureInformation;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class UserManagement {
    private final LoginSystem loginSystem;
    public UserManagement(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
    }

    public void createWorkerAccount(String email, String workplaceID, String sessionKey, String userType) {

    }
    public void addUser(String email, String sessionID, String userType) {
        Database database = null;
        if(userType.equals("Staff")) {
            database = new StaffCredentialDatabase();
        }
        else if(userType.equals("Organizer")) {
            database = new OrganizerCredentialDatabase();
        }
        else if(userType.equals("Worker")) {
            database = new WorkerCredentialDatabase();
        }
        else {
            throw new IllegalArgumentException("not Staff, Organizer, or Worker");
        }

        boolean doesUserExist = database.doesUserExist(email);
        if(doesUserExist) {
            loginSystem.notifyMessage(new Message("AccountAlreadyExists"));
        }
        else {
            createNewUser(email, sessionID);
        }
    }

    private void createNewUser(String email, String sessionID) {
        String tempPass = generateTempPassword();
    }

    private String generateTempPassword() {
        SecureRandom random = new SecureRandom();
        IntStream stream = random.ints(66,123);
        char[] tempPass = new char[8];
        for(int x = 0; x < 8; x++) {
            tempPass[x] = (char) (random.nextInt(57)+66);
        }
        return Arrays.toString(tempPass);
    }

    private String generateUserTempKey(String sessionID, String userTempPass) {
        return "";
    }

    private String decryptSynchronizedKey(String sessionKey) {
        return "";
    }

    private String encryptNewSynchronizedKey(String userTempPass) {
        return "";
    }

    private String hashSaltPassword(String userTempPass) {
        return "";
    }

    private String deriveKey(String userTempKey, String userTempPass) {
        return "";
    }


}
