package Liberation.SecureInformation;

import java.security.SecureRandom;
import java.util.Arrays;

public class StaffLoginSystem implements LoginSystem {
    private final UserManagement userManagement;
    private final WorkplaceManagment workplaceManagment;
    private final UnionCardManagment unionCardManagment;
    private final byte[] sessionID;

    StaffGUI staffGUI;

    public StaffLoginSystem(StaffGUI gui) {
        workplaceManagment = new WorkplaceManagment();
        unionCardManagment = new UnionCardManagment();
        sessionID = createSessionID();
        userManagement = new UserManagement(this,sessionID);
        staffGUI = gui;
    }

    private byte[] createSessionID() {
        byte[] sessionID = new byte[16];
        SecureRandom random = new SecureRandom();
        for(int x = 0; x < sessionID.length; x++) {
            random.nextBytes(sessionID);
        }
        return sessionID;
    }

    @Override
    public void notifyMessage(Message message) {

    }

    public byte[] getSessionID() {
        return sessionID;
    }
}
