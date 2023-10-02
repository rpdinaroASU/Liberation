package Liberation.SecureInformation;

public class StaffCredentialDatabase implements Database{
    @Override
    public boolean doesUserExist(String email) {
        return true;
    }

    @Override
    public boolean createNewUser(String email, String protectedPass, String protectedKey, String userType) {
        return false;
    }
}
