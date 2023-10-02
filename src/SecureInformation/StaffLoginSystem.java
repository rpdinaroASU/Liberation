package SecureInformation;

public class StaffLoginSystem implements LoginSystem {
    private final UserManagement userManagement;
    private final WorkplaceManagment workplaceManagment;
    private final UnionCardManagment unionCardManagment;
    private final String sessionID;

    StaffGUI staffGUI;

    public StaffLoginSystem(StaffGUI gui) {
        userManagement = new UserManagement(this);
        workplaceManagment = new WorkplaceManagment();
        unionCardManagment = new UnionCardManagment();
        sessionID = createSessionID();
        staffGUI = gui;
    }

    private String createSessionID() {
        return "";
    }

    @Override
    public void notifyMessage(Message message) {

    }

    public String getSessionID() {
        return sessionID;
    }
}
