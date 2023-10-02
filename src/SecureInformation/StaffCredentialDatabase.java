package SecureInformation;

public class StaffCredentialDatabase  implements Database{
    @Override
    public boolean doesUserExist(String email) {
        return true;
    }
}
