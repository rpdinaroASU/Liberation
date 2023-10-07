package Liberation.SecureInformation.NetworkCommunication;

import Liberation.SecureInformation.PermisionControl.LoginSystem;
import Liberation.UserDatabase.Database;
import Liberation.UserDatabase.OrganizerCredentialDatabase;
import Liberation.UserDatabase.StaffCredentialDatabase;
import Liberation.UserDatabase.WorkerCredentialDatabase;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class UserManagement {
    private final LoginSystem loginSystem;
    private Database database;
    private final String host = "localhost";
    private final int port = 300;

    public UserManagement(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
    }

    public void createWorkerAccount(String email, String workplaceID, String sessionKey, String userType) {

    }
    public void addUser(String email, byte[] sessionID, String userType) {
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

    private void createNewUser(String email, byte[] sessionID) {
        String tempPass = generateTempPassword();
        //generateUserTempKey();
    }

    private String generateTempPassword() {
        SecureRandom random = new SecureRandom();
        IntStream stream = random.ints(66,123);
        char[] tempPass = new char[8];
        for(int x = 0; x < 8; x++) {
            tempPass[x] = (char) (random.nextInt(57)+66);
        }
        return String.copyValueOf(tempPass);
    }

    /**
     * verifies user is a staff member,
     * if credentials are verified returns char[] of stored enc
     * @return
     */
    private boolean verifyStaff() {
        //estabish secured connection to StaffCredentialDatabase
        //check credentials to database
        // TODO
        return true;
    }

    private boolean verifyOrganizer() {
        //estabish secured connection to OrganizerCredentialDatabase
        //check credentials to database
        // TODO
        return true;
    }

    private void establishSecureConnection() {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = null;
        try {
            sslSocket = (SSLSocket) sslSocketFactory.createSocket(host,port);
            InputStream in = sslSocket.getInputStream();
            OutputStream out = sslSocket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
