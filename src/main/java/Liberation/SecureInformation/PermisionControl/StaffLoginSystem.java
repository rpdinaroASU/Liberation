package Liberation.SecureInformation.PermisionControl;

import Liberation.SecureInformation.NetworkCommunication.UnionCardManagment;
import Liberation.SecureInformation.NetworkCommunication.UserManagement;
import Liberation.SecureInformation.NetworkCommunication.WorkplaceManagment;
import Liberation.SecureInformation.UserGUI.StaffGUI;

import java.security.SecureRandom;

public class StaffLoginSystem implements LoginSystem {
    private UserManagement userManagement = null;
    private final WorkplaceManagment workplaceManagment;
    private final UnionCardManagment unionCardManagment;
    private final byte[] sessionID;
    private final SecureRandom random;
    private final String username;


    StaffGUI staffGUI;

    public StaffLoginSystem(StaffGUI staffGUI, String username, char[] password) {
        workplaceManagment = new WorkplaceManagment();
        unionCardManagment = new UnionCardManagment();
        random = new SecureRandom();
        sessionID = createSessionID();
        userManagement = new UserManagement(this);
        this.username = username;

        this.staffGUI = staffGUI;
    }

    private char[] hashSaltPDHS(char[] password) {
        //TODO
        return null;
    }

    private char[] hashSalt(char[] password) {
        //TODO
        return null;
    }

    private byte[] createSessionID() {
        byte[] sessionID = new byte[16];
        random.nextBytes(sessionID);
        return sessionID;
    }

    @Override
    public void notifyMessage(Message message) {

    }

    public byte[] getSessionID() {
        return sessionID;
    }
}
