package Liberation.SecureInformation;

public class OrganizerCredentialDatabase implements Database{
    @Override
    public boolean doesUserExist(String email) {
        return true;
    }
    public boolean createNewUser(String email, String protectedPass, String protectedKey,
                          String userType) {
        return true;
    }
}
